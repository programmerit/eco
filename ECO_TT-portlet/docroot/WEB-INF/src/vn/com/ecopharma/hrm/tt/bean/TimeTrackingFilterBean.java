package vn.com.ecopharma.hrm.tt.bean;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
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

	public void resetFilteredDateFrom() {
		filteredDateFrom = null;
	}

	public void resetFilteredDateTo() {
		filteredDateTo = null;
	}

	public List<Devision> getDevisions() {
		return DevisionLocalServiceUtil.findAll();
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
