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

import vn.com.ecopharma.emp.model.ResourceConfig;

/**
 * The persistence interface for the resource config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see ResourceConfigPersistenceImpl
 * @see ResourceConfigUtil
 * @generated
 */
public interface ResourceConfigPersistence extends BasePersistence<ResourceConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceConfigUtil} to access the resource config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the resource config where key = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchResourceConfigException} if it could not be found.
	*
	* @param key the key
	* @return the matching resource config
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig findByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the resource config where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resource config where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByKey(
		java.lang.String key, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the resource config where key = &#63; from the database.
	*
	* @param key the key
	* @return the resource config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig removeByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the number of resource configs where key = &#63;.
	*
	* @param key the key
	* @return the number of matching resource configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resource config where key = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchResourceConfigException} if it could not be found.
	*
	* @param key the key
	* @param type the type
	* @return the matching resource config
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig findByKeyAndType(
		java.lang.String key, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the resource config where key = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @param type the type
	* @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByKeyAndType(
		java.lang.String key, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resource config where key = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param type the type
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByKeyAndType(
		java.lang.String key, java.lang.String type, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the resource config where key = &#63; and type = &#63; from the database.
	*
	* @param key the key
	* @param type the type
	* @return the resource config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig removeByKeyAndType(
		java.lang.String key, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the number of resource configs where key = &#63; and type = &#63;.
	*
	* @param key the key
	* @param type the type
	* @return the number of matching resource configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByKeyAndType(java.lang.String key, java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the resource configs where type = &#63;.
	*
	* @param type the type
	* @return the matching resource configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findByType(
		java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the resource configs where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of resource configs
	* @param end the upper bound of the range of resource configs (not inclusive)
	* @return the range of matching resource configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findByType(
		java.lang.String type, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the resource configs where type = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param start the lower bound of the range of resource configs
	* @param end the upper bound of the range of resource configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching resource configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findByType(
		java.lang.String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first resource config in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resource config
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig findByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the first resource config in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching resource config, or <code>null</code> if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByType_First(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last resource config in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resource config
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig findByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the last resource config in the ordered set where type = &#63;.
	*
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching resource config, or <code>null</code> if a matching resource config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByType_Last(
		java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resource configs before and after the current resource config in the ordered set where type = &#63;.
	*
	* @param resourceConfigId the primary key of the current resource config
	* @param type the type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next resource config
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig[] findByType_PrevAndNext(
		long resourceConfigId, java.lang.String type,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Removes all the resource configs where type = &#63; from the database.
	*
	* @param type the type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of resource configs where type = &#63;.
	*
	* @param type the type
	* @return the number of matching resource configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByType(java.lang.String type)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the resource config in the entity cache if it is enabled.
	*
	* @param resourceConfig the resource config
	*/
	public void cacheResult(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig);

	/**
	* Caches the resource configs in the entity cache if it is enabled.
	*
	* @param resourceConfigs the resource configs
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> resourceConfigs);

	/**
	* Creates a new resource config with the primary key. Does not add the resource config to the database.
	*
	* @param resourceConfigId the primary key for the new resource config
	* @return the new resource config
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig create(
		long resourceConfigId);

	/**
	* Removes the resource config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param resourceConfigId the primary key of the resource config
	* @return the resource config that was removed
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig remove(
		long resourceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	public vn.com.ecopharma.emp.model.ResourceConfig updateImpl(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the resource config with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchResourceConfigException} if it could not be found.
	*
	* @param resourceConfigId the primary key of the resource config
	* @return the resource config
	* @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig findByPrimaryKey(
		long resourceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchResourceConfigException;

	/**
	* Returns the resource config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param resourceConfigId the primary key of the resource config
	* @return the resource config, or <code>null</code> if a resource config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.ResourceConfig fetchByPrimaryKey(
		long resourceConfigId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the resource configs.
	*
	* @return the resource configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the resource configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resource configs
	* @param end the upper bound of the range of resource configs (not inclusive)
	* @return the range of resource configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the resource configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of resource configs
	* @param end the upper bound of the range of resource configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of resource configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.ResourceConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the resource configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of resource configs.
	*
	* @return the number of resource configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}