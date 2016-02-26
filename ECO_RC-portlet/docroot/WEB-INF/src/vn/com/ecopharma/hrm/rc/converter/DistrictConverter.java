package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter("districtConverter")
public class DistrictConverter extends AbstractBaseModelConverter<District> {

	@Override
	protected District returnedObject(String value) {
		try {
			return DistrictLocalServiceUtil.fetchDistrict(Long.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return DistrictConverter.class;
	}

}
