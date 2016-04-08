package vn.com.ecopharma.rc.client.dto;

import java.io.Serializable;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

public abstract class AbstractUIBaseModelItem<T extends BaseModel<T>>
		implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T object;

	private boolean UIDeleted;

	public AbstractUIBaseModelItem() {
		this.object = createPrePersistedBaseModel();
		this.UIDeleted = false;
	}

	public AbstractUIBaseModelItem(T object) {
		this.object = object;
	}

	protected abstract T createPrePersistedBaseModel();

	protected ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public long getObjectPrimaryKey() {
		return Long.valueOf(this.object.getPrimaryKeyObj().toString());
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = prime
				* result
				* (this.getObjectPrimaryKey() == 0 ? 0 : Long.valueOf(
						this.getObjectPrimaryKey()).hashCode());
		return result;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AbstractUIBaseModelItem)
			return this.getObjectPrimaryKey() == ((AbstractUIBaseModelItem) obj)
					.getObjectPrimaryKey();
		return false;
	}

}
