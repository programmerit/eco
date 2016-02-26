package vn.com.ecopharma.emp.dm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.AbstractIndexedItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.util.FilterUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;

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
