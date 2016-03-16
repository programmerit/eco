package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vn.com.ecopharma.hrm.rc.bean.dialog.CriteriaBean;
import vn.com.ecopharma.hrm.rc.enumeration.EvaluationCriteriaType;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;

@ManagedBean
@ViewScoped
public class EvaluationCriteriaTreeViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TreeNode root;

	private TreeNode selectedNode;

	private String includedDialog = StringUtils.EMPTY;

	@ManagedProperty(value = "#{criteriaBean}")
	private CriteriaBean criteriaBean;

	@PostConstruct
	public void init() {
		root = initTree();
	}

	private TreeNode initTree() {
		final TreeNode root = new DefaultTreeNode(new Object(), null);
		List<String> allEvalTypes = EvaluationCriteriaType.getAll();

		List<TreeNode> typeLevelNodes = new ArrayList<>();
		List<TreeNode> criteriasByTypeNodes = new ArrayList<>();
		List<TreeNode> criteriaKeyValByCriteriaNodes = new ArrayList<>();

		for (String t : allEvalTypes) {
			typeLevelNodes.add(new DefaultTreeNode("EvalType", t, root));
		}

		for (TreeNode typeNode : typeLevelNodes) {
			String type = (String) typeNode.getData();
			final List<EvaluationCriteria> criteriasByTypeList = EvaluationCriteriaLocalServiceUtil
					.findByType(type);

			for (EvaluationCriteria evaluationCriteria : criteriasByTypeList) {
				criteriasByTypeNodes.add(new DefaultTreeNode("CriteriaType",
						evaluationCriteria, typeNode));
			}
		}

		for (TreeNode critNode : criteriasByTypeNodes) {
			EvaluationCriteria crit = (EvaluationCriteria) critNode.getData();
			final List<EvaluationCriteriaKeyValue> criteriasKeyValByCrit = EvaluationCriteriaKeyValueLocalServiceUtil
					.findByEvaluationCriteria(crit.getEvaluationCriteriaId());

			for (EvaluationCriteriaKeyValue evaluationCriteriaKeyValue : criteriasKeyValByCrit) {
				criteriaKeyValByCriteriaNodes.add(new DefaultTreeNode(
						"CriteriaKeyValType", evaluationCriteriaKeyValue,
						critNode));
			}
		}

		return root;
	}

	public void onAddCriteria(ActionEvent event) {
		String type = (String) selectedNode.getData();
		criteriaBean.getCriteria().setType(type);
		this.includedDialog = "/views/dialogs/addCriteria.xhtml";
	}

	public void onAddKey(ActionEvent event) {

	}

	public void onViewKey(ActionEvent event) {

	}

	public void onDeleteKey(ActionEvent event) {

	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public boolean isTypeNodeSelected() {
		return selectedNode != null
				&& (selectedNode.getData() instanceof String);
	}

	public boolean isCriteriaNodeSelected() {
		return selectedNode != null
				&& (selectedNode.getData() instanceof EvaluationCriteria);
	}

	public boolean isKeyValNodeSelected() {
		return selectedNode != null
				&& (selectedNode.getData() instanceof EvaluationCriteriaKeyValue);
	}

	public String getIncludedDialog() {
		return includedDialog;
	}

	public void setIncludedDialog(String includedDialog) {
		this.includedDialog = includedDialog;
	}

	public CriteriaBean getCriteriaBean() {
		return criteriaBean;
	}

	public void setCriteriaBean(CriteriaBean criteriaBean) {
		this.criteriaBean = criteriaBean;
	}

}
