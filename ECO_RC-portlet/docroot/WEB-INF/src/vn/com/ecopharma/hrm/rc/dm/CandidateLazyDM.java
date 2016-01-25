package vn.com.ecopharma.hrm.rc.dm;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.TermRangeQuery;
import com.liferay.portal.kernel.search.TermRangeQueryFactoryUtil;

public class CandidateLazyDM extends LazyDataModel<CandidateIndexItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public CandidateIndexItem getRowData(String rowKey) {
		return new CandidateIndexItem(
				CandidateLocalServiceUtil.getIndexCandidateDocument(rowKey,
						getSearchContext()));
	}

	@Override
	public Object getRowKey(CandidateIndexItem object) {
		return object.getCandidateId();
	}

	@Override
	public List<CandidateIndexItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		/* FILTERS */
		final List<Query> queries = new ArrayList<>();
		final SearchContext searchContext = getSearchContext();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		final SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			final BooleanQuery globalFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery nameFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery emailFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery contactNumberFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);
			final BooleanQuery vacancyFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			final BooleanQuery statusFilterQuery = BooleanQueryFactoryUtil
					.create(searchContext);

			final String[] effectFilterFields = new String[] {
					CandidateField.FULLNAME, CandidateField.STATUS,
					CandidateField.EMAIL, CandidateField.CONTACT_NUMBER,
					CandidateField.VACANCY, CandidateField.APPLICATION_DATE };

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

			if (filters.get(CandidateField.GLOBAL) != null) {
				globalFilterQuery.addTerms(effectFilterFields,
						(String) filters.get(CandidateField.GLOBAL), true);
				queries.add(globalFilterQuery);

			}

			if (filters.get(CandidateField.FULLNAME) != null) {
				nameFilterQuery.addTerm(CandidateField.FULLNAME,
						(String) filters.get(CandidateField.FULLNAME), true);
				queries.add(nameFilterQuery);

			}

			if (filters.get(CandidateField.EMAIL) != null) {
				emailFilterQuery.addTerm(CandidateField.EMAIL,
						(String) filters.get(CandidateField.EMAIL), true);
				queries.add(emailFilterQuery);

			}

			if (filters.get(CandidateField.CONTACT_NUMBER) != null) {
				contactNumberFilterQuery.addTerm(CandidateField.CONTACT_NUMBER,
						(String) filters.get(CandidateField.CONTACT_NUMBER),
						true);
				queries.add(contactNumberFilterQuery);

			}

			if (filters.get(CandidateField.VACANCY) != null) {
				@SuppressWarnings("unchecked")
				List<VacancyIndexItem> items = (List<VacancyIndexItem>) filters
						.get(CandidateField.VACANCY);
				for (VacancyIndexItem item : items) {
					vacancyFilterQuery.addExactTerm(CandidateField.VACANCY,
							item.getTitles());
				}
				queries.add(vacancyFilterQuery);

			}

			if (filters.get(CandidateField.STATUS) != null) {
				statusFilterQuery.addExactTerm(CandidateField.STATUS,
						(String) filters.get(CandidateField.STATUS));
				queries.add(statusFilterQuery);
			}

			String applyDateFrom = StringUtils.EMPTY;
			String applyDateTo = StringUtils.EMPTY;
			boolean isFilteredByApplyDate = Boolean.FALSE;

			if (filters.get(CandidateField.APPLY_DATE_FROM) != null
					&& filters.get(CandidateField.APPLY_DATE_TO) != null) {
				applyDateFrom = sdf1.format(filters
						.get(CandidateField.APPLY_DATE_FROM));
				applyDateTo = sdf1.format(filters
						.get(CandidateField.APPLY_DATE_TO));
				isFilteredByApplyDate = true;
			} else if (filters.get(CandidateField.APPLY_DATE_FROM) != null
					&& filters.get(CandidateField.APPLY_DATE_TO) == null) {
				applyDateFrom = sdf.format(filters
						.get(CandidateField.APPLY_DATE_FROM));
				applyDateTo = sdf.format(new Date(System.currentTimeMillis()));
				isFilteredByApplyDate = true;
			} else if (filters.get(CandidateField.APPLY_DATE_TO) != null
					&& filters.get(CandidateField.APPLY_DATE_FROM) == null) {
				applyDateFrom = "19700101000000";
				applyDateTo = sdf.format(filters
						.get(CandidateField.APPLY_DATE_TO));
				isFilteredByApplyDate = true;
			}

			if (isFilteredByApplyDate) {
				final TermRangeQuery applyDateTermRangeQuery = TermRangeQueryFactoryUtil
						.create(searchContext, CandidateField.APPLICATION_DATE,
								applyDateFrom, applyDateTo, true, true);
				queries.add(applyDateTermRangeQuery);
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
			searchSort = new Sort(CandidateField.CANDIDATE_ID, false);
		}
		setPageSize(pageSize);
		setRowCount(CandidateLocalServiceUtil
				.countAllUnDeletedIndexedCandidateDocuments(getSearchContext(),
						queries, searchContext.getCompanyId(), searchSort));

		return ECO_RCUtils.getCandidateIndexItems(CandidateLocalServiceUtil
				.searchAllUnDeletedCandidatesIndexedDocument(searchContext,
						queries, searchContext.getCompanyId(), searchSort,
						first, first + pageSize));
	}

	private SearchContext getSearchContext() {
		return ECO_RCUtils.getCurrentSearchContext();
	}
}
