package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "specializedConverter")
public class SpecializedConverter extends
		AbstractBaseModelConverter<Specialized> {

	@Override
	protected Specialized returnedObject(String value) {
		try {
			return SpecializedLocalServiceUtil.fetchSpecialized(Long
					.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return SpecializedConverter.class;
	}

}
