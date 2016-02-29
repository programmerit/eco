package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum VacationLeaveStatus {

	PENDING_REQUEST, MANAGER_APPROVED, HR_APPROVED;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "leaveStatus." + this.toString();
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();

		for (VacationLeaveStatus status : values()) {
			result.add(status.toString());
		}
		return result;
	}
}
