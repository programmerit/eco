package vn.com.ecopharma.hrm.rc.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class CandidateLazyDataModel extends
		AbstractIndexedLazyDataModel<CandidateIndexItem> {

	private static final long serialVersionUID = 1L;

	@Override
	public CandidateIndexItem getRowData(String rowKey) {
		return new CandidateIndexItem(
				CandidateLocalServiceUtil.getIndexCandidateDocument(rowKey,
						getSearchContext()));
	}

	@Override
	public List<CandidateIndexItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		SearchContext searchContext = getSearchContext();
		long companyId = getCompanyId();

		/* SORT */
		final Sort sort = sortField != null ? new Sort(sortField,
				sortOrder.equals(SortOrder.ASCENDING) ? true : false) : null;
		try {
			final List<Document> docs = CandidateLocalServiceUtil
					.filterByFields(searchContext, filters, sort, companyId,
							first, first + pageSize);

			final List<CandidateIndexItem> candidates = ECO_RCUtils
					.getCandidateIndexItems(docs);

			for (CandidateIndexItem item : candidates) {
				if (item.getFullName().equalsIgnoreCase("Tran Van Tran Tran"))
					System.out.println(item.getStatus());
			}

			final int totalRowCount = CandidateLocalServiceUtil
					.countFilterByFields(searchContext, filters, sort,
							companyId);

			setPageSize(pageSize);
			setRowCount(totalRowCount);

			return candidates;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
