package vn.com.ecopharma.emp.dm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.AbstractIndexedItem;

import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;

public class AbstractEmpBaseLazyDataModel<T extends AbstractIndexedItem>
		extends AbstractBaseOrganizationLazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void bindOrganizationFilterFields(Map<String, Object> filters,
			List<Query> queries) throws ParseException {
		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			final String filterProperty = it.next();
			System.out.println("filterProperty: " + filterProperty);
			final Object filterValue = filters.get(filterProperty);
			if (filterProperty.equalsIgnoreCase(EmpField.VN_FULL_NAME)) {
				if (filterValue != null
						&& !StringUtils.EMPTY.equals(((String) filterValue)))
					queries.add(createFullNameViQuery((String) filterValue,
							getSearchContext()));
			} else if (filterProperty.equalsIgnoreCase(EmpField.EMP_CODE)) {
				if (filterValue != null
						&& !StringUtils.EMPTY.equals(((String) filterValue)))
					queries.add(createEmpCodeQuery((String) filterValue,
							getSearchContext()));
			}
		}
		super.bindOrganizationFilterFields(filters, queries);
	}

	private Query createFullNameViQuery(String fullNameValue,
			SearchContext searchContext) throws ParseException {
		BooleanQuery fullNameQuery = BooleanQueryFactoryUtil
				.create(getSearchContext());
		fullNameQuery.addTerm(EmpField.VN_FULL_NAME, fullNameValue, true,
				BooleanClauseOccur.MUST);
		return fullNameQuery;
	}

	private Query createEmpCodeQuery(String empCodeValue,
			SearchContext searchContext) throws ParseException {
		BooleanQuery empCodeQuery = BooleanQueryFactoryUtil
				.create(getSearchContext());
		empCodeQuery.addTerm(EmpField.EMP_CODE, empCodeValue, true,
				BooleanClauseOccur.MUST);
		return empCodeQuery;
	}
}
