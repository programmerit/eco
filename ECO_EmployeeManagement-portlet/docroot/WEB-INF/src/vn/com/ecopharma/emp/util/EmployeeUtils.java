package vn.com.ecopharma.emp.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vn.com.ecopharma.emp.dto.AddressObjectItem;
import vn.com.ecopharma.emp.dto.BankInfoObject;
import vn.com.ecopharma.emp.dto.DependentName;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.enumeration.EmployeeExportType;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResourceConfigLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.util.DLUtil;

/**
 * @author TaoTran
 *
 */
public class EmployeeUtils {

	private static final String ZIP_CODE = "70000";

	private static final String DEST_DATETIME_FORMATTER = "dd/MM/yyyy";

	private EmployeeUtils() {

	}

	/**
	 * @param documents
	 * @return
	 */
	public static List<EmpIndexedItem> getEmployeeIndexedItemsFromIndexedDocuments(
			List<Document> documents) {

		final List<EmpIndexedItem> results = new ArrayList<>(documents.size());
		for (final Document document : documents) {
			results.add(new EmpIndexedItem(document));
		}
		return results;
	}

	/**
	 * @param clazzName
	 * @param primaryKey
	 * @param companyId
	 * @return
	 */
	public static List<AddressObjectItem> getAddressObjectItemsFromClassNameAndPK(
			String clazzName, long primaryKey, long companyId) {
		try {
			final List<AddressObjectItem> results = new ArrayList<>();

			for (Address address : AddressLocalServiceUtil.getAddresses(
					companyId, clazzName, primaryKey)) {
				results.add(new AddressObjectItem(address, false));
			}
			return results;
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return new ArrayList<>();
	}

	/**
	 * @param items
	 * @return
	 */
	/**
	 * @param items
	 * @return
	 */
	public static Map<Address, Boolean> transferAddressObjectListToAddressMap(
			List<AddressObjectItem> items) {
		final Map<Address, Boolean> resultMap = new HashMap<>(items.size());
		for (AddressObjectItem item : items) {
			final District district = item.getDistrict();
			final Address address = item.getAddress();
			long countryId = item.getCountry() != null ? item.getCountry()
					.getCountryId() : address.getCountryId();
			long regionId = item.getRegion() != null ? item.getRegion()
					.getRegionId() : address.getRegionId();
			address.setCountryId(countryId);
			address.setRegionId(regionId);
			if (StringUtils.trimToNull(address.getStreet3()) == null)
				address.setStreet3(item.isUIDeleted() ? StringUtils.EMPTY
						: district.getRegionCode() + "_" + district.getName());
			address.setZip(ZIP_CODE);
			resultMap.put(address, item.isUIDeleted());
		}
		return resultMap;
	}

	/**
	 * @param items
	 * @return
	 */
	public static Map<String, Boolean> transferDependentNameObjectListToDependentNameMap(
			List<DependentName> items) {
		final Map<String, Boolean> resultMap = new HashMap<>();

		for (DependentName item : items) {
			resultMap.put(item.getName(), item.isUIDeleted());
		}
		return resultMap;
	}

	public static List<BankInfoObject> getBankInfoObjectsFromEmp(long empId) {
		final List<BankInfoObject> result = new ArrayList<>();
		final List<EmpBankInfo> empBankInfos = EmpBankInfoLocalServiceUtil
				.findByEmp(empId);
		if (empBankInfos.isEmpty())
			result.add(new BankInfoObject());

		for (EmpBankInfo item : empBankInfos) {
			result.add(new BankInfoObject(item));
		}
		return result;
	}

	public static Map<EmpBankInfo, Boolean> transferBankInfoObjectListToBankInfoMap(
			List<BankInfoObject> items) {
		final Map<EmpBankInfo, Boolean> resultMap = new HashMap<>();
		for (BankInfoObject obj : items) {
			resultMap.put(obj.getEmpBankInfo(), obj.isUIDeleted());
		}

		return resultMap;
	}

	public static Map<EmpBankInfo, Boolean> transferEmpBankInfoListToBankInfoMap(
			List<EmpBankInfo> items) {
		final Map<EmpBankInfo, Boolean> resultMap = new HashMap<>();
		for (EmpBankInfo obj : items) {
			resultMap.put(obj, false);
		}

		return resultMap;
	}

	public static int numberOfValidDependentName(List<DependentName> items) {
		int count = 0;
		for (DependentName item : items) {
			if (!item.isUIDeleted())
				count++;
		}
		return count;
	}

	/**
	 * @param s
	 * @return
	 */
	public static List<DependentName> getDependentNamesFromString(String s) {
		final List<DependentName> result = new ArrayList<>();
		if (org.apache.commons.lang.StringUtils.trimToNull(s) == null) {
			return result;
		}
		String[] splitNames = s.split(";");
		for (int i = 0; i < splitNames.length; i++) {
			result.add(new DependentName(splitNames[i], Boolean.FALSE));
		}
		return result;
	}

	/**
	 * @return
	 */
	public static SearchContext getCurrentSearchContext() {
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		final PortletRequest req = (PortletRequest) liferayFacesContext
				.getExternalContext().getRequest();

		final HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(req));
		return SearchContextFactory.getInstance(httpServletRequest);
	}

