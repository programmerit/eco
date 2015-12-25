package vn.com.ecopharma.emp.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

import vn.com.ecopharma.emp.constant.EmpField;
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

@ManagedBean(name = "empFilterBean")
@ViewScoped
public class EmployeeFilterView implements Serializable {
	private static final long serialVersionUID = 1L;

	private String globalString = StringUtils.EMPTY;
	private String employeeCode = StringUtils.EMPTY;
	private String fullName = StringUtils.EMPTY;
	private String gender = StringUtils.EMPTY;
	private String status = StringUtils.EMPTY;

	private Unit unit;
	private Department department;
	private Devision devision;
	private UnitGroup unitGroup;
	private Titles titles;

	private Date joinedDateFrom;
	private Date joinedDateTo;

	private List<String> selectedGenders;

	public void onGlobalFiltering() {
		// only execute search for more than 2 words
		if (this.globalString.length() >= 2) {
			RequestContext.getCurrentInstance().execute(
					"filterEmployees(); refreshFooter();");
		}
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

	public void resetJoinedDateFrom() {
		joinedDateFrom = null;
	}

	public void resetJoinedDateTo() {
		joinedDateTo = null;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public Date getJoinedDateFrom() {
		return joinedDateFrom;
	}

	public void setJoinedDateFrom(Date joinedDateFrom) {
		this.joinedDateFrom = joinedDateFrom;
	}

	public Date getJoinedDateTo() {
		return joinedDateTo;
	}

	public void setJoinedDateTo(Date joinedDateTo) {
		this.joinedDateTo = joinedDateTo;
	}

	public List<String> getSelectedGenders() {
		return selectedGenders;
	}

	public void setSelectedGenders(List<String> selectedGenders) {
		this.selectedGenders = selectedGenders;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/* For Order */
	public String getJoinedDate() {
		return EmpField.JOINED_DATE;
	}

	public String getBirthDay() {
		return EmpField.BIRTHDAY;
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
		return TitlesLocalServiceUtil.findFilterTitlesByRelatedEntities(
				department, unit, unitGroup);
	}

	public Titles getTitles() {
		return titles;
	}

	public void setTitles(Titles titles) {
		this.titles = titles;
	}
}
