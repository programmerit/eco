package vn.com.ecopharma.rc.client.enumeration;

public enum VacancyCandidateType {

	MAIN, OPTIONAL;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

}
