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

import vn.com.ecopharma.emp.model.EmpAnualLeave;

/**
 * The persistence interface for the emp anual leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpAnualLeavePersistenceImpl
 * @see EmpAnualLeaveUtil
 * @generated
 */
public interface EmpAnualLeavePersistence extends BasePersistence<EmpAnualLeave> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EmpAnualLeaveUtil} to access the emp anual leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the emp anual leave in the entity cache if it is enabled.
	*
	* @param empAnualLeave the emp anual leave
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.EmpAnualLeave empAnualLeave);

	/**
	* Caches the emp anual leaves in the entity cache if it is enabled.
	*
	* @param empAnualLeaves the emp anual leaves
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.EmpAnualLeave> empAnualLeaves);

	/**
	* Creates a new emp anual leave with the primary key. Does not add the emp anual leave to the database.
	*
	* @param empAnualLeaveId the primary key for the new emp anual leave
	* @return the new emp anual leave
	*/
	public vn.com.ecopharma.emp.model.EmpAnualLeave create(long empAnualLeaveId);

	/**
	* Removes the emp anual leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param empAnualLeaveId the primary key of the emp anual leave
	* @return the emp anual leave that was removed
	* @throws vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException if a emp anual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmpAnualLeave remove(long empAnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException;

	public vn.com.ecopharma.emp.model.EmpAnualLeave updateImpl(
		vn.com.ecopharma.emp.model.EmpAnualLeave empAnualLeave)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the emp anual leave with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException} if it could not be found.
	*
	* @param empAnualLeaveId the primary key of the emp anual leave
	* @return the emp anual leave
	* @throws vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException if a emp anual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmpAnualLeave findByPrimaryKey(
		long empAnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException;

	/**
	* Returns the emp anual leave with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param empAnualLeaveId the primary key of the emp anual leave
	* @return the emp anual leave, or <code>null</code> if a emp anual leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.EmpAnualLeave fetchByPrimaryKey(
		long empAnualLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the emp anual leaves.
	*
	* @return the emp anual leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnualLeave> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the emp anual leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp anual leaves
	* @param end the upper bound of the range of emp anual leaves (not inclusive)
	* @return the range of emp anual leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnualLeave> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the emp anual leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of emp anual leaves
	* @param end the upper bound of the range of emp anual leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of emp anual leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.EmpAnualLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the emp anual leaves from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of emp anual leaves.
	*
	* @return the number of emp anual leaves
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}