package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

public abstract class AbstractPendingRequestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DualListModel<VacationLeaveIndexedItem> pendingRequests;

	private VacationLeaveIndexedItem selectedItem;

	@PostConstruct
	public void init() {
		this.pendingRequests = getPendingRequestDualList();
	}

	public void onConfirmApproval(ActionEvent event) {

	}

	public void onViewDetail(ActionEvent event) {

	}

	public void onTransfer(TransferEvent event) {

	}

	public void onSelect(SelectEvent event) {
		selectedItem = (VacationLeaveIndexedItem) event.getObject();
	}

	public void onUnSelect(UnselectEvent event) {
		selectedItem = null;
	}

	public void onReorder() {
	}

	public DualListModel<VacationLeaveIndexedItem> getPendingRequests() {
		return pendingRequests;
	}

	public void setPendingRequests(
			DualListModel<VacationLeaveIndexedItem> pendingRequests) {
		this.pendingRequests = pendingRequests;
	}

	public VacationLeaveIndexedItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(VacationLeaveIndexedItem selectedItem) {
		this.selectedItem = selectedItem;
	}

	protected abstract DualListModel<VacationLeaveIndexedItem> getPendingRequestDualList();

	protected SearchContext getSearchContext() {
		return TTUtils.getCurrentSearchContext();
	}

	protected ServiceContext getServiceContext() {
		return TTUtils.getServiceContext();
	}

}
