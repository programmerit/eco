package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;

@ManagedBean(name = "specializedTreeViewBean")
@ViewScoped
public class SpecializedTreeViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2928998067622705654L;

	private TreeNode root;

	private TreeNode[] selectedNodes;

	@PostConstruct
	public void init() {
		root = createDocuments();
	}

	public TreeNode createDocuments() {
		final TreeNode root = new DefaultTreeNode(new Object(), null);

		final List<Specialized> firstLevels = SpecializedLocalServiceUtil
				.findFirstLevelList();
		final List<TreeNode> firstLevelNodes = new ArrayList<>();

		for (Specialized s : firstLevels)
			firstLevelNodes.add(new DefaultTreeNode("First", s, root));

		// Children of first tree node includes both 2nd and 3rd levels
		final List<TreeNode> secondLevelNodes = new ArrayList<>();
		for (TreeNode f : firstLevelNodes) {
			Specialized fObj = (Specialized) f.getData();
			final List<Specialized> secondLevelsByFirst = SpecializedLocalServiceUtil
					.findByLevelAndParent(2, fObj.getSpecializedId());
			final List<Specialized> thirdLevelByFirst = SpecializedLocalServiceUtil
					.findByLevelAndParent(3, fObj.getSpecializedId());

			for (Specialized s : secondLevelsByFirst)
				secondLevelNodes.add(new DefaultTreeNode("Second", s, f));

			for (Specialized s : thirdLevelByFirst)
				new DefaultTreeNode("Third", s, f);
		}

		// Children of second tree node includes 3rd levels
		for (TreeNode s : secondLevelNodes) {
			Specialized sObj = (Specialized) s.getData();
			final List<Specialized> thirdLevelBySecond = SpecializedLocalServiceUtil
					.findThirdLevelList(sObj.getSpecializedId());
			for (Specialized s1 : thirdLevelBySecond)
				new DefaultTreeNode("Third", s1, s);
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
