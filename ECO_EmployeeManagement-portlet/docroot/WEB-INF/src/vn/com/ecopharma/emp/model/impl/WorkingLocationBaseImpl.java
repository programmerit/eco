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

package vn.com.ecopharma.emp.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.emp.model.WorkingLocation;
import vn.com.ecopharma.emp.service.WorkingLocationLocalServiceUtil;

/**
 * The extended model base implementation for the WorkingLocation service. Represents a row in the &quot;eco_em_portlet_WorkingLocation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WorkingLocationImpl}.
 * </p>
 *
 * @author tvt
 * @see WorkingLocationImpl
 * @see vn.com.ecopharma.emp.model.WorkingLocation
 * @generated
 */
public abstract class WorkingLocationBaseImpl extends WorkingLocationModelImpl
	implements WorkingLocation {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a working location model instance should use the {@link WorkingLocation} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			WorkingLocationLocalServiceUtil.addWorkingLocation(this);
		}
		else {
			WorkingLocationLocalServiceUtil.updateWorkingLocation(this);
		}
	}
}