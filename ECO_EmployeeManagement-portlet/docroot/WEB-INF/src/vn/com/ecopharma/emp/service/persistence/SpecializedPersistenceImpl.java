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

import vn.com.ecopharma.emp.NoSuchSpecializedException;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.model.impl.SpecializedImpl;
import vn.com.ecopharma.emp.model.impl.SpecializedModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the specialized service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see SpecializedPersistence
 * @see SpecializedUtil
 * @generated
 */
public class SpecializedPersistenceImpl extends BasePersistenceImpl<Specialized>
	implements SpecializedPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpecializedUtil} to access the specialized persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpecializedImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevel",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevel",
			new String[] { Integer.class.getName() },
			SpecializedModelImpl.LEVEL_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVEL = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevel",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the specializeds where level = &#63;.
	 *
	 * @param level the level
	 * @return the matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findByLevel(int level) throws SystemException {
		return findByLevel(level, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specializeds where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of specializeds
	 * @param end the upper bound of the range of specializeds (not inclusive)
	 * @return the range of matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findByLevel(int level, int start, int end)
		throws SystemException {
		return findByLevel(level, start, end, null);
	}

	/**
	 * Returns an ordered range of all the specializeds where level = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param start the lower bound of the range of specializeds
	 * @param end the upper bound of the range of specializeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findByLevel(int level, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL;
			finderArgs = new Object[] { level };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVEL;
			finderArgs = new Object[] { level, start, end, orderByComparator };
		}

		List<Specialized> list = (List<Specialized>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Specialized specialized : list) {
				if ((level != specialized.getLevel())) {
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

			query.append(_SQL_SELECT_SPECIALIZED_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpecializedModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				if (!pagination) {
					list = (List<Specialized>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Specialized>(list);
				}
				else {
					list = (List<Specialized>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first specialized in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByLevel_First(int level,
		OrderByComparator orderByComparator)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = fetchByLevel_First(level, orderByComparator);

		if (specialized != null) {
			return specialized;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecializedException(msg.toString());
	}

	/**
	 * Returns the first specialized in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialized, or <code>null</code> if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByLevel_First(int level,
		OrderByComparator orderByComparator) throws SystemException {
		List<Specialized> list = findByLevel(level, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last specialized in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByLevel_Last(int level,
		OrderByComparator orderByComparator)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = fetchByLevel_Last(level, orderByComparator);

		if (specialized != null) {
			return specialized;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecializedException(msg.toString());
	}

	/**
	 * Returns the last specialized in the ordered set where level = &#63;.
	 *
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialized, or <code>null</code> if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByLevel_Last(int level,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLevel(level);

		if (count == 0) {
			return null;
		}

		List<Specialized> list = findByLevel(level, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the specializeds before and after the current specialized in the ordered set where level = &#63;.
	 *
	 * @param specializedId the primary key of the current specialized
	 * @param level the level
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized[] findByLevel_PrevAndNext(long specializedId, int level,
		OrderByComparator orderByComparator)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = findByPrimaryKey(specializedId);

		Session session = null;

		try {
			session = openSession();

			Specialized[] array = new SpecializedImpl[3];

			array[0] = getByLevel_PrevAndNext(session, specialized, level,
					orderByComparator, true);

			array[1] = specialized;

			array[2] = getByLevel_PrevAndNext(session, specialized, level,
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

	protected Specialized getByLevel_PrevAndNext(Session session,
		Specialized specialized, int level,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPECIALIZED_WHERE);

		query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

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
			query.append(SpecializedModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(specialized);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Specialized> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the specializeds where level = &#63; from the database.
	 *
	 * @param level the level
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLevel(int level) throws SystemException {
		for (Specialized specialized : findByLevel(level, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(specialized);
		}
	}

	/**
	 * Returns the number of specializeds where level = &#63;.
	 *
	 * @param level the level
	 * @return the number of matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLevel(int level) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEVEL;

		Object[] finderArgs = new Object[] { level };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPECIALIZED_WHERE);

			query.append(_FINDER_COLUMN_LEVEL_LEVEL_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

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

	private static final String _FINDER_COLUMN_LEVEL_LEVEL_2 = "specialized.level = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDPARENT =
		new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLevelAndParent",
			new String[] {
				Integer.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDPARENT =
		new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLevelAndParent",
			new String[] { Integer.class.getName(), Long.class.getName() },
			SpecializedModelImpl.LEVEL_COLUMN_BITMASK |
			SpecializedModelImpl.PARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LEVELANDPARENT = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLevelAndParent",
			new String[] { Integer.class.getName(), Long.class.getName() });

	/**
	 * Returns all the specializeds where level = &#63; and parentId = &#63;.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @return the matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findByLevelAndParent(int level, long parentId)
		throws SystemException {
		return findByLevelAndParent(level, parentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specializeds where level = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of specializeds
	 * @param end the upper bound of the range of specializeds (not inclusive)
	 * @return the range of matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findByLevelAndParent(int level, long parentId,
		int start, int end) throws SystemException {
		return findByLevelAndParent(level, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the specializeds where level = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of specializeds
	 * @param end the upper bound of the range of specializeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findByLevelAndParent(int level, long parentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDPARENT;
			finderArgs = new Object[] { level, parentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LEVELANDPARENT;
			finderArgs = new Object[] {
					level, parentId,
					
					start, end, orderByComparator
				};
		}

		List<Specialized> list = (List<Specialized>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Specialized specialized : list) {
				if ((level != specialized.getLevel()) ||
						(parentId != specialized.getParentId())) {
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

			query.append(_SQL_SELECT_SPECIALIZED_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDPARENT_LEVEL_2);

			query.append(_FINDER_COLUMN_LEVELANDPARENT_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SpecializedModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Specialized>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Specialized>(list);
				}
				else {
					list = (List<Specialized>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first specialized in the ordered set where level = &#63; and parentId = &#63;.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByLevelAndParent_First(int level, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = fetchByLevelAndParent_First(level, parentId,
				orderByComparator);

		if (specialized != null) {
			return specialized;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecializedException(msg.toString());
	}

	/**
	 * Returns the first specialized in the ordered set where level = &#63; and parentId = &#63;.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching specialized, or <code>null</code> if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByLevelAndParent_First(int level, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Specialized> list = findByLevelAndParent(level, parentId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last specialized in the ordered set where level = &#63; and parentId = &#63;.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByLevelAndParent_Last(int level, long parentId,
		OrderByComparator orderByComparator)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = fetchByLevelAndParent_Last(level, parentId,
				orderByComparator);

		if (specialized != null) {
			return specialized;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("level=");
		msg.append(level);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpecializedException(msg.toString());
	}

	/**
	 * Returns the last specialized in the ordered set where level = &#63; and parentId = &#63;.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching specialized, or <code>null</code> if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByLevelAndParent_Last(int level, long parentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLevelAndParent(level, parentId);

		if (count == 0) {
			return null;
		}

		List<Specialized> list = findByLevelAndParent(level, parentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the specializeds before and after the current specialized in the ordered set where level = &#63; and parentId = &#63;.
	 *
	 * @param specializedId the primary key of the current specialized
	 * @param level the level
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized[] findByLevelAndParent_PrevAndNext(long specializedId,
		int level, long parentId, OrderByComparator orderByComparator)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = findByPrimaryKey(specializedId);

		Session session = null;

		try {
			session = openSession();

			Specialized[] array = new SpecializedImpl[3];

			array[0] = getByLevelAndParent_PrevAndNext(session, specialized,
					level, parentId, orderByComparator, true);

			array[1] = specialized;

			array[2] = getByLevelAndParent_PrevAndNext(session, specialized,
					level, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Specialized getByLevelAndParent_PrevAndNext(Session session,
		Specialized specialized, int level, long parentId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPECIALIZED_WHERE);

		query.append(_FINDER_COLUMN_LEVELANDPARENT_LEVEL_2);

		query.append(_FINDER_COLUMN_LEVELANDPARENT_PARENTID_2);

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
			query.append(SpecializedModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(level);

		qPos.add(parentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(specialized);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Specialized> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the specializeds where level = &#63; and parentId = &#63; from the database.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLevelAndParent(int level, long parentId)
		throws SystemException {
		for (Specialized specialized : findByLevelAndParent(level, parentId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(specialized);
		}
	}

	/**
	 * Returns the number of specializeds where level = &#63; and parentId = &#63;.
	 *
	 * @param level the level
	 * @param parentId the parent ID
	 * @return the number of matching specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLevelAndParent(int level, long parentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LEVELANDPARENT;

		Object[] finderArgs = new Object[] { level, parentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SPECIALIZED_WHERE);

			query.append(_FINDER_COLUMN_LEVELANDPARENT_LEVEL_2);

			query.append(_FINDER_COLUMN_LEVELANDPARENT_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(level);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_LEVELANDPARENT_LEVEL_2 = "specialized.level = ? AND ";
	private static final String _FINDER_COLUMN_LEVELANDPARENT_PARENTID_2 = "specialized.parentId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, SpecializedImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			SpecializedModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the specialized where name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchSpecializedException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByName(String name)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = fetchByName(name);

		if (specialized == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchSpecializedException(msg.toString());
		}

		return specialized;
	}

	/**
	 * Returns the specialized where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching specialized, or <code>null</code> if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the specialized where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching specialized, or <code>null</code> if a matching specialized could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Specialized) {
			Specialized specialized = (Specialized)result;

			if (!Validator.equals(name, specialized.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPECIALIZED_WHERE);

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

				List<Specialized> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"SpecializedPersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Specialized specialized = list.get(0);

					result = specialized;

					cacheResult(specialized);

					if ((specialized.getName() == null) ||
							!specialized.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, specialized);
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
			return (Specialized)result;
		}
	}

	/**
	 * Removes the specialized where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the specialized that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized removeByName(String name)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = findByName(name);

		return remove(specialized);
	}

	/**
	 * Returns the number of specializeds where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching specializeds
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

			query.append(_SQL_COUNT_SPECIALIZED_WHERE);

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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "specialized.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "specialized.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(specialized.name IS NULL OR specialized.name = '')";

	public SpecializedPersistenceImpl() {
		setModelClass(Specialized.class);
	}

	/**
	 * Caches the specialized in the entity cache if it is enabled.
	 *
	 * @param specialized the specialized
	 */
	@Override
	public void cacheResult(Specialized specialized) {
		EntityCacheUtil.putResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedImpl.class, specialized.getPrimaryKey(), specialized);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { specialized.getName() }, specialized);

		specialized.resetOriginalValues();
	}

	/**
	 * Caches the specializeds in the entity cache if it is enabled.
	 *
	 * @param specializeds the specializeds
	 */
	@Override
	public void cacheResult(List<Specialized> specializeds) {
		for (Specialized specialized : specializeds) {
			if (EntityCacheUtil.getResult(
						SpecializedModelImpl.ENTITY_CACHE_ENABLED,
						SpecializedImpl.class, specialized.getPrimaryKey()) == null) {
				cacheResult(specialized);
			}
			else {
				specialized.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all specializeds.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(SpecializedImpl.class.getName());
		}

		EntityCacheUtil.clearCache(SpecializedImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the specialized.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Specialized specialized) {
		EntityCacheUtil.removeResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedImpl.class, specialized.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(specialized);
	}

	@Override
	public void clearCache(List<Specialized> specializeds) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Specialized specialized : specializeds) {
			EntityCacheUtil.removeResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
				SpecializedImpl.class, specialized.getPrimaryKey());

			clearUniqueFindersCache(specialized);
		}
	}

	protected void cacheUniqueFindersCache(Specialized specialized) {
		if (specialized.isNew()) {
			Object[] args = new Object[] { specialized.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
				specialized);
		}
		else {
			SpecializedModelImpl specializedModelImpl = (SpecializedModelImpl)specialized;

			if ((specializedModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { specialized.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args,
					specialized);
			}
		}
	}

	protected void clearUniqueFindersCache(Specialized specialized) {
		SpecializedModelImpl specializedModelImpl = (SpecializedModelImpl)specialized;

		Object[] args = new Object[] { specialized.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((specializedModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { specializedModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new specialized with the primary key. Does not add the specialized to the database.
	 *
	 * @param specializedId the primary key for the new specialized
	 * @return the new specialized
	 */
	@Override
	public Specialized create(long specializedId) {
		Specialized specialized = new SpecializedImpl();

		specialized.setNew(true);
		specialized.setPrimaryKey(specializedId);

		return specialized;
	}

	/**
	 * Removes the specialized with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param specializedId the primary key of the specialized
	 * @return the specialized that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized remove(long specializedId)
		throws NoSuchSpecializedException, SystemException {
		return remove((Serializable)specializedId);
	}

	/**
	 * Removes the specialized with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the specialized
	 * @return the specialized that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized remove(Serializable primaryKey)
		throws NoSuchSpecializedException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Specialized specialized = (Specialized)session.get(SpecializedImpl.class,
					primaryKey);

			if (specialized == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpecializedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(specialized);
		}
		catch (NoSuchSpecializedException nsee) {
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
	protected Specialized removeImpl(Specialized specialized)
		throws SystemException {
		specialized = toUnwrappedModel(specialized);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(specialized)) {
				specialized = (Specialized)session.get(SpecializedImpl.class,
						specialized.getPrimaryKeyObj());
			}

			if (specialized != null) {
				session.delete(specialized);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (specialized != null) {
			clearCache(specialized);
		}

		return specialized;
	}

	@Override
	public Specialized updateImpl(
		vn.com.ecopharma.emp.model.Specialized specialized)
		throws SystemException {
		specialized = toUnwrappedModel(specialized);

		boolean isNew = specialized.isNew();

		SpecializedModelImpl specializedModelImpl = (SpecializedModelImpl)specialized;

		Session session = null;

		try {
			session = openSession();

			if (specialized.isNew()) {
				session.save(specialized);

				specialized.setNew(false);
			}
			else {
				session.merge(specialized);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SpecializedModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((specializedModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						specializedModelImpl.getOriginalLevel()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);

				args = new Object[] { specializedModelImpl.getLevel() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVEL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVEL,
					args);
			}

			if ((specializedModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDPARENT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						specializedModelImpl.getOriginalLevel(),
						specializedModelImpl.getOriginalParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDPARENT,
					args);

				args = new Object[] {
						specializedModelImpl.getLevel(),
						specializedModelImpl.getParentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LEVELANDPARENT,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LEVELANDPARENT,
					args);
			}
		}

		EntityCacheUtil.putResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
			SpecializedImpl.class, specialized.getPrimaryKey(), specialized);

		clearUniqueFindersCache(specialized);
		cacheUniqueFindersCache(specialized);

		return specialized;
	}

	protected Specialized toUnwrappedModel(Specialized specialized) {
		if (specialized instanceof SpecializedImpl) {
			return specialized;
		}

		SpecializedImpl specializedImpl = new SpecializedImpl();

		specializedImpl.setNew(specialized.isNew());
		specializedImpl.setPrimaryKey(specialized.getPrimaryKey());

		specializedImpl.setSpecializedId(specialized.getSpecializedId());
		specializedImpl.setSpecializedCode(specialized.getSpecializedCode());
		specializedImpl.setName(specialized.getName());
		specializedImpl.setLevel(specialized.getLevel());
		specializedImpl.setParentId(specialized.getParentId());
		specializedImpl.setUniversity(specialized.isUniversity());
		specializedImpl.setCollege(specialized.isCollege());
		specializedImpl.setVocationalCollege(specialized.isVocationalCollege());
		specializedImpl.setVocational(specialized.isVocational());
		specializedImpl.setGroupId(specialized.getGroupId());
		specializedImpl.setCompanyId(specialized.getCompanyId());
		specializedImpl.setUserId(specialized.getUserId());
		specializedImpl.setUserName(specialized.getUserName());
		specializedImpl.setCreateDate(specialized.getCreateDate());
		specializedImpl.setModifiedDate(specialized.getModifiedDate());

		return specializedImpl;
	}

	/**
	 * Returns the specialized with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the specialized
	 * @return the specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpecializedException, SystemException {
		Specialized specialized = fetchByPrimaryKey(primaryKey);

		if (specialized == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpecializedException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return specialized;
	}

	/**
	 * Returns the specialized with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchSpecializedException} if it could not be found.
	 *
	 * @param specializedId the primary key of the specialized
	 * @return the specialized
	 * @throws vn.com.ecopharma.emp.NoSuchSpecializedException if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized findByPrimaryKey(long specializedId)
		throws NoSuchSpecializedException, SystemException {
		return findByPrimaryKey((Serializable)specializedId);
	}

	/**
	 * Returns the specialized with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the specialized
	 * @return the specialized, or <code>null</code> if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Specialized specialized = (Specialized)EntityCacheUtil.getResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
				SpecializedImpl.class, primaryKey);

		if (specialized == _nullSpecialized) {
			return null;
		}

		if (specialized == null) {
			Session session = null;

			try {
				session = openSession();

				specialized = (Specialized)session.get(SpecializedImpl.class,
						primaryKey);

				if (specialized != null) {
					cacheResult(specialized);
				}
				else {
					EntityCacheUtil.putResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
						SpecializedImpl.class, primaryKey, _nullSpecialized);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(SpecializedModelImpl.ENTITY_CACHE_ENABLED,
					SpecializedImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return specialized;
	}

	/**
	 * Returns the specialized with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param specializedId the primary key of the specialized
	 * @return the specialized, or <code>null</code> if a specialized with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Specialized fetchByPrimaryKey(long specializedId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)specializedId);
	}

	/**
	 * Returns all the specializeds.
	 *
	 * @return the specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the specializeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializeds
	 * @param end the upper bound of the range of specializeds (not inclusive)
	 * @return the range of specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the specializeds.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.SpecializedModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of specializeds
	 * @param end the upper bound of the range of specializeds (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of specializeds
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Specialized> findAll(int start, int end,
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

		List<Specialized> list = (List<Specialized>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_SPECIALIZED);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPECIALIZED;

				if (pagination) {
					sql = sql.concat(SpecializedModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Specialized>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Specialized>(list);
				}
				else {
					list = (List<Specialized>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the specializeds from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Specialized specialized : findAll()) {
			remove(specialized);
		}
	}

	/**
	 * Returns the number of specializeds.
	 *
	 * @return the number of specializeds
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

				Query q = session.createQuery(_SQL_COUNT_SPECIALIZED);

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
	 * Initializes the specialized persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Specialized")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Specialized>> listenersList = new ArrayList<ModelListener<Specialized>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Specialized>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(SpecializedImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_SPECIALIZED = "SELECT specialized FROM Specialized specialized";
	private static final String _SQL_SELECT_SPECIALIZED_WHERE = "SELECT specialized FROM Specialized specialized WHERE ";
	private static final String _SQL_COUNT_SPECIALIZED = "SELECT COUNT(specialized) FROM Specialized specialized";
	private static final String _SQL_COUNT_SPECIALIZED_WHERE = "SELECT COUNT(specialized) FROM Specialized specialized WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "specialized.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Specialized exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Specialized exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(SpecializedPersistenceImpl.class);
	private static Specialized _nullSpecialized = new SpecializedImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Specialized> toCacheModel() {
				return _nullSpecializedCacheModel;
			}
		};

	private static CacheModel<Specialized> _nullSpecializedCacheModel = new CacheModel<Specialized>() {
			@Override
			public Specialized toEntityModel() {
				return _nullSpecialized;
			}
		};
}