package vn.com.ecopharma.hrm.rc.dto;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.rc.constant.InterviewScheduleField;

import com.liferay.portal.kernel.search.Document;

public class InterviewScheduleIndexedItem extends AbstractIndexEntityItem {

	private static final long serialVersionUID = 1L;

	public InterviewScheduleIndexedItem(Document document) {
		super(document);
	}

	@Override
	protected String idFieldName() {
		return InterviewScheduleField.ID;
	}

	public String getVacancy() {
		return getDocument().getField(InterviewScheduleField.VACANCY)
				.getValue();
	}

	public String getCandidateName() {
		return getDocument().getField(InterviewScheduleField.CANDIDATE)
				.getValue();
	}

	public String getInterviewName() {
		return getDocument().getField(InterviewScheduleField.INTERVIEW_NAME)
				.getValue();
	}

	public String getStatus() {
		return getDocument().getField(InterviewScheduleField.STATUS).getValue();
	}

	public Date getInterviewDate() {
		try {
			return getDocument().getDate(InterviewScheduleField.INTERVIEW_DATE);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getInterviewTime() {
		return getDocument().getField(InterviewScheduleField.INTERVIEW_TIME)
				.getValue();
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
}
