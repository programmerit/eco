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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpConcurrentTitles;
import vn.com.ecopharma.emp.service.base.EmpConcurrentTitlesLocalServiceBaseImpl;

/**
 * The implementation of the emp concurrent titles local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpConcurrentTitlesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpConcurrentTitlesLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpConcurrentTitlesLocalServiceUtil
 */
public class EmpConcurrentTitlesLocalServiceImpl extends
		EmpConcurrentTitlesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpConcurrentTitlesLocalServiceUtil} to
	 * access the emp concurrent titles local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpConcurrentTitlesLocalServiceImpl.class);

	public List<EmpConcurrentTitles> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpConcurrentTitles> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpConcurrentTitles> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empConcurrentTitlesPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpConcurrentTitles createPrePersistedEntity(
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			EmpConcurrentTitles obj = empConcurrentTitlesPersistence.create(id);

			obj.setCreateDate(new Date());
			obj.setUserId(serviceContext.getUserId());
			obj.setGroupId(serviceContext.getScopeGroupId());
			obj.setCompanyId(serviceContext.getCompanyId());

			return obj;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpConcurrentTitles addConcurrentTitles(long empId, long titlesId,
			long departmentId, long unitGroupId, long unitId,
			ServiceContext serviceContext) {
		if (fetchByEmpAndTitles(empId, titlesId) != null)
			return null;
		try {
			final Emp emp = empLocalService.fetchEmp(empId);

			if (emp.getTitlesId() == titlesId)
				return null;

			EmpConcurrentTitles obj = createPrePersistedEntity(serviceContext);
			obj.setEmpId(empId);
			obj.setTitlesId(titlesId);
			obj.setDepartmentId(departmentId);

			obj.setUnitId(unitId);
			obj.setUnitGroupId(unitGroupId);

			return super.addEmpConcurrentTitles(obj);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpConcurrentTitles fetchByEmpAndTitles(long empId, long titlesId) {
		try {
			return empConcurrentTitlesPersistence.fetchByEmpTitles(empId,
					titlesId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public List<EmpConcurrentTitles> findByEmp(long empId) {
		try {
			return empConcurrentTitlesPersistence.findByEmp(empId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<EmpConcurrentTitles> findByTitles(long titlesId) {
		try {
			return empConcurrentTitlesPersistence.findByTitles(titlesId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

}