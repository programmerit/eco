package vn.com.ecopharma.hrm.tt.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.service.ServiceContext;

@ManagedBean(name = "managerPendingRequestActionBean")
@ViewScoped
public class ManagerPendingRequestActionBean extends AbstractPendingRequestBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(ManagerPendingRequestActionBean.class);

	@Override
	public void onConfirmApproval(ActionEvent event) {
		for (VacationLeaveIndexedItem item : getPendingRequests().getTarget()) {
			try {
				LOGGER.info("On Approving " + item.getFullNameVi());
				VacationLeave vacationLeave = VacationLeaveLocalServiceUtil
						.fetchVacationLeave(item.getId());
				VacationLeaveLocalServiceUtil.setManagerApproval(vacationLeave,
						getServiceContext());
				LOGGER.info(item.getFullNameVi() + " was approved");
			} catch (SystemException e) {
				LOGGER.info(e);
			}

		}
		FacesMessage message = new FacesMessage("Notice!", getPendingRequests()
				.getTarget().size() + " was approved");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	@Override
	protected DualListModel<VacationLeaveIndexedItem> getPendingRequestDualList() {
		return new DualListModel<>(getPendingVacationLeaveRequests(),
				new ArrayList<VacationLeaveIndexedItem>());
	}

	public boolean isCurrentManager() {
		long currentUserId = TTUtils.getServiceContext().getUserId();
		return EmpOrgRelationshipLocalServiceUtil
				.isHeadOfAtLeastOneDepartment(currentUserId);
	}

	public List<VacationLeaveIndexedItem> getPendingVacationLeaveRequests() {
		final List<VacationLeaveIndexedItem> result = new ArrayList<>();
		if (isCurrentManager()) {
			ServiceContext serviceContext = TTUtils.getServiceContext();
			long currentUserId = serviceContext.getUserId();
			Emp emp = EmpLocalServiceUtil.findByUser(currentUserId);
			List<Document> pendingRequests = VacationLeaveLocalServiceUtil
					.searchPendingRequestsOfManager(emp.getEmpId(),
							TTUtils.getCurrentSearchContext(),
							serviceContext.getCompanyId());

			for (Document r : pendingRequests) {
				result.add(new VacationLeaveIndexedItem(r));
			}
		}
		return result;
	}

}