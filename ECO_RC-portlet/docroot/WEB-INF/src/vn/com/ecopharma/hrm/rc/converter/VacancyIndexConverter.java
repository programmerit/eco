package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.log.LogFactoryUtil;

@FacesConverter(value = "vacancyIndexConverter")
public class VacancyIndexConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				VacancyIndexItem vii = new VacancyIndexItem(
						VacancyLocalServiceUtil.getIndexVacancyDocument(
								Long.valueOf(value),
								RCUtils.getCurrentSearchContext()));
				return vii;
			} catch (NumberFormatException e) {
				LogFactoryUtil.getLog(VacancyIndexItemConverter.class).info(e);
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return null;
	}

}
