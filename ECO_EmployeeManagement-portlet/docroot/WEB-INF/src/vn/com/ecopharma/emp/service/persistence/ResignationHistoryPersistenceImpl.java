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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchResignationHistoryException;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.model.impl.ResignationHistoryImpl;
import vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the resignation history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see ResignationHistoryPersistence
 * @see ResignationHistoryUtil
 * @generated
 */
public class ResignationHistoryPersistenceImpl extends BasePersistenceImpl<ResignationHistory>
	implements ResignationHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ResignationHistoryUtil} to access the resignation history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ResignationHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryModelImpl.FINDER_CACHE_ENABLED,
			ResignationHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryModelImpl.FINDER_CACHE_ENABLED,
			ResignationHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEE = new FinderPath(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryModelImpl.FINDER_CACHE_ENABLED,
			ResignationHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmployee",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE =
		new FinderPath(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryModelImpl.FINDER_CACHE_ENABLED,
			ResignationHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployee",
			new String[] { Long.class.getName() },
			ResignationHistoryModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEE = new FinderPath(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployee",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the resignation histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResignationHistory> findByEmployee(long employeeId)
		throws SystemException {
		return findByEmployee(employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the resignation histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of resignation histories
	 * @param end the upper bound of the range of resignation histories (not inclusive)
	 * @return the range of matching resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResignationHistory> findByEmployee(long employeeId, int start,
		int end) throws SystemException {
		return findByEmployee(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the resignation histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of resignation histories
	 * @param end the upper bound of the range of resignation histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResignationHistory> findByEmployee(long employeeId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE;
			finderArgs = new Object[] { employeeId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEE;
			finderArgs = new Object[] { employeeId, start, end, orderByComparator };
		}

		List<ResignationHistory> list = (List<ResignationHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ResignationHistory resignationHistory : list) {
				if ((employeeId != resignationHistory.getEmployeeId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_RESIGNATIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEE_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ResignationHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<ResignationHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResignationHistory>(list);
				}
				else {
					list = (List<ResignationHistory>)QueryUtil.list(q,
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
	 * Returns the first resignation history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resignation history
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a matching resignation history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory findByEmployee_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchResignationHistoryException, SystemException {
		ResignationHistory resignationHistory = fetchByEmployee_First(employeeId,
				orderByComparator);

		if (resignationHistory != null) {
			return resignationHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResignationHistoryException(msg.toString());
	}

	/**
	 * Returns the first resignation history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resignation history, or <code>null</code> if a matching resignation history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory fetchByEmployee_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ResignationHistory> list = findByEmployee(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resignation history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resignation history
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a matching resignation history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory findByEmployee_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchResignationHistoryException, SystemException {
		ResignationHistory resignationHistory = fetchByEmployee_Last(employeeId,
				orderByComparator);

		if (resignationHistory != null) {
			return resignationHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchResignationHistoryException(msg.toString());
	}

	/**
	 * Returns the last resignation history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resignation history, or <code>null</code> if a matching resignation history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory fetchByEmployee_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmployee(employeeId);

		if (count == 0) {
			return null;
		}

		List<ResignationHistory> list = findByEmployee(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the resignation histories before and after the current resignation history in the ordered set where employeeId = &#63;.
	 *
	 * @param resignationHistoryId the primary key of the current resignation history
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resignation history
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory[] findByEmployee_PrevAndNext(
		long resignationHistoryId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchResignationHistoryException, SystemException {
		ResignationHistory resignationHistory = findByPrimaryKey(resignationHistoryId);

		Session session = null;

		try {
			session = openSession();

			ResignationHistory[] array = new ResignationHistoryImpl[3];

			array[0] = getByEmployee_PrevAndNext(session, resignationHistory,
					employeeId, orderByComparator, true);

			array[1] = resignationHistory;

			array[2] = getByEmployee_PrevAndNext(session, resignationHistory,
					employeeId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResignationHistory getByEmployee_PrevAndNext(Session session,
		ResignationHistory resignationHistory, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RESIGNATIONHISTORY_WHERE);

		query.append(_FINDER_COLUMN_EMPLOYEE_EMPLOYEEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ResignationHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(resignationHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ResignationHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resignation histories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmployee(long employeeId) throws SystemException {
		for (ResignationHistory resignationHistory : findByEmployee(
				employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(resignationHistory);
		}
	}

	/**
	 * Returns the number of resignation histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmployee(long employeeId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPLOYEE;

		Object[] finderArgs = new Object[] { employeeId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RESIGNATIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEE_EMPLOYEEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

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

	private static final String _FINDER_COLUMN_EMPLOYEE_EMPLOYEEID_2 = "resignationHistory.employeeId = ?";

	public ResignationHistoryPersistenceImpl() {
		setModelClass(ResignationHistory.class);
	}

	/**
	 * Caches the resignation history in the entity cache if it is enabled.
	 *
	 * @param resignationHistory the resignation history
	 */
	@Override
	public void cacheResult(ResignationHistory resignationHistory) {
		EntityCacheUtil.putResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryImpl.class, resignationHistory.getPrimaryKey(),
			resignationHistory);

		resignationHistory.resetOriginalValues();
	}

	/**
	 * Caches the resignation histories in the entity cache if it is enabled.
	 *
	 * @param resignationHistories the resignation histories
	 */
	@Override
	public void cacheResult(List<ResignationHistory> resignationHistories) {
		for (ResignationHistory resignationHistory : resignationHistories) {
			if (EntityCacheUtil.getResult(
						ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ResignationHistoryImpl.class,
						resignationHistory.getPrimaryKey()) == null) {
				cacheResult(resignationHistory);
			}
			else {
				resignationHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all resignation histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ResignationHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ResignationHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resignation history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResignationHistory resignationHistory) {
		EntityCacheUtil.removeResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryImpl.class, resignationHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ResignationHistory> resignationHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResignationHistory resignationHistory : resignationHistories) {
			EntityCacheUtil.removeResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ResignationHistoryImpl.class, resignationHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new resignation history with the primary key. Does not add the resignation history to the database.
	 *
	 * @param resignationHistoryId the primary key for the new resignation history
	 * @return the new resignation history
	 */
	@Override
	public ResignationHistory create(long resignationHistoryId) {
		ResignationHistory resignationHistory = new ResignationHistoryImpl();

		resignationHistory.setNew(true);
		resignationHistory.setPrimaryKey(resignationHistoryId);

		return resignationHistory;
	}

	/**
	 * Removes the resignation history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resignationHistoryId the primary key of the resignation history
	 * @return the resignation history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory remove(long resignationHistoryId)
		throws NoSuchResignationHistoryException, SystemException {
		return remove((Serializable)resignationHistoryId);
	}

	/**
	 * Removes the resignation history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resignation history
	 * @return the resignation history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory remove(Serializable primaryKey)
		throws NoSuchResignationHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ResignationHistory resignationHistory = (ResignationHistory)session.get(ResignationHistoryImpl.class,
					primaryKey);

			if (resignationHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResignationHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(resignationHistory);
		}
		catch (NoSuchResignationHistoryException nsee) {
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
	protected ResignationHistory removeImpl(
		ResignationHistory resignationHistory) throws SystemException {
		resignationHistory = toUnwrappedModel(resignationHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resignationHistory)) {
				resignationHistory = (ResignationHistory)session.get(ResignationHistoryImpl.class,
						resignationHistory.getPrimaryKeyObj());
			}

			if (resignationHistory != null) {
				session.delete(resignationHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (resignationHistory != null) {
			clearCache(resignationHistory);
		}

		return resignationHistory;
	}

	@Override
	public ResignationHistory updateImpl(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory)
		throws SystemException {
		resignationHistory = toUnwrappedModel(resignationHistory);

		boolean isNew = resignationHistory.isNew();

		ResignationHistoryModelImpl resignationHistoryModelImpl = (ResignationHistoryModelImpl)resignationHistory;

		Session session = null;

		try {
			session = openSession();

			if (resignationHistory.isNew()) {
				session.save(resignationHistory);

				resignationHistory.setNew(false);
			}
			else {
				session.merge(resignationHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ResignationHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((resignationHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						resignationHistoryModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE,
					args);

				args = new Object[] { resignationHistoryModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE,
					args);
			}
		}

		EntityCacheUtil.putResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
			ResignationHistoryImpl.class, resignationHistory.getPrimaryKey(),
			resignationHistory);

		return resignationHistory;
	}

	protected ResignationHistory toUnwrappedModel(
		ResignationHistory resignationHistory) {
		if (resignationHistory instanceof ResignationHistoryImpl) {
			return resignationHistory;
		}

		ResignationHistoryImpl resignationHistoryImpl = new ResignationHistoryImpl();

		resignationHistoryImpl.setNew(resignationHistory.isNew());
		resignationHistoryImpl.setPrimaryKey(resignationHistory.getPrimaryKey());

		resignationHistoryImpl.setResignationHistoryId(resignationHistory.getResignationHistoryId());
		resignationHistoryImpl.setEmployeeId(resignationHistory.getEmployeeId());
		resignationHistoryImpl.setResignedDate(resignationHistory.getResignedDate());
		resignationHistoryImpl.setResignedType(resignationHistory.getResignedType());
		resignationHistoryImpl.setComment(resignationHistory.getComment());
		resignationHistoryImpl.setGroupId(resignationHistory.getGroupId());
		resignationHistoryImpl.setCompanyId(resignationHistory.getCompanyId());
		resignationHistoryImpl.setUserId(resignationHistory.getUserId());
		resignationHistoryImpl.setUserName(resignationHistory.getUserName());
		resignationHistoryImpl.setCreateDate(resignationHistory.getCreateDate());
		resignationHistoryImpl.setModifiedDate(resignationHistory.getModifiedDate());
		resignationHistoryImpl.setDeleted(resignationHistory.isDeleted());

		return resignationHistoryImpl;
	}

	/**
	 * Returns the resignation history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the resignation history
	 * @return the resignation history
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResignationHistoryException, SystemException {
		ResignationHistory resignationHistory = fetchByPrimaryKey(primaryKey);

		if (resignationHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResignationHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return resignationHistory;
	}

	/**
	 * Returns the resignation history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchResignationHistoryException} if it could not be found.
	 *
	 * @param resignationHistoryId the primary key of the resignation history
	 * @return the resignation history
	 * @throws vn.com.ecopharma.emp.NoSuchResignationHistoryException if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory findByPrimaryKey(long resignationHistoryId)
		throws NoSuchResignationHistoryException, SystemException {
		return findByPrimaryKey((Serializable)resignationHistoryId);
	}

	/**
	 * Returns the resignation history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resignation history
	 * @return the resignation history, or <code>null</code> if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ResignationHistory resignationHistory = (ResignationHistory)EntityCacheUtil.getResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
				ResignationHistoryImpl.class, primaryKey);

		if (resignationHistory == _nullResignationHistory) {
			return null;
		}

		if (resignationHistory == null) {
			Session session = null;

			try {
				session = openSession();

				resignationHistory = (ResignationHistory)session.get(ResignationHistoryImpl.class,
						primaryKey);

				if (resignationHistory != null) {
					cacheResult(resignationHistory);
				}
				else {
					EntityCacheUtil.putResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
						ResignationHistoryImpl.class, primaryKey,
						_nullResignationHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ResignationHistoryModelImpl.ENTITY_CACHE_ENABLED,
					ResignationHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return resignationHistory;
	}

	/**
	 * Returns the resignation history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resignationHistoryId the primary key of the resignation history
	 * @return the resignation history, or <code>null</code> if a resignation history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ResignationHistory fetchByPrimaryKey(long resignationHistoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)resignationHistoryId);
	}

	/**
	 * Returns all the resignation histories.
	 *
	 * @return the resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResignationHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the resignation histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of resignation histories
	 * @param end the upper bound of the range of resignation histories (not inclusive)
	 * @return the range of resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResignationHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the resignation histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.ResignationHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of resignation histories
	 * @param end the upper bound of the range of resignation histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resignation histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ResignationHistory> findAll(int start, int end,
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

		List<ResignationHistory> list = (List<ResignationHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RESIGNATIONHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RESIGNATIONHISTORY;

				if (pagination) {
					sql = sql.concat(ResignationHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ResignationHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ResignationHistory>(list);
				}
				else {
					list = (List<ResignationHistory>)QueryUtil.list(q,
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
	 * Removes all the resignation histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ResignationHistory resignationHistory : findAll()) {
			remove(resignationHistory);
		}
	}

	/**
	 * Returns the number of resignation histories.
	 *
	 * @return the number of resignation histories
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

				Query q = session.createQuery(_SQL_COUNT_RESIGNATIONHISTORY);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the resignation history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.ResignationHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ResignationHistory>> listenersList = new ArrayList<ModelListener<ResignationHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ResignationHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ResignationHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RESIGNATIONHISTORY = "SELECT resignationHistory FROM ResignationHistory resignationHistory";
	private static final String _SQL_SELECT_RESIGNATIONHISTORY_WHERE = "SELECT resignationHistory FROM ResignationHistory resignationHistory WHERE ";
	private static final String _SQL_COUNT_RESIGNATIONHISTORY = "SELECT COUNT(resignationHistory) FROM ResignationHistory resignationHistory";
	private static final String _SQL_COUNT_RESIGNATIONHISTORY_WHERE = "SELECT COUNT(resignationHistory) FROM ResignationHistory resignationHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "resignationHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ResignationHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ResignationHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ResignationHistoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static ResignationHistory _nullResignationHistory = new ResignationHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ResignationHistory> toCacheModel() {
				return _nullResignationHistoryCacheModel;
			}
		};

	private static CacheModel<ResignationHistory> _nullResignationHistoryCacheModel =
		new CacheModel<ResignationHistory>() {
			@Override
			public ResignationHistory toEntityModel() {
				return _nullResignationHistory;
			}
		};
}