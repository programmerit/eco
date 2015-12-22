package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

@FacesConverter(value = "regionConverter")
public class RegionConverter extends AbstractBaseModelConverter<Region>{

	@Override
	protected Region returnedObject(String value) {
		try {
			return RegionServiceUtil.getRegion(Long.valueOf(value));
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
