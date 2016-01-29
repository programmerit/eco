package vn.com.ecopharma.emp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.search.Document;

@FacesConverter("empIndexedConverter")
public class EmpIndexedConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return new EmpIndexedItem((Document) EmpLocalServiceUtil.getIndexedEmp(
				arg2, EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return ((EmpIndexedItem) arg2).getIdAsString();
	}

}
