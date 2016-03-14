package vn.com.ecopharma.hrm.rc.constant;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class EmpField {

	private static final Log LOGGER = LogFactoryUtil.getLog(EmpField.class);

	public static final String EMP_ID = "empId";

	public static final String EMP_CODE = "empCode";

	public static final String FULL_NAME = "fullName";

	public static final String VN_FULL_NAME = "fullNameVi";

	public static final String CONTACT_NUMBER = "contactNumber";

	public static final String BIRTHDAY = "birthday";

	public static final String ETHNIC = "ethnic";

	public static final String NATIONALITY = "nationality";

	public static final String RELIGION = "religion";

	public static final String PASSPORT = "birthday";

	public static final String JOINED_DATE = "joinedDate";

	public static final String UNIT = "unit";

	public static final String DEPARTMENT = "department";

	public static final String DEVISION = "devision";

	public static final String UNIT_GROUP = "unitGroup";

	public static final String TITLES = "titles";

	public static final String LEVEL = "level";

	public static final String PROMOTED_DATE = "promotedDate";

	public static final String LABOR_CONTRACT_SIGNED_DATE = "laborContractSignedDate";

	public static final String LABOR_CONTRACT_EXPIRED_DATE = "laborContractExpiredDate";

	public static final String LABOR_CONTRACT_TYPE = "laborContractType";

	public static final String LABOR_CONTRACT_SIGNED_TIME = "laborContractSignedTime";

	public static final String GENDER = "gender";

	public static final String PLACE_OF_BIRTH = "placeOfBirth";

	public static final String EDUCATION = "education";

	public static final String EDUCATION_SPECIALIZE = "educationSpecialize";

	public static final String SPECIALIZED = "specialized";

	public static final String UNIVERSITY = "university";

	public static final String MARITAL_STATUS = "maritalStatus";

	public static final String IDENTITY_CARD_NO = "identityCardNo";

	public static final String ISSUED_DATE = "issuedDate";

	public static final String ISSUED_PLACE = "issuedPlace";

	public static final String ADDRESS = "address";

	public static final String CITY = "city";

	public static final String EMAIL = "emailAddress";

	public static final String PERSONAL_EMAIL_ADDRESS = "personalEmailAddress";

	public static final String TAX_CODE = "personalTaxCode";

	public static final String NUMBER_OF_DEPENDENTS = "numberOfDependents";

	public static final String DEPENDENT_NAMES = "dependentNames";

	public static final String SOCIAL_INSURANCE_NO = "socialInsuranceNo";

	public static final String HEALTH_INSURANCE_NO = "healthInsuranceNo";

	public static final String BANK_ACCOUNT_NO = "bankAccountNo";

	public static final String BANK_BRANCH_NAME = "bankBranchName";

	public static final String BASE_WAGE_RATES = "baseWageRates";

	public static final String POSITION_WAGE_RATES = "positionWageRates";

	public static final String CAPACITY_SALARY = "capacitySalary";

	public static final String TOTAL_SALARY = "totalSalary";

	public static final String BONUS = "bonus";

	public static final String STATUS = "empStatus";

	public static final String RESIGNED_DATE = "resignedDate";

	public static final String EMPLOYEE_USER_ID = "empUserId";

	public static final String IS_DELETED = "isDeleted";

	public static final String DEVISION_ID = "devisionId";

	public static final String TITLES_ID = "titlesId";

	public static final String UNITGROUP_ID = "unitGroupId";

	public static final String UNIT_ID = "unitId";

	public static final String DEPARTMENT_ID = "departmentId";

	public static final String LEVEL_ID = "levelId";

	public static final String UNIVERSITY_ID = "universityId";

	// For filter only
	public static final String JOINED_DATE_FROM = "joinedDateFrom";
	public static final String JOINED_DATE_TO = "joinedDateTo";

	private EmpField() {
	}

	public static List<String> defaultExportFields() {
		return Arrays.asList(EMP_CODE, VN_FULL_NAME, TITLES, DEPARTMENT,
				JOINED_DATE, LABOR_CONTRACT_SIGNED_DATE);
	}

	public static List<String> getAllFields() {
		Field[] fields = EmpField.class.getFields();
		List<String> results = new ArrayList<>();
		Object objectValue;
		try {
			objectValue = EmpField.class.newInstance();
			for (int i = 0; i < fields.length; i++) {
				results.add((String) fields[i].get(objectValue));
			}
			return results;
		} catch (InstantiationException e) {
			LOGGER.info(e);
		} catch (IllegalAccessException e) {
			LOGGER.info(e);
		}
		return results;
	}
}
