package vn.com.ecopharma.rc.client.enumeration.navigation;

public enum GuestNavigation {

	GUEST_ADD("/views/candidateGuest.xhtml"), //
	SUCCESS_ADD("/views/candidateGuestSavedSuccess.xhtml"), //
	FAIL_ADD("/views/vacancyView.xhtml");

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
