package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.ResignationHistoryField;
import vn.com.ecopharma.emp.dto.ResignationHistoryIndexedItem;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class ResignationHistoryIndexLazyDataModel extends
		AbstractEmpBaseLazyDataModel<ResignationHistoryIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(ResignationHistoryIndexLazyDataModel.class);

	@Override
	public ResignationHistoryIndexedItem getRowData(String rowKey) {
		return new ResignationHistoryIndexedItem(
				ResignationHistoryLocalServiceUtil.getIndexedDocument(rowKey,
						EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public List<ResignationHistoryIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		final List<ResignationHistoryIndexedItem> results = new ArrayList<>();
		final List<Query> queries = new ArrayList<>();
		try {
			super.bindOrganizationFilterFields(filters, queries);
			final SearchContext searchContext = EmployeeUtils
					.getCurrentSearchContext();

			final Sort sort = new Sort(ResignationHistoryField.ID, false);
			final List<Document> documents = ResignationHistoryLocalServiceUtil
					.searchAllUnDeletedDocuments(searchContext, queries,
							searchContext.getCompanyId(), sort, first, first
									+ pageSize);
			for (Document document : documents) {
				results.add(new ResignationHistoryIndexedItem(document));
			}
			setPageSize(pageSize);
			setRowCount(ResignationHistoryLocalServiceUtil
					.countAllUnDeletedDocuments(searchContext, queries,
							searchContext.getCompanyId(), sort));

			return results;
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}
}
