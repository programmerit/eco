package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "levelConverter")
public class LevelConverter extends AbstractBaseModelConverter<Level> {

	@Override
	protected Level returnedObject(String value) {
		try {
			return LevelLocalServiceUtil.getLevel(Long.valueOf(value));
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
