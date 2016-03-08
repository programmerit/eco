package vn.com.ecopharma.emp.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;

import vn.com.ecopharma.emp.dm.EmpAnnualLeaveIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.EmpAnnualLeaveIndexedItem;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

@ManagedBean
@ViewScoped
public class AnnualLeaveViewBean extends
		AbstractBaseIndexedDataTableBean<EmpAnnualLeaveIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		super.init();

	}

	public void onIndexAll() {
		EmpAnnualLeaveLocalServiceUtil.indexAll();
	}

	public void onRemoveAllIndex() {
		EmpAnnualLeaveLocalServiceUtil.removeAllIndexes(EmployeeUtils
				.getCurrentSearchContext(), EmployeeUtils.getServiceContext()
				.getCompanyId());
		;
	}

	public void onRowEdit(RowEditEvent event) {

	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	@Override
	public LazyDataModel<EmpAnnualLeaveIndexedItem> initializeLazyDataModel() {
		return new EmpAnnualLeaveIndexLazyDataModel();
	}

}
