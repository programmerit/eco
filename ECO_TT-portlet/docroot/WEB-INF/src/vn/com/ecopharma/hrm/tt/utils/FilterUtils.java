package vn.com.ecopharma.hrm.tt.utils;

import java.util.List;
import java.util.Map;

import vn.com.ecopharma.hrm.tt.bean.OrganizationFilter;

public class FilterUtils {

	// public static void bindOrgFilters(OrganizationFilter bean,
	// Map<String, Object> filters) {
	// if (bean == null)
	// return;
	// if (bean.getSelectedDevisions() != null
	// && !bean.getSelectedDevisions().isEmpty()) {
	// filters.put(EmpField.DEVISION, bean.getSelectedDevisions());
	// }
	//
	// if (bean.getSelectedDepartments() != null
	// && !bean.getSelectedDepartments().isEmpty()) {
	// filters.put(EmpField.DEPARTMENT, bean.getSelectedDepartments());
	// }
	//
	// if (bean.getSelectedUnits() != null
	// && !bean.getSelectedUnits().isEmpty()) {
	// filters.put(EmpField.UNIT, bean.getSelectedUnits());
	// }
	//
	// if (bean.getSelectedUnitGroups() != null
	// && !bean.getSelectedUnitGroups().isEmpty()) {
	// filters.put(EmpField.UNIT_GROUP, bean.getSelectedUnitGroups());
	// }
	//
	// if (bean.getSelectedTitlesList() != null
	// && !bean.getSelectedTitlesList().isEmpty()) {
	// filters.put(EmpField.TITLES, bean.getSelectedTitlesList());
	// }
	// }
	public static void bindOrgFilters(OrganizationFilter bean,
			Map<String, Object> filters) {
		for (Map.Entry<String, List<String>> entry : bean
				.getOrganizationFilters().entrySet()) {
			if (!entry.getValue().isEmpty())
				filters.put(entry.getKey(), entry.getValue());
		}
	}
}
