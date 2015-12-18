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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException;
import vn.com.ecopharma.emp.model.EmployeeTitlesHistory;
import vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryImpl;
import vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the employee titles history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmployeeTitlesHistoryPersistence
 * @see EmployeeTitlesHistoryUtil
 * @generated
 */
public class EmployeeTitlesHistoryPersistenceImpl extends BasePersistenceImpl<EmployeeTitlesHistory>
	implements EmployeeTitlesHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeTitlesHistoryUtil} to access the employee titles history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeTitlesHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTitlesHistoryModelImpl.FINDER_CACHE_ENABLED,
			EmployeeTitlesHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTitlesHistoryModelImpl.FINDER_CACHE_ENABLED,
			EmployeeTitlesHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTitlesHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmployeeTitlesHistoryPersistenceImpl() {
		setModelClass(EmployeeTitlesHistory.class);
	}

	/**
	 * Caches the employee titles history in the entity cache if it is enabled.
	 *
	 * @param employeeTitlesHistory the employee titles history
	 */
	@Override
	public void cacheResult(EmployeeTitlesHistory employeeTitlesHistory) {
		EntityCacheUtil.putResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTitlesHistoryImpl.class,
			employeeTitlesHistory.getPrimaryKey(), employeeTitlesHistory);

		employeeTitlesHistory.resetOriginalValues();
	}

	/**
	 * Caches the employee titles histories in the entity cache if it is enabled.
	 *
	 * @param employeeTitlesHistories the employee titles histories
	 */
	@Override
	public void cacheResult(List<EmployeeTitlesHistory> employeeTitlesHistories) {
		for (EmployeeTitlesHistory employeeTitlesHistory : employeeTitlesHistories) {
			if (EntityCacheUtil.getResult(
						EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeTitlesHistoryImpl.class,
						employeeTitlesHistory.getPrimaryKey()) == null) {
				cacheResult(employeeTitlesHistory);
			}
			else {
				employeeTitlesHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee titles histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmployeeTitlesHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmployeeTitlesHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee titles history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeTitlesHistory employeeTitlesHistory) {
		EntityCacheUtil.removeResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTitlesHistoryImpl.class,
			employeeTitlesHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmployeeTitlesHistory> employeeTitlesHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeTitlesHistory employeeTitlesHistory : employeeTitlesHistories) {
			EntityCacheUtil.removeResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeTitlesHistoryImpl.class,
				employeeTitlesHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee titles history with the primary key. Does not add the employee titles history to the database.
	 *
	 * @param employeeTitlesHistoryId the primary key for the new employee titles history
	 * @return the new employee titles history
	 */
	@Override
	public EmployeeTitlesHistory create(long employeeTitlesHistoryId) {
		EmployeeTitlesHistory employeeTitlesHistory = new EmployeeTitlesHistoryImpl();

		employeeTitlesHistory.setNew(true);
		employeeTitlesHistory.setPrimaryKey(employeeTitlesHistoryId);

		return employeeTitlesHistory;
	}

	/**
	 * Removes the employee titles history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeTitlesHistoryId the primary key of the employee titles history
	 * @return the employee titles history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeTitlesHistory remove(long employeeTitlesHistoryId)
		throws NoSuchEmployeeTitlesHistoryException, SystemException {
		return remove((Serializable)employeeTitlesHistoryId);
	}

	/**
	 * Removes the employee titles history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee titles history
	 * @return the employee titles history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeTitlesHistory remove(Serializable primaryKey)
		throws NoSuchEmployeeTitlesHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmployeeTitlesHistory employeeTitlesHistory = (EmployeeTitlesHistory)session.get(EmployeeTitlesHistoryImpl.class,
					primaryKey);

			if (employeeTitlesHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeTitlesHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeTitlesHistory);
		}
		catch (NoSuchEmployeeTitlesHistoryException nsee) {
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
	protected EmployeeTitlesHistory removeImpl(
		EmployeeTitlesHistory employeeTitlesHistory) throws SystemException {
		employeeTitlesHistory = toUnwrappedModel(employeeTitlesHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeTitlesHistory)) {
				employeeTitlesHistory = (EmployeeTitlesHistory)session.get(EmployeeTitlesHistoryImpl.class,
						employeeTitlesHistory.getPrimaryKeyObj());
			}

			if (employeeTitlesHistory != null) {
				session.delete(employeeTitlesHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeTitlesHistory != null) {
			clearCache(employeeTitlesHistory);
		}

		return employeeTitlesHistory;
	}

	@Override
	public EmployeeTitlesHistory updateImpl(
		vn.com.ecopharma.emp.model.EmployeeTitlesHistory employeeTitlesHistory)
		throws SystemException {
		employeeTitlesHistory = toUnwrappedModel(employeeTitlesHistory);

		boolean isNew = employeeTitlesHistory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (employeeTitlesHistory.isNew()) {
				session.save(employeeTitlesHistory);

				employeeTitlesHistory.setNew(false);
			}
			else {
				session.merge(employeeTitlesHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeTitlesHistoryImpl.class,
			employeeTitlesHistory.getPrimaryKey(), employeeTitlesHistory);

		return employeeTitlesHistory;
	}

	protected EmployeeTitlesHistory toUnwrappedModel(
		EmployeeTitlesHistory employeeTitlesHistory) {
		if (employeeTitlesHistory instanceof EmployeeTitlesHistoryImpl) {
			return employeeTitlesHistory;
		}

		EmployeeTitlesHistoryImpl employeeTitlesHistoryImpl = new EmployeeTitlesHistoryImpl();

		employeeTitlesHistoryImpl.setNew(employeeTitlesHistory.isNew());
		employeeTitlesHistoryImpl.setPrimaryKey(employeeTitlesHistory.getPrimaryKey());

		employeeTitlesHistoryImpl.setEmployeeTitlesHistoryId(employeeTitlesHistory.getEmployeeTitlesHistoryId());
		employeeTitlesHistoryImpl.setEmployeeId(employeeTitlesHistory.getEmployeeId());
		employeeTitlesHistoryImpl.setTitlesId(employeeTitlesHistory.getTitlesId());
		employeeTitlesHistoryImpl.setSetDate(employeeTitlesHistory.getSetDate());
		employeeTitlesHistoryImpl.setNote(employeeTitlesHistory.getNote());
		employeeTitlesHistoryImpl.setGroupId(employeeTitlesHistory.getGroupId());
		employeeTitlesHistoryImpl.setCompanyId(employeeTitlesHistory.getCompanyId());
		employeeTitlesHistoryImpl.setUserId(employeeTitlesHistory.getUserId());
		employeeTitlesHistoryImpl.setCreateDate(employeeTitlesHistory.getCreateDate());
		employeeTitlesHistoryImpl.setModifiedDate(employeeTitlesHistory.getModifiedDate());

		return employeeTitlesHistoryImpl;
	}

	/**
	 * Returns the employee titles history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee titles history
	 * @return the employee titles history
	 * @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeTitlesHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeTitlesHistoryException, SystemException {
		EmployeeTitlesHistory employeeTitlesHistory = fetchByPrimaryKey(primaryKey);

		if (employeeTitlesHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeTitlesHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeTitlesHistory;
	}

	/**
	 * Returns the employee titles history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException} if it could not be found.
	 *
	 * @param employeeTitlesHistoryId the primary key of the employee titles history
	 * @return the employee titles history
	 * @throws vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException if a employee titles history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeTitlesHistory findByPrimaryKey(long employeeTitlesHistoryId)
		throws NoSuchEmployeeTitlesHistoryException, SystemException {
		return findByPrimaryKey((Serializable)employeeTitlesHistoryId);
	}

	/**
	 * Returns the employee titles history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee titles history
	 * @return the employee titles history, or <code>null</code> if a employee titles history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeTitlesHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmployeeTitlesHistory employeeTitlesHistory = (EmployeeTitlesHistory)EntityCacheUtil.getResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeTitlesHistoryImpl.class, primaryKey);

		if (employeeTitlesHistory == _nullEmployeeTitlesHistory) {
			return null;
		}

		if (employeeTitlesHistory == null) {
			Session session = null;

			try {
				session = openSession();

				employeeTitlesHistory = (EmployeeTitlesHistory)session.get(EmployeeTitlesHistoryImpl.class,
						primaryKey);

				if (employeeTitlesHistory != null) {
					cacheResult(employeeTitlesHistory);
				}
				else {
					EntityCacheUtil.putResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeTitlesHistoryImpl.class, primaryKey,
						_nullEmployeeTitlesHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmployeeTitlesHistoryModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeTitlesHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeTitlesHistory;
	}

	/**
	 * Returns the employee titles history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeTitlesHistoryId the primary key of the employee titles history
	 * @return the employee titles history, or <code>null</code> if a employee titles history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeTitlesHistory fetchByPrimaryKey(long employeeTitlesHistoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)employeeTitlesHistoryId);
	}

	/**
	 * Returns all the employee titles histories.
	 *
	 * @return the employee titles histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeTitlesHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee titles histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee titles histories
	 * @param end the upper bound of the range of employee titles histories (not inclusive)
	 * @return the range of employee titles histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeTitlesHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee titles histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee titles histories
	 * @param end the upper bound of the range of employee titles histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee titles histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeTitlesHistory> findAll(int start, int end,
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

		List<EmployeeTitlesHistory> list = (List<EmployeeTitlesHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLOYEETITLESHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEETITLESHISTORY;

				if (pagination) {
					sql = sql.concat(EmployeeTitlesHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeTitlesHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeTitlesHistory>(list);
				}
				else {
					list = (List<EmployeeTitlesHistory>)QueryUtil.list(q,
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
	 * Removes all the employee titles histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmployeeTitlesHistory employeeTitlesHistory : findAll()) {
			remove(employeeTitlesHistory);
		}
	}

	/**
	 * Returns the number of employee titles histories.
	 *
	 * @return the number of employee titles histories
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

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEETITLESHISTORY);

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
	 * Initializes the employee titles history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmployeeTitlesHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmployeeTitlesHistory>> listenersList = new ArrayList<ModelListener<EmployeeTitlesHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmployeeTitlesHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmployeeTitlesHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLOYEETITLESHISTORY = "SELECT employeeTitlesHistory FROM EmployeeTitlesHistory employeeTitlesHistory";
	private static final String _SQL_COUNT_EMPLOYEETITLESHISTORY = "SELECT COUNT(employeeTitlesHistory) FROM EmployeeTitlesHistory employeeTitlesHistory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeTitlesHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeTitlesHistory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmployeeTitlesHistoryPersistenceImpl.class);
	private static EmployeeTitlesHistory _nullEmployeeTitlesHistory = new EmployeeTitlesHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmployeeTitlesHistory> toCacheModel() {
				return _nullEmployeeTitlesHistoryCacheModel;
			}
		};

	private static CacheModel<EmployeeTitlesHistory> _nullEmployeeTitlesHistoryCacheModel =
		new CacheModel<EmployeeTitlesHistory>() {
			@Override
			public EmployeeTitlesHistory toEntityModel() {
				return _nullEmployeeTitlesHistory;
			}
		};
}