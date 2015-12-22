package vn.com.ecopharma.hrm.rc.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.hrm.rc.enumeration.LaborContractType;

@FacesConverter(value = "laborContractTypeConverter")
public class LaborContractTypeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return LaborContractType.valueOf(value).toString();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return (value).toString();
	}

}
