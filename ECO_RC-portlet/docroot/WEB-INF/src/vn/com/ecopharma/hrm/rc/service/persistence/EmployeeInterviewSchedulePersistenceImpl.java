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

import vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException;
import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleImpl;
import vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the employee interview schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmployeeInterviewSchedulePersistence
 * @see EmployeeInterviewScheduleUtil
 * @generated
 */
public class EmployeeInterviewSchedulePersistenceImpl
	extends BasePersistenceImpl<EmployeeInterviewSchedule>
	implements EmployeeInterviewSchedulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmployeeInterviewScheduleUtil} to access the employee interview schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmployeeInterviewScheduleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INTERVIEWSCHEDULE =
		new FinderPath(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInterviewSchedule",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INTERVIEWSCHEDULE =
		new FinderPath(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByInterviewSchedule", new String[] { Long.class.getName() },
			EmployeeInterviewScheduleModelImpl.INTERVIEWSCHEDULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INTERVIEWSCHEDULE = new FinderPath(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInterviewSchedule", new String[] { Long.class.getName() });

	/**
	 * Returns all the employee interview schedules where interviewScheduleId = &#63;.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @return the matching employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInterviewSchedule> findByInterviewSchedule(
		long interviewScheduleId) throws SystemException {
		return findByInterviewSchedule(interviewScheduleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee interview schedules where interviewScheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @param start the lower bound of the range of employee interview schedules
	 * @param end the upper bound of the range of employee interview schedules (not inclusive)
	 * @return the range of matching employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInterviewSchedule> findByInterviewSchedule(
		long interviewScheduleId, int start, int end) throws SystemException {
		return findByInterviewSchedule(interviewScheduleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee interview schedules where interviewScheduleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @param start the lower bound of the range of employee interview schedules
	 * @param end the upper bound of the range of employee interview schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInterviewSchedule> findByInterviewSchedule(
		long interviewScheduleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INTERVIEWSCHEDULE;
			finderArgs = new Object[] { interviewScheduleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INTERVIEWSCHEDULE;
			finderArgs = new Object[] {
					interviewScheduleId,
					
					start, end, orderByComparator
				};
		}

		List<EmployeeInterviewSchedule> list = (List<EmployeeInterviewSchedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmployeeInterviewSchedule employeeInterviewSchedule : list) {
				if ((interviewScheduleId != employeeInterviewSchedule.getInterviewScheduleId())) {
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

			query.append(_SQL_SELECT_EMPLOYEEINTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_INTERVIEWSCHEDULE_INTERVIEWSCHEDULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmployeeInterviewScheduleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(interviewScheduleId);

				if (!pagination) {
					list = (List<EmployeeInterviewSchedule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeInterviewSchedule>(list);
				}
				else {
					list = (List<EmployeeInterviewSchedule>)QueryUtil.list(q,
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
	 * Returns the first employee interview schedule in the ordered set where interviewScheduleId = &#63;.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a matching employee interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule findByInterviewSchedule_First(
		long interviewScheduleId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		EmployeeInterviewSchedule employeeInterviewSchedule = fetchByInterviewSchedule_First(interviewScheduleId,
				orderByComparator);

		if (employeeInterviewSchedule != null) {
			return employeeInterviewSchedule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("interviewScheduleId=");
		msg.append(interviewScheduleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeInterviewScheduleException(msg.toString());
	}

	/**
	 * Returns the first employee interview schedule in the ordered set where interviewScheduleId = &#63;.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching employee interview schedule, or <code>null</code> if a matching employee interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule fetchByInterviewSchedule_First(
		long interviewScheduleId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EmployeeInterviewSchedule> list = findByInterviewSchedule(interviewScheduleId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last employee interview schedule in the ordered set where interviewScheduleId = &#63;.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a matching employee interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule findByInterviewSchedule_Last(
		long interviewScheduleId, OrderByComparator orderByComparator)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		EmployeeInterviewSchedule employeeInterviewSchedule = fetchByInterviewSchedule_Last(interviewScheduleId,
				orderByComparator);

		if (employeeInterviewSchedule != null) {
			return employeeInterviewSchedule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("interviewScheduleId=");
		msg.append(interviewScheduleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmployeeInterviewScheduleException(msg.toString());
	}

	/**
	 * Returns the last employee interview schedule in the ordered set where interviewScheduleId = &#63;.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching employee interview schedule, or <code>null</code> if a matching employee interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule fetchByInterviewSchedule_Last(
		long interviewScheduleId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByInterviewSchedule(interviewScheduleId);

		if (count == 0) {
			return null;
		}

		List<EmployeeInterviewSchedule> list = findByInterviewSchedule(interviewScheduleId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the employee interview schedules before and after the current employee interview schedule in the ordered set where interviewScheduleId = &#63;.
	 *
	 * @param employeeInterviewScheduleId the primary key of the current employee interview schedule
	 * @param interviewScheduleId the interview schedule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next employee interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule[] findByInterviewSchedule_PrevAndNext(
		long employeeInterviewScheduleId, long interviewScheduleId,
		OrderByComparator orderByComparator)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		EmployeeInterviewSchedule employeeInterviewSchedule = findByPrimaryKey(employeeInterviewScheduleId);

		Session session = null;

		try {
			session = openSession();

			EmployeeInterviewSchedule[] array = new EmployeeInterviewScheduleImpl[3];

			array[0] = getByInterviewSchedule_PrevAndNext(session,
					employeeInterviewSchedule, interviewScheduleId,
					orderByComparator, true);

			array[1] = employeeInterviewSchedule;

			array[2] = getByInterviewSchedule_PrevAndNext(session,
					employeeInterviewSchedule, interviewScheduleId,
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

	protected EmployeeInterviewSchedule getByInterviewSchedule_PrevAndNext(
		Session session, EmployeeInterviewSchedule employeeInterviewSchedule,
		long interviewScheduleId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLOYEEINTERVIEWSCHEDULE_WHERE);

		query.append(_FINDER_COLUMN_INTERVIEWSCHEDULE_INTERVIEWSCHEDULEID_2);

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
			query.append(EmployeeInterviewScheduleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(interviewScheduleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(employeeInterviewSchedule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmployeeInterviewSchedule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the employee interview schedules where interviewScheduleId = &#63; from the database.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByInterviewSchedule(long interviewScheduleId)
		throws SystemException {
		for (EmployeeInterviewSchedule employeeInterviewSchedule : findByInterviewSchedule(
				interviewScheduleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(employeeInterviewSchedule);
		}
	}

	/**
	 * Returns the number of employee interview schedules where interviewScheduleId = &#63;.
	 *
	 * @param interviewScheduleId the interview schedule ID
	 * @return the number of matching employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByInterviewSchedule(long interviewScheduleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INTERVIEWSCHEDULE;

		Object[] finderArgs = new Object[] { interviewScheduleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPLOYEEINTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_INTERVIEWSCHEDULE_INTERVIEWSCHEDULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(interviewScheduleId);

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

	private static final String _FINDER_COLUMN_INTERVIEWSCHEDULE_INTERVIEWSCHEDULEID_2 =
		"employeeInterviewSchedule.interviewScheduleId = ?";

	public EmployeeInterviewSchedulePersistenceImpl() {
		setModelClass(EmployeeInterviewSchedule.class);
	}

	/**
	 * Caches the employee interview schedule in the entity cache if it is enabled.
	 *
	 * @param employeeInterviewSchedule the employee interview schedule
	 */
	@Override
	public void cacheResult(EmployeeInterviewSchedule employeeInterviewSchedule) {
		EntityCacheUtil.putResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			employeeInterviewSchedule.getPrimaryKey(), employeeInterviewSchedule);

		employeeInterviewSchedule.resetOriginalValues();
	}

	/**
	 * Caches the employee interview schedules in the entity cache if it is enabled.
	 *
	 * @param employeeInterviewSchedules the employee interview schedules
	 */
	@Override
	public void cacheResult(
		List<EmployeeInterviewSchedule> employeeInterviewSchedules) {
		for (EmployeeInterviewSchedule employeeInterviewSchedule : employeeInterviewSchedules) {
			if (EntityCacheUtil.getResult(
						EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeInterviewScheduleImpl.class,
						employeeInterviewSchedule.getPrimaryKey()) == null) {
				cacheResult(employeeInterviewSchedule);
			}
			else {
				employeeInterviewSchedule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all employee interview schedules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmployeeInterviewScheduleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmployeeInterviewScheduleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the employee interview schedule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmployeeInterviewSchedule employeeInterviewSchedule) {
		EntityCacheUtil.removeResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			employeeInterviewSchedule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<EmployeeInterviewSchedule> employeeInterviewSchedules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmployeeInterviewSchedule employeeInterviewSchedule : employeeInterviewSchedules) {
			EntityCacheUtil.removeResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeInterviewScheduleImpl.class,
				employeeInterviewSchedule.getPrimaryKey());
		}
	}

	/**
	 * Creates a new employee interview schedule with the primary key. Does not add the employee interview schedule to the database.
	 *
	 * @param employeeInterviewScheduleId the primary key for the new employee interview schedule
	 * @return the new employee interview schedule
	 */
	@Override
	public EmployeeInterviewSchedule create(long employeeInterviewScheduleId) {
		EmployeeInterviewSchedule employeeInterviewSchedule = new EmployeeInterviewScheduleImpl();

		employeeInterviewSchedule.setNew(true);
		employeeInterviewSchedule.setPrimaryKey(employeeInterviewScheduleId);

		return employeeInterviewSchedule;
	}

	/**
	 * Removes the employee interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param employeeInterviewScheduleId the primary key of the employee interview schedule
	 * @return the employee interview schedule that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule remove(long employeeInterviewScheduleId)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		return remove((Serializable)employeeInterviewScheduleId);
	}

	/**
	 * Removes the employee interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the employee interview schedule
	 * @return the employee interview schedule that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule remove(Serializable primaryKey)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmployeeInterviewSchedule employeeInterviewSchedule = (EmployeeInterviewSchedule)session.get(EmployeeInterviewScheduleImpl.class,
					primaryKey);

			if (employeeInterviewSchedule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmployeeInterviewScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(employeeInterviewSchedule);
		}
		catch (NoSuchEmployeeInterviewScheduleException nsee) {
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
	protected EmployeeInterviewSchedule removeImpl(
		EmployeeInterviewSchedule employeeInterviewSchedule)
		throws SystemException {
		employeeInterviewSchedule = toUnwrappedModel(employeeInterviewSchedule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(employeeInterviewSchedule)) {
				employeeInterviewSchedule = (EmployeeInterviewSchedule)session.get(EmployeeInterviewScheduleImpl.class,
						employeeInterviewSchedule.getPrimaryKeyObj());
			}

			if (employeeInterviewSchedule != null) {
				session.delete(employeeInterviewSchedule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (employeeInterviewSchedule != null) {
			clearCache(employeeInterviewSchedule);
		}

		return employeeInterviewSchedule;
	}

	@Override
	public EmployeeInterviewSchedule updateImpl(
		vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule employeeInterviewSchedule)
		throws SystemException {
		employeeInterviewSchedule = toUnwrappedModel(employeeInterviewSchedule);

		boolean isNew = employeeInterviewSchedule.isNew();

		EmployeeInterviewScheduleModelImpl employeeInterviewScheduleModelImpl = (EmployeeInterviewScheduleModelImpl)employeeInterviewSchedule;

		Session session = null;

		try {
			session = openSession();

			if (employeeInterviewSchedule.isNew()) {
				session.save(employeeInterviewSchedule);

				employeeInterviewSchedule.setNew(false);
			}
			else {
				session.merge(employeeInterviewSchedule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!EmployeeInterviewScheduleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((employeeInterviewScheduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INTERVIEWSCHEDULE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						employeeInterviewScheduleModelImpl.getOriginalInterviewScheduleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INTERVIEWSCHEDULE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INTERVIEWSCHEDULE,
					args);

				args = new Object[] {
						employeeInterviewScheduleModelImpl.getInterviewScheduleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_INTERVIEWSCHEDULE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INTERVIEWSCHEDULE,
					args);
			}
		}

		EntityCacheUtil.putResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			EmployeeInterviewScheduleImpl.class,
			employeeInterviewSchedule.getPrimaryKey(), employeeInterviewSchedule);

		return employeeInterviewSchedule;
	}

	protected EmployeeInterviewSchedule toUnwrappedModel(
		EmployeeInterviewSchedule employeeInterviewSchedule) {
		if (employeeInterviewSchedule instanceof EmployeeInterviewScheduleImpl) {
			return employeeInterviewSchedule;
		}

		EmployeeInterviewScheduleImpl employeeInterviewScheduleImpl = new EmployeeInterviewScheduleImpl();

		employeeInterviewScheduleImpl.setNew(employeeInterviewSchedule.isNew());
		employeeInterviewScheduleImpl.setPrimaryKey(employeeInterviewSchedule.getPrimaryKey());

		employeeInterviewScheduleImpl.setEmployeeInterviewScheduleId(employeeInterviewSchedule.getEmployeeInterviewScheduleId());
		employeeInterviewScheduleImpl.setEmployeeId(employeeInterviewSchedule.getEmployeeId());
		employeeInterviewScheduleImpl.setInterviewScheduleId(employeeInterviewSchedule.getInterviewScheduleId());
		employeeInterviewScheduleImpl.setNote(employeeInterviewSchedule.getNote());
		employeeInterviewScheduleImpl.setGroupId(employeeInterviewSchedule.getGroupId());
		employeeInterviewScheduleImpl.setCompanyId(employeeInterviewSchedule.getCompanyId());
		employeeInterviewScheduleImpl.setUserId(employeeInterviewSchedule.getUserId());
		employeeInterviewScheduleImpl.setUserName(employeeInterviewSchedule.getUserName());
		employeeInterviewScheduleImpl.setCreateDate(employeeInterviewSchedule.getCreateDate());
		employeeInterviewScheduleImpl.setModifiedDate(employeeInterviewSchedule.getModifiedDate());

		return employeeInterviewScheduleImpl;
	}

	/**
	 * Returns the employee interview schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee interview schedule
	 * @return the employee interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		EmployeeInterviewSchedule employeeInterviewSchedule = fetchByPrimaryKey(primaryKey);

		if (employeeInterviewSchedule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmployeeInterviewScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return employeeInterviewSchedule;
	}

	/**
	 * Returns the employee interview schedule with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException} if it could not be found.
	 *
	 * @param employeeInterviewScheduleId the primary key of the employee interview schedule
	 * @return the employee interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule findByPrimaryKey(
		long employeeInterviewScheduleId)
		throws NoSuchEmployeeInterviewScheduleException, SystemException {
		return findByPrimaryKey((Serializable)employeeInterviewScheduleId);
	}

	/**
	 * Returns the employee interview schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the employee interview schedule
	 * @return the employee interview schedule, or <code>null</code> if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmployeeInterviewSchedule employeeInterviewSchedule = (EmployeeInterviewSchedule)EntityCacheUtil.getResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
				EmployeeInterviewScheduleImpl.class, primaryKey);

		if (employeeInterviewSchedule == _nullEmployeeInterviewSchedule) {
			return null;
		}

		if (employeeInterviewSchedule == null) {
			Session session = null;

			try {
				session = openSession();

				employeeInterviewSchedule = (EmployeeInterviewSchedule)session.get(EmployeeInterviewScheduleImpl.class,
						primaryKey);

				if (employeeInterviewSchedule != null) {
					cacheResult(employeeInterviewSchedule);
				}
				else {
					EntityCacheUtil.putResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
						EmployeeInterviewScheduleImpl.class, primaryKey,
						_nullEmployeeInterviewSchedule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmployeeInterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
					EmployeeInterviewScheduleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return employeeInterviewSchedule;
	}

	/**
	 * Returns the employee interview schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param employeeInterviewScheduleId the primary key of the employee interview schedule
	 * @return the employee interview schedule, or <code>null</code> if a employee interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmployeeInterviewSchedule fetchByPrimaryKey(
		long employeeInterviewScheduleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)employeeInterviewScheduleId);
	}

	/**
	 * Returns all the employee interview schedules.
	 *
	 * @return the employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInterviewSchedule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the employee interview schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee interview schedules
	 * @param end the upper bound of the range of employee interview schedules (not inclusive)
	 * @return the range of employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInterviewSchedule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the employee interview schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of employee interview schedules
	 * @param end the upper bound of the range of employee interview schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of employee interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmployeeInterviewSchedule> findAll(int start, int end,
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

		List<EmployeeInterviewSchedule> list = (List<EmployeeInterviewSchedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLOYEEINTERVIEWSCHEDULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLOYEEINTERVIEWSCHEDULE;

				if (pagination) {
					sql = sql.concat(EmployeeInterviewScheduleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmployeeInterviewSchedule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmployeeInterviewSchedule>(list);
				}
				else {
					list = (List<EmployeeInterviewSchedule>)QueryUtil.list(q,
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
	 * Removes all the employee interview schedules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmployeeInterviewSchedule employeeInterviewSchedule : findAll()) {
			remove(employeeInterviewSchedule);
		}
	}

	/**
	 * Returns the number of employee interview schedules.
	 *
	 * @return the number of employee interview schedules
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

				Query q = session.createQuery(_SQL_COUNT_EMPLOYEEINTERVIEWSCHEDULE);

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
	 * Initializes the employee interview schedule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmployeeInterviewSchedule>> listenersList = new ArrayList<ModelListener<EmployeeInterviewSchedule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmployeeInterviewSchedule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmployeeInterviewScheduleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLOYEEINTERVIEWSCHEDULE = "SELECT employeeInterviewSchedule FROM EmployeeInterviewSchedule employeeInterviewSchedule";
	private static final String _SQL_SELECT_EMPLOYEEINTERVIEWSCHEDULE_WHERE = "SELECT employeeInterviewSchedule FROM EmployeeInterviewSchedule employeeInterviewSchedule WHERE ";
	private static final String _SQL_COUNT_EMPLOYEEINTERVIEWSCHEDULE = "SELECT COUNT(employeeInterviewSchedule) FROM EmployeeInterviewSchedule employeeInterviewSchedule";
	private static final String _SQL_COUNT_EMPLOYEEINTERVIEWSCHEDULE_WHERE = "SELECT COUNT(employeeInterviewSchedule) FROM EmployeeInterviewSchedule employeeInterviewSchedule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "employeeInterviewSchedule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmployeeInterviewSchedule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmployeeInterviewSchedule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmployeeInterviewSchedulePersistenceImpl.class);
	private static EmployeeInterviewSchedule _nullEmployeeInterviewSchedule = new EmployeeInterviewScheduleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmployeeInterviewSchedule> toCacheModel() {
				return _nullEmployeeInterviewScheduleCacheModel;
			}
		};

	private static CacheModel<EmployeeInterviewSchedule> _nullEmployeeInterviewScheduleCacheModel =
		new CacheModel<EmployeeInterviewSchedule>() {
			@Override
			public EmployeeInterviewSchedule toEntityModel() {
				return _nullEmployeeInterviewSchedule;
			}
		};
}