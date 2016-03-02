package vn.com.ecopharma.emp.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.emp.dm.PromotionHistoryIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.PromotedHistoryIndexedItem;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

@ManagedBean
@ViewScoped
public class PromotionHistoryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PromotedHistoryIndexedItem selectedItem;

	private LazyDataModel<PromotedHistoryIndexedItem> lazyDataModel;

	@PostConstruct
	public void init() {
		lazyDataModel = new PromotionHistoryIndexLazyDataModel();
	}

	public void onRowEdit(RowEditEvent event) {
		PromotedHistoryIndexedItem item = (PromotedHistoryIndexedItem) event
				.getObject();

		PromotedHistoryLocalServiceUtil.updatePromotedHistory(item.getId(),
				item.getPromotedDate(), item.getComment(),
				EmployeeUtils.getServiceContext());
	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public void onRemoveAllIndex(ActionEvent event) {
		PromotedHistoryLocalServiceUtil.removeAllIndexes(EmployeeUtils
				.getCurrentSearchContext(), EmployeeUtils
				.getCurrentSearchContext().getCompanyId());
	}

	public void onIndexAll(ActionEvent event) {
		PromotedHistoryLocalServiceUtil.indexAll();
	}

	public LazyDataModel<PromotedHistoryIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<PromotedHistoryIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public PromotedHistoryIndexedItem getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(PromotedHistoryIndexedItem selectedItem) {
		this.selectedItem = selectedItem;
	}

}
