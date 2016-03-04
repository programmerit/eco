package vn.com.ecopharma.hrm.tt.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

@FacesConverter(value = "vacationIndexItemConverter")
public class VacationIndexItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		if (StringUtils.trimToNull(arg2) == null)
			return null;

		return new VacationLeaveIndexedItem(
				VacationLeaveLocalServiceUtil.getIndexedDocument(arg2,
						TTUtils.getCurrentSearchContext()));

	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (!(arg2 instanceof VacationLeaveIndexedItem))
			return StringUtils.EMPTY;
		return ((VacationLeaveIndexedItem) arg2).getIdAsString();
	}

}
