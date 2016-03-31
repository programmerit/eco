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

	public void onLeaveTypeSelectChanged() {
		requestItem.getLeave().setSign(StringUtils.EMPTY);
	}

	public void onLeaveFromSelect(SelectEvent event) {
		VacationLeave leave = requestItem.getLeave();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(leave.getLeaveFrom());
		if (leave.getLeaveType().equalsIgnoreCase(
				VacationLeaveType.POLICY_LEAVE.toString())
				&& leave.getSign().equalsIgnoreCase("TS")) {
			calendar.setTime(leave.getLeaveFrom());
			calendar.add(Calendar.DAY_OF_MONTH, 180);
			requestItem.getLeave().setLeaveTo(calendar.getTime());
		}

		if (leave.getSign().contains("1/2")) {
			// set default 8:00AM - 12:00PM for half day leave
			calendar.set(Calendar.HOUR, 8);
			leave.setLeaveFrom(calendar.getTime());

			calendar.set(Calendar.HOUR, 12);
			leave.setLeaveTo(calendar.getTime());
		}
	}

	public void onInOutDateChange() {
		requestItem.getLeave()
				.setLeaveTo(requestItem.getLeave().getLeaveFrom());
	}

	public List<String> getAllTypes() {
		return VacationLeaveType.getAll();
	}

	public String getHardCodeVneseTypeString(String leaveType) {
		return StringUtils.EMPTY.equals(leaveType) ? StringUtils.EMPTY
				: VacationLeaveType.valueOf(leaveType).getHardCodeVneseString();
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

	public List<String> getReasons() {
		if (requestItem.getLeave() == null)
			return new ArrayList<>();

		if (requestItem.getLeave().getLeaveType() == null
				|| requestItem.getLeave().getLeaveType()
						.equalsIgnoreCase(StringUtils.EMPTY)
				|| !isInOutRequest())
			return new ArrayList<>();

		VacationLeaveType leaveType = VacationLeaveType.valueOf(requestItem
				.getLeave().getLeaveType());
		return leaveType.getReasons();
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

	public String getQaSignTooltip() {
		if (getSigns().isEmpty())
			return StringUtils.EMPTY;

		StringBuilder result = new StringBuilder();
		for (String sign : getSigns()) {
			if (sign.equalsIgnoreCase("TS")) {
				result.append(" TS: Thai Sản;");
			} else if (sign.equalsIgnoreCase("CD")) {
				result.append(" CD: Chế Độ;");
			} else if (sign.equalsIgnoreCase("OD")) {
				result.append(" OD: Ốm đau;");
			} else if (sign.equalsIgnoreCase("CO")) {
				result.append(" CO: Con ốm;");
			} else if (sign.equalsIgnoreCase("NB")) {
				result.append(" NB: Nguyên ngày;");
			} else if (sign.equalsIgnoreCase("1/2NB")) {
				result.append(" 1/2NB: Nửa ngày;");
			} else if (sign.equalsIgnoreCase("P")) {
				result.append(" P: Nguyên ngày;");
			} else if (sign.equalsIgnoreCase("1/2P")) {
				result.append(" 1/2P: Nửa ngày;");
			} else if (sign.equalsIgnoreCase("N")) {
				result.append(" N: Nguyên ngày;");
			} else if (sign.equalsIgnoreCase("1/2N")) {
				result.append(" 1/2N: Nửa ngày;");
			}
		}
		return result.toString();
	}

	public boolean isInOutRequest() {
		return requestItem.getLeave().getLeaveType()
				.equalsIgnoreCase(VacationLeaveType.IN.toString())
				|| requestItem.getLeave().getLeaveType()
						.equalsIgnoreCase(VacationLeaveType.OUT.toString());
	}

	public boolean isInRequest() {
		return requestItem.getLeave().getLeaveType()
				.equalsIgnoreCase(VacationLeaveType.IN.toString());
	}

	public boolean isOutRequest() {
		return requestItem.getLeave().getLeaveType()
				.equalsIgnoreCase(VacationLeaveType.IN.toString());
	}

	public boolean isHalfDayLeaveRequest() {
		return requestItem.getLeave().getSign().contains("1/2");
	}

}
