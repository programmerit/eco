package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
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
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
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
			.getLog(UniversityImportExportBean.class);

	private String sheetNameOrIndex = "1";

	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();
		final UploadedFile uploadedFile = fileUploadEvent.getFile();
		try {
			final XSSFWorkbook wb = new XSSFWorkbook(
					uploadedFile.getInputstream());
			final XSSFSheet sheet = wb.getSheetAt(1);
			final String decisionNo = 
			List<EmpDisciplineItem> disciplineItems = new ArrayList<>();
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				final XSSFRow r = sheet.getRow(i);
				if (r.getCell(1) != null) {
					String code = r.getCell(1) != null ? r.getCell(2)
							.getStringCellValue() : StringUtils.EMPTY;
					String telFax = r.getCell(3) != null ? r.getCell(3)
							.getStringCellValue() : StringUtils.EMPTY;
					disciplineItems.add(new EmpDisciplineItem(name, code,
							telFax));
				}
			}
			for (EmpDisciplineItem item : disciplineItems) {
				System.out.println("Name: " + item.getName() + " Code: "
						+ item.getCode() + " Tel/Fax: " + item.getTelFax());
				if (UniversityLocalServiceUtil.findByName(item.getName()) == null) {
					UniversityLocalServiceUtil.addUniversity(item.getName(),
							item.getCode(), item.getTelFax(), serviceContext);
				} else {
					System.out.println("EXISTED");
				}
			}
			FacesMessage message = new FacesMessage("Notice",
					"Sucessfully Imported");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (IOException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
	}

	private String getFormattedDecisionNo(Row row) {
		String unformattedRowString = row.getCell(1).getStringCellValue();
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
			this.empCode = getActualEmpCode(empCode);
			this.additionDisciplineType = additionDisciplineType;
			this.description = description;
		}

		public EmpDisciplineItem(Row row) {
			this.empCode = getActualEmpCode(getCellValueAsString(row.getCell(1)));
			this.additionDisciplineType = getFormattedAdditionDiscipline(row);
			this.description = getCellValueAsString(row.getCell(8));
		}

		private String getFormattedAdditionDiscipline(Row row) {
			final StringBuilder result = new StringBuilder();
			String SOPsSubtract = getCellValueAsString(row.getCell(5));
			String salesSubtract = getCellValueAsString(row.getCell(6));

			if (SOPsSubtract.isEmpty() && salesSubtract.isEmpty()) {
				return StringUtils.EMPTY;
			}

			if (!SOPsSubtract.isEmpty() && salesSubtract.isEmpty()) {
				result.append(SOPsSubtract);
				result.append("; ");
				result.append(salesSubtract);
				return result.toString();
			}

			if (SOPsSubtract.isEmpty())
				return salesSubtract;

			if (salesSubtract.isEmpty())
				return SOPsSubtract;

			return StringUtils.EMPTY;
		}

		public String getEmpCode() {
			return empCode;
		}

		public void setEmpCode(String empCode) {
			this.empCode = empCode;
		}

		public String getDisciplineType() {
			return disciplineType;
		}

		public void setDisciplineType(String disciplineType) {
			this.disciplineType = disciplineType;
		}

		public String getAdditionDisciplineType() {
			return additionDisciplineType;
		}

		public void setAdditionDisciplineType(String additionDisciplineType) {
			this.additionDisciplineType = additionDisciplineType;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}

}