	public static String getFullnameFromUser(User user) {
		return user.getFirstName() + " " + user.getMiddleName() + " "
				+ user.getLastName();
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getFirstNameFromFullname(String fullname) {
		return StringUtils.trimToNull(fullname) == null ? StringUtils.EMPTY
				: fullname.split(" ")[0];
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getMiddleNameFromFullname(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;

		String[] fullnameArr = fullname.split(" ");
		int length = fullnameArr.length;
		// check if employee just have first and last name only
		if (length == 2) {
			return StringUtils.EMPTY;
		}
		String middleName = StringUtils.EMPTY;
		for (int i = 1; i < length - 1; i++) {
			middleName += fullnameArr[i] + " ";
		}
		return middleName;
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String getLastNameFromFullname(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		String[] fullnameArr = fullname.split(" ");
		return fullnameArr[fullnameArr.length - 1];
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String generateUsername1(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;

		fullname = VNCharacterUtils.removeAccent(fullname).toLowerCase(); // NOSONAR
		StringBuilder resultBuilder = new StringBuilder();
		char firstChar = getFirstNameFromFullname(fullname).toCharArray()[0];

		String[] middleNameArr = getMiddleNameFromFullname(fullname).split(" ");
		char[] middleNameChars;
		if (middleNameArr.length > 0 && middleNameArr[0] != StringUtils.EMPTY) {
			middleNameChars = new char[middleNameArr.length];
			for (int i = 0; i < middleNameChars.length; i++) {
				middleNameChars[i] = middleNameArr[i].charAt(0);
			}
		} else {
			middleNameChars = null;
		}

		resultBuilder.append(firstChar);
		if (middleNameChars != null) {
			resultBuilder.append(middleNameChars);
		}
		resultBuilder.append(getLastNameFromFullname(fullname));
		return resultBuilder.toString();
	}

	/**
	 * @param fullname
	 * @return
	 */
	public static String generateUsername(String fullname) {
		if (StringUtils.trimToNull(fullname) == null)
			return StringUtils.EMPTY;
		fullname = StringUtils.stripAccents(fullname); // NOSONAR
		LogFactoryUtil.getLog(EmployeeUtils.class).info(
				"FULL NAME AFTER STRIPPING ACCENTS: " + fullname);

		StringBuilder resultBuilder = new StringBuilder();
		char firstChar = getFirstNameFromFullname(fullname).toCharArray()[0];

		String[] middleNameArr = getMiddleNameFromFullname(fullname).split(" ");
		char[] middleNameChars;
		if (middleNameArr.length > 0 && middleNameArr[0] != StringUtils.EMPTY) {
			middleNameChars = new char[middleNameArr.length];
			for (int i = 0; i < middleNameChars.length; i++) {
				middleNameChars[i] = middleNameArr[i].charAt(0);
			}
		} else {
			middleNameChars = null;
		}

		resultBuilder.append(firstChar);
		if (middleNameChars != null) {
			resultBuilder.append(middleNameChars);
		}
		resultBuilder.append(getLastNameFromFullname(fullname));
		String resultString = resultBuilder.toString().toLowerCase();
		resultString = resultString.replaceAll("đ", "d");
		LogFactoryUtil.getLog(EmployeeUtils.class).info(
				"USERNAME AFTER STRIPPING ACCENTS: " + fullname);
		return resultString;
	}

	/**
	 * @param id
	 * @return
	 */
	public static Emp getEmployeeById(long id) {
		try {
			return EmpLocalServiceUtil.getEmp(id);
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	public static Emp getEmpById(long id) {
		try {
			return EmpLocalServiceUtil.getEmp(id);
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return null;
	}

	/**
	 * @param row
	 * @param cellStyle
	 */
	private static void setEntireRowStyle(Row row, CellStyle cellStyle) {
		for (int i = 0; i <= 41; i++) {
			if (row.getCell(i) != null)
				row.getCell(i).setCellStyle(cellStyle);
			else {
				row.getCell(i).setCellValue(StringUtils.EMPTY);
				row.getCell(i).setCellStyle(cellStyle);
			}
		}
	}

	/**
	 * @param wb
	 * @param ws
	 */
	public static void createExportHeaderRow(Workbook wb, Sheet ws) {
		Row row = ws.createRow(1);
		row.createCell(16).setCellValue(
				ResourceConfigLocalServiceUtil.findByKey("export_title")
						.getValue());
		CellStyle titleCellStyle = wb.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBoldweight((short) 0x2bc);
		titleCellStyle.setFont(headerFont);
		row.getCell(16).setCellStyle(titleCellStyle);

		row = ws.createRow(3);

		row.createCell(0).setCellValue("STT");
		row.createCell(1).setCellValue("Mã NV");
		row.createCell(2).setCellValue("Họ và Tên");
		row.createCell(3).setCellValue("Chức danh");
		row.createCell(4).setCellValue("Cấp bậc");
		row.createCell(5).setCellValue("Ngày bổ nhiệm");
		row.createCell(6).setCellValue("Nhóm");
		row.createCell(7).setCellValue("Bộ phận");
		row.createCell(8).setCellValue("Phòng");
		row.createCell(9).setCellValue("Khối");
		row.createCell(10).setCellValue("Ngày vào");
		row.createCell(11).setCellValue("Ngày ký HĐ");
		row.createCell(12).setCellValue("Ngày kết thúc HĐ");
		row.createCell(13).setCellValue("Loại HĐLĐ");
		row.createCell(14).setCellValue("Ngày tháng năm sinh");
		row.createCell(15).setCellValue("Giới tính");
		row.createCell(16).setCellValue("Nơi Sinh");
		row.createCell(17).setCellValue("Trình độ học vấn");
		row.createCell(18).setCellValue("Chuyên môn");
		row.createCell(19).setCellValue("Trường");
		row.createCell(20).setCellValue("Tình trạng hôn nhân");
		row.createCell(21).setCellValue("Số CMND");
		row.createCell(22).setCellValue("Ngày cấp");
		row.createCell(23).setCellValue("Nơi Cấp");
		row.createCell(24).setCellValue("Địa chỉ Thường trú");
		row.createCell(25).setCellValue("Địa Chỉ Tạm Trú");
		row.createCell(26).setCellValue("Số ĐT Liên lạc");
		row.createCell(27).setCellValue("Email cá nhân");
		row.createCell(28).setCellValue("Email Công ty");
		row.createCell(29).setCellValue("Mã số Thuế");
		row.createCell(30).setCellValue("Số người phụ thuộc");
		row.createCell(31).setCellValue("Tên Người phụ thuộc");
		row.createCell(32).setCellValue("Số sổ BHXH");
		row.createCell(33).setCellValue("Số Thẻ BHYT");
		row.createCell(34).setCellValue("Số Tài khoản NH");
		row.createCell(35).setCellValue("Tên Chi nhánh Ngân Hàng");
		row.createCell(36).setCellValue("Lương căn bản");
		row.createCell(37).setCellValue("Lương vị trí");
		row.createCell(38).setCellValue("Lương năng lực");
		row.createCell(39).setCellValue("Tổng lương");
		row.createCell(40).setCellValue("Thưởng thành tích");
		row.createCell(41).setCellValue("Ngày nghỉ việc");

		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setBorderTop((short) 0x1);// BorderStyle.THIN
		cellStyle.setBorderRight((short) 0x1);
		cellStyle.setBorderLeft((short) 0x1);
		cellStyle.setAlignment((short) 0x2); // ALIGN_CENTER

		Font font = wb.createFont();
		font.setBoldweight((short) 0x2bc);

		cellStyle.setFont(font);
		setEntireRowStyle(row, cellStyle);

		row = ws.createRow(4);
		for (int i = 0; i <= 41; i++) {
			int k = i + 1;
			row.createCell(i).setCellValue(k);
		}

		CellStyle cellStyle1 = wb.createCellStyle();
		cellStyle1.setBorderTop((short) 0x7);
		cellStyle1.setBorderBottom((short) 0x7);
		cellStyle1.setBorderRight((short) 0x1);
		cellStyle1.setBorderLeft((short) 0x1);
		cellStyle1.setAlignment((short) 2);

		setEntireRowStyle(row, cellStyle1);
	}

	/**
	 * @param wb
	 *            workbook
	 * @param ws
	 *            worksheet
	 * @param rowNum
	 * @param recordNo
	 * @param employee
	 * @return
	 */
	public static Row createRow(Workbook wb, Sheet ws, int rowNum,
			int recordNo, Emp employee) {
		final SimpleDateFormat destSdf = new SimpleDateFormat(
				DEST_DATETIME_FORMATTER);

		try {
			final Row row = ws.createRow(rowNum);
			final User employeeUser = UserLocalServiceUtil.getUser(employee
					.getEmpUserId());
			final Titles titles = employee.getTitlesId() != 0 ? TitlesLocalServiceUtil
					.fetchTitles(employee.getTitlesId()) : null;

			final UnitGroup unitGroup = titles != null
					&& titles.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.fetchUnitGroup(titles.getUnitGroupId()) : null;

			final Unit unit = titles != null && titles.getUnitId() != 0 ? UnitLocalServiceUtil
					.fetchUnit(titles.getUnitId()) : null;

			final Department department = titles != null
					&& titles.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
					.fetchDepartment(titles.getDepartmentId()) : null;

			final Devision devision = department != null ? DevisionLocalServiceUtil
					.getDevision(department.getDevisionId()) : null;

			final List<Address> addresses = AddressLocalServiceUtil
					.getAddresses(employee.getCompanyId(), Emp.class.getName(),
							employee.getEmpId());

			String tempAddress = StringUtils.EMPTY;
			String presentAddress = StringUtils.EMPTY;
			if (!addresses.isEmpty()) {
				if (addresses.size() == 1) {
					final Address presentAddressObj = addresses.get(0);
					presentAddress = getAddressStringFromAddressObj(presentAddressObj);
				} else if (addresses.size() == 2) {
					final Address tempAddressObj = addresses.get(1);
					tempAddress = getAddressStringFromAddressObj(tempAddressObj);
				}

			}

			row.createCell(0).setCellValue(recordNo);

			row.createCell(1).setCellValue(employee.getEmpCode());

			row.createCell(2).setCellValue(employeeUser.getFullName());
			row.createCell(3).setCellValue(
					titles != null ? titles.getName() : StringUtils.EMPTY);
			row.createCell(4).setCellValue(
					employee.getLevelId() != 0 ? LevelLocalServiceUtil
							.getLevel(employee.getLevelId()).getName()
							: StringUtils.EMPTY);
			row.createCell(5).setCellValue(employee.getPromotedDate());

			row.createCell(6)
					.setCellValue(
							unitGroup != null ? unitGroup.getName()
									: StringUtils.EMPTY);

			row.createCell(7).setCellValue(
					unit != null ? unit.getName() : StringUtils.EMPTY);

			row.createCell(8).setCellValue(
					department != null ? department.getName()
							: StringUtils.EMPTY);

			row.createCell(9).setCellValue(
					devision != null ? devision.getName() : StringUtils.EMPTY);

			row.createCell(10).setCellValue(
					employee.getJoinedDate() != null ? destSdf.format(employee
							.getJoinedDate()) : StringUtils.EMPTY);

			row.createCell(11).setCellValue(
					employee.getLaborContractSignedDate() != null ? destSdf
							.format(employee.getLaborContractSignedDate())
							: StringUtils.EMPTY);
			row.createCell(12).setCellValue(
					employee.getLaborContractExpiredDate() != null ? destSdf
							.format(employee.getLaborContractExpiredDate())
							: StringUtils.EMPTY);
			row.createCell(13).setCellValue(employee.getLaborContractType());
			row.createCell(14).setCellValue(
					employee.getBirthday() != null ? destSdf.format(employee
							.getBirthday()) : StringUtils.EMPTY);
			row.createCell(15).setCellValue(employee.getGender());
			row.createCell(16).setCellValue(employee.getPlaceOfBirth());
			row.createCell(17).setCellValue(employee.getEducation());
			row.createCell(18).setCellValue(employee.getEducationSpecialize());
			row.createCell(19)
					.setCellValue(
							employee.getUniversityId() != 0 ? UniversityLocalServiceUtil
									.getUniversity(employee.getUniversityId())
									.getName() : StringUtils.EMPTY);
			row.createCell(20).setCellValue(employee.getMaritalStatus());
			row.createCell(21).setCellValue(employee.getIdentityCardNo());
			row.createCell(22).setCellValue(
					employee.getIssuedDate() != null ? destSdf.format(employee
							.getIssuedDate()) : StringUtils.EMPTY);
			row.createCell(23).setCellValue(employee.getIssuedPlace());
			row.createCell(24).setCellValue(presentAddress);
			row.createCell(25).setCellValue(tempAddress);
			row.createCell(26).setCellValue(employee.getContactNumber());
			row.createCell(27).setCellValue(employeeUser.getEmailAddress());
			row.createCell(28).setCellValue(employee.getCompanyEmailAddress());
			row.createCell(29).setCellValue(employee.getPersonalTaxCode());
			row.createCell(30).setCellValue(employee.getNumberOfDependents());
			row.createCell(31).setCellValue(employee.getDependentNames());
			row.createCell(32).setCellValue(employee.getHealthInsuranceNo());
			row.createCell(33).setCellValue(employee.getSocialInsuranceNo());
			row.createCell(36).setCellValue(employee.getBaseWageRates());
			row.createCell(37).setCellValue(employee.getPositionWageRates());
			row.createCell(38).setCellValue(employee.getCapacitySalary());
			row.createCell(39).setCellValue(employee.getTotalSalary());
			row.createCell(40).setCellValue(employee.getBonus());
			row.createCell(41).setCellValue(
					employee.getResignedDate() != null ? destSdf
							.format(employee.getResignedDate())
							: StringUtils.EMPTY);

			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setBorderTop((short) 0x7);
			cellStyle.setBorderBottom((short) 0x7);
			cellStyle.setBorderRight((short) 0x1);
			cellStyle.setBorderLeft((short) 0x1);
			setEntireRowStyle(row, cellStyle);

			return row;
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return null;
	}

	public static Row createRow(Workbook wb, Sheet ws, int rowNum,
			int recordNo, EmpIndexedItem employee) {

		final SimpleDateFormat destSdf = new SimpleDateFormat(
				DEST_DATETIME_FORMATTER);
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		try {
			final Titles titles = employee.getTitlesId() != 0 ? TitlesLocalServiceUtil
					.fetchTitles(employee.getTitlesId()) : null;

			final UnitGroup unitGroup = titles != null
					&& titles.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.fetchUnitGroup(titles.getUnitGroupId()) : null;

			final Unit unit = titles != null && titles.getUnitId() != 0 ? UnitLocalServiceUtil
					.fetchUnit(titles.getUnitId()) : null;

			final Department department = titles != null
					&& titles.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
					.fetchDepartment(titles.getDepartmentId()) : null;

			final Devision devision = department != null ? DevisionLocalServiceUtil
					.getDevision(department.getDevisionId()) : null;

			final Row row = ws.createRow(rowNum);
			final User employeeUser = UserLocalServiceUtil.getUser(employee
					.getEmployeeUserId());
			final List<Address> addresses = AddressLocalServiceUtil
					.getAddresses(serviceContext.getCompanyId(),
							Emp.class.getName(), employee.getEmployeeId());

			String tempAddress = StringUtils.EMPTY;
			String presentAddress = StringUtils.EMPTY;

			// Export address info
			if (!addresses.isEmpty()) {
				if (addresses.size() == 1) {
					final Address presentAddressObj = addresses.get(0);
					presentAddress = getAddressStringFromAddressObj(presentAddressObj);
				} else if (addresses.size() == 2) {
					final Address presentAddressObj = addresses.get(0);
					presentAddress = getAddressStringFromAddressObj(presentAddressObj);
					final Address tempAddressObj = addresses.get(1);
					tempAddress = getAddressStringFromAddressObj(tempAddressObj);
				}

			}

			row.createCell(0).setCellValue(recordNo);

			Cell cell = row.createCell(1);
			cell.setCellType(1);
			cell.setCellValue(employee.getEmployeeCode());

			row.createCell(2).setCellValue(employeeUser.getFullName());
			row.createCell(3).setCellValue(
					titles != null ? titles.getName() : StringUtils.EMPTY);
			row.createCell(4).setCellValue(
					employee.getLevelId() != 0 ? LevelLocalServiceUtil
							.getLevel(employee.getLevelId()).getName()
							: StringUtils.EMPTY);
			row.createCell(5).setCellValue(
					employee.getPromotedDate() != null ? employee
							.getPromotedDate().toString() : StringUtils.EMPTY);

			row.createCell(6)
					.setCellValue(
							unitGroup != null ? unitGroup.getName()
									: StringUtils.EMPTY);

			row.createCell(7).setCellValue(
					unit != null ? unit.getName() : StringUtils.EMPTY);

			row.createCell(8).setCellValue(
					department != null ? department.getName()
							: StringUtils.EMPTY);

			row.createCell(9).setCellValue(
					devision != null ? devision.getName() : StringUtils.EMPTY);

			row.createCell(10).setCellValue(
					employee.getJoinedDate() != null ? destSdf.format(employee
							.getJoinedDate()) : StringUtils.EMPTY);

			row.createCell(11).setCellValue(
					employee.getLaborContractSignedDate() != null ? destSdf
							.format(employee.getLaborContractSignedDate())
							: StringUtils.EMPTY);
			row.createCell(12).setCellValue(
					employee.getLaborContractExpiredDate() != null ? destSdf
							.format(employee.getLaborContractExpiredDate())
							: StringUtils.EMPTY);
			row.createCell(13).setCellValue(
					LaborContractType.valueOf(employee.getLaborContractType())
							.getVietnameseString());
			row.createCell(14).setCellValue(
					employee.getBirthday() != null ? destSdf.format(employee
							.getBirthday()) : StringUtils.EMPTY);
			row.createCell(15).setCellValue(employee.getGender());
			row.createCell(16).setCellValue(StringUtils.EMPTY);
			row.createCell(17).setCellValue(employee.getEducation());
			row.createCell(18).setCellValue(employee.getEducationSpecialize());
			row.createCell(19)
					.setCellValue(
							employee.getUniversityId() != 0 ? UniversityLocalServiceUtil
									.getUniversity(employee.getUniversityId())
									.getName() : StringUtils.EMPTY);
			row.createCell(20).setCellValue(employee.getMaritalStatus());
			row.createCell(21).setCellValue(employee.getIdentityCardNo());
			row.createCell(22).setCellValue(
					employee.getIssuedDate() != null ? destSdf.format(employee
							.getIssuedDate()) : StringUtils.EMPTY);
			row.createCell(23).setCellValue(employee.getIssuedPlace());
			row.createCell(24).setCellValue(presentAddress);
			row.createCell(25).setCellValue(tempAddress);
			row.createCell(26).setCellValue(employee.getContactNumber());
			row.createCell(27).setCellValue(employeeUser.getEmailAddress());
			row.createCell(28).setCellValue(employee.getCompanyEmailAddress());
			row.createCell(29).setCellValue(employee.getPersonalTaxCode());
			row.createCell(30).setCellValue(employee.getNumberOfDependents());
			row.createCell(31).setCellValue(employee.getDependentNames());
			row.createCell(32).setCellValue(employee.getHealthInsuranceNo());
			row.createCell(33).setCellValue(employee.getSocialInsuranceNo());
			row.createCell(34).setCellValue(employee.getBankAccountNo());
			row.createCell(35).setCellValue(employee.getBankBranchName());
			row.createCell(36).setCellValue(employee.getBaseWageRates());
			row.createCell(37).setCellValue(employee.getPositionWageRates());
			row.createCell(38).setCellValue(employee.getCapacitySalary());
			row.createCell(39).setCellValue(employee.getTotalSalary());
			row.createCell(40).setCellValue(employee.getBonus());
			row.createCell(41).setCellValue(
					employee.getResignedDate() != null ? destSdf
							.format(employee.getResignedDate())
							: StringUtils.EMPTY);

			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setBorderTop((short) 0x7);
			cellStyle.setBorderBottom((short) 0x7);
			cellStyle.setBorderRight((short) 0x1);
			cellStyle.setBorderLeft((short) 0x1);
			setEntireRowStyle(row, cellStyle);
			return row;
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static String generateAndGetExportExcelFileURL(long folderId,
			String exportFilename, EmployeeExportType type, List<?> employees,
			ServiceContext serviceContext) {

		if (employees == null || employees.isEmpty())
			return StringUtils.EMPTY;

		String fileExt = StringUtils.EMPTY;
		Workbook wb = null;
		Sheet ws = null;
		try {
			switch (type) {
			case XLS:
				fileExt = ".xls";
				wb = new HSSFWorkbook();
				break;
			case XLSX:
				fileExt = ".xlsx";
				wb = new XSSFWorkbook();
				break;
			default:
				break;
			}
			ws = wb.createSheet("Sheet1");

			EmployeeUtils.createExportHeaderRow(wb, ws);
			int rowNum = 5;
			if (employees.get(0) instanceof Emp) {
				for (Emp employee : (List<Emp>) employees) {
					EmployeeUtils.createRow(wb, ws, rowNum, rowNum - 4,
							employee);
					rowNum++;
				}
			} else {
				for (EmpIndexedItem eii : (List<EmpIndexedItem>) employees) {
					EmployeeUtils.createRow(wb, ws, rowNum, rowNum - 4, eii);
					rowNum++;
				}
			}

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			wb.write(outputStream);

			final File tmpfile = FileUtil.createTempFile(outputStream
					.toByteArray());
			final File newFile = new File(tmpfile.getParent(), exportFilename
					+ fileExt);
			Files.move(tmpfile.toPath(), newFile.toPath());

			final PortletRequest pRequest = (PortletRequest) LiferayFacesContext
					.getCurrentInstance().getExternalContext().getRequest();

			final DLFileEntry dlFileEntry = DLUtils.uploadFile(pRequest,
					newFile, exportFilename, StringUtils.EMPTY,
					StringUtils.EMPTY, folderId, serviceContext);
			newFile.delete();

			final FileEntry fe = DLUtils.getUploadFileEntry(dlFileEntry);

			return DLUtil
					.getPreviewURL(fe, fe.getFileVersion(),
							(ThemeDisplay) pRequest
									.getAttribute(WebKeys.THEME_DISPLAY),
							StringUtils.EMPTY, false, true);
		} catch (IOException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (PortalException e) {
			writeDebugLog(EmployeeUtils.class, e);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return StringUtils.EMPTY;

	}

	public static void deleteAllEmployeeAndEmployeeUser() {
		for (Emp employee : EmpLocalServiceUtil.findAll()) {
			try {
				UserLocalServiceUtil.deleteUser(employee.getEmpUserId());

				EmployeeLocalServiceUtil.deleteEmployee(employee.getEmpId());
			} catch (PortalException e) {
				writeDebugLog(EmployeeUtils.class, e);
			} catch (SystemException e) {
				writeDebugLog(EmployeeUtils.class, e);
			}
		}
	}

	public static List<Long> getIdsFromBasedModelList(List<BaseModel<?>> list) {
		final List<Long> ids = new ArrayList<>();
		for (BaseModel<?> obj : list) {
			ids.add(new Long(obj.getPrimaryKeyObj().toString()));
		}
		return ids;
	}

	private static String getAddressStringFromAddressObj(Address address) {
		return address.getStreet1() + ", " + address.getStreet3().split("_")[1]
				+ ", " + address.getRegion().getName();
	}

	public static ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}

	public static long getCompanyId() {
		return getServiceContext().getCompanyId();
	}

	public static long getBaseModelPrimaryKey(BaseModel<?> model) {
		if (model == null)
			return 0;
		return Long.valueOf(String.valueOf(model.getPrimaryKeyObj()));
	}

	public static String regenerateUsername(String currentUsername,
			int increment) {

		try {
			if (increment > 1) {
				currentUsername = currentUsername.substring(0, // NOSONAR
						currentUsername.length() - 1) + increment;
			} else {
				currentUsername = currentUsername + increment; // NOSONAR
			}
			if (UserLocalServiceUtil.fetchUserByScreenName(getServiceContext()
					.getCompanyId(), currentUsername) == null) {
				return currentUsername;
			}
			increment += 1; // NOSONAR
			return regenerateUsername(currentUsername, increment);
		} catch (SystemException e) {
			writeDebugLog(EmployeeUtils.class, e);
		}
		return currentUsername;
	}

	public static String exceptionStacktraceToString(Exception e) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps); // NOSONAR
		ps.close();
		return baos.toString();
	}

	public static void writeDebugLog(Class<?> clazz, Exception e) {
		final Log log = LogFactoryUtil.getLog(clazz);
		if (log.isDebugEnabled())
			log.debug(exceptionStacktraceToString(e));
	}
}
