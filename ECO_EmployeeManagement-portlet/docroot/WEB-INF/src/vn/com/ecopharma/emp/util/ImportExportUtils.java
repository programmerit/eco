package vn.com.ecopharma.emp.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vn.com.ecopharma.emp.constant.EmpAdditionalFieds;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.BankInfoObject;
import vn.com.ecopharma.emp.dto.ColumnItem;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.enumeration.EmployeeExportType;
import vn.com.ecopharma.emp.enumeration.LaborContractType;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

public class ImportExportUtils {

	private static final Log LOGGER = LogFactoryUtil
			.getLog(ImportExportUtils.class);

	private static final String DEST_DATETIME_FORMATTER = "dd/MM/yyyy";

	private static final int STRING_CELL_TYPE = 1;

	private ImportExportUtils() {

	}

	@SuppressWarnings("unchecked")
	public static Workbook generateAndGetExportExcelWorkbook(
			EmployeeExportType type, List<?> employees,
			List<ColumnItem> selectedColumns) {
		Workbook wb = null;
		Sheet ws;
		switch (type) {
		case XLS:
			wb = new HSSFWorkbook();
			break;
		case XLSX:
			wb = new XSSFWorkbook();
			break;
		default:
			break;
		}
		ws = wb.createSheet("Sheet1");

		createExportHeaderRow(wb, ws, selectedColumns);
		int rowNum = 5;
		if (employees.get(0) instanceof Emp) {

			for (Emp employee : (List<Emp>) employees) {
				createRow(wb, ws, rowNum, rowNum - 4, employee);
				rowNum++;
			}
		} else {
			for (EmpIndexedItem eii : (List<EmpIndexedItem>) employees) {
				createRow(wb, ws, rowNum, rowNum - 4, eii, selectedColumns);
				rowNum++;
			}
		}

		return wb;
	}

	/**
	 * @param row
	 * @param cellStyle
	 */
	private static void setEntireRowStyle(Row row, CellStyle cellStyle) {
		// for (int i = 0; i <= 49; i++) {
		// if (row.getCell(i) != null)
		// row.getCell(i).setCellStyle(cellStyle);
		// else {
		// row.getCell(i).setCellValue(StringUtils.EMPTY);
		// row.getCell(i).setCellStyle(cellStyle);
		// }
		// }
	}

