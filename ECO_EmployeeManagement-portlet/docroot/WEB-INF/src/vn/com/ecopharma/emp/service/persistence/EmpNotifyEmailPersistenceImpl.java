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

import vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException;
import vn.com.ecopharma.emp.model.EmpNotifyEmail;
import vn.com.ecopharma.emp.model.impl.EmpNotifyEmailImpl;
import vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp notify email service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpNotifyEmailPersistence
 * @see EmpNotifyEmailUtil
 * @generated
 */
public class EmpNotifyEmailPersistenceImpl extends BasePersistenceImpl<EmpNotifyEmail>
	implements EmpNotifyEmailPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpNotifyEmailUtil} to access the emp notify email persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpNotifyEmailImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailModelImpl.FINDER_CACHE_ENABLED,
			EmpNotifyEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailModelImpl.FINDER_CACHE_ENABLED,
			EmpNotifyEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailModelImpl.FINDER_CACHE_ENABLED,
			EmpNotifyEmailImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByStatus",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailModelImpl.FINDER_CACHE_ENABLED,
			EmpNotifyEmailImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { String.class.getName() },
			EmpNotifyEmailModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { String.class.getName() });

	/**
	 * Returns all the emp notify emails where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpNotifyEmail> findByStatus(String status)
		throws SystemException {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp notify emails where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of emp notify emails
	 * @param end the upper bound of the range of emp notify emails (not inclusive)
	 * @return the range of matching emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpNotifyEmail> findByStatus(String status, int start, int end)
		throws SystemException {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp notify emails where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of emp notify emails
	 * @param end the upper bound of the range of emp notify emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpNotifyEmail> findByStatus(String status, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, start, end, orderByComparator };
		}

		List<EmpNotifyEmail> list = (List<EmpNotifyEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpNotifyEmail empNotifyEmail : list) {
				if (!Validator.equals(status, empNotifyEmail.getStatus())) {
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

			query.append(_SQL_SELECT_EMPNOTIFYEMAIL_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpNotifyEmailModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
				}

				if (!pagination) {
					list = (List<EmpNotifyEmail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpNotifyEmail>(list);
				}
				else {
					list = (List<EmpNotifyEmail>)QueryUtil.list(q,
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
	 * Returns the first emp notify email in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp notify email
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a matching emp notify email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail findByStatus_First(String status,
		OrderByComparator orderByComparator)
		throws NoSuchEmpNotifyEmailException, SystemException {
		EmpNotifyEmail empNotifyEmail = fetchByStatus_First(status,
				orderByComparator);

		if (empNotifyEmail != null) {
			return empNotifyEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpNotifyEmailException(msg.toString());
	}

	/**
	 * Returns the first emp notify email in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp notify email, or <code>null</code> if a matching emp notify email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail fetchByStatus_First(String status,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpNotifyEmail> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp notify email in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp notify email
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a matching emp notify email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail findByStatus_Last(String status,
		OrderByComparator orderByComparator)
		throws NoSuchEmpNotifyEmailException, SystemException {
		EmpNotifyEmail empNotifyEmail = fetchByStatus_Last(status,
				orderByComparator);

		if (empNotifyEmail != null) {
			return empNotifyEmail;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpNotifyEmailException(msg.toString());
	}

	/**
	 * Returns the last emp notify email in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp notify email, or <code>null</code> if a matching emp notify email could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail fetchByStatus_Last(String status,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<EmpNotifyEmail> list = findByStatus(status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp notify emails before and after the current emp notify email in the ordered set where status = &#63;.
	 *
	 * @param empNotifyEmailId the primary key of the current emp notify email
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp notify email
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail[] findByStatus_PrevAndNext(long empNotifyEmailId,
		String status, OrderByComparator orderByComparator)
		throws NoSuchEmpNotifyEmailException, SystemException {
		EmpNotifyEmail empNotifyEmail = findByPrimaryKey(empNotifyEmailId);

		Session session = null;

		try {
			session = openSession();

			EmpNotifyEmail[] array = new EmpNotifyEmailImpl[3];

			array[0] = getByStatus_PrevAndNext(session, empNotifyEmail, status,
					orderByComparator, true);

			array[1] = empNotifyEmail;

			array[2] = getByStatus_PrevAndNext(session, empNotifyEmail, status,
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

	protected EmpNotifyEmail getByStatus_PrevAndNext(Session session,
		EmpNotifyEmail empNotifyEmail, String status,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPNOTIFYEMAIL_WHERE);

		boolean bindStatus = false;

		if (status == null) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_1);
		}
		else if (status.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_STATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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
			query.append(EmpNotifyEmailModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindStatus) {
			qPos.add(status);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empNotifyEmail);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpNotifyEmail> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp notify emails where status = &#63; from the database.
	 *
	 * @param status the status
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByStatus(String status) throws SystemException {
		for (EmpNotifyEmail empNotifyEmail : findByStatus(status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empNotifyEmail);
		}
	}

	/**
	 * Returns the number of emp notify emails where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByStatus(String status) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EMPNOTIFYEMAIL_WHERE);

			boolean bindStatus = false;

			if (status == null) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_1);
			}
			else if (status.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_STATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				query.append(_FINDER_COLUMN_STATUS_STATUS_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindStatus) {
					qPos.add(status);
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

	private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "empNotifyEmail.status IS NULL";
	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "empNotifyEmail.status = ?";
	private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(empNotifyEmail.status IS NULL OR empNotifyEmail.status = '')";

	public EmpNotifyEmailPersistenceImpl() {
		setModelClass(EmpNotifyEmail.class);
	}

	/**
	 * Caches the emp notify email in the entity cache if it is enabled.
	 *
	 * @param empNotifyEmail the emp notify email
	 */
	@Override
	public void cacheResult(EmpNotifyEmail empNotifyEmail) {
		EntityCacheUtil.putResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailImpl.class, empNotifyEmail.getPrimaryKey(),
			empNotifyEmail);

		empNotifyEmail.resetOriginalValues();
	}

	/**
	 * Caches the emp notify emails in the entity cache if it is enabled.
	 *
	 * @param empNotifyEmails the emp notify emails
	 */
	@Override
	public void cacheResult(List<EmpNotifyEmail> empNotifyEmails) {
		for (EmpNotifyEmail empNotifyEmail : empNotifyEmails) {
			if (EntityCacheUtil.getResult(
						EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
						EmpNotifyEmailImpl.class, empNotifyEmail.getPrimaryKey()) == null) {
				cacheResult(empNotifyEmail);
			}
			else {
				empNotifyEmail.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp notify emails.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpNotifyEmailImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpNotifyEmailImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp notify email.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpNotifyEmail empNotifyEmail) {
		EntityCacheUtil.removeResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailImpl.class, empNotifyEmail.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpNotifyEmail> empNotifyEmails) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpNotifyEmail empNotifyEmail : empNotifyEmails) {
			EntityCacheUtil.removeResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
				EmpNotifyEmailImpl.class, empNotifyEmail.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp notify email with the primary key. Does not add the emp notify email to the database.
	 *
	 * @param empNotifyEmailId the primary key for the new emp notify email
	 * @return the new emp notify email
	 */
	@Override
	public EmpNotifyEmail create(long empNotifyEmailId) {
		EmpNotifyEmail empNotifyEmail = new EmpNotifyEmailImpl();

		empNotifyEmail.setNew(true);
		empNotifyEmail.setPrimaryKey(empNotifyEmailId);

		return empNotifyEmail;
	}

	/**
	 * Removes the emp notify email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empNotifyEmailId the primary key of the emp notify email
	 * @return the emp notify email that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail remove(long empNotifyEmailId)
		throws NoSuchEmpNotifyEmailException, SystemException {
		return remove((Serializable)empNotifyEmailId);
	}

	/**
	 * Removes the emp notify email with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp notify email
	 * @return the emp notify email that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail remove(Serializable primaryKey)
		throws NoSuchEmpNotifyEmailException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpNotifyEmail empNotifyEmail = (EmpNotifyEmail)session.get(EmpNotifyEmailImpl.class,
					primaryKey);

			if (empNotifyEmail == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpNotifyEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empNotifyEmail);
		}
		catch (NoSuchEmpNotifyEmailException nsee) {
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
	protected EmpNotifyEmail removeImpl(EmpNotifyEmail empNotifyEmail)
		throws SystemException {
		empNotifyEmail = toUnwrappedModel(empNotifyEmail);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empNotifyEmail)) {
				empNotifyEmail = (EmpNotifyEmail)session.get(EmpNotifyEmailImpl.class,
						empNotifyEmail.getPrimaryKeyObj());
			}

			if (empNotifyEmail != null) {
				session.delete(empNotifyEmail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empNotifyEmail != null) {
			clearCache(empNotifyEmail);
		}

		return empNotifyEmail;
	}

	@Override
	public EmpNotifyEmail updateImpl(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail)
		throws SystemException {
		empNotifyEmail = toUnwrappedModel(empNotifyEmail);

		boolean isNew = empNotifyEmail.isNew();

		EmpNotifyEmailModelImpl empNotifyEmailModelImpl = (EmpNotifyEmailModelImpl)empNotifyEmail;

		Session session = null;

		try {
			session = openSession();

			if (empNotifyEmail.isNew()) {
				session.save(empNotifyEmail);

				empNotifyEmail.setNew(false);
			}
			else {
				session.merge(empNotifyEmail);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpNotifyEmailModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empNotifyEmailModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empNotifyEmailModelImpl.getOriginalStatus()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] { empNotifyEmailModelImpl.getStatus() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
			EmpNotifyEmailImpl.class, empNotifyEmail.getPrimaryKey(),
			empNotifyEmail);

		return empNotifyEmail;
	}

	protected EmpNotifyEmail toUnwrappedModel(EmpNotifyEmail empNotifyEmail) {
		if (empNotifyEmail instanceof EmpNotifyEmailImpl) {
			return empNotifyEmail;
		}

		EmpNotifyEmailImpl empNotifyEmailImpl = new EmpNotifyEmailImpl();

		empNotifyEmailImpl.setNew(empNotifyEmail.isNew());
		empNotifyEmailImpl.setPrimaryKey(empNotifyEmail.getPrimaryKey());

		empNotifyEmailImpl.setEmpNotifyEmailId(empNotifyEmail.getEmpNotifyEmailId());
		empNotifyEmailImpl.setEmpId(empNotifyEmail.getEmpId());
		empNotifyEmailImpl.setNotifyType(empNotifyEmail.getNotifyType());
		empNotifyEmailImpl.setStatus(empNotifyEmail.getStatus());

		return empNotifyEmailImpl;
	}

	/**
	 * Returns the emp notify email with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp notify email
	 * @return the emp notify email
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpNotifyEmailException, SystemException {
		EmpNotifyEmail empNotifyEmail = fetchByPrimaryKey(primaryKey);

		if (empNotifyEmail == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpNotifyEmailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empNotifyEmail;
	}

	/**
	 * Returns the emp notify email with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException} if it could not be found.
	 *
	 * @param empNotifyEmailId the primary key of the emp notify email
	 * @return the emp notify email
	 * @throws vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail findByPrimaryKey(long empNotifyEmailId)
		throws NoSuchEmpNotifyEmailException, SystemException {
		return findByPrimaryKey((Serializable)empNotifyEmailId);
	}

	/**
	 * Returns the emp notify email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp notify email
	 * @return the emp notify email, or <code>null</code> if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpNotifyEmail empNotifyEmail = (EmpNotifyEmail)EntityCacheUtil.getResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
				EmpNotifyEmailImpl.class, primaryKey);

		if (empNotifyEmail == _nullEmpNotifyEmail) {
			return null;
		}

		if (empNotifyEmail == null) {
			Session session = null;

			try {
				session = openSession();

				empNotifyEmail = (EmpNotifyEmail)session.get(EmpNotifyEmailImpl.class,
						primaryKey);

				if (empNotifyEmail != null) {
					cacheResult(empNotifyEmail);
				}
				else {
					EntityCacheUtil.putResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
						EmpNotifyEmailImpl.class, primaryKey,
						_nullEmpNotifyEmail);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpNotifyEmailModelImpl.ENTITY_CACHE_ENABLED,
					EmpNotifyEmailImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empNotifyEmail;
	}

	/**
	 * Returns the emp notify email with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empNotifyEmailId the primary key of the emp notify email
	 * @return the emp notify email, or <code>null</code> if a emp notify email with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpNotifyEmail fetchByPrimaryKey(long empNotifyEmailId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empNotifyEmailId);
	}

	/**
	 * Returns all the emp notify emails.
	 *
	 * @return the emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpNotifyEmail> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp notify emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp notify emails
	 * @param end the upper bound of the range of emp notify emails (not inclusive)
	 * @return the range of emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpNotifyEmail> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp notify emails.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpNotifyEmailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp notify emails
	 * @param end the upper bound of the range of emp notify emails (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp notify emails
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpNotifyEmail> findAll(int start, int end,
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

		List<EmpNotifyEmail> list = (List<EmpNotifyEmail>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPNOTIFYEMAIL);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPNOTIFYEMAIL;

				if (pagination) {
					sql = sql.concat(EmpNotifyEmailModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpNotifyEmail>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpNotifyEmail>(list);
				}
				else {
					list = (List<EmpNotifyEmail>)QueryUtil.list(q,
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
	 * Removes all the emp notify emails from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpNotifyEmail empNotifyEmail : findAll()) {
			remove(empNotifyEmail);
		}
	}

	/**
	 * Returns the number of emp notify emails.
	 *
	 * @return the number of emp notify emails
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

				Query q = session.createQuery(_SQL_COUNT_EMPNOTIFYEMAIL);

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
	 * Initializes the emp notify email persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpNotifyEmail")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpNotifyEmail>> listenersList = new ArrayList<ModelListener<EmpNotifyEmail>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpNotifyEmail>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpNotifyEmailImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPNOTIFYEMAIL = "SELECT empNotifyEmail FROM EmpNotifyEmail empNotifyEmail";
	private static final String _SQL_SELECT_EMPNOTIFYEMAIL_WHERE = "SELECT empNotifyEmail FROM EmpNotifyEmail empNotifyEmail WHERE ";
	private static final String _SQL_COUNT_EMPNOTIFYEMAIL = "SELECT COUNT(empNotifyEmail) FROM EmpNotifyEmail empNotifyEmail";
	private static final String _SQL_COUNT_EMPNOTIFYEMAIL_WHERE = "SELECT COUNT(empNotifyEmail) FROM EmpNotifyEmail empNotifyEmail WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empNotifyEmail.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpNotifyEmail exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpNotifyEmail exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpNotifyEmailPersistenceImpl.class);
	private static EmpNotifyEmail _nullEmpNotifyEmail = new EmpNotifyEmailImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpNotifyEmail> toCacheModel() {
				return _nullEmpNotifyEmailCacheModel;
			}
		};

	private static CacheModel<EmpNotifyEmail> _nullEmpNotifyEmailCacheModel = new CacheModel<EmpNotifyEmail>() {
			@Override
			public EmpNotifyEmail toEntityModel() {
				return _nullEmpNotifyEmail;
			}
		};
}