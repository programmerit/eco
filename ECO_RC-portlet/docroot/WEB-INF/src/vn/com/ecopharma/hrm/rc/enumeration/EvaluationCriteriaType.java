package vn.com.ecopharma.hrm.rc.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum EvaluationCriteriaType {
	EDUCATION, EXPERIENCE;

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (EvaluationCriteriaType type : values()) {
			result.add(type.toString());
		}
		return result;
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "candidate.evaluationType." + this.toString();
	}

}
