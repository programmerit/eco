package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum VacationLeaveType {

	ANNUAL_LEAVE(Arrays.asList("P", "1/2P")), // Nghỉ phép
	WO_PAYMENT_LEAVE(Arrays.asList("N", "1/2N")), // Nghỉ không lương
	COMPENSATION_LEAVE(Arrays.asList("NB", "1/2NB")), // Nghỉ bù
	POLICY_LEAVE(Arrays.asList("CD", "OD", "CO", "TS")), // Nghỉ chế độ
	HOLIDAYS(Arrays.asList("L")), // Nghỉ lễ
	OTHERS(Arrays.asList("O")); // Khác

	private List<String> signs;

	VacationLeaveType(List<String> signs) {
		this.signs = signs;
	}

	public List<String> getSigns() {
		return signs;
	}

	public void setSigns(List<String> signs) {
		this.signs = signs;
	}

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
