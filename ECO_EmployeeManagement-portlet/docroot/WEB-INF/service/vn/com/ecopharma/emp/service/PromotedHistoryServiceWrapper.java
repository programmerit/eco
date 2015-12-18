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
 * Provides a wrapper for {@link PromotedHistoryService}.
 *
 * @author tvt
 * @see PromotedHistoryService
 * @generated
 */
public class PromotedHistoryServiceWrapper implements PromotedHistoryService,
	ServiceWrapper<PromotedHistoryService> {
	public PromotedHistoryServiceWrapper(
		PromotedHistoryService promotedHistoryService) {
		_promotedHistoryService = promotedHistoryService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _promotedHistoryService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_promotedHistoryService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _promotedHistoryService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PromotedHistoryService getWrappedPromotedHistoryService() {
		return _promotedHistoryService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPromotedHistoryService(
		PromotedHistoryService promotedHistoryService) {
		_promotedHistoryService = promotedHistoryService;
	}

	@Override
	public PromotedHistoryService getWrappedService() {
		return _promotedHistoryService;
	}

	@Override
	public void setWrappedService(PromotedHistoryService promotedHistoryService) {
		_promotedHistoryService = promotedHistoryService;
	}

	private PromotedHistoryService _promotedHistoryService;
}