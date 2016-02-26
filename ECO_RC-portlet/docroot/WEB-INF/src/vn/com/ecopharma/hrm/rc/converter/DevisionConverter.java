package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "devisionConverter")
public class DevisionConverter extends AbstractBaseModelConverter<Devision> {

	@Override
	protected Devision returnedObject(String value) {
		try {
			return DevisionLocalServiceUtil.fetchDevision(Long.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return DevisionConverter.class;
	}
}
