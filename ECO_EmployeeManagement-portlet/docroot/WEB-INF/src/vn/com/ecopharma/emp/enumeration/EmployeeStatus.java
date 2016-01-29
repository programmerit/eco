package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public enum EmployeeStatus {
	NEWLY_ADDED, RESIGNED, MATERNITY_LEAVE, JOB_WAITING, DISCIPLINE;

	public static List<EmployeeStatus> getAvailableStatus(EmployeeStatus status) {
		switch (status) {
		case NEWLY_ADDED:
			return Arrays.asList(RESIGNED);
		case RESIGNED:
			return new ArrayList<>();
		default:
			return new ArrayList<>();
		}
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (EmployeeStatus status : values())
			result.add(status.toString());
		return result;
	}

	public List<EmployeeStatus> getAvailableStatus() {
		return getAvailableStatus(this);
	}

	public static List<String> getAvailableStatus_(String status) {
		final EmployeeStatus s = EmployeeStatus.valueOf(status);
		final List<EmployeeStatus> statuses = getAvailableStatus(s);
		final List<String> result = new ArrayList<String>(statuses.size());
		for (EmployeeStatus ss : statuses) {
			result.add(ss.toString());
		}
		return result;
	}

	public List<String> getAvailableStatus_() {
		return getAvailableStatus_(this.toString());
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "employeeInfo.status." + this.name().toUpperCase();
	}

	public static String getCssClass(EmployeeStatus status) {
		switch (status) {
		case NEWLY_ADDED:
			return "status-green";
		case RESIGNED:
			return "status-red";
		default:
			return StringUtils.EMPTY;
		}
	}

	public String getCssClass() {
		return getCssClass(this);
	}

}
