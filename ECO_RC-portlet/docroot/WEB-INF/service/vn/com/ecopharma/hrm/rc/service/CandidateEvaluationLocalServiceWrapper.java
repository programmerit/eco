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
 * Provides a wrapper for {@link CandidateEvaluationLocalService}.
 *
 * @author tvt
 * @see CandidateEvaluationLocalService
 * @generated
 */
public class CandidateEvaluationLocalServiceWrapper
	implements CandidateEvaluationLocalService,
		ServiceWrapper<CandidateEvaluationLocalService> {
	public CandidateEvaluationLocalServiceWrapper(
		CandidateEvaluationLocalService candidateEvaluationLocalService) {
		_candidateEvaluationLocalService = candidateEvaluationLocalService;
	}

	/**
	* Adds the candidate evaluation to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluation the candidate evaluation
	* @return the candidate evaluation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation addCandidateEvaluation(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.addCandidateEvaluation(candidateEvaluation);
	}

	/**
	* Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	*
	* @param candidateEvaluationId the primary key for the new candidate evaluation
	* @return the new candidate evaluation
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation createCandidateEvaluation(
		long candidateEvaluationId) {
		return _candidateEvaluationLocalService.createCandidateEvaluation(candidateEvaluationId);
	}

	/**
	* Deletes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation that was removed
	* @throws PortalException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation deleteCandidateEvaluation(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.deleteCandidateEvaluation(candidateEvaluationId);
	}

	/**
	* Deletes the candidate evaluation from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluation the candidate evaluation
	* @return the candidate evaluation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation deleteCandidateEvaluation(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.deleteCandidateEvaluation(candidateEvaluation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateEvaluationLocalService.dynamicQuery();
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
		return _candidateEvaluationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateEvaluationLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateEvaluationLocalService.dynamicQuery(dynamicQuery,
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
		return _candidateEvaluationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateEvaluationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation fetchCandidateEvaluation(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.fetchCandidateEvaluation(candidateEvaluationId);
	}

	/**
	* Returns the candidate evaluation with the primary key.
	*
	* @param candidateEvaluationId the primary key of the candidate evaluation
	* @return the candidate evaluation
	* @throws PortalException if a candidate evaluation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation getCandidateEvaluation(
		long candidateEvaluationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.getCandidateEvaluation(candidateEvaluationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the candidate evaluations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate evaluations
	* @param end the upper bound of the range of candidate evaluations (not inclusive)
	* @return the range of candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> getCandidateEvaluations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.getCandidateEvaluations(start,
			end);
	}

	/**
	* Returns the number of candidate evaluations.
	*
	* @return the number of candidate evaluations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCandidateEvaluationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.getCandidateEvaluationsCount();
	}

	/**
	* Updates the candidate evaluation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateEvaluation the candidate evaluation
	* @return the candidate evaluation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation updateCandidateEvaluation(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluationLocalService.updateCandidateEvaluation(candidateEvaluation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _candidateEvaluationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_candidateEvaluationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _candidateEvaluationLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll() {
		return _candidateEvaluationLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll(
		int start, int end) {
		return _candidateEvaluationLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _candidateEvaluationLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> findByCandidate(
		long candidateId) {
		return _candidateEvaluationLocalService.findByCandidate(candidateId);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation createPrePersistedEntity() {
		return _candidateEvaluationLocalService.createPrePersistedEntity();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation addCandidateEvaluation(
		long candidateId, long evaluationCriteriaId,
		long evaluationCriteriaKeyValueId, int ratingPoint,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateEvaluationLocalService.addCandidateEvaluation(candidateId,
			evaluationCriteriaId, evaluationCriteriaKeyValueId, ratingPoint,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CandidateEvaluationLocalService getWrappedCandidateEvaluationLocalService() {
		return _candidateEvaluationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCandidateEvaluationLocalService(
		CandidateEvaluationLocalService candidateEvaluationLocalService) {
		_candidateEvaluationLocalService = candidateEvaluationLocalService;
	}

	@Override
	public CandidateEvaluationLocalService getWrappedService() {
		return _candidateEvaluationLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateEvaluationLocalService candidateEvaluationLocalService) {
		_candidateEvaluationLocalService = candidateEvaluationLocalService;
	}

	private CandidateEvaluationLocalService _candidateEvaluationLocalService;
}