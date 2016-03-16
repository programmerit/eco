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
 * Provides a wrapper for {@link InterviewScheduleLocalService}.
 *
 * @author tvt
 * @see InterviewScheduleLocalService
 * @generated
 */
public class InterviewScheduleLocalServiceWrapper
	implements InterviewScheduleLocalService,
		ServiceWrapper<InterviewScheduleLocalService> {
	public InterviewScheduleLocalServiceWrapper(
		InterviewScheduleLocalService interviewScheduleLocalService) {
		_interviewScheduleLocalService = interviewScheduleLocalService;
	}

	/**
	* Adds the interview schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param interviewSchedule the interview schedule
	* @return the interview schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule addInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.addInterviewSchedule(interviewSchedule);
	}

	/**
	* Creates a new interview schedule with the primary key. Does not add the interview schedule to the database.
	*
	* @param interviewScheduleId the primary key for the new interview schedule
	* @return the new interview schedule
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule createInterviewSchedule(
		long interviewScheduleId) {
		return _interviewScheduleLocalService.createInterviewSchedule(interviewScheduleId);
	}

	/**
	* Deletes the interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewScheduleId the primary key of the interview schedule
	* @return the interview schedule that was removed
	* @throws PortalException if a interview schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule deleteInterviewSchedule(
		long interviewScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.deleteInterviewSchedule(interviewScheduleId);
	}

	/**
	* Deletes the interview schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewSchedule the interview schedule
	* @return the interview schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule deleteInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.deleteInterviewSchedule(interviewSchedule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _interviewScheduleLocalService.dynamicQuery();
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
		return _interviewScheduleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _interviewScheduleLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _interviewScheduleLocalService.dynamicQuery(dynamicQuery, start,
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
		return _interviewScheduleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _interviewScheduleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule fetchInterviewSchedule(
		long interviewScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.fetchInterviewSchedule(interviewScheduleId);
	}

	/**
	* Returns the interview schedule with the primary key.
	*
	* @param interviewScheduleId the primary key of the interview schedule
	* @return the interview schedule
	* @throws PortalException if a interview schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule getInterviewSchedule(
		long interviewScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.getInterviewSchedule(interviewScheduleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the interview schedules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of interview schedules
	* @param end the upper bound of the range of interview schedules (not inclusive)
	* @return the range of interview schedules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> getInterviewSchedules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.getInterviewSchedules(start, end);
	}

	/**
	* Returns the number of interview schedules.
	*
	* @return the number of interview schedules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getInterviewSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.getInterviewSchedulesCount();
	}

	/**
	* Updates the interview schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interviewSchedule the interview schedule
	* @return the interview schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule updateInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewScheduleLocalService.updateInterviewSchedule(interviewSchedule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _interviewScheduleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_interviewScheduleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _interviewScheduleLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findAll() {
		return _interviewScheduleLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findAll(
		int start, int end) {
		return _interviewScheduleLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _interviewScheduleLocalService.findAll(start, end,
			orderByComparator);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule findByVacancyCandidateAndInterview(
		long vacancyCandidateId, long interviewId) {
		return _interviewScheduleLocalService.findByVacancyCandidateAndInterview(vacancyCandidateId,
			interviewId);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule findByVacancyCandidateAndStatus(
		long vacancyCandidateId, java.lang.String status) {
		return _interviewScheduleLocalService.findByVacancyCandidateAndStatus(vacancyCandidateId,
			status);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule findInProgressByVacancyCandidate(
		long vacancyCandidateId) {
		return _interviewScheduleLocalService.findInProgressByVacancyCandidate(vacancyCandidateId);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findByVacancyCandidate(
		long vacancyCandidateId) {
		return _interviewScheduleLocalService.findByVacancyCandidate(vacancyCandidateId);
	}

	@Override
	public java.util.List<java.lang.Long> findInterviewIdsByVacancyCandidate(
		long vacancyCandidateId) {
		return _interviewScheduleLocalService.findInterviewIdsByVacancyCandidate(vacancyCandidateId);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule addInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate,
		java.util.List<vn.com.ecopharma.emp.model.Employee> interviewers,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _interviewScheduleLocalService.addInterviewSchedule(interviewSchedule,
			vacancyCandidate, interviewers, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule addInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		long vacancyCandidateId, java.util.List<java.lang.Long> interviewers,
		long candidateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _interviewScheduleLocalService.addInterviewSchedule(interviewSchedule,
			vacancyCandidateId, interviewers, candidateId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule setInterviewStatusByCandidateStatus(
		java.lang.String candidateStatus, long candidateId,
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _interviewScheduleLocalService.setInterviewStatusByCandidateStatus(candidateStatus,
			candidateId, interviewSchedule, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule markInterviewFail(
		long candidateId,
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _interviewScheduleLocalService.markInterviewFail(candidateId,
			interviewSchedule, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule markInterviewPass(
		long candidateId,
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _interviewScheduleLocalService.markInterviewPass(candidateId,
			interviewSchedule, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule createPrePersitedEntity() {
		return _interviewScheduleLocalService.createPrePersitedEntity();
	}

	@Override
	public int countAllIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _interviewScheduleLocalService.countAllIndexedDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _interviewScheduleLocalService.searchAllIndexedDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchByVacancyCandidateId(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long vacancyCandidateId, long companyId) {
		return _interviewScheduleLocalService.searchByVacancyCandidateId(searchContext,
			vacancyCandidateId, companyId);
	}

	@Override
	public java.util.List<java.lang.Long> getAllInterviewRoundIdsByVacancyCandidateId(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long vacancyCandidateId, long companyId) {
		return _interviewScheduleLocalService.getAllInterviewRoundIdsByVacancyCandidateId(searchContext,
			vacancyCandidateId, companyId);
	}

	@Override
	public void indexAll() {
		_interviewScheduleLocalService.indexAll();
	}

	@Override
	public void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_interviewScheduleLocalService.removeAllIndexes(searchContext, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexDocument(long id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _interviewScheduleLocalService.getIndexDocument(id, searchContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public InterviewScheduleLocalService getWrappedInterviewScheduleLocalService() {
		return _interviewScheduleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedInterviewScheduleLocalService(
		InterviewScheduleLocalService interviewScheduleLocalService) {
		_interviewScheduleLocalService = interviewScheduleLocalService;
	}

	@Override
	public InterviewScheduleLocalService getWrappedService() {
		return _interviewScheduleLocalService;
	}

	@Override
	public void setWrappedService(
		InterviewScheduleLocalService interviewScheduleLocalService) {
		_interviewScheduleLocalService = interviewScheduleLocalService;
	}

	private InterviewScheduleLocalService _interviewScheduleLocalService;
}