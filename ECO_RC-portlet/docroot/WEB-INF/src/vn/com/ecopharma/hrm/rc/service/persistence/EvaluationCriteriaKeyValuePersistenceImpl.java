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

import vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;
import vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueImpl;
import vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the evaluation criteria key value service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValuePersistence
 * @see EvaluationCriteriaKeyValueUtil
 * @generated
 */
public class EvaluationCriteriaKeyValuePersistenceImpl
	extends BasePersistenceImpl<EvaluationCriteriaKeyValue>
	implements EvaluationCriteriaKeyValuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EvaluationCriteriaKeyValueUtil} to access the evaluation criteria key value persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EvaluationCriteriaKeyValueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVALUATIONCRITERIA =
		new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEvaluationCriteria",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVALUATIONCRITERIA =
		new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEvaluationCriteria", new String[] { Long.class.getName() },
			EvaluationCriteriaKeyValueModelImpl.EVALUATIONCRITERIAID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVALUATIONCRITERIA = new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEvaluationCriteria", new String[] { Long.class.getName() });

	/**
	 * Returns all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @return the matching evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId) throws SystemException {
		return findByEvaluationCriteria(evaluationCriteriaId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param start the lower bound of the range of evaluation criteria key values
	 * @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	 * @return the range of matching evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId, int start, int end)
		throws SystemException {
		return findByEvaluationCriteria(evaluationCriteriaId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluation criteria key values where evaluationCriteriaId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param start the lower bound of the range of evaluation criteria key values
	 * @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteriaKeyValue> findByEvaluationCriteria(
		long evaluationCriteriaId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVALUATIONCRITERIA;
			finderArgs = new Object[] { evaluationCriteriaId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVALUATIONCRITERIA;
			finderArgs = new Object[] {
					evaluationCriteriaId,
					
					start, end, orderByComparator
				};
		}

		List<EvaluationCriteriaKeyValue> list = (List<EvaluationCriteriaKeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EvaluationCriteriaKeyValue evaluationCriteriaKeyValue : list) {
				if ((evaluationCriteriaId != evaluationCriteriaKeyValue.getEvaluationCriteriaId())) {
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

			query.append(_SQL_SELECT_EVALUATIONCRITERIAKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_EVALUATIONCRITERIA_EVALUATIONCRITERIAID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EvaluationCriteriaKeyValueModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(evaluationCriteriaId);

				if (!pagination) {
					list = (List<EvaluationCriteriaKeyValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EvaluationCriteriaKeyValue>(list);
				}
				else {
					list = (List<EvaluationCriteriaKeyValue>)QueryUtil.list(q,
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
	 * Returns the first evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation criteria key value
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue findByEvaluationCriteria_First(
		long evaluationCriteriaId, OrderByComparator orderByComparator)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = fetchByEvaluationCriteria_First(evaluationCriteriaId,
				orderByComparator);

		if (evaluationCriteriaKeyValue != null) {
			return evaluationCriteriaKeyValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("evaluationCriteriaId=");
		msg.append(evaluationCriteriaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEvaluationCriteriaKeyValueException(msg.toString());
	}

	/**
	 * Returns the first evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue fetchByEvaluationCriteria_First(
		long evaluationCriteriaId, OrderByComparator orderByComparator)
		throws SystemException {
		List<EvaluationCriteriaKeyValue> list = findByEvaluationCriteria(evaluationCriteriaId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation criteria key value
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue findByEvaluationCriteria_Last(
		long evaluationCriteriaId, OrderByComparator orderByComparator)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = fetchByEvaluationCriteria_Last(evaluationCriteriaId,
				orderByComparator);

		if (evaluationCriteriaKeyValue != null) {
			return evaluationCriteriaKeyValue;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("evaluationCriteriaId=");
		msg.append(evaluationCriteriaId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEvaluationCriteriaKeyValueException(msg.toString());
	}

	/**
	 * Returns the last evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue fetchByEvaluationCriteria_Last(
		long evaluationCriteriaId, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByEvaluationCriteria(evaluationCriteriaId);

		if (count == 0) {
			return null;
		}

		List<EvaluationCriteriaKeyValue> list = findByEvaluationCriteria(evaluationCriteriaId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the evaluation criteria key values before and after the current evaluation criteria key value in the ordered set where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaKeyValueId the primary key of the current evaluation criteria key value
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next evaluation criteria key value
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue[] findByEvaluationCriteria_PrevAndNext(
		long evaluationCriteriaKeyValueId, long evaluationCriteriaId,
		OrderByComparator orderByComparator)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = findByPrimaryKey(evaluationCriteriaKeyValueId);

		Session session = null;

		try {
			session = openSession();

			EvaluationCriteriaKeyValue[] array = new EvaluationCriteriaKeyValueImpl[3];

			array[0] = getByEvaluationCriteria_PrevAndNext(session,
					evaluationCriteriaKeyValue, evaluationCriteriaId,
					orderByComparator, true);

			array[1] = evaluationCriteriaKeyValue;

			array[2] = getByEvaluationCriteria_PrevAndNext(session,
					evaluationCriteriaKeyValue, evaluationCriteriaId,
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

	protected EvaluationCriteriaKeyValue getByEvaluationCriteria_PrevAndNext(
		Session session, EvaluationCriteriaKeyValue evaluationCriteriaKeyValue,
		long evaluationCriteriaId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVALUATIONCRITERIAKEYVALUE_WHERE);

		query.append(_FINDER_COLUMN_EVALUATIONCRITERIA_EVALUATIONCRITERIAID_2);

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
			query.append(EvaluationCriteriaKeyValueModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(evaluationCriteriaId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(evaluationCriteriaKeyValue);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EvaluationCriteriaKeyValue> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the evaluation criteria key values where evaluationCriteriaId = &#63; from the database.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEvaluationCriteria(long evaluationCriteriaId)
		throws SystemException {
		for (EvaluationCriteriaKeyValue evaluationCriteriaKeyValue : findByEvaluationCriteria(
				evaluationCriteriaId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(evaluationCriteriaKeyValue);
		}
	}

	/**
	 * Returns the number of evaluation criteria key values where evaluationCriteriaId = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @return the number of matching evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEvaluationCriteria(long evaluationCriteriaId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVALUATIONCRITERIA;

		Object[] finderArgs = new Object[] { evaluationCriteriaId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVALUATIONCRITERIAKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_EVALUATIONCRITERIA_EVALUATIONCRITERIAID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(evaluationCriteriaId);

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

	private static final String _FINDER_COLUMN_EVALUATIONCRITERIA_EVALUATIONCRITERIAID_2 =
		"evaluationCriteriaKeyValue.evaluationCriteriaId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY =
		new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEvaluationCriteriaAndKey",
			new String[] { Long.class.getName(), String.class.getName() },
			EvaluationCriteriaKeyValueModelImpl.EVALUATIONCRITERIAID_COLUMN_BITMASK |
			EvaluationCriteriaKeyValueModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVALUATIONCRITERIAANDKEY =
		new FinderPath(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueModelImpl.FINDER_CACHE_ENABLED,
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEvaluationCriteriaAndKey",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException} if it could not be found.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param key the key
	 * @return the matching evaluation criteria key value
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue findByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, String key)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = fetchByEvaluationCriteriaAndKey(evaluationCriteriaId,
				key);

		if (evaluationCriteriaKeyValue == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("evaluationCriteriaId=");
			msg.append(evaluationCriteriaId);

			msg.append(", key=");
			msg.append(key);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEvaluationCriteriaKeyValueException(msg.toString());
		}

		return evaluationCriteriaKeyValue;
	}

	/**
	 * Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param key the key
	 * @return the matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue fetchByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, String key) throws SystemException {
		return fetchByEvaluationCriteriaAndKey(evaluationCriteriaId, key, true);
	}

	/**
	 * Returns the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param key the key
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching evaluation criteria key value, or <code>null</code> if a matching evaluation criteria key value could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue fetchByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, String key, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { evaluationCriteriaId, key };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
					finderArgs, this);
		}

		if (result instanceof EvaluationCriteriaKeyValue) {
			EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = (EvaluationCriteriaKeyValue)result;

			if ((evaluationCriteriaId != evaluationCriteriaKeyValue.getEvaluationCriteriaId()) ||
					!Validator.equals(key, evaluationCriteriaKeyValue.getKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVALUATIONCRITERIAKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_EVALUATIONCRITERIAID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(evaluationCriteriaId);

				if (bindKey) {
					qPos.add(key);
				}

				List<EvaluationCriteriaKeyValue> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EvaluationCriteriaKeyValuePersistenceImpl.fetchByEvaluationCriteriaAndKey(long, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = list.get(0);

					result = evaluationCriteriaKeyValue;

					cacheResult(evaluationCriteriaKeyValue);

					if ((evaluationCriteriaKeyValue.getEvaluationCriteriaId() != evaluationCriteriaId) ||
							(evaluationCriteriaKeyValue.getKey() == null) ||
							!evaluationCriteriaKeyValue.getKey().equals(key)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
							finderArgs, evaluationCriteriaKeyValue);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
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
			return (EvaluationCriteriaKeyValue)result;
		}
	}

	/**
	 * Removes the evaluation criteria key value where evaluationCriteriaId = &#63; and key = &#63; from the database.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param key the key
	 * @return the evaluation criteria key value that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue removeByEvaluationCriteriaAndKey(
		long evaluationCriteriaId, String key)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = findByEvaluationCriteriaAndKey(evaluationCriteriaId,
				key);

		return remove(evaluationCriteriaKeyValue);
	}

	/**
	 * Returns the number of evaluation criteria key values where evaluationCriteriaId = &#63; and key = &#63;.
	 *
	 * @param evaluationCriteriaId the evaluation criteria ID
	 * @param key the key
	 * @return the number of matching evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEvaluationCriteriaAndKey(long evaluationCriteriaId,
		String key) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVALUATIONCRITERIAANDKEY;

		Object[] finderArgs = new Object[] { evaluationCriteriaId, key };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVALUATIONCRITERIAKEYVALUE_WHERE);

			query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_EVALUATIONCRITERIAID_2);

			boolean bindKey = false;

			if (key == null) {
				query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_1);
			}
			else if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_3);
			}
			else {
				bindKey = true;

				query.append(_FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(evaluationCriteriaId);

				if (bindKey) {
					qPos.add(key);
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

	private static final String _FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_EVALUATIONCRITERIAID_2 =
		"evaluationCriteriaKeyValue.evaluationCriteriaId = ? AND ";
	private static final String _FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_1 = "evaluationCriteriaKeyValue.key IS NULL";
	private static final String _FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_2 = "evaluationCriteriaKeyValue.key = ?";
	private static final String _FINDER_COLUMN_EVALUATIONCRITERIAANDKEY_KEY_3 = "(evaluationCriteriaKeyValue.key IS NULL OR evaluationCriteriaKeyValue.key = '')";

	public EvaluationCriteriaKeyValuePersistenceImpl() {
		setModelClass(EvaluationCriteriaKeyValue.class);
	}

	/**
	 * Caches the evaluation criteria key value in the entity cache if it is enabled.
	 *
	 * @param evaluationCriteriaKeyValue the evaluation criteria key value
	 */
	@Override
	public void cacheResult(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		EntityCacheUtil.putResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			evaluationCriteriaKeyValue.getPrimaryKey(),
			evaluationCriteriaKeyValue);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
			new Object[] {
				evaluationCriteriaKeyValue.getEvaluationCriteriaId(),
				evaluationCriteriaKeyValue.getKey()
			}, evaluationCriteriaKeyValue);

		evaluationCriteriaKeyValue.resetOriginalValues();
	}

	/**
	 * Caches the evaluation criteria key values in the entity cache if it is enabled.
	 *
	 * @param evaluationCriteriaKeyValues the evaluation criteria key values
	 */
	@Override
	public void cacheResult(
		List<EvaluationCriteriaKeyValue> evaluationCriteriaKeyValues) {
		for (EvaluationCriteriaKeyValue evaluationCriteriaKeyValue : evaluationCriteriaKeyValues) {
			if (EntityCacheUtil.getResult(
						EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
						EvaluationCriteriaKeyValueImpl.class,
						evaluationCriteriaKeyValue.getPrimaryKey()) == null) {
				cacheResult(evaluationCriteriaKeyValue);
			}
			else {
				evaluationCriteriaKeyValue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all evaluation criteria key values.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EvaluationCriteriaKeyValueImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EvaluationCriteriaKeyValueImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the evaluation criteria key value.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		EntityCacheUtil.removeResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			evaluationCriteriaKeyValue.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(evaluationCriteriaKeyValue);
	}

	@Override
	public void clearCache(
		List<EvaluationCriteriaKeyValue> evaluationCriteriaKeyValues) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EvaluationCriteriaKeyValue evaluationCriteriaKeyValue : evaluationCriteriaKeyValues) {
			EntityCacheUtil.removeResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
				EvaluationCriteriaKeyValueImpl.class,
				evaluationCriteriaKeyValue.getPrimaryKey());

			clearUniqueFindersCache(evaluationCriteriaKeyValue);
		}
	}

	protected void cacheUniqueFindersCache(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		if (evaluationCriteriaKeyValue.isNew()) {
			Object[] args = new Object[] {
					evaluationCriteriaKeyValue.getEvaluationCriteriaId(),
					evaluationCriteriaKeyValue.getKey()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVALUATIONCRITERIAANDKEY,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
				args, evaluationCriteriaKeyValue);
		}
		else {
			EvaluationCriteriaKeyValueModelImpl evaluationCriteriaKeyValueModelImpl =
				(EvaluationCriteriaKeyValueModelImpl)evaluationCriteriaKeyValue;

			if ((evaluationCriteriaKeyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						evaluationCriteriaKeyValue.getEvaluationCriteriaId(),
						evaluationCriteriaKeyValue.getKey()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EVALUATIONCRITERIAANDKEY,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
					args, evaluationCriteriaKeyValue);
			}
		}
	}

	protected void clearUniqueFindersCache(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		EvaluationCriteriaKeyValueModelImpl evaluationCriteriaKeyValueModelImpl = (EvaluationCriteriaKeyValueModelImpl)evaluationCriteriaKeyValue;

		Object[] args = new Object[] {
				evaluationCriteriaKeyValue.getEvaluationCriteriaId(),
				evaluationCriteriaKeyValue.getKey()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVALUATIONCRITERIAANDKEY,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
			args);

		if ((evaluationCriteriaKeyValueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY.getColumnBitmask()) != 0) {
			args = new Object[] {
					evaluationCriteriaKeyValueModelImpl.getOriginalEvaluationCriteriaId(),
					evaluationCriteriaKeyValueModelImpl.getOriginalKey()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVALUATIONCRITERIAANDKEY,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EVALUATIONCRITERIAANDKEY,
				args);
		}
	}

	/**
	 * Creates a new evaluation criteria key value with the primary key. Does not add the evaluation criteria key value to the database.
	 *
	 * @param evaluationCriteriaKeyValueId the primary key for the new evaluation criteria key value
	 * @return the new evaluation criteria key value
	 */
	@Override
	public EvaluationCriteriaKeyValue create(long evaluationCriteriaKeyValueId) {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = new EvaluationCriteriaKeyValueImpl();

		evaluationCriteriaKeyValue.setNew(true);
		evaluationCriteriaKeyValue.setPrimaryKey(evaluationCriteriaKeyValueId);

		return evaluationCriteriaKeyValue;
	}

	/**
	 * Removes the evaluation criteria key value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	 * @return the evaluation criteria key value that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue remove(long evaluationCriteriaKeyValueId)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		return remove((Serializable)evaluationCriteriaKeyValueId);
	}

	/**
	 * Removes the evaluation criteria key value with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the evaluation criteria key value
	 * @return the evaluation criteria key value that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue remove(Serializable primaryKey)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = (EvaluationCriteriaKeyValue)session.get(EvaluationCriteriaKeyValueImpl.class,
					primaryKey);

			if (evaluationCriteriaKeyValue == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEvaluationCriteriaKeyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(evaluationCriteriaKeyValue);
		}
		catch (NoSuchEvaluationCriteriaKeyValueException nsee) {
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
	protected EvaluationCriteriaKeyValue removeImpl(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws SystemException {
		evaluationCriteriaKeyValue = toUnwrappedModel(evaluationCriteriaKeyValue);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(evaluationCriteriaKeyValue)) {
				evaluationCriteriaKeyValue = (EvaluationCriteriaKeyValue)session.get(EvaluationCriteriaKeyValueImpl.class,
						evaluationCriteriaKeyValue.getPrimaryKeyObj());
			}

			if (evaluationCriteriaKeyValue != null) {
				session.delete(evaluationCriteriaKeyValue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (evaluationCriteriaKeyValue != null) {
			clearCache(evaluationCriteriaKeyValue);
		}

		return evaluationCriteriaKeyValue;
	}

	@Override
	public EvaluationCriteriaKeyValue updateImpl(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue)
		throws SystemException {
		evaluationCriteriaKeyValue = toUnwrappedModel(evaluationCriteriaKeyValue);

		boolean isNew = evaluationCriteriaKeyValue.isNew();

		EvaluationCriteriaKeyValueModelImpl evaluationCriteriaKeyValueModelImpl = (EvaluationCriteriaKeyValueModelImpl)evaluationCriteriaKeyValue;

		Session session = null;

		try {
			session = openSession();

			if (evaluationCriteriaKeyValue.isNew()) {
				session.save(evaluationCriteriaKeyValue);

				evaluationCriteriaKeyValue.setNew(false);
			}
			else {
				session.merge(evaluationCriteriaKeyValue);
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
				!EvaluationCriteriaKeyValueModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((evaluationCriteriaKeyValueModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVALUATIONCRITERIA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						evaluationCriteriaKeyValueModelImpl.getOriginalEvaluationCriteriaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVALUATIONCRITERIA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVALUATIONCRITERIA,
					args);

				args = new Object[] {
						evaluationCriteriaKeyValueModelImpl.getEvaluationCriteriaId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVALUATIONCRITERIA,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVALUATIONCRITERIA,
					args);
			}
		}

		EntityCacheUtil.putResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
			EvaluationCriteriaKeyValueImpl.class,
			evaluationCriteriaKeyValue.getPrimaryKey(),
			evaluationCriteriaKeyValue);

		clearUniqueFindersCache(evaluationCriteriaKeyValue);
		cacheUniqueFindersCache(evaluationCriteriaKeyValue);

		return evaluationCriteriaKeyValue;
	}

	protected EvaluationCriteriaKeyValue toUnwrappedModel(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		if (evaluationCriteriaKeyValue instanceof EvaluationCriteriaKeyValueImpl) {
			return evaluationCriteriaKeyValue;
		}

		EvaluationCriteriaKeyValueImpl evaluationCriteriaKeyValueImpl = new EvaluationCriteriaKeyValueImpl();

		evaluationCriteriaKeyValueImpl.setNew(evaluationCriteriaKeyValue.isNew());
		evaluationCriteriaKeyValueImpl.setPrimaryKey(evaluationCriteriaKeyValue.getPrimaryKey());

		evaluationCriteriaKeyValueImpl.setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValue.getEvaluationCriteriaKeyValueId());
		evaluationCriteriaKeyValueImpl.setEvaluationCriteriaId(evaluationCriteriaKeyValue.getEvaluationCriteriaId());
		evaluationCriteriaKeyValueImpl.setKey(evaluationCriteriaKeyValue.getKey());
		evaluationCriteriaKeyValueImpl.setValue(evaluationCriteriaKeyValue.getValue());
		evaluationCriteriaKeyValueImpl.setGroupId(evaluationCriteriaKeyValue.getGroupId());
		evaluationCriteriaKeyValueImpl.setCompanyId(evaluationCriteriaKeyValue.getCompanyId());
		evaluationCriteriaKeyValueImpl.setUserId(evaluationCriteriaKeyValue.getUserId());
		evaluationCriteriaKeyValueImpl.setUserName(evaluationCriteriaKeyValue.getUserName());
		evaluationCriteriaKeyValueImpl.setCreateDate(evaluationCriteriaKeyValue.getCreateDate());
		evaluationCriteriaKeyValueImpl.setModifiedDate(evaluationCriteriaKeyValue.getModifiedDate());

		return evaluationCriteriaKeyValueImpl;
	}

	/**
	 * Returns the evaluation criteria key value with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation criteria key value
	 * @return the evaluation criteria key value
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = fetchByPrimaryKey(primaryKey);

		if (evaluationCriteriaKeyValue == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEvaluationCriteriaKeyValueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return evaluationCriteriaKeyValue;
	}

	/**
	 * Returns the evaluation criteria key value with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException} if it could not be found.
	 *
	 * @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	 * @return the evaluation criteria key value
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue findByPrimaryKey(
		long evaluationCriteriaKeyValueId)
		throws NoSuchEvaluationCriteriaKeyValueException, SystemException {
		return findByPrimaryKey((Serializable)evaluationCriteriaKeyValueId);
	}

	/**
	 * Returns the evaluation criteria key value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the evaluation criteria key value
	 * @return the evaluation criteria key value, or <code>null</code> if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue = (EvaluationCriteriaKeyValue)EntityCacheUtil.getResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
				EvaluationCriteriaKeyValueImpl.class, primaryKey);

		if (evaluationCriteriaKeyValue == _nullEvaluationCriteriaKeyValue) {
			return null;
		}

		if (evaluationCriteriaKeyValue == null) {
			Session session = null;

			try {
				session = openSession();

				evaluationCriteriaKeyValue = (EvaluationCriteriaKeyValue)session.get(EvaluationCriteriaKeyValueImpl.class,
						primaryKey);

				if (evaluationCriteriaKeyValue != null) {
					cacheResult(evaluationCriteriaKeyValue);
				}
				else {
					EntityCacheUtil.putResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
						EvaluationCriteriaKeyValueImpl.class, primaryKey,
						_nullEvaluationCriteriaKeyValue);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EvaluationCriteriaKeyValueModelImpl.ENTITY_CACHE_ENABLED,
					EvaluationCriteriaKeyValueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return evaluationCriteriaKeyValue;
	}

	/**
	 * Returns the evaluation criteria key value with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param evaluationCriteriaKeyValueId the primary key of the evaluation criteria key value
	 * @return the evaluation criteria key value, or <code>null</code> if a evaluation criteria key value with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EvaluationCriteriaKeyValue fetchByPrimaryKey(
		long evaluationCriteriaKeyValueId) throws SystemException {
		return fetchByPrimaryKey((Serializable)evaluationCriteriaKeyValueId);
	}

	/**
	 * Returns all the evaluation criteria key values.
	 *
	 * @return the evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteriaKeyValue> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the evaluation criteria key values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluation criteria key values
	 * @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	 * @return the range of evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteriaKeyValue> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the evaluation criteria key values.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of evaluation criteria key values
	 * @param end the upper bound of the range of evaluation criteria key values (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of evaluation criteria key values
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EvaluationCriteriaKeyValue> findAll(int start, int end,
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

		List<EvaluationCriteriaKeyValue> list = (List<EvaluationCriteriaKeyValue>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EVALUATIONCRITERIAKEYVALUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVALUATIONCRITERIAKEYVALUE;

				if (pagination) {
					sql = sql.concat(EvaluationCriteriaKeyValueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EvaluationCriteriaKeyValue>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EvaluationCriteriaKeyValue>(list);
				}
				else {
					list = (List<EvaluationCriteriaKeyValue>)QueryUtil.list(q,
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
	 * Removes all the evaluation criteria key values from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EvaluationCriteriaKeyValue evaluationCriteriaKeyValue : findAll()) {
			remove(evaluationCriteriaKeyValue);
		}
	}

	/**
	 * Returns the number of evaluation criteria key values.
	 *
	 * @return the number of evaluation criteria key values
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

				Query q = session.createQuery(_SQL_COUNT_EVALUATIONCRITERIAKEYVALUE);

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
	 * Initializes the evaluation criteria key value persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EvaluationCriteriaKeyValue>> listenersList = new ArrayList<ModelListener<EvaluationCriteriaKeyValue>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EvaluationCriteriaKeyValue>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EvaluationCriteriaKeyValueImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EVALUATIONCRITERIAKEYVALUE = "SELECT evaluationCriteriaKeyValue FROM EvaluationCriteriaKeyValue evaluationCriteriaKeyValue";
	private static final String _SQL_SELECT_EVALUATIONCRITERIAKEYVALUE_WHERE = "SELECT evaluationCriteriaKeyValue FROM EvaluationCriteriaKeyValue evaluationCriteriaKeyValue WHERE ";
	private static final String _SQL_COUNT_EVALUATIONCRITERIAKEYVALUE = "SELECT COUNT(evaluationCriteriaKeyValue) FROM EvaluationCriteriaKeyValue evaluationCriteriaKeyValue";
	private static final String _SQL_COUNT_EVALUATIONCRITERIAKEYVALUE_WHERE = "SELECT COUNT(evaluationCriteriaKeyValue) FROM EvaluationCriteriaKeyValue evaluationCriteriaKeyValue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "evaluationCriteriaKeyValue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EvaluationCriteriaKeyValue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EvaluationCriteriaKeyValue exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EvaluationCriteriaKeyValuePersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"key"
			});
	private static EvaluationCriteriaKeyValue _nullEvaluationCriteriaKeyValue = new EvaluationCriteriaKeyValueImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EvaluationCriteriaKeyValue> toCacheModel() {
				return _nullEvaluationCriteriaKeyValueCacheModel;
			}
		};

	private static CacheModel<EvaluationCriteriaKeyValue> _nullEvaluationCriteriaKeyValueCacheModel =
		new CacheModel<EvaluationCriteriaKeyValue>() {
			@Override
			public EvaluationCriteriaKeyValue toEntityModel() {
				return _nullEvaluationCriteriaKeyValue;
			}
		};
}