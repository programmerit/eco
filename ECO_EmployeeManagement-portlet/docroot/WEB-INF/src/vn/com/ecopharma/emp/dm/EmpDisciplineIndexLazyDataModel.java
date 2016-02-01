package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.EmpDisciplineField;
import vn.com.ecopharma.emp.dto.EmpDisciplineIndexedItem;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class EmpDisciplineIndexLazyDataModel extends
		AbstractEmpBaseLazyDataModel<EmpDisciplineIndexedItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpDisciplineIndexLazyDataModel.class);

	@Override
	public List<EmpDisciplineIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		final List<EmpDisciplineIndexedItem> results = new ArrayList<>();
		final List<Query> queries = new ArrayList<>();
		try {
			super.bindOrganizationFilterFields(filters, queries);

			final SearchContext searchContext = EmployeeUtils
					.getCurrentSearchContext();

			final Sort sort = new Sort(EmpDisciplineField.ID, false);
			final List<Document> documents = EmpDisciplineLocalServiceUtil
					.searchAllDocuments(searchContext, queries,
							searchContext.getCompanyId(), sort,
							QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Document document : documents) {
				results.add(new EmpDisciplineIndexedItem(document));
			}
			setPageSize(pageSize);
			setRowCount(EmpDisciplineLocalServiceUtil.countAllDocuments(
					searchContext, queries, searchContext.getCompanyId(), sort));

			return results;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public EmpDisciplineIndexedItem getRowData(String rowKey) {
		return new EmpDisciplineIndexedItem(
				EmpDisciplineLocalServiceUtil.getIndexedDocument(rowKey,
						EmployeeUtils.getCurrentSearchContext()));
	}
}
