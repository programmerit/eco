package vn.com.ecopharma.hrm.rc.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.hrm.rc.dto.CandidateImportExportDTO;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "candidateIEBean")
@RequestScoped
public class CandidateImportExportBean {

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

					final CandidateImportExportDTO cDTO = new CandidateImportExportDTO(
							r);
					if (!cDTO.isCandidateExisted()) {
						Candidate candidate = CandidateLocalServiceUtil
								.createPrePersistCandidate(
										cDTO.getCandidateCode(),
										cDTO.getFullName(),
										cDTO.getEmailAddress(),
										cDTO.getContactNumber(),
										cDTO.getIdentityCardNo(), 0,
										cDTO.getVacancyId(),
										cDTO.getApplicationDate(),
										cDTO.getStatus());

						CandidateLocalServiceUtil.addCandidate(candidate,
								cDTO.getVacancyId(), new ArrayList<Long>(),
								new ArrayList<Long>(),
								new LinkedHashMap<Experience, Boolean>(),
								new LinkedHashMap<Certificate, Boolean>(),
								serviceContext);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
