package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.PromotedHistoryField;
import vn.com.ecopharma.emp.dto.PromotedHistoryIndexedItem;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class PromotionHistoryIndexLazyDataModel extends
		LazyDataModel<PromotedHistoryIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public PromotedHistoryIndexedItem getRowData(String rowKey) {
		return new PromotedHistoryIndexedItem(
				PromotedHistoryLocalServiceUtil.getIndexedDocument(rowKey,
						EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(PromotedHistoryIndexedItem object) {
		return object.getPromotedHistoryId();
	}

	@Override
	public List<PromotedHistoryIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		final List<PromotedHistoryIndexedItem> results = new ArrayList<PromotedHistoryIndexedItem>();
		final SearchContext searchContext = EmployeeUtils
				.getCurrentSearchContext();

		final Sort sort = new Sort(PromotedHistoryField.ID, false);
		final List<Document> documents = PromotedHistoryLocalServiceUtil
				.searchAllUnDeletedDocuments(searchContext,
						new ArrayList<Query>(), searchContext.getCompanyId(),
						sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Document document : documents) {
			results.add(new PromotedHistoryIndexedItem(document));
		}
		setPageSize(pageSize);
		setRowCount(PromotedHistoryLocalServiceUtil.countAllUnDeletedDocuments(
				searchContext, new ArrayList<Query>(),
				searchContext.getCompanyId(), sort));

		return results;
	}
}
