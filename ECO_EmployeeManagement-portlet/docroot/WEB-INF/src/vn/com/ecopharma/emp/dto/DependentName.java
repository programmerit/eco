package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

public class DependentName implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private boolean UIDeleted = false;

	public DependentName(String name, boolean UIDeleted) {
		super();
		this.name = name;
		this.UIDeleted = UIDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUIDeleted() {
		return UIDeleted;
	}

	public void setUIDeleted(boolean UIDeleted) {
		this.UIDeleted = UIDeleted;
	}
}