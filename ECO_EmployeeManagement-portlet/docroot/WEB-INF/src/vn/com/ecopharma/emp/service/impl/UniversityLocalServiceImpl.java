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

import vn.com.ecopharma.emp.NoSuchUniversityException;
import vn.com.ecopharma.emp.model.University;
import vn.com.ecopharma.emp.service.base.UniversityLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the university local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.UniversityLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.UniversityLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.UniversityLocalServiceUtil
 */
public class UniversityLocalServiceImpl extends UniversityLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.UniversityLocalServiceUtil} to access the
	 * university local service.
	 */

	public List<University> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<University> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<University> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return universityPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public University addUniversity(String name, String code, String tel_fax,
			ServiceContext serviceContext) throws SystemException {
		long id = counterLocalService.increment();
		University university = universityPersistence.create(id);
		university.setName(name);
		university.setCode(code);
		university.setTel_fax(tel_fax);
		
		university.setGroupId(serviceContext.getScopeGroupId());
		university.setCompanyId(serviceContext.getCompanyId());
		university.setUserId(serviceContext.getUserId());
		university = universityPersistence.update(university);
		return university;
	}

	public University findByName(String name) {
		try {
			return universityPersistence.fetchByName(name);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public University findByCode(String code) {
		try {
			return universityPersistence.findByCode(code);
		} catch (NoSuchUniversityException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}