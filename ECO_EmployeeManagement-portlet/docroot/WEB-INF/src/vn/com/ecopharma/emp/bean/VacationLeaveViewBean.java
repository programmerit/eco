package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.emp.dm.VacationLeaveIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.emp.enumeration.VacationLeaveType;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;

@ManagedBean(name = "leaveViewBean")
@ViewScoped
public class VacationLeaveViewBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private VacationLeaveIndexedItem selectedItem;

	private LazyDataModel<VacationLeaveIndexedItem> lazyDataModel;

	@PostConstruct
	public void init() {
		lazyDataModel = new VacationLeaveIndexLazyDataModel();
	}

	public void onRowEdit(RowEditEvent event) {

	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public void onIndexAll() {
		VacationLeaveLocalServiceUtil.indexAll();
	}

	public void onRemoveAllIndex() {

	}

	public List<String> getLeaveTypes() {
		return VacationLeaveType.getAll();
	}

	public LazyDataModel<VacationLeaveIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<VacationLeaveIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public VacationLeaveIndexedItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(VacationLeaveIndexedItem selectedItem) {
		this.selectedItem = selectedItem;
	}
}
