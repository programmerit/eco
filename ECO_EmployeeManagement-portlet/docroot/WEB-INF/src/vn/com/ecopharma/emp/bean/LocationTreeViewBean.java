package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.node.LocationNodeItem;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;

@ManagedBean(name = "locationTreeViewBean")
@ViewScoped
public class LocationTreeViewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(LocationTreeViewBean.class);

	private TreeNode root;

	private TreeNode[] selectedNodes;

	@PostConstruct
	public void init() {
		try {
			root = createDocuments();
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
	}

	public TreeNode createDocuments() throws SystemException, PortalException {
		TreeNode treeRoot = new DefaultTreeNode(new LocationNodeItem(
				getDefaultRootCountry()), null);

		final List<Region> allVNRegions = RegionServiceUtil
				.getRegions(((LocationNodeItem) treeRoot.getData()).getId());
		final List<TreeNode> regionTreeNodes = new ArrayList<>();
		for (Region region : allVNRegions) {
			TreeNode regionNode = new DefaultTreeNode(
					LocationNodeItem.CITY_TYPE, new LocationNodeItem(region),
					treeRoot);
			regionTreeNodes.add(regionNode);
		}

		final List<TreeNode> districtNodes = new ArrayList<>();
		for (TreeNode regionNode : regionTreeNodes) {
			Region region = RegionServiceUtil
					.getRegion(((LocationNodeItem) regionNode.getData())
							.getId());
			final List<District> districtsByRegion = DistrictLocalServiceUtil
					.findByRegionCode(region.getRegionCode());

			if (!districtsByRegion.isEmpty()) {
				for (District district : districtsByRegion) {
					TreeNode districtNode = new DefaultTreeNode(
							LocationNodeItem.DISTRICT_TYPE,
							new LocationNodeItem(district), regionNode);
					districtNodes.add(districtNode);
				}
			} else {
				districtNodes.add(new DefaultTreeNode(
						LocationNodeItem.DISTRICT_TYPE, new LocationNodeItem(
								LocationNodeItem.DISTRICT_TYPE), regionNode));
			}
		}

		return treeRoot;
	}

	private static Country getDefaultRootCountry() {
		try {
			return CountryServiceUtil.getCountryByName("vietnam");
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
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
