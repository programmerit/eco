package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

public class RegionItem implements Comparable<RegionItem>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Region region;

	private int index;

	public RegionItem(long regionId) throws PortalException, SystemException {
		this(RegionServiceUtil.getRegion(regionId));
	}

	public RegionItem(Region region) {
		this.region = region;
		if (region.getRegionCode().equalsIgnoreCase("VN-65")) {
			this.index = 1;
		} else if (region.getRegionCode().equalsIgnoreCase("VN-64")) {
			this.index = 2;
		} else {
			this.index = 3;
		}
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public long getId() {
		return this.region.getRegionId();
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
	public boolean equals(Object obj) {
		if (!(obj instanceof RegionItem))
			return false;
		RegionItem that = (RegionItem) obj;
		return this.region.getRegionId() == that.getRegion().getRegionId();
	}

}
