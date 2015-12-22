package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.hrm.rc.constant.CandidateNavigation;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;

@ManagedBean(name = "RCViewBean")
@ViewScoped
public class RCViewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * 1: Candidate Page;
	 * 
	 * 2: Vacancy Page;
	 * 
	 * 3: Report
	 * 
	 * 4: Interviews
	 */
	private int currentPage = 1;

	private String currentNav = "";

	private String currentHashTag = StringUtils.EMPTY;

	@PostConstruct
	public void init() {
		currentHashTag = "vCandidate";
	}

	/**
	 * @param pageNo
	 */
	public void switchPage(int pageNo) {
		this.currentPage = pageNo;
		switch (pageNo) {
		case 1:
			currentNav = "/views/pages/candidate.xhtml";
			break;
		case 2:
			currentNav = "/views/pages/vacancy.xhtml";
			break;
		case 3:
			currentNav = "/views/pages/report.xhtml";
			break;
		case 4:
			currentNav = "/views/pages/interviews.xhtml";
			break;
		}
	}

	public void updateNav() {
		currentHashTag = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("currentNav");
		final CandidateBean candidateBean = BeanUtils.getCandidateBean();
		final CandidateViewBean candidateViewBean = BeanUtils
				.getCandidateViewBean();
		if (currentHashTag.equalsIgnoreCase("vCandidate")) {
			//
			switch (candidateViewBean.getCurrentMode()) {
			case CandidateNavigation.CREATE:
			case CandidateNavigation.EDIT:
				candidateBean.onCancel();
				break;
			case CandidateNavigation.SCHEDULE_INTERVIEW:
				ScheduleInterviewForCandidatesBean bean = (ScheduleInterviewForCandidatesBean) BeanUtils
						.getBackingBeanByName("scheduleInterviewForCandidatesBean");
				bean.onCancel();
				break;
			case CandidateNavigation.TRANSFER_TO_EMPLOYEE:
				EmployeeBean employeeBean = (EmployeeBean) BeanUtils
						.getBackingBeanByName("employeeBean");
				employeeBean.cancelModification();
				break;
			default:
				switchPage(1);
			}
		} else if (currentHashTag.equalsIgnoreCase("vVacancy")) {
			switchPage(2);
		} else if (currentHashTag.equalsIgnoreCase("vReport")) {
			switchPage(3);
		} else if (currentHashTag.equalsIgnoreCase("vInterview")) {
			switchPage(4);
		} else if (currentHashTag.contains("candidateId=")) {
			long candidateId = Long.valueOf(currentHashTag.split("=")[1]);
			candidateBean.editCandidate(candidateId);
			RequestContext.getCurrentInstance().update("CandidatePanelGroup");
		} else if (currentHashTag.equalsIgnoreCase("scheduleInterview")) {
			candidateBean
					.onChangeMultipleItemStatus(CandidateStatus.INTERVIEW_SCHEDULED
							.toString());
		} else if (currentHashTag.equalsIgnoreCase("scheduleInterview")) {

		} else if (currentHashTag.equalsIgnoreCase("vCandidate/addCandidate")) {
			candidateBean.addCandidate();
		} else if (currentHashTag.contains("first")
				&& currentHashTag.contains("pageSize")) {
			// #vCandidate/first=0&pageSize=10
			String orgHashtag = currentHashTag;
			orgHashtag = orgHashtag.replace("vCandidate/", ""); // first=0&pageSize=10
			orgHashtag = orgHashtag.replace("first=", ""); // 0&pageSize=10
			orgHashtag = orgHashtag.replace("pageSize=", ""); // 0&10

			System.out.println(orgHashtag);

			int first = Integer.valueOf(orgHashtag.split("&")[0]);
			int pageSize = Integer.valueOf(orgHashtag.split("&")[1]);

			System.out.println("first " + first + "   pagesize " + pageSize);
			candidateBean.setFirst(first);
			candidateBean.setPageSize(pageSize);
			candidateBean.setBackFromOtherPage(true);
			// switchPage(1);
			candidateViewBean.switchMode(CandidateNavigation.VIEW);
			RequestContext.getCurrentInstance().update("CandidatePanelGroup");
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}
}
