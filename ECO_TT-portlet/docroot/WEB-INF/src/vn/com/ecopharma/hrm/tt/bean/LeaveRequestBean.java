package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.SelectEvent;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.EmpLeaveRequestItem;
import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveType;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;

@ManagedBean
@ViewScoped
public class LeaveRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpLeaveRequestItem requestItem;

	public void onAddRequest(ActionEvent event) {
		VacationLeave leave = requestItem.getLeave();
		VacationLeave vacationLeave = VacationLeaveLocalServiceUtil
				.addVacationLeave(requestItem.getEmp().getId(), leave);
		TimeTrackingLocalServiceUtil
				.addOrUpdateTimeTrackingByLeaveRequest(vacationLeave);
	}

	public void onLeaveFromSelect(SelectEvent event) {
		VacationLeave leave = requestItem.getLeave();
		if (leave.getLeaveType().equalsIgnoreCase(
				VacationLeaveType.POLICY_LEAVE.toString())
				&& leave.getSign().equalsIgnoreCase("TS")) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(leave.getLeaveFrom());
			calendar.add(Calendar.DAY_OF_MONTH, 180);
			requestItem.getLeave().setLeaveTo(calendar.getTime());
		}
	}

	public List<String> getAllTypes() {
		return VacationLeaveType.getAll();
	}

	public List<String> getSigns() {
		if (requestItem.getLeave() == null)
			return new ArrayList<>();

		if (requestItem.getLeave().getLeaveType() == null
				|| requestItem.getLeave().getLeaveType()
						.equalsIgnoreCase(StringUtils.EMPTY))
			return new ArrayList<>();

		VacationLeaveType leaveType = VacationLeaveType.valueOf(requestItem
				.getLeave().getLeaveType());

		return leaveType.getSigns();
	}

	public boolean isTimeAvailable() {
		return requestItem.getLeave().getSign().contains("1/2");
	}

	public EmpLeaveRequestItem getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(EmpLeaveRequestItem requestItem) {
		this.requestItem = requestItem;
	}

}
