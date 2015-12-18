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

import vn.com.ecopharma.emp.NoSuchCertificateException;
import vn.com.ecopharma.emp.model.Certificate;
import vn.com.ecopharma.emp.model.impl.CertificateImpl;
import vn.com.ecopharma.emp.model.impl.CertificateModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CertificatePersistence
 * @see CertificateUtil
 * @generated
 */
public class CertificatePersistenceImpl extends BasePersistenceImpl<Certificate>
	implements CertificatePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CertificateUtil} to access the certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CertificateImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATETYPE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCertificateType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATETYPE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCertificateType",
			new String[] { String.class.getName() },
			CertificateModelImpl.CERTIFICATETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CERTIFICATETYPE = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCertificateType", new String[] { String.class.getName() });

	/**
	 * Returns all the certificates where certificateType = &#63;.
	 *
	 * @param certificateType the certificate type
	 * @return the matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByCertificateType(String certificateType)
		throws SystemException {
		return findByCertificateType(certificateType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates where certificateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param certificateType the certificate type
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByCertificateType(String certificateType,
		int start, int end) throws SystemException {
		return findByCertificateType(certificateType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates where certificateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param certificateType the certificate type
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByCertificateType(String certificateType,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATETYPE;
			finderArgs = new Object[] { certificateType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CERTIFICATETYPE;
			finderArgs = new Object[] {
					certificateType,
					
					start, end, orderByComparator
				};
		}

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Certificate certificate : list) {
				if (!Validator.equals(certificateType,
							certificate.getCertificateType())) {
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

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

			boolean bindCertificateType = false;

			if (certificateType == null) {
				query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_1);
			}
			else if (certificateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_3);
			}
			else {
				bindCertificateType = true;

				query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertificateModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCertificateType) {
					qPos.add(certificateType);
				}

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first certificate in the ordered set where certificateType = &#63;.
	 *
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByCertificateType_First(String certificateType,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByCertificateType_First(certificateType,
				orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("certificateType=");
		msg.append(certificateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the first certificate in the ordered set where certificateType = &#63;.
	 *
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByCertificateType_First(String certificateType,
		OrderByComparator orderByComparator) throws SystemException {
		List<Certificate> list = findByCertificateType(certificateType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last certificate in the ordered set where certificateType = &#63;.
	 *
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByCertificateType_Last(String certificateType,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByCertificateType_Last(certificateType,
				orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("certificateType=");
		msg.append(certificateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the last certificate in the ordered set where certificateType = &#63;.
	 *
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByCertificateType_Last(String certificateType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCertificateType(certificateType);

		if (count == 0) {
			return null;
		}

		List<Certificate> list = findByCertificateType(certificateType,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the certificates before and after the current certificate in the ordered set where certificateType = &#63;.
	 *
	 * @param certificateId the primary key of the current certificate
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate[] findByCertificateType_PrevAndNext(long certificateId,
		String certificateType, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByPrimaryKey(certificateId);

		Session session = null;

		try {
			session = openSession();

			Certificate[] array = new CertificateImpl[3];

			array[0] = getByCertificateType_PrevAndNext(session, certificate,
					certificateType, orderByComparator, true);

			array[1] = certificate;

			array[2] = getByCertificateType_PrevAndNext(session, certificate,
					certificateType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Certificate getByCertificateType_PrevAndNext(Session session,
		Certificate certificate, String certificateType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTIFICATE_WHERE);

		boolean bindCertificateType = false;

		if (certificateType == null) {
			query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_1);
		}
		else if (certificateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_3);
		}
		else {
			bindCertificateType = true;

			query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_2);
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
			query.append(CertificateModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCertificateType) {
			qPos.add(certificateType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Certificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the certificates where certificateType = &#63; from the database.
	 *
	 * @param certificateType the certificate type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCertificateType(String certificateType)
		throws SystemException {
		for (Certificate certificate : findByCertificateType(certificateType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates where certificateType = &#63;.
	 *
	 * @param certificateType the certificate type
	 * @return the number of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCertificateType(String certificateType)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CERTIFICATETYPE;

		Object[] finderArgs = new Object[] { certificateType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

			boolean bindCertificateType = false;

			if (certificateType == null) {
				query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_1);
			}
			else if (certificateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_3);
			}
			else {
				bindCertificateType = true;

				query.append(_FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCertificateType) {
					qPos.add(certificateType);
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

	private static final String _FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_1 =
		"certificate.certificateType IS NULL";
	private static final String _FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_2 =
		"certificate.certificateType = ?";
	private static final String _FINDER_COLUMN_CERTIFICATETYPE_CERTIFICATETYPE_3 =
		"(certificate.certificateType IS NULL OR certificate.certificateType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassNameAndClassPK",
			new String[] { String.class.getName(), Long.class.getName() },
			CertificateModelImpl.CLASSNAME_COLUMN_BITMASK |
			CertificateModelImpl.CLASSPK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK = new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameAndClassPK",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the certificates where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByClassNameAndClassPK(String className,
		long classPK) throws SystemException {
		return findByClassNameAndClassPK(className, classPK, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByClassNameAndClassPK(String className,
		long classPK, int start, int end) throws SystemException {
		return findByClassNameAndClassPK(className, classPK, start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates where className = &#63; and classPK = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByClassNameAndClassPK(String className,
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

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Certificate certificate : list) {
				if (!Validator.equals(className, certificate.getClassName()) ||
						(classPK != certificate.getClassPK())) {
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

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

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
				query.append(CertificateModelImpl.ORDER_BY_JPQL);
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
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first certificate in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByClassNameAndClassPK_First(String className,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByClassNameAndClassPK_First(className,
				classPK, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the first certificate in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByClassNameAndClassPK_First(String className,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		List<Certificate> list = findByClassNameAndClassPK(className, classPK,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last certificate in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByClassNameAndClassPK_Last(String className,
		long classPK, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByClassNameAndClassPK_Last(className,
				classPK, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the last certificate in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByClassNameAndClassPK_Last(String className,
		long classPK, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByClassNameAndClassPK(className, classPK);

		if (count == 0) {
			return null;
		}

		List<Certificate> list = findByClassNameAndClassPK(className, classPK,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the certificates before and after the current certificate in the ordered set where className = &#63; and classPK = &#63;.
	 *
	 * @param certificateId the primary key of the current certificate
	 * @param className the class name
	 * @param classPK the class p k
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate[] findByClassNameAndClassPK_PrevAndNext(
		long certificateId, String className, long classPK,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByPrimaryKey(certificateId);

		Session session = null;

		try {
			session = openSession();

			Certificate[] array = new CertificateImpl[3];

			array[0] = getByClassNameAndClassPK_PrevAndNext(session,
					certificate, className, classPK, orderByComparator, true);

			array[1] = certificate;

			array[2] = getByClassNameAndClassPK_PrevAndNext(session,
					certificate, className, classPK, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Certificate getByClassNameAndClassPK_PrevAndNext(
		Session session, Certificate certificate, String className,
		long classPK, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTIFICATE_WHERE);

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
			query.append(CertificateModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(certificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Certificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the certificates where className = &#63; and classPK = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassNameAndClassPK(String className, long classPK)
		throws SystemException {
		for (Certificate certificate : findByClassNameAndClassPK(className,
				classPK, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates where className = &#63; and classPK = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @return the number of matching certificates
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

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

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

	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_1 = "certificate.className IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_2 = "certificate.className = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSNAME_3 = "(certificate.className IS NULL OR certificate.className = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMEANDCLASSPK_CLASSPK_2 = "certificate.classPK = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByClassNameClassPKAndCertificateType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, CertificateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByClassNameClassPKAndCertificateType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			CertificateModelImpl.CLASSNAME_COLUMN_BITMASK |
			CertificateModelImpl.CLASSPK_COLUMN_BITMASK |
			CertificateModelImpl.CERTIFICATETYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE =
		new FinderPath(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByClassNameClassPKAndCertificateType",
			new String[] {
				String.class.getName(), Long.class.getName(),
				String.class.getName()
			});

	/**
	 * Returns all the certificates where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @return the matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByClassNameClassPKAndCertificateType(
		String className, long classPK, String certificateType)
		throws SystemException {
		return findByClassNameClassPKAndCertificateType(className, classPK,
			certificateType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByClassNameClassPKAndCertificateType(
		String className, long classPK, String certificateType, int start,
		int end) throws SystemException {
		return findByClassNameClassPKAndCertificateType(className, classPK,
			certificateType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findByClassNameClassPKAndCertificateType(
		String className, long classPK, String certificateType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE;
			finderArgs = new Object[] { className, classPK, certificateType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE;
			finderArgs = new Object[] {
					className, classPK, certificateType,
					
					start, end, orderByComparator
				};
		}

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Certificate certificate : list) {
				if (!Validator.equals(className, certificate.getClassName()) ||
						(classPK != certificate.getClassPK()) ||
						!Validator.equals(certificateType,
							certificate.getCertificateType())) {
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

			query.append(_SQL_SELECT_CERTIFICATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSPK_2);

			boolean bindCertificateType = false;

			if (certificateType == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_1);
			}
			else if (certificateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_3);
			}
			else {
				bindCertificateType = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CertificateModelImpl.ORDER_BY_JPQL);
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

				if (bindCertificateType) {
					qPos.add(certificateType);
				}

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first certificate in the ordered set where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByClassNameClassPKAndCertificateType_First(
		String className, long classPK, String certificateType,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByClassNameClassPKAndCertificateType_First(className,
				classPK, certificateType, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", certificateType=");
		msg.append(certificateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the first certificate in the ordered set where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByClassNameClassPKAndCertificateType_First(
		String className, long classPK, String certificateType,
		OrderByComparator orderByComparator) throws SystemException {
		List<Certificate> list = findByClassNameClassPKAndCertificateType(className,
				classPK, certificateType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last certificate in the ordered set where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByClassNameClassPKAndCertificateType_Last(
		String className, long classPK, String certificateType,
		OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByClassNameClassPKAndCertificateType_Last(className,
				classPK, certificateType, orderByComparator);

		if (certificate != null) {
			return certificate;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("className=");
		msg.append(className);

		msg.append(", classPK=");
		msg.append(classPK);

		msg.append(", certificateType=");
		msg.append(certificateType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCertificateException(msg.toString());
	}

	/**
	 * Returns the last certificate in the ordered set where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByClassNameClassPKAndCertificateType_Last(
		String className, long classPK, String certificateType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByClassNameClassPKAndCertificateType(className,
				classPK, certificateType);

		if (count == 0) {
			return null;
		}

		List<Certificate> list = findByClassNameClassPKAndCertificateType(className,
				classPK, certificateType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the certificates before and after the current certificate in the ordered set where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param certificateId the primary key of the current certificate
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate[] findByClassNameClassPKAndCertificateType_PrevAndNext(
		long certificateId, String className, long classPK,
		String certificateType, OrderByComparator orderByComparator)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = findByPrimaryKey(certificateId);

		Session session = null;

		try {
			session = openSession();

			Certificate[] array = new CertificateImpl[3];

			array[0] = getByClassNameClassPKAndCertificateType_PrevAndNext(session,
					certificate, className, classPK, certificateType,
					orderByComparator, true);

			array[1] = certificate;

			array[2] = getByClassNameClassPKAndCertificateType_PrevAndNext(session,
					certificate, className, classPK, certificateType,
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

	protected Certificate getByClassNameClassPKAndCertificateType_PrevAndNext(
		Session session, Certificate certificate, String className,
		long classPK, String certificateType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CERTIFICATE_WHERE);

		boolean bindClassName = false;

		if (className == null) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_1);
		}
		else if (className.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_3);
		}
		else {
			bindClassName = true;

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_2);
		}

		query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSPK_2);

		boolean bindCertificateType = false;

		if (certificateType == null) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_1);
		}
		else if (certificateType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_3);
		}
		else {
			bindCertificateType = true;

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_2);
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
			query.append(CertificateModelImpl.ORDER_BY_JPQL);
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

		if (bindCertificateType) {
			qPos.add(certificateType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(certificate);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Certificate> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the certificates where className = &#63; and classPK = &#63; and certificateType = &#63; from the database.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByClassNameClassPKAndCertificateType(String className,
		long classPK, String certificateType) throws SystemException {
		for (Certificate certificate : findByClassNameClassPKAndCertificateType(
				className, classPK, certificateType, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates where className = &#63; and classPK = &#63; and certificateType = &#63;.
	 *
	 * @param className the class name
	 * @param classPK the class p k
	 * @param certificateType the certificate type
	 * @return the number of matching certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByClassNameClassPKAndCertificateType(String className,
		long classPK, String certificateType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE;

		Object[] finderArgs = new Object[] { className, classPK, certificateType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CERTIFICATE_WHERE);

			boolean bindClassName = false;

			if (className == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_1);
			}
			else if (className.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_3);
			}
			else {
				bindClassName = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_2);
			}

			query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSPK_2);

			boolean bindCertificateType = false;

			if (certificateType == null) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_1);
			}
			else if (certificateType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_3);
			}
			else {
				bindCertificateType = true;

				query.append(_FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_2);
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

				if (bindCertificateType) {
					qPos.add(certificateType);
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

	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_1 =
		"certificate.className IS NULL AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_2 =
		"certificate.className = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSNAME_3 =
		"(certificate.className IS NULL OR certificate.className = '') AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CLASSPK_2 =
		"certificate.classPK = ? AND ";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_1 =
		"certificate.certificateType IS NULL";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_2 =
		"certificate.certificateType = ?";
	private static final String _FINDER_COLUMN_CLASSNAMECLASSPKANDCERTIFICATETYPE_CERTIFICATETYPE_3 =
		"(certificate.certificateType IS NULL OR certificate.certificateType = '')";

	public CertificatePersistenceImpl() {
		setModelClass(Certificate.class);
	}

	/**
	 * Caches the certificate in the entity cache if it is enabled.
	 *
	 * @param certificate the certificate
	 */
	@Override
	public void cacheResult(Certificate certificate) {
		EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateImpl.class, certificate.getPrimaryKey(), certificate);

		certificate.resetOriginalValues();
	}

	/**
	 * Caches the certificates in the entity cache if it is enabled.
	 *
	 * @param certificates the certificates
	 */
	@Override
	public void cacheResult(List<Certificate> certificates) {
		for (Certificate certificate : certificates) {
			if (EntityCacheUtil.getResult(
						CertificateModelImpl.ENTITY_CACHE_ENABLED,
						CertificateImpl.class, certificate.getPrimaryKey()) == null) {
				cacheResult(certificate);
			}
			else {
				certificate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all certificates.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CertificateImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CertificateImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the certificate.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Certificate certificate) {
		EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateImpl.class, certificate.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Certificate> certificates) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Certificate certificate : certificates) {
			EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
				CertificateImpl.class, certificate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new certificate with the primary key. Does not add the certificate to the database.
	 *
	 * @param certificateId the primary key for the new certificate
	 * @return the new certificate
	 */
	@Override
	public Certificate create(long certificateId) {
		Certificate certificate = new CertificateImpl();

		certificate.setNew(true);
		certificate.setPrimaryKey(certificateId);

		return certificate;
	}

	/**
	 * Removes the certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param certificateId the primary key of the certificate
	 * @return the certificate that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate remove(long certificateId)
		throws NoSuchCertificateException, SystemException {
		return remove((Serializable)certificateId);
	}

	/**
	 * Removes the certificate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the certificate
	 * @return the certificate that was removed
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate remove(Serializable primaryKey)
		throws NoSuchCertificateException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Certificate certificate = (Certificate)session.get(CertificateImpl.class,
					primaryKey);

			if (certificate == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(certificate);
		}
		catch (NoSuchCertificateException nsee) {
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
	protected Certificate removeImpl(Certificate certificate)
		throws SystemException {
		certificate = toUnwrappedModel(certificate);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(certificate)) {
				certificate = (Certificate)session.get(CertificateImpl.class,
						certificate.getPrimaryKeyObj());
			}

			if (certificate != null) {
				session.delete(certificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (certificate != null) {
			clearCache(certificate);
		}

		return certificate;
	}

	@Override
	public Certificate updateImpl(
		vn.com.ecopharma.emp.model.Certificate certificate)
		throws SystemException {
		certificate = toUnwrappedModel(certificate);

		boolean isNew = certificate.isNew();

		CertificateModelImpl certificateModelImpl = (CertificateModelImpl)certificate;

		Session session = null;

		try {
			session = openSession();

			if (certificate.isNew()) {
				session.save(certificate);

				certificate.setNew(false);
			}
			else {
				session.merge(certificate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CertificateModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificateModelImpl.getOriginalCertificateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATETYPE,
					args);

				args = new Object[] { certificateModelImpl.getCertificateType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CERTIFICATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CERTIFICATETYPE,
					args);
			}

			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificateModelImpl.getOriginalClassName(),
						certificateModelImpl.getOriginalClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);

				args = new Object[] {
						certificateModelImpl.getClassName(),
						certificateModelImpl.getClassPK()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMEANDCLASSPK,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMEANDCLASSPK,
					args);
			}

			if ((certificateModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						certificateModelImpl.getOriginalClassName(),
						certificateModelImpl.getOriginalClassPK(),
						certificateModelImpl.getOriginalCertificateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE,
					args);

				args = new Object[] {
						certificateModelImpl.getClassName(),
						certificateModelImpl.getClassPK(),
						certificateModelImpl.getCertificateType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CLASSNAMECLASSPKANDCERTIFICATETYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
			CertificateImpl.class, certificate.getPrimaryKey(), certificate);

		return certificate;
	}

	protected Certificate toUnwrappedModel(Certificate certificate) {
		if (certificate instanceof CertificateImpl) {
			return certificate;
		}

		CertificateImpl certificateImpl = new CertificateImpl();

		certificateImpl.setNew(certificate.isNew());
		certificateImpl.setPrimaryKey(certificate.getPrimaryKey());

		certificateImpl.setCertificateId(certificate.getCertificateId());
		certificateImpl.setClassName(certificate.getClassName());
		certificateImpl.setClassPK(certificate.getClassPK());
		certificateImpl.setEducation(certificate.getEducation());
		certificateImpl.setCertificateType(certificate.getCertificateType());
		certificateImpl.setName(certificate.getName());
		certificateImpl.setSpecialize(certificate.getSpecialize());
		certificateImpl.setCoursePlace(certificate.getCoursePlace());
		certificateImpl.setGraduatedYear(certificate.getGraduatedYear());
		certificateImpl.setGrade(certificate.getGrade());
		certificateImpl.setCourseType(certificate.getCourseType());
		certificateImpl.setExpiredDate(certificate.getExpiredDate());
		certificateImpl.setIssuedPlace(certificate.getIssuedPlace());
		certificateImpl.setNote(certificate.getNote());
		certificateImpl.setGroupId(certificate.getGroupId());
		certificateImpl.setCompanyId(certificate.getCompanyId());
		certificateImpl.setUserId(certificate.getUserId());
		certificateImpl.setUserName(certificate.getUserName());
		certificateImpl.setCreateDate(certificate.getCreateDate());
		certificateImpl.setModifiedDate(certificate.getModifiedDate());

		return certificateImpl;
	}

	/**
	 * Returns the certificate with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the certificate
	 * @return the certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCertificateException, SystemException {
		Certificate certificate = fetchByPrimaryKey(primaryKey);

		if (certificate == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCertificateException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return certificate;
	}

	/**
	 * Returns the certificate with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchCertificateException} if it could not be found.
	 *
	 * @param certificateId the primary key of the certificate
	 * @return the certificate
	 * @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate findByPrimaryKey(long certificateId)
		throws NoSuchCertificateException, SystemException {
		return findByPrimaryKey((Serializable)certificateId);
	}

	/**
	 * Returns the certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the certificate
	 * @return the certificate, or <code>null</code> if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Certificate certificate = (Certificate)EntityCacheUtil.getResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
				CertificateImpl.class, primaryKey);

		if (certificate == _nullCertificate) {
			return null;
		}

		if (certificate == null) {
			Session session = null;

			try {
				session = openSession();

				certificate = (Certificate)session.get(CertificateImpl.class,
						primaryKey);

				if (certificate != null) {
					cacheResult(certificate);
				}
				else {
					EntityCacheUtil.putResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
						CertificateImpl.class, primaryKey, _nullCertificate);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CertificateModelImpl.ENTITY_CACHE_ENABLED,
					CertificateImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return certificate;
	}

	/**
	 * Returns the certificate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param certificateId the primary key of the certificate
	 * @return the certificate, or <code>null</code> if a certificate with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Certificate fetchByPrimaryKey(long certificateId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)certificateId);
	}

	/**
	 * Returns all the certificates.
	 *
	 * @return the certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @return the range of certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the certificates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.emp.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of certificates
	 * @param end the upper bound of the range of certificates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of certificates
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Certificate> findAll(int start, int end,
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

		List<Certificate> list = (List<Certificate>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CERTIFICATE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CERTIFICATE;

				if (pagination) {
					sql = sql.concat(CertificateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Certificate>(list);
				}
				else {
					list = (List<Certificate>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the certificates from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Certificate certificate : findAll()) {
			remove(certificate);
		}
	}

	/**
	 * Returns the number of certificates.
	 *
	 * @return the number of certificates
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

				Query q = session.createQuery(_SQL_COUNT_CERTIFICATE);

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
	 * Initializes the certificate persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.vn.com.ecopharma.emp.model.Certificate")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Certificate>> listenersList = new ArrayList<ModelListener<Certificate>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Certificate>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CertificateImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CERTIFICATE = "SELECT certificate FROM Certificate certificate";
	private static final String _SQL_SELECT_CERTIFICATE_WHERE = "SELECT certificate FROM Certificate certificate WHERE ";
	private static final String _SQL_COUNT_CERTIFICATE = "SELECT COUNT(certificate) FROM Certificate certificate";
	private static final String _SQL_COUNT_CERTIFICATE_WHERE = "SELECT COUNT(certificate) FROM Certificate certificate WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "certificate.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Certificate exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Certificate exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CertificatePersistenceImpl.class);
	private static Certificate _nullCertificate = new CertificateImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Certificate> toCacheModel() {
				return _nullCertificateCacheModel;
			}
		};

	private static CacheModel<Certificate> _nullCertificateCacheModel = new CacheModel<Certificate>() {
			@Override
			public Certificate toEntityModel() {
				return _nullCertificate;
			}
		};
}