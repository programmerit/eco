package vn.com.ecopharma.emp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vn.com.ecopharma.emp.dto.Document;
import vn.com.ecopharma.emp.dto.OrgNodeItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

@ManagedBean(name = "organizationTreeViewBean")
@ViewScoped
public class OrganizationTreeViewBean {

	private TreeNode root;

	private TreeNode[] selectedNodes;

	@PostConstruct
	public void init() {
		root = createDocuments();
	}

	public TreeNode createDocuments() {
		TreeNode root = new DefaultTreeNode(
				new Document("Files", "-", "Folder"), null);

		final List<Devision> allDevisions = DevisionLocalServiceUtil.findAll();
		final List<TreeNode> devisionTreeNodes = new ArrayList<>();
		for (Devision devision : allDevisions) {
			TreeNode devisionNode = new DefaultTreeNode("DEVISION",
					new OrgNodeItem(devision), root);
			devisionTreeNodes.add(devisionNode);
		}

		final List<TreeNode> deptTreeNodes = new ArrayList<>();
		for (TreeNode devisionNode : devisionTreeNodes) {
			OrgNodeItem devisionItem = (OrgNodeItem) devisionNode.getData();
			final List<Department> departmentsByDevision = DepartmentLocalServiceUtil
					.findByDevision(devisionItem.getId());

			if (!departmentsByDevision.isEmpty()) {
				for (Department department : departmentsByDevision) {
					TreeNode deptNode = new DefaultTreeNode("DEPARTMENT",
							new OrgNodeItem(department), devisionNode);
					deptTreeNodes.add(deptNode);
				}
			} else {
				deptTreeNodes.add(new DefaultTreeNode("DEPARTMENT",
						new OrgNodeItem("DEPARTMENT"), devisionNode));
			}
		}

		final List<TreeNode> unitTreeNodes = new ArrayList<>();
		for (TreeNode deptNode : deptTreeNodes) {
			OrgNodeItem deptItem = (OrgNodeItem) deptNode.getData();
			final List<Unit> unitsByDept = UnitLocalServiceUtil
					.findByDepartment(deptItem.getId());

			for (Unit unit : unitsByDept) {
				TreeNode unitNode = new DefaultTreeNode("UNIT",
						new OrgNodeItem(unit), deptNode);
				unitTreeNodes.add(unitNode);
			}
		}

		final List<TreeNode> titlesTreeNodes = new ArrayList<>();
		for (TreeNode deptNode : deptTreeNodes) {
			OrgNodeItem deptItem = (OrgNodeItem) deptNode.getData();
			final List<Titles> titlesListByDept = TitlesLocalServiceUtil
					.findByDepartment(deptItem.getId());

			for (Titles titles : titlesListByDept) {
				TreeNode titlesNode = new DefaultTreeNode("TITLES",
						new OrgNodeItem(titles), deptNode);
				titlesTreeNodes.add(titlesNode);
			}
		}

		return root;
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

}
