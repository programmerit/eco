package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.service.EmployeeLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.Interview;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class InterviewScheduleItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(InterviewScheduleItem.class);

	private List<Interview> interviews;

	private Interview interview;

	private List<EmpIndexedItem> interviewers;

	private InterviewSchedule interviewSchedule;

	private Interview selectedInterview;

	private CandidateIndexItem candidateIndexItem;

	private VacancyIndexItem vacancyIndexItem;

	private Date timeFrom;

	private Date timeTo;

	public InterviewScheduleItem() {
		this.interviewSchedule = InterviewScheduleLocalServiceUtil
				.createPrePersitedEntity();
		this.interviewSchedule.setVacancyCandidateId(candidateIndexItem
				.getVacancyCandidateId());
		this.interviewers = new ArrayList<EmpIndexedItem>();
		this.interviews = InterviewLocalServiceUtil.findAll();
	}

	public InterviewScheduleItem(CandidateIndexItem candidateIndexItem) {
		this.candidateIndexItem = candidateIndexItem;
		this.interviewSchedule = InterviewScheduleLocalServiceUtil
				.createPrePersitedEntity();
		this.interviewSchedule.setVacancyCandidateId(candidateIndexItem
				.getVacancyCandidateId());
		this.interviewers = new ArrayList<>();
		this.interviews = InterviewLocalServiceUtil.findAll();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 0);
		timeFrom = calendar.getTime();

		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 30);
		timeTo = calendar.getTime();
	}

	public InterviewScheduleItem(InterviewSchedule interviewSchedule) {
		this.interviewSchedule = interviewSchedule;
		this.candidateIndexItem = getCandidateIndexItemByInterviewSchedule();
		this.vacancyIndexItem = getVacancyIndexItemByInterviewSchedule();
		this.interviewers = getInterviewersByInterviewSchedule();
		this.interview = getInterviewByInterviewSchedule();
		setTimeByInterviewSchedule();
	}

	private CandidateIndexItem getCandidateIndexItemByInterviewSchedule() {
		try {
			long vacancyCandidateId = interviewSchedule.getVacancyCandidateId();
			long candidateId = VacancyCandidateLocalServiceUtil
					.getVacancyCandidate(vacancyCandidateId).getCandidateId();
			return new CandidateIndexItem(
					CandidateLocalServiceUtil.getIndexCandidateDocument(
							candidateId, RCUtils.getCurrentSearchContext()));
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	private VacancyIndexItem getVacancyIndexItemByInterviewSchedule() {
		try {
			long vacancyCandidateId = interviewSchedule.getVacancyCandidateId();
			long vacancyId = VacancyCandidateLocalServiceUtil
					.getVacancyCandidate(vacancyCandidateId).getVacancyId();
			return new VacancyIndexItem(
					VacancyLocalServiceUtil.getIndexVacancyDocument(vacancyId,
							RCUtils.getCurrentSearchContext()));
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	private List<EmpIndexedItem> getInterviewersByInterviewSchedule() {
		final List<EmpIndexedItem> items = new ArrayList<EmpIndexedItem>();
		for (EmployeeInterviewSchedule item : EmployeeInterviewScheduleLocalServiceUtil
				.findByInterviewSchedule(interviewSchedule
						.getInterviewScheduleId())) {
			final EmpIndexedItem e = new EmpIndexedItem(
					EmployeeLocalServiceUtil.getIndexedEmployee(
							item.getEmployeeId(),
							RCUtils.getCurrentSearchContext()));
			items.add(e);
		}
		return items;
	}

	private Interview getInterviewByInterviewSchedule() {
		try {
			return InterviewLocalServiceUtil.getInterview(interviewSchedule
					.getInterviewId());
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	private void setTimeByInterviewSchedule() {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(interviewSchedule.getInterviewDate());
		final String time = this.interviewSchedule.getInterviewTime(); // format:
																		// 08:00-09:00
		final String timeFromString = time.split("-")[0];
		final String timeToString = time.split("-")[1];

		int fromHour = Integer.parseInt(timeFromString.split(":")[0]);
		int fromMin = Integer.parseInt(timeFromString.split(":")[1]);

		int toHour = Integer.parseInt(timeToString.split(":")[0]);
		int toMin = Integer.parseInt(timeToString.split(":")[1]);

		calendar.set(Calendar.HOUR, fromHour);
		calendar.set(Calendar.MINUTE, fromMin);
		this.timeFrom = calendar.getTime();

		calendar.set(Calendar.HOUR, toHour);
		calendar.set(Calendar.MINUTE, toMin);
		this.timeTo = calendar.getTime();
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	public List<EmpIndexedItem> getInterviewers() {
		return interviewers;
	}

	public void setInterviewers(List<EmpIndexedItem> interviewers) {
		this.interviewers = interviewers;
	}

	public InterviewSchedule getInterviewSchedule() {
		return interviewSchedule;
	}

	public void setInterviewSchedule(InterviewSchedule interviewSchedule) {
		this.interviewSchedule = interviewSchedule;
	}

	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public Interview getSelectedInterview() {
		return selectedInterview;
	}

	public void setSelectedInterview(Interview selectedInterview) {
		this.selectedInterview = selectedInterview;
	}

	// public List<Interview> getPrevInterviews() {
	// final List<Long> ids = InterviewScheduleLocalServiceUtil
	// .getAllInterviewRoundIdsByVacancyCandidateId(
	// RCUtils.getCurrentSearchContext(),
	// this.interviewSchedule.getVacancyCandidateId(),
	// this.interviewSchedule.getCompanyId());
	// final List<Interview> results = new ArrayList<Interview>(ids.size());
	// for (long id : ids) {
	// try {
	// results.add(InterviewLocalServiceUtil.fetchInterview(id));
	// } catch (SystemException e) {
	// LOGGER.info(e);
	// }
	// }
	// return results;
	// }

	public List<Interview> getPrevInterviews() {
		final List<Long> ids = InterviewScheduleLocalServiceUtil
				.findInterviewIdsByVacancyCandidate(interviewSchedule
						.getVacancyCandidateId());
		final List<Interview> results = new ArrayList<>(ids.size());
		for (long id : ids) {
			try {
				results.add(InterviewLocalServiceUtil.fetchInterview(id));
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
		return results;
	}

	public String getPrevInterviewsFormattedString() {
		final List<Interview> interviews = getPrevInterviews();
		if (interviews.isEmpty()) {
			return "None";
		}
		String result = StringUtils.EMPTY;
		for (int i = 0; i < interviews.size(); i++) {
			result += i < interviews.size() - 1 ? interviews.get(i).getName()
					+ "; " : interviews.get(i).getName() + ".";
		}
		return result;
	}

	public String getSelectedInterviewersString() {
		if (interviewers == null || interviewers.isEmpty())
			return "Not specified";
		String result = StringUtils.EMPTY;
		int count = 0;
		for (EmpIndexedItem employeeIndexedItem : interviewers) {
			count++;
			result += count < interviewers.size() ? employeeIndexedItem
					.getFullName() + ", " : employeeIndexedItem.getFullName()
					+ ".";
		}
		return result;
	}

	public InterviewSchedule getInterviewScheduleAfterSettingFields() {
		interviewSchedule.setInterviewId(selectedInterview.getInterviewId());
		interviewSchedule.setVacancyCandidateId(candidateIndexItem
				.getVacancyCandidateId());
		interviewSchedule.setInterviewTime(getTimeFromFormatted() + "-"
				+ getTimeToFormatted());
		return interviewSchedule;
	}

	public CandidateIndexItem getCandidateIndexItem() {
		return candidateIndexItem;
	}

	public void setCandidateIndexItem(CandidateIndexItem candidateIndexItem) {
		this.candidateIndexItem = candidateIndexItem;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(Date timeTo) {
		this.timeTo = timeTo;
	}

	public String getTimeFromFormatted() {
		return getFormattedTime(timeFrom, "HH:mm");
	}

	public String getTimeToFormatted() {
		return getFormattedTime(timeTo, "HH:mm");
	}

	private String getFormattedTime(Date time, String format) {
		if (time == null) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(time);
	}

	public VacancyIndexItem getVacancyIndexItem() {
		return vacancyIndexItem;
	}

	public void setVacancyIndexItem(VacancyIndexItem vacancyIndexItem) {
		this.vacancyIndexItem = vacancyIndexItem;
	}
}
