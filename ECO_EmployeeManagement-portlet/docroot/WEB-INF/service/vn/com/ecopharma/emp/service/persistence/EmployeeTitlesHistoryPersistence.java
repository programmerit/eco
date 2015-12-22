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

import vn.com.ecopharma.emp.model.EmployeeTitlesHistory;

/**
 * The persistence interface for the employee titles history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmployeeTitlesHistoryPersistenceImpl
 * @see EmployeeTitlesHistoryUtil
 * @generated
 */
public interface EmployeeTitlesHistoryPersistence extends BasePersistence<EmployeeTitlesHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmployeeTitlesHistoryUtil} to access the employee titles history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the employee titles history in the entity cache if it is enabled.
	*
	* @param employeeTitlesHistory the employee titles history
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.EmployeeTitlesHistory employeeTitlesHistory);

	/**
	* Caches the employee titles histories in the entity cache if it is enabled.
	*
	* @param employeeTitlesHistories the employee titles histories
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> employeeTitlesHistories);

	/**
	* Creates a new employee titles history with the primary key. Does not add the employee titles history to the database.
	*
	* @param employeeTitlesHistoryId the primary key for the new employee titles history
	* @return the new employee titles history
	*/
	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory create(
		long employeeTitlesHistoryId);

	/**
	* Removes the employee titles history with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employeeTitlesHistoryId the primary key of the employee titles history
	* @return the employee titles history that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory remove(
		long employeeTitlesHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException;

	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory updateImpl(
		vn.com.ecopharma.emp.model.EmployeeTitlesHistory employeeTitlesHistory)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the employee titles history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException} if it could not be found.
	*
	* @param employeeTitlesHistoryId the primary key of the employee titles history
	* @return the employee titles history
	* @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory findByPrimaryKey(
		long employeeTitlesHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException;

	/**
	* Returns the employee titles history with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employeeTitlesHistoryId the primary key of the employee titles history
	* @return the employee titles history, or <code>null</code> if a employee titles history with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory fetchByPrimaryKey(
		long employeeTitlesHistoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the employee titles histories.
	*
	* @return the employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the employee titles histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee titles histories
	* @param end the upper bound of the range of employee titles histories (not inclusive)
	* @return the range of employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the employee titles histories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employee titles histories
	* @param end the upper bound of the range of employee titles histories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the employee titles histories from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of employee titles histories.
	*
	* @return the number of employee titles histories
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}