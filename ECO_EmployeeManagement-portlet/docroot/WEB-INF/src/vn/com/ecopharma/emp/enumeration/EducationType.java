package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum EducationType {

	SECONDARY, HIGH_SCHOOL, VOCATIONAL, COLLEGE, UNIVERSITY, MASTER, DOCTOR, NONE;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "employee.educationtype." + this.name();
	}

	public String getViValue() {
		switch (this) {
		case SECONDARY:
			return "PTCS";
		case HIGH_SCHOOL:
			return "PTTH";
		case VOCATIONAL:
			return "Trung cấp";
		case COLLEGE:
			return "Cao đẳng";
		case UNIVERSITY:
			return "Đại học";
		case MASTER:
			return "Thạc sỹ";
		case DOCTOR:
			return "Tiến sĩ";
		default:
			return "None";
		}
	}

	public static EducationType getValueFromVi(String educationVi) {
		if (educationVi.equalsIgnoreCase("PTCS"))
			return SECONDARY;
		if (educationVi.equalsIgnoreCase("PTTH"))
			return HIGH_SCHOOL;
		if (educationVi.equalsIgnoreCase("Trung cấp"))
			return VOCATIONAL;
		if (educationVi.equalsIgnoreCase("Cao đẳng"))
			return COLLEGE;
		if (educationVi.equalsIgnoreCase("Đại học"))
			return UNIVERSITY;
		if (educationVi.equalsIgnoreCase("Thạc sỹ"))
			return MASTER;
		if (educationVi.equalsIgnoreCase("Tiến sỹ"))
			return DOCTOR;

		return NONE;
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (EducationType o : values()) {
			result.add(o.toString());
		}
		return result;
	}

	public static List<String> getAllVi() {
		final List<String> result = new ArrayList<>();
		for (EducationType o : values())
			result.add(o.getViValue());
		return result;
	}
}
