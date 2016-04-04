package vn.com.ecopharma.emp.bean.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedProperty;

import vn.com.ecopharma.emp.bean.global.AuthorityBean;
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
import vn.com.ecopharma.emp.util.BeanUtils;

public class OrganizationFilterBean implements OrganizationFilter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Devision> selectedDevisions;
	private List<Department> selectedDepartments;
	private List<Unit> selectedUnits;
	private List<UnitGroup> selectedUnitGroups;
	private List<Titles> selectedTitlesList;

	@ManagedProperty(value = "#{authorityBean}")
	private AuthorityBean authorityBean;

	public void init() {
		selectedDevisions = new ArrayList<>();
		selectedDepartments = new ArrayList<>();
		selectedUnits = new ArrayList<>();
		selectedUnitGroups = new ArrayList<>();
		selectedTitlesList = new ArrayList<>();
		bindFieldsByAuthorities();
	}

	public void bindFieldsByAuthorities() {
		final AuthorityBean authorityBean = (AuthorityBean) BeanUtils
				.getBackingBeanByName("authorityBean");

		for (Devision devision : DevisionLocalServiceUtil.findAll()) {
			if (authorityBean.getSearchableDevisionIds().contains(
					devision.getDevisionId())
					&& !selectedDevisions.contains(devision))
				selectedDevisions.add(devision);
		}

		for (Department department : DepartmentLocalServiceUtil
				.findByDevisions(selectedDevisions)) {
			if (authorityBean.getSearchableDepartmentIds().contains(
					department.getDepartmentId())
					&& !selectedDepartments.contains(department))
				selectedDepartments.add(department);
		}

		for (Unit unit : UnitLocalServiceUtil
				.findByDepartments(selectedDepartments)) {
			selectedUnits.add(unit);
		}

	}

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
		final List<Unit> unitsByDepartments = UnitLocalServiceUtil
				.findByDepartments(selectedDepartments);
		if (BeanUtils.getEmpModelPermission().isHrPermission())
			return unitsByDepartments;
		final List<Unit> result = new ArrayList<>();
		for (Unit unit : unitsByDepartments)
			if (authorityBean.getSearchableUnitIds().contains(unit.getUnitId()))
				result.add(unit);
		return result;
	}

	public List<UnitGroup> getUnitGroups() {
		return UnitGroupLocalServiceUtil.findByUnits(selectedUnits);
	}

	public List<Department> getDepartments() {
		final List<Department> departmentsByDevisions = DepartmentLocalServiceUtil
				.findByDevisions(selectedDevisions);
		if (BeanUtils.getEmpModelPermission().isHrPermission())
			return departmentsByDevisions;
		final List<Department> result = new ArrayList<>();
		for (Department department : departmentsByDevisions) {
			if (authorityBean.getSearchableDepartmentIds().contains(
					department.getDepartmentId()))
				result.add(department);
		}
		return result;
	}

	public List<Devision> getDevisions() {
		final List<Devision> allDevisions = DevisionLocalServiceUtil.findAll();
		if (BeanUtils.getEmpModelPermission().isHrPermission())
			return allDevisions;

		final List<Devision> result = new ArrayList<>();

		for (Devision dev : allDevisions)
			if (authorityBean.getSearchableDevisionIds().contains(
					dev.getDevisionId()))
				result.add(dev);
		return result;
	}

	public List<Titles> getTitlesList() {
		return TitlesLocalServiceUtil.findFilterListByRelatedFields(
				selectedDepartments, selectedUnits, selectedUnitGroups);
	}

	public List<String> getSelectedDevisionStrings() {
		final List<String> result = new ArrayList<>();
		for (Devision devision : selectedDevisions) {
			result.add(devision.getName());
		}
		return result;
	}

	public List<String> getSelectedDepartmentStrings() {
		final List<String> result = new ArrayList<>();
		for (Department department : selectedDepartments) {
			result.add(department.getName());
		}
		return result;
	}

	public List<String> getSelectedUnitStrings() {
		final List<String> result = new ArrayList<>();
		for (Unit unit : selectedUnits) {
			result.add(unit.getName());
		}
		return result;
	}

	public List<String> getSelectedUnitGroupStrings() {
		final List<String> result = new ArrayList<>();
		for (UnitGroup unitGroup : selectedUnitGroups) {
			result.add(unitGroup.getName());
		}
		return result;
	}

	public List<String> getSelectedTitlesListStrings() {
		final List<String> result = new ArrayList<>();
		for (Titles titles : selectedTitlesList) {
			result.add(titles.getName());
		}
		return result;
	}

	public Map<String, List<String>> getOrganizationFilters() {
		final Map<String, List<String>> map = new HashMap<>();
		map.put(EmpField.DEVISION, getSelectedDevisionStrings());
		map.put(EmpField.DEPARTMENT, getSelectedDepartmentStrings());
		map.put(EmpField.UNIT, getSelectedUnitStrings());
		map.put(EmpField.UNIT_GROUP, getSelectedUnitGroupStrings());
		map.put(EmpField.TITLES, getSelectedTitlesListStrings());
		return map;
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

	public AuthorityBean getAuthorityBean() {
		return authorityBean;
	}

	public void setAuthorityBean(AuthorityBean authorityBean) {
		this.authorityBean = authorityBean;
	}

}
