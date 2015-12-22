package vn.com.ecopharma.emp.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.WorkingLocation;
import vn.com.ecopharma.emp.service.WorkingLocationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "workingLocationConverter")
public class WorkingLocationConverter extends
		AbstractBaseModelConverter<WorkingLocation> {

	@Override
	protected WorkingLocation returnedModelObject(String value) {
		try {
			return WorkingLocationLocalServiceUtil.getWorkingLocation(Long
					.valueOf(value));
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
