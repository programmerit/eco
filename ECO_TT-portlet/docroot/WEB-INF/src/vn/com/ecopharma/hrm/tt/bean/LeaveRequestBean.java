package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.EmpLeaveRequestItem;
import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveType;
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
			List<Date> vacationRange = TTUtils.getDatesBetweenTwoDates(
					vacationLeave.getLeaveFrom(), vacationLeave.getLeaveTo(),
					false);
			for (Date date : vacationRange) {
				LOGGER.info("Adding timetracking Date: " + date);
				TimeTrackingLocalServiceUtil.addTimeTracking(
						vacationLeave.getEmpId(), date, null, null, null, null,
						null, null, vacationLeave.getVacationLeaveId(),
						TTUtils.getServiceContext());
			}

		}
	}

	public List<String> getAllTypes() {
		return VacationLeaveType.getAll();
	}

	public EmpLeaveRequestItem getRequestItem() {
		return requestItem;
	}

	public void setRequestItem(EmpLeaveRequestItem requestItem) {
		this.requestItem = requestItem;
	}

}
