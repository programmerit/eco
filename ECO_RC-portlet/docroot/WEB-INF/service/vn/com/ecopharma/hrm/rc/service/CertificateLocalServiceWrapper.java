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

package vn.com.ecopharma.hrm.rc.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CertificateLocalService}.
 *
 * @author tvt
 * @see CertificateLocalService
 * @generated
 */
public class CertificateLocalServiceWrapper implements CertificateLocalService,
	ServiceWrapper<CertificateLocalService> {
	public CertificateLocalServiceWrapper(
		CertificateLocalService certificateLocalService) {
		_certificateLocalService = certificateLocalService;
	}

	/**
	* Adds the certificate to the database. Also notifies the appropriate model listeners.
	*
	* @param certificate the certificate
	* @return the certificate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate addCertificate(
		vn.com.ecopharma.hrm.rc.model.Certificate certificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.addCertificate(certificate);
	}

	/**
	* Creates a new certificate with the primary key. Does not add the certificate to the database.
	*
	* @param certificateId the primary key for the new certificate
	* @return the new certificate
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate createCertificate(
		long certificateId) {
		return _certificateLocalService.createCertificate(certificateId);
	}

	/**
	* Deletes the certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param certificateId the primary key of the certificate
	* @return the certificate that was removed
	* @throws PortalException if a certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate deleteCertificate(
		long certificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.deleteCertificate(certificateId);
	}

	/**
	* Deletes the certificate from the database. Also notifies the appropriate model listeners.
	*
	* @param certificate the certificate
	* @return the certificate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate deleteCertificate(
		vn.com.ecopharma.hrm.rc.model.Certificate certificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.deleteCertificate(certificate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _certificateLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate fetchCertificate(
		long certificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.fetchCertificate(certificateId);
	}

	/**
	* Returns the certificate with the primary key.
	*
	* @param certificateId the primary key of the certificate
	* @return the certificate
	* @throws PortalException if a certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate getCertificate(
		long certificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.getCertificate(certificateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link vn.com.ecopharma.hrm.rc.model.impl.CertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of certificates
	* @param end the upper bound of the range of certificates (not inclusive)
	* @return the range of certificates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Certificate> getCertificates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.getCertificates(start, end);
	}

	/**
	* Returns the number of certificates.
	*
	* @return the number of certificates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCertificatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.getCertificatesCount();
	}

	/**
	* Updates the certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param certificate the certificate
	* @return the certificate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate updateCertificate(
		vn.com.ecopharma.hrm.rc.model.Certificate certificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificateLocalService.updateCertificate(certificate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _certificateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_certificateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _certificateLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Certificate> findAll() {
		return _certificateLocalService.findAll();
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Certificate> findAll(
		int start, int end) {
		return _certificateLocalService.findAll(start, end);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Certificate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		return _certificateLocalService.findAll(start, end, orderByComparator);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Certificate> findByClassNameAndClassPK(
		java.lang.String className, long classPK) {
		return _certificateLocalService.findByClassNameAndClassPK(className,
			classPK);
	}

	@Override
	public java.util.List<vn.com.ecopharma.hrm.rc.model.Certificate> findByClassName(
		java.lang.String className) {
		return _certificateLocalService.findByClassName(className);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate createPrePersitedCertificate(
		java.lang.String className, long classPK) {
		return _certificateLocalService.createPrePersitedCertificate(className,
			classPK);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate addCertificate(
		vn.com.ecopharma.hrm.rc.model.Certificate certificate,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _certificateLocalService.addCertificate(certificate,
			serviceContext);
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate addCertificate(
		java.lang.String className, long classPK, java.lang.String name,
		java.lang.String certificateType, long universityId,
		com.liferay.portal.service.ServiceContext serviceContext) {
		return _certificateLocalService.addCertificate(className, classPK,
			name, certificateType, universityId, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CertificateLocalService getWrappedCertificateLocalService() {
		return _certificateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCertificateLocalService(
		CertificateLocalService certificateLocalService) {
		_certificateLocalService = certificateLocalService;
	}

	@Override
	public CertificateLocalService getWrappedService() {
		return _certificateLocalService;
	}

	@Override
	public void setWrappedService(
		CertificateLocalService certificateLocalService) {
		_certificateLocalService = certificateLocalService;
	}

	private CertificateLocalService _certificateLocalService;
}