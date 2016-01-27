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

import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;

/**
 * The extended model base implementation for the EmpDiscipline service. Represents a row in the &quot;eco_em_portlet_EmpDiscipline&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmpDisciplineImpl}.
 * </p>
 *
 * @author tvt
 * @see EmpDisciplineImpl
 * @see vn.com.ecopharma.emp.model.EmpDiscipline
 * @generated
 */
public abstract class EmpDisciplineBaseImpl extends EmpDisciplineModelImpl
	implements EmpDiscipline {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a emp discipline model instance should use the {@link EmpDiscipline} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpDisciplineLocalServiceUtil.addEmpDiscipline(this);
		}
		else {
			EmpDisciplineLocalServiceUtil.updateEmpDiscipline(this);
		}
	}
}