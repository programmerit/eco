package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dm.TimeTrackingReportLazyDataModel;
import vn.com.ecopharma.hrm.tt.dto.EmpTimeTrackingIndexedItem;
import vn.com.ecopharma.hrm.tt.enumeration.ValueFilterType;
import vn.com.ecopharma.hrm.tt.utils.BeanUtils;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

@ManagedBean
@ViewScoped
public class TimeTrackingReportBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String DATE_FORMAT = "dd/MM/yyyy";

	private static final String SHORT_DATE_FORMAT = "dd/MM";

	private static final String DAY_FORMAT = "EE";

	private LazyDataModel<EmpTimeTrackingIndexedItem> lazyDataModel;

	private EmpTimeTrackingIndexedItem selectedEmpTimeTrackingIndexedItem;

	@PostConstruct
	public void init() {

		lazyDataModel = new TimeTrackingReportLazyDataModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public List<EmpTimeTrackingIndexedItem> load(int first,
					int pageSize, String sortField, SortOrder sortOrder,
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

				// TTUtils.checkAndAddFilterValue(
				// TimeTrackingField.IS_EMPTY_IN,
				// filterBean.getValueFilter().equalsIgnoreCase(
				// ValueFilterType.EMPTY_MIN_IN.toString()) ? true
				// : false, filters);
				//
				// TTUtils.checkAndAddFilterValue(
				// TimeTrackingField.IS_EMPTY_OUT,
				// filterBean.getValueFilter().equalsIgnoreCase(
				// ValueFilterType.EMPTY_MAX_OUT.toString()) ? true
				// : false, filters);

				// month
				filters.put(TimeTrackingField.MONTH, filterBean.getMonth());

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};

	}

	public List<Date> getDatesOfMonth(int month) {
		final List<Date> result = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		for (int i = 1; i <= maxDay; i++) {
			calendar.set(Calendar.DAY_OF_MONTH, i);
			calendar.set(Calendar.HOUR, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			result.add(calendar.getTime());
		}
		return result;
	}

	public List<String> getDatesOfMonthStrings() {
		final List<String> result = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

		for (Date date : getDatesOfMonth(getFilteredMonth())) {
			result.add(sdf.format(date));
		}
		return result;
	}

	public List<String> getShortDatesOfMonthStrings() {
		final List<String> result = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);

		for (Date date : getDatesOfMonth(getFilteredMonth())) {
			result.add(sdf.format(date));
		}
		return result;
	}

	public List<String> getDaysOfMonthStrings() {
		final List<String> result = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);

		for (Date date : getDatesOfMonth(getFilteredMonth())) {
			result.add(sdf.format(date));
		}
		return result;
	}

	private static int getFilteredMonth() {
		return BeanUtils.getTimeTrackingFilterBean().getMonth();
	}

	public int getDatesSize() {
		return getDatesOfMonthStrings().size();
	}

	public LazyDataModel<EmpTimeTrackingIndexedItem> getLazyDataModel() {
		return lazyDataModel;
	}

	public void setLazyDataModel(
			LazyDataModel<EmpTimeTrackingIndexedItem> lazyDataModel) {
		this.lazyDataModel = lazyDataModel;
	}

	public EmpTimeTrackingIndexedItem getSelectedEmpTimeTrackingIndexedItem() {
		return selectedEmpTimeTrackingIndexedItem;
	}

	public void setSelectedEmpTimeTrackingIndexedItem(
			EmpTimeTrackingIndexedItem selectedEmpTimeTrackingIndexedItem) {
		this.selectedEmpTimeTrackingIndexedItem = selectedEmpTimeTrackingIndexedItem;
	}

}
