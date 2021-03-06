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

package vn.com.ecopharma.hrm.rc.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

/**
 * The extended model base implementation for the Vacancy service. Represents a row in the &quot;eco_rcp_Vacancy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VacancyImpl}.
 * </p>
 *
 * @author tvt
 * @see VacancyImpl
 * @see vn.com.ecopharma.hrm.rc.model.Vacancy
 * @generated
 */
public abstract class VacancyBaseImpl extends VacancyModelImpl
	implements Vacancy {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vacancy model instance should use the {@link Vacancy} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VacancyLocalServiceUtil.addVacancy(this);
		}
		else {
			VacancyLocalServiceUtil.updateVacancy(this);
		}
	}
}