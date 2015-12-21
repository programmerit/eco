package vn.com.ecopharma.hrm.rc.enumeration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public enum CandidateStatus {
	/*
	 * Indicates status of current candidate Example: when candidate first
	 * created -> status would be APPLICATION_INITIATED... Use comment on each
	 * enum item to prevent formatting code :)
	 */
	APPLICATION_INITIATED, // initiated
	REJECT, // reject
	SHORTLIST, // shorted list
	INTERVIEW_SCHEDULED, // schedule for interviewing
	JOB_OFFERED, // offer job
	DECLINE_OFFERED, // decline
	HIRE, // hire
	MARK_INTERVIEW_PASS, // mark pass
	MARK_INTERVIEW_FAIL; // mark fail

	public static List<CandidateStatus> getAvailableStatus(
			CandidateStatus status) {
		switch (status) {
		case APPLICATION_INITIATED:
			return Arrays.asList(REJECT, SHORTLIST);
		case INTERVIEW_SCHEDULED:
			return Arrays.asList(REJECT, MARK_INTERVIEW_FAIL,
					MARK_INTERVIEW_PASS);
		case SHORTLIST:
			return Arrays.asList(REJECT, INTERVIEW_SCHEDULED);
		case MARK_INTERVIEW_PASS:
			return Arrays.asList(JOB_OFFERED, INTERVIEW_SCHEDULED, REJECT);
		case MARK_INTERVIEW_FAIL:
			return Arrays.asList(REJECT);
		case JOB_OFFERED:
			return Arrays.asList(DECLINE_OFFERED, HIRE, REJECT);
		case REJECT:
			return new ArrayList<CandidateStatus>();
		default:
			return new ArrayList<CandidateStatus>();
		}
	}

	public List<String> getAvailableStatus_() {
		return getAvailableStatus_(this.toString());
	}

	public List<CandidateStatus> getAvailableStatus() {
		return getAvailableStatus(this);
	}

	public static List<String> getAvailableStatus_(String status) {
		final CandidateStatus statusEnum = CandidateStatus.valueOf(status);
		final List<CandidateStatus> statuses = getAvailableStatus(statusEnum);
		final List<String> statusStringList = new ArrayList<String>();
		for (CandidateStatus c : statuses) {
			statusStringList.add(c.toString());
		}
		return statusStringList;
	}

	/**
	 * Recursive check and return List of SAME CANDIDATE STATUS
	 * 
	 * @param statuses
	 * @param retainList
	 * @param index
	 * @return
	 */
	public static List<CandidateStatus> getSameAvailableStatusesForStatuses(
			List<CandidateStatus> statuses, List<CandidateStatus> retainList,
			int index) {
		if (index == 0) {
			return statuses.get(index).getAvailableStatus();
		}

		if (index == 1) {
			List<CandidateStatus> result = new ArrayList<CandidateStatus>(
					statuses.get(0).getAvailableStatus());
			// check in case there are only 2 statuses -> retain the first & the
			// second status
			result.retainAll(retainList != null ? retainList : statuses.get(1)
					.getAvailableStatus());
			return result;
		}

		// for the first time temp = list of first available statuses element
		// otherwise temp = the retainment list from last retaining
		List<CandidateStatus> temp = index != statuses.size() - 1 ? new ArrayList<CandidateStatus>(
				retainList) : new ArrayList<CandidateStatus>(statuses
				.get(index).getAvailableStatus());
		temp.retainAll(statuses.get(index - 1).getAvailableStatus());
		index--;
		return getSameAvailableStatusesForStatuses(statuses, temp, index);
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	/**
	 * 
	 * @return localized key of current status
	 */
	public String getLocalizedName() {
		return "candidate.status." + this;
	}

	/**
	 * Get css class name of current candidate status
	 * 
	 * @return css class name
	 */
	public String getCssClass() {
		return getCssClass(this);
	}

	/**
	 * Get css class name of given candidate status
	 * 
	 * @param status
	 * @return css class name
	 */
	public static String getCssClass(CandidateStatus status) {
		switch (status) {
		case APPLICATION_INITIATED:
			return "status-grey";
		case SHORTLIST:
		case INTERVIEW_SCHEDULED:
			return "status-yellow";
		case MARK_INTERVIEW_PASS:
		case JOB_OFFERED:
		case HIRE:
			return "status-green";
		case MARK_INTERVIEW_FAIL:
		case DECLINE_OFFERED:
		case REJECT:
			return "status-red";
		default:
			return StringUtils.EMPTY;
		}
	}

}
