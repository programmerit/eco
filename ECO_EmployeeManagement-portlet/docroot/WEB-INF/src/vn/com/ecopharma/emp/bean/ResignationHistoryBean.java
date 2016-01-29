package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import com.liferay.faces.portal.context.LiferayFacesContext;

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

	private String param1;

	@PostConstruct
	public void init() {
		lazyDataModel = new ResignationHistoryIndexLazyDataModel();
		System.out.println(param1);
	}

	public void onRowEdit(RowEditEvent event) {
		ResignationHistoryIndexedItem item = (ResignationHistoryIndexedItem) event
				.getObject();

		ResignationHistoryLocalServiceUtil.updateResignationHistory(
				item.getId(), item.getResignedDate(), item.getResignedType(),
				item.getComment());
	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public void addMissingResignedEmployee() {
		ResignationHistoryLocalServiceUtil
				.addMissingResignedEmployee(LiferayFacesContext.getInstance()
						.getServiceContext());
	}

	public void onRemoveAllIndex(ActionEvent event) {
		ResignationHistoryLocalServiceUtil.removeAllIndexes(EmployeeUtils
				.getCurrentSearchContext(), EmployeeUtils
				.getCurrentSearchContext().getCompanyId());
	}

	public void onIndexAll(ActionEvent event) {
		ResignationHistoryLocalServiceUtil.indexAll();
	}

	public List<String> getResignationTypes() {
		return EmployeeUtils.getResignationTypes();
	}

	public String getLocalizedResignationType(String r) {
		return EmployeeUtils.getLocalizedResignationType(r);
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

	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

}
