package vn.com.ecopharma.rc.client.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.rc.client.dto.RegionItem;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@FacesConverter(value = "regionItemConverter")
public class RegionItemConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		try {
			if (!StringUtils.EMPTY.equalsIgnoreCase(arg2))
				return new RegionItem(Long.valueOf(arg2));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		if (arg2 instanceof RegionItem)
			return String.valueOf(((RegionItem) arg2).getId());
		return StringUtils.EMPTY;
	}
}
