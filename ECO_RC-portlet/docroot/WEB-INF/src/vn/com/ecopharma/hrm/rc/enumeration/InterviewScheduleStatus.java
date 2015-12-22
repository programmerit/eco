package vn.com.ecopharma.hrm.rc.enumeration;

import java.util.Arrays;
import java.util.List;

public enum InterviewScheduleStatus {

	PROCESSING, PASSED, FAILED;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "interviewSchedule.status." + this.toString();
	}

	public static List<InterviewScheduleStatus> getAll() {
		return Arrays.asList(PROCESSING, PASSED, FAILED);
	}

	public static List<String> getAllStringFormatted() {
		return Arrays.asList(PROCESSING.toString(), PASSED.toString(),
				FAILED.toString());
	}

}
