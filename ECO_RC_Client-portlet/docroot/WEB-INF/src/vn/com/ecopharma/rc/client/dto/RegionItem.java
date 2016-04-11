package vn.com.ecopharma.rc.client.dto;

import java.io.Serializable;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

public class RegionItem extends AbstractBaseModelItem<Region> implements
		Comparable<RegionItem>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int index;

	public RegionItem(long regionId) throws PortalException, SystemException {
		this(RegionServiceUtil.getRegion(regionId));
	}

	public RegionItem(Region region) {
		super(region);
		if (region.getRegionCode().equalsIgnoreCase("VN-65")) {
			this.index = 1;
		} else if (region.getRegionCode().equalsIgnoreCase("VN-64")) {
			this.index = 2;
		} else {
			this.index = 3;
		}
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public int compareTo(RegionItem o) {
		return this.index - o.index;
	}

	@Override
	public Region createPrepersistedEntity() {
		return null;
	}

}
