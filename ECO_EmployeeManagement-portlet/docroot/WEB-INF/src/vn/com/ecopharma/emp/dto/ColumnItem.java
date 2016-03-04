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

	private boolean bankField = Boolean.FALSE;

	private boolean addressField = Boolean.FALSE;

	public ColumnItem(int index, String propertyName, String propertyViName) {
		this.index = index;
		this.propertyName = propertyName;
		this.propertyViName = propertyViName;
	}

	public ColumnItem(int index, String propertyName, String propertyViName,
			boolean bankField, boolean addressField) {
		this.index = index;
		this.propertyName = propertyName;
		this.propertyViName = propertyViName;
		this.bankField = bankField;
		this.addressField = addressField;
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

	public boolean isBankField() {
		return bankField;
	}

	public void setBankField(boolean bankField) {
		this.bankField = bankField;
	}

	public boolean isAddressField() {
		return addressField;
	}

	public void setAddressField(boolean addressField) {
		this.addressField = addressField;
	}

}
