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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchLevelException;
import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.model.impl.LevelImpl;
import vn.com.ecopharma.emp.model.impl.LevelModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the level service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see LevelPersistence
 * @see LevelUtil
 * @generated
 */
public class LevelPersistenceImpl extends BasePersistenceImpl<Level>
	implements LevelPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LevelUtil} to access the level persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LevelImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelModelImpl.FINDER_CACHE_ENABLED, LevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelModelImpl.FINDER_CACHE_ENABLED, LevelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelModelImpl.FINDER_CACHE_ENABLED, LevelImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			LevelModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the level where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchLevelException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching level
	 * @throws vn.com.ecopharma.emp.NoSuchLevelException if a matching level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level findByName(String name)
		throws NoSuchLevelException, SystemException {
		Level level = fetchByName(name);

		if (level == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLevelException(msg.toString());
		}

		return level;
	}

	/**
	 * Returns the level where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching level, or <code>null</code> if a matching level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the level where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching level, or <code>null</code> if a matching level could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Level) {
			Level level = (Level)result;

			if (!Validator.equals(name, level.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LEVEL_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Level> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"LevelPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Level level = list.get(0);

					result = level;

					cacheResult(level);

					if ((level.getName() == null) ||
							!level.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, level);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (Level)result;
		}
	}

	/**
	 * Removes the level where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the level that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level removeByName(String name)
		throws NoSuchLevelException, SystemException {
		Level level = findByName(name);

		return remove(level);
	}

	/**
	 * Returns the number of levels where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LEVEL_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "level.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "level.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(level.name IS NULL OR level.name = '')";

	public LevelPersistenceImpl() {
		setModelClass(Level.class);
	}

	/**
	 * Caches the level in the entity cache if it is enabled.
	 *
	 * @param level the level
	 */
	@Override
	public void cacheResult(Level level) {
		EntityCacheUtil.putResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelImpl.class, level.getPrimaryKey(), level);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { level.getName() }, level);

		level.resetOriginalValues();
	}

	/**
	 * Caches the levels in the entity cache if it is enabled.
	 *
	 * @param levels the levels
	 */
	@Override
	public void cacheResult(List<Level> levels) {
		for (Level level : levels) {
			if (EntityCacheUtil.getResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
						LevelImpl.class, level.getPrimaryKey()) == null) {
				cacheResult(level);
			}
			else {
				level.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all levels.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LevelImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LevelImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the level.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Level level) {
		EntityCacheUtil.removeResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelImpl.class, level.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(level);
	}

	@Override
	public void clearCache(List<Level> levels) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Level level : levels) {
			EntityCacheUtil.removeResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
				LevelImpl.class, level.getPrimaryKey());

			clearUniqueFindersCache(level);
		}
	}

	protected void cacheUniqueFindersCache(Level level) {
		if (level.isNew()) {
			Object[] args = new Object[] { level.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, level);
		}
		else {
			LevelModelImpl levelModelImpl = (LevelModelImpl)level;

			if ((levelModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { level.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, level);
			}
		}
	}

	protected void clearUniqueFindersCache(Level level) {
		LevelModelImpl levelModelImpl = (LevelModelImpl)level;

		Object[] args = new Object[] { level.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((levelModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { levelModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new level with the primary key. Does not add the level to the database.
	 *
	 * @param levelId the primary key for the new level
	 * @return the new level
	 */
	@Override
	public Level create(long levelId) {
		Level level = new LevelImpl();

		level.setNew(true);
		level.setPrimaryKey(levelId);

		return level;
	}

	/**
	 * Removes the level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param levelId the primary key of the level
	 * @return the level that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchLevelException if a level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level remove(long levelId)
		throws NoSuchLevelException, SystemException {
		return remove((Serializable)levelId);
	}

	/**
	 * Removes the level with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the level
	 * @return the level that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchLevelException if a level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level remove(Serializable primaryKey)
		throws NoSuchLevelException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Level level = (Level)session.get(LevelImpl.class, primaryKey);

			if (level == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(level);
		}
		catch (NoSuchLevelException nsee) {
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
	protected Level removeImpl(Level level) throws SystemException {
		level = toUnwrappedModel(level);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(level)) {
				level = (Level)session.get(LevelImpl.class,
						level.getPrimaryKeyObj());
			}

			if (level != null) {
				session.delete(level);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (level != null) {
			clearCache(level);
		}

		return level;
	}

	@Override
	public Level updateImpl(vn.com.ecopharma.emp.model.Level level)
		throws SystemException {
		level = toUnwrappedModel(level);

		boolean isNew = level.isNew();

		Session session = null;

		try {
			session = openSession();

			if (level.isNew()) {
				session.save(level);

				level.setNew(false);
			}
			else {
				session.merge(level);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LevelModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
			LevelImpl.class, level.getPrimaryKey(), level);

		clearUniqueFindersCache(level);
		cacheUniqueFindersCache(level);

		return level;
	}

	protected Level toUnwrappedModel(Level level) {
		if (level instanceof LevelImpl) {
			return level;
		}

		LevelImpl levelImpl = new LevelImpl();

		levelImpl.setNew(level.isNew());
		levelImpl.setPrimaryKey(level.getPrimaryKey());

		levelImpl.setLevelId(level.getLevelId());
		levelImpl.setName(level.getName());
		levelImpl.setLevel(level.getLevel());
		levelImpl.setGroupId(level.getGroupId());
		levelImpl.setCompanyId(level.getCompanyId());
		levelImpl.setUserId(level.getUserId());
		levelImpl.setCreateDate(level.getCreateDate());
		levelImpl.setModifiedDate(level.getModifiedDate());

		return levelImpl;
	}

	/**
	 * Returns the level with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the level
	 * @return the level
	 * @throws vn.com.ecopharma.emp.NoSuchLevelException if a level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLevelException, SystemException {
		Level level = fetchByPrimaryKey(primaryKey);

		if (level == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLevelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return level;
	}

	/**
	 * Returns the level with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchLevelException} if it could not be found.
	 *
	 * @param levelId the primary key of the level
	 * @return the level
	 * @throws vn.com.ecopharma.emp.NoSuchLevelException if a level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level findByPrimaryKey(long levelId)
		throws NoSuchLevelException, SystemException {
		return findByPrimaryKey((Serializable)levelId);
	}

	/**
	 * Returns the level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the level
	 * @return the level, or <code>null</code> if a level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Level level = (Level)EntityCacheUtil.getResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
				LevelImpl.class, primaryKey);

		if (level == _nullLevel) {
			return null;
		}

		if (level == null) {
			Session session = null;

			try {
				session = openSession();

				level = (Level)session.get(LevelImpl.class, primaryKey);

				if (level != null) {
					cacheResult(level);
				}
				else {
					EntityCacheUtil.putResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
						LevelImpl.class, primaryKey, _nullLevel);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(LevelModelImpl.ENTITY_CACHE_ENABLED,
					LevelImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return level;
	}

	/**
	 * Returns the level with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param levelId the primary key of the level
	 * @return the level, or <code>null</code> if a level with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Level fetchByPrimaryKey(long levelId) throws SystemException {
		return fetchByPrimaryKey((Serializable)levelId);
	}

	/**
	 * Returns all the levels.
	 *
	 * @return the levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Level> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.LevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of levels
	 * @param end the upper bound of the range of levels (not inclusive)
	 * @return the range of levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Level> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the levels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.LevelModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of levels
	 * @param end the upper bound of the range of levels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of levels
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Level> findAll(int start, int end,
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

		List<Level> list = (List<Level>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LEVEL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LEVEL;

				if (pagination) {
					sql = sql.concat(LevelModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Level>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Level>(list);
				}
				else {
					list = (List<Level>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the levels from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Level level : findAll()) {
			remove(level);
		}
	}

	/**
	 * Returns the number of levels.
	 *
	 * @return the number of levels
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

				Query q = session.createQuery(_SQL_COUNT_LEVEL);

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

	/**
	 * Initializes the level persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Level")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Level>> listenersList = new ArrayList<ModelListener<Level>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Level>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(LevelImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_LEVEL = "SELECT level FROM Level level";
	private static final String _SQL_SELECT_LEVEL_WHERE = "SELECT level FROM Level level WHERE ";
	private static final String _SQL_COUNT_LEVEL = "SELECT COUNT(level) FROM Level level";
	private static final String _SQL_COUNT_LEVEL_WHERE = "SELECT COUNT(level) FROM Level level WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "level.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Level exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Level exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LevelPersistenceImpl.class);
	private static Level _nullLevel = new LevelImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Level> toCacheModel() {
				return _nullLevelCacheModel;
			}
		};

	private static CacheModel<Level> _nullLevelCacheModel = new CacheModel<Level>() {
			@Override
			public Level toEntityModel() {
				return _nullLevel;
			}
		};
}