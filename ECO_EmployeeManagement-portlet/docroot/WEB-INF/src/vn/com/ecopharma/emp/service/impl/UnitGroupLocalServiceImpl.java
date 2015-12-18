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

import vn.com.ecopharma.emp.NoSuchUnitGroupException;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.base.UnitGroupLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the unit group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.UnitGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.UnitGroupLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil
 */
public class UnitGroupLocalServiceImpl extends UnitGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil} to access the
	 * unit group local service.
	 */

	@Override
	public List<UnitGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<UnitGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	@Override
	public List<UnitGroup> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return unitGroupPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<UnitGroup> findByUnit(long unitId) {
		try {
			return unitGroupPersistence.findByUnit(unitId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public UnitGroup findByNameAndUnit(String name, long unitId) {
		try {
			return unitGroupPersistence.fetchByNameAndUnit(name, unitId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public UnitGroup addUnitGroup(String name, long unitId,
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			final UnitGroup unitGroup = unitGroupPersistence.create(id);
			unitGroup.setName(name);
			unitGroup.setUnitId(unitId);

			unitGroup.setCreateDate(new Date());
			unitGroup.setModifiedDate(new Date());
			unitGroup.setUserId(serviceContext.getUserId());
			unitGroup.setGroupId(serviceContext.getScopeGroupId());
			unitGroup.setCompanyId(serviceContext.getCompanyId());
			return super.addUnitGroup(unitGroup);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public UnitGroup addUnitGroup(UnitGroup unitGroup,
			ServiceContext serviceContext) {
		try {
			unitGroup.setCreateDate(new Date());
			unitGroup.setModifiedDate(new Date());
			unitGroup.setUserId(serviceContext.getUserId());
			unitGroup.setGroupId(serviceContext.getScopeGroupId());
			unitGroup.setCompanyId(serviceContext.getCompanyId());
			return super.addUnitGroup(unitGroup);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
		}
		return null;
	}

	public void completelyRemoveAll() {
		for (UnitGroup unitGroup : findAll()) {
			try {
				unitGroupPersistence.remove(unitGroup.getUnitId());
			} catch (NoSuchUnitGroupException e) {
				LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
			} catch (SystemException e) {
				LogFactoryUtil.getLog(UnitGroupLocalServiceImpl.class).info(e);
			}
		}
	}

}