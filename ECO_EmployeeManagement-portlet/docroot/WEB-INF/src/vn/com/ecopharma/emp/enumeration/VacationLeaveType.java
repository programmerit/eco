package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public enum VacationLeaveType {

	ANNUAL_LEAVE(Arrays.asList("P", "1/2P"), new ArrayList<String>()), // Nghỉ
																		// phép

	WO_PAYMENT_LEAVE(Arrays.asList("N", "1/2N"), new ArrayList<String>()), // Nghỉ
																			// không
																			// lương

	COMPENSATION_LEAVE(Arrays.asList("NB", "1/2NB"), new ArrayList<String>()), // Nghỉ
																				// bù

	POLICY_LEAVE(Arrays.asList("CD", "OD", "CO", "TS"), new ArrayList<String>()), // Nghỉ
																					// chế
																					// độ

	HOLIDAYS(Arrays.asList("L"), new ArrayList<String>()), // Nghỉ lễ

	IN(new ArrayList<String>(), Arrays.asList("MISSED_IN_FINGER_PRINT", "LATE",
			"BUSINESS", "OTHER")), // Vào

	OUT(new ArrayList<String>(), Arrays.asList("MISSED_OUT_FINGER_PRINT",
			"OTHER")), // Ra

	OTHERS(Arrays.asList("O"), new ArrayList<String>()); // Khác

	private List<String> signs;

	private List<String> reasons;

	VacationLeaveType(List<String> signs, List<String> reasons) {
		this.signs = signs;
		this.reasons = reasons;
	}

	public List<String> getSigns() {
		return signs;
	}

	public void setSigns(List<String> signs) {
		this.signs = signs;
	}

	public List<String> getReasons() {
		return reasons;
	}

	public void setReasons(List<String> reasons) {
		this.reasons = reasons;
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "leaveType." + this.toString();
	}

	public String getHardCodeVneseString() {
		switch (this) {
		case ANNUAL_LEAVE:

			return "Nghỉ phép";
		case WO_PAYMENT_LEAVE:

			return "Nghỉ không lương";
		case COMPENSATION_LEAVE:

			return "Nghỉ bù";
		case POLICY_LEAVE:

			return "Nghỉ chế độ";
		case HOLIDAYS:

			return "Nghỉ lễ";
		case IN:
			return "Ra cổng";
		case OUT:
			return "Vào cổng";
		case OTHERS:

			return "Khác";
		default:
			break;
		}
		return StringUtils.EMPTY;
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();

		for (VacationLeaveType type : values()) {
			result.add(type.toString());
		}
		return result;
	}
}
