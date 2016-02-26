package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.DevisionGroup;
import vn.com.ecopharma.emp.service.DevisionGroupLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "devisionGroupConverter")
public class DevisionGroupConverter extends
		AbstractBaseModelConverter<DevisionGroup> {

	@Override
	protected DevisionGroup returnedObject(String value) {
		try {
			return DevisionGroupLocalServiceUtil.fetchDevisionGroup(Long
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
		return DevisionGroupConverter.class;
	}
}
