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

import vn.com.ecopharma.emp.NoSuchUniversityException;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.model.impl.UniversityImpl;
import vn.com.ecopharma.emp.model.impl.UniversityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the university service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see UniversityPersistence
 * @see UniversityUtil
 * @generated
 */
public class UniversityPersistenceImpl extends BasePersistenceImpl<University>
	implements UniversityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UniversityUtil} to access the university persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UniversityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, UniversityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, UniversityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, UniversityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			UniversityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the university where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUniversityException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching university
	 * @throws vn.com.ecopharma.emp.NoSuchUniversityException if a matching university could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University findByName(String name)
		throws NoSuchUniversityException, SystemException {
		University university = fetchByName(name);

		if (university == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUniversityException(msg.toString());
		}

		return university;
	}

	/**
	 * Returns the university where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching university, or <code>null</code> if a matching university could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the university where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching university, or <code>null</code> if a matching university could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof University) {
			University university = (University)result;

			if (!Validator.equals(name, university.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_UNIVERSITY_WHERE);

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

				List<University> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UniversityPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					University university = list.get(0);

					result = university;

					cacheResult(university);

					if ((university.getName() == null) ||
							!university.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, university);
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
			return (University)result;
		}
	}

	/**
	 * Removes the university where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the university that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University removeByName(String name)
		throws NoSuchUniversityException, SystemException {
		University university = findByName(name);

		return remove(university);
	}

	/**
	 * Returns the number of universities where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching universities
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

			query.append(_SQL_COUNT_UNIVERSITY_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "university.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "university.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(university.name IS NULL OR university.name = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CODE = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, UniversityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCode",
			new String[] { String.class.getName() },
			UniversityModelImpl.CODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CODE = new FinderPath(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the university where code = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUniversityException} if it could not be found.
	 *
	 * @param code the code
	 * @return the matching university
	 * @throws vn.com.ecopharma.emp.NoSuchUniversityException if a matching university could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University findByCode(String code)
		throws NoSuchUniversityException, SystemException {
		University university = fetchByCode(code);

		if (university == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("code=");
			msg.append(code);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUniversityException(msg.toString());
		}

		return university;
	}

	/**
	 * Returns the university where code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @return the matching university, or <code>null</code> if a matching university could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University fetchByCode(String code) throws SystemException {
		return fetchByCode(code, true);
	}

	/**
	 * Returns the university where code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching university, or <code>null</code> if a matching university could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University fetchByCode(String code, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { code };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CODE,
					finderArgs, this);
		}

		if (result instanceof University) {
			University university = (University)result;

			if (!Validator.equals(code, university.getCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_UNIVERSITY_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
				}

				List<University> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UniversityPersistenceImpl.fetchByCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					University university = list.get(0);

					result = university;

					cacheResult(university);

					if ((university.getCode() == null) ||
							!university.getCode().equals(code)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
							finderArgs, university);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE,
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
			return (University)result;
		}
	}

	/**
	 * Removes the university where code = &#63; from the database.
	 *
	 * @param code the code
	 * @return the university that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University removeByCode(String code)
		throws NoSuchUniversityException, SystemException {
		University university = findByCode(code);

		return remove(university);
	}

	/**
	 * Returns the number of universities where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching universities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCode(String code) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CODE;

		Object[] finderArgs = new Object[] { code };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UNIVERSITY_WHERE);

			boolean bindCode = false;

			if (code == null) {
				query.append(_FINDER_COLUMN_CODE_CODE_1);
			}
			else if (code.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				query.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCode) {
					qPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_1 = "university.code IS NULL";
	private static final String _FINDER_COLUMN_CODE_CODE_2 = "university.code = ?";
	private static final String _FINDER_COLUMN_CODE_CODE_3 = "(university.code IS NULL OR university.code = '')";

	public UniversityPersistenceImpl() {
		setModelClass(University.class);
	}

	/**
	 * Caches the university in the entity cache if it is enabled.
	 *
	 * @param university the university
	 */
	@Override
	public void cacheResult(University university) {
		EntityCacheUtil.putResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityImpl.class, university.getPrimaryKey(), university);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { university.getName() }, university);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE,
			new Object[] { university.getCode() }, university);

		university.resetOriginalValues();
	}

	/**
	 * Caches the universities in the entity cache if it is enabled.
	 *
	 * @param universities the universities
	 */
	@Override
	public void cacheResult(List<University> universities) {
		for (University university : universities) {
			if (EntityCacheUtil.getResult(
						UniversityModelImpl.ENTITY_CACHE_ENABLED,
						UniversityImpl.class, university.getPrimaryKey()) == null) {
				cacheResult(university);
			}
			else {
				university.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all universities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UniversityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UniversityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the university.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(University university) {
		EntityCacheUtil.removeResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityImpl.class, university.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(university);
	}

	@Override
	public void clearCache(List<University> universities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (University university : universities) {
			EntityCacheUtil.removeResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
				UniversityImpl.class, university.getPrimaryKey());

			clearUniqueFindersCache(university);
		}
	}

	protected void cacheUniqueFindersCache(University university) {
		if (university.isNew()) {
			Object[] args = new Object[] { university.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				university);

			args = new Object[] { university.getCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
				university);
		}
		else {
			UniversityModelImpl universityModelImpl = (UniversityModelImpl)university;

			if ((universityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { university.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					university);
			}

			if ((universityModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { university.getCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CODE, args,
					university);
			}
		}
	}

	protected void clearUniqueFindersCache(University university) {
		UniversityModelImpl universityModelImpl = (UniversityModelImpl)university;

		Object[] args = new Object[] { university.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((universityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { universityModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}

		args = new Object[] { university.getCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);

		if ((universityModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CODE.getColumnBitmask()) != 0) {
			args = new Object[] { universityModelImpl.getOriginalCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CODE, args);
		}
	}

	/**
	 * Creates a new university with the primary key. Does not add the university to the database.
	 *
	 * @param universityId the primary key for the new university
	 * @return the new university
	 */
	@Override
	public University create(long universityId) {
		University university = new UniversityImpl();

		university.setNew(true);
		university.setPrimaryKey(universityId);

		return university;
	}

	/**
	 * Removes the university with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param universityId the primary key of the university
	 * @return the university that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchUniversityException if a university with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University remove(long universityId)
		throws NoSuchUniversityException, SystemException {
		return remove((Serializable)universityId);
	}

	/**
	 * Removes the university with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the university
	 * @return the university that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchUniversityException if a university with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University remove(Serializable primaryKey)
		throws NoSuchUniversityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			University university = (University)session.get(UniversityImpl.class,
					primaryKey);

			if (university == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUniversityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(university);
		}
		catch (NoSuchUniversityException nsee) {
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
	protected University removeImpl(University university)
		throws SystemException {
		university = toUnwrappedModel(university);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(university)) {
				university = (University)session.get(UniversityImpl.class,
						university.getPrimaryKeyObj());
			}

			if (university != null) {
				session.delete(university);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (university != null) {
			clearCache(university);
		}

		return university;
	}

	@Override
	public University updateImpl(
		vn.com.ecopharma.emp.model.University university)
		throws SystemException {
		university = toUnwrappedModel(university);

		boolean isNew = university.isNew();

		Session session = null;

		try {
			session = openSession();

			if (university.isNew()) {
				session.save(university);

				university.setNew(false);
			}
			else {
				session.merge(university);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UniversityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
			UniversityImpl.class, university.getPrimaryKey(), university);

		clearUniqueFindersCache(university);
		cacheUniqueFindersCache(university);

		return university;
	}

	protected University toUnwrappedModel(University university) {
		if (university instanceof UniversityImpl) {
			return university;
		}

		UniversityImpl universityImpl = new UniversityImpl();

		universityImpl.setNew(university.isNew());
		universityImpl.setPrimaryKey(university.getPrimaryKey());

		universityImpl.setUniversityId(university.getUniversityId());
		universityImpl.setName(university.getName());
		universityImpl.setCode(university.getCode());
		universityImpl.setTel_fax(university.getTel_fax());
		universityImpl.setGroupId(university.getGroupId());
		universityImpl.setCompanyId(university.getCompanyId());
		universityImpl.setUserId(university.getUserId());
		universityImpl.setCreateDate(university.getCreateDate());
		universityImpl.setModifiedDate(university.getModifiedDate());

		return universityImpl;
	}

	/**
	 * Returns the university with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the university
	 * @return the university
	 * @throws vn.com.ecopharma.emp.NoSuchUniversityException if a university with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUniversityException, SystemException {
		University university = fetchByPrimaryKey(primaryKey);

		if (university == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUniversityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return university;
	}

	/**
	 * Returns the university with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchUniversityException} if it could not be found.
	 *
	 * @param universityId the primary key of the university
	 * @return the university
	 * @throws vn.com.ecopharma.emp.NoSuchUniversityException if a university with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University findByPrimaryKey(long universityId)
		throws NoSuchUniversityException, SystemException {
		return findByPrimaryKey((Serializable)universityId);
	}

	/**
	 * Returns the university with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the university
	 * @return the university, or <code>null</code> if a university with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		University university = (University)EntityCacheUtil.getResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
				UniversityImpl.class, primaryKey);

		if (university == _nullUniversity) {
			return null;
		}

		if (university == null) {
			Session session = null;

			try {
				session = openSession();

				university = (University)session.get(UniversityImpl.class,
						primaryKey);

				if (university != null) {
					cacheResult(university);
				}
				else {
					EntityCacheUtil.putResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
						UniversityImpl.class, primaryKey, _nullUniversity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UniversityModelImpl.ENTITY_CACHE_ENABLED,
					UniversityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return university;
	}

	/**
	 * Returns the university with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param universityId the primary key of the university
	 * @return the university, or <code>null</code> if a university with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public University fetchByPrimaryKey(long universityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)universityId);
	}

	/**
	 * Returns all the universities.
	 *
	 * @return the universities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<University> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the universities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UniversityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of universities
	 * @param end the upper bound of the range of universities (not inclusive)
	 * @return the range of universities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<University> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the universities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UniversityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of universities
	 * @param end the upper bound of the range of universities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of universities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<University> findAll(int start, int end,
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

		List<University> list = (List<University>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNIVERSITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNIVERSITY;

				if (pagination) {
					sql = sql.concat(UniversityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<University>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<University>(list);
				}
				else {
					list = (List<University>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the universities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (University university : findAll()) {
			remove(university);
		}
	}

	/**
	 * Returns the number of universities.
	 *
	 * @return the number of universities
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

				Query q = session.createQuery(_SQL_COUNT_UNIVERSITY);

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
	 * Initializes the university persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.University")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<University>> listenersList = new ArrayList<ModelListener<University>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<University>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UniversityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNIVERSITY = "SELECT university FROM University university";
	private static final String _SQL_SELECT_UNIVERSITY_WHERE = "SELECT university FROM University university WHERE ";
	private static final String _SQL_COUNT_UNIVERSITY = "SELECT COUNT(university) FROM University university";
	private static final String _SQL_COUNT_UNIVERSITY_WHERE = "SELECT COUNT(university) FROM University university WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "university.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No University exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No University exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UniversityPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"code"
			});
	private static University _nullUniversity = new UniversityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<University> toCacheModel() {
				return _nullUniversityCacheModel;
			}
		};

	private static CacheModel<University> _nullUniversityCacheModel = new CacheModel<University>() {
			@Override
			public University toEntityModel() {
				return _nullUniversity;
			}
		};
}