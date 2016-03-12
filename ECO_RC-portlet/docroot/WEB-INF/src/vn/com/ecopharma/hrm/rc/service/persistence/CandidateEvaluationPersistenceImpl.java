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

import vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException;
import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;
import vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationImpl;
import vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the candidate evaluation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidateEvaluationPersistence
 * @see CandidateEvaluationUtil
 * @generated
 */
public class CandidateEvaluationPersistenceImpl extends BasePersistenceImpl<CandidateEvaluation>
	implements CandidateEvaluationPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateEvaluationUtil} to access the candidate evaluation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateEvaluationImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED,
			CandidateEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED,
			CandidateEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATE =
		new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED,
			CandidateEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCandidate",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE =
		new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED,
			CandidateEvaluationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCandidate",
			new String[] { Long.class.getName() },
			CandidateEvaluationModelImpl.CANDIDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATE = new FinderPath(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidate",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the candidate evaluations where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching candidate evaluations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateEvaluation> findByCandidate(long candidateId)
		throws SystemException {
		return findByCandidate(candidateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate evaluations where candidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @return the range of matching candidate evaluations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateEvaluation> findByCandidate(long candidateId,
		int start, int end) throws SystemException {
		return findByCandidate(candidateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate evaluations where candidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidate evaluations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateEvaluation> findByCandidate(long candidateId,
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

		List<CandidateEvaluation> list = (List<CandidateEvaluation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CandidateEvaluation candidateEvaluation : list) {
				if ((candidateId != candidateEvaluation.getCandidateId())) {
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

			query.append(_SQL_SELECT_CANDIDATEEVALUATION_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATE_CANDIDATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateEvaluationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (!pagination) {
					list = (List<CandidateEvaluation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CandidateEvaluation>(list);
				}
				else {
					list = (List<CandidateEvaluation>)QueryUtil.list(q,
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
	 * Returns the first candidate evaluation in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate evaluation
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a matching candidate evaluation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation findByCandidate_First(long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateEvaluationException, SystemException {
		CandidateEvaluation candidateEvaluation = fetchByCandidate_First(candidateId,
				orderByComparator);

		if (candidateEvaluation != null) {
			return candidateEvaluation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateEvaluationException(msg.toString());
	}

	/**
	 * Returns the first candidate evaluation in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate evaluation, or <code>null</code> if a matching candidate evaluation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation fetchByCandidate_First(long candidateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<CandidateEvaluation> list = findByCandidate(candidateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate evaluation in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate evaluation
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a matching candidate evaluation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation findByCandidate_Last(long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateEvaluationException, SystemException {
		CandidateEvaluation candidateEvaluation = fetchByCandidate_Last(candidateId,
				orderByComparator);

		if (candidateEvaluation != null) {
			return candidateEvaluation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateEvaluationException(msg.toString());
	}

	/**
	 * Returns the last candidate evaluation in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate evaluation, or <code>null</code> if a matching candidate evaluation could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation fetchByCandidate_Last(long candidateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCandidate(candidateId);

		if (count == 0) {
			return null;
		}

		List<CandidateEvaluation> list = findByCandidate(candidateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidate evaluations before and after the current candidate evaluation in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateEvaluationId the primary key of the current candidate evaluation
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate evaluation
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation[] findByCandidate_PrevAndNext(
		long candidateEvaluationId, long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateEvaluationException, SystemException {
		CandidateEvaluation candidateEvaluation = findByPrimaryKey(candidateEvaluationId);

		Session session = null;

		try {
			session = openSession();

			CandidateEvaluation[] array = new CandidateEvaluationImpl[3];

			array[0] = getByCandidate_PrevAndNext(session, candidateEvaluation,
					candidateId, orderByComparator, true);

			array[1] = candidateEvaluation;

			array[2] = getByCandidate_PrevAndNext(session, candidateEvaluation,
					candidateId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CandidateEvaluation getByCandidate_PrevAndNext(Session session,
		CandidateEvaluation candidateEvaluation, long candidateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATEEVALUATION_WHERE);

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
			query.append(CandidateEvaluationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(candidateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidateEvaluation);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CandidateEvaluation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidate evaluations where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCandidate(long candidateId) throws SystemException {
		for (CandidateEvaluation candidateEvaluation : findByCandidate(
				candidateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidateEvaluation);
		}
	}

	/**
	 * Returns the number of candidate evaluations where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching candidate evaluations
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

			query.append(_SQL_COUNT_CANDIDATEEVALUATION_WHERE);

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

	private static final String _FINDER_COLUMN_CANDIDATE_CANDIDATEID_2 = "candidateEvaluation.candidateId = ?";

	public CandidateEvaluationPersistenceImpl() {
		setModelClass(CandidateEvaluation.class);
	}

	/**
	 * Caches the candidate evaluation in the entity cache if it is enabled.
	 *
	 * @param candidateEvaluation the candidate evaluation
	 */
	@Override
	public void cacheResult(CandidateEvaluation candidateEvaluation) {
		EntityCacheUtil.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationImpl.class, candidateEvaluation.getPrimaryKey(),
			candidateEvaluation);

		candidateEvaluation.resetOriginalValues();
	}

	/**
	 * Caches the candidate evaluations in the entity cache if it is enabled.
	 *
	 * @param candidateEvaluations the candidate evaluations
	 */
	@Override
	public void cacheResult(List<CandidateEvaluation> candidateEvaluations) {
		for (CandidateEvaluation candidateEvaluation : candidateEvaluations) {
			if (EntityCacheUtil.getResult(
						CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						CandidateEvaluationImpl.class,
						candidateEvaluation.getPrimaryKey()) == null) {
				cacheResult(candidateEvaluation);
			}
			else {
				candidateEvaluation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidate evaluations.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CandidateEvaluationImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CandidateEvaluationImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate evaluation.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CandidateEvaluation candidateEvaluation) {
		EntityCacheUtil.removeResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationImpl.class, candidateEvaluation.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<CandidateEvaluation> candidateEvaluations) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CandidateEvaluation candidateEvaluation : candidateEvaluations) {
			EntityCacheUtil.removeResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				CandidateEvaluationImpl.class,
				candidateEvaluation.getPrimaryKey());
		}
	}

	/**
	 * Creates a new candidate evaluation with the primary key. Does not add the candidate evaluation to the database.
	 *
	 * @param candidateEvaluationId the primary key for the new candidate evaluation
	 * @return the new candidate evaluation
	 */
	@Override
	public CandidateEvaluation create(long candidateEvaluationId) {
		CandidateEvaluation candidateEvaluation = new CandidateEvaluationImpl();

		candidateEvaluation.setNew(true);
		candidateEvaluation.setPrimaryKey(candidateEvaluationId);

		return candidateEvaluation;
	}

	/**
	 * Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateEvaluationId the primary key of the candidate evaluation
	 * @return the candidate evaluation that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation remove(long candidateEvaluationId)
		throws NoSuchCandidateEvaluationException, SystemException {
		return remove((Serializable)candidateEvaluationId);
	}

	/**
	 * Removes the candidate evaluation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate evaluation
	 * @return the candidate evaluation that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation remove(Serializable primaryKey)
		throws NoSuchCandidateEvaluationException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CandidateEvaluation candidateEvaluation = (CandidateEvaluation)session.get(CandidateEvaluationImpl.class,
					primaryKey);

			if (candidateEvaluation == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidateEvaluation);
		}
		catch (NoSuchCandidateEvaluationException nsee) {
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
	protected CandidateEvaluation removeImpl(
		CandidateEvaluation candidateEvaluation) throws SystemException {
		candidateEvaluation = toUnwrappedModel(candidateEvaluation);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidateEvaluation)) {
				candidateEvaluation = (CandidateEvaluation)session.get(CandidateEvaluationImpl.class,
						candidateEvaluation.getPrimaryKeyObj());
			}

			if (candidateEvaluation != null) {
				session.delete(candidateEvaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidateEvaluation != null) {
			clearCache(candidateEvaluation);
		}

		return candidateEvaluation;
	}

	@Override
	public CandidateEvaluation updateImpl(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation)
		throws SystemException {
		candidateEvaluation = toUnwrappedModel(candidateEvaluation);

		boolean isNew = candidateEvaluation.isNew();

		CandidateEvaluationModelImpl candidateEvaluationModelImpl = (CandidateEvaluationModelImpl)candidateEvaluation;

		Session session = null;

		try {
			session = openSession();

			if (candidateEvaluation.isNew()) {
				session.save(candidateEvaluation);

				candidateEvaluation.setNew(false);
			}
			else {
				session.merge(candidateEvaluation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CandidateEvaluationModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((candidateEvaluationModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateEvaluationModelImpl.getOriginalCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE,
					args);

				args = new Object[] {
						candidateEvaluationModelImpl.getCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
			CandidateEvaluationImpl.class, candidateEvaluation.getPrimaryKey(),
			candidateEvaluation);

		return candidateEvaluation;
	}

	protected CandidateEvaluation toUnwrappedModel(
		CandidateEvaluation candidateEvaluation) {
		if (candidateEvaluation instanceof CandidateEvaluationImpl) {
			return candidateEvaluation;
		}

		CandidateEvaluationImpl candidateEvaluationImpl = new CandidateEvaluationImpl();

		candidateEvaluationImpl.setNew(candidateEvaluation.isNew());
		candidateEvaluationImpl.setPrimaryKey(candidateEvaluation.getPrimaryKey());

		candidateEvaluationImpl.setCandidateEvaluationId(candidateEvaluation.getCandidateEvaluationId());
		candidateEvaluationImpl.setCandidateId(candidateEvaluation.getCandidateId());
		candidateEvaluationImpl.setInterviewId(candidateEvaluation.getInterviewId());
		candidateEvaluationImpl.setEvaluationCriteriaKeyValueId(candidateEvaluation.getEvaluationCriteriaKeyValueId());
		candidateEvaluationImpl.setRatingPoint(candidateEvaluation.getRatingPoint());
		candidateEvaluationImpl.setNote(candidateEvaluation.getNote());
		candidateEvaluationImpl.setGroupId(candidateEvaluation.getGroupId());
		candidateEvaluationImpl.setCompanyId(candidateEvaluation.getCompanyId());
		candidateEvaluationImpl.setUserId(candidateEvaluation.getUserId());
		candidateEvaluationImpl.setUserName(candidateEvaluation.getUserName());
		candidateEvaluationImpl.setCreateDate(candidateEvaluation.getCreateDate());
		candidateEvaluationImpl.setModifiedDate(candidateEvaluation.getModifiedDate());

		return candidateEvaluationImpl;
	}

	/**
	 * Returns the candidate evaluation with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate evaluation
	 * @return the candidate evaluation
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateEvaluationException, SystemException {
		CandidateEvaluation candidateEvaluation = fetchByPrimaryKey(primaryKey);

		if (candidateEvaluation == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateEvaluationException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidateEvaluation;
	}

	/**
	 * Returns the candidate evaluation with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException} if it could not be found.
	 *
	 * @param candidateEvaluationId the primary key of the candidate evaluation
	 * @return the candidate evaluation
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation findByPrimaryKey(long candidateEvaluationId)
		throws NoSuchCandidateEvaluationException, SystemException {
		return findByPrimaryKey((Serializable)candidateEvaluationId);
	}

	/**
	 * Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate evaluation
	 * @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CandidateEvaluation candidateEvaluation = (CandidateEvaluation)EntityCacheUtil.getResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
				CandidateEvaluationImpl.class, primaryKey);

		if (candidateEvaluation == _nullCandidateEvaluation) {
			return null;
		}

		if (candidateEvaluation == null) {
			Session session = null;

			try {
				session = openSession();

				candidateEvaluation = (CandidateEvaluation)session.get(CandidateEvaluationImpl.class,
						primaryKey);

				if (candidateEvaluation != null) {
					cacheResult(candidateEvaluation);
				}
				else {
					EntityCacheUtil.putResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
						CandidateEvaluationImpl.class, primaryKey,
						_nullCandidateEvaluation);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CandidateEvaluationModelImpl.ENTITY_CACHE_ENABLED,
					CandidateEvaluationImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidateEvaluation;
	}

	/**
	 * Returns the candidate evaluation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateEvaluationId the primary key of the candidate evaluation
	 * @return the candidate evaluation, or <code>null</code> if a candidate evaluation with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CandidateEvaluation fetchByPrimaryKey(long candidateEvaluationId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)candidateEvaluationId);
	}

	/**
	 * Returns all the candidate evaluations.
	 *
	 * @return the candidate evaluations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateEvaluation> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidate evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @return the range of candidate evaluations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateEvaluation> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidate evaluations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidate evaluations
	 * @param end the upper bound of the range of candidate evaluations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidate evaluations
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CandidateEvaluation> findAll(int start, int end,
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

		List<CandidateEvaluation> list = (List<CandidateEvaluation>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CANDIDATEEVALUATION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATEEVALUATION;

				if (pagination) {
					sql = sql.concat(CandidateEvaluationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CandidateEvaluation>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CandidateEvaluation>(list);
				}
				else {
					list = (List<CandidateEvaluation>)QueryUtil.list(q,
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
	 * Removes all the candidate evaluations from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CandidateEvaluation candidateEvaluation : findAll()) {
			remove(candidateEvaluation);
		}
	}

	/**
	 * Returns the number of candidate evaluations.
	 *
	 * @return the number of candidate evaluations
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

				Query q = session.createQuery(_SQL_COUNT_CANDIDATEEVALUATION);

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
	 * Initializes the candidate evaluation persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.CandidateEvaluation")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CandidateEvaluation>> listenersList = new ArrayList<ModelListener<CandidateEvaluation>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CandidateEvaluation>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CandidateEvaluationImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CANDIDATEEVALUATION = "SELECT candidateEvaluation FROM CandidateEvaluation candidateEvaluation";
	private static final String _SQL_SELECT_CANDIDATEEVALUATION_WHERE = "SELECT candidateEvaluation FROM CandidateEvaluation candidateEvaluation WHERE ";
	private static final String _SQL_COUNT_CANDIDATEEVALUATION = "SELECT COUNT(candidateEvaluation) FROM CandidateEvaluation candidateEvaluation";
	private static final String _SQL_COUNT_CANDIDATEEVALUATION_WHERE = "SELECT COUNT(candidateEvaluation) FROM CandidateEvaluation candidateEvaluation WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidateEvaluation.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CandidateEvaluation exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CandidateEvaluation exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CandidateEvaluationPersistenceImpl.class);
	private static CandidateEvaluation _nullCandidateEvaluation = new CandidateEvaluationImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CandidateEvaluation> toCacheModel() {
				return _nullCandidateEvaluationCacheModel;
			}
		};

	private static CacheModel<CandidateEvaluation> _nullCandidateEvaluationCacheModel =
		new CacheModel<CandidateEvaluation>() {
			@Override
			public CandidateEvaluation toEntityModel() {
				return _nullCandidateEvaluation;
			}
		};
}