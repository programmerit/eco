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

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.EmpOrgRelationship;
import vn.com.ecopharma.emp.service.base.EmpOrgRelationshipLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the emp org relationship local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpOrgRelationshipLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil
 */
public class EmpOrgRelationshipLocalServiceImpl extends
		EmpOrgRelationshipLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil} to
	 * access the emp org relationship local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpOrgRelationshipLocalServiceImpl.class);

	public List<EmpOrgRelationship> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpOrgRelationship> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpOrgRelationship> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empOrgRelationshipPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<EmpOrgRelationship> findByEmp(long empId) {
		try {
			return empOrgRelationshipPersistence.findByEmp(empId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<EmpOrgRelationship> findByClassNameClassPK(String className,
			long classPK) {
		try {
			return empOrgRelationshipPersistence.findByClassNameClassPK(
					className, classPK);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpOrgRelationship fetchByClassNameClassPKHeadOfOrg(
			String className, long classPK, boolean isHeadOfOrg) {
		try {
			return empOrgRelationshipPersistence
					.fetchByClassNameClassPKHeadOfOrg(className, classPK,
							isHeadOfOrg);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpOrgRelationship fetchByEmpClassNameClassPKHeadOfOrg(long empId,
			String className, long classPK, boolean isHeadOfOrg) {
		try {
			return empOrgRelationshipPersistence
					.fetchByEmpClassNameClassPKHeadOfOrg(empId, className,
							classPK, isHeadOfOrg);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpOrgRelationship fetchByClassNameClassPKDeputyOfOrg(
			String className, long classPK, boolean isDeputyOfOrg) {
		try {
			return empOrgRelationshipPersistence
					.fetchByClassNameClassPKDeputyOfOrg(className, classPK,
							isDeputyOfOrg);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public boolean isHeadOfDepartment(long empId, long departmentId) {
		return fetchByEmpClassNameClassPKHeadOfOrg(empId,
				Department.class.getName(), departmentId, true) != null;
	}

	public EmpOrgRelationship createPrepersistedEntity(
			ServiceContext serviceContext) throws SystemException {
		long id = counterLocalService.increment();
		EmpOrgRelationship obj = empOrgRelationshipPersistence.create(id);
		obj.setCreateDate(new Date());
		obj.setCompanyId(serviceContext.getCompanyId());
		obj.setGroupId(serviceContext.getScopeGroupId());
		obj.setUserId(serviceContext.getUserId());
		return obj;
	}

	public EmpOrgRelationship addEmpOrgRelationship(long empId,
			String className, long classPK, boolean isHeadOfOrg,
			boolean isDeputyOfOrg, ServiceContext serviceContext) {
		try {
			final EmpOrgRelationship obj = createPrepersistedEntity(serviceContext);
			obj.setEmpId(empId);
			obj.setOrgClassName(className);
			obj.setOrgClassPK(classPK);
			obj.setHeadOfOrg(isHeadOfOrg);
			obj.setDeputyOfOrg(isDeputyOfOrg);
			return super.addEmpOrgRelationship(obj);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpOrgRelationship updateEmpOrgRelationship(
			long empOrgRelationshipId, long empId, ServiceContext serviceContext) {

		try {
			final EmpOrgRelationship empOrgRelationship = super
					.fetchEmpOrgRelationship(empOrgRelationshipId);
			return this.updateEmpOrgRelationship(empOrgRelationship, empId,
					serviceContext);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpOrgRelationship updateEmpOrgRelationship(
			EmpOrgRelationship empOrgRelationship, long empId,
			ServiceContext serviceContext) throws SystemException {
		empOrgRelationship.setEmpId(empId);
		empOrgRelationship.setModifiedDate(new Date());
		empOrgRelationship.setUserId(serviceContext.getUserId());

		return super.updateEmpOrgRelationship(empOrgRelationship);
	}
}