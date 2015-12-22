package vn.com.ecopharma.emp.enumeration;

import org.apache.commons.lang3.StringUtils;

public enum LaborContractType {

	DEFINITE_TERMS, DEFINITE_TERMS_12_MONTHS, INDEFINITE_TERMS, SEASONAL_EMPLOYMENT_CONTRACT, PROBATION_CONTRACT, COLLABORATOR, NONE;

	@Override
	public String toString() {
		return this.name().toUpperCase();
	}

	public String getLocalizedString() {
		return "employeeInfo.labor_contract_type." + this.name().toUpperCase();
	}

	public static LaborContractType convertFromVNeseToLaborContractType(
			String VNeseString) {
		String trimedString = StringUtils.trimToEmpty(VNeseString);
		if (trimedString.equals(StringUtils.EMPTY)) {
			return NONE;
		}
		if (trimedString.equalsIgnoreCase("Không xác định")
				|| trimedString
						.equalsIgnoreCase("HĐLĐ không xác định thời hạn")) {
			return INDEFINITE_TERMS;
		}

		if (trimedString.equalsIgnoreCase("HĐLĐ xác định thời hạn")) {
			return DEFINITE_TERMS;
		}

		if (trimedString.equalsIgnoreCase("12 tháng")) {
			return DEFINITE_TERMS_12_MONTHS;
		}

		if (trimedString.equalsIgnoreCase("HĐLĐ thời vụ")
				|| trimedString.equalsIgnoreCase("thời vụ")) {
			return SEASONAL_EMPLOYMENT_CONTRACT;
		}

		if (trimedString.equalsIgnoreCase("HĐ thử việc")
				|| trimedString.equalsIgnoreCase("thử việc")) {
			return PROBATION_CONTRACT;
		}

		if (trimedString.equalsIgnoreCase("Cộng tác viên")) {
			return COLLABORATOR;
		}

		return NONE;
	}

	public String getVietnameseString() {
		switch (this) {
		case NONE:
			return StringUtils.EMPTY;
		case INDEFINITE_TERMS:
			return "HĐLĐ không xác định thời hạn";
		case DEFINITE_TERMS:
			return "HĐLĐ xác định thời hạn";
		case DEFINITE_TERMS_12_MONTHS:
			return "12 tháng";
		case SEASONAL_EMPLOYMENT_CONTRACT:
			return "HĐLĐ thời vụ";
		case PROBATION_CONTRACT:
			return "HĐ thử việc";
		case COLLABORATOR:
			return "Cộng tác viên";
		default:
			return StringUtils.EMPTY;
		}
	}

}
