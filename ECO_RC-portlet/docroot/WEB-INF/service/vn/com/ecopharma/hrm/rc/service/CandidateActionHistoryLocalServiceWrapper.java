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
 * Provides a wrapper for {@link CandidateActionHistoryLocalService}.
 *
 * @author tvt
 * @see CandidateActionHistoryLocalService
 * @generated
 */
public class CandidateActionHistoryLocalServiceWrapper
	implements CandidateActionHistoryLocalService,
		ServiceWrapper<CandidateActionHistoryLocalService> {
	public CandidateActionHistoryLocalServiceWrapper(
		CandidateActionHistoryLocalService candidateActionHistoryLocalService) {
		_candidateActionHistoryLocalService = candidateActionHistoryLocalService;
	}

	/**
	* Adds the candidate action history to the database. Also notifies the appropriate model listeners.
	*
	* @param candidateActionHistory the candidate action history
	* @return the candidate action history that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory addCandidateActionHistory(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.addCandidateActionHistory(candidateActionHistory);
	}

	/**
	* Creates a new candidate action history with the primary key. Does not add the candidate action history to the database.
	*
	* @param candidateActionHistoryId the primary key for the new candidate action history
	* @return the new candidate action history
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory createCandidateActionHistory(
		long candidateActionHistoryId) {
		return _candidateActionHistoryLocalService.createCandidateActionHistory(candidateActionHistoryId);
	}

	/**
	* Deletes the candidate action history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history that was removed
	* @throws PortalException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory deleteCandidateActionHistory(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.deleteCandidateActionHistory(candidateActionHistoryId);
	}

	/**
	* Deletes the candidate action history from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateActionHistory the candidate action history
	* @return the candidate action history that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory deleteCandidateActionHistory(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.deleteCandidateActionHistory(candidateActionHistory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateActionHistoryLocalService.dynamicQuery();
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
		return _candidateActionHistoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateActionHistoryLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _candidateActionHistoryLocalService.dynamicQuery(dynamicQuery,
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
		return _candidateActionHistoryLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateActionHistoryLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory fetchCandidateActionHistory(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.fetchCandidateActionHistory(candidateActionHistoryId);
	}

	/**
	* Returns the candidate action history with the primary key.
	*
	* @param candidateActionHistoryId the primary key of the candidate action history
	* @return the candidate action history
	* @throws PortalException if a candidate action history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory getCandidateActionHistory(
		long candidateActionHistoryId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.getCandidateActionHistory(candidateActionHistoryId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the candidate action histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidate action histories
	* @param end the upper bound of the range of candidate action histories (not inclusive)
	* @return the range of candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> getCandidateActionHistories(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.getCandidateActionHistories(start,
			end);
	}

	/**
	* Returns the number of candidate action histories.
	*
	* @return the number of candidate action histories
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCandidateActionHistoriesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.getCandidateActionHistoriesCount();
	}

	/**
	* Updates the candidate action history in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidateActionHistory the candidate action history
	* @return the candidate action history that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory updateCandidateActionHistory(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistoryLocalService.updateCandidateActionHistory(candidateActionHistory);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _candidateActionHistoryLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_candidateActionHistoryLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _candidateActionHistoryLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll() {
		return _candidateActionHistoryLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll(
		int start, int end) {
		return _candidateActionHistoryLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _candidateActionHistoryLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidate(
		long candidateId) {
		return _candidateActionHistoryLocalService.findByCandidate(candidateId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, java.lang.String actionType) {
		return _candidateActionHistoryLocalService.findByCandidateAndActionType(candidateId,
			actionType);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, java.lang.String actionType, java.lang.String action) {
		return _candidateActionHistoryLocalService.findByCandidateAndActionTypeAndAction(candidateId,
			actionType, action);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory createPrePersistedEntity() {
		return _candidateActionHistoryLocalService.createPrePersistedEntity();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory createPrePersistedEntity(
		long candidateId, java.lang.String action, java.lang.String actionType,
		long executedBy, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateActionHistoryLocalService.createPrePersistedEntity(candidateId,
			action, actionType, executedBy, description, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CandidateActionHistoryLocalService getWrappedCandidateActionHistoryLocalService() {
		return _candidateActionHistoryLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCandidateActionHistoryLocalService(
		CandidateActionHistoryLocalService candidateActionHistoryLocalService) {
		_candidateActionHistoryLocalService = candidateActionHistoryLocalService;
	}

	@Override
	public CandidateActionHistoryLocalService getWrappedService() {
		return _candidateActionHistoryLocalService;
	}

	@Override
	public void setWrappedService(
		CandidateActionHistoryLocalService candidateActionHistoryLocalService) {
		_candidateActionHistoryLocalService = candidateActionHistoryLocalService;
	}

	private CandidateActionHistoryLocalService _candidateActionHistoryLocalService;
}