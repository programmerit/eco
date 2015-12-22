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

package vn.com.ecopharma.hrm.rc.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.hrm.rc.model.Experience;
import vn.com.ecopharma.hrm.rc.service.base.ExperienceLocalServiceBaseImpl;

/**
 * The implementation of the experience local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.ExperienceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.ExperienceLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil
 */
public class ExperienceLocalServiceImpl extends ExperienceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil} to access the
	 * experience local service.
	 */

	public List<Experience> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<Experience> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Experience> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return experiencePersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Experience> findByClassNameAndClassPK(String className,
			long classPK) {
		try {
			return experiencePersistence.findByClassNameAndClassPK(className,
					classPK);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Experience> findByClassName(String className) {
		try {
			return experiencePersistence.findByClassName(className);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Experience createPrePersitedExperience(String className, long classPK) {
		try {
			final long id = counterLocalService.increment();
			final Experience experience = experiencePersistence.create(id);
			experience.setClassName(className);
			experience.setClassPK(classPK);
			return experience;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Experience addExperience(Experience experience,
			ServiceContext serviceContext) {
		try {
			experience.setCompanyId(serviceContext.getCompanyId());
			experience.setGroupId(serviceContext.getScopeGroupId());
			experience.setUserId(serviceContext.getUserId());
			experience.setCreateDate(new Date());
			experience.setModifiedDate(new Date());

			return experiencePersistence.update(experience);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Experience addExperience(String className, long classPK,
			String workingPlace, double yearsExperience, String description,
			ServiceContext serviceContext) {
		try {
			final long id = counterLocalService.increment();
			final Experience experience = experiencePersistence.create(id);
			experience.setClassName(className);
			experience.setClassPK(classPK);
			experience.setWorkingPlace(workingPlace);
			experience.setYearsExperience(yearsExperience);
			experience.setDescription(description);

			experience.setCompanyId(serviceContext.getCompanyId());
			experience.setGroupId(serviceContext.getScopeGroupId());
			experience.setUserId(serviceContext.getUserId());
			experience.setCreateDate(new Date());
			experience.setModifiedDate(new Date());

			return experiencePersistence.update(experience);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}