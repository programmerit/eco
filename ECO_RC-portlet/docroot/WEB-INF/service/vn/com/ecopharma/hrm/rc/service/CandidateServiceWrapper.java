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

package vn.com.ecopharma.hrm.rc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CandidateService}.
 *
 * @author tvt
 * @see CandidateService
 * @generated
 */
public class CandidateServiceWrapper implements CandidateService,
	ServiceWrapper<CandidateService> {
	public CandidateServiceWrapper(CandidateService candidateService) {
		_candidateService = candidateService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _candidateService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_candidateService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _candidateService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll() {
		return _candidateService.findAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CandidateService getWrappedCandidateService() {
		return _candidateService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCandidateService(CandidateService candidateService) {
		_candidateService = candidateService;
	}

	@Override
	public CandidateService getWrappedService() {
		return _candidateService;
	}

	@Override
	public void setWrappedService(CandidateService candidateService) {
		_candidateService = candidateService;
	}

	private CandidateService _candidateService;
}