package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "unitConverter")
public class UnitConverter extends AbstractBaseModelConverter<Unit> {

	@Override
	protected Unit returnedObject(String value) {
		try {
			return UnitLocalServiceUtil.fetchUnit(Long.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return UnitConverter.class;
	}

}
