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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for TimeTracking. This utility wraps
 * {@link vn.com.ecopharma.hrm.tt.service.impl.TimeTrackingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author tvt
 * @see TimeTrackingLocalService
 * @see vn.com.ecopharma.hrm.tt.service.base.TimeTrackingLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.tt.service.impl.TimeTrackingLocalServiceImpl
 * @generated
 */
public class TimeTrackingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link vn.com.ecopharma.hrm.tt.service.impl.TimeTrackingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the time tracking to the database. Also notifies the appropriate model listeners.
	*
	* @param timeTracking the time tracking
	* @return the time tracking that was added
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking addTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addTimeTracking(timeTracking);
	}

	/**
	* Creates a new time tracking with the primary key. Does not add the time tracking to the database.
	*
	* @param timeTrackingId the primary key for the new time tracking
	* @return the new time tracking
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking createTimeTracking(
		long timeTrackingId) {
		return getService().createTimeTracking(timeTrackingId);
	}

	/**
	* Deletes the time tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking that was removed
	* @throws PortalException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking deleteTimeTracking(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTimeTracking(timeTrackingId);
	}

	/**
	* Deletes the time tracking from the database. Also notifies the appropriate model listeners.
	*
	* @param timeTracking the time tracking
	* @return the time tracking that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking deleteTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteTimeTracking(timeTracking);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static vn.com.ecopharma.hrm.tt.model.TimeTracking fetchTimeTracking(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchTimeTracking(timeTrackingId);
	}

	/**
	* Returns the time tracking with the primary key.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking
	* @throws PortalException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking getTimeTracking(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimeTracking(timeTrackingId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> getTimeTrackings(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimeTrackings(start, end);
	}

	/**
	* Returns the number of time trackings.
	*
	* @return the number of time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static int getTimeTrackingsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getTimeTrackingsCount();
	}

	/**
	* Updates the time tracking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param timeTracking the time tracking
	* @return the time tracking that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking updateTimeTracking(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateTimeTracking(timeTracking);
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

	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll() {
		return getService().findAll();
	}

	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll(
		int start, int end) {
		return getService().findAll(start, end);
	}

	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return getService().findAll(start, end, orderByComparator);
	}

	public static int countSearch(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return getService().countSearch(searchContext, queries, companyId);
	}

	public static java.util.List<com.liferay.portal.kernel.search.Document> search(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end)
		throws com.liferay.portal.kernel.search.ParseException,
			com.liferay.portal.kernel.search.SearchException {
		return getService()
				   .search(searchContext, queries, companyId, sort, start, end);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedTimeTracking(
		long id, com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedTimeTracking(id, searchContext);
	}

	public static com.liferay.portal.kernel.search.Document getIndexedTimeTracking(
		java.lang.String id,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		return getService().getIndexedTimeTracking(id, searchContext);
	}

	public static vn.com.ecopharma.hrm.tt.model.TimeTracking addTimeTracking(
		long empId, java.util.Date date, java.util.Date in1,
		java.util.Date out1, java.util.Date in2, java.util.Date out2,
		java.util.Date in3, java.util.Date out3,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return getService()
				   .addTimeTracking(empId, date, in1, out1, in2, out2, in3,
			out3, serviceContext);
	}

	public static vn.com.ecopharma.hrm.tt.model.TimeTracking updateTimeTracking(
		long timeTrackingId, java.util.Date in1, java.util.Date in2,
		java.util.Date in3, java.util.Date out1, java.util.Date out2,
		java.util.Date out3) {
		return getService()
				   .updateTimeTracking(timeTrackingId, in1, in2, in3, out1,
			out2, out3);
	}

	public static void completelyRemoveAllTimeTrackings() {
		getService().completelyRemoveAllTimeTrackings();
	}

	public static void clearService() {
		_service = null;
	}

	public static TimeTrackingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					TimeTrackingLocalService.class.getName());

			if (invokableLocalService instanceof TimeTrackingLocalService) {
				_service = (TimeTrackingLocalService)invokableLocalService;
			}
			else {
				_service = new TimeTrackingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(TimeTrackingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(TimeTrackingLocalService service) {
	}

	private static TimeTrackingLocalService _service;
}