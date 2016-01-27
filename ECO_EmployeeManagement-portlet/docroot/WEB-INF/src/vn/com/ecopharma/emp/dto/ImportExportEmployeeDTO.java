package vn.com.ecopharma.emp.dto;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Country;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;

public class ImportExportEmployeeDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(ImportExportEmployeeDTO.class);

	private static final String DATE_STRING_CELL_FORMAT = "dd/MM/yyyy";

	private static final int STRING_CELL_TYPE = 1;

	private static final String BLANK_UNIT = "(blank)";
	private static final String MALE_VNESE = "Nam";
	private static final String MALE = "Male";
	private static final String FEMALE = "Female";

	private int no = 0;
	private String employeeCode;
	private String fullname;
	private String firstName;
	private String middleName;
	private String lastName;
	private long titlesId;
	private long levelId;

	private Date promotedDate;

	private Date joinedDate;
	private Date laborContractSignedDate;
	private Date laborContractExpiredDate;

	private String laborContractType;
	private int laborContractSignedTime;

	private Date dob;

	private String gender;
	private String pob;
	private String education;
	private String educationSpecialize;
	private long specializedId = 0L;
	private long universityId = 0L;
	private String marritalStatus;
	private String identityCardNo;
	private Date issuedDate;

	private String issuedPlace;

	private String presentAddress;
	private String temporaryAddress;

	private String contactNumber;
	private String emailAddress;
	private String companyEmailAddress;
	private String taxCode;
	private int numberOfDependents;
	private String dependentNames;

	private String insurranceCode;
	private String healthInsurranceCode;
	private String bankNo1;
	private String bankName1;
	private String bankBranchName1;

	private String bankNo2;
	private String bankName2;
	private String bankBranchName2;

	private String bankNo3;
	private String bankName3;
	private String bankBranchName3;

	private Region presentRegion;

	private Region tempRegion;

	private ServiceContext serviceContext;

	private Unit unit;
	private UnitGroup unitGroup;
	private Department department;
	private Devision devision;
	private Titles titles;

	private String importFailedException;
	
	public ImportExportEmployeeDTO(XSSFRow r) {
		this.bindFieldsFromExcelRow(r);
	}

	private void bindFieldsFromExcelRow(XSSFRow r) {
		serviceContext = LiferayFacesContext.getInstance().getServiceContext();

		long devisionId = 0;
		long departmentId = 0;
		long unitId = 0;
		long unitGroupId = 0;
		// no = getConvertedIntegerCell(r.getCell(0));
		employeeCode = getCellValueAsString(r.getCell(1));
		fullname = getCellValueAsString(r.getCell(2));
		firstName = EmployeeUtils.getFirstName(fullname);
		middleName = EmployeeUtils.getMiddleName(fullname);
		lastName = EmployeeUtils.getLastName(fullname);

		LOGGER.info("============ " + fullname + " =============");

		String devisionName = getCellValueAsString(r.getCell(9));
		LOGGER.info("============ Checking devision =============");
		if (StringUtils.trimToNull(devisionName) != null) {
			this.devision = DevisionLocalServiceUtil.findByName(devisionName);
			if (this.devision == null) {
				// create new one
				LOGGER.info("============ Creating devision =============");
				this.devision = DevisionLocalServiceUtil.addDevision(
						devisionName, serviceContext);
			}
			devisionId = this.devision.getDevisionId();
		}

		String departmentName = getCellValueAsString(r.getCell(8));
		LOGGER.info("============ Checking department =============");
		if (!departmentName.equals(StringUtils.EMPTY) && devision != null) {
			this.department = DepartmentLocalServiceUtil.findByNameAndDevision(
					departmentName, devision.getDevisionId());
			if (this.department == null) {
				// create new one
				LOGGER.info("============ Creating department =============");
				this.department = DepartmentLocalServiceUtil.addDepartment(
						departmentName, devisionId, serviceContext);
			}
			departmentId = this.department.getDepartmentId();
		}

		String unitName = getCellValueAsString(r.getCell(7));
		LOGGER.info("============ Checking unit =============");
		if (StringUtils.trimToNull(unitName) != null
				&& !StringUtils.trim(unitName).equalsIgnoreCase(BLANK_UNIT)
				&& departmentId != 0) {
			this.unit = UnitLocalServiceUtil.findByNameAndDepartment(unitName,
					departmentId);
			if (this.unit == null) {
				// create new one
				LOGGER.info("============ Creating unit =============");

				this.unit = UnitLocalServiceUtil.addUnit(unitName,
						departmentId, serviceContext);
			}
			unitId = this.unit.getUnitId();
		}

		String unitGroupName = getCellValueAsString(r.getCell(6));
		LOGGER.info("============ Checking unitGroup =============");
		if (!unitGroupName.equals(StringUtils.EMPTY) && unit != null
				&& !StringUtils.trim(unitGroupName).equals(BLANK_UNIT)) {
			this.unitGroup = UnitGroupLocalServiceUtil.findByNameAndUnit(
					unitGroupName, unitId);
			if (this.unitGroup == null) {
				// create new one
				LOGGER.info("============ Creating unitGroup =============");
				this.unitGroup = UnitGroupLocalServiceUtil.addUnitGroup(
						unitGroupName, unitId, serviceContext);
			}
			unitGroupId = this.unitGroup.getUnitGroupId();
		}

		String titlesName = getCellValueAsString(r.getCell(3));
		LOGGER.info("============ Checking titles =============");
		if (!titlesName.equals(StringUtils.EMPTY)) {
			this.titles = TitlesLocalServiceUtil.findByName(titlesName);

			if (this.titles == null) {
				// create new
				LOGGER.info("============ Creating unit =============");
				this.titles = TitlesLocalServiceUtil.addTitles(titlesName,
						StringUtils.EMPTY, StringUtils.EMPTY, serviceContext);

				if (departmentId != 0) {
					TitlesDepartmentUnitUnitGroupLocalServiceUtil
							.addTitlesDepartmentUnitUnitGroup(
									titles.getTitlesId(), departmentId, unitId,
									unitGroupId, serviceContext);
				}
			} else {
				// update missing unit/unitGroup for Existing Titles
				if (unit != null) {
					if (unitGroup != null) { // NOSONAR
						TitlesDepartmentUnitUnitGroup o = TitlesDepartmentUnitUnitGroupLocalServiceUtil
								.findByTitlesDepartmentUnitUnitGroup(
										this.titles.getTitlesId(),
										departmentId, unitId, unitGroupId);
						// means need to be updated
						if (o == null) {

							// check whether titles associates with department
							// and unit existed ?
							final TitlesDepartmentUnitUnitGroup o1 = TitlesDepartmentUnitUnitGroupLocalServiceUtil
									.findByTitlesDepartmentUnitUnitGroup(
											titles.getTitlesId(), departmentId,
											unitId, 0L);

							// if not check to another level
							if (o1 == null) {
								// check level of department
								TitlesDepartmentUnitUnitGroup o2 = TitlesDepartmentUnitUnitGroupLocalServiceUtil
										.findByTitlesDepartmentUnitUnitGroup(
												titles.getTitlesId(),
												departmentId, 0L, 0L);
								if (o2 == null) {
									TitlesDepartmentUnitUnitGroupLocalServiceUtil
											.addTitlesDepartmentUnitUnitGroup(
													titles.getTitlesId(),
													departmentId, unitId,
													unitGroupId, serviceContext);
								} else {
									o2.setUnitId(unitId);
									o2.setUnitGroupId(unitGroupId);
									try {
										TitlesDepartmentUnitUnitGroupLocalServiceUtil
												.updateTitlesDepartmentUnitUnitGroup(o2);
									} catch (SystemException e) {
										LOGGER.info(e);
									}
								}
							} else {
								o1.setUnitGroupId(unitGroupId);
								try {
									TitlesDepartmentUnitUnitGroupLocalServiceUtil
											.updateTitlesDepartmentUnitUnitGroup(o1);
								} catch (SystemException e) {
									LOGGER.info(e);
								}
							}
						}
					} else {
						TitlesDepartmentUnitUnitGroup o1 = TitlesDepartmentUnitUnitGroupLocalServiceUtil
								.findByTitlesDepartmentUnitUnitGroup(
										titles.getTitlesId(), departmentId,
										unitId, 0L);
						if (o1 == null) {
							TitlesDepartmentUnitUnitGroup o2 = TitlesDepartmentUnitUnitGroupLocalServiceUtil
									.findByTitlesDepartmentUnitUnitGroup(
											titles.getTitlesId(), departmentId,
											0L, 0L);
							if (o2 == null) {
								TitlesDepartmentUnitUnitGroupLocalServiceUtil
										.addTitlesDepartmentUnitUnitGroup(
												titles.getTitlesId(),
												departmentId, unitId, 0L,
												serviceContext);
							} else {
								o2.setUnitId(unitId);
								try {
									TitlesDepartmentUnitUnitGroupLocalServiceUtil
											.updateTitlesDepartmentUnitUnitGroup(o2);
								} catch (SystemException e) {
									LOGGER.info(e);
								}
							}
						}
					}
				}
			}
			this.titlesId = this.titles.getTitlesId();
		}

		levelId = r.getCell(4) != null
				&& StringUtils.trimToNull(r.getCell(4).getStringCellValue()) != null
				&& LevelLocalServiceUtil.findByName(r.getCell(4)
						.getStringCellValue()) != null ? LevelLocalServiceUtil
				.findByName(r.getCell(4).getStringCellValue()).getLevelId() : 0;
		promotedDate = getConvertedDateStringCell(r.getCell(5));
		joinedDate = getConvertedDateStringCell(r.getCell(10));
		laborContractSignedDate = getConvertedDateStringCell(r.getCell(11));
		laborContractExpiredDate = getConvertedDateStringCell(r.getCell(12));
		laborContractType = getCellValueAsString(r.getCell(13)) != StringUtils.EMPTY ? LaborContractType
				.convertFromVNeseToLaborContractType(
						StringUtils.trim(r.getCell(13).getStringCellValue()))
				.toString() : LaborContractType.NONE.toString();
		laborContractSignedTime = getLaborContractSignedTime(r.getCell(14));

		dob = getConvertedDateStringCell(r.getCell(15));
		String genderCellVal = getCellValueAsString(r.getCell(16));
		gender = genderCellVal.equalsIgnoreCase(MALE_VNESE)
				|| genderCellVal.equalsIgnoreCase(MALE) ? MALE : FEMALE;

		pob = getCellValueAsString(r.getCell(17));
		education = getCellValueAsString(r.getCell(18));
		educationSpecialize = getCellValueAsString(r.getCell(19));
		// Specialized specialized = educationSpecializeName
		// .equals(StringUtils.EMPTY) ? SpecializedLocalServiceUtil
		// .findByName(educationSpecializeName) : null;
		// specializedId = specialized.getSpecializedId();

		universityId = r.getCell(20) != null
				&& r.getCell(20).getCellType() == 1
				&& StringUtils.trimToNull(r.getCell(19).getStringCellValue()) != null
				&& UniversityLocalServiceUtil.findByName(r.getCell(19)
						.getStringCellValue()) != null ? UniversityLocalServiceUtil
				.findByName(r.getCell(19).getStringCellValue())
				.getUniversityId() : 0;
		marritalStatus = getCellValueAsString(r.getCell(21));
		identityCardNo = getCellValueAsString(r.getCell(22));
		issuedDate = getConvertedDateStringCell(r.getCell(23));
		issuedPlace = getCellValueAsString(r.getCell(24));

		presentAddress = getCellValueAsString(r.getCell(25));
		temporaryAddress = getCellValueAsString(r.getCell(26));

		final List<Region> allVNRegions = ImportExportUtils.getAllVNRegions();
		presentRegion = ImportExportUtils.getRegionFromListByName(allVNRegions,
				getCityFromPresentAddress());
		tempRegion = ImportExportUtils.getRegionFromListByName(allVNRegions,
				getCityFromTemporaryAddress());

		contactNumber = getCellValueAsString(r.getCell(27));
		emailAddress = getCellValueAsString(r.getCell(28));
		companyEmailAddress = getCellValueAsString(r.getCell(29));
		taxCode = getCellValueAsString(r.getCell(30));
		numberOfDependents = getConvertedIntegerCell(r.getCell(31));
		dependentNames = getCellValueAsString(r.getCell(32));
		insurranceCode = getCellValueAsString(r.getCell(33));
		healthInsurranceCode = getCellValueAsString(r.getCell(34));

		bankNo1 = getCellValueAsString(r.getCell(35));
		bankName1 = getCellValueAsString(r.getCell(36));
		bankBranchName1 = getCellValueAsString(r.getCell(37));

		bankNo2 = getCellValueAsString(r.getCell(38));
		bankName2 = getCellValueAsString(r.getCell(39));
		bankBranchName2 = getCellValueAsString(r.getCell(40));

		bankNo3 = getCellValueAsString(r.getCell(41));
		bankName3 = getCellValueAsString(r.getCell(42));
		bankBranchName3 = getCellValueAsString(r.getCell(43));
	}

	private static int getLaborContractSignedTime(Cell cell) {
		if (cell == null)
			return 0;
		final String s = cell.getStringCellValue();
		return StringUtils.trimToNull(s) != null ? Integer.parseInt(s
				.split(" ")[1]) : 0;
	}

	public Emp createPrePersistedEmployee() {
		return EmpLocalServiceUtil.createEmployee(employeeCode, titlesId,
				getUnitGroupId(), getUnitId(), getDepartmentId(), levelId,
				promotedDate, joinedDate, laborContractSignedDate,
				laborContractExpiredDate, laborContractType,
				laborContractSignedTime, dob, gender, pob, education,
				educationSpecialize, specializedId, universityId,
				marritalStatus, identityCardNo, issuedDate, issuedPlace,
				contactNumber, companyEmailAddress, taxCode,
				numberOfDependents, dependentNames, insurranceCode,
				healthInsurranceCode);
	}

	public Emp updateExistedEmployee(Emp emp) {
		return EmpLocalServiceUtil.updateExistedEmployee(emp, employeeCode,
				titlesId, getUnitGroupId(), getUnitId(), getDepartmentId(),
				levelId, promotedDate, joinedDate, laborContractSignedDate,
				laborContractExpiredDate, laborContractType,
				laborContractSignedTime, dob, gender, pob, education,
				educationSpecialize, specializedId, universityId,
				marritalStatus, identityCardNo, issuedDate, issuedPlace,
				contactNumber, companyEmailAddress, taxCode,
				numberOfDependents, dependentNames, insurranceCode,
				healthInsurranceCode);
	}

	private static boolean isNotNullCell(Cell cell) {
		if (cell == null || cell.getCellType() == 1)
			return false;
		return true;
	}

	private Calendar getBirthDayCalendar() {
		if (dob == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dob);
		return calendar;
	}

	public String getCityFromTemporaryAddress() {
		return getAddressElement(temporaryAddress, 1, 1);
	}

	public Country getCountry() {
		try {
			return getPresentRegion() != null ? CountryServiceUtil
					.fetchCountry(getPresentRegion().getCountryId()) : null;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(ImportExportEmployeeDTO.class).info(
					"Exception on getCountry()", e);
		}
		return null;
	}

	public String getCityFromPresentAddress() {
		return getAddressElement(presentAddress, 1, 1);
	}

	public String getDistrictFromTemporaryAddress() {
		return getAddressElement(temporaryAddress, 1, 2);
	}

	public String getDistrictFromPresentAddress() {
		return getAddressElement(presentAddress, 1, 2);
	}

	public String getAddressFromTemporaryAddress() {
		String result = StringUtils.EMPTY;
		String[] arr = temporaryAddress.split(",");
		if (arr.length > 2) {
			for (int i = 0; i < arr.length - 2; i++) {
				result += arr[i];
			}
		}
		return StringUtils.trimToEmpty(result);
	}

	public String getAddressFromPresentAddress() {
		String result = StringUtils.EMPTY;
		String[] arr = presentAddress.split(",");
		if (arr.length > 2) {
			for (int i = 0; i < arr.length - 2; i++) {
				result += arr[i];
			}
		}
		return StringUtils.trimToEmpty(result);
	}

	private static String getAddressElement(String address,
			int checkSizeCondition, int indexOfElement) {
		if (address != null && StringUtils.trimToNull(address) != null) {
			String[] addressArr = address.split(",");
			if (addressArr.length > checkSizeCondition) {
				return StringUtils.trimToEmpty(addressArr[addressArr.length
						- indexOfElement]);
			}
		}
		return StringUtils.EMPTY;
	}

	/**
	 * Normalization for some address elements name. Example: "TP.HCM", "HCM",
	 * "Tp. HCM" -> "Hồ Chí Minh";
	 * 
	 * @param name
	 * @param possibleArr
	 * @param returnValue
	 * @return
	 */
	private static String replaceNameInPosibleArr(String name,
			String[] possibleArr, String returnValue) {
		boolean isExisted = false;
		for (int i = 0; i < possibleArr.length; i++) {
			if (name.equalsIgnoreCase(possibleArr[i])) {
				isExisted = true;
				break;
			}
		}
		return isExisted ? StringUtils.trimToEmpty(returnValue) : StringUtils
				.trimToEmpty(name);
	}

	public int getBirthdayYear() {
		return getBirthDayCalendar() != null ? getBirthDayCalendar().get(
				Calendar.YEAR) : 1970;
	}

	public int getBirthdayMonth() {
		return getBirthDayCalendar() != null ? getBirthDayCalendar().get(
				Calendar.MONTH) : 1;
	}

	public int getBirthdayDay() {
		return getBirthDayCalendar() != null ? getBirthDayCalendar().get(
				Calendar.DAY_OF_MONTH) : 1;
	}

	/**
	 * to avoid numeric values on string cell, this method will correct the type
	 * of cell & return String value
	 * 
	 * @param cell
	 * @return
	 */
	private static String getCellValueAsString(Cell cell) {
		if (cell == null)
			return StringUtils.EMPTY;
		cell.setCellType(STRING_CELL_TYPE);
		return cell.getStringCellValue();
	}

	private static Date getConvertedDateStringCell(Cell cell) {
		if (cell == null) {
			return null;
		}

		if (cell.getCellType() == 1) { // String cell type
			if (StringUtils.trimToNull(cell.getStringCellValue()) == null)
				return null;
			try {
				final SimpleDateFormat sdf = new SimpleDateFormat(
						DATE_STRING_CELL_FORMAT);
				cell.setCellType(STRING_CELL_TYPE);
				return StringUtils.trimToNull(cell.getStringCellValue()) != null ? sdf
						.parse(cell.getStringCellValue()) : null;
			} catch (ParseException e) {
				LogFactoryUtil.getLog(ImportExportEmployeeDTO.class).info(
						"Parse Exception on getConvertedDateStringCell", e);
			}
			return null;
		} else {
			return cell.getDateCellValue();
		}
	}

	private Integer getConvertedIntegerCell(Cell cell) {
		if (cell == null)
			return 0;
		cell.setCellType(STRING_CELL_TYPE);
		return StringUtils.trimToNull(cell.getStringCellValue()) != null ? Integer
				.valueOf(cell.getStringCellValue()) : 0;
	}

	/********************************************************************************************************************
	 * * * * * * * * * * * * * * * * * * * * * AUTO GENERATE Getters & Setters *
	 ********************************************************************************************************************/

	public String getEmployeeCode() {
		return employeeCode;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getPromotedDate() {
		return promotedDate;
	}

	public void setPromotedDate(Date promotedDate) {
		this.promotedDate = promotedDate;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Date getLaborContractSignedDate() {
		return laborContractSignedDate;
	}

	public void setLaborContractSignedDate(Date laborContractSignedDate) {
		this.laborContractSignedDate = laborContractSignedDate;
	}

	public Date getLaborContractExpiredDate() {
		return laborContractExpiredDate;
	}

	public void setLaborContractExpiredDate(Date laborContractExpiredDate) {
		this.laborContractExpiredDate = laborContractExpiredDate;
	}

	public String getLaborContractType() {
		return laborContractType;
	}

	public void setLaborContractType(String laborContractType) {
		this.laborContractType = laborContractType;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPob() {
		return pob;
	}

	public void setPob(String pob) {
		this.pob = pob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMarritalStatus() {
		return marritalStatus;
	}

	public void setMarritalStatus(String marritalStatus) {
		this.marritalStatus = marritalStatus;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getIssuedPlace() {
		return issuedPlace;
	}

	public void setIssuedPlace(String issuedPlace) {
		this.issuedPlace = issuedPlace;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getTemporaryAddress() {
		return temporaryAddress;
	}

	public void setTemporaryAddress(String temporaryAddress) {
		this.temporaryAddress = temporaryAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCompanyEmailAddress() {
		return companyEmailAddress;
	}

	public void setCompanyEmailAddress(String companyEmailAddress) {
		this.companyEmailAddress = companyEmailAddress;
	}

	public String getTaxCode() {
		return taxCode;
	}

	public void setTaxCode(String taxCode) {
		this.taxCode = taxCode;
	}

	public String getInsurranceCode() {
		return insurranceCode;
	}

	public void setInsurranceCode(String insurranceCode) {
		this.insurranceCode = insurranceCode;
	}

	public int getLaborContractSignedTime() {
		return laborContractSignedTime;
	}

	public void setLaborContractSignedTime(int laborContractSignedTime) {
		this.laborContractSignedTime = laborContractSignedTime;
	}

	public String getBankNo1() {
		return bankNo1;
	}

	public void setBankNo1(String bankNo1) {
		this.bankNo1 = bankNo1;
	}

	public String getBankName1() {
		return bankName1;
	}

	public void setBankName1(String bankName1) {
		this.bankName1 = bankName1;
	}

	public String getBankBranchName1() {
		return bankBranchName1;
	}

	public void setBankBranchName1(String bankBranchName1) {
		this.bankBranchName1 = bankBranchName1;
	}

	public String getBankNo2() {
		return bankNo2;
	}

	public void setBankNo2(String bankNo2) {
		this.bankNo2 = bankNo2;
	}

	public String getBankName2() {
		return bankName2;
	}

	public void setBankName2(String bankName2) {
		this.bankName2 = bankName2;
	}

	public String getBankBranchName2() {
		return bankBranchName2;
	}

	public void setBankBranchName2(String bankBranchName2) {
		this.bankBranchName2 = bankBranchName2;
	}

	public String getBankNo3() {
		return bankNo3;
	}

	public void setBankNo3(String bankNo3) {
		this.bankNo3 = bankNo3;
	}

	public String getBankName3() {
		return bankName3;
	}

	public void setBankName3(String bankName3) {
		this.bankName3 = bankName3;
	}

	public String getBankBranchName3() {
		return bankBranchName3;
	}

	public void setBankBranchName3(String bankBranchName3) {
		this.bankBranchName3 = bankBranchName3;
	}

	public ServiceContext getServiceContext() {
		return serviceContext;
	}

	public void setServiceContext(ServiceContext serviceContext) {
		this.serviceContext = serviceContext;
	}

	public long getDepartmentId() {
		return this.department != null ? this.department.getDepartmentId() : 0L;
	}

	public long getUnitId() {
		return this.unit != null ? this.unit.getUnitId() : 0L;
	}

	public long getUnitGroupId() {
		return this.unitGroup != null ? this.unitGroup.getUnitGroupId() : 0L;
	}

	public long getTitlesId() {
		return titlesId;
	}

	public void setTitlesId(long titlesId) {
		this.titlesId = titlesId;
	}

	public long getLevelId() {
		return levelId;
	}

	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}

	public long getUniversityId() {
		return universityId;
	}

	public int getNumberOfDependents() {
		return numberOfDependents;
	}

	public void setNumberOfDependents(int numberOfDependents) {
		this.numberOfDependents = numberOfDependents;
	}

	public String getDependentNames() {
		return dependentNames;
	}

	public void setDependentNames(String dependentNames) {
		this.dependentNames = dependentNames;
	}

	public void setUniversityId(long universityId) {
		this.universityId = universityId;
	}

	public Region getPresentRegion() {
		return presentRegion;
	}

	public void setPresentRegion(Region presentRegion) {
		this.presentRegion = presentRegion;
	}

	public Region getTempRegion() {
		return tempRegion;
	}

	public void setTempRegion(Region tempRegion) {
		this.tempRegion = tempRegion;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Devision getDevision() {
		return devision;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(UnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public String getHealthInsurranceCode() {
		return healthInsurranceCode;
	}

	public void setHealthInsurranceCode(String healthInsurranceCode) {
		this.healthInsurranceCode = healthInsurranceCode;
	}

	public List<AddressObjectItem> getAddresses() {
		List<AddressObjectItem> addresses = new ArrayList<>();

		if (presentRegion != null) {
			addresses.add(new AddressObjectItem(presentRegion.getCountryId(),
					presentRegion.getRegionId(),
					getDistrictFromPresentAddress(),
					getAddressFromPresentAddress()));
		}

		if (tempRegion != null) {
			addresses.add(new AddressObjectItem(tempRegion.getCountryId(),
					tempRegion.getRegionId(),
					getDistrictFromTemporaryAddress(),
					getAddressFromTemporaryAddress()));
		}

		return addresses;
	}

	public List<EmpBankInfo> getEmpBankInfos() {
		final List<EmpBankInfo> empBankInfos = new ArrayList<>();

		if (!StringUtils.EMPTY.equalsIgnoreCase(bankNo1)) {
			empBankInfos.add(EmpBankInfoLocalServiceUtil
					.createPrePersistedEntity(0L, bankNo1, bankName1,
							bankBranchName1));
		}

		if (!StringUtils.EMPTY.equalsIgnoreCase(bankNo2)) {
			empBankInfos.add(EmpBankInfoLocalServiceUtil
					.createPrePersistedEntity(0L, bankNo2, bankName2,
							bankBranchName2));
		}

		if (!StringUtils.EMPTY.equalsIgnoreCase(bankNo3)) {
			empBankInfos.add(EmpBankInfoLocalServiceUtil
					.createPrePersistedEntity(0L, bankNo3, bankName3,
							bankBranchName3));
		}
		return empBankInfos;
	}

	public Map<EmpBankInfo, Boolean> getBankInfoMap() {
		return EmployeeUtils
				.transferEmpBankInfoListToBankInfoMap(getEmpBankInfos());
	}

	public String getImportFailedException() {
		return importFailedException;
	}

	public void setImportFailedException(String importFailedException) {
		this.importFailedException = importFailedException;
	}

	public boolean isEmployeeExisted() {
		return EmpLocalServiceUtil.findByEmpCode(employeeCode) != null;
	}

}
