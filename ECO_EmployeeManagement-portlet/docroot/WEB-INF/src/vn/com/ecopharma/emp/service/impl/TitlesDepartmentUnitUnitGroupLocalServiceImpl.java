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

import vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.base.TitlesDepartmentUnitUnitGroupLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the titles department unit unit group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.TitlesDepartmentUnitUnitGroupLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil
 */
public class TitlesDepartmentUnitUnitGroupLocalServiceImpl extends
		TitlesDepartmentUnitUnitGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma
	 * .emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil} to access the
	 * titles department unit unit group local service.
	 */
	private static final Log LOGGER = LogFactoryUtil
			.getLog(TitlesDepartmentUnitUnitGroupLocalServiceImpl.class);

	public List<TitlesDepartmentUnitUnitGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<TitlesDepartmentUnitUnitGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<TitlesDepartmentUnitUnitGroup> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return titlesDepartmentUnitUnitGroupPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public TitlesDepartmentUnitUnitGroup addTitlesDepartmentUnitUnitGroup(
			long titlesId, long departmentId, long unitId, long unitGroupId,
			ServiceContext serviceContext) {
		try {
			TitlesDepartmentUnitUnitGroup o = titlesDepartmentUnitUnitGroupPersistence
					.create(counterLocalService.increment());

			o.setTitlesId(titlesId);
			o.setUnitGroupId(unitGroupId);
			o.setUnitId(unitId);
			o.setDepartmentId(departmentId);

			o.setCreateDate(new Date());
			o.setModifiedDate(new Date());
			o.setGroupId(serviceContext.getScopeGroupId());
			o.setCompanyId(serviceContext.getCompanyId());
			o.setUserId(serviceContext.getUserId());

			return super.addTitlesDepartmentUnitUnitGroup(o);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public TitlesDepartmentUnitUnitGroup addTitlesDepartmentUnitUnitGroup(
			Titles titles, Department department, Unit unit,
			UnitGroup unitGroup, ServiceContext serviceContext) {
		if (department == null)
			return null;
		long departmentId = department.getDepartmentId();
		long unitId = unit != null ? unit.getUnitId() : 0L;
		long unitGroupId = unitGroup != null ? unitGroup.getUnitGroupId() : 0L;

		return addTitlesDepartmentUnitUnitGroup(titles.getTitlesId(),
				departmentId, unitId, unitGroupId, serviceContext);
	}

	public TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
			long titlesId, long departmentId, long unitId, long unitGroupId) {
		try {
			return titlesDepartmentUnitUnitGroupPersistence
					.fetchByTitlesDepartmentUnitUnitGroup(titlesId,
							departmentId, unitId, unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public TitlesDepartmentUnitUnitGroup findByTitlesDepartmentUnitUnitGroup(
			Titles titles, Department department, Unit unit, UnitGroup unitGroup) {
		if (department == null)
			return null;
		long departmentId = department.getDepartmentId();
		long unitId = unit != null ? unit.getUnitId() : 0L;
		long unitGroupId = unitGroup != null ? unitGroup.getUnitGroupId() : 0L;
		long titlesId = titles.getTitlesId();
		return findByTitlesDepartmentUnitUnitGroup(titlesId, departmentId,
				unitId, unitGroupId);
	}

	public List<TitlesDepartmentUnitUnitGroup> findByDepartmentUnitUnitGroup(
			long departmentId, long unitId, long unitGroupId) {
		try {
			return titlesDepartmentUnitUnitGroupPersistence
					.findByDepartmentUnitUnitGroup(departmentId, unitId,
							unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<TitlesDepartmentUnitUnitGroup> findByUnitUnitGroup(long unitId,
			long unitGroupId) {
		try {
			return titlesDepartmentUnitUnitGroupPersistence
					.findByUnitAndUnitGroup(unitId, unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<TitlesDepartmentUnitUnitGroup> findByUnitGroup(long unitGroupId) {
		try {
			return titlesDepartmentUnitUnitGroupPersistence
					.findByUnitGroup(unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<TitlesDepartmentUnitUnitGroup> findByTitlesDepartmentUnitNoneUnitGroup(
			long titlesId, long departmentId, long unitId) {
		try {
			return titlesDepartmentUnitUnitGroupPersistence
					.findByTitlesDepartmentUnitNoneUnitGroup(titlesId,
							departmentId, unitId, 0L);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public void completelyRemoveAll() {
		for (TitlesDepartmentUnitUnitGroup item : findAll()) {
			try {
				titlesDepartmentUnitUnitGroupPersistence.remove(item
						.getTitlesDepartmentUnitUnitGroupId());
			} catch (NoSuchTitlesDepartmentUnitUnitGroupException e) {
				LOGGER.info(e);
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
	}
}