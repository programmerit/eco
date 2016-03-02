package vn.com.ecopharma.emp.dm;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.OrganizationFilterBean;
import vn.com.ecopharma.emp.dto.AbstractIndexedItem;
import vn.com.ecopharma.emp.util.FilterUtils;

import com.liferay.portal.kernel.search.ParseException;

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

	protected void bindOrganizationFilterFields(Map<String, Object> filters,
			S bean) {
		FilterUtils.bindOrgFilters(bean, filters);
	}

}
