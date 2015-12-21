package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "unitConverter")
public class UnitConverter extends AbstractBaseModelConverter<Unit> {

	@Override
	protected Unit returnedObject(String value) {
		try {
			return UnitLocalServiceUtil.getUnit(Long.valueOf(value));
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
