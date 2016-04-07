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

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;

public class VacancyLazyDM extends LazyDataModel<VacancyIndexItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public VacancyIndexItem getRowData(String rowKey) {
		return new VacancyIndexItem(
				VacancyLocalServiceUtil.getIndexVacancyDocument(rowKey,
						getSearchContext()));
	}

	@Override
	public Object getRowKey(VacancyIndexItem object) {
		return object.getId();
	}

	@Override
	public List<VacancyIndexItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		/* FILTERS */
		final List<Query> queries = new ArrayList<Query>();
		final SearchContext searchContext = getSearchContext();
		try {
			final BooleanQuery globalFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery nameFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery titlesNumberFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			final String[] effectFilterFields = new String[] {
					VacancyField.NAME, VacancyField.TITLES,
					VacancyField.NUMBER_OF_POSITION };

			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				System.out.println("FILTER BY: " + entry.getKey());
				if (entry.getValue() instanceof String) {
					System.out.println("FILTER VALUE: "
							+ (String) entry.getValue());
				} else if (entry.getValue() instanceof Integer) {
					System.out.println("FILTER VALUE: "
							+ (Integer) entry.getValue());
				}
			}

			if (filters.get(VacancyField.GLOBAL) != null) {
				globalFilterQuery.addTerms(effectFilterFields,
						(String) filters.get(VacancyField.GLOBAL), true);
				queries.add(globalFilterQuery);
			}

			if (filters.get(VacancyField.NAME) != null) {
				nameFilterQuery.addTerm(VacancyField.NAME,
						(String) filters.get(VacancyField.NAME), true);
				queries.add(nameFilterQuery);

			}

			if (filters.get(VacancyField.TITLES) != null) {
				titlesNumberFilterQuery.addTerm(VacancyField.TITLES,
						(String) filters.get(VacancyField.TITLES), true);
				queries.add(titlesNumberFilterQuery);

			}

			int numberOfPositionFrom = -1;
			int numberOfPositionTo = -1;
			boolean isFilteredByNumberOfPosition = Boolean.FALSE;
			final int inputFrom = (Integer) filters
					.get(VacancyField.NUMBER_POSITION_FROM);
			final int inputTo = (Integer) filters
					.get(VacancyField.NUMBER_POSITION_TO);
			if (inputFrom != -1 && inputTo != -1) {
				numberOfPositionFrom = inputFrom;
				numberOfPositionTo = inputTo;
				isFilteredByNumberOfPosition = true;
			} else if (inputFrom != -1) {
				numberOfPositionFrom = inputFrom;
				isFilteredByNumberOfPosition = true;
			} else if (inputTo != -1) {
				numberOfPositionTo = inputTo;
				isFilteredByNumberOfPosition = true;
			}

			if (isFilteredByNumberOfPosition) {
				final TermRangeQuery numberOfPositionTermRangeQuery = TermRangeQueryFactoryUtil
						.create(searchContext, VacancyField.NUMBER_OF_POSITION,
								String.valueOf(numberOfPositionFrom),
								String.valueOf(numberOfPositionTo), true, true);
				queries.add(numberOfPositionTermRangeQuery);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/* SORT */
		Sort searchSort = null;
		if (sortField != null) {
			searchSort = new Sort(sortField,
					sortOrder.equals(SortOrder.ASCENDING) ? false : true);
		} else {
			searchSort = new Sort(VacancyField.VACANCY_ID, false);
		}
		setPageSize(pageSize);
		setRowCount(VacancyLocalServiceUtil
				.countAllUnDeletedIndexedVacancyDocuments(getSearchContext(),
						queries, getSearchContext().getCompanyId(), searchSort));
		return RCClientUtils.getVacancyIndexItems(VacancyLocalServiceUtil
				.searchAllUnDeletedVacanciesIndexedDocument(getSearchContext(),
						queries, getSearchContext().getCompanyId(), searchSort,
						first, first + pageSize));
	}

	private SearchContext getSearchContext() {
		return RCClientUtils.getCurrentSearchContext();
	}

}
