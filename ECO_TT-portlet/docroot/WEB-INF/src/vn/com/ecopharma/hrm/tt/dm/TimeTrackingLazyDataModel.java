package vn.com.ecopharma.hrm.tt.dm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.constant.EmpField;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;

public class TimeTrackingLazyDataModel extends
		LazyDataModel<TimeTrackingIndexItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String FILTER_DATE_FORMAT = "yyyyMMddhhmmss";

	private static final String MIN_FILTER_DATE = "19700101000000";

	private static final String[] GLOBAL_FILTER_FIELDS = new String[] {
			TimeTrackingField.EMP_CODE, TimeTrackingField.FULLNAME,
			TimeTrackingField.DEVISION, TimeTrackingField.DEPARTMENT,
			TimeTrackingField.UNIT, TimeTrackingField.UNIT_GROUP,
			TimeTrackingField.TITLES, TimeTrackingField.DATE };

	@Override
	public TimeTrackingIndexItem getRowData(String rowKey) {
		return new TimeTrackingIndexItem(
				TimeTrackingLocalServiceUtil.getIndexedTimeTracking(rowKey,
						TTUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(TimeTrackingIndexItem object) {
		return object.getId();
	}

	@Override
	public List<TimeTrackingIndexItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		try {
			final List<Query> queries = new ArrayList<Query>();
			final SearchContext searchContext = TTUtils
					.getCurrentSearchContext();

			// add Filtered values
			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				if (!entry.getKey().equalsIgnoreCase(
						TimeTrackingField.FILTERED_DATE_FROM)
						&& !entry.getKey().equalsIgnoreCase(
								TimeTrackingField.FILTERED_DATE_TO)
						&& !entry.getKey().equalsIgnoreCase(
								TimeTrackingField.GLOBAL)) {
					BooleanQuery query = BooleanQueryFactoryUtil
							.create(searchContext);
					query.addTerm(entry.getKey(), (String) entry.getValue(),
							true, BooleanClauseOccur.MUST);
					queries.add(query);
				}
			}

			// add global filter
			if (filters.get(TimeTrackingField.GLOBAL) != null) {
				final BooleanQuery globalFilterQuery = BooleanQueryFactoryUtil
						.create(searchContext);
				globalFilterQuery.addTerms(GLOBAL_FILTER_FIELDS,
						(String) filters.get(TimeTrackingField.GLOBAL), true);
				queries.add(globalFilterQuery);
			}

			// filtered date termRange
			final SimpleDateFormat sdf = new SimpleDateFormat(
					FILTER_DATE_FORMAT);
			String dateFrom = MIN_FILTER_DATE; // default date from
			String dateTo = sdf.format(new Date()); // get today as default date
													// to
			if (filters.get(TimeTrackingField.FILTERED_DATE_FROM) != null) {
				dateFrom = sdf.format(filters
						.get(TimeTrackingField.FILTERED_DATE_FROM));
			}

			if (filters.get(TimeTrackingField.FILTERED_DATE_TO) != null) {
				dateTo = sdf.format(filters
						.get(TimeTrackingField.FILTERED_DATE_TO));
			}

			// create term range query
			final TermRangeQuery filteredDateRangeQuery = TermRangeQueryFactoryUtil
					.create(searchContext, TimeTrackingField.DATE, dateFrom,
							dateTo, true, true);

			queries.add(filteredDateRangeQuery);

			final List<Document> documents = TimeTrackingLocalServiceUtil
					.search(TTUtils.getCurrentSearchContext(), queries, TTUtils
							.getCompanyId(), new Sort(TimeTrackingField.ID,
							false), first, first + pageSize);
			setPageSize(pageSize);
			setRowCount(TimeTrackingLocalServiceUtil.countSearch(
					TTUtils.getCurrentSearchContext(), queries,
					TTUtils.getCompanyId()));

			return TTUtils.getTimeTrackingIndexItems(documents);
		} catch (ParseException e) {
			LogFactoryUtil.getLog(EmpField.class).info(
					"Exception while fetching all time tracking index", e);
		} catch (SearchException e) {
			LogFactoryUtil.getLog(EmpField.class).info(
					"Exception while fetching all time tracking index", e);
		}
		return new ArrayList<>();
	}
}
