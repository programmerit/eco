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
 * Provides a wrapper for {@link VacancyEvaluationCriteriaLocalService}.
 *
 * @author tvt
 * @see VacancyEvaluationCriteriaLocalService
 * @generated
 */
public class VacancyEvaluationCriteriaLocalServiceWrapper
	implements VacancyEvaluationCriteriaLocalService,
		ServiceWrapper<VacancyEvaluationCriteriaLocalService> {
	public VacancyEvaluationCriteriaLocalServiceWrapper(
		VacancyEvaluationCriteriaLocalService vacancyEvaluationCriteriaLocalService) {
		_vacancyEvaluationCriteriaLocalService = vacancyEvaluationCriteriaLocalService;
	}

	/**
	* Adds the vacancy evaluation criteria to the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyEvaluationCriteria the vacancy evaluation criteria
	* @return the vacancy evaluation criteria that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria addVacancyEvaluationCriteria(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.addVacancyEvaluationCriteria(vacancyEvaluationCriteria);
	}

	/**
	* Creates a new vacancy evaluation criteria with the primary key. Does not add the vacancy evaluation criteria to the database.
	*
	* @param vacancyEvaluationCriteriaId the primary key for the new vacancy evaluation criteria
	* @return the new vacancy evaluation criteria
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria createVacancyEvaluationCriteria(
		long vacancyEvaluationCriteriaId) {
		return _vacancyEvaluationCriteriaLocalService.createVacancyEvaluationCriteria(vacancyEvaluationCriteriaId);
	}

	/**
	* Deletes the vacancy evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria that was removed
	* @throws PortalException if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria deleteVacancyEvaluationCriteria(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.deleteVacancyEvaluationCriteria(vacancyEvaluationCriteriaId);
	}

	/**
	* Deletes the vacancy evaluation criteria from the database. Also notifies the appropriate model listeners.
	*
	* @param vacancyEvaluationCriteria the vacancy evaluation criteria
	* @return the vacancy evaluation criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria deleteVacancyEvaluationCriteria(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.deleteVacancyEvaluationCriteria(vacancyEvaluationCriteria);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vacancyEvaluationCriteriaLocalService.dynamicQuery();
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
		return _vacancyEvaluationCriteriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vacancyEvaluationCriteriaLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vacancyEvaluationCriteriaLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _vacancyEvaluationCriteriaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vacancyEvaluationCriteriaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria fetchVacancyEvaluationCriteria(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.fetchVacancyEvaluationCriteria(vacancyEvaluationCriteriaId);
	}

	/**
	* Returns the vacancy evaluation criteria with the primary key.
	*
	* @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	* @return the vacancy evaluation criteria
	* @throws PortalException if a vacancy evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria getVacancyEvaluationCriteria(
		long vacancyEvaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.getVacancyEvaluationCriteria(vacancyEvaluationCriteriaId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vacancy evaluation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacancy evaluation criterias
	* @param end the upper bound of the range of vacancy evaluation criterias (not inclusive)
	* @return the range of vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> getVacancyEvaluationCriterias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.getVacancyEvaluationCriterias(start,
			end);
	}

	/**
	* Returns the number of vacancy evaluation criterias.
	*
	* @return the number of vacancy evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVacancyEvaluationCriteriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.getVacancyEvaluationCriteriasCount();
	}

	/**
	* Updates the vacancy evaluation criteria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vacancyEvaluationCriteria the vacancy evaluation criteria
	* @return the vacancy evaluation criteria that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria updateVacancyEvaluationCriteria(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteriaLocalService.updateVacancyEvaluationCriteria(vacancyEvaluationCriteria);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vacancyEvaluationCriteriaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vacancyEvaluationCriteriaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vacancyEvaluationCriteriaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VacancyEvaluationCriteriaLocalService getWrappedVacancyEvaluationCriteriaLocalService() {
		return _vacancyEvaluationCriteriaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVacancyEvaluationCriteriaLocalService(
		VacancyEvaluationCriteriaLocalService vacancyEvaluationCriteriaLocalService) {
		_vacancyEvaluationCriteriaLocalService = vacancyEvaluationCriteriaLocalService;
	}

	@Override
	public VacancyEvaluationCriteriaLocalService getWrappedService() {
		return _vacancyEvaluationCriteriaLocalService;
	}

	@Override
	public void setWrappedService(
		VacancyEvaluationCriteriaLocalService vacancyEvaluationCriteriaLocalService) {
		_vacancyEvaluationCriteriaLocalService = vacancyEvaluationCriteriaLocalService;
	}

	private VacancyEvaluationCriteriaLocalService _vacancyEvaluationCriteriaLocalService;
}