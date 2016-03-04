package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.EmpLeaveRequestItem;
import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveType;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@ManagedBean
@ViewScoped
public class LeaveRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(LeaveRequestBean.class);

	private EmpLeaveRequestItem requestItem;

	public void onAddRequest(ActionEvent event) {
		VacationLeave leave = requestItem.getLeave();
		VacationLeave vacationLeave = VacationLeaveLocalServiceUtil
				.addVacationLeave(requestItem.getEmp().getId(), leave);

		if (vacationLeave != null) {
			List<Date> vacationRange = TimeTrackingLocalServiceUtil
					.getDatesBetweenTwoDates(vacationLeave.getLeaveFrom(),
							vacationLeave.getLeaveTo(), false, true);
			for (Date date : vacationRange) {

				final TimeTracking checkedTimeTracking = TimeTrackingLocalServiceUtil
						.findByEmpAndDate(vacationLeave.getEmpId(), date);

				if (checkedTimeTracking == null) {
					LOGGER.info("Adding timetracking Date: " + date);
					TimeTrackingLocalServiceUtil.addTimeTracking(
							vacationLeave.getEmpId(), date, null, null, null,
							null, null, null,
							vacationLeave.getVacationLeaveId(),
							TTUtils.getServiceContext());
				} else {
					LOGGER.info("Update timetracking Date: " + date);
					TimeTrackingLocalServiceUtil.setLeaveForTimeTracking(
							checkedTimeTracking,
							vacationLeave.getVacationLeaveId());
				}
			}

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
