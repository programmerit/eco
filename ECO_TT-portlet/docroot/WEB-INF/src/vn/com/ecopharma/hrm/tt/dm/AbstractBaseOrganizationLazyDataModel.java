package vn.com.ecopharma.hrm.tt.dm;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.bean.OrganizationFilterBean;
import vn.com.ecopharma.hrm.tt.dto.AbstractIndexedItem;
import vn.com.ecopharma.hrm.tt.utils.FilterUtils;

public abstract class AbstractBaseOrganizationLazyDataModel<T extends AbstractIndexedItem, S extends OrganizationFilterBean>
		extends AbstractIndexedLazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public abstract List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters);

	@Override
	public abstract T getRowData(String rowKey);

	protected void bindEmpFilterFields(Map<String, Object> filters,
			S bean) {
		FilterUtils.bindOrgFilters(bean, filters);
	}

}
