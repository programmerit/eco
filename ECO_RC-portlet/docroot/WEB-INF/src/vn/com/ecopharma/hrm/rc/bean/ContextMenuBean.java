package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleItem;

@ManagedBean(name = "contextMenuBean")
@RequestScoped
public class ContextMenuBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<InterviewScheduleItem> interviewScheduleItems;

	@PostConstruct
	public void init() {

	}

	public void onScheduleInterview(ActionEvent actionEvent) {

	}

	public List<InterviewScheduleItem> getInterviewScheduleItems() {
		return interviewScheduleItems;
	}

	public void setInterviewScheduleItems(
			List<InterviewScheduleItem> interviewScheduleItems) {
		this.interviewScheduleItems = interviewScheduleItems;
	}
}
