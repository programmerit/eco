package vn.com.ecopharma.hrm.rc.converter;

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
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}
