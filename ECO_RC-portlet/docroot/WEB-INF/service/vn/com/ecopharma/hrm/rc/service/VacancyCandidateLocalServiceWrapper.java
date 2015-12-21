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
 * Provides a wrapper for {@link VacancyCandidateLocalService}.
 *
 * @author tvt
 * @see VacancyCandidateLocalService
 * @generated
 */
public class VacancyCandidateLocalServiceWrapper
	implements VacancyCandidateLocalService,
		ServiceWrapper<VacancyCandidateLocalService> {
	public VacancyCandidateLocalServiceWrapper(
		VacancyCandidateLocalService vacancyCandidateLocalService) {
		_vacancyCandidateLocalService = vacancyCandidateLocalService;
	}

	/**
	* Adds the vacancy candidate to the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyCandidate the vacancy candidate
	* @return the vacancy candidate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate addVacancyCandidate(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.addVacancyCandidate(vacancyCandidate);
	}

	/**
	* Creates a new vacancy candidate with the primary key. Does not add the vacancy candidate to the database.
	*
	* @param vacancyCandidateId the primary key for the new vacancy candidate
	* @return the new vacancy candidate
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate createVacancyCandidate(
		long vacancyCandidateId) {
		return _vacancyCandidateLocalService.createVacancyCandidate(vacancyCandidateId);
	}

	/**
	* Deletes the vacancy candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate that was removed
	* @throws PortalException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate deleteVacancyCandidate(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.deleteVacancyCandidate(vacancyCandidateId);
	}

	/**
	* Deletes the vacancy candidate from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyCandidate the vacancy candidate
	* @return the vacancy candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate deleteVacancyCandidate(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.deleteVacancyCandidate(vacancyCandidate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vacancyCandidateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate fetchVacancyCandidate(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.fetchVacancyCandidate(vacancyCandidateId);
	}

	/**
	* Returns the vacancy candidate with the primary key.
	*
	* @param vacancyCandidateId the primary key of the vacancy candidate
	* @return the vacancy candidate
	* @throws PortalException if a vacancy candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate getVacancyCandidate(
		long vacancyCandidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.getVacancyCandidate(vacancyCandidateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vacancy candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancy candidates
	* @param end the upper bound of the range of vacancy candidates (not inclusive)
	* @return the range of vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> getVacancyCandidates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.getVacancyCandidates(start, end);
	}

	/**
	* Returns the number of vacancy candidates.
	*
	* @return the number of vacancy candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVacancyCandidatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.getVacancyCandidatesCount();
	}

	/**
	* Updates the vacancy candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vacancyCandidate the vacancy candidate
	* @return the vacancy candidate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate updateVacancyCandidate(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidateLocalService.updateVacancyCandidate(vacancyCandidate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vacancyCandidateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vacancyCandidateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vacancyCandidateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll() {
		return _vacancyCandidateLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll(
		int start, int end) {
		return _vacancyCandidateLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _vacancyCandidateLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate createPrePersitedVacancyCandidate() {
		return _vacancyCandidateLocalService.createPrePersitedVacancyCandidate();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate addVacancyCandidate(
		long vacancyId, long candidateId, int status) {
		return _vacancyCandidateLocalService.addVacancyCandidate(vacancyId,
			candidateId, status);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate addVacancyCandidate(
		long vacancyId, long candidateId, java.lang.String type) {
		return _vacancyCandidateLocalService.addVacancyCandidate(vacancyId,
			candidateId, type);
	}

	@Override
	public void setInActivatedByCandidate(long candidateId) {
		_vacancyCandidateLocalService.setInActivatedByCandidate(candidateId);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByVacancyAndCandidate(
		long vacancyId, long candidateId) {
		return _vacancyCandidateLocalService.findByVacancyAndCandidate(vacancyId,
			candidateId);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate findByCandidateAndActiveStatus(
		long candidateId) {
		return _vacancyCandidateLocalService.findByCandidateAndActiveStatus(candidateId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByVacancy(
		long vacancyId) {
		return _vacancyCandidateLocalService.findByVacancy(vacancyId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidate(
		long candidateId) {
		return _vacancyCandidateLocalService.findByCandidate(candidateId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> findByCandidateAndType(
		long candidateId, java.lang.String type) {
		return _vacancyCandidateLocalService.findByCandidateAndType(candidateId,
			type);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VacancyCandidateLocalService getWrappedVacancyCandidateLocalService() {
		return _vacancyCandidateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVacancyCandidateLocalService(
		VacancyCandidateLocalService vacancyCandidateLocalService) {
		_vacancyCandidateLocalService = vacancyCandidateLocalService;
	}

	@Override
	public VacancyCandidateLocalService getWrappedService() {
		return _vacancyCandidateLocalService;
	}

	@Override
	public void setWrappedService(
		VacancyCandidateLocalService vacancyCandidateLocalService) {
		_vacancyCandidateLocalService = vacancyCandidateLocalService;
	}

	private VacancyCandidateLocalService _vacancyCandidateLocalService;
}