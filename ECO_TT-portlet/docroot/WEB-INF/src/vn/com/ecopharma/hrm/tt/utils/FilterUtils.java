package vn.com.ecopharma.hrm.tt.utils;

import java.util.List;
import java.util.Map;

import vn.com.ecopharma.hrm.tt.bean.OrganizationFilter;

public class FilterUtils {
	public static void bindOrgFilters(OrganizationFilter bean,
			Map<String, Object> filters) {
		for (Map.Entry<String, List<String>> entry : bean
				.getOrganizationFilters().entrySet()) {
			if (!entry.getValue().isEmpty())
				filters.put(entry.getKey(), entry.getValue());
		}
	}
}
