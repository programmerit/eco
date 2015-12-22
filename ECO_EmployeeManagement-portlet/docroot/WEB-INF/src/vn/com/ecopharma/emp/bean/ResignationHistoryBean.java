package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.emp.dm.ResignationHistoryIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.ResignationHistoryIndexedItem;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

@ManagedBean
@ViewScoped
public class ResignationHistoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ResignationHistoryIndexedItem selectedItem;

	private LazyDataModel<ResignationHistoryIndexedItem> lazyDataModel;

	@PostConstruct
	public void init() {
		lazyDataModel = new ResignationHistoryIndexLazyDataModel();
	}

	public void onRemoveAllIndex(ActionEvent event) {
		ResignationHistoryLocalServiceUtil.removeAllIndexes(EmployeeUtils
				.getCurrentSearchContext(), EmployeeUtils
				.getCurrentSearchContext().getCompanyId());
	}

	public void onIndexAll(ActionEvent event) {
		ResignationHistoryLocalServiceUtil.indexAll();
	}

	public LazyDataModel<ResignationHistoryIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<ResignationHistoryIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public ResignationHistoryIndexedItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(ResignationHistoryIndexedItem selectedItem) {
		this.selectedItem = selectedItem;
	}

}
