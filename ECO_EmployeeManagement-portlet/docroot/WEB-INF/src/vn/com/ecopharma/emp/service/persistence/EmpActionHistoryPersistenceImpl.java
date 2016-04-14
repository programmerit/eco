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

import vn.com.ecopharma.emp.NoSuchEmpActionHistoryException;
import vn.com.ecopharma.emp.model.EmpActionHistory;
import vn.com.ecopharma.emp.model.impl.EmpActionHistoryImpl;
import vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp action history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpActionHistoryPersistence
 * @see EmpActionHistoryUtil
 * @generated
 */
public class EmpActionHistoryPersistenceImpl extends BasePersistenceImpl<EmpActionHistory>
	implements EmpActionHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpActionHistoryUtil} to access the emp action history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpActionHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmpActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			EmpActionHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmpActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			EmpActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmpActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpActionHistoryPersistenceImpl() {
		setModelClass(EmpActionHistory.class);
	}

	/**
	 * Caches the emp action history in the entity cache if it is enabled.
	 *
	 * @param empActionHistory the emp action history
	 */
	@Override
	public void cacheResult(EmpActionHistory empActionHistory) {
		EntityCacheUtil.putResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmpActionHistoryImpl.class, empActionHistory.getPrimaryKey(),
			empActionHistory);

		empActionHistory.resetOriginalValues();
	}

	/**
	 * Caches the emp action histories in the entity cache if it is enabled.
	 *
	 * @param empActionHistories the emp action histories
	 */
	@Override
	public void cacheResult(List<EmpActionHistory> empActionHistories) {
		for (EmpActionHistory empActionHistory : empActionHistories) {
			if (EntityCacheUtil.getResult(
						EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
						EmpActionHistoryImpl.class,
						empActionHistory.getPrimaryKey()) == null) {
				cacheResult(empActionHistory);
			}
			else {
				empActionHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp action histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpActionHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpActionHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp action history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpActionHistory empActionHistory) {
		EntityCacheUtil.removeResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmpActionHistoryImpl.class, empActionHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpActionHistory> empActionHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpActionHistory empActionHistory : empActionHistories) {
			EntityCacheUtil.removeResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
				EmpActionHistoryImpl.class, empActionHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp action history with the primary key. Does not add the emp action history to the database.
	 *
	 * @param empActionHistoryId the primary key for the new emp action history
	 * @return the new emp action history
	 */
	@Override
	public EmpActionHistory create(long empActionHistoryId) {
		EmpActionHistory empActionHistory = new EmpActionHistoryImpl();

		empActionHistory.setNew(true);
		empActionHistory.setPrimaryKey(empActionHistoryId);

		return empActionHistory;
	}

	/**
	 * Removes the emp action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empActionHistoryId the primary key of the emp action history
	 * @return the emp action history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpActionHistoryException if a emp action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpActionHistory remove(long empActionHistoryId)
		throws NoSuchEmpActionHistoryException, SystemException {
		return remove((Serializable)empActionHistoryId);
	}

	/**
	 * Removes the emp action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp action history
	 * @return the emp action history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpActionHistoryException if a emp action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpActionHistory remove(Serializable primaryKey)
		throws NoSuchEmpActionHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpActionHistory empActionHistory = (EmpActionHistory)session.get(EmpActionHistoryImpl.class,
					primaryKey);

			if (empActionHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpActionHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empActionHistory);
		}
		catch (NoSuchEmpActionHistoryException nsee) {
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
	protected EmpActionHistory removeImpl(EmpActionHistory empActionHistory)
		throws SystemException {
		empActionHistory = toUnwrappedModel(empActionHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empActionHistory)) {
				empActionHistory = (EmpActionHistory)session.get(EmpActionHistoryImpl.class,
						empActionHistory.getPrimaryKeyObj());
			}

			if (empActionHistory != null) {
				session.delete(empActionHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empActionHistory != null) {
			clearCache(empActionHistory);
		}

		return empActionHistory;
	}

	@Override
	public EmpActionHistory updateImpl(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory)
		throws SystemException {
		empActionHistory = toUnwrappedModel(empActionHistory);

		boolean isNew = empActionHistory.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empActionHistory.isNew()) {
				session.save(empActionHistory);

				empActionHistory.setNew(false);
			}
			else {
				session.merge(empActionHistory);
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

		EntityCacheUtil.putResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			EmpActionHistoryImpl.class, empActionHistory.getPrimaryKey(),
			empActionHistory);

		return empActionHistory;
	}

	protected EmpActionHistory toUnwrappedModel(
		EmpActionHistory empActionHistory) {
		if (empActionHistory instanceof EmpActionHistoryImpl) {
			return empActionHistory;
		}

		EmpActionHistoryImpl empActionHistoryImpl = new EmpActionHistoryImpl();

		empActionHistoryImpl.setNew(empActionHistory.isNew());
		empActionHistoryImpl.setPrimaryKey(empActionHistory.getPrimaryKey());

		empActionHistoryImpl.setEmpActionHistoryId(empActionHistory.getEmpActionHistoryId());
		empActionHistoryImpl.setEmpId(empActionHistory.getEmpId());
		empActionHistoryImpl.setAction(empActionHistory.getAction());
		empActionHistoryImpl.setPerformedBy(empActionHistory.getPerformedBy());
		empActionHistoryImpl.setDescription(empActionHistory.getDescription());
		empActionHistoryImpl.setStatus(empActionHistory.getStatus());
		empActionHistoryImpl.setRefId(empActionHistory.getRefId());
		empActionHistoryImpl.setGroupId(empActionHistory.getGroupId());
		empActionHistoryImpl.setCompanyId(empActionHistory.getCompanyId());
		empActionHistoryImpl.setUserId(empActionHistory.getUserId());
		empActionHistoryImpl.setUserName(empActionHistory.getUserName());
		empActionHistoryImpl.setCreateDate(empActionHistory.getCreateDate());
		empActionHistoryImpl.setModifiedDate(empActionHistory.getModifiedDate());

		return empActionHistoryImpl;
	}

	/**
	 * Returns the emp action history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp action history
	 * @return the emp action history
	 * @throws vn.com.ecopharma.emp.NoSuchEmpActionHistoryException if a emp action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpActionHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpActionHistoryException, SystemException {
		EmpActionHistory empActionHistory = fetchByPrimaryKey(primaryKey);

		if (empActionHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpActionHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empActionHistory;
	}

	/**
	 * Returns the emp action history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpActionHistoryException} if it could not be found.
	 *
	 * @param empActionHistoryId the primary key of the emp action history
	 * @return the emp action history
	 * @throws vn.com.ecopharma.emp.NoSuchEmpActionHistoryException if a emp action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpActionHistory findByPrimaryKey(long empActionHistoryId)
		throws NoSuchEmpActionHistoryException, SystemException {
		return findByPrimaryKey((Serializable)empActionHistoryId);
	}

	/**
	 * Returns the emp action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp action history
	 * @return the emp action history, or <code>null</code> if a emp action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpActionHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpActionHistory empActionHistory = (EmpActionHistory)EntityCacheUtil.getResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
				EmpActionHistoryImpl.class, primaryKey);

		if (empActionHistory == _nullEmpActionHistory) {
			return null;
		}

		if (empActionHistory == null) {
			Session session = null;

			try {
				session = openSession();

				empActionHistory = (EmpActionHistory)session.get(EmpActionHistoryImpl.class,
						primaryKey);

				if (empActionHistory != null) {
					cacheResult(empActionHistory);
				}
				else {
					EntityCacheUtil.putResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
						EmpActionHistoryImpl.class, primaryKey,
						_nullEmpActionHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
					EmpActionHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empActionHistory;
	}

	/**
	 * Returns the emp action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empActionHistoryId the primary key of the emp action history
	 * @return the emp action history, or <code>null</code> if a emp action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpActionHistory fetchByPrimaryKey(long empActionHistoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empActionHistoryId);
	}

	/**
	 * Returns all the emp action histories.
	 *
	 * @return the emp action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpActionHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp action histories
	 * @param end the upper bound of the range of emp action histories (not inclusive)
	 * @return the range of emp action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpActionHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp action histories
	 * @param end the upper bound of the range of emp action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpActionHistory> findAll(int start, int end,
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

		List<EmpActionHistory> list = (List<EmpActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPACTIONHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPACTIONHISTORY;

				if (pagination) {
					sql = sql.concat(EmpActionHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpActionHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpActionHistory>(list);
				}
				else {
					list = (List<EmpActionHistory>)QueryUtil.list(q,
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
	 * Removes all the emp action histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpActionHistory empActionHistory : findAll()) {
			remove(empActionHistory);
		}
	}

	/**
	 * Returns the number of emp action histories.
	 *
	 * @return the number of emp action histories
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

				Query q = session.createQuery(_SQL_COUNT_EMPACTIONHISTORY);

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
	 * Initializes the emp action history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpActionHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpActionHistory>> listenersList = new ArrayList<ModelListener<EmpActionHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpActionHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpActionHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPACTIONHISTORY = "SELECT empActionHistory FROM EmpActionHistory empActionHistory";
	private static final String _SQL_COUNT_EMPACTIONHISTORY = "SELECT COUNT(empActionHistory) FROM EmpActionHistory empActionHistory";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empActionHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpActionHistory exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpActionHistoryPersistenceImpl.class);
	private static EmpActionHistory _nullEmpActionHistory = new EmpActionHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpActionHistory> toCacheModel() {
				return _nullEmpActionHistoryCacheModel;
			}
		};

	private static CacheModel<EmpActionHistory> _nullEmpActionHistoryCacheModel = new CacheModel<EmpActionHistory>() {
			@Override
			public EmpActionHistory toEntityModel() {
				return _nullEmpActionHistory;
			}
		};
}