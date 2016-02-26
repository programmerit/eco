package vn.com.ecopharma.hrm.rc.dto;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.constant.InterviewScheduleField;

import com.liferay.portal.kernel.search.Document;

public class InterviewScheduleIndexedItem extends AbstractIndexedItem {

	private static final long serialVersionUID = 1L;

	public InterviewScheduleIndexedItem(Document document) {
		super(document);
	}

	public String getVacancy() {
		return checkNullFieldAndReturnEmptyString(InterviewScheduleField.VACANCY);
	}

	public String getCandidateName() {
		return checkNullFieldAndReturnEmptyString(InterviewScheduleField.CANDIDATE);
	}

	public String getInterviewName() {
		return checkNullFieldAndReturnEmptyString(InterviewScheduleField.INTERVIEW_NAME);
	}

	public String getStatus() {
		return checkNullFieldAndReturnEmptyString(InterviewScheduleField.STATUS);
	}

	public Date getInterviewDate() {
		return checkNullFieldAndReturnNullDate(InterviewScheduleField.INTERVIEW_DATE);
	}

	public String getInterviewTime() {
		return checkNullFieldAndReturnEmptyString(InterviewScheduleField.INTERVIEW_TIME);
	}

	public String[] getInterviewers() {
		return getDocument().getValues(InterviewScheduleField.INTERVIEWERS);
	}

	public String getInterviewersFormattedString() {
		String result = StringUtils.EMPTY;
		final String[] interviewers = getInterviewers();
		for (int i = 0; i < interviewers.length; i++) {
			result += i < interviewers.length - 1 ? interviewers[i] + "; "
					: interviewers[i] + ".";
		}
		return result;
	}

	@Override
	protected String getIdFieldName() {
		return InterviewScheduleField.ID;
	}
}
