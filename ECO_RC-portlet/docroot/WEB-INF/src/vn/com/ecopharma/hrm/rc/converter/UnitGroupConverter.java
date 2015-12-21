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
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}