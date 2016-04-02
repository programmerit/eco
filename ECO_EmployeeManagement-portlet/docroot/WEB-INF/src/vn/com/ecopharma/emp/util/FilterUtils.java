package vn.com.ecopharma.emp.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.bean.filter.OrganizationFilter;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

public class FilterUtils {

	public static void bindOrgFilters(OrganizationFilter bean,
			Map<String, Object> filters) {
		for (Map.Entry<String, List<String>> entry : bean
				.getOrganizationFilters().entrySet()) {
			if (!entry.getValue().isEmpty())
				filters.put(entry.getKey(), entry.getValue());
		}
		// try {
		// filters.put(EmpField.UNIT, Arrays.asList(UnitLocalServiceUtil
		// .fetchUnit(185324L).getName()));
		// } catch (SystemException e) {
		// e.printStackTrace();
		// }
	}
}
