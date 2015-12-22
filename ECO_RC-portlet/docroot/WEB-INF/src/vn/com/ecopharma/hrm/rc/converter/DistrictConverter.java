package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;

@FacesConverter("districtConverter")
public class DistrictConverter extends AbstractBaseModelConverter<District> {

	@Override
	protected District returnedObject(String value) {
		try {
			return DistrictLocalServiceUtil.fetchDistrict(Long.valueOf(value));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}
