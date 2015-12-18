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

import vn.com.ecopharma.emp.model.UnitGroup;

import java.util.List;

/**
 * The persistence utility for the unit group service. This utility wraps {@link UnitGroupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see UnitGroupPersistence
 * @see UnitGroupPersistenceImpl
 * @generated
 */
public class UnitGroupUtil {
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
	public static void clearCache(UnitGroup unitGroup) {
		getPersistence().clearCache(unitGroup);
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
	public static List<UnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UnitGroup> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static UnitGroup update(UnitGroup unitGroup)
		throws SystemException {
		return getPersistence().update(unitGroup);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static UnitGroup update(UnitGroup unitGroup,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(unitGroup, serviceContext);
	}

	/**
	* Returns all the unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId);
	}

	/**
	* Returns a range of all the unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of unit groups
	* @param end the upper bound of the range of unit groups (not inclusive)
	* @return the range of matching unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end);
	}

	/**
	* Returns an ordered range of all the unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of unit groups
	* @param end the upper bound of the range of unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end, orderByComparator);
	}

	/**
	* Returns the first unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit group
	* @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence().findByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the first unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit group, or <code>null</code> if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the last unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit group
	* @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence().findByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the last unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit group, or <code>null</code> if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the unit groups before and after the current unit group in the ordered set where unitId = &#63;.
	*
	* @param unitGroupId the primary key of the current unit group
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next unit group
	* @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup[] findByUnit_PrevAndNext(
		long unitGroupId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence()
				   .findByUnit_PrevAndNext(unitGroupId, unitId,
			orderByComparator);
	}

	/**
	* Removes all the unit groups where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnit(unitId);
	}

	/**
	* Returns the number of unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnit(unitId);
	}

	/**
	* Returns the unit group where name = &#63; and unitId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUnitGroupException} if it could not be found.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the matching unit group
	* @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup findByNameAndUnit(
		java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence().findByNameAndUnit(name, unitId);
	}

	/**
	* Returns the unit group where name = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the matching unit group, or <code>null</code> if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup fetchByNameAndUnit(
		java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByNameAndUnit(name, unitId);
	}

	/**
	* Returns the unit group where name = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param unitId the unit ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching unit group, or <code>null</code> if a matching unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup fetchByNameAndUnit(
		java.lang.String name, long unitId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndUnit(name, unitId, retrieveFromCache);
	}

	/**
	* Removes the unit group where name = &#63; and unitId = &#63; from the database.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup removeByNameAndUnit(
		java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence().removeByNameAndUnit(name, unitId);
	}

	/**
	* Returns the number of unit groups where name = &#63; and unitId = &#63;.
	*
	* @param name the name
	* @param unitId the unit ID
	* @return the number of matching unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndUnit(java.lang.String name, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndUnit(name, unitId);
	}

	/**
	* Caches the unit group in the entity cache if it is enabled.
	*
	* @param unitGroup the unit group
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		getPersistence().cacheResult(unitGroup);
	}

	/**
	* Caches the unit groups in the entity cache if it is enabled.
	*
	* @param unitGroups the unit groups
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.UnitGroup> unitGroups) {
		getPersistence().cacheResult(unitGroups);
	}

	/**
	* Creates a new unit group with the primary key. Does not add the unit group to the database.
	*
	* @param unitGroupId the primary key for the new unit group
	* @return the new unit group
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup create(long unitGroupId) {
		return getPersistence().create(unitGroupId);
	}

	/**
	* Removes the unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitGroupId the primary key of the unit group
	* @return the unit group that was removed
	* @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup remove(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence().remove(unitGroupId);
	}

	public static vn.com.ecopharma.emp.model.UnitGroup updateImpl(
		vn.com.ecopharma.emp.model.UnitGroup unitGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(unitGroup);
	}

	/**
	* Returns the unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchUnitGroupException} if it could not be found.
	*
	* @param unitGroupId the primary key of the unit group
	* @return the unit group
	* @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup findByPrimaryKey(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitGroupException {
		return getPersistence().findByPrimaryKey(unitGroupId);
	}

	/**
	* Returns the unit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param unitGroupId the primary key of the unit group
	* @return the unit group, or <code>null</code> if a unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.UnitGroup fetchByPrimaryKey(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(unitGroupId);
	}

	/**
	* Returns all the unit groups.
	*
	* @return the unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unit groups
	* @param end the upper bound of the range of unit groups (not inclusive)
	* @return the range of unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of unit groups
	* @param end the upper bound of the range of unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.UnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the unit groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of unit groups.
	*
	* @return the number of unit groups
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static UnitGroupPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (UnitGroupPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					UnitGroupPersistence.class.getName());

			ReferenceRegistry.registerReference(UnitGroupUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(UnitGroupPersistence persistence) {
	}

	private static UnitGroupPersistence _persistence;
}