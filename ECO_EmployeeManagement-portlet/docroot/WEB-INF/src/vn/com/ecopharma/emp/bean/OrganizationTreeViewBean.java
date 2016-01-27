package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.node.OrgNodeItem;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean(name = "organizationTreeViewBean")
@ViewScoped
public class OrganizationTreeViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2928998067622705654L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(OrganizationTreeViewBean.class);

	private TreeNode root;

	private TreeNode[] selectedNodes;

	@PostConstruct
	public void init() {
		root = createDocuments();
	}

	public TreeNode createDocuments() {
		TreeNode treeRoot = new DefaultTreeNode(OrgNodeItem.ROOT, new OrgNodeItem(), null);

		final List<Devision> allDevisions = DevisionLocalServiceUtil.findAll();
		final List<TreeNode> devisionTreeNodes = new ArrayList<>();
		for (Devision devision : allDevisions) {
			TreeNode devisionNode = new DefaultTreeNode("Devision",
					new OrgNodeItem(devision), treeRoot);
			devisionTreeNodes.add(devisionNode);
		}

		final List<TreeNode> deptTreeNodes = new ArrayList<>();
		for (TreeNode devisionNode : devisionTreeNodes) {
			OrgNodeItem devisionItem = (OrgNodeItem) devisionNode.getData();
			final List<Department> departmentsByDevision = DepartmentLocalServiceUtil
					.findByDevision(devisionItem.getId());

			if (!departmentsByDevision.isEmpty()) {
				for (Department department : departmentsByDevision) {
					OrgNodeItem departmentNodeItem = new OrgNodeItem(department);
					TreeNode deptNode = new DefaultTreeNode("Department",
							departmentNodeItem, devisionNode);
					deptTreeNodes.add(deptNode);

					// devisionItem.getChildrenModels().add(departmentNodeItem);
				}
			}
			// else {
			// deptTreeNodes.add(new DefaultTreeNode(
			// OrgNodeItem.DEPARTMENT_TYPE, new OrgNodeItem(
			// OrgNodeItem.DEPARTMENT_TYPE), devisionNode));
			// }
		}

		final List<TreeNode> unitTreeNodes = new ArrayList<>();
		for (TreeNode deptNode : deptTreeNodes) {
			OrgNodeItem deptItem = (OrgNodeItem) deptNode.getData();
			final List<Unit> unitsByDept = UnitLocalServiceUtil
					.findByDepartment(deptItem.getId());

			for (Unit unit : unitsByDept) {
				TreeNode unitNode = new DefaultTreeNode("Unit",
						new OrgNodeItem(unit), deptNode);
				unitTreeNodes.add(unitNode);
			}
		}

		final List<TreeNode> unitGroupTreeNodes = new ArrayList<>();
		for (TreeNode unitNode : unitTreeNodes) {
			OrgNodeItem unitItem = (OrgNodeItem) unitNode.getData();
			final List<UnitGroup> unitGroupsByUnit = UnitGroupLocalServiceUtil
					.findByUnit(unitItem.getId());

			for (UnitGroup unitGroup : unitGroupsByUnit) {
				TreeNode unitGroupNode = new DefaultTreeNode("UnitGroup",
						new OrgNodeItem(unitGroup), unitNode);
				unitGroupTreeNodes.add(unitGroupNode);
			}
		}

		final List<TreeNode> titlesTreeNodesByDept = new ArrayList<>();
		for (TreeNode deptNode : deptTreeNodes) {
			OrgNodeItem deptItem = (OrgNodeItem) deptNode.getData();
			final List<Titles> titlesListByDept = TitlesLocalServiceUtil
					.findByDepartmentOnly(deptItem.getId());
			for (Titles titles : titlesListByDept) {
				TreeNode titlesNode = new DefaultTreeNode("Titles",
						new OrgNodeItem(titles), deptNode);
				titlesTreeNodesByDept.add(titlesNode);
			}
		}

		final List<TreeNode> titlesTreeNodesByUnit = new ArrayList<>();
		for (TreeNode unitNode : unitTreeNodes) {
			OrgNodeItem unitItem = (OrgNodeItem) unitNode.getData();
			final List<Titles> titlesListByUnit = TitlesLocalServiceUtil
					.findByUnitOnly(unitItem.getId());
			for (Titles titles : titlesListByUnit) {
				TreeNode titlesNode = new DefaultTreeNode("Titles",
						new OrgNodeItem(titles), unitNode);
				titlesTreeNodesByUnit.add(titlesNode);
			}
		}

		final List<TreeNode> titlesTreeNodesByUnitGroup = new ArrayList<>();
		for (TreeNode unitGroupNode : unitGroupTreeNodes) {
			OrgNodeItem unitGroupItem = (OrgNodeItem) unitGroupNode.getData();
			final List<Titles> titlesListByUnitGroup = TitlesLocalServiceUtil
					.findByUnitGroupOnly(unitGroupItem.getId());
			for (Titles titles : titlesListByUnitGroup) {
				TreeNode titlesNode = new DefaultTreeNode("Titles",
						new OrgNodeItem(titles), unitGroupNode);
				titlesTreeNodesByUnitGroup.add(titlesNode);
			}
		}

		return treeRoot;
	}

	public void addTitles() {
		TreeNode firstParentNode = selectedNodes[0];
		OrgNodeItem firstParentItem = (OrgNodeItem) firstParentNode.getData();
		TitlesBean titlesBean = BeanUtils.getTitlesBean();

		Department department = null;
		Unit unit = null;
		UnitGroup unitGroup = null;
		if (firstParentItem.getType().equalsIgnoreCase(
				OrgNodeItem.DEPARTMENT_TYPE)) {
			department = (Department) firstParentItem.getModelObject();
		} else if (firstParentItem.getType().equalsIgnoreCase(
				OrgNodeItem.UNIT_TYPE)) {
			unit = (Unit) firstParentItem.getModelObject();
			department = (Department) ((OrgNodeItem) firstParentNode
					.getParent().getData()).getModelObject();
		} else if (firstParentItem.getType().equalsIgnoreCase(
				OrgNodeItem.UNITGROUP_TYPE)) {
			unitGroup = (UnitGroup) firstParentItem.getModelObject();
			TreeNode unitNode = firstParentNode.getParent();
			unit = (Unit) ((OrgNodeItem) unitNode.getData()).getModelObject();
			department = (Department) ((OrgNodeItem) unitNode.getParent()
					.getData()).getModelObject();
		}

		titlesBean.setTitles(TitlesLocalServiceUtil.createPrePersistedTitles());
		titlesBean.setUnitGroup(unitGroup);
		titlesBean.setUnit(unit);
		titlesBean.setDepartment(department);
		titlesBean.setUpdateComponents(":orgTreeForm:orgTree");
		titlesBean.setUpdateTree(true);
	}

	public void editTitles() {

		OrgNodeItem item = (OrgNodeItem) selectedNodes[0].getData();
		TitlesBean titlesBean = BeanUtils.getTitlesBean();
		if (item.getType().equalsIgnoreCase(OrgNodeItem.TITLES_TYPE)) {

			titlesBean.setTitles((Titles) item.getModelObject());
			titlesBean.setUpdateTree(true);
		}
	}

	public void deleteTitles() {
		TreeNode titlesNode = selectedNodes[0];

		TreeNode firstParentNode = titlesNode.getParent();
		String firstParentNodeType = ((OrgNodeItem) firstParentNode).getType();
		if (firstParentNodeType.equalsIgnoreCase(OrgNodeItem.DEPARTMENT_TYPE)) {

		}

		OrgNodeItem item = (OrgNodeItem) selectedNodes[0].getData();
		try {
			TitlesLocalServiceUtil.deleteTitles(item.getId());
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public String getCurrentSelectedLevel() {
		if (selectedNodes == null || selectedNodes.length > 1)
			return StringUtils.EMPTY;
		TreeNode selectedNode = selectedNodes[0];
		OrgNodeItem item = (OrgNodeItem) selectedNode.getData();
		return item.getType();
	}

	public void updateTreeOnTitlesAdded(Titles titles) {
		TreeNode firstParentNode = selectedNodes[0];
		firstParentNode.getChildren().add(
				new DefaultTreeNode(OrgNodeItem.TITLES_TYPE, new OrgNodeItem(
						titles), firstParentNode));
	}

	public void updateTreeOnTitlesEdited(Titles titles) {
		TreeNode selectedTitlesNode = selectedNodes[0];
		TreeNode parent = selectedTitlesNode.getParent();

		parent.getChildren().remove(selectedTitlesNode);
		parent.getChildren().add(
				new DefaultTreeNode(OrgNodeItem.TITLES_TYPE, new OrgNodeItem(
						titles), parent));
	}

}
