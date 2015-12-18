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

import java.util.Date;
import java.util.List;

import vn.com.ecopharma.emp.model.Level;
import vn.com.ecopharma.emp.service.base.LevelLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the level local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.LevelLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.LevelLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.LevelLocalServiceUtil
 */
public class LevelLocalServiceImpl extends LevelLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.LevelLocalServiceUtil} to access the level
	 * local service.
	 */
	public List<Level> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Level> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	public List<Level> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return levelPersistence.findAll(start, end, orderByComparator);
	}

	public Level findByName(String name) {
		try {
			return levelPersistence.fetchByName(name);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Level addLevel(String name, int level, ServiceContext serviceContext) {

		try {
			final long id = counterLocalService.increment();
			Level l = levelPersistence.create(id);
			l.setName(name);
			l.setLevel(level);

			l.setCompanyId(serviceContext.getCompanyId());
			l.setGroupId(serviceContext.getScopeGroupId());
			l.setUserId(serviceContext.getUserId());
			l.setCreateDate(new Date());
			l.setModifiedDate(new Date());

			return l;
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return null;
	}
}