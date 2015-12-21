package vn.com.ecopharma.hrm.rc.enumeration;

public enum EvaluationCriteriaType {
	EDUCATION, EXPERIENCE;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "candidate.evaluationType." + this.toString();
	}

}
