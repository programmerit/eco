package vn.com.ecopharma.hrm.tt.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.tt.dto.EmpLeaveRequestItem;
import vn.com.ecopharma.hrm.tt.utils.BeanUtils;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.service.ServiceContext;

@ManagedBean
@ViewScoped
public class MainBean extends BaseDialogBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PostConstruct
	public void init() {

	}

	public void onRequestLeave() {
		long requestUserId = TTUtils.getServiceContext().getUserId();
		Emp emp = EmpLocalServiceUtil.findByUser(requestUserId);
		if (emp != null) {
			EmpIndexedItem empIndexedItem = new EmpIndexedItem(
					EmpLocalServiceUtil.getIndexedEmp(emp.getEmpId(),
							getSearchContext()));
			if (empIndexedItem != null) {
				LeaveRequestBean requestBean = BeanUtils.getLeaveRequestBean();
				requestBean.setRequestItem(new EmpLeaveRequestItem(
						empIndexedItem));
				setIncludedDialog("/views/dialogs/leaveRequestDialog.xhtml");
			}
		}

	}

	public boolean isCurrentManager() {
		long currentUserId = TTUtils.getServiceContext().getUserId();
		return EmpOrgRelationshipLocalServiceUtil
				.isHeadOfAtLeastOneDepartment(currentUserId);
	}

	public boolean isHr() {
		return BeanUtils.getEmployeeModelPermission().isHrPermission();
	}

	public int getManagerPendingVacationLeaveRequests() {
		ServiceContext serviceContext = TTUtils.getServiceContext();
		if (isCurrentManager()) {
			long currentUserId = serviceContext.getUserId();
			Emp emp = EmpLocalServiceUtil.findByUser(currentUserId);
			return VacationLeaveLocalServiceUtil
					.searchPendingRequestsOfManager(emp.getEmpId(),
							TTUtils.getCurrentSearchContext(),
							serviceContext.getCompanyId()).size();
		}
		return 0;
	}

	public int getHrPendingVacationLeaveRequests() {
		ServiceContext serviceContext = TTUtils.getServiceContext();
		if (isHr()) {
			return VacationLeaveLocalServiceUtil.searchManagerApprovalList(
					getSearchContext(), serviceContext.getCompanyId()).size();
		}
		return 0;
	}

}
