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

import vn.com.ecopharma.emp.model.Titles;

/**
 * The persistence interface for the titles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesPersistenceImpl
 * @see TitlesUtil
 * @generated
 */
public interface TitlesPersistence extends BasePersistence<Titles> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TitlesUtil} to access the titles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the titles where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles findByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the titles where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the titles where name = &#63; from the database.
	*
	* @param name the name
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the number of titleses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles findByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByNameAndDepartment(
		java.lang.String name, long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the titles where name = &#63; and departmentId = &#63; from the database.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles removeByNameAndDepartment(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the number of titleses where name = &#63; and departmentId = &#63;.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByNameAndDepartment(java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titleses where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titleses where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titleses where departmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param departmentId the department ID
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findByDepartment(
		long departmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles findByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the first titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByDepartment_First(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles findByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the last titles in the ordered set where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByDepartment_Last(
		long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titleses before and after the current titles in the ordered set where departmentId = &#63;.
	*
	* @param titlesId the primary key of the current titles
	* @param departmentId the department ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles[] findByDepartment_PrevAndNext(
		long titlesId, long departmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Removes all the titleses where departmentId = &#63; from the database.
	*
	* @param departmentId the department ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titleses where departmentId = &#63;.
	*
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByDepartment(long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles findByfindByNameAndRelatedFields(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByfindByNameAndRelatedFields(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param departmentId the department ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching titles, or <code>null</code> if a matching titles could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByfindByNameAndRelatedFields(
		java.lang.String name, long departmentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the titles where name = &#63; and departmentId = &#63; from the database.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the titles that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles removeByfindByNameAndRelatedFields(
		java.lang.String name, long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the number of titleses where name = &#63; and departmentId = &#63;.
	*
	* @param name the name
	* @param departmentId the department ID
	* @return the number of matching titleses
	* @throws SystemException if a system exception occurred
	*/
	public int countByfindByNameAndRelatedFields(java.lang.String name,
		long departmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the titles in the entity cache if it is enabled.
	*
	* @param titles the titles
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.Titles titles);

	/**
	* Caches the titleses in the entity cache if it is enabled.
	*
	* @param titleses the titleses
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Titles> titleses);

	/**
	* Creates a new titles with the primary key. Does not add the titles to the database.
	*
	* @param titlesId the primary key for the new titles
	* @return the new titles
	*/
	public vn.com.ecopharma.emp.model.Titles create(long titlesId);

	/**
	* Removes the titles with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param titlesId the primary key of the titles
	* @return the titles that was removed
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles remove(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	public vn.com.ecopharma.emp.model.Titles updateImpl(
		vn.com.ecopharma.emp.model.Titles titles)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the titles with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	*
	* @param titlesId the primary key of the titles
	* @return the titles
	* @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles findByPrimaryKey(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchTitlesException;

	/**
	* Returns the titles with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param titlesId the primary key of the titles
	* @return the titles, or <code>null</code> if a titles with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Titles fetchByPrimaryKey(long titlesId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the titleses.
	*
	* @return the titleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @return the range of titleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the titleses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of titleses
	* @param end the upper bound of the range of titleses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of titleses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Titles> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the titleses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of titleses.
	*
	* @return the number of titleses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}