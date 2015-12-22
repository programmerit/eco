package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dm.EmployeeIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.util.PortalUtil;

@ManagedBean
@ViewScoped
public class EmployeeIndexedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final List<String> VALID_COLUMNS = Arrays.asList(
			"employeeCode", "fullName", "titles", "gender", "birthdayString",
			"joinedDateString", "promotedDateString",
			"laborContractSignedDateString", "laborContractExpiredDateString",
			"laborContractType", "contactNumber", "unit", "department",
			"devision", "level", "emailAddress", "companyEmailAddress",
			"taxCode", "maritalStatus", "education");

	private static final List<String> SORTABLE_COLUMNS = Arrays.asList(
			"employeeCode", "fullName", "titles", "gender", "birthdayString",
			"joinedDate", "promotedDate", "laborContractSignedDate",
			"laborContractExpiredDate", "laborContractType", "contactNumber",
			"unit", "department", "devision", "level", "emailAddress",
			"companyEmailAddress", "taxCode", "maritalStatus", "education");

	private List<ColumnModel> columns;

	private List<String> columnTemplates = Arrays.asList("employeeCode",
			"fullName", "titles", "gender", "birthdayString",
			"joinedDateString");

	private static final String DATE_FORMAT = "dd/MM/yyyy";
	private static final String GLOBAL_STRING = "globalString";
	private static final String JOINED_DATE_FROM = "joined_dateFrom";
	private static final String JOINED_DATE_TO = "joined_dateTo";

	private LazyDataModel<EmpIndexedItem> lazyDataModel;
	private EmpIndexedItem selectedEmployeeIndexItem;

	private List<EmpIndexedItem> empIndexedItems;

	private transient Map<String, Object> filterMap;

	private String sortField;

	private SortOrder sortOder;

	private List<Query> queries;

	private int first = -1;

	private int pageSize;

	@PostConstruct
	public void init() {
		lazyDataModel = new EmployeeIndexLazyDataModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<EmpIndexedItem> load(int first, int pageSize,
					String sortField_, SortOrder sortOrder_,
					Map<String, Object> filters) {
				final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				final EmployeeFilterView filterBean = (EmployeeFilterView) BeanUtils
						.getBackingBeanByName("empFilterBean");
				final String dateFromStr = filterBean.getJoinedDateFrom() != null ? sdf
						.format(filterBean.getJoinedDateFrom())
						: StringUtils.EMPTY;
				final String dateToStr = filterBean.getJoinedDateTo() != null ? sdf
						.format(filterBean.getJoinedDateTo())
						: StringUtils.EMPTY;

				if (filterBean.getGlobalString() != StringUtils.EMPTY) {
					filters.put(GLOBAL_STRING, filterBean.getGlobalString());
				}

				if (filterBean.getEmployeeCode() != StringUtils.EMPTY) {
					filters.put(EmpField.EMP_CODE, filterBean.getEmployeeCode());
				}

				if (dateFromStr != StringUtils.EMPTY) {
					filters.put(JOINED_DATE_FROM, dateFromStr);
				}
				if (dateToStr != StringUtils.EMPTY) {
					filters.put(JOINED_DATE_TO, dateToStr);
				}

				if (filterBean.getFullName() != StringUtils.EMPTY) {
					filters.put(EmpField.FULL_NAME, filterBean.getFullName());
				}

				if (filterBean.getSelectedGenders() != null
						&& !filterBean.getSelectedGenders().isEmpty()) {
					filters.put(EmpField.GENDER,
							filterBean.getSelectedGenders());
				}

				if (filterBean.getDevision() != null) {
					filters.put(EmpField.DEVISION, filterBean.getDevision()
							.getName());
				}
				if (filterBean.getDepartment() != null) {
					filters.put(EmpField.DEPARTMENT, filterBean.getDepartment()
							.getName());
				}
				if (filterBean.getUnit() != null) {
					filters.put(EmpField.UNIT, filterBean.getUnit().getName());
				}

				if (filterBean.getUnitGroup() != null) {
					filters.put(EmpField.UNIT_GROUP, filterBean.getUnitGroup()
							.getName());
				}

				if (filterBean.getTitles() != null) {
					filters.put(EmpField.TITLES, filterBean.getTitles()
							.getName());
				}
				sortField = sortField_;
				sortOder = sortOrder_;
				filterMap = filters;
				// first = EmployeeIndexedBean.this.first > first ?
				// EmployeeIndexedBean.this.first
				// : first;
				empIndexedItems = super.load(first, pageSize, sortField_,
						sortOrder_, filters);
				queries = this.getQueries();
				// EmployeeIndexedBean.this.first =
				// EmployeeIndexedBean.this.first < first ? first
				// : EmployeeIndexedBean.this.first;
				return empIndexedItems;
			}
		};
		createDynamicColumns();
	}

	private void createDynamicColumns() {
		columns = new ArrayList<>();

		for (String columnKey : columnTemplates) {
			String key = columnKey.trim();

			if (VALID_COLUMNS.contains(key)) {
				columns.add(new ColumnModel(columnKey, columnKey));
			}
		}
	}

	public List<String> completeColumns(String query) {
		final List<String> filteredItem = new ArrayList<>();
		for (String s : VALID_COLUMNS) {
			if ("*".equals(query) || s.contains(query))
				filteredItem.add(s);
		}
		return filteredItem;
	}

	public void updateColumns() {
		final UIComponent table = FacesContext.getCurrentInstance()
				.getViewRoot().findComponent(":employeesForm:employees");
		table.setValueExpression("sortBy", null);

		// update columns
		createDynamicColumns();
	}

	public String getSortColumn(String columnKey) {
		if (VALID_COLUMNS.contains(columnKey)) {
			int index = VALID_COLUMNS.indexOf(columnKey);
			return SORTABLE_COLUMNS.get(index);
		}
		return StringUtils.EMPTY;
	}

	public void onDeSelectColumn(String columnKey) {
		for (ColumnModel c : columns) {
			if (c.getProperty().equalsIgnoreCase(columnKey)) {
				columns.remove(c);
				VALID_COLUMNS.add(columnKey);
			}
		}
		updateColumns();
	}

	public void indexAllEmployees() {
		EmpLocalServiceUtil.indexAllEmps();
	}

	public void indexSomeEmployees() {
		EmpLocalServiceUtil.indexSomeEmps();

	}

	public void removeIndexes() {
		final LiferayFacesContext liferayFacesContext = LiferayFacesContext
				.getInstance();

		final PortletRequest req = (PortletRequest) liferayFacesContext
				.getExternalContext().getRequest();
		final HttpServletRequest httpServletRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(req));

		final SearchContext searchContext = SearchContextFactory
				.getInstance(httpServletRequest);

		EmpLocalServiceUtil.removeAllEmpIndexes(searchContext,
				liferayFacesContext.getCompanyId());

	}

	public void onCompletelyRemoveAllEmployees() {
		EmpLocalServiceUtil.completelyRemoveAllEmp(LiferayFacesContext
				.getInstance().getCompanyId());
	}

	public void onCompletelyRemoveAllEmployeesFromDB() {
		EmpLocalServiceUtil.completelyRemoveAllEmpFromDB(LiferayFacesContext
				.getInstance().getCompanyId());
	}

	public void onCompletelyRemoveAllOrganizations() {
		TitlesLocalServiceUtil.completelyRemoveAll();

		UnitGroupLocalServiceUtil.completelyRemoveAll();

		UnitLocalServiceUtil.completelyRemoveAll();

		DepartmentLocalServiceUtil.completelyRemoveAll();

		DevisionLocalServiceUtil.completelyDeleteAll();
	}

	public String getHeaderi18nKey(String header) {
		return "employee.info." + header;
	}

	public LazyDataModel<EmpIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(LazyDataModel<EmpIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public EmpIndexedItem getSelectedEmployeeIndexItem() {
		return selectedEmployeeIndexItem;
	}

	public void setSelectedEmployeeIndexItem(
			EmpIndexedItem selectedEmployeeIndexItem) {
		this.selectedEmployeeIndexItem = selectedEmployeeIndexItem;
	}

	public List<EmpIndexedItem> getEmpIndexedItems() {
		return empIndexedItems;
	}

	public void setEmpIndexedItems(List<EmpIndexedItem> empIndexedItems) {
		this.empIndexedItems = empIndexedItems;
	}

	public Map<String, Object> getFilterMap() {
		return filterMap;
	}

	public void setFilterMap(Map<String, Object> filterMap) {
		this.filterMap = filterMap;
	}

	public SortOrder getSortOder() {
		return sortOder;
	}

	public void setSortOder(SortOrder sortOder) {
		this.sortOder = sortOder;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public List<Query> getQueries() {
		return queries;
	}

	public void setQueries(List<Query> queries) {
		this.queries = queries;
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}

	public List<String> getColumnTemplates() {
		return columnTemplates;
	}

	public void setColumnTemplates(List<String> columnTemplates) {
		this.columnTemplates = columnTemplates;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getEmpClassName() {
		return Emp.class.getName();
	}

	public static class ColumnModel implements Serializable {

		private static final long serialVersionUID = 1L;

		private String header;
		private String property;

		public ColumnModel(String header, String property) {
			this.header = header;
			this.property = property;
		}

		public String getHeader() {
			return header;
		}

		public void setHeader(String header) {
			this.header = header;
		}

		public String getProperty() {
			return property;
		}

		public void setProperty(String property) {
			this.property = property;
		}
	}

}
