package vn.com.ecopharma.emp.enumeration;

public enum ResignationType {
	RESIGNED_LETTER, EMPLOYEE_SIDE, COMPANY_SIDE, AGREEMENT, EXPIRED, DISMISSAL, TERMINATION_PROBATION, OTHER, NONE;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "employeeInfo.resignation_type." + this.name().toUpperCase();
	}

}
