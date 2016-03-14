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
 * Provides a wrapper for {@link CandidateLocalService}.
 *
 * @author tvt
 * @see CandidateLocalService
 * @generated
 */
public class CandidateLocalServiceWrapper implements CandidateLocalService,
	ServiceWrapper<CandidateLocalService> {
	public CandidateLocalServiceWrapper(
		CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	/**
	* Adds the candidate to the database. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate addCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.addCandidate(candidate);
	}

	/**
	* Creates a new candidate with the primary key. Does not add the candidate to the database.
	*
	* @param candidateId the primary key for the new candidate
	* @return the new candidate
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate createCandidate(
		long candidateId) {
		return _candidateLocalService.createCandidate(candidateId);
	}

	/**
	* Deletes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param candidateId the primary key of the candidate
	* @return the candidate that was removed
	* @throws PortalException if a candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate deleteCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.deleteCandidate(candidateId);
	}

	/**
	* Deletes the candidate from the database. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate deleteCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.deleteCandidate(candidate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _candidateLocalService.dynamicQuery();
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
		return _candidateLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _candidateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _candidateLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate fetchCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.fetchCandidate(candidateId);
	}

	/**
	* Returns the candidate with the primary key.
	*
	* @param candidateId the primary key of the candidate
	* @return the candidate
	* @throws PortalException if a candidate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate getCandidate(
		long candidateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getCandidate(candidateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> getCandidates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getCandidates(start, end);
	}

	/**
	* Returns the number of candidates.
	*
	* @return the number of candidates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCandidatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.getCandidatesCount();
	}

	/**
	* Updates the candidate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param candidate the candidate
	* @return the candidate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate updateCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateLocalService.updateCandidate(candidate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _candidateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_candidateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _candidateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll() {
		return _candidateLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll(
		int start, int end) {
		return _candidateLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Candidate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _candidateLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public boolean isEmailExisted(java.lang.String emailAddress) {
		return _candidateLocalService.isEmailExisted(emailAddress);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate findByIdentityCardNo(
		java.lang.String identityCardNo) {
		return _candidateLocalService.findByIdentityCardNo(identityCardNo);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate findByContactNumber(
		java.lang.String contactNumber) {
		return _candidateLocalService.findByContactNumber(contactNumber);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate createPrePersistCandidate() {
		return _candidateLocalService.createPrePersistCandidate();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate createPrePersistCandidate(
		java.lang.String candidateCode, java.lang.String fullName,
		java.lang.String emailAddress, java.lang.String contactNumber,
		java.lang.String identityCardNo, long locationId, long vacancyId,
		java.util.Date applicationDate, java.lang.String status) {
		return _candidateLocalService.createPrePersistCandidate(candidateCode,
			fullName, emailAddress, contactNumber, identityCardNo, locationId,
			vacancyId, applicationDate, status);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate addCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate, long locationId,
		long vacancyId, java.util.List<java.lang.Long> desireVacancies,
		java.util.List<java.lang.Long> fileEntryIds,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Experience, java.lang.Boolean> experienceMap,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Certificate, java.lang.Boolean> certificateMap,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.addCandidate(candidate, locationId,
			vacancyId, desireVacancies, fileEntryIds, experienceMap,
			certificateMap, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate updateCandidate(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate, long vacancyId,
		java.util.List<java.lang.Long> desireVacancies,
		java.util.List<java.lang.Long> fileEntryIds,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Experience, java.lang.Boolean> experienceMap,
		java.util.Map<vn.com.ecopharma.hrm.rc.model.Certificate, java.lang.Boolean> certificateMap,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.updateCandidate(candidate, vacancyId,
			desireVacancies, fileEntryIds, experienceMap, certificateMap,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate changeCandidateStatus(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate,
		java.lang.String status,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.changeCandidateStatus(candidate, status,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate changeCandidateStatus(
		long candidateId, java.lang.String status,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.changeCandidateStatus(candidateId,
			status, serviceContext);
	}

	@Override
	public void changeMultipleCandidateStatus(
		java.util.List<java.lang.Long> ids, java.lang.String status,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_candidateLocalService.changeMultipleCandidateStatus(ids, status,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate setShortListCandidate(
		long candidateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.setShortListCandidate(candidateId,
			serviceContext);
	}

	@Override
	public void setShortListCandidates(java.util.List<java.lang.Long> ids,
		com.liferay.portal.service.ServiceContext serviceContext) {
		_candidateLocalService.setShortListCandidates(ids, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate markDeleted(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.markDeleted(candidate, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate markDeleted(
		long candidateId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _candidateLocalService.markDeleted(candidateId, serviceContext);
	}

	@Override
	public int countAllUnDeletedIndexedCandidateDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _candidateLocalService.countAllUnDeletedIndexedCandidateDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedCandidatesIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _candidateLocalService.searchAllUnDeletedCandidatesIndexedDocument(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _candidateLocalService.filterByFields(searchContext, filters,
			sort, companyId, start, end);
	}

	@Override
	public int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _candidateLocalService.countFilterByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Query createDateTermRangeQuery(
		java.lang.String field, java.util.Date dateFrom, java.util.Date dateTo,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _candidateLocalService.createDateTermRangeQuery(field, dateFrom,
			dateTo, searchContext);
	}

	@Override
	public java.util.Date getCurrentDateNextYear() {
		return _candidateLocalService.getCurrentDateNextYear();
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexCandidateDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _candidateLocalService.getIndexCandidateDocument(id,
			searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexCandidateDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _candidateLocalService.getIndexCandidateDocument(id,
			searchContext);
	}

	@Override
	public void indexAllCandidates() {
		_candidateLocalService.indexAllCandidates();
	}

	@Override
	public void removeAllCandidateIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_candidateLocalService.removeAllCandidateIndexes(searchContext,
			companyId);
	}

	@Override
	public boolean hasAlreadyScheduleForInterview(long candidateId,
		long vacancyId, long interviewId) {
		return _candidateLocalService.hasAlreadyScheduleForInterview(candidateId,
			vacancyId, interviewId);
	}

	@Override
	public boolean hasAlreadyScheduleForInterview(long vacancyCandidateId,
		long interviewId) {
		return _candidateLocalService.hasAlreadyScheduleForInterview(vacancyCandidateId,
			interviewId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CandidateLocalService getWrappedCandidateLocalService() {
		return _candidateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCandidateLocalService(
		CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	@Override
	public CandidateLocalService getWrappedService() {
		return _candidateLocalService;
	}

	@Override
	public void setWrappedService(CandidateLocalService candidateLocalService) {
		_candidateLocalService = candidateLocalService;
	}

	private CandidateLocalService _candidateLocalService;
}