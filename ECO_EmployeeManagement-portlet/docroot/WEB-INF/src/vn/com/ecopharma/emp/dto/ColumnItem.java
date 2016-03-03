package vn.com.ecopharma.emp.dto;

import java.io.Serializable;

public class ColumnItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int index;

	private String propertyName;

	private String propertyViName;

	private Object value;

	public ColumnItem(int index, String propertyName, String propertyViName) {
		this.index = index;
		this.propertyName = propertyName;
		this.propertyViName = propertyViName;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertyViName() {
		return propertyViName;
	}

	public void setPropertyViName(String propertyViName) {
		this.propertyViName = propertyViName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
