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

import vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException;
import vn.com.ecopharma.emp.model.EmpAnualLeave;
import vn.com.ecopharma.emp.model.impl.EmpAnualLeaveImpl;
import vn.com.ecopharma.emp.model.impl.EmpAnualLeaveModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp anual leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpAnualLeavePersistence
 * @see EmpAnualLeaveUtil
 * @generated
 */
public class EmpAnualLeavePersistenceImpl extends BasePersistenceImpl<EmpAnualLeave>
	implements EmpAnualLeavePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpAnualLeaveUtil} to access the emp anual leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpAnualLeaveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnualLeaveModelImpl.FINDER_CACHE_ENABLED,
			EmpAnualLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnualLeaveModelImpl.FINDER_CACHE_ENABLED,
			EmpAnualLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnualLeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpAnualLeavePersistenceImpl() {
		setModelClass(EmpAnualLeave.class);
	}

	/**
	 * Caches the emp anual leave in the entity cache if it is enabled.
	 *
	 * @param empAnualLeave the emp anual leave
	 */
	@Override
	public void cacheResult(EmpAnualLeave empAnualLeave) {
		EntityCacheUtil.putResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnualLeaveImpl.class, empAnualLeave.getPrimaryKey(),
			empAnualLeave);

		empAnualLeave.resetOriginalValues();
	}

	/**
	 * Caches the emp anual leaves in the entity cache if it is enabled.
	 *
	 * @param empAnualLeaves the emp anual leaves
	 */
	@Override
	public void cacheResult(List<EmpAnualLeave> empAnualLeaves) {
		for (EmpAnualLeave empAnualLeave : empAnualLeaves) {
			if (EntityCacheUtil.getResult(
						EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
						EmpAnualLeaveImpl.class, empAnualLeave.getPrimaryKey()) == null) {
				cacheResult(empAnualLeave);
			}
			else {
				empAnualLeave.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp anual leaves.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpAnualLeaveImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpAnualLeaveImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp anual leave.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpAnualLeave empAnualLeave) {
		EntityCacheUtil.removeResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnualLeaveImpl.class, empAnualLeave.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpAnualLeave> empAnualLeaves) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpAnualLeave empAnualLeave : empAnualLeaves) {
			EntityCacheUtil.removeResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
				EmpAnualLeaveImpl.class, empAnualLeave.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp anual leave with the primary key. Does not add the emp anual leave to the database.
	 *
	 * @param empAnualLeaveId the primary key for the new emp anual leave
	 * @return the new emp anual leave
	 */
	@Override
	public EmpAnualLeave create(long empAnualLeaveId) {
		EmpAnualLeave empAnualLeave = new EmpAnualLeaveImpl();

		empAnualLeave.setNew(true);
		empAnualLeave.setPrimaryKey(empAnualLeaveId);

		return empAnualLeave;
	}

	/**
	 * Removes the emp anual leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empAnualLeaveId the primary key of the emp anual leave
	 * @return the emp anual leave that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException if a emp anual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnualLeave remove(long empAnualLeaveId)
		throws NoSuchEmpAnualLeaveException, SystemException {
		return remove((Serializable)empAnualLeaveId);
	}

	/**
	 * Removes the emp anual leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp anual leave
	 * @return the emp anual leave that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException if a emp anual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnualLeave remove(Serializable primaryKey)
		throws NoSuchEmpAnualLeaveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpAnualLeave empAnualLeave = (EmpAnualLeave)session.get(EmpAnualLeaveImpl.class,
					primaryKey);

			if (empAnualLeave == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpAnualLeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empAnualLeave);
		}
		catch (NoSuchEmpAnualLeaveException nsee) {
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
	protected EmpAnualLeave removeImpl(EmpAnualLeave empAnualLeave)
		throws SystemException {
		empAnualLeave = toUnwrappedModel(empAnualLeave);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empAnualLeave)) {
				empAnualLeave = (EmpAnualLeave)session.get(EmpAnualLeaveImpl.class,
						empAnualLeave.getPrimaryKeyObj());
			}

			if (empAnualLeave != null) {
				session.delete(empAnualLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empAnualLeave != null) {
			clearCache(empAnualLeave);
		}

		return empAnualLeave;
	}

	@Override
	public EmpAnualLeave updateImpl(
		vn.com.ecopharma.emp.model.EmpAnualLeave empAnualLeave)
		throws SystemException {
		empAnualLeave = toUnwrappedModel(empAnualLeave);

		boolean isNew = empAnualLeave.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empAnualLeave.isNew()) {
				session.save(empAnualLeave);

				empAnualLeave.setNew(false);
			}
			else {
				session.merge(empAnualLeave);
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

		EntityCacheUtil.putResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnualLeaveImpl.class, empAnualLeave.getPrimaryKey(),
			empAnualLeave);

		return empAnualLeave;
	}

	protected EmpAnualLeave toUnwrappedModel(EmpAnualLeave empAnualLeave) {
		if (empAnualLeave instanceof EmpAnualLeaveImpl) {
			return empAnualLeave;
		}

		EmpAnualLeaveImpl empAnualLeaveImpl = new EmpAnualLeaveImpl();

		empAnualLeaveImpl.setNew(empAnualLeave.isNew());
		empAnualLeaveImpl.setPrimaryKey(empAnualLeave.getPrimaryKey());

		empAnualLeaveImpl.setEmpAnualLeaveId(empAnualLeave.getEmpAnualLeaveId());
		empAnualLeaveImpl.setEmpId(empAnualLeave.getEmpId());
		empAnualLeaveImpl.setNoOfAnualLeave(empAnualLeave.getNoOfAnualLeave());
		empAnualLeaveImpl.setGroupId(empAnualLeave.getGroupId());
		empAnualLeaveImpl.setCompanyId(empAnualLeave.getCompanyId());
		empAnualLeaveImpl.setUserId(empAnualLeave.getUserId());
		empAnualLeaveImpl.setUserName(empAnualLeave.getUserName());
		empAnualLeaveImpl.setCreateDate(empAnualLeave.getCreateDate());
		empAnualLeaveImpl.setModifiedDate(empAnualLeave.getModifiedDate());

		return empAnualLeaveImpl;
	}

	/**
	 * Returns the emp anual leave with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp anual leave
	 * @return the emp anual leave
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException if a emp anual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnualLeave findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpAnualLeaveException, SystemException {
		EmpAnualLeave empAnualLeave = fetchByPrimaryKey(primaryKey);

		if (empAnualLeave == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpAnualLeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empAnualLeave;
	}

	/**
	 * Returns the emp anual leave with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException} if it could not be found.
	 *
	 * @param empAnualLeaveId the primary key of the emp anual leave
	 * @return the emp anual leave
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnualLeaveException if a emp anual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnualLeave findByPrimaryKey(long empAnualLeaveId)
		throws NoSuchEmpAnualLeaveException, SystemException {
		return findByPrimaryKey((Serializable)empAnualLeaveId);
	}

	/**
	 * Returns the emp anual leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp anual leave
	 * @return the emp anual leave, or <code>null</code> if a emp anual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnualLeave fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpAnualLeave empAnualLeave = (EmpAnualLeave)EntityCacheUtil.getResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
				EmpAnualLeaveImpl.class, primaryKey);

		if (empAnualLeave == _nullEmpAnualLeave) {
			return null;
		}

		if (empAnualLeave == null) {
			Session session = null;

			try {
				session = openSession();

				empAnualLeave = (EmpAnualLeave)session.get(EmpAnualLeaveImpl.class,
						primaryKey);

				if (empAnualLeave != null) {
					cacheResult(empAnualLeave);
				}
				else {
					EntityCacheUtil.putResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
						EmpAnualLeaveImpl.class, primaryKey, _nullEmpAnualLeave);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpAnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
					EmpAnualLeaveImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empAnualLeave;
	}

	/**
	 * Returns the emp anual leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empAnualLeaveId the primary key of the emp anual leave
	 * @return the emp anual leave, or <code>null</code> if a emp anual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnualLeave fetchByPrimaryKey(long empAnualLeaveId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empAnualLeaveId);
	}

	/**
	 * Returns all the emp anual leaves.
	 *
	 * @return the emp anual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAnualLeave> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp anual leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp anual leaves
	 * @param end the upper bound of the range of emp anual leaves (not inclusive)
	 * @return the range of emp anual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAnualLeave> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp anual leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp anual leaves
	 * @param end the upper bound of the range of emp anual leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp anual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAnualLeave> findAll(int start, int end,
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

		List<EmpAnualLeave> list = (List<EmpAnualLeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPANUALLEAVE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPANUALLEAVE;

				if (pagination) {
					sql = sql.concat(EmpAnualLeaveModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpAnualLeave>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpAnualLeave>(list);
				}
				else {
					list = (List<EmpAnualLeave>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp anual leaves from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpAnualLeave empAnualLeave : findAll()) {
			remove(empAnualLeave);
		}
	}

	/**
	 * Returns the number of emp anual leaves.
	 *
	 * @return the number of emp anual leaves
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

				Query q = session.createQuery(_SQL_COUNT_EMPANUALLEAVE);

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
	 * Initializes the emp anual leave persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpAnualLeave")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpAnualLeave>> listenersList = new ArrayList<ModelListener<EmpAnualLeave>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpAnualLeave>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpAnualLeaveImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPANUALLEAVE = "SELECT empAnualLeave FROM EmpAnualLeave empAnualLeave";
	private static final String _SQL_COUNT_EMPANUALLEAVE = "SELECT COUNT(empAnualLeave) FROM EmpAnualLeave empAnualLeave";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empAnualLeave.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpAnualLeave exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpAnualLeavePersistenceImpl.class);
	private static EmpAnualLeave _nullEmpAnualLeave = new EmpAnualLeaveImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpAnualLeave> toCacheModel() {
				return _nullEmpAnualLeaveCacheModel;
			}
		};

	private static CacheModel<EmpAnualLeave> _nullEmpAnualLeaveCacheModel = new CacheModel<EmpAnualLeave>() {
			@Override
			public EmpAnualLeave toEntityModel() {
				return _nullEmpAnualLeave;
			}
		};
}