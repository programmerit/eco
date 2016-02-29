package vn.com.ecopharma.hrm.tt.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum VacationLeaveType {
	ANNUAL_LEAVE, PERSONAL_REASON_LEAVE, WO_PAYMENT_LEAVE, POLICY_LEAVE, OTHERS;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "leaveType." + this.toString();
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();

		for (VacationLeaveType type : values()) {
			result.add(type.toString());
		}
		return result;
	}
}
