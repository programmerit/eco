package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;

public abstract class PersistableBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void onSave();

}
