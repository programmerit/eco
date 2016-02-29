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

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

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
				leave.getEmp().getEmpId(), leave.getLeave());
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

	public void onLeaveFromDateSelect(SelectEvent event) {
		final Date leaveFrom = leave.getLeave().getLeaveFrom();
		if (leaveFrom != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(leaveFrom);
			calendar.add(Calendar.DATE, 180);
			leave.getLeave().setLeaveTo(calendar.getTime());
		}
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
		private VacationLeave leave;

		public VacationItem(EmpIndexedItem emp) {
			this.emp = emp;
			this.leave = VacationLeaveLocalServiceUtil
					.createPrePersistedEntity(EmployeeUtils.getServiceContext());
			this.leave.setLeaveType(VacationLeaveType.MATERNITY.toString());
		}

		public VacationLeave getLeave() {
			return leave;
		}

		public void setLeave(VacationLeave leave) {
			this.leave = leave;
		}

		public EmpIndexedItem getEmp() {
			return emp;
		}

		public void setEmp(EmpIndexedItem emp) {
			this.emp = emp;
		}

	}
}
