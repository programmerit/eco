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

import vn.com.ecopharma.emp.NoSuchEmpDisciplineException;
import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.model.impl.EmpDisciplineImpl;
import vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp discipline service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpDisciplinePersistence
 * @see EmpDisciplineUtil
 * @generated
 */
public class EmpDisciplinePersistenceImpl extends BasePersistenceImpl<EmpDiscipline>
	implements EmpDisciplinePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpDisciplineUtil} to access the emp discipline persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpDisciplineImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
			EmpDisciplineModelImpl.FINDER_CACHE_ENABLED,
			EmpDisciplineImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
			EmpDisciplineModelImpl.FINDER_CACHE_ENABLED,
			EmpDisciplineImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
			EmpDisciplineModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpDisciplinePersistenceImpl() {
		setModelClass(EmpDiscipline.class);
	}

	/**
	 * Caches the emp discipline in the entity cache if it is enabled.
	 *
	 * @param empDiscipline the emp discipline
	 */
	@Override
	public void cacheResult(EmpDiscipline empDiscipline) {
		EntityCacheUtil.putResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
			EmpDisciplineImpl.class, empDiscipline.getPrimaryKey(),
			empDiscipline);

		empDiscipline.resetOriginalValues();
	}

	/**
	 * Caches the emp disciplines in the entity cache if it is enabled.
	 *
	 * @param empDisciplines the emp disciplines
	 */
	@Override
	public void cacheResult(List<EmpDiscipline> empDisciplines) {
		for (EmpDiscipline empDiscipline : empDisciplines) {
			if (EntityCacheUtil.getResult(
						EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
						EmpDisciplineImpl.class, empDiscipline.getPrimaryKey()) == null) {
				cacheResult(empDiscipline);
			}
			else {
				empDiscipline.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp disciplines.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpDisciplineImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpDisciplineImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp discipline.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpDiscipline empDiscipline) {
		EntityCacheUtil.removeResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
			EmpDisciplineImpl.class, empDiscipline.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpDiscipline> empDisciplines) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpDiscipline empDiscipline : empDisciplines) {
			EntityCacheUtil.removeResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
				EmpDisciplineImpl.class, empDiscipline.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp discipline with the primary key. Does not add the emp discipline to the database.
	 *
	 * @param empDisciplineId the primary key for the new emp discipline
	 * @return the new emp discipline
	 */
	@Override
	public EmpDiscipline create(long empDisciplineId) {
		EmpDiscipline empDiscipline = new EmpDisciplineImpl();

		empDiscipline.setNew(true);
		empDiscipline.setPrimaryKey(empDisciplineId);

		return empDiscipline;
	}

	/**
	 * Removes the emp discipline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empDisciplineId the primary key of the emp discipline
	 * @return the emp discipline that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDiscipline remove(long empDisciplineId)
		throws NoSuchEmpDisciplineException, SystemException {
		return remove((Serializable)empDisciplineId);
	}

	/**
	 * Removes the emp discipline with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp discipline
	 * @return the emp discipline that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDiscipline remove(Serializable primaryKey)
		throws NoSuchEmpDisciplineException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpDiscipline empDiscipline = (EmpDiscipline)session.get(EmpDisciplineImpl.class,
					primaryKey);

			if (empDiscipline == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpDisciplineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empDiscipline);
		}
		catch (NoSuchEmpDisciplineException nsee) {
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
	protected EmpDiscipline removeImpl(EmpDiscipline empDiscipline)
		throws SystemException {
		empDiscipline = toUnwrappedModel(empDiscipline);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empDiscipline)) {
				empDiscipline = (EmpDiscipline)session.get(EmpDisciplineImpl.class,
						empDiscipline.getPrimaryKeyObj());
			}

			if (empDiscipline != null) {
				session.delete(empDiscipline);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empDiscipline != null) {
			clearCache(empDiscipline);
		}

		return empDiscipline;
	}

	@Override
	public EmpDiscipline updateImpl(
		vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline)
		throws SystemException {
		empDiscipline = toUnwrappedModel(empDiscipline);

		boolean isNew = empDiscipline.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empDiscipline.isNew()) {
				session.save(empDiscipline);

				empDiscipline.setNew(false);
			}
			else {
				session.merge(empDiscipline);
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

		EntityCacheUtil.putResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
			EmpDisciplineImpl.class, empDiscipline.getPrimaryKey(),
			empDiscipline);

		return empDiscipline;
	}

	protected EmpDiscipline toUnwrappedModel(EmpDiscipline empDiscipline) {
		if (empDiscipline instanceof EmpDisciplineImpl) {
			return empDiscipline;
		}

		EmpDisciplineImpl empDisciplineImpl = new EmpDisciplineImpl();

		empDisciplineImpl.setNew(empDiscipline.isNew());
		empDisciplineImpl.setPrimaryKey(empDiscipline.getPrimaryKey());

		empDisciplineImpl.setEmpDisciplineId(empDiscipline.getEmpDisciplineId());
		empDisciplineImpl.setEmpId(empDiscipline.getEmpId());
		empDisciplineImpl.setDecisionNo(empDiscipline.getDecisionNo());
		empDisciplineImpl.setContent(empDiscipline.getContent());
		empDisciplineImpl.setDisciplineType(empDiscipline.getDisciplineType());
		empDisciplineImpl.setEffectiveDate(empDiscipline.getEffectiveDate());
		empDisciplineImpl.setAdditionalDisciplineType(empDiscipline.getAdditionalDisciplineType());
		empDisciplineImpl.setDescription(empDiscipline.getDescription());
		empDisciplineImpl.setGroupId(empDiscipline.getGroupId());
		empDisciplineImpl.setCompanyId(empDiscipline.getCompanyId());
		empDisciplineImpl.setUserId(empDiscipline.getUserId());
		empDisciplineImpl.setUserName(empDiscipline.getUserName());
		empDisciplineImpl.setCreateDate(empDiscipline.getCreateDate());
		empDisciplineImpl.setModifiedDate(empDiscipline.getModifiedDate());
		empDisciplineImpl.setDeleted(empDiscipline.isDeleted());

		return empDisciplineImpl;
	}

	/**
	 * Returns the emp discipline with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp discipline
	 * @return the emp discipline
	 * @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDiscipline findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpDisciplineException, SystemException {
		EmpDiscipline empDiscipline = fetchByPrimaryKey(primaryKey);

		if (empDiscipline == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpDisciplineException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empDiscipline;
	}

	/**
	 * Returns the emp discipline with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpDisciplineException} if it could not be found.
	 *
	 * @param empDisciplineId the primary key of the emp discipline
	 * @return the emp discipline
	 * @throws vn.com.ecopharma.emp.NoSuchEmpDisciplineException if a emp discipline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDiscipline findByPrimaryKey(long empDisciplineId)
		throws NoSuchEmpDisciplineException, SystemException {
		return findByPrimaryKey((Serializable)empDisciplineId);
	}

	/**
	 * Returns the emp discipline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp discipline
	 * @return the emp discipline, or <code>null</code> if a emp discipline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDiscipline fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpDiscipline empDiscipline = (EmpDiscipline)EntityCacheUtil.getResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
				EmpDisciplineImpl.class, primaryKey);

		if (empDiscipline == _nullEmpDiscipline) {
			return null;
		}

		if (empDiscipline == null) {
			Session session = null;

			try {
				session = openSession();

				empDiscipline = (EmpDiscipline)session.get(EmpDisciplineImpl.class,
						primaryKey);

				if (empDiscipline != null) {
					cacheResult(empDiscipline);
				}
				else {
					EntityCacheUtil.putResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
						EmpDisciplineImpl.class, primaryKey, _nullEmpDiscipline);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpDisciplineModelImpl.ENTITY_CACHE_ENABLED,
					EmpDisciplineImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empDiscipline;
	}

	/**
	 * Returns the emp discipline with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empDisciplineId the primary key of the emp discipline
	 * @return the emp discipline, or <code>null</code> if a emp discipline with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpDiscipline fetchByPrimaryKey(long empDisciplineId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empDisciplineId);
	}

	/**
	 * Returns all the emp disciplines.
	 *
	 * @return the emp disciplines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDiscipline> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp disciplines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp disciplines
	 * @param end the upper bound of the range of emp disciplines (not inclusive)
	 * @return the range of emp disciplines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDiscipline> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp disciplines.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpDisciplineModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp disciplines
	 * @param end the upper bound of the range of emp disciplines (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp disciplines
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpDiscipline> findAll(int start, int end,
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

		List<EmpDiscipline> list = (List<EmpDiscipline>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPDISCIPLINE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPDISCIPLINE;

				if (pagination) {
					sql = sql.concat(EmpDisciplineModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpDiscipline>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpDiscipline>(list);
				}
				else {
					list = (List<EmpDiscipline>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp disciplines from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpDiscipline empDiscipline : findAll()) {
			remove(empDiscipline);
		}
	}

	/**
	 * Returns the number of emp disciplines.
	 *
	 * @return the number of emp disciplines
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

				Query q = session.createQuery(_SQL_COUNT_EMPDISCIPLINE);

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
	 * Initializes the emp discipline persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpDiscipline")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpDiscipline>> listenersList = new ArrayList<ModelListener<EmpDiscipline>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpDiscipline>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpDisciplineImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPDISCIPLINE = "SELECT empDiscipline FROM EmpDiscipline empDiscipline";
	private static final String _SQL_COUNT_EMPDISCIPLINE = "SELECT COUNT(empDiscipline) FROM EmpDiscipline empDiscipline";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empDiscipline.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpDiscipline exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpDisciplinePersistenceImpl.class);
	private static EmpDiscipline _nullEmpDiscipline = new EmpDisciplineImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpDiscipline> toCacheModel() {
				return _nullEmpDisciplineCacheModel;
			}
		};

	private static CacheModel<EmpDiscipline> _nullEmpDisciplineCacheModel = new CacheModel<EmpDiscipline>() {
			@Override
			public EmpDiscipline toEntityModel() {
				return _nullEmpDiscipline;
			}
		};
}