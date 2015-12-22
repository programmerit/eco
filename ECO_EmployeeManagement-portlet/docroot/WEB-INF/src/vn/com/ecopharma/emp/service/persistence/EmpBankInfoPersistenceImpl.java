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

import vn.com.ecopharma.emp.NoSuchEmpBankInfoException;
import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.impl.EmpBankInfoImpl;
import vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp bank info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpBankInfoPersistence
 * @see EmpBankInfoUtil
 * @generated
 */
public class EmpBankInfoPersistenceImpl extends BasePersistenceImpl<EmpBankInfo>
	implements EmpBankInfoPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpBankInfoUtil} to access the emp bank info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpBankInfoImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmpBankInfoModelImpl.FINDER_CACHE_ENABLED, EmpBankInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmpBankInfoModelImpl.FINDER_CACHE_ENABLED, EmpBankInfoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmpBankInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public EmpBankInfoPersistenceImpl() {
		setModelClass(EmpBankInfo.class);
	}

	/**
	 * Caches the emp bank info in the entity cache if it is enabled.
	 *
	 * @param empBankInfo the emp bank info
	 */
	@Override
	public void cacheResult(EmpBankInfo empBankInfo) {
		EntityCacheUtil.putResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmpBankInfoImpl.class, empBankInfo.getPrimaryKey(), empBankInfo);

		empBankInfo.resetOriginalValues();
	}

	/**
	 * Caches the emp bank infos in the entity cache if it is enabled.
	 *
	 * @param empBankInfos the emp bank infos
	 */
	@Override
	public void cacheResult(List<EmpBankInfo> empBankInfos) {
		for (EmpBankInfo empBankInfo : empBankInfos) {
			if (EntityCacheUtil.getResult(
						EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
						EmpBankInfoImpl.class, empBankInfo.getPrimaryKey()) == null) {
				cacheResult(empBankInfo);
			}
			else {
				empBankInfo.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp bank infos.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpBankInfoImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpBankInfoImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp bank info.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpBankInfo empBankInfo) {
		EntityCacheUtil.removeResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmpBankInfoImpl.class, empBankInfo.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpBankInfo> empBankInfos) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpBankInfo empBankInfo : empBankInfos) {
			EntityCacheUtil.removeResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
				EmpBankInfoImpl.class, empBankInfo.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp bank info with the primary key. Does not add the emp bank info to the database.
	 *
	 * @param empBankInfoId the primary key for the new emp bank info
	 * @return the new emp bank info
	 */
	@Override
	public EmpBankInfo create(long empBankInfoId) {
		EmpBankInfo empBankInfo = new EmpBankInfoImpl();

		empBankInfo.setNew(true);
		empBankInfo.setPrimaryKey(empBankInfoId);

		return empBankInfo;
	}

	/**
	 * Removes the emp bank info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empBankInfoId the primary key of the emp bank info
	 * @return the emp bank info that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpBankInfoException if a emp bank info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpBankInfo remove(long empBankInfoId)
		throws NoSuchEmpBankInfoException, SystemException {
		return remove((Serializable)empBankInfoId);
	}

	/**
	 * Removes the emp bank info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp bank info
	 * @return the emp bank info that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpBankInfoException if a emp bank info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpBankInfo remove(Serializable primaryKey)
		throws NoSuchEmpBankInfoException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpBankInfo empBankInfo = (EmpBankInfo)session.get(EmpBankInfoImpl.class,
					primaryKey);

			if (empBankInfo == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpBankInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empBankInfo);
		}
		catch (NoSuchEmpBankInfoException nsee) {
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
	protected EmpBankInfo removeImpl(EmpBankInfo empBankInfo)
		throws SystemException {
		empBankInfo = toUnwrappedModel(empBankInfo);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empBankInfo)) {
				empBankInfo = (EmpBankInfo)session.get(EmpBankInfoImpl.class,
						empBankInfo.getPrimaryKeyObj());
			}

			if (empBankInfo != null) {
				session.delete(empBankInfo);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empBankInfo != null) {
			clearCache(empBankInfo);
		}

		return empBankInfo;
	}

	@Override
	public EmpBankInfo updateImpl(
		vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo)
		throws SystemException {
		empBankInfo = toUnwrappedModel(empBankInfo);

		boolean isNew = empBankInfo.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empBankInfo.isNew()) {
				session.save(empBankInfo);

				empBankInfo.setNew(false);
			}
			else {
				session.merge(empBankInfo);
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

		EntityCacheUtil.putResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
			EmpBankInfoImpl.class, empBankInfo.getPrimaryKey(), empBankInfo);

		return empBankInfo;
	}

	protected EmpBankInfo toUnwrappedModel(EmpBankInfo empBankInfo) {
		if (empBankInfo instanceof EmpBankInfoImpl) {
			return empBankInfo;
		}

		EmpBankInfoImpl empBankInfoImpl = new EmpBankInfoImpl();

		empBankInfoImpl.setNew(empBankInfo.isNew());
		empBankInfoImpl.setPrimaryKey(empBankInfo.getPrimaryKey());

		empBankInfoImpl.setEmpBankInfoId(empBankInfo.getEmpBankInfoId());
		empBankInfoImpl.setEmpId(empBankInfo.getEmpId());
		empBankInfoImpl.setBankAccountNo(empBankInfo.getBankAccountNo());
		empBankInfoImpl.setBankName(empBankInfo.getBankName());
		empBankInfoImpl.setBranchName(empBankInfo.getBranchName());
		empBankInfoImpl.setGroupId(empBankInfo.getGroupId());
		empBankInfoImpl.setCompanyId(empBankInfo.getCompanyId());
		empBankInfoImpl.setUserId(empBankInfo.getUserId());
		empBankInfoImpl.setUserName(empBankInfo.getUserName());
		empBankInfoImpl.setCreateDate(empBankInfo.getCreateDate());
		empBankInfoImpl.setModifiedDate(empBankInfo.getModifiedDate());

		return empBankInfoImpl;
	}

	/**
	 * Returns the emp bank info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp bank info
	 * @return the emp bank info
	 * @throws vn.com.ecopharma.emp.NoSuchEmpBankInfoException if a emp bank info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpBankInfo findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpBankInfoException, SystemException {
		EmpBankInfo empBankInfo = fetchByPrimaryKey(primaryKey);

		if (empBankInfo == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpBankInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empBankInfo;
	}

	/**
	 * Returns the emp bank info with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpBankInfoException} if it could not be found.
	 *
	 * @param empBankInfoId the primary key of the emp bank info
	 * @return the emp bank info
	 * @throws vn.com.ecopharma.emp.NoSuchEmpBankInfoException if a emp bank info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpBankInfo findByPrimaryKey(long empBankInfoId)
		throws NoSuchEmpBankInfoException, SystemException {
		return findByPrimaryKey((Serializable)empBankInfoId);
	}

	/**
	 * Returns the emp bank info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp bank info
	 * @return the emp bank info, or <code>null</code> if a emp bank info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpBankInfo fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpBankInfo empBankInfo = (EmpBankInfo)EntityCacheUtil.getResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
				EmpBankInfoImpl.class, primaryKey);

		if (empBankInfo == _nullEmpBankInfo) {
			return null;
		}

		if (empBankInfo == null) {
			Session session = null;

			try {
				session = openSession();

				empBankInfo = (EmpBankInfo)session.get(EmpBankInfoImpl.class,
						primaryKey);

				if (empBankInfo != null) {
					cacheResult(empBankInfo);
				}
				else {
					EntityCacheUtil.putResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
						EmpBankInfoImpl.class, primaryKey, _nullEmpBankInfo);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpBankInfoModelImpl.ENTITY_CACHE_ENABLED,
					EmpBankInfoImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empBankInfo;
	}

	/**
	 * Returns the emp bank info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empBankInfoId the primary key of the emp bank info
	 * @return the emp bank info, or <code>null</code> if a emp bank info with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpBankInfo fetchByPrimaryKey(long empBankInfoId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empBankInfoId);
	}

	/**
	 * Returns all the emp bank infos.
	 *
	 * @return the emp bank infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpBankInfo> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp bank infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp bank infos
	 * @param end the upper bound of the range of emp bank infos (not inclusive)
	 * @return the range of emp bank infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpBankInfo> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp bank infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp bank infos
	 * @param end the upper bound of the range of emp bank infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp bank infos
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpBankInfo> findAll(int start, int end,
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

		List<EmpBankInfo> list = (List<EmpBankInfo>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPBANKINFO);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPBANKINFO;

				if (pagination) {
					sql = sql.concat(EmpBankInfoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpBankInfo>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpBankInfo>(list);
				}
				else {
					list = (List<EmpBankInfo>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the emp bank infos from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpBankInfo empBankInfo : findAll()) {
			remove(empBankInfo);
		}
	}

	/**
	 * Returns the number of emp bank infos.
	 *
	 * @return the number of emp bank infos
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

				Query q = session.createQuery(_SQL_COUNT_EMPBANKINFO);

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
	 * Initializes the emp bank info persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpBankInfo")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpBankInfo>> listenersList = new ArrayList<ModelListener<EmpBankInfo>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpBankInfo>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpBankInfoImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPBANKINFO = "SELECT empBankInfo FROM EmpBankInfo empBankInfo";
	private static final String _SQL_COUNT_EMPBANKINFO = "SELECT COUNT(empBankInfo) FROM EmpBankInfo empBankInfo";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empBankInfo.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpBankInfo exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpBankInfoPersistenceImpl.class);
	private static EmpBankInfo _nullEmpBankInfo = new EmpBankInfoImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpBankInfo> toCacheModel() {
				return _nullEmpBankInfoCacheModel;
			}
		};

	private static CacheModel<EmpBankInfo> _nullEmpBankInfoCacheModel = new CacheModel<EmpBankInfo>() {
			@Override
			public EmpBankInfo toEntityModel() {
				return _nullEmpBankInfo;
			}
		};
}