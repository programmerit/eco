package vn.com.ecopharma.hrm.rc.enumeration.navigation;

public enum CandidateNavigation {

	VIEW("/views/pages/candidateView.xhtml"), //
	EDIT("/views/pages/modifyCandidate.xhtml"), //
	CREATE("/views/pages/modifyCandidate.xhtml"), //
	SCHEDULE_INTERVIEW("/views/pages/scheduleInterviewForCandidates.xhtml"), //
	TRANSFER_TO_EMP("/views/pages/employee.xhtml");

	private String outCome;

	private CandidateNavigation(String outCome) {
		this.outCome = outCome;
	}

	public String getOutCome() {
		return outCome;
	}

	public void setOutCome(String outCome) {
		this.outCome = outCome;
	}

}
