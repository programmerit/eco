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

import vn.com.ecopharma.emp.model.TitlesUnitUnitGroup;

/**
 * The persistence interface for the titles unit unit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesUnitUnitGroupPersistenceImpl
 * @see TitlesUnitUnitGroupUtil
 * @generated
 */
public interface TitlesUnitUnitGroupPersistence extends BasePersistence<TitlesUnitUnitGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TitlesUnitUnitGroupUtil} to access the titles unit unit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the titles unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByUnit_PrevAndNext(
		long titlesUnitUnitGroupId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Removes all the titles unit unit groups where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles unit unit groups where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the first titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitGroup_First(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the last titles unit unit group in the ordered set where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitGroup_Last(
		long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByUnitGroup_PrevAndNext(
		long titlesUnitUnitGroupId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Removes all the titles unit unit groups where unitGroupId = &#63; from the database.
	*
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles unit unit groups where unitGroupId = &#63;.
	*
	* @param unitGroupId the unit group ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnitGroup(long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the titles unit unit group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup removeByTitlesUnitUnitGroup(
		long titlesId, long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the number of titles unit unit groups where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	*
	* @param titlesId the titles ID
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitlesUnitUnitGroup(long titlesId, long unitId,
		long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByTitles(
		long titlesId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the first titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitles_First(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the last titles unit unit group in the ordered set where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByTitles_Last(
		long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByTitles_PrevAndNext(
		long titlesUnitUnitGroupId, long titlesId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Removes all the titles unit unit groups where titlesId = &#63; from the database.
	*
	* @param titlesId the titles ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles unit unit groups where titlesId = &#63;.
	*
	* @param titlesId the titles ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByTitles(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the first titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitAndUnitGroup_First(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the last titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup[] findByUnitAndUnitGroup_PrevAndNext(
		long titlesUnitUnitGroupId, long unitId, long unitGroupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Removes all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	*
	* @param unitId the unit ID
	* @param unitGroupId the unit group ID
	* @return the number of matching titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the titles unit unit group in the entity cache if it is enabled.
	*
	* @param titlesUnitUnitGroup the titles unit unit group
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup);

	/**
	* Caches the titles unit unit groups in the entity cache if it is enabled.
	*
	* @param titlesUnitUnitGroups the titles unit unit groups
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> titlesUnitUnitGroups);

	/**
	* Creates a new titles unit unit group with the primary key. Does not add the titles unit unit group to the database.
	*
	* @param titlesUnitUnitGroupId the primary key for the new titles unit unit group
	* @return the new titles unit unit group
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup create(
		long titlesUnitUnitGroupId);

	/**
	* Removes the titles unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group that was removed
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup remove(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup updateImpl(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles unit unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException} if it could not be found.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group
	* @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup findByPrimaryKey(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;

	/**
	* Returns the titles unit unit group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	* @return the titles unit unit group, or <code>null</code> if a titles unit unit group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup fetchByPrimaryKey(
		long titlesUnitUnitGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titles unit unit groups.
	*
	* @return the titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the titles unit unit groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titles unit unit groups.
	*
	* @return the number of titles unit unit groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}