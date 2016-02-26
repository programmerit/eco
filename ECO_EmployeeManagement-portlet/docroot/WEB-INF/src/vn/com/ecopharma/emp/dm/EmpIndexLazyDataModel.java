package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

/**
 * @author TaoTran
 *
 */
public class EmpIndexLazyDataModel extends LazyDataModel<EmpIndexedItem> {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpIndexLazyDataModel.class);

	private List<Query> queries;

	@Override
	public EmpIndexedItem getRowData(String rowKey) {
		return new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(rowKey,
				EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(EmpIndexedItem object) {
		return object.getId();
	}

	@Override
	public List<EmpIndexedItem> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {

		final SearchContext searchContext = EmployeeUtils
				.getCurrentSearchContext();
		try {
			long companyId = EmployeeUtils.getCompanyId();
			final Sort sort = sortField != null ? new Sort(sortField,
					sortOrder.equals(SortOrder.ASCENDING) ? true : false)
					: null;
			List<Document> docs = EmpLocalServiceUtil.filterEmployeeByFields(
					searchContext, filters, sort, companyId, first, first
							+ pageSize);
			final List<EmpIndexedItem> emps = EmployeeUtils
					.getEmployeeIndexedItemsFromIndexedDocuments(docs);

			int totalRowCount = EmpLocalServiceUtil
					.countFilterEmployeeByFields(searchContext, filters, sort,
							companyId);

			setPageSize(pageSize);
			setRowCount(totalRowCount);
			return emps;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();

	}

	public List<Query> getQueries() {
		return queries;
	}

}
