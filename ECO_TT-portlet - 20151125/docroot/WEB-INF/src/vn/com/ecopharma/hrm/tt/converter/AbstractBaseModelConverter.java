package vn.com.ecopharma.hrm.tt.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.model.BaseModel;

/**
 * @author TaoTran
 * @version 1.0
 * @param <T>
 *            concrete sub class of BaseModel<T>
 */
public abstract class AbstractBaseModelConverter<T extends BaseModel<T>> implements
		Converter {

	@Override
	public T getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && StringUtils.trimToNull(value) != null)
			return returnedModelObject(value);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof BaseModel<?>)
			return String.valueOf(((T) value).getPrimaryKeyObj());
		return StringUtils.EMPTY;
	}

	protected abstract T returnedModelObject(String value);
}
