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

package vn.com.ecopharma.emp.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vn.com.ecopharma.emp.model.Certificate;
import vn.com.ecopharma.emp.service.base.CertificateLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the certificate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.CertificateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.CertificateLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.CertificateLocalServiceUtil
 */
public class CertificateLocalServiceImpl extends
		CertificateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.CertificateLocalServiceUtil} to access the
	 * certificate local service.
	 */

	@Override
	public List<Certificate> findAll() {
		return this.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<Certificate> findAll(int start, int end) {
		return this.findAll(start, end, null);
	}

	@Override
	public List<Certificate> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return certificatePersistence
					.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			infoLevelLog("Fetch all Certificate failed", e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Certificate> findByType(String type) {
		try {
			return certificatePersistence.findByCertificateType(type);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(CertificateLocalServiceImpl.class).info(
					"Error while fetching by type", e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Certificate> findByClassNameAndClassPK(String className,
			long classPK) {
		try {
			return certificatePersistence.findByClassNameAndClassPK(className,
					classPK);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(CertificateLocalServiceImpl.class).info(
					"Error while fetching by Class Name & Class PK", e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Certificate> findByClassNameClassPKAndType(String className,
			long classPK, String type) {
		try {
			return certificatePersistence
					.findByClassNameClassPKAndCertificateType(className,
							classPK, type);
		} catch (SystemException e) {
			infoLevelLog("Error while fetching by Class Name, Class PK & Type",
					e);
		}
		return new ArrayList<>();
	}

	@Override
	public Certificate createPrePersistedCertificate(
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			final Certificate certificate = certificatePersistence.create(id);
			certificate.setCompanyId(serviceContext.getCompanyId());
			certificate.setGroupId(serviceContext.getScopeGroupId());
			certificate.setUserId(serviceContext.getUserId());
			certificate.setCreateDate(new Date());

			return certificate;
		} catch (SystemException e) {
			infoLevelLog("Create Pre Persisted Certificate failed", e);
		}

		return null;
	}

	@Override
	public Certificate addCertificate(String certificateType, String name,
			String specialize, long coursePlace, Date graduatedYear,
			String grade, String courseType, Date expiredDate,
			String issuedPlace, String note, ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			final Certificate certificate = certificatePersistence.create(id);

			certificate.setCompanyId(serviceContext.getCompanyId());
			certificate.setGroupId(serviceContext.getScopeGroupId());
			certificate.setUserId(serviceContext.getUserId());
			certificate.setCreateDate(new Date());
			certificate.setModifiedDate(new Date());

			certificate.setCertificateType(certificateType);
			certificate.setName(name);
			certificate.setSpecialize(specialize);
			certificate.setCoursePlace(coursePlace);
			certificate.setGraduatedYear(graduatedYear);
			certificate.setGrade(grade);
			certificate.setCourseType(courseType);
			certificate.setExpiredDate(expiredDate);
			certificate.setIssuedPlace(issuedPlace);
			certificate.setNote(note);

			return super.addCertificate(certificate);
		} catch (SystemException e) {
			infoLevelLog("Add Certificate failed", e);
		}
		return null;
	}

	@Override
	public Certificate addCertificate(Certificate certificate,
			String certificateType, String name, String specialize,
			long coursePlace, Date graduatedYear, String grade,
			String courseType, Date expiredDate, String issuedPlace,
			String note, ServiceContext serviceContext) {
		try {
			certificate.setModifiedDate(new Date());

			certificate.setCertificateType(certificateType);
			certificate.setName(name);
			certificate.setSpecialize(specialize);
			certificate.setCoursePlace(coursePlace);
			certificate.setGraduatedYear(graduatedYear);
			certificate.setGrade(grade);
			certificate.setCourseType(courseType);
			certificate.setExpiredDate(expiredDate);
			certificate.setIssuedPlace(issuedPlace);
			certificate.setNote(note);

			return super.addCertificate(certificate);
		} catch (SystemException e) {
			infoLevelLog("Add Certificate failed", e);
		}

		return null;
	}

	@Override
	public void infoLevelLog(String msg, Throwable e) {
		LogFactoryUtil.getLog(CertificateLocalServiceImpl.class).info(msg, e);
	}
}