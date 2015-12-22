package vn.com.ecopharma.hrm.tt.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;

@FacesConverter(value = "devisionConverter")
public class DevisionConverter extends AbstractBaseModelConverter<Devision> {

	@Override
	protected Devision returnedModelObject(String value) {
		try {
			return DevisionLocalServiceUtil.getDevision(Long.valueOf(value));
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
