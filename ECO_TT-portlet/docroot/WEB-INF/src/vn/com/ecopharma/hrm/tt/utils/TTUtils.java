package vn.com.ecopharma.hrm.tt.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.hrm.tt.constant.EmpField;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dto.EmpTimeTrackingIndexedItem;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingReport;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

public class TTUtils {

	private static final String RANGE_DATE_FORMAT = "yyyyMMddhhmmss";

	private TTUtils() {
	}

	/**
	 * @return
	 */
	public static SearchContext getCurrentSearchContext() {
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		final PortletRequest req = (PortletRequest) liferayFacesContext
				.getExternalContext().getRequest();

		final HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(req));
		return SearchContextFactory.getInstance(httpServletRequest);
	}

	public static ServiceContext getServiceContext() {
		return LiferayFacesContext.getInstance().getServiceContext();
	}

	public static long getCompanyId() {
		return getServiceContext().getCompanyId();
	}

	public static List<TimeTrackingIndexItem> getTimeTrackingIndexItems(
			List<Document> documents) {
		final List<TimeTrackingIndexItem> result = new ArrayList<>(
				documents.size());
		for (Document document : documents) {
			result.add(new TimeTrackingIndexItem(document));
		}
		return result;
	}

	public static List<TimeTrackingReport> getTimeTrackingReports(
			List<Document> documents) {
		final List<TimeTrackingReport> result = new ArrayList<>(
				documents.size());
		for (Document document : documents) {
			result.add(new TimeTrackingReport(document));
		}
		return result;
	}

	/**
	 * @param documents
	 * @return
	 */
	public static List<EmpTimeTrackingIndexedItem> getEmployeeIndexedItemsFromIndexedDocuments(
			List<Document> documents) {

		final List<EmpTimeTrackingIndexedItem> results = new ArrayList<>(
				documents.size());
		for (final Document document : documents) {
			results.add(new EmpTimeTrackingIndexedItem(document));
		}
		return results;
	}

	/**
	 * find all Employee's time tracking data bases on employee code and the
	 * selected month/year
	 * 
	 * @param empCode
	 * @param month
	 * @param year
	 * @return
	 */
	public static List<TimeTrackingIndexItem> getTimeTrackingIndexItems(
			String empCode, int month, int year, boolean isEmptyIn,
			boolean isEmptyOut) {
		final SearchContext searchContext = TTUtils.getCurrentSearchContext();
		final List<Query> queries = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat(RANGE_DATE_FORMAT);
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, 0, 0, 0, 0);
		final int maxDayOfMonth = calendar
				.getActualMaximum(Calendar.DAY_OF_MONTH);
		final Date dateFrom = calendar.getTime();
		calendar.set(year, month, maxDayOfMonth, 0, 0, 0);
		final Date dateTo = calendar.getTime();

		String formattedDateFrom = sdf.format(dateFrom);
		String formattedDateTo = sdf.format(dateTo);
		final BooleanQuery empCodeBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);
		empCodeBooleanQuery.addExactTerm(EmpField.EMP_CODE, empCode);

		// final BooleanQuery emptyInBooleanQuery = BooleanQueryFactoryUtil
		// .create(searchContext);
		// emptyInBooleanQuery.addExactTerm(TimeTrackingField.IS_EMPTY_IN,
		// isEmptyIn ? "true" : "false");
		//
		// final BooleanQuery emptyOutBooleanQuery = BooleanQueryFactoryUtil
		// .create(searchContext);
		// emptyOutBooleanQuery.addExactTerm(TimeTrackingField.IS_EMPTY_OUT,
		// isEmptyOut ? "true" : "false");

		final TermRangeQuery monthRangeQuery = TermRangeQueryFactoryUtil
				.create(searchContext, TimeTrackingField.DATE,
						formattedDateFrom, formattedDateTo, true, true);

		// queries.add(emptyInBooleanQuery);
		// queries.add(emptyInBooleanQuery);
		queries.add(empCodeBooleanQuery);
		queries.add(monthRangeQuery);

		try {
			final List<Document> documents = TimeTrackingLocalServiceUtil
					.search(searchContext, queries, TTUtils.getCompanyId(),
							new Sort(TimeTrackingField.ID, false),
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			return getTimeTrackingIndexItems(documents);
		} catch (ParseException e) {
			LogFactoryUtil.getLog(TTUtils.class).info(e);
		} catch (SearchException e) {
			LogFactoryUtil.getLog(TTUtils.class).info(e);
		}
		return new ArrayList<>();
	}

	/**
	 * @param filterKey
	 * @param filterValue
	 * @param filters
	 */
	public static void checkAndAddFilterValue(String filterKey,
			Object filterValue, Map<String, Object> filters) {

		if (filterValue instanceof String) {
			if (StringUtils.trimToNull((String) filterValue) != null)
				filters.put(filterKey, filterValue);
		} else if (filterValue != null) {
			filters.put(filterKey, filterValue);
		}
	}

	/**
	 * @param unformattedEmpCode
	 *            01234 will be replaced -> 91234
	 * @return
	 */
	public static String getActualEmpCode(String unformattedEmpCode) {
		if (StringUtils.trimToNull(unformattedEmpCode) == null) {
			return StringUtils.EMPTY;
		}
		String actualEmpCode = null;
		if (unformattedEmpCode.length() == 5) {
			actualEmpCode = "9"
					+ unformattedEmpCode.substring(1,
							unformattedEmpCode.length());
		} else if (unformattedEmpCode.length() == 4) {
			actualEmpCode = "9" + unformattedEmpCode;
		} else {
			actualEmpCode = unformattedEmpCode;
		}

		return actualEmpCode;
	}

	/**
	 * @param item
	 * @return
	 */
	public static Date determineMinIn(TimeTrackingIndexItem item) {
		final Date minIn = null;
		if (item.getIn1() != null) {
			return item.getIn1();
		}

		return minIn;
	}

	public static Date compareAndGetMinTime(int index, Date min, Date... dates) {
		if (dates == null || dates.length == 0)
			return null;

		if (index == dates.length)
			return min;

		if (dates[index] != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dates[index]);

			int checkedHour = calendar.get(Calendar.HOUR_OF_DAY);
			int checkedMin = calendar.get(Calendar.MINUTE);
			if (checkedHour < 12)
				if (min != null) {
					calendar.setTime(min);
					int minHour = calendar.get(Calendar.HOUR_OF_DAY);
					int minMin = calendar.get(Calendar.MINUTE);

					if (checkedHour < minHour) {
						min = dates[index]; // NOSONAR
					} else if (checkedHour == minHour) {
						if (checkedMin < minMin) { // NOSONAR
							min = dates[index]; // NOSONAR
						}
					}
				} else {
					min = dates[index]; // NOSONAR
				}
		}
		index += 1; // NOSONAR

		return compareAndGetMinTime(index, min, dates);
	}

	public static Date compareAndGetMaxTime(int index, Date max, Date[] outArr,
			Date[] inArr) {
		if (outArr == null || outArr.length == 0 || isAllNullArray(outArr)) {
			return getOver13PM(inArr);
		}

		if (index == outArr.length)
			return max;

		if (outArr[index] != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(outArr[index]);

			int checkedHour = calendar.get(Calendar.HOUR_OF_DAY);
			int checkedMin = calendar.get(Calendar.MINUTE);
			if (checkedHour >= 12)
				if (max != null) {
					calendar.setTime(max);
					int maxHour = calendar.get(Calendar.HOUR_OF_DAY);
					int maxMin = calendar.get(Calendar.MINUTE);

					if (checkedHour > maxHour) {
						max = outArr[index]; // NOSONAR
					} else if (checkedHour == maxHour) {
						if (checkedMin > maxMin) { // NOSONAR
							max = outArr[index]; // NOSONAR
						}
					}
				} else {
					max = outArr[index]; // NOSONAR
				}
		}
		index += 1; // NOSONAR

		return compareAndGetMaxTime(index, max, outArr, inArr);
	}

	private static Date getOver13PM(Date[] dates) {
		if (dates == null || dates.length == 0)
			return null;
		Calendar calendar = Calendar.getInstance();
		for (int i = 0; i < dates.length; i++) {
			if (dates[i] != null) {
				calendar.setTime(dates[i]);
				int checkedHour = calendar.get(Calendar.HOUR_OF_DAY);
				if (checkedHour >= 13) {
					return dates[i];
				}
			}
		}
		return null;
	}

	public static boolean isAllNullArray(Object[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null)
				return false;
		}
		return true;
	}

	public static String getViFullnameFromUser(User user) {
		return StringUtils.trimToEmpty(user.getLastName()) + " "
				+ StringUtils.trimToEmpty(user.getMiddleName()) + " "
				+ StringUtils.trimToEmpty(user.getFirstName());
	}
}
