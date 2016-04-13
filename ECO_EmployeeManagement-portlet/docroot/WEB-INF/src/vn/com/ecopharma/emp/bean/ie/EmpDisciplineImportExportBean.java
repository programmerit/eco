package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.dto.ImportExportItem;
import vn.com.ecopharma.emp.enumeration.DisciplineType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "disciplineIEBean")
@ViewScoped
public class EmpDisciplineImportExportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpDisciplineImportExportBean.class);

	private String sheetNameOrIndex = "1";

	private static final int MN_SHEET = 0;
	private static final int MB_SHEET = 1;

	private static final int DECISION_NO_ROW = 3;
	private static final int APPLIED_DATE_ROW = 4;
	private static final int ACTUAL_DATA_ROW_FROM = 8;

	private static final int EMP_CODE_CELL = 1;
	private static final int SOP_SUBTRACT_CELL = 5;
	private static final int SALES_SUBTRACT_CELL = 6;
	private static final int REPRIMAND_DECISION_CELL = 7;
	private static final int DESCRIPTION_CELL = 8;

	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		final UploadedFile uploadedFile = fileUploadEvent.getFile();
		try {
			final XSSFWorkbook wb = new XSSFWorkbook(
					uploadedFile.getInputstream());
			List<EmpDisciplineItem> disciplineItems = new ArrayList<>();

			disciplineItems.addAll(bindItemsFromWorkSheet(wb
					.getSheetAt(MN_SHEET)));
			disciplineItems.addAll(bindItemsFromWorkSheet(wb
					.getSheetAt(MB_SHEET)));

			for (EmpDisciplineItem item : disciplineItems) {
				final long empId = item.getEmpId();
				if (empId != 0L) {
					EmpDisciplineLocalServiceUtil.addEmpDiscipline(empId,
							item.getDecisionNo(), StringUtils.EMPTY,
							item.getDisciplineType(), item.getAppliedDate(),
							item.getAdditionDisciplineType(),
							item.getDescription(), serviceContext);
					System.out.println(item.getDecisionNo() + "  "
							+ item.getAppliedDate() + "  " + item.toString());

				}

			}
			FacesMessage message = new FacesMessage("Notice",
					"Successfully Imported");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (IOException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
	}

	private List<EmpDisciplineItem> bindItemsFromWorkSheet(XSSFSheet sheet) {
		final List<EmpDisciplineItem> result = new ArrayList<>();
		if (sheet == null)
			return result;
		final String decision = getFormattedDecisionNo(sheet
				.getRow(DECISION_NO_ROW));
		final Date appliedDate = getAppliedDate(sheet.getRow(APPLIED_DATE_ROW));
		for (int i = ACTUAL_DATA_ROW_FROM; i <= sheet.getLastRowNum(); i++) {
			final XSSFRow row = sheet.getRow(i);
			if (row != null && row.getCell(EMP_CODE_CELL) != null) {
				EmpDisciplineItem item = new EmpDisciplineItem(row,
						appliedDate, decision);
				result.add(item);
			}
		}
		return result;

	}

	private String getFormattedDecisionNo(Row row) {
		String unformattedRowString = row.getCell(0).getStringCellValue();
		if (StringUtils.trimToNull(unformattedRowString) == null)
			return StringUtils.EMPTY;
		final String[] strArr = unformattedRowString.split(" ");
		String decisionNo = strArr[strArr.length - 1];
		return decisionNo;
	}

	private Date getAppliedDate(Row row) {
		String unforrmattedRowString = row.getCell(0).getStringCellValue();
		if (StringUtils.trimToNull(unforrmattedRowString) == null)
			return null;
		final String[] strArr = unforrmattedRowString.split(" ");
		String unformattedDate = strArr[strArr.length - 1];

		String[] dateTimeStrArr = unformattedDate.split("/");

		if (dateTimeStrArr.length != 3)
			return null;

		int date = Integer.valueOf(dateTimeStrArr[0]);
		int actualMonth = Integer.valueOf(dateTimeStrArr[1]);
		int month = actualMonth - 1;
		int year = Integer.valueOf(dateTimeStrArr[2]);
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, date);
		return calendar.getTime();
	}

	public String getSheetNameOrIndex() {
		return sheetNameOrIndex;
	}

	public void setSheetNameOrIndex(String sheetNameOrIndex) {
		this.sheetNameOrIndex = sheetNameOrIndex;
	}

	private final class EmpDisciplineItem extends ImportExportItem {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String decisionNo;
		private Date appliedDate;
		private String empCode;
		private String disciplineType = DisciplineType.REPRIMAND.toString();
		private String additionDisciplineType;
		private String description;

		public EmpDisciplineItem(Row row, Date appliedDate, String decisionNo) {
			this.decisionNo = decisionNo;
			this.appliedDate = appliedDate;
			this.empCode = getActualEmpCode(getCellValueAsString(row
					.getCell(EMP_CODE_CELL)));
			this.disciplineType = getDisciplineType(
					row.getCell(REPRIMAND_DECISION_CELL)).toString();
			this.additionDisciplineType = getFormattedAdditionDiscipline(row);
			this.description = getCellValueAsString(row
					.getCell(DESCRIPTION_CELL));

		}

		private long getEmpId() {
			if (empCode.isEmpty())
				return 0L;
			final Emp empByEmpCode = EmpLocalServiceUtil.findByEmpCode(empCode);
			return empByEmpCode != null ? empByEmpCode.getEmpId() : 0L;
		}

		private DisciplineType getDisciplineType(Cell cell) {
			if (cell == null)
				return DisciplineType.NONE;
			boolean isReprimand = getCellValueAsString(cell).equalsIgnoreCase(
					"x");
			return isReprimand ? DisciplineType.REPRIMAND : DisciplineType.NONE;
		}

		private String getFormattedAdditionDiscipline(Row row) {
			final StringBuilder result = new StringBuilder();
			String SOPsSubtract = row.getCell(SOP_SUBTRACT_CELL) != null ? getFormattedPercentageCellValue(row
					.getCell(SOP_SUBTRACT_CELL)) : StringUtils.EMPTY;
			String salesSubtract = row.getCell(SALES_SUBTRACT_CELL) != null ? getFormattedPercentageCellValue(row
					.getCell(SALES_SUBTRACT_CELL)) : StringUtils.EMPTY;

			if (SOPsSubtract.isEmpty() && salesSubtract.isEmpty()) {
				return StringUtils.EMPTY;
			}

			if (!SOPsSubtract.isEmpty() && !salesSubtract.isEmpty()) {
				result.append("Trừ SOPs " + SOPsSubtract);
				result.append("; ");
				result.append("Trừ Doanh số " + salesSubtract);
				return result.toString();
			}

			if (SOPsSubtract.isEmpty())
				return "Trừ Doanh số " + salesSubtract;

			if (salesSubtract.isEmpty())
				return "Trừ SOPs " + SOPsSubtract;

			return StringUtils.EMPTY;
		}

		public String getDisciplineType() {
			return disciplineType;
		}

		public String getAdditionDisciplineType() {
			return additionDisciplineType;
		}

		public String getDescription() {
			return description;
		}

		public String getDecisionNo() {
			return decisionNo;
		}

		public Date getAppliedDate() {
			return appliedDate;
		}

		@Override
		public String toString() {
			return this.empCode + "  " + this.disciplineType + "  "
					+ this.additionDisciplineType + "  " + this.description;
		}
	}

}
