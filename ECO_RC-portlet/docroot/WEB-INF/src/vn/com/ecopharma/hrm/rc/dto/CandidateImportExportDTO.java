package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFRow;

import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;

public class CandidateImportExportDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String candidateCode;

	private String fullName;

	private String emailAddress;

	private String contactNumber;

	private String identityCardNo;

	private String address;

	private String vacancy;

	private String subUnit;

	private Date applicationDate;

	private String status;

	private long subUnitId;

	private long vacancyId;

	public CandidateImportExportDTO() {
		super();
	}

	public CandidateImportExportDTO(XSSFRow r) {
		this.bindFieldsFromExcelRow(r);
	}

	public CandidateImportExportDTO(CandidateIndexItem candidate) {

	}

	private void bindFieldsFromExcelRow(XSSFRow r) {
		candidateCode = r.getCell(1).getStringCellValue();
		fullName = r.getCell(2).getStringCellValue();
		emailAddress = r.getCell(3).getStringCellValue();
		contactNumber = r.getCell(4).getStringCellValue();
		identityCardNo = r.getCell(5).getStringCellValue();
		address = r.getCell(6).getStringCellValue();
		vacancy = r.getCell(7).getStringCellValue();
		subUnit = r.getCell(8).getStringCellValue();
		applicationDate = r.getCell(9).getDateCellValue();
		status = r.getCell(10).getStringCellValue();

		/* */

		// TODO
		// this.vacancyId = VacancyLocalServiceUtil.findByName(vacancy)
		// .getVacancyId();

		// this.subUnitId = SubUnitLocalServiceUtil.findByName(subUnit)
		// .getSubUnitId();
	}

	// private void bindFieldsFromIndexItem(CandidateIndexItem c) {
	//
	// candidateCode = "";
	// fullName = c.getFullName();
	// emailAddress = c.getEmailAddress();
	// contactNumber = c.getContactNumber();
	// identityCardNo = "";
	// address = "";
	// vacancyId = c.getVacancyId();
	// Vacancy v = fetchVacancy();
	// vacancy = v != null ? v.getName() : StringUtils.EMPTY;
	// subUnitId = v != null ? v.getSubUnitId() : 0;
	// subUnit = fetchSubUnit() != null ? fetchSubUnit().getName()
	// : StringUtils.EMPTY;
	// applicationDate = c.getApplicationDate();
	// status = c.getStatus();
	// }

	public Candidate createPrePersistedCandidate() {
		Candidate candidate = CandidateLocalServiceUtil
				.createPrePersistCandidate(candidateCode, fullName,
						emailAddress, contactNumber, identityCardNo, 0,
						vacancyId, applicationDate, status);
		return candidate;
	}

	public boolean isCandidateExisted() {
		return CandidateLocalServiceUtil.findByContactNumber(contactNumber) != null
				|| CandidateLocalServiceUtil.isEmailExisted(emailAddress)
				|| CandidateLocalServiceUtil
						.findByIdentityCardNo(identityCardNo) != null;
	}

	// private Vacancy fetchVacancy() {
	// try {
	// return VacancyLocalServiceUtil.fetchVacancy(this.vacancyId);
	// } catch (SystemException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// private SubUnit fetchSubUnit() {
	// try {
	// return SubUnitLocalServiceUtil.fetchSubUnit(subUnitId);
	// } catch (SystemException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	public String getCandidateCode() {
		return candidateCode;
	}

	public void setCandidateCode(String candidateCode) {
		this.candidateCode = candidateCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getIdentityCardNo() {
		return identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		this.identityCardNo = identityCardNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public String getSubUnit() {
		return subUnit;
	}

	public void setSubUnit(String subUnit) {
		this.subUnit = subUnit;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getSubUnitId() {
		return subUnitId;
	}

	public void setSubUnitId(long subUnitId) {
		this.subUnitId = subUnitId;
	}

	public long getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(long vacancyId) {
		this.vacancyId = vacancyId;
	}

}
