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
 * Provides the local service utility for Candidate. This utility wraps
 * {@link vn.com.ecopharma.hrm.rc.service.impl.CandidateLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see CandidateLocalService
 * @see vn.com.ecopharma.hrm.rc.service.base.CandidateLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.impl.CandidateLocalServiceImpl
 * @generated
 */
public class CandidateLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.hrm.rc.service.impl.CandidateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the candidate to the database. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Candidate addCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCandidate(candidate);
	}

	/**
	* Creates a new candidate with the primary key. Does not add the candidate to the database.
	*
	* @param candidateId the primary key for the new candidate
	* @return the new candidate
	*/
	public static vn.com.ecopharma.hrm.rc.model.Candidate createCandidate(
		long candidateId) {
		return getService().createCandidate(candidateId);
	}

	/**
	* Deletes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateId the primary key of the candidate
	* @return the candidate that was removed
	* @throws PortalException if a candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Candidate deleteCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCandidate(candidateId);
	}

	/**
	* Deletes the candidate from the database. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Candidate deleteCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCandidate(candidate);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.hrm.rc.model.Candidate fetchCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCandidate(candidateId);
	}

	/**
	* Returns the candidate with the primary key.
	*
	* @param candidateId the primary key of the candidate
	* @return the candidate
	* @throws PortalException if a candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Candidate getCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCandidate(candidateId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the candidates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of candidates
	* @param end the upper bound of the range of candidates (not inclusive)
	* @return the range of candidates
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> getCandidates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCandidates(start, end);
	}

	/**
	* Returns the number of candidates.
	*
	* @return the number of candidates
	* @throws SystemException if a system exception occurred
	*/
	public static int getCandidatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCandidatesCount();
	}

	/**
	* Updates the candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.rc.model.Candidate updateCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCandidate(candidate);
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

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static boolean isEmailExisted(java.lang.String emailAddress) {
		return getService().isEmailExisted(emailAddress);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate findByIdentityCardNo(
		java.lang.String identityCardNo) {
		return getService().findByIdentityCardNo(identityCardNo);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate findByContactNumber(
		java.lang.String contactNumber) {
		return getService().findByContactNumber(contactNumber);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate createPrePersistCandidate() {
		return getService().createPrePersistCandidate();
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate createPrePersistCandidate(
		java.lang.String candidateCode, java.lang.String fullName,
		java.lang.String emailAddress, java.lang.String contactNumber,
		java.lang.String identityCardNo, long locationId, long vacancyId,
		java.util.Date applicationDate, java.lang.String status) {
		return getService()
				   .createPrePersistCandidate(candidateCode, fullName,
			emailAddress, contactNumber, identityCardNo, locationId, vacancyId,
			applicationDate, status);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate addCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate, long locationId,
		long vacancyId, java.util.List<java.lang.Long> desireVacancies,
		java.util.List<java.lang.Long> fileEntryIds,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Experience, java.lang.Boolean> experienceMap,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Certificate, java.lang.Boolean> certificateMap,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addCandidate(candidate, locationId, vacancyId,
			desireVacancies, fileEntryIds, experienceMap, certificateMap,
			serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate updateCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate, long vacancyId,
		java.util.List<java.lang.Long> desireVacancies,
		java.util.List<java.lang.Long> fileEntryIds,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Experience, java.lang.Boolean> experienceMap,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Certificate, java.lang.Boolean> certificateMap,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .updateCandidate(candidate, vacancyId, desireVacancies,
			fileEntryIds, experienceMap, certificateMap, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate changeCandidateStatus(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate,
		java.lang.String status,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .changeCandidateStatus(candidate, status, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate changeCandidateStatus(
		long candidateId, java.lang.String status,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .changeCandidateStatus(candidateId, status, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate markDeleted(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().markDeleted(candidate, serviceContext);
	}

	public static vn.com.ecopharma.hrm.rc.model.Candidate markDeleted(
		long candidateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService().markDeleted(candidateId, serviceContext);
	}

	public static int countAllUnDeletedIndexedCandidateDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return getService()
				   .countAllUnDeletedIndexedCandidateDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedCandidatesIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return getService()
				   .searchAllUnDeletedCandidatesIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .filterByFields(searchContext, filters, sort, companyId,
			start, end);
	}

	public static int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return getService()
				   .countFilterByFields(searchContext, filters, sort, companyId);
	}

	public static com.liferay.portal.kernel.search.Query createDateTermRangeQuery(
		java.lang.String field, java.util.Date dateFrom, java.util.Date dateTo,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService()
				   .createDateTermRangeQuery(field, dateFrom, dateTo,
			searchContext);
	}

	public static java.util.Date getCurrentDateNextYear() {
		return getService().getCurrentDateNextYear();
	}

	public static com.liferay.portal.kernel.search.Document getIndexCandidateDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexCandidateDocument(id, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexCandidateDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexCandidateDocument(id, searchContext);
	}

	public static void indexAllCandidates() {
		getService().indexAllCandidates();
	}

	public static void removeAllCandidateIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		getService().removeAllCandidateIndexes(searchContext, companyId);
	}

	public static boolean hasAlreadyScheduleForInterview(long candidateId,
		long vacancyId, long interviewId) {
		return getService()
				   .hasAlreadyScheduleForInterview(candidateId, vacancyId,
			interviewId);
	}

	public static boolean hasAlreadyScheduleForInterview(
		long vacancyCandidateId, long interviewId) {
		return getService()
				   .hasAlreadyScheduleForInterview(vacancyCandidateId,
			interviewId);
	}

	public static void clearService() {
		_service = null;
	}

	public static CandidateLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CandidateLocalService.class.getName());

			if (invokableLocalService instanceof CandidateLocalService) {
				_service = (CandidateLocalService)invokableLocalService;
			}
			else {
				_service = new CandidateLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CandidateLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CandidateLocalService service) {
	}

	private static CandidateLocalService _service;
}