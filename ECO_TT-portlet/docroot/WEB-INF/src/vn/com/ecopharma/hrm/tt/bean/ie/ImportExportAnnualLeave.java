package vn.com.ecopharma.hrm.tt.bean.ie;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class ImportExportAnnualLeave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SHEET_INDEX = 0;
	private static final int START_ROW_NUM = 4;
	private static final int START_CELL_NUM = 0;

	private static final int NO_CELL = 0;

	private static final int EMP_CODE_CELL = 1;
	private static final int LEAVE_LEFT_CELL = 3;
	private static final int JAN_LEAVE = 4;
	private static final int FEB_LEAVE = 5;

	public void handleFileImport(FileUploadEvent event) {
		try {
			final UploadedFile uploadedFile = event.getFile();
			final InputStream is = uploadedFile.getInputstream();

			final XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(SHEET_INDEX);
			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				final Row row = sheet.getRow(i);
				if (row != null && row.getCell(START_CELL_NUM) != null) {
					if (isValidDataCell(row.getCell(NO_CELL))) {
						String unformattedEmpCode = StringUtils.trimToEmpty(row
								.getCell(EMP_CODE_CELL).getStringCellValue());
						String empCode = TTUtils
								.getActualEmpCode(unformattedEmpCode);
						double totalPrevYearLeaves = row.getCell(
								LEAVE_LEFT_CELL).getNumericCellValue();
						double janLeave = row.getCell(JAN_LEAVE) != null ? row
								.getCell(JAN_LEAVE).getNumericCellValue()
								: 0.0D;
						double febLeave = row.getCell(FEB_LEAVE) != null
								&& row.getCell(FEB_LEAVE).getCellType() == 0 ? row
								.getCell(FEB_LEAVE).getNumericCellValue()
								: 0.0D;

						double totalLeave = totalPrevYearLeaves
								+ getCurrentMonthAnnualLeaveCount();

						double totalLeaveLeft = totalLeave
								- (janLeave + febLeave);

						Emp emp = EmpLocalServiceUtil.findByEmpCode(empCode);
						if (emp != null && emp.getEmpId() == 188697)
							System.out.println("TEST");
						if (emp != null) {
							EmpAnnualLeave currentEmpAnnualLeave = EmpAnnualLeaveLocalServiceUtil
									.fetchByEmp(emp.getEmpId());
							if (currentEmpAnnualLeave == null) {
								EmpAnnualLeaveLocalServiceUtil
										.addEmpAnnualLeave(emp.getEmpId(),
												totalLeave, totalLeaveLeft,
												totalPrevYearLeaves,
												TTUtils.getServiceContext());
							} else {
								EmpAnnualLeaveLocalServiceUtil
										.updateEmpAnnualLeave(
												currentEmpAnnualLeave,
												totalLeave, totalLeaveLeft,
												totalPrevYearLeaves);
							}

						}
					}
				}
			}

		} catch (IOException e) {
			LogFactoryUtil.getLog(ImportExportAnnualLeave.class).info(
					"Error while executing import data", e);
		}

	}

	public double getCurrentMonthAnnualLeaveCount() {
		return 3.0D;
	}

	public boolean isValidDataCell(Cell noCell) {
		if (noCell == null || noCell.getCellType() == 3) // 3: BLANK_CELL_TYPE
			return false;
		if (noCell.getCellType() == 1)
			return StringUtils.trimToNull(noCell.getStringCellValue()) != null;
		return true;
	}

}
