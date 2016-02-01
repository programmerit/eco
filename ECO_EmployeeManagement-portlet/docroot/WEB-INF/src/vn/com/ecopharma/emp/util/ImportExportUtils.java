package vn.com.ecopharma.emp.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import vn.com.ecopharma.emp.dto.BankInfoObject;
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
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Address;
import com.liferay.portal.model.Region;
import com.liferay.portal.model.User;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.RegionServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.util.DLUtil;

public class ImportExportUtils {

	private static final Log LOGGER = LogFactoryUtil
			.getLog(ImportExportUtils.class);

	private static final String DEST_DATETIME_FORMATTER = "dd/MM/yyyy";

	private static final int STRING_CELL_TYPE = 1;

	private ImportExportUtils() {

	}

	@SuppressWarnings("unchecked")
	public static Workbook generateAndGetExportExcelWorkbook(
			EmployeeExportType type, List<?> employees) {
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

		createExportHeaderRow(wb, ws);
		int rowNum = 5;
		if (employees.get(0) instanceof Emp) {

			for (Emp employee : (List<Emp>) employees) {
				createRow(wb, ws, rowNum, rowNum - 4, employee);
				rowNum++;
			}
		} else {
			for (EmpIndexedItem eii : (List<EmpIndexedItem>) employees) {
				createRow(wb, ws, rowNum, rowNum - 4, eii);
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
	public static void createExportHeaderRow(Workbook wb, Sheet ws) {
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

	private static String getBankNoCellInfo(int sizeCheck,
			List<BankInfoObject> objList) {
		return objList.size() > sizeCheck ? objList.get(sizeCheck)
				.getEmpBankInfo().getBankAccountNo() : StringUtils.EMPTY;
	}

	private static String getBankNameCellInfo(int sizeCheck,
			List<BankInfoObject> objList) {
		return objList.size() > sizeCheck ? objList.get(sizeCheck)
				.getEmpBankInfo().getBankName() : StringUtils.EMPTY;
	}

	private static String getBankBranchCellInfo(int sizeCheck,
			List<BankInfoObject> objList) {
		return objList.size() > sizeCheck ? objList.get(sizeCheck)
				.getEmpBankInfo().getBranchName() : StringUtils.EMPTY;
	}

	public static Row createRow(Workbook wb, Sheet ws, int rowNum,
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

	@SuppressWarnings("unchecked")
	@Deprecated
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

			createExportHeaderRow(wb, ws);
			int rowNum = 5;
			if (employees.get(0) instanceof Emp) {
				for (Emp employee : (List<Emp>) employees) {
					createRow(wb, ws, rowNum, rowNum - 4, employee);
					rowNum++;
				}
			} else {
				for (EmpIndexedItem eii : (List<EmpIndexedItem>) employees) {
					createRow(wb, ws, rowNum, rowNum - 4, eii);
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
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return StringUtils.EMPTY;
	}

	private static String getAddressStringFromAddressObj(Address address) {
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

}
