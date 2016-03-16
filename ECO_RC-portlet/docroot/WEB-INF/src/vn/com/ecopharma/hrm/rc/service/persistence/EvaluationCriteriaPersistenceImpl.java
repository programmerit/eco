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

import vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaImpl;
import vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the evaluation criteria service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaPersistence
 * @see EvaluationCriteriaUtil
 * @generated
 */
public class EvaluationCriteriaPersistenceImpl extends BasePersistenceImpl<EvaluationCriteria>
	implements EvaluationCriteriaPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EvaluationCriteriaUtil} to access the evaluation criteria persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EvaluationCriteriaImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByType",
			new String[] { String.class.getName() },
			EvaluationCriteriaModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TYPE = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the evaluation criterias where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteria> findByType(String type)
		throws SystemException {
		return findByType(type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluation criterias where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of evaluation criterias
	 * @param end the upper bound of the range of evaluation criterias (not inclusive)
	 * @return the range of matching evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteria> findByType(String type, int start, int end)
		throws SystemException {
		return findByType(type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluation criterias where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of evaluation criterias
	 * @param end the upper bound of the range of evaluation criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteria> findByType(String type, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TYPE;
			finderArgs = new Object[] { type, start, end, orderByComparator };
		}

		List<EvaluationCriteria> list = (List<EvaluationCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EvaluationCriteria evaluationCriteria : list) {
				if (!Validator.equals(type, evaluationCriteria.getType())) {
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

			query.append(_SQL_SELECT_EVALUATIONCRITERIA_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EvaluationCriteriaModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<EvaluationCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EvaluationCriteria>(list);
				}
				else {
					list = (List<EvaluationCriteria>)QueryUtil.list(q,
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
	 * Returns the first evaluation criteria in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria findByType_First(String type,
		OrderByComparator orderByComparator)
		throws NoSuchEvaluationCriteriaException, SystemException {
		EvaluationCriteria evaluationCriteria = fetchByType_First(type,
				orderByComparator);

		if (evaluationCriteria != null) {
			return evaluationCriteria;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEvaluationCriteriaException(msg.toString());
	}

	/**
	 * Returns the first evaluation criteria in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria fetchByType_First(String type,
		OrderByComparator orderByComparator) throws SystemException {
		List<EvaluationCriteria> list = findByType(type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evaluation criteria in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria findByType_Last(String type,
		OrderByComparator orderByComparator)
		throws NoSuchEvaluationCriteriaException, SystemException {
		EvaluationCriteria evaluationCriteria = fetchByType_Last(type,
				orderByComparator);

		if (evaluationCriteria != null) {
			return evaluationCriteria;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("type=");
		msg.append(type);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEvaluationCriteriaException(msg.toString());
	}

	/**
	 * Returns the last evaluation criteria in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria fetchByType_Last(String type,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByType(type);

		if (count == 0) {
			return null;
		}

		List<EvaluationCriteria> list = findByType(type, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evaluation criterias before and after the current evaluation criteria in the ordered set where type = &#63;.
	 *
	 * @param evaluationCriteriaId the primary key of the current evaluation criteria
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria[] findByType_PrevAndNext(
		long evaluationCriteriaId, String type,
		OrderByComparator orderByComparator)
		throws NoSuchEvaluationCriteriaException, SystemException {
		EvaluationCriteria evaluationCriteria = findByPrimaryKey(evaluationCriteriaId);

		Session session = null;

		try {
			session = openSession();

			EvaluationCriteria[] array = new EvaluationCriteriaImpl[3];

			array[0] = getByType_PrevAndNext(session, evaluationCriteria, type,
					orderByComparator, true);

			array[1] = evaluationCriteria;

			array[2] = getByType_PrevAndNext(session, evaluationCriteria, type,
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

	protected EvaluationCriteria getByType_PrevAndNext(Session session,
		EvaluationCriteria evaluationCriteria, String type,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVALUATIONCRITERIA_WHERE);

		boolean bindType = false;

		if (type == null) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_1);
		}
		else if (type.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_TYPE_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_TYPE_TYPE_2);
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
			query.append(EvaluationCriteriaModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evaluationCriteria);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EvaluationCriteria> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evaluation criterias where type = &#63; from the database.
	 *
	 * @param type the type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByType(String type) throws SystemException {
		for (EvaluationCriteria evaluationCriteria : findByType(type,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(evaluationCriteria);
		}
	}

	/**
	 * Returns the number of evaluation criterias where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByType(String type) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TYPE;

		Object[] finderArgs = new Object[] { type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVALUATIONCRITERIA_WHERE);

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_TYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_TYPE_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

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

	private static final String _FINDER_COLUMN_TYPE_TYPE_1 = "evaluationCriteria.type IS NULL";
	private static final String _FINDER_COLUMN_TYPE_TYPE_2 = "evaluationCriteria.type = ?";
	private static final String _FINDER_COLUMN_TYPE_TYPE_3 = "(evaluationCriteria.type IS NULL OR evaluationCriteria.type = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDTYPE = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByNameAndType",
			new String[] { String.class.getName(), String.class.getName() },
			EvaluationCriteriaModelImpl.NAME_COLUMN_BITMASK |
			EvaluationCriteriaModelImpl.TYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDTYPE = new FinderPath(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNameAndType",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the evaluation criteria where name = &#63; and type = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException} if it could not be found.
	 *
	 * @param name the name
	 * @param type the type
	 * @return the matching evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria findByNameAndType(String name, String type)
		throws NoSuchEvaluationCriteriaException, SystemException {
		EvaluationCriteria evaluationCriteria = fetchByNameAndType(name, type);

		if (evaluationCriteria == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(", type=");
			msg.append(type);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEvaluationCriteriaException(msg.toString());
		}

		return evaluationCriteria;
	}

	/**
	 * Returns the evaluation criteria where name = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @return the matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria fetchByNameAndType(String name, String type)
		throws SystemException {
		return fetchByNameAndType(name, type, true);
	}

	/**
	 * Returns the evaluation criteria where name = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param type the type
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evaluation criteria, or <code>null</code> if a matching evaluation criteria could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria fetchByNameAndType(String name, String type,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, type };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE,
					finderArgs, this);
		}

		if (result instanceof EvaluationCriteria) {
			EvaluationCriteria evaluationCriteria = (EvaluationCriteria)result;

			if (!Validator.equals(name, evaluationCriteria.getName()) ||
					!Validator.equals(type, evaluationCriteria.getType())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVALUATIONCRITERIA_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_2);
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

				if (bindType) {
					qPos.add(type);
				}

				List<EvaluationCriteria> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EvaluationCriteriaPersistenceImpl.fetchByNameAndType(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EvaluationCriteria evaluationCriteria = list.get(0);

					result = evaluationCriteria;

					cacheResult(evaluationCriteria);

					if ((evaluationCriteria.getName() == null) ||
							!evaluationCriteria.getName().equals(name) ||
							(evaluationCriteria.getType() == null) ||
							!evaluationCriteria.getType().equals(type)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE,
							finderArgs, evaluationCriteria);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE,
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
			return (EvaluationCriteria)result;
		}
	}

	/**
	 * Removes the evaluation criteria where name = &#63; and type = &#63; from the database.
	 *
	 * @param name the name
	 * @param type the type
	 * @return the evaluation criteria that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria removeByNameAndType(String name, String type)
		throws NoSuchEvaluationCriteriaException, SystemException {
		EvaluationCriteria evaluationCriteria = findByNameAndType(name, type);

		return remove(evaluationCriteria);
	}

	/**
	 * Returns the number of evaluation criterias where name = &#63; and type = &#63;.
	 *
	 * @param name the name
	 * @param type the type
	 * @return the number of matching evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameAndType(String name, String type)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAMEANDTYPE;

		Object[] finderArgs = new Object[] { name, type };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVALUATIONCRITERIA_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDTYPE_NAME_2);
			}

			boolean bindType = false;

			if (type == null) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_1);
			}
			else if (type.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_NAMEANDTYPE_TYPE_2);
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

	private static final String _FINDER_COLUMN_NAMEANDTYPE_NAME_1 = "evaluationCriteria.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDTYPE_NAME_2 = "evaluationCriteria.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDTYPE_NAME_3 = "(evaluationCriteria.name IS NULL OR evaluationCriteria.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDTYPE_TYPE_1 = "evaluationCriteria.type IS NULL";
	private static final String _FINDER_COLUMN_NAMEANDTYPE_TYPE_2 = "evaluationCriteria.type = ?";
	private static final String _FINDER_COLUMN_NAMEANDTYPE_TYPE_3 = "(evaluationCriteria.type IS NULL OR evaluationCriteria.type = '')";

	public EvaluationCriteriaPersistenceImpl() {
		setModelClass(EvaluationCriteria.class);
	}

	/**
	 * Caches the evaluation criteria in the entity cache if it is enabled.
	 *
	 * @param evaluationCriteria the evaluation criteria
	 */
	@Override
	public void cacheResult(EvaluationCriteria evaluationCriteria) {
		EntityCacheUtil.putResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaImpl.class, evaluationCriteria.getPrimaryKey(),
			evaluationCriteria);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE,
			new Object[] {
				evaluationCriteria.getName(), evaluationCriteria.getType()
			}, evaluationCriteria);

		evaluationCriteria.resetOriginalValues();
	}

	/**
	 * Caches the evaluation criterias in the entity cache if it is enabled.
	 *
	 * @param evaluationCriterias the evaluation criterias
	 */
	@Override
	public void cacheResult(List<EvaluationCriteria> evaluationCriterias) {
		for (EvaluationCriteria evaluationCriteria : evaluationCriterias) {
			if (EntityCacheUtil.getResult(
						EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						EvaluationCriteriaImpl.class,
						evaluationCriteria.getPrimaryKey()) == null) {
				cacheResult(evaluationCriteria);
			}
			else {
				evaluationCriteria.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all evaluation criterias.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EvaluationCriteriaImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EvaluationCriteriaImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evaluation criteria.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EvaluationCriteria evaluationCriteria) {
		EntityCacheUtil.removeResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaImpl.class, evaluationCriteria.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(evaluationCriteria);
	}

	@Override
	public void clearCache(List<EvaluationCriteria> evaluationCriterias) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EvaluationCriteria evaluationCriteria : evaluationCriterias) {
			EntityCacheUtil.removeResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				EvaluationCriteriaImpl.class, evaluationCriteria.getPrimaryKey());

			clearUniqueFindersCache(evaluationCriteria);
		}
	}

	protected void cacheUniqueFindersCache(
		EvaluationCriteria evaluationCriteria) {
		if (evaluationCriteria.isNew()) {
			Object[] args = new Object[] {
					evaluationCriteria.getName(), evaluationCriteria.getType()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDTYPE, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE, args,
				evaluationCriteria);
		}
		else {
			EvaluationCriteriaModelImpl evaluationCriteriaModelImpl = (EvaluationCriteriaModelImpl)evaluationCriteria;

			if ((evaluationCriteriaModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						evaluationCriteria.getName(),
						evaluationCriteria.getType()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDTYPE,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE,
					args, evaluationCriteria);
			}
		}
	}

	protected void clearUniqueFindersCache(
		EvaluationCriteria evaluationCriteria) {
		EvaluationCriteriaModelImpl evaluationCriteriaModelImpl = (EvaluationCriteriaModelImpl)evaluationCriteria;

		Object[] args = new Object[] {
				evaluationCriteria.getName(), evaluationCriteria.getType()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDTYPE, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE, args);

		if ((evaluationCriteriaModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEANDTYPE.getColumnBitmask()) != 0) {
			args = new Object[] {
					evaluationCriteriaModelImpl.getOriginalName(),
					evaluationCriteriaModelImpl.getOriginalType()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDTYPE, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDTYPE, args);
		}
	}

	/**
	 * Creates a new evaluation criteria with the primary key. Does not add the evaluation criteria to the database.
	 *
	 * @param evaluationCriteriaId the primary key for the new evaluation criteria
	 * @return the new evaluation criteria
	 */
	@Override
	public EvaluationCriteria create(long evaluationCriteriaId) {
		EvaluationCriteria evaluationCriteria = new EvaluationCriteriaImpl();

		evaluationCriteria.setNew(true);
		evaluationCriteria.setPrimaryKey(evaluationCriteriaId);

		return evaluationCriteria;
	}

	/**
	 * Removes the evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param evaluationCriteriaId the primary key of the evaluation criteria
	 * @return the evaluation criteria that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria remove(long evaluationCriteriaId)
		throws NoSuchEvaluationCriteriaException, SystemException {
		return remove((Serializable)evaluationCriteriaId);
	}

	/**
	 * Removes the evaluation criteria with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evaluation criteria
	 * @return the evaluation criteria that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria remove(Serializable primaryKey)
		throws NoSuchEvaluationCriteriaException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EvaluationCriteria evaluationCriteria = (EvaluationCriteria)session.get(EvaluationCriteriaImpl.class,
					primaryKey);

			if (evaluationCriteria == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEvaluationCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(evaluationCriteria);
		}
		catch (NoSuchEvaluationCriteriaException nsee) {
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
	protected EvaluationCriteria removeImpl(
		EvaluationCriteria evaluationCriteria) throws SystemException {
		evaluationCriteria = toUnwrappedModel(evaluationCriteria);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(evaluationCriteria)) {
				evaluationCriteria = (EvaluationCriteria)session.get(EvaluationCriteriaImpl.class,
						evaluationCriteria.getPrimaryKeyObj());
			}

			if (evaluationCriteria != null) {
				session.delete(evaluationCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (evaluationCriteria != null) {
			clearCache(evaluationCriteria);
		}

		return evaluationCriteria;
	}

	@Override
	public EvaluationCriteria updateImpl(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria)
		throws SystemException {
		evaluationCriteria = toUnwrappedModel(evaluationCriteria);

		boolean isNew = evaluationCriteria.isNew();

		EvaluationCriteriaModelImpl evaluationCriteriaModelImpl = (EvaluationCriteriaModelImpl)evaluationCriteria;

		Session session = null;

		try {
			session = openSession();

			if (evaluationCriteria.isNew()) {
				session.save(evaluationCriteria);

				evaluationCriteria.setNew(false);
			}
			else {
				session.merge(evaluationCriteria);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EvaluationCriteriaModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((evaluationCriteriaModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						evaluationCriteriaModelImpl.getOriginalType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);

				args = new Object[] { evaluationCriteriaModelImpl.getType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaImpl.class, evaluationCriteria.getPrimaryKey(),
			evaluationCriteria);

		clearUniqueFindersCache(evaluationCriteria);
		cacheUniqueFindersCache(evaluationCriteria);

		return evaluationCriteria;
	}

	protected EvaluationCriteria toUnwrappedModel(
		EvaluationCriteria evaluationCriteria) {
		if (evaluationCriteria instanceof EvaluationCriteriaImpl) {
			return evaluationCriteria;
		}

		EvaluationCriteriaImpl evaluationCriteriaImpl = new EvaluationCriteriaImpl();

		evaluationCriteriaImpl.setNew(evaluationCriteria.isNew());
		evaluationCriteriaImpl.setPrimaryKey(evaluationCriteria.getPrimaryKey());

		evaluationCriteriaImpl.setEvaluationCriteriaId(evaluationCriteria.getEvaluationCriteriaId());
		evaluationCriteriaImpl.setType(evaluationCriteria.getType());
		evaluationCriteriaImpl.setName(evaluationCriteria.getName());
		evaluationCriteriaImpl.setGroupId(evaluationCriteria.getGroupId());
		evaluationCriteriaImpl.setCompanyId(evaluationCriteria.getCompanyId());
		evaluationCriteriaImpl.setUserId(evaluationCriteria.getUserId());
		evaluationCriteriaImpl.setUserName(evaluationCriteria.getUserName());
		evaluationCriteriaImpl.setCreateDate(evaluationCriteria.getCreateDate());
		evaluationCriteriaImpl.setModifiedDate(evaluationCriteria.getModifiedDate());

		return evaluationCriteriaImpl;
	}

	/**
	 * Returns the evaluation criteria with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation criteria
	 * @return the evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEvaluationCriteriaException, SystemException {
		EvaluationCriteria evaluationCriteria = fetchByPrimaryKey(primaryKey);

		if (evaluationCriteria == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEvaluationCriteriaException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return evaluationCriteria;
	}

	/**
	 * Returns the evaluation criteria with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException} if it could not be found.
	 *
	 * @param evaluationCriteriaId the primary key of the evaluation criteria
	 * @return the evaluation criteria
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria findByPrimaryKey(long evaluationCriteriaId)
		throws NoSuchEvaluationCriteriaException, SystemException {
		return findByPrimaryKey((Serializable)evaluationCriteriaId);
	}

	/**
	 * Returns the evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation criteria
	 * @return the evaluation criteria, or <code>null</code> if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EvaluationCriteria evaluationCriteria = (EvaluationCriteria)EntityCacheUtil.getResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
				EvaluationCriteriaImpl.class, primaryKey);

		if (evaluationCriteria == _nullEvaluationCriteria) {
			return null;
		}

		if (evaluationCriteria == null) {
			Session session = null;

			try {
				session = openSession();

				evaluationCriteria = (EvaluationCriteria)session.get(EvaluationCriteriaImpl.class,
						primaryKey);

				if (evaluationCriteria != null) {
					cacheResult(evaluationCriteria);
				}
				else {
					EntityCacheUtil.putResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
						EvaluationCriteriaImpl.class, primaryKey,
						_nullEvaluationCriteria);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EvaluationCriteriaModelImpl.ENTITY_CACHE_ENABLED,
					EvaluationCriteriaImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return evaluationCriteria;
	}

	/**
	 * Returns the evaluation criteria with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param evaluationCriteriaId the primary key of the evaluation criteria
	 * @return the evaluation criteria, or <code>null</code> if a evaluation criteria with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteria fetchByPrimaryKey(long evaluationCriteriaId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)evaluationCriteriaId);
	}

	/**
	 * Returns all the evaluation criterias.
	 *
	 * @return the evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteria> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluation criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluation criterias
	 * @param end the upper bound of the range of evaluation criterias (not inclusive)
	 * @return the range of evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteria> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluation criterias.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluation criterias
	 * @param end the upper bound of the range of evaluation criterias (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evaluation criterias
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteria> findAll(int start, int end,
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

		List<EvaluationCriteria> list = (List<EvaluationCriteria>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVALUATIONCRITERIA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVALUATIONCRITERIA;

				if (pagination) {
					sql = sql.concat(EvaluationCriteriaModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EvaluationCriteria>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EvaluationCriteria>(list);
				}
				else {
					list = (List<EvaluationCriteria>)QueryUtil.list(q,
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
	 * Removes all the evaluation criterias from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EvaluationCriteria evaluationCriteria : findAll()) {
			remove(evaluationCriteria);
		}
	}

	/**
	 * Returns the number of evaluation criterias.
	 *
	 * @return the number of evaluation criterias
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

				Query q = session.createQuery(_SQL_COUNT_EVALUATIONCRITERIA);

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
	 * Initializes the evaluation criteria persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.EvaluationCriteria")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EvaluationCriteria>> listenersList = new ArrayList<ModelListener<EvaluationCriteria>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EvaluationCriteria>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EvaluationCriteriaImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVALUATIONCRITERIA = "SELECT evaluationCriteria FROM EvaluationCriteria evaluationCriteria";
	private static final String _SQL_SELECT_EVALUATIONCRITERIA_WHERE = "SELECT evaluationCriteria FROM EvaluationCriteria evaluationCriteria WHERE ";
	private static final String _SQL_COUNT_EVALUATIONCRITERIA = "SELECT COUNT(evaluationCriteria) FROM EvaluationCriteria evaluationCriteria";
	private static final String _SQL_COUNT_EVALUATIONCRITERIA_WHERE = "SELECT COUNT(evaluationCriteria) FROM EvaluationCriteria evaluationCriteria WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "evaluationCriteria.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EvaluationCriteria exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EvaluationCriteria exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EvaluationCriteriaPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
	private static EvaluationCriteria _nullEvaluationCriteria = new EvaluationCriteriaImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EvaluationCriteria> toCacheModel() {
				return _nullEvaluationCriteriaCacheModel;
			}
		};

	private static CacheModel<EvaluationCriteria> _nullEvaluationCriteriaCacheModel =
		new CacheModel<EvaluationCriteria>() {
			@Override
			public EvaluationCriteria toEntityModel() {
				return _nullEvaluationCriteria;
			}
		};
}