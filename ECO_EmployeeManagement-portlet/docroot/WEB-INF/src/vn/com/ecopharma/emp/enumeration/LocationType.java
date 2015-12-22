package vn.com.ecopharma.emp.enumeration;

/**
 * @author TaoTran
 *
 */
public enum LocationType {

	WORKING_LOCATION, EMPLOYEE_ADDRESS;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

}
