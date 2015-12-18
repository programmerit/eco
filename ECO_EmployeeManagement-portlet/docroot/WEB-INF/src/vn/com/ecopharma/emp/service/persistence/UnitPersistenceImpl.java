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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.emp.NoSuchUnitException;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.impl.UnitImpl;
import vn.com.ecopharma.emp.model.impl.UnitModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the unit service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see UnitPersistence
 * @see UnitUtil
 * @generated
 */
public class UnitPersistenceImpl extends BasePersistenceImpl<Unit>
	implements UnitPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UnitUtil} to access the unit persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UnitImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, UnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, UnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, UnitImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNameAndDepartment",
			new String[] { String.class.getName(), Long.class.getName() },
			UnitModelImpl.NAME_COLUMN_BITMASK |
			UnitModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDDEPARTMENT = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNameAndDepartment",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the unit where name = &#63; and departmentId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUnitException} if it could not be found.
	 *
	 * @param name the name
	 * @param departmentId the department ID
	 * @return the matching unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit findByNameAndDepartment(String name, long departmentId)
		throws NoSuchUnitException, SystemException {
		Unit unit = fetchByNameAndDepartment(name, departmentId);

		if (unit == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", departmentId=");
			msg.append(departmentId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUnitException(msg.toString());
		}

		return unit;
	}

	/**
	 * Returns the unit where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param departmentId the department ID
	 * @return the matching unit, or <code>null</code> if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByNameAndDepartment(String name, long departmentId)
		throws SystemException {
		return fetchByNameAndDepartment(name, departmentId, true);
	}

	/**
	 * Returns the unit where name = &#63; and departmentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param departmentId the department ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching unit, or <code>null</code> if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByNameAndDepartment(String name, long departmentId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, departmentId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
					finderArgs, this);
		}

		if (result instanceof Unit) {
			Unit unit = (Unit)result;

			if (!Validator.equals(name, unit.getName()) ||
					(departmentId != unit.getDepartmentId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_UNIT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(departmentId);

				List<Unit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UnitPersistenceImpl.fetchByNameAndDepartment(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Unit unit = list.get(0);

					result = unit;

					cacheResult(unit);

					if ((unit.getName() == null) ||
							!unit.getName().equals(name) ||
							(unit.getDepartmentId() != departmentId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
							finderArgs, unit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
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
			return (Unit)result;
		}
	}

	/**
	 * Removes the unit where name = &#63; and departmentId = &#63; from the database.
	 *
	 * @param name the name
	 * @param departmentId the department ID
	 * @return the unit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit removeByNameAndDepartment(String name, long departmentId)
		throws NoSuchUnitException, SystemException {
		Unit unit = findByNameAndDepartment(name, departmentId);

		return remove(unit);
	}

	/**
	 * Returns the number of units where name = &#63; and departmentId = &#63;.
	 *
	 * @param name the name
	 * @param departmentId the department ID
	 * @return the number of matching units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameAndDepartment(String name, long departmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDDEPARTMENT;

		Object[] finderArgs = new Object[] { name, departmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_UNIT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDDEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_1 = "unit.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_2 = "unit.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEPARTMENT_NAME_3 = "(unit.name IS NULL OR unit.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEPARTMENT_DEPARTMENTID_2 = "unit.departmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, UnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartment",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, UnitImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartment",
			new String[] { Long.class.getName() },
			UnitModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENT = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDepartment",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the units where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Unit> findByDepartment(long departmentId)
		throws SystemException {
		return findByDepartment(departmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the units where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @return the range of matching units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Unit> findByDepartment(long departmentId, int start, int end)
		throws SystemException {
		return findByDepartment(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the units where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Unit> findByDepartment(long departmentId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT;
			finderArgs = new Object[] { departmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT;
			finderArgs = new Object[] {
					departmentId,
					
					start, end, orderByComparator
				};
		}

		List<Unit> list = (List<Unit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Unit unit : list) {
				if ((departmentId != unit.getDepartmentId())) {
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

			query.append(_SQL_SELECT_UNIT_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UnitModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (!pagination) {
					list = (List<Unit>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Unit>(list);
				}
				else {
					list = (List<Unit>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first unit in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit findByDepartment_First(long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitException, SystemException {
		Unit unit = fetchByDepartment_First(departmentId, orderByComparator);

		if (unit != null) {
			return unit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitException(msg.toString());
	}

	/**
	 * Returns the first unit in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unit, or <code>null</code> if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByDepartment_First(long departmentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Unit> list = findByDepartment(departmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last unit in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit findByDepartment_Last(long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitException, SystemException {
		Unit unit = fetchByDepartment_Last(departmentId, orderByComparator);

		if (unit != null) {
			return unit;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitException(msg.toString());
	}

	/**
	 * Returns the last unit in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unit, or <code>null</code> if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByDepartment_Last(long departmentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDepartment(departmentId);

		if (count == 0) {
			return null;
		}

		List<Unit> list = findByDepartment(departmentId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the units before and after the current unit in the ordered set where departmentId = &#63;.
	 *
	 * @param unitId the primary key of the current unit
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit[] findByDepartment_PrevAndNext(long unitId, long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitException, SystemException {
		Unit unit = findByPrimaryKey(unitId);

		Session session = null;

		try {
			session = openSession();

			Unit[] array = new UnitImpl[3];

			array[0] = getByDepartment_PrevAndNext(session, unit, departmentId,
					orderByComparator, true);

			array[1] = unit;

			array[2] = getByDepartment_PrevAndNext(session, unit, departmentId,
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

	protected Unit getByDepartment_PrevAndNext(Session session, Unit unit,
		long departmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UNIT_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENTID_2);

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
			query.append(UnitModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(unit);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Unit> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the units where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartment(long departmentId) throws SystemException {
		for (Unit unit : findByDepartment(departmentId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(unit);
		}
	}

	/**
	 * Returns the number of units where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDepartment(long departmentId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENT;

		Object[] finderArgs = new Object[] { departmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UNIT_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

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

	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENTID_2 = "unit.departmentId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, UnitImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			UnitModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the unit where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUnitException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit findByName(String name)
		throws NoSuchUnitException, SystemException {
		Unit unit = fetchByName(name);

		if (unit == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUnitException(msg.toString());
		}

		return unit;
	}

	/**
	 * Returns the unit where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching unit, or <code>null</code> if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the unit where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching unit, or <code>null</code> if a matching unit could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Unit) {
			Unit unit = (Unit)result;

			if (!Validator.equals(name, unit.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_UNIT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Unit> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UnitPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Unit unit = list.get(0);

					result = unit;

					cacheResult(unit);

					if ((unit.getName() == null) ||
							!unit.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, unit);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (Unit)result;
		}
	}

	/**
	 * Removes the unit where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the unit that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit removeByName(String name)
		throws NoSuchUnitException, SystemException {
		Unit unit = findByName(name);

		return remove(unit);
	}

	/**
	 * Returns the number of units where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UNIT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "unit.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "unit.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(unit.name IS NULL OR unit.name = '')";

	public UnitPersistenceImpl() {
		setModelClass(Unit.class);
	}

	/**
	 * Caches the unit in the entity cache if it is enabled.
	 *
	 * @param unit the unit
	 */
	@Override
	public void cacheResult(Unit unit) {
		EntityCacheUtil.putResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitImpl.class, unit.getPrimaryKey(), unit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
			new Object[] { unit.getName(), unit.getDepartmentId() }, unit);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { unit.getName() }, unit);

		unit.resetOriginalValues();
	}

	/**
	 * Caches the units in the entity cache if it is enabled.
	 *
	 * @param units the units
	 */
	@Override
	public void cacheResult(List<Unit> units) {
		for (Unit unit : units) {
			if (EntityCacheUtil.getResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
						UnitImpl.class, unit.getPrimaryKey()) == null) {
				cacheResult(unit);
			}
			else {
				unit.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all units.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UnitImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UnitImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unit.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Unit unit) {
		EntityCacheUtil.removeResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitImpl.class, unit.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(unit);
	}

	@Override
	public void clearCache(List<Unit> units) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Unit unit : units) {
			EntityCacheUtil.removeResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
				UnitImpl.class, unit.getPrimaryKey());

			clearUniqueFindersCache(unit);
		}
	}

	protected void cacheUniqueFindersCache(Unit unit) {
		if (unit.isNew()) {
			Object[] args = new Object[] { unit.getName(), unit.getDepartmentId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDDEPARTMENT,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
				args, unit);

			args = new Object[] { unit.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, unit);
		}
		else {
			UnitModelImpl unitModelImpl = (UnitModelImpl)unit;

			if ((unitModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						unit.getName(), unit.getDepartmentId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDDEPARTMENT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
					args, unit);
			}

			if ((unitModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { unit.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, unit);
			}
		}
	}

	protected void clearUniqueFindersCache(Unit unit) {
		UnitModelImpl unitModelImpl = (UnitModelImpl)unit;

		Object[] args = new Object[] { unit.getName(), unit.getDepartmentId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDDEPARTMENT,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
			args);

		if ((unitModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT.getColumnBitmask()) != 0) {
			args = new Object[] {
					unitModelImpl.getOriginalName(),
					unitModelImpl.getOriginalDepartmentId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDDEPARTMENT,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEPARTMENT,
				args);
		}

		args = new Object[] { unit.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((unitModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { unitModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new unit with the primary key. Does not add the unit to the database.
	 *
	 * @param unitId the primary key for the new unit
	 * @return the new unit
	 */
	@Override
	public Unit create(long unitId) {
		Unit unit = new UnitImpl();

		unit.setNew(true);
		unit.setPrimaryKey(unitId);

		return unit;
	}

	/**
	 * Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit remove(long unitId) throws NoSuchUnitException, SystemException {
		return remove((Serializable)unitId);
	}

	/**
	 * Removes the unit with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unit
	 * @return the unit that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit remove(Serializable primaryKey)
		throws NoSuchUnitException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Unit unit = (Unit)session.get(UnitImpl.class, primaryKey);

			if (unit == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(unit);
		}
		catch (NoSuchUnitException nsee) {
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
	protected Unit removeImpl(Unit unit) throws SystemException {
		unit = toUnwrappedModel(unit);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(unit)) {
				unit = (Unit)session.get(UnitImpl.class, unit.getPrimaryKeyObj());
			}

			if (unit != null) {
				session.delete(unit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (unit != null) {
			clearCache(unit);
		}

		return unit;
	}

	@Override
	public Unit updateImpl(vn.com.ecopharma.emp.model.Unit unit)
		throws SystemException {
		unit = toUnwrappedModel(unit);

		boolean isNew = unit.isNew();

		UnitModelImpl unitModelImpl = (UnitModelImpl)unit;

		Session session = null;

		try {
			session = openSession();

			if (unit.isNew()) {
				session.save(unit);

				unit.setNew(false);
			}
			else {
				session.merge(unit);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UnitModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((unitModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						unitModelImpl.getOriginalDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);

				args = new Object[] { unitModelImpl.getDepartmentId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);
			}
		}

		EntityCacheUtil.putResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
			UnitImpl.class, unit.getPrimaryKey(), unit);

		clearUniqueFindersCache(unit);
		cacheUniqueFindersCache(unit);

		return unit;
	}

	protected Unit toUnwrappedModel(Unit unit) {
		if (unit instanceof UnitImpl) {
			return unit;
		}

		UnitImpl unitImpl = new UnitImpl();

		unitImpl.setNew(unit.isNew());
		unitImpl.setPrimaryKey(unit.getPrimaryKey());

		unitImpl.setUnitId(unit.getUnitId());
		unitImpl.setName(unit.getName());
		unitImpl.setDepartmentId(unit.getDepartmentId());
		unitImpl.setGroupId(unit.getGroupId());
		unitImpl.setCompanyId(unit.getCompanyId());
		unitImpl.setUserId(unit.getUserId());
		unitImpl.setUserName(unit.getUserName());
		unitImpl.setCreateDate(unit.getCreateDate());
		unitImpl.setModifiedDate(unit.getModifiedDate());

		return unitImpl;
	}

	/**
	 * Returns the unit with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit
	 * @return the unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUnitException, SystemException {
		Unit unit = fetchByPrimaryKey(primaryKey);

		if (unit == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUnitException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return unit;
	}

	/**
	 * Returns the unit with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchUnitException} if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit
	 * @throws vn.com.ecopharma.emp.NoSuchUnitException if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit findByPrimaryKey(long unitId)
		throws NoSuchUnitException, SystemException {
		return findByPrimaryKey((Serializable)unitId);
	}

	/**
	 * Returns the unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit
	 * @return the unit, or <code>null</code> if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Unit unit = (Unit)EntityCacheUtil.getResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
				UnitImpl.class, primaryKey);

		if (unit == _nullUnit) {
			return null;
		}

		if (unit == null) {
			Session session = null;

			try {
				session = openSession();

				unit = (Unit)session.get(UnitImpl.class, primaryKey);

				if (unit != null) {
					cacheResult(unit);
				}
				else {
					EntityCacheUtil.putResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
						UnitImpl.class, primaryKey, _nullUnit);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UnitModelImpl.ENTITY_CACHE_ENABLED,
					UnitImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return unit;
	}

	/**
	 * Returns the unit with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitId the primary key of the unit
	 * @return the unit, or <code>null</code> if a unit with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Unit fetchByPrimaryKey(long unitId) throws SystemException {
		return fetchByPrimaryKey((Serializable)unitId);
	}

	/**
	 * Returns all the units.
	 *
	 * @return the units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Unit> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @return the range of units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Unit> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the units.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of units
	 * @param end the upper bound of the range of units (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of units
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Unit> findAll(int start, int end,
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

		List<Unit> list = (List<Unit>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNIT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNIT;

				if (pagination) {
					sql = sql.concat(UnitModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Unit>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Unit>(list);
				}
				else {
					list = (List<Unit>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the units from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Unit unit : findAll()) {
			remove(unit);
		}
	}

	/**
	 * Returns the number of units.
	 *
	 * @return the number of units
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

				Query q = session.createQuery(_SQL_COUNT_UNIT);

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
	 * Initializes the unit persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Unit")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Unit>> listenersList = new ArrayList<ModelListener<Unit>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Unit>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UnitImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNIT = "SELECT unit FROM Unit unit";
	private static final String _SQL_SELECT_UNIT_WHERE = "SELECT unit FROM Unit unit WHERE ";
	private static final String _SQL_COUNT_UNIT = "SELECT COUNT(unit) FROM Unit unit";
	private static final String _SQL_COUNT_UNIT_WHERE = "SELECT COUNT(unit) FROM Unit unit WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "unit.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Unit exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Unit exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UnitPersistenceImpl.class);
	private static Unit _nullUnit = new UnitImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Unit> toCacheModel() {
				return _nullUnitCacheModel;
			}
		};

	private static CacheModel<Unit> _nullUnitCacheModel = new CacheModel<Unit>() {
			@Override
			public Unit toEntityModel() {
				return _nullUnit;
			}
		};
}