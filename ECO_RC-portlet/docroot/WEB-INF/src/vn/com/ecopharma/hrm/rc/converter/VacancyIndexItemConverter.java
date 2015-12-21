package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.search.SearchContext;

@FacesConverter(value = "vacancyIndexItemConverter")
public class VacancyIndexItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value != null && value.trim().length() > 0) {
			try {
				VacancyIndexItem vii = new VacancyIndexItem(
						VacancyLocalServiceUtil.getIndexVacancyDocument(
								Long.valueOf(value), getCurrentSearchContext()));
				return vii;
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		return value != null && value instanceof VacancyIndexItem ? String
				.valueOf(((VacancyIndexItem) value).getId())
				: StringUtils.EMPTY;
	}

	private SearchContext getCurrentSearchContext() {
		return RCUtils.getCurrentSearchContext();
	}

}
