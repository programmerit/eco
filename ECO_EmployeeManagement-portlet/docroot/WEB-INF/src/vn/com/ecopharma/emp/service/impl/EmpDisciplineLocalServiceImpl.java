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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.service.base.EmpDisciplineLocalServiceBaseImpl;

/**
 * The implementation of the emp discipline local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpDisciplineLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpDisciplineLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil
 */
public class EmpDisciplineLocalServiceImpl extends
		EmpDisciplineLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil} to access the
	 * emp discipline local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpDisciplineLocalServiceImpl.class);

	public List<EmpDiscipline> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpDiscipline> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpDiscipline> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empDisciplinePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpDiscipline createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			final long id = counterLocalService.increment();
			EmpDiscipline obj = empDisciplinePersistence.create(id);

			obj.setCompanyId(serviceContext.getCompanyId());
			obj.setGroupId(serviceContext.getScopeGroupId());
			obj.setUserId(serviceContext.getUserId());
			obj.setCreateDate(new Date());

			return obj;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}
	
	public EmpDiscipline addEmpDiscipline(EmpDiscipline prePersistedObj, ServiceContext serviceContext) {
		
	}
}