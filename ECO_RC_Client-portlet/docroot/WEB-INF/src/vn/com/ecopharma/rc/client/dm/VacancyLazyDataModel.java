package vn.com.ecopharma.rc.client.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.rc.client.constant.VacancyField;
import vn.com.ecopharma.rc.client.dto.VacancyIndexItem;
import vn.com.ecopharma.rc.client.util.RCClientUtils;

import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class VacancyLazyDataModel extends LazyDataModel<VacancyIndexItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public VacancyIndexItem getRowData(String rowKey) {
		return new VacancyIndexItem(rowKey);
	}

	@Override
	public Object getRowKey(VacancyIndexItem object) {
		return object.getId();
	}

	@Override
	public List<VacancyIndexItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		/* FILTERS */
		final SearchContext searchContext = getSearchContext();

		/* SORT */
		Sort searchSort = null;
		if (sortField != null) {
			searchSort = new Sort(sortField,
					sortOrder.equals(SortOrder.ASCENDING) ? false : true);
		} else {
			searchSort = new Sort(VacancyField.VACANCY_ID, false);
		}
		setPageSize(pageSize);
		try {
			List<VacancyIndexItem> result = RCClientUtils
					.getVacancyIndexItems(VacancyLocalServiceUtil
							.filterByFields(searchContext, filters, searchSort,
									searchContext.getCompanyId(), first, first
											+ pageSize));
			int rowCount = VacancyLocalServiceUtil.countFilterByFields(
					searchContext, filters, searchSort,
					searchContext.getCompanyId());
			setRowCount(rowCount);
			return result;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	private SearchContext getSearchContext() {
		return RCClientUtils.getCurrentSearchContext();
	}

}
