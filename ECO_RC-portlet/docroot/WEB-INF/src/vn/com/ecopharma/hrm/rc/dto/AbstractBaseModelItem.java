package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import com.liferay.portal.model.BaseModel;

public abstract class AbstractBaseModelItem<T extends BaseModel<T>> implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T object;

	public AbstractBaseModelItem() {
		this.object = createPrepersistedEntity();
	}

	public AbstractBaseModelItem(T object) {
		this.object = object;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public abstract T createPrepersistedEntity();
}
