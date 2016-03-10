package vn.com.ecopharma.hrm.tt.dto;

import java.io.Serializable;
import java.util.Date;

import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

public class EmpLeaveRequestItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpIndexedItem emp;

	private VacationLeave leave;

	private EmpAnnualLeave annualLeave;

	private Date inOutDate;

	public EmpLeaveRequestItem(EmpIndexedItem emp, VacationLeave leave) {
		this.emp = emp;
		this.leave = leave;
		this.annualLeave = EmpAnnualLeaveLocalServiceUtil.fetchByEmp(emp
				.getEmpId());
	}

	public EmpLeaveRequestItem(EmpIndexedItem emp) {
		this(emp, VacationLeaveLocalServiceUtil
				.createPrePersistedEntity(TTUtils.getServiceContext()));
	}

	public EmpLeaveRequestItem(long empId) {
		this(new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(empId,
				TTUtils.getCurrentSearchContext())));
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

	public EmpAnnualLeave getAnnualLeave() {
		return annualLeave;
	}

	public void setAnnualLeave(EmpAnnualLeave annualLeave) {
		this.annualLeave = annualLeave;
	}

	public Date getInOutDate() {
		return inOutDate;
	}

	public void setInOutDate(Date inOutDate) {
		this.inOutDate = inOutDate;
	}

}
