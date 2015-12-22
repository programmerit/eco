package vn.com.ecopharma.hrm.rc.dm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.rc.constant.InterviewScheduleField;
import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.dto.InterviewScheduleIndexedItem;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;

public class InterviewScheduleLazyDM extends
		LazyDataModel<InterviewScheduleIndexedItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public Object getRowKey(InterviewScheduleIndexedItem object) {
		return object.getId();
	}

	@Override
	public List<InterviewScheduleIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		/* FILTERS */
		final List<Query> queries = new ArrayList<Query>();
		final SearchContext searchContext = getSearchContext();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			final BooleanQuery globalFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery candidateNameFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery vacancyNameFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			final BooleanQuery statusFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			final BooleanQuery interviewerFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			final String[] effectFilterFields = new String[] {
					InterviewScheduleField.CANDIDATE,
					InterviewScheduleField.VACANCY,
					InterviewScheduleField.INTERVIEW_DATE,
					InterviewScheduleField.STATUS,
					InterviewScheduleField.INTERVIEWERS };

			for (Map.Entry<String, Object> entry : filters.entrySet()) {
				System.out.println("FILTER BY: " + entry.getKey());
				if (entry.getValue() instanceof String) {
					System.out.println("FILTER VALUE: "
							+ (String) entry.getValue());
				} else if (entry.getValue() instanceof Date) {
					System.out.println("FILTER VALUE: "
							+ sdf.format((Date) entry.getValue()));
				}
			}

			if (filters.get(InterviewScheduleField.GLOBAL) != null) {
				globalFilterQuery.addTerms(effectFilterFields,
						(String) filters.get(InterviewScheduleField.GLOBAL),
						true);
				queries.add(globalFilterQuery);

			}

			if (filters.get(InterviewScheduleField.CANDIDATE) != null) {
				candidateNameFilterQuery.addTerm(
						InterviewScheduleField.CANDIDATE,
						(String) filters.get(InterviewScheduleField.CANDIDATE),
						true);
				queries.add(candidateNameFilterQuery);

			}

			if (filters.get(InterviewScheduleField.VACANCY) != null) {
				vacancyNameFilterQuery.addTerm(InterviewScheduleField.VACANCY,
						(String) filters.get(InterviewScheduleField.VACANCY),
						true);
				queries.add(vacancyNameFilterQuery);

			}

			if (filters.get(InterviewScheduleField.STATUS) != null) {
				statusFilterQuery.addExactTerm(InterviewScheduleField.STATUS,
						(String) filters.get(InterviewScheduleField.STATUS));
				queries.add(statusFilterQuery);
			}

			if (filters.get(InterviewScheduleField.INTERVIEWERS) != null) {
				@SuppressWarnings("unchecked")
				final List<EmpIndexedItem> employeeIndexedItems = (List<EmpIndexedItem>) filters
						.get(InterviewScheduleField.INTERVIEWERS);
				for (EmpIndexedItem item : employeeIndexedItems) {
					interviewerFilterQuery.addTerm(
							InterviewScheduleField.INTERVIEWERS,
							item.getFullName());
				}
				queries.add(interviewerFilterQuery);

			}

			String applyDateFrom = StringUtils.EMPTY;
			String applyDateTo = StringUtils.EMPTY;
			boolean isFilteredByInterviewDate = Boolean.FALSE;

			if (filters.get(InterviewScheduleField.INTERVIEW_DATE_FROM) != null
					&& filters.get(InterviewScheduleField.INTERVIEW_DATE_TO) != null) {
				applyDateFrom = sdf1.format(filters
						.get(InterviewScheduleField.INTERVIEW_DATE_FROM));
				applyDateTo = sdf1.format(filters
						.get(InterviewScheduleField.INTERVIEW_DATE_TO));
				isFilteredByInterviewDate = true;
			} else if (filters.get(InterviewScheduleField.INTERVIEW_DATE_FROM) != null
					&& filters.get(InterviewScheduleField.INTERVIEW_DATE_TO) == null) {
				applyDateFrom = sdf.format(filters
						.get(InterviewScheduleField.INTERVIEW_DATE_FROM));
				applyDateTo = sdf.format(new Date(System.currentTimeMillis()));
				isFilteredByInterviewDate = true;
			} else if (filters.get(InterviewScheduleField.INTERVIEW_DATE_TO) != null
					&& filters.get(InterviewScheduleField.INTERVIEW_DATE_FROM) == null) {
				applyDateFrom = "19700101000000";
				applyDateTo = sdf.format(filters
						.get(InterviewScheduleField.INTERVIEW_DATE_TO));
				isFilteredByInterviewDate = true;
			}

			if (isFilteredByInterviewDate) {
				final TermRangeQuery interviewDateTermRangeQuery = TermRangeQueryFactoryUtil
						.create(searchContext,
								InterviewScheduleField.INTERVIEW_DATE,
								applyDateFrom, applyDateTo, true, true);
				queries.add(interviewDateTermRangeQuery);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		final Sort sort = sortField != null ? new Sort(sortField,
				sortOrder.equals(SortOrder.ASCENDING) ? false : true) : null;

		final List<Document> docs = InterviewScheduleLocalServiceUtil
				.searchAllIndexedDocuments(getSearchContext(), queries,
						getSearchContext().getCompanyId(), sort, first, first
								+ pageSize);
		final List<InterviewScheduleIndexedItem> results = new ArrayList<InterviewScheduleIndexedItem>(
				docs.size());
		for (Document doc : docs) {
			results.add(new InterviewScheduleIndexedItem(doc));
		}

		setPageSize(pageSize);
		setRowCount(InterviewScheduleLocalServiceUtil.countAllIndexedDocuments(
				getSearchContext(), queries, getSearchContext().getCompanyId(),
				null));

		return results;
	}

	@Override
	public InterviewScheduleIndexedItem getRowData(String rowKey) {
		return new InterviewScheduleIndexedItem(
				InterviewScheduleLocalServiceUtil.getIndexDocument(
						Long.valueOf(rowKey), getSearchContext()));
	}

	private SearchContext getSearchContext() {
		return RCUtils.getCurrentSearchContext();
	}

}
