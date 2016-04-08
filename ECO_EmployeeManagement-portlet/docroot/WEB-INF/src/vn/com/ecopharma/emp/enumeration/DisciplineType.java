package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum DisciplineType {

	REPRIMAND, // khiển trách
	DEPRIVATION, // cách chức
	LAYOFFS, // sa thải
	PROLONGATION_OF_WAGE_INCREASE, // kéo dài thời hạn tăng lương
	NONE;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "employee.discipline." + this.name();
	}

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (DisciplineType type : values())
			result.add(type.toString());
		return result;
	}
}
