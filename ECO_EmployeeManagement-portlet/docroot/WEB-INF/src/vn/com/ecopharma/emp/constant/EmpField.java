package vn.com.ecopharma.emp.constant;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class EmpField {

	public static final String EMP_ID = "empId";

	public static final String EMP_CODE = "empCode";

	public static final String FULL_NAME = "fullName";

	public static final String CONTACT_NUMBER = "contactNumber";

	public static final String BIRTHDAY = "birthday";

	public static final String ETHNIC = "birthday";

	public static final String NATIONALITY = "birthday";

	public static final String RELIGION = "birthday";

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

	public static final String GENDER = "gender";

	public static final String PLACE_OF_BIRTH = "placeOfBirth";

	public static final String EDUCATION = "education";

	public static final String EDUCATION_SPECIALIZE = "educationSpecialize";

	public static final String UNIVERSITY = "university";

	public static final String MARITAL_STATUS = "maritalStatus";

	public static final String IDENTITY_CARD_NO = "identityCardNo";

	public static final String ISSUED_DATE = "issuedDate";

	public static final String ISSUED_PLACE = "issuedPlace";

	public static final String ADDRESS = "address";

	public static final String EMAIL = "emailAddress";

	public static final String COMPANY_EMAIL_ADDRESS = "companyEmailAddress";

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

	public static final String STATUS = "status";

	public static final String RESIGNED_DATE = "resignedDate";

	public static final String EMPLOYEE_USER_ID = "empUserId";

	public static final String IS_DELETED = "isDeleted";

	public static final String DEVISION_ID = "devisionId";

	public static final String TITLES_ID = "titlesId";

	public static final String LEVEL_ID = "levelId";

	public static final String UNIVERSITY_ID = "universityId";

	public static List<String> getAllFields() {
		Field[] fields = EmpField.class.getFields();
		List<String> results = new ArrayList<String>();
		Object objectValue;
		try {
			objectValue = EmpField.class.newInstance();
			for (int i = 0; i < fields.length; i++) {
				// System.out.println((String) fields[i].get(objectValue));
				results.add((String) fields[i].get(objectValue));
			}
			return results;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
