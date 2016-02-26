package vn.com.ecopharma.hrm.tt.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dto.EmpTimeTrackingIndexedItem;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;

public class TimeTrackingReportLazyDataModel extends
		LazyDataModel<EmpTimeTrackingIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(TimeTrackingReportLazyDataModel.class);

	private static final long YEAR_MONTH_DATE_CONS = 86400000L; // 24*60*60*1000L

	@Override
	public List<EmpTimeTrackingIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		try {
			final SearchContext searchContext = TTUtils
					.getCurrentSearchContext();
			// final List<Query> queries = new ArrayList<>();

			// add Filtered values
			// for (Map.Entry<String, Object> entry : filters.entrySet()) {
			// if (!entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.FILTERED_DATE_FROM)
			// && !entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.FILTERED_DATE_TO)
			// && !entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.GLOBAL)
			// && !entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.MONTH)
			// && !entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.YEAR)
			// && !entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.IS_EMPTY_IN)
			// && !entry.getKey().equalsIgnoreCase(
			// TimeTrackingField.IS_EMPTY_OUT)) {
			// BooleanQuery query = BooleanQueryFactoryUtil
			// .create(searchContext);
			// query.addTerm(entry.getKey(), (String) entry.getValue(),
			// true, BooleanClauseOccur.MUST);
			// queries.add(query);
			// }
			// }

			final List<Document> empDocs = EmpLocalServiceUtil
					.filterEmployeeByFields(TTUtils.getCurrentSearchContext(),
							filters, null, TTUtils.getCompanyId(), first, first
									+ pageSize);
			final List<EmpTimeTrackingIndexedItem> empTimeTrackingIndexedItems = new ArrayList<>();

			for (Document document : empDocs) {
				final EmpTimeTrackingIndexedItem empTimeTrackingIndexedItem = new EmpTimeTrackingIndexedItem(
						document);
				final int month = (Integer) filters
						.get(TimeTrackingField.MONTH);

				final int year = (Integer) filters.get(TimeTrackingField.YEAR);

				final List<TimeTrackingIndexItem> timeTrackingIndexItems = TTUtils
						.getTimeTrackingIndexItems(
								empTimeTrackingIndexedItem.getEmployeeCode(),
								month, year, true, true);

				LOGGER.info(empTimeTrackingIndexedItem.getFullName() + "    "
						+ timeTrackingIndexItems.size());

				final Map<String, Date> minInMap = getMinInMap(timeTrackingIndexItems);
				final Map<String, Date> maxOutMap = getMaxOutMap(timeTrackingIndexItems);
				empTimeTrackingIndexedItem.setMinInMap(minInMap);
				empTimeTrackingIndexedItem.setMaxOutMap(maxOutMap);
				empTimeTrackingIndexedItem
						.setGrandTotalMinInTime(getGrandMinIn(minInMap));
				empTimeTrackingIndexedItem
						.setGrandTotalMaxOutTime(getGrandMaxOut(maxOutMap));
				empTimeTrackingIndexedItems.add(empTimeTrackingIndexedItem);
			}
			int countTotal = EmpLocalServiceUtil.countFilterEmployeeByFields(
					searchContext, filters, null, TTUtils.getCompanyId());
			setPageSize(pageSize);
			setRowCount(countTotal);

			return empTimeTrackingIndexedItems;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	// private static boolean hasEmptyIn(
	// List<TimeTrackingIndexItem> timeTrackingIndexItems) {
	// for (TimeTrackingIndexItem item : timeTrackingIndexItems) {
	// if ("true".equalsIgnoreCase(item.getEmptyIn())) {
	// return true;
	// }
	// }
	// return false;
	// }
	//
	// private static boolean hasEmptyOut(
	// List<TimeTrackingIndexItem> timeTrackingIndexItems) {
	// for (TimeTrackingIndexItem item : timeTrackingIndexItems) {
	// if ("true".equalsIgnoreCase(item.getEmptyOut())) {
	// return true;
	// }
	// }
	// return false;
	// }

	@Override
	public EmpTimeTrackingIndexedItem getRowData(String rowKey) {
		return new EmpTimeTrackingIndexedItem(
				EmpLocalServiceUtil.getIndexedEmp(rowKey, getSearchContext()));
	}

	@Override
	public Object getRowKey(EmpTimeTrackingIndexedItem object) {
		return object.getEmployeeId();
	}

	// Other helper methods

	private static SearchContext getSearchContext() {
		return TTUtils.getCurrentSearchContext();
	}

	public Map<String, Date> getMinInMap(
			List<TimeTrackingIndexItem> timeTrackingIndexItems) {
		Map<String, Date> resultMap = new LinkedHashMap<>();
		for (TimeTrackingIndexItem item : timeTrackingIndexItems) {
			final Date[] inArray = new Date[] { item.getIn1(), item.getIn2(),
					item.getIn3() };
			// resultMap.put(item.getDateFormatted(), item.getIn1());
			Date min = null;
			resultMap.put(item.getDateFormatted(),
					TTUtils.compareAndGetMinTime(0, min, inArray));

		}
		return resultMap;
	}

	public Map<String, Date> getMaxOutMap(
			List<TimeTrackingIndexItem> timeTrackingIndexItems) {
		Map<String, Date> resultMap = new LinkedHashMap<>();
		for (TimeTrackingIndexItem item : timeTrackingIndexItems) {
			final Date[] outArray = new Date[] { item.getOut1(),
					item.getOut2(), item.getOut3() };

			final Date[] inArray = new Date[] { item.getIn1(), item.getIn2(),
					item.getIn3() };
			Date max = null;
			resultMap.put(item.getDateFormatted(),
					TTUtils.compareAndGetMaxTime(0, max, outArray, inArray));
		}
		return resultMap;
	}

	private static Date getGrandMinIn(Map<String, Date> map) {
		if (map == null || map.values().isEmpty())
			return null;
		Date min = null;
		for (Date date : map.values()) {
			if (min == null) {
				min = date;
			} else {
				if (date != null && compareTimes(date, min) < 0) {
					min = date;
				}
			}
		}
		return min;
	}

	private static Date getGrandMaxOut(Map<String, Date> map) {
		if (map == null || map.values().isEmpty())
			return null;
		Date max = null;
		for (Date date : map.values()) {
			if (max == null) {
				max = date;
			} else {
				if (date != null && compareTimes(date, max) > 0) {
					max = date;
				}
			}
		}
		return max;
	}

	/**
	 * Compare ONLY TIME(HH:mm) from 2 dates
	 * 
	 * @param d1
	 *            first date
	 * @param d2
	 *            second date
	 * @return value < 0: d1 less than d2; value > 0: d1 larger than d2
	 */
	private static int compareTimes(Date d1, Date d2) {
		int t1;
		int t2;

		t1 = (int) (d1.getTime() % (YEAR_MONTH_DATE_CONS));
		t2 = (int) (d2.getTime() % (YEAR_MONTH_DATE_CONS));
		return t1 - t2;
	}

}
