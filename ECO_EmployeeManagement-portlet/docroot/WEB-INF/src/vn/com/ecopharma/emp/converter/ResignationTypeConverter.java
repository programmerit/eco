package vn.com.ecopharma.emp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import vn.com.ecopharma.emp.enumeration.ResignationType;

@FacesConverter(value = "resignationTypeConverter")
public class ResignationTypeConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		return ResignationType.valueOf(value).toString();
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		return (value).toString();
	}

}
