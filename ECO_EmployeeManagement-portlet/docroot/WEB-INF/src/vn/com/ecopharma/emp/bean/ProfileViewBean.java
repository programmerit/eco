package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.dto.EmpInfoItem;

@ManagedBean
@ViewScoped
public class ProfileViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpInfoItem emp;

	private long empId;

	@PostConstruct
	public void init() {

	}

	public void onload() throws SystemException {
		emp = new EmpInfoItem(empId);
	}

	public EmpInfoItem getEmp() {
		return emp;
	}

	public void setEmp(EmpInfoItem emp) {
		this.emp = emp;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public Date getMaxBirthdayDate() {
		Calendar now = Calendar.getInstance();
		// backward 18 years
		now.add(Calendar.YEAR, -18);
		return now.getTime();
	}

	public void onFullNameBlur() {

	}

	public boolean isShowUserTab() {
		return false;
	}
}
