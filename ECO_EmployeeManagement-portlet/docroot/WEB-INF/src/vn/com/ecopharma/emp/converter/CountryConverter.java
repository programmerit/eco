package vn.com.ecopharma.emp.converter;

import javax.faces.convert.FacesConverter;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Country;
import com.liferay.portal.service.CountryServiceUtil;

@FacesConverter(value = "countryConverter")
public class CountryConverter extends AbstractBaseModelConverter<Country> {

	@Override
	protected Country returnedModelObject(String value) {
		try {
			return CountryServiceUtil.getCountry(Long.valueOf(value));
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
