package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.constant.EmpField;

import com.liferay.portal.kernel.search.Document;

public class EmpIndexedItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SOURCE_DATETIME_FORMAT = "yyyyMMddhhmmss";
	private static final String DESTINATION_DATETIME_FORMAT = "dd/MM/yyyy";

	private Document employeeDocument;

	public EmpIndexedItem(Document employeeDocument) {
		this.employeeDocument = employeeDocument;
	}

	public Document getEmployeeDocument() {
		return employeeDocument;
	}

	public void setEmployeeDocument(Document employeeDocument) {
		this.employeeDocument = employeeDocument;
	}

	public String getJoinedDateString() {
		try {
			SimpleDateFormat srcSdf = new SimpleDateFormat(
					SOURCE_DATETIME_FORMAT);
			SimpleDateFormat desSdf = new SimpleDateFormat(
					DESTINATION_DATETIME_FORMAT);

			return employeeDocument.getField(EmpField.JOINED_DATE) != null ? desSdf
					.format(srcSdf.parse(employeeDocument.getField(
							EmpField.JOINED_DATE).getValue()))
					: StringUtils.EMPTY;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}

	public Date getJoinedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return sdf.parse(employeeDocument.getField(EmpField.JOINED_DATE)
					.getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** GETTER & SETTER **/

	public long getEmployeeId() {
		return Long.valueOf(this.employeeDocument.getField(EmpField.EMP_ID)
				.getValue());
	}

	public String getEmployeeCode() {
		return employeeDocument.getField(EmpField.EMP_CODE) != null ? employeeDocument
				.getField(EmpField.EMP_CODE).getValue() : StringUtils.EMPTY;
	}

	public String getFullName() {
		return employeeDocument.getField(EmpField.FULL_NAME).getValue();
	}

	public String getContactNumber() {
		return employeeDocument.getField(EmpField.CONTACT_NUMBER) != null ? employeeDocument
				.getField(EmpField.CONTACT_NUMBER).getValue()
				: StringUtils.EMPTY;
	}

	public Date getBirthday() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmpField.BIRTHDAY) != null ? sdf
					.parse(employeeDocument.getField(EmpField.BIRTHDAY)
							.getValue()) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getBirthdayString() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				DESTINATION_DATETIME_FORMAT);
		return getBirthday() != null ? sdf.format(getBirthday())
				: StringUtils.EMPTY;
	}

	public long getDevisionId() {
		return Long.valueOf(employeeDocument.getField(EmpField.DEVISION_ID)
				.getValue());
	}

	public long getTitlesId() {
		return Long.valueOf(employeeDocument.getField(EmpField.TITLES_ID)
				.getValue());
	}

	public long getLevelId() {
		return Long.valueOf(employeeDocument.getField(EmpField.LEVEL_ID)
				.getValue());
	}

	public long getUniversityId() {
		return Long.valueOf(employeeDocument.getField(EmpField.UNIVERSITY_ID)
				.getValue());
	}

	public String getUnit() {
		return employeeDocument.getField(EmpField.UNIT) != null ? employeeDocument
				.getField(EmpField.UNIT).getValue() : StringUtils.EMPTY;
	}

	public String getDepartment() {
		return employeeDocument.getField(EmpField.DEPARTMENT) != null ? employeeDocument
				.getField(EmpField.DEPARTMENT).getValue() : StringUtils.EMPTY;
	}

	public String getDevision() {
		return employeeDocument.getField(EmpField.DEVISION) != null ? employeeDocument
				.getField(EmpField.DEVISION).getValue() : StringUtils.EMPTY;
	}

	public String getUnitGroup() {
		return employeeDocument.getField(EmpField.UNIT_GROUP) != null ? employeeDocument
				.getField(EmpField.UNIT_GROUP).getValue() : StringUtils.EMPTY;
	}

	public String getTitles() {
		return employeeDocument.getField(EmpField.TITLES).getValue();
	}

	public String getLevel() {
		return employeeDocument.getField(EmpField.LEVEL) != null ? employeeDocument
				.getField(EmpField.LEVEL).getValue() : StringUtils.EMPTY;
	}

	public String getUniversity() {
		return employeeDocument.getField(EmpField.UNIVERSITY).getValue();
	}

	public Date getPromotedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmpField.PROMOTED_DATE) != null ? sdf
					.parse(employeeDocument.getField(EmpField.PROMOTED_DATE)
							.getValue()) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getPromotedDateString() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				DESTINATION_DATETIME_FORMAT);

		return getPromotedDate() != null ? sdf.format(getPromotedDate())
				: StringUtils.EMPTY;
	}

	public Date getLaborContractSignedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			if (employeeDocument.getField(EmpField.LABOR_CONTRACT_SIGNED_DATE) != null)
				return sdf.parse(employeeDocument.getField(
						EmpField.LABOR_CONTRACT_SIGNED_DATE).getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getLaborContractSignedDateString() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				DESTINATION_DATETIME_FORMAT);

		return getLaborContractSignedDate() != null ? sdf
				.format(getLaborContractSignedDate()) : StringUtils.EMPTY;
	}

	public Date getLaborContractExpiredDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			if (employeeDocument.getField(EmpField.LABOR_CONTRACT_EXPIRED_DATE) != null)
				return sdf.parse(employeeDocument.getField(
						EmpField.LABOR_CONTRACT_EXPIRED_DATE).getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getLaborContractExpiredDateString() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				DESTINATION_DATETIME_FORMAT);

		return getLaborContractExpiredDate() != null ? sdf
				.format(getLaborContractExpiredDate()) : StringUtils.EMPTY;
	}

	public String getLaborContractType() {
		return checkNullFieldAndReturnEMPTY(EmpField.LABOR_CONTRACT_TYPE);
	}

	public String getGender() {
		return checkNullFieldAndReturnEMPTY(EmpField.GENDER);
	}

	public String getPlaceOfBirth() {
		return checkNullFieldAndReturnEMPTY(EmpField.PLACE_OF_BIRTH);
	}

	public String getEducation() {
		return checkNullFieldAndReturnEMPTY(EmpField.EDUCATION);
	}

	public String getEducationSpecialize() {
		return checkNullFieldAndReturnEMPTY(EmpField.EDUCATION_SPECIALIZE);
	}

	public String getMaritalStatus() {
		return checkNullFieldAndReturnEMPTY(EmpField.MARITAL_STATUS);
	}

	public String getIdentityCardNo() {
		return checkNullFieldAndReturnEMPTY(EmpField.IDENTITY_CARD_NO);
	}

	public Date getIssuedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmpField.ISSUED_DATE) != null ? sdf
					.parse(employeeDocument.getField(EmpField.ISSUED_DATE)
							.getValue()) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getIssuedPlace() {
		return checkNullFieldAndReturnEMPTY(EmpField.ISSUED_PLACE);
	}

	public String getCompanyEmail() {
		return checkNullFieldAndReturnEMPTY(EmpField.COMPANY_EMAIL_ADDRESS);
	}

	public String getPersonalTaxCode() {
		return checkNullFieldAndReturnEMPTY(EmpField.TAX_CODE);
	}

	public int getNumberOfDependents() {
		return Integer.valueOf(employeeDocument.getField(
				EmpField.NUMBER_OF_DEPENDENTS).getValue());
	}

	public String getDependentNames() {
		return checkNullFieldAndReturnEMPTY(EmpField.DEPENDENT_NAMES);
	}

	public String getSocialInsuranceNo() {
		return checkNullFieldAndReturnEMPTY(EmpField.SOCIAL_INSURANCE_NO);
	}

	public String getHealthInsuranceNo() {
		return checkNullFieldAndReturnEMPTY(EmpField.HEALTH_INSURANCE_NO);
	}

	public String getBankAccountNo() {
		return checkNullFieldAndReturnEMPTY(EmpField.BANK_ACCOUNT_NO);
	}

	public String getBankBranchName() {
		return checkNullFieldAndReturnEMPTY(EmpField.BANK_BRANCH_NAME);
	}

	public double getBaseWageRates() {
		return Double.valueOf(employeeDocument.getField(
				EmpField.BASE_WAGE_RATES).getValue());
	}

	public double getPositionWageRates() {
		return Double.valueOf(employeeDocument.getField(
				EmpField.POSITION_WAGE_RATES).getValue());
	}

	public double getCapacitySalary() {
		return Double.valueOf(employeeDocument.getField(
				EmpField.CAPACITY_SALARY).getValue());
	}

	public double getTotalSalary() {
		return Double.valueOf(employeeDocument.getField(EmpField.TOTAL_SALARY)
				.getValue());
	}

	public double getBonus() {
		return Double.valueOf(employeeDocument.getField(EmpField.BONUS)
				.getValue());
	}

	public Date getResignedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmpField.RESIGNED_DATE) != null ? sdf
					.parse(employeeDocument.getField(EmpField.RESIGNED_DATE)
							.getValue()) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getStatus() {
		return employeeDocument.getField(EmpField.STATUS).getValue();
	}

	public long getEmployeeUserId() {
		return Long.valueOf(employeeDocument
				.getField(EmpField.EMPLOYEE_USER_ID).getValue());
	}

	public boolean isDeleted() {
		return Boolean.valueOf(employeeDocument.getField(EmpField.IS_DELETED)
				.getValue());
	}

	public String getCompanyEmailAddress() {
		return checkNullFieldAndReturnEMPTY(EmpField.COMPANY_EMAIL_ADDRESS);
	}

	private String checkNullFieldAndReturnEMPTY(String EmpField) {
		return employeeDocument.getField(EmpField) != null ? employeeDocument
				.getField(EmpField).getValue() : StringUtils.EMPTY;
	}

	// public String getStatusCss() {
	// return EmployeeStatus.getCssClass(EmployeeStatus.valueOf(getStatus()));
	// }
	//
	// public String getStatusLocalized() {
	// return EmployeeStatus.valueOf(getStatus()).getLocalizedString();
	// }

	public String getUnitName() {
		return employeeDocument.getField(EmpField.UNIT) != null ? employeeDocument
				.getField(EmpField.UNIT).getValue() : StringUtils.EMPTY;
	}

}
