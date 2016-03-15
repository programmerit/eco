package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import vn.com.ecopharma.hrm.rc.constant.CandidateNavigation;
import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleForAllItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleItem;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.BeanUtils;
import vn.com.ecopharma.hrm.rc.util.EmployeeUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class ScheduleInterviewForCandidatesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ScheduleInterviewForCandidatesBean.class);

	private List<InterviewScheduleItem> interviewScheduleItems;

	private InterviewScheduleForAllItem interviewScheduleForAllItem;

	private List<InterviewScheduleItem> selectedInterviewScheduleItems;

	@PostConstruct
	public void init() {
		interviewScheduleItems = new ArrayList<InterviewScheduleItem>();
		interviewScheduleForAllItem = new InterviewScheduleForAllItem();
		selectedInterviewScheduleItems = new ArrayList<InterviewScheduleItem>();
	}

	public void onRowEdit(RowEditEvent event) {
		LogFactoryUtil.getLog(ScheduleInterviewForCandidatesBean.class);
	}

	public void onRowCancel(RowEditEvent event) {

	}

	public void onSavingAll() {
		if (validateInterviewSchedule()) {
			for (InterviewScheduleItem interviewScheduleItem : interviewScheduleItems) {

				final ServiceContext serviceContext = LiferayFacesContext
						.getInstance().getServiceContext();
				interviewScheduleItem.getInterviewScheduleAfterSettingFields();

				InterviewScheduleLocalServiceUtil.addInterviewSchedule(
						interviewScheduleItem.getInterviewSchedule(),
						interviewScheduleItem.getCandidateIndexItem()
								.getVacancyCandidateId(),
						getEmpIds(interviewScheduleItem.getInterviewers()),
						interviewScheduleItem.getCandidateIndexItem().getId(),
						serviceContext);
				FacesMessage msg = new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Schedule Interview Success",
						"Candidate ['"
								+ interviewScheduleItem.getCandidateIndexItem()
										.getFullName()
								+ "'] was sucessfully scheduled for an interview");
				FacesContext.getCurrentInstance().addMessage(null, msg);

			}
			BeanUtils.getCandidateViewBean().switchMode(
					CandidateNavigation.VIEW);
			;
		}

	}

	private boolean validateInterviewSchedule() {
		boolean checked = true;
		for (InterviewScheduleItem item : interviewScheduleItems) {
			if (item.getSelectedInterview() == null) {
				checked = false;
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Warning!!!",
						"You have not select Interview Round. Please select");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}

			if (item.getInterviewers().isEmpty()) {
				checked = false;
				FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Warning!!!",
						"You have not select Interviewer. Please select");
				FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		return checked;
	}

	public void onCancel() {
		interviewScheduleItems = null;
		interviewScheduleForAllItem = null;
		selectedInterviewScheduleItems = null;

		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Cancel Scheduling Interview",
				"You selected to cancel scheduling interview");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		CandidateViewBean candidateViewBean = BeanUtils.getCandidateViewBean();
		candidateViewBean.switchMode(CandidateNavigation.VIEW);
	}

	public void onApplyForAll(ActionEvent actionEvent) {
		setSameInterviewScheduleForItems(interviewScheduleItems);
	}

	public void onApplyForSelected(ActionEvent event) {
		setSameInterviewScheduleForItems(selectedInterviewScheduleItems);
	}

	public void onDeleteInterviewSchedule(ActionEvent event) {
		LOGGER.info("#### Delete key was pressed ####");
		interviewScheduleItems.removeAll(selectedInterviewScheduleItems);
	}

	private void setSameInterviewScheduleForItems(
			List<InterviewScheduleItem> items) {
		Date nextTime = null;
		final Calendar calendar = Calendar.getInstance();
		boolean isAvailablePrevInterviewRound = false;
		FacesMessage message = null;
		for (InterviewScheduleItem item : items) {
			if (interviewScheduleForAllItem.isSetInterviewForAll()) {
				isAvailablePrevInterviewRound = CandidateLocalServiceUtil
						.hasAlreadyScheduleForInterview(item
								.getCandidateIndexItem().getId(), item
								.getCandidateIndexItem().getVacancyId(),
								interviewScheduleForAllItem
										.getSelectedInterview()
										.getInterviewId());
				if (!isAvailablePrevInterviewRound) {
					item.setSelectedInterview(interviewScheduleForAllItem
							.getSelectedInterview());
				} else {
					item.setSelectedInterview(null);
					message = new FacesMessage("Interview Warning",
							"The selected Interview Round has already existed");
					FacesContext.getCurrentInstance().addMessage(null, message);
				}
			}

			if (interviewScheduleForAllItem.isSetInterviewersForAll()) {
				item.setInterviewers(interviewScheduleForAllItem
						.getInterviewers());
			}

			if (interviewScheduleForAllItem.isSetInterviewDateForAll()) {
				item.getInterviewSchedule().setInterviewDate(
						interviewScheduleForAllItem.getDate());
			}

			if (interviewScheduleForAllItem.isSetInterviewTimeForAll()) {
				if (nextTime != null) {
					calendar.setTime(nextTime);
					int mins = calendar.get(Calendar.MINUTE);
					calendar.set(Calendar.MINUTE, mins
							+ interviewScheduleForAllItem.getStep());
					item.setTimeFrom(nextTime);
					item.setTimeTo(calendar.getTime());
					nextTime = item.getTimeTo();
				} else {
					item.setTimeFrom(interviewScheduleForAllItem.getTimeFrom());
					item.setTimeTo(interviewScheduleForAllItem.getTimeTo());
					nextTime = item.getTimeTo();
				}
			}
		}

	}

	public List<EmpIndexedItem> completeInterviewers(String query) {
		return EmployeeUtils.searchEmpByName(query);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<InterviewScheduleItem> getInterviewScheduleItems() {
		return interviewScheduleItems;
	}

	public void setInterviewScheduleItems(
			List<InterviewScheduleItem> interviewScheduleItems) {
		this.interviewScheduleItems = interviewScheduleItems;
	}

	public InterviewScheduleForAllItem getInterviewScheduleForAllItem() {
		return interviewScheduleForAllItem;
	}

	public void setInterviewScheduleForAllItem(
			InterviewScheduleForAllItem interviewScheduleForAllItem) {
		this.interviewScheduleForAllItem = interviewScheduleForAllItem;
	}

	public List<InterviewScheduleItem> getSelectedInterviewScheduleItems() {
		return selectedInterviewScheduleItems;
	}

	public void setSelectedInterviewScheduleItems(
			List<InterviewScheduleItem> selectedInterviewScheduleItems) {
		this.selectedInterviewScheduleItems = selectedInterviewScheduleItems;
	}

	public boolean isHasAtLeastOneForAll() {

		return interviewScheduleForAllItem != null
				&& (interviewScheduleForAllItem.isSetInterviewForAll()
						|| interviewScheduleForAllItem
								.isSetInterviewDateForAll()
						|| interviewScheduleForAllItem
								.isSetInterviewTimeForAll() || interviewScheduleForAllItem
							.isSetInterviewersForAll());
	}

	private List<Long> getEmpIds(List<EmpIndexedItem> employeeIndexedItems) {
		final List<Long> ids = new ArrayList<Long>(employeeIndexedItems.size());
		for (EmpIndexedItem employeeIndexedItem : employeeIndexedItems) {
			ids.add(employeeIndexedItem.getId());
		}
		return ids;
	}
}
