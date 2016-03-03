package vn.com.ecopharma.emp.dm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.EmpDisciplineFilterBean;
import vn.com.ecopharma.emp.constant.EmpDisciplineField;
import vn.com.ecopharma.emp.dto.EmpDisciplineIndexedItem;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.Sort;

public class EmpDisciplineIndexLazyDataModel
		extends
		AbstractEmpBaseLazyDataModel<EmpDisciplineIndexedItem, EmpDisciplineFilterBean> {

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
			super.bindOrganizationFilterFields(filters,
					BeanUtils.getDisciplineFilterBean());

			final Date effectiveDateFrom = (Date) filters
					.get(EmpDisciplineField.EFFECTIVE_DATE_FROM);

			final Date effectiveDateTo = (Date) filters
					.get(EmpDisciplineField.EFFECTIVE_DATE_TO);

			SearchEngineUtils.createAndAddDateTermRangeQuery(queries,
					effectiveDateFrom, effectiveDateTo,
					EmpDisciplineField.EFFECTIVE_DATE, searchContext);

			final Sort sort = new Sort(EmpDisciplineField.ID, false);
			final List<Document> documents = EmpDisciplineLocalServiceUtil
					.filterByFields(searchContext, filters, sort,
							searchContext.getCompanyId(), first, first
									+ pageSize);

			for (Document document : documents) {
				results.add(new EmpDisciplineIndexedItem(document));
			}
			setPageSize(pageSize);
			setRowCount(EmpDisciplineLocalServiceUtil.countFilterByFields(
					searchContext, filters, sort, searchContext.getCompanyId()));

			return results;
		} catch (ParseException e) {
			LOGGER.info(e);
		} catch (java.text.ParseException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public EmpDisciplineIndexedItem getRowData(String rowKey) {
		return new EmpDisciplineIndexedItem(
				EmpDisciplineLocalServiceUtil.getIndexedDocument(rowKey,
						searchContext));
	}
}
