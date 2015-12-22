package vn.com.ecopharma.hrm.rc.enumeration;

public enum VacancyCandidateType {

	MAIN, OPTIONAL;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

}
