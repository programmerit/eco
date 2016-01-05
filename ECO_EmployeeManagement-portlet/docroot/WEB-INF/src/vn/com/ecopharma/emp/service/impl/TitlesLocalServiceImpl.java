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
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.TitlesUnitUnitGroup;
import vn.com.ecopharma.emp.service.base.TitlesLocalServiceBaseImpl;
import vn.com.ecopharma.emp.service.persistence.TitlesFinderUtil;

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

	public Titles addTitles(String name, long departmentId, String name_en,
			String code, ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			Titles titles = titlesPersistence.create(id);
			titles.setName(name);
			titles.setName_en(name_en);
			titles.setCode(code);
			titles.setDepartmentId(departmentId);
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

	@Override
	public List<Titles> findByDepartment(long departmentId) {
		try {
			return titlesPersistence.findByDepartment(departmentId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Titles> findNoneUnitUnitGroupDependentTitlesListByDepartment(
			long departmentId) {
		List<Titles> result = new ArrayList<>();

		List<Titles> titlesListByDepartment = findByDepartment(departmentId);

		for (Titles titles : titlesListByDepartment) {
			if (titlesUnitUnitGroupLocalService.findByTitles(
					titles.getTitlesId()).isEmpty()) {
				result.add(titles);
			}
		}

		return result;
	}

	public List<Titles> findTitlesByUnit(long unitId) {
		List<Titles> result = new ArrayList<>();
		List<TitlesUnitUnitGroup> titlesUnitUnitGroups = titlesUnitUnitGroupLocalService
				.findByUnitAndNoneUnitGroup(unitId);
		for (TitlesUnitUnitGroup t : titlesUnitUnitGroups) {
			try {
				result.add(super.fetchTitles(t.getTitlesId()));
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
		return result;
	}

	public List<Titles> findTitlesByUnitGroup(long unitGroupId) {
		List<Titles> result = new ArrayList<>();
		List<TitlesUnitUnitGroup> titlesUnitUnitGroups = titlesUnitUnitGroupLocalService
				.findByUnitGroup(unitGroupId);
		for (TitlesUnitUnitGroup t : titlesUnitUnitGroups) {
			try {
				result.add(super.fetchTitles(t.getTitlesId()));
			} catch (SystemException e) {
				LOGGER.info(e);
			}
		}
		return result;
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
	public Titles findByName(String name) {
		try {
			return titlesPersistence.fetchByName(name);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return null;
	}

	// public List<Titles> findNoneUnitUnitGroupDependentTitlesListByDepartment(
	// long departmentId) {
	// return findNoneUnitUnitGroupDependentTitlesListByDepartment(
	// departmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	// }

	public List<Titles> findNoneUnitUnitGroupDependentTitlesListByDepartment(
			long departmentId, int start, int end) {
		try {
			return TitlesFinderUtil
					.findNoneUnitUnitGroupDependentTitlesListByDepartment(
							departmentId, start, end);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(TitlesLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	public Titles createPrePersistedTitles() {
		try {
			return super.createTitles(counterLocalService.increment());
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Titles updateTitles(Titles titles, long departmentId) {
		try {
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
}