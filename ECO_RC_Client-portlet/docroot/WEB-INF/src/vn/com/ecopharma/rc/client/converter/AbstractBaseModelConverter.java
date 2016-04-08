package vn.com.ecopharma.rc.client.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

/**
 * @author TaoTran
 * @version 1.0
 * @param <T>
 *            concrete sub class of BaseModel<T>
 */
public abstract class AbstractBaseModelConverter<T extends BaseModel<T>>
		implements Converter {

	@Override
	public T getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && StringUtils.trimToNull(value) != null)
			return returnedObject(value);
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

	public void info(Throwable e) {
		getLogger().info(e);
	}

	protected Log getLogger() {
		return getLogClass() != null ? LogFactoryUtil.getLog(getLogClass())
				: LogFactoryUtil.getLog(AbstractBaseModelConverter.class);
	}

	protected abstract T returnedObject(String value);

	protected abstract Class<?> getLogClass();
}
