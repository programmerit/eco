package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.enumeration.VacationLeaveType;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

@ManagedBean(name = "leaveBean")
@ViewScoped
public class VacationLeaveBean {

	private VacationItem leave;

	@PostConstruct
	public void init() {
	}

	public void onSave() {
		FacesMessage msg = null;
		VacationLeave result = VacationLeaveLocalServiceUtil.addVacationLeave(
				leave.getEmp().getEmpId(), leave.getLeaveType(),
				leave.getLeaveFrom(), leave.getLeaveTo(), leave.getActualTo(),
				leave.getReason(), leave.getDescription(),
				EmployeeUtils.getServiceContext());
		msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Vacation Leave Information",
				"The selected employee was set on " + result.getLeaveType()
						+ " successfully");

		RequestContext.getCurrentInstance().execute(
				"PF('wLeaveDialog').hide();");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel() {

	}

	public List<String> getLeaveTypes() {
		return VacationLeaveType.getAll();
	}

	public VacationItem getLeave() {
		return leave;
	}

	public void setLeave(VacationItem leave) {
		this.leave = leave;
	}

	public static final class VacationItem implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private EmpIndexedItem emp;
		private String leaveType;
		private Date leaveFrom;
		private Date leaveTo;
		private Date actualTo;
		private String reason;
		private String description;

		public VacationItem(EmpIndexedItem emp) {
			this.emp = emp;
			this.leaveType = VacationLeaveType.MATERNITY.toString();
			this.leaveFrom = null;
			this.leaveTo = null;
			this.actualTo = null;
			this.reason = StringUtils.EMPTY;
			this.description = StringUtils.EMPTY;
		}

		public String getLeaveType() {
			return leaveType;
		}

		public void setLeaveType(String leaveType) {
			this.leaveType = leaveType;
		}

		public Date getLeaveFrom() {
			return leaveFrom;
		}

		public void setLeaveFrom(Date leaveFrom) {
			this.leaveFrom = leaveFrom;
		}

		public Date getLeaveTo() {
			if (leaveTo == null
					&& leaveFrom != null
					&& leaveType.equalsIgnoreCase(VacationLeaveType.MATERNITY
							.toString())) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(leaveFrom);
				calendar.add(Calendar.DATE, 180);
				leaveTo = calendar.getTime();
			}
			return leaveTo;
		}

		public void setLeaveTo(Date leaveTo) {
			this.leaveTo = leaveTo;
		}

		public Date getActualTo() {
			return actualTo;
		}

		public void setActualTo(Date actualTo) {
			this.actualTo = actualTo;
		}

		public String getReason() {
			return reason;
		}

		public void setReason(String reason) {
			this.reason = reason;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public EmpIndexedItem getEmp() {
			return emp;
		}

		public void setEmp(EmpIndexedItem emp) {
			this.emp = emp;
		}

	}
}
