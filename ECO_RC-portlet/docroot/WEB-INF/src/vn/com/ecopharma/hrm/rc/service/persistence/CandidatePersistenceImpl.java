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

import vn.com.ecopharma.hrm.rc.NoSuchCandidateException;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.impl.CandidateImpl;
import vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the candidate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CandidatePersistence
 * @see CandidateUtil
 * @generated
 */
public class CandidatePersistenceImpl extends BasePersistenceImpl<Candidate>
	implements CandidatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CandidateUtil} to access the candidate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CandidateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmailAddress",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS =
		new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmailAddress",
			new String[] { String.class.getName() },
			CandidateModelImpl.EMAILADDRESS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress",
			new String[] { String.class.getName() });

	/**
	 * Returns all the candidates where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByEmailAddress(String emailAddress)
		throws SystemException {
		return findByEmailAddress(emailAddress, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidates where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByEmailAddress(String emailAddress, int start,
		int end) throws SystemException {
		return findByEmailAddress(emailAddress, start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidates where emailAddress = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param emailAddress the email address
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findByEmailAddress(String emailAddress, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] { emailAddress };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAILADDRESS;
			finderArgs = new Object[] {
					emailAddress,
					
					start, end, orderByComparator
				};
		}

		List<Candidate> list = (List<Candidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Candidate candidate : list) {
				if (!Validator.equals(emailAddress, candidate.getEmailAddress())) {
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

			query.append(_SQL_SELECT_CANDIDATE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CandidateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
				}

				if (!pagination) {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Candidate>(list);
				}
				else {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first candidate in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByEmailAddress_First(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByEmailAddress_First(emailAddress,
				orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the first candidate in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByEmailAddress_First(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		List<Candidate> list = findByEmailAddress(emailAddress, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last candidate in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByEmailAddress_Last(String emailAddress,
		OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByEmailAddress_Last(emailAddress,
				orderByComparator);

		if (candidate != null) {
			return candidate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("emailAddress=");
		msg.append(emailAddress);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCandidateException(msg.toString());
	}

	/**
	 * Returns the last candidate in the ordered set where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByEmailAddress_Last(String emailAddress,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmailAddress(emailAddress);

		if (count == 0) {
			return null;
		}

		List<Candidate> list = findByEmailAddress(emailAddress, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the candidates before and after the current candidate in the ordered set where emailAddress = &#63;.
	 *
	 * @param candidateId the primary key of the current candidate
	 * @param emailAddress the email address
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate[] findByEmailAddress_PrevAndNext(long candidateId,
		String emailAddress, OrderByComparator orderByComparator)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = findByPrimaryKey(candidateId);

		Session session = null;

		try {
			session = openSession();

			Candidate[] array = new CandidateImpl[3];

			array[0] = getByEmailAddress_PrevAndNext(session, candidate,
					emailAddress, orderByComparator, true);

			array[1] = candidate;

			array[2] = getByEmailAddress_PrevAndNext(session, candidate,
					emailAddress, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Candidate getByEmailAddress_PrevAndNext(Session session,
		Candidate candidate, String emailAddress,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CANDIDATE_WHERE);

		boolean bindEmailAddress = false;

		if (emailAddress == null) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
		}
		else if (emailAddress.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
		}
		else {
			bindEmailAddress = true;

			query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
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
			query.append(CandidateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEmailAddress) {
			qPos.add(emailAddress);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(candidate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Candidate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the candidates where emailAddress = &#63; from the database.
	 *
	 * @param emailAddress the email address
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmailAddress(String emailAddress)
		throws SystemException {
		for (Candidate candidate : findByEmailAddress(emailAddress,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(candidate);
		}
	}

	/**
	 * Returns the number of candidates where emailAddress = &#63;.
	 *
	 * @param emailAddress the email address
	 * @return the number of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmailAddress(String emailAddress)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS;

		Object[] finderArgs = new Object[] { emailAddress };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATE_WHERE);

			boolean bindEmailAddress = false;

			if (emailAddress == null) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1);
			}
			else if (emailAddress.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				query.append(_FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEmailAddress) {
					qPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_1 = "candidate.emailAddress IS NULL";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_2 = "candidate.emailAddress = ?";
	private static final String _FINDER_COLUMN_EMAILADDRESS_EMAILADDRESS_3 = "(candidate.emailAddress IS NULL OR candidate.emailAddress = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_CONTACTNUMBER = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByContactNumber",
			new String[] { String.class.getName() },
			CandidateModelImpl.CONTACTNUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CONTACTNUMBER = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByContactNumber",
			new String[] { String.class.getName() });

	/**
	 * Returns the candidate where contactNumber = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateException} if it could not be found.
	 *
	 * @param contactNumber the contact number
	 * @return the matching candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByContactNumber(String contactNumber)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByContactNumber(contactNumber);

		if (candidate == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("contactNumber=");
			msg.append(contactNumber);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCandidateException(msg.toString());
		}

		return candidate;
	}

	/**
	 * Returns the candidate where contactNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @return the matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByContactNumber(String contactNumber)
		throws SystemException {
		return fetchByContactNumber(contactNumber, true);
	}

	/**
	 * Returns the candidate where contactNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param contactNumber the contact number
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByContactNumber(String contactNumber,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { contactNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
					finderArgs, this);
		}

		if (result instanceof Candidate) {
			Candidate candidate = (Candidate)result;

			if (!Validator.equals(contactNumber, candidate.getContactNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CANDIDATE_WHERE);

			boolean bindContactNumber = false;

			if (contactNumber == null) {
				query.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_1);
			}
			else if (contactNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3);
			}
			else {
				bindContactNumber = true;

				query.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContactNumber) {
					qPos.add(contactNumber);
				}

				List<Candidate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CandidatePersistenceImpl.fetchByContactNumber(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Candidate candidate = list.get(0);

					result = candidate;

					cacheResult(candidate);

					if ((candidate.getContactNumber() == null) ||
							!candidate.getContactNumber().equals(contactNumber)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
							finderArgs, candidate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
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
			return (Candidate)result;
		}
	}

	/**
	 * Removes the candidate where contactNumber = &#63; from the database.
	 *
	 * @param contactNumber the contact number
	 * @return the candidate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate removeByContactNumber(String contactNumber)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = findByContactNumber(contactNumber);

		return remove(candidate);
	}

	/**
	 * Returns the number of candidates where contactNumber = &#63;.
	 *
	 * @param contactNumber the contact number
	 * @return the number of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByContactNumber(String contactNumber)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CONTACTNUMBER;

		Object[] finderArgs = new Object[] { contactNumber };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATE_WHERE);

			boolean bindContactNumber = false;

			if (contactNumber == null) {
				query.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_1);
			}
			else if (contactNumber.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3);
			}
			else {
				bindContactNumber = true;

				query.append(_FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindContactNumber) {
					qPos.add(contactNumber);
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

	private static final String _FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_1 = "candidate.contactNumber IS NULL";
	private static final String _FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_2 = "candidate.contactNumber = ?";
	private static final String _FINDER_COLUMN_CONTACTNUMBER_CONTACTNUMBER_3 = "(candidate.contactNumber IS NULL OR candidate.contactNumber = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_IDENTITYCARDNO = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, CandidateImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIdentityCardNo",
			new String[] { String.class.getName() },
			CandidateModelImpl.IDENTITYCARDNO_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_IDENTITYCARDNO = new FinderPath(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIdentityCardNo",
			new String[] { String.class.getName() });

	/**
	 * Returns the candidate where identityCardNo = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateException} if it could not be found.
	 *
	 * @param identityCardNo the identity card no
	 * @return the matching candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByIdentityCardNo(String identityCardNo)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByIdentityCardNo(identityCardNo);

		if (candidate == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("identityCardNo=");
			msg.append(identityCardNo);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCandidateException(msg.toString());
		}

		return candidate;
	}

	/**
	 * Returns the candidate where identityCardNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param identityCardNo the identity card no
	 * @return the matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByIdentityCardNo(String identityCardNo)
		throws SystemException {
		return fetchByIdentityCardNo(identityCardNo, true);
	}

	/**
	 * Returns the candidate where identityCardNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param identityCardNo the identity card no
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching candidate, or <code>null</code> if a matching candidate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByIdentityCardNo(String identityCardNo,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { identityCardNo };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
					finderArgs, this);
		}

		if (result instanceof Candidate) {
			Candidate candidate = (Candidate)result;

			if (!Validator.equals(identityCardNo, candidate.getIdentityCardNo())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CANDIDATE_WHERE);

			boolean bindIdentityCardNo = false;

			if (identityCardNo == null) {
				query.append(_FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_1);
			}
			else if (identityCardNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_3);
			}
			else {
				bindIdentityCardNo = true;

				query.append(_FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdentityCardNo) {
					qPos.add(identityCardNo);
				}

				List<Candidate> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CandidatePersistenceImpl.fetchByIdentityCardNo(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Candidate candidate = list.get(0);

					result = candidate;

					cacheResult(candidate);

					if ((candidate.getIdentityCardNo() == null) ||
							!candidate.getIdentityCardNo().equals(identityCardNo)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
							finderArgs, candidate);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
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
			return (Candidate)result;
		}
	}

	/**
	 * Removes the candidate where identityCardNo = &#63; from the database.
	 *
	 * @param identityCardNo the identity card no
	 * @return the candidate that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate removeByIdentityCardNo(String identityCardNo)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = findByIdentityCardNo(identityCardNo);

		return remove(candidate);
	}

	/**
	 * Returns the number of candidates where identityCardNo = &#63;.
	 *
	 * @param identityCardNo the identity card no
	 * @return the number of matching candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByIdentityCardNo(String identityCardNo)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_IDENTITYCARDNO;

		Object[] finderArgs = new Object[] { identityCardNo };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CANDIDATE_WHERE);

			boolean bindIdentityCardNo = false;

			if (identityCardNo == null) {
				query.append(_FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_1);
			}
			else if (identityCardNo.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_3);
			}
			else {
				bindIdentityCardNo = true;

				query.append(_FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindIdentityCardNo) {
					qPos.add(identityCardNo);
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

	private static final String _FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_1 = "candidate.identityCardNo IS NULL";
	private static final String _FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_2 = "candidate.identityCardNo = ?";
	private static final String _FINDER_COLUMN_IDENTITYCARDNO_IDENTITYCARDNO_3 = "(candidate.identityCardNo IS NULL OR candidate.identityCardNo = '')";

	public CandidatePersistenceImpl() {
		setModelClass(Candidate.class);
	}

	/**
	 * Caches the candidate in the entity cache if it is enabled.
	 *
	 * @param candidate the candidate
	 */
	@Override
	public void cacheResult(Candidate candidate) {
		EntityCacheUtil.putResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateImpl.class, candidate.getPrimaryKey(), candidate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
			new Object[] { candidate.getContactNumber() }, candidate);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
			new Object[] { candidate.getIdentityCardNo() }, candidate);

		candidate.resetOriginalValues();
	}

	/**
	 * Caches the candidates in the entity cache if it is enabled.
	 *
	 * @param candidates the candidates
	 */
	@Override
	public void cacheResult(List<Candidate> candidates) {
		for (Candidate candidate : candidates) {
			if (EntityCacheUtil.getResult(
						CandidateModelImpl.ENTITY_CACHE_ENABLED,
						CandidateImpl.class, candidate.getPrimaryKey()) == null) {
				cacheResult(candidate);
			}
			else {
				candidate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all candidates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CandidateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CandidateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the candidate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Candidate candidate) {
		EntityCacheUtil.removeResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateImpl.class, candidate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(candidate);
	}

	@Override
	public void clearCache(List<Candidate> candidates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Candidate candidate : candidates) {
			EntityCacheUtil.removeResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
				CandidateImpl.class, candidate.getPrimaryKey());

			clearUniqueFindersCache(candidate);
		}
	}

	protected void cacheUniqueFindersCache(Candidate candidate) {
		if (candidate.isNew()) {
			Object[] args = new Object[] { candidate.getContactNumber() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTNUMBER, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER, args,
				candidate);

			args = new Object[] { candidate.getIdentityCardNo() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDENTITYCARDNO,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
				args, candidate);
		}
		else {
			CandidateModelImpl candidateModelImpl = (CandidateModelImpl)candidate;

			if ((candidateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CONTACTNUMBER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { candidate.getContactNumber() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONTACTNUMBER,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
					args, candidate);
			}

			if ((candidateModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_IDENTITYCARDNO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { candidate.getIdentityCardNo() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_IDENTITYCARDNO,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
					args, candidate);
			}
		}
	}

	protected void clearUniqueFindersCache(Candidate candidate) {
		CandidateModelImpl candidateModelImpl = (CandidateModelImpl)candidate;

		Object[] args = new Object[] { candidate.getContactNumber() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTNUMBER, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER, args);

		if ((candidateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CONTACTNUMBER.getColumnBitmask()) != 0) {
			args = new Object[] { candidateModelImpl.getOriginalContactNumber() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONTACTNUMBER,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CONTACTNUMBER,
				args);
		}

		args = new Object[] { candidate.getIdentityCardNo() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDENTITYCARDNO, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO, args);

		if ((candidateModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_IDENTITYCARDNO.getColumnBitmask()) != 0) {
			args = new Object[] { candidateModelImpl.getOriginalIdentityCardNo() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_IDENTITYCARDNO,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_IDENTITYCARDNO,
				args);
		}
	}

	/**
	 * Creates a new candidate with the primary key. Does not add the candidate to the database.
	 *
	 * @param candidateId the primary key for the new candidate
	 * @return the new candidate
	 */
	@Override
	public Candidate create(long candidateId) {
		Candidate candidate = new CandidateImpl();

		candidate.setNew(true);
		candidate.setPrimaryKey(candidateId);

		return candidate;
	}

	/**
	 * Removes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate remove(long candidateId)
		throws NoSuchCandidateException, SystemException {
		return remove((Serializable)candidateId);
	}

	/**
	 * Removes the candidate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the candidate
	 * @return the candidate that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate remove(Serializable primaryKey)
		throws NoSuchCandidateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Candidate candidate = (Candidate)session.get(CandidateImpl.class,
					primaryKey);

			if (candidate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(candidate);
		}
		catch (NoSuchCandidateException nsee) {
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
	protected Candidate removeImpl(Candidate candidate)
		throws SystemException {
		candidate = toUnwrappedModel(candidate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(candidate)) {
				candidate = (Candidate)session.get(CandidateImpl.class,
						candidate.getPrimaryKeyObj());
			}

			if (candidate != null) {
				session.delete(candidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (candidate != null) {
			clearCache(candidate);
		}

		return candidate;
	}

	@Override
	public Candidate updateImpl(
		vn.com.ecopharma.hrm.rc.model.Candidate candidate)
		throws SystemException {
		candidate = toUnwrappedModel(candidate);

		boolean isNew = candidate.isNew();

		CandidateModelImpl candidateModelImpl = (CandidateModelImpl)candidate;

		Session session = null;

		try {
			session = openSession();

			if (candidate.isNew()) {
				session.save(candidate);

				candidate.setNew(false);
			}
			else {
				session.merge(candidate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CandidateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((candidateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						candidateModelImpl.getOriginalEmailAddress()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);

				args = new Object[] { candidateModelImpl.getEmailAddress() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAILADDRESS,
					args);
			}
		}

		EntityCacheUtil.putResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
			CandidateImpl.class, candidate.getPrimaryKey(), candidate);

		clearUniqueFindersCache(candidate);
		cacheUniqueFindersCache(candidate);

		return candidate;
	}

	protected Candidate toUnwrappedModel(Candidate candidate) {
		if (candidate instanceof CandidateImpl) {
			return candidate;
		}

		CandidateImpl candidateImpl = new CandidateImpl();

		candidateImpl.setNew(candidate.isNew());
		candidateImpl.setPrimaryKey(candidate.getPrimaryKey());

		candidateImpl.setCandidateId(candidate.getCandidateId());
		candidateImpl.setCandidateCode(candidate.getCandidateCode());
		candidateImpl.setFullName(candidate.getFullName());
		candidateImpl.setEmailAddress(candidate.getEmailAddress());
		candidateImpl.setContactNumber(candidate.getContactNumber());
		candidateImpl.setDateOfBirth(candidate.getDateOfBirth());
		candidateImpl.setPlaceOfBirth(candidate.getPlaceOfBirth());
		candidateImpl.setGender(candidate.getGender());
		candidateImpl.setIdentityCardNo(candidate.getIdentityCardNo());
		candidateImpl.setIssuedDate(candidate.getIssuedDate());
		candidateImpl.setIssuedPlace(candidate.getIssuedPlace());
		candidateImpl.setMaritalStatus(candidate.getMaritalStatus());
		candidateImpl.setNumberOfChild(candidate.getNumberOfChild());
		candidateImpl.setNationalityId(candidate.getNationalityId());
		candidateImpl.setEthnic(candidate.getEthnic());
		candidateImpl.setReligion(candidate.getReligion());
		candidateImpl.setApplicationDate(candidate.getApplicationDate());
		candidateImpl.setStatus(candidate.getStatus());
		candidateImpl.setDeleted(candidate.isDeleted());
		candidateImpl.setGroupId(candidate.getGroupId());
		candidateImpl.setCompanyId(candidate.getCompanyId());
		candidateImpl.setUserId(candidate.getUserId());
		candidateImpl.setUserName(candidate.getUserName());
		candidateImpl.setCreateDate(candidate.getCreateDate());
		candidateImpl.setModifiedDate(candidate.getModifiedDate());
		candidateImpl.setDescription(candidate.getDescription());

		return candidateImpl;
	}

	/**
	 * Returns the candidate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate
	 * @return the candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCandidateException, SystemException {
		Candidate candidate = fetchByPrimaryKey(primaryKey);

		if (candidate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCandidateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return candidate;
	}

	/**
	 * Returns the candidate with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchCandidateException} if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchCandidateException if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate findByPrimaryKey(long candidateId)
		throws NoSuchCandidateException, SystemException {
		return findByPrimaryKey((Serializable)candidateId);
	}

	/**
	 * Returns the candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the candidate
	 * @return the candidate, or <code>null</code> if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Candidate candidate = (Candidate)EntityCacheUtil.getResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
				CandidateImpl.class, primaryKey);

		if (candidate == _nullCandidate) {
			return null;
		}

		if (candidate == null) {
			Session session = null;

			try {
				session = openSession();

				candidate = (Candidate)session.get(CandidateImpl.class,
						primaryKey);

				if (candidate != null) {
					cacheResult(candidate);
				}
				else {
					EntityCacheUtil.putResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
						CandidateImpl.class, primaryKey, _nullCandidate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CandidateModelImpl.ENTITY_CACHE_ENABLED,
					CandidateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return candidate;
	}

	/**
	 * Returns the candidate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param candidateId the primary key of the candidate
	 * @return the candidate, or <code>null</code> if a candidate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Candidate fetchByPrimaryKey(long candidateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)candidateId);
	}

	/**
	 * Returns all the candidates.
	 *
	 * @return the candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @return the range of candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the candidates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CandidateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of candidates
	 * @param end the upper bound of the range of candidates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of candidates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Candidate> findAll(int start, int end,
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

		List<Candidate> list = (List<Candidate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CANDIDATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CANDIDATE;

				if (pagination) {
					sql = sql.concat(CandidateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Candidate>(list);
				}
				else {
					list = (List<Candidate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the candidates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Candidate candidate : findAll()) {
			remove(candidate);
		}
	}

	/**
	 * Returns the number of candidates.
	 *
	 * @return the number of candidates
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

				Query q = session.createQuery(_SQL_COUNT_CANDIDATE);

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
	 * Initializes the candidate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.Candidate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Candidate>> listenersList = new ArrayList<ModelListener<Candidate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Candidate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CandidateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CANDIDATE = "SELECT candidate FROM Candidate candidate";
	private static final String _SQL_SELECT_CANDIDATE_WHERE = "SELECT candidate FROM Candidate candidate WHERE ";
	private static final String _SQL_COUNT_CANDIDATE = "SELECT COUNT(candidate) FROM Candidate candidate";
	private static final String _SQL_COUNT_CANDIDATE_WHERE = "SELECT COUNT(candidate) FROM Candidate candidate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "candidate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Candidate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Candidate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CandidatePersistenceImpl.class);
	private static Candidate _nullCandidate = new CandidateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Candidate> toCacheModel() {
				return _nullCandidateCacheModel;
			}
		};

	private static CacheModel<Candidate> _nullCandidateCacheModel = new CacheModel<Candidate>() {
			@Override
			public Candidate toEntityModel() {
				return _nullCandidate;
			}
		};
}