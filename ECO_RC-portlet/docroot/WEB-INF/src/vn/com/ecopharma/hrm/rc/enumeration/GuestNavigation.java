package vn.com.ecopharma.hrm.rc.enumeration;

public enum GuestNavigation {

	GUEST_ADD("/views/pages/candidateGuest.xhtml"), //
	SUCCESS_ADD("/views/pages/candidateGuestSavedSuccess.xhtml"), //
	FAIL_ADD("/views/pages/candidateGuest.xhtml");

	private String outCome;

	private GuestNavigation(String outCome) {
		this.outCome = outCome;
	}

	public String getOutCome() {
		return outCome;
	}

	public void setOutCome(String outCome) {
		this.outCome = outCome;
	}

}
