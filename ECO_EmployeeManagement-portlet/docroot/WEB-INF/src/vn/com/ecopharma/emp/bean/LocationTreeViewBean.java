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
import vn.com.ecopharma.emp.util.EmployeePortletServicesUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.CountryServiceUtil;

@ManagedBean(name = "locationTreeBean")
@ViewScoped
public class LocationTreeViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7420787934576982916L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(LocationTreeViewBean.class);

	private TreeNode root;

	private TreeNode[] selectedNodes;

	@PostConstruct
	public void init() {
		root = createDocuments();
	}

	public TreeNode createDocuments() {

		TreeNode treeRoot = new DefaultTreeNode(new Object(), null);

		List<Country> countries = new ArrayList<>();
		countries.add(getDefaultRootCountry());

		List<TreeNode> countryNodes = new ArrayList<>();
		for (Country country : countries) {
			TreeNode countryNode = new DefaultTreeNode(
					LocationNodeItem.COUNTRY_TYPE,
					new LocationNodeItem(country), treeRoot);
			countryNodes.add(countryNode);
		}

		final List<TreeNode> regionTreeNodes = new ArrayList<>();
		for (TreeNode countryNode : countryNodes) {
			final List<Region> allVNRegions = EmployeePortletServicesUtils
					.getRegionByCountry(((LocationNodeItem) countryNode
							.getData()).getId());
			for (Region region : allVNRegions) {
				TreeNode regionNode = new DefaultTreeNode(
						LocationNodeItem.CITY_TYPE,
						new LocationNodeItem(region), countryNode);
				regionTreeNodes.add(regionNode);
			}
		}

		final List<TreeNode> districtNodes = new ArrayList<>();
		for (TreeNode regionNode : regionTreeNodes) {
			Region region = EmployeePortletServicesUtils
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

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public List<LocationNodeItem> getSelectedTreeNodeItemList() {
		if (selectedNodes == null || selectedNodes.length == 0)
			return new ArrayList<>();
		final List<LocationNodeItem> result = new ArrayList<>();
		for (TreeNode treeNode : selectedNodes)
			result.add((LocationNodeItem) treeNode.getData());
		return result;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public boolean isAllDistrictSelected() {
		if (selectedNodes == null || selectedNodes.length == 0)
			return false;
		for (TreeNode node : selectedNodes) {
			if (!((LocationNodeItem) node.getData()).getType()
					.equalsIgnoreCase(LocationNodeItem.DISTRICT_TYPE)) {
				return false;
			}
		}
		return true;
	}

	public Region getCurrentParentRegion() {
		return null;
	}

}
