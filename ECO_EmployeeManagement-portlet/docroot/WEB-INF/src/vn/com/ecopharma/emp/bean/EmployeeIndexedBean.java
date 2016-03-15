package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.emp.bean.filter.EmployeeFilterView;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dm.EmpIndexLazyDataModel;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.dto.FilterDTO;
import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.BeanUtils;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.util.PortalUtil;

@ManagedBean
@ViewScoped
public class EmployeeIndexedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmployeeIndexedBean.class);

	@ManagedProperty(value = "#{empFilterBean}")
	private transient EmployeeFilterView filterBean;

	private static final List<String> VALID_COLUMNS = Arrays.asList(
			"employeeCode", "fullName", "fullNameVi", "titles", "gender",
			"birthdayString", "joinedDateString", "promotedDateString",
			"laborContractSignedDateString", "laborContractExpiredDateString",
			"laborContractType", "contactNumber", "unitGroup", "unit",
			"department", "devision", "level", "emailAddress",
			"companyEmailAddress", "taxCode", "maritalStatus", "education");

	private static final List<String> SORTABLE_COLUMNS = Arrays.asList(
			"employeeCode", "fullName", "fullNameVi", "titles", "gender",
			"birthdayString", "joinedDate", "promotedDate",
			"laborContractSignedDate", "laborContractExpiredDate",
			"laborContractType", "contactNumber", "unitGroup", "unit",
			"department", "devision", "level", "emailAddress",
			"companyEmailAddress", "taxCode", "maritalStatus", "education");

	private List<ColumnModel> columns;

	private List<String> columnTemplates = Arrays.asList("employeeCode",
			"fullNameVi", "titles", "gender", "birthdayString",
			"joinedDateString");

	private static final String GLOBAL_STRING = "globalString";

	private LazyDataModel<EmpIndexedItem> lazyDataModel;
	private List<EmpIndexedItem> selectedEmployeeIndexItems;

	@PostConstruct
	public void init() {
		selectedEmployeeIndexItems = new ArrayList<>();
		lazyDataModel = new EmpIndexLazyDataModel() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<EmpIndexedItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {

				if (filterBean.getGlobalString() != StringUtils.EMPTY) {
					filters.put(GLOBAL_STRING, filterBean.getGlobalString());
				}

				if (filterBean.getJoinedDateFrom() != null)
					filters.put(EmpField.JOINED_DATE_FROM,
							filterBean.getJoinedDateFrom());

				if (filterBean.getJoinedDateTo() != null)
					filters.put(EmpField.JOINED_DATE_TO,
							filterBean.getJoinedDateTo());

				if (filterBean.getSelectedGenders() != null
						&& !filterBean.getSelectedGenders().isEmpty()) {
					filters.put(EmpField.GENDER,
							filterBean.getSelectedGenders());
				}

				if (filterBean.getSelectedStatuses() != null
						&& !filterBean.getSelectedStatuses().isEmpty()) {
					filters.put(EmpField.STATUS,
							filterBean.getSelectedStatuses());
				}

				List<EmpIndexedItem> empIndexedItems = super.load(first,
						pageSize, sortField, sortOrder, filters);

				BeanUtils.getEmpFilterHolderBean().setEmpFilterDTO(
						new FilterDTO(sortField, sortOrder, filters, first,
								pageSize));

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

	public void reindexAllEmps() {
		for (Emp emp : EmpLocalServiceUtil.findAll())
			try {
				EmpLocalServiceUtil.updateEmp(emp);
			} catch (SystemException e) {
				LOGGER.info(e);
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

	public void onCompletelyRemoveAllOrganizations() {
		TitlesLocalServiceUtil.completelyRemoveAll();

		UnitGroupLocalServiceUtil.completelyRemoveAll();

		UnitLocalServiceUtil.completelyRemoveAll();

		DepartmentLocalServiceUtil.completelyRemoveAll();

		DevisionLocalServiceUtil.completelyDeleteAll();

		TitlesDepartmentUnitUnitGroupLocalServiceUtil.completelyRemoveAll();
	}

	public void onTestSendMail() {

	}

	public boolean isDisciplineValid() {
		if (selectedEmployeeIndexItems.isEmpty())
			return false;
		for (EmpIndexedItem item : selectedEmployeeIndexItems)
			if (item.getStatus().equalsIgnoreCase(
					EmployeeStatus.RESIGNED.toString()))
				return false;
		return true;
	}

	public boolean isMaternityLeaveValid() {
		if (selectedEmployeeIndexItems.isEmpty()
				|| selectedEmployeeIndexItems.size() > 1)
			return false;
		EmpIndexedItem singleItem = selectedEmployeeIndexItems.get(0);

		return singleItem.getGender().equalsIgnoreCase("FEMALE")
				&& !(singleItem.getStatus().equalsIgnoreCase(
						EmployeeStatus.MATERNITY_LEAVE.toString())
						|| singleItem.getStatus().equalsIgnoreCase(
								EmployeeStatus.MATERNITY_LEAVE.toString()) || singleItem
						.getStatus().equalsIgnoreCase(
								EmployeeStatus.RESIGNED.toString()));
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

	public List<EmpIndexedItem> getSelectedEmployeeIndexItems() {
		return selectedEmployeeIndexItems;
	}

	public void setSelectedEmployeeIndexItems(
			List<EmpIndexedItem> selectedEmployeeIndexItems) {
		this.selectedEmployeeIndexItems = selectedEmployeeIndexItems;
	}

	public String getEmpClassName() {
		return Emp.class.getName();
	}

	public void setFilterBean(EmployeeFilterView filterBean) {
		this.filterBean = filterBean;
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
