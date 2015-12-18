package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EmployeeField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;

import com.liferay.portal.kernel.search.Document;

public class EmployeeIndexedItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SOURCE_DATETIME_FORMAT = "yyyyMMddhhmmss";
	private static final String DESTINATION_DATETIME_FORMAT = "dd/MM/yyyy";

	private Document employeeDocument;

	public EmployeeIndexedItem(Document employeeDocument) {
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

			return employeeDocument.getField(EmployeeField.JOINED_DATE) != null ? desSdf
					.format(srcSdf.parse(employeeDocument.getField(
							EmployeeField.JOINED_DATE).getValue()))
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
			return sdf.parse(employeeDocument.getField(
					EmployeeField.JOINED_DATE).getValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/** GETTER & SETTER **/

	public long getEmployeeId() {
		return Long.valueOf(this.employeeDocument.getField(
				EmployeeField.EMPLOYEE_ID).getValue());
	}

	public String getEmployeeCode() {
		return employeeDocument.getField(EmployeeField.EMPLOYEE_CODE) != null ? employeeDocument
				.getField(EmployeeField.EMPLOYEE_CODE).getValue()
				: StringUtils.EMPTY;
	}

	public String getFullName() {
		return employeeDocument.getField(EmployeeField.FULL_NAME).getValue();
	}

	public String getContactNumber() {
		return employeeDocument.getField(EmployeeField.CONTACT_NUMBER) != null ? employeeDocument
				.getField(EmployeeField.CONTACT_NUMBER).getValue()
				: StringUtils.EMPTY;
	}

	public Date getBirthday() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmployeeField.BIRTHDAY) != null ? sdf
					.parse(employeeDocument.getField(EmployeeField.BIRTHDAY)
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
		return Long.valueOf(employeeDocument
				.getField(EmployeeField.DEVISION_ID).getValue());
	}

	public long getTitlesId() {
		return Long.valueOf(employeeDocument.getField(EmployeeField.TITLES_ID)
				.getValue());
	}

	public long getLevelId() {
		return Long.valueOf(employeeDocument.getField(EmployeeField.LEVEL_ID)
				.getValue());
	}

	public long getUniversityId() {
		return Long.valueOf(employeeDocument.getField(
				EmployeeField.UNIVERSITY_ID).getValue());
	}

	public String getUnit() {
		return employeeDocument.getField(EmployeeField.UNIT) != null ? employeeDocument
				.getField(EmployeeField.UNIT).getValue() : StringUtils.EMPTY;
	}

	public String getDepartment() {
		return employeeDocument.getField(EmployeeField.DEPARTMENT) != null ? employeeDocument
				.getField(EmployeeField.DEPARTMENT).getValue()
				: StringUtils.EMPTY;
	}

	public String getDevision() {
		return employeeDocument.getField(EmployeeField.DEVISION) != null ? employeeDocument
				.getField(EmployeeField.DEVISION).getValue()
				: StringUtils.EMPTY;
	}

	public String getUnitGroup() {
		return employeeDocument.getField(EmployeeField.UNIT_GROUP) != null ? employeeDocument
				.getField(EmployeeField.UNIT_GROUP).getValue()
				: StringUtils.EMPTY;
	}

	public String getTitles() {
		return employeeDocument.getField(EmployeeField.TITLES).getValue();
	}

	public String getLevel() {
		return employeeDocument.getField(EmployeeField.LEVEL) != null ? employeeDocument
				.getField(EmployeeField.LEVEL).getValue() : StringUtils.EMPTY;
	}

	public String getUniversity() {
		return employeeDocument.getField(EmployeeField.UNIVERSITY).getValue();
	}

	public Date getPromotedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmployeeField.PROMOTED_DATE) != null ? sdf
					.parse(employeeDocument.getField(
							EmployeeField.PROMOTED_DATE).getValue()) : null;
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
			if (employeeDocument
					.getField(EmployeeField.LABOR_CONTRACT_SIGNED_DATE) != null)
				return sdf.parse(employeeDocument.getField(
						EmployeeField.LABOR_CONTRACT_SIGNED_DATE).getValue());
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
			if (employeeDocument
					.getField(EmployeeField.LABOR_CONTRACT_EXPIRED_DATE) != null)
				return sdf.parse(employeeDocument.getField(
						EmployeeField.LABOR_CONTRACT_EXPIRED_DATE).getValue());
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
		return checkNullFieldAndReturnEMPTY(EmployeeField.LABOR_CONTRACT_TYPE);
	}

	public String getGender() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.GENDER);
	}

	public String getPlaceOfBirth() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.PLACE_OF_BIRTH);
	}

	public String getEducation() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.EDUCATION);
	}

	public String getEducationSpecialize() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.EDUCATION_SPECIALIZE);
	}

	public String getMaritalStatus() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.MARITAL_STATUS);
	}

	public String getIdentityCardNo() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.IDENTITY_CARD_NO);
	}

	public Date getIssuedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmployeeField.ISSUED_DATE) != null ? sdf
					.parse(employeeDocument.getField(EmployeeField.ISSUED_DATE)
							.getValue()) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getIssuedPlace() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.ISSUED_PLACE);
	}

	public String getCompanyEmail() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.COMPANY_EMAIL_ADDRESS);
	}

	public String getPersonalTaxCode() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.TAX_CODE);
	}

	public int getNumberOfDependents() {
		return Integer.valueOf(employeeDocument.getField(
				EmployeeField.NUMBER_OF_DEPENDENTS).getValue());
	}

	public String getDependentNames() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.DEPENDENT_NAMES);
	}

	public String getSocialInsuranceNo() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.SOCIAL_INSURANCE_NO);
	}

	public String getHealthInsuranceNo() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.HEALTH_INSURANCE_NO);
	}

	public String getBankAccountNo() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.BANK_ACCOUNT_NO);
	}

	public String getBankBranchName() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.BANK_BRANCH_NAME);
	}

	public double getBaseWageRates() {
		return Double.valueOf(employeeDocument.getField(
				EmployeeField.BASE_WAGE_RATES).getValue());
	}

	public double getPositionWageRates() {
		return Double.valueOf(employeeDocument.getField(
				EmployeeField.POSITION_WAGE_RATES).getValue());
	}

	public double getCapacitySalary() {
		return Double.valueOf(employeeDocument.getField(
				EmployeeField.CAPACITY_SALARY).getValue());
	}

	public double getTotalSalary() {
		return Double.valueOf(employeeDocument.getField(
				EmployeeField.TOTAL_SALARY).getValue());
	}

	public double getBonus() {
		return Double.valueOf(employeeDocument.getField(EmployeeField.BONUS)
				.getValue());
	}

	public Date getResignedDate() {
		final SimpleDateFormat sdf = new SimpleDateFormat(
				SOURCE_DATETIME_FORMAT);
		try {
			return employeeDocument.getField(EmployeeField.RESIGNED_DATE) != null ? sdf
					.parse(employeeDocument.getField(
							EmployeeField.RESIGNED_DATE).getValue()) : null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getStatus() {
		return employeeDocument.getField(EmployeeField.STATUS).getValue();
	}

	public long getEmployeeUserId() {
		return Long.valueOf(employeeDocument.getField(
				EmployeeField.EMPLOYEE_USER_ID).getValue());
	}

	public boolean isDeleted() {
		return Boolean.valueOf(employeeDocument.getField(
				EmployeeField.IS_DELETED).getValue());
	}

	public String getCompanyEmailAddress() {
		return checkNullFieldAndReturnEMPTY(EmployeeField.COMPANY_EMAIL_ADDRESS);
	}

	private String checkNullFieldAndReturnEMPTY(String employeeField) {
		return employeeDocument.getField(employeeField) != null ? employeeDocument
				.getField(employeeField).getValue() : StringUtils.EMPTY;
	}

	public String getStatusCss() {
		return EmployeeStatus.getCssClass(EmployeeStatus.valueOf(getStatus()));
	}

	public String getStatusLocalized() {
		return EmployeeStatus.valueOf(getStatus()).getLocalizedString();
	}

	public String getUnitName() {
		return employeeDocument.getField(EmployeeField.UNIT) != null ? employeeDocument
				.getField(EmployeeField.UNIT).getValue() : StringUtils.EMPTY;
	}

}
