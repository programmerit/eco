package vn.com.ecopharma.hrm.tt.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.enumeration.VacationLeaveStatus;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.BeanUtils;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "hrPendingRequestActionBean")
@ViewScoped
public class HrPendingRequestActionBean extends AbstractPendingRequestBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(HrPendingRequestActionBean.class);

	@Override
	public void onConfirmApproval(ActionEvent event) {
		List<VacationLeaveIndexedItem> approvedList = getPendingRequests()
				.getTarget();
		for (int i = 0; i < approvedList.size(); i++) {
			VacationLeaveIndexedItem item = approvedList.get(i);
			long id = item.getId();
			VacationLeave result = VacationLeaveLocalServiceUtil.setHrApproval(
					id, getServiceContext());
			if (result != null
					&& result.getStatus().equalsIgnoreCase(
							VacationLeaveStatus.HR_APPROVED.toString())) {
				Date dateFrom = result.getLeaveFrom();
				Date dateTo = result.getLeaveTo();
				long empId = item.getEmpId();
				long leaveId = result.getVacationLeaveId();
				// request 1 DAY, 1/2 DAY leave
				if (dateFrom.compareTo(dateTo) == 0) {
					addOrUpdateLeave(empId, dateFrom, leaveId);
				} else {
					final List<Date> vacationLeaveRange = TimeTrackingLocalServiceUtil
							.getDatesBetweenTwoDates(dateFrom, dateTo, false,
									true);
					for (Date date : vacationLeaveRange) {
						addOrUpdateLeave(empId, date, leaveId);
					}
				}
				approvedList.remove(item);
			}
			LOGGER.info(item.getFullNameVi() + " was approved by HR");
		}
		FacesMessage message = new FacesMessage("Notice!", getPendingRequests()
				.getTarget().size() + " was approved by HR");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public TimeTracking addOrUpdateLeave(long empId, Date date, long leaveId) {
		TimeTracking result = null;
		TimeTracking checkedTimeTracking = TimeTrackingLocalServiceUtil
				.fetchByEmpAndDate(empId, date);

		// late-request -> just update leave ref...
		if (checkedTimeTracking != null) {
			result = TimeTrackingLocalServiceUtil.setLeaveForTimeTracking(
					checkedTimeTracking, leaveId);
		} else { // request before leave...
			result = TimeTrackingLocalServiceUtil.addTimeTracking(empId, date,
					null, null, null, null, null, null, leaveId,
					getServiceContext());
		}
		return result;
	}

	@Override
	protected DualListModel<VacationLeaveIndexedItem> getPendingRequestDualList() {
		return new DualListModel<>(getPendingVacationLeaveRequests(),
				new ArrayList<VacationLeaveIndexedItem>());
	}

	public boolean isHr() {
		return BeanUtils.getEmployeeModelPermission().isHrPermission();
	}

	public List<VacationLeaveIndexedItem> getPendingVacationLeaveRequests() {
		final List<VacationLeaveIndexedItem> result = new ArrayList<>();
		if (isHr()) {
			ServiceContext serviceContext = TTUtils.getServiceContext();
			List<Document> pendingRequests = VacationLeaveLocalServiceUtil
					.searchManagerApprovalList(getSearchContext(),
							serviceContext.getCompanyId());
			for (Document r : pendingRequests) {
				result.add(new VacationLeaveIndexedItem(r));
			}
		}
		return result;
	}

}