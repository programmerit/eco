package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import vn.com.ecopharma.hrm.rc.model.Interview;

public class InterviewScheduleForAllItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Interview selectedInterview;
	private List<Interview> interviews;
	private Date date;
	private Date timeFrom;
	private Date timeTo;
	private int step = 30;// default 30 mins for each candidate
	private List<EmpIndexedItem> interviewers;

	public InterviewScheduleForAllItem() {
		selectedInterview = null;
		date = new Date();
		interviewers = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.AM_PM, Calendar.AM);
		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 0);
		timeFrom = calendar.getTime();

		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 30);
		timeTo = calendar.getTime();
	}

	public Interview getSelectedInterview() {
		return selectedInterview;
	}

	public void setSelectedInterview(Interview selectedInterview) {
		this.selectedInterview = selectedInterview;
	}

	public List<Interview> getInterviews() {
		return interviews;
	}

	public void setInterviews(List<Interview> interviews) {
		this.interviews = interviews;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public List<EmpIndexedItem> getInterviewers() {
		return interviewers;
	}

	public void setInterviewers(List<EmpIndexedItem> interviewers) {
		this.interviewers = interviewers;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}
}