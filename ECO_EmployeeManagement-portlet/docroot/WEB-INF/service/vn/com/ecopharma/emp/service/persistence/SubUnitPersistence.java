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

import vn.com.ecopharma.emp.model.SubUnit;

/**
 * The persistence interface for the sub unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SubUnitPersistenceImpl
 * @see SubUnitUtil
 * @generated
 */
public interface SubUnitPersistence extends BasePersistence<SubUnit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubUnitUtil} to access the sub unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the sub unit where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchSubUnitException} if it could not be found.
	*
	* @param name the name
	* @return the matching sub unit
	* @throws vn.com.ecopharma.emp.NoSuchSubUnitException if a matching sub unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException;

	/**
	* Returns the sub unit where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching sub unit, or <code>null</code> if a matching sub unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sub unit where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching sub unit, or <code>null</code> if a matching sub unit could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the sub unit where name = &#63; from the database.
	*
	* @param name the name
	* @return the sub unit that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException;

	/**
	* Returns the number of sub units where name = &#63;.
	*
	* @param name the name
	* @return the number of matching sub units
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the sub unit in the entity cache if it is enabled.
	*
	* @param subUnit the sub unit
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.SubUnit subUnit);

	/**
	* Caches the sub units in the entity cache if it is enabled.
	*
	* @param subUnits the sub units
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.SubUnit> subUnits);

	/**
	* Creates a new sub unit with the primary key. Does not add the sub unit to the database.
	*
	* @param subUnitId the primary key for the new sub unit
	* @return the new sub unit
	*/
	public vn.com.ecopharma.emp.model.SubUnit create(long subUnitId);

	/**
	* Removes the sub unit with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit that was removed
	* @throws vn.com.ecopharma.emp.NoSuchSubUnitException if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit remove(long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException;

	public vn.com.ecopharma.emp.model.SubUnit updateImpl(
		vn.com.ecopharma.emp.model.SubUnit subUnit)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the sub unit with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchSubUnitException} if it could not be found.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit
	* @throws vn.com.ecopharma.emp.NoSuchSubUnitException if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit findByPrimaryKey(long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSubUnitException;

	/**
	* Returns the sub unit with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param subUnitId the primary key of the sub unit
	* @return the sub unit, or <code>null</code> if a sub unit with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.SubUnit fetchByPrimaryKey(long subUnitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the sub units.
	*
	* @return the sub units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the sub units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sub units
	* @param end the upper bound of the range of sub units (not inclusive)
	* @return the range of sub units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the sub units.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SubUnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of sub units
	* @param end the upper bound of the range of sub units (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of sub units
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.SubUnit> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the sub units from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of sub units.
	*
	* @return the number of sub units
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}