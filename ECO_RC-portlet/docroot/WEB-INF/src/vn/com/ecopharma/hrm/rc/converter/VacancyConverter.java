package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "vacancyConverter")
public class VacancyConverter extends AbstractBaseModelConverter<Vacancy> {

	@Override
	protected Vacancy returnedObject(String value) {
		try {
			return VacancyLocalServiceUtil.fetchVacancy(Long.valueOf(value));
		} catch (NumberFormatException e) {
			info(e);
		} catch (SystemException e) {
			info(e);
		}
		return null;
	}

	@Override
	protected Class<?> getLogClass() {
		return VacancyConverter.class;
	}

}
