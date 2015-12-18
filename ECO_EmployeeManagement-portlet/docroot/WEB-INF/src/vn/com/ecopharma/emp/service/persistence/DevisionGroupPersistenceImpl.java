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

import vn.com.ecopharma.emp.NoSuchDevisionGroupException;
import vn.com.ecopharma.emp.model.DevisionGroup;
import vn.com.ecopharma.emp.model.impl.DevisionGroupImpl;
import vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the devision group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DevisionGroupPersistence
 * @see DevisionGroupUtil
 * @generated
 */
public class DevisionGroupPersistenceImpl extends BasePersistenceImpl<DevisionGroup>
	implements DevisionGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DevisionGroupUtil} to access the devision group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DevisionGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED,
			DevisionGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED,
			DevisionGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVISION = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED,
			DevisionGroupImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDevision",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION =
		new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED,
			DevisionGroupImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDevision", new String[] { Long.class.getName() },
			DevisionGroupModelImpl.DEVISIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVISION = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDevision",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the devision groups where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @return the matching devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DevisionGroup> findByDevision(long devisionId)
		throws SystemException {
		return findByDevision(devisionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the devision groups where devisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param devisionId the devision ID
	 * @param start the lower bound of the range of devision groups
	 * @param end the upper bound of the range of devision groups (not inclusive)
	 * @return the range of matching devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DevisionGroup> findByDevision(long devisionId, int start,
		int end) throws SystemException {
		return findByDevision(devisionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the devision groups where devisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param devisionId the devision ID
	 * @param start the lower bound of the range of devision groups
	 * @param end the upper bound of the range of devision groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DevisionGroup> findByDevision(long devisionId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION;
			finderArgs = new Object[] { devisionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVISION;
			finderArgs = new Object[] { devisionId, start, end, orderByComparator };
		}

		List<DevisionGroup> list = (List<DevisionGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DevisionGroup devisionGroup : list) {
				if ((devisionId != devisionGroup.getDevisionId())) {
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

			query.append(_SQL_SELECT_DEVISIONGROUP_WHERE);

			query.append(_FINDER_COLUMN_DEVISION_DEVISIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DevisionGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(devisionId);

				if (!pagination) {
					list = (List<DevisionGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DevisionGroup>(list);
				}
				else {
					list = (List<DevisionGroup>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first devision group in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching devision group
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup findByDevision_First(long devisionId,
		OrderByComparator orderByComparator)
		throws NoSuchDevisionGroupException, SystemException {
		DevisionGroup devisionGroup = fetchByDevision_First(devisionId,
				orderByComparator);

		if (devisionGroup != null) {
			return devisionGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("devisionId=");
		msg.append(devisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDevisionGroupException(msg.toString());
	}

	/**
	 * Returns the first devision group in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching devision group, or <code>null</code> if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup fetchByDevision_First(long devisionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DevisionGroup> list = findByDevision(devisionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last devision group in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching devision group
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup findByDevision_Last(long devisionId,
		OrderByComparator orderByComparator)
		throws NoSuchDevisionGroupException, SystemException {
		DevisionGroup devisionGroup = fetchByDevision_Last(devisionId,
				orderByComparator);

		if (devisionGroup != null) {
			return devisionGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("devisionId=");
		msg.append(devisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDevisionGroupException(msg.toString());
	}

	/**
	 * Returns the last devision group in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching devision group, or <code>null</code> if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup fetchByDevision_Last(long devisionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDevision(devisionId);

		if (count == 0) {
			return null;
		}

		List<DevisionGroup> list = findByDevision(devisionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the devision groups before and after the current devision group in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionGroupId the primary key of the current devision group
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next devision group
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup[] findByDevision_PrevAndNext(long devisionGroupId,
		long devisionId, OrderByComparator orderByComparator)
		throws NoSuchDevisionGroupException, SystemException {
		DevisionGroup devisionGroup = findByPrimaryKey(devisionGroupId);

		Session session = null;

		try {
			session = openSession();

			DevisionGroup[] array = new DevisionGroupImpl[3];

			array[0] = getByDevision_PrevAndNext(session, devisionGroup,
					devisionId, orderByComparator, true);

			array[1] = devisionGroup;

			array[2] = getByDevision_PrevAndNext(session, devisionGroup,
					devisionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DevisionGroup getByDevision_PrevAndNext(Session session,
		DevisionGroup devisionGroup, long devisionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEVISIONGROUP_WHERE);

		query.append(_FINDER_COLUMN_DEVISION_DEVISIONID_2);

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
			query.append(DevisionGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(devisionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(devisionGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DevisionGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the devision groups where devisionId = &#63; from the database.
	 *
	 * @param devisionId the devision ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDevision(long devisionId) throws SystemException {
		for (DevisionGroup devisionGroup : findByDevision(devisionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(devisionGroup);
		}
	}

	/**
	 * Returns the number of devision groups where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @return the number of matching devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDevision(long devisionId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEVISION;

		Object[] finderArgs = new Object[] { devisionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DEVISIONGROUP_WHERE);

			query.append(_FINDER_COLUMN_DEVISION_DEVISIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(devisionId);

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

	private static final String _FINDER_COLUMN_DEVISION_DEVISIONID_2 = "devisionGroup.devisionId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDDEVISION = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED,
			DevisionGroupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNameAndDevision",
			new String[] { String.class.getName(), Long.class.getName() },
			DevisionGroupModelImpl.NAME_COLUMN_BITMASK |
			DevisionGroupModelImpl.DEVISIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDDEVISION = new FinderPath(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNameAndDevision",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the devision group where name = &#63; and devisionId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDevisionGroupException} if it could not be found.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the matching devision group
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup findByNameAndDevision(String name, long devisionId)
		throws NoSuchDevisionGroupException, SystemException {
		DevisionGroup devisionGroup = fetchByNameAndDevision(name, devisionId);

		if (devisionGroup == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", devisionId=");
			msg.append(devisionId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDevisionGroupException(msg.toString());
		}

		return devisionGroup;
	}

	/**
	 * Returns the devision group where name = &#63; and devisionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the matching devision group, or <code>null</code> if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup fetchByNameAndDevision(String name, long devisionId)
		throws SystemException {
		return fetchByNameAndDevision(name, devisionId, true);
	}

	/**
	 * Returns the devision group where name = &#63; and devisionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching devision group, or <code>null</code> if a matching devision group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup fetchByNameAndDevision(String name, long devisionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, devisionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
					finderArgs, this);
		}

		if (result instanceof DevisionGroup) {
			DevisionGroup devisionGroup = (DevisionGroup)result;

			if (!Validator.equals(name, devisionGroup.getName()) ||
					(devisionId != devisionGroup.getDevisionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DEVISIONGROUP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDDEVISION_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDDEVISION_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDDEVISION_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDDEVISION_DEVISIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(devisionId);

				List<DevisionGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DevisionGroupPersistenceImpl.fetchByNameAndDevision(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DevisionGroup devisionGroup = list.get(0);

					result = devisionGroup;

					cacheResult(devisionGroup);

					if ((devisionGroup.getName() == null) ||
							!devisionGroup.getName().equals(name) ||
							(devisionGroup.getDevisionId() != devisionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
							finderArgs, devisionGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
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
			return (DevisionGroup)result;
		}
	}

	/**
	 * Removes the devision group where name = &#63; and devisionId = &#63; from the database.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the devision group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup removeByNameAndDevision(String name, long devisionId)
		throws NoSuchDevisionGroupException, SystemException {
		DevisionGroup devisionGroup = findByNameAndDevision(name, devisionId);

		return remove(devisionGroup);
	}

	/**
	 * Returns the number of devision groups where name = &#63; and devisionId = &#63;.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the number of matching devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameAndDevision(String name, long devisionId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDDEVISION;

		Object[] finderArgs = new Object[] { name, devisionId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DEVISIONGROUP_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDDEVISION_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDDEVISION_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDDEVISION_NAME_2);
			}

			query.append(_FINDER_COLUMN_NAMEANDDEVISION_DEVISIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				qPos.add(devisionId);

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

	private static final String _FINDER_COLUMN_NAMEANDDEVISION_NAME_1 = "devisionGroup.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEVISION_NAME_2 = "devisionGroup.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEVISION_NAME_3 = "(devisionGroup.name IS NULL OR devisionGroup.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEVISION_DEVISIONID_2 = "devisionGroup.devisionId = ?";

	public DevisionGroupPersistenceImpl() {
		setModelClass(DevisionGroup.class);
	}

	/**
	 * Caches the devision group in the entity cache if it is enabled.
	 *
	 * @param devisionGroup the devision group
	 */
	@Override
	public void cacheResult(DevisionGroup devisionGroup) {
		EntityCacheUtil.putResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupImpl.class, devisionGroup.getPrimaryKey(),
			devisionGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
			new Object[] { devisionGroup.getName(), devisionGroup.getDevisionId() },
			devisionGroup);

		devisionGroup.resetOriginalValues();
	}

	/**
	 * Caches the devision groups in the entity cache if it is enabled.
	 *
	 * @param devisionGroups the devision groups
	 */
	@Override
	public void cacheResult(List<DevisionGroup> devisionGroups) {
		for (DevisionGroup devisionGroup : devisionGroups) {
			if (EntityCacheUtil.getResult(
						DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
						DevisionGroupImpl.class, devisionGroup.getPrimaryKey()) == null) {
				cacheResult(devisionGroup);
			}
			else {
				devisionGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all devision groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DevisionGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DevisionGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the devision group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DevisionGroup devisionGroup) {
		EntityCacheUtil.removeResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupImpl.class, devisionGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(devisionGroup);
	}

	@Override
	public void clearCache(List<DevisionGroup> devisionGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DevisionGroup devisionGroup : devisionGroups) {
			EntityCacheUtil.removeResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
				DevisionGroupImpl.class, devisionGroup.getPrimaryKey());

			clearUniqueFindersCache(devisionGroup);
		}
	}

	protected void cacheUniqueFindersCache(DevisionGroup devisionGroup) {
		if (devisionGroup.isNew()) {
			Object[] args = new Object[] {
					devisionGroup.getName(), devisionGroup.getDevisionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
				args, devisionGroup);
		}
		else {
			DevisionGroupModelImpl devisionGroupModelImpl = (DevisionGroupModelImpl)devisionGroup;

			if ((devisionGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEANDDEVISION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						devisionGroup.getName(), devisionGroup.getDevisionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
					args, devisionGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(DevisionGroup devisionGroup) {
		DevisionGroupModelImpl devisionGroupModelImpl = (DevisionGroupModelImpl)devisionGroup;

		Object[] args = new Object[] {
				devisionGroup.getName(), devisionGroup.getDevisionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION, args);

		if ((devisionGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEANDDEVISION.getColumnBitmask()) != 0) {
			args = new Object[] {
					devisionGroupModelImpl.getOriginalName(),
					devisionGroupModelImpl.getOriginalDevisionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
				args);
		}
	}

	/**
	 * Creates a new devision group with the primary key. Does not add the devision group to the database.
	 *
	 * @param devisionGroupId the primary key for the new devision group
	 * @return the new devision group
	 */
	@Override
	public DevisionGroup create(long devisionGroupId) {
		DevisionGroup devisionGroup = new DevisionGroupImpl();

		devisionGroup.setNew(true);
		devisionGroup.setPrimaryKey(devisionGroupId);

		return devisionGroup;
	}

	/**
	 * Removes the devision group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param devisionGroupId the primary key of the devision group
	 * @return the devision group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup remove(long devisionGroupId)
		throws NoSuchDevisionGroupException, SystemException {
		return remove((Serializable)devisionGroupId);
	}

	/**
	 * Removes the devision group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the devision group
	 * @return the devision group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup remove(Serializable primaryKey)
		throws NoSuchDevisionGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DevisionGroup devisionGroup = (DevisionGroup)session.get(DevisionGroupImpl.class,
					primaryKey);

			if (devisionGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDevisionGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(devisionGroup);
		}
		catch (NoSuchDevisionGroupException nsee) {
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
	protected DevisionGroup removeImpl(DevisionGroup devisionGroup)
		throws SystemException {
		devisionGroup = toUnwrappedModel(devisionGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(devisionGroup)) {
				devisionGroup = (DevisionGroup)session.get(DevisionGroupImpl.class,
						devisionGroup.getPrimaryKeyObj());
			}

			if (devisionGroup != null) {
				session.delete(devisionGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (devisionGroup != null) {
			clearCache(devisionGroup);
		}

		return devisionGroup;
	}

	@Override
	public DevisionGroup updateImpl(
		vn.com.ecopharma.emp.model.DevisionGroup devisionGroup)
		throws SystemException {
		devisionGroup = toUnwrappedModel(devisionGroup);

		boolean isNew = devisionGroup.isNew();

		DevisionGroupModelImpl devisionGroupModelImpl = (DevisionGroupModelImpl)devisionGroup;

		Session session = null;

		try {
			session = openSession();

			if (devisionGroup.isNew()) {
				session.save(devisionGroup);

				devisionGroup.setNew(false);
			}
			else {
				session.merge(devisionGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DevisionGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((devisionGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						devisionGroupModelImpl.getOriginalDevisionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVISION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION,
					args);

				args = new Object[] { devisionGroupModelImpl.getDevisionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVISION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION,
					args);
			}
		}

		EntityCacheUtil.putResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
			DevisionGroupImpl.class, devisionGroup.getPrimaryKey(),
			devisionGroup);

		clearUniqueFindersCache(devisionGroup);
		cacheUniqueFindersCache(devisionGroup);

		return devisionGroup;
	}

	protected DevisionGroup toUnwrappedModel(DevisionGroup devisionGroup) {
		if (devisionGroup instanceof DevisionGroupImpl) {
			return devisionGroup;
		}

		DevisionGroupImpl devisionGroupImpl = new DevisionGroupImpl();

		devisionGroupImpl.setNew(devisionGroup.isNew());
		devisionGroupImpl.setPrimaryKey(devisionGroup.getPrimaryKey());

		devisionGroupImpl.setDevisionGroupId(devisionGroup.getDevisionGroupId());
		devisionGroupImpl.setName(devisionGroup.getName());
		devisionGroupImpl.setDevisionId(devisionGroup.getDevisionId());
		devisionGroupImpl.setGroupId(devisionGroup.getGroupId());
		devisionGroupImpl.setCompanyId(devisionGroup.getCompanyId());
		devisionGroupImpl.setUserId(devisionGroup.getUserId());
		devisionGroupImpl.setUserName(devisionGroup.getUserName());
		devisionGroupImpl.setCreateDate(devisionGroup.getCreateDate());
		devisionGroupImpl.setModifiedDate(devisionGroup.getModifiedDate());

		return devisionGroupImpl;
	}

	/**
	 * Returns the devision group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the devision group
	 * @return the devision group
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDevisionGroupException, SystemException {
		DevisionGroup devisionGroup = fetchByPrimaryKey(primaryKey);

		if (devisionGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDevisionGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return devisionGroup;
	}

	/**
	 * Returns the devision group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDevisionGroupException} if it could not be found.
	 *
	 * @param devisionGroupId the primary key of the devision group
	 * @return the devision group
	 * @throws vn.com.ecopharma.emp.NoSuchDevisionGroupException if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup findByPrimaryKey(long devisionGroupId)
		throws NoSuchDevisionGroupException, SystemException {
		return findByPrimaryKey((Serializable)devisionGroupId);
	}

	/**
	 * Returns the devision group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the devision group
	 * @return the devision group, or <code>null</code> if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DevisionGroup devisionGroup = (DevisionGroup)EntityCacheUtil.getResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
				DevisionGroupImpl.class, primaryKey);

		if (devisionGroup == _nullDevisionGroup) {
			return null;
		}

		if (devisionGroup == null) {
			Session session = null;

			try {
				session = openSession();

				devisionGroup = (DevisionGroup)session.get(DevisionGroupImpl.class,
						primaryKey);

				if (devisionGroup != null) {
					cacheResult(devisionGroup);
				}
				else {
					EntityCacheUtil.putResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
						DevisionGroupImpl.class, primaryKey, _nullDevisionGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DevisionGroupModelImpl.ENTITY_CACHE_ENABLED,
					DevisionGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return devisionGroup;
	}

	/**
	 * Returns the devision group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param devisionGroupId the primary key of the devision group
	 * @return the devision group, or <code>null</code> if a devision group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DevisionGroup fetchByPrimaryKey(long devisionGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)devisionGroupId);
	}

	/**
	 * Returns all the devision groups.
	 *
	 * @return the devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DevisionGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the devision groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of devision groups
	 * @param end the upper bound of the range of devision groups (not inclusive)
	 * @return the range of devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DevisionGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the devision groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DevisionGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of devision groups
	 * @param end the upper bound of the range of devision groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of devision groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DevisionGroup> findAll(int start, int end,
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

		List<DevisionGroup> list = (List<DevisionGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEVISIONGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEVISIONGROUP;

				if (pagination) {
					sql = sql.concat(DevisionGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DevisionGroup>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DevisionGroup>(list);
				}
				else {
					list = (List<DevisionGroup>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the devision groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DevisionGroup devisionGroup : findAll()) {
			remove(devisionGroup);
		}
	}

	/**
	 * Returns the number of devision groups.
	 *
	 * @return the number of devision groups
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

				Query q = session.createQuery(_SQL_COUNT_DEVISIONGROUP);

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
	 * Initializes the devision group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.DevisionGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DevisionGroup>> listenersList = new ArrayList<ModelListener<DevisionGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DevisionGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DevisionGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEVISIONGROUP = "SELECT devisionGroup FROM DevisionGroup devisionGroup";
	private static final String _SQL_SELECT_DEVISIONGROUP_WHERE = "SELECT devisionGroup FROM DevisionGroup devisionGroup WHERE ";
	private static final String _SQL_COUNT_DEVISIONGROUP = "SELECT COUNT(devisionGroup) FROM DevisionGroup devisionGroup";
	private static final String _SQL_COUNT_DEVISIONGROUP_WHERE = "SELECT COUNT(devisionGroup) FROM DevisionGroup devisionGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "devisionGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DevisionGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DevisionGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DevisionGroupPersistenceImpl.class);
	private static DevisionGroup _nullDevisionGroup = new DevisionGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DevisionGroup> toCacheModel() {
				return _nullDevisionGroupCacheModel;
			}
		};

	private static CacheModel<DevisionGroup> _nullDevisionGroupCacheModel = new CacheModel<DevisionGroup>() {
			@Override
			public DevisionGroup toEntityModel() {
				return _nullDevisionGroup;
			}
		};
}