package vn.com.ecopharma.hrm.rc.enumeration;

public enum CandidateHistoryActionType {

	CHANGE_STATUS, EDIT, CREATE, DELETE;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "candidate.candidateHistoryActionType." + this.toString();
	}

}
