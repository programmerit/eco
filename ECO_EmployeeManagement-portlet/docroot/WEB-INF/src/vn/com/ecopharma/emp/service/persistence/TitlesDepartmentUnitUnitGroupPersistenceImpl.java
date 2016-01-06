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

import vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;
import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;
import vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupImpl;
import vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the titles department unit unit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesDepartmentUnitUnitGroupPersistence
 * @see TitlesDepartmentUnitUnitGroupUtil
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupPersistenceImpl
	extends BasePersistenceImpl<TitlesDepartmentUnitUnitGroup>
	implements TitlesDepartmentUnitUnitGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TitlesDepartmentUnitUnitGroupUtil} to access the titles department unit unit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TitlesDepartmentUnitUnitGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDepartment",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDepartment",
			new String[] { Long.class.getName() },
			TitlesDepartmentUnitUnitGroupModelImpl.DEPARTMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENT = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartment", new String[] { Long.class.getName() });

	/**
	 * Returns all the titles department unit unit groups where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId) throws SystemException {
		return findByDepartment(departmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId, int start, int end) throws SystemException {
		return findByDepartment(departmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where departmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByDepartment(
		long departmentId, int start, int end,
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

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((departmentId != titlesDepartmentUnitUnitGroup.getDepartmentId())) {
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

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENT_DEPARTMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByDepartment_First(
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByDepartment_First(departmentId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByDepartment_First(
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByDepartment(departmentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByDepartment_Last(
		long departmentId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByDepartment_Last(departmentId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByDepartment_Last(
		long departmentId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByDepartment(departmentId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByDepartment(departmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where departmentId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param departmentId the department ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByDepartment_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long departmentId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByDepartment_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, departmentId,
					orderByComparator, true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByDepartment_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, departmentId,
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

	protected TitlesDepartmentUnitUnitGroup getByDepartment_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long departmentId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where departmentId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartment(long departmentId) throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByDepartment(
				departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where departmentId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @return the number of matching titles department unit unit groups
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

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_DEPARTMENT_DEPARTMENTID_2 = "titlesDepartmentUnitUnitGroup.departmentId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNIT = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnit",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnit",
			new String[] { Long.class.getName() },
			TitlesDepartmentUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNIT = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUnit", new String[] { Long.class.getName() });

	/**
	 * Returns all the titles department unit unit groups where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnit(long unitId)
		throws SystemException {
		return findByUnit(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnit(long unitId,
		int start, int end) throws SystemException {
		return findByUnit(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnit(long unitId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((unitId != titlesDepartmentUnitUnitGroup.getUnitId())) {
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

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNIT_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByUnit_First(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByUnit_First(unitId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByUnit_First(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByUnit(unitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByUnit_Last(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByUnit_Last(unitId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByUnit_Last(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUnit(unitId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByUnit(unitId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByUnit_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByUnit_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, unitId, orderByComparator,
					true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByUnit_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, unitId, orderByComparator,
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

	protected TitlesDepartmentUnitUnitGroup getByUnit_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long unitId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnit(long unitId) throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByUnit(
				unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching titles department unit unit groups
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

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UNIT_UNITID_2 = "titlesDepartmentUnitUnitGroup.unitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitGroup",
			new String[] { Long.class.getName() },
			TitlesDepartmentUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNITGROUP = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUnitGroup", new String[] { Long.class.getName() });

	/**
	 * Returns all the titles department unit unit groups where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnitGroup(long unitGroupId)
		throws SystemException {
		return findByUnitGroup(unitGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end) throws SystemException {
		return findByUnitGroup(unitGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnitGroup(
		long unitGroupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP;
			finderArgs = new Object[] { unitGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITGROUP;
			finderArgs = new Object[] { unitGroupId, start, end, orderByComparator };
		}

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((unitGroupId != titlesDepartmentUnitUnitGroup.getUnitGroupId())) {
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

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNITGROUP_UNITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitGroupId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByUnitGroup_First(
		long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByUnitGroup_First(unitGroupId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByUnitGroup_First(
		long unitGroupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByUnitGroup(unitGroupId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByUnitGroup_Last(
		long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByUnitGroup_Last(unitGroupId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByUnitGroup_Last(
		long unitGroupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUnitGroup(unitGroupId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByUnitGroup(unitGroupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, unitGroupId,
					orderByComparator, true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, unitGroupId,
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

	protected TitlesDepartmentUnitUnitGroup getByUnitGroup_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long unitGroupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

		query.append(_FINDER_COLUMN_UNITGROUP_UNITGROUPID_2);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where unitGroupId = &#63; from the database.
	 *
	 * @param unitGroupId the unit group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnitGroup(long unitGroupId) throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByUnitGroup(
				unitGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUnitGroup(long unitGroupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UNITGROUP;

		Object[] finderArgs = new Object[] { unitGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitGroupId);

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

	private static final String _FINDER_COLUMN_UNITGROUP_UNITGROUPID_2 = "titlesDepartmentUnitUnitGroup.unitGroupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLES = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitles",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitles",
			new String[] { Long.class.getName() },
			TitlesDepartmentUnitUnitGroupModelImpl.TITLESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLES = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTitles", new String[] { Long.class.getName() });

	/**
	 * Returns all the titles department unit unit groups where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByTitles(long titlesId)
		throws SystemException {
		return findByTitles(titlesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where titlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByTitles(long titlesId,
		int start, int end) throws SystemException {
		return findByTitles(titlesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where titlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByTitles(long titlesId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((titlesId != titlesDepartmentUnitUnitGroup.getTitlesId())) {
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

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLES_TITLESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByTitles_First(long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByTitles_First(titlesId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByTitles_First(long titlesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByTitles(titlesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByTitles_Last(long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByTitles_Last(titlesId,
				orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByTitles_Last(long titlesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitles(titlesId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByTitles(titlesId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByTitles_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByTitles_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, titlesId, orderByComparator,
					true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByTitles_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, titlesId, orderByComparator,
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

	protected TitlesDepartmentUnitUnitGroup getByTitles_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long titlesId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titlesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where titlesId = &#63; from the database.
	 *
	 * @param titlesId the titles ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitles(long titlesId) throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByTitles(
				titlesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @return the number of matching titles department unit unit groups
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

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_TITLES_TITLESID_2 = "titlesDepartmentUnitUnitGroup.titlesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByDepartmentUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByDepartmentUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TitlesDepartmentUnitUnitGroupModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEPARTMENTUNITUNITGROUP = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDepartmentUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId)
		throws SystemException {
		return findByDepartmentUnitUnitGroup(departmentId, unitId, unitGroupId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId, int start, int end)
		throws SystemException {
		return findByDepartmentUnitUnitGroup(departmentId, unitId, unitGroupId,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
		long departmentId, long unitId, long unitGroupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP;
			finderArgs = new Object[] { departmentId, unitId, unitGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP;
			finderArgs = new Object[] {
					departmentId, unitId, unitGroupId,
					
					start, end, orderByComparator
				};
		}

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((departmentId != titlesDepartmentUnitUnitGroup.getDepartmentId()) ||
						(unitId != titlesDepartmentUnitUnitGroup.getUnitId()) ||
						(unitGroupId != titlesDepartmentUnitUnitGroup.getUnitGroupId())) {
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

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByDepartmentUnitUnitGroup_First(
		long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByDepartmentUnitUnitGroup_First(departmentId,
				unitId, unitGroupId, orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByDepartmentUnitUnitGroup_First(
		long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByDepartmentUnitUnitGroup(departmentId,
				unitId, unitGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByDepartmentUnitUnitGroup_Last(
		long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByDepartmentUnitUnitGroup_Last(departmentId,
				unitId, unitGroupId, orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("departmentId=");
		msg.append(departmentId);

		msg.append(", unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByDepartmentUnitUnitGroup_Last(
		long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDepartmentUnitUnitGroup(departmentId, unitId,
				unitGroupId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByDepartmentUnitUnitGroup(departmentId,
				unitId, unitGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByDepartmentUnitUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long departmentId, long unitId,
		long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByDepartmentUnitUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, departmentId, unitId,
					unitGroupId, orderByComparator, true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByDepartmentUnitUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, departmentId, unitId,
					unitGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TitlesDepartmentUnitUnitGroup getByDepartmentUnitUnitGroup_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

		query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITID_2);

		query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITGROUPID_2);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(departmentId);

		qPos.add(unitId);

		qPos.add(unitGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDepartmentUnitUnitGroup(long departmentId, long unitId,
		long unitGroupId) throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByDepartmentUnitUnitGroup(
				departmentId, unitId, unitGroupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDepartmentUnitUnitGroup(long departmentId, long unitId,
		long unitGroupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DEPARTMENTUNITUNITGROUP;

		Object[] finderArgs = new Object[] { departmentId, unitId, unitGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(departmentId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

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

	private static final String _FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_DEPARTMENTID_2 =
		"titlesDepartmentUnitUnitGroup.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITID_2 = "titlesDepartmentUnitUnitGroup.unitId = ? AND ";
	private static final String _FINDER_COLUMN_DEPARTMENTUNITUNITGROUP_UNITGROUPID_2 =
		"titlesDepartmentUnitUnitGroup.unitGroupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTitlesDepartmentUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			TitlesDepartmentUnitUnitGroupModelImpl.TITLESID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTitlesDepartmentUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException} if it could not be found.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByTitlesDepartmentUnitUnitGroup(titlesId,
				departmentId, unitId, unitGroupId);

		if (titlesDepartmentUnitUnitGroup == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("titlesId=");
			msg.append(titlesId);

			msg.append(", departmentId=");
			msg.append(departmentId);

			msg.append(", unitId=");
			msg.append(unitId);

			msg.append(", unitGroupId=");
			msg.append(unitGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
		}

		return titlesDepartmentUnitUnitGroup;
	}

	/**
	 * Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws SystemException {
		return fetchByTitlesDepartmentUnitUnitGroup(titlesId, departmentId,
			unitId, unitGroupId, true);
	}

	/**
	 * Returns the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				titlesId, departmentId, unitId, unitGroupId
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
					finderArgs, this);
		}

		if (result instanceof TitlesDepartmentUnitUnitGroup) {
			TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = (TitlesDepartmentUnitUnitGroup)result;

			if ((titlesId != titlesDepartmentUnitUnitGroup.getTitlesId()) ||
					(departmentId != titlesDepartmentUnitUnitGroup.getDepartmentId()) ||
					(unitId != titlesDepartmentUnitUnitGroup.getUnitId()) ||
					(unitGroupId != titlesDepartmentUnitUnitGroup.getUnitGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_TITLESID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				qPos.add(departmentId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

				List<TitlesDepartmentUnitUnitGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TitlesDepartmentUnitUnitGroupPersistenceImpl.fetchByTitlesDepartmentUnitUnitGroup(long, long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = list.get(0);

					result = titlesDepartmentUnitUnitGroup;

					cacheResult(titlesDepartmentUnitUnitGroup);

					if ((titlesDepartmentUnitUnitGroup.getTitlesId() != titlesId) ||
							(titlesDepartmentUnitUnitGroup.getDepartmentId() != departmentId) ||
							(titlesDepartmentUnitUnitGroup.getUnitId() != unitId) ||
							(titlesDepartmentUnitUnitGroup.getUnitGroupId() != unitGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
							finderArgs, titlesDepartmentUnitUnitGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
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
			return (TitlesDepartmentUnitUnitGroup)result;
		}
	}

	/**
	 * Removes the titles department unit unit group where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the titles department unit unit group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup removeByTitlesDepartmentUnitUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByTitlesDepartmentUnitUnitGroup(titlesId,
				departmentId, unitId, unitGroupId);

		return remove(titlesDepartmentUnitUnitGroup);
	}

	/**
	 * Returns the number of titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitlesDepartmentUnitUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITUNITGROUP;

		Object[] finderArgs = new Object[] {
				titlesId, departmentId, unitId, unitGroupId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_TITLESID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				qPos.add(departmentId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

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

	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_TITLESID_2 =
		"titlesDepartmentUnitUnitGroup.titlesId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_DEPARTMENTID_2 =
		"titlesDepartmentUnitUnitGroup.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_UNITID_2 =
		"titlesDepartmentUnitUnitGroup.unitId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITUNITGROUP_UNITGROUPID_2 =
		"titlesDepartmentUnitUnitGroup.unitGroupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITANDUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitAndUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUnitAndUnitGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TitlesDepartmentUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNITANDUNITGROUP = new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUnitAndUnitGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId) throws SystemException {
		return findByUnitAndUnitGroup(unitId, unitGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end)
		throws SystemException {
		return findByUnitAndUnitGroup(unitId, unitGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByUnitAndUnitGroup(
		long unitId, long unitGroupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP;
			finderArgs = new Object[] { unitId, unitGroupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITANDUNITGROUP;
			finderArgs = new Object[] {
					unitId, unitGroupId,
					
					start, end, orderByComparator
				};
		}

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((unitId != titlesDepartmentUnitUnitGroup.getUnitId()) ||
						(unitGroupId != titlesDepartmentUnitUnitGroup.getUnitGroupId())) {
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

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

				qPos.add(unitGroupId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByUnitAndUnitGroup_First(
		long unitId, long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByUnitAndUnitGroup_First(unitId,
				unitGroupId, orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByUnitAndUnitGroup_First(
		long unitId, long unitGroupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByUnitAndUnitGroup(unitId,
				unitGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByUnitAndUnitGroup_Last(unitId,
				unitGroupId, orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByUnitAndUnitGroup_Last(
		long unitId, long unitGroupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUnitAndUnitGroup(unitId, unitGroupId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByUnitAndUnitGroup(unitId,
				unitGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByUnitAndUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByUnitAndUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, unitId, unitGroupId,
					orderByComparator, true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByUnitAndUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, unitId, unitGroupId,
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

	protected TitlesDepartmentUnitUnitGroup getByUnitAndUnitGroup_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long unitId, long unitGroupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

		query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITID_2);

		query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITGROUPID_2);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitId);

		qPos.add(unitGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where unitId = &#63; and unitGroupId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByUnitAndUnitGroup(
				unitId, unitGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UNITANDUNITGROUP;

		Object[] finderArgs = new Object[] { unitId, unitGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

				qPos.add(unitGroupId);

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

	private static final String _FINDER_COLUMN_UNITANDUNITGROUP_UNITID_2 = "titlesDepartmentUnitUnitGroup.unitId = ? AND ";
	private static final String _FINDER_COLUMN_UNITANDUNITGROUP_UNITGROUPID_2 = "titlesDepartmentUnitUnitGroup.unitGroupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTitlesDepartmentUnitNoneUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTitlesDepartmentUnitNoneUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			},
			TitlesDepartmentUnitUnitGroupModelImpl.TITLESID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.DEPARTMENTID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK |
			TitlesDepartmentUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITNONEUNITGROUP =
		new FinderPath(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTitlesDepartmentUnitNoneUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId)
		throws SystemException {
		return findByTitlesDepartmentUnitNoneUnitGroup(titlesId, departmentId,
			unitId, unitGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		int start, int end) throws SystemException {
		return findByTitlesDepartmentUnitNoneUnitGroup(titlesId, departmentId,
			unitId, unitGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP;
			finderArgs = new Object[] {
					titlesId, departmentId, unitId, unitGroupId
				};
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP;
			finderArgs = new Object[] {
					titlesId, departmentId, unitId, unitGroupId,
					
					start, end, orderByComparator
				};
		}

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : list) {
				if ((titlesId != titlesDepartmentUnitUnitGroup.getTitlesId()) ||
						(departmentId != titlesDepartmentUnitUnitGroup.getDepartmentId()) ||
						(unitId != titlesDepartmentUnitUnitGroup.getUnitId()) ||
						(unitGroupId != titlesDepartmentUnitUnitGroup.getUnitGroupId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_TITLESID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				qPos.add(departmentId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitNoneUnitGroup_First(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByTitlesDepartmentUnitNoneUnitGroup_First(titlesId,
				departmentId, unitId, unitGroupId, orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitNoneUnitGroup_First(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesDepartmentUnitUnitGroup> list = findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
				departmentId, unitId, unitGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitNoneUnitGroup_Last(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByTitlesDepartmentUnitNoneUnitGroup_Last(titlesId,
				departmentId, unitId, unitGroupId, orderByComparator);

		if (titlesDepartmentUnitUnitGroup != null) {
			return titlesDepartmentUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(", departmentId=");
		msg.append(departmentId);

		msg.append(", unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesDepartmentUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles department unit unit group, or <code>null</code> if a matching titles department unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByTitlesDepartmentUnitNoneUnitGroup_Last(
		long titlesId, long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitlesDepartmentUnitNoneUnitGroup(titlesId,
				departmentId, unitId, unitGroupId);

		if (count == 0) {
			return null;
		}

		List<TitlesDepartmentUnitUnitGroup> list = findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
				departmentId, unitId, unitGroupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles department unit unit groups before and after the current titles department unit unit group in the ordered set where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the current titles department unit unit group
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup[] findByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(
		long titlesDepartmentUnitUnitGroupId, long titlesId, long departmentId,
		long unitId, long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = findByPrimaryKey(titlesDepartmentUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup[] array = new TitlesDepartmentUnitUnitGroupImpl[3];

			array[0] = getByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, titlesId, departmentId,
					unitId, unitGroupId, orderByComparator, true);

			array[1] = titlesDepartmentUnitUnitGroup;

			array[2] = getByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(session,
					titlesDepartmentUnitUnitGroup, titlesId, departmentId,
					unitId, unitGroupId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TitlesDepartmentUnitUnitGroup getByTitlesDepartmentUnitNoneUnitGroup_PrevAndNext(
		Session session,
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup,
		long titlesId, long departmentId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

		query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_TITLESID_2);

		query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_DEPARTMENTID_2);

		query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITID_2);

		query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITGROUPID_2);

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
			query.append(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titlesId);

		qPos.add(departmentId);

		qPos.add(unitId);

		qPos.add(unitGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesDepartmentUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesDepartmentUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitlesDepartmentUnitNoneUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findByTitlesDepartmentUnitNoneUnitGroup(
				titlesId, departmentId, unitId, unitGroupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups where titlesId = &#63; and departmentId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param departmentId the department ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitlesDepartmentUnitNoneUnitGroup(long titlesId,
		long departmentId, long unitId, long unitGroupId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITNONEUNITGROUP;

		Object[] finderArgs = new Object[] {
				titlesId, departmentId, unitId, unitGroupId
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_TITLESID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_DEPARTMENTID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				qPos.add(departmentId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

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

	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_TITLESID_2 =
		"titlesDepartmentUnitUnitGroup.titlesId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_DEPARTMENTID_2 =
		"titlesDepartmentUnitUnitGroup.departmentId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITID_2 =
		"titlesDepartmentUnitUnitGroup.unitId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESDEPARTMENTUNITNONEUNITGROUP_UNITGROUPID_2 =
		"titlesDepartmentUnitUnitGroup.unitGroupId = ?";

	public TitlesDepartmentUnitUnitGroupPersistenceImpl() {
		setModelClass(TitlesDepartmentUnitUnitGroup.class);
	}

	/**
	 * Caches the titles department unit unit group in the entity cache if it is enabled.
	 *
	 * @param titlesDepartmentUnitUnitGroup the titles department unit unit group
	 */
	@Override
	public void cacheResult(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		EntityCacheUtil.putResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			titlesDepartmentUnitUnitGroup.getPrimaryKey(),
			titlesDepartmentUnitUnitGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
			new Object[] {
				titlesDepartmentUnitUnitGroup.getTitlesId(),
				titlesDepartmentUnitUnitGroup.getDepartmentId(),
				titlesDepartmentUnitUnitGroup.getUnitId(),
				titlesDepartmentUnitUnitGroup.getUnitGroupId()
			}, titlesDepartmentUnitUnitGroup);

		titlesDepartmentUnitUnitGroup.resetOriginalValues();
	}

	/**
	 * Caches the titles department unit unit groups in the entity cache if it is enabled.
	 *
	 * @param titlesDepartmentUnitUnitGroups the titles department unit unit groups
	 */
	@Override
	public void cacheResult(
		List<TitlesDepartmentUnitUnitGroup> titlesDepartmentUnitUnitGroups) {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : titlesDepartmentUnitUnitGroups) {
			if (EntityCacheUtil.getResult(
						TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
						TitlesDepartmentUnitUnitGroupImpl.class,
						titlesDepartmentUnitUnitGroup.getPrimaryKey()) == null) {
				cacheResult(titlesDepartmentUnitUnitGroup);
			}
			else {
				titlesDepartmentUnitUnitGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all titles department unit unit groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TitlesDepartmentUnitUnitGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TitlesDepartmentUnitUnitGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the titles department unit unit group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		EntityCacheUtil.removeResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			titlesDepartmentUnitUnitGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(titlesDepartmentUnitUnitGroup);
	}

	@Override
	public void clearCache(
		List<TitlesDepartmentUnitUnitGroup> titlesDepartmentUnitUnitGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : titlesDepartmentUnitUnitGroups) {
			EntityCacheUtil.removeResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
				TitlesDepartmentUnitUnitGroupImpl.class,
				titlesDepartmentUnitUnitGroup.getPrimaryKey());

			clearUniqueFindersCache(titlesDepartmentUnitUnitGroup);
		}
	}

	protected void cacheUniqueFindersCache(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		if (titlesDepartmentUnitUnitGroup.isNew()) {
			Object[] args = new Object[] {
					titlesDepartmentUnitUnitGroup.getTitlesId(),
					titlesDepartmentUnitUnitGroup.getDepartmentId(),
					titlesDepartmentUnitUnitGroup.getUnitId(),
					titlesDepartmentUnitUnitGroup.getUnitGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITUNITGROUP,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
				args, titlesDepartmentUnitUnitGroup);
		}
		else {
			TitlesDepartmentUnitUnitGroupModelImpl titlesDepartmentUnitUnitGroupModelImpl =
				(TitlesDepartmentUnitUnitGroupModelImpl)titlesDepartmentUnitUnitGroup;

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroup.getTitlesId(),
						titlesDepartmentUnitUnitGroup.getDepartmentId(),
						titlesDepartmentUnitUnitGroup.getUnitId(),
						titlesDepartmentUnitUnitGroup.getUnitGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITUNITGROUP,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
					args, titlesDepartmentUnitUnitGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		TitlesDepartmentUnitUnitGroupModelImpl titlesDepartmentUnitUnitGroupModelImpl =
			(TitlesDepartmentUnitUnitGroupModelImpl)titlesDepartmentUnitUnitGroup;

		Object[] args = new Object[] {
				titlesDepartmentUnitUnitGroup.getTitlesId(),
				titlesDepartmentUnitUnitGroup.getDepartmentId(),
				titlesDepartmentUnitUnitGroup.getUnitId(),
				titlesDepartmentUnitUnitGroup.getUnitGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITUNITGROUP,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
			args);

		if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP.getColumnBitmask()) != 0) {
			args = new Object[] {
					titlesDepartmentUnitUnitGroupModelImpl.getOriginalTitlesId(),
					titlesDepartmentUnitUnitGroupModelImpl.getOriginalDepartmentId(),
					titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitId(),
					titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITUNITGROUP,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLESDEPARTMENTUNITUNITGROUP,
				args);
		}
	}

	/**
	 * Creates a new titles department unit unit group with the primary key. Does not add the titles department unit unit group to the database.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key for the new titles department unit unit group
	 * @return the new titles department unit unit group
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup create(
		long titlesDepartmentUnitUnitGroupId) {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = new TitlesDepartmentUnitUnitGroupImpl();

		titlesDepartmentUnitUnitGroup.setNew(true);
		titlesDepartmentUnitUnitGroup.setPrimaryKey(titlesDepartmentUnitUnitGroupId);

		return titlesDepartmentUnitUnitGroup;
	}

	/**
	 * Removes the titles department unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	 * @return the titles department unit unit group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup remove(
		long titlesDepartmentUnitUnitGroupId)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		return remove((Serializable)titlesDepartmentUnitUnitGroupId);
	}

	/**
	 * Removes the titles department unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the titles department unit unit group
	 * @return the titles department unit unit group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup remove(Serializable primaryKey)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = (TitlesDepartmentUnitUnitGroup)session.get(TitlesDepartmentUnitUnitGroupImpl.class,
					primaryKey);

			if (titlesDepartmentUnitUnitGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTitlesDepartmentUnitUnitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(titlesDepartmentUnitUnitGroup);
		}
		catch (NoSuchTitlesDepartmentUnitUnitGroupException nsee) {
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
	protected TitlesDepartmentUnitUnitGroup removeImpl(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws SystemException {
		titlesDepartmentUnitUnitGroup = toUnwrappedModel(titlesDepartmentUnitUnitGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(titlesDepartmentUnitUnitGroup)) {
				titlesDepartmentUnitUnitGroup = (TitlesDepartmentUnitUnitGroup)session.get(TitlesDepartmentUnitUnitGroupImpl.class,
						titlesDepartmentUnitUnitGroup.getPrimaryKeyObj());
			}

			if (titlesDepartmentUnitUnitGroup != null) {
				session.delete(titlesDepartmentUnitUnitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (titlesDepartmentUnitUnitGroup != null) {
			clearCache(titlesDepartmentUnitUnitGroup);
		}

		return titlesDepartmentUnitUnitGroup;
	}

	@Override
	public TitlesDepartmentUnitUnitGroup updateImpl(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup)
		throws SystemException {
		titlesDepartmentUnitUnitGroup = toUnwrappedModel(titlesDepartmentUnitUnitGroup);

		boolean isNew = titlesDepartmentUnitUnitGroup.isNew();

		TitlesDepartmentUnitUnitGroupModelImpl titlesDepartmentUnitUnitGroupModelImpl =
			(TitlesDepartmentUnitUnitGroupModelImpl)titlesDepartmentUnitUnitGroup;

		Session session = null;

		try {
			session = openSession();

			if (titlesDepartmentUnitUnitGroup.isNew()) {
				session.save(titlesDepartmentUnitUnitGroup);

				titlesDepartmentUnitUnitGroup.setNew(false);
			}
			else {
				session.merge(titlesDepartmentUnitUnitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew ||
				!TitlesDepartmentUnitUnitGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getDepartmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENT,
					args);
			}

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);
			}

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP,
					args);
			}

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalTitlesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getTitlesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES,
					args);
			}

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalDepartmentId(),
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitId(),
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTUNITUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getDepartmentId(),
						titlesDepartmentUnitUnitGroupModelImpl.getUnitId(),
						titlesDepartmentUnitUnitGroupModelImpl.getUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEPARTMENTUNITUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEPARTMENTUNITUNITGROUP,
					args);
			}

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitId(),
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITANDUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getUnitId(),
						titlesDepartmentUnitUnitGroupModelImpl.getUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITANDUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP,
					args);
			}

			if ((titlesDepartmentUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalTitlesId(),
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalDepartmentId(),
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitId(),
						titlesDepartmentUnitUnitGroupModelImpl.getOriginalUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITNONEUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP,
					args);

				args = new Object[] {
						titlesDepartmentUnitUnitGroupModelImpl.getTitlesId(),
						titlesDepartmentUnitUnitGroupModelImpl.getDepartmentId(),
						titlesDepartmentUnitUnitGroupModelImpl.getUnitId(),
						titlesDepartmentUnitUnitGroupModelImpl.getUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLESDEPARTMENTUNITNONEUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLESDEPARTMENTUNITNONEUNITGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesDepartmentUnitUnitGroupImpl.class,
			titlesDepartmentUnitUnitGroup.getPrimaryKey(),
			titlesDepartmentUnitUnitGroup);

		clearUniqueFindersCache(titlesDepartmentUnitUnitGroup);
		cacheUniqueFindersCache(titlesDepartmentUnitUnitGroup);

		return titlesDepartmentUnitUnitGroup;
	}

	protected TitlesDepartmentUnitUnitGroup toUnwrappedModel(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		if (titlesDepartmentUnitUnitGroup instanceof TitlesDepartmentUnitUnitGroupImpl) {
			return titlesDepartmentUnitUnitGroup;
		}

		TitlesDepartmentUnitUnitGroupImpl titlesDepartmentUnitUnitGroupImpl = new TitlesDepartmentUnitUnitGroupImpl();

		titlesDepartmentUnitUnitGroupImpl.setNew(titlesDepartmentUnitUnitGroup.isNew());
		titlesDepartmentUnitUnitGroupImpl.setPrimaryKey(titlesDepartmentUnitUnitGroup.getPrimaryKey());

		titlesDepartmentUnitUnitGroupImpl.setTitlesDepartmentUnitUnitGroupId(titlesDepartmentUnitUnitGroup.getTitlesDepartmentUnitUnitGroupId());
		titlesDepartmentUnitUnitGroupImpl.setTitlesId(titlesDepartmentUnitUnitGroup.getTitlesId());
		titlesDepartmentUnitUnitGroupImpl.setDepartmentId(titlesDepartmentUnitUnitGroup.getDepartmentId());
		titlesDepartmentUnitUnitGroupImpl.setUnitId(titlesDepartmentUnitUnitGroup.getUnitId());
		titlesDepartmentUnitUnitGroupImpl.setUnitGroupId(titlesDepartmentUnitUnitGroup.getUnitGroupId());
		titlesDepartmentUnitUnitGroupImpl.setGroupId(titlesDepartmentUnitUnitGroup.getGroupId());
		titlesDepartmentUnitUnitGroupImpl.setCompanyId(titlesDepartmentUnitUnitGroup.getCompanyId());
		titlesDepartmentUnitUnitGroupImpl.setUserId(titlesDepartmentUnitUnitGroup.getUserId());
		titlesDepartmentUnitUnitGroupImpl.setUserName(titlesDepartmentUnitUnitGroup.getUserName());
		titlesDepartmentUnitUnitGroupImpl.setCreateDate(titlesDepartmentUnitUnitGroup.getCreateDate());
		titlesDepartmentUnitUnitGroupImpl.setModifiedDate(titlesDepartmentUnitUnitGroup.getModifiedDate());

		return titlesDepartmentUnitUnitGroupImpl;
	}

	/**
	 * Returns the titles department unit unit group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the titles department unit unit group
	 * @return the titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByPrimaryKey(
		Serializable primaryKey)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = fetchByPrimaryKey(primaryKey);

		if (titlesDepartmentUnitUnitGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTitlesDepartmentUnitUnitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return titlesDepartmentUnitUnitGroup;
	}

	/**
	 * Returns the titles department unit unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException} if it could not be found.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	 * @return the titles department unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup findByPrimaryKey(
		long titlesDepartmentUnitUnitGroupId)
		throws NoSuchTitlesDepartmentUnitUnitGroupException, SystemException {
		return findByPrimaryKey((Serializable)titlesDepartmentUnitUnitGroupId);
	}

	/**
	 * Returns the titles department unit unit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the titles department unit unit group
	 * @return the titles department unit unit group, or <code>null</code> if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByPrimaryKey(
		Serializable primaryKey) throws SystemException {
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup = (TitlesDepartmentUnitUnitGroup)EntityCacheUtil.getResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
				TitlesDepartmentUnitUnitGroupImpl.class, primaryKey);

		if (titlesDepartmentUnitUnitGroup == _nullTitlesDepartmentUnitUnitGroup) {
			return null;
		}

		if (titlesDepartmentUnitUnitGroup == null) {
			Session session = null;

			try {
				session = openSession();

				titlesDepartmentUnitUnitGroup = (TitlesDepartmentUnitUnitGroup)session.get(TitlesDepartmentUnitUnitGroupImpl.class,
						primaryKey);

				if (titlesDepartmentUnitUnitGroup != null) {
					cacheResult(titlesDepartmentUnitUnitGroup);
				}
				else {
					EntityCacheUtil.putResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
						TitlesDepartmentUnitUnitGroupImpl.class, primaryKey,
						_nullTitlesDepartmentUnitUnitGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TitlesDepartmentUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
					TitlesDepartmentUnitUnitGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return titlesDepartmentUnitUnitGroup;
	}

	/**
	 * Returns the titles department unit unit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param titlesDepartmentUnitUnitGroupId the primary key of the titles department unit unit group
	 * @return the titles department unit unit group, or <code>null</code> if a titles department unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesDepartmentUnitUnitGroup fetchByPrimaryKey(
		long titlesDepartmentUnitUnitGroupId) throws SystemException {
		return fetchByPrimaryKey((Serializable)titlesDepartmentUnitUnitGroupId);
	}

	/**
	 * Returns all the titles department unit unit groups.
	 *
	 * @return the titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findAll()
		throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles department unit unit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @return the range of titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles department unit unit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of titles department unit unit groups
	 * @param end the upper bound of the range of titles department unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of titles department unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesDepartmentUnitUnitGroup> findAll(int start, int end,
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

		List<TitlesDepartmentUnitUnitGroup> list = (List<TitlesDepartmentUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP;

				if (pagination) {
					sql = sql.concat(TitlesDepartmentUnitUnitGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesDepartmentUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesDepartmentUnitUnitGroup>)QueryUtil.list(q,
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
	 * Removes all the titles department unit unit groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup : findAll()) {
			remove(titlesDepartmentUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles department unit unit groups.
	 *
	 * @return the number of titles department unit unit groups
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

				Query q = session.createQuery(_SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP);

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
	 * Initializes the titles department unit unit group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TitlesDepartmentUnitUnitGroup>> listenersList =
					new ArrayList<ModelListener<TitlesDepartmentUnitUnitGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TitlesDepartmentUnitUnitGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TitlesDepartmentUnitUnitGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP = "SELECT titlesDepartmentUnitUnitGroup FROM TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup";
	private static final String _SQL_SELECT_TITLESDEPARTMENTUNITUNITGROUP_WHERE = "SELECT titlesDepartmentUnitUnitGroup FROM TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup WHERE ";
	private static final String _SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP = "SELECT COUNT(titlesDepartmentUnitUnitGroup) FROM TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup";
	private static final String _SQL_COUNT_TITLESDEPARTMENTUNITUNITGROUP_WHERE = "SELECT COUNT(titlesDepartmentUnitUnitGroup) FROM TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "titlesDepartmentUnitUnitGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TitlesDepartmentUnitUnitGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TitlesDepartmentUnitUnitGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TitlesDepartmentUnitUnitGroupPersistenceImpl.class);
	private static TitlesDepartmentUnitUnitGroup _nullTitlesDepartmentUnitUnitGroup =
		new TitlesDepartmentUnitUnitGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TitlesDepartmentUnitUnitGroup> toCacheModel() {
				return _nullTitlesDepartmentUnitUnitGroupCacheModel;
			}
		};

	private static CacheModel<TitlesDepartmentUnitUnitGroup> _nullTitlesDepartmentUnitUnitGroupCacheModel =
		new CacheModel<TitlesDepartmentUnitUnitGroup>() {
			@Override
			public TitlesDepartmentUnitUnitGroup toEntityModel() {
				return _nullTitlesDepartmentUnitUnitGroup;
			}
		};
}