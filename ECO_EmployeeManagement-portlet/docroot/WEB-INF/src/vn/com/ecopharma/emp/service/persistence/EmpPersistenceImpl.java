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

import vn.com.ecopharma.emp.NoSuchEmpException;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.impl.EmpImpl;
import vn.com.ecopharma.emp.model.impl.EmpModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpPersistence
 * @see EmpUtil
 * @generated
 */
public class EmpPersistenceImpl extends BasePersistenceImpl<Emp>
	implements EmpPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpUtil} to access the emp persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, EmpImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, EmpImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPCODE = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, EmpImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmpCode",
			new String[] { String.class.getName() },
			EmpModelImpl.EMPCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPCODE = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpCode",
			new String[] { String.class.getName() });

	/**
	 * Returns the emp where empCode = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpException} if it could not be found.
	 *
	 * @param empCode the emp code
	 * @return the matching emp
	 * @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp findByEmpCode(String empCode)
		throws NoSuchEmpException, SystemException {
		Emp emp = fetchByEmpCode(empCode);

		if (emp == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empCode=");
			msg.append(empCode);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpException(msg.toString());
		}

		return emp;
	}

	/**
	 * Returns the emp where empCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empCode the emp code
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp fetchByEmpCode(String empCode) throws SystemException {
		return fetchByEmpCode(empCode, true);
	}

	/**
	 * Returns the emp where empCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empCode the emp code
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp fetchByEmpCode(String empCode, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { empCode };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPCODE,
					finderArgs, this);
		}

		if (result instanceof Emp) {
			Emp emp = (Emp)result;

			if (!Validator.equals(empCode, emp.getEmpCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMP_WHERE);

			boolean bindEmpCode = false;

			if (empCode == null) {
				query.append(_FINDER_COLUMN_EMPCODE_EMPCODE_1);
			}
			else if (empCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPCODE_EMPCODE_3);
			}
			else {
				bindEmpCode = true;

				query.append(_FINDER_COLUMN_EMPCODE_EMPCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmpCode) {
					qPos.add(empCode);
				}

				List<Emp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCODE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpPersistenceImpl.fetchByEmpCode(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Emp emp = list.get(0);

					result = emp;

					cacheResult(emp);

					if ((emp.getEmpCode() == null) ||
							!emp.getEmpCode().equals(empCode)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCODE,
							finderArgs, emp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPCODE,
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
			return (Emp)result;
		}
	}

	/**
	 * Removes the emp where empCode = &#63; from the database.
	 *
	 * @param empCode the emp code
	 * @return the emp that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp removeByEmpCode(String empCode)
		throws NoSuchEmpException, SystemException {
		Emp emp = findByEmpCode(empCode);

		return remove(emp);
	}

	/**
	 * Returns the number of emps where empCode = &#63;.
	 *
	 * @param empCode the emp code
	 * @return the number of matching emps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmpCode(String empCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPCODE;

		Object[] finderArgs = new Object[] { empCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMP_WHERE);

			boolean bindEmpCode = false;

			if (empCode == null) {
				query.append(_FINDER_COLUMN_EMPCODE_EMPCODE_1);
			}
			else if (empCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPCODE_EMPCODE_3);
			}
			else {
				bindEmpCode = true;

				query.append(_FINDER_COLUMN_EMPCODE_EMPCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmpCode) {
					qPos.add(empCode);
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

	private static final String _FINDER_COLUMN_EMPCODE_EMPCODE_1 = "emp.empCode IS NULL";
	private static final String _FINDER_COLUMN_EMPCODE_EMPCODE_2 = "emp.empCode = ?";
	private static final String _FINDER_COLUMN_EMPCODE_EMPCODE_3 = "(emp.empCode IS NULL OR emp.empCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_USER = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, EmpImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUser",
			new String[] { Long.class.getName() },
			EmpModelImpl.EMPUSERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName() });

	/**
	 * Returns the emp where empUserId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpException} if it could not be found.
	 *
	 * @param empUserId the emp user ID
	 * @return the matching emp
	 * @throws vn.com.ecopharma.emp.NoSuchEmpException if a matching emp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp findByUser(long empUserId)
		throws NoSuchEmpException, SystemException {
		Emp emp = fetchByUser(empUserId);

		if (emp == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empUserId=");
			msg.append(empUserId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpException(msg.toString());
		}

		return emp;
	}

	/**
	 * Returns the emp where empUserId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empUserId the emp user ID
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp fetchByUser(long empUserId) throws SystemException {
		return fetchByUser(empUserId, true);
	}

	/**
	 * Returns the emp where empUserId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empUserId the emp user ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp, or <code>null</code> if a matching emp could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp fetchByUser(long empUserId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { empUserId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USER,
					finderArgs, this);
		}

		if (result instanceof Emp) {
			Emp emp = (Emp)result;

			if ((empUserId != emp.getEmpUserId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_EMP_WHERE);

			query.append(_FINDER_COLUMN_USER_EMPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empUserId);

				List<Emp> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpPersistenceImpl.fetchByUser(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Emp emp = list.get(0);

					result = emp;

					cacheResult(emp);

					if ((emp.getEmpUserId() != empUserId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER,
							finderArgs, emp);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USER,
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
			return (Emp)result;
		}
	}

	/**
	 * Removes the emp where empUserId = &#63; from the database.
	 *
	 * @param empUserId the emp user ID
	 * @return the emp that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp removeByUser(long empUserId)
		throws NoSuchEmpException, SystemException {
		Emp emp = findByUser(empUserId);

		return remove(emp);
	}

	/**
	 * Returns the number of emps where empUserId = &#63;.
	 *
	 * @param empUserId the emp user ID
	 * @return the number of matching emps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUser(long empUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { empUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMP_WHERE);

			query.append(_FINDER_COLUMN_USER_EMPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empUserId);

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

	private static final String _FINDER_COLUMN_USER_EMPUSERID_2 = "emp.empUserId = ?";

	public EmpPersistenceImpl() {
		setModelClass(Emp.class);
	}

	/**
	 * Caches the emp in the entity cache if it is enabled.
	 *
	 * @param emp the emp
	 */
	@Override
	public void cacheResult(Emp emp) {
		EntityCacheUtil.putResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey(), emp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCODE,
			new Object[] { emp.getEmpCode() }, emp);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER,
			new Object[] { emp.getEmpUserId() }, emp);

		emp.resetOriginalValues();
	}

	/**
	 * Caches the emps in the entity cache if it is enabled.
	 *
	 * @param emps the emps
	 */
	@Override
	public void cacheResult(List<Emp> emps) {
		for (Emp emp : emps) {
			if (EntityCacheUtil.getResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
						EmpImpl.class, emp.getPrimaryKey()) == null) {
				cacheResult(emp);
			}
			else {
				emp.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emps.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Emp emp) {
		EntityCacheUtil.removeResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(emp);
	}

	@Override
	public void clearCache(List<Emp> emps) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Emp emp : emps) {
			EntityCacheUtil.removeResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
				EmpImpl.class, emp.getPrimaryKey());

			clearUniqueFindersCache(emp);
		}
	}

	protected void cacheUniqueFindersCache(Emp emp) {
		if (emp.isNew()) {
			Object[] args = new Object[] { emp.getEmpCode() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPCODE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCODE, args, emp);

			args = new Object[] { emp.getEmpUserId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER, args, emp);
		}
		else {
			EmpModelImpl empModelImpl = (EmpModelImpl)emp;

			if ((empModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { emp.getEmpCode() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPCODE, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCODE, args,
					emp);
			}

			if ((empModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { emp.getEmpUserId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USER, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USER, args, emp);
			}
		}
	}

	protected void clearUniqueFindersCache(Emp emp) {
		EmpModelImpl empModelImpl = (EmpModelImpl)emp;

		Object[] args = new Object[] { emp.getEmpCode() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPCODE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPCODE, args);

		if ((empModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPCODE.getColumnBitmask()) != 0) {
			args = new Object[] { empModelImpl.getOriginalEmpCode() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPCODE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPCODE, args);
		}

		args = new Object[] { emp.getEmpUserId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USER, args);

		if ((empModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_USER.getColumnBitmask()) != 0) {
			args = new Object[] { empModelImpl.getOriginalEmpUserId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USER, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USER, args);
		}
	}

	/**
	 * Creates a new emp with the primary key. Does not add the emp to the database.
	 *
	 * @param empId the primary key for the new emp
	 * @return the new emp
	 */
	@Override
	public Emp create(long empId) {
		Emp emp = new EmpImpl();

		emp.setNew(true);
		emp.setPrimaryKey(empId);

		return emp;
	}

	/**
	 * Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empId the primary key of the emp
	 * @return the emp that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp remove(long empId) throws NoSuchEmpException, SystemException {
		return remove((Serializable)empId);
	}

	/**
	 * Removes the emp with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp
	 * @return the emp that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp remove(Serializable primaryKey)
		throws NoSuchEmpException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Emp emp = (Emp)session.get(EmpImpl.class, primaryKey);

			if (emp == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(emp);
		}
		catch (NoSuchEmpException nsee) {
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
	protected Emp removeImpl(Emp emp) throws SystemException {
		emp = toUnwrappedModel(emp);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(emp)) {
				emp = (Emp)session.get(EmpImpl.class, emp.getPrimaryKeyObj());
			}

			if (emp != null) {
				session.delete(emp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (emp != null) {
			clearCache(emp);
		}

		return emp;
	}

	@Override
	public Emp updateImpl(vn.com.ecopharma.emp.model.Emp emp)
		throws SystemException {
		emp = toUnwrappedModel(emp);

		boolean isNew = emp.isNew();

		Session session = null;

		try {
			session = openSession();

			if (emp.isNew()) {
				session.save(emp);

				emp.setNew(false);
			}
			else {
				session.merge(emp);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
			EmpImpl.class, emp.getPrimaryKey(), emp);

		clearUniqueFindersCache(emp);
		cacheUniqueFindersCache(emp);

		return emp;
	}

	protected Emp toUnwrappedModel(Emp emp) {
		if (emp instanceof EmpImpl) {
			return emp;
		}

		EmpImpl empImpl = new EmpImpl();

		empImpl.setNew(emp.isNew());
		empImpl.setPrimaryKey(emp.getPrimaryKey());

		empImpl.setEmpId(emp.getEmpId());
		empImpl.setGroupId(emp.getGroupId());
		empImpl.setEmpCode(emp.getEmpCode());
		empImpl.setContactNumber(emp.getContactNumber());
		empImpl.setBirthday(emp.getBirthday());
		empImpl.setEthnic(emp.getEthnic());
		empImpl.setNationality(emp.getNationality());
		empImpl.setReligion(emp.getReligion());
		empImpl.setJoinedDate(emp.getJoinedDate());
		empImpl.setTitlesId(emp.getTitlesId());
		empImpl.setLevelId(emp.getLevelId());
		empImpl.setPromotedDate(emp.getPromotedDate());
		empImpl.setLaborContractSignedDate(emp.getLaborContractSignedDate());
		empImpl.setLaborContractExpiredDate(emp.getLaborContractExpiredDate());
		empImpl.setLaborContractType(emp.getLaborContractType());
		empImpl.setGender(emp.getGender());
		empImpl.setPlaceOfBirth(emp.getPlaceOfBirth());
		empImpl.setEducation(emp.getEducation());
		empImpl.setEducationSpecialize(emp.getEducationSpecialize());
		empImpl.setUniversityId(emp.getUniversityId());
		empImpl.setMaritalStatus(emp.getMaritalStatus());
		empImpl.setIdentityCardNo(emp.getIdentityCardNo());
		empImpl.setIssuedDate(emp.getIssuedDate());
		empImpl.setIssuedPlace(emp.getIssuedPlace());
		empImpl.setPassport(emp.getPassport());
		empImpl.setAddressId(emp.getAddressId());
		empImpl.setCompanyEmail(emp.getCompanyEmail());
		empImpl.setPersonalTaxCode(emp.getPersonalTaxCode());
		empImpl.setNumberOfDependents(emp.getNumberOfDependents());
		empImpl.setDependentNames(emp.getDependentNames());
		empImpl.setSocialInsuranceNo(emp.getSocialInsuranceNo());
		empImpl.setHealthInsuranceNo(emp.getHealthInsuranceNo());
		empImpl.setHealthInsurancePlace(emp.getHealthInsurancePlace());
		empImpl.setBankAccountNo(emp.getBankAccountNo());
		empImpl.setBankName(emp.getBankName());
		empImpl.setBankBranchName(emp.getBankBranchName());
		empImpl.setBaseWageRates(emp.getBaseWageRates());
		empImpl.setPositionWageRates(emp.getPositionWageRates());
		empImpl.setCapacitySalary(emp.getCapacitySalary());
		empImpl.setTotalSalary(emp.getTotalSalary());
		empImpl.setBonus(emp.getBonus());
		empImpl.setResignedDate(emp.getResignedDate());
		empImpl.setEmpUserId(emp.getEmpUserId());
		empImpl.setDeleted(emp.isDeleted());
		empImpl.setCompanyEmailAddress(emp.getCompanyEmailAddress());
		empImpl.setWorkingPlaceId(emp.getWorkingPlaceId());
		empImpl.setStatus(emp.getStatus());
		empImpl.setCompanyId(emp.getCompanyId());
		empImpl.setUserId(emp.getUserId());
		empImpl.setUserName(emp.getUserName());
		empImpl.setCreateDate(emp.getCreateDate());
		empImpl.setModifiedDate(emp.getModifiedDate());

		return empImpl;
	}

	/**
	 * Returns the emp with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp
	 * @return the emp
	 * @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpException, SystemException {
		Emp emp = fetchByPrimaryKey(primaryKey);

		if (emp == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return emp;
	}

	/**
	 * Returns the emp with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpException} if it could not be found.
	 *
	 * @param empId the primary key of the emp
	 * @return the emp
	 * @throws vn.com.ecopharma.emp.NoSuchEmpException if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp findByPrimaryKey(long empId)
		throws NoSuchEmpException, SystemException {
		return findByPrimaryKey((Serializable)empId);
	}

	/**
	 * Returns the emp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp
	 * @return the emp, or <code>null</code> if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Emp emp = (Emp)EntityCacheUtil.getResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
				EmpImpl.class, primaryKey);

		if (emp == _nullEmp) {
			return null;
		}

		if (emp == null) {
			Session session = null;

			try {
				session = openSession();

				emp = (Emp)session.get(EmpImpl.class, primaryKey);

				if (emp != null) {
					cacheResult(emp);
				}
				else {
					EntityCacheUtil.putResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
						EmpImpl.class, primaryKey, _nullEmp);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpModelImpl.ENTITY_CACHE_ENABLED,
					EmpImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return emp;
	}

	/**
	 * Returns the emp with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empId the primary key of the emp
	 * @return the emp, or <code>null</code> if a emp with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Emp fetchByPrimaryKey(long empId) throws SystemException {
		return fetchByPrimaryKey((Serializable)empId);
	}

	/**
	 * Returns all the emps.
	 *
	 * @return the emps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Emp> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @return the range of emps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Emp> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emps
	 * @param end the upper bound of the range of emps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emps
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Emp> findAll(int start, int end,
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

		List<Emp> list = (List<Emp>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMP;

				if (pagination) {
					sql = sql.concat(EmpModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Emp>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Emp>(list);
				}
				else {
					list = (List<Emp>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the emps from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Emp emp : findAll()) {
			remove(emp);
		}
	}

	/**
	 * Returns the number of emps.
	 *
	 * @return the number of emps
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

				Query q = session.createQuery(_SQL_COUNT_EMP);

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
	 * Initializes the emp persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Emp")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Emp>> listenersList = new ArrayList<ModelListener<Emp>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Emp>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMP = "SELECT emp FROM Emp emp";
	private static final String _SQL_SELECT_EMP_WHERE = "SELECT emp FROM Emp emp WHERE ";
	private static final String _SQL_COUNT_EMP = "SELECT COUNT(emp) FROM Emp emp";
	private static final String _SQL_COUNT_EMP_WHERE = "SELECT COUNT(emp) FROM Emp emp WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "emp.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Emp exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Emp exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpPersistenceImpl.class);
	private static Emp _nullEmp = new EmpImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Emp> toCacheModel() {
				return _nullEmpCacheModel;
			}
		};

	private static CacheModel<Emp> _nullEmpCacheModel = new CacheModel<Emp>() {
			@Override
			public Emp toEntityModel() {
				return _nullEmp;
			}
		};
}