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

import vn.com.ecopharma.emp.model.Titles;

import java.util.List;

/**
 * The persistence utility for the titles service. This utility wraps {@link TitlesPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesPersistence
 * @see TitlesPersistenceImpl
 * @generated
 */
public class TitlesUtil {
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
	public static void clearCache(Titles titles) {
		getPersistence().clearCache(titles);
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
	public static List<Titles> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Titles> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Titles> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Titles update(Titles titles) throws SystemException {
		return getPersistence().update(titles);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Titles update(Titles titles, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(titles, serviceContext);
	}

	/**
	* Returns the titles where name = &#63; and unitId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByNameAndUnit(
		java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByNameAndUnit(name, unitId);
	}

	/**
	* Returns the titles where name = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameAndUnit(
		java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndUnit(name, unitId);
	}

	/**
	* Returns the titles where name = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param unitId the unit ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameAndUnit(
		java.lang.String name, long unitId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndUnit(name, unitId, retrieveFromCache);
	}

	/**
	* Removes the titles where name = &#63; and unitId = &#63; from the database.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles removeByNameAndUnit(
		java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().removeByNameAndUnit(name, unitId);
	}

	/**
	* Returns the number of titleses where name = &#63; and unitId = &#63;.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndUnit(java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndUnit(name, unitId);
	}

	/**
	* Returns the titles where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the titles where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the titles where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the titles where name = &#63; from the database.
	*
	* @param name the name
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of titleses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the titleses where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId);
	}

	/**
	* Returns a range of all the titleses where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end);
	}

	/**
	* Returns an ordered range of all the titleses where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the first titles in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the last titles in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the last titles in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the titleses before and after the current titles in the ordered set where unitId = &#63;.
	*
	* @param titlesId the primary key of the current titles
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles[] findByUnit_PrevAndNext(
		long titlesId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByUnit_PrevAndNext(titlesId, unitId, orderByComparator);
	}

	/**
	* Removes all the titleses where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnit(unitId);
	}

	/**
	* Returns the number of titleses where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnit(unitId);
	}

	/**
	* Returns all the titleses where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnitGroup(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitGroup(unitGroupId);
	}

	/**
	* Returns a range of all the titleses where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnitGroup(
		long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitGroup(unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titleses where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByUnitGroup(
		long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitGroup(unitGroupId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByUnitGroup_First(unitGroupId, orderByComparator);
	}

	/**
	* Returns the first titles in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitGroup_First(unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByUnitGroup_Last(unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitGroup_Last(unitGroupId, orderByComparator);
	}

	/**
	* Returns the titleses before and after the current titles in the ordered set where unitGroupId = &#63;.
	*
	* @param titlesId the primary key of the current titles
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles[] findByUnitGroup_PrevAndNext(
		long titlesId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByUnitGroup_PrevAndNext(titlesId, unitGroupId,
			orderByComparator);
	}

	/**
	* Removes all the titleses where unitGroupId = &#63; from the database.
	*
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnitGroup(unitGroupId);
	}

	/**
	* Returns the number of titleses where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnitGroup(unitGroupId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByNameAndUnitGroup(
		java.lang.String name, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByNameAndUnitGroup(name, unitGroupId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameAndUnitGroup(
		java.lang.String name, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndUnitGroup(name, unitGroupId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameAndUnitGroup(
		java.lang.String name, long unitGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndUnitGroup(name, unitGroupId, retrieveFromCache);
	}

	/**
	* Removes the titles where name = &#63; and unitGroupId = &#63; from the database.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles removeByNameAndUnitGroup(
		java.lang.String name, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().removeByNameAndUnitGroup(name, unitGroupId);
	}

	/**
	* Returns the number of titleses where name = &#63; and unitGroupId = &#63;.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndUnitGroup(java.lang.String name,
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndUnitGroup(name, unitGroupId);
	}

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByNameAndDepartment(name, departmentId);
	}

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndDepartment(name, departmentId);
	}

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameAndDepartment(
		java.lang.String name, long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndDepartment(name, departmentId,
			retrieveFromCache);
	}

	/**
	* Removes the titles where name = &#63; and departmentId = &#63; from the database.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles removeByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().removeByNameAndDepartment(name, departmentId);
	}

	/**
	* Returns the number of titleses where name = &#63; and departmentId = &#63;.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndDepartment(java.lang.String name,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndDepartment(name, departmentId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByNameUnitGroupUnitDepartment(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByNameUnitGroupUnitDepartment(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameUnitGroupUnitDepartment(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameUnitGroupUnitDepartment(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByNameUnitGroupUnitDepartment(
		java.lang.String name, long unitGroupId, long unitId,
		long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameUnitGroupUnitDepartment(name, unitGroupId,
			unitId, departmentId, retrieveFromCache);
	}

	/**
	* Removes the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; from the database.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles removeByNameUnitGroupUnitDepartment(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .removeByNameUnitGroupUnitDepartment(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Returns the number of titleses where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63;.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameUnitGroupUnitDepartment(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByNameUnitGroupUnitDepartment(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Returns all the titleses where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartment(departmentId);
	}

	/**
	* Returns a range of all the titleses where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDepartment(departmentId, start, end);
	}

	/**
	* Returns an ordered range of all the titleses where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDepartment(departmentId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByDepartment_First(departmentId, orderByComparator);
	}

	/**
	* Returns the first titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_First(departmentId, orderByComparator);
	}

	/**
	* Returns the last titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByDepartment_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the last titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDepartment_Last(departmentId, orderByComparator);
	}

	/**
	* Returns the titleses before and after the current titles in the ordered set where departmentId = &#63;.
	*
	* @param titlesId the primary key of the current titles
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles[] findByDepartment_PrevAndNext(
		long titlesId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByDepartment_PrevAndNext(titlesId, departmentId,
			orderByComparator);
	}

	/**
	* Removes all the titleses where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDepartment(departmentId);
	}

	/**
	* Returns the number of titleses where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDepartment(departmentId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByfindByNameAndRelatedFields(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .findByfindByNameAndRelatedFields(name, unitGroupId, unitId,
			departmentId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByfindByNameAndRelatedFields(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByNameAndRelatedFields(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Returns the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByfindByNameAndRelatedFields(
		java.lang.String name, long unitGroupId, long unitId,
		long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByfindByNameAndRelatedFields(name, unitGroupId,
			unitId, departmentId, retrieveFromCache);
	}

	/**
	* Removes the titles where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63; from the database.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles removeByfindByNameAndRelatedFields(
		java.lang.String name, long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence()
				   .removeByfindByNameAndRelatedFields(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Returns the number of titleses where name = &#63; and unitGroupId = &#63; and unitId = &#63; and departmentId = &#63;.
	*
	* @param name the name
	* @param unitGroupId the unit group ID
	* @param unitId the unit ID
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByfindByNameAndRelatedFields(java.lang.String name,
		long unitGroupId, long unitId, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByfindByNameAndRelatedFields(name, unitGroupId,
			unitId, departmentId);
	}

	/**
	* Caches the titles in the entity cache if it is enabled.
	*
	* @param titles the titles
	*/
	public static void cacheResult(vn.com.ecopharma.emp.model.Titles titles) {
		getPersistence().cacheResult(titles);
	}

	/**
	* Caches the titleses in the entity cache if it is enabled.
	*
	* @param titleses the titleses
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Titles> titleses) {
		getPersistence().cacheResult(titleses);
	}

	/**
	* Creates a new titles with the primary key. Does not add the titles to the database.
	*
	* @param titlesId the primary key for the new titles
	* @return the new titles
	*/
	public static vn.com.ecopharma.emp.model.Titles create(long titlesId) {
		return getPersistence().create(titlesId);
	}

	/**
	* Removes the titles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesId the primary key of the titles
	* @return the titles that was removed
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles remove(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().remove(titlesId);
	}

	public static vn.com.ecopharma.emp.model.Titles updateImpl(
		vn.com.ecopharma.emp.model.Titles titles)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(titles);
	}

	/**
	* Returns the titles with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param titlesId the primary key of the titles
	* @return the titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles findByPrimaryKey(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException {
		return getPersistence().findByPrimaryKey(titlesId);
	}

	/**
	* Returns the titles with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titlesId the primary key of the titles
	* @return the titles, or <code>null</code> if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Titles fetchByPrimaryKey(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(titlesId);
	}

	/**
	* Returns all the titleses.
	*
	* @return the titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of titleses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Titles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the titleses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of titleses.
	*
	* @return the number of titleses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TitlesPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TitlesPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					TitlesPersistence.class.getName());

			ReferenceRegistry.registerReference(TitlesUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TitlesPersistence persistence) {
	}

	private static TitlesPersistence _persistence;
}