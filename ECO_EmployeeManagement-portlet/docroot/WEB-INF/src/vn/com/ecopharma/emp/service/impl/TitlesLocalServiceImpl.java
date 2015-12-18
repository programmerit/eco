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

import vn.com.ecopharma.emp.NoSuchTitlesException;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.base.TitlesLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the titles local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.TitlesLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.TitlesLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.TitlesLocalServiceUtil
 */
public class TitlesLocalServiceImpl extends TitlesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.TitlesLocalServiceUtil} to access the titles
	 * local service.
	 */

	@Override
	public List<Titles> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Titles> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	@Override
	public List<Titles> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return titlesPersistence.findAll(start, end, orderByComparator);
	}

	@Override
	public Titles createTitles(String name, long unitGroupId, long unitId,
			long departmentId, ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			Titles titles = titlesPersistence.create(id);
			titles.setName(name);
			titles.setUnitGroupId(unitGroupId);
			titles.setUnitId(unitId);
			titles.setDepartmentId(departmentId);
			titles.setUserId(serviceContext.getUserId());
			titles.setCompanyId(serviceContext.getCompanyId());
			titles.setGroupId(serviceContext.getScopeGroupId());
			titles.setCreateDate(new Date());
			titles.setModifiedDate(new Date());

			return titlesPersistence.update(titles);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public List<Titles> findByUnit(long unitId) {
		try {
			return titlesPersistence.findByUnit(unitId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Titles findByNameAndUnit(String name, long unitId) {
		try {
			return titlesPersistence.findByNameAndUnit(name, unitId);
		} catch (NoSuchTitlesException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public List<Titles> findByUnitGroup(long unitGroupId) {
		try {
			return titlesPersistence.findByUnitGroup(unitGroupId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Titles findByNameAndUnitGroup(String name, long unitGroupId) {
		try {
			return titlesPersistence.findByNameAndUnitGroup(name, unitGroupId);
		} catch (NoSuchTitlesException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public List<Titles> findByDepartment(long departmentId) {
		try {
			return titlesPersistence.findByDepartment(departmentId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Titles findByNameAndDepartment(String name, long departmentId) {
		try {
			return titlesPersistence.fetchByNameAndDepartment(name,
					departmentId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * vn.com.ecopharma.emp.service.TitlesLocalService#findByNameAndRelatedEntities
	 * (vn.com.ecopharma.emp.model.Department, vn.com.ecopharma.emp.model.Unit,
	 * vn.com.ecopharma.emp.model.UnitGroup)
	 */
	@Override
	public List<Titles> findByNameAndRelatedEntities(Department department,
			Unit unit, UnitGroup unitGroup) {
		List<Titles> titlesList = null;
		try {
			if (department != null) {
				if (unitGroup != null) {
					titlesList = titlesPersistence.findByUnitGroup(unitGroup
							.getUnitGroupId());

				} else if (unit != null) {
					titlesList = titlesPersistence.findByUnit(unit.getUnitId());
				} else {
					titlesList = titlesPersistence.findByDepartment(department
							.getDepartmentId());
				}
			}
			return titlesList;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}

		return titlesList;
	}

	@Override
	public Titles findByName(String name) {
		try {
			return titlesPersistence.fetchByName(name);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public Titles findByNameAndRelatedFields(String name, long unitGroupId,
			long unitId, long departmentId) {
		try {
			return titlesPersistence.fetchByfindByNameAndRelatedFields(name,
					unitGroupId, unitId, departmentId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	public void completelyRemoveAll() {
		for (Titles titles : findAll()) {
			try {
				titlesPersistence.remove(titles.getTitlesId());
			} catch (NoSuchTitlesException e) {
				LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
			} catch (SystemException e) {
				LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
			}
		}
	}

}