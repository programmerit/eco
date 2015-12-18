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

import vn.com.ecopharma.emp.NoSuchWorkingLocationException;
import vn.com.ecopharma.emp.model.WorkingLocation;
import vn.com.ecopharma.emp.model.impl.WorkingLocationImpl;
import vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the working location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see WorkingLocationPersistence
 * @see WorkingLocationUtil
 * @generated
 */
public class WorkingLocationPersistenceImpl extends BasePersistenceImpl<WorkingLocation>
	implements WorkingLocationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkingLocationUtil} to access the working location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkingLocationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
			WorkingLocationModelImpl.FINDER_CACHE_ENABLED,
			WorkingLocationImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
			WorkingLocationModelImpl.FINDER_CACHE_ENABLED,
			WorkingLocationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
			WorkingLocationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WorkingLocationPersistenceImpl() {
		setModelClass(WorkingLocation.class);
	}

	/**
	 * Caches the working location in the entity cache if it is enabled.
	 *
	 * @param workingLocation the working location
	 */
	@Override
	public void cacheResult(WorkingLocation workingLocation) {
		EntityCacheUtil.putResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
			WorkingLocationImpl.class, workingLocation.getPrimaryKey(),
			workingLocation);

		workingLocation.resetOriginalValues();
	}

	/**
	 * Caches the working locations in the entity cache if it is enabled.
	 *
	 * @param workingLocations the working locations
	 */
	@Override
	public void cacheResult(List<WorkingLocation> workingLocations) {
		for (WorkingLocation workingLocation : workingLocations) {
			if (EntityCacheUtil.getResult(
						WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
						WorkingLocationImpl.class,
						workingLocation.getPrimaryKey()) == null) {
				cacheResult(workingLocation);
			}
			else {
				workingLocation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all working locations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkingLocationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkingLocationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the working location.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkingLocation workingLocation) {
		EntityCacheUtil.removeResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
			WorkingLocationImpl.class, workingLocation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkingLocation> workingLocations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkingLocation workingLocation : workingLocations) {
			EntityCacheUtil.removeResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
				WorkingLocationImpl.class, workingLocation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new working location with the primary key. Does not add the working location to the database.
	 *
	 * @param workingLocationId the primary key for the new working location
	 * @return the new working location
	 */
	@Override
	public WorkingLocation create(long workingLocationId) {
		WorkingLocation workingLocation = new WorkingLocationImpl();

		workingLocation.setNew(true);
		workingLocation.setPrimaryKey(workingLocationId);

		return workingLocation;
	}

	/**
	 * Removes the working location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workingLocationId the primary key of the working location
	 * @return the working location that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchWorkingLocationException if a working location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingLocation remove(long workingLocationId)
		throws NoSuchWorkingLocationException, SystemException {
		return remove((Serializable)workingLocationId);
	}

	/**
	 * Removes the working location with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the working location
	 * @return the working location that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchWorkingLocationException if a working location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingLocation remove(Serializable primaryKey)
		throws NoSuchWorkingLocationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkingLocation workingLocation = (WorkingLocation)session.get(WorkingLocationImpl.class,
					primaryKey);

			if (workingLocation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkingLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workingLocation);
		}
		catch (NoSuchWorkingLocationException nsee) {
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
	protected WorkingLocation removeImpl(WorkingLocation workingLocation)
		throws SystemException {
		workingLocation = toUnwrappedModel(workingLocation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workingLocation)) {
				workingLocation = (WorkingLocation)session.get(WorkingLocationImpl.class,
						workingLocation.getPrimaryKeyObj());
			}

			if (workingLocation != null) {
				session.delete(workingLocation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workingLocation != null) {
			clearCache(workingLocation);
		}

		return workingLocation;
	}

	@Override
	public WorkingLocation updateImpl(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation)
		throws SystemException {
		workingLocation = toUnwrappedModel(workingLocation);

		boolean isNew = workingLocation.isNew();

		Session session = null;

		try {
			session = openSession();

			if (workingLocation.isNew()) {
				session.save(workingLocation);

				workingLocation.setNew(false);
			}
			else {
				session.merge(workingLocation);
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

		EntityCacheUtil.putResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
			WorkingLocationImpl.class, workingLocation.getPrimaryKey(),
			workingLocation);

		return workingLocation;
	}

	protected WorkingLocation toUnwrappedModel(WorkingLocation workingLocation) {
		if (workingLocation instanceof WorkingLocationImpl) {
			return workingLocation;
		}

		WorkingLocationImpl workingLocationImpl = new WorkingLocationImpl();

		workingLocationImpl.setNew(workingLocation.isNew());
		workingLocationImpl.setPrimaryKey(workingLocation.getPrimaryKey());

		workingLocationImpl.setWorkingLocationId(workingLocation.getWorkingLocationId());
		workingLocationImpl.setName(workingLocation.getName());
		workingLocationImpl.setLocationId(workingLocation.getLocationId());
		workingLocationImpl.setGroupId(workingLocation.getGroupId());
		workingLocationImpl.setCompanyId(workingLocation.getCompanyId());
		workingLocationImpl.setUserId(workingLocation.getUserId());
		workingLocationImpl.setUserName(workingLocation.getUserName());
		workingLocationImpl.setCreateDate(workingLocation.getCreateDate());
		workingLocationImpl.setModifiedDate(workingLocation.getModifiedDate());

		return workingLocationImpl;
	}

	/**
	 * Returns the working location with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the working location
	 * @return the working location
	 * @throws vn.com.ecopharma.emp.NoSuchWorkingLocationException if a working location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingLocation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkingLocationException, SystemException {
		WorkingLocation workingLocation = fetchByPrimaryKey(primaryKey);

		if (workingLocation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkingLocationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workingLocation;
	}

	/**
	 * Returns the working location with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchWorkingLocationException} if it could not be found.
	 *
	 * @param workingLocationId the primary key of the working location
	 * @return the working location
	 * @throws vn.com.ecopharma.emp.NoSuchWorkingLocationException if a working location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingLocation findByPrimaryKey(long workingLocationId)
		throws NoSuchWorkingLocationException, SystemException {
		return findByPrimaryKey((Serializable)workingLocationId);
	}

	/**
	 * Returns the working location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the working location
	 * @return the working location, or <code>null</code> if a working location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingLocation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkingLocation workingLocation = (WorkingLocation)EntityCacheUtil.getResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
				WorkingLocationImpl.class, primaryKey);

		if (workingLocation == _nullWorkingLocation) {
			return null;
		}

		if (workingLocation == null) {
			Session session = null;

			try {
				session = openSession();

				workingLocation = (WorkingLocation)session.get(WorkingLocationImpl.class,
						primaryKey);

				if (workingLocation != null) {
					cacheResult(workingLocation);
				}
				else {
					EntityCacheUtil.putResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
						WorkingLocationImpl.class, primaryKey,
						_nullWorkingLocation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkingLocationModelImpl.ENTITY_CACHE_ENABLED,
					WorkingLocationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workingLocation;
	}

	/**
	 * Returns the working location with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workingLocationId the primary key of the working location
	 * @return the working location, or <code>null</code> if a working location with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkingLocation fetchByPrimaryKey(long workingLocationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)workingLocationId);
	}

	/**
	 * Returns all the working locations.
	 *
	 * @return the working locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingLocation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the working locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of working locations
	 * @param end the upper bound of the range of working locations (not inclusive)
	 * @return the range of working locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingLocation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the working locations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of working locations
	 * @param end the upper bound of the range of working locations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of working locations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkingLocation> findAll(int start, int end,
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

		List<WorkingLocation> list = (List<WorkingLocation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKINGLOCATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKINGLOCATION;

				if (pagination) {
					sql = sql.concat(WorkingLocationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkingLocation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkingLocation>(list);
				}
				else {
					list = (List<WorkingLocation>)QueryUtil.list(q,
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
	 * Removes all the working locations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkingLocation workingLocation : findAll()) {
			remove(workingLocation);
		}
	}

	/**
	 * Returns the number of working locations.
	 *
	 * @return the number of working locations
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

				Query q = session.createQuery(_SQL_COUNT_WORKINGLOCATION);

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
	 * Initializes the working location persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.WorkingLocation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkingLocation>> listenersList = new ArrayList<ModelListener<WorkingLocation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkingLocation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WorkingLocationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKINGLOCATION = "SELECT workingLocation FROM WorkingLocation workingLocation";
	private static final String _SQL_COUNT_WORKINGLOCATION = "SELECT COUNT(workingLocation) FROM WorkingLocation workingLocation";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workingLocation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkingLocation exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkingLocationPersistenceImpl.class);
	private static WorkingLocation _nullWorkingLocation = new WorkingLocationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkingLocation> toCacheModel() {
				return _nullWorkingLocationCacheModel;
			}
		};

	private static CacheModel<WorkingLocation> _nullWorkingLocationCacheModel = new CacheModel<WorkingLocation>() {
			@Override
			public WorkingLocation toEntityModel() {
				return _nullWorkingLocation;
			}
		};
}