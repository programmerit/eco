package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.RegionServiceUtil;

@FacesConverter(value = "regionConverter")
public class RegionConverter extends AbstractBaseModelConverter<Region> {

	@Override
	protected Region returnedObject(String value) {
		try {
			return RegionServiceUtil.getRegion(Long.valueOf(value));
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
		return RegionConverter.class;
	}

}
