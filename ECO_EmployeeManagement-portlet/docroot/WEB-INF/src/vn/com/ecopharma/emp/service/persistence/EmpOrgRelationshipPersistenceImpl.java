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

import vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipImpl;
import vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp org relationship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpOrgRelationshipPersistence
 * @see EmpOrgRelationshipUtil
 * @generated
 */
public class EmpOrgRelationshipPersistenceImpl extends BasePersistenceImpl<EmpOrgRelationship>
	implements EmpOrgRelationshipPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpOrgRelationshipUtil} to access the emp org relationship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpOrgRelationshipImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMP = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmp",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmp",
			new String[] { Long.class.getName() },
			EmpOrgRelationshipModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMP = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmp",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp org relationships where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByEmp(long empId)
		throws SystemException {
		return findByEmp(empId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp org relationships where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @return the range of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByEmp(long empId, int start, int end)
		throws SystemException {
		return findByEmp(empId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp org relationships where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByEmp(long empId, int start, int end,
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

		List<EmpOrgRelationship> list = (List<EmpOrgRelationship>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpOrgRelationship empOrgRelationship : list) {
				if ((empId != empOrgRelationship.getEmpId())) {
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

			query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (!pagination) {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpOrgRelationship>(list);
				}
				else {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
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
	 * Returns the first emp org relationship in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByEmp_First(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByEmp_First(empId,
				orderByComparator);

		if (empOrgRelationship != null) {
			return empOrgRelationship;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpOrgRelationshipException(msg.toString());
	}

	/**
	 * Returns the first emp org relationship in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByEmp_First(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpOrgRelationship> list = findByEmp(empId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp org relationship in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByEmp_Last(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByEmp_Last(empId,
				orderByComparator);

		if (empOrgRelationship != null) {
			return empOrgRelationship;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpOrgRelationshipException(msg.toString());
	}

	/**
	 * Returns the last emp org relationship in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByEmp_Last(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmp(empId);

		if (count == 0) {
			return null;
		}

		List<EmpOrgRelationship> list = findByEmp(empId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp org relationships before and after the current emp org relationship in the ordered set where empId = &#63;.
	 *
	 * @param empOrgRelationshipId the primary key of the current emp org relationship
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship[] findByEmp_PrevAndNext(
		long empOrgRelationshipId, long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = findByPrimaryKey(empOrgRelationshipId);

		Session session = null;

		try {
			session = openSession();

			EmpOrgRelationship[] array = new EmpOrgRelationshipImpl[3];

			array[0] = getByEmp_PrevAndNext(session, empOrgRelationship, empId,
					orderByComparator, true);

			array[1] = empOrgRelationship;

			array[2] = getByEmp_PrevAndNext(session, empOrgRelationship, empId,
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

	protected EmpOrgRelationship getByEmp_PrevAndNext(Session session,
		EmpOrgRelationship empOrgRelationship, long empId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

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
			query.append(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empOrgRelationship);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpOrgRelationship> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp org relationships where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmp(long empId) throws SystemException {
		for (EmpOrgRelationship empOrgRelationship : findByEmp(empId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empOrgRelationship);
		}
	}

	/**
	 * Returns the number of emp org relationships where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching emp org relationships
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

			query.append(_SQL_COUNT_EMPORGRELATIONSHIP_WHERE);

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

	private static final String _FINDER_COLUMN_EMP_EMPID_2 = "empOrgRelationship.empId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMECLASSPK =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassNameClassPK",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPK =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassNameClassPK",
			new String[] { String.class.getName(), Long.class.getName() },
			EmpOrgRelationshipModelImpl.ORGCLASSNAME_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.ORGCLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMECLASSPK = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameClassPK",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the emp org relationships where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @return the matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByClassNameClassPK(
		String orgClassName, long orgClassPK) throws SystemException {
		return findByClassNameClassPK(orgClassName, orgClassPK,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp org relationships where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @return the range of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByClassNameClassPK(
		String orgClassName, long orgClassPK, int start, int end)
		throws SystemException {
		return findByClassNameClassPK(orgClassName, orgClassPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp org relationships where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByClassNameClassPK(
		String orgClassName, long orgClassPK, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPK;
			finderArgs = new Object[] { orgClassName, orgClassPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMECLASSPK;
			finderArgs = new Object[] {
					orgClassName, orgClassPK,
					
					start, end, orderByComparator
				};
		}

		List<EmpOrgRelationship> list = (List<EmpOrgRelationship>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpOrgRelationship empOrgRelationship : list) {
				if (!Validator.equals(orgClassName,
							empOrgRelationship.getOrgClassName()) ||
						(orgClassPK != empOrgRelationship.getOrgClassPK())) {
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

			query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				if (!pagination) {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpOrgRelationship>(list);
				}
				else {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
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
	 * Returns the first emp org relationship in the ordered set where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByClassNameClassPK_First(
		String orgClassName, long orgClassPK,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByClassNameClassPK_First(orgClassName,
				orgClassPK, orderByComparator);

		if (empOrgRelationship != null) {
			return empOrgRelationship;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orgClassName=");
		msg.append(orgClassName);

		msg.append(", orgClassPK=");
		msg.append(orgClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpOrgRelationshipException(msg.toString());
	}

	/**
	 * Returns the first emp org relationship in the ordered set where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByClassNameClassPK_First(
		String orgClassName, long orgClassPK,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpOrgRelationship> list = findByClassNameClassPK(orgClassName,
				orgClassPK, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp org relationship in the ordered set where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByClassNameClassPK_Last(String orgClassName,
		long orgClassPK, OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByClassNameClassPK_Last(orgClassName,
				orgClassPK, orderByComparator);

		if (empOrgRelationship != null) {
			return empOrgRelationship;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("orgClassName=");
		msg.append(orgClassName);

		msg.append(", orgClassPK=");
		msg.append(orgClassPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpOrgRelationshipException(msg.toString());
	}

	/**
	 * Returns the last emp org relationship in the ordered set where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByClassNameClassPK_Last(
		String orgClassName, long orgClassPK,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClassNameClassPK(orgClassName, orgClassPK);

		if (count == 0) {
			return null;
		}

		List<EmpOrgRelationship> list = findByClassNameClassPK(orgClassName,
				orgClassPK, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp org relationships before and after the current emp org relationship in the ordered set where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param empOrgRelationshipId the primary key of the current emp org relationship
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship[] findByClassNameClassPK_PrevAndNext(
		long empOrgRelationshipId, String orgClassName, long orgClassPK,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = findByPrimaryKey(empOrgRelationshipId);

		Session session = null;

		try {
			session = openSession();

			EmpOrgRelationship[] array = new EmpOrgRelationshipImpl[3];

			array[0] = getByClassNameClassPK_PrevAndNext(session,
					empOrgRelationship, orgClassName, orgClassPK,
					orderByComparator, true);

			array[1] = empOrgRelationship;

			array[2] = getByClassNameClassPK_PrevAndNext(session,
					empOrgRelationship, orgClassName, orgClassPK,
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

	protected EmpOrgRelationship getByClassNameClassPK_PrevAndNext(
		Session session, EmpOrgRelationship empOrgRelationship,
		String orgClassName, long orgClassPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

		boolean bindOrgClassName = false;

		if (orgClassName == null) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_1);
		}
		else if (orgClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_3);
		}
		else {
			bindOrgClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSPK_2);

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
			query.append(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindOrgClassName) {
			qPos.add(orgClassName);
		}

		qPos.add(orgClassPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empOrgRelationship);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpOrgRelationship> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp org relationships where orgClassName = &#63; and orgClassPK = &#63; from the database.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassNameClassPK(String orgClassName, long orgClassPK)
		throws SystemException {
		for (EmpOrgRelationship empOrgRelationship : findByClassNameClassPK(
				orgClassName, orgClassPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(empOrgRelationship);
		}
	}

	/**
	 * Returns the number of emp org relationships where orgClassName = &#63; and orgClassPK = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @return the number of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassNameClassPK(String orgClassName, long orgClassPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMECLASSPK;

		Object[] finderArgs = new Object[] { orgClassName, orgClassPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EMPORGRELATIONSHIP_WHERE);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

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

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_1 = "empOrgRelationship.orgClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_2 = "empOrgRelationship.orgClassName = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSNAME_3 = "(empOrgRelationship.orgClassName IS NULL OR empOrgRelationship.orgClassName = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPK_ORGCLASSPK_2 = "empOrgRelationship.orgClassPK = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByClassNameClassPKHeadOfOrg",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			EmpOrgRelationshipModelImpl.ORGCLASSNAME_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.ORGCLASSPK_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.HEADOFORG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKHEADOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameClassPKHeadOfOrg",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException} if it could not be found.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByClassNameClassPKHeadOfOrg(
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByClassNameClassPKHeadOfOrg(orgClassName,
				orgClassPK, headOfOrg);

		if (empOrgRelationship == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orgClassName=");
			msg.append(orgClassName);

			msg.append(", orgClassPK=");
			msg.append(orgClassPK);

			msg.append(", headOfOrg=");
			msg.append(headOfOrg);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpOrgRelationshipException(msg.toString());
		}

		return empOrgRelationship;
	}

	/**
	 * Returns the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByClassNameClassPKHeadOfOrg(
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws SystemException {
		return fetchByClassNameClassPKHeadOfOrg(orgClassName, orgClassPK,
			headOfOrg, true);
	}

	/**
	 * Returns the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByClassNameClassPKHeadOfOrg(
		String orgClassName, long orgClassPK, boolean headOfOrg,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { orgClassName, orgClassPK, headOfOrg };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
					finderArgs, this);
		}

		if (result instanceof EmpOrgRelationship) {
			EmpOrgRelationship empOrgRelationship = (EmpOrgRelationship)result;

			if (!Validator.equals(orgClassName,
						empOrgRelationship.getOrgClassName()) ||
					(orgClassPK != empOrgRelationship.getOrgClassPK()) ||
					(headOfOrg != empOrgRelationship.getHeadOfOrg())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_HEADOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				qPos.add(headOfOrg);

				List<EmpOrgRelationship> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpOrgRelationshipPersistenceImpl.fetchByClassNameClassPKHeadOfOrg(String, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmpOrgRelationship empOrgRelationship = list.get(0);

					result = empOrgRelationship;

					cacheResult(empOrgRelationship);

					if ((empOrgRelationship.getOrgClassName() == null) ||
							!empOrgRelationship.getOrgClassName()
												   .equals(orgClassName) ||
							(empOrgRelationship.getOrgClassPK() != orgClassPK) ||
							(empOrgRelationship.getHeadOfOrg() != headOfOrg)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
							finderArgs, empOrgRelationship);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
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
			return (EmpOrgRelationship)result;
		}
	}

	/**
	 * Removes the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; from the database.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the emp org relationship that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship removeByClassNameClassPKHeadOfOrg(
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = findByClassNameClassPKHeadOfOrg(orgClassName,
				orgClassPK, headOfOrg);

		return remove(empOrgRelationship);
	}

	/**
	 * Returns the number of emp org relationships where orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the number of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassNameClassPKHeadOfOrg(String orgClassName,
		long orgClassPK, boolean headOfOrg) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKHEADOFORG;

		Object[] finderArgs = new Object[] { orgClassName, orgClassPK, headOfOrg };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EMPORGRELATIONSHIP_WHERE);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_HEADOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				qPos.add(headOfOrg);

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

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_1 =
		"empOrgRelationship.orgClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_2 =
		"empOrgRelationship.orgClassName = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_3 =
		"(empOrgRelationship.orgClassName IS NULL OR empOrgRelationship.orgClassName = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_ORGCLASSPK_2 =
		"empOrgRelationship.orgClassPK = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKHEADOFORG_HEADOFORG_2 =
		"empOrgRelationship.headOfOrg = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByClassNameClassPKDeputyOfOrg",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			EmpOrgRelationshipModelImpl.ORGCLASSNAME_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.ORGCLASSPK_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.DEPUTYOFORG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKDEPUTYOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameClassPKDeputyOfOrg",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and deputyOfOrg = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException} if it could not be found.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param deputyOfOrg the deputy of org
	 * @return the matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByClassNameClassPKDeputyOfOrg(
		String orgClassName, long orgClassPK, boolean deputyOfOrg)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByClassNameClassPKDeputyOfOrg(orgClassName,
				orgClassPK, deputyOfOrg);

		if (empOrgRelationship == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("orgClassName=");
			msg.append(orgClassName);

			msg.append(", orgClassPK=");
			msg.append(orgClassPK);

			msg.append(", deputyOfOrg=");
			msg.append(deputyOfOrg);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpOrgRelationshipException(msg.toString());
		}

		return empOrgRelationship;
	}

	/**
	 * Returns the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and deputyOfOrg = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param deputyOfOrg the deputy of org
	 * @return the matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByClassNameClassPKDeputyOfOrg(
		String orgClassName, long orgClassPK, boolean deputyOfOrg)
		throws SystemException {
		return fetchByClassNameClassPKDeputyOfOrg(orgClassName, orgClassPK,
			deputyOfOrg, true);
	}

	/**
	 * Returns the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and deputyOfOrg = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param deputyOfOrg the deputy of org
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByClassNameClassPKDeputyOfOrg(
		String orgClassName, long orgClassPK, boolean deputyOfOrg,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { orgClassName, orgClassPK, deputyOfOrg };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
					finderArgs, this);
		}

		if (result instanceof EmpOrgRelationship) {
			EmpOrgRelationship empOrgRelationship = (EmpOrgRelationship)result;

			if (!Validator.equals(orgClassName,
						empOrgRelationship.getOrgClassName()) ||
					(orgClassPK != empOrgRelationship.getOrgClassPK()) ||
					(deputyOfOrg != empOrgRelationship.getDeputyOfOrg())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_DEPUTYOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				qPos.add(deputyOfOrg);

				List<EmpOrgRelationship> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpOrgRelationshipPersistenceImpl.fetchByClassNameClassPKDeputyOfOrg(String, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmpOrgRelationship empOrgRelationship = list.get(0);

					result = empOrgRelationship;

					cacheResult(empOrgRelationship);

					if ((empOrgRelationship.getOrgClassName() == null) ||
							!empOrgRelationship.getOrgClassName()
												   .equals(orgClassName) ||
							(empOrgRelationship.getOrgClassPK() != orgClassPK) ||
							(empOrgRelationship.getDeputyOfOrg() != deputyOfOrg)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
							finderArgs, empOrgRelationship);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
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
			return (EmpOrgRelationship)result;
		}
	}

	/**
	 * Removes the emp org relationship where orgClassName = &#63; and orgClassPK = &#63; and deputyOfOrg = &#63; from the database.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param deputyOfOrg the deputy of org
	 * @return the emp org relationship that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship removeByClassNameClassPKDeputyOfOrg(
		String orgClassName, long orgClassPK, boolean deputyOfOrg)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = findByClassNameClassPKDeputyOfOrg(orgClassName,
				orgClassPK, deputyOfOrg);

		return remove(empOrgRelationship);
	}

	/**
	 * Returns the number of emp org relationships where orgClassName = &#63; and orgClassPK = &#63; and deputyOfOrg = &#63;.
	 *
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param deputyOfOrg the deputy of org
	 * @return the number of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassNameClassPKDeputyOfOrg(String orgClassName,
		long orgClassPK, boolean deputyOfOrg) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKDEPUTYOFORG;

		Object[] finderArgs = new Object[] { orgClassName, orgClassPK, deputyOfOrg };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EMPORGRELATIONSHIP_WHERE);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSPK_2);

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_DEPUTYOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				qPos.add(deputyOfOrg);

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

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_1 =
		"empOrgRelationship.orgClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_2 =
		"empOrgRelationship.orgClassName = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSNAME_3 =
		"(empOrgRelationship.orgClassName IS NULL OR empOrgRelationship.orgClassName = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_ORGCLASSPK_2 =
		"empOrgRelationship.orgClassPK = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKDEPUTYOFORG_DEPUTYOFORG_2 =
		"empOrgRelationship.deputyOfOrg = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByEmpClassNameClassPKHeadOfOrg",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			EmpOrgRelationshipModelImpl.EMPID_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.ORGCLASSNAME_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.ORGCLASSPK_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.HEADOFORG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPCLASSNAMECLASSPKHEADOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmpClassNameClassPKHeadOfOrg",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

	/**
	 * Returns the emp org relationship where empId = &#63; and orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException} if it could not be found.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByEmpClassNameClassPKHeadOfOrg(long empId,
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByEmpClassNameClassPKHeadOfOrg(empId,
				orgClassName, orgClassPK, headOfOrg);

		if (empOrgRelationship == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("empId=");
			msg.append(empId);

			msg.append(", orgClassName=");
			msg.append(orgClassName);

			msg.append(", orgClassPK=");
			msg.append(orgClassPK);

			msg.append(", headOfOrg=");
			msg.append(headOfOrg);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchEmpOrgRelationshipException(msg.toString());
		}

		return empOrgRelationship;
	}

	/**
	 * Returns the emp org relationship where empId = &#63; and orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByEmpClassNameClassPKHeadOfOrg(long empId,
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws SystemException {
		return fetchByEmpClassNameClassPKHeadOfOrg(empId, orgClassName,
			orgClassPK, headOfOrg, true);
	}

	/**
	 * Returns the emp org relationship where empId = &#63; and orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByEmpClassNameClassPKHeadOfOrg(long empId,
		String orgClassName, long orgClassPK, boolean headOfOrg,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] {
				empId, orgClassName, orgClassPK, headOfOrg
			};

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
					finderArgs, this);
		}

		if (result instanceof EmpOrgRelationship) {
			EmpOrgRelationship empOrgRelationship = (EmpOrgRelationship)result;

			if ((empId != empOrgRelationship.getEmpId()) ||
					!Validator.equals(orgClassName,
						empOrgRelationship.getOrgClassName()) ||
					(orgClassPK != empOrgRelationship.getOrgClassPK()) ||
					(headOfOrg != empOrgRelationship.getHeadOfOrg())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

			query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_EMPID_2);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSPK_2);

			query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_HEADOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				qPos.add(headOfOrg);

				List<EmpOrgRelationship> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"EmpOrgRelationshipPersistenceImpl.fetchByEmpClassNameClassPKHeadOfOrg(long, String, long, boolean, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					EmpOrgRelationship empOrgRelationship = list.get(0);

					result = empOrgRelationship;

					cacheResult(empOrgRelationship);

					if ((empOrgRelationship.getEmpId() != empId) ||
							(empOrgRelationship.getOrgClassName() == null) ||
							!empOrgRelationship.getOrgClassName()
												   .equals(orgClassName) ||
							(empOrgRelationship.getOrgClassPK() != orgClassPK) ||
							(empOrgRelationship.getHeadOfOrg() != headOfOrg)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
							finderArgs, empOrgRelationship);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
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
			return (EmpOrgRelationship)result;
		}
	}

	/**
	 * Removes the emp org relationship where empId = &#63; and orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the emp org relationship that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship removeByEmpClassNameClassPKHeadOfOrg(long empId,
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = findByEmpClassNameClassPKHeadOfOrg(empId,
				orgClassName, orgClassPK, headOfOrg);

		return remove(empOrgRelationship);
	}

	/**
	 * Returns the number of emp org relationships where empId = &#63; and orgClassName = &#63; and orgClassPK = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param orgClassPK the org class p k
	 * @param headOfOrg the head of org
	 * @return the number of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmpClassNameClassPKHeadOfOrg(long empId,
		String orgClassName, long orgClassPK, boolean headOfOrg)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPCLASSNAMECLASSPKHEADOFORG;

		Object[] finderArgs = new Object[] {
				empId, orgClassName, orgClassPK, headOfOrg
			};

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_EMPORGRELATIONSHIP_WHERE);

			query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_EMPID_2);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSPK_2);

			query.append(_FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_HEADOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(orgClassPK);

				qPos.add(headOfOrg);

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

	private static final String _FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_EMPID_2 =
		"empOrgRelationship.empId = ? AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_1 =
		"empOrgRelationship.orgClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_2 =
		"empOrgRelationship.orgClassName = ? AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSNAME_3 =
		"(empOrgRelationship.orgClassName IS NULL OR empOrgRelationship.orgClassName = '') AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_ORGCLASSPK_2 =
		"empOrgRelationship.orgClassPK = ? AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMECLASSPKHEADOFORG_HEADOFORG_2 =
		"empOrgRelationship.headOfOrg = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmpClassNameHeadOfOrg",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG =
		new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmpClassNameHeadOfOrg",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			},
			EmpOrgRelationshipModelImpl.EMPID_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.ORGCLASSNAME_COLUMN_BITMASK |
			EmpOrgRelationshipModelImpl.HEADOFORG_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPCLASSNAMEHEADOFORG = new FinderPath(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByEmpClassNameHeadOfOrg",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the emp org relationships where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @return the matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByEmpClassNameHeadOfOrg(long empId,
		String orgClassName, boolean headOfOrg) throws SystemException {
		return findByEmpClassNameHeadOfOrg(empId, orgClassName, headOfOrg,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp org relationships where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @return the range of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByEmpClassNameHeadOfOrg(long empId,
		String orgClassName, boolean headOfOrg, int start, int end)
		throws SystemException {
		return findByEmpClassNameHeadOfOrg(empId, orgClassName, headOfOrg,
			start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp org relationships where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findByEmpClassNameHeadOfOrg(long empId,
		String orgClassName, boolean headOfOrg, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG;
			finderArgs = new Object[] { empId, orgClassName, headOfOrg };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG;
			finderArgs = new Object[] {
					empId, orgClassName, headOfOrg,
					
					start, end, orderByComparator
				};
		}

		List<EmpOrgRelationship> list = (List<EmpOrgRelationship>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpOrgRelationship empOrgRelationship : list) {
				if ((empId != empOrgRelationship.getEmpId()) ||
						!Validator.equals(orgClassName,
							empOrgRelationship.getOrgClassName()) ||
						(headOfOrg != empOrgRelationship.getHeadOfOrg())) {
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

			query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_EMPID_2);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_HEADOFORG_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(headOfOrg);

				if (!pagination) {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpOrgRelationship>(list);
				}
				else {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
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
	 * Returns the first emp org relationship in the ordered set where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByEmpClassNameHeadOfOrg_First(long empId,
		String orgClassName, boolean headOfOrg,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByEmpClassNameHeadOfOrg_First(empId,
				orgClassName, headOfOrg, orderByComparator);

		if (empOrgRelationship != null) {
			return empOrgRelationship;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(", orgClassName=");
		msg.append(orgClassName);

		msg.append(", headOfOrg=");
		msg.append(headOfOrg);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpOrgRelationshipException(msg.toString());
	}

	/**
	 * Returns the first emp org relationship in the ordered set where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByEmpClassNameHeadOfOrg_First(long empId,
		String orgClassName, boolean headOfOrg,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpOrgRelationship> list = findByEmpClassNameHeadOfOrg(empId,
				orgClassName, headOfOrg, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp org relationship in the ordered set where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByEmpClassNameHeadOfOrg_Last(long empId,
		String orgClassName, boolean headOfOrg,
		OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByEmpClassNameHeadOfOrg_Last(empId,
				orgClassName, headOfOrg, orderByComparator);

		if (empOrgRelationship != null) {
			return empOrgRelationship;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(", orgClassName=");
		msg.append(orgClassName);

		msg.append(", headOfOrg=");
		msg.append(headOfOrg);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpOrgRelationshipException(msg.toString());
	}

	/**
	 * Returns the last emp org relationship in the ordered set where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp org relationship, or <code>null</code> if a matching emp org relationship could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByEmpClassNameHeadOfOrg_Last(long empId,
		String orgClassName, boolean headOfOrg,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmpClassNameHeadOfOrg(empId, orgClassName, headOfOrg);

		if (count == 0) {
			return null;
		}

		List<EmpOrgRelationship> list = findByEmpClassNameHeadOfOrg(empId,
				orgClassName, headOfOrg, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp org relationships before and after the current emp org relationship in the ordered set where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empOrgRelationshipId the primary key of the current emp org relationship
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship[] findByEmpClassNameHeadOfOrg_PrevAndNext(
		long empOrgRelationshipId, long empId, String orgClassName,
		boolean headOfOrg, OrderByComparator orderByComparator)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = findByPrimaryKey(empOrgRelationshipId);

		Session session = null;

		try {
			session = openSession();

			EmpOrgRelationship[] array = new EmpOrgRelationshipImpl[3];

			array[0] = getByEmpClassNameHeadOfOrg_PrevAndNext(session,
					empOrgRelationship, empId, orgClassName, headOfOrg,
					orderByComparator, true);

			array[1] = empOrgRelationship;

			array[2] = getByEmpClassNameHeadOfOrg_PrevAndNext(session,
					empOrgRelationship, empId, orgClassName, headOfOrg,
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

	protected EmpOrgRelationship getByEmpClassNameHeadOfOrg_PrevAndNext(
		Session session, EmpOrgRelationship empOrgRelationship, long empId,
		String orgClassName, boolean headOfOrg,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPORGRELATIONSHIP_WHERE);

		query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_EMPID_2);

		boolean bindOrgClassName = false;

		if (orgClassName == null) {
			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_1);
		}
		else if (orgClassName.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_3);
		}
		else {
			bindOrgClassName = true;

			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_HEADOFORG_2);

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
			query.append(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (bindOrgClassName) {
			qPos.add(orgClassName);
		}

		qPos.add(headOfOrg);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empOrgRelationship);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpOrgRelationship> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp org relationships where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmpClassNameHeadOfOrg(long empId, String orgClassName,
		boolean headOfOrg) throws SystemException {
		for (EmpOrgRelationship empOrgRelationship : findByEmpClassNameHeadOfOrg(
				empId, orgClassName, headOfOrg, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(empOrgRelationship);
		}
	}

	/**
	 * Returns the number of emp org relationships where empId = &#63; and orgClassName = &#63; and headOfOrg = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orgClassName the org class name
	 * @param headOfOrg the head of org
	 * @return the number of matching emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmpClassNameHeadOfOrg(long empId, String orgClassName,
		boolean headOfOrg) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPCLASSNAMEHEADOFORG;

		Object[] finderArgs = new Object[] { empId, orgClassName, headOfOrg };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EMPORGRELATIONSHIP_WHERE);

			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_EMPID_2);

			boolean bindOrgClassName = false;

			if (orgClassName == null) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_1);
			}
			else if (orgClassName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_3);
			}
			else {
				bindOrgClassName = true;

				query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_HEADOFORG_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindOrgClassName) {
					qPos.add(orgClassName);
				}

				qPos.add(headOfOrg);

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

	private static final String _FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_EMPID_2 = "empOrgRelationship.empId = ? AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_1 =
		"empOrgRelationship.orgClassName IS NULL AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_2 =
		"empOrgRelationship.orgClassName = ? AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_ORGCLASSNAME_3 =
		"(empOrgRelationship.orgClassName IS NULL OR empOrgRelationship.orgClassName = '') AND ";
	private static final String _FINDER_COLUMN_EMPCLASSNAMEHEADOFORG_HEADOFORG_2 =
		"empOrgRelationship.headOfOrg = ?";

	public EmpOrgRelationshipPersistenceImpl() {
		setModelClass(EmpOrgRelationship.class);
	}

	/**
	 * Caches the emp org relationship in the entity cache if it is enabled.
	 *
	 * @param empOrgRelationship the emp org relationship
	 */
	@Override
	public void cacheResult(EmpOrgRelationship empOrgRelationship) {
		EntityCacheUtil.putResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class, empOrgRelationship.getPrimaryKey(),
			empOrgRelationship);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
			new Object[] {
				empOrgRelationship.getOrgClassName(),
				empOrgRelationship.getOrgClassPK(),
				empOrgRelationship.getHeadOfOrg()
			}, empOrgRelationship);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
			new Object[] {
				empOrgRelationship.getOrgClassName(),
				empOrgRelationship.getOrgClassPK(),
				empOrgRelationship.getDeputyOfOrg()
			}, empOrgRelationship);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
			new Object[] {
				empOrgRelationship.getEmpId(),
				empOrgRelationship.getOrgClassName(),
				empOrgRelationship.getOrgClassPK(),
				empOrgRelationship.getHeadOfOrg()
			}, empOrgRelationship);

		empOrgRelationship.resetOriginalValues();
	}

	/**
	 * Caches the emp org relationships in the entity cache if it is enabled.
	 *
	 * @param empOrgRelationships the emp org relationships
	 */
	@Override
	public void cacheResult(List<EmpOrgRelationship> empOrgRelationships) {
		for (EmpOrgRelationship empOrgRelationship : empOrgRelationships) {
			if (EntityCacheUtil.getResult(
						EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
						EmpOrgRelationshipImpl.class,
						empOrgRelationship.getPrimaryKey()) == null) {
				cacheResult(empOrgRelationship);
			}
			else {
				empOrgRelationship.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp org relationships.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpOrgRelationshipImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpOrgRelationshipImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp org relationship.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpOrgRelationship empOrgRelationship) {
		EntityCacheUtil.removeResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class, empOrgRelationship.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(empOrgRelationship);
	}

	@Override
	public void clearCache(List<EmpOrgRelationship> empOrgRelationships) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpOrgRelationship empOrgRelationship : empOrgRelationships) {
			EntityCacheUtil.removeResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
				EmpOrgRelationshipImpl.class, empOrgRelationship.getPrimaryKey());

			clearUniqueFindersCache(empOrgRelationship);
		}
	}

	protected void cacheUniqueFindersCache(
		EmpOrgRelationship empOrgRelationship) {
		if (empOrgRelationship.isNew()) {
			Object[] args = new Object[] {
					empOrgRelationship.getOrgClassName(),
					empOrgRelationship.getOrgClassPK(),
					empOrgRelationship.getHeadOfOrg()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKHEADOFORG,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
				args, empOrgRelationship);

			args = new Object[] {
					empOrgRelationship.getOrgClassName(),
					empOrgRelationship.getOrgClassPK(),
					empOrgRelationship.getDeputyOfOrg()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKDEPUTYOFORG,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
				args, empOrgRelationship);

			args = new Object[] {
					empOrgRelationship.getEmpId(),
					empOrgRelationship.getOrgClassName(),
					empOrgRelationship.getOrgClassPK(),
					empOrgRelationship.getHeadOfOrg()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPCLASSNAMECLASSPKHEADOFORG,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
				args, empOrgRelationship);
		}
		else {
			EmpOrgRelationshipModelImpl empOrgRelationshipModelImpl = (EmpOrgRelationshipModelImpl)empOrgRelationship;

			if ((empOrgRelationshipModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empOrgRelationship.getOrgClassName(),
						empOrgRelationship.getOrgClassPK(),
						empOrgRelationship.getHeadOfOrg()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKHEADOFORG,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
					args, empOrgRelationship);
			}

			if ((empOrgRelationshipModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empOrgRelationship.getOrgClassName(),
						empOrgRelationship.getOrgClassPK(),
						empOrgRelationship.getDeputyOfOrg()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKDEPUTYOFORG,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
					args, empOrgRelationship);
			}

			if ((empOrgRelationshipModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empOrgRelationship.getEmpId(),
						empOrgRelationship.getOrgClassName(),
						empOrgRelationship.getOrgClassPK(),
						empOrgRelationship.getHeadOfOrg()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMPCLASSNAMECLASSPKHEADOFORG,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
					args, empOrgRelationship);
			}
		}
	}

	protected void clearUniqueFindersCache(
		EmpOrgRelationship empOrgRelationship) {
		EmpOrgRelationshipModelImpl empOrgRelationshipModelImpl = (EmpOrgRelationshipModelImpl)empOrgRelationship;

		Object[] args = new Object[] {
				empOrgRelationship.getOrgClassName(),
				empOrgRelationship.getOrgClassPK(),
				empOrgRelationship.getHeadOfOrg()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKHEADOFORG,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
			args);

		if ((empOrgRelationshipModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG.getColumnBitmask()) != 0) {
			args = new Object[] {
					empOrgRelationshipModelImpl.getOriginalOrgClassName(),
					empOrgRelationshipModelImpl.getOriginalOrgClassPK(),
					empOrgRelationshipModelImpl.getOriginalHeadOfOrg()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKHEADOFORG,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKHEADOFORG,
				args);
		}

		args = new Object[] {
				empOrgRelationship.getOrgClassName(),
				empOrgRelationship.getOrgClassPK(),
				empOrgRelationship.getDeputyOfOrg()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKDEPUTYOFORG,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
			args);

		if ((empOrgRelationshipModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG.getColumnBitmask()) != 0) {
			args = new Object[] {
					empOrgRelationshipModelImpl.getOriginalOrgClassName(),
					empOrgRelationshipModelImpl.getOriginalOrgClassPK(),
					empOrgRelationshipModelImpl.getOriginalDeputyOfOrg()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKDEPUTYOFORG,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CLASSNAMECLASSPKDEPUTYOFORG,
				args);
		}

		args = new Object[] {
				empOrgRelationship.getEmpId(),
				empOrgRelationship.getOrgClassName(),
				empOrgRelationship.getOrgClassPK(),
				empOrgRelationship.getHeadOfOrg()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPCLASSNAMECLASSPKHEADOFORG,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
			args);

		if ((empOrgRelationshipModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG.getColumnBitmask()) != 0) {
			args = new Object[] {
					empOrgRelationshipModelImpl.getOriginalEmpId(),
					empOrgRelationshipModelImpl.getOriginalOrgClassName(),
					empOrgRelationshipModelImpl.getOriginalOrgClassPK(),
					empOrgRelationshipModelImpl.getOriginalHeadOfOrg()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPCLASSNAMECLASSPKHEADOFORG,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMPCLASSNAMECLASSPKHEADOFORG,
				args);
		}
	}

	/**
	 * Creates a new emp org relationship with the primary key. Does not add the emp org relationship to the database.
	 *
	 * @param empOrgRelationshipId the primary key for the new emp org relationship
	 * @return the new emp org relationship
	 */
	@Override
	public EmpOrgRelationship create(long empOrgRelationshipId) {
		EmpOrgRelationship empOrgRelationship = new EmpOrgRelationshipImpl();

		empOrgRelationship.setNew(true);
		empOrgRelationship.setPrimaryKey(empOrgRelationshipId);

		return empOrgRelationship;
	}

	/**
	 * Removes the emp org relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empOrgRelationshipId the primary key of the emp org relationship
	 * @return the emp org relationship that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship remove(long empOrgRelationshipId)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		return remove((Serializable)empOrgRelationshipId);
	}

	/**
	 * Removes the emp org relationship with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp org relationship
	 * @return the emp org relationship that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship remove(Serializable primaryKey)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpOrgRelationship empOrgRelationship = (EmpOrgRelationship)session.get(EmpOrgRelationshipImpl.class,
					primaryKey);

			if (empOrgRelationship == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpOrgRelationshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empOrgRelationship);
		}
		catch (NoSuchEmpOrgRelationshipException nsee) {
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
	protected EmpOrgRelationship removeImpl(
		EmpOrgRelationship empOrgRelationship) throws SystemException {
		empOrgRelationship = toUnwrappedModel(empOrgRelationship);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empOrgRelationship)) {
				empOrgRelationship = (EmpOrgRelationship)session.get(EmpOrgRelationshipImpl.class,
						empOrgRelationship.getPrimaryKeyObj());
			}

			if (empOrgRelationship != null) {
				session.delete(empOrgRelationship);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empOrgRelationship != null) {
			clearCache(empOrgRelationship);
		}

		return empOrgRelationship;
	}

	@Override
	public EmpOrgRelationship updateImpl(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship)
		throws SystemException {
		empOrgRelationship = toUnwrappedModel(empOrgRelationship);

		boolean isNew = empOrgRelationship.isNew();

		EmpOrgRelationshipModelImpl empOrgRelationshipModelImpl = (EmpOrgRelationshipModelImpl)empOrgRelationship;

		Session session = null;

		try {
			session = openSession();

			if (empOrgRelationship.isNew()) {
				session.save(empOrgRelationship);

				empOrgRelationship.setNew(false);
			}
			else {
				session.merge(empOrgRelationship);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpOrgRelationshipModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empOrgRelationshipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empOrgRelationshipModelImpl.getOriginalEmpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);

				args = new Object[] { empOrgRelationshipModelImpl.getEmpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);
			}

			if ((empOrgRelationshipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empOrgRelationshipModelImpl.getOriginalOrgClassName(),
						empOrgRelationshipModelImpl.getOriginalOrgClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPK,
					args);

				args = new Object[] {
						empOrgRelationshipModelImpl.getOrgClassName(),
						empOrgRelationshipModelImpl.getOrgClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPK,
					args);
			}

			if ((empOrgRelationshipModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empOrgRelationshipModelImpl.getOriginalEmpId(),
						empOrgRelationshipModelImpl.getOriginalOrgClassName(),
						empOrgRelationshipModelImpl.getOriginalHeadOfOrg()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPCLASSNAMEHEADOFORG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG,
					args);

				args = new Object[] {
						empOrgRelationshipModelImpl.getEmpId(),
						empOrgRelationshipModelImpl.getOrgClassName(),
						empOrgRelationshipModelImpl.getHeadOfOrg()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPCLASSNAMEHEADOFORG,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPCLASSNAMEHEADOFORG,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
			EmpOrgRelationshipImpl.class, empOrgRelationship.getPrimaryKey(),
			empOrgRelationship);

		clearUniqueFindersCache(empOrgRelationship);
		cacheUniqueFindersCache(empOrgRelationship);

		return empOrgRelationship;
	}

	protected EmpOrgRelationship toUnwrappedModel(
		EmpOrgRelationship empOrgRelationship) {
		if (empOrgRelationship instanceof EmpOrgRelationshipImpl) {
			return empOrgRelationship;
		}

		EmpOrgRelationshipImpl empOrgRelationshipImpl = new EmpOrgRelationshipImpl();

		empOrgRelationshipImpl.setNew(empOrgRelationship.isNew());
		empOrgRelationshipImpl.setPrimaryKey(empOrgRelationship.getPrimaryKey());

		empOrgRelationshipImpl.setEmpOrgRelationshipId(empOrgRelationship.getEmpOrgRelationshipId());
		empOrgRelationshipImpl.setEmpId(empOrgRelationship.getEmpId());
		empOrgRelationshipImpl.setOrgClassName(empOrgRelationship.getOrgClassName());
		empOrgRelationshipImpl.setOrgClassPK(empOrgRelationship.getOrgClassPK());
		empOrgRelationshipImpl.setHeadOfOrg(empOrgRelationship.isHeadOfOrg());
		empOrgRelationshipImpl.setDeputyOfOrg(empOrgRelationship.isDeputyOfOrg());
		empOrgRelationshipImpl.setGroupId(empOrgRelationship.getGroupId());
		empOrgRelationshipImpl.setCompanyId(empOrgRelationship.getCompanyId());
		empOrgRelationshipImpl.setUserId(empOrgRelationship.getUserId());
		empOrgRelationshipImpl.setUserName(empOrgRelationship.getUserName());
		empOrgRelationshipImpl.setCreateDate(empOrgRelationship.getCreateDate());
		empOrgRelationshipImpl.setModifiedDate(empOrgRelationship.getModifiedDate());

		return empOrgRelationshipImpl;
	}

	/**
	 * Returns the emp org relationship with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp org relationship
	 * @return the emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		EmpOrgRelationship empOrgRelationship = fetchByPrimaryKey(primaryKey);

		if (empOrgRelationship == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpOrgRelationshipException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empOrgRelationship;
	}

	/**
	 * Returns the emp org relationship with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException} if it could not be found.
	 *
	 * @param empOrgRelationshipId the primary key of the emp org relationship
	 * @return the emp org relationship
	 * @throws vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship findByPrimaryKey(long empOrgRelationshipId)
		throws NoSuchEmpOrgRelationshipException, SystemException {
		return findByPrimaryKey((Serializable)empOrgRelationshipId);
	}

	/**
	 * Returns the emp org relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp org relationship
	 * @return the emp org relationship, or <code>null</code> if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpOrgRelationship empOrgRelationship = (EmpOrgRelationship)EntityCacheUtil.getResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
				EmpOrgRelationshipImpl.class, primaryKey);

		if (empOrgRelationship == _nullEmpOrgRelationship) {
			return null;
		}

		if (empOrgRelationship == null) {
			Session session = null;

			try {
				session = openSession();

				empOrgRelationship = (EmpOrgRelationship)session.get(EmpOrgRelationshipImpl.class,
						primaryKey);

				if (empOrgRelationship != null) {
					cacheResult(empOrgRelationship);
				}
				else {
					EntityCacheUtil.putResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
						EmpOrgRelationshipImpl.class, primaryKey,
						_nullEmpOrgRelationship);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpOrgRelationshipModelImpl.ENTITY_CACHE_ENABLED,
					EmpOrgRelationshipImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empOrgRelationship;
	}

	/**
	 * Returns the emp org relationship with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empOrgRelationshipId the primary key of the emp org relationship
	 * @return the emp org relationship, or <code>null</code> if a emp org relationship with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpOrgRelationship fetchByPrimaryKey(long empOrgRelationshipId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empOrgRelationshipId);
	}

	/**
	 * Returns all the emp org relationships.
	 *
	 * @return the emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp org relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @return the range of emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp org relationships.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp org relationships
	 * @param end the upper bound of the range of emp org relationships (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp org relationships
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpOrgRelationship> findAll(int start, int end,
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

		List<EmpOrgRelationship> list = (List<EmpOrgRelationship>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPORGRELATIONSHIP);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPORGRELATIONSHIP;

				if (pagination) {
					sql = sql.concat(EmpOrgRelationshipModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpOrgRelationship>(list);
				}
				else {
					list = (List<EmpOrgRelationship>)QueryUtil.list(q,
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
	 * Removes all the emp org relationships from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpOrgRelationship empOrgRelationship : findAll()) {
			remove(empOrgRelationship);
		}
	}

	/**
	 * Returns the number of emp org relationships.
	 *
	 * @return the number of emp org relationships
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

				Query q = session.createQuery(_SQL_COUNT_EMPORGRELATIONSHIP);

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
	 * Initializes the emp org relationship persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpOrgRelationship")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpOrgRelationship>> listenersList = new ArrayList<ModelListener<EmpOrgRelationship>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpOrgRelationship>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpOrgRelationshipImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPORGRELATIONSHIP = "SELECT empOrgRelationship FROM EmpOrgRelationship empOrgRelationship";
	private static final String _SQL_SELECT_EMPORGRELATIONSHIP_WHERE = "SELECT empOrgRelationship FROM EmpOrgRelationship empOrgRelationship WHERE ";
	private static final String _SQL_COUNT_EMPORGRELATIONSHIP = "SELECT COUNT(empOrgRelationship) FROM EmpOrgRelationship empOrgRelationship";
	private static final String _SQL_COUNT_EMPORGRELATIONSHIP_WHERE = "SELECT COUNT(empOrgRelationship) FROM EmpOrgRelationship empOrgRelationship WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empOrgRelationship.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpOrgRelationship exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpOrgRelationship exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpOrgRelationshipPersistenceImpl.class);
	private static EmpOrgRelationship _nullEmpOrgRelationship = new EmpOrgRelationshipImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpOrgRelationship> toCacheModel() {
				return _nullEmpOrgRelationshipCacheModel;
			}
		};

	private static CacheModel<EmpOrgRelationship> _nullEmpOrgRelationshipCacheModel =
		new CacheModel<EmpOrgRelationship>() {
			@Override
			public EmpOrgRelationship toEntityModel() {
				return _nullEmpOrgRelationship;
			}
		};
}