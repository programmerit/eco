package vn.com.ecopharma.hrm.rc.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.hrm.rc.constant.CandidateNavigation;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleForAllItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleItem;
import vn.com.ecopharma.hrm.rc.dto.evaluate.EvaluationItem;
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.EvaluationCriteriaType;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "candidateViewBean")
@ViewScoped
public class CandidateViewBean extends EntityViewBean {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(CandidateViewBean.class);

	private static final String VIEW = "/views/pages/candidateView.xhtml";

	private String currentNav = StringUtils.EMPTY;

	private String selectedStatus = StringUtils.EMPTY;

	private String includedDialog = StringUtils.EMPTY;

	@PostConstruct
	public void init() {
		currentNav = VIEW;
	}

	@Override
	public void switchMode(int mode) {
		switch (mode) {
		case CandidateNavigation.VIEW:
			currentNav = VIEW;
			break;
		case CandidateNavigation.CREATE:
		case CandidateNavigation.EDIT:
			currentNav = "/views/pages/modifyCandidate.xhtml";
			break;
		case CandidateNavigation.TRANSFER_TO_EMPLOYEE:
			currentNav = "/views/pages/employeeForm.xhtml";
			break;
		case CandidateNavigation.SCHEDULE_INTERVIEW:
			currentNav = "/views/pages/scheduleInterviewForCandidates.xhtml";
			break;
		default:
			break;
		}
		super.switchMode(mode);
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
			switchMode(CandidateNavigation.SCHEDULE_INTERVIEW);
			break;

		case EVALUATE_CANDIDATE:
			onEvaluateCandidates(Arrays.asList(item));
			break;
		case HIRE:
			EmployeeBean employeeBean = (EmployeeBean) BeanUtils
					.getBackingBeanByName("employeeBean");
			if (employeeBean.transferCandidateInfo(item) != null) {
				switchMode(4);
			}
			break;
		case MARK_INTERVIEW_PASS:
		case MARK_INTERVIEW_FAIL:
			InterviewSchedule is = InterviewScheduleLocalServiceUtil
					.findByVacancyCandidateAndStatus(
							item.getVacancyCandidateId(),
							InterviewScheduleStatus.PROCESSING.toString());
			is.setStatus(status.equals(CandidateStatus.MARK_INTERVIEW_PASS) ? InterviewScheduleStatus.PASSED
					.toString() : InterviewScheduleStatus.FAILED.toString());
			try {
				InterviewSchedule interviewSchedule = InterviewScheduleLocalServiceUtil
						.updateInterviewSchedule(is);
				if (interviewSchedule != null) {
					CandidateLocalServiceUtil.changeCandidateStatus(
							item.getId(), status.toString(), serviceContext);
				}
			} catch (SystemException e) {
				LOGGER.info(e);
			}
			break;
		case REJECT:
			candidateBean.setSelectedItems(Arrays.asList(item));
			RequestContext.getCurrentInstance().execute(
					"PF('wRejectConfirmDialog').show()");
			break;
		default:
			CandidateLocalServiceUtil.changeCandidateStatus(item.getId(),
					selectedStatus, serviceContext);
			RequestContext.getCurrentInstance().execute(
					"updateCandidatesAndGrowl();");
			break;
		}
		selectedStatus = StringUtils.EMPTY;
	}

	public String currentStatusCSS(String status) {
		return CandidateStatus.getCssClass(CandidateStatus.valueOf(status));
	}

	public List<String> getAvailableStatuses(String status) {
		return CandidateStatus.getAvailableStatus_(status);
	}

	public void onEvaluateCandidates(List<CandidateIndexItem> candidates) {
		EvaluationBean evaluationBean = (EvaluationBean) BeanUtils
				.getBackingBeanByName("evaluationBean");
		evaluationBean.setCandidateIndexItems(candidates);
		evaluationBean.setEvaluationItems(initEvaluationItems());
		this.includedDialog = "/views/dialogs/evaluation.xhtml";
		RequestContext.getCurrentInstance().update(
				":CandidatePanelGroup:includedDialog");
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

}
