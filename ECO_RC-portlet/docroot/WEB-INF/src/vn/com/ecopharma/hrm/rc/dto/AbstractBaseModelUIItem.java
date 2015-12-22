package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import com.liferay.portal.model.BaseModel;

public abstract class AbstractBaseModelUIItem<T extends BaseModel<T>>
		implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean UIDeleted;
	private T t;

	public AbstractBaseModelUIItem() {
		t = createPrePersistedBaseModel();
		this.UIDeleted = false;
	}

	public AbstractBaseModelUIItem(T t) {
		this.t = t;
		this.UIDeleted = false;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean uIDeleted) {
		UIDeleted = uIDeleted;
	}

	public T getObject() {
		return t;
	}

	public abstract T createPrePersistedBaseModel();

}
