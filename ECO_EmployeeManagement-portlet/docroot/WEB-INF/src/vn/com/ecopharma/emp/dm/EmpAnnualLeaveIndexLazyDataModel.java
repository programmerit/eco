package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.EmpAnnualLeaveFilterBean;
import vn.com.ecopharma.emp.constant.EmpAnnualLeaveField;
import vn.com.ecopharma.emp.dto.EmpAnnualLeaveIndexedItem;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Sort;

public class EmpAnnualLeaveIndexLazyDataModel
		extends
		AbstractEmpBaseLazyDataModel<EmpAnnualLeaveIndexedItem, EmpAnnualLeaveFilterBean> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpAnnualLeaveIndexLazyDataModel.class);

	@Override
	public List<EmpAnnualLeaveIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {
		final List<EmpAnnualLeaveIndexedItem> results = new ArrayList<>();
		try {
			super.bindOrganizationFilterFields(filters,
					BeanUtils.getAnnualLeaveFilterBean());

			final Sort sort = new Sort(EmpAnnualLeaveField.ID, false);
			final List<Document> documents = EmpAnnualLeaveLocalServiceUtil
					.filterByFields(searchContext, filters, sort,
							searchContext.getCompanyId(), first, first
									+ pageSize);

			for (Document document : documents) {
				results.add(new EmpAnnualLeaveIndexedItem(document));
			}
			setPageSize(pageSize);
			setRowCount(EmpAnnualLeaveLocalServiceUtil.countFilterByFields(
					searchContext, filters, sort, searchContext.getCompanyId()));

			return results;
		} catch (ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public EmpAnnualLeaveIndexedItem getRowData(String rowKey) {
		return new EmpAnnualLeaveIndexedItem(
				EmpAnnualLeaveLocalServiceUtil.getIndexedDocument(rowKey,
						searchContext));
	}
}
