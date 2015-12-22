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

package vn.com.ecopharma.hrm.rc.service.impl;

import java.util.Date;
import java.util.List;

import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.service.base.CertificateLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.CertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.CertificateLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil
 */
public class CertificateLocalServiceImpl extends
		CertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil} to access
	 * the certificate local service.
	 */
	public List<Certificate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Certificate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Certificate> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return certificatePersistence
					.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Certificate> findByClassNameAndClassPK(String className,
			long classPK) {
		try {
			return certificatePersistence.findByClassNameAndClassPK(className,
					classPK);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Certificate> findByClassName(String className) {
		try {
			return certificatePersistence.findByClassName(className);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Certificate createPrePersitedCertificate(String className,
			long classPK) {
		try {
			final long id = counterLocalService.increment();
			final Certificate c = certificatePersistence.create(id);
			c.setClassName(className);
			c.setClassPK(classPK);
			return c;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Certificate addCertificate(Certificate certificate,
			ServiceContext serviceContext) {
		try {
			certificate.setCompanyId(serviceContext.getCompanyId());
			certificate.setGroupId(serviceContext.getScopeGroupId());
			certificate.setUserId(serviceContext.getUserId());
			certificate.setCreateDate(new Date());
			certificate.setModifiedDate(new Date());

			return certificatePersistence.update(certificate);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Certificate addCertificate(String className, long classPK,
			String name, String certificateType, long universityId,
			ServiceContext serviceContext) {
		try {
			final long id = counterLocalService.increment();
			final Certificate certificate = certificatePersistence.create(id);
			certificate.setClassName(className);
			certificate.setClassPK(classPK);
			certificate.setName(name);
			certificate.setCertificateType(certificateType);
			certificate.setUniversityId(universityId);

			certificate.setCompanyId(serviceContext.getCompanyId());
			certificate.setGroupId(serviceContext.getScopeGroupId());
			certificate.setUserId(serviceContext.getUserId());
			certificate.setCreateDate(new Date());
			certificate.setModifiedDate(new Date());

			return certificatePersistence.update(certificate);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}