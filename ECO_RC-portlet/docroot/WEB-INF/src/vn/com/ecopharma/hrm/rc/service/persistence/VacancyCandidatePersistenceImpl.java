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

import vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateImpl;
import vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the vacancy candidate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacancyCandidatePersistence
 * @see VacancyCandidateUtil
 * @generated
 */
public class VacancyCandidatePersistenceImpl extends BasePersistenceImpl<VacancyCandidate>
	implements VacancyCandidatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VacancyCandidateUtil} to access the vacancy candidate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VacancyCandidateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVacancyAndCandidate",
			new String[] { Long.class.getName(), Long.class.getName() },
			VacancyCandidateModelImpl.VACANCYID_COLUMN_BITMASK |
			VacancyCandidateModelImpl.CANDIDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VACANCYANDCANDIDATE = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVacancyAndCandidate",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	 *
	 * @param vacancyId the vacancy ID
	 * @param candidateId the candidate ID
	 * @return the matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByVacancyAndCandidate(long vacancyId,
		long candidateId)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByVacancyAndCandidate(vacancyId,
				candidateId);

		if (vacancyCandidate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vacancyId=");
			msg.append(vacancyId);

			msg.append(", candidateId=");
			msg.append(candidateId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVacancyCandidateException(msg.toString());
		}

		return vacancyCandidate;
	}

	/**
	 * Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vacancyId the vacancy ID
	 * @param candidateId the candidate ID
	 * @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByVacancyAndCandidate(long vacancyId,
		long candidateId) throws SystemException {
		return fetchByVacancyAndCandidate(vacancyId, candidateId, true);
	}

	/**
	 * Returns the vacancy candidate where vacancyId = &#63; and candidateId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vacancyId the vacancy ID
	 * @param candidateId the candidate ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByVacancyAndCandidate(long vacancyId,
		long candidateId, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { vacancyId, candidateId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
					finderArgs, this);
		}

		if (result instanceof VacancyCandidate) {
			VacancyCandidate vacancyCandidate = (VacancyCandidate)result;

			if ((vacancyId != vacancyCandidate.getVacancyId()) ||
					(candidateId != vacancyCandidate.getCandidateId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYANDCANDIDATE_VACANCYID_2);

			query.append(_FINDER_COLUMN_VACANCYANDCANDIDATE_CANDIDATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyId);

				qPos.add(candidateId);

				List<VacancyCandidate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VacancyCandidatePersistenceImpl.fetchByVacancyAndCandidate(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VacancyCandidate vacancyCandidate = list.get(0);

					result = vacancyCandidate;

					cacheResult(vacancyCandidate);

					if ((vacancyCandidate.getVacancyId() != vacancyId) ||
							(vacancyCandidate.getCandidateId() != candidateId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
							finderArgs, vacancyCandidate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
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
			return (VacancyCandidate)result;
		}
	}

	/**
	 * Removes the vacancy candidate where vacancyId = &#63; and candidateId = &#63; from the database.
	 *
	 * @param vacancyId the vacancy ID
	 * @param candidateId the candidate ID
	 * @return the vacancy candidate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate removeByVacancyAndCandidate(long vacancyId,
		long candidateId)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = findByVacancyAndCandidate(vacancyId,
				candidateId);

		return remove(vacancyCandidate);
	}

	/**
	 * Returns the number of vacancy candidates where vacancyId = &#63; and candidateId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @param candidateId the candidate ID
	 * @return the number of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVacancyAndCandidate(long vacancyId, long candidateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VACANCYANDCANDIDATE;

		Object[] finderArgs = new Object[] { vacancyId, candidateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYANDCANDIDATE_VACANCYID_2);

			query.append(_FINDER_COLUMN_VACANCYANDCANDIDATE_CANDIDATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyId);

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

	private static final String _FINDER_COLUMN_VACANCYANDCANDIDATE_VACANCYID_2 = "vacancyCandidate.vacancyId = ? AND ";
	private static final String _FINDER_COLUMN_VACANCYANDCANDIDATE_CANDIDATEID_2 =
		"vacancyCandidate.candidateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATE =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCandidate",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCandidate",
			new String[] { Long.class.getName() },
			VacancyCandidateModelImpl.CANDIDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATE = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCandidate",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vacancy candidates where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByCandidate(long candidateId)
		throws SystemException {
		return findByCandidate(candidateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacancy candidates where candidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @return the range of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByCandidate(long candidateId, int start,
		int end) throws SystemException {
		return findByCandidate(candidateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacancy candidates where candidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByCandidate(long candidateId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<VacancyCandidate> list = (List<VacancyCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VacancyCandidate vacancyCandidate : list) {
				if ((candidateId != vacancyCandidate.getCandidateId())) {
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

			query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATE_CANDIDATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VacancyCandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (!pagination) {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacancyCandidate>(list);
				}
				else {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
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
	 * Returns the first vacancy candidate in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByCandidate_First(long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByCandidate_First(candidateId,
				orderByComparator);

		if (vacancyCandidate != null) {
			return vacancyCandidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacancyCandidateException(msg.toString());
	}

	/**
	 * Returns the first vacancy candidate in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidate_First(long candidateId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VacancyCandidate> list = findByCandidate(candidateId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vacancy candidate in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByCandidate_Last(long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByCandidate_Last(candidateId,
				orderByComparator);

		if (vacancyCandidate != null) {
			return vacancyCandidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacancyCandidateException(msg.toString());
	}

	/**
	 * Returns the last vacancy candidate in the ordered set where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidate_Last(long candidateId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCandidate(candidateId);

		if (count == 0) {
			return null;
		}

		List<VacancyCandidate> list = findByCandidate(candidateId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vacancy candidates before and after the current vacancy candidate in the ordered set where candidateId = &#63;.
	 *
	 * @param vacancyCandidateId the primary key of the current vacancy candidate
	 * @param candidateId the candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate[] findByCandidate_PrevAndNext(
		long vacancyCandidateId, long candidateId,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = findByPrimaryKey(vacancyCandidateId);

		Session session = null;

		try {
			session = openSession();

			VacancyCandidate[] array = new VacancyCandidateImpl[3];

			array[0] = getByCandidate_PrevAndNext(session, vacancyCandidate,
					candidateId, orderByComparator, true);

			array[1] = vacancyCandidate;

			array[2] = getByCandidate_PrevAndNext(session, vacancyCandidate,
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

	protected VacancyCandidate getByCandidate_PrevAndNext(Session session,
		VacancyCandidate vacancyCandidate, long candidateId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

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
			query.append(VacancyCandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(candidateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vacancyCandidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VacancyCandidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vacancy candidates where candidateId = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCandidate(long candidateId) throws SystemException {
		for (VacancyCandidate vacancyCandidate : findByCandidate(candidateId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vacancyCandidate);
		}
	}

	/**
	 * Returns the number of vacancy candidates where candidateId = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @return the number of matching vacancy candidates
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

			query.append(_SQL_COUNT_VACANCYCANDIDATE_WHERE);

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

	private static final String _FINDER_COLUMN_CANDIDATE_CANDIDATEID_2 = "vacancyCandidate.candidateId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VACANCY = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVacancy",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCY =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVacancy",
			new String[] { Long.class.getName() },
			VacancyCandidateModelImpl.VACANCYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VACANCY = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVacancy",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vacancy candidates where vacancyId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @return the matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByVacancy(long vacancyId)
		throws SystemException {
		return findByVacancy(vacancyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the vacancy candidates where vacancyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vacancyId the vacancy ID
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @return the range of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByVacancy(long vacancyId, int start,
		int end) throws SystemException {
		return findByVacancy(vacancyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacancy candidates where vacancyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vacancyId the vacancy ID
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByVacancy(long vacancyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCY;
			finderArgs = new Object[] { vacancyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VACANCY;
			finderArgs = new Object[] { vacancyId, start, end, orderByComparator };
		}

		List<VacancyCandidate> list = (List<VacancyCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VacancyCandidate vacancyCandidate : list) {
				if ((vacancyId != vacancyCandidate.getVacancyId())) {
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

			query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_VACANCY_VACANCYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VacancyCandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyId);

				if (!pagination) {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacancyCandidate>(list);
				}
				else {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
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
	 * Returns the first vacancy candidate in the ordered set where vacancyId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByVacancy_First(long vacancyId,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByVacancy_First(vacancyId,
				orderByComparator);

		if (vacancyCandidate != null) {
			return vacancyCandidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vacancyId=");
		msg.append(vacancyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacancyCandidateException(msg.toString());
	}

	/**
	 * Returns the first vacancy candidate in the ordered set where vacancyId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByVacancy_First(long vacancyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VacancyCandidate> list = findByVacancy(vacancyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vacancy candidate in the ordered set where vacancyId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByVacancy_Last(long vacancyId,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByVacancy_Last(vacancyId,
				orderByComparator);

		if (vacancyCandidate != null) {
			return vacancyCandidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vacancyId=");
		msg.append(vacancyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacancyCandidateException(msg.toString());
	}

	/**
	 * Returns the last vacancy candidate in the ordered set where vacancyId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByVacancy_Last(long vacancyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByVacancy(vacancyId);

		if (count == 0) {
			return null;
		}

		List<VacancyCandidate> list = findByVacancy(vacancyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vacancy candidates before and after the current vacancy candidate in the ordered set where vacancyId = &#63;.
	 *
	 * @param vacancyCandidateId the primary key of the current vacancy candidate
	 * @param vacancyId the vacancy ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate[] findByVacancy_PrevAndNext(
		long vacancyCandidateId, long vacancyId,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = findByPrimaryKey(vacancyCandidateId);

		Session session = null;

		try {
			session = openSession();

			VacancyCandidate[] array = new VacancyCandidateImpl[3];

			array[0] = getByVacancy_PrevAndNext(session, vacancyCandidate,
					vacancyId, orderByComparator, true);

			array[1] = vacancyCandidate;

			array[2] = getByVacancy_PrevAndNext(session, vacancyCandidate,
					vacancyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VacancyCandidate getByVacancy_PrevAndNext(Session session,
		VacancyCandidate vacancyCandidate, long vacancyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

		query.append(_FINDER_COLUMN_VACANCY_VACANCYID_2);

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
			query.append(VacancyCandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vacancyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vacancyCandidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VacancyCandidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vacancy candidates where vacancyId = &#63; from the database.
	 *
	 * @param vacancyId the vacancy ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVacancy(long vacancyId) throws SystemException {
		for (VacancyCandidate vacancyCandidate : findByVacancy(vacancyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vacancyCandidate);
		}
	}

	/**
	 * Returns the number of vacancy candidates where vacancyId = &#63;.
	 *
	 * @param vacancyId the vacancy ID
	 * @return the number of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVacancy(long vacancyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VACANCY;

		Object[] finderArgs = new Object[] { vacancyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_VACANCY_VACANCYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyId);

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

	private static final String _FINDER_COLUMN_VACANCY_VACANCYID_2 = "vacancyCandidate.vacancyId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCandidateAndActiveStatus",
			new String[] { Long.class.getName(), Integer.class.getName() },
			VacancyCandidateModelImpl.CANDIDATEID_COLUMN_BITMASK |
			VacancyCandidateModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATEANDACTIVESTATUS =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCandidateAndActiveStatus",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns the vacancy candidate where candidateId = &#63; and status = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @param status the status
	 * @return the matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByCandidateAndActiveStatus(long candidateId,
		int status) throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByCandidateAndActiveStatus(candidateId,
				status);

		if (vacancyCandidate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("candidateId=");
			msg.append(candidateId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVacancyCandidateException(msg.toString());
		}

		return vacancyCandidate;
	}

	/**
	 * Returns the vacancy candidate where candidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param status the status
	 * @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidateAndActiveStatus(long candidateId,
		int status) throws SystemException {
		return fetchByCandidateAndActiveStatus(candidateId, status, true);
	}

	/**
	 * Returns the vacancy candidate where candidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidateAndActiveStatus(long candidateId,
		int status, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { candidateId, status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
					finderArgs, this);
		}

		if (result instanceof VacancyCandidate) {
			VacancyCandidate vacancyCandidate = (VacancyCandidate)result;

			if ((candidateId != vacancyCandidate.getCandidateId()) ||
					(status != vacancyCandidate.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIVESTATUS_CANDIDATEID_2);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIVESTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				qPos.add(status);

				List<VacancyCandidate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VacancyCandidatePersistenceImpl.fetchByCandidateAndActiveStatus(long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VacancyCandidate vacancyCandidate = list.get(0);

					result = vacancyCandidate;

					cacheResult(vacancyCandidate);

					if ((vacancyCandidate.getCandidateId() != candidateId) ||
							(vacancyCandidate.getStatus() != status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
							finderArgs, vacancyCandidate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
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
			return (VacancyCandidate)result;
		}
	}

	/**
	 * Removes the vacancy candidate where candidateId = &#63; and status = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @param status the status
	 * @return the vacancy candidate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate removeByCandidateAndActiveStatus(long candidateId,
		int status) throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = findByCandidateAndActiveStatus(candidateId,
				status);

		return remove(vacancyCandidate);
	}

	/**
	 * Returns the number of vacancy candidates where candidateId = &#63; and status = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param status the status
	 * @return the number of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCandidateAndActiveStatus(long candidateId, int status)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATEANDACTIVESTATUS;

		Object[] finderArgs = new Object[] { candidateId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIVESTATUS_CANDIDATEID_2);

			query.append(_FINDER_COLUMN_CANDIDATEANDACTIVESTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_CANDIDATEANDACTIVESTATUS_CANDIDATEID_2 =
		"vacancyCandidate.candidateId = ? AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDACTIVESTATUS_STATUS_2 =
		"vacancyCandidate.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEANDTYPE =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCandidateAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDTYPE =
		new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCandidateAndType",
			new String[] { Long.class.getName(), String.class.getName() },
			VacancyCandidateModelImpl.CANDIDATEID_COLUMN_BITMASK |
			VacancyCandidateModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATEANDTYPE = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCandidateAndType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vacancy candidates where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @return the matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByCandidateAndType(long candidateId,
		String type) throws SystemException {
		return findByCandidateAndType(candidateId, type, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacancy candidates where candidateId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @return the range of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByCandidateAndType(long candidateId,
		String type, int start, int end) throws SystemException {
		return findByCandidateAndType(candidateId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacancy candidates where candidateId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findByCandidateAndType(long candidateId,
		String type, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDTYPE;
			finderArgs = new Object[] { candidateId, type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANDIDATEANDTYPE;
			finderArgs = new Object[] {
					candidateId, type,
					
					start, end, orderByComparator
				};
		}

		List<VacancyCandidate> list = (List<VacancyCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VacancyCandidate vacancyCandidate : list) {
				if ((candidateId != vacancyCandidate.getCandidateId()) ||
						!Validator.equals(type, vacancyCandidate.getType())) {
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

			query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_CANDIDATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VacancyCandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacancyCandidate>(list);
				}
				else {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
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
	 * Returns the first vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByCandidateAndType_First(long candidateId,
		String type, OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByCandidateAndType_First(candidateId,
				type, orderByComparator);

		if (vacancyCandidate != null) {
			return vacancyCandidate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacancyCandidateException(msg.toString());
	}

	/**
	 * Returns the first vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidateAndType_First(long candidateId,
		String type, OrderByComparator orderByComparator)
		throws SystemException {
		List<VacancyCandidate> list = findByCandidateAndType(candidateId, type,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByCandidateAndType_Last(long candidateId,
		String type, OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByCandidateAndType_Last(candidateId,
				type, orderByComparator);

		if (vacancyCandidate != null) {
			return vacancyCandidate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("candidateId=");
		msg.append(candidateId);

		msg.append(", type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacancyCandidateException(msg.toString());
	}

	/**
	 * Returns the last vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidateAndType_Last(long candidateId,
		String type, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByCandidateAndType(candidateId, type);

		if (count == 0) {
			return null;
		}

		List<VacancyCandidate> list = findByCandidateAndType(candidateId, type,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vacancy candidates before and after the current vacancy candidate in the ordered set where candidateId = &#63; and type = &#63;.
	 *
	 * @param vacancyCandidateId the primary key of the current vacancy candidate
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate[] findByCandidateAndType_PrevAndNext(
		long vacancyCandidateId, long candidateId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = findByPrimaryKey(vacancyCandidateId);

		Session session = null;

		try {
			session = openSession();

			VacancyCandidate[] array = new VacancyCandidateImpl[3];

			array[0] = getByCandidateAndType_PrevAndNext(session,
					vacancyCandidate, candidateId, type, orderByComparator, true);

			array[1] = vacancyCandidate;

			array[2] = getByCandidateAndType_PrevAndNext(session,
					vacancyCandidate, candidateId, type, orderByComparator,
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

	protected VacancyCandidate getByCandidateAndType_PrevAndNext(
		Session session, VacancyCandidate vacancyCandidate, long candidateId,
		String type, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

		query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_CANDIDATEID_2);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_2);
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
			query.append(VacancyCandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(candidateId);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vacancyCandidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VacancyCandidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vacancy candidates where candidateId = &#63; and type = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCandidateAndType(long candidateId, String type)
		throws SystemException {
		for (VacancyCandidate vacancyCandidate : findByCandidateAndType(
				candidateId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vacancyCandidate);
		}
	}

	/**
	 * Returns the number of vacancy candidates where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @return the number of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCandidateAndType(long candidateId, String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATEANDTYPE;

		Object[] finderArgs = new Object[] { candidateId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_CANDIDATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_CANDIDATEANDTYPE_CANDIDATEID_2 = "vacancyCandidate.candidateId = ? AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_1 = "vacancyCandidate.type IS NULL";
	private static final String _FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_2 = "vacancyCandidate.type = ?";
	private static final String _FINDER_COLUMN_CANDIDATEANDTYPE_TYPE_3 = "(vacancyCandidate.type IS NULL OR vacancyCandidate.type = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED,
			VacancyCandidateImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCandidateAndMAINType",
			new String[] { Long.class.getName(), String.class.getName() },
			VacancyCandidateModelImpl.CANDIDATEID_COLUMN_BITMASK |
			VacancyCandidateModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CANDIDATEANDMAINTYPE = new FinderPath(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCandidateAndMAINType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the vacancy candidate where candidateId = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @return the matching vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByCandidateAndMAINType(long candidateId,
		String type) throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByCandidateAndMAINType(candidateId,
				type);

		if (vacancyCandidate == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("candidateId=");
			msg.append(candidateId);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchVacancyCandidateException(msg.toString());
		}

		return vacancyCandidate;
	}

	/**
	 * Returns the vacancy candidate where candidateId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidateAndMAINType(long candidateId,
		String type) throws SystemException {
		return fetchByCandidateAndMAINType(candidateId, type, true);
	}

	/**
	 * Returns the vacancy candidate where candidateId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching vacancy candidate, or <code>null</code> if a matching vacancy candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByCandidateAndMAINType(long candidateId,
		String type, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { candidateId, type };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
					finderArgs, this);
		}

		if (result instanceof VacancyCandidate) {
			VacancyCandidate vacancyCandidate = (VacancyCandidate)result;

			if ((candidateId != vacancyCandidate.getCandidateId()) ||
					!Validator.equals(type, vacancyCandidate.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_CANDIDATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindType) {
					qPos.add(type);
				}

				List<VacancyCandidate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"VacancyCandidatePersistenceImpl.fetchByCandidateAndMAINType(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					VacancyCandidate vacancyCandidate = list.get(0);

					result = vacancyCandidate;

					cacheResult(vacancyCandidate);

					if ((vacancyCandidate.getCandidateId() != candidateId) ||
							(vacancyCandidate.getType() == null) ||
							!vacancyCandidate.getType().equals(type)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
							finderArgs, vacancyCandidate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
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
			return (VacancyCandidate)result;
		}
	}

	/**
	 * Removes the vacancy candidate where candidateId = &#63; and type = &#63; from the database.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @return the vacancy candidate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate removeByCandidateAndMAINType(long candidateId,
		String type) throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = findByCandidateAndMAINType(candidateId,
				type);

		return remove(vacancyCandidate);
	}

	/**
	 * Returns the number of vacancy candidates where candidateId = &#63; and type = &#63;.
	 *
	 * @param candidateId the candidate ID
	 * @param type the type
	 * @return the number of matching vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCandidateAndMAINType(long candidateId, String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CANDIDATEANDMAINTYPE;

		Object[] finderArgs = new Object[] { candidateId, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VACANCYCANDIDATE_WHERE);

			query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_CANDIDATEID_2);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(candidateId);

				if (bindType) {
					qPos.add(type);
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

	private static final String _FINDER_COLUMN_CANDIDATEANDMAINTYPE_CANDIDATEID_2 =
		"vacancyCandidate.candidateId = ? AND ";
	private static final String _FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_1 = "vacancyCandidate.type IS NULL";
	private static final String _FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_2 = "vacancyCandidate.type = ?";
	private static final String _FINDER_COLUMN_CANDIDATEANDMAINTYPE_TYPE_3 = "(vacancyCandidate.type IS NULL OR vacancyCandidate.type = '')";

	public VacancyCandidatePersistenceImpl() {
		setModelClass(VacancyCandidate.class);
	}

	/**
	 * Caches the vacancy candidate in the entity cache if it is enabled.
	 *
	 * @param vacancyCandidate the vacancy candidate
	 */
	@Override
	public void cacheResult(VacancyCandidate vacancyCandidate) {
		EntityCacheUtil.putResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateImpl.class, vacancyCandidate.getPrimaryKey(),
			vacancyCandidate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
			new Object[] {
				vacancyCandidate.getVacancyId(),
				vacancyCandidate.getCandidateId()
			}, vacancyCandidate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
			new Object[] {
				vacancyCandidate.getCandidateId(), vacancyCandidate.getStatus()
			}, vacancyCandidate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
			new Object[] {
				vacancyCandidate.getCandidateId(), vacancyCandidate.getType()
			}, vacancyCandidate);

		vacancyCandidate.resetOriginalValues();
	}

	/**
	 * Caches the vacancy candidates in the entity cache if it is enabled.
	 *
	 * @param vacancyCandidates the vacancy candidates
	 */
	@Override
	public void cacheResult(List<VacancyCandidate> vacancyCandidates) {
		for (VacancyCandidate vacancyCandidate : vacancyCandidates) {
			if (EntityCacheUtil.getResult(
						VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
						VacancyCandidateImpl.class,
						vacancyCandidate.getPrimaryKey()) == null) {
				cacheResult(vacancyCandidate);
			}
			else {
				vacancyCandidate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vacancy candidates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VacancyCandidateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VacancyCandidateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vacancy candidate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VacancyCandidate vacancyCandidate) {
		EntityCacheUtil.removeResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateImpl.class, vacancyCandidate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(vacancyCandidate);
	}

	@Override
	public void clearCache(List<VacancyCandidate> vacancyCandidates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VacancyCandidate vacancyCandidate : vacancyCandidates) {
			EntityCacheUtil.removeResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
				VacancyCandidateImpl.class, vacancyCandidate.getPrimaryKey());

			clearUniqueFindersCache(vacancyCandidate);
		}
	}

	protected void cacheUniqueFindersCache(VacancyCandidate vacancyCandidate) {
		if (vacancyCandidate.isNew()) {
			Object[] args = new Object[] {
					vacancyCandidate.getVacancyId(),
					vacancyCandidate.getCandidateId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VACANCYANDCANDIDATE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
				args, vacancyCandidate);

			args = new Object[] {
					vacancyCandidate.getCandidateId(),
					vacancyCandidate.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIVESTATUS,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
				args, vacancyCandidate);

			args = new Object[] {
					vacancyCandidate.getCandidateId(),
					vacancyCandidate.getType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CANDIDATEANDMAINTYPE,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
				args, vacancyCandidate);
		}
		else {
			VacancyCandidateModelImpl vacancyCandidateModelImpl = (VacancyCandidateModelImpl)vacancyCandidate;

			if ((vacancyCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacancyCandidate.getVacancyId(),
						vacancyCandidate.getCandidateId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VACANCYANDCANDIDATE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
					args, vacancyCandidate);
			}

			if ((vacancyCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacancyCandidate.getCandidateId(),
						vacancyCandidate.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIVESTATUS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
					args, vacancyCandidate);
			}

			if ((vacancyCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacancyCandidate.getCandidateId(),
						vacancyCandidate.getType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CANDIDATEANDMAINTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
					args, vacancyCandidate);
			}
		}
	}

	protected void clearUniqueFindersCache(VacancyCandidate vacancyCandidate) {
		VacancyCandidateModelImpl vacancyCandidateModelImpl = (VacancyCandidateModelImpl)vacancyCandidate;

		Object[] args = new Object[] {
				vacancyCandidate.getVacancyId(),
				vacancyCandidate.getCandidateId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYANDCANDIDATE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
			args);

		if ((vacancyCandidateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE.getColumnBitmask()) != 0) {
			args = new Object[] {
					vacancyCandidateModelImpl.getOriginalVacancyId(),
					vacancyCandidateModelImpl.getOriginalCandidateId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYANDCANDIDATE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYANDCANDIDATE,
				args);
		}

		args = new Object[] {
				vacancyCandidate.getCandidateId(), vacancyCandidate.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIVESTATUS,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
			args);

		if ((vacancyCandidateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS.getColumnBitmask()) != 0) {
			args = new Object[] {
					vacancyCandidateModelImpl.getOriginalCandidateId(),
					vacancyCandidateModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDACTIVESTATUS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CANDIDATEANDACTIVESTATUS,
				args);
		}

		args = new Object[] {
				vacancyCandidate.getCandidateId(), vacancyCandidate.getType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDMAINTYPE,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
			args);

		if ((vacancyCandidateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					vacancyCandidateModelImpl.getOriginalCandidateId(),
					vacancyCandidateModelImpl.getOriginalType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDMAINTYPE,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CANDIDATEANDMAINTYPE,
				args);
		}
	}

	/**
	 * Creates a new vacancy candidate with the primary key. Does not add the vacancy candidate to the database.
	 *
	 * @param vacancyCandidateId the primary key for the new vacancy candidate
	 * @return the new vacancy candidate
	 */
	@Override
	public VacancyCandidate create(long vacancyCandidateId) {
		VacancyCandidate vacancyCandidate = new VacancyCandidateImpl();

		vacancyCandidate.setNew(true);
		vacancyCandidate.setPrimaryKey(vacancyCandidateId);

		return vacancyCandidate;
	}

	/**
	 * Removes the vacancy candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancyCandidateId the primary key of the vacancy candidate
	 * @return the vacancy candidate that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate remove(long vacancyCandidateId)
		throws NoSuchVacancyCandidateException, SystemException {
		return remove((Serializable)vacancyCandidateId);
	}

	/**
	 * Removes the vacancy candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vacancy candidate
	 * @return the vacancy candidate that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate remove(Serializable primaryKey)
		throws NoSuchVacancyCandidateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VacancyCandidate vacancyCandidate = (VacancyCandidate)session.get(VacancyCandidateImpl.class,
					primaryKey);

			if (vacancyCandidate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVacancyCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vacancyCandidate);
		}
		catch (NoSuchVacancyCandidateException nsee) {
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
	protected VacancyCandidate removeImpl(VacancyCandidate vacancyCandidate)
		throws SystemException {
		vacancyCandidate = toUnwrappedModel(vacancyCandidate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vacancyCandidate)) {
				vacancyCandidate = (VacancyCandidate)session.get(VacancyCandidateImpl.class,
						vacancyCandidate.getPrimaryKeyObj());
			}

			if (vacancyCandidate != null) {
				session.delete(vacancyCandidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vacancyCandidate != null) {
			clearCache(vacancyCandidate);
		}

		return vacancyCandidate;
	}

	@Override
	public VacancyCandidate updateImpl(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate)
		throws SystemException {
		vacancyCandidate = toUnwrappedModel(vacancyCandidate);

		boolean isNew = vacancyCandidate.isNew();

		VacancyCandidateModelImpl vacancyCandidateModelImpl = (VacancyCandidateModelImpl)vacancyCandidate;

		Session session = null;

		try {
			session = openSession();

			if (vacancyCandidate.isNew()) {
				session.save(vacancyCandidate);

				vacancyCandidate.setNew(false);
			}
			else {
				session.merge(vacancyCandidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VacancyCandidateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vacancyCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacancyCandidateModelImpl.getOriginalCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE,
					args);

				args = new Object[] { vacancyCandidateModelImpl.getCandidateId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATE,
					args);
			}

			if ((vacancyCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacancyCandidateModelImpl.getOriginalVacancyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCY,
					args);

				args = new Object[] { vacancyCandidateModelImpl.getVacancyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCY,
					args);
			}

			if ((vacancyCandidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacancyCandidateModelImpl.getOriginalCandidateId(),
						vacancyCandidateModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDTYPE,
					args);

				args = new Object[] {
						vacancyCandidateModelImpl.getCandidateId(),
						vacancyCandidateModelImpl.getType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANDIDATEANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANDIDATEANDTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
			VacancyCandidateImpl.class, vacancyCandidate.getPrimaryKey(),
			vacancyCandidate);

		clearUniqueFindersCache(vacancyCandidate);
		cacheUniqueFindersCache(vacancyCandidate);

		return vacancyCandidate;
	}

	protected VacancyCandidate toUnwrappedModel(
		VacancyCandidate vacancyCandidate) {
		if (vacancyCandidate instanceof VacancyCandidateImpl) {
			return vacancyCandidate;
		}

		VacancyCandidateImpl vacancyCandidateImpl = new VacancyCandidateImpl();

		vacancyCandidateImpl.setNew(vacancyCandidate.isNew());
		vacancyCandidateImpl.setPrimaryKey(vacancyCandidate.getPrimaryKey());

		vacancyCandidateImpl.setVacancyCandidateId(vacancyCandidate.getVacancyCandidateId());
		vacancyCandidateImpl.setVacancyId(vacancyCandidate.getVacancyId());
		vacancyCandidateImpl.setCandidateId(vacancyCandidate.getCandidateId());
		vacancyCandidateImpl.setStatus(vacancyCandidate.getStatus());
		vacancyCandidateImpl.setGroupId(vacancyCandidate.getGroupId());
		vacancyCandidateImpl.setCompanyId(vacancyCandidate.getCompanyId());
		vacancyCandidateImpl.setUserId(vacancyCandidate.getUserId());
		vacancyCandidateImpl.setUserName(vacancyCandidate.getUserName());
		vacancyCandidateImpl.setCreateDate(vacancyCandidate.getCreateDate());
		vacancyCandidateImpl.setModifiedDate(vacancyCandidate.getModifiedDate());
		vacancyCandidateImpl.setType(vacancyCandidate.getType());

		return vacancyCandidateImpl;
	}

	/**
	 * Returns the vacancy candidate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacancy candidate
	 * @return the vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVacancyCandidateException, SystemException {
		VacancyCandidate vacancyCandidate = fetchByPrimaryKey(primaryKey);

		if (vacancyCandidate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVacancyCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vacancyCandidate;
	}

	/**
	 * Returns the vacancy candidate with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException} if it could not be found.
	 *
	 * @param vacancyCandidateId the primary key of the vacancy candidate
	 * @return the vacancy candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate findByPrimaryKey(long vacancyCandidateId)
		throws NoSuchVacancyCandidateException, SystemException {
		return findByPrimaryKey((Serializable)vacancyCandidateId);
	}

	/**
	 * Returns the vacancy candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacancy candidate
	 * @return the vacancy candidate, or <code>null</code> if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VacancyCandidate vacancyCandidate = (VacancyCandidate)EntityCacheUtil.getResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
				VacancyCandidateImpl.class, primaryKey);

		if (vacancyCandidate == _nullVacancyCandidate) {
			return null;
		}

		if (vacancyCandidate == null) {
			Session session = null;

			try {
				session = openSession();

				vacancyCandidate = (VacancyCandidate)session.get(VacancyCandidateImpl.class,
						primaryKey);

				if (vacancyCandidate != null) {
					cacheResult(vacancyCandidate);
				}
				else {
					EntityCacheUtil.putResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
						VacancyCandidateImpl.class, primaryKey,
						_nullVacancyCandidate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VacancyCandidateModelImpl.ENTITY_CACHE_ENABLED,
					VacancyCandidateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vacancyCandidate;
	}

	/**
	 * Returns the vacancy candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vacancyCandidateId the primary key of the vacancy candidate
	 * @return the vacancy candidate, or <code>null</code> if a vacancy candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacancyCandidate fetchByPrimaryKey(long vacancyCandidateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vacancyCandidateId);
	}

	/**
	 * Returns all the vacancy candidates.
	 *
	 * @return the vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacancy candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @return the range of vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacancy candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy candidates
	 * @param end the upper bound of the range of vacancy candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vacancy candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacancyCandidate> findAll(int start, int end,
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

		List<VacancyCandidate> list = (List<VacancyCandidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VACANCYCANDIDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VACANCYCANDIDATE;

				if (pagination) {
					sql = sql.concat(VacancyCandidateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacancyCandidate>(list);
				}
				else {
					list = (List<VacancyCandidate>)QueryUtil.list(q,
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
	 * Removes all the vacancy candidates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VacancyCandidate vacancyCandidate : findAll()) {
			remove(vacancyCandidate);
		}
	}

	/**
	 * Returns the number of vacancy candidates.
	 *
	 * @return the number of vacancy candidates
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

				Query q = session.createQuery(_SQL_COUNT_VACANCYCANDIDATE);

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
	 * Initializes the vacancy candidate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.VacancyCandidate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VacancyCandidate>> listenersList = new ArrayList<ModelListener<VacancyCandidate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VacancyCandidate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VacancyCandidateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VACANCYCANDIDATE = "SELECT vacancyCandidate FROM VacancyCandidate vacancyCandidate";
	private static final String _SQL_SELECT_VACANCYCANDIDATE_WHERE = "SELECT vacancyCandidate FROM VacancyCandidate vacancyCandidate WHERE ";
	private static final String _SQL_COUNT_VACANCYCANDIDATE = "SELECT COUNT(vacancyCandidate) FROM VacancyCandidate vacancyCandidate";
	private static final String _SQL_COUNT_VACANCYCANDIDATE_WHERE = "SELECT COUNT(vacancyCandidate) FROM VacancyCandidate vacancyCandidate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vacancyCandidate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VacancyCandidate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VacancyCandidate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VacancyCandidatePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static VacancyCandidate _nullVacancyCandidate = new VacancyCandidateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VacancyCandidate> toCacheModel() {
				return _nullVacancyCandidateCacheModel;
			}
		};

	private static CacheModel<VacancyCandidate> _nullVacancyCandidateCacheModel = new CacheModel<VacancyCandidate>() {
			@Override
			public VacancyCandidate toEntityModel() {
				return _nullVacancyCandidate;
			}
		};
}