	/**
	 * @param wb
	 * @param ws
	 */
	public static void createExportHeaderRow1(Workbook wb, Sheet ws) {
		Row row = ws.createRow(1);
		row.createCell(16).setCellValue("Thông Tin Nhân Viên");
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
		row.createCell(14).setCellValue("Lần ký HĐLĐ");
		row.createCell(15).setCellValue("Ngày tháng năm sinh");
		row.createCell(16).setCellValue("Giới tính");
		row.createCell(17).setCellValue("Nơi Sinh");
		row.createCell(18).setCellValue("Trình độ học vấn");
		row.createCell(19).setCellValue("Chuyên môn");
		row.createCell(20).setCellValue("Trường");
		row.createCell(21).setCellValue("Tình trạng hôn nhân");
		row.createCell(22).setCellValue("Số CMND");
		row.createCell(23).setCellValue("Ngày cấp");
		row.createCell(24).setCellValue("Nơi Cấp");
		row.createCell(25).setCellValue("Địa chỉ Thường trú");
		row.createCell(26).setCellValue("Địa Chỉ Tạm Trú");
		row.createCell(27).setCellValue("Số ĐT Liên lạc");
		row.createCell(28).setCellValue("Email cá nhân");
		row.createCell(29).setCellValue("Email Công ty");
		row.createCell(30).setCellValue("Mã số Thuế");
		row.createCell(31).setCellValue("Số người phụ thuộc");
		row.createCell(32).setCellValue("Tên Người phụ thuộc");
		row.createCell(33).setCellValue("Số sổ BHXH");
		row.createCell(34).setCellValue("Số Thẻ BHYT");

		row.createCell(35).setCellValue("Số Tài khoản NH 1");
		row.createCell(36).setCellValue("Tên Ngân Hàng 1");
		row.createCell(37).setCellValue("Tên Chi nhánh Ngân Hàng 1");

		row.createCell(38).setCellValue("Số Tài khoản NH 2");
		row.createCell(39).setCellValue("Tên Ngân Hàng 2");
		row.createCell(40).setCellValue("Tên Chi nhánh Ngân Hàng 2");

		row.createCell(41).setCellValue("Số Tài khoản NH 3");
		row.createCell(42).setCellValue("Tên Ngân Hàng 3");
		row.createCell(43).setCellValue("Tên Chi nhánh Ngân Hàng 3");

		row.createCell(44).setCellValue("Lương căn bản");
		row.createCell(45).setCellValue("Lương vị trí");
		row.createCell(46).setCellValue("Lương năng lực");
		row.createCell(47).setCellValue("Tổng lương");
		row.createCell(48).setCellValue("Thưởng thành tích");
		row.createCell(49).setCellValue("Ngày nghỉ việc");

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
		for (int i = 0; i <= 49; i++) {
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

	public static void createExportHeaderRow(Workbook wb, Sheet ws,
			List<ColumnItem> selecColumnItems) {
		Row row = ws.createRow(1);
		row.createCell(16).setCellValue("Thông Tin Nhân Viên");
		CellStyle titleCellStyle = wb.createCellStyle();
		Font headerFont = wb.createFont();
		headerFont.setBoldweight((short) 0x2bc);
		titleCellStyle.setFont(headerFont);
		row.getCell(16).setCellStyle(titleCellStyle);

		row = ws.createRow(3);

		row.createCell(0).setCellValue("STT");
		int actualColumnCount = 1;
		for (ColumnItem item : selecColumnItems) {
			row.createCell(actualColumnCount).setCellValue(
					item.getPropertyViName());
			actualColumnCount++;
		}

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
		for (int i = 0; i <= selecColumnItems.size(); i++) {
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

			final UnitGroup unitGroup = employee.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.fetchUnitGroup(employee.getUnitGroupId()) : null;

			final Unit unit = employee.getUnitId() != 0 ? UnitLocalServiceUtil
					.fetchUnit(employee.getUnitId()) : null;

			final Department department = employee.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
					.fetchDepartment(employee.getDepartmentId()) : null;

			final Devision devision = department != null ? DevisionLocalServiceUtil
					.getDevision(department.getDevisionId()) : null;

			final List<Address> addresses = AddressLocalServiceUtil
					.getAddresses(employee.getCompanyId(), Emp.class.getName(),
							employee.getEmpId());

			final List<BankInfoObject> bankInfos = EmployeeUtils
					.getBankInfoObjectsFromEmp(employee.getEmpId());

			final Specialized specialized = employee.getSpecializeId() != 0 ? SpecializedLocalServiceUtil
					.fetchSpecialized(employee.getSpecializeId()) : null;

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

			row.createCell(2).setCellValue(
					EmployeeUtils.getViFullnameFromUser(employeeUser));
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
					employee.getLaborContractSignedTime());

			row.createCell(15).setCellValue(
					employee.getBirthday() != null ? destSdf.format(employee
							.getBirthday()) : StringUtils.EMPTY);
			row.createCell(16).setCellValue(employee.getGender());
			row.createCell(17).setCellValue(employee.getPlaceOfBirth());
			row.createCell(18).setCellValue(employee.getEducation());
			row.createCell(19).setCellValue(
					employee.getEducationSpecialize() != null ? employee
							.getEducationSpecialize() : StringUtils.EMPTY);
			row.createCell(20)
					.setCellValue(
							employee.getUniversityId() != 0 ? UniversityLocalServiceUtil
									.getUniversity(employee.getUniversityId())
									.getName() : StringUtils.EMPTY);
			row.createCell(21).setCellValue(employee.getMaritalStatus());
			row.createCell(22).setCellValue(employee.getIdentityCardNo());
			row.createCell(23).setCellValue(
					employee.getIssuedDate() != null ? destSdf.format(employee
							.getIssuedDate()) : StringUtils.EMPTY);
			row.createCell(24).setCellValue(employee.getIssuedPlace());
			row.createCell(25).setCellValue(presentAddress);
			row.createCell(26).setCellValue(tempAddress);
			row.createCell(27).setCellValue(employee.getContactNumber());
			row.createCell(28).setCellValue(employeeUser.getEmailAddress());
			row.createCell(29).setCellValue(employee.getCompanyEmailAddress());
			row.createCell(30).setCellValue(employee.getPersonalTaxCode());
			row.createCell(31).setCellValue(employee.getNumberOfDependents());
			row.createCell(32).setCellValue(employee.getDependentNames());
			row.createCell(33).setCellValue(employee.getHealthInsuranceNo());
			row.createCell(34).setCellValue(employee.getSocialInsuranceNo());

			row.createCell(35).setCellValue(getBankNoCellInfo(0, bankInfos));
			row.createCell(36).setCellValue(getBankNameCellInfo(0, bankInfos));
			row.createCell(37)
					.setCellValue(getBankBranchCellInfo(0, bankInfos));

			row.createCell(38).setCellValue(getBankNoCellInfo(1, bankInfos));
			row.createCell(39).setCellValue(getBankNameCellInfo(1, bankInfos));
			row.createCell(40)
					.setCellValue(getBankBranchCellInfo(1, bankInfos));

			row.createCell(41).setCellValue(getBankNoCellInfo(2, bankInfos));
			row.createCell(42).setCellValue(getBankNameCellInfo(2, bankInfos));
			row.createCell(43)
					.setCellValue(getBankBranchCellInfo(2, bankInfos));

			row.createCell(44).setCellValue(employee.getBaseWageRates());
			row.createCell(45).setCellValue(employee.getPositionWageRates());
			row.createCell(46).setCellValue(employee.getCapacitySalary());
			row.createCell(47).setCellValue(employee.getTotalSalary());
			row.createCell(48).setCellValue(employee.getBonus());
			row.createCell(49).setCellValue(
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
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static String getBankNoCellInfo(int sizeCheck,
			List<BankInfoObject> objList) {
		return objList.size() > sizeCheck ? objList.get(sizeCheck)
				.getEmpBankInfo().getBankAccountNo() : StringUtils.EMPTY;
	}

	public static String getBankNameCellInfo(int sizeCheck,
			List<BankInfoObject> objList) {
		return objList.size() > sizeCheck ? objList.get(sizeCheck)
				.getEmpBankInfo().getBankName() : StringUtils.EMPTY;
	}

	public static String getBankBranchCellInfo(int sizeCheck,
			List<BankInfoObject> objList) {
		return objList.size() > sizeCheck ? objList.get(sizeCheck)
				.getEmpBankInfo().getBranchName() : StringUtils.EMPTY;
	}

	public static Row createRow1(Workbook wb, Sheet ws, int rowNum,
			int recordNo, EmpIndexedItem employee) {

		final SimpleDateFormat destSdf = new SimpleDateFormat(
				DEST_DATETIME_FORMATTER);
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		try {
			final Row row = ws.createRow(rowNum);
			final User employeeUser = UserLocalServiceUtil.getUser(employee
					.getEmployeeUserId());
			final List<Address> addresses = AddressLocalServiceUtil
					.getAddresses(serviceContext.getCompanyId(),
							Emp.class.getName(), employee.getId());

			final List<BankInfoObject> bankInfos = EmployeeUtils
					.getBankInfoObjectsFromEmp(employee.getId());

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

			row.createCell(2).setCellValue(
					EmployeeUtils.getViFullnameFromUser(employeeUser));
			row.createCell(3).setCellValue(employee.getTitles());
			row.createCell(4).setCellValue(
					employee.getLevelId() != 0 ? LevelLocalServiceUtil
							.getLevel(employee.getLevelId()).getName()
							: StringUtils.EMPTY);
			row.createCell(5).setCellValue(
					employee.getPromotedDate() != null ? employee
							.getPromotedDate().toString() : StringUtils.EMPTY);

			row.createCell(6).setCellValue(employee.getUnitGroup());

			row.createCell(7).setCellValue(employee.getUnit());

			row.createCell(8).setCellValue(employee.getDepartment());

			row.createCell(9).setCellValue(employee.getDevision());

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
			row.createCell(14).setCellValue("Lần 1");

			row.createCell(15).setCellValue(
					employee.getBirthday() != null ? destSdf.format(employee
							.getBirthday()) : StringUtils.EMPTY);
			row.createCell(16).setCellValue(employee.getGender());
			row.createCell(17).setCellValue(StringUtils.EMPTY);
			row.createCell(18).setCellValue(employee.getEducation());
			row.createCell(19).setCellValue(employee.getEducationSpecialize());
			row.createCell(20)
					.setCellValue(
							employee.getUniversityId() != 0 ? UniversityLocalServiceUtil
									.getUniversity(employee.getUniversityId())
									.getName() : StringUtils.EMPTY);
			row.createCell(21).setCellValue(employee.getMaritalStatus());
			row.createCell(22).setCellValue(employee.getIdentityCardNo());
			row.createCell(23).setCellValue(
					employee.getIssuedDate() != null ? destSdf.format(employee
							.getIssuedDate()) : StringUtils.EMPTY);
			row.createCell(24).setCellValue(employee.getIssuedPlace());
			row.createCell(25).setCellValue(presentAddress);
			row.createCell(26).setCellValue(tempAddress);
			row.createCell(27).setCellValue(employee.getContactNumber());
			row.createCell(28).setCellValue(employeeUser.getEmailAddress());
			row.createCell(29).setCellValue(employee.getPersonalEmail());
			row.createCell(30).setCellValue(employee.getPersonalTaxCode());
			row.createCell(31).setCellValue(employee.getNumberOfDependents());
			row.createCell(32).setCellValue(employee.getDependentNames());
			row.createCell(34).setCellValue(employee.getHealthInsuranceNo());
			row.createCell(35).setCellValue(employee.getSocialInsuranceNo());

			row.createCell(35).setCellValue(getBankNoCellInfo(0, bankInfos));
			row.createCell(36).setCellValue(getBankNameCellInfo(0, bankInfos));
			row.createCell(37)
					.setCellValue(getBankBranchCellInfo(0, bankInfos));

			row.createCell(38).setCellValue(getBankNoCellInfo(1, bankInfos));
			row.createCell(39).setCellValue(getBankNameCellInfo(1, bankInfos));
			row.createCell(40)
					.setCellValue(getBankBranchCellInfo(1, bankInfos));

			row.createCell(41).setCellValue(getBankNoCellInfo(2, bankInfos));
			row.createCell(42).setCellValue(getBankNameCellInfo(2, bankInfos));
			row.createCell(43)
					.setCellValue(getBankBranchCellInfo(2, bankInfos));

			row.createCell(44).setCellValue(employee.getBaseWageRates());
			row.createCell(45).setCellValue(employee.getPositionWageRates());
			row.createCell(46).setCellValue(employee.getCapacitySalary());
			row.createCell(47).setCellValue(employee.getTotalSalary());
			row.createCell(48).setCellValue(employee.getBonus());
			row.createCell(49).setCellValue(
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
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public static Row createRow(Workbook wb, Sheet ws, int rowNum,
			int recordNo, EmpIndexedItem employee,
			List<ColumnItem> selectedColumns) {

		final Row row = ws.createRow(rowNum);

		row.createCell(0).setCellValue(recordNo);
		int i = 1;
		for (ColumnItem item : selectedColumns) {
			row.createCell(i).setCellValue(
					employee.getItemKeyValueMap(item.isBankField(),
							item.isAddressField()).get(item.getPropertyName())
							.toString());
			i++;
		}
		CellStyle cellStyle = wb.createCellStyle();
		cellStyle.setBorderTop((short) 0x7);
		cellStyle.setBorderBottom((short) 0x7);
		cellStyle.setBorderRight((short) 0x1);
		cellStyle.setBorderLeft((short) 0x1);
		setEntireRowStyle(row, cellStyle);
		return row;
	}

	public static String getAddressStringFromAddressObj(Address address) {
		return address.getStreet1() + ", " + address.getStreet3().split("_")[1]
				+ ", " + address.getRegion().getName();
	}

	/**
	 * @param street3
	 *            VN-65_Bình Tân
	 * @return
	 */
	public static District getDistrictByStreet3(Address address) {
		final String[] districtArr = address.getStreet3().split("_");
		return DistrictLocalServiceUtil.findByRegionCodeAndName(districtArr[0],
				districtArr[1]);
	}

	public static String getFullAddressString(Address address) {
		if (address == null)
			return StringUtils.EMPTY;

		String city = address.getRegion().getName();
		String street = address.getStreet1();
		String districtName = StringUtils.trimToNull(address.getStreet3()) != null ? getDistrictNameFromStreet3String(address
				.getStreet3()) : StringUtils.EMPTY;

		return street + ", " + districtName + ", " + city;
	}

	private static String getDistrictNameFromStreet3String(String street3) {
		return street3.indexOf("-") != -1 ? street3.split("-")[1]
				: StringUtils.EMPTY;
	}

	public static List<Region> getAllVNRegions() {
		try {
			return RegionServiceUtil.getRegions(17L);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(ImportExportUtils.class).info(
					"Exception on getAllVNRegions()", e);
		}
		return new ArrayList<>();
	}

	public static Region getRegionFromListByName(List<Region> list, String name) {
		for (Region region : list) {
			if (region.getName().trim().equalsIgnoreCase(name.trim())) {
				return region;
			}
		}
		return null;
	}

	public static boolean isEmptyOrNullStringCell(Cell cell) {
		if (cell == null)
			return true;
		cell.setCellType(STRING_CELL_TYPE);
		return StringUtils.trimToNull(cell.getStringCellValue()) == null;
	}

	public static String getReturnValueFromStringCell(Cell cell) {
		return isEmptyOrNullStringCell(cell) ? StringUtils.EMPTY : StringUtils
				.trimToEmpty(cell.getStringCellValue());
	}

	public static List<ColumnItem> createDefaultColumnItems() {
		final List<ColumnItem> result = new ArrayList<>();
		result.add(new ColumnItem(1, EmpField.EMP_CODE, "Mã NV"));
		result.add(new ColumnItem(2, EmpField.VN_FULL_NAME, "Họ và Tên"));
		result.add(new ColumnItem(3, EmpField.TITLES, "Chức danh"));
		result.add(new ColumnItem(4, EmpField.LEVEL, "Cấp bậc"));
		result.add(new ColumnItem(5, EmpField.PROMOTED_DATE, "Ngày bổ nhiệm"));
		result.add(new ColumnItem(6, EmpField.UNIT_GROUP, "Nhóm"));
		result.add(new ColumnItem(7, EmpField.UNIT, "Bộ phận"));
		result.add(new ColumnItem(8, EmpField.DEPARTMENT, "Phòng"));
		result.add(new ColumnItem(9, EmpField.DEVISION, "Khối"));
		result.add(new ColumnItem(10, EmpField.JOINED_DATE, "Ngày vào"));
		result.add(new ColumnItem(11, EmpField.LABOR_CONTRACT_SIGNED_DATE,
				"Ngày ký HĐ"));
		result.add(new ColumnItem(12, EmpField.LABOR_CONTRACT_EXPIRED_DATE,
				"Ngày kết thúc HĐ"));
		result.add(new ColumnItem(13, EmpField.LABOR_CONTRACT_TYPE, "Loại HĐLĐ"));
		result.add(new ColumnItem(14, EmpField.LABOR_CONTRACT_SIGNED_TIME,
				"Lần ký HĐLĐ"));
		result.add(new ColumnItem(15, EmpField.BIRTHDAY, "Ngày tháng năm sinh"));
		result.add(new ColumnItem(16, EmpField.GENDER, "Giới tính"));
		result.add(new ColumnItem(17, EmpField.PLACE_OF_BIRTH, "Nơi Sinh"));
		result.add(new ColumnItem(18, EmpField.EDUCATION, "Trình độ học vấn"));
		result.add(new ColumnItem(19, EmpField.SPECIALIZED, "Chuyên môn"));
		result.add(new ColumnItem(20, EmpField.UNIVERSITY, "Trường"));
		result.add(new ColumnItem(21, EmpField.MARITAL_STATUS,
				"Tình trạng hôn nhân"));
		result.add(new ColumnItem(22, EmpField.IDENTITY_CARD_NO, "Số CMND"));
		result.add(new ColumnItem(23, EmpField.ISSUED_DATE, "Ngày cấp"));
		result.add(new ColumnItem(24, EmpField.ISSUED_PLACE, "Nơi Cấp"));
		result.add(new ColumnItem(25, EmpAdditionalFieds.PRESENT_ADDRESS,
				"Địa chỉ Thường trú", false, true));
		result.add(new ColumnItem(26, EmpAdditionalFieds.PRESENT_ADDRESS,
				"Địa Chỉ Tạm Trú", false, true));
		result.add(new ColumnItem(27, EmpField.CONTACT_NUMBER, "Số ĐT Liên lạc"));
		result.add(new ColumnItem(28, EmpField.PERSONAL_EMAIL_ADDRESS,
				"Email cá nhân"));
		result.add(new ColumnItem(29, EmpField.EMAIL, "Email Công ty"));
		result.add(new ColumnItem(30, EmpField.TAX_CODE, "Mã số Thuế"));
		result.add(new ColumnItem(31, EmpField.NUMBER_OF_DEPENDENTS,
				"Số người phụ thuộc"));
		result.add(new ColumnItem(32, EmpField.DEPENDENT_NAMES,
				"Tên Người phụ thuộc"));
		result.add(new ColumnItem(33, EmpField.SOCIAL_INSURANCE_NO,
				"Số sổ BHXH"));
		result.add(new ColumnItem(34, EmpField.HEALTH_INSURANCE_NO,
				"Số Thẻ BHYT"));
		result.add(new ColumnItem(35, EmpAdditionalFieds.BANK_ACCOUNT_NO1,
				"Số Tài khoản NH 1", true, false));
		result.add(new ColumnItem(36, EmpAdditionalFieds.BANK_NAME1,
				"Tên Ngân Hàng 1", true, false));
		result.add(new ColumnItem(37, EmpAdditionalFieds.BANK_BRANCH_NAME1,
				"Tên Chi nhánh Ngân Hàng 1", true, false));

		result.add(new ColumnItem(38, EmpAdditionalFieds.BANK_ACCOUNT_NO2,
				"Số Tài khoản NH 2", true, false));
		result.add(new ColumnItem(39, EmpAdditionalFieds.BANK_NAME2,
				"Tên Ngân Hàng 2", true, false));
		result.add(new ColumnItem(40, EmpAdditionalFieds.BANK_BRANCH_NAME2,
				"Tên Chi nhánh Ngân Hàng 2", true, false));

		result.add(new ColumnItem(41, EmpAdditionalFieds.BANK_ACCOUNT_NO3,
				"Số Tài khoản NH 3", true, false));
		result.add(new ColumnItem(42, EmpAdditionalFieds.BANK_NAME3,
				"Tên Ngân Hàng 3", true, false));
		result.add(new ColumnItem(43, EmpAdditionalFieds.BANK_BRANCH_NAME3,
				"Tên Chi nhánh Ngân Hàng 3", true, false));
		result.add(new ColumnItem(44, EmpField.BASE_WAGE_RATES, "Lương căn bản"));
		result.add(new ColumnItem(45, EmpField.POSITION_WAGE_RATES,
				"Lương vị trí"));
		result.add(new ColumnItem(46, EmpField.CAPACITY_SALARY,
				"Lương năng lực"));
		result.add(new ColumnItem(47, EmpField.TOTAL_SALARY, "Tổng lương"));
		result.add(new ColumnItem(48, EmpField.BONUS, "Thưởng thành tích"));
		result.add(new ColumnItem(49, EmpField.RESIGNED_DATE, "Ngày nghỉ việc"));
		return result;
	}

}
