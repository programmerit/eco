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

import vn.com.ecopharma.emp.NoSuchVacationLeaveException;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.model.impl.VacationLeaveImpl;
import vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the vacation leave service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see VacationLeavePersistence
 * @see VacationLeaveUtil
 * @generated
 */
public class VacationLeavePersistenceImpl extends BasePersistenceImpl<VacationLeave>
	implements VacationLeavePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link VacationLeaveUtil} to access the vacation leave persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = VacationLeaveImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED,
			VacationLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED,
			VacationLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMP = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED,
			VacationLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmp",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED,
			VacationLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmp", new String[] { Long.class.getName() },
			VacationLeaveModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMP = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmp",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the vacation leaves where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findByEmp(long empId) throws SystemException {
		return findByEmp(empId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacation leaves where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of vacation leaves
	 * @param end the upper bound of the range of vacation leaves (not inclusive)
	 * @return the range of matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findByEmp(long empId, int start, int end)
		throws SystemException {
		return findByEmp(empId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacation leaves where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of vacation leaves
	 * @param end the upper bound of the range of vacation leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findByEmp(long empId, int start, int end,
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

		List<VacationLeave> list = (List<VacationLeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VacationLeave vacationLeave : list) {
				if ((empId != vacationLeave.getEmpId())) {
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

			query.append(_SQL_SELECT_VACATIONLEAVE_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VacationLeaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (!pagination) {
					list = (List<VacationLeave>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacationLeave>(list);
				}
				else {
					list = (List<VacationLeave>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vacation leave in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave findByEmp_First(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = fetchByEmp_First(empId, orderByComparator);

		if (vacationLeave != null) {
			return vacationLeave;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacationLeaveException(msg.toString());
	}

	/**
	 * Returns the first vacation leave in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave fetchByEmp_First(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		List<VacationLeave> list = findByEmp(empId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vacation leave in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave findByEmp_Last(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = fetchByEmp_Last(empId, orderByComparator);

		if (vacationLeave != null) {
			return vacationLeave;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacationLeaveException(msg.toString());
	}

	/**
	 * Returns the last vacation leave in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave fetchByEmp_Last(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmp(empId);

		if (count == 0) {
			return null;
		}

		List<VacationLeave> list = findByEmp(empId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vacation leaves before and after the current vacation leave in the ordered set where empId = &#63;.
	 *
	 * @param vacationLeaveId the primary key of the current vacation leave
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave[] findByEmp_PrevAndNext(long vacationLeaveId,
		long empId, OrderByComparator orderByComparator)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = findByPrimaryKey(vacationLeaveId);

		Session session = null;

		try {
			session = openSession();

			VacationLeave[] array = new VacationLeaveImpl[3];

			array[0] = getByEmp_PrevAndNext(session, vacationLeave, empId,
					orderByComparator, true);

			array[1] = vacationLeave;

			array[2] = getByEmp_PrevAndNext(session, vacationLeave, empId,
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

	protected VacationLeave getByEmp_PrevAndNext(Session session,
		VacationLeave vacationLeave, long empId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VACATIONLEAVE_WHERE);

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
			query.append(VacationLeaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vacationLeave);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VacationLeave> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vacation leaves where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmp(long empId) throws SystemException {
		for (VacationLeave vacationLeave : findByEmp(empId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(vacationLeave);
		}
	}

	/**
	 * Returns the number of vacation leaves where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching vacation leaves
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

			query.append(_SQL_COUNT_VACATIONLEAVE_WHERE);

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

	private static final String _FINDER_COLUMN_EMP_EMPID_2 = "vacationLeave.empId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPANDTYPE =
		new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED,
			VacationLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmpAndType",
			new String[] {
				Long.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPANDTYPE =
		new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED,
			VacationLeaveImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByEmpAndType",
			new String[] { Long.class.getName(), String.class.getName() },
			VacationLeaveModelImpl.EMPID_COLUMN_BITMASK |
			VacationLeaveModelImpl.LEAVETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMPANDTYPE = new FinderPath(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpAndType",
			new String[] { Long.class.getName(), String.class.getName() });

	/**
	 * Returns all the vacation leaves where empId = &#63; and leaveType = &#63;.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @return the matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findByEmpAndType(long empId, String leaveType)
		throws SystemException {
		return findByEmpAndType(empId, leaveType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacation leaves where empId = &#63; and leaveType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param start the lower bound of the range of vacation leaves
	 * @param end the upper bound of the range of vacation leaves (not inclusive)
	 * @return the range of matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findByEmpAndType(long empId, String leaveType,
		int start, int end) throws SystemException {
		return findByEmpAndType(empId, leaveType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacation leaves where empId = &#63; and leaveType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param start the lower bound of the range of vacation leaves
	 * @param end the upper bound of the range of vacation leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findByEmpAndType(long empId, String leaveType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPANDTYPE;
			finderArgs = new Object[] { empId, leaveType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMPANDTYPE;
			finderArgs = new Object[] {
					empId, leaveType,
					
					start, end, orderByComparator
				};
		}

		List<VacationLeave> list = (List<VacationLeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (VacationLeave vacationLeave : list) {
				if ((empId != vacationLeave.getEmpId()) ||
						!Validator.equals(leaveType,
							vacationLeave.getLeaveType())) {
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

			query.append(_SQL_SELECT_VACATIONLEAVE_WHERE);

			query.append(_FINDER_COLUMN_EMPANDTYPE_EMPID_2);

			boolean bindLeaveType = false;

			if (leaveType == null) {
				query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_1);
			}
			else if (leaveType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_3);
			}
			else {
				bindLeaveType = true;

				query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(VacationLeaveModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindLeaveType) {
					qPos.add(leaveType);
				}

				if (!pagination) {
					list = (List<VacationLeave>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacationLeave>(list);
				}
				else {
					list = (List<VacationLeave>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave findByEmpAndType_First(long empId, String leaveType,
		OrderByComparator orderByComparator)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = fetchByEmpAndType_First(empId, leaveType,
				orderByComparator);

		if (vacationLeave != null) {
			return vacationLeave;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(", leaveType=");
		msg.append(leaveType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacationLeaveException(msg.toString());
	}

	/**
	 * Returns the first vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave fetchByEmpAndType_First(long empId, String leaveType,
		OrderByComparator orderByComparator) throws SystemException {
		List<VacationLeave> list = findByEmpAndType(empId, leaveType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave findByEmpAndType_Last(long empId, String leaveType,
		OrderByComparator orderByComparator)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = fetchByEmpAndType_Last(empId, leaveType,
				orderByComparator);

		if (vacationLeave != null) {
			return vacationLeave;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(", leaveType=");
		msg.append(leaveType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVacationLeaveException(msg.toString());
	}

	/**
	 * Returns the last vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching vacation leave, or <code>null</code> if a matching vacation leave could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave fetchByEmpAndType_Last(long empId, String leaveType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmpAndType(empId, leaveType);

		if (count == 0) {
			return null;
		}

		List<VacationLeave> list = findByEmpAndType(empId, leaveType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the vacation leaves before and after the current vacation leave in the ordered set where empId = &#63; and leaveType = &#63;.
	 *
	 * @param vacationLeaveId the primary key of the current vacation leave
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave[] findByEmpAndType_PrevAndNext(long vacationLeaveId,
		long empId, String leaveType, OrderByComparator orderByComparator)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = findByPrimaryKey(vacationLeaveId);

		Session session = null;

		try {
			session = openSession();

			VacationLeave[] array = new VacationLeaveImpl[3];

			array[0] = getByEmpAndType_PrevAndNext(session, vacationLeave,
					empId, leaveType, orderByComparator, true);

			array[1] = vacationLeave;

			array[2] = getByEmpAndType_PrevAndNext(session, vacationLeave,
					empId, leaveType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected VacationLeave getByEmpAndType_PrevAndNext(Session session,
		VacationLeave vacationLeave, long empId, String leaveType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VACATIONLEAVE_WHERE);

		query.append(_FINDER_COLUMN_EMPANDTYPE_EMPID_2);

		boolean bindLeaveType = false;

		if (leaveType == null) {
			query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_1);
		}
		else if (leaveType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_3);
		}
		else {
			bindLeaveType = true;

			query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_2);
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
			query.append(VacationLeaveModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (bindLeaveType) {
			qPos.add(leaveType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(vacationLeave);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<VacationLeave> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the vacation leaves where empId = &#63; and leaveType = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmpAndType(long empId, String leaveType)
		throws SystemException {
		for (VacationLeave vacationLeave : findByEmpAndType(empId, leaveType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(vacationLeave);
		}
	}

	/**
	 * Returns the number of vacation leaves where empId = &#63; and leaveType = &#63;.
	 *
	 * @param empId the emp ID
	 * @param leaveType the leave type
	 * @return the number of matching vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByEmpAndType(long empId, String leaveType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EMPANDTYPE;

		Object[] finderArgs = new Object[] { empId, leaveType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VACATIONLEAVE_WHERE);

			query.append(_FINDER_COLUMN_EMPANDTYPE_EMPID_2);

			boolean bindLeaveType = false;

			if (leaveType == null) {
				query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_1);
			}
			else if (leaveType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_3);
			}
			else {
				bindLeaveType = true;

				query.append(_FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (bindLeaveType) {
					qPos.add(leaveType);
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

	private static final String _FINDER_COLUMN_EMPANDTYPE_EMPID_2 = "vacationLeave.empId = ? AND ";
	private static final String _FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_1 = "vacationLeave.leaveType IS NULL";
	private static final String _FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_2 = "vacationLeave.leaveType = ?";
	private static final String _FINDER_COLUMN_EMPANDTYPE_LEAVETYPE_3 = "(vacationLeave.leaveType IS NULL OR vacationLeave.leaveType = '')";

	public VacationLeavePersistenceImpl() {
		setModelClass(VacationLeave.class);
	}

	/**
	 * Caches the vacation leave in the entity cache if it is enabled.
	 *
	 * @param vacationLeave the vacation leave
	 */
	@Override
	public void cacheResult(VacationLeave vacationLeave) {
		EntityCacheUtil.putResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveImpl.class, vacationLeave.getPrimaryKey(),
			vacationLeave);

		vacationLeave.resetOriginalValues();
	}

	/**
	 * Caches the vacation leaves in the entity cache if it is enabled.
	 *
	 * @param vacationLeaves the vacation leaves
	 */
	@Override
	public void cacheResult(List<VacationLeave> vacationLeaves) {
		for (VacationLeave vacationLeave : vacationLeaves) {
			if (EntityCacheUtil.getResult(
						VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
						VacationLeaveImpl.class, vacationLeave.getPrimaryKey()) == null) {
				cacheResult(vacationLeave);
			}
			else {
				vacationLeave.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vacation leaves.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(VacationLeaveImpl.class.getName());
		}

		EntityCacheUtil.clearCache(VacationLeaveImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vacation leave.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(VacationLeave vacationLeave) {
		EntityCacheUtil.removeResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveImpl.class, vacationLeave.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<VacationLeave> vacationLeaves) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (VacationLeave vacationLeave : vacationLeaves) {
			EntityCacheUtil.removeResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
				VacationLeaveImpl.class, vacationLeave.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vacation leave with the primary key. Does not add the vacation leave to the database.
	 *
	 * @param vacationLeaveId the primary key for the new vacation leave
	 * @return the new vacation leave
	 */
	@Override
	public VacationLeave create(long vacationLeaveId) {
		VacationLeave vacationLeave = new VacationLeaveImpl();

		vacationLeave.setNew(true);
		vacationLeave.setPrimaryKey(vacationLeaveId);

		return vacationLeave;
	}

	/**
	 * Removes the vacation leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacationLeaveId the primary key of the vacation leave
	 * @return the vacation leave that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave remove(long vacationLeaveId)
		throws NoSuchVacationLeaveException, SystemException {
		return remove((Serializable)vacationLeaveId);
	}

	/**
	 * Removes the vacation leave with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vacation leave
	 * @return the vacation leave that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave remove(Serializable primaryKey)
		throws NoSuchVacationLeaveException, SystemException {
		Session session = null;

		try {
			session = openSession();

			VacationLeave vacationLeave = (VacationLeave)session.get(VacationLeaveImpl.class,
					primaryKey);

			if (vacationLeave == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVacationLeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(vacationLeave);
		}
		catch (NoSuchVacationLeaveException nsee) {
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
	protected VacationLeave removeImpl(VacationLeave vacationLeave)
		throws SystemException {
		vacationLeave = toUnwrappedModel(vacationLeave);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vacationLeave)) {
				vacationLeave = (VacationLeave)session.get(VacationLeaveImpl.class,
						vacationLeave.getPrimaryKeyObj());
			}

			if (vacationLeave != null) {
				session.delete(vacationLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vacationLeave != null) {
			clearCache(vacationLeave);
		}

		return vacationLeave;
	}

	@Override
	public VacationLeave updateImpl(
		vn.com.ecopharma.emp.model.VacationLeave vacationLeave)
		throws SystemException {
		vacationLeave = toUnwrappedModel(vacationLeave);

		boolean isNew = vacationLeave.isNew();

		VacationLeaveModelImpl vacationLeaveModelImpl = (VacationLeaveModelImpl)vacationLeave;

		Session session = null;

		try {
			session = openSession();

			if (vacationLeave.isNew()) {
				session.save(vacationLeave);

				vacationLeave.setNew(false);
			}
			else {
				session.merge(vacationLeave);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !VacationLeaveModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((vacationLeaveModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacationLeaveModelImpl.getOriginalEmpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);

				args = new Object[] { vacationLeaveModelImpl.getEmpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);
			}

			if ((vacationLeaveModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPANDTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						vacationLeaveModelImpl.getOriginalEmpId(),
						vacationLeaveModelImpl.getOriginalLeaveType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPANDTYPE,
					args);

				args = new Object[] {
						vacationLeaveModelImpl.getEmpId(),
						vacationLeaveModelImpl.getLeaveType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMPANDTYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMPANDTYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
			VacationLeaveImpl.class, vacationLeave.getPrimaryKey(),
			vacationLeave);

		return vacationLeave;
	}

	protected VacationLeave toUnwrappedModel(VacationLeave vacationLeave) {
		if (vacationLeave instanceof VacationLeaveImpl) {
			return vacationLeave;
		}

		VacationLeaveImpl vacationLeaveImpl = new VacationLeaveImpl();

		vacationLeaveImpl.setNew(vacationLeave.isNew());
		vacationLeaveImpl.setPrimaryKey(vacationLeave.getPrimaryKey());

		vacationLeaveImpl.setVacationLeaveId(vacationLeave.getVacationLeaveId());
		vacationLeaveImpl.setEmpId(vacationLeave.getEmpId());
		vacationLeaveImpl.setLeaveType(vacationLeave.getLeaveType());
		vacationLeaveImpl.setLeaveFrom(vacationLeave.getLeaveFrom());
		vacationLeaveImpl.setLeaveTo(vacationLeave.getLeaveTo());
		vacationLeaveImpl.setActualTo(vacationLeave.getActualTo());
		vacationLeaveImpl.setNumberOfHours(vacationLeave.getNumberOfHours());
		vacationLeaveImpl.setReason(vacationLeave.getReason());
		vacationLeaveImpl.setDescription(vacationLeave.getDescription());
		vacationLeaveImpl.setGroupId(vacationLeave.getGroupId());
		vacationLeaveImpl.setCompanyId(vacationLeave.getCompanyId());
		vacationLeaveImpl.setUserId(vacationLeave.getUserId());
		vacationLeaveImpl.setUserName(vacationLeave.getUserName());
		vacationLeaveImpl.setCreateDate(vacationLeave.getCreateDate());
		vacationLeaveImpl.setModifiedDate(vacationLeave.getModifiedDate());
		vacationLeaveImpl.setDeleted(vacationLeave.isDeleted());
		vacationLeaveImpl.setStatus(vacationLeave.getStatus());

		return vacationLeaveImpl;
	}

	/**
	 * Returns the vacation leave with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacation leave
	 * @return the vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVacationLeaveException, SystemException {
		VacationLeave vacationLeave = fetchByPrimaryKey(primaryKey);

		if (vacationLeave == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVacationLeaveException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return vacationLeave;
	}

	/**
	 * Returns the vacation leave with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchVacationLeaveException} if it could not be found.
	 *
	 * @param vacationLeaveId the primary key of the vacation leave
	 * @return the vacation leave
	 * @throws vn.com.ecopharma.emp.NoSuchVacationLeaveException if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave findByPrimaryKey(long vacationLeaveId)
		throws NoSuchVacationLeaveException, SystemException {
		return findByPrimaryKey((Serializable)vacationLeaveId);
	}

	/**
	 * Returns the vacation leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacation leave
	 * @return the vacation leave, or <code>null</code> if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		VacationLeave vacationLeave = (VacationLeave)EntityCacheUtil.getResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
				VacationLeaveImpl.class, primaryKey);

		if (vacationLeave == _nullVacationLeave) {
			return null;
		}

		if (vacationLeave == null) {
			Session session = null;

			try {
				session = openSession();

				vacationLeave = (VacationLeave)session.get(VacationLeaveImpl.class,
						primaryKey);

				if (vacationLeave != null) {
					cacheResult(vacationLeave);
				}
				else {
					EntityCacheUtil.putResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
						VacationLeaveImpl.class, primaryKey, _nullVacationLeave);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(VacationLeaveModelImpl.ENTITY_CACHE_ENABLED,
					VacationLeaveImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return vacationLeave;
	}

	/**
	 * Returns the vacation leave with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param vacationLeaveId the primary key of the vacation leave
	 * @return the vacation leave, or <code>null</code> if a vacation leave with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public VacationLeave fetchByPrimaryKey(long vacationLeaveId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)vacationLeaveId);
	}

	/**
	 * Returns all the vacation leaves.
	 *
	 * @return the vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the vacation leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacation leaves
	 * @param end the upper bound of the range of vacation leaves (not inclusive)
	 * @return the range of vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the vacation leaves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.VacationLeaveModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacation leaves
	 * @param end the upper bound of the range of vacation leaves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vacation leaves
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<VacationLeave> findAll(int start, int end,
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

		List<VacationLeave> list = (List<VacationLeave>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_VACATIONLEAVE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VACATIONLEAVE;

				if (pagination) {
					sql = sql.concat(VacationLeaveModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<VacationLeave>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<VacationLeave>(list);
				}
				else {
					list = (List<VacationLeave>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the vacation leaves from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (VacationLeave vacationLeave : findAll()) {
			remove(vacationLeave);
		}
	}

	/**
	 * Returns the number of vacation leaves.
	 *
	 * @return the number of vacation leaves
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

				Query q = session.createQuery(_SQL_COUNT_VACATIONLEAVE);

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
	 * Initializes the vacation leave persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.VacationLeave")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<VacationLeave>> listenersList = new ArrayList<ModelListener<VacationLeave>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<VacationLeave>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(VacationLeaveImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_VACATIONLEAVE = "SELECT vacationLeave FROM VacationLeave vacationLeave";
	private static final String _SQL_SELECT_VACATIONLEAVE_WHERE = "SELECT vacationLeave FROM VacationLeave vacationLeave WHERE ";
	private static final String _SQL_COUNT_VACATIONLEAVE = "SELECT COUNT(vacationLeave) FROM VacationLeave vacationLeave";
	private static final String _SQL_COUNT_VACATIONLEAVE_WHERE = "SELECT COUNT(vacationLeave) FROM VacationLeave vacationLeave WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "vacationLeave.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No VacationLeave exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No VacationLeave exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(VacationLeavePersistenceImpl.class);
	private static VacationLeave _nullVacationLeave = new VacationLeaveImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<VacationLeave> toCacheModel() {
				return _nullVacationLeaveCacheModel;
			}
		};

	private static CacheModel<VacationLeave> _nullVacationLeaveCacheModel = new CacheModel<VacationLeave>() {
			@Override
			public VacationLeave toEntityModel() {
				return _nullVacationLeave;
			}
		};
}