package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;

/**
 * @author TaoTran
 *
 */
public class AddressObjectItem implements Serializable {

	private static final long serialVersionUID = 1L;
	private Region selectedRegion;
	private Region region;
	private List<Region> regions;
	private District district;
	private List<District> districts;
	private Country country;
	private boolean UIDeleted;
	private Address address;
	private static final String DEFAULT_COUNTRY_NAME = "vietnam";

	public AddressObjectItem() {
		this.region = null;
		this.country = getDefaultCountry();
		this.UIDeleted = false;
		this.regions = getRegionByCountryId();
		this.address = createNewAddress();
	}

	public AddressObjectItem(Address address) {
		this.address = address;
		this.region = address.getRegion();
		this.district = ImportExportUtils.getDistrictByStreet3(address);
		this.country = address.getCountry();
		this.UIDeleted = false;
		this.regions = getRegionByCountryId();
		this.districts = getDistrictsByRegionCode(this.region.getRegionCode());
	}

	/**
	 * @param countryId
	 * @param regionId
	 * @param district
	 *            use street3 of address object as district
	 * @param street
	 */
	public AddressObjectItem(long countryId, long regionId, String district,
			String street) {
		this.address = createNewAddress(countryId, regionId, district, street);
	}

	private Country getDefaultCountry() {
		try {
			return CountryServiceUtil.getCountryByName(DEFAULT_COUNTRY_NAME);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(AddressObjectItem.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(AddressObjectItem.class).info(e);
		}
		return null;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Region getSelectedRegion() {
		return selectedRegion;
	}

	public void setSelectedRegion(Region selectedRegion) {
		this.selectedRegion = selectedRegion;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	private final Address createNewAddress() {
		try {
			final long generatedId = CounterLocalServiceUtil.increment();
			return AddressLocalServiceUtil.createAddress(generatedId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(AddressObjectItem.class).info(e);
		}
		return null;
	}

	/**
	 * @param countryId
	 * @param regionId
	 * @param district
	 * @param street
	 * @return
	 */
	private final Address createNewAddress(long countryId, long regionId,
			String district, String street) {
		final Address a = createNewAddress();
		if (a != null) {
			try {
				Region r = RegionServiceUtil.getRegion(regionId);
				a.setRegionId(regionId);
				a.setCountryId(countryId);
				a.setStreet1(street);
				checkAndCreateDistrict(r.getRegionCode(), district);
				a.setStreet3(r.getRegionCode() + "_" + district);
				return a;
			} catch (PortalException e) {
				LogFactoryUtil.getLog(AddressObjectItem.class).info(e);
			} catch (SystemException e) {
				LogFactoryUtil.getLog(AddressObjectItem.class).info(e);
			}
		}
		return null;
	}

	private static void checkAndCreateDistrict(String regionCode,
			String districtName) {
		if (DistrictLocalServiceUtil.findByRegionCodeAndName(regionCode,
				districtName) == null)
			DistrictLocalServiceUtil.addDistrict(districtName, regionCode,
					LiferayFacesContext.getInstance().getServiceContext());
	}

	private List<Region> getRegionByCountryId() {
		try {
			return RegionServiceUtil.getRegions(country.getCountryId());
		} catch (SystemException e) {
			LogFactoryUtil.getLog(AddressObjectItem.class).info(e);
		}
		return new ArrayList<>();
	}

	private static List<District> getDistrictsByRegionCode(String regionCode) {
		return DistrictLocalServiceUtil.findByRegionCode(regionCode);
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setDistricts(List<District> districts) {
		this.districts = districts;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
