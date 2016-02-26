package vn.com.ecopharma.emp.dm;

import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.dto.AbstractIndexedItem;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;

public abstract class AbstractBaseOrganizationLazyDataModel<T extends AbstractIndexedItem>
		extends AbstractIndexedLazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(AbstractBaseOrganizationLazyDataModel.class);

	@Override
	public abstract List<T> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters);

	@Override
	public abstract T getRowData(String rowKey);

	@SuppressWarnings("unchecked")
	protected void bindOrganizationFilterFields(Map<String, Object> filters,
			List<Query> queries) throws ParseException {
		final SearchContext searchContext = getSearchContext();
		//FilterUtils.bindOrgFilters(bean, filters);
	}

}
