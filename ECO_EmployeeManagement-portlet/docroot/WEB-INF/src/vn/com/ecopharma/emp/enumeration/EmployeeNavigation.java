package vn.com.ecopharma.emp.enumeration;

public enum EmployeeNavigation {

	VIEW("/views/employees.xhtml"), //
	NORMAL_USER_VIEW("/views/normalUserView.xhtml"), //
	EDIT("/views/employeeForm.xhtml"), //
	CREATE("/views/employeeForm.xhtml"), //
	IMPORT_EXPORT("/views/import_export.xhtml"); //

	private String outCome;

	private EmployeeNavigation(String outCome) {
		this.outCome = outCome;
	}

	public String getOutCome() {
		return outCome;
	}

	public void setOutCome(String outCome) {
		this.outCome = outCome;
	}
}
