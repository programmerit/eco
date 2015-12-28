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

package vn.com.ecopharma.emp.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.Emp;

import java.util.List;

/**
 * The persistence utility for the emp service. This utility wraps {@link EmpPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpPersistence
 * @see EmpPersistenceImpl
 * @generated
 */
public class EmpUtil {
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
	public static void clearCache(Emp emp) {
		getPersistence().clearCache(emp);
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
	public static List<Emp> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Emp> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Emp> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Emp update(Emp emp) throws SystemException {
		return getPersistence().update(emp);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Emp update(Emp emp, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(emp, serviceContext);
	}

	/**
	* Returns the emp where empCode = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpException} if it could not be found.
	*
	* @param empCode the emp code
	* @return the matching emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByEmpCode(
		java.lang.String empCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByEmpCode(empCode);
	}

	/**
	* Returns the emp where empCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param empCode the emp code
	* @return the matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByEmpCode(
		java.lang.String empCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmpCode(empCode);
	}

	/**
	* Returns the emp where empCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param empCode the emp code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByEmpCode(
		java.lang.String empCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmpCode(empCode, retrieveFromCache);
	}

	/**
	* Removes the emp where empCode = &#63; from the database.
	*
	* @param empCode the emp code
	* @return the emp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp removeByEmpCode(
		java.lang.String empCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().removeByEmpCode(empCode);
	}

	/**
	* Returns the number of emps where empCode = &#63;.
	*
	* @param empCode the emp code
	* @return the number of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmpCode(java.lang.String empCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmpCode(empCode);
	}

	/**
	* Returns the emp where empUserId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpException} if it could not be found.
	*
	* @param empUserId the emp user ID
	* @return the matching emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByUser(long empUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByUser(empUserId);
	}

	/**
	* Returns the emp where empUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param empUserId the emp user ID
	* @return the matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByUser(long empUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser(empUserId);
	}

	/**
	* Returns the emp where empUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param empUserId the emp user ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByUser(long empUserId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUser(empUserId, retrieveFromCache);
	}

	/**
	* Removes the emp where empUserId = &#63; from the database.
	*
	* @param empUserId the emp user ID
	* @return the emp that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp removeByUser(long empUserId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().removeByUser(empUserId);
	}

	/**
	* Returns the number of emps where empUserId = &#63;.
	*
	* @param empUserId the emp user ID
	* @return the number of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUser(long empUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUser(empUserId);
	}

	/**
	* Returns all the emps where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByTitles(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId);
	}

	/**
	* Returns a range of all the emps where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @return the range of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByTitles(
		long titlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId, start, end);
	}

	/**
	* Returns an ordered range of all the emps where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByTitles(
		long titlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitles(titlesId, start, end, orderByComparator);
	}

	/**
	* Returns the first emp in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the first emp in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the last emp in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the last emp in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the emps before and after the current emp in the ordered set where titlesId = &#63;.
	*
	* @param empId the primary key of the current emp
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp[] findByTitles_PrevAndNext(
		long empId, long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence()
				   .findByTitles_PrevAndNext(empId, titlesId, orderByComparator);
	}

	/**
	* Removes all the emps where titlesId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitles(titlesId);
	}

	/**
	* Returns the number of emps where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the number of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitles(titlesId);
	}

	/**
	* Returns all the emps where status = &#63;.
	*
	* @param status the status
	* @return the matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status);
	}

	/**
	* Returns a range of all the emps where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @return the range of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByStatus(status, start, end);
	}

	/**
	* Returns an ordered range of all the emps where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findByStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByStatus(status, start, end, orderByComparator);
	}

	/**
	* Returns the first emp in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first emp in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last emp in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last emp in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp, or <code>null</code> if a matching emp could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the emps before and after the current emp in the ordered set where status = &#63;.
	*
	* @param empId the primary key of the current emp
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp[] findByStatus_PrevAndNext(
		long empId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence()
				   .findByStatus_PrevAndNext(empId, status, orderByComparator);
	}

	/**
	* Removes all the emps where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByStatus(status);
	}

	/**
	* Returns the number of emps where status = &#63;.
	*
	* @param status the status
	* @return the number of matching emps
	* @throws SystemException if a system exception occurred
	*/
	public static int countByStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByStatus(status);
	}

	/**
	* Caches the emp in the entity cache if it is enabled.
	*
	* @param emp the emp
	*/
	public static void cacheResult(vn.com.ecopharma.emp.model.Emp emp) {
		getPersistence().cacheResult(emp);
	}

	/**
	* Caches the emps in the entity cache if it is enabled.
	*
	* @param emps the emps
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		getPersistence().cacheResult(emps);
	}

	/**
	* Creates a new emp with the primary key. Does not add the emp to the database.
	*
	* @param empId the primary key for the new emp
	* @return the new emp
	*/
	public static vn.com.ecopharma.emp.model.Emp create(long empId) {
		return getPersistence().create(empId);
	}

	/**
	* Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empId the primary key of the emp
	* @return the emp that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp remove(long empId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().remove(empId);
	}

	public static vn.com.ecopharma.emp.model.Emp updateImpl(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(emp);
	}

	/**
	* Returns the emp with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpException} if it could not be found.
	*
	* @param empId the primary key of the emp
	* @return the emp
	* @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp findByPrimaryKey(long empId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpException {
		return getPersistence().findByPrimaryKey(empId);
	}

	/**
	* Returns the emp with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empId the primary key of the emp
	* @return the emp, or <code>null</code> if a emp with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Emp fetchByPrimaryKey(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empId);
	}

	/**
	* Returns all the emps.
	*
	* @return the emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @return the range of emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emps
	* @param end the upper bound of the range of emps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emps.
	*
	* @return the number of emps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpPersistence persistence) {
	}

	private static EmpPersistence _persistence;
}