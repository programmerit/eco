package vn.com.ecopharma.hrm.tt.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

public class OrganizationFilterBean implements OrganizationFilter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	public List<String> getFilterBadges() {
		final Set<String> badges = new HashSet<>();
		checkAndAddOrganizationBadges(selectedDevisions, badges);
		checkAndAddOrganizationBadges(selectedDepartments, badges);
		checkAndAddOrganizationBadges(selectedUnits, badges);
		checkAndAddOrganizationBadges(selectedUnitGroups, badges);
		checkAndAddOrganizationBadges(selectedTitlesList, badges);
		return new ArrayList<>(badges);
	}

	public void checkAndAddOrganizationBadges(List<?> orgFilters,
			Collection<String> badges) {
		if (orgFilters != null && !orgFilters.isEmpty()) {
			Object value = orgFilters.get(0);
			if (value instanceof Devision) {
				badges.add("Devision");
				return;
			} else if (value instanceof Department) {
				badges.add("Department");
				return;
			} else if (value instanceof Unit) {
				badges.add("Unit");
				return;
			} else if (value instanceof UnitGroup) {
				badges.add("UnitGroup");
				return;
			} else if (value instanceof Titles) {
				badges.add("Titles");
				return;
			}
		}
	}

	public void onDeleteFilterBadges(int index) {
		String removeValue = getFilterBadges().get(index);
		if ("Devision".equalsIgnoreCase(removeValue)) {
			setSelectedDevisions(new ArrayList<Devision>());
		} else if ("Department".equalsIgnoreCase(removeValue)) {
			setSelectedDepartments(new ArrayList<Department>());
		} else if ("Unit".equalsIgnoreCase(removeValue)) {
			setSelectedUnits(new ArrayList<Unit>());
		} else if ("UnitGroup".equalsIgnoreCase(removeValue)) {
			setSelectedUnitGroups(new ArrayList<UnitGroup>());
		} else if ("Titles".equalsIgnoreCase(removeValue)) {
			setSelectedTitlesList(new ArrayList<Titles>());
		}

		// getFilterBadges().remove(index);
	}
}
