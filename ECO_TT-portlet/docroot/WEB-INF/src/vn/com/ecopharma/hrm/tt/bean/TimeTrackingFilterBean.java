package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.enumeration.ValueFilterType;

@ManagedBean
@ViewScoped
public class TimeTrackingFilterBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String globalString = StringUtils.EMPTY;
	private String employeeCode = StringUtils.EMPTY;
	private String fullName = StringUtils.EMPTY;

	private Unit unit;
	private Department department;
	private Devision devision;
	private UnitGroup unitGroup;
	private Titles titles;

	private Date filteredDateFrom;
	private Date filteredDateTo;

	private String valueFilter = ValueFilterType.ALL.toString();

	// for report page only
	private int month;
	private int year;

	@PostConstruct
	public void init() {
		month = getDefaultMonth();
		year = getDefaultYear();
	}

	public void onDevisionChanged() {
		this.department = null;
		this.unitGroup = null;
		this.titles = null;
	}

	public void onDepartmentChanged() {
		this.unit = null;
		this.unitGroup = null;
		this.titles = null;
	}

	public void onUnitChanged() {
		this.unitGroup = null;
		this.titles = null;
	}

	public void onUnitGroupChanged() {
		this.titles = null;
	}

	public void onTitlesChanged() {
	}

	public void resetFilteredDateFrom() {
		filteredDateFrom = null;
	}

	public void resetFilteredDateTo() {
		filteredDateTo = null;
	}

	public List<Unit> getUnits() {
		return department != null ? UnitLocalServiceUtil
				.findByDepartment(department.getDepartmentId())
				: new ArrayList<Unit>();
	}

	public List<UnitGroup> getUnitGroups() {
		return unit != null ? UnitGroupLocalServiceUtil.findByUnit(unit
				.getUnitId()) : new ArrayList<UnitGroup>();
	}

	public List<Department> getDepartments() {
		return devision != null ? DepartmentLocalServiceUtil
				.findByDevision(devision.getDevisionId())
				: new ArrayList<Department>();
	}

	public List<Devision> getDevisions() {
		return DevisionLocalServiceUtil.findAll();
	}

	public List<Titles> getTitlesList() {
		if (unit == null) {
			return department != null ? TitlesLocalServiceUtil
					.findAllByDepartment(department.getDepartmentId())
					: new ArrayList<Titles>();
		} else {
			if (unitGroup != null) {
				return TitlesLocalServiceUtil.findByUnitGroupOnly(unitGroup
						.getUnitGroupId());
			} else {
				return TitlesLocalServiceUtil.findByUnitOnly(unit.getUnitId());
			}
		}
	}

	public String getGlobalString() {
		return globalString;
	}

	public void setGlobalString(String globalString) {
		this.globalString = globalString;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}

	public Date getFilteredDateFrom() {
		return filteredDateFrom;
	}

	public void setFilteredDateFrom(Date filteredDateFrom) {
		this.filteredDateFrom = filteredDateFrom;
	}

	public Date getFilteredDateTo() {
		return filteredDateTo;
	}

	public void setFilteredDateTo(Date filteredDateTo) {
		this.filteredDateTo = filteredDateTo;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Devision getDevision() {
		return devision;
	}

	public void setDevision(Devision devision) {
		this.devision = devision;
	}

	public UnitGroup getUnitGroup() {
		return unitGroup;
	}

	public void setUnitGroup(UnitGroup unitGroup) {
		this.unitGroup = unitGroup;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getValueFilter() {
		return valueFilter;
	}

	public void setValueFilter(String valueFilter) {
		this.valueFilter = valueFilter;
	}

	/**
	 * Use today as maximum day for filtering
	 * 
	 * @return
	 */
	public Date getMaxFilterableDay() {
		return new Date();
	}

	public List<Integer> getMonths() {
		return Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
	}

	public List<Integer> getYears() {
		return Arrays.asList(2015, 2016);
	}

	public List<String> getValuesFilter() {
		return ValueFilterType.getStringValues();
	}

	public String getMonthName(int month) {
		return new DateFormatSymbols().getMonths()[month];
	}

	private static int getDefaultMonth() {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.MONTH);
	}

	private static int getDefaultYear() {
		return 2016;
	}
}
