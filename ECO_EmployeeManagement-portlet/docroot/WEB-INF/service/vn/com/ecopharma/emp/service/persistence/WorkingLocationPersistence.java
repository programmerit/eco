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

import vn.com.ecopharma.emp.model.WorkingLocation;

/**
 * The persistence interface for the working location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see WorkingLocationPersistenceImpl
 * @see WorkingLocationUtil
 * @generated
 */
public interface WorkingLocationPersistence extends BasePersistence<WorkingLocation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkingLocationUtil} to access the working location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the working location in the entity cache if it is enabled.
	*
	* @param workingLocation the working location
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation);

	/**
	* Caches the working locations in the entity cache if it is enabled.
	*
	* @param workingLocations the working locations
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> workingLocations);

	/**
	* Creates a new working location with the primary key. Does not add the working location to the database.
	*
	* @param workingLocationId the primary key for the new working location
	* @return the new working location
	*/
	public vn.com.ecopharma.emp.model.WorkingLocation create(
		long workingLocationId);

	/**
	* Removes the working location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workingLocationId the primary key of the working location
	* @return the working location that was removed
	* @throws vn.com.ecopharma.emp.NoSuchWorkingLocationException if a working location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.WorkingLocation remove(
		long workingLocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchWorkingLocationException;

	public vn.com.ecopharma.emp.model.WorkingLocation updateImpl(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the working location with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchWorkingLocationException} if it could not be found.
	*
	* @param workingLocationId the primary key of the working location
	* @return the working location
	* @throws vn.com.ecopharma.emp.NoSuchWorkingLocationException if a working location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.WorkingLocation findByPrimaryKey(
		long workingLocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchWorkingLocationException;

	/**
	* Returns the working location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workingLocationId the primary key of the working location
	* @return the working location, or <code>null</code> if a working location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.WorkingLocation fetchByPrimaryKey(
		long workingLocationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the working locations.
	*
	* @return the working locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the working locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working locations
	* @param end the upper bound of the range of working locations (not inclusive)
	* @return the range of working locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the working locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of working locations
	* @param end the upper bound of the range of working locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of working locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.WorkingLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the working locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of working locations.
	*
	* @return the number of working locations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}