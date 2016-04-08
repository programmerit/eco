package vn.com.ecopharma.rc.client.enumeration;

import java.util.ArrayList;
import java.util.List;

public enum DocumentType {

	CANDIDATE_CV, JOB_DESC, // candidate & vacancy
	LABOR_CONTRACT, DECISION, OTHER; // employee

	public static List<String> getAll() {
		final List<String> result = new ArrayList<>();
		for (DocumentType documentType : values()) {
			result.add(documentType.toString());
		}
		return result;
	}

	public String getLocalizedString() {
		return "documentType." + this.toString();
	}

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

}
