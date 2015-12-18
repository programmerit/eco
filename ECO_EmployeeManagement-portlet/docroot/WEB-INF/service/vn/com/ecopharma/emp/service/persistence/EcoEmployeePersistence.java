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

import vn.com.ecopharma.emp.model.EcoEmployee;

/**
 * The persistence interface for the eco employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EcoEmployeePersistenceImpl
 * @see EcoEmployeeUtil
 * @generated
 */
public interface EcoEmployeePersistence extends BasePersistence<EcoEmployee> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EcoEmployeeUtil} to access the eco employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the eco employee in the entity cache if it is enabled.
	*
	* @param ecoEmployee the eco employee
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee);

	/**
	* Caches the eco employees in the entity cache if it is enabled.
	*
	* @param ecoEmployees the eco employees
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> ecoEmployees);

	/**
	* Creates a new eco employee with the primary key. Does not add the eco employee to the database.
	*
	* @param ecoEmployeeId the primary key for the new eco employee
	* @return the new eco employee
	*/
	public vn.com.ecopharma.emp.model.EcoEmployee create(long ecoEmployeeId);

	/**
	* Removes the eco employee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ecoEmployeeId the primary key of the eco employee
	* @return the eco employee that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEcoEmployeeException if a eco employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EcoEmployee remove(long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEcoEmployeeException;

	public vn.com.ecopharma.emp.model.EcoEmployee updateImpl(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the eco employee with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEcoEmployeeException} if it could not be found.
	*
	* @param ecoEmployeeId the primary key of the eco employee
	* @return the eco employee
	* @throws vn.com.ecopharma.emp.NoSuchEcoEmployeeException if a eco employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EcoEmployee findByPrimaryKey(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEcoEmployeeException;

	/**
	* Returns the eco employee with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ecoEmployeeId the primary key of the eco employee
	* @return the eco employee, or <code>null</code> if a eco employee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EcoEmployee fetchByPrimaryKey(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the eco employees.
	*
	* @return the eco employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the eco employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EcoEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eco employees
	* @param end the upper bound of the range of eco employees (not inclusive)
	* @return the range of eco employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the eco employees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EcoEmployeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eco employees
	* @param end the upper bound of the range of eco employees (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eco employees
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the eco employees from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of eco employees.
	*
	* @return the number of eco employees
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}