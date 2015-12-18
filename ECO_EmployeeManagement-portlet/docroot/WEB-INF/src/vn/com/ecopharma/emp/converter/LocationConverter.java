package vn.com.ecopharma.emp.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.model.Location;
import vn.com.ecopharma.emp.service.LocationLocalServiceUtil;

@FacesConverter(value = "locationConverter")
public class LocationConverter extends AbstractBaseModelConverter<Location> {

	@Override
	protected Location returnedModelObject(String value) {
		try {
			return LocationLocalServiceUtil.getLocation(Long.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}
