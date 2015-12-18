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

import vn.com.ecopharma.emp.NoSuchUnitGroupException;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.model.impl.UnitGroupImpl;
import vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the unit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see UnitGroupPersistence
 * @see UnitGroupUtil
 * @generated
 */
public class UnitGroupPersistenceImpl extends BasePersistenceImpl<UnitGroup>
	implements UnitGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link UnitGroupUtil} to access the unit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = UnitGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, UnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, UnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNIT = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, UnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnit",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, UnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnit",
			new String[] { Long.class.getName() },
			UnitGroupModelImpl.UNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNIT = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnit",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the unit groups where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitGroup> findByUnit(long unitId) throws SystemException {
		return findByUnit(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unit groups where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of unit groups
	 * @param end the upper bound of the range of unit groups (not inclusive)
	 * @return the range of matching unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitGroup> findByUnit(long unitId, int start, int end)
		throws SystemException {
		return findByUnit(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the unit groups where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of unit groups
	 * @param end the upper bound of the range of unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitGroup> findByUnit(long unitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT;
			finderArgs = new Object[] { unitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNIT;
			finderArgs = new Object[] { unitId, start, end, orderByComparator };
		}

		List<UnitGroup> list = (List<UnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UnitGroup unitGroup : list) {
				if ((unitId != unitGroup.getUnitId())) {
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

			query.append(_SQL_SELECT_UNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNIT_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(UnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

				if (!pagination) {
					list = (List<UnitGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UnitGroup>(list);
				}
				else {
					list = (List<UnitGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unit group
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup findByUnit_First(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitGroupException, SystemException {
		UnitGroup unitGroup = fetchByUnit_First(unitId, orderByComparator);

		if (unitGroup != null) {
			return unitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching unit group, or <code>null</code> if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup fetchByUnit_First(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<UnitGroup> list = findByUnit(unitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unit group
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup findByUnit_Last(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitGroupException, SystemException {
		UnitGroup unitGroup = fetchByUnit_Last(unitId, orderByComparator);

		if (unitGroup != null) {
			return unitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching unit group, or <code>null</code> if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup fetchByUnit_Last(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUnit(unitId);

		if (count == 0) {
			return null;
		}

		List<UnitGroup> list = findByUnit(unitId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the unit groups before and after the current unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitGroupId the primary key of the current unit group
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next unit group
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup[] findByUnit_PrevAndNext(long unitGroupId, long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchUnitGroupException, SystemException {
		UnitGroup unitGroup = findByPrimaryKey(unitGroupId);

		Session session = null;

		try {
			session = openSession();

			UnitGroup[] array = new UnitGroupImpl[3];

			array[0] = getByUnit_PrevAndNext(session, unitGroup, unitId,
					orderByComparator, true);

			array[1] = unitGroup;

			array[2] = getByUnit_PrevAndNext(session, unitGroup, unitId,
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

	protected UnitGroup getByUnit_PrevAndNext(Session session,
		UnitGroup unitGroup, long unitId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_UNITGROUP_WHERE);

		query.append(_FINDER_COLUMN_UNIT_UNITID_2);

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
			query.append(UnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(unitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<UnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the unit groups where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnit(long unitId) throws SystemException {
		for (UnitGroup unitGroup : findByUnit(unitId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(unitGroup);
		}
	}

	/**
	 * Returns the number of unit groups where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUnit(long unitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UNIT;

		Object[] finderArgs = new Object[] { unitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_UNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNIT_UNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

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

	private static final String _FINDER_COLUMN_UNIT_UNITID_2 = "unitGroup.unitId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDUNIT = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, UnitGroupImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNameAndUnit",
			new String[] { String.class.getName(), Long.class.getName() },
			UnitGroupModelImpl.NAME_COLUMN_BITMASK |
			UnitGroupModelImpl.UNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDUNIT = new FinderPath(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameAndUnit",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the unit group where name = &#63; and unitId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchUnitGroupException} if it could not be found.
	 *
	 * @param name the name
	 * @param unitId the unit ID
	 * @return the matching unit group
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup findByNameAndUnit(String name, long unitId)
		throws NoSuchUnitGroupException, SystemException {
		UnitGroup unitGroup = fetchByNameAndUnit(name, unitId);

		if (unitGroup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", unitId=");
			msg.append(unitId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchUnitGroupException(msg.toString());
		}

		return unitGroup;
	}

	/**
	 * Returns the unit group where name = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param unitId the unit ID
	 * @return the matching unit group, or <code>null</code> if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup fetchByNameAndUnit(String name, long unitId)
		throws SystemException {
		return fetchByNameAndUnit(name, unitId, true);
	}

	/**
	 * Returns the unit group where name = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param unitId the unit ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching unit group, or <code>null</code> if a matching unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup fetchByNameAndUnit(String name, long unitId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, unitId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT,
					finderArgs, this);
		}

		if (result instanceof UnitGroup) {
			UnitGroup unitGroup = (UnitGroup)result;

			if (!Validator.equals(name, unitGroup.getName()) ||
					(unitId != unitGroup.getUnitId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_UNITGROUP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDUNIT_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDUNIT_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDUNIT_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDUNIT_UNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(unitId);

				List<UnitGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"UnitGroupPersistenceImpl.fetchByNameAndUnit(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					UnitGroup unitGroup = list.get(0);

					result = unitGroup;

					cacheResult(unitGroup);

					if ((unitGroup.getName() == null) ||
							!unitGroup.getName().equals(name) ||
							(unitGroup.getUnitId() != unitId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT,
							finderArgs, unitGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT,
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
			return (UnitGroup)result;
		}
	}

	/**
	 * Removes the unit group where name = &#63; and unitId = &#63; from the database.
	 *
	 * @param name the name
	 * @param unitId the unit ID
	 * @return the unit group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup removeByNameAndUnit(String name, long unitId)
		throws NoSuchUnitGroupException, SystemException {
		UnitGroup unitGroup = findByNameAndUnit(name, unitId);

		return remove(unitGroup);
	}

	/**
	 * Returns the number of unit groups where name = &#63; and unitId = &#63;.
	 *
	 * @param name the name
	 * @param unitId the unit ID
	 * @return the number of matching unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameAndUnit(String name, long unitId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDUNIT;

		Object[] finderArgs = new Object[] { name, unitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_UNITGROUP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDUNIT_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDUNIT_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDUNIT_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDUNIT_UNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(unitId);

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

	private static final String _FINDER_COLUMN_NAMEANDUNIT_NAME_1 = "unitGroup.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDUNIT_NAME_2 = "unitGroup.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDUNIT_NAME_3 = "(unitGroup.name IS NULL OR unitGroup.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDUNIT_UNITID_2 = "unitGroup.unitId = ?";

	public UnitGroupPersistenceImpl() {
		setModelClass(UnitGroup.class);
	}

	/**
	 * Caches the unit group in the entity cache if it is enabled.
	 *
	 * @param unitGroup the unit group
	 */
	@Override
	public void cacheResult(UnitGroup unitGroup) {
		EntityCacheUtil.putResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupImpl.class, unitGroup.getPrimaryKey(), unitGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT,
			new Object[] { unitGroup.getName(), unitGroup.getUnitId() },
			unitGroup);

		unitGroup.resetOriginalValues();
	}

	/**
	 * Caches the unit groups in the entity cache if it is enabled.
	 *
	 * @param unitGroups the unit groups
	 */
	@Override
	public void cacheResult(List<UnitGroup> unitGroups) {
		for (UnitGroup unitGroup : unitGroups) {
			if (EntityCacheUtil.getResult(
						UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
						UnitGroupImpl.class, unitGroup.getPrimaryKey()) == null) {
				cacheResult(unitGroup);
			}
			else {
				unitGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all unit groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(UnitGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(UnitGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the unit group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UnitGroup unitGroup) {
		EntityCacheUtil.removeResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupImpl.class, unitGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(unitGroup);
	}

	@Override
	public void clearCache(List<UnitGroup> unitGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UnitGroup unitGroup : unitGroups) {
			EntityCacheUtil.removeResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
				UnitGroupImpl.class, unitGroup.getPrimaryKey());

			clearUniqueFindersCache(unitGroup);
		}
	}

	protected void cacheUniqueFindersCache(UnitGroup unitGroup) {
		if (unitGroup.isNew()) {
			Object[] args = new Object[] {
					unitGroup.getName(), unitGroup.getUnitId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDUNIT, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT, args,
				unitGroup);
		}
		else {
			UnitGroupModelImpl unitGroupModelImpl = (UnitGroupModelImpl)unitGroup;

			if ((unitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEANDUNIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						unitGroup.getName(), unitGroup.getUnitId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDUNIT,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT,
					args, unitGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(UnitGroup unitGroup) {
		UnitGroupModelImpl unitGroupModelImpl = (UnitGroupModelImpl)unitGroup;

		Object[] args = new Object[] { unitGroup.getName(), unitGroup.getUnitId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDUNIT, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT, args);

		if ((unitGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEANDUNIT.getColumnBitmask()) != 0) {
			args = new Object[] {
					unitGroupModelImpl.getOriginalName(),
					unitGroupModelImpl.getOriginalUnitId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDUNIT, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDUNIT, args);
		}
	}

	/**
	 * Creates a new unit group with the primary key. Does not add the unit group to the database.
	 *
	 * @param unitGroupId the primary key for the new unit group
	 * @return the new unit group
	 */
	@Override
	public UnitGroup create(long unitGroupId) {
		UnitGroup unitGroup = new UnitGroupImpl();

		unitGroup.setNew(true);
		unitGroup.setPrimaryKey(unitGroupId);

		return unitGroup;
	}

	/**
	 * Removes the unit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param unitGroupId the primary key of the unit group
	 * @return the unit group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup remove(long unitGroupId)
		throws NoSuchUnitGroupException, SystemException {
		return remove((Serializable)unitGroupId);
	}

	/**
	 * Removes the unit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the unit group
	 * @return the unit group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup remove(Serializable primaryKey)
		throws NoSuchUnitGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			UnitGroup unitGroup = (UnitGroup)session.get(UnitGroupImpl.class,
					primaryKey);

			if (unitGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUnitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(unitGroup);
		}
		catch (NoSuchUnitGroupException nsee) {
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
	protected UnitGroup removeImpl(UnitGroup unitGroup)
		throws SystemException {
		unitGroup = toUnwrappedModel(unitGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(unitGroup)) {
				unitGroup = (UnitGroup)session.get(UnitGroupImpl.class,
						unitGroup.getPrimaryKeyObj());
			}

			if (unitGroup != null) {
				session.delete(unitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (unitGroup != null) {
			clearCache(unitGroup);
		}

		return unitGroup;
	}

	@Override
	public UnitGroup updateImpl(vn.com.ecopharma.emp.model.UnitGroup unitGroup)
		throws SystemException {
		unitGroup = toUnwrappedModel(unitGroup);

		boolean isNew = unitGroup.isNew();

		UnitGroupModelImpl unitGroupModelImpl = (UnitGroupModelImpl)unitGroup;

		Session session = null;

		try {
			session = openSession();

			if (unitGroup.isNew()) {
				session.save(unitGroup);

				unitGroup.setNew(false);
			}
			else {
				session.merge(unitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !UnitGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((unitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						unitGroupModelImpl.getOriginalUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);

				args = new Object[] { unitGroupModelImpl.getUnitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);
			}
		}

		EntityCacheUtil.putResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			UnitGroupImpl.class, unitGroup.getPrimaryKey(), unitGroup);

		clearUniqueFindersCache(unitGroup);
		cacheUniqueFindersCache(unitGroup);

		return unitGroup;
	}

	protected UnitGroup toUnwrappedModel(UnitGroup unitGroup) {
		if (unitGroup instanceof UnitGroupImpl) {
			return unitGroup;
		}

		UnitGroupImpl unitGroupImpl = new UnitGroupImpl();

		unitGroupImpl.setNew(unitGroup.isNew());
		unitGroupImpl.setPrimaryKey(unitGroup.getPrimaryKey());

		unitGroupImpl.setUnitGroupId(unitGroup.getUnitGroupId());
		unitGroupImpl.setName(unitGroup.getName());
		unitGroupImpl.setUnitId(unitGroup.getUnitId());
		unitGroupImpl.setGroupId(unitGroup.getGroupId());
		unitGroupImpl.setCompanyId(unitGroup.getCompanyId());
		unitGroupImpl.setUserId(unitGroup.getUserId());
		unitGroupImpl.setUserName(unitGroup.getUserName());
		unitGroupImpl.setCreateDate(unitGroup.getCreateDate());
		unitGroupImpl.setModifiedDate(unitGroup.getModifiedDate());

		return unitGroupImpl;
	}

	/**
	 * Returns the unit group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit group
	 * @return the unit group
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUnitGroupException, SystemException {
		UnitGroup unitGroup = fetchByPrimaryKey(primaryKey);

		if (unitGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUnitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return unitGroup;
	}

	/**
	 * Returns the unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchUnitGroupException} if it could not be found.
	 *
	 * @param unitGroupId the primary key of the unit group
	 * @return the unit group
	 * @throws vn.com.ecopharma.emp.NoSuchUnitGroupException if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup findByPrimaryKey(long unitGroupId)
		throws NoSuchUnitGroupException, SystemException {
		return findByPrimaryKey((Serializable)unitGroupId);
	}

	/**
	 * Returns the unit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the unit group
	 * @return the unit group, or <code>null</code> if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		UnitGroup unitGroup = (UnitGroup)EntityCacheUtil.getResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
				UnitGroupImpl.class, primaryKey);

		if (unitGroup == _nullUnitGroup) {
			return null;
		}

		if (unitGroup == null) {
			Session session = null;

			try {
				session = openSession();

				unitGroup = (UnitGroup)session.get(UnitGroupImpl.class,
						primaryKey);

				if (unitGroup != null) {
					cacheResult(unitGroup);
				}
				else {
					EntityCacheUtil.putResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
						UnitGroupImpl.class, primaryKey, _nullUnitGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(UnitGroupModelImpl.ENTITY_CACHE_ENABLED,
					UnitGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return unitGroup;
	}

	/**
	 * Returns the unit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param unitGroupId the primary key of the unit group
	 * @return the unit group, or <code>null</code> if a unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public UnitGroup fetchByPrimaryKey(long unitGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)unitGroupId);
	}

	/**
	 * Returns all the unit groups.
	 *
	 * @return the unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the unit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit groups
	 * @param end the upper bound of the range of unit groups (not inclusive)
	 * @return the range of unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the unit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.UnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of unit groups
	 * @param end the upper bound of the range of unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<UnitGroup> findAll(int start, int end,
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

		List<UnitGroup> list = (List<UnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_UNITGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_UNITGROUP;

				if (pagination) {
					sql = sql.concat(UnitGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UnitGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<UnitGroup>(list);
				}
				else {
					list = (List<UnitGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the unit groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (UnitGroup unitGroup : findAll()) {
			remove(unitGroup);
		}
	}

	/**
	 * Returns the number of unit groups.
	 *
	 * @return the number of unit groups
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

				Query q = session.createQuery(_SQL_COUNT_UNITGROUP);

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
	 * Initializes the unit group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.UnitGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<UnitGroup>> listenersList = new ArrayList<ModelListener<UnitGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<UnitGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(UnitGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_UNITGROUP = "SELECT unitGroup FROM UnitGroup unitGroup";
	private static final String _SQL_SELECT_UNITGROUP_WHERE = "SELECT unitGroup FROM UnitGroup unitGroup WHERE ";
	private static final String _SQL_COUNT_UNITGROUP = "SELECT COUNT(unitGroup) FROM UnitGroup unitGroup";
	private static final String _SQL_COUNT_UNITGROUP_WHERE = "SELECT COUNT(unitGroup) FROM UnitGroup unitGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "unitGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UnitGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UnitGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(UnitGroupPersistenceImpl.class);
	private static UnitGroup _nullUnitGroup = new UnitGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<UnitGroup> toCacheModel() {
				return _nullUnitGroupCacheModel;
			}
		};

	private static CacheModel<UnitGroup> _nullUnitGroupCacheModel = new CacheModel<UnitGroup>() {
			@Override
			public UnitGroup toEntityModel() {
				return _nullUnitGroup;
			}
		};
}