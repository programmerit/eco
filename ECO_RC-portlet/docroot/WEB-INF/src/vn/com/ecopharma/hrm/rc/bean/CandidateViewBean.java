package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleForAllItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.EvaluationCriteriaType;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.enumeration.navigation.CandidateNavigation;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.service.ServiceContext;

/**
 * @author TaoTran
 *
 */
@ManagedBean(name = "candidateViewBean")
@ViewScoped
public class CandidateViewBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String currentNav = StringUtils.EMPTY;

	private String selectedStatus = StringUtils.EMPTY;

	private String includedDialog = StringUtils.EMPTY;

	private String onCompleteUpdate = StringUtils.EMPTY;

	private CandidateIndexItem selectedCandidate;

	@PostConstruct
	public void init() {
		currentNav = CandidateNavigation.VIEW.getOutCome();
	}

	public void switchOutCome(CandidateNavigation navigation) {
		currentNav = navigation.getOutCome();
	}

	public void switchOutCome(String navigation) {
		CandidateNavigation navigationEnum = CandidateNavigation
				.valueOf(navigation);
		switchOutCome(navigationEnum);
	}

	public void onStatusChange(CandidateIndexItem item) {
		final CandidateBean candidateBean = (CandidateBean) BeanUtils
				.getBackingBeanByName("candidateBean");
		candidateBean.setSelectedItem(item);
		final CandidateStatus status = CandidateStatus.valueOf(selectedStatus);

		final ServiceContext serviceContext = LiferayFacesContext.getInstance()
				.getServiceContext();

		switch (status) {
		case INTERVIEW_SCHEDULED:
			ScheduleInterviewForCandidatesBean bean = (ScheduleInterviewForCandidatesBean) BeanUtils
					.getBackingBeanByName("scheduleInterviewForCandidatesBean");
			bean.setInterviewScheduleItems(Arrays
					.asList(new InterviewScheduleItem(item)));
			bean.setInterviewScheduleForAllItem(new InterviewScheduleForAllItem());
			switchOutCome(CandidateNavigation.SCHEDULE_INTERVIEW);
			onCompleteUpdate = "updateCandidatePanelGroup();";
			break;

		case EVALUATE_CANDIDATE:
			onEvaluateCandidates(Arrays.asList(item));
			break;
		case HIRE:
			EmployeeBean employeeBean = (EmployeeBean) BeanUtils
					.getBackingBeanByName("employeeBean");
			if (employeeBean.transferCandidateInfo(item) != null) {
				switchOutCome(CandidateNavigation.TRANSFER_TO_EMP);
				;
			}
			onCompleteUpdate = "updateCandidatePanelGroup();";
			break;
		case MARK_INTERVIEW_PASS:
		case MARK_INTERVIEW_FAIL:
			InterviewSchedule interviewSchedule = InterviewScheduleLocalServiceUtil
					.findByVacancyCandidateAndStatus(
							item.getVacancyCandidateId(),
							InterviewScheduleStatus.PROCESSING.toString());
			InterviewScheduleLocalServiceUtil
					.setInterviewStatusByCandidateStatus(status.toString(),
							item.getId(), interviewSchedule, serviceContext);
			onCompleteUpdate = "updateCandidatesAndGrowl();";
			break;
		case REJECT:
			candidateBean.setSelectedItems(Arrays.asList(item));
			onCompleteUpdate = "PF('wRejectConfirmDialog').show();";
			break;
		default:
			CandidateLocalServiceUtil.changeCandidateStatus(item.getId(),
					selectedStatus, serviceContext);
			onCompleteUpdate = "updateCandidatesAndGrowl();";
			break;
		}
		selectedStatus = StringUtils.EMPTY;
		// RequestContext.getCurrentInstance().update("refreshStatusGroup();");
	}

	public String currentStatusCSS(String status) {
		return CandidateStatus.getCssClass(CandidateStatus.valueOf(status));
	}

	public List<String> retreiveAvailableStatuses(String status) {
		return CandidateStatus.getAvailableStatus_(status);
	}

	public void onEvaluateCandidates(List<CandidateIndexItem> candidates) {
		EvaluationBean evaluationBean = (EvaluationBean) BeanUtils
				.getBackingBeanByName("evaluationBean");
		evaluationBean.setCandidateIndexItems(candidates);
		evaluationBean.setEvaluationItems(initEvaluationItems());
		this.includedDialog = "/views/dialogs/evaluation.xhtml";
		RequestContext.getCurrentInstance().update(
				":CandidatePanelGroup");
		RequestContext.getCurrentInstance().execute(
				"PF('wEvaluationDialog').show();");
	}

	public List<EvaluationItem> initEvaluationItems() {
		final List<String> types = new ArrayList<>(new HashSet<>(
				EvaluationCriteriaType.getAll()));
		final List<EvaluationItem> results = new ArrayList<>();

		for (String type : types) {
			results.add(new EvaluationItem(type));
		}
		return results;
	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public String getLocalizedStatus(String status) {
		return CandidateStatus.valueOf(status).getLocalizedString();
	}

	public String getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}

	public String getIncludedDialog() {
		return includedDialog;
	}

	public void setIncludedDialog(String includedDialog) {
		this.includedDialog = includedDialog;
	}

	public String getOnCompleteUpdate() {
		return onCompleteUpdate;
	}

	public void setOnCompleteUpdate(String onCompleteUpdate) {
		this.onCompleteUpdate = onCompleteUpdate;
	}

	public CandidateIndexItem getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(CandidateIndexItem selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}

}
