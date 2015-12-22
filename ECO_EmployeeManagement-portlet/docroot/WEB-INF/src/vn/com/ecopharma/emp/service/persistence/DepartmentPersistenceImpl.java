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

import vn.com.ecopharma.emp.NoSuchDepartmentException;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.impl.DepartmentImpl;
import vn.com.ecopharma.emp.model.impl.DepartmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the department service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DepartmentPersistence
 * @see DepartmentUtil
 * @generated
 */
public class DepartmentPersistenceImpl extends BasePersistenceImpl<Department>
	implements DepartmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DepartmentUtil} to access the department persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DepartmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_NAMEANDDEVISION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByNameAndDevision",
			new String[] { String.class.getName(), Long.class.getName() },
			DepartmentModelImpl.NAME_COLUMN_BITMASK |
			DepartmentModelImpl.DEVISIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAMEANDDEVISION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByNameAndDevision",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the department where name = &#63; and devisionId = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDepartmentException} if it could not be found.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the matching department
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByNameAndDevision(String name, long devisionId)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByNameAndDevision(name, devisionId);

		if (department == null) {
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

			throw new NoSuchDepartmentException(msg.toString());
		}

		return department;
	}

	/**
	 * Returns the department where name = &#63; and devisionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the matching department, or <code>null</code> if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByNameAndDevision(String name, long devisionId)
		throws SystemException {
		return fetchByNameAndDevision(name, devisionId, true);
	}

	/**
	 * Returns the department where name = &#63; and devisionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching department, or <code>null</code> if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByNameAndDevision(String name, long devisionId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { name, devisionId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
					finderArgs, this);
		}

		if (result instanceof Department) {
			Department department = (Department)result;

			if (!Validator.equals(name, department.getName()) ||
					(devisionId != department.getDevisionId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DEPARTMENT_WHERE);

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

				List<Department> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DepartmentPersistenceImpl.fetchByNameAndDevision(String, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Department department = list.get(0);

					result = department;

					cacheResult(department);

					if ((department.getName() == null) ||
							!department.getName().equals(name) ||
							(department.getDevisionId() != devisionId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
							finderArgs, department);
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
			return (Department)result;
		}
	}

	/**
	 * Removes the department where name = &#63; and devisionId = &#63; from the database.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the department that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department removeByNameAndDevision(String name, long devisionId)
		throws NoSuchDepartmentException, SystemException {
		Department department = findByNameAndDevision(name, devisionId);

		return remove(department);
	}

	/**
	 * Returns the number of departments where name = &#63; and devisionId = &#63;.
	 *
	 * @param name the name
	 * @param devisionId the devision ID
	 * @return the number of matching departments
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

			query.append(_SQL_COUNT_DEPARTMENT_WHERE);

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

	private static final String _FINDER_COLUMN_NAMEANDDEVISION_NAME_1 = "department.name IS NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEVISION_NAME_2 = "department.name = ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEVISION_NAME_3 = "(department.name IS NULL OR department.name = '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDDEVISION_DEVISIONID_2 = "department.devisionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DEVISION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDevision",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION =
		new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, DepartmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDevision",
			new String[] { Long.class.getName() },
			DepartmentModelImpl.DEVISIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DEVISION = new FinderPath(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDevision",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the departments where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @return the matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findByDevision(long devisionId)
		throws SystemException {
		return findByDevision(devisionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the departments where devisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param devisionId the devision ID
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @return the range of matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findByDevision(long devisionId, int start, int end)
		throws SystemException {
		return findByDevision(devisionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the departments where devisionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param devisionId the devision ID
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findByDevision(long devisionId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
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

		List<Department> list = (List<Department>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Department department : list) {
				if ((devisionId != department.getDevisionId())) {
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

			query.append(_SQL_SELECT_DEPARTMENT_WHERE);

			query.append(_FINDER_COLUMN_DEVISION_DEVISIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DepartmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(devisionId);

				if (!pagination) {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Department>(list);
				}
				else {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first department in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByDevision_First(long devisionId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByDevision_First(devisionId,
				orderByComparator);

		if (department != null) {
			return department;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("devisionId=");
		msg.append(devisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartmentException(msg.toString());
	}

	/**
	 * Returns the first department in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching department, or <code>null</code> if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByDevision_First(long devisionId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Department> list = findByDevision(devisionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last department in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByDevision_Last(long devisionId,
		OrderByComparator orderByComparator)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByDevision_Last(devisionId,
				orderByComparator);

		if (department != null) {
			return department;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("devisionId=");
		msg.append(devisionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDepartmentException(msg.toString());
	}

	/**
	 * Returns the last department in the ordered set where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching department, or <code>null</code> if a matching department could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByDevision_Last(long devisionId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDevision(devisionId);

		if (count == 0) {
			return null;
		}

		List<Department> list = findByDevision(devisionId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the departments before and after the current department in the ordered set where devisionId = &#63;.
	 *
	 * @param departmentId the primary key of the current department
	 * @param devisionId the devision ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next department
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department[] findByDevision_PrevAndNext(long departmentId,
		long devisionId, OrderByComparator orderByComparator)
		throws NoSuchDepartmentException, SystemException {
		Department department = findByPrimaryKey(departmentId);

		Session session = null;

		try {
			session = openSession();

			Department[] array = new DepartmentImpl[3];

			array[0] = getByDevision_PrevAndNext(session, department,
					devisionId, orderByComparator, true);

			array[1] = department;

			array[2] = getByDevision_PrevAndNext(session, department,
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

	protected Department getByDevision_PrevAndNext(Session session,
		Department department, long devisionId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DEPARTMENT_WHERE);

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
			query.append(DepartmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(devisionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(department);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Department> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the departments where devisionId = &#63; from the database.
	 *
	 * @param devisionId the devision ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDevision(long devisionId) throws SystemException {
		for (Department department : findByDevision(devisionId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(department);
		}
	}

	/**
	 * Returns the number of departments where devisionId = &#63;.
	 *
	 * @param devisionId the devision ID
	 * @return the number of matching departments
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

			query.append(_SQL_COUNT_DEPARTMENT_WHERE);

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

	private static final String _FINDER_COLUMN_DEVISION_DEVISIONID_2 = "department.devisionId = ?";

	public DepartmentPersistenceImpl() {
		setModelClass(Department.class);
	}

	/**
	 * Caches the department in the entity cache if it is enabled.
	 *
	 * @param department the department
	 */
	@Override
	public void cacheResult(Department department) {
		EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey(), department);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
			new Object[] { department.getName(), department.getDevisionId() },
			department);

		department.resetOriginalValues();
	}

	/**
	 * Caches the departments in the entity cache if it is enabled.
	 *
	 * @param departments the departments
	 */
	@Override
	public void cacheResult(List<Department> departments) {
		for (Department department : departments) {
			if (EntityCacheUtil.getResult(
						DepartmentModelImpl.ENTITY_CACHE_ENABLED,
						DepartmentImpl.class, department.getPrimaryKey()) == null) {
				cacheResult(department);
			}
			else {
				department.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all departments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DepartmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DepartmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the department.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Department department) {
		EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(department);
	}

	@Override
	public void clearCache(List<Department> departments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Department department : departments) {
			EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
				DepartmentImpl.class, department.getPrimaryKey());

			clearUniqueFindersCache(department);
		}
	}

	protected void cacheUniqueFindersCache(Department department) {
		if (department.isNew()) {
			Object[] args = new Object[] {
					department.getName(), department.getDevisionId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
				args, department);
		}
		else {
			DepartmentModelImpl departmentModelImpl = (DepartmentModelImpl)department;

			if ((departmentModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAMEANDDEVISION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						department.getName(), department.getDevisionId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
					args, department);
			}
		}
	}

	protected void clearUniqueFindersCache(Department department) {
		DepartmentModelImpl departmentModelImpl = (DepartmentModelImpl)department;

		Object[] args = new Object[] {
				department.getName(), department.getDevisionId()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION, args);

		if ((departmentModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAMEANDDEVISION.getColumnBitmask()) != 0) {
			args = new Object[] {
					departmentModelImpl.getOriginalName(),
					departmentModelImpl.getOriginalDevisionId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAMEANDDEVISION,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAMEANDDEVISION,
				args);
		}
	}

	/**
	 * Creates a new department with the primary key. Does not add the department to the database.
	 *
	 * @param departmentId the primary key for the new department
	 * @return the new department
	 */
	@Override
	public Department create(long departmentId) {
		Department department = new DepartmentImpl();

		department.setNew(true);
		department.setPrimaryKey(departmentId);

		return department;
	}

	/**
	 * Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param departmentId the primary key of the department
	 * @return the department that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department remove(long departmentId)
		throws NoSuchDepartmentException, SystemException {
		return remove((Serializable)departmentId);
	}

	/**
	 * Removes the department with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department remove(Serializable primaryKey)
		throws NoSuchDepartmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Department department = (Department)session.get(DepartmentImpl.class,
					primaryKey);

			if (department == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(department);
		}
		catch (NoSuchDepartmentException nsee) {
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
	protected Department removeImpl(Department department)
		throws SystemException {
		department = toUnwrappedModel(department);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(department)) {
				department = (Department)session.get(DepartmentImpl.class,
						department.getPrimaryKeyObj());
			}

			if (department != null) {
				session.delete(department);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (department != null) {
			clearCache(department);
		}

		return department;
	}

	@Override
	public Department updateImpl(
		vn.com.ecopharma.emp.model.Department department)
		throws SystemException {
		department = toUnwrappedModel(department);

		boolean isNew = department.isNew();

		DepartmentModelImpl departmentModelImpl = (DepartmentModelImpl)department;

		Session session = null;

		try {
			session = openSession();

			if (department.isNew()) {
				session.save(department);

				department.setNew(false);
			}
			else {
				session.merge(department);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DepartmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((departmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						departmentModelImpl.getOriginalDevisionId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVISION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION,
					args);

				args = new Object[] { departmentModelImpl.getDevisionId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DEVISION, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DEVISION,
					args);
			}
		}

		EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
			DepartmentImpl.class, department.getPrimaryKey(), department);

		clearUniqueFindersCache(department);
		cacheUniqueFindersCache(department);

		return department;
	}

	protected Department toUnwrappedModel(Department department) {
		if (department instanceof DepartmentImpl) {
			return department;
		}

		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setNew(department.isNew());
		departmentImpl.setPrimaryKey(department.getPrimaryKey());

		departmentImpl.setDepartmentId(department.getDepartmentId());
		departmentImpl.setName(department.getName());
		departmentImpl.setDevisionId(department.getDevisionId());
		departmentImpl.setGroupId(department.getGroupId());
		departmentImpl.setCompanyId(department.getCompanyId());
		departmentImpl.setUserId(department.getUserId());
		departmentImpl.setUserName(department.getUserName());
		departmentImpl.setCreateDate(department.getCreateDate());
		departmentImpl.setModifiedDate(department.getModifiedDate());

		return departmentImpl;
	}

	/**
	 * Returns the department with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDepartmentException, SystemException {
		Department department = fetchByPrimaryKey(primaryKey);

		if (department == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDepartmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return department;
	}

	/**
	 * Returns the department with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDepartmentException} if it could not be found.
	 *
	 * @param departmentId the primary key of the department
	 * @return the department
	 * @throws vn.com.ecopharma.emp.NoSuchDepartmentException if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department findByPrimaryKey(long departmentId)
		throws NoSuchDepartmentException, SystemException {
		return findByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns the department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the department
	 * @return the department, or <code>null</code> if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Department department = (Department)EntityCacheUtil.getResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
				DepartmentImpl.class, primaryKey);

		if (department == _nullDepartment) {
			return null;
		}

		if (department == null) {
			Session session = null;

			try {
				session = openSession();

				department = (Department)session.get(DepartmentImpl.class,
						primaryKey);

				if (department != null) {
					cacheResult(department);
				}
				else {
					EntityCacheUtil.putResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
						DepartmentImpl.class, primaryKey, _nullDepartment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DepartmentModelImpl.ENTITY_CACHE_ENABLED,
					DepartmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return department;
	}

	/**
	 * Returns the department with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param departmentId the primary key of the department
	 * @return the department, or <code>null</code> if a department with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Department fetchByPrimaryKey(long departmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)departmentId);
	}

	/**
	 * Returns all the departments.
	 *
	 * @return the departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @return the range of departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the departments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DepartmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of departments
	 * @param end the upper bound of the range of departments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of departments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Department> findAll(int start, int end,
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

		List<Department> list = (List<Department>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DEPARTMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DEPARTMENT;

				if (pagination) {
					sql = sql.concat(DepartmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Department>(list);
				}
				else {
					list = (List<Department>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the departments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Department department : findAll()) {
			remove(department);
		}
	}

	/**
	 * Returns the number of departments.
	 *
	 * @return the number of departments
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

				Query q = session.createQuery(_SQL_COUNT_DEPARTMENT);

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
	 * Initializes the department persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Department")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Department>> listenersList = new ArrayList<ModelListener<Department>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Department>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DepartmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DEPARTMENT = "SELECT department FROM Department department";
	private static final String _SQL_SELECT_DEPARTMENT_WHERE = "SELECT department FROM Department department WHERE ";
	private static final String _SQL_COUNT_DEPARTMENT = "SELECT COUNT(department) FROM Department department";
	private static final String _SQL_COUNT_DEPARTMENT_WHERE = "SELECT COUNT(department) FROM Department department WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "department.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Department exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Department exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DepartmentPersistenceImpl.class);
	private static Department _nullDepartment = new DepartmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Department> toCacheModel() {
				return _nullDepartmentCacheModel;
			}
		};

	private static CacheModel<Department> _nullDepartmentCacheModel = new CacheModel<Department>() {
			@Override
			public Department toEntityModel() {
				return _nullDepartment;
			}
		};
}