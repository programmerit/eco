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

import vn.com.ecopharma.emp.model.TitlesUnitUnitGroup;

import java.util.List;

/**
 * The persistence utility for the titles unit unit group service. This utility wraps {@link TitlesUnitUnitGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesUnitUnitGroupPersistence
 * @see TitlesUnitUnitGroupPersistenceImpl
 * @generated
 */
public class TitlesUnitUnitGroupUtil {
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
	public static void clearCache(TitlesUnitUnitGroup titlesUnitUnitGroup) {
		getPersistence().clearCache(titlesUnitUnitGroup);
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
	public static List<TitlesUnitUnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TitlesUnitUnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TitlesUnitUnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TitlesUnitUnitGroup update(
		TitlesUnitUnitGroup titlesUnitUnitGroup) throws SystemException {
		return getPersistence().update(titlesUnitUnitGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TitlesUnitUnitGroup update(
		TitlesUnitUnitGroup titlesUnitUnitGroup, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(titlesUnitUnitGroup, serviceContext);
	}

	/**
	* Returns all the titles unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId);
	}

	/**
	* Returns a range of all the titles unit unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @return the range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end);
	}

	/**
	* Returns an ordered range of all the titles unit unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence().findByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence().findByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByUnit_PrevAndNext(
		long titlesUnitUnitGroupId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnit_PrevAndNext(titlesUnitUnitGroupId, unitId,
			orderByComparator);
	}

	/**
	* Removes all the titles unit unit groups where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnit(unitId);
	}

	/**
	* Returns the number of titles unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnit(unitId);
	}

	/**
	* Returns all the titles unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitGroup(unitGroupId);
	}

	/**
	* Returns a range of all the titles unit unit groups where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @return the range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitGroup(unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titles unit unit groups where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitGroup(unitGroupId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnitGroup_First(unitGroupId, orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitGroup_First(unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnitGroup_Last(unitGroupId, orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitGroup_Last(unitGroupId, orderByComparator);
	}

	/**
	* Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByUnitGroup_PrevAndNext(
		long titlesUnitUnitGroupId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnitGroup_PrevAndNext(titlesUnitUnitGroupId,
			unitGroupId, orderByComparator);
	}

	/**
	* Removes all the titles unit unit groups where unitGroupId = &#63; from the database.
	*
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnitGroup(unitGroupId);
	}

	/**
	* Returns the number of titles unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnitGroup(unitGroupId);
	}

	/**
	* Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException} if it could not be found.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId);
	}

	/**
	* Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId);
	}

	/**
	* Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId,
			retrieveFromCache);
	}

	/**
	* Removes the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the titles unit unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup removeByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .removeByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId);
	}

	/**
	* Returns the number of titles unit unit groups where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitlesUnitUnitGroup(long titlesId, long unitId,
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId);
	}

	/**
	* Returns all the titles unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId);
	}

	/**
	* Returns a range of all the titles unit unit groups where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @return the range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTitles(titlesId, start, end);
	}

	/**
	* Returns an ordered range of all the titles unit unit groups where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTitles(titlesId, start, end, orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence().findByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_First(titlesId, orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence().findByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByTitles_Last(titlesId, orderByComparator);
	}

	/**
	* Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByTitles_PrevAndNext(
		long titlesUnitUnitGroupId, long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByTitles_PrevAndNext(titlesUnitUnitGroupId, titlesId,
			orderByComparator);
	}

	/**
	* Removes all the titles unit unit groups where titlesId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTitles(titlesId);
	}

	/**
	* Returns the number of titles unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTitles(titlesId);
	}

	/**
	* Returns all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitAndUnitGroup(unitId, unitGroupId);
	}

	/**
	* Returns a range of all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @return the range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitAndUnitGroup(unitId, unitGroupId, start, end);
	}

	/**
	* Returns an ordered range of all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitAndUnitGroup(unitId, unitGroupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnitAndUnitGroup_First(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitAndUnitGroup_First(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnitAndUnitGroup_Last(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitAndUnitGroup_Last(unitId, unitGroupId,
			orderByComparator);
	}

	/**
	* Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByUnitAndUnitGroup_PrevAndNext(
		long titlesUnitUnitGroupId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence()
				   .findByUnitAndUnitGroup_PrevAndNext(titlesUnitUnitGroupId,
			unitId, unitGroupId, orderByComparator);
	}

	/**
	* Removes all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnitAndUnitGroup(unitId, unitGroupId);
	}

	/**
	* Returns the number of titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnitAndUnitGroup(unitId, unitGroupId);
	}

	/**
	* Caches the titles unit unit group in the entity cache if it is enabled.
	*
	* @param titlesUnitUnitGroup the titles unit unit group
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup) {
		getPersistence().cacheResult(titlesUnitUnitGroup);
	}

	/**
	* Caches the titles unit unit groups in the entity cache if it is enabled.
	*
	* @param titlesUnitUnitGroups the titles unit unit groups
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> titlesUnitUnitGroups) {
		getPersistence().cacheResult(titlesUnitUnitGroups);
	}

	/**
	* Creates a new titles unit unit group with the primary key. Does not add the titles unit unit group to the database.
	*
	* @param titlesUnitUnitGroupId the primary key for the new titles unit unit group
	* @return the new titles unit unit group
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup create(
		long titlesUnitUnitGroupId) {
		return getPersistence().create(titlesUnitUnitGroupId);
	}

	/**
	* Removes the titles unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group that was removed
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup remove(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence().remove(titlesUnitUnitGroupId);
	}

	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup updateImpl(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(titlesUnitUnitGroup);
	}

	/**
	* Returns the titles unit unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException} if it could not be found.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByPrimaryKey(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException {
		return getPersistence().findByPrimaryKey(titlesUnitUnitGroupId);
	}

	/**
	* Returns the titles unit unit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group, or <code>null</code> if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByPrimaryKey(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(titlesUnitUnitGroupId);
	}

	/**
	* Returns all the titles unit unit groups.
	*
	* @return the titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the titles unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @return the range of titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the titles unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles unit unit groups
	* @param end the upper bound of the range of titles unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the titles unit unit groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of titles unit unit groups.
	*
	* @return the number of titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TitlesUnitUnitGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TitlesUnitUnitGroupPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					TitlesUnitUnitGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(TitlesUnitUnitGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TitlesUnitUnitGroupPersistence persistence) {
	}

	private static TitlesUnitUnitGroupPersistence _persistence;
}