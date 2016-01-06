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

import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;

/**
 * The persistence interface for the titles department unit unit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesDepartmentUnitUnitGroupPersistenceImpl
 * @see TitlesDepartmentUnitUnitGroupUtil
 * @generated
 */
public interface TitlesDepartmentUnitUnitGroupPersistence
	extends BasePersistence<TitlesDepartmentUnitUnitGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TitlesDepartmentUnitUnitGroupUtil} to access the titles department unit unit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the titles department unit unit groups where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where departmentId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByDepartment_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByUnit_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where unitGroupId = &#63; from the database.
	*
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitles(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitles(
		long titlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where titlesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitles(
		long titlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByTitles_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where titlesId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartmentUnitUnitGroup_First(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartmentUnitUnitGroup_First(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByDepartmentUnitUnitGroup_Last(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByDepartmentUnitUnitGroup_Last(
		long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByDepartmentUnitUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long departmentId, long unitId,
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartmentUnitUnitGroup(long departmentId, long unitId,
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartmentUnitUnitGroup(long departmentId, long unitId,
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException} if it could not be found.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the titles department unit unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup removeByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the number of titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitlesDepartmentUnitUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByUnitAndUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitNoneUnitGroup_First(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the first titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitNoneUnitGroup_First(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitNoneUnitGroup_Last(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the last titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitNoneUnitGroup_Last(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup[] findByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long titlesId, long departmentId,
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Removes all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitlesDepartmentUnitNoneUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param departmentId the department ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitlesDepartmentUnitNoneUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the titles department unit unit group in the entity cache if it is enabled.
	*
	* @param titlesDepartmentUnitUnitGroup the titles department unit unit group
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup);

	/**
	* Caches the titles department unit unit groups in the entity cache if it is enabled.
	*
	* @param titlesDepartmentUnitUnitGroups the titles department unit unit groups
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> titlesDepartmentUnitUnitGroups);

	/**
	* Creates a new titles department unit unit group with the primary key. Does not add the titles department unit unit group to the database.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key for the new titles department unit unit group
	* @return the new titles department unit unit group
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup create(
		long titlesDepartmentUnitUnitGroupId);

	/**
	* Removes the titles department unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group that was removed
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup remove(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup updateImpl(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles department unit unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException} if it could not be found.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup findByPrimaryKey(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;

	/**
	* Returns the titles department unit unit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	* @return the titles department unit unit group, or <code>null</code> if a titles department unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup fetchByPrimaryKey(
		long titlesDepartmentUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles department unit unit groups.
	*
	* @return the titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titles department unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @return the range of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titles department unit unit groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titles department unit unit groups
	* @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the titles department unit unit groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles department unit unit groups.
	*
	* @return the number of titles department unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}