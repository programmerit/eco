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

package vn.com.ecopharma.hrm.tt.service.persistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingImpl;
import vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the time tracking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TimeTrackingPersistence
 * @see TimeTrackingUtil
 * @generated
 */
public class TimeTrackingPersistenceImpl extends BasePersistenceImpl<TimeTracking>
	implements TimeTrackingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TimeTrackingUtil} to access the time tracking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TimeTrackingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, TimeTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, TimeTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMP = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, TimeTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmp",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, TimeTrackingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmp",
			new String[] { Long.class.getName() },
			TimeTrackingModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMP = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmp",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the time trackings where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the matching time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimeTracking> findByEmp(long empId) throws SystemException {
		return findByEmp(empId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackings where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of time trackings
	 * @param end the upper bound of the range of time trackings (not inclusive)
	 * @return the range of matching time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimeTracking> findByEmp(long empId, int start, int end)
		throws SystemException {
		return findByEmp(empId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackings where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of time trackings
	 * @param end the upper bound of the range of time trackings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimeTracking> findByEmp(long empId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP;
			finderArgs = new Object[] { empId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMP;
			finderArgs = new Object[] { empId, start, end, orderByComparator };
		}

		List<TimeTracking> list = (List<TimeTracking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TimeTracking timeTracking : list) {
				if ((empId != timeTracking.getEmpId())) {
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

			query.append(_SQL_SELECT_TIMETRACKING_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TimeTrackingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (!pagination) {
					list = (List<TimeTracking>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TimeTracking>(list);
				}
				else {
					list = (List<TimeTracking>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first time tracking in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracking
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking findByEmp_First(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchTimeTrackingException, SystemException {
		TimeTracking timeTracking = fetchByEmp_First(empId, orderByComparator);

		if (timeTracking != null) {
			return timeTracking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeTrackingException(msg.toString());
	}

	/**
	 * Returns the first time tracking in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching time tracking, or <code>null</code> if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking fetchByEmp_First(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TimeTracking> list = findByEmp(empId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last time tracking in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracking
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking findByEmp_Last(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchTimeTrackingException, SystemException {
		TimeTracking timeTracking = fetchByEmp_Last(empId, orderByComparator);

		if (timeTracking != null) {
			return timeTracking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTimeTrackingException(msg.toString());
	}

	/**
	 * Returns the last time tracking in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching time tracking, or <code>null</code> if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking fetchByEmp_Last(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmp(empId);

		if (count == 0) {
			return null;
		}

		List<TimeTracking> list = findByEmp(empId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the time trackings before and after the current time tracking in the ordered set where empId = &#63;.
	 *
	 * @param timeTrackingId the primary key of the current time tracking
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next time tracking
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking[] findByEmp_PrevAndNext(long timeTrackingId,
		long empId, OrderByComparator orderByComparator)
		throws NoSuchTimeTrackingException, SystemException {
		TimeTracking timeTracking = findByPrimaryKey(timeTrackingId);

		Session session = null;

		try {
			session = openSession();

			TimeTracking[] array = new TimeTrackingImpl[3];

			array[0] = getByEmp_PrevAndNext(session, timeTracking, empId,
					orderByComparator, true);

			array[1] = timeTracking;

			array[2] = getByEmp_PrevAndNext(session, timeTracking, empId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TimeTracking getByEmp_PrevAndNext(Session session,
		TimeTracking timeTracking, long empId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TIMETRACKING_WHERE);

		query.append(_FINDER_COLUMN_EMP_EMPID_2);

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
			query.append(TimeTrackingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(timeTracking);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TimeTracking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the time trackings where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmp(long empId) throws SystemException {
		for (TimeTracking timeTracking : findByEmp(empId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(timeTracking);
		}
	}

	/**
	 * Returns the number of time trackings where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmp(long empId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMP;

		Object[] finderArgs = new Object[] { empId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TIMETRACKING_WHERE);

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

	private static final String _FINDER_COLUMN_EMP_EMPID_2 = "timeTracking.empId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPANDDATE = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, TimeTrackingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByEmpAndDate",
			new String[] { Long.class.getName(), Date.class.getName() },
			TimeTrackingModelImpl.EMPID_COLUMN_BITMASK |
			TimeTrackingModelImpl.DATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPANDDATE = new FinderPath(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpAndDate",
			new String[] { Long.class.getName(), Date.class.getName() });

	/**
	 * Returns the time tracking where empId = &#63; and date = &#63; or throws a {@link vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException} if it could not be found.
	 *
	 * @param empId the emp ID
	 * @param date the date
	 * @return the matching time tracking
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking findByEmpAndDate(long empId, Date date)
		throws NoSuchTimeTrackingException, SystemException {
		TimeTracking timeTracking = fetchByEmpAndDate(empId, date);

		if (timeTracking == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empId=");
			msg.append(empId);

			msg.append(", date=");
			msg.append(date);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTimeTrackingException(msg.toString());
		}

		return timeTracking;
	}

	/**
	 * Returns the time tracking where empId = &#63; and date = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empId the emp ID
	 * @param date the date
	 * @return the matching time tracking, or <code>null</code> if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking fetchByEmpAndDate(long empId, Date date)
		throws SystemException {
		return fetchByEmpAndDate(empId, date, true);
	}

	/**
	 * Returns the time tracking where empId = &#63; and date = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empId the emp ID
	 * @param date the date
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching time tracking, or <code>null</code> if a matching time tracking could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking fetchByEmpAndDate(long empId, Date date,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { empId, date };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPANDDATE,
					finderArgs, this);
		}

		if (result instanceof TimeTracking) {
			TimeTracking timeTracking = (TimeTracking)result;

			if ((empId != timeTracking.getEmpId()) ||
					!Validator.equals(date, timeTracking.getDate())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TIMETRACKING_WHERE);

			query.append(_FINDER_COLUMN_EMPANDDATE_EMPID_2);

			boolean bindDate = false;

			if (date == null) {
				query.append(_FINDER_COLUMN_EMPANDDATE_DATE_1);
			}
			else {
				bindDate = true;

				query.append(_FINDER_COLUMN_EMPANDDATE_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindDate) {
					qPos.add(CalendarUtil.getTimestamp(date));
				}

				List<TimeTracking> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPANDDATE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TimeTrackingPersistenceImpl.fetchByEmpAndDate(long, Date, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TimeTracking timeTracking = list.get(0);

					result = timeTracking;

					cacheResult(timeTracking);

					if ((timeTracking.getEmpId() != empId) ||
							(timeTracking.getDate() == null) ||
							!timeTracking.getDate().equals(date)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPANDDATE,
							finderArgs, timeTracking);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPANDDATE,
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
			return (TimeTracking)result;
		}
	}

	/**
	 * Removes the time tracking where empId = &#63; and date = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @param date the date
	 * @return the time tracking that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking removeByEmpAndDate(long empId, Date date)
		throws NoSuchTimeTrackingException, SystemException {
		TimeTracking timeTracking = findByEmpAndDate(empId, date);

		return remove(timeTracking);
	}

	/**
	 * Returns the number of time trackings where empId = &#63; and date = &#63;.
	 *
	 * @param empId the emp ID
	 * @param date the date
	 * @return the number of matching time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmpAndDate(long empId, Date date)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPANDDATE;

		Object[] finderArgs = new Object[] { empId, date };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TIMETRACKING_WHERE);

			query.append(_FINDER_COLUMN_EMPANDDATE_EMPID_2);

			boolean bindDate = false;

			if (date == null) {
				query.append(_FINDER_COLUMN_EMPANDDATE_DATE_1);
			}
			else {
				bindDate = true;

				query.append(_FINDER_COLUMN_EMPANDDATE_DATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindDate) {
					qPos.add(CalendarUtil.getTimestamp(date));
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

	private static final String _FINDER_COLUMN_EMPANDDATE_EMPID_2 = "timeTracking.empId = ? AND ";
	private static final String _FINDER_COLUMN_EMPANDDATE_DATE_1 = "timeTracking.date IS NULL";
	private static final String _FINDER_COLUMN_EMPANDDATE_DATE_2 = "timeTracking.date = ?";

	public TimeTrackingPersistenceImpl() {
		setModelClass(TimeTracking.class);
	}

	/**
	 * Caches the time tracking in the entity cache if it is enabled.
	 *
	 * @param timeTracking the time tracking
	 */
	@Override
	public void cacheResult(TimeTracking timeTracking) {
		EntityCacheUtil.putResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingImpl.class, timeTracking.getPrimaryKey(), timeTracking);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPANDDATE,
			new Object[] { timeTracking.getEmpId(), timeTracking.getDate() },
			timeTracking);

		timeTracking.resetOriginalValues();
	}

	/**
	 * Caches the time trackings in the entity cache if it is enabled.
	 *
	 * @param timeTrackings the time trackings
	 */
	@Override
	public void cacheResult(List<TimeTracking> timeTrackings) {
		for (TimeTracking timeTracking : timeTrackings) {
			if (EntityCacheUtil.getResult(
						TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
						TimeTrackingImpl.class, timeTracking.getPrimaryKey()) == null) {
				cacheResult(timeTracking);
			}
			else {
				timeTracking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all time trackings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TimeTrackingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TimeTrackingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the time tracking.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TimeTracking timeTracking) {
		EntityCacheUtil.removeResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingImpl.class, timeTracking.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(timeTracking);
	}

	@Override
	public void clearCache(List<TimeTracking> timeTrackings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TimeTracking timeTracking : timeTrackings) {
			EntityCacheUtil.removeResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
				TimeTrackingImpl.class, timeTracking.getPrimaryKey());

			clearUniqueFindersCache(timeTracking);
		}
	}

	protected void cacheUniqueFindersCache(TimeTracking timeTracking) {
		if (timeTracking.isNew()) {
			Object[] args = new Object[] {
					timeTracking.getEmpId(), timeTracking.getDate()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPANDDATE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPANDDATE, args,
				timeTracking);
		}
		else {
			TimeTrackingModelImpl timeTrackingModelImpl = (TimeTrackingModelImpl)timeTracking;

			if ((timeTrackingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPANDDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeTracking.getEmpId(), timeTracking.getDate()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPANDDATE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPANDDATE,
					args, timeTracking);
			}
		}
	}

	protected void clearUniqueFindersCache(TimeTracking timeTracking) {
		TimeTrackingModelImpl timeTrackingModelImpl = (TimeTrackingModelImpl)timeTracking;

		Object[] args = new Object[] {
				timeTracking.getEmpId(), timeTracking.getDate()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPANDDATE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPANDDATE, args);

		if ((timeTrackingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPANDDATE.getColumnBitmask()) != 0) {
			args = new Object[] {
					timeTrackingModelImpl.getOriginalEmpId(),
					timeTrackingModelImpl.getOriginalDate()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPANDDATE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPANDDATE, args);
		}
	}

	/**
	 * Creates a new time tracking with the primary key. Does not add the time tracking to the database.
	 *
	 * @param timeTrackingId the primary key for the new time tracking
	 * @return the new time tracking
	 */
	@Override
	public TimeTracking create(long timeTrackingId) {
		TimeTracking timeTracking = new TimeTrackingImpl();

		timeTracking.setNew(true);
		timeTracking.setPrimaryKey(timeTrackingId);

		return timeTracking;
	}

	/**
	 * Removes the time tracking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param timeTrackingId the primary key of the time tracking
	 * @return the time tracking that was removed
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking remove(long timeTrackingId)
		throws NoSuchTimeTrackingException, SystemException {
		return remove((Serializable)timeTrackingId);
	}

	/**
	 * Removes the time tracking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the time tracking
	 * @return the time tracking that was removed
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking remove(Serializable primaryKey)
		throws NoSuchTimeTrackingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TimeTracking timeTracking = (TimeTracking)session.get(TimeTrackingImpl.class,
					primaryKey);

			if (timeTracking == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTimeTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(timeTracking);
		}
		catch (NoSuchTimeTrackingException nsee) {
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
	protected TimeTracking removeImpl(TimeTracking timeTracking)
		throws SystemException {
		timeTracking = toUnwrappedModel(timeTracking);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(timeTracking)) {
				timeTracking = (TimeTracking)session.get(TimeTrackingImpl.class,
						timeTracking.getPrimaryKeyObj());
			}

			if (timeTracking != null) {
				session.delete(timeTracking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (timeTracking != null) {
			clearCache(timeTracking);
		}

		return timeTracking;
	}

	@Override
	public TimeTracking updateImpl(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking)
		throws SystemException {
		timeTracking = toUnwrappedModel(timeTracking);

		boolean isNew = timeTracking.isNew();

		TimeTrackingModelImpl timeTrackingModelImpl = (TimeTrackingModelImpl)timeTracking;

		Session session = null;

		try {
			session = openSession();

			if (timeTracking.isNew()) {
				session.save(timeTracking);

				timeTracking.setNew(false);
			}
			else {
				session.merge(timeTracking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TimeTrackingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((timeTrackingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						timeTrackingModelImpl.getOriginalEmpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);

				args = new Object[] { timeTrackingModelImpl.getEmpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);
			}
		}

		EntityCacheUtil.putResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
			TimeTrackingImpl.class, timeTracking.getPrimaryKey(), timeTracking);

		clearUniqueFindersCache(timeTracking);
		cacheUniqueFindersCache(timeTracking);

		return timeTracking;
	}

	protected TimeTracking toUnwrappedModel(TimeTracking timeTracking) {
		if (timeTracking instanceof TimeTrackingImpl) {
			return timeTracking;
		}

		TimeTrackingImpl timeTrackingImpl = new TimeTrackingImpl();

		timeTrackingImpl.setNew(timeTracking.isNew());
		timeTrackingImpl.setPrimaryKey(timeTracking.getPrimaryKey());

		timeTrackingImpl.setTimeTrackingId(timeTracking.getTimeTrackingId());
		timeTrackingImpl.setEmpId(timeTracking.getEmpId());
		timeTrackingImpl.setDate(timeTracking.getDate());
		timeTrackingImpl.setIn1(timeTracking.getIn1());
		timeTrackingImpl.setOut1(timeTracking.getOut1());
		timeTrackingImpl.setIn2(timeTracking.getIn2());
		timeTrackingImpl.setOut2(timeTracking.getOut2());
		timeTrackingImpl.setIn3(timeTracking.getIn3());
		timeTrackingImpl.setOut3(timeTracking.getOut3());
		timeTrackingImpl.setGroupId(timeTracking.getGroupId());
		timeTrackingImpl.setCompanyId(timeTracking.getCompanyId());
		timeTrackingImpl.setUserId(timeTracking.getUserId());
		timeTrackingImpl.setUserName(timeTracking.getUserName());
		timeTrackingImpl.setCreateDate(timeTracking.getCreateDate());
		timeTrackingImpl.setModifiedDate(timeTracking.getModifiedDate());

		return timeTrackingImpl;
	}

	/**
	 * Returns the time tracking with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the time tracking
	 * @return the time tracking
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTimeTrackingException, SystemException {
		TimeTracking timeTracking = fetchByPrimaryKey(primaryKey);

		if (timeTracking == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTimeTrackingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return timeTracking;
	}

	/**
	 * Returns the time tracking with the primary key or throws a {@link vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException} if it could not be found.
	 *
	 * @param timeTrackingId the primary key of the time tracking
	 * @return the time tracking
	 * @throws vn.com.ecopharma.hrm.tt.NoSuchTimeTrackingException if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking findByPrimaryKey(long timeTrackingId)
		throws NoSuchTimeTrackingException, SystemException {
		return findByPrimaryKey((Serializable)timeTrackingId);
	}

	/**
	 * Returns the time tracking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the time tracking
	 * @return the time tracking, or <code>null</code> if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TimeTracking timeTracking = (TimeTracking)EntityCacheUtil.getResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
				TimeTrackingImpl.class, primaryKey);

		if (timeTracking == _nullTimeTracking) {
			return null;
		}

		if (timeTracking == null) {
			Session session = null;

			try {
				session = openSession();

				timeTracking = (TimeTracking)session.get(TimeTrackingImpl.class,
						primaryKey);

				if (timeTracking != null) {
					cacheResult(timeTracking);
				}
				else {
					EntityCacheUtil.putResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
						TimeTrackingImpl.class, primaryKey, _nullTimeTracking);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TimeTrackingModelImpl.ENTITY_CACHE_ENABLED,
					TimeTrackingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return timeTracking;
	}

	/**
	 * Returns the time tracking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param timeTrackingId the primary key of the time tracking
	 * @return the time tracking, or <code>null</code> if a time tracking with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TimeTracking fetchByPrimaryKey(long timeTrackingId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)timeTrackingId);
	}

	/**
	 * Returns all the time trackings.
	 *
	 * @return the time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimeTracking> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the time trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackings
	 * @param end the upper bound of the range of time trackings (not inclusive)
	 * @return the range of time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimeTracking> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the time trackings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.tt.model.impl.TimeTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of time trackings
	 * @param end the upper bound of the range of time trackings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of time trackings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TimeTracking> findAll(int start, int end,
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

		List<TimeTracking> list = (List<TimeTracking>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TIMETRACKING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TIMETRACKING;

				if (pagination) {
					sql = sql.concat(TimeTrackingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TimeTracking>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TimeTracking>(list);
				}
				else {
					list = (List<TimeTracking>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the time trackings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TimeTracking timeTracking : findAll()) {
			remove(timeTracking);
		}
	}

	/**
	 * Returns the number of time trackings.
	 *
	 * @return the number of time trackings
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

				Query q = session.createQuery(_SQL_COUNT_TIMETRACKING);

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
	 * Initializes the time tracking persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.tt.model.TimeTracking")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TimeTracking>> listenersList = new ArrayList<ModelListener<TimeTracking>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TimeTracking>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TimeTrackingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TIMETRACKING = "SELECT timeTracking FROM TimeTracking timeTracking";
	private static final String _SQL_SELECT_TIMETRACKING_WHERE = "SELECT timeTracking FROM TimeTracking timeTracking WHERE ";
	private static final String _SQL_COUNT_TIMETRACKING = "SELECT COUNT(timeTracking) FROM TimeTracking timeTracking";
	private static final String _SQL_COUNT_TIMETRACKING_WHERE = "SELECT COUNT(timeTracking) FROM TimeTracking timeTracking WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "timeTracking.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TimeTracking exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TimeTracking exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TimeTrackingPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static TimeTracking _nullTimeTracking = new TimeTrackingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TimeTracking> toCacheModel() {
				return _nullTimeTrackingCacheModel;
			}
		};

	private static CacheModel<TimeTracking> _nullTimeTrackingCacheModel = new CacheModel<TimeTracking>() {
			@Override
			public TimeTracking toEntityModel() {
				return _nullTimeTracking;
			}
		};
}