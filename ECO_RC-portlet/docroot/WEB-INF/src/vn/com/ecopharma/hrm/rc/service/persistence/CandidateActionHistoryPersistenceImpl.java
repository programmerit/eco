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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException;
import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;
import vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryImpl;
import vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the candidate action history service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidateActionHistoryPersistence
 * @see CandidateActionHistoryUtil
 * @generated
 */
public class CandidateActionHistoryPersistenceImpl extends BasePersistenceImpl<CandidateActionHistory>
	implements CandidateActionHistoryPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateActionHistoryUtil} to access the candidate action history persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateActionHistoryImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATE =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCandidate",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCandidate",
			new String[] { Long.class.getName() },
			CandidateActionHistoryModelImpl.CANDIDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATE = new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidate",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the candidate action histories where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidate(long candidateId)
		throws SystemException {
		return findByCandidate(candidateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate action histories where candidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @return the range of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidate(long candidateId,
		int start, int end) throws SystemException {
		return findByCandidate(candidateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate action histories where candidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidate(long candidateId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE;
			finderArgs = new Object[] { candidateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATE;
			finderArgs = new Object[] { candidateId, start, end, orderByComparator };
		}

		List<CandidateActionHistory> list = (List<CandidateActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CandidateActionHistory candidateActionHistory : list) {
				if ((candidateId != candidateActionHistory.getCandidateId())) {
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

			query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATE_CANDIDATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (!pagination) {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CandidateActionHistory>(list);
				}
				else {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
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
	 * Returns the first candidate action history in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByCandidate_First(long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByCandidate_First(candidateId,
				orderByComparator);

		if (candidateActionHistory != null) {
			return candidateActionHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateActionHistoryException(msg.toString());
	}

	/**
	 * Returns the first candidate action history in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByCandidate_First(long candidateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CandidateActionHistory> list = findByCandidate(candidateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate action history in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByCandidate_Last(long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByCandidate_Last(candidateId,
				orderByComparator);

		if (candidateActionHistory != null) {
			return candidateActionHistory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateActionHistoryException(msg.toString());
	}

	/**
	 * Returns the last candidate action history in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByCandidate_Last(long candidateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCandidate(candidateId);

		if (count == 0) {
			return null;
		}

		List<CandidateActionHistory> list = findByCandidate(candidateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate action histories before and after the current candidate action history in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateActionHistoryId the primary key of the current candidate action history
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory[] findByCandidate_PrevAndNext(
		long candidateActionHistoryId, long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = findByPrimaryKey(candidateActionHistoryId);

		Session session = null;

		try {
			session = openSession();

			CandidateActionHistory[] array = new CandidateActionHistoryImpl[3];

			array[0] = getByCandidate_PrevAndNext(session,
					candidateActionHistory, candidateId, orderByComparator, true);

			array[1] = candidateActionHistory;

			array[2] = getByCandidate_PrevAndNext(session,
					candidateActionHistory, candidateId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateActionHistory getByCandidate_PrevAndNext(
		Session session, CandidateActionHistory candidateActionHistory,
		long candidateId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE);

		query.append(_FINDER_COLUMN_CANDIDATE_CANDIDATEID_2);

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
			query.append(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(candidateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateActionHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateActionHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate action histories where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCandidate(long candidateId) throws SystemException {
		for (CandidateActionHistory candidateActionHistory : findByCandidate(
				candidateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateActionHistory);
		}
	}

	/**
	 * Returns the number of candidate action histories where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCandidate(long candidateId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATE;

		Object[] finderArgs = new Object[] { candidateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATEACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATE_CANDIDATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

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

	private static final String _FINDER_COLUMN_CANDIDATE_CANDIDATEID_2 = "candidateActionHistory.candidateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCandidateAndActionType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCandidateAndActionType",
			new String[] { Long.class.getName(), String.class.getName() },
			CandidateActionHistoryModelImpl.CANDIDATEID_COLUMN_BITMASK |
			CandidateActionHistoryModelImpl.ACTIONTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPE = new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCandidateAndActionType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @return the matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, String actionType) throws SystemException {
		return findByCandidateAndActionType(candidateId, actionType,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @return the range of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, String actionType, int start, int end)
		throws SystemException {
		return findByCandidateAndActionType(candidateId, actionType, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the candidate action histories where candidateId = &#63; and actionType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidateAndActionType(
		long candidateId, String actionType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE;
			finderArgs = new Object[] { candidateId, actionType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE;
			finderArgs = new Object[] {
					candidateId, actionType,
					
					start, end, orderByComparator
				};
		}

		List<CandidateActionHistory> list = (List<CandidateActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CandidateActionHistory candidateActionHistory : list) {
				if ((candidateId != candidateActionHistory.getCandidateId()) ||
						!Validator.equals(actionType,
							candidateActionHistory.getActionType())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_CANDIDATEID_2);

			boolean bindActionType = false;

			if (actionType == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_1);
			}
			else if (actionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_3);
			}
			else {
				bindActionType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindActionType) {
					qPos.add(actionType);
				}

				if (!pagination) {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CandidateActionHistory>(list);
				}
				else {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
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
	 * Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByCandidateAndActionType_First(
		long candidateId, String actionType, OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByCandidateAndActionType_First(candidateId,
				actionType, orderByComparator);

		if (candidateActionHistory != null) {
			return candidateActionHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(", actionType=");
		msg.append(actionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateActionHistoryException(msg.toString());
	}

	/**
	 * Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByCandidateAndActionType_First(
		long candidateId, String actionType, OrderByComparator orderByComparator)
		throws SystemException {
		List<CandidateActionHistory> list = findByCandidateAndActionType(candidateId,
				actionType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByCandidateAndActionType_Last(
		long candidateId, String actionType, OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByCandidateAndActionType_Last(candidateId,
				actionType, orderByComparator);

		if (candidateActionHistory != null) {
			return candidateActionHistory;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(", actionType=");
		msg.append(actionType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateActionHistoryException(msg.toString());
	}

	/**
	 * Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByCandidateAndActionType_Last(
		long candidateId, String actionType, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCandidateAndActionType(candidateId, actionType);

		if (count == 0) {
			return null;
		}

		List<CandidateActionHistory> list = findByCandidateAndActionType(candidateId,
				actionType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate action histories before and after the current candidate action history in the ordered set where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateActionHistoryId the primary key of the current candidate action history
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory[] findByCandidateAndActionType_PrevAndNext(
		long candidateActionHistoryId, long candidateId, String actionType,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = findByPrimaryKey(candidateActionHistoryId);

		Session session = null;

		try {
			session = openSession();

			CandidateActionHistory[] array = new CandidateActionHistoryImpl[3];

			array[0] = getByCandidateAndActionType_PrevAndNext(session,
					candidateActionHistory, candidateId, actionType,
					orderByComparator, true);

			array[1] = candidateActionHistory;

			array[2] = getByCandidateAndActionType_PrevAndNext(session,
					candidateActionHistory, candidateId, actionType,
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

	protected CandidateActionHistory getByCandidateAndActionType_PrevAndNext(
		Session session, CandidateActionHistory candidateActionHistory,
		long candidateId, String actionType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE);

		query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_CANDIDATEID_2);

		boolean bindActionType = false;

		if (actionType == null) {
			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_1);
		}
		else if (actionType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_3);
		}
		else {
			bindActionType = true;

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_2);
		}

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
			query.append(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(candidateId);

		if (bindActionType) {
			qPos.add(actionType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateActionHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateActionHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate action histories where candidateId = &#63; and actionType = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCandidateAndActionType(long candidateId,
		String actionType) throws SystemException {
		for (CandidateActionHistory candidateActionHistory : findByCandidateAndActionType(
				candidateId, actionType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(candidateActionHistory);
		}
	}

	/**
	 * Returns the number of candidate action histories where candidateId = &#63; and actionType = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @return the number of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCandidateAndActionType(long candidateId, String actionType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPE;

		Object[] finderArgs = new Object[] { candidateId, actionType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CANDIDATEACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_CANDIDATEID_2);

			boolean bindActionType = false;

			if (actionType == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_1);
			}
			else if (actionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_3);
			}
			else {
				bindActionType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindActionType) {
					qPos.add(actionType);
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

	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPE_CANDIDATEID_2 =
		"candidateActionHistory.candidateId = ? AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_1 =
		"candidateActionHistory.actionType IS NULL";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_2 =
		"candidateActionHistory.actionType = ?";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPE_ACTIONTYPE_3 =
		"(candidateActionHistory.actionType IS NULL OR candidateActionHistory.actionType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCandidateAndActionTypeAndAction",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCandidateAndActionTypeAndAction",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			CandidateActionHistoryModelImpl.CANDIDATEID_COLUMN_BITMASK |
			CandidateActionHistoryModelImpl.ACTIONTYPE_COLUMN_BITMASK |
			CandidateActionHistoryModelImpl.ACTION_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPEANDACTION =
		new FinderPath(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCandidateAndActionTypeAndAction",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @return the matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, String actionType, String action)
		throws SystemException {
		return findByCandidateAndActionTypeAndAction(candidateId, actionType,
			action, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @return the range of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, String actionType, String action, int start, int end)
		throws SystemException {
		return findByCandidateAndActionTypeAndAction(candidateId, actionType,
			action, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findByCandidateAndActionTypeAndAction(
		long candidateId, String actionType, String action, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION;
			finderArgs = new Object[] { candidateId, actionType, action };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION;
			finderArgs = new Object[] {
					candidateId, actionType, action,
					
					start, end, orderByComparator
				};
		}

		List<CandidateActionHistory> list = (List<CandidateActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CandidateActionHistory candidateActionHistory : list) {
				if ((candidateId != candidateActionHistory.getCandidateId()) ||
						!Validator.equals(actionType,
							candidateActionHistory.getActionType()) ||
						!Validator.equals(action,
							candidateActionHistory.getAction())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_CANDIDATEID_2);

			boolean bindActionType = false;

			if (actionType == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_1);
			}
			else if (actionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_3);
			}
			else {
				bindActionType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_2);
			}

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindActionType) {
					qPos.add(actionType);
				}

				if (bindAction) {
					qPos.add(action);
				}

				if (!pagination) {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CandidateActionHistory>(list);
				}
				else {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
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
	 * Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByCandidateAndActionTypeAndAction_First(
		long candidateId, String actionType, String action,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByCandidateAndActionTypeAndAction_First(candidateId,
				actionType, action, orderByComparator);

		if (candidateActionHistory != null) {
			return candidateActionHistory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(", actionType=");
		msg.append(actionType);

		msg.append(", action=");
		msg.append(action);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateActionHistoryException(msg.toString());
	}

	/**
	 * Returns the first candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByCandidateAndActionTypeAndAction_First(
		long candidateId, String actionType, String action,
		OrderByComparator orderByComparator) throws SystemException {
		List<CandidateActionHistory> list = findByCandidateAndActionTypeAndAction(candidateId,
				actionType, action, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByCandidateAndActionTypeAndAction_Last(
		long candidateId, String actionType, String action,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByCandidateAndActionTypeAndAction_Last(candidateId,
				actionType, action, orderByComparator);

		if (candidateActionHistory != null) {
			return candidateActionHistory;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(", actionType=");
		msg.append(actionType);

		msg.append(", action=");
		msg.append(action);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateActionHistoryException(msg.toString());
	}

	/**
	 * Returns the last candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate action history, or <code>null</code> if a matching candidate action history could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByCandidateAndActionTypeAndAction_Last(
		long candidateId, String actionType, String action,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCandidateAndActionTypeAndAction(candidateId,
				actionType, action);

		if (count == 0) {
			return null;
		}

		List<CandidateActionHistory> list = findByCandidateAndActionTypeAndAction(candidateId,
				actionType, action, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate action histories before and after the current candidate action history in the ordered set where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateActionHistoryId the primary key of the current candidate action history
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory[] findByCandidateAndActionTypeAndAction_PrevAndNext(
		long candidateActionHistoryId, long candidateId, String actionType,
		String action, OrderByComparator orderByComparator)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = findByPrimaryKey(candidateActionHistoryId);

		Session session = null;

		try {
			session = openSession();

			CandidateActionHistory[] array = new CandidateActionHistoryImpl[3];

			array[0] = getByCandidateAndActionTypeAndAction_PrevAndNext(session,
					candidateActionHistory, candidateId, actionType, action,
					orderByComparator, true);

			array[1] = candidateActionHistory;

			array[2] = getByCandidateAndActionTypeAndAction_PrevAndNext(session,
					candidateActionHistory, candidateId, actionType, action,
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

	protected CandidateActionHistory getByCandidateAndActionTypeAndAction_PrevAndNext(
		Session session, CandidateActionHistory candidateActionHistory,
		long candidateId, String actionType, String action,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE);

		query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_CANDIDATEID_2);

		boolean bindActionType = false;

		if (actionType == null) {
			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_1);
		}
		else if (actionType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_3);
		}
		else {
			bindActionType = true;

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_2);
		}

		boolean bindAction = false;

		if (action == null) {
			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_1);
		}
		else if (action.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_3);
		}
		else {
			bindAction = true;

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_2);
		}

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
			query.append(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(candidateId);

		if (bindActionType) {
			qPos.add(actionType);
		}

		if (bindAction) {
			qPos.add(action);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateActionHistory);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateActionHistory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCandidateAndActionTypeAndAction(long candidateId,
		String actionType, String action) throws SystemException {
		for (CandidateActionHistory candidateActionHistory : findByCandidateAndActionTypeAndAction(
				candidateId, actionType, action, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(candidateActionHistory);
		}
	}

	/**
	 * Returns the number of candidate action histories where candidateId = &#63; and actionType = &#63; and action = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param actionType the action type
	 * @param action the action
	 * @return the number of matching candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCandidateAndActionTypeAndAction(long candidateId,
		String actionType, String action) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPEANDACTION;

		Object[] finderArgs = new Object[] { candidateId, actionType, action };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CANDIDATEACTIONHISTORY_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_CANDIDATEID_2);

			boolean bindActionType = false;

			if (actionType == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_1);
			}
			else if (actionType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_3);
			}
			else {
				bindActionType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_2);
			}

			boolean bindAction = false;

			if (action == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_1);
			}
			else if (action.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_3);
			}
			else {
				bindAction = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindActionType) {
					qPos.add(actionType);
				}

				if (bindAction) {
					qPos.add(action);
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

	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_CANDIDATEID_2 =
		"candidateActionHistory.candidateId = ? AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_1 =
		"candidateActionHistory.actionType IS NULL AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_2 =
		"candidateActionHistory.actionType = ? AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTIONTYPE_3 =
		"(candidateActionHistory.actionType IS NULL OR candidateActionHistory.actionType = '') AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_1 =
		"candidateActionHistory.action IS NULL";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_2 =
		"candidateActionHistory.action = ?";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIONTYPEANDACTION_ACTION_3 =
		"(candidateActionHistory.action IS NULL OR candidateActionHistory.action = '')";

	public CandidateActionHistoryPersistenceImpl() {
		setModelClass(CandidateActionHistory.class);
	}

	/**
	 * Caches the candidate action history in the entity cache if it is enabled.
	 *
	 * @param candidateActionHistory the candidate action history
	 */
	@Override
	public void cacheResult(CandidateActionHistory candidateActionHistory) {
		EntityCacheUtil.putResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			candidateActionHistory.getPrimaryKey(), candidateActionHistory);

		candidateActionHistory.resetOriginalValues();
	}

	/**
	 * Caches the candidate action histories in the entity cache if it is enabled.
	 *
	 * @param candidateActionHistories the candidate action histories
	 */
	@Override
	public void cacheResult(
		List<CandidateActionHistory> candidateActionHistories) {
		for (CandidateActionHistory candidateActionHistory : candidateActionHistories) {
			if (EntityCacheUtil.getResult(
						CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
						CandidateActionHistoryImpl.class,
						candidateActionHistory.getPrimaryKey()) == null) {
				cacheResult(candidateActionHistory);
			}
			else {
				candidateActionHistory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate action histories.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CandidateActionHistoryImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CandidateActionHistoryImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate action history.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateActionHistory candidateActionHistory) {
		EntityCacheUtil.removeResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			candidateActionHistory.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(
		List<CandidateActionHistory> candidateActionHistories) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateActionHistory candidateActionHistory : candidateActionHistories) {
			EntityCacheUtil.removeResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
				CandidateActionHistoryImpl.class,
				candidateActionHistory.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate action history with the primary key. Does not add the candidate action history to the database.
	 *
	 * @param candidateActionHistoryId the primary key for the new candidate action history
	 * @return the new candidate action history
	 */
	@Override
	public CandidateActionHistory create(long candidateActionHistoryId) {
		CandidateActionHistory candidateActionHistory = new CandidateActionHistoryImpl();

		candidateActionHistory.setNew(true);
		candidateActionHistory.setPrimaryKey(candidateActionHistoryId);

		return candidateActionHistory;
	}

	/**
	 * Removes the candidate action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateActionHistoryId the primary key of the candidate action history
	 * @return the candidate action history that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory remove(long candidateActionHistoryId)
		throws NoSuchCandidateActionHistoryException, SystemException {
		return remove((Serializable)candidateActionHistoryId);
	}

	/**
	 * Removes the candidate action history with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate action history
	 * @return the candidate action history that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory remove(Serializable primaryKey)
		throws NoSuchCandidateActionHistoryException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CandidateActionHistory candidateActionHistory = (CandidateActionHistory)session.get(CandidateActionHistoryImpl.class,
					primaryKey);

			if (candidateActionHistory == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateActionHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateActionHistory);
		}
		catch (NoSuchCandidateActionHistoryException nsee) {
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
	protected CandidateActionHistory removeImpl(
		CandidateActionHistory candidateActionHistory)
		throws SystemException {
		candidateActionHistory = toUnwrappedModel(candidateActionHistory);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateActionHistory)) {
				candidateActionHistory = (CandidateActionHistory)session.get(CandidateActionHistoryImpl.class,
						candidateActionHistory.getPrimaryKeyObj());
			}

			if (candidateActionHistory != null) {
				session.delete(candidateActionHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateActionHistory != null) {
			clearCache(candidateActionHistory);
		}

		return candidateActionHistory;
	}

	@Override
	public CandidateActionHistory updateImpl(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory)
		throws SystemException {
		candidateActionHistory = toUnwrappedModel(candidateActionHistory);

		boolean isNew = candidateActionHistory.isNew();

		CandidateActionHistoryModelImpl candidateActionHistoryModelImpl = (CandidateActionHistoryModelImpl)candidateActionHistory;

		Session session = null;

		try {
			session = openSession();

			if (candidateActionHistory.isNew()) {
				session.save(candidateActionHistory);

				candidateActionHistory.setNew(false);
			}
			else {
				session.merge(candidateActionHistory);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CandidateActionHistoryModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((candidateActionHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateActionHistoryModelImpl.getOriginalCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE,
					args);

				args = new Object[] {
						candidateActionHistoryModelImpl.getCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE,
					args);
			}

			if ((candidateActionHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateActionHistoryModelImpl.getOriginalCandidateId(),
						candidateActionHistoryModelImpl.getOriginalActionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE,
					args);

				args = new Object[] {
						candidateActionHistoryModelImpl.getCandidateId(),
						candidateActionHistoryModelImpl.getActionType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPE,
					args);
			}

			if ((candidateActionHistoryModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateActionHistoryModelImpl.getOriginalCandidateId(),
						candidateActionHistoryModelImpl.getOriginalActionType(),
						candidateActionHistoryModelImpl.getOriginalAction()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPEANDACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION,
					args);

				args = new Object[] {
						candidateActionHistoryModelImpl.getCandidateId(),
						candidateActionHistoryModelImpl.getActionType(),
						candidateActionHistoryModelImpl.getAction()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIONTYPEANDACTION,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDACTIONTYPEANDACTION,
					args);
			}
		}

		EntityCacheUtil.putResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
			CandidateActionHistoryImpl.class,
			candidateActionHistory.getPrimaryKey(), candidateActionHistory);

		return candidateActionHistory;
	}

	protected CandidateActionHistory toUnwrappedModel(
		CandidateActionHistory candidateActionHistory) {
		if (candidateActionHistory instanceof CandidateActionHistoryImpl) {
			return candidateActionHistory;
		}

		CandidateActionHistoryImpl candidateActionHistoryImpl = new CandidateActionHistoryImpl();

		candidateActionHistoryImpl.setNew(candidateActionHistory.isNew());
		candidateActionHistoryImpl.setPrimaryKey(candidateActionHistory.getPrimaryKey());

		candidateActionHistoryImpl.setCandidateActionHistoryId(candidateActionHistory.getCandidateActionHistoryId());
		candidateActionHistoryImpl.setCandidateId(candidateActionHistory.getCandidateId());
		candidateActionHistoryImpl.setAction(candidateActionHistory.getAction());
		candidateActionHistoryImpl.setActionType(candidateActionHistory.getActionType());
		candidateActionHistoryImpl.setExecutedBy(candidateActionHistory.getExecutedBy());
		candidateActionHistoryImpl.setDate(candidateActionHistory.getDate());
		candidateActionHistoryImpl.setDescription(candidateActionHistory.getDescription());
		candidateActionHistoryImpl.setGroupId(candidateActionHistory.getGroupId());
		candidateActionHistoryImpl.setCompanyId(candidateActionHistory.getCompanyId());
		candidateActionHistoryImpl.setUserId(candidateActionHistory.getUserId());
		candidateActionHistoryImpl.setUserName(candidateActionHistory.getUserName());
		candidateActionHistoryImpl.setCreateDate(candidateActionHistory.getCreateDate());
		candidateActionHistoryImpl.setModifiedDate(candidateActionHistory.getModifiedDate());

		return candidateActionHistoryImpl;
	}

	/**
	 * Returns the candidate action history with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate action history
	 * @return the candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateActionHistoryException, SystemException {
		CandidateActionHistory candidateActionHistory = fetchByPrimaryKey(primaryKey);

		if (candidateActionHistory == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateActionHistoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateActionHistory;
	}

	/**
	 * Returns the candidate action history with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException} if it could not be found.
	 *
	 * @param candidateActionHistoryId the primary key of the candidate action history
	 * @return the candidate action history
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory findByPrimaryKey(
		long candidateActionHistoryId)
		throws NoSuchCandidateActionHistoryException, SystemException {
		return findByPrimaryKey((Serializable)candidateActionHistoryId);
	}

	/**
	 * Returns the candidate action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate action history
	 * @return the candidate action history, or <code>null</code> if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CandidateActionHistory candidateActionHistory = (CandidateActionHistory)EntityCacheUtil.getResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
				CandidateActionHistoryImpl.class, primaryKey);

		if (candidateActionHistory == _nullCandidateActionHistory) {
			return null;
		}

		if (candidateActionHistory == null) {
			Session session = null;

			try {
				session = openSession();

				candidateActionHistory = (CandidateActionHistory)session.get(CandidateActionHistoryImpl.class,
						primaryKey);

				if (candidateActionHistory != null) {
					cacheResult(candidateActionHistory);
				}
				else {
					EntityCacheUtil.putResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
						CandidateActionHistoryImpl.class, primaryKey,
						_nullCandidateActionHistory);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CandidateActionHistoryModelImpl.ENTITY_CACHE_ENABLED,
					CandidateActionHistoryImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateActionHistory;
	}

	/**
	 * Returns the candidate action history with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateActionHistoryId the primary key of the candidate action history
	 * @return the candidate action history, or <code>null</code> if a candidate action history with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateActionHistory fetchByPrimaryKey(
		long candidateActionHistoryId) throws SystemException {
		return fetchByPrimaryKey((Serializable)candidateActionHistoryId);
	}

	/**
	 * Returns all the candidate action histories.
	 *
	 * @return the candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @return the range of candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate action histories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate action histories
	 * @param end the upper bound of the range of candidate action histories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate action histories
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateActionHistory> findAll(int start, int end,
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

		List<CandidateActionHistory> list = (List<CandidateActionHistory>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CANDIDATEACTIONHISTORY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEACTIONHISTORY;

				if (pagination) {
					sql = sql.concat(CandidateActionHistoryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CandidateActionHistory>(list);
				}
				else {
					list = (List<CandidateActionHistory>)QueryUtil.list(q,
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
	 * Removes all the candidate action histories from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CandidateActionHistory candidateActionHistory : findAll()) {
			remove(candidateActionHistory);
		}
	}

	/**
	 * Returns the number of candidate action histories.
	 *
	 * @return the number of candidate action histories
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

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEACTIONHISTORY);

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
	 * Initializes the candidate action history persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.CandidateActionHistory")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CandidateActionHistory>> listenersList = new ArrayList<ModelListener<CandidateActionHistory>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CandidateActionHistory>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CandidateActionHistoryImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CANDIDATEACTIONHISTORY = "SELECT candidateActionHistory FROM CandidateActionHistory candidateActionHistory";
	private static final String _SQL_SELECT_CANDIDATEACTIONHISTORY_WHERE = "SELECT candidateActionHistory FROM CandidateActionHistory candidateActionHistory WHERE ";
	private static final String _SQL_COUNT_CANDIDATEACTIONHISTORY = "SELECT COUNT(candidateActionHistory) FROM CandidateActionHistory candidateActionHistory";
	private static final String _SQL_COUNT_CANDIDATEACTIONHISTORY_WHERE = "SELECT COUNT(candidateActionHistory) FROM CandidateActionHistory candidateActionHistory WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateActionHistory.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateActionHistory exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CandidateActionHistory exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CandidateActionHistoryPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static CandidateActionHistory _nullCandidateActionHistory = new CandidateActionHistoryImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CandidateActionHistory> toCacheModel() {
				return _nullCandidateActionHistoryCacheModel;
			}
		};

	private static CacheModel<CandidateActionHistory> _nullCandidateActionHistoryCacheModel =
		new CacheModel<CandidateActionHistory>() {
			@Override
			public CandidateActionHistory toEntityModel() {
				return _nullCandidateActionHistory;
			}
		};
}