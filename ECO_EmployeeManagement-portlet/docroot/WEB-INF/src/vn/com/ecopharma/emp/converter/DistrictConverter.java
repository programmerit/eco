package vn.com.ecopharma.emp.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter("districtConverter")
public class DistrictConverter extends AbstractBaseModelConverter<District> {

	@Override
	protected District returnedModelObject(String value) {
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
