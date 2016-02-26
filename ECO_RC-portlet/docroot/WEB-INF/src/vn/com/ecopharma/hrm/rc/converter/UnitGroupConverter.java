package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter("unitGroupConverter")
public class UnitGroupConverter extends AbstractBaseModelConverter<UnitGroup> {

	@Override
	protected UnitGroup returnedObject(String value) {
		try {
			return UnitGroupLocalServiceUtil.getUnitGroup(Long.valueOf(value));
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
		return UnitGroupConverter.class;
	}

}