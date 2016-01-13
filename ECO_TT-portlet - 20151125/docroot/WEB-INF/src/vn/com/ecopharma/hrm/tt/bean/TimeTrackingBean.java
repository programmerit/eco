package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.dm.TimeTrackingLazyDataModel;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;

@ManagedBean(name = "timeTrackingBean")
@ViewScoped
public class TimeTrackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static List<String> VALID_COLUMNS = Arrays.asList("unit",
			"empCode", "fullName", "titles", "dateFormatted", "day",
			"in1Formatted", "out1Formatted", "in2Formatted", "out2Formatted",
			"in3Formatted", "out3Formatted");

	private List<String> columnTemplates = Arrays.asList("unit", "empCode",
			"fullName", "titles", "dateFormatted", "day", "in1Formatted",
			"out1Formatted");

	private static List<String> SORTABLE_COLUMNS = Arrays.asList("unit",
			"empCode", "fullName", "titles");

	private LazyDataModel<TimeTrackingIndexItem> lazyDataModel;

	private List<ColumnModel> columns;

	@PostConstruct
	public void init() {
		lazyDataModel = new TimeTrackingLazyDataModel() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public List<TimeTrackingIndexItem> load(int first, int pageSize,
					String sortField, SortOrder sortOrder,
					Map<String, Object> filters) {
				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};
		createDynamicColumns();
	}

	public void updateColumns() {
		final UIComponent table = FacesContext.getCurrentInstance()
				.getViewRoot().findComponent(":timeTrackingForm:timeTrackings");
		table.setValueExpression("sortBy", null);

		// update columns
		createDynamicColumns();
	}

	private void createDynamicColumns() {
		columns = new ArrayList<ColumnModel>();

		for (String columnKey : columnTemplates) {
			String key = columnKey.trim();

			if (VALID_COLUMNS.contains(key)) {
				columns.add(new ColumnModel(columnKey, columnKey));
			}
		}
	}

	public String getSortColumn(String columnKey) {
		if (VALID_COLUMNS.contains(columnKey)) {
			int index = VALID_COLUMNS.indexOf(columnKey);
			return SORTABLE_COLUMNS.get(index);
		}
		return StringUtils.EMPTY;
	}

	public List<String> completeColumns(String query) {
		final List<String> filteredItem = new ArrayList<String>();
		for (String s : VALID_COLUMNS) {
			if (query.equals("*") || s.contains(query))
				filteredItem.add(s);
		}
		return filteredItem;
	}

	public LazyDataModel<TimeTrackingIndexItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<TimeTrackingIndexItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public String getHeaderi18nKey(String header) {
		return "timetracking." + header;
	}

	public String getLocalizedString(String header) {
		return "timetracking." + header;
	}

	public List<String> getColumnTemplates() {
		return columnTemplates;
	}

	public void setColumnTemplates(List<String> columnTemplates) {
		this.columnTemplates = columnTemplates;
	}

	public List<ColumnModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnModel> columns) {
		this.columns = columns;
	}
	
	

	static public class ColumnModel implements Serializable {

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
