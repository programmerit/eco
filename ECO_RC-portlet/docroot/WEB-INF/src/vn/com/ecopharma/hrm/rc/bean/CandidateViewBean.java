package vn.com.ecopharma.hrm.rc.bean;

import java.util.Arrays;
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
import vn.com.ecopharma.hrm.rc.enumeration.CandidateStatus;
import vn.com.ecopharma.hrm.rc.enumeration.InterviewScheduleStatus;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "candidateViewBean")
@ViewScoped
public class CandidateViewBean extends EntityViewBean {

	private static final long serialVersionUID = 1L;

	private String currentNav = StringUtils.EMPTY;

	private String selectedStatus = StringUtils.EMPTY;

	@PostConstruct
	public void init() {
		currentNav = "/views/pages/candidateView.xhtml";
	}

	@Override
	public void switchMode(int mode) {
		switch (mode) {
		case CandidateNavigation.VIEW:
			currentNav = "/views/pages/candidateView.xhtml";
			break;
		case CandidateNavigation.CREATE:
		case CandidateNavigation.EDIT:
			currentNav = "/views/pages/modifyCandidate.xhtml";
			break;
		case CandidateNavigation.TRANSFER_TO_EMPLOYEE:
			currentNav = "/views/pages/employee.xhtml";
			break;
		case CandidateNavigation.SCHEDULE_INTERVIEW:
			currentNav = "/views/pages/scheduleInterviewForCandidates.xhtml";
			break;
		default:
			break;
		}
		super.switchMode(mode);
	}

	public String currentStatusCSS(String status) {
		return CandidateStatus.getCssClass(CandidateStatus.valueOf(status));
	}

	public List<String> getAvailableStatuses(String status) {
		return CandidateStatus.getAvailableStatus_(status);
	}

	public void onStatusChange(CandidateIndexItem item) {
		try {
			final CandidateBean candidateBean = (CandidateBean) BeanUtils
					.getBackingBeanByName("candidateBean");
			candidateBean.setSelectedItem(item);
			final CandidateStatus status = CandidateStatus
					.valueOf(selectedStatus);

			final ServiceContext serviceContext = LiferayFacesContext
					.getInstance().getServiceContext();

			switch (status) {
			case INTERVIEW_SCHEDULED:
				/* Old interview schedule for single candidate */
				// InterviewScheduleBean interviewScheduleBean =
				// (InterviewScheduleBean) BeanUtils
				// .getBackingBeanByName("interviewScheduleBean");
				// interviewScheduleBean
				// .setInterviewScheduleItem(new InterviewScheduleItem(
				// item));
				// RequestContext.getCurrentInstance().execute(
				// "PF('wInterviewScheduleDialog').show()");
				/**********************/
				ScheduleInterviewForCandidatesBean bean = (ScheduleInterviewForCandidatesBean) BeanUtils
						.getBackingBeanByName("scheduleInterviewForCandidatesBean");
				bean.setInterviewScheduleItems(Arrays
						.asList(new InterviewScheduleItem(item)));
				bean.setInterviewScheduleForAllItem(new InterviewScheduleForAllItem());
				RequestContext.getCurrentInstance().execute(
						"window.location.hash = '#scheduleInterview';");
				switchMode(CandidateNavigation.SCHEDULE_INTERVIEW);
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
								item.getCandidateId(), status.toString(),
								serviceContext);
					}
				} catch (SystemException e) {
					e.printStackTrace();
				}
				break;
			case REJECT:
				candidateBean.setSelectedItems(Arrays.asList(item));
				RequestContext.getCurrentInstance().execute(
						"PF('wRejectConfirmDialog').show()");
				break;
			case JOB_OFFERED:
				EvaluationBean evaluationBean = (EvaluationBean) BeanUtils
						.getBackingBeanByName("evaluationBean");
				evaluationBean.setCandidateIndexItems(Arrays.asList(item));
				evaluationBean.setEvaluationItems(evaluationBean
						.getEvaluationItemsFromEvaluationCriteria());
				RequestContext.getCurrentInstance().execute(
						"PF('wEvaluationDialog').show()");
				break;
			default:
				final Candidate candidate = CandidateLocalServiceUtil
						.fetchCandidate(item.getCandidateId());
				candidate.setStatus(selectedStatus);
				CandidateLocalServiceUtil.updateCandidate(candidate);
				RequestContext.getCurrentInstance().execute(
						"updateCandidatesAndGrowl();");
				break;
			}
			selectedStatus = StringUtils.EMPTY;
		} catch (SystemException e) {
			e.printStackTrace();
		}

	}

	public String getSelectedStatus() {
		return selectedStatus;
	}

	public void setSelectedStatus(String selectedStatus) {
		this.selectedStatus = selectedStatus;
	}

	public String getLocalizedStatus(String status) {
		return CandidateStatus.valueOf(status).getLocalizedName();
	}

	public String getCurrentNav() {
		return currentNav;
	}

	public void setCurrentNav(String currentNav) {
		this.currentNav = currentNav;
	}
}
