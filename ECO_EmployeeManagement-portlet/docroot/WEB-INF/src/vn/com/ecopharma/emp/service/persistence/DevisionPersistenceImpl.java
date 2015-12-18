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

import vn.com.ecopharma.emp.NoSuchDevisionException;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.impl.DevisionImpl;
import vn.com.ecopharma.emp.model.impl.DevisionModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the devision service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DevisionPersistence
 * @see DevisionUtil
 * @generated
 */
public class DevisionPersistenceImpl extends BasePersistenceImpl<Devision>
	implements DevisionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DevisionUtil} to access the devision persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DevisionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionModelImpl.FINDER_CACHE_ENABLED, DevisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionModelImpl.FINDER_CACHE_ENABLED, DevisionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionModelImpl.FINDER_CACHE_ENABLED, DevisionImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			DevisionModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the devision where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDevisionException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching devision
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionException if a matching devision could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision findByName(String name)
		throws NoSuchDevisionException, SystemException {
		Devision devision = fetchByName(name);

		if (devision == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDevisionException(msg.toString());
		}

		return devision;
	}

	/**
	 * Returns the devision where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching devision, or <code>null</code> if a matching devision could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the devision where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching devision, or <code>null</code> if a matching devision could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Devision) {
			Devision devision = (Devision)result;

			if (!Validator.equals(name, devision.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DEVISION_WHERE);

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

				List<Devision> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DevisionPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Devision devision = list.get(0);

					result = devision;

					cacheResult(devision);

					if ((devision.getName() == null) ||
							!devision.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, devision);
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
			return (Devision)result;
		}
	}

	/**
	 * Removes the devision where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the devision that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision removeByName(String name)
		throws NoSuchDevisionException, SystemException {
		Devision devision = findByName(name);

		return remove(devision);
	}

	/**
	 * Returns the number of devisions where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching devisions
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

			query.append(_SQL_COUNT_DEVISION_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "devision.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "devision.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(devision.name IS NULL OR devision.name = '')";

	public DevisionPersistenceImpl() {
		setModelClass(Devision.class);
	}

	/**
	 * Caches the devision in the entity cache if it is enabled.
	 *
	 * @param devision the devision
	 */
	@Override
	public void cacheResult(Devision devision) {
		EntityCacheUtil.putResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionImpl.class, devision.getPrimaryKey(), devision);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { devision.getName() }, devision);

		devision.resetOriginalValues();
	}

	/**
	 * Caches the devisions in the entity cache if it is enabled.
	 *
	 * @param devisions the devisions
	 */
	@Override
	public void cacheResult(List<Devision> devisions) {
		for (Devision devision : devisions) {
			if (EntityCacheUtil.getResult(
						DevisionModelImpl.ENTITY_CACHE_ENABLED,
						DevisionImpl.class, devision.getPrimaryKey()) == null) {
				cacheResult(devision);
			}
			else {
				devision.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all devisions.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DevisionImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DevisionImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the devision.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Devision devision) {
		EntityCacheUtil.removeResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionImpl.class, devision.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(devision);
	}

	@Override
	public void clearCache(List<Devision> devisions) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Devision devision : devisions) {
			EntityCacheUtil.removeResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
				DevisionImpl.class, devision.getPrimaryKey());

			clearUniqueFindersCache(devision);
		}
	}

	protected void cacheUniqueFindersCache(Devision devision) {
		if (devision.isNew()) {
			Object[] args = new Object[] { devision.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, devision);
		}
		else {
			DevisionModelImpl devisionModelImpl = (DevisionModelImpl)devision;

			if ((devisionModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { devision.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					devision);
			}
		}
	}

	protected void clearUniqueFindersCache(Devision devision) {
		DevisionModelImpl devisionModelImpl = (DevisionModelImpl)devision;

		Object[] args = new Object[] { devision.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((devisionModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { devisionModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new devision with the primary key. Does not add the devision to the database.
	 *
	 * @param devisionId the primary key for the new devision
	 * @return the new devision
	 */
	@Override
	public Devision create(long devisionId) {
		Devision devision = new DevisionImpl();

		devision.setNew(true);
		devision.setPrimaryKey(devisionId);

		return devision;
	}

	/**
	 * Removes the devision with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param devisionId the primary key of the devision
	 * @return the devision that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionException if a devision with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision remove(long devisionId)
		throws NoSuchDevisionException, SystemException {
		return remove((Serializable)devisionId);
	}

	/**
	 * Removes the devision with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the devision
	 * @return the devision that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionException if a devision with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision remove(Serializable primaryKey)
		throws NoSuchDevisionException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Devision devision = (Devision)session.get(DevisionImpl.class,
					primaryKey);

			if (devision == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDevisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(devision);
		}
		catch (NoSuchDevisionException nsee) {
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
	protected Devision removeImpl(Devision devision) throws SystemException {
		devision = toUnwrappedModel(devision);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(devision)) {
				devision = (Devision)session.get(DevisionImpl.class,
						devision.getPrimaryKeyObj());
			}

			if (devision != null) {
				session.delete(devision);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (devision != null) {
			clearCache(devision);
		}

		return devision;
	}

	@Override
	public Devision updateImpl(vn.com.ecopharma.emp.model.Devision devision)
		throws SystemException {
		devision = toUnwrappedModel(devision);

		boolean isNew = devision.isNew();

		Session session = null;

		try {
			session = openSession();

			if (devision.isNew()) {
				session.save(devision);

				devision.setNew(false);
			}
			else {
				session.merge(devision);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DevisionModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
			DevisionImpl.class, devision.getPrimaryKey(), devision);

		clearUniqueFindersCache(devision);
		cacheUniqueFindersCache(devision);

		return devision;
	}

	protected Devision toUnwrappedModel(Devision devision) {
		if (devision instanceof DevisionImpl) {
			return devision;
		}

		DevisionImpl devisionImpl = new DevisionImpl();

		devisionImpl.setNew(devision.isNew());
		devisionImpl.setPrimaryKey(devision.getPrimaryKey());

		devisionImpl.setDevisionId(devision.getDevisionId());
		devisionImpl.setName(devision.getName());
		devisionImpl.setGroupId(devision.getGroupId());
		devisionImpl.setCompanyId(devision.getCompanyId());
		devisionImpl.setUserId(devision.getUserId());
		devisionImpl.setUserName(devision.getUserName());
		devisionImpl.setCreateDate(devision.getCreateDate());
		devisionImpl.setModifiedDate(devision.getModifiedDate());

		return devisionImpl;
	}

	/**
	 * Returns the devision with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the devision
	 * @return the devision
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionException if a devision with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDevisionException, SystemException {
		Devision devision = fetchByPrimaryKey(primaryKey);

		if (devision == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDevisionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return devision;
	}

	/**
	 * Returns the devision with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDevisionException} if it could not be found.
	 *
	 * @param devisionId the primary key of the devision
	 * @return the devision
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionException if a devision with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision findByPrimaryKey(long devisionId)
		throws NoSuchDevisionException, SystemException {
		return findByPrimaryKey((Serializable)devisionId);
	}

	/**
	 * Returns the devision with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the devision
	 * @return the devision, or <code>null</code> if a devision with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Devision devision = (Devision)EntityCacheUtil.getResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
				DevisionImpl.class, primaryKey);

		if (devision == _nullDevision) {
			return null;
		}

		if (devision == null) {
			Session session = null;

			try {
				session = openSession();

				devision = (Devision)session.get(DevisionImpl.class, primaryKey);

				if (devision != null) {
					cacheResult(devision);
				}
				else {
					EntityCacheUtil.putResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
						DevisionImpl.class, primaryKey, _nullDevision);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DevisionModelImpl.ENTITY_CACHE_ENABLED,
					DevisionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return devision;
	}

	/**
	 * Returns the devision with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param devisionId the primary key of the devision
	 * @return the devision, or <code>null</code> if a devision with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Devision fetchByPrimaryKey(long devisionId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)devisionId);
	}

	/**
	 * Returns all the devisions.
	 *
	 * @return the devisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Devision> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of devisions
	 * @param end the upper bound of the range of devisions (not inclusive)
	 * @return the range of devisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Devision> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the devisions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of devisions
	 * @param end the upper bound of the range of devisions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of devisions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Devision> findAll(int start, int end,
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

		List<Devision> list = (List<Devision>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEVISION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEVISION;

				if (pagination) {
					sql = sql.concat(DevisionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Devision>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Devision>(list);
				}
				else {
					list = (List<Devision>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the devisions from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Devision devision : findAll()) {
			remove(devision);
		}
	}

	/**
	 * Returns the number of devisions.
	 *
	 * @return the number of devisions
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

				Query q = session.createQuery(_SQL_COUNT_DEVISION);

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
	 * Initializes the devision persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Devision")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Devision>> listenersList = new ArrayList<ModelListener<Devision>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Devision>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DevisionImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEVISION = "SELECT devision FROM Devision devision";
	private static final String _SQL_SELECT_DEVISION_WHERE = "SELECT devision FROM Devision devision WHERE ";
	private static final String _SQL_COUNT_DEVISION = "SELECT COUNT(devision) FROM Devision devision";
	private static final String _SQL_COUNT_DEVISION_WHERE = "SELECT COUNT(devision) FROM Devision devision WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "devision.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Devision exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Devision exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DevisionPersistenceImpl.class);
	private static Devision _nullDevision = new DevisionImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Devision> toCacheModel() {
				return _nullDevisionCacheModel;
			}
		};

	private static CacheModel<Devision> _nullDevisionCacheModel = new CacheModel<Devision>() {
			@Override
			public Devision toEntityModel() {
				return _nullDevision;
			}
		};
}