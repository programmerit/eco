package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum VacationLeaveType {

	MATERNITY;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "vacationLeaveType." + this.name().toUpperCase();
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (VacationLeaveType status : values())
			result.add(status.toString());
		return result;
	}

}
