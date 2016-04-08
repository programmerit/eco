package vn.com.ecopharma.rc.client.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;
import vn.com.ecopharma.rc.client.util.RCClientUtils;

@FacesConverter(value = "vacancyIndexItemConverter")
public class VacancyIndexItemConverter implements Converter {

	@Override
	public VacancyIndexItem getAsObject(FacesContext arg0, UIComponent arg1,
			String value) {
		if (value != null && !value.equals(StringUtils.EMPTY))
			return new VacancyIndexItem(
					VacancyLocalServiceUtil.getIndexVacancyDocument(
							Long.valueOf(value),
							RCClientUtils.getCurrentSearchContext()));
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value != null && value instanceof VacancyIndexItem) {
			VacancyIndexItem obj = (VacancyIndexItem) value;
			return String.valueOf(obj.getId());
		}
		return StringUtils.EMPTY;
	}

}
