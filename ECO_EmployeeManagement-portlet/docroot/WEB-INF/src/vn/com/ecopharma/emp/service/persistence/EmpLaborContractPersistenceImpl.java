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

import vn.com.ecopharma.emp.NoSuchEmpLaborContractException;
import vn.com.ecopharma.emp.model.EmpLaborContract;
import vn.com.ecopharma.emp.model.impl.EmpLaborContractImpl;
import vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the emp labor contract service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see EmpLaborContractPersistence
 * @see EmpLaborContractUtil
 * @generated
 */
public class EmpLaborContractPersistenceImpl extends BasePersistenceImpl<EmpLaborContract>
	implements EmpLaborContractPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EmpLaborContractUtil} to access the emp labor contract persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EmpLaborContractImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractModelImpl.FINDER_CACHE_ENABLED,
			EmpLaborContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractModelImpl.FINDER_CACHE_ENABLED,
			EmpLaborContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMP = new FinderPath(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractModelImpl.FINDER_CACHE_ENABLED,
			EmpLaborContractImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByEmp",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP = new FinderPath(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractModelImpl.FINDER_CACHE_ENABLED,
			EmpLaborContractImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmp",
			new String[] { Long.class.getName() },
			EmpLaborContractModelImpl.EMPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EMP = new FinderPath(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmp",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the emp labor contracts where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the matching emp labor contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLaborContract> findByEmp(long empId)
		throws SystemException {
		return findByEmp(empId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp labor contracts where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of emp labor contracts
	 * @param end the upper bound of the range of emp labor contracts (not inclusive)
	 * @return the range of matching emp labor contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLaborContract> findByEmp(long empId, int start, int end)
		throws SystemException {
		return findByEmp(empId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp labor contracts where empId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param empId the emp ID
	 * @param start the lower bound of the range of emp labor contracts
	 * @param end the upper bound of the range of emp labor contracts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching emp labor contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLaborContract> findByEmp(long empId, int start, int end,
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

		List<EmpLaborContract> list = (List<EmpLaborContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (EmpLaborContract empLaborContract : list) {
				if ((empId != empLaborContract.getEmpId())) {
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

			query.append(_SQL_SELECT_EMPLABORCONTRACT_WHERE);

			query.append(_FINDER_COLUMN_EMP_EMPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EmpLaborContractModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(empId);

				if (!pagination) {
					list = (List<EmpLaborContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLaborContract>(list);
				}
				else {
					list = (List<EmpLaborContract>)QueryUtil.list(q,
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
	 * Returns the first emp labor contract in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp labor contract
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a matching emp labor contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract findByEmp_First(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLaborContractException, SystemException {
		EmpLaborContract empLaborContract = fetchByEmp_First(empId,
				orderByComparator);

		if (empLaborContract != null) {
			return empLaborContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLaborContractException(msg.toString());
	}

	/**
	 * Returns the first emp labor contract in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching emp labor contract, or <code>null</code> if a matching emp labor contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract fetchByEmp_First(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		List<EmpLaborContract> list = findByEmp(empId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last emp labor contract in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp labor contract
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a matching emp labor contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract findByEmp_Last(long empId,
		OrderByComparator orderByComparator)
		throws NoSuchEmpLaborContractException, SystemException {
		EmpLaborContract empLaborContract = fetchByEmp_Last(empId,
				orderByComparator);

		if (empLaborContract != null) {
			return empLaborContract;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("empId=");
		msg.append(empId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEmpLaborContractException(msg.toString());
	}

	/**
	 * Returns the last emp labor contract in the ordered set where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching emp labor contract, or <code>null</code> if a matching emp labor contract could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract fetchByEmp_Last(long empId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByEmp(empId);

		if (count == 0) {
			return null;
		}

		List<EmpLaborContract> list = findByEmp(empId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the emp labor contracts before and after the current emp labor contract in the ordered set where empId = &#63;.
	 *
	 * @param empLaborContractId the primary key of the current emp labor contract
	 * @param empId the emp ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next emp labor contract
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract[] findByEmp_PrevAndNext(long empLaborContractId,
		long empId, OrderByComparator orderByComparator)
		throws NoSuchEmpLaborContractException, SystemException {
		EmpLaborContract empLaborContract = findByPrimaryKey(empLaborContractId);

		Session session = null;

		try {
			session = openSession();

			EmpLaborContract[] array = new EmpLaborContractImpl[3];

			array[0] = getByEmp_PrevAndNext(session, empLaborContract, empId,
					orderByComparator, true);

			array[1] = empLaborContract;

			array[2] = getByEmp_PrevAndNext(session, empLaborContract, empId,
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

	protected EmpLaborContract getByEmp_PrevAndNext(Session session,
		EmpLaborContract empLaborContract, long empId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EMPLABORCONTRACT_WHERE);

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
			query.append(EmpLaborContractModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(empId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(empLaborContract);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<EmpLaborContract> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the emp labor contracts where empId = &#63; from the database.
	 *
	 * @param empId the emp ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByEmp(long empId) throws SystemException {
		for (EmpLaborContract empLaborContract : findByEmp(empId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(empLaborContract);
		}
	}

	/**
	 * Returns the number of emp labor contracts where empId = &#63;.
	 *
	 * @param empId the emp ID
	 * @return the number of matching emp labor contracts
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

			query.append(_SQL_COUNT_EMPLABORCONTRACT_WHERE);

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

	private static final String _FINDER_COLUMN_EMP_EMPID_2 = "empLaborContract.empId = ?";

	public EmpLaborContractPersistenceImpl() {
		setModelClass(EmpLaborContract.class);
	}

	/**
	 * Caches the emp labor contract in the entity cache if it is enabled.
	 *
	 * @param empLaborContract the emp labor contract
	 */
	@Override
	public void cacheResult(EmpLaborContract empLaborContract) {
		EntityCacheUtil.putResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractImpl.class, empLaborContract.getPrimaryKey(),
			empLaborContract);

		empLaborContract.resetOriginalValues();
	}

	/**
	 * Caches the emp labor contracts in the entity cache if it is enabled.
	 *
	 * @param empLaborContracts the emp labor contracts
	 */
	@Override
	public void cacheResult(List<EmpLaborContract> empLaborContracts) {
		for (EmpLaborContract empLaborContract : empLaborContracts) {
			if (EntityCacheUtil.getResult(
						EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
						EmpLaborContractImpl.class,
						empLaborContract.getPrimaryKey()) == null) {
				cacheResult(empLaborContract);
			}
			else {
				empLaborContract.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all emp labor contracts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(EmpLaborContractImpl.class.getName());
		}

		EntityCacheUtil.clearCache(EmpLaborContractImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the emp labor contract.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(EmpLaborContract empLaborContract) {
		EntityCacheUtil.removeResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractImpl.class, empLaborContract.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<EmpLaborContract> empLaborContracts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (EmpLaborContract empLaborContract : empLaborContracts) {
			EntityCacheUtil.removeResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
				EmpLaborContractImpl.class, empLaborContract.getPrimaryKey());
		}
	}

	/**
	 * Creates a new emp labor contract with the primary key. Does not add the emp labor contract to the database.
	 *
	 * @param empLaborContractId the primary key for the new emp labor contract
	 * @return the new emp labor contract
	 */
	@Override
	public EmpLaborContract create(long empLaborContractId) {
		EmpLaborContract empLaborContract = new EmpLaborContractImpl();

		empLaborContract.setNew(true);
		empLaborContract.setPrimaryKey(empLaborContractId);

		return empLaborContract;
	}

	/**
	 * Removes the emp labor contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param empLaborContractId the primary key of the emp labor contract
	 * @return the emp labor contract that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract remove(long empLaborContractId)
		throws NoSuchEmpLaborContractException, SystemException {
		return remove((Serializable)empLaborContractId);
	}

	/**
	 * Removes the emp labor contract with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the emp labor contract
	 * @return the emp labor contract that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract remove(Serializable primaryKey)
		throws NoSuchEmpLaborContractException, SystemException {
		Session session = null;

		try {
			session = openSession();

			EmpLaborContract empLaborContract = (EmpLaborContract)session.get(EmpLaborContractImpl.class,
					primaryKey);

			if (empLaborContract == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEmpLaborContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(empLaborContract);
		}
		catch (NoSuchEmpLaborContractException nsee) {
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
	protected EmpLaborContract removeImpl(EmpLaborContract empLaborContract)
		throws SystemException {
		empLaborContract = toUnwrappedModel(empLaborContract);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(empLaborContract)) {
				empLaborContract = (EmpLaborContract)session.get(EmpLaborContractImpl.class,
						empLaborContract.getPrimaryKeyObj());
			}

			if (empLaborContract != null) {
				session.delete(empLaborContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (empLaborContract != null) {
			clearCache(empLaborContract);
		}

		return empLaborContract;
	}

	@Override
	public EmpLaborContract updateImpl(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract)
		throws SystemException {
		empLaborContract = toUnwrappedModel(empLaborContract);

		boolean isNew = empLaborContract.isNew();

		EmpLaborContractModelImpl empLaborContractModelImpl = (EmpLaborContractModelImpl)empLaborContract;

		Session session = null;

		try {
			session = openSession();

			if (empLaborContract.isNew()) {
				session.save(empLaborContract);

				empLaborContract.setNew(false);
			}
			else {
				session.merge(empLaborContract);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EmpLaborContractModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((empLaborContractModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						empLaborContractModelImpl.getOriginalEmpId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);

				args = new Object[] { empLaborContractModelImpl.getEmpId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMP, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMP,
					args);
			}
		}

		EntityCacheUtil.putResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
			EmpLaborContractImpl.class, empLaborContract.getPrimaryKey(),
			empLaborContract);

		return empLaborContract;
	}

	protected EmpLaborContract toUnwrappedModel(
		EmpLaborContract empLaborContract) {
		if (empLaborContract instanceof EmpLaborContractImpl) {
			return empLaborContract;
		}

		EmpLaborContractImpl empLaborContractImpl = new EmpLaborContractImpl();

		empLaborContractImpl.setNew(empLaborContract.isNew());
		empLaborContractImpl.setPrimaryKey(empLaborContract.getPrimaryKey());

		empLaborContractImpl.setEmpLaborContractId(empLaborContract.getEmpLaborContractId());
		empLaborContractImpl.setEmpId(empLaborContract.getEmpId());
		empLaborContractImpl.setLaborContractSignedDate(empLaborContract.getLaborContractSignedDate());
		empLaborContractImpl.setLaborContractExpiredDate(empLaborContract.getLaborContractExpiredDate());
		empLaborContractImpl.setLaborContractSignedType(empLaborContract.getLaborContractSignedType());
		empLaborContractImpl.setSignedTimes(empLaborContract.getSignedTimes());
		empLaborContractImpl.setLatest(empLaborContract.isLatest());
		empLaborContractImpl.setGroupId(empLaborContract.getGroupId());
		empLaborContractImpl.setCompanyId(empLaborContract.getCompanyId());
		empLaborContractImpl.setUserId(empLaborContract.getUserId());
		empLaborContractImpl.setUserName(empLaborContract.getUserName());
		empLaborContractImpl.setCreateDate(empLaborContract.getCreateDate());
		empLaborContractImpl.setModifiedDate(empLaborContract.getModifiedDate());

		return empLaborContractImpl;
	}

	/**
	 * Returns the emp labor contract with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp labor contract
	 * @return the emp labor contract
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEmpLaborContractException, SystemException {
		EmpLaborContract empLaborContract = fetchByPrimaryKey(primaryKey);

		if (empLaborContract == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEmpLaborContractException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return empLaborContract;
	}

	/**
	 * Returns the emp labor contract with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchEmpLaborContractException} if it could not be found.
	 *
	 * @param empLaborContractId the primary key of the emp labor contract
	 * @return the emp labor contract
	 * @throws vn.com.ecopharma.emp.NoSuchEmpLaborContractException if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract findByPrimaryKey(long empLaborContractId)
		throws NoSuchEmpLaborContractException, SystemException {
		return findByPrimaryKey((Serializable)empLaborContractId);
	}

	/**
	 * Returns the emp labor contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the emp labor contract
	 * @return the emp labor contract, or <code>null</code> if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		EmpLaborContract empLaborContract = (EmpLaborContract)EntityCacheUtil.getResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
				EmpLaborContractImpl.class, primaryKey);

		if (empLaborContract == _nullEmpLaborContract) {
			return null;
		}

		if (empLaborContract == null) {
			Session session = null;

			try {
				session = openSession();

				empLaborContract = (EmpLaborContract)session.get(EmpLaborContractImpl.class,
						primaryKey);

				if (empLaborContract != null) {
					cacheResult(empLaborContract);
				}
				else {
					EntityCacheUtil.putResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
						EmpLaborContractImpl.class, primaryKey,
						_nullEmpLaborContract);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(EmpLaborContractModelImpl.ENTITY_CACHE_ENABLED,
					EmpLaborContractImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return empLaborContract;
	}

	/**
	 * Returns the emp labor contract with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param empLaborContractId the primary key of the emp labor contract
	 * @return the emp labor contract, or <code>null</code> if a emp labor contract with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public EmpLaborContract fetchByPrimaryKey(long empLaborContractId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)empLaborContractId);
	}

	/**
	 * Returns all the emp labor contracts.
	 *
	 * @return the emp labor contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLaborContract> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the emp labor contracts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp labor contracts
	 * @param end the upper bound of the range of emp labor contracts (not inclusive)
	 * @return the range of emp labor contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLaborContract> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the emp labor contracts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.EmpLaborContractModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of emp labor contracts
	 * @param end the upper bound of the range of emp labor contracts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of emp labor contracts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<EmpLaborContract> findAll(int start, int end,
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

		List<EmpLaborContract> list = (List<EmpLaborContract>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EMPLABORCONTRACT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EMPLABORCONTRACT;

				if (pagination) {
					sql = sql.concat(EmpLaborContractModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<EmpLaborContract>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<EmpLaborContract>(list);
				}
				else {
					list = (List<EmpLaborContract>)QueryUtil.list(q,
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
	 * Removes all the emp labor contracts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (EmpLaborContract empLaborContract : findAll()) {
			remove(empLaborContract);
		}
	}

	/**
	 * Returns the number of emp labor contracts.
	 *
	 * @return the number of emp labor contracts
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

				Query q = session.createQuery(_SQL_COUNT_EMPLABORCONTRACT);

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
	 * Initializes the emp labor contract persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.EmpLaborContract")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<EmpLaborContract>> listenersList = new ArrayList<ModelListener<EmpLaborContract>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<EmpLaborContract>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(EmpLaborContractImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EMPLABORCONTRACT = "SELECT empLaborContract FROM EmpLaborContract empLaborContract";
	private static final String _SQL_SELECT_EMPLABORCONTRACT_WHERE = "SELECT empLaborContract FROM EmpLaborContract empLaborContract WHERE ";
	private static final String _SQL_COUNT_EMPLABORCONTRACT = "SELECT COUNT(empLaborContract) FROM EmpLaborContract empLaborContract";
	private static final String _SQL_COUNT_EMPLABORCONTRACT_WHERE = "SELECT COUNT(empLaborContract) FROM EmpLaborContract empLaborContract WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "empLaborContract.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EmpLaborContract exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EmpLaborContract exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(EmpLaborContractPersistenceImpl.class);
	private static EmpLaborContract _nullEmpLaborContract = new EmpLaborContractImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<EmpLaborContract> toCacheModel() {
				return _nullEmpLaborContractCacheModel;
			}
		};

	private static CacheModel<EmpLaborContract> _nullEmpLaborContractCacheModel = new CacheModel<EmpLaborContract>() {
			@Override
			public EmpLaborContract toEntityModel() {
				return _nullEmpLaborContract;
			}
		};
}