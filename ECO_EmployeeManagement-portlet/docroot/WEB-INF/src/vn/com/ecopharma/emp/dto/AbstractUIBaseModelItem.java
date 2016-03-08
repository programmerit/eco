package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;

/**
 * @author TaoTran
 * @version 1.0
 * @since 2015/11/22
 * @category Base class of User Interface Removable BaseModel item(UI)
 * @param <T>
 *            BaseModel
 */
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
		return EmployeeUtils.getServiceContext();
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
