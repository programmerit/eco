package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.DevisionGroup;
import vn.com.ecopharma.emp.service.DevisionGroupLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "devisionGroupConverter")
public class DevisionGroupConverter extends AbstractBaseModelConverter<DevisionGroup> {

	@Override
	protected DevisionGroup returnedObject(String value) {
		try {
			return DevisionGroupLocalServiceUtil.getDevisionGroup(Long
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
