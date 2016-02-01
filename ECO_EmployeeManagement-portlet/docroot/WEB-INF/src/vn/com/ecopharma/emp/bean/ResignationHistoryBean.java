package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.ResignationFilterBean;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dm.ResignationHistoryIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.ResignationHistoryIndexedItem;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.FilterUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;

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
		lazyDataModel = new ResignationHistoryIndexLazyDataModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<ResignationHistoryIndexedItem> load(int first,
					int pageSize, String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				final ResignationFilterBean filterBean = BeanUtils
						.getResignationFilterBean();

				if (!StringUtils.EMPTY.equals(filterBean.getFullName())) {
					filters.put(EmpField.VN_FULL_NAME, filterBean.getFullName());
				}

				if (!StringUtils.EMPTY.equals(filterBean.getEmpCode())) {
					filters.put(EmpField.EMP_CODE, filterBean.getEmpCode());
				}

				FilterUtils.bindOrgFilters(filterBean, filters);
				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}

		};
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
