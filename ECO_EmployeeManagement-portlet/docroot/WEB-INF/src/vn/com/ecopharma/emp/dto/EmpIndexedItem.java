package vn.com.ecopharma.emp.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EmpAdditionalFieds;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

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

	public String getStatusCss() {
		return !getStatus().equals(StringUtils.EMPTY) ? EmployeeStatus
				.getCssClass(EmployeeStatus.valueOf(getStatus()))
				: StringUtils.EMPTY;
	}

	public String getStatusLocalized() {
		return !getStatus().equals(StringUtils.EMPTY) ? EmployeeStatus
				.getIndexedActualEnum(getStatus()).getLocalizedString()
				: StringUtils.EMPTY;
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

	public String getPresentAddress() {
		if (getAddresses().isEmpty())
			return StringUtils.EMPTY;
		return ImportExportUtils.getAddressStringFromAddressObj(getAddresses()
				.get(0));
	}

	public String getTempAddress() {
		if (getAddresses().size() < 2)
			return StringUtils.EMPTY;
		return ImportExportUtils.getAddressStringFromAddressObj(getAddresses()
				.get(1));

	}

	public List<BankInfoObject> getBankInfos() {
		return EmployeeUtils.getBankInfoObjectsFromEmp(getId());
	}

	public String getBankNo1() {
		return ImportExportUtils.getBankNoCellInfo(0, getBankInfos());
	}

	public String getBankNo2() {
		return ImportExportUtils.getBankNoCellInfo(1, getBankInfos());
	}

	public String getBankNo3() {
		return ImportExportUtils.getBankNoCellInfo(2, getBankInfos());
	}

	public String getBankName1() {
		return ImportExportUtils.getBankNameCellInfo(0, getBankInfos());
	}

	public String getBankName2() {
		return ImportExportUtils.getBankNameCellInfo(1, getBankInfos());
	}

	public String getBankName3() {
		return ImportExportUtils.getBankNameCellInfo(2, getBankInfos());
	}

	public String getBankBranch1() {
		return ImportExportUtils.getBankBranchCellInfo(0, getBankInfos());
	}

	public String getBankBranch2() {
		return ImportExportUtils.getBankBranchCellInfo(1, getBankInfos());
	}

	public String getBankBranch3() {
		return ImportExportUtils.getBankBranchCellInfo(2, getBankInfos());
	}

	@Override
	protected String getIdFieldName() {
		return EmpField.EMP_ID;
	}

	public Map<String, Object> getItemKeyValueMap(boolean bankField,
			boolean addressField) {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(EmpField.EMP_CODE, getEmployeeCode());
		result.put(EmpField.VN_FULL_NAME, getFullNameVi());
		result.put(EmpField.TITLES, getTitles());
		result.put(EmpField.LEVEL, getLevel());
		result.put(EmpField.PROMOTED_DATE, getPromotedDateString());
		result.put(EmpField.UNIT_GROUP, getUnitGroup());
		result.put(EmpField.UNIT, getUnit());
		result.put(EmpField.DEPARTMENT, getDepartment());
		result.put(EmpField.DEVISION, getDevision());
		result.put(EmpField.JOINED_DATE, getJoinedDateString());
		result.put(EmpField.LABOR_CONTRACT_SIGNED_DATE,
				getLaborContractSignedDateString());
		result.put(EmpField.LABOR_CONTRACT_EXPIRED_DATE,
				getLaborContractExpiredDateString());
		result.put(EmpField.LABOR_CONTRACT_TYPE, getLaborContractType());
		result.put(EmpField.LABOR_CONTRACT_SIGNED_TIME, getLaborContractTime());
		result.put(EmpField.BIRTHDAY, getBirthdayString());
		result.put(EmpField.GENDER, getGender());
		result.put(EmpField.PLACE_OF_BIRTH, getPlaceOfBirth());
		result.put(EmpField.EDUCATION, getEducation());
		result.put(EmpField.SPECIALIZED, getEducationSpecialize());
		result.put(EmpField.UNIVERSITY, getUniversity());
		result.put(EmpField.MARITAL_STATUS, getMaritalStatus());
		result.put(EmpField.IDENTITY_CARD_NO, getIdentityCardNo());
		result.put(EmpField.ISSUED_DATE, getIssuedDateString());
		result.put(EmpField.ISSUED_PLACE, getIssuedPlace());
		if (addressField) {
			result.put(EmpAdditionalFieds.PRESENT_ADDRESS, getPresentAddress());
			result.put(EmpAdditionalFieds.TEMP_ADDRESS, getTempAddress());
		}
		result.put(EmpField.CONTACT_NUMBER, getContactNumber());
		result.put(EmpField.PERSONAL_EMAIL_ADDRESS, getPersonalEmail());
		result.put(EmpField.EMAIL, getEmail());
		result.put(EmpField.TAX_CODE, getPersonalTaxCode());
		result.put(EmpField.NUMBER_OF_DEPENDENTS, getNumberOfDependents());
		result.put(EmpField.DEPENDENT_NAMES, getDependentNames());
		result.put(EmpField.SOCIAL_INSURANCE_NO, getSocialInsuranceNo());
		result.put(EmpField.HEALTH_INSURANCE_NO, getHealthInsuranceNo());

		if (bankField) {
			result.put(EmpAdditionalFieds.BANK_ACCOUNT_NO1, getBankNo1());
			result.put(EmpAdditionalFieds.BANK_NAME1, getBankName1());
			result.put(EmpAdditionalFieds.BANK_BRANCH_NAME1, getBankBranch1());

			result.put(EmpAdditionalFieds.BANK_ACCOUNT_NO2, getBankNo2());
			result.put(EmpAdditionalFieds.BANK_NAME2, getBankName2());
			result.put(EmpAdditionalFieds.BANK_BRANCH_NAME2, getBankBranch2());

			result.put(EmpAdditionalFieds.BANK_ACCOUNT_NO3, getBankNo3());
			result.put(EmpAdditionalFieds.BANK_NAME3, getBankName3());
			result.put(EmpAdditionalFieds.BANK_BRANCH_NAME3, getBankBranch3());
		}

		result.put(EmpField.BASE_WAGE_RATES, 0);
		result.put(EmpField.POSITION_WAGE_RATES, 0);
		result.put(EmpField.CAPACITY_SALARY, 0);
		result.put(EmpField.TOTAL_SALARY, 0);
		result.put(EmpField.BONUS, 0);
		result.put(EmpField.RESIGNED_DATE, getResignedDateString());
		return result;
	}
}
