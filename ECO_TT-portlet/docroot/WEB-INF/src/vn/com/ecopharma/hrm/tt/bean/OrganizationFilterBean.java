package vn.com.ecopharma.hrm.tt.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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

@ManagedBean(name = "organizationFilterBean")
@ViewScoped
public class OrganizationFilterBean {
	private List<Devision> selectedDevisions = new ArrayList<>();
	private List<Department> selectedDepartments = new ArrayList<>();
	private List<Unit> selectedUnits = new ArrayList<>();
	private List<UnitGroup> selectedUnitGroups = new ArrayList<>();
	private List<Titles> selectedTitlesList = new ArrayList<>();

	public void onDevisionChanged() {
		this.selectedDepartments = new ArrayList<>();
		this.selectedUnits = new ArrayList<>();
		this.selectedUnitGroups = new ArrayList<>();
		this.selectedTitlesList = new ArrayList<>();
	}

	public void onDepartmentChanged() {
		this.selectedUnits = new ArrayList<>();
		this.selectedUnitGroups = new ArrayList<>();
		this.selectedTitlesList = new ArrayList<>();
	}

	public void onUnitChanged() {
		this.selectedUnitGroups = new ArrayList<>();
		this.selectedTitlesList = new ArrayList<>();
	}

	public void onUnitGroupChanged() {
		this.selectedTitlesList = new ArrayList<>();
	}

	public List<Unit> getUnits() {
		return UnitLocalServiceUtil.findByDepartments(selectedDepartments);
	}

	public List<UnitGroup> getUnitGroups() {
		return UnitGroupLocalServiceUtil.findByUnits(selectedUnits);
	}

	public List<Department> getDepartments() {
		return DepartmentLocalServiceUtil.findByDevisions(selectedDevisions);
	}

	public List<Devision> getDevisions() {
		return DevisionLocalServiceUtil.findAll();
	}

	public List<Titles> getTitlesList() {
		return TitlesLocalServiceUtil.findFilterListByRelatedFields(
				selectedDepartments, selectedUnits, selectedUnitGroups);
	}

	public List<Devision> getSelectedDevisions() {
		return selectedDevisions;
	}

	public void setSelectedDevisions(List<Devision> selectedDevisions) {
		this.selectedDevisions = selectedDevisions;
	}

	public List<Department> getSelectedDepartments() {
		return selectedDepartments;
	}

	public void setSelectedDepartments(List<Department> selectedDepartments) {
		this.selectedDepartments = selectedDepartments;
	}

	public List<Unit> getSelectedUnits() {
		return selectedUnits;
	}

	public void setSelectedUnits(List<Unit> selectedUnits) {
		this.selectedUnits = selectedUnits;
	}

	public List<UnitGroup> getSelectedUnitGroups() {
		return selectedUnitGroups;
	}

	public void setSelectedUnitGroups(List<UnitGroup> selectedUnitGroups) {
		this.selectedUnitGroups = selectedUnitGroups;
	}

	public List<Titles> getSelectedTitlesList() {
		return selectedTitlesList;
	}

	public void setSelectedTitlesList(List<Titles> selectedTitlesList) {
		this.selectedTitlesList = selectedTitlesList;
	}
}
