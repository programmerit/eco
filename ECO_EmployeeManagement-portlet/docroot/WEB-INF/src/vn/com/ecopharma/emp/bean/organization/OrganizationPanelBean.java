package vn.com.ecopharma.emp.bean.organization;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.dto.EmpInfoItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpConcurrentTitles;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

@ManagedBean
@SessionScoped
public class OrganizationPanelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Devision selectedDevision;
	private Department selectedDepartment;
	private Unit selectedUnit;
	private UnitGroup selectedUnitGroup;
	private Titles selectedTitles;
	private Level selectedLevel;

	private List<EmpConcurrentTitles> concurrentTitles;

	@PostConstruct
	public void init() {
		this.concurrentTitles = new ArrayList<>();
	}

	public void afterSetOrganizationToEntity() {
		this.selectedDevision = null;
		this.selectedDepartment = null;
		this.selectedUnit = null;
		this.selectedUnitGroup = null;
		this.selectedTitles = null;
		this.selectedLevel = null;
	}

	public void onDevisionChanged() {
		selectedDepartment = null;
		selectedUnit = null;
		selectedUnitGroup = null;
		selectedTitles = null;
	}

	public void onDepartmentChanged() {
		selectedUnit = null;
		selectedUnitGroup = null;
		selectedTitles = null;
	}

	public void onUnitChanged() {
		selectedUnitGroup = null;
	}

	public void onUnitGroupChanged() {

	}

	public void onTitlesChanged() {

	}

	public List<Titles> getTitlesList() {
		if (selectedDepartment != null) {
			return TitlesLocalServiceUtil
					.findAllByDepartment(selectedDepartment.getDepartmentId());
		}
		return new ArrayList<>();
	}

	public List<UnitGroup> getUnitGroups() {
		return selectedUnit != null ? UnitGroupLocalServiceUtil
				.findByUnit(selectedUnit.getUnitId()) : null;
	}

	public List<Unit> getUnits() {
		final Department empDepartment = selectedDepartment;
		return empDepartment != null ? UnitLocalServiceUtil
				.findByDepartment(empDepartment.getDepartmentId())
				: new ArrayList<Unit>();
	}

	public List<Department> getDepartments() {
		List<Department> departments = selectedDevision != null ? DepartmentLocalServiceUtil
				.findByDevision(selectedDevision.getDevisionId())
				: new ArrayList<Department>();
		if (departments.isEmpty() || !departments.contains(selectedDepartment)) {
			selectedDepartment = null;
		}
		return departments;
	}

	public List<Devision> getDevisions() {
		return DevisionLocalServiceUtil.findAll();
	}

	public List<Level> getLevels() {
		return new ArrayList<>();
	}

	public void setSelectedValuesToEmp(Emp emp) {
		emp.setDepartmentId(EmployeeUtils
				.getBaseModelPrimaryKey(selectedDepartment));
		emp.setUnitId(EmployeeUtils.getBaseModelPrimaryKey(selectedUnit));
		emp.setUnitGroupId(EmployeeUtils
				.getBaseModelPrimaryKey(selectedUnitGroup));
		emp.setTitlesId(EmployeeUtils.getBaseModelPrimaryKey(selectedTitles));
	}

	public void setSelectedValuesFromEmpInfoItem(EmpInfoItem item) {
	}

	public void setSelectedValuesFromEmp(Emp emp) {
		try {
			selectedTitles = TitlesLocalServiceUtil
					.getTitles(emp.getTitlesId());
			selectedUnitGroup = emp.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
					.getUnitGroup(emp.getUnitGroupId()) : null;
			selectedUnit = emp.getUnitId() != 0 ? UnitLocalServiceUtil
					.getUnit(emp.getUnitId()) : null;
			selectedDepartment = emp.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
					.getDepartment(emp.getDepartmentId()) : null;
			selectedDevision = selectedDepartment != null ? DevisionLocalServiceUtil
					.getDevision(selectedDepartment.getDevisionId()) : null;
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}

	public void setSelectedValuesToConcurrentTitles(EmpConcurrentTitles ec) {
		ec.setDepartmentId(EmployeeUtils
				.getBaseModelPrimaryKey(selectedDepartment));
		ec.setUnitId(EmployeeUtils.getBaseModelPrimaryKey(selectedUnit));
		ec.setUnitGroupId(EmployeeUtils
				.getBaseModelPrimaryKey(selectedUnitGroup));
		ec.setTitlesId(EmployeeUtils.getBaseModelPrimaryKey(selectedTitles));
	}

	public Devision getSelectedDevision() {
		return selectedDevision;
	}

	public void setSelectedDevision(Devision selectedDevision) {
		this.selectedDevision = selectedDevision;
	}

	public Department getSelectedDepartment() {
		return selectedDepartment;
	}

	public void setSelectedDepartment(Department selectedDepartment) {
		this.selectedDepartment = selectedDepartment;
	}

	public Unit getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(Unit selectedUnit) {
		this.selectedUnit = selectedUnit;
	}

	public UnitGroup getSelectedUnitGroup() {
		return selectedUnitGroup;
	}

	public void setSelectedUnitGroup(UnitGroup selectedUnitGroup) {
		this.selectedUnitGroup = selectedUnitGroup;
	}

	public Titles getSelectedTitles() {
		return selectedTitles;
	}

	public void setSelectedTitles(Titles selectedTitles) {
		this.selectedTitles = selectedTitles;
	}

	public Level getSelectedLevel() {
		return selectedLevel;
	}

	public void setSelectedLevel(Level selectedLevel) {
		this.selectedLevel = selectedLevel;
	}

	public long getSelectedTitlesId() {
		return EmployeeUtils.getBaseModelPrimaryKey(selectedTitles);
	}

	public long getSelectedDepartmentId() {
		return EmployeeUtils.getBaseModelPrimaryKey(selectedDepartment);
	}

	public long getSelectedUnitGroupId() {
		return EmployeeUtils.getBaseModelPrimaryKey(selectedUnitGroup);
	}

	public long getSelectedUnitId() {
		return EmployeeUtils.getBaseModelPrimaryKey(selectedUnit);
	}

	public List<EmpConcurrentTitles> getConcurrentTitles() {
		return concurrentTitles;
	}

	public void setConcurrentTitles(List<EmpConcurrentTitles> concurrentTitles) {
		this.concurrentTitles = concurrentTitles;
	}

	public String getTitlesName(long titlesId) {
		try {
			return TitlesLocalServiceUtil.fetchTitles(titlesId).getName();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return StringUtils.EMPTY;
	}
}
