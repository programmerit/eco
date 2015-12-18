/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package vn.com.ecopharma.emp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author tvt
 */
public class EmployeeFinderUtil {
	public static java.util.List<vn.com.ecopharma.emp.model.Employee> findByName(
		java.lang.String name, int start, int end) {
		return getFinder().findByName(name, start, end);
	}

	public static java.util.List<java.lang.Object[]> findEmployeeObjectsByName(
		java.lang.String name, int start, int end) {
		return getFinder().findEmployeeObjectsByName(name, start, end);
	}

	public static EmployeeFinder getFinder() {
		if (_finder == null) {
			_finder = (EmployeeFinder)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmployeeFinder.class.getName());

			ReferenceRegistry.registerReference(EmployeeFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(EmployeeFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(EmployeeFinderUtil.class, "_finder");
	}

	private static EmployeeFinder _finder;
}