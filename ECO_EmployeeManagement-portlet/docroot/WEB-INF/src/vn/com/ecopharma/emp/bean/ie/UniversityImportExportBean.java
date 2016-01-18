package vn.com.ecopharma.emp.bean.ie;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
public class UniversityImportExportBean implements Serializable {

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
			List<UniversityItem> universityItems = new ArrayList<>();
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				final XSSFRow r = sheet.getRow(i);
				if (r.getCell(1) != null) {
					String name = r.getCell(1).getStringCellValue();
					String code = r.getCell(2) != null ? r.getCell(2)
							.getStringCellValue() : StringUtils.EMPTY;
					String telFax = r.getCell(3) != null ? r.getCell(3)
							.getStringCellValue() : StringUtils.EMPTY;
					universityItems.add(new UniversityItem(name, code, telFax));
				}
			}
			for (UniversityItem item : universityItems) {
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
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
	}

	public String getSheetNameOrIndex() {
		return sheetNameOrIndex;
	}

	public void setSheetNameOrIndex(String sheetNameOrIndex) {
		this.sheetNameOrIndex = sheetNameOrIndex;
	}

	private class UniversityItem {
		private String name;
		private String code;
		private String telFax;

		public UniversityItem(String name, String code, String telFax) {
			super();
			this.name = name;
			this.code = code;
			this.telFax = telFax;
		}

		public String getName() {
			return name;
		}

		public String getCode() {
			return code;
		}

		public String getTelFax() {
			return telFax;
		}
	}

}
