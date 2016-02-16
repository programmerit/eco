package vn.com.ecopharma.emp.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import vn.com.ecopharma.emp.enumeration.EmployeeNotifyType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpNotifyEmail;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil;
import vn.com.ecopharma.emp.util.MailServiceUtils;

import com.liferay.faces.util.logging.Logger;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.mail.MailEngine;
import com.liferay.util.mail.MailEngineException;

@ManagedBean
@ViewScoped
public class EmpNotifyBean {

	private List<EmpNotifyEmail> empNotifyEmails;

	@PostConstruct
	public void init() {
		empNotifyEmails = EmpNotifyEmailLocalServiceUtil
				.findByStatus(EmployeeNotifyType.WAITING.toString());
	}

	public void onSendNotificationEmail() {
		final List<Emp> emps = new ArrayList<>();
		for (EmpNotifyEmail item : empNotifyEmails) {
			try {
				emps.add(EmpLocalServiceUtil.getEmp(item.getEmpId()));
			} catch (PortalException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}

		EmpLocalServiceUtil.sendNewEmpsNotificationEmail(emps);

		// try {
		// InternetAddress from = new InternetAddress("tvtao@ecopharma.com.vn");
		// InternetAddress[] toTest = new InternetAddress[] {
		// new InternetAddress("tao.tranv@gmail.com"),
		// new InternetAddress("tvtao@ecopharma.com.vn") };
		//
		// String emailContent = EmpLocalServiceUtil
		// .getEntireNewEmployeesHtmlMailContent(emps);
		//
		// System.out.println(emailContent);
		// MailEngine.send(from, toTest, null,
		// "Thông tin nhân sự sắp nhận việc", emailContent, true);
		// } catch (AddressException e) {
		// e.printStackTrace();
		// } catch (MailEngineException e) {
		// e.printStackTrace();
		// } catch (SystemException e) {
		// e.printStackTrace();
		// }

	}

	public List<EmpNotifyEmail> getEmpNotifyEmails() {
		return empNotifyEmails;
	}

	public void setEmpNotifyEmails(List<EmpNotifyEmail> empNotifyEmails) {
		this.empNotifyEmails = empNotifyEmails;
	}

}
