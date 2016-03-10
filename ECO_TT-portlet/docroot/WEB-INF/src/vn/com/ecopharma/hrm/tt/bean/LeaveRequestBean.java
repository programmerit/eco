package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

	public void onInOutDateChange() {
		final Date timeFrom = requestItem.getLeave().getLeaveFrom();
		final Date timeTo = requestItem.getLeave().getLeaveTo();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(requestItem.getInOutDate());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);

		if (timeFrom != null) {
			calendar.setTime(timeFrom);
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DAY_OF_MONTH, day);
		}
		requestItem.getLeave().setLeaveFrom(calendar.getTime());

		if (timeTo != null) {
			calendar.setTime(timeTo);
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.MONTH, month);
			calendar.set(Calendar.DAY_OF_MONTH, day);
		}
		requestItem.getLeave().setLeaveTo(calendar.getTime());
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

}
