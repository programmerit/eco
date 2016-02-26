package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;

@FacesConverter(value = "countryConverter")
public class CountryConverter extends AbstractBaseModelConverter<Country> {

	@Override
	protected Country returnedObject(String value) {
		try {
			return CountryServiceUtil.getCountry(Long.valueOf(value));
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
		return CountryConverter.class;
	}
}
