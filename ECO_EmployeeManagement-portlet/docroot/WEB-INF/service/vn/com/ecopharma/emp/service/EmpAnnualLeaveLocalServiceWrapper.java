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
 * Provides a wrapper for {@link EmpAnnualLeaveLocalService}.
 *
 * @author tvt
 * @see EmpAnnualLeaveLocalService
 * @generated
 */
public class EmpAnnualLeaveLocalServiceWrapper
	implements EmpAnnualLeaveLocalService,
		ServiceWrapper<EmpAnnualLeaveLocalService> {
	public EmpAnnualLeaveLocalServiceWrapper(
		EmpAnnualLeaveLocalService empAnnualLeaveLocalService) {
		_empAnnualLeaveLocalService = empAnnualLeaveLocalService;
	}

	/**
	* Adds the emp annual leave to the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeave the emp annual leave
	* @return the emp annual leave that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave addEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.addEmpAnnualLeave(empAnnualLeave);
	}

	/**
	* Creates a new emp annual leave with the primary key. Does not add the emp annual leave to the database.
	*
	* @param empAnnualLeaveId the primary key for the new emp annual leave
	* @return the new emp annual leave
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave createEmpAnnualLeave(
		long empAnnualLeaveId) {
		return _empAnnualLeaveLocalService.createEmpAnnualLeave(empAnnualLeaveId);
	}

	/**
	* Deletes the emp annual leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave that was removed
	* @throws PortalException if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave deleteEmpAnnualLeave(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.deleteEmpAnnualLeave(empAnnualLeaveId);
	}

	/**
	* Deletes the emp annual leave from the database. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeave the emp annual leave
	* @return the emp annual leave that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave deleteEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.deleteEmpAnnualLeave(empAnnualLeave);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _empAnnualLeaveLocalService.dynamicQuery();
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
		return _empAnnualLeaveLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empAnnualLeaveLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _empAnnualLeaveLocalService.dynamicQuery(dynamicQuery, start,
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
		return _empAnnualLeaveLocalService.dynamicQueryCount(dynamicQuery);
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
		return _empAnnualLeaveLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave fetchEmpAnnualLeave(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.fetchEmpAnnualLeave(empAnnualLeaveId);
	}

	/**
	* Returns the emp annual leave with the primary key.
	*
	* @param empAnnualLeaveId the primary key of the emp annual leave
	* @return the emp annual leave
	* @throws PortalException if a emp annual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave getEmpAnnualLeave(
		long empAnnualLeaveId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.getEmpAnnualLeave(empAnnualLeaveId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the emp annual leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp annual leaves
	* @param end the upper bound of the range of emp annual leaves (not inclusive)
	* @return the range of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> getEmpAnnualLeaves(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.getEmpAnnualLeaves(start, end);
	}

	/**
	* Returns the number of emp annual leaves.
	*
	* @return the number of emp annual leaves
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEmpAnnualLeavesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.getEmpAnnualLeavesCount();
	}

	/**
	* Updates the emp annual leave in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param empAnnualLeave the emp annual leave
	* @return the emp annual leave that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave updateEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.updateEmpAnnualLeave(empAnnualLeave);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _empAnnualLeaveLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_empAnnualLeaveLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _empAnnualLeaveLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll() {
		return _empAnnualLeaveLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll(
		int start, int end) {
		return _empAnnualLeaveLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnnualLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _empAnnualLeaveLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empAnnualLeaveLocalService.createPrePersistedEntity(serviceContext);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave addEmpAnnualLeave(
		vn.com.ecopharma.emp.model.EmpAnnualLeave prePersistedEntity,
		long empId, int totalLeave, double totalLeaveLeft,
		double totalOldLeavesLeft) {
		return _empAnnualLeaveLocalService.addEmpAnnualLeave(prePersistedEntity,
			empId, totalLeave, totalLeaveLeft, totalOldLeavesLeft);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave addEmpAnnualLeave(
		long empId, int totalLeave, double totalLeaveLeft,
		double totalOldLeavesLeft,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _empAnnualLeaveLocalService.addEmpAnnualLeave(empId, totalLeave,
			totalLeaveLeft, totalOldLeavesLeft, serviceContext);
	}

	@Override
	public void scanAndAutoAddVacationLeave(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empAnnualLeaveLocalService.scanAndAutoAddVacationLeave(serviceContext);
	}

	@Override
	public int calculateTotalAnnualLeaveByJoinedDate(java.util.Date joinedDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeaveLocalService.calculateTotalAnnualLeaveByJoinedDate(joinedDate);
	}

	@Override
	public int getMonthsBetweenTwoDate(java.util.Date startDate,
		java.util.Date endDate) {
		return _empAnnualLeaveLocalService.getMonthsBetweenTwoDate(startDate,
			endDate);
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave fetchByEmp(long empId) {
		return _empAnnualLeaveLocalService.fetchByEmp(empId);
	}

	@Override
	public java.util.List<java.util.Date> getDatesBetweenTwoDates(
		java.util.Date date1, java.util.Date date2, boolean includedHolidays,
		boolean includedLowerTerm) {
		return _empAnnualLeaveLocalService.getDatesBetweenTwoDates(date1,
			date2, includedHolidays, includedLowerTerm);
	}

	@Override
	public int countAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		return _empAnnualLeaveLocalService.countAllDocuments(searchContext,
			filterQueries, companyId, sort);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		return _empAnnualLeaveLocalService.searchAllDocuments(searchContext,
			filterQueries, companyId, sort, start, end);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		return _empAnnualLeaveLocalService.filterByFields(searchContext,
			filters, sort, companyId, start, end);
	}

	@Override
	public int countFilterByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		return _empAnnualLeaveLocalService.countFilterByFields(searchContext,
			filters, sort, companyId);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _empAnnualLeaveLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedDocument(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _empAnnualLeaveLocalService.getIndexedDocument(id, searchContext);
	}

	@Override
	public void indexAll() {
		_empAnnualLeaveLocalService.indexAll();
	}

	@Override
	public void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_empAnnualLeaveLocalService.removeAllIndexes(searchContext, companyId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EmpAnnualLeaveLocalService getWrappedEmpAnnualLeaveLocalService() {
		return _empAnnualLeaveLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEmpAnnualLeaveLocalService(
		EmpAnnualLeaveLocalService empAnnualLeaveLocalService) {
		_empAnnualLeaveLocalService = empAnnualLeaveLocalService;
	}

	@Override
	public EmpAnnualLeaveLocalService getWrappedService() {
		return _empAnnualLeaveLocalService;
	}

	@Override
	public void setWrappedService(
		EmpAnnualLeaveLocalService empAnnualLeaveLocalService) {
		_empAnnualLeaveLocalService = empAnnualLeaveLocalService;
	}

	private EmpAnnualLeaveLocalService _empAnnualLeaveLocalService;
}