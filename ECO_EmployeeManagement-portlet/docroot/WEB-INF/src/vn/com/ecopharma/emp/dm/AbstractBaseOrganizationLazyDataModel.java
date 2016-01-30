package vn.com.ecopharma.emp.dm;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.AbstractIndexedItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.TermQuery;
import com.liferay.portal.kernel.search.TermQueryFactoryUtil;

public abstract class AbstractBaseOrganizationLazyDataModel<T extends AbstractIndexedItem>
		extends AbstractIndexedLazyDataModel<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(AbstractBaseOrganizationLazyDataModel.class);

	@SuppressWarnings("unchecked")
	protected void bindOrganizationFilterFields(Map<String, Object> filters,
			List<Query> queries) throws ParseException {
		final SearchContext searchContext = getSearchContext();
		for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
			final String filterProperty = it.next();
			final Object filterValue = filters.get(filterProperty);
			LOGGER.info("Filter Property: " + filterProperty);

			if (filterProperty.equalsIgnoreCase(EmpField.DEVISION)) {
				queries.add(createDevisionQuery((List<Devision>) filterValue,
						searchContext));
			} else if (filterProperty.equalsIgnoreCase(EmpField.DEPARTMENT)) {
				queries.add(createDepartmentQuery(
						(List<Department>) filterValue, searchContext));
			} else if (filterProperty.equalsIgnoreCase(EmpField.UNIT)) {
				queries.add(createUnitQuery((List<Unit>) filterValue,
						searchContext));
			} else if (filterProperty.equalsIgnoreCase(EmpField.UNIT_GROUP)) {
				queries.add(createUnitGroupQuery((List<UnitGroup>) filterValue,
						searchContext));
			} else if (filterProperty.equalsIgnoreCase(EmpField.TITLES)) {
				queries.add(createTitlesQuery((List<Titles>) filterValue,
						searchContext));
			}
		}
	}

	private Query createDevisionQuery(List<Devision> devisions,
			SearchContext searchContext) throws ParseException {
		final BooleanQuery devisionQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		for (Devision devision : devisions) {
			TermQuery devisionTermQuery = TermQueryFactoryUtil.create(
					searchContext, EmpField.DEVISION,
					StringUtils.trimToEmpty(devision.getName()));
			devisionQuery.add(devisionTermQuery, BooleanClauseOccur.SHOULD);
		}
		return devisionQuery;
	}

	private Query createDepartmentQuery(List<Department> departments,
			SearchContext searchContext) throws ParseException {
		final BooleanQuery deptQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		for (Department dept : departments) {
			TermQuery deptTermQuery = TermQueryFactoryUtil.create(
					searchContext, EmpField.DEPARTMENT,
					StringUtils.trimToEmpty(dept.getName()));
			deptQuery.add(deptTermQuery, BooleanClauseOccur.SHOULD);
		}
		return deptQuery;
	}

	private Query createUnitQuery(List<Unit> units, SearchContext searchContext)
			throws ParseException {
		final BooleanQuery unitQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		for (Unit unit : units) {
			TermQuery unitTermQuery = TermQueryFactoryUtil.create(
					searchContext, EmpField.UNIT,
					StringUtils.trimToEmpty(unit.getName()));
			unitQuery.add(unitTermQuery, BooleanClauseOccur.SHOULD);
		}
		return unitQuery;
	}

	private Query createUnitGroupQuery(List<UnitGroup> unitGroups,
			SearchContext searchContext) throws ParseException {
		final BooleanQuery unitGroupQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		for (UnitGroup unitGroup : unitGroups) {
			TermQuery titlesTermQuery = TermQueryFactoryUtil.create(
					searchContext, EmpField.UNIT_GROUP,
					StringUtils.trimToEmpty(unitGroup.getName()));
			unitGroupQuery.add(titlesTermQuery, BooleanClauseOccur.SHOULD);
		}
		return unitGroupQuery;
	}

	private Query createTitlesQuery(List<Titles> titlesList,
			SearchContext searchContext) throws ParseException {
		final BooleanQuery titlesQuery = BooleanQueryFactoryUtil
				.create(searchContext);

		for (Titles titles : titlesList) {
			TermQuery titlesTermQuery = TermQueryFactoryUtil.create(
					searchContext, EmpField.TITLES,
					StringUtils.trimToEmpty(titles.getName()));
			titlesQuery.add(titlesTermQuery, BooleanClauseOccur.SHOULD);
		}
		return titlesQuery;
	}

}
