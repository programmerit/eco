package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.search.Document;

@FacesConverter("interviewerConverter")
public class InterviewerConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return new EmpIndexedItem((Document) EmpLocalServiceUtil.getIndexedEmp(
				arg2, RCUtils.getCurrentSearchContext()));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((EmpIndexedItem) arg2).getIdAsString();
	}

}
