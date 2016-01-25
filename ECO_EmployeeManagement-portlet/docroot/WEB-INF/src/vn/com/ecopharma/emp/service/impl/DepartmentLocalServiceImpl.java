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

import vn.com.ecopharma.emp.NoSuchDepartmentException;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.service.base.DepartmentLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the department local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.DepartmentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.DepartmentLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil
 */
public class DepartmentLocalServiceImpl extends DepartmentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil} to access the
	 * department local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(DepartmentLocalServiceImpl.class);

	@Override
	public List<Department> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<Department> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	@Override
	public Department findByNameAndDevision(String name, long devisionId) {
		try {
			return departmentPersistence.fetchByNameAndDevision(name,
					devisionId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public List<Department> findByDevision(long devisionId) {
		try {
			return departmentPersistence.findByDevision(devisionId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Department> findByDevisions(List<Devision> devisions) {
		if (devisions == null)
			return new ArrayList<>();
		final List<Department> departments = new ArrayList<>();
		for (Devision devision : devisions) {
			List<Department> departmentsByDevision = findByDevision(devision
					.getDevisionId());
			departments.addAll(departmentsByDevision);
		}
		return departments;
	}

	@Override
	public List<Department> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return departmentPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public Department createPrePersistedDepartment() {
		try {
			return super.createDepartment(counterLocalService.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Department addDepartment(String name, long devisionId,
			ServiceContext serviceContext) {
		try {
			Department department = departmentPersistence
					.create(counterLocalService.increment());
			department.setName(name);
			department.setDevisionId(devisionId);
			department.setGroupId(serviceContext.getScopeGroupId());
			department.setCompanyId(serviceContext.getCompanyId());
			department.setUserId(serviceContext.getUserId());
			department.setCreateDate(new Date());
			department.setModifiedDate(new Date());

			department = super.addDepartment(department);

			// add permission
			resourceLocalService.addResources(department.getCompanyId(),
					department.getGroupId(), serviceContext.getUserId(),
					Department.class.getName(), department.getDepartmentId(),
					false, true, true);
			return department;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Department addDepartment(Department department,
			ServiceContext serviceContext) {
		try {
			department.setGroupId(serviceContext.getScopeGroupId());
			department.setCompanyId(serviceContext.getCompanyId());
			department.setUserId(serviceContext.getUserId());
			department.setCreateDate(new Date());
			department.setModifiedDate(new Date());

			department = super.addDepartment(department);// NOSONAR

			// add permission
			resourceLocalService.addResources(department.getCompanyId(),
					department.getGroupId(), serviceContext.getUserId(),
					Department.class.getName(), department.getDepartmentId(),
					false, true, true);
			return department;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public void completelyRemoveAll() {
		for (Department department : findAll()) {
			try {
				departmentPersistence.remove(department.getDepartmentId());
			} catch (NoSuchDepartmentException e) {
				LOGGER.info(e);
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
	}
}