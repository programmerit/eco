package vn.com.ecopharma.hrm.rc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.hrm.rc.constant.EmpField;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.model.Address;
import com.liferay.portal.service.AddressLocalServiceUtil;

public class EmpIndexedItem extends BaseEmpInfoIndexedItem {

	private static final long serialVersionUID = 1L;

	public EmpIndexedItem(Document document) {
		super(document);
	}

	public String getJoinedDateString() {
		return getParseDateString(getJoinedDate());
	}

	public Date getJoinedDate() {
		return checkNullFieldAndReturnNullDate(EmpField.JOINED_DATE);
	}

	/** GETTER & SETTER **/

	public String getContactNumber() {
		return checkNullFieldAndReturnEmptyString(EmpField.CONTACT_NUMBER);
	}

	public Date getBirthday() {
		return checkNullFieldAndReturnNullDate(EmpField.BIRTHDAY);
	}

	public String getBirthdayString() {
		return getParseDateString(getBirthday());
	}

	public long getUniversityId() {
		return checkNullFieldAndReturnLongValue(EmpField.UNIVERSITY_ID);
	}

	public String getUniversity() {
		return checkNullFieldAndReturnEmptyString(EmpField.UNIVERSITY);
	}

	public Date getPromotedDate() {
		return checkNullFieldAndReturnNullDate(EmpField.PROMOTED_DATE);
	}

	public String getPromotedDateString() {
		return getParseDateString(getPromotedDate());
	}

	public Date getLaborContractSignedDate() {
		return checkNullFieldAndReturnNullDate(EmpField.LABOR_CONTRACT_SIGNED_DATE);
	}

	public String getLaborContractSignedDateString() {
		return getParseDateString(getLaborContractSignedDate());
	}

	public Date getLaborContractExpiredDate() {
		return checkNullFieldAndReturnNullDate(EmpField.LABOR_CONTRACT_EXPIRED_DATE);
	}

	public String getLaborContractExpiredDateString() {
		return getParseDateString(getLaborContractExpiredDate());
	}

	public String getLaborContractType() {
		return checkNullFieldAndReturnEmptyString(EmpField.LABOR_CONTRACT_TYPE);
	}

	public String getLaborContractTime() {
		return checkNullFieldAndReturnEmptyString(EmpField.LABOR_CONTRACT_SIGNED_TIME);
	}

	public String getGender() {
		return checkNullFieldAndReturnEmptyString(EmpField.GENDER);
	}

	public String getPlaceOfBirth() {
		return checkNullFieldAndReturnEmptyString(EmpField.PLACE_OF_BIRTH);
	}

	public String getEducation() {
		return checkNullFieldAndReturnEmptyString(EmpField.EDUCATION);
	}

	public String getEducationSpecialize() {
		return checkNullFieldAndReturnEmptyString(EmpField.EDUCATION_SPECIALIZE);
	}

	public String getMaritalStatus() {
		return checkNullFieldAndReturnEmptyString(EmpField.MARITAL_STATUS);
	}

	public String getIdentityCardNo() {
		return checkNullFieldAndReturnEmptyString(EmpField.IDENTITY_CARD_NO);
	}

	public Date getIssuedDate() {
		return checkNullFieldAndReturnNullDate(EmpField.ISSUED_DATE);
	}

	public String getIssuedDateString() {
		return getParseDateString(getIssuedDate());
	}

	public String getIssuedPlace() {
		return checkNullFieldAndReturnEmptyString(EmpField.ISSUED_PLACE);
	}

	public String getPersonalEmail() {
		return checkNullFieldAndReturnEmptyString(EmpField.PERSONAL_EMAIL_ADDRESS);
	}

	public String getPersonalTaxCode() {
		return checkNullFieldAndReturnEmptyString(EmpField.TAX_CODE);
	}

	public int getNumberOfDependents() {
		return checkNullFieldAndReturnIntegerValue(EmpField.NUMBER_OF_DEPENDENTS);
	}

	public String getDependentNames() {
		return checkNullFieldAndReturnEmptyString(EmpField.DEPENDENT_NAMES);
	}

	public String getSocialInsuranceNo() {
		return checkNullFieldAndReturnEmptyString(EmpField.SOCIAL_INSURANCE_NO);
	}

	public String getHealthInsuranceNo() {
		return checkNullFieldAndReturnEmptyString(EmpField.HEALTH_INSURANCE_NO);
	}

	public String getBankAccountNo() {
		return checkNullFieldAndReturnEmptyString(EmpField.BANK_ACCOUNT_NO);
	}

	public String getBankBranchName() {
		return checkNullFieldAndReturnEmptyString(EmpField.BANK_BRANCH_NAME);
	}

	public double getBaseWageRates() {
		return checkNullFieldAndReturnDoubleValue(EmpField.BASE_WAGE_RATES);
	}

	public double getPositionWageRates() {
		return checkNullFieldAndReturnDoubleValue(EmpField.POSITION_WAGE_RATES);
	}

	public double getCapacitySalary() {
		return checkNullFieldAndReturnDoubleValue(EmpField.CAPACITY_SALARY);
	}

	public double getTotalSalary() {
		return checkNullFieldAndReturnDoubleValue(EmpField.TOTAL_SALARY);
	}

	public double getBonus() {
		return checkNullFieldAndReturnDoubleValue(EmpField.BONUS);
	}

	public Date getResignedDate() {
		return checkNullFieldAndReturnNullDate(EmpField.RESIGNED_DATE);
	}

	public String getResignedDateString() {
		return getParseDateString(getResignedDate());
	}

	public String getStatus() {
		return checkNullFieldAndReturnEmptyString(EmpField.STATUS);
	}

	public long getEmployeeUserId() {
		return checkNullFieldAndReturnLongValue(EmpField.EMPLOYEE_USER_ID);
	}

	public boolean isDeleted() {
		return Boolean.valueOf(getDocument().getField(EmpField.IS_DELETED)
				.getValue());
	}

	public String getPersonalEmailAddress() {
		return checkNullFieldAndReturnEmptyString(EmpField.PERSONAL_EMAIL_ADDRESS);
	}
	
	public List<Address> getAddresses() {
		try {
			return AddressLocalServiceUtil.getAddresses(EmployeeUtils
					.getServiceContext().getCompanyId(), Emp.class.getName(),
					getId());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	protected String getIdFieldName() {
		return EmpField.EMP_ID;
	}
}
