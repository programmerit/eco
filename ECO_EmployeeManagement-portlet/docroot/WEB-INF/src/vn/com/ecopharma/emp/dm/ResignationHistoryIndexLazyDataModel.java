package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.ResignationHistoryField;
import vn.com.ecopharma.emp.dto.ResignationHistoryIndexedItem;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class ResignationHistoryIndexLazyDataModel extends
		LazyDataModel<ResignationHistoryIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ResignationHistoryIndexedItem getRowData(String rowKey) {
		return new ResignationHistoryIndexedItem(
				ResignationHistoryLocalServiceUtil.getIndexedDocument(rowKey,
						EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(ResignationHistoryIndexedItem object) {
		return object.getResignationHistoryId();
	}

	@Override
	public List<ResignationHistoryIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		final List<ResignationHistoryIndexedItem> results = new ArrayList<ResignationHistoryIndexedItem>();
		final SearchContext searchContext = EmployeeUtils
				.getCurrentSearchContext();

		final Sort sort = new Sort(ResignationHistoryField.ID, false);
		final List<Document> documents = ResignationHistoryLocalServiceUtil
				.searchAllUnDeletedDocuments(searchContext,
						new ArrayList<Query>(), searchContext.getCompanyId(),
						sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (Document document : documents) {
			results.add(new ResignationHistoryIndexedItem(document));
		}
		setPageSize(pageSize);
		setRowCount(ResignationHistoryLocalServiceUtil
				.countAllUnDeletedDocuments(searchContext,
						new ArrayList<Query>(), searchContext.getCompanyId(),
						sort));

		return results;
	}
}
