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

import vn.com.ecopharma.emp.model.VacationLeave;

/**
 * The persistence interface for the vacation leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacationLeavePersistenceImpl
 * @see VacationLeaveUtil
 * @generated
 */
public interface VacationLeavePersistence extends BasePersistence<VacationLeave> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link VacationLeaveUtil} to access the vacation leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the vacation leaves where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findByEmp(
		long empId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacation leaves where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @return the range of matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findByEmp(
		long empId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacation leaves where empId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findByEmp(
		long empId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vacation leave in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave findByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Returns the first vacation leave in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave fetchByEmp_First(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vacation leave in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave findByEmp_Last(long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Returns the last vacation leave in the ordered set where empId = &#63;.
	*
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave fetchByEmp_Last(
		long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacation leaves before and after the current vacation leave in the ordered set where empId = &#63;.
	*
	* @param vacationLeaveId the primary key of the current vacation leave
	* @param empId the emp ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave[] findByEmp_PrevAndNext(
		long vacationLeaveId, long empId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Removes all the vacation leaves where empId = &#63; from the database.
	*
	* @param empId the emp ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacation leaves where empId = &#63;.
	*
	* @param empId the emp ID
	* @return the number of matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacation leaves where empId = &#63; and leaveType = &#63;.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @return the matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findByEmpAndType(
		long empId, java.lang.String leaveType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacation leaves where empId = &#63; and leaveType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @return the range of matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findByEmpAndType(
		long empId, java.lang.String leaveType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacation leaves where empId = &#63; and leaveType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findByEmpAndType(
		long empId, java.lang.String leaveType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave findByEmpAndType_First(
		long empId, java.lang.String leaveType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Returns the first vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave fetchByEmpAndType_First(
		long empId, java.lang.String leaveType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave findByEmpAndType_Last(
		long empId, java.lang.String leaveType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Returns the last vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave fetchByEmpAndType_Last(
		long empId, java.lang.String leaveType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacation leaves before and after the current vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	*
	* @param vacationLeaveId the primary key of the current vacation leave
	* @param empId the emp ID
	* @param leaveType the leave type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave[] findByEmpAndType_PrevAndNext(
		long vacationLeaveId, long empId, java.lang.String leaveType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Removes all the vacation leaves where empId = &#63; and leaveType = &#63; from the database.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmpAndType(long empId, java.lang.String leaveType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacation leaves where empId = &#63; and leaveType = &#63;.
	*
	* @param empId the emp ID
	* @param leaveType the leave type
	* @return the number of matching vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmpAndType(long empId, java.lang.String leaveType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the vacation leave in the entity cache if it is enabled.
	*
	* @param vacationLeave the vacation leave
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave);

	/**
	* Caches the vacation leaves in the entity cache if it is enabled.
	*
	* @param vacationLeaves the vacation leaves
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.VacationLeave> vacationLeaves);

	/**
	* Creates a new vacation leave with the primary key. Does not add the vacation leave to the database.
	*
	* @param vacationLeaveId the primary key for the new vacation leave
	* @return the new vacation leave
	*/
	public vn.com.ecopharma.emp.model.VacationLeave create(long vacationLeaveId);

	/**
	* Removes the vacation leave with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave that was removed
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave remove(long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	public vn.com.ecopharma.emp.model.VacationLeave updateImpl(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the vacation leave with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchVacationLeaveException} if it could not be found.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave
	* @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave findByPrimaryKey(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchVacationLeaveException;

	/**
	* Returns the vacation leave with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param vacationLeaveId the primary key of the vacation leave
	* @return the vacation leave, or <code>null</code> if a vacation leave with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.VacationLeave fetchByPrimaryKey(
		long vacationLeaveId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the vacation leaves.
	*
	* @return the vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the vacation leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @return the range of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the vacation leaves.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of vacation leaves
	* @param end the upper bound of the range of vacation leaves (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.VacationLeave> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the vacation leaves from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of vacation leaves.
	*
	* @return the number of vacation leaves
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}