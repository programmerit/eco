package vn.com.ecopharma.emp.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum DocumentType {

	LABOR_CONTRACT, DECISION, OTHER;

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (DocumentType type : values())
			result.add(type.toString());
		return result;
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "documentType." + this.toString();
	}

}
