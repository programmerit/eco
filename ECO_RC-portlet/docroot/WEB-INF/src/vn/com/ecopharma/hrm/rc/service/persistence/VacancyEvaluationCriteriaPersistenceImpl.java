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

package vn.com.ecopharma.hrm.rc.service.persistence;

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

import vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException;
import vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria;
import vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaImpl;
import vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vacancy evaluation criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyEvaluationCriteriaPersistence
 * @see VacancyEvaluationCriteriaUtil
 * @generated
 */
public class VacancyEvaluationCriteriaPersistenceImpl
	extends BasePersistenceImpl<VacancyEvaluationCriteria>
	implements VacancyEvaluationCriteriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VacancyEvaluationCriteriaUtil} to access the vacancy evaluation criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VacancyEvaluationCriteriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			VacancyEvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			VacancyEvaluationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			VacancyEvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			VacancyEvaluationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			VacancyEvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

	public VacancyEvaluationCriteriaPersistenceImpl() {
		setModelClass(VacancyEvaluationCriteria.class);
	}

	/**
	 * Caches the vacancy evaluation criteria in the entity cache if it is enabled.
	 *
	 * @param vacancyEvaluationCriteria the vacancy evaluation criteria
	 */
	@Override
	public void cacheResult(VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		EntityCacheUtil.putResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			VacancyEvaluationCriteriaImpl.class,
			vacancyEvaluationCriteria.getPrimaryKey(), vacancyEvaluationCriteria);

		vacancyEvaluationCriteria.resetOriginalValues();
	}

	/**
	 * Caches the vacancy evaluation criterias in the entity cache if it is enabled.
	 *
	 * @param vacancyEvaluationCriterias the vacancy evaluation criterias
	 */
	@Override
	public void cacheResult(
		List<VacancyEvaluationCriteria> vacancyEvaluationCriterias) {
		for (VacancyEvaluationCriteria vacancyEvaluationCriteria : vacancyEvaluationCriterias) {
			if (EntityCacheUtil.getResult(
						VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						VacancyEvaluationCriteriaImpl.class,
						vacancyEvaluationCriteria.getPrimaryKey()) == null) {
				cacheResult(vacancyEvaluationCriteria);
			}
			else {
				vacancyEvaluationCriteria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vacancy evaluation criterias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VacancyEvaluationCriteriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VacancyEvaluationCriteriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vacancy evaluation criteria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		EntityCacheUtil.removeResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			VacancyEvaluationCriteriaImpl.class,
			vacancyEvaluationCriteria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<VacancyEvaluationCriteria> vacancyEvaluationCriterias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VacancyEvaluationCriteria vacancyEvaluationCriteria : vacancyEvaluationCriterias) {
			EntityCacheUtil.removeResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				VacancyEvaluationCriteriaImpl.class,
				vacancyEvaluationCriteria.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vacancy evaluation criteria with the primary key. Does not add the vacancy evaluation criteria to the database.
	 *
	 * @param vacancyEvaluationCriteriaId the primary key for the new vacancy evaluation criteria
	 * @return the new vacancy evaluation criteria
	 */
	@Override
	public VacancyEvaluationCriteria create(long vacancyEvaluationCriteriaId) {
		VacancyEvaluationCriteria vacancyEvaluationCriteria = new VacancyEvaluationCriteriaImpl();

		vacancyEvaluationCriteria.setNew(true);
		vacancyEvaluationCriteria.setPrimaryKey(vacancyEvaluationCriteriaId);

		return vacancyEvaluationCriteria;
	}

	/**
	 * Removes the vacancy evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	 * @return the vacancy evaluation criteria that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyEvaluationCriteria remove(long vacancyEvaluationCriteriaId)
		throws NoSuchVacancyEvaluationCriteriaException, SystemException {
		return remove((Serializable)vacancyEvaluationCriteriaId);
	}

	/**
	 * Removes the vacancy evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vacancy evaluation criteria
	 * @return the vacancy evaluation criteria that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyEvaluationCriteria remove(Serializable primaryKey)
		throws NoSuchVacancyEvaluationCriteriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VacancyEvaluationCriteria vacancyEvaluationCriteria = (VacancyEvaluationCriteria)session.get(VacancyEvaluationCriteriaImpl.class,
					primaryKey);

			if (vacancyEvaluationCriteria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVacancyEvaluationCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vacancyEvaluationCriteria);
		}
		catch (NoSuchVacancyEvaluationCriteriaException nsee) {
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
	protected VacancyEvaluationCriteria removeImpl(
		VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws SystemException {
		vacancyEvaluationCriteria = toUnwrappedModel(vacancyEvaluationCriteria);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vacancyEvaluationCriteria)) {
				vacancyEvaluationCriteria = (VacancyEvaluationCriteria)session.get(VacancyEvaluationCriteriaImpl.class,
						vacancyEvaluationCriteria.getPrimaryKeyObj());
			}

			if (vacancyEvaluationCriteria != null) {
				session.delete(vacancyEvaluationCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vacancyEvaluationCriteria != null) {
			clearCache(vacancyEvaluationCriteria);
		}

		return vacancyEvaluationCriteria;
	}

	@Override
	public VacancyEvaluationCriteria updateImpl(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria)
		throws SystemException {
		vacancyEvaluationCriteria = toUnwrappedModel(vacancyEvaluationCriteria);

		boolean isNew = vacancyEvaluationCriteria.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vacancyEvaluationCriteria.isNew()) {
				session.save(vacancyEvaluationCriteria);

				vacancyEvaluationCriteria.setNew(false);
			}
			else {
				session.merge(vacancyEvaluationCriteria);
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

		EntityCacheUtil.putResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			VacancyEvaluationCriteriaImpl.class,
			vacancyEvaluationCriteria.getPrimaryKey(), vacancyEvaluationCriteria);

		return vacancyEvaluationCriteria;
	}

	protected VacancyEvaluationCriteria toUnwrappedModel(
		VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		if (vacancyEvaluationCriteria instanceof VacancyEvaluationCriteriaImpl) {
			return vacancyEvaluationCriteria;
		}

		VacancyEvaluationCriteriaImpl vacancyEvaluationCriteriaImpl = new VacancyEvaluationCriteriaImpl();

		vacancyEvaluationCriteriaImpl.setNew(vacancyEvaluationCriteria.isNew());
		vacancyEvaluationCriteriaImpl.setPrimaryKey(vacancyEvaluationCriteria.getPrimaryKey());

		vacancyEvaluationCriteriaImpl.setVacancyEvaluationCriteriaId(vacancyEvaluationCriteria.getVacancyEvaluationCriteriaId());
		vacancyEvaluationCriteriaImpl.setVacancyId(vacancyEvaluationCriteria.getVacancyId());
		vacancyEvaluationCriteriaImpl.setEvaluationCriteriaId(vacancyEvaluationCriteria.getEvaluationCriteriaId());
		vacancyEvaluationCriteriaImpl.setGroupId(vacancyEvaluationCriteria.getGroupId());
		vacancyEvaluationCriteriaImpl.setCompanyId(vacancyEvaluationCriteria.getCompanyId());
		vacancyEvaluationCriteriaImpl.setUserId(vacancyEvaluationCriteria.getUserId());
		vacancyEvaluationCriteriaImpl.setUserName(vacancyEvaluationCriteria.getUserName());
		vacancyEvaluationCriteriaImpl.setCreateDate(vacancyEvaluationCriteria.getCreateDate());
		vacancyEvaluationCriteriaImpl.setModifiedDate(vacancyEvaluationCriteria.getModifiedDate());

		return vacancyEvaluationCriteriaImpl;
	}

	/**
	 * Returns the vacancy evaluation criteria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacancy evaluation criteria
	 * @return the vacancy evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyEvaluationCriteria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVacancyEvaluationCriteriaException, SystemException {
		VacancyEvaluationCriteria vacancyEvaluationCriteria = fetchByPrimaryKey(primaryKey);

		if (vacancyEvaluationCriteria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVacancyEvaluationCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vacancyEvaluationCriteria;
	}

	/**
	 * Returns the vacancy evaluation criteria with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException} if it could not be found.
	 *
	 * @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	 * @return the vacancy evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException if a vacancy evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyEvaluationCriteria findByPrimaryKey(
		long vacancyEvaluationCriteriaId)
		throws NoSuchVacancyEvaluationCriteriaException, SystemException {
		return findByPrimaryKey((Serializable)vacancyEvaluationCriteriaId);
	}

	/**
	 * Returns the vacancy evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacancy evaluation criteria
	 * @return the vacancy evaluation criteria, or <code>null</code> if a vacancy evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyEvaluationCriteria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VacancyEvaluationCriteria vacancyEvaluationCriteria = (VacancyEvaluationCriteria)EntityCacheUtil.getResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				VacancyEvaluationCriteriaImpl.class, primaryKey);

		if (vacancyEvaluationCriteria == _nullVacancyEvaluationCriteria) {
			return null;
		}

		if (vacancyEvaluationCriteria == null) {
			Session session = null;

			try {
				session = openSession();

				vacancyEvaluationCriteria = (VacancyEvaluationCriteria)session.get(VacancyEvaluationCriteriaImpl.class,
						primaryKey);

				if (vacancyEvaluationCriteria != null) {
					cacheResult(vacancyEvaluationCriteria);
				}
				else {
					EntityCacheUtil.putResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						VacancyEvaluationCriteriaImpl.class, primaryKey,
						_nullVacancyEvaluationCriteria);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VacancyEvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
					VacancyEvaluationCriteriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vacancyEvaluationCriteria;
	}

	/**
	 * Returns the vacancy evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vacancyEvaluationCriteriaId the primary key of the vacancy evaluation criteria
	 * @return the vacancy evaluation criteria, or <code>null</code> if a vacancy evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyEvaluationCriteria fetchByPrimaryKey(
		long vacancyEvaluationCriteriaId) throws SystemException {
		return fetchByPrimaryKey((Serializable)vacancyEvaluationCriteriaId);
	}

	/**
	 * Returns all the vacancy evaluation criterias.
	 *
	 * @return the vacancy evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyEvaluationCriteria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacancy evaluation criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy evaluation criterias
	 * @param end the upper bound of the range of vacancy evaluation criterias (not inclusive)
	 * @return the range of vacancy evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyEvaluationCriteria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacancy evaluation criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy evaluation criterias
	 * @param end the upper bound of the range of vacancy evaluation criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vacancy evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyEvaluationCriteria> findAll(int start, int end,
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

		List<VacancyEvaluationCriteria> list = (List<VacancyEvaluationCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VACANCYEVALUATIONCRITERIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VACANCYEVALUATIONCRITERIA;

				if (pagination) {
					sql = sql.concat(VacancyEvaluationCriteriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VacancyEvaluationCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacancyEvaluationCriteria>(list);
				}
				else {
					list = (List<VacancyEvaluationCriteria>)QueryUtil.list(q,
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
	 * Removes all the vacancy evaluation criterias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VacancyEvaluationCriteria vacancyEvaluationCriteria : findAll()) {
			remove(vacancyEvaluationCriteria);
		}
	}

	/**
	 * Returns the number of vacancy evaluation criterias.
	 *
	 * @return the number of vacancy evaluation criterias
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

				Query q = session.createQuery(_SQL_COUNT_VACANCYEVALUATIONCRITERIA);

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
	 * Initializes the vacancy evaluation criteria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VacancyEvaluationCriteria>> listenersList = new ArrayList<ModelListener<VacancyEvaluationCriteria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VacancyEvaluationCriteria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VacancyEvaluationCriteriaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VACANCYEVALUATIONCRITERIA = "SELECT vacancyEvaluationCriteria FROM VacancyEvaluationCriteria vacancyEvaluationCriteria";
	private static final String _SQL_COUNT_VACANCYEVALUATIONCRITERIA = "SELECT COUNT(vacancyEvaluationCriteria) FROM VacancyEvaluationCriteria vacancyEvaluationCriteria";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vacancyEvaluationCriteria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VacancyEvaluationCriteria exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VacancyEvaluationCriteriaPersistenceImpl.class);
	private static VacancyEvaluationCriteria _nullVacancyEvaluationCriteria = new VacancyEvaluationCriteriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VacancyEvaluationCriteria> toCacheModel() {
				return _nullVacancyEvaluationCriteriaCacheModel;
			}
		};

	private static CacheModel<VacancyEvaluationCriteria> _nullVacancyEvaluationCriteriaCacheModel =
		new CacheModel<VacancyEvaluationCriteria>() {
			@Override
			public VacancyEvaluationCriteria toEntityModel() {
				return _nullVacancyEvaluationCriteria;
			}
		};
}