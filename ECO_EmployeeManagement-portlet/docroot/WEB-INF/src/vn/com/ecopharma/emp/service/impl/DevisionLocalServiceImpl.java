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

import vn.com.ecopharma.emp.NoSuchDevisionException;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.service.base.DevisionLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the devision local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.DevisionLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.DevisionLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.DevisionLocalServiceUtil
 */
public class DevisionLocalServiceImpl extends DevisionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.DevisionLocalServiceUtil} to access the
	 * devision local service.
	 */

	@Override
	public List<Devision> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	@Override
	public List<Devision> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	@Override
	public List<Devision> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return devisionPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public Devision addDevision(String name, ServiceContext serviceContext) {
		try {
			Devision devision = devisionPersistence.create(counterLocalService
					.increment());
			devision.setName(name);
			devision.setGroupId(serviceContext.getScopeGroupId());
			devision.setCompanyId(serviceContext.getCompanyId());
			devision.setUserId(serviceContext.getUserId());
			devision.setCreateDate(new Date());
			devision.setModifiedDate(new Date());

			devision = super.addDevision(devision);
			// add permission
			resourceLocalService.addResources(devision.getCompanyId(),
					devision.getGroupId(), serviceContext.getUserId(),
					Devision.class.getName(), devision.getDevisionId(), false,
					true, true);
			return devision;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public Devision addDevision(Devision devision, ServiceContext serviceContext) {
		try {
			devision.setGroupId(serviceContext.getScopeGroupId());
			devision.setCompanyId(serviceContext.getCompanyId());
			devision.setUserId(serviceContext.getUserId());
			devision.setCreateDate(new Date());
			devision.setModifiedDate(new Date());

			devision = super.addDevision(devision);// NOSONAR
			// add permission
			resourceLocalService.addResources(devision.getCompanyId(),
					devision.getGroupId(), serviceContext.getUserId(),
					Devision.class.getName(), devision.getDevisionId(), false,
					true, true);
			return devision;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		} catch (PortalException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public Devision findByName(String name) {
		try {
			return devisionPersistence.findByName(name);
		} catch (NoSuchDevisionException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
		}
		return null;
	}

	public void completelyDeleteAll() {
		for (Devision devision : findAll()) {
			try {
				devisionPersistence.remove(devision.getDevisionId());
			} catch (NoSuchDevisionException e) {
				LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
			} catch (SystemException e) {
				LogFactoryUtil.getLog(DevisionLocalServiceImpl.class).info(e);
			}
		}
	}
}