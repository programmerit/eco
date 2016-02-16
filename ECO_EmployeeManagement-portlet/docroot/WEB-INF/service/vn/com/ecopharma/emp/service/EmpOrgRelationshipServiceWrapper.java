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
 * Provides a wrapper for {@link EmpOrgRelationshipService}.
 *
 * @author tvt
 * @see EmpOrgRelationshipService
 * @generated
 */
public class EmpOrgRelationshipServiceWrapper
	implements EmpOrgRelationshipService,
		ServiceWrapper<EmpOrgRelationshipService> {
	public EmpOrgRelationshipServiceWrapper(
		EmpOrgRelationshipService empOrgRelationshipService) {
		_empOrgRelationshipService = empOrgRelationshipService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empOrgRelationshipService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empOrgRelationshipService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empOrgRelationshipService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpOrgRelationshipService getWrappedEmpOrgRelationshipService() {
		return _empOrgRelationshipService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpOrgRelationshipService(
		EmpOrgRelationshipService empOrgRelationshipService) {
		_empOrgRelationshipService = empOrgRelationshipService;
	}

	@Override
	public EmpOrgRelationshipService getWrappedService() {
		return _empOrgRelationshipService;
	}

	@Override
	public void setWrappedService(
		EmpOrgRelationshipService empOrgRelationshipService) {
		_empOrgRelationshipService = empOrgRelationshipService;
	}

	private EmpOrgRelationshipService _empOrgRelationshipService;
}