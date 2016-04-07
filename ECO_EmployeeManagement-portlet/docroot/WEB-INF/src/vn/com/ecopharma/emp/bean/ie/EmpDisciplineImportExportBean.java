package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
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
	private static final int ACTUAL_DATA_ROW_FROM = 7;
	private static final int EMP_CODE_CELL = 1;

	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		final UploadedFile uploadedFile = fileUploadEvent.getFile();
		try {
			final XSSFWorkbook wb = new XSSFWorkbook(
					uploadedFile.getInputstream());
			XSSFSheet sheet = null;
			sheet = wb.getSheetAt(MN_SHEET);
			String decision = StringUtils.EMPTY;

			decision = getFormattedDecisionNo(sheet.getRow(DECISION_NO_ROW));
			List<EmpDisciplineItem> disciplineItems = new ArrayList<>();
			for (int i = ACTUAL_DATA_ROW_FROM; i <= sheet.getLastRowNum(); i++) {
				final XSSFRow row = sheet.getRow(i);
				if (row != null && row.getCell(EMP_CODE_CELL) != null) {
					EmpDisciplineItem item = new EmpDisciplineItem(row,
							decision);
					disciplineItems.add(item);
				}
			}

			sheet = wb.getSheetAt(MB_SHEET);
			if (sheet != null) {
				decision = getFormattedDecisionNo(sheet.getRow(DECISION_NO_ROW));
				for (int i = ACTUAL_DATA_ROW_FROM; i <= sheet.getLastRowNum(); i++) {
					final XSSFRow row = sheet.getRow(i);
					if (row != null && row.getCell(EMP_CODE_CELL) != null) {
						EmpDisciplineItem item = new EmpDisciplineItem(row,
								decision);
						disciplineItems.add(item);
					}
				}
			}

			for (EmpDisciplineItem item : disciplineItems) {
				final long empId = item.getEmpId();
				if (empId != 0L) {
					EmpDisciplineLocalServiceUtil.addEmpDiscipline(empId,
							item.getDecisionNo(), StringUtils.EMPTY,
							item.getDisciplineType(), new Date(),
							item.getAdditionDisciplineType(),
							item.getDescription(), serviceContext);
					System.out.println(item.getDecisionNo() + "  "
							+ item.toString());

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

	private String getFormattedDecisionNo(Row row) {
		String unformattedRowString = row.getCell(0).getStringCellValue();
		if (StringUtils.trimToNull(unformattedRowString) == null)
			return StringUtils.EMPTY;
		final String[] strArr = unformattedRowString.split(" ");
		String decisionNo = strArr[strArr.length - 1];
		return decisionNo;
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

		private static final int SOP_SUBTRACT_CELL = 5;
		private static final int SALES_SUBTRACT_CELL = 6;

		private String decisionNo;
		private String empCode;
		private String disciplineType = DisciplineType.REPRIMAND.toString();
		private String additionDisciplineType;
		private String description;

		public EmpDisciplineItem(String empCode, String disciplineType,
				String additionDisciplineType, String description) {
			this.empCode = getActualEmpCode(empCode);
			this.disciplineType = disciplineType;
			this.additionDisciplineType = additionDisciplineType;
			this.description = description;
		}

		public EmpDisciplineItem(String empCode, String additionDisciplineType,
				String description) {
			this(empCode, DisciplineType.REPRIMAND.toString(),
					additionDisciplineType, description);
		}

		public EmpDisciplineItem(Row row, String decisionNo) {
			this.decisionNo = decisionNo;
			this.empCode = getActualEmpCode(getCellValueAsString(row.getCell(1)));
			this.additionDisciplineType = getFormattedAdditionDiscipline(row);
			this.description = getCellValueAsString(row.getCell(8));
			System.out.println(empCode + "________" + additionDisciplineType);

		}

		private long getEmpId() {
			if (empCode.isEmpty())
				return 0L;
			final Emp empByEmpCode = EmpLocalServiceUtil.findByEmpCode(empCode);
			return empByEmpCode != null ? empByEmpCode.getEmpId() : 0L;
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

		@Override
		public String toString() {
			return this.empCode + "  " + this.disciplineType + "  "
					+ this.additionDisciplineType + "  " + this.description;
		}
	}

}
