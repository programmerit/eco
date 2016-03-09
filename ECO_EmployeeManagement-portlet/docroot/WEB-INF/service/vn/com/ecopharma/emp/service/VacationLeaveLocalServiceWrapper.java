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

package vn.com.ecopharma.emp.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link VacationLeaveLocalService}.
 *
 * @author tvt
 * @see VacationLeaveLocalService
 * @generated
 */
public class VacationLeaveLocalServiceWrapper
	implements VacationLeaveLocalService,
		ServiceWrapper<VacationLeaveLocalService> {
	public VacationLeaveLocalServiceWrapper(
		VacationLeaveLocalService vacationLeaveLocalService) {
		_vacationLeaveLocalService = vacationLeaveLocalService;
	}

	/**
	* Adds the vacation leave to the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeave the vacation leave
	* @return the vacation leave that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.addVacationLeave(vacationLeave);
	}

	/**
	* Creates a new vacation leave with the primary key. Does not add the vacation leave to the database.
	*
	* @param vacationLeaveId the primary key for the new vacation leave
	* @return the new vacation leave
	*/
	@Override
	public vn.com.ecopharma.emp.model.VacationLeave createVacationLeave(
		long vacationLeaveId) {
		return _vacationLeaveLocalService.createVacationLeave(vacationLeaveId);
	}

	/**
	* Deletes the vacation leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave that was removed
	* @throws PortalException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.VacationLeave deleteVacationLeave(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.deleteVacationLeave(vacationLeaveId);
	}

	/**
	* Deletes the vacation leave from the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeave the vacation leave
	* @return the vacation leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.VacationLeave deleteVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.deleteVacationLeave(vacationLeave);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vacationLeaveLocalService.dynamicQuery();
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
		return _vacationLeaveLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vacationLeaveLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _vacationLeaveLocalService.dynamicQuery(dynamicQuery, start,
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
		return _vacationLeaveLocalService.dynamicQueryCount(dynamicQuery);
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
		return _vacationLeaveLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave fetchVacationLeave(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.fetchVacationLeave(vacationLeaveId);
	}

	/**
	* Returns the vacation leave with the primary key.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave
	* @throws PortalException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.VacationLeave getVacationLeave(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.getVacationLeave(vacationLeaveId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the vacation leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @return the range of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> getVacationLeaves(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.getVacationLeaves(start, end);
	}

	/**
	* Returns the number of vacation leaves.
	*
	* @return the number of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getVacationLeavesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.getVacationLeavesCount();
	}

	/**
	* Updates the vacation leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param vacationLeave the vacation leave
	* @return the vacation leave that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.VacationLeave updateVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeaveLocalService.updateVacationLeave(vacationLeave);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _vacationLeaveLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_vacationLeaveLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _vacationLeaveLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll() {
		return _vacationLeaveLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll(
		int start, int end) {
		return _vacationLeaveLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _vacationLeaveLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _vacationLeaveLocalService.createPrePersistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		vn.com.ecopharma.emp.model.VacationLeave prePersistedEntity,
		long empId, java.lang.String leaveType, java.util.Date leaveFrom,
		java.util.Date leaveTo, java.util.Date actualTo, int numberOfHours,
		java.lang.String reason, java.lang.String description) {
		return _vacationLeaveLocalService.addVacationLeave(prePersistedEntity,
			empId, leaveType, leaveFrom, leaveTo, actualTo, numberOfHours,
			reason, description);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		long empId, java.lang.String leaveType, java.util.Date leaveFrom,
		java.util.Date leaveTo, java.util.Date actualTo, int numberOfHours,
		java.lang.String reason, java.lang.String description,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _vacationLeaveLocalService.addVacationLeave(empId, leaveType,
			leaveFrom, leaveTo, actualTo, numberOfHours, reason, description,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave addVacationLeave(
		long empId, vn.com.ecopharma.emp.model.VacationLeave leave) {
		return _vacationLeaveLocalService.addVacationLeave(empId, leave);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave updateVacationLeave(
		long id, java.lang.String leaveType, java.lang.String sign,
		java.util.Date leaveFrom, java.util.Date leaveTo,
		java.util.Date actualLeaveTo, java.lang.String reason,
		java.lang.String description, java.lang.String status) {
		return _vacationLeaveLocalService.updateVacationLeave(id, leaveType,
			sign, leaveFrom, leaveTo, actualLeaveTo, reason, description, status);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave setManagerApproval(
		long leaveId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _vacationLeaveLocalService.setManagerApproval(leaveId,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave setManagerApproval(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _vacationLeaveLocalService.setManagerApproval(vacationLeave,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave setHrApproval(
		long leaveId, com.liferay.portal.service.ServiceContext serviceContext) {
		return _vacationLeaveLocalService.setHrApproval(leaveId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave setHrApproval(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _vacationLeaveLocalService.setHrApproval(vacationLeave,
			serviceContext);
	}

	@Override
	public double calculateNumberOfAnnualLeavesBtwTwoDates(
		java.util.Date dateFrom, java.util.Date dateTo,
		java.lang.String additionLeaveSign) {
		return _vacationLeaveLocalService.calculateNumberOfAnnualLeavesBtwTwoDates(dateFrom,
			dateTo, additionLeaveSign);
	}

	@Override
	public java.util.List<java.util.Date> getDatesBetweenTwoDates(
		java.util.Date date1, java.util.Date date2, boolean includedHolidays,
		boolean includedLowerTerm) {
		return _vacationLeaveLocalService.getDatesBetweenTwoDates(date1, date2,
			includedHolidays, includedLowerTerm);
	}

	@Override
	public int countAllUnDeletedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _vacationLeaveLocalService.countAllUnDeletedDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _vacationLeaveLocalService.searchAllUnDeletedDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _vacationLeaveLocalService.filterByFields(searchContext,
			filters, sort, companyId, start, end);
	}

	@Override
	public int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _vacationLeaveLocalService.countFilterByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchPendingRequestsOfManager(
		long managerId,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return _vacationLeaveLocalService.searchPendingRequestsOfManager(managerId,
			searchContext, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchByStatuses(
		java.util.List<java.lang.String> statuses,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return _vacationLeaveLocalService.searchByStatuses(statuses,
			searchContext, companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchManagerApprovalList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		return _vacationLeaveLocalService.searchManagerApprovalList(searchContext,
			companyId);
	}

	@Override
	public void reindexAll() {
		_vacationLeaveLocalService.reindexAll();
	}

	@Override
	public void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_vacationLeaveLocalService.removeAllIndexes(searchContext, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _vacationLeaveLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _vacationLeaveLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public void indexAll() {
		_vacationLeaveLocalService.indexAll();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public VacationLeaveLocalService getWrappedVacationLeaveLocalService() {
		return _vacationLeaveLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedVacationLeaveLocalService(
		VacationLeaveLocalService vacationLeaveLocalService) {
		_vacationLeaveLocalService = vacationLeaveLocalService;
	}

	@Override
	public VacationLeaveLocalService getWrappedService() {
		return _vacationLeaveLocalService;
	}

	@Override
	public void setWrappedService(
		VacationLeaveLocalService vacationLeaveLocalService) {
		_vacationLeaveLocalService = vacationLeaveLocalService;
	}

	private VacationLeaveLocalService _vacationLeaveLocalService;
}