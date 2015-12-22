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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchResourceConfigException;
import vn.com.ecopharma.emp.model.ResourceConfig;
import vn.com.ecopharma.emp.model.impl.ResourceConfigImpl;
import vn.com.ecopharma.emp.model.impl.ResourceConfigModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the resource config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see ResourceConfigPersistence
 * @see ResourceConfigUtil
 * @generated
 */
public class ResourceConfigPersistenceImpl extends BasePersistenceImpl<ResourceConfig>
	implements ResourceConfigPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResourceConfigUtil} to access the resource config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResourceConfigImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED,
			ResourceConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED,
			ResourceConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_KEY = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED,
			ResourceConfigImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByKey",
			new String[] { String.class.getName() },
			ResourceConfigModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] { String.class.getName() });

	/**
	 * Returns the resource config where key = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchResourceConfigException} if it could not be found.
	 *
	 * @param key the key
	 * @return the matching resource config
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig findByKey(String key)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = fetchByKey(key);

		if (resourceConfig == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchResourceConfigException(msg.toString());
		}

		return resourceConfig;
	}

	/**
	 * Returns the resource config where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByKey(String key) throws SystemException {
		return fetchByKey(key, true);
	}

	/**
	 * Returns the resource config where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByKey(String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEY,
					finderArgs, this);
		}

		if (result instanceof ResourceConfig) {
			ResourceConfig resourceConfig = (ResourceConfig)result;

			if (!Validator.equals(key, resourceConfig.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RESOURCECONFIG_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				List<ResourceConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ResourceConfigPersistenceImpl.fetchByKey(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ResourceConfig resourceConfig = list.get(0);

					result = resourceConfig;

					cacheResult(resourceConfig);

					if ((resourceConfig.getKey() == null) ||
							!resourceConfig.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
							finderArgs, resourceConfig);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ResourceConfig)result;
		}
	}

	/**
	 * Removes the resource config where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the resource config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig removeByKey(String key)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = findByKey(key);

		return remove(resourceConfig);
	}

	/**
	 * Returns the number of resource configs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching resource configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKey(String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEY;

		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESOURCECONFIG_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_KEY_KEY_1 = "resourceConfig.key IS NULL";
	private static final String _FINDER_COLUMN_KEY_KEY_2 = "resourceConfig.key = ?";
	private static final String _FINDER_COLUMN_KEY_KEY_3 = "(resourceConfig.key IS NULL OR resourceConfig.key = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_KEYANDTYPE = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED,
			ResourceConfigImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByKeyAndType",
			new String[] { String.class.getName(), String.class.getName() },
			ResourceConfigModelImpl.KEY_COLUMN_BITMASK |
			ResourceConfigModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEYANDTYPE = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKeyAndType",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the resource config where key = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchResourceConfigException} if it could not be found.
	 *
	 * @param key the key
	 * @param type the type
	 * @return the matching resource config
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig findByKeyAndType(String key, String type)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = fetchByKeyAndType(key, type);

		if (resourceConfig == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchResourceConfigException(msg.toString());
		}

		return resourceConfig;
	}

	/**
	 * Returns the resource config where key = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @param type the type
	 * @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByKeyAndType(String key, String type)
		throws SystemException {
		return fetchByKeyAndType(key, type, true);
	}

	/**
	 * Returns the resource config where key = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param type the type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching resource config, or <code>null</code> if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByKeyAndType(String key, String type,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { key, type };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEYANDTYPE,
					finderArgs, this);
		}

		if (result instanceof ResourceConfig) {
			ResourceConfig resourceConfig = (ResourceConfig)result;

			if (!Validator.equals(key, resourceConfig.getKey()) ||
					!Validator.equals(type, resourceConfig.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_RESOURCECONFIG_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEYANDTYPE_KEY_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_KEYANDTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				if (bindType) {
					qPos.add(type);
				}

				List<ResourceConfig> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"ResourceConfigPersistenceImpl.fetchByKeyAndType(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					ResourceConfig resourceConfig = list.get(0);

					result = resourceConfig;

					cacheResult(resourceConfig);

					if ((resourceConfig.getKey() == null) ||
							!resourceConfig.getKey().equals(key) ||
							(resourceConfig.getType() == null) ||
							!resourceConfig.getType().equals(type)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDTYPE,
							finderArgs, resourceConfig);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDTYPE,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ResourceConfig)result;
		}
	}

	/**
	 * Removes the resource config where key = &#63; and type = &#63; from the database.
	 *
	 * @param key the key
	 * @param type the type
	 * @return the resource config that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig removeByKeyAndType(String key, String type)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = findByKeyAndType(key, type);

		return remove(resourceConfig);
	}

	/**
	 * Returns the number of resource configs where key = &#63; and type = &#63;.
	 *
	 * @param key the key
	 * @param type the type
	 * @return the number of matching resource configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByKeyAndType(String key, String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_KEYANDTYPE;

		Object[] finderArgs = new Object[] { key, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RESOURCECONFIG_WHERE);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_KEYANDTYPE_KEY_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEYANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_KEYANDTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindKey) {
					qPos.add(key);
				}

				if (bindType) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_KEYANDTYPE_KEY_1 = "resourceConfig.key IS NULL AND ";
	private static final String _FINDER_COLUMN_KEYANDTYPE_KEY_2 = "resourceConfig.key = ? AND ";
	private static final String _FINDER_COLUMN_KEYANDTYPE_KEY_3 = "(resourceConfig.key IS NULL OR resourceConfig.key = '') AND ";
	private static final String _FINDER_COLUMN_KEYANDTYPE_TYPE_1 = "resourceConfig.type IS NULL";
	private static final String _FINDER_COLUMN_KEYANDTYPE_TYPE_2 = "resourceConfig.type = ?";
	private static final String _FINDER_COLUMN_KEYANDTYPE_TYPE_3 = "(resourceConfig.type IS NULL OR resourceConfig.type = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED,
			ResourceConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED,
			ResourceConfigImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			ResourceConfigModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the resource configs where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching resource configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResourceConfig> findByType(String type)
		throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ResourceConfig> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

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
	@Override
	public List<ResourceConfig> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<ResourceConfig> list = (List<ResourceConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResourceConfig resourceConfig : list) {
				if (!Validator.equals(type, resourceConfig.getType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RESOURCECONFIG_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResourceConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<ResourceConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResourceConfig>(list);
				}
				else {
					list = (List<ResourceConfig>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first resource config in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource config
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = fetchByType_First(type,
				orderByComparator);

		if (resourceConfig != null) {
			return resourceConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResourceConfigException(msg.toString());
	}

	/**
	 * Returns the first resource config in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource config, or <code>null</code> if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResourceConfig> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource config in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource config
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = fetchByType_Last(type, orderByComparator);

		if (resourceConfig != null) {
			return resourceConfig;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResourceConfigException(msg.toString());
	}

	/**
	 * Returns the last resource config in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource config, or <code>null</code> if a matching resource config could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<ResourceConfig> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ResourceConfig[] findByType_PrevAndNext(long resourceConfigId,
		String type, OrderByComparator orderByComparator)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = findByPrimaryKey(resourceConfigId);

		Session session = null;

		try {
			session = openSession();

			ResourceConfig[] array = new ResourceConfigImpl[3];

			array[0] = getByType_PrevAndNext(session, resourceConfig, type,
					orderByComparator, true);

			array[1] = resourceConfig;

			array[2] = getByType_PrevAndNext(session, resourceConfig, type,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResourceConfig getByType_PrevAndNext(Session session,
		ResourceConfig resourceConfig, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESOURCECONFIG_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ResourceConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(resourceConfig);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResourceConfig> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource configs where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(String type) throws SystemException {
		for (ResourceConfig resourceConfig : findByType(type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(resourceConfig);
		}
	}

	/**
	 * Returns the number of resource configs where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching resource configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESOURCECONFIG_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "resourceConfig.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "resourceConfig.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(resourceConfig.type IS NULL OR resourceConfig.type = '')";

	public ResourceConfigPersistenceImpl() {
		setModelClass(ResourceConfig.class);
	}

	/**
	 * Caches the resource config in the entity cache if it is enabled.
	 *
	 * @param resourceConfig the resource config
	 */
	@Override
	public void cacheResult(ResourceConfig resourceConfig) {
		EntityCacheUtil.putResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigImpl.class, resourceConfig.getPrimaryKey(),
			resourceConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY,
			new Object[] { resourceConfig.getKey() }, resourceConfig);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDTYPE,
			new Object[] { resourceConfig.getKey(), resourceConfig.getType() },
			resourceConfig);

		resourceConfig.resetOriginalValues();
	}

	/**
	 * Caches the resource configs in the entity cache if it is enabled.
	 *
	 * @param resourceConfigs the resource configs
	 */
	@Override
	public void cacheResult(List<ResourceConfig> resourceConfigs) {
		for (ResourceConfig resourceConfig : resourceConfigs) {
			if (EntityCacheUtil.getResult(
						ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
						ResourceConfigImpl.class, resourceConfig.getPrimaryKey()) == null) {
				cacheResult(resourceConfig);
			}
			else {
				resourceConfig.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all resource configs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResourceConfigImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResourceConfigImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resource config.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResourceConfig resourceConfig) {
		EntityCacheUtil.removeResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigImpl.class, resourceConfig.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(resourceConfig);
	}

	@Override
	public void clearCache(List<ResourceConfig> resourceConfigs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResourceConfig resourceConfig : resourceConfigs) {
			EntityCacheUtil.removeResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
				ResourceConfigImpl.class, resourceConfig.getPrimaryKey());

			clearUniqueFindersCache(resourceConfig);
		}
	}

	protected void cacheUniqueFindersCache(ResourceConfig resourceConfig) {
		if (resourceConfig.isNew()) {
			Object[] args = new Object[] { resourceConfig.getKey() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
				resourceConfig);

			args = new Object[] {
					resourceConfig.getKey(), resourceConfig.getType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDTYPE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDTYPE, args,
				resourceConfig);
		}
		else {
			ResourceConfigModelImpl resourceConfigModelImpl = (ResourceConfigModelImpl)resourceConfig;

			if ((resourceConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { resourceConfig.getKey() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEY, args,
					resourceConfig);
			}

			if ((resourceConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEYANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						resourceConfig.getKey(), resourceConfig.getType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDTYPE,
					args, resourceConfig);
			}
		}
	}

	protected void clearUniqueFindersCache(ResourceConfig resourceConfig) {
		ResourceConfigModelImpl resourceConfigModelImpl = (ResourceConfigModelImpl)resourceConfig;

		Object[] args = new Object[] { resourceConfig.getKey() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);

		if ((resourceConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEY.getColumnBitmask()) != 0) {
			args = new Object[] { resourceConfigModelImpl.getOriginalKey() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEY, args);
		}

		args = new Object[] { resourceConfig.getKey(), resourceConfig.getType() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDTYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDTYPE, args);

		if ((resourceConfigModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_KEYANDTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					resourceConfigModelImpl.getOriginalKey(),
					resourceConfigModelImpl.getOriginalType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDTYPE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDTYPE, args);
		}
	}

	/**
	 * Creates a new resource config with the primary key. Does not add the resource config to the database.
	 *
	 * @param resourceConfigId the primary key for the new resource config
	 * @return the new resource config
	 */
	@Override
	public ResourceConfig create(long resourceConfigId) {
		ResourceConfig resourceConfig = new ResourceConfigImpl();

		resourceConfig.setNew(true);
		resourceConfig.setPrimaryKey(resourceConfigId);

		return resourceConfig;
	}

	/**
	 * Removes the resource config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceConfigId the primary key of the resource config
	 * @return the resource config that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig remove(long resourceConfigId)
		throws NoSuchResourceConfigException, SystemException {
		return remove((Serializable)resourceConfigId);
	}

	/**
	 * Removes the resource config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource config
	 * @return the resource config that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig remove(Serializable primaryKey)
		throws NoSuchResourceConfigException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResourceConfig resourceConfig = (ResourceConfig)session.get(ResourceConfigImpl.class,
					primaryKey);

			if (resourceConfig == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResourceConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(resourceConfig);
		}
		catch (NoSuchResourceConfigException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ResourceConfig removeImpl(ResourceConfig resourceConfig)
		throws SystemException {
		resourceConfig = toUnwrappedModel(resourceConfig);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resourceConfig)) {
				resourceConfig = (ResourceConfig)session.get(ResourceConfigImpl.class,
						resourceConfig.getPrimaryKeyObj());
			}

			if (resourceConfig != null) {
				session.delete(resourceConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (resourceConfig != null) {
			clearCache(resourceConfig);
		}

		return resourceConfig;
	}

	@Override
	public ResourceConfig updateImpl(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig)
		throws SystemException {
		resourceConfig = toUnwrappedModel(resourceConfig);

		boolean isNew = resourceConfig.isNew();

		ResourceConfigModelImpl resourceConfigModelImpl = (ResourceConfigModelImpl)resourceConfig;

		Session session = null;

		try {
			session = openSession();

			if (resourceConfig.isNew()) {
				session.save(resourceConfig);

				resourceConfig.setNew(false);
			}
			else {
				session.merge(resourceConfig);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ResourceConfigModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((resourceConfigModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						resourceConfigModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { resourceConfigModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
			ResourceConfigImpl.class, resourceConfig.getPrimaryKey(),
			resourceConfig);

		clearUniqueFindersCache(resourceConfig);
		cacheUniqueFindersCache(resourceConfig);

		return resourceConfig;
	}

	protected ResourceConfig toUnwrappedModel(ResourceConfig resourceConfig) {
		if (resourceConfig instanceof ResourceConfigImpl) {
			return resourceConfig;
		}

		ResourceConfigImpl resourceConfigImpl = new ResourceConfigImpl();

		resourceConfigImpl.setNew(resourceConfig.isNew());
		resourceConfigImpl.setPrimaryKey(resourceConfig.getPrimaryKey());

		resourceConfigImpl.setResourceConfigId(resourceConfig.getResourceConfigId());
		resourceConfigImpl.setKey(resourceConfig.getKey());
		resourceConfigImpl.setValue(resourceConfig.getValue());
		resourceConfigImpl.setType(resourceConfig.getType());
		resourceConfigImpl.setGroupId(resourceConfig.getGroupId());
		resourceConfigImpl.setCompanyId(resourceConfig.getCompanyId());
		resourceConfigImpl.setUserId(resourceConfig.getUserId());
		resourceConfigImpl.setUserName(resourceConfig.getUserName());
		resourceConfigImpl.setCreateDate(resourceConfig.getCreateDate());
		resourceConfigImpl.setModifiedDate(resourceConfig.getModifiedDate());

		return resourceConfigImpl;
	}

	/**
	 * Returns the resource config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource config
	 * @return the resource config
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResourceConfigException, SystemException {
		ResourceConfig resourceConfig = fetchByPrimaryKey(primaryKey);

		if (resourceConfig == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResourceConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return resourceConfig;
	}

	/**
	 * Returns the resource config with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchResourceConfigException} if it could not be found.
	 *
	 * @param resourceConfigId the primary key of the resource config
	 * @return the resource config
	 * @throws vn.com.ecopharma.emp.NoSuchResourceConfigException if a resource config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig findByPrimaryKey(long resourceConfigId)
		throws NoSuchResourceConfigException, SystemException {
		return findByPrimaryKey((Serializable)resourceConfigId);
	}

	/**
	 * Returns the resource config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource config
	 * @return the resource config, or <code>null</code> if a resource config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ResourceConfig resourceConfig = (ResourceConfig)EntityCacheUtil.getResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
				ResourceConfigImpl.class, primaryKey);

		if (resourceConfig == _nullResourceConfig) {
			return null;
		}

		if (resourceConfig == null) {
			Session session = null;

			try {
				session = openSession();

				resourceConfig = (ResourceConfig)session.get(ResourceConfigImpl.class,
						primaryKey);

				if (resourceConfig != null) {
					cacheResult(resourceConfig);
				}
				else {
					EntityCacheUtil.putResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
						ResourceConfigImpl.class, primaryKey,
						_nullResourceConfig);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ResourceConfigModelImpl.ENTITY_CACHE_ENABLED,
					ResourceConfigImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return resourceConfig;
	}

	/**
	 * Returns the resource config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceConfigId the primary key of the resource config
	 * @return the resource config, or <code>null</code> if a resource config with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResourceConfig fetchByPrimaryKey(long resourceConfigId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)resourceConfigId);
	}

	/**
	 * Returns all the resource configs.
	 *
	 * @return the resource configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResourceConfig> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ResourceConfig> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ResourceConfig> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<ResourceConfig> list = (List<ResourceConfig>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESOURCECONFIG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCECONFIG;

				if (pagination) {
					sql = sql.concat(ResourceConfigModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ResourceConfig>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResourceConfig>(list);
				}
				else {
					list = (List<ResourceConfig>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the resource configs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ResourceConfig resourceConfig : findAll()) {
			remove(resourceConfig);
		}
	}

	/**
	 * Returns the number of resource configs.
	 *
	 * @return the number of resource configs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RESOURCECONFIG);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the resource config persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.ResourceConfig")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResourceConfig>> listenersList = new ArrayList<ModelListener<ResourceConfig>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResourceConfig>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(ResourceConfigImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RESOURCECONFIG = "SELECT resourceConfig FROM ResourceConfig resourceConfig";
	private static final String _SQL_SELECT_RESOURCECONFIG_WHERE = "SELECT resourceConfig FROM ResourceConfig resourceConfig WHERE ";
	private static final String _SQL_COUNT_RESOURCECONFIG = "SELECT COUNT(resourceConfig) FROM ResourceConfig resourceConfig";
	private static final String _SQL_COUNT_RESOURCECONFIG_WHERE = "SELECT COUNT(resourceConfig) FROM ResourceConfig resourceConfig WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resourceConfig.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResourceConfig exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResourceConfig exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResourceConfigPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key", "type"
			});
	private static ResourceConfig _nullResourceConfig = new ResourceConfigImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResourceConfig> toCacheModel() {
				return _nullResourceConfigCacheModel;
			}
		};

	private static CacheModel<ResourceConfig> _nullResourceConfigCacheModel = new CacheModel<ResourceConfig>() {
			@Override
			public ResourceConfig toEntityModel() {
				return _nullResourceConfig;
			}
		};
}