package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.EmployeeFilterView;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Sort;

/**
 * @author TaoTran
 *
 */
public class EmpIndexLazyDataModel extends
		AbstractEmpBaseLazyDataModel<EmpIndexedItem, EmployeeFilterView> {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpIndexLazyDataModel.class);

	@Override
	public EmpIndexedItem getRowData(String rowKey) {
		return new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(rowKey,
				searchContext));
	}

	@Override
	public List<EmpIndexedItem> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {

		super.bindOrganizationFilterFields(filters,
				BeanUtils.getEmpFilterBean());

		long companyId = EmployeeUtils.getCompanyId();
		final Sort sort = sortField != null ? new Sort(sortField,
				sortOrder.equals(SortOrder.ASCENDING) ? true : false) : null;
		try {
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
}
