package vn.com.ecopharma.hrm.rc.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import vn.com.ecopharma.hrm.rc.model.Interview;
import vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean(name = "interviewBean")
@RequestScoped
public class InterviewBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Interview interview;

	@PostConstruct
	public void init() {
		interview = InterviewLocalServiceUtil
				.createPrePersitedInterview(RCUtils.getServiceContext());
	}

	public void save() {
		try {
			InterviewLocalServiceUtil.addInterview(interview);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Create Interview successfully", "Interview"
							+ interview.getName() + " has been created");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public void onCloseOrSave() {
		RequestContext context = RequestContext.getCurrentInstance();
		context.reset(":interviewForm");
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

}