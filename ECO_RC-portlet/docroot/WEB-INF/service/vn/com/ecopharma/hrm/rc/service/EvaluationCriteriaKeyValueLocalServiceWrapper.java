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
 * Provides a wrapper for {@link EvaluationCriteriaKeyValueLocalService}.
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValueLocalService
 * @generated
 */
public class EvaluationCriteriaKeyValueLocalServiceWrapper
	implements EvaluationCriteriaKeyValueLocalService,
		ServiceWrapper<EvaluationCriteriaKeyValueLocalService> {
	public EvaluationCriteriaKeyValueLocalServiceWrapper(
		EvaluationCriteriaKeyValueLocalService evaluationCriteriaKeyValueLocalService) {
		_evaluationCriteriaKeyValueLocalService = evaluationCriteriaKeyValueLocalService;
	}

	/**
	* Adds the evaluation criteria key value to the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	* @return the evaluation criteria key value that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue addEvaluationCriteriaKeyValue(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.addEvaluationCriteriaKeyValue(evaluationCriteriaKeyValue);
	}

	/**
	* Creates a new evaluation criteria key value with the primary key. Does not add the evaluation criteria key value to the database.
	*
	* @param evaluationCriteriaKeyValueId the primary key for the new evaluation criteria key value
	* @return the new evaluation criteria key value
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue createEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId) {
		return _evaluationCriteriaKeyValueLocalService.createEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	/**
	* Deletes the evaluation criteria key value with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value that was removed
	* @throws PortalException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue deleteEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.deleteEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	/**
	* Deletes the evaluation criteria key value from the database. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	* @return the evaluation criteria key value that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue deleteEvaluationCriteriaKeyValue(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.deleteEvaluationCriteriaKeyValue(evaluationCriteriaKeyValue);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _evaluationCriteriaKeyValueLocalService.dynamicQuery();
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
		return _evaluationCriteriaKeyValueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _evaluationCriteriaKeyValueLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _evaluationCriteriaKeyValueLocalService.dynamicQuery(dynamicQuery,
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
		return _evaluationCriteriaKeyValueLocalService.dynamicQueryCount(dynamicQuery);
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
		return _evaluationCriteriaKeyValueLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue fetchEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.fetchEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	/**
	* Returns the evaluation criteria key value with the primary key.
	*
	* @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	* @return the evaluation criteria key value
	* @throws PortalException if a evaluation criteria key value with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue getEvaluationCriteriaKeyValue(
		long evaluationCriteriaKeyValueId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.getEvaluationCriteriaKeyValue(evaluationCriteriaKeyValueId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the evaluation criteria key values.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of evaluation criteria key values
	* @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	* @return the range of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> getEvaluationCriteriaKeyValues(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.getEvaluationCriteriaKeyValues(start,
			end);
	}

	/**
	* Returns the number of evaluation criteria key values.
	*
	* @return the number of evaluation criteria key values
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEvaluationCriteriaKeyValuesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.getEvaluationCriteriaKeyValuesCount();
	}

	/**
	* Updates the evaluation criteria key value in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param evaluationCriteriaKeyValue the evaluation criteria key value
	* @return the evaluation criteria key value that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue updateEvaluationCriteriaKeyValue(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValueLocalService.updateEvaluationCriteriaKeyValue(evaluationCriteriaKeyValue);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _evaluationCriteriaKeyValueLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_evaluationCriteriaKeyValueLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _evaluationCriteriaKeyValueLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue addEvaluationCriteriaKeyValue(
		long evaluationCriteriaId, java.lang.String key, int value,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _evaluationCriteriaKeyValueLocalService.addEvaluationCriteriaKeyValue(evaluationCriteriaId,
			key, value, serviceContext);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId) {
		return _evaluationCriteriaKeyValueLocalService.findByEvaluationCriteria(evaluationCriteriaId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> findByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, java.lang.String key) {
		return _evaluationCriteriaKeyValueLocalService.findByEvaluationCriteriaAndKey(evaluationCriteriaId,
			key);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EvaluationCriteriaKeyValueLocalService getWrappedEvaluationCriteriaKeyValueLocalService() {
		return _evaluationCriteriaKeyValueLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEvaluationCriteriaKeyValueLocalService(
		EvaluationCriteriaKeyValueLocalService evaluationCriteriaKeyValueLocalService) {
		_evaluationCriteriaKeyValueLocalService = evaluationCriteriaKeyValueLocalService;
	}

	@Override
	public EvaluationCriteriaKeyValueLocalService getWrappedService() {
		return _evaluationCriteriaKeyValueLocalService;
	}

	@Override
	public void setWrappedService(
		EvaluationCriteriaKeyValueLocalService evaluationCriteriaKeyValueLocalService) {
		_evaluationCriteriaKeyValueLocalService = evaluationCriteriaKeyValueLocalService;
	}

	private EvaluationCriteriaKeyValueLocalService _evaluationCriteriaKeyValueLocalService;
}