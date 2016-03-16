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
 * Provides a wrapper for {@link EvaluationCriteriaLocalService}.
 *
 * @author tvt
 * @see EvaluationCriteriaLocalService
 * @generated
 */
public class EvaluationCriteriaLocalServiceWrapper
	implements EvaluationCriteriaLocalService,
		ServiceWrapper<EvaluationCriteriaLocalService> {
	public EvaluationCriteriaLocalServiceWrapper(
		EvaluationCriteriaLocalService evaluationCriteriaLocalService) {
		_evaluationCriteriaLocalService = evaluationCriteriaLocalService;
	}

	/**
	* Adds the evaluation criteria to the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteria the evaluation criteria
	* @return the evaluation criteria that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria addEvaluationCriteria(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.addEvaluationCriteria(evaluationCriteria);
	}

	/**
	* Creates a new evaluation criteria with the primary key. Does not add the evaluation criteria to the database.
	*
	* @param evaluationCriteriaId the primary key for the new evaluation criteria
	* @return the new evaluation criteria
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria createEvaluationCriteria(
		long evaluationCriteriaId) {
		return _evaluationCriteriaLocalService.createEvaluationCriteria(evaluationCriteriaId);
	}

	/**
	* Deletes the evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria that was removed
	* @throws PortalException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria deleteEvaluationCriteria(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.deleteEvaluationCriteria(evaluationCriteriaId);
	}

	/**
	* Deletes the evaluation criteria from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteria the evaluation criteria
	* @return the evaluation criteria that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria deleteEvaluationCriteria(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.deleteEvaluationCriteria(evaluationCriteria);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _evaluationCriteriaLocalService.dynamicQuery();
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
		return _evaluationCriteriaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _evaluationCriteriaLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _evaluationCriteriaLocalService.dynamicQuery(dynamicQuery,
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
		return _evaluationCriteriaLocalService.dynamicQueryCount(dynamicQuery);
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
		return _evaluationCriteriaLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria fetchEvaluationCriteria(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.fetchEvaluationCriteria(evaluationCriteriaId);
	}

	/**
	* Returns the evaluation criteria with the primary key.
	*
	* @param evaluationCriteriaId the primary key of the evaluation criteria
	* @return the evaluation criteria
	* @throws PortalException if a evaluation criteria with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria getEvaluationCriteria(
		long evaluationCriteriaId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.getEvaluationCriteria(evaluationCriteriaId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the evaluation criterias.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criterias
	* @param end the upper bound of the range of evaluation criterias (not inclusive)
	* @return the range of evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> getEvaluationCriterias(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.getEvaluationCriterias(start, end);
	}

	/**
	* Returns the number of evaluation criterias.
	*
	* @return the number of evaluation criterias
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEvaluationCriteriasCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.getEvaluationCriteriasCount();
	}

	/**
	* Updates the evaluation criteria in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteria the evaluation criteria
	* @return the evaluation criteria that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria updateEvaluationCriteria(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaLocalService.updateEvaluationCriteria(evaluationCriteria);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _evaluationCriteriaLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_evaluationCriteriaLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _evaluationCriteriaLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll() {
		return _evaluationCriteriaLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll(
		int start, int end) {
		return _evaluationCriteriaLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _evaluationCriteriaLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> findByType(
		java.lang.String type) {
		return _evaluationCriteriaLocalService.findByType(type);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria findByNameAndType(
		java.lang.String name, java.lang.String type) {
		return _evaluationCriteriaLocalService.findByNameAndType(name, type);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria createPrePersistedEntity() {
		return _evaluationCriteriaLocalService.createPrePersistedEntity();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria addEvaluationCriteria(
		java.lang.String type, java.lang.String name,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _evaluationCriteriaLocalService.addEvaluationCriteria(type,
			name, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EvaluationCriteriaLocalService getWrappedEvaluationCriteriaLocalService() {
		return _evaluationCriteriaLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEvaluationCriteriaLocalService(
		EvaluationCriteriaLocalService evaluationCriteriaLocalService) {
		_evaluationCriteriaLocalService = evaluationCriteriaLocalService;
	}

	@Override
	public EvaluationCriteriaLocalService getWrappedService() {
		return _evaluationCriteriaLocalService;
	}

	@Override
	public void setWrappedService(
		EvaluationCriteriaLocalService evaluationCriteriaLocalService) {
		_evaluationCriteriaLocalService = evaluationCriteriaLocalService;
	}

	private EvaluationCriteriaLocalService _evaluationCriteriaLocalService;
}