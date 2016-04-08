package vn.com.ecopharma.rc.client.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "universityConverter")
public class UniversityConverter extends AbstractBaseModelConverter<University> {

	@Override
	protected University returnedObject(String value) {
		try {
			return UniversityLocalServiceUtil
					.getUniversity(Long.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (PortalException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return UniversityConverter.class;
	}

}
