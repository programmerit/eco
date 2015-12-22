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

import com.liferay.portal.service.persistence.BasePersistence;

import vn.com.ecopharma.emp.model.Certificate;

/**
 * The persistence interface for the certificate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author tvt
 * @see CertificatePersistenceImpl
 * @see CertificateUtil
 * @generated
 */
public interface CertificatePersistence extends BasePersistence<Certificate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CertificateUtil} to access the certificate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the certificates where certificateType = &#63;.
	*
	* @param certificateType the certificate type
	* @return the matching certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByCertificateType(
		java.lang.String certificateType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByCertificateType(
		java.lang.String certificateType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByCertificateType(
		java.lang.String certificateType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first certificate in the ordered set where certificateType = &#63;.
	*
	* @param certificateType the certificate type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching certificate
	* @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate findByCertificateType_First(
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Returns the first certificate in the ordered set where certificateType = &#63;.
	*
	* @param certificateType the certificate type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate fetchByCertificateType_First(
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last certificate in the ordered set where certificateType = &#63;.
	*
	* @param certificateType the certificate type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching certificate
	* @throws vn.com.ecopharma.emp.NoSuchCertificateException if a matching certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate findByCertificateType_Last(
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Returns the last certificate in the ordered set where certificateType = &#63;.
	*
	* @param certificateType the certificate type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate fetchByCertificateType_Last(
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate[] findByCertificateType_PrevAndNext(
		long certificateId, java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Removes all the certificates where certificateType = &#63; from the database.
	*
	* @param certificateType the certificate type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCertificateType(java.lang.String certificateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of certificates where certificateType = &#63;.
	*
	* @param certificateType the certificate type
	* @return the number of matching certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByCertificateType(java.lang.String certificateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the certificates where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the matching certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByClassNameAndClassPK(
		java.lang.String className, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByClassNameAndClassPK(
		java.lang.String className, long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByClassNameAndClassPK(
		java.lang.String className, long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate findByClassNameAndClassPK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Returns the first certificate in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching certificate, or <code>null</code> if a matching certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate fetchByClassNameAndClassPK_First(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate findByClassNameAndClassPK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Returns the last certificate in the ordered set where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching certificate, or <code>null</code> if a matching certificate could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate fetchByClassNameAndClassPK_Last(
		java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate[] findByClassNameAndClassPK_PrevAndNext(
		long certificateId, java.lang.String className, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Removes all the certificates where className = &#63; and classPK = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassNameAndClassPK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of certificates where className = &#63; and classPK = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @return the number of matching certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassNameAndClassPK(java.lang.String className,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the certificates where className = &#63; and classPK = &#63; and certificateType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param certificateType the certificate type
	* @return the matching certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByClassNameClassPKAndCertificateType(
		java.lang.String className, long classPK,
		java.lang.String certificateType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByClassNameClassPKAndCertificateType(
		java.lang.String className, long classPK,
		java.lang.String certificateType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findByClassNameClassPKAndCertificateType(
		java.lang.String className, long classPK,
		java.lang.String certificateType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate findByClassNameClassPKAndCertificateType_First(
		java.lang.String className, long classPK,
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

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
	public vn.com.ecopharma.emp.model.Certificate fetchByClassNameClassPKAndCertificateType_First(
		java.lang.String className, long classPK,
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate findByClassNameClassPKAndCertificateType_Last(
		java.lang.String className, long classPK,
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

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
	public vn.com.ecopharma.emp.model.Certificate fetchByClassNameClassPKAndCertificateType_Last(
		java.lang.String className, long classPK,
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public vn.com.ecopharma.emp.model.Certificate[] findByClassNameClassPKAndCertificateType_PrevAndNext(
		long certificateId, java.lang.String className, long classPK,
		java.lang.String certificateType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Removes all the certificates where className = &#63; and classPK = &#63; and certificateType = &#63; from the database.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param certificateType the certificate type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassNameClassPKAndCertificateType(
		java.lang.String className, long classPK,
		java.lang.String certificateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of certificates where className = &#63; and classPK = &#63; and certificateType = &#63;.
	*
	* @param className the class name
	* @param classPK the class p k
	* @param certificateType the certificate type
	* @return the number of matching certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassNameClassPKAndCertificateType(
		java.lang.String className, long classPK,
		java.lang.String certificateType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the certificate in the entity cache if it is enabled.
	*
	* @param certificate the certificate
	*/
	public void cacheResult(vn.com.ecopharma.emp.model.Certificate certificate);

	/**
	* Caches the certificates in the entity cache if it is enabled.
	*
	* @param certificates the certificates
	*/
	public void cacheResult(
		java.util.List<vn.com.ecopharma.emp.model.Certificate> certificates);

	/**
	* Creates a new certificate with the primary key. Does not add the certificate to the database.
	*
	* @param certificateId the primary key for the new certificate
	* @return the new certificate
	*/
	public vn.com.ecopharma.emp.model.Certificate create(long certificateId);

	/**
	* Removes the certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param certificateId the primary key of the certificate
	* @return the certificate that was removed
	* @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate remove(long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	public vn.com.ecopharma.emp.model.Certificate updateImpl(
		vn.com.ecopharma.emp.model.Certificate certificate)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the certificate with the primary key or throws a {@link vn.com.ecopharma.emp.NoSuchCertificateException} if it could not be found.
	*
	* @param certificateId the primary key of the certificate
	* @return the certificate
	* @throws vn.com.ecopharma.emp.NoSuchCertificateException if a certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate findByPrimaryKey(
		long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			vn.com.ecopharma.emp.NoSuchCertificateException;

	/**
	* Returns the certificate with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param certificateId the primary key of the certificate
	* @return the certificate, or <code>null</code> if a certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public vn.com.ecopharma.emp.model.Certificate fetchByPrimaryKey(
		long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the certificates.
	*
	* @return the certificates
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<vn.com.ecopharma.emp.model.Certificate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the certificates from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of certificates.
	*
	* @return the number of certificates
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}