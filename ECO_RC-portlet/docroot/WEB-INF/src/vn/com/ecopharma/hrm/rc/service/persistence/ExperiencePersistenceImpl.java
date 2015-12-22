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
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import vn.com.ecopharma.hrm.rc.NoSuchExperienceException;
import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.model.impl.ExperienceImpl;
import vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the experience service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see ExperiencePersistence
 * @see ExperienceUtil
 * @generated
 */
public class ExperiencePersistenceImpl extends BasePersistenceImpl<Experience>
	implements ExperiencePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ExperienceUtil} to access the experience persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ExperienceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, ExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, ExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, ExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, ExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] { String.class.getName(), Long.class.getName() },
			ExperienceModelImpl.CLASSNAME_COLUMN_BITMASK |
			ExperienceModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK = new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameAndClassPK",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the experiences where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findByClassNameAndClassPK(String className,
		long classPK) throws SystemException {
		return findByClassNameAndClassPK(className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experiences where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findByClassNameAndClassPK(String className,
		long classPK, int start, int end) throws SystemException {
		return findByClassNameAndClassPK(className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experiences where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findByClassNameAndClassPK(String className,
		long classPK, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK;
			finderArgs = new Object[] { className, classPK };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK;
			finderArgs = new Object[] {
					className, classPK,
					
					start, end, orderByComparator
				};
		}

		List<Experience> list = (List<Experience>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Experience experience : list) {
				if (!Validator.equals(className, experience.getClassName()) ||
						(classPK != experience.getClassPK())) {
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

			query.append(_SQL_SELECT_EXPERIENCE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

				if (!pagination) {
					list = (List<Experience>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Experience>(list);
				}
				else {
					list = (List<Experience>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first experience in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience findByClassNameAndClassPK_First(String className,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchExperienceException, SystemException {
		Experience experience = fetchByClassNameAndClassPK_First(className,
				classPK, orderByComparator);

		if (experience != null) {
			return experience;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExperienceException(msg.toString());
	}

	/**
	 * Returns the first experience in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience fetchByClassNameAndClassPK_First(String className,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<Experience> list = findByClassNameAndClassPK(className, classPK,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last experience in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience findByClassNameAndClassPK_Last(String className,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchExperienceException, SystemException {
		Experience experience = fetchByClassNameAndClassPK_Last(className,
				classPK, orderByComparator);

		if (experience != null) {
			return experience;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExperienceException(msg.toString());
	}

	/**
	 * Returns the last experience in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience fetchByClassNameAndClassPK_Last(String className,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByClassNameAndClassPK(className, classPK);

		if (count == 0) {
			return null;
		}

		List<Experience> list = findByClassNameAndClassPK(className, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the experiences before and after the current experience in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience[] findByClassNameAndClassPK_PrevAndNext(
		long experienceId, String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchExperienceException, SystemException {
		Experience experience = findByPrimaryKey(experienceId);

		Session session = null;

		try {
			session = openSession();

			Experience[] array = new ExperienceImpl[3];

			array[0] = getByClassNameAndClassPK_PrevAndNext(session,
					experience, className, classPK, orderByComparator, true);

			array[1] = experience;

			array[2] = getByClassNameAndClassPK_PrevAndNext(session,
					experience, className, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Experience getByClassNameAndClassPK_PrevAndNext(Session session,
		Experience experience, String className, long classPK,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPERIENCE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

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
			query.append(ExperienceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		qPos.add(classPK);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(experience);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Experience> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the experiences where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassNameAndClassPK(String className, long classPK)
		throws SystemException {
		for (Experience experience : findByClassNameAndClassPK(className,
				classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(experience);
		}
	}

	/**
	 * Returns the number of experiences where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassNameAndClassPK(String className, long classPK)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK;

		Object[] finderArgs = new Object[] { className, classPK };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXPERIENCE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1 = "experience.className IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2 = "experience.className = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3 = "(experience.className IS NULL OR experience.className = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2 = "experience.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, ExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByClassName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME =
		new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, ExperienceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByClassName",
			new String[] { String.class.getName() },
			ExperienceModelImpl.CLASSNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAME = new FinderPath(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByClassName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the experiences where className = &#63;.
	 *
	 * @param className the class name
	 * @return the matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findByClassName(String className)
		throws SystemException {
		return findByClassName(className, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the experiences where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findByClassName(String className, int start, int end)
		throws SystemException {
		return findByClassName(className, start, end, null);
	}

	/**
	 * Returns an ordered range of all the experiences where className = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findByClassName(String className, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAME;
			finderArgs = new Object[] { className, start, end, orderByComparator };
		}

		List<Experience> list = (List<Experience>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Experience experience : list) {
				if (!Validator.equals(className, experience.getClassName())) {
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

			query.append(_SQL_SELECT_EXPERIENCE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ExperienceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
				}

				if (!pagination) {
					list = (List<Experience>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Experience>(list);
				}
				else {
					list = (List<Experience>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first experience in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience findByClassName_First(String className,
		OrderByComparator orderByComparator)
		throws NoSuchExperienceException, SystemException {
		Experience experience = fetchByClassName_First(className,
				orderByComparator);

		if (experience != null) {
			return experience;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExperienceException(msg.toString());
	}

	/**
	 * Returns the first experience in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching experience, or <code>null</code> if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience fetchByClassName_First(String className,
		OrderByComparator orderByComparator) throws SystemException {
		List<Experience> list = findByClassName(className, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last experience in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience findByClassName_Last(String className,
		OrderByComparator orderByComparator)
		throws NoSuchExperienceException, SystemException {
		Experience experience = fetchByClassName_Last(className,
				orderByComparator);

		if (experience != null) {
			return experience;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchExperienceException(msg.toString());
	}

	/**
	 * Returns the last experience in the ordered set where className = &#63;.
	 *
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching experience, or <code>null</code> if a matching experience could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience fetchByClassName_Last(String className,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClassName(className);

		if (count == 0) {
			return null;
		}

		List<Experience> list = findByClassName(className, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the experiences before and after the current experience in the ordered set where className = &#63;.
	 *
	 * @param experienceId the primary key of the current experience
	 * @param className the class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience[] findByClassName_PrevAndNext(long experienceId,
		String className, OrderByComparator orderByComparator)
		throws NoSuchExperienceException, SystemException {
		Experience experience = findByPrimaryKey(experienceId);

		Session session = null;

		try {
			session = openSession();

			Experience[] array = new ExperienceImpl[3];

			array[0] = getByClassName_PrevAndNext(session, experience,
					className, orderByComparator, true);

			array[1] = experience;

			array[2] = getByClassName_PrevAndNext(session, experience,
					className, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Experience getByClassName_PrevAndNext(Session session,
		Experience experience, String className,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPERIENCE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
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
			query.append(ExperienceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindClassName) {
			qPos.add(className);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(experience);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Experience> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the experiences where className = &#63; from the database.
	 *
	 * @param className the class name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassName(String className) throws SystemException {
		for (Experience experience : findByClassName(className,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(experience);
		}
	}

	/**
	 * Returns the number of experiences where className = &#63;.
	 *
	 * @param className the class name
	 * @return the number of matching experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassName(String className) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAME;

		Object[] finderArgs = new Object[] { className };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPERIENCE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAME_CLASSNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindClassName) {
					qPos.add(className);
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

	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_1 = "experience.className IS NULL";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_2 = "experience.className = ?";
	private static final String _FINDER_COLUMN_CLASSNAME_CLASSNAME_3 = "(experience.className IS NULL OR experience.className = '')";

	public ExperiencePersistenceImpl() {
		setModelClass(Experience.class);
	}

	/**
	 * Caches the experience in the entity cache if it is enabled.
	 *
	 * @param experience the experience
	 */
	@Override
	public void cacheResult(Experience experience) {
		EntityCacheUtil.putResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceImpl.class, experience.getPrimaryKey(), experience);

		experience.resetOriginalValues();
	}

	/**
	 * Caches the experiences in the entity cache if it is enabled.
	 *
	 * @param experiences the experiences
	 */
	@Override
	public void cacheResult(List<Experience> experiences) {
		for (Experience experience : experiences) {
			if (EntityCacheUtil.getResult(
						ExperienceModelImpl.ENTITY_CACHE_ENABLED,
						ExperienceImpl.class, experience.getPrimaryKey()) == null) {
				cacheResult(experience);
			}
			else {
				experience.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all experiences.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ExperienceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ExperienceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the experience.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Experience experience) {
		EntityCacheUtil.removeResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceImpl.class, experience.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Experience> experiences) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Experience experience : experiences) {
			EntityCacheUtil.removeResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
				ExperienceImpl.class, experience.getPrimaryKey());
		}
	}

	/**
	 * Creates a new experience with the primary key. Does not add the experience to the database.
	 *
	 * @param experienceId the primary key for the new experience
	 * @return the new experience
	 */
	@Override
	public Experience create(long experienceId) {
		Experience experience = new ExperienceImpl();

		experience.setNew(true);
		experience.setPrimaryKey(experienceId);

		return experience;
	}

	/**
	 * Removes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience remove(long experienceId)
		throws NoSuchExperienceException, SystemException {
		return remove((Serializable)experienceId);
	}

	/**
	 * Removes the experience with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the experience
	 * @return the experience that was removed
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience remove(Serializable primaryKey)
		throws NoSuchExperienceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Experience experience = (Experience)session.get(ExperienceImpl.class,
					primaryKey);

			if (experience == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExperienceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(experience);
		}
		catch (NoSuchExperienceException nsee) {
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
	protected Experience removeImpl(Experience experience)
		throws SystemException {
		experience = toUnwrappedModel(experience);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(experience)) {
				experience = (Experience)session.get(ExperienceImpl.class,
						experience.getPrimaryKeyObj());
			}

			if (experience != null) {
				session.delete(experience);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (experience != null) {
			clearCache(experience);
		}

		return experience;
	}

	@Override
	public Experience updateImpl(
		vn.com.ecopharma.hrm.rc.model.Experience experience)
		throws SystemException {
		experience = toUnwrappedModel(experience);

		boolean isNew = experience.isNew();

		ExperienceModelImpl experienceModelImpl = (ExperienceModelImpl)experience;

		Session session = null;

		try {
			session = openSession();

			if (experience.isNew()) {
				session.save(experience);

				experience.setNew(false);
			}
			else {
				session.merge(experience);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ExperienceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((experienceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						experienceModelImpl.getOriginalClassName(),
						experienceModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);

				args = new Object[] {
						experienceModelImpl.getClassName(),
						experienceModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);
			}

			if ((experienceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						experienceModelImpl.getOriginalClassName()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);

				args = new Object[] { experienceModelImpl.getClassName() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
			ExperienceImpl.class, experience.getPrimaryKey(), experience);

		return experience;
	}

	protected Experience toUnwrappedModel(Experience experience) {
		if (experience instanceof ExperienceImpl) {
			return experience;
		}

		ExperienceImpl experienceImpl = new ExperienceImpl();

		experienceImpl.setNew(experience.isNew());
		experienceImpl.setPrimaryKey(experience.getPrimaryKey());

		experienceImpl.setExperienceId(experience.getExperienceId());
		experienceImpl.setClassName(experience.getClassName());
		experienceImpl.setClassPK(experience.getClassPK());
		experienceImpl.setCompanyName(experience.getCompanyName());
		experienceImpl.setWorkingPlace(experience.getWorkingPlace());
		experienceImpl.setYearsExperience(experience.getYearsExperience());
		experienceImpl.setTel(experience.getTel());
		experienceImpl.setWorkingFrom(experience.getWorkingFrom());
		experienceImpl.setWorkingTo(experience.getWorkingTo());
		experienceImpl.setInitialTitles(experience.getInitialTitles());
		experienceImpl.setFinalTitles(experience.getFinalTitles());
		experienceImpl.setInitialSalary(experience.getInitialSalary());
		experienceImpl.setFinalSalary(experience.getFinalSalary());
		experienceImpl.setField(experience.getField());
		experienceImpl.setManager(experience.getManager());
		experienceImpl.setResponsibility(experience.getResponsibility());
		experienceImpl.setResignedReason(experience.getResignedReason());
		experienceImpl.setDescription(experience.getDescription());
		experienceImpl.setGroupId(experience.getGroupId());
		experienceImpl.setCompanyId(experience.getCompanyId());
		experienceImpl.setUserId(experience.getUserId());
		experienceImpl.setUserName(experience.getUserName());
		experienceImpl.setCreateDate(experience.getCreateDate());
		experienceImpl.setModifiedDate(experience.getModifiedDate());

		return experienceImpl;
	}

	/**
	 * Returns the experience with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the experience
	 * @return the experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExperienceException, SystemException {
		Experience experience = fetchByPrimaryKey(primaryKey);

		if (experience == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExperienceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return experience;
	}

	/**
	 * Returns the experience with the primary key or throws a {@link vn.com.ecopharma.hrm.rc.NoSuchExperienceException} if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience
	 * @throws vn.com.ecopharma.hrm.rc.NoSuchExperienceException if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience findByPrimaryKey(long experienceId)
		throws NoSuchExperienceException, SystemException {
		return findByPrimaryKey((Serializable)experienceId);
	}

	/**
	 * Returns the experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the experience
	 * @return the experience, or <code>null</code> if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Experience experience = (Experience)EntityCacheUtil.getResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
				ExperienceImpl.class, primaryKey);

		if (experience == _nullExperience) {
			return null;
		}

		if (experience == null) {
			Session session = null;

			try {
				session = openSession();

				experience = (Experience)session.get(ExperienceImpl.class,
						primaryKey);

				if (experience != null) {
					cacheResult(experience);
				}
				else {
					EntityCacheUtil.putResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
						ExperienceImpl.class, primaryKey, _nullExperience);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ExperienceModelImpl.ENTITY_CACHE_ENABLED,
					ExperienceImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return experience;
	}

	/**
	 * Returns the experience with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param experienceId the primary key of the experience
	 * @return the experience, or <code>null</code> if a experience with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Experience fetchByPrimaryKey(long experienceId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)experienceId);
	}

	/**
	 * Returns all the experiences.
	 *
	 * @return the experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @return the range of experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the experiences.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.ExperienceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of experiences
	 * @param end the upper bound of the range of experiences (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of experiences
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Experience> findAll(int start, int end,
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

		List<Experience> list = (List<Experience>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_EXPERIENCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPERIENCE;

				if (pagination) {
					sql = sql.concat(ExperienceModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Experience>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Experience>(list);
				}
				else {
					list = (List<Experience>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the experiences from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Experience experience : findAll()) {
			remove(experience);
		}
	}

	/**
	 * Returns the number of experiences.
	 *
	 * @return the number of experiences
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

				Query q = session.createQuery(_SQL_COUNT_EXPERIENCE);

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
	 * Initializes the experience persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.hrm.rc.model.Experience")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Experience>> listenersList = new ArrayList<ModelListener<Experience>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Experience>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ExperienceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_EXPERIENCE = "SELECT experience FROM Experience experience";
	private static final String _SQL_SELECT_EXPERIENCE_WHERE = "SELECT experience FROM Experience experience WHERE ";
	private static final String _SQL_COUNT_EXPERIENCE = "SELECT COUNT(experience) FROM Experience experience";
	private static final String _SQL_COUNT_EXPERIENCE_WHERE = "SELECT COUNT(experience) FROM Experience experience WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "experience.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Experience exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Experience exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ExperiencePersistenceImpl.class);
	private static Experience _nullExperience = new ExperienceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Experience> toCacheModel() {
				return _nullExperienceCacheModel;
			}
		};

	private static CacheModel<Experience> _nullExperienceCacheModel = new CacheModel<Experience>() {
			@Override
			public Experience toEntityModel() {
				return _nullExperience;
			}
		};
}