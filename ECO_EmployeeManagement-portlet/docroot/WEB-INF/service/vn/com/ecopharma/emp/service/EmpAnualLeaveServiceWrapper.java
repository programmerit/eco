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
 * Provides a wrapper for {@link EmpAnualLeaveService}.
 *
 * @author tvt
 * @see EmpAnualLeaveService
 * @generated
 */
public class EmpAnualLeaveServiceWrapper implements EmpAnualLeaveService,
	ServiceWrapper<EmpAnualLeaveService> {
	public EmpAnualLeaveServiceWrapper(
		EmpAnualLeaveService empAnualLeaveService) {
		_empAnualLeaveService = empAnualLeaveService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empAnualLeaveService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empAnualLeaveService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empAnualLeaveService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpAnualLeaveService getWrappedEmpAnualLeaveService() {
		return _empAnualLeaveService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpAnualLeaveService(
		EmpAnualLeaveService empAnualLeaveService) {
		_empAnualLeaveService = empAnualLeaveService;
	}

	@Override
	public EmpAnualLeaveService getWrappedService() {
		return _empAnualLeaveService;
	}

	@Override
	public void setWrappedService(EmpAnualLeaveService empAnualLeaveService) {
		_empAnualLeaveService = empAnualLeaveService;
	}

	private EmpAnualLeaveService _empAnualLeaveService;
}