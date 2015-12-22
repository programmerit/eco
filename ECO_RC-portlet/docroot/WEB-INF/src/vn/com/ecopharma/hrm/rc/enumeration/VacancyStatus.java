package vn.com.ecopharma.hrm.rc.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum VacancyStatus {
	NEW, // just added
	PUBLISHED, // published and ready to assign candidate
	UNPUBLISHED; // closed

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedName() {
		// TODO: get localized name for status, TEMPORARY using this way
		return this.name().toUpperCase();
	}

	public static java.util.List<VacancyStatus> getAllStatuses() {
		return Arrays.asList(NEW, PUBLISHED, UNPUBLISHED);
	}

	public static java.util.List<VacancyStatus> getAvailableStatuses(
			VacancyStatus status) {
		switch (status) {
		case NEW:
			return Arrays.asList(PUBLISHED, UNPUBLISHED);
		case PUBLISHED:
			return Arrays.asList(UNPUBLISHED);
		case UNPUBLISHED:
			return Arrays.asList(PUBLISHED);
		default:
			return new java.util.ArrayList<VacancyStatus>();
		}
	}

	public String getCssClass() {
		switch (this) {
		case NEW:
			return "status-yellow";
		case PUBLISHED:
			return "status-green";
		case UNPUBLISHED:
			return "status-red";
		default:
			return "";
		}
	}

	public static String getCssClass(VacancyStatus status) {
		switch (status) {
		case NEW:
			return "status-yellow";
		case PUBLISHED:
			return "status-green";
		case UNPUBLISHED:
			return "status-red";
		default:
			return "";
		}
	}

	public static List<String> getAvailableStatus(String status) {
		final VacancyStatus statusEnum = VacancyStatus.valueOf(status);
		final List<VacancyStatus> statuses = getAvailableStatuses(statusEnum);
		final List<String> statusStringList = new ArrayList<String>();
		for (VacancyStatus v : statuses) {
			statusStringList.add(v.toString());
		}
		return statusStringList;
	}
}
