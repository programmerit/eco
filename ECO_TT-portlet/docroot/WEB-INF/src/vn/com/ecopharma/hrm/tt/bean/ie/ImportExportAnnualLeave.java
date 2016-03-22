package vn.com.ecopharma.hrm.tt.bean.ie;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;
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
	private static final int START_ROW_NUM = 5;
	private static final int START_CELL_NUM = 0;

	public void handleFileImport(FileUploadEvent event) {
		try {
			final UploadedFile uploadedFile = event.getFile();
			final InputStream is = uploadedFile.getInputstream();

			final XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(0);
			for (int i = START_ROW_NUM; i <= sheet.getLastRowNum(); i++) {
				final Row row = sheet.getRow(i);
				if (row != null && row.getCell(START_CELL_NUM) != null) {
					String unformattedEmpCode = StringUtils.trimToEmpty(row
							.getCell(1).getStringCellValue());

					String empCode = TTUtils
							.getActualEmpCode(unformattedEmpCode);
					double prevYearLeaves = row.getCell(2)
							.getNumericCellValue();
					double janLeave = row.getCell(3).getNumericCellValue();
					double febLeave = row.getCell(4).getNumericCellValue();

					double totalLeave = prevYearLeaves
							+ getCurrentMonthAnnualLeaveCount();

					double totalLeaveLeft = totalLeave - (janLeave + febLeave);

					Emp emp = EmpLocalServiceUtil.findByEmpCode(empCode);
					if (emp != null) {
						EmpAnnualLeave currentEmpAnnualLeave = EmpAnnualLeaveLocalServiceUtil
								.fetchByEmp(emp.getEmpId());
						if (currentEmpAnnualLeave == null) {

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

}
