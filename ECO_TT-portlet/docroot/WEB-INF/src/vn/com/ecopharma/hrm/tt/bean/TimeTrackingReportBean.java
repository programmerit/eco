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

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.dm.TimeTrackingReportLazyDataModel;
import vn.com.ecopharma.hrm.tt.dto.EmpTimeTrackingIndexedItem;
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

				final OrganizationFilterBean organizationFilterBean = BeanUtils
						.getOrganizationFilterBean();

				TTUtils.checkAndAddFilterValue(TimeTrackingField.GLOBAL,
						filterBean.getGlobalString(), filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.VN_FULLNAME,
						filterBean.getFullName(), filters);

				TTUtils.checkAndAddFilterValue(TimeTrackingField.EMP_CODE,
						filterBean.getEmployeeCode(), filters);

				if (organizationFilterBean.getSelectedDevisions() != null
						&& !organizationFilterBean.getSelectedDevisions()
								.isEmpty()) {
					filters.put(TimeTrackingField.DEVISION,
							organizationFilterBean.getSelectedDevisions());
				}

				if (organizationFilterBean.getSelectedDepartments() != null
						&& !organizationFilterBean.getSelectedDepartments()
								.isEmpty()) {
					filters.put(TimeTrackingField.DEPARTMENT,
							organizationFilterBean.getSelectedDepartments());
				}

				if (organizationFilterBean.getSelectedUnits() != null
						&& !organizationFilterBean.getSelectedUnits().isEmpty()) {
					filters.put(TimeTrackingField.UNIT,
							organizationFilterBean.getSelectedUnits());
				}

				if (organizationFilterBean.getSelectedUnitGroups() != null
						&& !organizationFilterBean.getSelectedUnitGroups()
								.isEmpty()) {
					filters.put(TimeTrackingField.UNIT_GROUP,
							organizationFilterBean.getSelectedUnitGroups());
				}

				if (organizationFilterBean.getSelectedTitlesList() != null
						&& !organizationFilterBean.getSelectedTitlesList()
								.isEmpty()) {
					filters.put(TimeTrackingField.TITLES,
							organizationFilterBean.getSelectedTitlesList());
				}

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

				// year
				filters.put(TimeTrackingField.YEAR, filterBean.getYear());

				return super.load(first, pageSize, sortField, sortOrder,
						filters);
			}
		};

	}

	public List<Date> getDatesOfMonth(int month, int year) {
		final List<Date> result = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
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

		for (Date date : getDatesOfMonth(getFilteredMonth(), getFilteredYear())) {
			result.add(sdf.format(date));
		}
		return result;
	}

	public List<String> getShortDatesOfMonthStrings() {
		final List<String> result = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);

		for (Date date : getDatesOfMonth(getFilteredMonth(), getFilteredYear())) {
			result.add(sdf.format(date));
		}
		return result;
	}

	public List<String> getDaysOfMonthStrings() {
		final List<String> result = new ArrayList<>();
		final SimpleDateFormat sdf = new SimpleDateFormat(DAY_FORMAT);

		for (Date date : getDatesOfMonth(getFilteredMonth(), getFilteredYear())) {
			result.add(sdf.format(date));
		}
		return result;
	}

	private static int getFilteredMonth() {
		return BeanUtils.getTimeTrackingFilterBean().getMonth();
	}

	private static int getFilteredYear() {
		return BeanUtils.getTimeTrackingFilterBean().getYear();
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
