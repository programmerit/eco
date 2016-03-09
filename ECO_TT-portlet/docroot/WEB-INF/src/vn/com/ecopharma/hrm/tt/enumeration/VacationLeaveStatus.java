package vn.com.ecopharma.hrm.tt.enumeration;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

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

	public String getCSS() {
		switch (this) {
		case PENDING_REQUEST:
			return "status-grey";
		case MANAGER_APPROVED:
			return "status-yellow";
		case HR_APPROVED:
			return "status-green";
		default:
			break;
		}
		return StringUtils.EMPTY;
	}
}
