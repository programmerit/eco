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
public class TitlesFinderUtil {
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findNoneUnitUnitGroupDependentTitlesListByDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findNoneUnitUnitGroupDependentTitlesListByDepartment(departmentId,
			start, end);
	}

	public static TitlesFinder getFinder() {
		if (_finder == null) {
			_finder = (TitlesFinder)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					TitlesFinder.class.getName());

			ReferenceRegistry.registerReference(TitlesFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TitlesFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TitlesFinderUtil.class, "_finder");
	}

	private static TitlesFinder _finder;
}