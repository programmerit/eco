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
 * Provides a wrapper for {@link TitlesUnitUnitGroupService}.
 *
 * @author tvt
 * @see TitlesUnitUnitGroupService
 * @generated
 */
public class TitlesUnitUnitGroupServiceWrapper
	implements TitlesUnitUnitGroupService,
		ServiceWrapper<TitlesUnitUnitGroupService> {
	public TitlesUnitUnitGroupServiceWrapper(
		TitlesUnitUnitGroupService titlesUnitUnitGroupService) {
		_titlesUnitUnitGroupService = titlesUnitUnitGroupService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _titlesUnitUnitGroupService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_titlesUnitUnitGroupService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _titlesUnitUnitGroupService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TitlesUnitUnitGroupService getWrappedTitlesUnitUnitGroupService() {
		return _titlesUnitUnitGroupService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTitlesUnitUnitGroupService(
		TitlesUnitUnitGroupService titlesUnitUnitGroupService) {
		_titlesUnitUnitGroupService = titlesUnitUnitGroupService;
	}

	@Override
	public TitlesUnitUnitGroupService getWrappedService() {
		return _titlesUnitUnitGroupService;
	}

	@Override
	public void setWrappedService(
		TitlesUnitUnitGroupService titlesUnitUnitGroupService) {
		_titlesUnitUnitGroupService = titlesUnitUnitGroupService;
	}

	private TitlesUnitUnitGroupService _titlesUnitUnitGroupService;
}