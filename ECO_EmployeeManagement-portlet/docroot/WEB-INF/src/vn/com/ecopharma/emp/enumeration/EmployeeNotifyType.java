package vn.com.ecopharma.emp.enumeration;

public enum EmployeeNotifyType {

	SENT, WAITING;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "emp.notifytype." + this.toString();
	}

}
