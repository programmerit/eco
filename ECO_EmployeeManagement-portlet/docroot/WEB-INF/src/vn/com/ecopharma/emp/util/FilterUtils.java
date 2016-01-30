package vn.com.ecopharma.emp.util;

import java.util.Map;

import vn.com.ecopharma.emp.bean.filter.OrganizationFilter;
import vn.com.ecopharma.emp.constant.EmpField;

public class FilterUtils {

	public static void bindOrgFilters(OrganizationFilter bean,
			Map<String, Object> filters) {
		if (bean.getSelectedDevisions() != null
				&& !bean.getSelectedDevisions().isEmpty()) {
			filters.put(EmpField.DEVISION, bean.getSelectedDevisions());
		}

		if (bean.getSelectedDepartments() != null
				&& !bean.getSelectedDepartments().isEmpty()) {
			filters.put(EmpField.DEPARTMENT, bean.getSelectedDepartments());
		}

		if (bean.getSelectedUnits() != null
				&& !bean.getSelectedUnits().isEmpty()) {
			filters.put(EmpField.UNIT, bean.getSelectedUnits());
		}

		if (bean.getSelectedUnitGroups() != null
				&& !bean.getSelectedUnitGroups().isEmpty()) {
			filters.put(EmpField.UNIT_GROUP, bean.getSelectedUnitGroups());
		}

		if (bean.getSelectedTitlesList() != null
				&& !bean.getSelectedTitlesList().isEmpty()) {
			filters.put(EmpField.TITLES, bean.getSelectedTitlesList());
		}
	}
}
