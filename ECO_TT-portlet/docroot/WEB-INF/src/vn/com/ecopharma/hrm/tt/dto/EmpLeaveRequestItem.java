package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

public class EmpLeaveRequestItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpIndexedItem emp;

	private VacationLeave leave;

	public EmpLeaveRequestItem(EmpIndexedItem emp, VacationLeave leave) {
		this.emp = emp;
		this.leave = leave;
	}

	public EmpLeaveRequestItem(EmpIndexedItem emp) {
		this(emp, VacationLeaveLocalServiceUtil
				.createPrePersistedEntity(TTUtils.getServiceContext()));
	}

	public EmpIndexedItem getEmp() {
		return emp;
	}

	public void setEmp(EmpIndexedItem emp) {
		this.emp = emp;
	}

	public VacationLeave getLeave() {
		return leave;
	}

	public void setLeave(VacationLeave leave) {
		this.leave = leave;
	}
}
