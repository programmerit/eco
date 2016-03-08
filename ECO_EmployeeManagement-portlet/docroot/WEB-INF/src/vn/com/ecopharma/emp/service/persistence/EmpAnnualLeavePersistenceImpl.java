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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException;
import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveImpl;
import vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp annual leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpAnnualLeavePersistence
 * @see EmpAnnualLeaveUtil
 * @generated
 */
public class EmpAnnualLeavePersistenceImpl extends BasePersistenceImpl<EmpAnnualLeave>
	implements EmpAnnualLeavePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpAnnualLeaveUtil} to access the emp annual leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpAnnualLeaveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveModelImpl.FINDER_CACHE_ENABLED,
			EmpAnnualLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveModelImpl.FINDER_CACHE_ENABLED,
			EmpAnnualLeaveImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMP = new FinderPath(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveModelImpl.FINDER_CACHE_ENABLED,
			EmpAnnualLeaveImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByemp",
			new String[] { Long.class.getName() },
			EmpAnnualLeaveModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMP = new FinderPath(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByemp",
			new String[] { Long.class.getName() });

	/**
	 * Returns the emp annual leave where empId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException} if it could not be found.
	 *
	 * @param empId the emp ID
	 * @return the matching emp annual leave
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a matching emp annual leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave findByemp(long empId)
		throws NoSuchEmpAnnualLeaveException, SystemException {
		EmpAnnualLeave empAnnualLeave = fetchByemp(empId);

		if (empAnnualLeave == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empId=");
			msg.append(empId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpAnnualLeaveException(msg.toString());
		}

		return empAnnualLeave;
	}

	/**
	 * Returns the emp annual leave where empId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empId the emp ID
	 * @return the matching emp annual leave, or <code>null</code> if a matching emp annual leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave fetchByemp(long empId) throws SystemException {
		return fetchByemp(empId, true);
	}

	/**
	 * Returns the emp annual leave where empId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empId the emp ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp annual leave, or <code>null</code> if a matching emp annual leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave fetchByemp(long empId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { empId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMP,
					finderArgs, this);
		}

		if (result instanceof EmpAnnualLeave) {
			EmpAnnualLeave empAnnualLeave = (EmpAnnualLeave)result;

			if ((empId != empAnnualLeave.getEmpId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMPANNUALLEAVE_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				List<EmpAnnualLeave> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpAnnualLeavePersistenceImpl.fetchByemp(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmpAnnualLeave empAnnualLeave = list.get(0);

					result = empAnnualLeave;

					cacheResult(empAnnualLeave);

					if ((empAnnualLeave.getEmpId() != empId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMP,
							finderArgs, empAnnualLeave);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMP,
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
			return (EmpAnnualLeave)result;
		}
	}

	/**
	 * Removes the emp annual leave where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @return the emp annual leave that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave removeByemp(long empId)
		throws NoSuchEmpAnnualLeaveException, SystemException {
		EmpAnnualLeave empAnnualLeave = findByemp(empId);

		return remove(empAnnualLeave);
	}

	/**
	 * Returns the number of emp annual leaves where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching emp annual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByemp(long empId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMP;

		Object[] finderArgs = new Object[] { empId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPANNUALLEAVE_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

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

	private static final String _FINDER_COLUMN_EMP_EMPID_2 = "empAnnualLeave.empId = ?";

	public EmpAnnualLeavePersistenceImpl() {
		setModelClass(EmpAnnualLeave.class);
	}

	/**
	 * Caches the emp annual leave in the entity cache if it is enabled.
	 *
	 * @param empAnnualLeave the emp annual leave
	 */
	@Override
	public void cacheResult(EmpAnnualLeave empAnnualLeave) {
		EntityCacheUtil.putResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveImpl.class, empAnnualLeave.getPrimaryKey(),
			empAnnualLeave);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMP,
			new Object[] { empAnnualLeave.getEmpId() }, empAnnualLeave);

		empAnnualLeave.resetOriginalValues();
	}

	/**
	 * Caches the emp annual leaves in the entity cache if it is enabled.
	 *
	 * @param empAnnualLeaves the emp annual leaves
	 */
	@Override
	public void cacheResult(List<EmpAnnualLeave> empAnnualLeaves) {
		for (EmpAnnualLeave empAnnualLeave : empAnnualLeaves) {
			if (EntityCacheUtil.getResult(
						EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
						EmpAnnualLeaveImpl.class, empAnnualLeave.getPrimaryKey()) == null) {
				cacheResult(empAnnualLeave);
			}
			else {
				empAnnualLeave.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp annual leaves.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpAnnualLeaveImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpAnnualLeaveImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp annual leave.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpAnnualLeave empAnnualLeave) {
		EntityCacheUtil.removeResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveImpl.class, empAnnualLeave.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(empAnnualLeave);
	}

	@Override
	public void clearCache(List<EmpAnnualLeave> empAnnualLeaves) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpAnnualLeave empAnnualLeave : empAnnualLeaves) {
			EntityCacheUtil.removeResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
				EmpAnnualLeaveImpl.class, empAnnualLeave.getPrimaryKey());

			clearUniqueFindersCache(empAnnualLeave);
		}
	}

	protected void cacheUniqueFindersCache(EmpAnnualLeave empAnnualLeave) {
		if (empAnnualLeave.isNew()) {
			Object[] args = new Object[] { empAnnualLeave.getEmpId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMP, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMP, args,
				empAnnualLeave);
		}
		else {
			EmpAnnualLeaveModelImpl empAnnualLeaveModelImpl = (EmpAnnualLeaveModelImpl)empAnnualLeave;

			if ((empAnnualLeaveModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { empAnnualLeave.getEmpId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMP, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMP, args,
					empAnnualLeave);
			}
		}
	}

	protected void clearUniqueFindersCache(EmpAnnualLeave empAnnualLeave) {
		EmpAnnualLeaveModelImpl empAnnualLeaveModelImpl = (EmpAnnualLeaveModelImpl)empAnnualLeave;

		Object[] args = new Object[] { empAnnualLeave.getEmpId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMP, args);

		if ((empAnnualLeaveModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMP.getColumnBitmask()) != 0) {
			args = new Object[] { empAnnualLeaveModelImpl.getOriginalEmpId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMP, args);
		}
	}

	/**
	 * Creates a new emp annual leave with the primary key. Does not add the emp annual leave to the database.
	 *
	 * @param empAnnualLeaveId the primary key for the new emp annual leave
	 * @return the new emp annual leave
	 */
	@Override
	public EmpAnnualLeave create(long empAnnualLeaveId) {
		EmpAnnualLeave empAnnualLeave = new EmpAnnualLeaveImpl();

		empAnnualLeave.setNew(true);
		empAnnualLeave.setPrimaryKey(empAnnualLeaveId);

		return empAnnualLeave;
	}

	/**
	 * Removes the emp annual leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empAnnualLeaveId the primary key of the emp annual leave
	 * @return the emp annual leave that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a emp annual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave remove(long empAnnualLeaveId)
		throws NoSuchEmpAnnualLeaveException, SystemException {
		return remove((Serializable)empAnnualLeaveId);
	}

	/**
	 * Removes the emp annual leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp annual leave
	 * @return the emp annual leave that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a emp annual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave remove(Serializable primaryKey)
		throws NoSuchEmpAnnualLeaveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpAnnualLeave empAnnualLeave = (EmpAnnualLeave)session.get(EmpAnnualLeaveImpl.class,
					primaryKey);

			if (empAnnualLeave == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpAnnualLeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empAnnualLeave);
		}
		catch (NoSuchEmpAnnualLeaveException nsee) {
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
	protected EmpAnnualLeave removeImpl(EmpAnnualLeave empAnnualLeave)
		throws SystemException {
		empAnnualLeave = toUnwrappedModel(empAnnualLeave);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empAnnualLeave)) {
				empAnnualLeave = (EmpAnnualLeave)session.get(EmpAnnualLeaveImpl.class,
						empAnnualLeave.getPrimaryKeyObj());
			}

			if (empAnnualLeave != null) {
				session.delete(empAnnualLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empAnnualLeave != null) {
			clearCache(empAnnualLeave);
		}

		return empAnnualLeave;
	}

	@Override
	public EmpAnnualLeave updateImpl(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave)
		throws SystemException {
		empAnnualLeave = toUnwrappedModel(empAnnualLeave);

		boolean isNew = empAnnualLeave.isNew();

		Session session = null;

		try {
			session = openSession();

			if (empAnnualLeave.isNew()) {
				session.save(empAnnualLeave);

				empAnnualLeave.setNew(false);
			}
			else {
				session.merge(empAnnualLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpAnnualLeaveModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
			EmpAnnualLeaveImpl.class, empAnnualLeave.getPrimaryKey(),
			empAnnualLeave);

		clearUniqueFindersCache(empAnnualLeave);
		cacheUniqueFindersCache(empAnnualLeave);

		return empAnnualLeave;
	}

	protected EmpAnnualLeave toUnwrappedModel(EmpAnnualLeave empAnnualLeave) {
		if (empAnnualLeave instanceof EmpAnnualLeaveImpl) {
			return empAnnualLeave;
		}

		EmpAnnualLeaveImpl empAnnualLeaveImpl = new EmpAnnualLeaveImpl();

		empAnnualLeaveImpl.setNew(empAnnualLeave.isNew());
		empAnnualLeaveImpl.setPrimaryKey(empAnnualLeave.getPrimaryKey());

		empAnnualLeaveImpl.setEmpAnnualLeaveId(empAnnualLeave.getEmpAnnualLeaveId());
		empAnnualLeaveImpl.setEmpId(empAnnualLeave.getEmpId());
		empAnnualLeaveImpl.setTotalAnualLeaveLeft(empAnnualLeave.getTotalAnualLeaveLeft());
		empAnnualLeaveImpl.setTotalAnnualLeave(empAnnualLeave.getTotalAnnualLeave());
		empAnnualLeaveImpl.setTotalPreviousYearLeavesLeft(empAnnualLeave.getTotalPreviousYearLeavesLeft());
		empAnnualLeaveImpl.setGroupId(empAnnualLeave.getGroupId());
		empAnnualLeaveImpl.setCompanyId(empAnnualLeave.getCompanyId());
		empAnnualLeaveImpl.setUserId(empAnnualLeave.getUserId());
		empAnnualLeaveImpl.setUserName(empAnnualLeave.getUserName());
		empAnnualLeaveImpl.setCreateDate(empAnnualLeave.getCreateDate());
		empAnnualLeaveImpl.setModifiedDate(empAnnualLeave.getModifiedDate());

		return empAnnualLeaveImpl;
	}

	/**
	 * Returns the emp annual leave with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp annual leave
	 * @return the emp annual leave
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a emp annual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpAnnualLeaveException, SystemException {
		EmpAnnualLeave empAnnualLeave = fetchByPrimaryKey(primaryKey);

		if (empAnnualLeave == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpAnnualLeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empAnnualLeave;
	}

	/**
	 * Returns the emp annual leave with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException} if it could not be found.
	 *
	 * @param empAnnualLeaveId the primary key of the emp annual leave
	 * @return the emp annual leave
	 * @throws vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException if a emp annual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave findByPrimaryKey(long empAnnualLeaveId)
		throws NoSuchEmpAnnualLeaveException, SystemException {
		return findByPrimaryKey((Serializable)empAnnualLeaveId);
	}

	/**
	 * Returns the emp annual leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp annual leave
	 * @return the emp annual leave, or <code>null</code> if a emp annual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpAnnualLeave empAnnualLeave = (EmpAnnualLeave)EntityCacheUtil.getResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
				EmpAnnualLeaveImpl.class, primaryKey);

		if (empAnnualLeave == _nullEmpAnnualLeave) {
			return null;
		}

		if (empAnnualLeave == null) {
			Session session = null;

			try {
				session = openSession();

				empAnnualLeave = (EmpAnnualLeave)session.get(EmpAnnualLeaveImpl.class,
						primaryKey);

				if (empAnnualLeave != null) {
					cacheResult(empAnnualLeave);
				}
				else {
					EntityCacheUtil.putResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
						EmpAnnualLeaveImpl.class, primaryKey,
						_nullEmpAnnualLeave);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpAnnualLeaveModelImpl.ENTITY_CACHE_ENABLED,
					EmpAnnualLeaveImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empAnnualLeave;
	}

	/**
	 * Returns the emp annual leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empAnnualLeaveId the primary key of the emp annual leave
	 * @return the emp annual leave, or <code>null</code> if a emp annual leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpAnnualLeave fetchByPrimaryKey(long empAnnualLeaveId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empAnnualLeaveId);
	}

	/**
	 * Returns all the emp annual leaves.
	 *
	 * @return the emp annual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAnnualLeave> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp annual leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp annual leaves
	 * @param end the upper bound of the range of emp annual leaves (not inclusive)
	 * @return the range of emp annual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAnnualLeave> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp annual leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp annual leaves
	 * @param end the upper bound of the range of emp annual leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp annual leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpAnnualLeave> findAll(int start, int end,
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

		List<EmpAnnualLeave> list = (List<EmpAnnualLeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPANNUALLEAVE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPANNUALLEAVE;

				if (pagination) {
					sql = sql.concat(EmpAnnualLeaveModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpAnnualLeave>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpAnnualLeave>(list);
				}
				else {
					list = (List<EmpAnnualLeave>)QueryUtil.list(q,
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
	 * Removes all the emp annual leaves from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpAnnualLeave empAnnualLeave : findAll()) {
			remove(empAnnualLeave);
		}
	}

	/**
	 * Returns the number of emp annual leaves.
	 *
	 * @return the number of emp annual leaves
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

				Query q = session.createQuery(_SQL_COUNT_EMPANNUALLEAVE);

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
	 * Initializes the emp annual leave persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpAnnualLeave")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpAnnualLeave>> listenersList = new ArrayList<ModelListener<EmpAnnualLeave>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpAnnualLeave>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpAnnualLeaveImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPANNUALLEAVE = "SELECT empAnnualLeave FROM EmpAnnualLeave empAnnualLeave";
	private static final String _SQL_SELECT_EMPANNUALLEAVE_WHERE = "SELECT empAnnualLeave FROM EmpAnnualLeave empAnnualLeave WHERE ";
	private static final String _SQL_COUNT_EMPANNUALLEAVE = "SELECT COUNT(empAnnualLeave) FROM EmpAnnualLeave empAnnualLeave";
	private static final String _SQL_COUNT_EMPANNUALLEAVE_WHERE = "SELECT COUNT(empAnnualLeave) FROM EmpAnnualLeave empAnnualLeave WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empAnnualLeave.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpAnnualLeave exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpAnnualLeave exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpAnnualLeavePersistenceImpl.class);
	private static EmpAnnualLeave _nullEmpAnnualLeave = new EmpAnnualLeaveImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpAnnualLeave> toCacheModel() {
				return _nullEmpAnnualLeaveCacheModel;
			}
		};

	private static CacheModel<EmpAnnualLeave> _nullEmpAnnualLeaveCacheModel = new CacheModel<EmpAnnualLeave>() {
			@Override
			public EmpAnnualLeave toEntityModel() {
				return _nullEmpAnnualLeave;
			}
		};
}