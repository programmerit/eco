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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.Specialized;

import java.util.List;

/**
 * The persistence utility for the specialized service. This utility wraps {@link SpecializedPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SpecializedPersistence
 * @see SpecializedPersistenceImpl
 * @generated
 */
public class SpecializedUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Specialized specialized) {
		getPersistence().clearCache(specialized);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Specialized> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Specialized> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Specialized> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Specialized update(Specialized specialized)
		throws SystemException {
		return getPersistence().update(specialized);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Specialized update(Specialized specialized,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(specialized, serviceContext);
	}

	/**
	* Returns all the specializeds where level = &#63;.
	*
	* @param level the level
	* @return the matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevel(level);
	}

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
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevel(level, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevel(
		int level, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevel(level, start, end, orderByComparator);
	}

	/**
	* Returns the first specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized findByLevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence().findByLevel_First(level, orderByComparator);
	}

	/**
	* Returns the first specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByLevel_First(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLevel_First(level, orderByComparator);
	}

	/**
	* Returns the last specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized findByLevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence().findByLevel_Last(level, orderByComparator);
	}

	/**
	* Returns the last specialized in the ordered set where level = &#63;.
	*
	* @param level the level
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByLevel_Last(
		int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByLevel_Last(level, orderByComparator);
	}

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
	public static vn.com.ecopharma.emp.model.Specialized[] findByLevel_PrevAndNext(
		long specializedId, int level,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence()
				   .findByLevel_PrevAndNext(specializedId, level,
			orderByComparator);
	}

	/**
	* Removes all the specializeds where level = &#63; from the database.
	*
	* @param level the level
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLevel(level);
	}

	/**
	* Returns the number of specializeds where level = &#63;.
	*
	* @param level the level
	* @return the number of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLevel(int level)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLevel(level);
	}

	/**
	* Returns all the specializeds where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @return the matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndParent(level, parentId);
	}

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
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLevelAndParent(level, parentId, start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findByLevelAndParent(
		int level, long parentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLevelAndParent(level, parentId, start, end,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.emp.model.Specialized findByLevelAndParent_First(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence()
				   .findByLevelAndParent_First(level, parentId,
			orderByComparator);
	}

	/**
	* Returns the first specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByLevelAndParent_First(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndParent_First(level, parentId,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.emp.model.Specialized findByLevelAndParent_Last(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence()
				   .findByLevelAndParent_Last(level, parentId, orderByComparator);
	}

	/**
	* Returns the last specialized in the ordered set where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByLevelAndParent_Last(
		int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLevelAndParent_Last(level, parentId,
			orderByComparator);
	}

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
	public static vn.com.ecopharma.emp.model.Specialized[] findByLevelAndParent_PrevAndNext(
		long specializedId, int level, long parentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence()
				   .findByLevelAndParent_PrevAndNext(specializedId, level,
			parentId, orderByComparator);
	}

	/**
	* Removes all the specializeds where level = &#63; and parentId = &#63; from the database.
	*
	* @param level the level
	* @param parentId the parent ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLevelAndParent(int level, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLevelAndParent(level, parentId);
	}

	/**
	* Returns the number of specializeds where level = &#63; and parentId = &#63;.
	*
	* @param level the level
	* @param parentId the parent ID
	* @return the number of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLevelAndParent(int level, long parentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLevelAndParent(level, parentId);
	}

	/**
	* Returns the specialized where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchSpecializedException} if it could not be found.
	*
	* @param name the name
	* @return the matching specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the specialized where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the specialized where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching specialized, or <code>null</code> if a matching specialized could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the specialized where name = &#63; from the database.
	*
	* @param name the name
	* @return the specialized that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of specializeds where name = &#63;.
	*
	* @param name the name
	* @return the number of matching specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the specialized in the entity cache if it is enabled.
	*
	* @param specialized the specialized
	*/
	public static void cacheResult(
		vn.com.ecopharma.emp.model.Specialized specialized) {
		getPersistence().cacheResult(specialized);
	}

	/**
	* Caches the specializeds in the entity cache if it is enabled.
	*
	* @param specializeds the specializeds
	*/
	public static void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Specialized> specializeds) {
		getPersistence().cacheResult(specializeds);
	}

	/**
	* Creates a new specialized with the primary key. Does not add the specialized to the database.
	*
	* @param specializedId the primary key for the new specialized
	* @return the new specialized
	*/
	public static vn.com.ecopharma.emp.model.Specialized create(
		long specializedId) {
		return getPersistence().create(specializedId);
	}

	/**
	* Removes the specialized with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized that was removed
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized remove(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence().remove(specializedId);
	}

	public static vn.com.ecopharma.emp.model.Specialized updateImpl(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(specialized);
	}

	/**
	* Returns the specialized with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchSpecializedException} if it could not be found.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized
	* @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized findByPrimaryKey(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchSpecializedException {
		return getPersistence().findByPrimaryKey(specializedId);
	}

	/**
	* Returns the specialized with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param specializedId the primary key of the specialized
	* @return the specialized, or <code>null</code> if a specialized with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static vn.com.ecopharma.emp.model.Specialized fetchByPrimaryKey(
		long specializedId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(specializedId);
	}

	/**
	* Returns all the specializeds.
	*
	* @return the specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<vn.com.ecopharma.emp.model.Specialized> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the specializeds from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of specializeds.
	*
	* @return the number of specializeds
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SpecializedPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SpecializedPersistence)PortletBeanLocatorUtil.locate(vn.com.ecopharma.emp.service.ClpSerializer.getServletContextName(),
					SpecializedPersistence.class.getName());

			ReferenceRegistry.registerReference(SpecializedUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SpecializedPersistence persistence) {
	}

	private static SpecializedPersistence _persistence;
}