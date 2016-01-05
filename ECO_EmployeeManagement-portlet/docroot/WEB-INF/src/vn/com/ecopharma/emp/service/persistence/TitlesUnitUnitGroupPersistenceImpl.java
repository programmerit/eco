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

import vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;
import vn.com.ecopharma.emp.model.TitlesUnitUnitGroup;
import vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupImpl;
import vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the titles unit unit group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see TitlesUnitUnitGroupPersistence
 * @see TitlesUnitUnitGroupUtil
 * @generated
 */
public class TitlesUnitUnitGroupPersistenceImpl extends BasePersistenceImpl<TitlesUnitUnitGroup>
	implements TitlesUnitUnitGroupPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TitlesUnitUnitGroupUtil} to access the titles unit unit group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TitlesUnitUnitGroupImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNIT = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnit",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnit",
			new String[] { Long.class.getName() },
			TitlesUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNIT = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnit",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the titles unit unit groups where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnit(long unitId)
		throws SystemException {
		return findByUnit(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles unit unit groups where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @return the range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnit(long unitId, int start, int end)
		throws SystemException {
		return findByUnit(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles unit unit groups where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnit(long unitId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
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

		List<TitlesUnitUnitGroup> list = (List<TitlesUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesUnitUnitGroup titlesUnitUnitGroup : list) {
				if ((unitId != titlesUnitUnitGroup.getUnitId())) {
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

			query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNIT_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

				if (!pagination) {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByUnit_First(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByUnit_First(unitId,
				orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByUnit_First(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesUnitUnitGroup> list = findByUnit(unitId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByUnit_Last(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByUnit_Last(unitId,
				orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByUnit_Last(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUnit(unitId);

		if (count == 0) {
			return null;
		}

		List<TitlesUnitUnitGroup> list = findByUnit(unitId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where unitId = &#63;.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup[] findByUnit_PrevAndNext(
		long titlesUnitUnitGroupId, long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = findByPrimaryKey(titlesUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesUnitUnitGroup[] array = new TitlesUnitUnitGroupImpl[3];

			array[0] = getByUnit_PrevAndNext(session, titlesUnitUnitGroup,
					unitId, orderByComparator, true);

			array[1] = titlesUnitUnitGroup;

			array[2] = getByUnit_PrevAndNext(session, titlesUnitUnitGroup,
					unitId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TitlesUnitUnitGroup getByUnit_PrevAndNext(Session session,
		TitlesUnitUnitGroup titlesUnitUnitGroup, long unitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

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
			query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles unit unit groups where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnit(long unitId) throws SystemException {
		for (TitlesUnitUnitGroup titlesUnitUnitGroup : findByUnit(unitId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles unit unit groups where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching titles unit unit groups
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

			query.append(_SQL_COUNT_TITLESUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UNIT_UNITID_2 = "titlesUnitUnitGroup.unitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITGROUP =
		new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitGroup",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP =
		new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitGroup",
			new String[] { Long.class.getName() },
			TitlesUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNITGROUP = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitGroup",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the titles unit unit groups where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @return the matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnitGroup(long unitGroupId)
		throws SystemException {
		return findByUnitGroup(unitGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles unit unit groups where unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @return the range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnitGroup(long unitGroupId,
		int start, int end) throws SystemException {
		return findByUnitGroup(unitGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles unit unit groups where unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnitGroup(long unitGroupId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
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

		List<TitlesUnitUnitGroup> list = (List<TitlesUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesUnitUnitGroup titlesUnitUnitGroup : list) {
				if ((unitGroupId != titlesUnitUnitGroup.getUnitGroupId())) {
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

			query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNITGROUP_UNITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitGroupId);

				if (!pagination) {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByUnitGroup_First(long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByUnitGroup_First(unitGroupId,
				orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByUnitGroup_First(long unitGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesUnitUnitGroup> list = findByUnitGroup(unitGroupId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByUnitGroup_Last(long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByUnitGroup_Last(unitGroupId,
				orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByUnitGroup_Last(long unitGroupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUnitGroup(unitGroupId);

		if (count == 0) {
			return null;
		}

		List<TitlesUnitUnitGroup> list = findByUnitGroup(unitGroupId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where unitGroupId = &#63;.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup[] findByUnitGroup_PrevAndNext(
		long titlesUnitUnitGroupId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = findByPrimaryKey(titlesUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesUnitUnitGroup[] array = new TitlesUnitUnitGroupImpl[3];

			array[0] = getByUnitGroup_PrevAndNext(session, titlesUnitUnitGroup,
					unitGroupId, orderByComparator, true);

			array[1] = titlesUnitUnitGroup;

			array[2] = getByUnitGroup_PrevAndNext(session, titlesUnitUnitGroup,
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

	protected TitlesUnitUnitGroup getByUnitGroup_PrevAndNext(Session session,
		TitlesUnitUnitGroup titlesUnitUnitGroup, long unitGroupId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

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
			query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles unit unit groups where unitGroupId = &#63; from the database.
	 *
	 * @param unitGroupId the unit group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnitGroup(long unitGroupId) throws SystemException {
		for (TitlesUnitUnitGroup titlesUnitUnitGroup : findByUnitGroup(
				unitGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles unit unit groups where unitGroupId = &#63;.
	 *
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles unit unit groups
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

			query.append(_SQL_COUNT_TITLESUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UNITGROUP_UNITGROUPID_2 = "titlesUnitUnitGroup.unitGroupId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByTitlesUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			TitlesUnitUnitGroupModelImpl.TITLESID_COLUMN_BITMASK |
			TitlesUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK |
			TitlesUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLESUNITUNITGROUP = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTitlesUnitUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException} if it could not be found.
	 *
	 * @param titlesId the titles ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByTitlesUnitUnitGroup(long titlesId,
		long unitId, long unitGroupId)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByTitlesUnitUnitGroup(titlesId,
				unitId, unitGroupId);

		if (titlesUnitUnitGroup == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("titlesId=");
			msg.append(titlesId);

			msg.append(", unitId=");
			msg.append(unitId);

			msg.append(", unitGroupId=");
			msg.append(unitGroupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
		}

		return titlesUnitUnitGroup;
	}

	/**
	 * Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param titlesId the titles ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByTitlesUnitUnitGroup(long titlesId,
		long unitId, long unitGroupId) throws SystemException {
		return fetchByTitlesUnitUnitGroup(titlesId, unitId, unitGroupId, true);
	}

	/**
	 * Returns the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param titlesId the titles ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByTitlesUnitUnitGroup(long titlesId,
		long unitId, long unitGroupId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { titlesId, unitId, unitGroupId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
					finderArgs, this);
		}

		if (result instanceof TitlesUnitUnitGroup) {
			TitlesUnitUnitGroup titlesUnitUnitGroup = (TitlesUnitUnitGroup)result;

			if ((titlesId != titlesUnitUnitGroup.getTitlesId()) ||
					(unitId != titlesUnitUnitGroup.getUnitId()) ||
					(unitGroupId != titlesUnitUnitGroup.getUnitGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLESUNITUNITGROUP_TITLESID_2);

			query.append(_FINDER_COLUMN_TITLESUNITUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_TITLESUNITUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				qPos.add(unitId);

				qPos.add(unitGroupId);

				List<TitlesUnitUnitGroup> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"TitlesUnitUnitGroupPersistenceImpl.fetchByTitlesUnitUnitGroup(long, long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					TitlesUnitUnitGroup titlesUnitUnitGroup = list.get(0);

					result = titlesUnitUnitGroup;

					cacheResult(titlesUnitUnitGroup);

					if ((titlesUnitUnitGroup.getTitlesId() != titlesId) ||
							(titlesUnitUnitGroup.getUnitId() != unitId) ||
							(titlesUnitUnitGroup.getUnitGroupId() != unitGroupId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
							finderArgs, titlesUnitUnitGroup);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
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
			return (TitlesUnitUnitGroup)result;
		}
	}

	/**
	 * Removes the titles unit unit group where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63; from the database.
	 *
	 * @param titlesId the titles ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the titles unit unit group that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup removeByTitlesUnitUnitGroup(long titlesId,
		long unitId, long unitGroupId)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = findByTitlesUnitUnitGroup(titlesId,
				unitId, unitGroupId);

		return remove(titlesUnitUnitGroup);
	}

	/**
	 * Returns the number of titles unit unit groups where titlesId = &#63; and unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTitlesUnitUnitGroup(long titlesId, long unitId,
		long unitGroupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TITLESUNITUNITGROUP;

		Object[] finderArgs = new Object[] { titlesId, unitId, unitGroupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TITLESUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLESUNITUNITGROUP_TITLESID_2);

			query.append(_FINDER_COLUMN_TITLESUNITUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_TITLESUNITUNITGROUP_UNITGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

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

	private static final String _FINDER_COLUMN_TITLESUNITUNITGROUP_TITLESID_2 = "titlesUnitUnitGroup.titlesId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESUNITUNITGROUP_UNITID_2 = "titlesUnitUnitGroup.unitId = ? AND ";
	private static final String _FINDER_COLUMN_TITLESUNITUNITGROUP_UNITGROUPID_2 =
		"titlesUnitUnitGroup.unitGroupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TITLES = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTitles",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES =
		new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTitles",
			new String[] { Long.class.getName() },
			TitlesUnitUnitGroupModelImpl.TITLESID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TITLES = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTitles",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the titles unit unit groups where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @return the matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByTitles(long titlesId)
		throws SystemException {
		return findByTitles(titlesId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles unit unit groups where titlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @return the range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByTitles(long titlesId, int start,
		int end) throws SystemException {
		return findByTitles(titlesId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles unit unit groups where titlesId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param titlesId the titles ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByTitles(long titlesId, int start,
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

		List<TitlesUnitUnitGroup> list = (List<TitlesUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesUnitUnitGroup titlesUnitUnitGroup : list) {
				if ((titlesId != titlesUnitUnitGroup.getTitlesId())) {
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

			query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_TITLES_TITLESID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(titlesId);

				if (!pagination) {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByTitles_First(long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByTitles_First(titlesId,
				orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByTitles_First(long titlesId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TitlesUnitUnitGroup> list = findByTitles(titlesId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByTitles_Last(long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByTitles_Last(titlesId,
				orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("titlesId=");
		msg.append(titlesId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByTitles_Last(long titlesId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTitles(titlesId);

		if (count == 0) {
			return null;
		}

		List<TitlesUnitUnitGroup> list = findByTitles(titlesId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where titlesId = &#63;.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	 * @param titlesId the titles ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup[] findByTitles_PrevAndNext(
		long titlesUnitUnitGroupId, long titlesId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = findByPrimaryKey(titlesUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesUnitUnitGroup[] array = new TitlesUnitUnitGroupImpl[3];

			array[0] = getByTitles_PrevAndNext(session, titlesUnitUnitGroup,
					titlesId, orderByComparator, true);

			array[1] = titlesUnitUnitGroup;

			array[2] = getByTitles_PrevAndNext(session, titlesUnitUnitGroup,
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

	protected TitlesUnitUnitGroup getByTitles_PrevAndNext(Session session,
		TitlesUnitUnitGroup titlesUnitUnitGroup, long titlesId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

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
			query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(titlesId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles unit unit groups where titlesId = &#63; from the database.
	 *
	 * @param titlesId the titles ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTitles(long titlesId) throws SystemException {
		for (TitlesUnitUnitGroup titlesUnitUnitGroup : findByTitles(titlesId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles unit unit groups where titlesId = &#63;.
	 *
	 * @param titlesId the titles ID
	 * @return the number of matching titles unit unit groups
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

			query.append(_SQL_COUNT_TITLESUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_TITLES_TITLESID_2 = "titlesUnitUnitGroup.titlesId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITANDUNITGROUP =
		new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitAndUnitGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP =
		new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUnitAndUnitGroup",
			new String[] { Long.class.getName(), Long.class.getName() },
			TitlesUnitUnitGroupModelImpl.UNITID_COLUMN_BITMASK |
			TitlesUnitUnitGroupModelImpl.UNITGROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNITANDUNITGROUP = new FinderPath(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUnitAndUnitGroup",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnitAndUnitGroup(long unitId,
		long unitGroupId) throws SystemException {
		return findByUnitAndUnitGroup(unitId, unitGroupId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @return the range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnitAndUnitGroup(long unitId,
		long unitGroupId, int start, int end) throws SystemException {
		return findByUnitAndUnitGroup(unitId, unitGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findByUnitAndUnitGroup(long unitId,
		long unitGroupId, int start, int end,
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

		List<TitlesUnitUnitGroup> list = (List<TitlesUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TitlesUnitUnitGroup titlesUnitUnitGroup : list) {
				if ((unitId != titlesUnitUnitGroup.getUnitId()) ||
						(unitGroupId != titlesUnitUnitGroup.getUnitGroupId())) {
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

			query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

			query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITID_2);

			query.append(_FINDER_COLUMN_UNITANDUNITGROUP_UNITGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
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
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
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
	 * Returns the first titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByUnitAndUnitGroup_First(long unitId,
		long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByUnitAndUnitGroup_First(unitId,
				unitGroupId, orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the first titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByUnitAndUnitGroup_First(long unitId,
		long unitGroupId, OrderByComparator orderByComparator)
		throws SystemException {
		List<TitlesUnitUnitGroup> list = findByUnitAndUnitGroup(unitId,
				unitGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByUnitAndUnitGroup_Last(long unitId,
		long unitGroupId, OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByUnitAndUnitGroup_Last(unitId,
				unitGroupId, orderByComparator);

		if (titlesUnitUnitGroup != null) {
			return titlesUnitUnitGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(", unitGroupId=");
		msg.append(unitGroupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTitlesUnitUnitGroupException(msg.toString());
	}

	/**
	 * Returns the last titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching titles unit unit group, or <code>null</code> if a matching titles unit unit group could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByUnitAndUnitGroup_Last(long unitId,
		long unitGroupId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByUnitAndUnitGroup(unitId, unitGroupId);

		if (count == 0) {
			return null;
		}

		List<TitlesUnitUnitGroup> list = findByUnitAndUnitGroup(unitId,
				unitGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the titles unit unit groups before and after the current titles unit unit group in the ordered set where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the current titles unit unit group
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup[] findByUnitAndUnitGroup_PrevAndNext(
		long titlesUnitUnitGroupId, long unitId, long unitGroupId,
		OrderByComparator orderByComparator)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = findByPrimaryKey(titlesUnitUnitGroupId);

		Session session = null;

		try {
			session = openSession();

			TitlesUnitUnitGroup[] array = new TitlesUnitUnitGroupImpl[3];

			array[0] = getByUnitAndUnitGroup_PrevAndNext(session,
					titlesUnitUnitGroup, unitId, unitGroupId,
					orderByComparator, true);

			array[1] = titlesUnitUnitGroup;

			array[2] = getByUnitAndUnitGroup_PrevAndNext(session,
					titlesUnitUnitGroup, unitId, unitGroupId,
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

	protected TitlesUnitUnitGroup getByUnitAndUnitGroup_PrevAndNext(
		Session session, TitlesUnitUnitGroup titlesUnitUnitGroup, long unitId,
		long unitGroupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TITLESUNITUNITGROUP_WHERE);

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
			query.append(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitId);

		qPos.add(unitGroupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(titlesUnitUnitGroup);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<TitlesUnitUnitGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the titles unit unit groups where unitId = &#63; and unitGroupId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnitAndUnitGroup(long unitId, long unitGroupId)
		throws SystemException {
		for (TitlesUnitUnitGroup titlesUnitUnitGroup : findByUnitAndUnitGroup(
				unitId, unitGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(titlesUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles unit unit groups where unitId = &#63; and unitGroupId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param unitGroupId the unit group ID
	 * @return the number of matching titles unit unit groups
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

			query.append(_SQL_COUNT_TITLESUNITUNITGROUP_WHERE);

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

	private static final String _FINDER_COLUMN_UNITANDUNITGROUP_UNITID_2 = "titlesUnitUnitGroup.unitId = ? AND ";
	private static final String _FINDER_COLUMN_UNITANDUNITGROUP_UNITGROUPID_2 = "titlesUnitUnitGroup.unitGroupId = ?";

	public TitlesUnitUnitGroupPersistenceImpl() {
		setModelClass(TitlesUnitUnitGroup.class);
	}

	/**
	 * Caches the titles unit unit group in the entity cache if it is enabled.
	 *
	 * @param titlesUnitUnitGroup the titles unit unit group
	 */
	@Override
	public void cacheResult(TitlesUnitUnitGroup titlesUnitUnitGroup) {
		EntityCacheUtil.putResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class, titlesUnitUnitGroup.getPrimaryKey(),
			titlesUnitUnitGroup);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
			new Object[] {
				titlesUnitUnitGroup.getTitlesId(),
				titlesUnitUnitGroup.getUnitId(),
				titlesUnitUnitGroup.getUnitGroupId()
			}, titlesUnitUnitGroup);

		titlesUnitUnitGroup.resetOriginalValues();
	}

	/**
	 * Caches the titles unit unit groups in the entity cache if it is enabled.
	 *
	 * @param titlesUnitUnitGroups the titles unit unit groups
	 */
	@Override
	public void cacheResult(List<TitlesUnitUnitGroup> titlesUnitUnitGroups) {
		for (TitlesUnitUnitGroup titlesUnitUnitGroup : titlesUnitUnitGroups) {
			if (EntityCacheUtil.getResult(
						TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
						TitlesUnitUnitGroupImpl.class,
						titlesUnitUnitGroup.getPrimaryKey()) == null) {
				cacheResult(titlesUnitUnitGroup);
			}
			else {
				titlesUnitUnitGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all titles unit unit groups.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TitlesUnitUnitGroupImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TitlesUnitUnitGroupImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the titles unit unit group.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TitlesUnitUnitGroup titlesUnitUnitGroup) {
		EntityCacheUtil.removeResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class, titlesUnitUnitGroup.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(titlesUnitUnitGroup);
	}

	@Override
	public void clearCache(List<TitlesUnitUnitGroup> titlesUnitUnitGroups) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TitlesUnitUnitGroup titlesUnitUnitGroup : titlesUnitUnitGroups) {
			EntityCacheUtil.removeResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
				TitlesUnitUnitGroupImpl.class,
				titlesUnitUnitGroup.getPrimaryKey());

			clearUniqueFindersCache(titlesUnitUnitGroup);
		}
	}

	protected void cacheUniqueFindersCache(
		TitlesUnitUnitGroup titlesUnitUnitGroup) {
		if (titlesUnitUnitGroup.isNew()) {
			Object[] args = new Object[] {
					titlesUnitUnitGroup.getTitlesId(),
					titlesUnitUnitGroup.getUnitId(),
					titlesUnitUnitGroup.getUnitGroupId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLESUNITUNITGROUP,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
				args, titlesUnitUnitGroup);
		}
		else {
			TitlesUnitUnitGroupModelImpl titlesUnitUnitGroupModelImpl = (TitlesUnitUnitGroupModelImpl)titlesUnitUnitGroup;

			if ((titlesUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesUnitUnitGroup.getTitlesId(),
						titlesUnitUnitGroup.getUnitId(),
						titlesUnitUnitGroup.getUnitGroupId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TITLESUNITUNITGROUP,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
					args, titlesUnitUnitGroup);
			}
		}
	}

	protected void clearUniqueFindersCache(
		TitlesUnitUnitGroup titlesUnitUnitGroup) {
		TitlesUnitUnitGroupModelImpl titlesUnitUnitGroupModelImpl = (TitlesUnitUnitGroupModelImpl)titlesUnitUnitGroup;

		Object[] args = new Object[] {
				titlesUnitUnitGroup.getTitlesId(),
				titlesUnitUnitGroup.getUnitId(),
				titlesUnitUnitGroup.getUnitGroupId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLESUNITUNITGROUP,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
			args);

		if ((titlesUnitUnitGroupModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP.getColumnBitmask()) != 0) {
			args = new Object[] {
					titlesUnitUnitGroupModelImpl.getOriginalTitlesId(),
					titlesUnitUnitGroupModelImpl.getOriginalUnitId(),
					titlesUnitUnitGroupModelImpl.getOriginalUnitGroupId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLESUNITUNITGROUP,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_TITLESUNITUNITGROUP,
				args);
		}
	}

	/**
	 * Creates a new titles unit unit group with the primary key. Does not add the titles unit unit group to the database.
	 *
	 * @param titlesUnitUnitGroupId the primary key for the new titles unit unit group
	 * @return the new titles unit unit group
	 */
	@Override
	public TitlesUnitUnitGroup create(long titlesUnitUnitGroupId) {
		TitlesUnitUnitGroup titlesUnitUnitGroup = new TitlesUnitUnitGroupImpl();

		titlesUnitUnitGroup.setNew(true);
		titlesUnitUnitGroup.setPrimaryKey(titlesUnitUnitGroupId);

		return titlesUnitUnitGroup;
	}

	/**
	 * Removes the titles unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	 * @return the titles unit unit group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup remove(long titlesUnitUnitGroupId)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		return remove((Serializable)titlesUnitUnitGroupId);
	}

	/**
	 * Removes the titles unit unit group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the titles unit unit group
	 * @return the titles unit unit group that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup remove(Serializable primaryKey)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TitlesUnitUnitGroup titlesUnitUnitGroup = (TitlesUnitUnitGroup)session.get(TitlesUnitUnitGroupImpl.class,
					primaryKey);

			if (titlesUnitUnitGroup == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTitlesUnitUnitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(titlesUnitUnitGroup);
		}
		catch (NoSuchTitlesUnitUnitGroupException nsee) {
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
	protected TitlesUnitUnitGroup removeImpl(
		TitlesUnitUnitGroup titlesUnitUnitGroup) throws SystemException {
		titlesUnitUnitGroup = toUnwrappedModel(titlesUnitUnitGroup);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(titlesUnitUnitGroup)) {
				titlesUnitUnitGroup = (TitlesUnitUnitGroup)session.get(TitlesUnitUnitGroupImpl.class,
						titlesUnitUnitGroup.getPrimaryKeyObj());
			}

			if (titlesUnitUnitGroup != null) {
				session.delete(titlesUnitUnitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (titlesUnitUnitGroup != null) {
			clearCache(titlesUnitUnitGroup);
		}

		return titlesUnitUnitGroup;
	}

	@Override
	public TitlesUnitUnitGroup updateImpl(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup)
		throws SystemException {
		titlesUnitUnitGroup = toUnwrappedModel(titlesUnitUnitGroup);

		boolean isNew = titlesUnitUnitGroup.isNew();

		TitlesUnitUnitGroupModelImpl titlesUnitUnitGroupModelImpl = (TitlesUnitUnitGroupModelImpl)titlesUnitUnitGroup;

		Session session = null;

		try {
			session = openSession();

			if (titlesUnitUnitGroup.isNew()) {
				session.save(titlesUnitUnitGroup);

				titlesUnitUnitGroup.setNew(false);
			}
			else {
				session.merge(titlesUnitUnitGroup);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TitlesUnitUnitGroupModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((titlesUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesUnitUnitGroupModelImpl.getOriginalUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);

				args = new Object[] { titlesUnitUnitGroupModelImpl.getUnitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);
			}

			if ((titlesUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesUnitUnitGroupModelImpl.getOriginalUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP,
					args);

				args = new Object[] {
						titlesUnitUnitGroupModelImpl.getUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITGROUP,
					args);
			}

			if ((titlesUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesUnitUnitGroupModelImpl.getOriginalTitlesId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES,
					args);

				args = new Object[] { titlesUnitUnitGroupModelImpl.getTitlesId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TITLES, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TITLES,
					args);
			}

			if ((titlesUnitUnitGroupModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						titlesUnitUnitGroupModelImpl.getOriginalUnitId(),
						titlesUnitUnitGroupModelImpl.getOriginalUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITANDUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP,
					args);

				args = new Object[] {
						titlesUnitUnitGroupModelImpl.getUnitId(),
						titlesUnitUnitGroupModelImpl.getUnitGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITANDUNITGROUP,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITANDUNITGROUP,
					args);
			}
		}

		EntityCacheUtil.putResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
			TitlesUnitUnitGroupImpl.class, titlesUnitUnitGroup.getPrimaryKey(),
			titlesUnitUnitGroup);

		clearUniqueFindersCache(titlesUnitUnitGroup);
		cacheUniqueFindersCache(titlesUnitUnitGroup);

		return titlesUnitUnitGroup;
	}

	protected TitlesUnitUnitGroup toUnwrappedModel(
		TitlesUnitUnitGroup titlesUnitUnitGroup) {
		if (titlesUnitUnitGroup instanceof TitlesUnitUnitGroupImpl) {
			return titlesUnitUnitGroup;
		}

		TitlesUnitUnitGroupImpl titlesUnitUnitGroupImpl = new TitlesUnitUnitGroupImpl();

		titlesUnitUnitGroupImpl.setNew(titlesUnitUnitGroup.isNew());
		titlesUnitUnitGroupImpl.setPrimaryKey(titlesUnitUnitGroup.getPrimaryKey());

		titlesUnitUnitGroupImpl.setTitlesUnitUnitGroupId(titlesUnitUnitGroup.getTitlesUnitUnitGroupId());
		titlesUnitUnitGroupImpl.setTitlesId(titlesUnitUnitGroup.getTitlesId());
		titlesUnitUnitGroupImpl.setUnitId(titlesUnitUnitGroup.getUnitId());
		titlesUnitUnitGroupImpl.setUnitGroupId(titlesUnitUnitGroup.getUnitGroupId());
		titlesUnitUnitGroupImpl.setGroupId(titlesUnitUnitGroup.getGroupId());
		titlesUnitUnitGroupImpl.setCompanyId(titlesUnitUnitGroup.getCompanyId());
		titlesUnitUnitGroupImpl.setUserId(titlesUnitUnitGroup.getUserId());
		titlesUnitUnitGroupImpl.setUserName(titlesUnitUnitGroup.getUserName());
		titlesUnitUnitGroupImpl.setCreateDate(titlesUnitUnitGroup.getCreateDate());
		titlesUnitUnitGroupImpl.setModifiedDate(titlesUnitUnitGroup.getModifiedDate());

		return titlesUnitUnitGroupImpl;
	}

	/**
	 * Returns the titles unit unit group with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the titles unit unit group
	 * @return the titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = fetchByPrimaryKey(primaryKey);

		if (titlesUnitUnitGroup == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTitlesUnitUnitGroupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return titlesUnitUnitGroup;
	}

	/**
	 * Returns the titles unit unit group with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException} if it could not be found.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	 * @return the titles unit unit group
	 * @throws vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup findByPrimaryKey(long titlesUnitUnitGroupId)
		throws NoSuchTitlesUnitUnitGroupException, SystemException {
		return findByPrimaryKey((Serializable)titlesUnitUnitGroupId);
	}

	/**
	 * Returns the titles unit unit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the titles unit unit group
	 * @return the titles unit unit group, or <code>null</code> if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TitlesUnitUnitGroup titlesUnitUnitGroup = (TitlesUnitUnitGroup)EntityCacheUtil.getResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
				TitlesUnitUnitGroupImpl.class, primaryKey);

		if (titlesUnitUnitGroup == _nullTitlesUnitUnitGroup) {
			return null;
		}

		if (titlesUnitUnitGroup == null) {
			Session session = null;

			try {
				session = openSession();

				titlesUnitUnitGroup = (TitlesUnitUnitGroup)session.get(TitlesUnitUnitGroupImpl.class,
						primaryKey);

				if (titlesUnitUnitGroup != null) {
					cacheResult(titlesUnitUnitGroup);
				}
				else {
					EntityCacheUtil.putResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
						TitlesUnitUnitGroupImpl.class, primaryKey,
						_nullTitlesUnitUnitGroup);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TitlesUnitUnitGroupModelImpl.ENTITY_CACHE_ENABLED,
					TitlesUnitUnitGroupImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return titlesUnitUnitGroup;
	}

	/**
	 * Returns the titles unit unit group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param titlesUnitUnitGroupId the primary key of the titles unit unit group
	 * @return the titles unit unit group, or <code>null</code> if a titles unit unit group with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TitlesUnitUnitGroup fetchByPrimaryKey(long titlesUnitUnitGroupId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)titlesUnitUnitGroupId);
	}

	/**
	 * Returns all the titles unit unit groups.
	 *
	 * @return the titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the titles unit unit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @return the range of titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the titles unit unit groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.TitlesUnitUnitGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of titles unit unit groups
	 * @param end the upper bound of the range of titles unit unit groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of titles unit unit groups
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TitlesUnitUnitGroup> findAll(int start, int end,
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

		List<TitlesUnitUnitGroup> list = (List<TitlesUnitUnitGroup>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TITLESUNITUNITGROUP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TITLESUNITUNITGROUP;

				if (pagination) {
					sql = sql.concat(TitlesUnitUnitGroupModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TitlesUnitUnitGroup>(list);
				}
				else {
					list = (List<TitlesUnitUnitGroup>)QueryUtil.list(q,
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
	 * Removes all the titles unit unit groups from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TitlesUnitUnitGroup titlesUnitUnitGroup : findAll()) {
			remove(titlesUnitUnitGroup);
		}
	}

	/**
	 * Returns the number of titles unit unit groups.
	 *
	 * @return the number of titles unit unit groups
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

				Query q = session.createQuery(_SQL_COUNT_TITLESUNITUNITGROUP);

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
	 * Initializes the titles unit unit group persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.TitlesUnitUnitGroup")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TitlesUnitUnitGroup>> listenersList = new ArrayList<ModelListener<TitlesUnitUnitGroup>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TitlesUnitUnitGroup>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(TitlesUnitUnitGroupImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TITLESUNITUNITGROUP = "SELECT titlesUnitUnitGroup FROM TitlesUnitUnitGroup titlesUnitUnitGroup";
	private static final String _SQL_SELECT_TITLESUNITUNITGROUP_WHERE = "SELECT titlesUnitUnitGroup FROM TitlesUnitUnitGroup titlesUnitUnitGroup WHERE ";
	private static final String _SQL_COUNT_TITLESUNITUNITGROUP = "SELECT COUNT(titlesUnitUnitGroup) FROM TitlesUnitUnitGroup titlesUnitUnitGroup";
	private static final String _SQL_COUNT_TITLESUNITUNITGROUP_WHERE = "SELECT COUNT(titlesUnitUnitGroup) FROM TitlesUnitUnitGroup titlesUnitUnitGroup WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "titlesUnitUnitGroup.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TitlesUnitUnitGroup exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TitlesUnitUnitGroup exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TitlesUnitUnitGroupPersistenceImpl.class);
	private static TitlesUnitUnitGroup _nullTitlesUnitUnitGroup = new TitlesUnitUnitGroupImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TitlesUnitUnitGroup> toCacheModel() {
				return _nullTitlesUnitUnitGroupCacheModel;
			}
		};

	private static CacheModel<TitlesUnitUnitGroup> _nullTitlesUnitUnitGroupCacheModel =
		new CacheModel<TitlesUnitUnitGroup>() {
			@Override
			public TitlesUnitUnitGroup toEntityModel() {
				return _nullTitlesUnitUnitGroup;
			}
		};
}