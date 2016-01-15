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

import vn.com.ecopharma.emp.NoSuchDistrictException;
import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.model.impl.DistrictImpl;
import vn.com.ecopharma.emp.model.impl.DistrictModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the district service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see DistrictPersistence
 * @see DistrictUtil
 * @generated
 */
public class DistrictPersistenceImpl extends BasePersistenceImpl<District>
	implements DistrictPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DistrictUtil} to access the district persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DistrictImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONCODE =
		new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRegionCode",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODE =
		new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRegionCode",
			new String[] { String.class.getName() },
			DistrictModelImpl.REGIONCODE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONCODE = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRegionCode",
			new String[] { String.class.getName() });

	/**
	 * Returns all the districts where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @return the matching districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<District> findByRegionCode(String regionCode)
		throws SystemException {
		return findByRegionCode(regionCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the districts where regionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionCode the region code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of matching districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<District> findByRegionCode(String regionCode, int start, int end)
		throws SystemException {
		return findByRegionCode(regionCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the districts where regionCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param regionCode the region code
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<District> findByRegionCode(String regionCode, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODE;
			finderArgs = new Object[] { regionCode };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REGIONCODE;
			finderArgs = new Object[] { regionCode, start, end, orderByComparator };
		}

		List<District> list = (List<District>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (District district : list) {
				if (!Validator.equals(regionCode, district.getRegionCode())) {
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

			query.append(_SQL_SELECT_DISTRICT_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DistrictModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				if (!pagination) {
					list = (List<District>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<District>(list);
				}
				else {
					list = (List<District>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first district in the ordered set where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District findByRegionCode_First(String regionCode,
		OrderByComparator orderByComparator)
		throws NoSuchDistrictException, SystemException {
		District district = fetchByRegionCode_First(regionCode,
				orderByComparator);

		if (district != null) {
			return district;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionCode=");
		msg.append(regionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistrictException(msg.toString());
	}

	/**
	 * Returns the first district in the ordered set where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching district, or <code>null</code> if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District fetchByRegionCode_First(String regionCode,
		OrderByComparator orderByComparator) throws SystemException {
		List<District> list = findByRegionCode(regionCode, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last district in the ordered set where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District findByRegionCode_Last(String regionCode,
		OrderByComparator orderByComparator)
		throws NoSuchDistrictException, SystemException {
		District district = fetchByRegionCode_Last(regionCode, orderByComparator);

		if (district != null) {
			return district;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("regionCode=");
		msg.append(regionCode);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDistrictException(msg.toString());
	}

	/**
	 * Returns the last district in the ordered set where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching district, or <code>null</code> if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District fetchByRegionCode_Last(String regionCode,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRegionCode(regionCode);

		if (count == 0) {
			return null;
		}

		List<District> list = findByRegionCode(regionCode, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the districts before and after the current district in the ordered set where regionCode = &#63;.
	 *
	 * @param districtId the primary key of the current district
	 * @param regionCode the region code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next district
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District[] findByRegionCode_PrevAndNext(long districtId,
		String regionCode, OrderByComparator orderByComparator)
		throws NoSuchDistrictException, SystemException {
		District district = findByPrimaryKey(districtId);

		Session session = null;

		try {
			session = openSession();

			District[] array = new DistrictImpl[3];

			array[0] = getByRegionCode_PrevAndNext(session, district,
					regionCode, orderByComparator, true);

			array[1] = district;

			array[2] = getByRegionCode_PrevAndNext(session, district,
					regionCode, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected District getByRegionCode_PrevAndNext(Session session,
		District district, String regionCode,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DISTRICT_WHERE);

		boolean bindRegionCode = false;

		if (regionCode == null) {
			query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_1);
		}
		else if (regionCode.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_3);
		}
		else {
			bindRegionCode = true;

			query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_2);
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
			query.append(DistrictModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindRegionCode) {
			qPos.add(regionCode);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(district);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<District> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the districts where regionCode = &#63; from the database.
	 *
	 * @param regionCode the region code
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRegionCode(String regionCode) throws SystemException {
		for (District district : findByRegionCode(regionCode,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(district);
		}
	}

	/**
	 * Returns the number of districts where regionCode = &#63;.
	 *
	 * @param regionCode the region code
	 * @return the number of matching districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionCode(String regionCode) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONCODE;

		Object[] finderArgs = new Object[] { regionCode };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DISTRICT_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODE_REGIONCODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
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

	private static final String _FINDER_COLUMN_REGIONCODE_REGIONCODE_1 = "district.regionCode IS NULL";
	private static final String _FINDER_COLUMN_REGIONCODE_REGIONCODE_2 = "district.regionCode = ?";
	private static final String _FINDER_COLUMN_REGIONCODE_REGIONCODE_3 = "(district.regionCode IS NULL OR district.regionCode = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_REGIONCODEANDNAME = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, DistrictImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRegionCodeAndName",
			new String[] { String.class.getName(), String.class.getName() },
			DistrictModelImpl.REGIONCODE_COLUMN_BITMASK |
			DistrictModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_REGIONCODEANDNAME = new FinderPath(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRegionCodeAndName",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns the district where regionCode = &#63; and name = &#63; or throws a {@link vn.com.ecopharma.emp.NoSuchDistrictException} if it could not be found.
	 *
	 * @param regionCode the region code
	 * @param name the name
	 * @return the matching district
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District findByRegionCodeAndName(String regionCode, String name)
		throws NoSuchDistrictException, SystemException {
		District district = fetchByRegionCodeAndName(regionCode, name);

		if (district == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("regionCode=");
			msg.append(regionCode);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDistrictException(msg.toString());
		}

		return district;
	}

	/**
	 * Returns the district where regionCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param regionCode the region code
	 * @param name the name
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District fetchByRegionCodeAndName(String regionCode, String name)
		throws SystemException {
		return fetchByRegionCodeAndName(regionCode, name, true);
	}

	/**
	 * Returns the district where regionCode = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param regionCode the region code
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching district, or <code>null</code> if a matching district could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District fetchByRegionCodeAndName(String regionCode, String name,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { regionCode, name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
					finderArgs, this);
		}

		if (result instanceof District) {
			District district = (District)result;

			if (!Validator.equals(regionCode, district.getRegionCode()) ||
					!Validator.equals(name, district.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DISTRICT_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_2);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

				if (bindName) {
					qPos.add(name);
				}

				List<District> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DistrictPersistenceImpl.fetchByRegionCodeAndName(String, String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					District district = list.get(0);

					result = district;

					cacheResult(district);

					if ((district.getRegionCode() == null) ||
							!district.getRegionCode().equals(regionCode) ||
							(district.getName() == null) ||
							!district.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
							finderArgs, district);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
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
			return (District)result;
		}
	}

	/**
	 * Removes the district where regionCode = &#63; and name = &#63; from the database.
	 *
	 * @param regionCode the region code
	 * @param name the name
	 * @return the district that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District removeByRegionCodeAndName(String regionCode, String name)
		throws NoSuchDistrictException, SystemException {
		District district = findByRegionCodeAndName(regionCode, name);

		return remove(district);
	}

	/**
	 * Returns the number of districts where regionCode = &#63; and name = &#63;.
	 *
	 * @param regionCode the region code
	 * @param name the name
	 * @return the number of matching districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRegionCodeAndName(String regionCode, String name)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_REGIONCODEANDNAME;

		Object[] finderArgs = new Object[] { regionCode, name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DISTRICT_WHERE);

			boolean bindRegionCode = false;

			if (regionCode == null) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_1);
			}
			else if (regionCode.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_3);
			}
			else {
				bindRegionCode = true;

				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_2);
			}

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_REGIONCODEANDNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRegionCode) {
					qPos.add(regionCode);
				}

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

	private static final String _FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_1 = "district.regionCode IS NULL AND ";
	private static final String _FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_2 = "district.regionCode = ? AND ";
	private static final String _FINDER_COLUMN_REGIONCODEANDNAME_REGIONCODE_3 = "(district.regionCode IS NULL OR district.regionCode = '') AND ";
	private static final String _FINDER_COLUMN_REGIONCODEANDNAME_NAME_1 = "district.name IS NULL";
	private static final String _FINDER_COLUMN_REGIONCODEANDNAME_NAME_2 = "district.name = ?";
	private static final String _FINDER_COLUMN_REGIONCODEANDNAME_NAME_3 = "(district.name IS NULL OR district.name = '')";

	public DistrictPersistenceImpl() {
		setModelClass(District.class);
	}

	/**
	 * Caches the district in the entity cache if it is enabled.
	 *
	 * @param district the district
	 */
	@Override
	public void cacheResult(District district) {
		EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictImpl.class, district.getPrimaryKey(), district);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
			new Object[] { district.getRegionCode(), district.getName() },
			district);

		district.resetOriginalValues();
	}

	/**
	 * Caches the districts in the entity cache if it is enabled.
	 *
	 * @param districts the districts
	 */
	@Override
	public void cacheResult(List<District> districts) {
		for (District district : districts) {
			if (EntityCacheUtil.getResult(
						DistrictModelImpl.ENTITY_CACHE_ENABLED,
						DistrictImpl.class, district.getPrimaryKey()) == null) {
				cacheResult(district);
			}
			else {
				district.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all districts.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DistrictImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DistrictImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the district.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(District district) {
		EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictImpl.class, district.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(district);
	}

	@Override
	public void clearCache(List<District> districts) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (District district : districts) {
			EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
				DistrictImpl.class, district.getPrimaryKey());

			clearUniqueFindersCache(district);
		}
	}

	protected void cacheUniqueFindersCache(District district) {
		if (district.isNew()) {
			Object[] args = new Object[] {
					district.getRegionCode(), district.getName()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONCODEANDNAME,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
				args, district);
		}
		else {
			DistrictModelImpl districtModelImpl = (DistrictModelImpl)district;

			if ((districtModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_REGIONCODEANDNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						district.getRegionCode(), district.getName()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_REGIONCODEANDNAME,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
					args, district);
			}
		}
	}

	protected void clearUniqueFindersCache(District district) {
		DistrictModelImpl districtModelImpl = (DistrictModelImpl)district;

		Object[] args = new Object[] {
				district.getRegionCode(), district.getName()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODEANDNAME,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
			args);

		if ((districtModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_REGIONCODEANDNAME.getColumnBitmask()) != 0) {
			args = new Object[] {
					districtModelImpl.getOriginalRegionCode(),
					districtModelImpl.getOriginalName()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODEANDNAME,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_REGIONCODEANDNAME,
				args);
		}
	}

	/**
	 * Creates a new district with the primary key. Does not add the district to the database.
	 *
	 * @param districtId the primary key for the new district
	 * @return the new district
	 */
	@Override
	public District create(long districtId) {
		District district = new DistrictImpl();

		district.setNew(true);
		district.setPrimaryKey(districtId);

		return district;
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param districtId the primary key of the district
	 * @return the district that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District remove(long districtId)
		throws NoSuchDistrictException, SystemException {
		return remove((Serializable)districtId);
	}

	/**
	 * Removes the district with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the district
	 * @return the district that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District remove(Serializable primaryKey)
		throws NoSuchDistrictException, SystemException {
		Session session = null;

		try {
			session = openSession();

			District district = (District)session.get(DistrictImpl.class,
					primaryKey);

			if (district == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDistrictException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(district);
		}
		catch (NoSuchDistrictException nsee) {
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
	protected District removeImpl(District district) throws SystemException {
		district = toUnwrappedModel(district);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(district)) {
				district = (District)session.get(DistrictImpl.class,
						district.getPrimaryKeyObj());
			}

			if (district != null) {
				session.delete(district);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (district != null) {
			clearCache(district);
		}

		return district;
	}

	@Override
	public District updateImpl(vn.com.ecopharma.emp.model.District district)
		throws SystemException {
		district = toUnwrappedModel(district);

		boolean isNew = district.isNew();

		DistrictModelImpl districtModelImpl = (DistrictModelImpl)district;

		Session session = null;

		try {
			session = openSession();

			if (district.isNew()) {
				session.save(district);

				district.setNew(false);
			}
			else {
				session.merge(district);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DistrictModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((districtModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						districtModelImpl.getOriginalRegionCode()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODE,
					args);

				args = new Object[] { districtModelImpl.getRegionCode() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REGIONCODE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REGIONCODE,
					args);
			}
		}

		EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
			DistrictImpl.class, district.getPrimaryKey(), district);

		clearUniqueFindersCache(district);
		cacheUniqueFindersCache(district);

		return district;
	}

	protected District toUnwrappedModel(District district) {
		if (district instanceof DistrictImpl) {
			return district;
		}

		DistrictImpl districtImpl = new DistrictImpl();

		districtImpl.setNew(district.isNew());
		districtImpl.setPrimaryKey(district.getPrimaryKey());

		districtImpl.setDistrictId(district.getDistrictId());
		districtImpl.setRegionCode(district.getRegionCode());
		districtImpl.setDistrictType(district.getDistrictType());
		districtImpl.setName(district.getName());
		districtImpl.setGroupId(district.getGroupId());
		districtImpl.setCompanyId(district.getCompanyId());
		districtImpl.setUserId(district.getUserId());
		districtImpl.setUserName(district.getUserName());
		districtImpl.setCreateDate(district.getCreateDate());
		districtImpl.setModifiedDate(district.getModifiedDate());

		return districtImpl;
	}

	/**
	 * Returns the district with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the district
	 * @return the district
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDistrictException, SystemException {
		District district = fetchByPrimaryKey(primaryKey);

		if (district == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDistrictException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return district;
	}

	/**
	 * Returns the district with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchDistrictException} if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district
	 * @throws vn.com.ecopharma.emp.NoSuchDistrictException if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District findByPrimaryKey(long districtId)
		throws NoSuchDistrictException, SystemException {
		return findByPrimaryKey((Serializable)districtId);
	}

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		District district = (District)EntityCacheUtil.getResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
				DistrictImpl.class, primaryKey);

		if (district == _nullDistrict) {
			return null;
		}

		if (district == null) {
			Session session = null;

			try {
				session = openSession();

				district = (District)session.get(DistrictImpl.class, primaryKey);

				if (district != null) {
					cacheResult(district);
				}
				else {
					EntityCacheUtil.putResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
						DistrictImpl.class, primaryKey, _nullDistrict);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DistrictModelImpl.ENTITY_CACHE_ENABLED,
					DistrictImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return district;
	}

	/**
	 * Returns the district with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param districtId the primary key of the district
	 * @return the district, or <code>null</code> if a district with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public District fetchByPrimaryKey(long districtId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)districtId);
	}

	/**
	 * Returns all the districts.
	 *
	 * @return the districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<District> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @return the range of districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<District> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the districts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of districts
	 * @param end the upper bound of the range of districts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of districts
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<District> findAll(int start, int end,
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

		List<District> list = (List<District>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DISTRICT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DISTRICT;

				if (pagination) {
					sql = sql.concat(DistrictModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<District>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<District>(list);
				}
				else {
					list = (List<District>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the districts from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (District district : findAll()) {
			remove(district);
		}
	}

	/**
	 * Returns the number of districts.
	 *
	 * @return the number of districts
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

				Query q = session.createQuery(_SQL_COUNT_DISTRICT);

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
	 * Initializes the district persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.District")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<District>> listenersList = new ArrayList<ModelListener<District>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<District>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DistrictImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DISTRICT = "SELECT district FROM District district";
	private static final String _SQL_SELECT_DISTRICT_WHERE = "SELECT district FROM District district WHERE ";
	private static final String _SQL_COUNT_DISTRICT = "SELECT COUNT(district) FROM District district";
	private static final String _SQL_COUNT_DISTRICT_WHERE = "SELECT COUNT(district) FROM District district WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "district.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No District exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No District exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DistrictPersistenceImpl.class);
	private static District _nullDistrict = new DistrictImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<District> toCacheModel() {
				return _nullDistrictCacheModel;
			}
		};

	private static CacheModel<District> _nullDistrictCacheModel = new CacheModel<District>() {
			@Override
			public District toEntityModel() {
				return _nullDistrict;
			}
		};
}