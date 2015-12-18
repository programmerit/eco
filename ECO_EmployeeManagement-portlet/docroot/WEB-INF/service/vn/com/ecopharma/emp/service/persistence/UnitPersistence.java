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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.com.ecopharma.emp.model.Unit;

/**
 * The persistence interface for the unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see UnitPersistenceImpl
 * @see UnitUtil
 * @generated
 */
public interface UnitPersistence extends BasePersistence<Unit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UnitUtil} to access the unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the unit where name = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUnitException} if it could not be found.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching unit
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit findByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the unit where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching unit, or <code>null</code> if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching unit, or <code>null</code> if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByNameAndDepartment(
		java.lang.String name, long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the unit where name = &#63; and departmentId = &#63; from the database.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit removeByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the number of units where name = &#63; and departmentId = &#63;.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the number of matching units
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameAndDepartment(java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the units where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findByDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the units where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of units
	* @param end the upper bound of the range of units (not inclusive)
	* @return the range of matching units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findByDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the units where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of units
	* @param end the upper bound of the range of units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findByDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first unit in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit findByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the first unit in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching unit, or <code>null</code> if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last unit in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit findByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the last unit in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching unit, or <code>null</code> if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the units before and after the current unit in the ordered set where departmentId = &#63;.
	*
	* @param unitId the primary key of the current unit
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next unit
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit[] findByDepartment_PrevAndNext(
		long unitId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Removes all the units where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of units where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching units
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUnitException} if it could not be found.
	*
	* @param name the name
	* @return the matching unit
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the unit where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching unit, or <code>null</code> if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching unit, or <code>null</code> if a matching unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByName(java.lang.String name,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the unit where name = &#63; from the database.
	*
	* @param name the name
	* @return the unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the number of units where name = &#63;.
	*
	* @param name the name
	* @return the number of matching units
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the unit in the entity cache if it is enabled.
	*
	* @param unit the unit
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.Unit unit);

	/**
	* Caches the units in the entity cache if it is enabled.
	*
	* @param units the units
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Unit> units);

	/**
	* Creates a new unit with the primary key. Does not add the unit to the database.
	*
	* @param unitId the primary key for the new unit
	* @return the new unit
	*/
	public vn.com.ecopharma.emp.model.Unit create(long unitId);

	/**
	* Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param unitId the primary key of the unit
	* @return the unit that was removed
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit remove(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	public vn.com.ecopharma.emp.model.Unit updateImpl(
		vn.com.ecopharma.emp.model.Unit unit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the unit with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchUnitException} if it could not be found.
	*
	* @param unitId the primary key of the unit
	* @return the unit
	* @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit findByPrimaryKey(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchUnitException;

	/**
	* Returns the unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param unitId the primary key of the unit
	* @return the unit, or <code>null</code> if a unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Unit fetchByPrimaryKey(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the units.
	*
	* @return the units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of units
	* @param end the upper bound of the range of units (not inclusive)
	* @return the range of units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of units
	* @param end the upper bound of the range of units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Unit> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of units.
	*
	* @return the number of units
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}