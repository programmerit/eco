package vn.com.ecopharma.hrm.tt.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DualListModel;

import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
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
		for (VacationLeaveIndexedItem item : getPendingRequests().getTarget()) {
			LOGGER.info(item.getFullNameVi() + " was approved");
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