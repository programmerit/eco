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

import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.service.base.SpecializedLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the specialized local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.SpecializedLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.SpecializedLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil
 */
public class SpecializedLocalServiceImpl extends
		SpecializedLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil} to access the
	 * specialized local service.
	 */
	private static final Log LOGGER = LogFactoryUtil
			.getLog(SpecializedLocalServiceImpl.class);

	public List<Specialized> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return specializedPersistence
					.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Specialized> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<Specialized> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public Specialized findByName(String name) {
		try {
			return specializedPersistence.fetchByName(name);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Specialized createPreperistedEntity(ServiceContext serviceContext) {

		try {
			long id = counterLocalService.increment();
			Specialized obj = specializedPersistence.create(id);
			obj.setCreateDate(new Date());
			obj.setCompanyId(serviceContext.getCompanyId());
			obj.setGroupId(serviceContext.getScopeGroupId());
			obj.setUserId(serviceContext.getUserId());
			return obj;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Specialized createSpecialized(Specialized preObj, String code,
			String name, int level, long parentId, boolean isUniversity,
			boolean isCollege, boolean isVocationalCollege, boolean isVocational) {
		preObj.setSpecializedCode(code);
		preObj.setName(name);
		preObj.setLevel(level);
		preObj.setParentId(parentId);
		preObj.setUniversity(isUniversity);
		preObj.setCollege(isCollege);
		preObj.setVocationalCollege(isVocationalCollege);
		preObj.setVocational(isVocational);
		try {
			return super.addSpecialized(preObj);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public Specialized createSpecialized(String code, String name, int level,
			long parentId, boolean isUniversity, boolean isCollege,
			boolean isVocationalCollege, boolean isVocational,
			ServiceContext serviceContext) {
		final Specialized preObj = createPreperistedEntity(serviceContext);
		return createSpecialized(preObj, code, name, level, parentId,
				isUniversity, isCollege, isVocationalCollege, isVocational);
	}

	public List<Specialized> findByLevel(int level) {
		try {
			return specializedPersistence.findByLevel(level);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Specialized> findFirstLevelList() {
		return findByLevel(1);
	}

	public List<Specialized> findByLevelAndParent(int level, long parentId) {
		try {
			return specializedPersistence.findByLevelAndParent(level, parentId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<Specialized> findSecondLevelList(long parentId) {
		return findByLevelAndParent(2, parentId);
	}

	public List<Specialized> findThirdLevelList(long parentId) {
		return findByLevelAndParent(3, parentId);
	}

}