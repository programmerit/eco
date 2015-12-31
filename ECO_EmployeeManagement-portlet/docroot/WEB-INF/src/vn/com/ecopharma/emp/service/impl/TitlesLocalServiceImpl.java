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
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.base.TitlesLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
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

	private static final Log LOGGER = LogFactoryUtil
			.getLog(TitlesLocalServiceImpl.class);

	@Override
	public List<Titles> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			LOGGER.info(e);
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
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public List<Titles> findByUnit(long unitId) {
		try {
			return titlesPersistence.findByUnit(unitId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Titles> findByUnitAndNullUnitGroup(long unitId) {
		try {
			return titlesPersistence.findByUnitAndUnitGroup(unitId, 0);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Titles findByNameAndUnit(String name, long unitId) {
		try {
			return titlesPersistence.findByNameAndUnit(name, unitId);
		} catch (NoSuchTitlesException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public List<Titles> findByUnitGroup(long unitGroupId) {
		try {
			return titlesPersistence.findByUnitGroup(unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Titles findByNameAndUnitGroup(String name, long unitGroupId) {
		try {
			return titlesPersistence.findByNameAndUnitGroup(name, unitGroupId);
		} catch (NoSuchTitlesException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public List<Titles> findByDepartment(long departmentId) {
		try {
			return titlesPersistence.findByDepartment(departmentId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Titles findByNameAndDepartment(String name, long departmentId) {
		try {
			return titlesPersistence.fetchByNameAndDepartment(name,
					departmentId);
		} catch (SystemException e) {
			LOGGER.info(e);
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
	public List<Titles> findByRelatedEntities(Department department, Unit unit,
			UnitGroup unitGroup) {
		long departmentId = department != null ? department.getDepartmentId()
				: 0L;
		long unitId = unit != null ? unit.getUnitId() : 0L;
		long unitGroupId = unitGroup != null ? unitGroup.getUnitGroupId() : 0L;
		return findByRelatedEntities(unitGroupId, unitId, departmentId);
	}

	public List<Titles> findByRelatedEntities(long departmentId, long unitId,
			long unitGroupId) {
		try {
			return titlesPersistence.findByUnitGroupUnitDepartment(unitGroupId,
					unitId, departmentId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<Titles> findFilterTitlesByRelatedEntities(
			Department department, Unit unit, UnitGroup unitGroup) {
		List<Titles> titlesList = new ArrayList<>();
		try {
			if (department != null) {
				long departmentId = department.getDepartmentId();
				if (unit != null) {
					long unitId = unit.getUnitId();
					if (unitGroup != null) { // NOSONAR
						long unitGroupId = unitGroup.getUnitGroupId();
						return titlesPersistence.findByUnitGroupUnitDepartment(
								unitGroupId, unitId, departmentId);
					} else {
						return eliminateSameNameTitles(titlesPersistence
								.findByUnit(unitId));
					}
				} else {
					return eliminateSameNameTitles(titlesPersistence
							.findByDepartment(department.getDepartmentId()));
				}
			}

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

	public Titles createPrePersistedTitles() {
		try {
			return super.createTitles(counterLocalService.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Titles updateTitles(Titles titles, long unitGroupId, long unitId,
			long departmentId) {
		try {
			titles.setUnitGroupId(unitGroupId);
			titles.setUnitId(unitId);
			titles.setDepartmentId(departmentId);

			titles.setModifiedDate(new Date());

			return super.updateTitles(titles);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Titles updateTitles(Titles titles) throws SystemException {
		final Titles result = super.updateTitles(titles);
		if (result != null) {
			final List<Emp> emps = empLocalService.findByTitles(result
					.getTitlesId());
			for (Emp emp : emps) {
				empLocalService.updateEmp(emp);
			}
		}
		return result;
	}

	@Override
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

	private static List<Titles> eliminateSameNameTitles(List<Titles> titlesList) {
		final List<String> names = new ArrayList<>();
		final List<Titles> result = new ArrayList<>();
		for (Titles titles : titlesList) {
			if (!names.contains(titles.getName())) {
				names.add(titles.getName());
				result.add(titles);
			}
		}
		return result;
	}

}