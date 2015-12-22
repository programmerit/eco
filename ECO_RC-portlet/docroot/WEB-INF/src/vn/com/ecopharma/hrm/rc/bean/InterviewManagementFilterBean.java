package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;

@ManagedBean
@ViewScoped
public class InterviewManagementFilterBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String global = StringUtils.EMPTY;
	private String interviewScheduleId = StringUtils.EMPTY;
	private String vacancyCandidateId = StringUtils.EMPTY;
	private String interviewName = StringUtils.EMPTY;
	private Date interviewDate;
	private Date interviewDateFrom;
	private Date interviewDateTo;
	private String interviewer = StringUtils.EMPTY;
	private String candidate = StringUtils.EMPTY;
	private String vacancy = StringUtils.EMPTY;
	private String status = StringUtils.EMPTY;

	private List<EmpIndexedItem> interviewers;

	public List<EmpIndexedItem> completeInterviewers(String query) {
		return EmployeeUtils.searchEmpByName(query);
	}

	public void resetInterviewDateFrom(ActionEvent event) {
		this.interviewDateFrom = null;
	}

	public void resetInterviewDateTo(ActionEvent event) {
		this.interviewDateTo = null;
	}

	public String getInterviewScheduleId() {
		return interviewScheduleId;
	}

	public void setInterviewScheduleId(String interviewScheduleId) {
		this.interviewScheduleId = interviewScheduleId;
	}

	public String getVacancyCandidateId() {
		return vacancyCandidateId;
	}

	public void setVacancyCandidateId(String vacancyCandidateId) {
		this.vacancyCandidateId = vacancyCandidateId;
	}

	public String getInterviewName() {
		return interviewName;
	}

	public void setInterviewName(String interviewName) {
		this.interviewName = interviewName;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public String getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public String getVacancy() {
		return vacancy;
	}

	public void setVacancy(String vacancy) {
		this.vacancy = vacancy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getInterviewDateFrom() {
		return interviewDateFrom;
	}

	public void setInterviewDateFrom(Date interviewDateFrom) {
		this.interviewDateFrom = interviewDateFrom;
	}

	public Date getInterviewDateTo() {
		return interviewDateTo;
	}

	public void setInterviewDateTo(Date interviewDateTo) {
		this.interviewDateTo = interviewDateTo;
	}

	public String getGlobal() {
		return global;
	}

	public void setGlobal(String global) {
		this.global = global;
	}

	public List<EmpIndexedItem> getInterviewers() {
		return interviewers;
	}

	public void setInterviewers(List<EmpIndexedItem> interviewers) {
		this.interviewers = interviewers;
	}

	public List<String> getAllStatus() {
		return InterviewScheduleStatus.getAllStringFormatted();
	}

}
