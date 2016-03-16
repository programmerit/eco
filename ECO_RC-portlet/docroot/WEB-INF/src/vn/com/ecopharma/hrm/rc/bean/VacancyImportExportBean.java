package vn.com.ecopharma.hrm.rc.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.hrm.rc.dto.VacancyImportExportDTO;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "vacancyIEBean")
@RequestScoped
public class VacancyImportExportBean {

	public void handleFileImport(FileUploadEvent fileUploadEvent) {
		try {
			final ServiceContext serviceContext = LiferayFacesContext
					.getInstance().getServiceContext();
			final UploadedFile uploadedFile = fileUploadEvent.getFile();
			final InputStream is = uploadedFile.getInputstream();

			final XSSFWorkbook wb = new XSSFWorkbook(is);
			final XSSFSheet sheet = wb.getSheetAt(0);
			for (int i = 5; i <= sheet.getLastRowNum(); i++) {
				if (sheet.getRow(i) != null) {
					final XSSFRow r = sheet.getRow(i);

					final VacancyImportExportDTO vDTO = new VacancyImportExportDTO(
							r);
					if (!vDTO.isExistedVacancy()) {
						Vacancy vacancy = VacancyLocalServiceUtil
								.createPrePersistedVacancy(
										vDTO.getVacancyCode(), vDTO.getName(),
										vDTO.getNumberOfPosition(),
										vDTO.getTitlesId(),
										vDTO.getDescription(),
										vDTO.getPostedDate(),
										vDTO.getExpiredDate(), vDTO.getStatus());
						VacancyLocalServiceUtil.addVacancy(vacancy,
								new ArrayList<Long>(), serviceContext);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
