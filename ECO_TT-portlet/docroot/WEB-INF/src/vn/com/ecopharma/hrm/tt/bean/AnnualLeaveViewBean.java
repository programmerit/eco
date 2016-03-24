package vn.com.ecopharma.hrm.tt.bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.bean.filter.AnnualLeaveFilterBean;
import vn.com.ecopharma.hrm.tt.dm.AnnualLeaveLazyDataModel;
import vn.com.ecopharma.hrm.tt.dto.AnnualLeaveIndexedItem;

@ManagedBean
@ViewScoped
public class AnnualLeaveViewBean extends
		AbstractEditableBaseEmpIndexedItemDataTableBean<AnnualLeaveIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{annualLeaveFilterBean}")
	private AnnualLeaveFilterBean filterBean;

	@PostConstruct
	public void init() {
		super.init();
	}

	@Override
	public void onRowEdit(RowEditEvent event) {

	}

	@Override
	public void onRowEditCancel(RowEditEvent event) {

	}

	public void onIndexAll() {

	}

	public void onRemoveAllIndex() {

	}

	@Override
	protected LazyDataModel<AnnualLeaveIndexedItem> getConcreteLazyDataModel() {
		return new AnnualLeaveLazyDataModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<AnnualLeaveIndexedItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}

		};
	}

	public AnnualLeaveFilterBean getFilterBean() {
		return filterBean;
	}

	public void setFilterBean(AnnualLeaveFilterBean filterBean) {
		this.filterBean = filterBean;
	}

}
