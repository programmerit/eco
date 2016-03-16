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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for InterviewSchedule. This utility wraps
 * {@link vn.com.ecopharma.hrm.rc.service.impl.InterviewScheduleLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see InterviewScheduleLocalService
 * @see vn.com.ecopharma.hrm.rc.service.base.InterviewScheduleLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.impl.InterviewScheduleLocalServiceImpl
 * @generated
 */
public class InterviewScheduleLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.hrm.rc.service.impl.InterviewScheduleLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the interview schedule to the database. Also notifies the appropriate model listeners.
	*
	* @param interviewSchedule the interview schedule
	* @return the interview schedule that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule addInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addInterviewSchedule(interviewSchedule);
	}

	/**
	* Creates a new interview schedule with the primary key. Does not add the interview schedule to the database.
	*
	* @param interviewScheduleId the primary key for the new interview schedule
	* @return the new interview schedule
	*/
	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule createInterviewSchedule(
		long interviewScheduleId) {
		return getService().createInterviewSchedule(interviewScheduleId);
	}

	/**
	* Deletes the interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewScheduleId the primary key of the interview schedule
	* @return the interview schedule that was removed
	* @throws PortalException if a interview schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule deleteInterviewSchedule(
		long interviewScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInterviewSchedule(interviewScheduleId);
	}

	/**
	* Deletes the interview schedule from the database. Also notifies the appropriate model listeners.
	*
	* @param interviewSchedule the interview schedule
	* @return the interview schedule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule deleteInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteInterviewSchedule(interviewSchedule);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule fetchInterviewSchedule(
		long interviewScheduleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchInterviewSchedule(interviewScheduleId);
	}

	/**
	* Returns the interview schedule with the primary key.
	*
	* @param interviewScheduleId the primary key of the interview schedule
	* @return the interview schedule
	* @throws PortalException if a interview schedule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule getInterviewSchedule(
		long interviewScheduleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getInterviewSchedule(interviewScheduleId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> getInterviewSchedules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInterviewSchedules(start, end);
	}

	/**
	* Returns the number of interview schedules.
	*
	* @return the number of interview schedules
	* @throws SystemException if a system exception occurred
	*/
	public static int getInterviewSchedulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInterviewSchedulesCount();
	}

	/**
	* Updates the interview schedule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param interviewSchedule the interview schedule
	* @return the interview schedule that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule updateInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateInterviewSchedule(interviewSchedule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule findByVacancyCandidateAndInterview(
		long vacancyCandidateId, long interviewId) {
		return getService()
				   .findByVacancyCandidateAndInterview(vacancyCandidateId,
			interviewId);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule findByVacancyCandidateAndStatus(
		long vacancyCandidateId, java.lang.String status) {
		return getService()
				   .findByVacancyCandidateAndStatus(vacancyCandidateId, status);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule findInProgressByVacancyCandidate(
		long vacancyCandidateId) {
		return getService().findInProgressByVacancyCandidate(vacancyCandidateId);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> findByVacancyCandidate(
		long vacancyCandidateId) {
		return getService().findByVacancyCandidate(vacancyCandidateId);
	}

	public static java.util.List<java.lang.Long> findInterviewIdsByVacancyCandidate(
		long vacancyCandidateId) {
		return getService()
				   .findInterviewIdsByVacancyCandidate(vacancyCandidateId);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule addInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate,
		java.util.List<vn.com.ecopharma.emp.model.Employee> interviewers,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addInterviewSchedule(interviewSchedule, vacancyCandidate,
			interviewers, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule addInterviewSchedule(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		long vacancyCandidateId, java.util.List<java.lang.Long> interviewers,
		long candidateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addInterviewSchedule(interviewSchedule, vacancyCandidateId,
			interviewers, candidateId, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule setInterviewStatusByCandidateStatus(
		java.lang.String candidateStatus, long candidateId,
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .setInterviewStatusByCandidateStatus(candidateStatus,
			candidateId, interviewSchedule, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule markInterviewFail(
		long candidateId,
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .markInterviewFail(candidateId, interviewSchedule,
			serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule markInterviewPass(
		long candidateId,
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .markInterviewPass(candidateId, interviewSchedule,
			serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.InterviewSchedule createPrePersitedEntity() {
		return getService().createPrePersitedEntity();
	}

	public static int countAllIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllIndexedDocuments(searchContext, filterQueries,
			companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllIndexedDocuments(searchContext, filterQueries,
			companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchByVacancyCandidateId(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long vacancyCandidateId, long companyId) {
		return getService()
				   .searchByVacancyCandidateId(searchContext,
			vacancyCandidateId, companyId);
	}

	public static java.util.List<java.lang.Long> getAllInterviewRoundIdsByVacancyCandidateId(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long vacancyCandidateId, long companyId) {
		return getService()
				   .getAllInterviewRoundIdsByVacancyCandidateId(searchContext,
			vacancyCandidateId, companyId);
	}

	public static void indexAll() {
		getService().indexAll();
	}

	public static void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllIndexes(searchContext, companyId);
	}

	public static com.liferay.portal.kernel.search.Document getIndexDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexDocument(id, searchContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static InterviewScheduleLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					InterviewScheduleLocalService.class.getName());

			if (invokableLocalService instanceof InterviewScheduleLocalService) {
				_service = (InterviewScheduleLocalService)invokableLocalService;
			}
			else {
				_service = new InterviewScheduleLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(InterviewScheduleLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(InterviewScheduleLocalService service) {
	}

	private static InterviewScheduleLocalService _service;
}