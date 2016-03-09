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

package vn.com.ecopharma.hrm.tt.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TimeTrackingLocalService}.
 *
 * @author tvt
 * @see TimeTrackingLocalService
 * @generated
 */
public class TimeTrackingLocalServiceWrapper implements TimeTrackingLocalService,
	ServiceWrapper<TimeTrackingLocalService> {
	public TimeTrackingLocalServiceWrapper(
		TimeTrackingLocalService timeTrackingLocalService) {
		_timeTrackingLocalService = timeTrackingLocalService;
	}

	/**
	* Adds the time tracking to the database. Also notifies the appropriate model listeners.
	*
	* @param timeTracking the time tracking
	* @return the time tracking that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking addTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.addTimeTracking(timeTracking);
	}

	/**
	* Creates a new time tracking with the primary key. Does not add the time tracking to the database.
	*
	* @param timeTrackingId the primary key for the new time tracking
	* @return the new time tracking
	*/
	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking createTimeTracking(
		long timeTrackingId) {
		return _timeTrackingLocalService.createTimeTracking(timeTrackingId);
	}

	/**
	* Deletes the time tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking that was removed
	* @throws PortalException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking deleteTimeTracking(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.deleteTimeTracking(timeTrackingId);
	}

	/**
	* Deletes the time tracking from the database. Also notifies the appropriate model listeners.
	*
	* @param timeTracking the time tracking
	* @return the time tracking that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking deleteTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.deleteTimeTracking(timeTracking);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _timeTrackingLocalService.dynamicQuery();
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
		return _timeTrackingLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timeTrackingLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _timeTrackingLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _timeTrackingLocalService.dynamicQueryCount(dynamicQuery);
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
		return _timeTrackingLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking fetchTimeTracking(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.fetchTimeTracking(timeTrackingId);
	}

	/**
	* Returns the time tracking with the primary key.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking
	* @throws PortalException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking getTimeTracking(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.getTimeTracking(timeTrackingId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the time trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time trackings
	* @param end the upper bound of the range of time trackings (not inclusive)
	* @return the range of time trackings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> getTimeTrackings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.getTimeTrackings(start, end);
	}

	/**
	* Returns the number of time trackings.
	*
	* @return the number of time trackings
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getTimeTrackingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.getTimeTrackingsCount();
	}

	/**
	* Updates the time tracking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timeTracking the time tracking
	* @return the time tracking that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking updateTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTrackingLocalService.updateTimeTracking(timeTracking);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _timeTrackingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_timeTrackingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _timeTrackingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll() {
		return _timeTrackingLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll(
		int start, int end) {
		return _timeTrackingLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _timeTrackingLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking findByEmpAndDate(
		long empId, java.util.Date date) {
		return _timeTrackingLocalService.findByEmpAndDate(empId, date);
	}

	@Override
	public int countSearch(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return _timeTrackingLocalService.countSearch(searchContext, queries,
			companyId);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> search(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return _timeTrackingLocalService.search(searchContext, queries,
			companyId, sort, start, end);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedTimeTracking(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _timeTrackingLocalService.getIndexedTimeTracking(id,
			searchContext);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedTimeTracking(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return _timeTrackingLocalService.getIndexedTimeTracking(id,
			searchContext);
	}

	@Override
	public void reindexAllTimeTrackings() {
		_timeTrackingLocalService.reindexAllTimeTrackings();
	}

	@Override
	public void removeAllIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		_timeTrackingLocalService.removeAllIndexes(searchContext, companyId);
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking addTimeTracking(
		long empId, java.util.Date date, java.util.Date in1,
		java.util.Date out1, java.util.Date in2, java.util.Date out2,
		java.util.Date in3, java.util.Date out3, long leaveRefId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _timeTrackingLocalService.addTimeTracking(empId, date, in1,
			out1, in2, out2, in3, out3, leaveRefId, serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking updateTimeTracking(
		long timeTrackingId, java.util.Date in1, java.util.Date in2,
		java.util.Date in3, java.util.Date out1, java.util.Date out2,
		java.util.Date out3) {
		return _timeTrackingLocalService.updateTimeTracking(timeTrackingId,
			in1, in2, in3, out1, out2, out3);
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking setLeaveForTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking, long leaveRefId) {
		return _timeTrackingLocalService.setLeaveForTimeTracking(timeTracking,
			leaveRefId);
	}

	@Override
	public void addOrUpdateTimeTrackingByLeaveRequest(
		vn.com.ecopharma.emp.model.VacationLeave leaveRequest) {
		_timeTrackingLocalService.addOrUpdateTimeTrackingByLeaveRequest(leaveRequest);
	}

	@Override
	public void scanAndAddMissingDataByLeaveRequests(
		java.util.List<vn.com.ecopharma.emp.model.VacationLeave> list) {
		_timeTrackingLocalService.scanAndAddMissingDataByLeaveRequests(list);
	}

	@Override
	public void completelyRemoveAllTimeTrackings() {
		_timeTrackingLocalService.completelyRemoveAllTimeTrackings();
	}

	@Override
	public java.util.List<java.util.Date> getDatesBetweenTwoDates(
		java.util.Date date1, java.util.Date date2, boolean includedHolidays,
		boolean includedLowerTerm) {
		return _timeTrackingLocalService.getDatesBetweenTwoDates(date1, date2,
			includedHolidays, includedLowerTerm);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public TimeTrackingLocalService getWrappedTimeTrackingLocalService() {
		return _timeTrackingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedTimeTrackingLocalService(
		TimeTrackingLocalService timeTrackingLocalService) {
		_timeTrackingLocalService = timeTrackingLocalService;
	}

	@Override
	public TimeTrackingLocalService getWrappedService() {
		return _timeTrackingLocalService;
	}

	@Override
	public void setWrappedService(
		TimeTrackingLocalService timeTrackingLocalService) {
		_timeTrackingLocalService = timeTrackingLocalService;
	}

	private TimeTrackingLocalService _timeTrackingLocalService;
}