package vn.com.ecopharma.hrm.rc.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum CertificateType {

	HIGH_SCHOOL, VOCATIONAL, COLLEGE, UNIVERSITY, MASTER, DOCTOR;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "candidate.certificateType." + this.name();
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<String>();
		for (CertificateType o : values()) {
			result.add(o.toString());
		}
		return result;
	}

	public static double getCertificateEvaluationPoint(CertificateType requirement,
			CertificateType check) {
		if (check.equals(requirement))
			return 4;

		switch (requirement) {
		case UNIVERSITY:
			switch (check) {
			case MASTER:
			case DOCTOR:
				return 5;
			case UNIVERSITY:
				return 4;
			case COLLEGE:
				return 3;
			case VOCATIONAL:
				return 2;
			case HIGH_SCHOOL:
				return 1;
			default:
				return 0;
			}
		case COLLEGE:
			switch (check) {
			case MASTER:
			case DOCTOR:
			case UNIVERSITY:
				return 5;
			case COLLEGE:
				return 4;
			case VOCATIONAL:
				return 3;
			case HIGH_SCHOOL:
				return 2;
			default:
				return 0;
			}
		case VOCATIONAL:
			switch (check) {
			case MASTER:
			case DOCTOR:
			case UNIVERSITY:
			case COLLEGE:
				return 5;
			case VOCATIONAL:
				return 4;
			case HIGH_SCHOOL:
				return 3;
			default:
				return 0;
			}
		case HIGH_SCHOOL:
			switch (check) {
			case MASTER:
			case DOCTOR:
			case UNIVERSITY:
			case COLLEGE:
			case VOCATIONAL:
				return 5;
			case HIGH_SCHOOL:
				return 4;
			default:
				return 0;
			}
		case DOCTOR:
		case MASTER:
			return 0;
		}

		return 0;
	}

}
