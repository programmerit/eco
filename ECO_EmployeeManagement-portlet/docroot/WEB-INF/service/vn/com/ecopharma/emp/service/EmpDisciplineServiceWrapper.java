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

package vn.com.ecopharma.emp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmpDisciplineService}.
 *
 * @author tvt
 * @see EmpDisciplineService
 * @generated
 */
public class EmpDisciplineServiceWrapper implements EmpDisciplineService,
	ServiceWrapper<EmpDisciplineService> {
	public EmpDisciplineServiceWrapper(
		EmpDisciplineService empDisciplineService) {
		_empDisciplineService = empDisciplineService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empDisciplineService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empDisciplineService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empDisciplineService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpDisciplineService getWrappedEmpDisciplineService() {
		return _empDisciplineService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpDisciplineService(
		EmpDisciplineService empDisciplineService) {
		_empDisciplineService = empDisciplineService;
	}

	@Override
	public EmpDisciplineService getWrappedService() {
		return _empDisciplineService;
	}

	@Override
	public void setWrappedService(EmpDisciplineService empDisciplineService) {
		_empDisciplineService = empDisciplineService;
	}

	private EmpDisciplineService _empDisciplineService;
}