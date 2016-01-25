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

import vn.com.ecopharma.emp.NoSuchUnitException;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.base.UnitLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the unit local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.UnitLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.UnitLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.UnitLocalServiceUtil
 */
public class UnitLocalServiceImpl extends UnitLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.UnitLocalServiceUtil} to access the unit
	 * local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(UnitLocalServiceImpl.class);

	@Override
	public List<Unit> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<Unit> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	@Override
	public List<Unit> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return unitPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Unit findByNameAndDepartment(String name, long departmentId) {
		try {
			return unitPersistence.fetchByNameAndDepartment(name, departmentId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public List<Unit> findByDepartment(long departmentId) {
		try {
			return unitPersistence.findByDepartment(departmentId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Unit> findByDepartments(List<Department> departments) {
		if (departments == null)
			return new ArrayList<>();

		final List<Unit> result = new ArrayList<>();
		for (Department department : departments) {
			result.addAll(findByDepartment(department.getDepartmentId()));
		}
		return result;
	}

	public Unit createPrePersistedUnit() {
		try {
			return super.createUnit(counterLocalService.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.ecopharma.emp.service.UnitLocalService#addUnit(java.lang.String,
	 * com.liferay.portal.service.ServiceContext)
	 */
	@Deprecated
	@Override
	public Unit addUnit(String name, ServiceContext serviceContext) {
		try {
			final Unit unit = unitPersistence.create(counterLocalService
					.increment());
			unit.setName(name);
			unit.setGroupId(serviceContext.getScopeGroupId());
			unit.setCompanyId(serviceContext.getCompanyId());
			unit.setUserId(serviceContext.getUserId());
			unit.setCreateDate(new Date());
			unit.setModifiedDate(new Date());

			return unitPersistence.update(unit);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Unit addUnit(String name, long departmentId,
			ServiceContext serviceContext) {
		try {
			Unit unit = unitPersistence.create(counterLocalService.increment());
			unit.setName(name);
			unit.setDepartmentId(departmentId);
			unit.setGroupId(serviceContext.getScopeGroupId());
			unit.setCompanyId(serviceContext.getCompanyId());
			unit.setUserId(serviceContext.getUserId());
			unit.setCreateDate(new Date());
			unit.setModifiedDate(new Date());

			unit = super.addUnit(unit);
			// add permission
			resourceLocalService.addResources(unit.getCompanyId(),
					unit.getGroupId(), serviceContext.getUserId(),
					Unit.class.getName(), unit.getUnitId(), false, true, true);
			return unit;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Unit addUnit(Unit unit, ServiceContext serviceContext) {
		try {
			unit.setGroupId(serviceContext.getScopeGroupId());
			unit.setCompanyId(serviceContext.getCompanyId());
			unit.setUserId(serviceContext.getUserId());
			unit.setCreateDate(new Date());
			unit.setModifiedDate(new Date());

			unit = super.addUnit(unit);
			// add permission
			resourceLocalService.addResources(unit.getCompanyId(),
					unit.getGroupId(), serviceContext.getUserId(),
					Unit.class.getName(), unit.getUnitId(), false, true, true);
			return unit;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public void completelyRemoveAll() {
		for (Unit unit : findAll()) {
			try {
				unitPersistence.remove(unit.getUnitId());
			} catch (NoSuchUnitException e) {
				LOGGER.info(e);
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
	}
}