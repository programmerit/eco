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

import vn.com.ecopharma.emp.NoSuchTitlesUnitUnitGroupException;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.TitlesUnitUnitGroup;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.base.TitlesUnitUnitGroupLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the titles unit unit group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.TitlesUnitUnitGroupLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.TitlesUnitUnitGroupLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.TitlesUnitUnitGroupLocalServiceUtil
 */
public class TitlesUnitUnitGroupLocalServiceImpl extends
		TitlesUnitUnitGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.TitlesUnitUnitGroupLocalServiceUtil} to
	 * access the titles unit unit group local service.
	 */
	private static final Log LOGGER = LogFactoryUtil
			.getLog(TitlesUnitUnitGroupLocalServiceImpl.class);

	public List<TitlesUnitUnitGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<TitlesUnitUnitGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<TitlesUnitUnitGroup> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return titlesUnitUnitGroupPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public TitlesUnitUnitGroup findByTitlesUnitUnitGroup(long titlesId,
			long unitId, long unitGroupId) {
		try {
			return titlesUnitUnitGroupPersistence.fetchByTitlesUnitUnitGroup(
					titlesId, unitId, unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public TitlesUnitUnitGroup findByTitlesUnitUnitGroup(Titles titles,
			Unit unit, UnitGroup unitGroup) {
		if (titles == null || (unit == null && unitGroup == null))
			return null;
		long unitId = unit != null ? unit.getUnitId() : 0L;
		long unitGroupId = unitGroup != null ? unitGroup.getUnitGroupId() : 0L;
		return findByTitlesUnitUnitGroup(titles.getTitlesId(), unitId,
				unitGroupId);
	}

	public List<TitlesUnitUnitGroup> findByTitles(long titlesId) {
		try {
			return titlesUnitUnitGroupPersistence.findByTitles(titlesId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<TitlesUnitUnitGroup> findByTitles(Titles titles) {
		return titles != null ? findByTitles(titles.getTitlesId())
				: new ArrayList<TitlesUnitUnitGroup>();
	}

	public List<TitlesUnitUnitGroup> findByUnitAndNoneUnitGroup(long unitId) {
		try {
			return titlesUnitUnitGroupPersistence.findByUnitAndUnitGroup(
					unitId, 0);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<TitlesUnitUnitGroup> findByUnitAndNoneUnitGroup(Unit unit) {
		if (unit == null)
			return new ArrayList<>();
		return findByUnitAndNoneUnitGroup(unit.getUnitId());
	}

	public List<TitlesUnitUnitGroup> findByUnitGroup(UnitGroup unitGroup) {
		if (unitGroup == null)
			return new ArrayList<>();
		return findByUnitGroup(unitGroup.getUnitGroupId());
	}

	public List<TitlesUnitUnitGroup> findByUnitGroup(long unitGroupId) {
		try {
			return titlesUnitUnitGroupPersistence.findByUnitGroup(unitGroupId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public TitlesUnitUnitGroup addTitlesUnitUnitGroup(long titlesId,
			long unitGroupId, long unitId, ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			TitlesUnitUnitGroup o = titlesUnitUnitGroupPersistence.create(id);

			o.setTitlesId(titlesId);
			o.setUnitId(unitId);
			o.setUnitGroupId(unitGroupId);

			o.setCreateDate(new Date());
			o.setModifiedDate(new Date());
			o.setUserId(serviceContext.getUserId());
			o.setGroupId(serviceContext.getScopeGroupId());
			o.setCompanyId(serviceContext.getCompanyId());

			o = super.addTitlesUnitUnitGroup(o);

			return o;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public TitlesUnitUnitGroup addTitlesUnitUnitGroup(Titles titles, Unit unit,
			UnitGroup unitGroup, ServiceContext serviceContext) {
		if (titles == null || (unit == null && unitGroup == null))
			return null;

		long titlesId = titles.getTitlesId();
		long unitId = unit != null ? unit.getUnitId() : 0L;
		long unitGroupId = unitGroup != null ? unitGroup.getUnitGroupId() : 0L;
		return addTitlesUnitUnitGroup(titlesId, unitGroupId, unitId,
				serviceContext);
	}

	public void completelyRemoveAll() {
		for (TitlesUnitUnitGroup o : findAll()) {
			try {
				titlesUnitUnitGroupPersistence.remove(o
						.getTitlesUnitUnitGroupId());
			} catch (SystemException e) {
				LogFactoryUtil
						.getLog(TitlesUnitUnitGroupLocalServiceImpl.class)
						.info(e);
			} catch (NoSuchTitlesUnitUnitGroupException e) {
				LogFactoryUtil
						.getLog(TitlesUnitUnitGroupLocalServiceImpl.class)
						.info(e);
			}
		}
	}
}