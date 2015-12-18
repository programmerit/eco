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

import java.util.List;

import vn.com.ecopharma.emp.model.Location;
import vn.com.ecopharma.emp.service.base.LocationLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the location local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.LocationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.LocationLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.LocationLocalServiceUtil
 */
public class LocationLocalServiceImpl extends LocationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.LocationLocalServiceUtil} to access the
	 * location local service.
	 */

	public List<Location> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Location> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	public List<Location> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return locationPersistence.findAll(start, end, orderByComparator);
	}

	public List<Location> findByType(String type) {
		try {
			return locationPersistence.findByType(type);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}