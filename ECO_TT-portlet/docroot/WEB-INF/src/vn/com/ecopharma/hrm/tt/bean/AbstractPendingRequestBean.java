package vn.com.ecopharma.hrm.tt.bean;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;

import vn.com.ecopharma.hrm.tt.dto.VacationLeaveIndexedItem;

public abstract class AbstractPendingRequestBean extends BaseBean {

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
}
