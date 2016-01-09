package vn.com.ecopharma.emp.dm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;

/**
 * @author TaoTran
 *
 */
public class EmployeeIndexLazyDataModel extends LazyDataModel<EmpIndexedItem> {

	private static final long serialVersionUID = 1L;
	private static final String GLOBAL_FILTER = "globalString";
	private static final String JOINED_DATE_FROM = "joined_dateFrom";
	private static final String JOINED_DATE_TO = "joined_dateTo";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmployeeIndexLazyDataModel.class);

	private List<Query> queries;

	@Override
	public EmpIndexedItem getRowData(String rowKey) {
		return new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(rowKey,
				EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(EmpIndexedItem object) {
		return Long.valueOf(object.getEmployeeDocument()
				.getField(EmpField.EMP_ID).getValue());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpIndexedItem> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		String globalFilter = StringUtils.EMPTY;
		String fullName = StringUtils.EMPTY;
		String empCode = StringUtils.EMPTY;
		String joinedDateFrom = StringUtils.EMPTY;
		String joinedDateTo = StringUtils.EMPTY;
		String titles = StringUtils.EMPTY;
		String unitGroup = StringUtils.EMPTY;
		String devision = StringUtils.EMPTY;
		String department = StringUtils.EMPTY;
		String unit = StringUtils.EMPTY;
		final List<String> genders = new ArrayList<>();
		if (filters != null) {
			globalFilter = filters.get(GLOBAL_FILTER) != null ? (String) filters
					.get(GLOBAL_FILTER) : StringUtils.EMPTY;

			fullName = filters.get(EmpField.VN_FULL_NAME) != null ? (String) filters
					.get(EmpField.VN_FULL_NAME) : StringUtils.EMPTY;

			empCode = filters.get(EmpField.EMP_CODE) != null ? (String) filters
					.get(EmpField.EMP_CODE) : StringUtils.EMPTY;

			joinedDateFrom = filters.get(JOINED_DATE_FROM) != null ? (String) filters
					.get(JOINED_DATE_FROM) : StringUtils.EMPTY;

			joinedDateTo = filters.get(JOINED_DATE_TO) != null ? (String) filters
					.get(JOINED_DATE_TO) : StringUtils.EMPTY;

			devision = filters.get(EmpField.DEVISION) != null ? (String) filters
					.get(EmpField.DEVISION) : StringUtils.EMPTY;

			department = filters.get(EmpField.DEPARTMENT) != null ? (String) filters
					.get(EmpField.DEPARTMENT) : StringUtils.EMPTY;

			unit = filters.get(EmpField.UNIT) != null ? (String) filters
					.get(EmpField.UNIT) : StringUtils.EMPTY;

			unitGroup = filters.get(EmpField.UNIT_GROUP) != null ? (String) filters
					.get(EmpField.UNIT_GROUP) : StringUtils.EMPTY;

			titles = filters.get(EmpField.TITLES) != null ? (String) filters
					.get(EmpField.TITLES) : StringUtils.EMPTY;

			boolean isGenderFiltered = false;
			for (Iterator<String> it = filters.keySet().iterator(); it
					.hasNext();) {
				final String filterProperty = it.next();
				final Object filterValue = filters.get(filterProperty);
				LOGGER.info("Filter Property: " + filterProperty);

				if (filterValue instanceof String) {
					LOGGER.info("Filter Property Value: " + filterValue);
				} else if (filterValue instanceof List<?>
						&& filterProperty.equalsIgnoreCase(EmpField.GENDER)) {
					isGenderFiltered = true;
				}
			}

			if (isGenderFiltered) {
				genders.addAll((List<String>) filters.get(EmpField.GENDER));
			}
		}
		final List<String> allEmpFields = EmpField.getAllFields();
		allEmpFields.remove(EmpField.EMP_ID);
		allEmpFields.remove(EmpField.EMPLOYEE_USER_ID);
		allEmpFields.remove(EmpField.IS_DELETED);
		allEmpFields.remove(EmpField.TITLES_ID);
		allEmpFields.remove(EmpField.UNIVERSITY_ID);
		allEmpFields.remove(EmpField.LEVEL_ID);
		allEmpFields.remove(EmpField.DEVISION_ID);
		allEmpFields.remove(EmpField.TOTAL_SALARY);
		allEmpFields.remove(EmpField.BONUS);
		allEmpFields.remove(EmpField.POSITION_WAGE_RATES);
		allEmpFields.remove(EmpField.BASE_WAGE_RATES);

		final SearchContext searchContext = EmployeeUtils
				.getCurrentSearchContext();
		searchContext.setPortletIds(new String[] { EMInfo.PORTLET_ID });
		String[] fields = allEmpFields.toArray(new String[allEmpFields.size()]);

		queries = new ArrayList<>();

		final BooleanQuery globalFilterBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		final BooleanQuery empCodeFilterBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		final BooleanQuery fullNameFilterBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		final BooleanQuery genderFilterBooleanQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		Sort searchSort = null;
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
			final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
			final String defaultDateFromString = "19700101000000";
			final String currentDateString = sdf.format(new Date(System
					.currentTimeMillis()));// example: 19700101000000
			int nextYear = Integer.valueOf(currentDateString.substring(0, 4)) + 1;
			final String nextYearString = nextYear
					+ currentDateString
							.substring(4, currentDateString.length());

			final String defaultDateToString = nextYearString;

			final String filterJoinedDateFrom = joinedDateFrom != null
					&& joinedDateFrom != StringUtils.EMPTY ? sdf.format(sdf1
					.parse(joinedDateFrom)) : defaultDateFromString;

			final String filterJoinedDateTo = joinedDateTo != null
					&& joinedDateTo != StringUtils.EMPTY ? sdf.format(sdf1
					.parse(joinedDateTo)) : defaultDateToString;

			final boolean isDefaultJDSearch = filterJoinedDateFrom
					.equals(defaultDateFromString)
					&& filterJoinedDateTo.equals(defaultDateToString);

			final TermRangeQuery joinedDateTermRangeQuery = TermRangeQueryFactoryUtil
					.create(searchContext, EmpField.JOINED_DATE,
							filterJoinedDateFrom, filterJoinedDateTo, true,
							true);

			// not include null joined date
			if (!isDefaultJDSearch) {
				queries.add(joinedDateTermRangeQuery);
			}

			if (StringUtils.trimToNull(globalFilter) != null) {
				globalFilterBooleanQuery.addTerms(fields, globalFilter, true);
				queries.add(globalFilterBooleanQuery);
			}

			if (StringUtils.trimToNull(empCode) != null) {
				empCodeFilterBooleanQuery.addTerm(EmpField.EMP_CODE, empCode,
						true, BooleanClauseOccur.MUST);
				queries.add(empCodeFilterBooleanQuery);
			}

			if (StringUtils.trimToNull(fullName) != null) {
				fullNameFilterBooleanQuery.addTerm(EmpField.VN_FULL_NAME,
						fullName, true, BooleanClauseOccur.MUST);
				queries.add(fullNameFilterBooleanQuery);
			}

			if (StringUtils.trimToNull(devision) != null) {
				TermQuery devisionTermQuery = TermQueryFactoryUtil.create(
						searchContext, EmpField.DEVISION,
						StringUtils.trimToEmpty(devision));
				queries.add(devisionTermQuery);
			}

			if (StringUtils.trimToNull(department) != null) {
				TermQuery departmentTermQuery = TermQueryFactoryUtil.create(
						searchContext, EmpField.DEPARTMENT,
						StringUtils.trimToEmpty(department));
				queries.add(departmentTermQuery);
			}

			if (StringUtils.trimToNull(unit) != null) {
				TermQuery unitTermQuery = TermQueryFactoryUtil.create(
						searchContext, EmpField.UNIT,
						StringUtils.trimToEmpty(unit));
				queries.add(unitTermQuery);
			}

			if (StringUtils.trimToNull(unitGroup) != null) {
				TermQuery unitGroupTermQuery = TermQueryFactoryUtil.create(
						searchContext, EmpField.UNIT_GROUP,
						StringUtils.trimToEmpty(unitGroup));
				queries.add(unitGroupTermQuery);
			}

			if (StringUtils.trimToNull(titles) != null) {
				TermQuery titlesTermQuery = TermQueryFactoryUtil.create(
						searchContext, EmpField.TITLES,
						StringUtils.trimToEmpty(titles));
				queries.add(titlesTermQuery);
			}

			if (!genders.isEmpty()) {
				for (String gender : genders) {
					genderFilterBooleanQuery.addExactTerm(EmpField.GENDER,
							gender);
				}
				queries.add(genderFilterBooleanQuery);
			}

			/* SORT */
			if (sortField != null) {
				searchSort = new Sort(sortField,
						sortOrder.equals(SortOrder.ASCENDING) ? false : true);
			} else {
				searchSort = new Sort(EmpField.EMP_ID, false);
			}

		} catch (ParseException e) {
			LogFactoryUtil.getLog(EmployeeIndexLazyDataModel.class).info(e);
		} catch (java.text.ParseException e) {
			LogFactoryUtil.getLog(EmployeeIndexLazyDataModel.class).info(e);
		}
		final List<Document> docs = EmpLocalServiceUtil
				.searchAllUnDeletedEmpIndexedDocument(searchContext, queries,
						searchContext.getCompanyId(), searchSort, first, first
								+ pageSize);

		final List<EmpIndexedItem> emps = EmployeeUtils
				.getEmployeeIndexedItemsFromIndexedDocuments(docs);

		int totalRowCount = EmpLocalServiceUtil
				.countAllUnDeletedIndexedEmpDocuments(searchContext, queries,
						searchContext.getCompanyId(), searchSort);

		setPageSize(pageSize);
		setRowCount(totalRowCount);
		return emps;
	}

	public List<Query> getQueries() {
		return queries;
	}

}
