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

import vn.com.ecopharma.emp.model.EmpConcurrentTitles;

import java.util.List;

/**
 * The persistence utility for the emp concurrent titles service. This utility wraps {@link EmpConcurrentTitlesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpConcurrentTitlesPersistence
 * @see EmpConcurrentTitlesPersistenceImpl
 * @generated
 */
public class EmpConcurrentTitlesUtil {
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
	public static void clearCache(EmpConcurrentTitles empConcurrentTitles) {
		getPersistence().clearCache(empConcurrentTitles);
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
	public static List<EmpConcurrentTitles> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<EmpConcurrentTitles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<EmpConcurrentTitles> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static EmpConcurrentTitles update(
		EmpConcurrentTitles empConcurrentTitles) throws SystemException {
		return getPersistence().update(empConcurrentTitles);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static EmpConcurrentTitles update(
		EmpConcurrentTitles empConcurrentTitles, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(empConcurrentTitles, serviceContext);
	}

	/**
	* Returns the emp concurrent titles where empId = &#63; and titlesId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException} if it could not be found.
	*
	* @param empId the emp ID
	* @param titlesId the titles ID
	* @return the matching emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles findByEmpTitles(
		long empId, long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().findByEmpTitles(empId, titlesId);
	}

	/**
	* Returns the emp concurrent titles where empId = &#63; and titlesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param empId the emp ID
	* @param titlesId the titles ID
	* @return the matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByEmpTitles(
		long empId, long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmpTitles(empId, titlesId);
	}

	/**
	* Returns the emp concurrent titles where empId = &#63; and titlesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param empId the emp ID
	* @param titlesId the titles ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByEmpTitles(
		long empId, long titlesId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmpTitles(empId, titlesId, retrieveFromCache);
	}

	/**
	* Removes the emp concurrent titles where empId = &#63; and titlesId = &#63; from the database.
	*
	* @param empId the emp ID
	* @param titlesId the titles ID
	* @return the emp concurrent titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles removeByEmpTitles(
		long empId, long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().removeByEmpTitles(empId, titlesId);
	}

	/**
	* Returns the number of emp concurrent titleses where empId = &#63; and titlesId = &#63;.
	*
	* @param empId the emp ID
	* @param titlesId the titles ID
	* @return the number of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmpTitles(long empId, long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmpTitles(empId, titlesId);
	}

	/**
	* Returns all the emp concurrent titleses where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByEmp(
		long empId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId);
	}

	/**
	* Returns a range of all the emp concurrent titleses where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @return the range of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByEmp(
		long empId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId, start, end);
	}

	/**
	* Returns an ordered range of all the emp concurrent titleses where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByEmp(
		long empId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmp(empId, start, end, orderByComparator);
	}

	/**
	* Returns the first emp concurrent titles in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles findByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().findByEmp_First(empId, orderByComparator);
	}

	/**
	* Returns the first emp concurrent titles in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmp_First(empId, orderByComparator);
	}

	/**
	* Returns the last emp concurrent titles in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles findByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().findByEmp_Last(empId, orderByComparator);
	}

	/**
	* Returns the last emp concurrent titles in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByEmp_Last(empId, orderByComparator);
	}

	/**
	* Returns the emp concurrent titleses before and after the current emp concurrent titles in the ordered set where empId = &#63;.
	*
	* @param empConcurrentTitlesId the primary key of the current emp concurrent titles
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles[] findByEmp_PrevAndNext(
		long empConcurrentTitlesId, long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence()
				   .findByEmp_PrevAndNext(empConcurrentTitlesId, empId,
			orderByComparator);
	}

	/**
	* Removes all the emp concurrent titleses where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmp(empId);
	}

	/**
	* Returns the number of emp concurrent titleses where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmp(empId);
	}

	/**
	* Returns all the emp concurrent titleses where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByTitles(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId);
	}

	/**
	* Returns a range of all the emp concurrent titleses where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @return the range of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByTitles(
		long titlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId, start, end);
	}

	/**
	* Returns an ordered range of all the emp concurrent titleses where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findByTitles(
		long titlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitles(titlesId, start, end, orderByComparator);
	}

	/**
	* Returns the first emp concurrent titles in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles findByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().findByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the first emp concurrent titles in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the last emp concurrent titles in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles findByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().findByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the last emp concurrent titles in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the emp concurrent titleses before and after the current emp concurrent titles in the ordered set where titlesId = &#63;.
	*
	* @param empConcurrentTitlesId the primary key of the current emp concurrent titles
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles[] findByTitles_PrevAndNext(
		long empConcurrentTitlesId, long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence()
				   .findByTitles_PrevAndNext(empConcurrentTitlesId, titlesId,
			orderByComparator);
	}

	/**
	* Removes all the emp concurrent titleses where titlesId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitles(titlesId);
	}

	/**
	* Returns the number of emp concurrent titleses where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the number of matching emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitles(titlesId);
	}

	/**
	* Caches the emp concurrent titles in the entity cache if it is enabled.
	*
	* @param empConcurrentTitles the emp concurrent titles
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles) {
		getPersistence().cacheResult(empConcurrentTitles);
	}

	/**
	* Caches the emp concurrent titleses in the entity cache if it is enabled.
	*
	* @param empConcurrentTitleses the emp concurrent titleses
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> empConcurrentTitleses) {
		getPersistence().cacheResult(empConcurrentTitleses);
	}

	/**
	* Creates a new emp concurrent titles with the primary key. Does not add the emp concurrent titles to the database.
	*
	* @param empConcurrentTitlesId the primary key for the new emp concurrent titles
	* @return the new emp concurrent titles
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles create(
		long empConcurrentTitlesId) {
		return getPersistence().create(empConcurrentTitlesId);
	}

	/**
	* Removes the emp concurrent titles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empConcurrentTitlesId the primary key of the emp concurrent titles
	* @return the emp concurrent titles that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles remove(
		long empConcurrentTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().remove(empConcurrentTitlesId);
	}

	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles updateImpl(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(empConcurrentTitles);
	}

	/**
	* Returns the emp concurrent titles with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException} if it could not be found.
	*
	* @param empConcurrentTitlesId the primary key of the emp concurrent titles
	* @return the emp concurrent titles
	* @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles findByPrimaryKey(
		long empConcurrentTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException {
		return getPersistence().findByPrimaryKey(empConcurrentTitlesId);
	}

	/**
	* Returns the emp concurrent titles with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empConcurrentTitlesId the primary key of the emp concurrent titles
	* @return the emp concurrent titles, or <code>null</code> if a emp concurrent titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.EmpConcurrentTitles fetchByPrimaryKey(
		long empConcurrentTitlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(empConcurrentTitlesId);
	}

	/**
	* Returns all the emp concurrent titleses.
	*
	* @return the emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the emp concurrent titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @return the range of emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the emp concurrent titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp concurrent titleses
	* @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.EmpConcurrentTitles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the emp concurrent titleses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of emp concurrent titleses.
	*
	* @return the number of emp concurrent titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static EmpConcurrentTitlesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (EmpConcurrentTitlesPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					EmpConcurrentTitlesPersistence.class.getName());

			ReferenceRegistry.registerReference(EmpConcurrentTitlesUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(EmpConcurrentTitlesPersistence persistence) {
	}

	private static EmpConcurrentTitlesPersistence _persistence;
}