package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "titlesConverter")
public class TitlesConverter extends AbstractBaseModelConverter<Titles> {

	@Override
	protected Titles returnedObject(String value) {
		try {
			return TitlesLocalServiceUtil.fetchTitles(Long.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return TitlesConverter.class;
	}

}
