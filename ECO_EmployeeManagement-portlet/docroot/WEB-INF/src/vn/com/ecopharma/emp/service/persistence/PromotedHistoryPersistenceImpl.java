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

import vn.com.ecopharma.emp.NoSuchPromotedHistoryException;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.impl.PromotedHistoryImpl;
import vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the promoted history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see PromotedHistoryPersistence
 * @see PromotedHistoryUtil
 * @generated
 */
public class PromotedHistoryPersistenceImpl extends BasePersistenceImpl<PromotedHistory>
	implements PromotedHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PromotedHistoryUtil} to access the promoted history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PromotedHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPLOYEE = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmployee",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE =
		new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmployee",
			new String[] { Long.class.getName() },
			PromotedHistoryModelImpl.EMPLOYEEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPLOYEE = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmployee",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the promoted histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByEmployee(long employeeId)
		throws SystemException {
		return findByEmployee(employeeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the promoted histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @return the range of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByEmployee(long employeeId, int start,
		int end) throws SystemException {
		return findByEmployee(employeeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the promoted histories where employeeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param employeeId the employee ID
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByEmployee(long employeeId, int start,
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

		List<PromotedHistory> list = (List<PromotedHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PromotedHistory promotedHistory : list) {
				if ((employeeId != promotedHistory.getEmployeeId())) {
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

			query.append(_SQL_SELECT_PROMOTEDHISTORY_WHERE);

			query.append(_FINDER_COLUMN_EMPLOYEE_EMPLOYEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PromotedHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(employeeId);

				if (!pagination) {
					list = (List<PromotedHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PromotedHistory>(list);
				}
				else {
					list = (List<PromotedHistory>)QueryUtil.list(q,
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
	 * Returns the first promoted history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByEmployee_First(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByEmployee_First(employeeId,
				orderByComparator);

		if (promotedHistory != null) {
			return promotedHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPromotedHistoryException(msg.toString());
	}

	/**
	 * Returns the first promoted history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promoted history, or <code>null</code> if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByEmployee_First(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PromotedHistory> list = findByEmployee(employeeId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last promoted history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByEmployee_Last(long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByEmployee_Last(employeeId,
				orderByComparator);

		if (promotedHistory != null) {
			return promotedHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("employeeId=");
		msg.append(employeeId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPromotedHistoryException(msg.toString());
	}

	/**
	 * Returns the last promoted history in the ordered set where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promoted history, or <code>null</code> if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByEmployee_Last(long employeeId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmployee(employeeId);

		if (count == 0) {
			return null;
		}

		List<PromotedHistory> list = findByEmployee(employeeId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the promoted histories before and after the current promoted history in the ordered set where employeeId = &#63;.
	 *
	 * @param promotedHistoryId the primary key of the current promoted history
	 * @param employeeId the employee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory[] findByEmployee_PrevAndNext(
		long promotedHistoryId, long employeeId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = findByPrimaryKey(promotedHistoryId);

		Session session = null;

		try {
			session = openSession();

			PromotedHistory[] array = new PromotedHistoryImpl[3];

			array[0] = getByEmployee_PrevAndNext(session, promotedHistory,
					employeeId, orderByComparator, true);

			array[1] = promotedHistory;

			array[2] = getByEmployee_PrevAndNext(session, promotedHistory,
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

	protected PromotedHistory getByEmployee_PrevAndNext(Session session,
		PromotedHistory promotedHistory, long employeeId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROMOTEDHISTORY_WHERE);

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
			query.append(PromotedHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(employeeId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(promotedHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PromotedHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promoted histories where employeeId = &#63; from the database.
	 *
	 * @param employeeId the employee ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmployee(long employeeId) throws SystemException {
		for (PromotedHistory promotedHistory : findByEmployee(employeeId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(promotedHistory);
		}
	}

	/**
	 * Returns the number of promoted histories where employeeId = &#63;.
	 *
	 * @param employeeId the employee ID
	 * @return the number of matching promoted histories
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

			query.append(_SQL_COUNT_PROMOTEDHISTORY_WHERE);

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

	private static final String _FINDER_COLUMN_EMPLOYEE_EMPLOYEEID_2 = "promotedHistory.employeeId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_OLDTITLESID =
		new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByOldTitlesId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDTITLESID =
		new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOldTitlesId",
			new String[] { Long.class.getName() },
			PromotedHistoryModelImpl.OLDTITLESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_OLDTITLESID = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOldTitlesId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the promoted histories where oldTitlesId = &#63;.
	 *
	 * @param oldTitlesId the old titles ID
	 * @return the matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByOldTitlesId(long oldTitlesId)
		throws SystemException {
		return findByOldTitlesId(oldTitlesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the promoted histories where oldTitlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oldTitlesId the old titles ID
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @return the range of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByOldTitlesId(long oldTitlesId, int start,
		int end) throws SystemException {
		return findByOldTitlesId(oldTitlesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the promoted histories where oldTitlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param oldTitlesId the old titles ID
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByOldTitlesId(long oldTitlesId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDTITLESID;
			finderArgs = new Object[] { oldTitlesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_OLDTITLESID;
			finderArgs = new Object[] { oldTitlesId, start, end, orderByComparator };
		}

		List<PromotedHistory> list = (List<PromotedHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PromotedHistory promotedHistory : list) {
				if ((oldTitlesId != promotedHistory.getOldTitlesId())) {
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

			query.append(_SQL_SELECT_PROMOTEDHISTORY_WHERE);

			query.append(_FINDER_COLUMN_OLDTITLESID_OLDTITLESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PromotedHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(oldTitlesId);

				if (!pagination) {
					list = (List<PromotedHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PromotedHistory>(list);
				}
				else {
					list = (List<PromotedHistory>)QueryUtil.list(q,
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
	 * Returns the first promoted history in the ordered set where oldTitlesId = &#63;.
	 *
	 * @param oldTitlesId the old titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByOldTitlesId_First(long oldTitlesId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByOldTitlesId_First(oldTitlesId,
				orderByComparator);

		if (promotedHistory != null) {
			return promotedHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oldTitlesId=");
		msg.append(oldTitlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPromotedHistoryException(msg.toString());
	}

	/**
	 * Returns the first promoted history in the ordered set where oldTitlesId = &#63;.
	 *
	 * @param oldTitlesId the old titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promoted history, or <code>null</code> if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByOldTitlesId_First(long oldTitlesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PromotedHistory> list = findByOldTitlesId(oldTitlesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last promoted history in the ordered set where oldTitlesId = &#63;.
	 *
	 * @param oldTitlesId the old titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByOldTitlesId_Last(long oldTitlesId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByOldTitlesId_Last(oldTitlesId,
				orderByComparator);

		if (promotedHistory != null) {
			return promotedHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("oldTitlesId=");
		msg.append(oldTitlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPromotedHistoryException(msg.toString());
	}

	/**
	 * Returns the last promoted history in the ordered set where oldTitlesId = &#63;.
	 *
	 * @param oldTitlesId the old titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promoted history, or <code>null</code> if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByOldTitlesId_Last(long oldTitlesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByOldTitlesId(oldTitlesId);

		if (count == 0) {
			return null;
		}

		List<PromotedHistory> list = findByOldTitlesId(oldTitlesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the promoted histories before and after the current promoted history in the ordered set where oldTitlesId = &#63;.
	 *
	 * @param promotedHistoryId the primary key of the current promoted history
	 * @param oldTitlesId the old titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory[] findByOldTitlesId_PrevAndNext(
		long promotedHistoryId, long oldTitlesId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = findByPrimaryKey(promotedHistoryId);

		Session session = null;

		try {
			session = openSession();

			PromotedHistory[] array = new PromotedHistoryImpl[3];

			array[0] = getByOldTitlesId_PrevAndNext(session, promotedHistory,
					oldTitlesId, orderByComparator, true);

			array[1] = promotedHistory;

			array[2] = getByOldTitlesId_PrevAndNext(session, promotedHistory,
					oldTitlesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PromotedHistory getByOldTitlesId_PrevAndNext(Session session,
		PromotedHistory promotedHistory, long oldTitlesId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROMOTEDHISTORY_WHERE);

		query.append(_FINDER_COLUMN_OLDTITLESID_OLDTITLESID_2);

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
			query.append(PromotedHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(oldTitlesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(promotedHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PromotedHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promoted histories where oldTitlesId = &#63; from the database.
	 *
	 * @param oldTitlesId the old titles ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByOldTitlesId(long oldTitlesId) throws SystemException {
		for (PromotedHistory promotedHistory : findByOldTitlesId(oldTitlesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(promotedHistory);
		}
	}

	/**
	 * Returns the number of promoted histories where oldTitlesId = &#63;.
	 *
	 * @param oldTitlesId the old titles ID
	 * @return the number of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByOldTitlesId(long oldTitlesId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_OLDTITLESID;

		Object[] finderArgs = new Object[] { oldTitlesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROMOTEDHISTORY_WHERE);

			query.append(_FINDER_COLUMN_OLDTITLESID_OLDTITLESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(oldTitlesId);

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

	private static final String _FINDER_COLUMN_OLDTITLESID_OLDTITLESID_2 = "promotedHistory.oldTitlesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWTITLESID =
		new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByNewTitlesId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWTITLESID =
		new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED,
			PromotedHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNewTitlesId",
			new String[] { Long.class.getName() },
			PromotedHistoryModelImpl.NEWTITLESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NEWTITLESID = new FinderPath(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNewTitlesId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the promoted histories where newTitlesId = &#63;.
	 *
	 * @param newTitlesId the new titles ID
	 * @return the matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByNewTitlesId(long newTitlesId)
		throws SystemException {
		return findByNewTitlesId(newTitlesId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the promoted histories where newTitlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param newTitlesId the new titles ID
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @return the range of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByNewTitlesId(long newTitlesId, int start,
		int end) throws SystemException {
		return findByNewTitlesId(newTitlesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the promoted histories where newTitlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param newTitlesId the new titles ID
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findByNewTitlesId(long newTitlesId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWTITLESID;
			finderArgs = new Object[] { newTitlesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWTITLESID;
			finderArgs = new Object[] { newTitlesId, start, end, orderByComparator };
		}

		List<PromotedHistory> list = (List<PromotedHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (PromotedHistory promotedHistory : list) {
				if ((newTitlesId != promotedHistory.getNewTitlesId())) {
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

			query.append(_SQL_SELECT_PROMOTEDHISTORY_WHERE);

			query.append(_FINDER_COLUMN_NEWTITLESID_NEWTITLESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(PromotedHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(newTitlesId);

				if (!pagination) {
					list = (List<PromotedHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PromotedHistory>(list);
				}
				else {
					list = (List<PromotedHistory>)QueryUtil.list(q,
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
	 * Returns the first promoted history in the ordered set where newTitlesId = &#63;.
	 *
	 * @param newTitlesId the new titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByNewTitlesId_First(long newTitlesId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByNewTitlesId_First(newTitlesId,
				orderByComparator);

		if (promotedHistory != null) {
			return promotedHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("newTitlesId=");
		msg.append(newTitlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPromotedHistoryException(msg.toString());
	}

	/**
	 * Returns the first promoted history in the ordered set where newTitlesId = &#63;.
	 *
	 * @param newTitlesId the new titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching promoted history, or <code>null</code> if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByNewTitlesId_First(long newTitlesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<PromotedHistory> list = findByNewTitlesId(newTitlesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last promoted history in the ordered set where newTitlesId = &#63;.
	 *
	 * @param newTitlesId the new titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByNewTitlesId_Last(long newTitlesId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByNewTitlesId_Last(newTitlesId,
				orderByComparator);

		if (promotedHistory != null) {
			return promotedHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("newTitlesId=");
		msg.append(newTitlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchPromotedHistoryException(msg.toString());
	}

	/**
	 * Returns the last promoted history in the ordered set where newTitlesId = &#63;.
	 *
	 * @param newTitlesId the new titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching promoted history, or <code>null</code> if a matching promoted history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByNewTitlesId_Last(long newTitlesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNewTitlesId(newTitlesId);

		if (count == 0) {
			return null;
		}

		List<PromotedHistory> list = findByNewTitlesId(newTitlesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the promoted histories before and after the current promoted history in the ordered set where newTitlesId = &#63;.
	 *
	 * @param promotedHistoryId the primary key of the current promoted history
	 * @param newTitlesId the new titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory[] findByNewTitlesId_PrevAndNext(
		long promotedHistoryId, long newTitlesId,
		OrderByComparator orderByComparator)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = findByPrimaryKey(promotedHistoryId);

		Session session = null;

		try {
			session = openSession();

			PromotedHistory[] array = new PromotedHistoryImpl[3];

			array[0] = getByNewTitlesId_PrevAndNext(session, promotedHistory,
					newTitlesId, orderByComparator, true);

			array[1] = promotedHistory;

			array[2] = getByNewTitlesId_PrevAndNext(session, promotedHistory,
					newTitlesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PromotedHistory getByNewTitlesId_PrevAndNext(Session session,
		PromotedHistory promotedHistory, long newTitlesId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PROMOTEDHISTORY_WHERE);

		query.append(_FINDER_COLUMN_NEWTITLESID_NEWTITLESID_2);

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
			query.append(PromotedHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(newTitlesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(promotedHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<PromotedHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the promoted histories where newTitlesId = &#63; from the database.
	 *
	 * @param newTitlesId the new titles ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNewTitlesId(long newTitlesId) throws SystemException {
		for (PromotedHistory promotedHistory : findByNewTitlesId(newTitlesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(promotedHistory);
		}
	}

	/**
	 * Returns the number of promoted histories where newTitlesId = &#63;.
	 *
	 * @param newTitlesId the new titles ID
	 * @return the number of matching promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNewTitlesId(long newTitlesId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NEWTITLESID;

		Object[] finderArgs = new Object[] { newTitlesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PROMOTEDHISTORY_WHERE);

			query.append(_FINDER_COLUMN_NEWTITLESID_NEWTITLESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(newTitlesId);

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

	private static final String _FINDER_COLUMN_NEWTITLESID_NEWTITLESID_2 = "promotedHistory.newTitlesId = ?";

	public PromotedHistoryPersistenceImpl() {
		setModelClass(PromotedHistory.class);
	}

	/**
	 * Caches the promoted history in the entity cache if it is enabled.
	 *
	 * @param promotedHistory the promoted history
	 */
	@Override
	public void cacheResult(PromotedHistory promotedHistory) {
		EntityCacheUtil.putResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryImpl.class, promotedHistory.getPrimaryKey(),
			promotedHistory);

		promotedHistory.resetOriginalValues();
	}

	/**
	 * Caches the promoted histories in the entity cache if it is enabled.
	 *
	 * @param promotedHistories the promoted histories
	 */
	@Override
	public void cacheResult(List<PromotedHistory> promotedHistories) {
		for (PromotedHistory promotedHistory : promotedHistories) {
			if (EntityCacheUtil.getResult(
						PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
						PromotedHistoryImpl.class,
						promotedHistory.getPrimaryKey()) == null) {
				cacheResult(promotedHistory);
			}
			else {
				promotedHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all promoted histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PromotedHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PromotedHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the promoted history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PromotedHistory promotedHistory) {
		EntityCacheUtil.removeResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryImpl.class, promotedHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PromotedHistory> promotedHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PromotedHistory promotedHistory : promotedHistories) {
			EntityCacheUtil.removeResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
				PromotedHistoryImpl.class, promotedHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new promoted history with the primary key. Does not add the promoted history to the database.
	 *
	 * @param promotedHistoryId the primary key for the new promoted history
	 * @return the new promoted history
	 */
	@Override
	public PromotedHistory create(long promotedHistoryId) {
		PromotedHistory promotedHistory = new PromotedHistoryImpl();

		promotedHistory.setNew(true);
		promotedHistory.setPrimaryKey(promotedHistoryId);

		return promotedHistory;
	}

	/**
	 * Removes the promoted history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param promotedHistoryId the primary key of the promoted history
	 * @return the promoted history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory remove(long promotedHistoryId)
		throws NoSuchPromotedHistoryException, SystemException {
		return remove((Serializable)promotedHistoryId);
	}

	/**
	 * Removes the promoted history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the promoted history
	 * @return the promoted history that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory remove(Serializable primaryKey)
		throws NoSuchPromotedHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			PromotedHistory promotedHistory = (PromotedHistory)session.get(PromotedHistoryImpl.class,
					primaryKey);

			if (promotedHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPromotedHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(promotedHistory);
		}
		catch (NoSuchPromotedHistoryException nsee) {
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
	protected PromotedHistory removeImpl(PromotedHistory promotedHistory)
		throws SystemException {
		promotedHistory = toUnwrappedModel(promotedHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(promotedHistory)) {
				promotedHistory = (PromotedHistory)session.get(PromotedHistoryImpl.class,
						promotedHistory.getPrimaryKeyObj());
			}

			if (promotedHistory != null) {
				session.delete(promotedHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (promotedHistory != null) {
			clearCache(promotedHistory);
		}

		return promotedHistory;
	}

	@Override
	public PromotedHistory updateImpl(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory)
		throws SystemException {
		promotedHistory = toUnwrappedModel(promotedHistory);

		boolean isNew = promotedHistory.isNew();

		PromotedHistoryModelImpl promotedHistoryModelImpl = (PromotedHistoryModelImpl)promotedHistory;

		Session session = null;

		try {
			session = openSession();

			if (promotedHistory.isNew()) {
				session.save(promotedHistory);

				promotedHistory.setNew(false);
			}
			else {
				session.merge(promotedHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !PromotedHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((promotedHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						promotedHistoryModelImpl.getOriginalEmployeeId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE,
					args);

				args = new Object[] { promotedHistoryModelImpl.getEmployeeId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPLOYEE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPLOYEE,
					args);
			}

			if ((promotedHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDTITLESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						promotedHistoryModelImpl.getOriginalOldTitlesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OLDTITLESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDTITLESID,
					args);

				args = new Object[] { promotedHistoryModelImpl.getOldTitlesId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_OLDTITLESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_OLDTITLESID,
					args);
			}

			if ((promotedHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWTITLESID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						promotedHistoryModelImpl.getOriginalNewTitlesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEWTITLESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWTITLESID,
					args);

				args = new Object[] { promotedHistoryModelImpl.getNewTitlesId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEWTITLESID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWTITLESID,
					args);
			}
		}

		EntityCacheUtil.putResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
			PromotedHistoryImpl.class, promotedHistory.getPrimaryKey(),
			promotedHistory);

		return promotedHistory;
	}

	protected PromotedHistory toUnwrappedModel(PromotedHistory promotedHistory) {
		if (promotedHistory instanceof PromotedHistoryImpl) {
			return promotedHistory;
		}

		PromotedHistoryImpl promotedHistoryImpl = new PromotedHistoryImpl();

		promotedHistoryImpl.setNew(promotedHistory.isNew());
		promotedHistoryImpl.setPrimaryKey(promotedHistory.getPrimaryKey());

		promotedHistoryImpl.setPromotedHistoryId(promotedHistory.getPromotedHistoryId());
		promotedHistoryImpl.setEmployeeId(promotedHistory.getEmployeeId());
		promotedHistoryImpl.setOldTitlesId(promotedHistory.getOldTitlesId());
		promotedHistoryImpl.setNewTitlesId(promotedHistory.getNewTitlesId());
		promotedHistoryImpl.setPromotedDate(promotedHistory.getPromotedDate());
		promotedHistoryImpl.setComment(promotedHistory.getComment());
		promotedHistoryImpl.setGroupId(promotedHistory.getGroupId());
		promotedHistoryImpl.setCompanyId(promotedHistory.getCompanyId());
		promotedHistoryImpl.setUserId(promotedHistory.getUserId());
		promotedHistoryImpl.setUserName(promotedHistory.getUserName());
		promotedHistoryImpl.setCreateDate(promotedHistory.getCreateDate());
		promotedHistoryImpl.setModifiedDate(promotedHistory.getModifiedDate());
		promotedHistoryImpl.setDeleted(promotedHistory.isDeleted());

		return promotedHistoryImpl;
	}

	/**
	 * Returns the promoted history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the promoted history
	 * @return the promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPromotedHistoryException, SystemException {
		PromotedHistory promotedHistory = fetchByPrimaryKey(primaryKey);

		if (promotedHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPromotedHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return promotedHistory;
	}

	/**
	 * Returns the promoted history with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchPromotedHistoryException} if it could not be found.
	 *
	 * @param promotedHistoryId the primary key of the promoted history
	 * @return the promoted history
	 * @throws vn.com.ecopharma.emp.NoSuchPromotedHistoryException if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory findByPrimaryKey(long promotedHistoryId)
		throws NoSuchPromotedHistoryException, SystemException {
		return findByPrimaryKey((Serializable)promotedHistoryId);
	}

	/**
	 * Returns the promoted history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the promoted history
	 * @return the promoted history, or <code>null</code> if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		PromotedHistory promotedHistory = (PromotedHistory)EntityCacheUtil.getResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
				PromotedHistoryImpl.class, primaryKey);

		if (promotedHistory == _nullPromotedHistory) {
			return null;
		}

		if (promotedHistory == null) {
			Session session = null;

			try {
				session = openSession();

				promotedHistory = (PromotedHistory)session.get(PromotedHistoryImpl.class,
						primaryKey);

				if (promotedHistory != null) {
					cacheResult(promotedHistory);
				}
				else {
					EntityCacheUtil.putResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
						PromotedHistoryImpl.class, primaryKey,
						_nullPromotedHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PromotedHistoryModelImpl.ENTITY_CACHE_ENABLED,
					PromotedHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return promotedHistory;
	}

	/**
	 * Returns the promoted history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param promotedHistoryId the primary key of the promoted history
	 * @return the promoted history, or <code>null</code> if a promoted history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public PromotedHistory fetchByPrimaryKey(long promotedHistoryId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)promotedHistoryId);
	}

	/**
	 * Returns all the promoted histories.
	 *
	 * @return the promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the promoted histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @return the range of promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the promoted histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.PromotedHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of promoted histories
	 * @param end the upper bound of the range of promoted histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of promoted histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<PromotedHistory> findAll(int start, int end,
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

		List<PromotedHistory> list = (List<PromotedHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PROMOTEDHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PROMOTEDHISTORY;

				if (pagination) {
					sql = sql.concat(PromotedHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PromotedHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<PromotedHistory>(list);
				}
				else {
					list = (List<PromotedHistory>)QueryUtil.list(q,
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
	 * Removes all the promoted histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (PromotedHistory promotedHistory : findAll()) {
			remove(promotedHistory);
		}
	}

	/**
	 * Returns the number of promoted histories.
	 *
	 * @return the number of promoted histories
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

				Query q = session.createQuery(_SQL_COUNT_PROMOTEDHISTORY);

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
	 * Initializes the promoted history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.PromotedHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<PromotedHistory>> listenersList = new ArrayList<ModelListener<PromotedHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<PromotedHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PromotedHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PROMOTEDHISTORY = "SELECT promotedHistory FROM PromotedHistory promotedHistory";
	private static final String _SQL_SELECT_PROMOTEDHISTORY_WHERE = "SELECT promotedHistory FROM PromotedHistory promotedHistory WHERE ";
	private static final String _SQL_COUNT_PROMOTEDHISTORY = "SELECT COUNT(promotedHistory) FROM PromotedHistory promotedHistory";
	private static final String _SQL_COUNT_PROMOTEDHISTORY_WHERE = "SELECT COUNT(promotedHistory) FROM PromotedHistory promotedHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "promotedHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No PromotedHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No PromotedHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PromotedHistoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"comment"
			});
	private static PromotedHistory _nullPromotedHistory = new PromotedHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<PromotedHistory> toCacheModel() {
				return _nullPromotedHistoryCacheModel;
			}
		};

	private static CacheModel<PromotedHistory> _nullPromotedHistoryCacheModel = new CacheModel<PromotedHistory>() {
			@Override
			public PromotedHistory toEntityModel() {
				return _nullPromotedHistory;
			}
		};
}