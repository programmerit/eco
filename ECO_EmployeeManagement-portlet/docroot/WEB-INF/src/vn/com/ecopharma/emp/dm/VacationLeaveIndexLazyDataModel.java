package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.VacationLeaveField;
import vn.com.ecopharma.emp.dto.VacationLeaveIndexedItem;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class VacationLeaveIndexLazyDataModel extends
		AbstractEmpBaseLazyDataModel<VacationLeaveIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(VacationLeaveIndexLazyDataModel.class);

	@Override
	public List<VacationLeaveIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		final List<VacationLeaveIndexedItem> results = new ArrayList<>();
		final List<Query> queries = new ArrayList<>();
		try {
			super.bindOrganizationFilterFields(filters, queries);
			final SearchContext searchContext = getSearchContext();

			final Sort sort = new Sort(VacationLeaveField.ID, false);
			final List<Document> documents = VacationLeaveLocalServiceUtil
					.searchAllUnDeletedDocuments(searchContext, queries,
							searchContext.getCompanyId(), sort, first, first
									+ pageSize);
			for (Document document : documents) {
				results.add(new VacationLeaveIndexedItem(document));
			}
			setPageSize(pageSize);
			setRowCount(VacationLeaveLocalServiceUtil
					.countAllUnDeletedDocuments(searchContext, queries,
							searchContext.getCompanyId(), sort));

			return results;
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public VacationLeaveIndexedItem getRowData(String rowKey) {
		return new VacationLeaveIndexedItem(
				VacationLeaveLocalServiceUtil.getIndexedDocument(
						Long.valueOf(rowKey), getSearchContext()));
	}

}
