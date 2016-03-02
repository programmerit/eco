package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.PromotionFilterBean;
import vn.com.ecopharma.emp.constant.PromotedHistoryField;
import vn.com.ecopharma.emp.dto.PromotedHistoryIndexedItem;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;

public class PromotionHistoryIndexLazyDataModel
		extends
		AbstractEmpBaseLazyDataModel<PromotedHistoryIndexedItem, PromotionFilterBean> {

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
	public List<PromotedHistoryIndexedItem> load(int first, int pageSize,
			String sortField, SortOrder sortOrder, Map<String, Object> filters) {

		super.bindOrganizationFilterFields(filters,
				BeanUtils.getPromotionFilterBean());
		final List<PromotedHistoryIndexedItem> results = new ArrayList<>();
		try {
			final SearchContext searchContext = EmployeeUtils
					.getCurrentSearchContext();

			final Sort sort = new Sort(PromotedHistoryField.ID, false);
			final List<Document> documents = PromotedHistoryLocalServiceUtil
					.filterByFields(searchContext, filters, sort,
							searchContext.getCompanyId(), first, first
									+ pageSize);
			for (Document document : documents) {
				results.add(new PromotedHistoryIndexedItem(document));
			}
			setPageSize(pageSize);
			setRowCount(PromotedHistoryLocalServiceUtil.countFilterByFields(
					searchContext, filters, sort, searchContext.getCompanyId()));

			return results;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
