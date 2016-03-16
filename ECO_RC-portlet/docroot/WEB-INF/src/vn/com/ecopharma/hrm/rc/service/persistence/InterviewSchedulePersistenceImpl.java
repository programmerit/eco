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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleImpl;
import vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the interview schedule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see InterviewSchedulePersistence
 * @see InterviewScheduleUtil
 * @generated
 */
public class InterviewSchedulePersistenceImpl extends BasePersistenceImpl<InterviewSchedule>
	implements InterviewSchedulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link InterviewScheduleUtil} to access the interview schedule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = InterviewScheduleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			InterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			InterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW =
		new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			InterviewScheduleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVacancyCandidateAndInterview",
			new String[] { Long.class.getName(), Long.class.getName() },
			InterviewScheduleModelImpl.VACANCYCANDIDATEID_COLUMN_BITMASK |
			InterviewScheduleModelImpl.INTERVIEWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDINTERVIEW =
		new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVacancyCandidateAndInterview",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the interview schedule where vacancyCandidateId = &#63; and interviewId = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException} if it could not be found.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param interviewId the interview ID
	 * @return the matching interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule findByVacancyCandidateAndInterview(
		long vacancyCandidateId, long interviewId)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = fetchByVacancyCandidateAndInterview(vacancyCandidateId,
				interviewId);

		if (interviewSchedule == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vacancyCandidateId=");
			msg.append(vacancyCandidateId);

			msg.append(", interviewId=");
			msg.append(interviewId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInterviewScheduleException(msg.toString());
		}

		return interviewSchedule;
	}

	/**
	 * Returns the interview schedule where vacancyCandidateId = &#63; and interviewId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param interviewId the interview ID
	 * @return the matching interview schedule, or <code>null</code> if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByVacancyCandidateAndInterview(
		long vacancyCandidateId, long interviewId) throws SystemException {
		return fetchByVacancyCandidateAndInterview(vacancyCandidateId,
			interviewId, true);
	}

	/**
	 * Returns the interview schedule where vacancyCandidateId = &#63; and interviewId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param interviewId the interview ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching interview schedule, or <code>null</code> if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByVacancyCandidateAndInterview(
		long vacancyCandidateId, long interviewId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { vacancyCandidateId, interviewId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
					finderArgs, this);
		}

		if (result instanceof InterviewSchedule) {
			InterviewSchedule interviewSchedule = (InterviewSchedule)result;

			if ((vacancyCandidateId != interviewSchedule.getVacancyCandidateId()) ||
					(interviewId != interviewSchedule.getInterviewId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDINTERVIEW_VACANCYCANDIDATEID_2);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDINTERVIEW_INTERVIEWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyCandidateId);

				qPos.add(interviewId);

				List<InterviewSchedule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InterviewSchedulePersistenceImpl.fetchByVacancyCandidateAndInterview(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					InterviewSchedule interviewSchedule = list.get(0);

					result = interviewSchedule;

					cacheResult(interviewSchedule);

					if ((interviewSchedule.getVacancyCandidateId() != vacancyCandidateId) ||
							(interviewSchedule.getInterviewId() != interviewId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
							finderArgs, interviewSchedule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
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
			return (InterviewSchedule)result;
		}
	}

	/**
	 * Removes the interview schedule where vacancyCandidateId = &#63; and interviewId = &#63; from the database.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param interviewId the interview ID
	 * @return the interview schedule that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule removeByVacancyCandidateAndInterview(
		long vacancyCandidateId, long interviewId)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = findByVacancyCandidateAndInterview(vacancyCandidateId,
				interviewId);

		return remove(interviewSchedule);
	}

	/**
	 * Returns the number of interview schedules where vacancyCandidateId = &#63; and interviewId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param interviewId the interview ID
	 * @return the number of matching interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVacancyCandidateAndInterview(long vacancyCandidateId,
		long interviewId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDINTERVIEW;

		Object[] finderArgs = new Object[] { vacancyCandidateId, interviewId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDINTERVIEW_VACANCYCANDIDATEID_2);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDINTERVIEW_INTERVIEWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyCandidateId);

				qPos.add(interviewId);

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

	private static final String _FINDER_COLUMN_VACANCYCANDIDATEANDINTERVIEW_VACANCYCANDIDATEID_2 =
		"interviewSchedule.vacancyCandidateId = ? AND ";
	private static final String _FINDER_COLUMN_VACANCYCANDIDATEANDINTERVIEW_INTERVIEWID_2 =
		"interviewSchedule.interviewId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS =
		new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			InterviewScheduleImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByVacancyCandidateAndStatus",
			new String[] { Long.class.getName(), String.class.getName() },
			InterviewScheduleModelImpl.VACANCYCANDIDATEID_COLUMN_BITMASK |
			InterviewScheduleModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDSTATUS =
		new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVacancyCandidateAndStatus",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the interview schedule where vacancyCandidateId = &#63; and status = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException} if it could not be found.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param status the status
	 * @return the matching interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule findByVacancyCandidateAndStatus(
		long vacancyCandidateId, String status)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = fetchByVacancyCandidateAndStatus(vacancyCandidateId,
				status);

		if (interviewSchedule == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("vacancyCandidateId=");
			msg.append(vacancyCandidateId);

			msg.append(", status=");
			msg.append(status);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchInterviewScheduleException(msg.toString());
		}

		return interviewSchedule;
	}

	/**
	 * Returns the interview schedule where vacancyCandidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param status the status
	 * @return the matching interview schedule, or <code>null</code> if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByVacancyCandidateAndStatus(
		long vacancyCandidateId, String status) throws SystemException {
		return fetchByVacancyCandidateAndStatus(vacancyCandidateId, status, true);
	}

	/**
	 * Returns the interview schedule where vacancyCandidateId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param status the status
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching interview schedule, or <code>null</code> if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByVacancyCandidateAndStatus(
		long vacancyCandidateId, String status, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { vacancyCandidateId, status };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
					finderArgs, this);
		}

		if (result instanceof InterviewSchedule) {
			InterviewSchedule interviewSchedule = (InterviewSchedule)result;

			if ((vacancyCandidateId != interviewSchedule.getVacancyCandidateId()) ||
					!Validator.equals(status, interviewSchedule.getStatus())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_INTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_VACANCYCANDIDATEID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyCandidateId);

				if (bindStatus) {
					qPos.add(status);
				}

				List<InterviewSchedule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"InterviewSchedulePersistenceImpl.fetchByVacancyCandidateAndStatus(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					InterviewSchedule interviewSchedule = list.get(0);

					result = interviewSchedule;

					cacheResult(interviewSchedule);

					if ((interviewSchedule.getVacancyCandidateId() != vacancyCandidateId) ||
							(interviewSchedule.getStatus() == null) ||
							!interviewSchedule.getStatus().equals(status)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
							finderArgs, interviewSchedule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
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
			return (InterviewSchedule)result;
		}
	}

	/**
	 * Removes the interview schedule where vacancyCandidateId = &#63; and status = &#63; from the database.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param status the status
	 * @return the interview schedule that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule removeByVacancyCandidateAndStatus(
		long vacancyCandidateId, String status)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = findByVacancyCandidateAndStatus(vacancyCandidateId,
				status);

		return remove(interviewSchedule);
	}

	/**
	 * Returns the number of interview schedules where vacancyCandidateId = &#63; and status = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param status the status
	 * @return the number of matching interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVacancyCandidateAndStatus(long vacancyCandidateId,
		String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDSTATUS;

		Object[] finderArgs = new Object[] { vacancyCandidateId, status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_INTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_VACANCYCANDIDATEID_2);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyCandidateId);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_VACANCYCANDIDATEID_2 =
		"interviewSchedule.vacancyCandidateId = ? AND ";
	private static final String _FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_1 =
		"interviewSchedule.status IS NULL";
	private static final String _FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_2 =
		"interviewSchedule.status = ?";
	private static final String _FINDER_COLUMN_VACANCYCANDIDATEANDSTATUS_STATUS_3 =
		"(interviewSchedule.status IS NULL OR interviewSchedule.status = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VACANCYCANDIDATE =
		new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			InterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVacancyCandidate",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCYCANDIDATE =
		new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED,
			InterviewScheduleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVacancyCandidate", new String[] { Long.class.getName() },
			InterviewScheduleModelImpl.VACANCYCANDIDATEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VACANCYCANDIDATE = new FinderPath(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVacancyCandidate", new String[] { Long.class.getName() });

	/**
	 * Returns all the interview schedules where vacancyCandidateId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @return the matching interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InterviewSchedule> findByVacancyCandidate(
		long vacancyCandidateId) throws SystemException {
		return findByVacancyCandidate(vacancyCandidateId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interview schedules where vacancyCandidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param start the lower bound of the range of interview schedules
	 * @param end the upper bound of the range of interview schedules (not inclusive)
	 * @return the range of matching interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InterviewSchedule> findByVacancyCandidate(
		long vacancyCandidateId, int start, int end) throws SystemException {
		return findByVacancyCandidate(vacancyCandidateId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview schedules where vacancyCandidateId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param start the lower bound of the range of interview schedules
	 * @param end the upper bound of the range of interview schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InterviewSchedule> findByVacancyCandidate(
		long vacancyCandidateId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCYCANDIDATE;
			finderArgs = new Object[] { vacancyCandidateId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VACANCYCANDIDATE;
			finderArgs = new Object[] {
					vacancyCandidateId,
					
					start, end, orderByComparator
				};
		}

		List<InterviewSchedule> list = (List<InterviewSchedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (InterviewSchedule interviewSchedule : list) {
				if ((vacancyCandidateId != interviewSchedule.getVacancyCandidateId())) {
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

			query.append(_SQL_SELECT_INTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATE_VACANCYCANDIDATEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(InterviewScheduleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyCandidateId);

				if (!pagination) {
					list = (List<InterviewSchedule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InterviewSchedule>(list);
				}
				else {
					list = (List<InterviewSchedule>)QueryUtil.list(q,
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
	 * Returns the first interview schedule in the ordered set where vacancyCandidateId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule findByVacancyCandidate_First(
		long vacancyCandidateId, OrderByComparator orderByComparator)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = fetchByVacancyCandidate_First(vacancyCandidateId,
				orderByComparator);

		if (interviewSchedule != null) {
			return interviewSchedule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vacancyCandidateId=");
		msg.append(vacancyCandidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterviewScheduleException(msg.toString());
	}

	/**
	 * Returns the first interview schedule in the ordered set where vacancyCandidateId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching interview schedule, or <code>null</code> if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByVacancyCandidate_First(
		long vacancyCandidateId, OrderByComparator orderByComparator)
		throws SystemException {
		List<InterviewSchedule> list = findByVacancyCandidate(vacancyCandidateId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last interview schedule in the ordered set where vacancyCandidateId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule findByVacancyCandidate_Last(
		long vacancyCandidateId, OrderByComparator orderByComparator)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = fetchByVacancyCandidate_Last(vacancyCandidateId,
				orderByComparator);

		if (interviewSchedule != null) {
			return interviewSchedule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("vacancyCandidateId=");
		msg.append(vacancyCandidateId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchInterviewScheduleException(msg.toString());
	}

	/**
	 * Returns the last interview schedule in the ordered set where vacancyCandidateId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching interview schedule, or <code>null</code> if a matching interview schedule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByVacancyCandidate_Last(
		long vacancyCandidateId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByVacancyCandidate(vacancyCandidateId);

		if (count == 0) {
			return null;
		}

		List<InterviewSchedule> list = findByVacancyCandidate(vacancyCandidateId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the interview schedules before and after the current interview schedule in the ordered set where vacancyCandidateId = &#63;.
	 *
	 * @param interviewScheduleId the primary key of the current interview schedule
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule[] findByVacancyCandidate_PrevAndNext(
		long interviewScheduleId, long vacancyCandidateId,
		OrderByComparator orderByComparator)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = findByPrimaryKey(interviewScheduleId);

		Session session = null;

		try {
			session = openSession();

			InterviewSchedule[] array = new InterviewScheduleImpl[3];

			array[0] = getByVacancyCandidate_PrevAndNext(session,
					interviewSchedule, vacancyCandidateId, orderByComparator,
					true);

			array[1] = interviewSchedule;

			array[2] = getByVacancyCandidate_PrevAndNext(session,
					interviewSchedule, vacancyCandidateId, orderByComparator,
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

	protected InterviewSchedule getByVacancyCandidate_PrevAndNext(
		Session session, InterviewSchedule interviewSchedule,
		long vacancyCandidateId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_INTERVIEWSCHEDULE_WHERE);

		query.append(_FINDER_COLUMN_VACANCYCANDIDATE_VACANCYCANDIDATEID_2);

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
			query.append(InterviewScheduleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(vacancyCandidateId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(interviewSchedule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<InterviewSchedule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the interview schedules where vacancyCandidateId = &#63; from the database.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByVacancyCandidate(long vacancyCandidateId)
		throws SystemException {
		for (InterviewSchedule interviewSchedule : findByVacancyCandidate(
				vacancyCandidateId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(interviewSchedule);
		}
	}

	/**
	 * Returns the number of interview schedules where vacancyCandidateId = &#63;.
	 *
	 * @param vacancyCandidateId the vacancy candidate ID
	 * @return the number of matching interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByVacancyCandidate(long vacancyCandidateId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VACANCYCANDIDATE;

		Object[] finderArgs = new Object[] { vacancyCandidateId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_INTERVIEWSCHEDULE_WHERE);

			query.append(_FINDER_COLUMN_VACANCYCANDIDATE_VACANCYCANDIDATEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(vacancyCandidateId);

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

	private static final String _FINDER_COLUMN_VACANCYCANDIDATE_VACANCYCANDIDATEID_2 =
		"interviewSchedule.vacancyCandidateId = ?";

	public InterviewSchedulePersistenceImpl() {
		setModelClass(InterviewSchedule.class);
	}

	/**
	 * Caches the interview schedule in the entity cache if it is enabled.
	 *
	 * @param interviewSchedule the interview schedule
	 */
	@Override
	public void cacheResult(InterviewSchedule interviewSchedule) {
		EntityCacheUtil.putResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleImpl.class, interviewSchedule.getPrimaryKey(),
			interviewSchedule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
			new Object[] {
				interviewSchedule.getVacancyCandidateId(),
				interviewSchedule.getInterviewId()
			}, interviewSchedule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
			new Object[] {
				interviewSchedule.getVacancyCandidateId(),
				interviewSchedule.getStatus()
			}, interviewSchedule);

		interviewSchedule.resetOriginalValues();
	}

	/**
	 * Caches the interview schedules in the entity cache if it is enabled.
	 *
	 * @param interviewSchedules the interview schedules
	 */
	@Override
	public void cacheResult(List<InterviewSchedule> interviewSchedules) {
		for (InterviewSchedule interviewSchedule : interviewSchedules) {
			if (EntityCacheUtil.getResult(
						InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
						InterviewScheduleImpl.class,
						interviewSchedule.getPrimaryKey()) == null) {
				cacheResult(interviewSchedule);
			}
			else {
				interviewSchedule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all interview schedules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(InterviewScheduleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(InterviewScheduleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the interview schedule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(InterviewSchedule interviewSchedule) {
		EntityCacheUtil.removeResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleImpl.class, interviewSchedule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(interviewSchedule);
	}

	@Override
	public void clearCache(List<InterviewSchedule> interviewSchedules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (InterviewSchedule interviewSchedule : interviewSchedules) {
			EntityCacheUtil.removeResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
				InterviewScheduleImpl.class, interviewSchedule.getPrimaryKey());

			clearUniqueFindersCache(interviewSchedule);
		}
	}

	protected void cacheUniqueFindersCache(InterviewSchedule interviewSchedule) {
		if (interviewSchedule.isNew()) {
			Object[] args = new Object[] {
					interviewSchedule.getVacancyCandidateId(),
					interviewSchedule.getInterviewId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDINTERVIEW,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
				args, interviewSchedule);

			args = new Object[] {
					interviewSchedule.getVacancyCandidateId(),
					interviewSchedule.getStatus()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDSTATUS,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
				args, interviewSchedule);
		}
		else {
			InterviewScheduleModelImpl interviewScheduleModelImpl = (InterviewScheduleModelImpl)interviewSchedule;

			if ((interviewScheduleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interviewSchedule.getVacancyCandidateId(),
						interviewSchedule.getInterviewId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDINTERVIEW,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
					args, interviewSchedule);
			}

			if ((interviewScheduleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interviewSchedule.getVacancyCandidateId(),
						interviewSchedule.getStatus()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDSTATUS,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
					args, interviewSchedule);
			}
		}
	}

	protected void clearUniqueFindersCache(InterviewSchedule interviewSchedule) {
		InterviewScheduleModelImpl interviewScheduleModelImpl = (InterviewScheduleModelImpl)interviewSchedule;

		Object[] args = new Object[] {
				interviewSchedule.getVacancyCandidateId(),
				interviewSchedule.getInterviewId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDINTERVIEW,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
			args);

		if ((interviewScheduleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW.getColumnBitmask()) != 0) {
			args = new Object[] {
					interviewScheduleModelImpl.getOriginalVacancyCandidateId(),
					interviewScheduleModelImpl.getOriginalInterviewId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDINTERVIEW,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDINTERVIEW,
				args);
		}

		args = new Object[] {
				interviewSchedule.getVacancyCandidateId(),
				interviewSchedule.getStatus()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDSTATUS,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
			args);

		if ((interviewScheduleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS.getColumnBitmask()) != 0) {
			args = new Object[] {
					interviewScheduleModelImpl.getOriginalVacancyCandidateId(),
					interviewScheduleModelImpl.getOriginalStatus()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATEANDSTATUS,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_VACANCYCANDIDATEANDSTATUS,
				args);
		}
	}

	/**
	 * Creates a new interview schedule with the primary key. Does not add the interview schedule to the database.
	 *
	 * @param interviewScheduleId the primary key for the new interview schedule
	 * @return the new interview schedule
	 */
	@Override
	public InterviewSchedule create(long interviewScheduleId) {
		InterviewSchedule interviewSchedule = new InterviewScheduleImpl();

		interviewSchedule.setNew(true);
		interviewSchedule.setPrimaryKey(interviewScheduleId);

		return interviewSchedule;
	}

	/**
	 * Removes the interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param interviewScheduleId the primary key of the interview schedule
	 * @return the interview schedule that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule remove(long interviewScheduleId)
		throws NoSuchInterviewScheduleException, SystemException {
		return remove((Serializable)interviewScheduleId);
	}

	/**
	 * Removes the interview schedule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the interview schedule
	 * @return the interview schedule that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule remove(Serializable primaryKey)
		throws NoSuchInterviewScheduleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			InterviewSchedule interviewSchedule = (InterviewSchedule)session.get(InterviewScheduleImpl.class,
					primaryKey);

			if (interviewSchedule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchInterviewScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(interviewSchedule);
		}
		catch (NoSuchInterviewScheduleException nsee) {
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
	protected InterviewSchedule removeImpl(InterviewSchedule interviewSchedule)
		throws SystemException {
		interviewSchedule = toUnwrappedModel(interviewSchedule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(interviewSchedule)) {
				interviewSchedule = (InterviewSchedule)session.get(InterviewScheduleImpl.class,
						interviewSchedule.getPrimaryKeyObj());
			}

			if (interviewSchedule != null) {
				session.delete(interviewSchedule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (interviewSchedule != null) {
			clearCache(interviewSchedule);
		}

		return interviewSchedule;
	}

	@Override
	public InterviewSchedule updateImpl(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule)
		throws SystemException {
		interviewSchedule = toUnwrappedModel(interviewSchedule);

		boolean isNew = interviewSchedule.isNew();

		InterviewScheduleModelImpl interviewScheduleModelImpl = (InterviewScheduleModelImpl)interviewSchedule;

		Session session = null;

		try {
			session = openSession();

			if (interviewSchedule.isNew()) {
				session.save(interviewSchedule);

				interviewSchedule.setNew(false);
			}
			else {
				session.merge(interviewSchedule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !InterviewScheduleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((interviewScheduleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCYCANDIDATE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						interviewScheduleModelImpl.getOriginalVacancyCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCYCANDIDATE,
					args);

				args = new Object[] {
						interviewScheduleModelImpl.getVacancyCandidateId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_VACANCYCANDIDATE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VACANCYCANDIDATE,
					args);
			}
		}

		EntityCacheUtil.putResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
			InterviewScheduleImpl.class, interviewSchedule.getPrimaryKey(),
			interviewSchedule);

		clearUniqueFindersCache(interviewSchedule);
		cacheUniqueFindersCache(interviewSchedule);

		return interviewSchedule;
	}

	protected InterviewSchedule toUnwrappedModel(
		InterviewSchedule interviewSchedule) {
		if (interviewSchedule instanceof InterviewScheduleImpl) {
			return interviewSchedule;
		}

		InterviewScheduleImpl interviewScheduleImpl = new InterviewScheduleImpl();

		interviewScheduleImpl.setNew(interviewSchedule.isNew());
		interviewScheduleImpl.setPrimaryKey(interviewSchedule.getPrimaryKey());

		interviewScheduleImpl.setInterviewScheduleId(interviewSchedule.getInterviewScheduleId());
		interviewScheduleImpl.setVacancyCandidateId(interviewSchedule.getVacancyCandidateId());
		interviewScheduleImpl.setInterviewId(interviewSchedule.getInterviewId());
		interviewScheduleImpl.setInterviewDate(interviewSchedule.getInterviewDate());
		interviewScheduleImpl.setInterviewTime(interviewSchedule.getInterviewTime());
		interviewScheduleImpl.setStatus(interviewSchedule.getStatus());
		interviewScheduleImpl.setGroupId(interviewSchedule.getGroupId());
		interviewScheduleImpl.setCompanyId(interviewSchedule.getCompanyId());
		interviewScheduleImpl.setUserId(interviewSchedule.getUserId());
		interviewScheduleImpl.setUserName(interviewSchedule.getUserName());
		interviewScheduleImpl.setCreateDate(interviewSchedule.getCreateDate());
		interviewScheduleImpl.setModifiedDate(interviewSchedule.getModifiedDate());

		return interviewScheduleImpl;
	}

	/**
	 * Returns the interview schedule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview schedule
	 * @return the interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchInterviewScheduleException, SystemException {
		InterviewSchedule interviewSchedule = fetchByPrimaryKey(primaryKey);

		if (interviewSchedule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchInterviewScheduleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return interviewSchedule;
	}

	/**
	 * Returns the interview schedule with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException} if it could not be found.
	 *
	 * @param interviewScheduleId the primary key of the interview schedule
	 * @return the interview schedule
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule findByPrimaryKey(long interviewScheduleId)
		throws NoSuchInterviewScheduleException, SystemException {
		return findByPrimaryKey((Serializable)interviewScheduleId);
	}

	/**
	 * Returns the interview schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the interview schedule
	 * @return the interview schedule, or <code>null</code> if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		InterviewSchedule interviewSchedule = (InterviewSchedule)EntityCacheUtil.getResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
				InterviewScheduleImpl.class, primaryKey);

		if (interviewSchedule == _nullInterviewSchedule) {
			return null;
		}

		if (interviewSchedule == null) {
			Session session = null;

			try {
				session = openSession();

				interviewSchedule = (InterviewSchedule)session.get(InterviewScheduleImpl.class,
						primaryKey);

				if (interviewSchedule != null) {
					cacheResult(interviewSchedule);
				}
				else {
					EntityCacheUtil.putResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
						InterviewScheduleImpl.class, primaryKey,
						_nullInterviewSchedule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(InterviewScheduleModelImpl.ENTITY_CACHE_ENABLED,
					InterviewScheduleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return interviewSchedule;
	}

	/**
	 * Returns the interview schedule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param interviewScheduleId the primary key of the interview schedule
	 * @return the interview schedule, or <code>null</code> if a interview schedule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public InterviewSchedule fetchByPrimaryKey(long interviewScheduleId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)interviewScheduleId);
	}

	/**
	 * Returns all the interview schedules.
	 *
	 * @return the interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InterviewSchedule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the interview schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview schedules
	 * @param end the upper bound of the range of interview schedules (not inclusive)
	 * @return the range of interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InterviewSchedule> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the interview schedules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of interview schedules
	 * @param end the upper bound of the range of interview schedules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of interview schedules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<InterviewSchedule> findAll(int start, int end,
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

		List<InterviewSchedule> list = (List<InterviewSchedule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_INTERVIEWSCHEDULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_INTERVIEWSCHEDULE;

				if (pagination) {
					sql = sql.concat(InterviewScheduleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<InterviewSchedule>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<InterviewSchedule>(list);
				}
				else {
					list = (List<InterviewSchedule>)QueryUtil.list(q,
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
	 * Removes all the interview schedules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (InterviewSchedule interviewSchedule : findAll()) {
			remove(interviewSchedule);
		}
	}

	/**
	 * Returns the number of interview schedules.
	 *
	 * @return the number of interview schedules
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

				Query q = session.createQuery(_SQL_COUNT_INTERVIEWSCHEDULE);

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
	 * Initializes the interview schedule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.InterviewSchedule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<InterviewSchedule>> listenersList = new ArrayList<ModelListener<InterviewSchedule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<InterviewSchedule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(InterviewScheduleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_INTERVIEWSCHEDULE = "SELECT interviewSchedule FROM InterviewSchedule interviewSchedule";
	private static final String _SQL_SELECT_INTERVIEWSCHEDULE_WHERE = "SELECT interviewSchedule FROM InterviewSchedule interviewSchedule WHERE ";
	private static final String _SQL_COUNT_INTERVIEWSCHEDULE = "SELECT COUNT(interviewSchedule) FROM InterviewSchedule interviewSchedule";
	private static final String _SQL_COUNT_INTERVIEWSCHEDULE_WHERE = "SELECT COUNT(interviewSchedule) FROM InterviewSchedule interviewSchedule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "interviewSchedule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No InterviewSchedule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No InterviewSchedule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(InterviewSchedulePersistenceImpl.class);
	private static InterviewSchedule _nullInterviewSchedule = new InterviewScheduleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<InterviewSchedule> toCacheModel() {
				return _nullInterviewScheduleCacheModel;
			}
		};

	private static CacheModel<InterviewSchedule> _nullInterviewScheduleCacheModel =
		new CacheModel<InterviewSchedule>() {
			@Override
			public InterviewSchedule toEntityModel() {
				return _nullInterviewSchedule;
			}
		};
}