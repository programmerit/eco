package vn.com.ecopharma.hrm.rc.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vn.com.ecopharma.hrm.rc.dto.CandidateImportExportDTO;
import vn.com.ecopharma.hrm.rc.dto.VacancyImportExportDTO;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "importExportBean")
@RequestScoped
public class ImportExportBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fileName;
	private String presetType;
	private String exportRange;
	private String exportColumn;

	private String fileURL = "http://www.google.com";

	@PostConstruct
	public void init() {

	}

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
					if (currentPage() == 1) {
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
									0, cDTO.getVacancyId(),
									new ArrayList<Long>(),
									new ArrayList<Long>(),
									new LinkedHashMap<Experience, Boolean>(),
									new LinkedHashMap<Certificate, Boolean>(),
									serviceContext);
						}
					} else if (currentPage() == 2) {
						final VacancyImportExportDTO vDTO = new VacancyImportExportDTO(
								r);
						if (!vDTO.isExistedVacancy()) {
							Vacancy vacancy = VacancyLocalServiceUtil
									.createPrePersistedVacancy(
											vDTO.getVacancyCode(),
											vDTO.getName(),
											vDTO.getNumberOfPosition(),
											vDTO.getTitlesId(),
											vDTO.getDescription(),
											vDTO.getPostedDate(),
											vDTO.getExpiredDate(),
											vDTO.getStatus());
							VacancyLocalServiceUtil.addVacancy(vacancy, 0,
									new ArrayList<Long>(), serviceContext);
						}
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void handleFileExport() {

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getPresetType() {
		return presetType;
	}

	public void setPresetType(String presetType) {
		this.presetType = presetType;
	}

	public String getExportRange() {
		return exportRange;
	}

	public void setExportRange(String exportRange) {
		this.exportRange = exportRange;
	}

	public String getExportColumn() {
		return exportColumn;
	}

	public void setExportColumn(String exportColumn) {
		this.exportColumn = exportColumn;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	private int currentPage() {
		return BeanUtils.getRCViewBean().getCurrentPage();
	}

}
