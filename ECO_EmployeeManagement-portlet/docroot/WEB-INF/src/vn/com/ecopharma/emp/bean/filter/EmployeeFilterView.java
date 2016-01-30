package vn.com.ecopharma.emp.bean.filter;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;

@ManagedBean(name = "empFilterBean")
@ViewScoped
public class EmployeeFilterView extends OrganizationFilterBean {

	private static final long serialVersionUID = 1L;

	private String globalString = StringUtils.EMPTY;
	private String employeeCode = StringUtils.EMPTY;
	private String fullName = StringUtils.EMPTY;
	private String gender = StringUtils.EMPTY;
	private String status = StringUtils.EMPTY;
	private Date joinedDateFrom;
	private Date joinedDateTo;

	private List<String> selectedGenders;

	public void onGlobalFiltering() {
		// only execute search for more than 2 words
		if (this.globalString.length() >= 2) {
			RequestContext.getCurrentInstance().execute(
					"filterEmployees(); refreshFooter();");
		}
	}

	public void resetJoinedDateFrom() {
		joinedDateFrom = null;
	}

	public void resetJoinedDateTo() {
		joinedDateTo = null;
	}

	public String getGlobalString() {
		return globalString;
	}

	public void setGlobalString(String globalString) {
		this.globalString = globalString;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getJoinedDateFrom() {
		return joinedDateFrom;
	}

	public void setJoinedDateFrom(Date joinedDateFrom) {
		this.joinedDateFrom = joinedDateFrom;
	}

	public Date getJoinedDateTo() {
		return joinedDateTo;
	}

	public void setJoinedDateTo(Date joinedDateTo) {
		this.joinedDateTo = joinedDateTo;
	}

	public List<String> getSelectedGenders() {
		return selectedGenders;
	}

	public void setSelectedGenders(List<String> selectedGenders) {
		this.selectedGenders = selectedGenders;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getStatuses() {
		return EmployeeStatus.getAll();
	}

	public String getStatusLocaleKey(String value) {
		if (value == null || StringUtils.EMPTY.equals(value))
			return StringUtils.EMPTY;
		EmployeeStatus s = EmployeeStatus.valueOf(value);
		return s.getLocalizedString();
	}

	/* For Order */
	public String getJoinedDate() {
		return EmpField.JOINED_DATE;
	}

	public String getBirthDay() {
		return EmpField.BIRTHDAY;
	}
}
