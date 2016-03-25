package vn.com.ecopharma.hrm.rc.enumeration.navigation;

public enum VacancyNavigation {
	VIEW("/views/pages/vacancyView.xhtml"), //
	CREATE("/views/pages/modifyVacancy.xhtml"), //
	EDIT("/views/pages/modifyVacancy.xhtml"); //

	private String outCome;

	private VacancyNavigation(String outCome) {
		this.outCome = outCome;
	}

	public String getOutCome() {
		return outCome;
	}

	public void setOutCome(String outCome) {
		this.outCome = outCome;
	}
}
