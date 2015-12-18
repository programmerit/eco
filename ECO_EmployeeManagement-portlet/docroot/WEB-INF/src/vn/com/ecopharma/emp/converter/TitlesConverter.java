package vn.com.ecopharma.emp.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "titlesConverter")
public class TitlesConverter extends AbstractBaseModelConverter<Titles> {

	@Override
	protected Titles returnedModelObject(String value) {
		try {
			System.out.println("TEST" + Long.valueOf(value));
			return TitlesLocalServiceUtil.getTitles(Long.valueOf(value));
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
