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

package vn.com.ecopharma.hrm.tt.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.hrm.tt.model.TimeTracking;

import java.util.List;

/**
 * The persistence utility for the time tracking service. This utility wraps {@link TimeTrackingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TimeTrackingPersistence
 * @see TimeTrackingPersistenceImpl
 * @generated
 */
public class TimeTrackingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(TimeTracking timeTracking) {
		getPersistence().clearCache(timeTracking);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TimeTracking> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TimeTracking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TimeTracking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TimeTracking update(TimeTracking timeTracking)
		throws SystemException {
		return getPersistence().update(timeTracking);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TimeTracking update(TimeTracking timeTracking,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(timeTracking, serviceContext);
	}

	/**
	* Returns all the time trackings where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the matching time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findByEmp(
		long empId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId);
	}

	/**
	* Returns a range of all the time trackings where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of time trackings
	* @param end the upper bound of the range of time trackings (not inclusive)
	* @return the range of matching time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findByEmp(
		long empId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId, start, end);
	}

	/**
	* Returns an ordered range of all the time trackings where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of time trackings
	* @param end the upper bound of the range of time trackings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findByEmp(
		long empId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId, start, end, orderByComparator);
	}

	/**
	* Returns the first time tracking in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time tracking
	* @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a matching time tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking findByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException {
		return getPersistence().findByEmp_First(empId, orderByComparator);
	}

	/**
	* Returns the first time tracking in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching time tracking, or <code>null</code> if a matching time tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking fetchByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmp_First(empId, orderByComparator);
	}

	/**
	* Returns the last time tracking in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time tracking
	* @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a matching time tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking findByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException {
		return getPersistence().findByEmp_Last(empId, orderByComparator);
	}

	/**
	* Returns the last time tracking in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching time tracking, or <code>null</code> if a matching time tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking fetchByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmp_Last(empId, orderByComparator);
	}

	/**
	* Returns the time trackings before and after the current time tracking in the ordered set where empId = &#63;.
	*
	* @param timeTrackingId the primary key of the current time tracking
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next time tracking
	* @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking[] findByEmp_PrevAndNext(
		long timeTrackingId, long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException {
		return getPersistence()
				   .findByEmp_PrevAndNext(timeTrackingId, empId,
			orderByComparator);
	}

	/**
	* Removes all the time trackings where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmp(empId);
	}

	/**
	* Returns the number of time trackings where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmp(empId);
	}

	/**
	* Caches the time tracking in the entity cache if it is enabled.
	*
	* @param timeTracking the time tracking
	*/
	public static void cacheResult(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking) {
		getPersistence().cacheResult(timeTracking);
	}

	/**
	* Caches the time trackings in the entity cache if it is enabled.
	*
	* @param timeTrackings the time trackings
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> timeTrackings) {
		getPersistence().cacheResult(timeTrackings);
	}

	/**
	* Creates a new time tracking with the primary key. Does not add the time tracking to the database.
	*
	* @param timeTrackingId the primary key for the new time tracking
	* @return the new time tracking
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking create(
		long timeTrackingId) {
		return getPersistence().create(timeTrackingId);
	}

	/**
	* Removes the time tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking that was removed
	* @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking remove(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException {
		return getPersistence().remove(timeTrackingId);
	}

	public static vn.com.ecopharma.hrm.tt.model.TimeTracking updateImpl(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(timeTracking);
	}

	/**
	* Returns the time tracking with the primary key or throws a {@link vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException} if it could not be found.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking
	* @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking findByPrimaryKey(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException {
		return getPersistence().findByPrimaryKey(timeTrackingId);
	}

	/**
	* Returns the time tracking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param timeTrackingId the primary key of the time tracking
	* @return the time tracking, or <code>null</code> if a time tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.hrm.tt.model.TimeTracking fetchByPrimaryKey(
		long timeTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(timeTrackingId);
	}

	/**
	* Returns all the time trackings.
	*
	* @return the time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the time trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of time trackings
	* @param end the upper bound of the range of time trackings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.hrm.tt.model.TimeTracking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the time trackings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of time trackings.
	*
	* @return the number of time trackings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TimeTrackingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TimeTrackingPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.hrm.tt.service.ClpSerializer.getServletContextName(),
					TimeTrackingPersistence.class.getName());

			ReferenceRegistry.registerReference(TimeTrackingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TimeTrackingPersistence persistence) {
	}

	private static TimeTrackingPersistence _persistence;
}