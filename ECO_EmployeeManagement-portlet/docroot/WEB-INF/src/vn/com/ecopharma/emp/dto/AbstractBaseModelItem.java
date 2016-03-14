package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

import com.liferay.portal.model.BaseModel;

public abstract class AbstractBaseModelItem<T extends BaseModel<T>> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	T t;

	public AbstractBaseModelItem(T t) {
		this.t = t;
	}

	public T getObject() {
		return t;
	}

	public void setObject(T t) {
		this.t = t;
	}

	public long getId() {
		return new Long(t.getPrimaryKeyObj().toString());
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractBaseModelItem<?>))
			return false;
		AbstractBaseModelItem<?> that = (AbstractBaseModelItem<?>) obj;
		return this.getId() == that.getId();
	}

}
