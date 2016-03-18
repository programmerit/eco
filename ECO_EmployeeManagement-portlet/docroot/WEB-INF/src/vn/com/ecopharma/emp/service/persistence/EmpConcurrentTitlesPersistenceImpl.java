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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException;
import vn.com.ecopharma.emp.model.EmpConcurrentTitles;
import vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesImpl;
import vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp concurrent titles service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpConcurrentTitlesPersistence
 * @see EmpConcurrentTitlesUtil
 * @generated
 */
public class EmpConcurrentTitlesPersistenceImpl extends BasePersistenceImpl<EmpConcurrentTitles>
	implements EmpConcurrentTitlesPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpConcurrentTitlesUtil} to access the emp concurrent titles persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpConcurrentTitlesImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPTITLES = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmpTitles",
			new String[] { Long.class.getName(), Long.class.getName() },
			EmpConcurrentTitlesModelImpl.EMPID_COLUMN_BITMASK |
			EmpConcurrentTitlesModelImpl.TITLESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPTITLES = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpTitles",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the emp concurrent titles where empId = &#63; and titlesId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException} if it could not be found.
	 *
	 * @param empId the emp ID
	 * @param titlesId the titles ID
	 * @return the matching emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByEmpTitles(long empId, long titlesId)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = fetchByEmpTitles(empId,
				titlesId);

		if (empConcurrentTitles == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empId=");
			msg.append(empId);

			msg.append(", titlesId=");
			msg.append(titlesId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpConcurrentTitlesException(msg.toString());
		}

		return empConcurrentTitles;
	}

	/**
	 * Returns the emp concurrent titles where empId = &#63; and titlesId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empId the emp ID
	 * @param titlesId the titles ID
	 * @return the matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByEmpTitles(long empId, long titlesId)
		throws SystemException {
		return fetchByEmpTitles(empId, titlesId, true);
	}

	/**
	 * Returns the emp concurrent titles where empId = &#63; and titlesId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empId the emp ID
	 * @param titlesId the titles ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByEmpTitles(long empId, long titlesId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { empId, titlesId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPTITLES,
					finderArgs, this);
		}

		if (result instanceof EmpConcurrentTitles) {
			EmpConcurrentTitles empConcurrentTitles = (EmpConcurrentTitles)result;

			if ((empId != empConcurrentTitles.getEmpId()) ||
					(titlesId != empConcurrentTitles.getTitlesId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EMPCONCURRENTTITLES_WHERE);

			query.append(_FINDER_COLUMN_EMPTITLES_EMPID_2);

			query.append(_FINDER_COLUMN_EMPTITLES_TITLESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				qPos.add(titlesId);

				List<EmpConcurrentTitles> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPTITLES,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpConcurrentTitlesPersistenceImpl.fetchByEmpTitles(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmpConcurrentTitles empConcurrentTitles = list.get(0);

					result = empConcurrentTitles;

					cacheResult(empConcurrentTitles);

					if ((empConcurrentTitles.getEmpId() != empId) ||
							(empConcurrentTitles.getTitlesId() != titlesId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPTITLES,
							finderArgs, empConcurrentTitles);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPTITLES,
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
			return (EmpConcurrentTitles)result;
		}
	}

	/**
	 * Removes the emp concurrent titles where empId = &#63; and titlesId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @param titlesId the titles ID
	 * @return the emp concurrent titles that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles removeByEmpTitles(long empId, long titlesId)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = findByEmpTitles(empId,
				titlesId);

		return remove(empConcurrentTitles);
	}

	/**
	 * Returns the number of emp concurrent titleses where empId = &#63; and titlesId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param titlesId the titles ID
	 * @return the number of matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmpTitles(long empId, long titlesId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPTITLES;

		Object[] finderArgs = new Object[] { empId, titlesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPCONCURRENTTITLES_WHERE);

			query.append(_FINDER_COLUMN_EMPTITLES_EMPID_2);

			query.append(_FINDER_COLUMN_EMPTITLES_TITLESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				qPos.add(titlesId);

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

	private static final String _FINDER_COLUMN_EMPTITLES_EMPID_2 = "empConcurrentTitles.empId = ? AND ";
	private static final String _FINDER_COLUMN_EMPTITLES_TITLESID_2 = "empConcurrentTitles.titlesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMP = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmp",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmp",
			new String[] { Long.class.getName() },
			EmpConcurrentTitlesModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMP = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmp",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp concurrent titleses where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findByEmp(long empId)
		throws SystemException {
		return findByEmp(empId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp concurrent titleses where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of emp concurrent titleses
	 * @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	 * @return the range of matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findByEmp(long empId, int start, int end)
		throws SystemException {
		return findByEmp(empId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp concurrent titleses where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of emp concurrent titleses
	 * @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findByEmp(long empId, int start, int end,
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

		List<EmpConcurrentTitles> list = (List<EmpConcurrentTitles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpConcurrentTitles empConcurrentTitles : list) {
				if ((empId != empConcurrentTitles.getEmpId())) {
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

			query.append(_SQL_SELECT_EMPCONCURRENTTITLES_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpConcurrentTitlesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (!pagination) {
					list = (List<EmpConcurrentTitles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpConcurrentTitles>(list);
				}
				else {
					list = (List<EmpConcurrentTitles>)QueryUtil.list(q,
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
	 * Returns the first emp concurrent titles in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByEmp_First(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = fetchByEmp_First(empId,
				orderByComparator);

		if (empConcurrentTitles != null) {
			return empConcurrentTitles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpConcurrentTitlesException(msg.toString());
	}

	/**
	 * Returns the first emp concurrent titles in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByEmp_First(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpConcurrentTitles> list = findByEmp(empId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp concurrent titles in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByEmp_Last(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = fetchByEmp_Last(empId,
				orderByComparator);

		if (empConcurrentTitles != null) {
			return empConcurrentTitles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpConcurrentTitlesException(msg.toString());
	}

	/**
	 * Returns the last emp concurrent titles in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByEmp_Last(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmp(empId);

		if (count == 0) {
			return null;
		}

		List<EmpConcurrentTitles> list = findByEmp(empId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp concurrent titleses before and after the current emp concurrent titles in the ordered set where empId = &#63;.
	 *
	 * @param empConcurrentTitlesId the primary key of the current emp concurrent titles
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles[] findByEmp_PrevAndNext(
		long empConcurrentTitlesId, long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = findByPrimaryKey(empConcurrentTitlesId);

		Session session = null;

		try {
			session = openSession();

			EmpConcurrentTitles[] array = new EmpConcurrentTitlesImpl[3];

			array[0] = getByEmp_PrevAndNext(session, empConcurrentTitles,
					empId, orderByComparator, true);

			array[1] = empConcurrentTitles;

			array[2] = getByEmp_PrevAndNext(session, empConcurrentTitles,
					empId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpConcurrentTitles getByEmp_PrevAndNext(Session session,
		EmpConcurrentTitles empConcurrentTitles, long empId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPCONCURRENTTITLES_WHERE);

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
			query.append(EmpConcurrentTitlesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empConcurrentTitles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpConcurrentTitles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp concurrent titleses where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmp(long empId) throws SystemException {
		for (EmpConcurrentTitles empConcurrentTitles : findByEmp(empId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empConcurrentTitles);
		}
	}

	/**
	 * Returns the number of emp concurrent titleses where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching emp concurrent titleses
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

			query.append(_SQL_COUNT_EMPCONCURRENTTITLES_WHERE);

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

	private static final String _FINDER_COLUMN_EMP_EMPID_2 = "empConcurrentTitles.empId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLES = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitles",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES =
		new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitles",
			new String[] { Long.class.getName() },
			EmpConcurrentTitlesModelImpl.TITLESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLES = new FinderPath(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitles",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp concurrent titleses where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @return the matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findByTitles(long titlesId)
		throws SystemException {
		return findByTitles(titlesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp concurrent titleses where titlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param start the lower bound of the range of emp concurrent titleses
	 * @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	 * @return the range of matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findByTitles(long titlesId, int start,
		int end) throws SystemException {
		return findByTitles(titlesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp concurrent titleses where titlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param start the lower bound of the range of emp concurrent titleses
	 * @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findByTitles(long titlesId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES;
			finderArgs = new Object[] { titlesId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLES;
			finderArgs = new Object[] { titlesId, start, end, orderByComparator };
		}

		List<EmpConcurrentTitles> list = (List<EmpConcurrentTitles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpConcurrentTitles empConcurrentTitles : list) {
				if ((titlesId != empConcurrentTitles.getTitlesId())) {
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

			query.append(_SQL_SELECT_EMPCONCURRENTTITLES_WHERE);

			query.append(_FINDER_COLUMN_TITLES_TITLESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpConcurrentTitlesModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				if (!pagination) {
					list = (List<EmpConcurrentTitles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpConcurrentTitles>(list);
				}
				else {
					list = (List<EmpConcurrentTitles>)QueryUtil.list(q,
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
	 * Returns the first emp concurrent titles in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByTitles_First(long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = fetchByTitles_First(titlesId,
				orderByComparator);

		if (empConcurrentTitles != null) {
			return empConcurrentTitles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpConcurrentTitlesException(msg.toString());
	}

	/**
	 * Returns the first emp concurrent titles in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByTitles_First(long titlesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpConcurrentTitles> list = findByTitles(titlesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp concurrent titles in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByTitles_Last(long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = fetchByTitles_Last(titlesId,
				orderByComparator);

		if (empConcurrentTitles != null) {
			return empConcurrentTitles;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpConcurrentTitlesException(msg.toString());
	}

	/**
	 * Returns the last emp concurrent titles in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp concurrent titles, or <code>null</code> if a matching emp concurrent titles could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByTitles_Last(long titlesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitles(titlesId);

		if (count == 0) {
			return null;
		}

		List<EmpConcurrentTitles> list = findByTitles(titlesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp concurrent titleses before and after the current emp concurrent titles in the ordered set where titlesId = &#63;.
	 *
	 * @param empConcurrentTitlesId the primary key of the current emp concurrent titles
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles[] findByTitles_PrevAndNext(
		long empConcurrentTitlesId, long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = findByPrimaryKey(empConcurrentTitlesId);

		Session session = null;

		try {
			session = openSession();

			EmpConcurrentTitles[] array = new EmpConcurrentTitlesImpl[3];

			array[0] = getByTitles_PrevAndNext(session, empConcurrentTitles,
					titlesId, orderByComparator, true);

			array[1] = empConcurrentTitles;

			array[2] = getByTitles_PrevAndNext(session, empConcurrentTitles,
					titlesId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected EmpConcurrentTitles getByTitles_PrevAndNext(Session session,
		EmpConcurrentTitles empConcurrentTitles, long titlesId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPCONCURRENTTITLES_WHERE);

		query.append(_FINDER_COLUMN_TITLES_TITLESID_2);

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
			query.append(EmpConcurrentTitlesModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titlesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empConcurrentTitles);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpConcurrentTitles> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp concurrent titleses where titlesId = &#63; from the database.
	 *
	 * @param titlesId the titles ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitles(long titlesId) throws SystemException {
		for (EmpConcurrentTitles empConcurrentTitles : findByTitles(titlesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empConcurrentTitles);
		}
	}

	/**
	 * Returns the number of emp concurrent titleses where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @return the number of matching emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitles(long titlesId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLES;

		Object[] finderArgs = new Object[] { titlesId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPCONCURRENTTITLES_WHERE);

			query.append(_FINDER_COLUMN_TITLES_TITLESID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

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

	private static final String _FINDER_COLUMN_TITLES_TITLESID_2 = "empConcurrentTitles.titlesId = ?";

	public EmpConcurrentTitlesPersistenceImpl() {
		setModelClass(EmpConcurrentTitles.class);
	}

	/**
	 * Caches the emp concurrent titles in the entity cache if it is enabled.
	 *
	 * @param empConcurrentTitles the emp concurrent titles
	 */
	@Override
	public void cacheResult(EmpConcurrentTitles empConcurrentTitles) {
		EntityCacheUtil.putResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class, empConcurrentTitles.getPrimaryKey(),
			empConcurrentTitles);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPTITLES,
			new Object[] {
				empConcurrentTitles.getEmpId(),
				empConcurrentTitles.getTitlesId()
			}, empConcurrentTitles);

		empConcurrentTitles.resetOriginalValues();
	}

	/**
	 * Caches the emp concurrent titleses in the entity cache if it is enabled.
	 *
	 * @param empConcurrentTitleses the emp concurrent titleses
	 */
	@Override
	public void cacheResult(List<EmpConcurrentTitles> empConcurrentTitleses) {
		for (EmpConcurrentTitles empConcurrentTitles : empConcurrentTitleses) {
			if (EntityCacheUtil.getResult(
						EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
						EmpConcurrentTitlesImpl.class,
						empConcurrentTitles.getPrimaryKey()) == null) {
				cacheResult(empConcurrentTitles);
			}
			else {
				empConcurrentTitles.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp concurrent titleses.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpConcurrentTitlesImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpConcurrentTitlesImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp concurrent titles.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpConcurrentTitles empConcurrentTitles) {
		EntityCacheUtil.removeResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class, empConcurrentTitles.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(empConcurrentTitles);
	}

	@Override
	public void clearCache(List<EmpConcurrentTitles> empConcurrentTitleses) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpConcurrentTitles empConcurrentTitles : empConcurrentTitleses) {
			EntityCacheUtil.removeResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
				EmpConcurrentTitlesImpl.class,
				empConcurrentTitles.getPrimaryKey());

			clearUniqueFindersCache(empConcurrentTitles);
		}
	}

	protected void cacheUniqueFindersCache(
		EmpConcurrentTitles empConcurrentTitles) {
		if (empConcurrentTitles.isNew()) {
			Object[] args = new Object[] {
					empConcurrentTitles.getEmpId(),
					empConcurrentTitles.getTitlesId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPTITLES, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPTITLES, args,
				empConcurrentTitles);
		}
		else {
			EmpConcurrentTitlesModelImpl empConcurrentTitlesModelImpl = (EmpConcurrentTitlesModelImpl)empConcurrentTitles;

			if ((empConcurrentTitlesModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPTITLES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empConcurrentTitles.getEmpId(),
						empConcurrentTitles.getTitlesId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPTITLES, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPTITLES, args,
					empConcurrentTitles);
			}
		}
	}

	protected void clearUniqueFindersCache(
		EmpConcurrentTitles empConcurrentTitles) {
		EmpConcurrentTitlesModelImpl empConcurrentTitlesModelImpl = (EmpConcurrentTitlesModelImpl)empConcurrentTitles;

		Object[] args = new Object[] {
				empConcurrentTitles.getEmpId(),
				empConcurrentTitles.getTitlesId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPTITLES, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPTITLES, args);

		if ((empConcurrentTitlesModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPTITLES.getColumnBitmask()) != 0) {
			args = new Object[] {
					empConcurrentTitlesModelImpl.getOriginalEmpId(),
					empConcurrentTitlesModelImpl.getOriginalTitlesId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPTITLES, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPTITLES, args);
		}
	}

	/**
	 * Creates a new emp concurrent titles with the primary key. Does not add the emp concurrent titles to the database.
	 *
	 * @param empConcurrentTitlesId the primary key for the new emp concurrent titles
	 * @return the new emp concurrent titles
	 */
	@Override
	public EmpConcurrentTitles create(long empConcurrentTitlesId) {
		EmpConcurrentTitles empConcurrentTitles = new EmpConcurrentTitlesImpl();

		empConcurrentTitles.setNew(true);
		empConcurrentTitles.setPrimaryKey(empConcurrentTitlesId);

		return empConcurrentTitles;
	}

	/**
	 * Removes the emp concurrent titles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empConcurrentTitlesId the primary key of the emp concurrent titles
	 * @return the emp concurrent titles that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles remove(long empConcurrentTitlesId)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		return remove((Serializable)empConcurrentTitlesId);
	}

	/**
	 * Removes the emp concurrent titles with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp concurrent titles
	 * @return the emp concurrent titles that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles remove(Serializable primaryKey)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpConcurrentTitles empConcurrentTitles = (EmpConcurrentTitles)session.get(EmpConcurrentTitlesImpl.class,
					primaryKey);

			if (empConcurrentTitles == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpConcurrentTitlesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empConcurrentTitles);
		}
		catch (NoSuchEmpConcurrentTitlesException nsee) {
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
	protected EmpConcurrentTitles removeImpl(
		EmpConcurrentTitles empConcurrentTitles) throws SystemException {
		empConcurrentTitles = toUnwrappedModel(empConcurrentTitles);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empConcurrentTitles)) {
				empConcurrentTitles = (EmpConcurrentTitles)session.get(EmpConcurrentTitlesImpl.class,
						empConcurrentTitles.getPrimaryKeyObj());
			}

			if (empConcurrentTitles != null) {
				session.delete(empConcurrentTitles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empConcurrentTitles != null) {
			clearCache(empConcurrentTitles);
		}

		return empConcurrentTitles;
	}

	@Override
	public EmpConcurrentTitles updateImpl(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles)
		throws SystemException {
		empConcurrentTitles = toUnwrappedModel(empConcurrentTitles);

		boolean isNew = empConcurrentTitles.isNew();

		EmpConcurrentTitlesModelImpl empConcurrentTitlesModelImpl = (EmpConcurrentTitlesModelImpl)empConcurrentTitles;

		Session session = null;

		try {
			session = openSession();

			if (empConcurrentTitles.isNew()) {
				session.save(empConcurrentTitles);

				empConcurrentTitles.setNew(false);
			}
			else {
				session.merge(empConcurrentTitles);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpConcurrentTitlesModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empConcurrentTitlesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empConcurrentTitlesModelImpl.getOriginalEmpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);

				args = new Object[] { empConcurrentTitlesModelImpl.getEmpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);
			}

			if ((empConcurrentTitlesModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empConcurrentTitlesModelImpl.getOriginalTitlesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES,
					args);

				args = new Object[] { empConcurrentTitlesModelImpl.getTitlesId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
			EmpConcurrentTitlesImpl.class, empConcurrentTitles.getPrimaryKey(),
			empConcurrentTitles);

		clearUniqueFindersCache(empConcurrentTitles);
		cacheUniqueFindersCache(empConcurrentTitles);

		return empConcurrentTitles;
	}

	protected EmpConcurrentTitles toUnwrappedModel(
		EmpConcurrentTitles empConcurrentTitles) {
		if (empConcurrentTitles instanceof EmpConcurrentTitlesImpl) {
			return empConcurrentTitles;
		}

		EmpConcurrentTitlesImpl empConcurrentTitlesImpl = new EmpConcurrentTitlesImpl();

		empConcurrentTitlesImpl.setNew(empConcurrentTitles.isNew());
		empConcurrentTitlesImpl.setPrimaryKey(empConcurrentTitles.getPrimaryKey());

		empConcurrentTitlesImpl.setEmpConcurrentTitlesId(empConcurrentTitles.getEmpConcurrentTitlesId());
		empConcurrentTitlesImpl.setEmpId(empConcurrentTitles.getEmpId());
		empConcurrentTitlesImpl.setTitlesId(empConcurrentTitles.getTitlesId());
		empConcurrentTitlesImpl.setUnitGroupId(empConcurrentTitles.getUnitGroupId());
		empConcurrentTitlesImpl.setUnitId(empConcurrentTitles.getUnitId());
		empConcurrentTitlesImpl.setDepartmentId(empConcurrentTitles.getDepartmentId());
		empConcurrentTitlesImpl.setGroupId(empConcurrentTitles.getGroupId());
		empConcurrentTitlesImpl.setCompanyId(empConcurrentTitles.getCompanyId());
		empConcurrentTitlesImpl.setUserId(empConcurrentTitles.getUserId());
		empConcurrentTitlesImpl.setUserName(empConcurrentTitles.getUserName());
		empConcurrentTitlesImpl.setCreateDate(empConcurrentTitles.getCreateDate());
		empConcurrentTitlesImpl.setModifiedDate(empConcurrentTitles.getModifiedDate());

		return empConcurrentTitlesImpl;
	}

	/**
	 * Returns the emp concurrent titles with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp concurrent titles
	 * @return the emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		EmpConcurrentTitles empConcurrentTitles = fetchByPrimaryKey(primaryKey);

		if (empConcurrentTitles == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpConcurrentTitlesException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empConcurrentTitles;
	}

	/**
	 * Returns the emp concurrent titles with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException} if it could not be found.
	 *
	 * @param empConcurrentTitlesId the primary key of the emp concurrent titles
	 * @return the emp concurrent titles
	 * @throws vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles findByPrimaryKey(long empConcurrentTitlesId)
		throws NoSuchEmpConcurrentTitlesException, SystemException {
		return findByPrimaryKey((Serializable)empConcurrentTitlesId);
	}

	/**
	 * Returns the emp concurrent titles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp concurrent titles
	 * @return the emp concurrent titles, or <code>null</code> if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpConcurrentTitles empConcurrentTitles = (EmpConcurrentTitles)EntityCacheUtil.getResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
				EmpConcurrentTitlesImpl.class, primaryKey);

		if (empConcurrentTitles == _nullEmpConcurrentTitles) {
			return null;
		}

		if (empConcurrentTitles == null) {
			Session session = null;

			try {
				session = openSession();

				empConcurrentTitles = (EmpConcurrentTitles)session.get(EmpConcurrentTitlesImpl.class,
						primaryKey);

				if (empConcurrentTitles != null) {
					cacheResult(empConcurrentTitles);
				}
				else {
					EntityCacheUtil.putResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
						EmpConcurrentTitlesImpl.class, primaryKey,
						_nullEmpConcurrentTitles);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpConcurrentTitlesModelImpl.ENTITY_CACHE_ENABLED,
					EmpConcurrentTitlesImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empConcurrentTitles;
	}

	/**
	 * Returns the emp concurrent titles with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empConcurrentTitlesId the primary key of the emp concurrent titles
	 * @return the emp concurrent titles, or <code>null</code> if a emp concurrent titles with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpConcurrentTitles fetchByPrimaryKey(long empConcurrentTitlesId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empConcurrentTitlesId);
	}

	/**
	 * Returns all the emp concurrent titleses.
	 *
	 * @return the emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp concurrent titleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp concurrent titleses
	 * @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	 * @return the range of emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp concurrent titleses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp concurrent titleses
	 * @param end the upper bound of the range of emp concurrent titleses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp concurrent titleses
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpConcurrentTitles> findAll(int start, int end,
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

		List<EmpConcurrentTitles> list = (List<EmpConcurrentTitles>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPCONCURRENTTITLES);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPCONCURRENTTITLES;

				if (pagination) {
					sql = sql.concat(EmpConcurrentTitlesModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpConcurrentTitles>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpConcurrentTitles>(list);
				}
				else {
					list = (List<EmpConcurrentTitles>)QueryUtil.list(q,
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
	 * Removes all the emp concurrent titleses from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpConcurrentTitles empConcurrentTitles : findAll()) {
			remove(empConcurrentTitles);
		}
	}

	/**
	 * Returns the number of emp concurrent titleses.
	 *
	 * @return the number of emp concurrent titleses
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

				Query q = session.createQuery(_SQL_COUNT_EMPCONCURRENTTITLES);

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
	 * Initializes the emp concurrent titles persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpConcurrentTitles")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpConcurrentTitles>> listenersList = new ArrayList<ModelListener<EmpConcurrentTitles>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpConcurrentTitles>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpConcurrentTitlesImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPCONCURRENTTITLES = "SELECT empConcurrentTitles FROM EmpConcurrentTitles empConcurrentTitles";
	private static final String _SQL_SELECT_EMPCONCURRENTTITLES_WHERE = "SELECT empConcurrentTitles FROM EmpConcurrentTitles empConcurrentTitles WHERE ";
	private static final String _SQL_COUNT_EMPCONCURRENTTITLES = "SELECT COUNT(empConcurrentTitles) FROM EmpConcurrentTitles empConcurrentTitles";
	private static final String _SQL_COUNT_EMPCONCURRENTTITLES_WHERE = "SELECT COUNT(empConcurrentTitles) FROM EmpConcurrentTitles empConcurrentTitles WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empConcurrentTitles.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpConcurrentTitles exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpConcurrentTitles exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpConcurrentTitlesPersistenceImpl.class);
	private static EmpConcurrentTitles _nullEmpConcurrentTitles = new EmpConcurrentTitlesImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpConcurrentTitles> toCacheModel() {
				return _nullEmpConcurrentTitlesCacheModel;
			}
		};

	private static CacheModel<EmpConcurrentTitles> _nullEmpConcurrentTitlesCacheModel =
		new CacheModel<EmpConcurrentTitles>() {
			@Override
			public EmpConcurrentTitles toEntityModel() {
				return _nullEmpConcurrentTitles;
			}
		};
}