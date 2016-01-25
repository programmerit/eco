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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import vn.com.ecopharma.emp.NoSuchTitlesException;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.base.TitlesLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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

	public List<Titles> findFilterListByRelatedFields(
			List<Department> departments, List<Unit> units,
			List<UnitGroup> unitGroups) {
		if (departments == null || departments.isEmpty())
			return new ArrayList<>();

		final Set<Titles> resultSet = new LinkedHashSet<>();

		if (units == null || units.isEmpty()) {
			for (Department department : departments) {
				resultSet.addAll(this.findAllByDepartment(department
						.getDepartmentId()));
			}
			return new ArrayList<>(resultSet);
		} else {
			if (unitGroups == null || unitGroups.isEmpty()) {
				for (Unit unit : units)
					resultSet.addAll(this.findAllByUnit(unit.getUnitId()));
				return new ArrayList<>(resultSet);
			}
			for (UnitGroup unitGroup : unitGroups)
				resultSet.addAll(this.findByUnitGroupOnly(unitGroup
						.getUnitGroupId()));
			return new ArrayList<>(resultSet);
		}
	}

	public Titles addTitles(String name, String name_en, String code,
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			Titles titles = titlesPersistence.create(id);
			titles.setName(name);
			titles.setName_en(name_en);
			titles.setCode(code);
			titles.setUserId(serviceContext.getUserId());
			titles.setCompanyId(serviceContext.getCompanyId());
			titles.setGroupId(serviceContext.getScopeGroupId());
			titles.setCreateDate(new Date());
			titles.setModifiedDate(new Date());

			return super.addTitles(titles);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Titles addTitles(Titles titles, ServiceContext serviceContext) {
		try {
			titles.setUserId(serviceContext.getUserId());
			titles.setCompanyId(serviceContext.getCompanyId());
			titles.setGroupId(serviceContext.getScopeGroupId());
			titles.setCreateDate(new Date());
			titles.setModifiedDate(new Date());

			return super.addTitles(titles);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public List<Titles> findByDepartmentUnitUnitGroup(long departmentId,
			long unitId, long unitGroupId) {
		try {
			final List<Titles> result = new ArrayList<>();
			final List<TitlesDepartmentUnitUnitGroup> list = titlesDepartmentUnitUnitGroupPersistence
					.findByDepartmentUnitUnitGroup(departmentId, unitId,
							unitGroupId);
			for (TitlesDepartmentUnitUnitGroup item : list) {
				result.add(super.fetchTitles(item.getTitlesId()));
			}
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Titles> findByUnitUnitGroup(long unitId, long unitGroupId) {
		try {
			final List<Titles> result = new ArrayList<>();
			final List<TitlesDepartmentUnitUnitGroup> list = titlesDepartmentUnitUnitGroupPersistence
					.findByUnitAndUnitGroup(unitId, unitGroupId);
			for (TitlesDepartmentUnitUnitGroup item : list) {
				result.add(super.fetchTitles(item.getTitlesId()));
			}
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Titles> findAllByDepartment(long departmentId) {
		return getUniqueTitlesListFromTitlesDepartmentUnitUnitGroups(titlesDepartmentUnitUnitGroupLocalService
				.findByDepartment(departmentId));
	}

	public List<Titles> findAllByUnit(long unitId) {
		return getUniqueTitlesListFromTitlesDepartmentUnitUnitGroups(titlesDepartmentUnitUnitGroupLocalService
				.findByUnit(unitId));
	}

	public List<Titles> findByDepartmentOnly(long departmentId) {
		return findByDepartmentUnitUnitGroup(departmentId, 0, 0);
	}

	public List<Titles> findByUnitOnly(long unitId) {
		return findByUnitUnitGroup(unitId, 0);
	}

	public List<Titles> findByUnitGroupOnly(long unitGroupId) {
		return getTitlesListFromTitlesDepartmentUnitUnitGroups(titlesDepartmentUnitUnitGroupLocalService
				.findByUnitGroup(unitGroupId));
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

	public Titles createPrePersistedTitles() {
		try {
			return super.createTitles(counterLocalService.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	@Override
	public Titles updateTitles(Titles titles) throws SystemException {
		titles.setModifiedDate(new Date());
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

	public Titles deleteTitles(Titles titles) {
		try {
			return super.deleteTitles(titles);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Titles deleteTitles(long titlesId) {
		try {
			return super.deleteTitles(titlesId);
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
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

	private List<Titles> getTitlesListFromTitlesDepartmentUnitUnitGroups(
			List<TitlesDepartmentUnitUnitGroup> list) {
		final List<Titles> result = new ArrayList<>();
		for (TitlesDepartmentUnitUnitGroup item : list) {
			try {
				result.add(super.fetchTitles(item.getTitlesId()));
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
		return result;
	}

	private List<Titles> getUniqueTitlesListFromTitlesDepartmentUnitUnitGroups(
			List<TitlesDepartmentUnitUnitGroup> list) {
		final List<Titles> result = new ArrayList<>();
		for (TitlesDepartmentUnitUnitGroup item : list) {
			try {
				Titles titles = super.fetchTitles(item.getTitlesId());
				if (!result.contains(titles))
					result.add(titles);
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
		return result;
	}
}