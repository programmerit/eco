package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.emp.enumeration.EmployeeNotifyType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpNotifyEmail;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class EmpNotifyBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpNotifyBean.class);
	private List<EmpNotifyEmail> empNotifyEmails;

	@PostConstruct
	public void init() {
		empNotifyEmails = EmpNotifyEmailLocalServiceUtil
				.findByStatus(EmployeeNotifyType.WAITING.toString());
	}

	public void onSendNotificationEmail() {
		final List<Emp> emps = new ArrayList<>();
		if (empNotifyEmails != null && !empNotifyEmails.isEmpty()) {
			for (EmpNotifyEmail item : empNotifyEmails) {
				try {
					emps.add(EmpLocalServiceUtil.getEmp(item.getEmpId()));
				} catch (PortalException e) {
					LOGGER.info(e);
				} catch (SystemException e) {
					LOGGER.info(e);
				}
			}
			boolean isSentMail = EmpLocalServiceUtil
					.sendNewEmpsNotificationEmail(emps);
			if (isSentMail) {
				EmpNotifyEmailLocalServiceUtil
						.updateSentMailNotifications(empNotifyEmails);
			}

		}

	}

	public List<EmpNotifyEmail> getEmpNotifyEmails() {
		return empNotifyEmails;
	}

	public void setEmpNotifyEmails(List<EmpNotifyEmail> empNotifyEmails) {
		this.empNotifyEmails = empNotifyEmails;
	}

}
