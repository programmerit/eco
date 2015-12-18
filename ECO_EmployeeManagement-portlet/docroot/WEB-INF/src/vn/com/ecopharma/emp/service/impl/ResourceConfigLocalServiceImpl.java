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

import vn.com.ecopharma.emp.model.ResourceConfig;
import vn.com.ecopharma.emp.service.base.ResourceConfigLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the resource config local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.ResourceConfigLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.ResourceConfigLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.ResourceConfigLocalServiceUtil
 */
public class ResourceConfigLocalServiceImpl extends
		ResourceConfigLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.ResourceConfigLocalServiceUtil} to access
	 * the resource config local service.
	 */

	public List<ResourceConfig> findAll() {
		try {
			return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ResourceConfig> findAll(int start, int end)
			throws SystemException {
		return findAll(start, end, null);
	}

	public List<ResourceConfig> findAll(int start, int end,
			OrderByComparator orderByComparator) throws SystemException {
		return resourceConfigPersistence.findAll(start, end, orderByComparator);
	}

	public List<ResourceConfig> findByType(String type) {
		try {
			return resourceConfigPersistence.findByType(type);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResourceConfig findByKeyAndType(String key, String type) {
		try {
			return resourceConfigPersistence.fetchByKeyAndType(key, type);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ResourceConfig findByKey(String key) {
		try {
			return resourceConfigPersistence.fetchByKey(key);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}