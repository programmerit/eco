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

import vn.com.ecopharma.emp.model.Specialized;

/**
 * The persistence interface for the specialized service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SpecializedPersistenceImpl
 * @see SpecializedUtil
 * @generated
 */
public interface SpecializedPersistence extends BasePersistence<Specialized> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpecializedUtil} to access the specialized persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the specializeds where level = &#63;.
	*
	* @param level the level
	* @return the matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the specializeds where level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @return the range of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the specializeds where level = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized findByLevel_First(int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the first specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByLevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized findByLevel_Last(int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the last specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByLevel_Last(int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the specializeds before and after the current specialized in the ordered set where level = &#63;.
	*
	* @param specializedId the primary key of the current specialized
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized[] findByLevel_PrevAndNext(
		long specializedId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Removes all the specializeds where level = &#63; from the database.
	*
	* @param level the level
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of specializeds where level = &#63;.
	*
	* @param level the level
	* @return the number of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public int countByLevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the specializeds where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @return the matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the specializeds where level = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param parentId the parent ID
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @return the range of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the specializeds where level = &#63; and parentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param level the level
	* @param parentId the parent ID
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized findByLevelAndParent_First(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the first specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByLevelAndParent_First(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized findByLevelAndParent_Last(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the last specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByLevelAndParent_Last(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the specializeds before and after the current specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param specializedId the primary key of the current specialized
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized[] findByLevelAndParent_PrevAndNext(
		long specializedId, int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Removes all the specializeds where level = &#63; and parentId = &#63; from the database.
	*
	* @param level the level
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLevelAndParent(int level, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of specializeds where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @return the number of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public int countByLevelAndParent(int level, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the specialized where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchSpecializedException} if it could not be found.
	*
	* @param name the name
	* @return the matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the specialized where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the specialized where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the specialized where name = &#63; from the database.
	*
	* @param name the name
	* @return the specialized that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the number of specializeds where name = &#63;.
	*
	* @param name the name
	* @return the number of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the specialized in the entity cache if it is enabled.
	*
	* @param specialized the specialized
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.Specialized specialized);

	/**
	* Caches the specializeds in the entity cache if it is enabled.
	*
	* @param specializeds the specializeds
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Specialized> specializeds);

	/**
	* Creates a new specialized with the primary key. Does not add the specialized to the database.
	*
	* @param specializedId the primary key for the new specialized
	* @return the new specialized
	*/
	public vn.com.ecopharma.emp.model.Specialized create(long specializedId);

	/**
	* Removes the specialized with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized that was removed
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized remove(long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	public vn.com.ecopharma.emp.model.Specialized updateImpl(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the specialized with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchSpecializedException} if it could not be found.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized findByPrimaryKey(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException;

	/**
	* Returns the specialized with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized, or <code>null</code> if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Specialized fetchByPrimaryKey(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the specializeds.
	*
	* @return the specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the specializeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @return the range of specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the specializeds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of specializeds
	* @param end the upper bound of the range of specializeds (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of specializeds
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the specializeds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of specializeds.
	*
	* @return the number of specializeds
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}