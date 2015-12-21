package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dm.TimeTrackingLazyDataModel;
import vn.com.ecopharma.hrm.tt.dto.TimeTrackingIndexItem;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.utils.BeanUtils;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

@ManagedBean
@ViewScoped
public class TimeTrackingBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final List<String> VALID_COLUMNS = Arrays.asList("unit",
			"empCode", "fullName", "titles", "dateFormatted", "day", "emptyIn",
			"emptyOut", "in1Formatted", "out1Formatted", "in2Formatted",
			"out2Formatted", "in3Formatted", "out3Formatted");

	private List<String> columnTemplates = Arrays.asList("unit", "empCode",
			"fullName", "titles", "dateFormatted", "day", "emptyIn",
			"emptyOut", "in1Formatted", "out1Formatted");

	private static final List<String> SORTABLE_COLUMNS = Arrays.asList("unit",
			"empCode", "fullName", "titles");

	private static final List<String> EDITABLE_COLUMNS = Arrays.asList(
			"in1Formatted", "out1Formatted", "in2Formatted", "out2Formatted",
			"in3Formatted", "out3Formatted");

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
				final TimeTrackingFilterBean filterBean = BeanUtils
						.getTimeTrackingFilterBean();

				TTUtils.checkAndAddFilterValue(TimeTrackingField.GLOBAL,
						filterBean.getGlobalString(), filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.FULLNAME,
						filterBean.getFullName(), filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.EMP_CODE,
						filterBean.getEmployeeCode(), filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.DEVISION,
						filterBean.getDevision() != null ? filterBean
								.getDevision().getName() : StringUtils.EMPTY,
						filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.DEPARTMENT,
						filterBean.getDepartment() != null ? filterBean
								.getDepartment().getName() : StringUtils.EMPTY,
						filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.UNIT,
						filterBean.getUnit() != null ? filterBean.getUnit()
								.getName() : StringUtils.EMPTY, filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.UNIT_GROUP,
						filterBean.getUnitGroup() != null ? filterBean
								.getUnitGroup().getName() : StringUtils.EMPTY,
						filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.TITLES,
						filterBean.getTitles() != null ? filterBean.getTitles()
								.getName() : StringUtils.EMPTY, filters);

				/* check and add Tracking Date Range */

				TTUtils.checkAndAddFilterValue(
						TimeTrackingField.FILTERED_DATE_FROM,
						filterBean.getFilteredDateFrom(), filters);
				TTUtils.checkAndAddFilterValue(
						TimeTrackingField.FILTERED_DATE_TO,
						filterBean.getFilteredDateTo(), filters);

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
		columns = new ArrayList<>();
		final Map<String, String> actualColumnKeyMap = getActualColumnKeyMap();
		for (String columnKey : columnTemplates) {
			final String key = columnKey.trim();

			if (VALID_COLUMNS.contains(key)) {
				final String actualColumnKey = actualColumnKeyMap.get(key);
				final ColumnModel model = new ColumnModel(key, key,
						actualColumnKey, isEditableColumn(key));
				columns.add(model);
			}
		}
	}

	/**
	 * Store actual value of time tracking(in1, in2,...) in order to provide for
	 * inline editing
	 * 
	 * @return map<String, String> with formatted value is the KEY, actual value
	 *         is the VALUE
	 */
	private Map<String, String> getActualColumnKeyMap() {
		final Map<String, String> map = new HashMap<>();

		map.put("in1Formatted", "in1");
		map.put("in2Formatted", "in2");
		map.put("in3Formatted", "in3");
		map.put("out1Formatted", "out1");
		map.put("out2Formatted", "out2");
		map.put("out3Formatted", "out3");
		return map;

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
			if ("*".equals(query) || s.contains(query))
				filteredItem.add(s);
		}
		return filteredItem;
	}

	public void onRowEdit(RowEditEvent event) {
		final TimeTrackingIndexItem editItem = (TimeTrackingIndexItem) event
				.getObject();

		TimeTrackingLocalServiceUtil.updateTimeTracking(editItem.getId(),
				editItem.getIn1(), editItem.getIn2(), editItem.getIn3(),
				editItem.getOut1(), editItem.getOut2(), editItem.getOut3());

	}

	public void onRowEditCancel(RowEditEvent event) {

	}

	public LazyDataModel<TimeTrackingIndexItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<TimeTrackingIndexItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	private static boolean isEditableColumn(String columnKey) {
		return EDITABLE_COLUMNS.contains(columnKey);
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

	public static class ColumnModel implements Serializable {

		private static final long serialVersionUID = 1L;

		private String header;
		private String property;
		private String actualProperty;
		private boolean isEditable;

		public ColumnModel(String header, String property,
				String actualProperty, boolean isEditable) {
			this.header = header;
			this.property = property;
			this.actualProperty = actualProperty;
			this.isEditable = isEditable;
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

		public boolean isEditable() {
			return isEditable;
		}

		public void setEditable(boolean isEditable) {
			this.isEditable = isEditable;
		}

		public String getActualProperty() {
			return actualProperty;
		}

		public void setActualProperty(String actualProperty) {
			this.actualProperty = actualProperty;
		}
	}
}
