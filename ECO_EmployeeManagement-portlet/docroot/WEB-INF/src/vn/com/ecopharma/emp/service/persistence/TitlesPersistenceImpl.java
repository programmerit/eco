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

import vn.com.ecopharma.emp.NoSuchTitlesException;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.impl.TitlesImpl;
import vn.com.ecopharma.emp.model.impl.TitlesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the titles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesPersistence
 * @see TitlesUtil
 * @generated
 */
public class TitlesPersistenceImpl extends BasePersistenceImpl<Titles>
	implements TitlesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TitlesUtil} to access the titles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TitlesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesModelImpl.FINDER_CACHE_ENABLED, TitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesModelImpl.FINDER_CACHE_ENABLED, TitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesModelImpl.FINDER_CACHE_ENABLED, TitlesImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			TitlesModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the titles where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching titles
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesException if a matching titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles findByName(String name)
		throws NoSuchTitlesException, SystemException {
		Titles titles = fetchByName(name);

		if (titles == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTitlesException(msg.toString());
		}

		return titles;
	}

	/**
	 * Returns the titles where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching titles, or <code>null</code> if a matching titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the titles where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching titles, or <code>null</code> if a matching titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Titles) {
			Titles titles = (Titles)result;

			if (!Validator.equals(name, titles.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TITLES_WHERE);

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

				List<Titles> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TitlesPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Titles titles = list.get(0);

					result = titles;

					cacheResult(titles);

					if ((titles.getName() == null) ||
							!titles.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, titles);
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
			return (Titles)result;
		}
	}

	/**
	 * Removes the titles where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the titles that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles removeByName(String name)
		throws NoSuchTitlesException, SystemException {
		Titles titles = findByName(name);

		return remove(titles);
	}

	/**
	 * Returns the number of titleses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching titleses
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

			query.append(_SQL_COUNT_TITLES_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "titles.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "titles.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(titles.name IS NULL OR titles.name = '')";

	public TitlesPersistenceImpl() {
		setModelClass(Titles.class);
	}

	/**
	 * Caches the titles in the entity cache if it is enabled.
	 *
	 * @param titles the titles
	 */
	@Override
	public void cacheResult(Titles titles) {
		EntityCacheUtil.putResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesImpl.class, titles.getPrimaryKey(), titles);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { titles.getName() }, titles);

		titles.resetOriginalValues();
	}

	/**
	 * Caches the titleses in the entity cache if it is enabled.
	 *
	 * @param titleses the titleses
	 */
	@Override
	public void cacheResult(List<Titles> titleses) {
		for (Titles titles : titleses) {
			if (EntityCacheUtil.getResult(
						TitlesModelImpl.ENTITY_CACHE_ENABLED, TitlesImpl.class,
						titles.getPrimaryKey()) == null) {
				cacheResult(titles);
			}
			else {
				titles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all titleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TitlesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TitlesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Titles titles) {
		EntityCacheUtil.removeResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesImpl.class, titles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(titles);
	}

	@Override
	public void clearCache(List<Titles> titleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Titles titles : titleses) {
			EntityCacheUtil.removeResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
				TitlesImpl.class, titles.getPrimaryKey());

			clearUniqueFindersCache(titles);
		}
	}

	protected void cacheUniqueFindersCache(Titles titles) {
		if (titles.isNew()) {
			Object[] args = new Object[] { titles.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, titles);
		}
		else {
			TitlesModelImpl titlesModelImpl = (TitlesModelImpl)titles;

			if ((titlesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { titles.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					titles);
			}
		}
	}

	protected void clearUniqueFindersCache(Titles titles) {
		TitlesModelImpl titlesModelImpl = (TitlesModelImpl)titles;

		Object[] args = new Object[] { titles.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((titlesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { titlesModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new titles with the primary key. Does not add the titles to the database.
	 *
	 * @param titlesId the primary key for the new titles
	 * @return the new titles
	 */
	@Override
	public Titles create(long titlesId) {
		Titles titles = new TitlesImpl();

		titles.setNew(true);
		titles.setPrimaryKey(titlesId);

		return titles;
	}

	/**
	 * Removes the titles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param titlesId the primary key of the titles
	 * @return the titles that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles remove(long titlesId)
		throws NoSuchTitlesException, SystemException {
		return remove((Serializable)titlesId);
	}

	/**
	 * Removes the titles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the titles
	 * @return the titles that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles remove(Serializable primaryKey)
		throws NoSuchTitlesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Titles titles = (Titles)session.get(TitlesImpl.class, primaryKey);

			if (titles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTitlesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(titles);
		}
		catch (NoSuchTitlesException nsee) {
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
	protected Titles removeImpl(Titles titles) throws SystemException {
		titles = toUnwrappedModel(titles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(titles)) {
				titles = (Titles)session.get(TitlesImpl.class,
						titles.getPrimaryKeyObj());
			}

			if (titles != null) {
				session.delete(titles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (titles != null) {
			clearCache(titles);
		}

		return titles;
	}

	@Override
	public Titles updateImpl(vn.com.ecopharma.emp.model.Titles titles)
		throws SystemException {
		titles = toUnwrappedModel(titles);

		boolean isNew = titles.isNew();

		Session session = null;

		try {
			session = openSession();

			if (titles.isNew()) {
				session.save(titles);

				titles.setNew(false);
			}
			else {
				session.merge(titles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TitlesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
			TitlesImpl.class, titles.getPrimaryKey(), titles);

		clearUniqueFindersCache(titles);
		cacheUniqueFindersCache(titles);

		return titles;
	}

	protected Titles toUnwrappedModel(Titles titles) {
		if (titles instanceof TitlesImpl) {
			return titles;
		}

		TitlesImpl titlesImpl = new TitlesImpl();

		titlesImpl.setNew(titles.isNew());
		titlesImpl.setPrimaryKey(titles.getPrimaryKey());

		titlesImpl.setTitlesId(titles.getTitlesId());
		titlesImpl.setName(titles.getName());
		titlesImpl.setName_en(titles.getName_en());
		titlesImpl.setCode(titles.getCode());
		titlesImpl.setGroupId(titles.getGroupId());
		titlesImpl.setCompanyId(titles.getCompanyId());
		titlesImpl.setUserId(titles.getUserId());
		titlesImpl.setCreateDate(titles.getCreateDate());
		titlesImpl.setModifiedDate(titles.getModifiedDate());

		return titlesImpl;
	}

	/**
	 * Returns the titles with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the titles
	 * @return the titles
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTitlesException, SystemException {
		Titles titles = fetchByPrimaryKey(primaryKey);

		if (titles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTitlesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return titles;
	}

	/**
	 * Returns the titles with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesException} if it could not be found.
	 *
	 * @param titlesId the primary key of the titles
	 * @return the titles
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesException if a titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles findByPrimaryKey(long titlesId)
		throws NoSuchTitlesException, SystemException {
		return findByPrimaryKey((Serializable)titlesId);
	}

	/**
	 * Returns the titles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the titles
	 * @return the titles, or <code>null</code> if a titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Titles titles = (Titles)EntityCacheUtil.getResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
				TitlesImpl.class, primaryKey);

		if (titles == _nullTitles) {
			return null;
		}

		if (titles == null) {
			Session session = null;

			try {
				session = openSession();

				titles = (Titles)session.get(TitlesImpl.class, primaryKey);

				if (titles != null) {
					cacheResult(titles);
				}
				else {
					EntityCacheUtil.putResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
						TitlesImpl.class, primaryKey, _nullTitles);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TitlesModelImpl.ENTITY_CACHE_ENABLED,
					TitlesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return titles;
	}

	/**
	 * Returns the titles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param titlesId the primary key of the titles
	 * @return the titles, or <code>null</code> if a titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Titles fetchByPrimaryKey(long titlesId) throws SystemException {
		return fetchByPrimaryKey((Serializable)titlesId);
	}

	/**
	 * Returns all the titleses.
	 *
	 * @return the titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Titles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Titles> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Titles> findAll(int start, int end,
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

		List<Titles> list = (List<Titles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TITLES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TITLES;

				if (pagination) {
					sql = sql.concat(TitlesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Titles>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Titles>(list);
				}
				else {
					list = (List<Titles>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the titleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Titles titles : findAll()) {
			remove(titles);
		}
	}

	/**
	 * Returns the number of titleses.
	 *
	 * @return the number of titleses
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

				Query q = session.createQuery(_SQL_COUNT_TITLES);

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
	 * Initializes the titles persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Titles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Titles>> listenersList = new ArrayList<ModelListener<Titles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Titles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TitlesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TITLES = "SELECT titles FROM Titles titles";
	private static final String _SQL_SELECT_TITLES_WHERE = "SELECT titles FROM Titles titles WHERE ";
	private static final String _SQL_COUNT_TITLES = "SELECT COUNT(titles) FROM Titles titles";
	private static final String _SQL_COUNT_TITLES_WHERE = "SELECT COUNT(titles) FROM Titles titles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "titles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Titles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Titles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TitlesPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static Titles _nullTitles = new TitlesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Titles> toCacheModel() {
				return _nullTitlesCacheModel;
			}
		};

	private static CacheModel<Titles> _nullTitlesCacheModel = new CacheModel<Titles>() {
			@Override
			public Titles toEntityModel() {
				return _nullTitles;
			}
		};
}