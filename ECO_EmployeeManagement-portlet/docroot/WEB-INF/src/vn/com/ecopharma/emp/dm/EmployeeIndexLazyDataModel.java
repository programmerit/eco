package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;

/**
 * @author TaoTran
 *
 */
public class EmployeeIndexLazyDataModel extends LazyDataModel<EmpIndexedItem> {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmployeeIndexLazyDataModel.class);

	private List<Query> queries;

	@Override
	public EmpIndexedItem getRowData(String rowKey) {
		return new EmpIndexedItem(EmpLocalServiceUtil.getIndexedEmp(rowKey,
				EmployeeUtils.getCurrentSearchContext()));
	}

	@Override
	public Object getRowKey(EmpIndexedItem object) {
		return Long.valueOf(object.getEmployeeDocument()
				.getField(EmpField.EMP_ID).getValue());
	}

	@Override
	public List<EmpIndexedItem> load(int first, int pageSize, String sortField,
			SortOrder sortOrder, Map<String, Object> filters) {
		final List<String> allEmpFields = EmpField.getAllFields();
		allEmpFields.remove(EmpField.EMP_ID);
		allEmpFields.remove(EmpField.EMPLOYEE_USER_ID);
		allEmpFields.remove(EmpField.IS_DELETED);
		allEmpFields.remove(EmpField.TITLES_ID);
		allEmpFields.remove(EmpField.UNIVERSITY_ID);
		allEmpFields.remove(EmpField.LEVEL_ID);
		allEmpFields.remove(EmpField.DEVISION_ID);
		allEmpFields.remove(EmpField.TOTAL_SALARY);
		allEmpFields.remove(EmpField.BONUS);
		allEmpFields.remove(EmpField.POSITION_WAGE_RATES);
		allEmpFields.remove(EmpField.BASE_WAGE_RATES);

		final SearchContext searchContext = EmployeeUtils
				.getCurrentSearchContext();
		searchContext.setPortletIds(new String[] { EMInfo.PORTLET_ID });
		String[] globalSearchableFields = allEmpFields.toArray(new String[allEmpFields.size()]);

		try {
			long companyId = EmployeeUtils.getCompanyId();

			List<Document> docs = EmpLocalServiceUtil.filterEmployeeByFields(
					searchContext, filters, sortField, sortOrder, companyId,
					first, first + pageSize);
			final List<EmpIndexedItem> emps = EmployeeUtils
					.getEmployeeIndexedItemsFromIndexedDocuments(docs);

			int totalRowCount = EmpLocalServiceUtil
					.countFilterEmployeeByFields(searchContext, filters,
							sortField, sortOrder, companyId);

			setPageSize(pageSize);
			setRowCount(totalRowCount);
			return emps;
		} catch (ParseException e) {
			LOGGER.info(e);
		} catch (java.text.ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();

	}

	public List<Query> getQueries() {
		return queries;
	}

}
