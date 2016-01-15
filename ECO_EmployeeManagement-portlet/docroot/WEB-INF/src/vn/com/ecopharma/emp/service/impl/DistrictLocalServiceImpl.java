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

import vn.com.ecopharma.emp.model.District;
import vn.com.ecopharma.emp.service.base.DistrictLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the district local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.DistrictLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.DistrictLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.DistrictLocalServiceUtil
 */
public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.DistrictLocalServiceUtil} to access the
	 * district local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(DistrictLocalServiceImpl.class);

	public List<District> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<District> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<District> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return districtPersistence.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<District> findByRegionCode(String regionCode) {
		try {
			return districtPersistence.findByRegionCode(regionCode);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public District addDistrict(String name, String regionCode,
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			final District district = districtPersistence.create(id);
			district.setName(name);
			district.setRegionCode(regionCode);

			district.setCreateDate(new Date());
			district.setModifiedDate(new Date());
			district.setGroupId(serviceContext.getScopeGroupId());
			district.setCompanyId(serviceContext.getCompanyId());
			district.setUserId(serviceContext.getUserId());

			return super.addDistrict(district);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public District findByRegionCodeAndName(String regionCode, String name) {
		try {
			District matchDistrict = districtPersistence
					.fetchByRegionCodeAndName(regionCode, name);
			if (matchDistrict == null && name.contains("'")) {
				LOGGER.info("INSIDE deep compare district's name");
				LOGGER.info("name before replace: " + name);
				name = name.replaceAll("'", "");
				LOGGER.info("name after replace: " + name);
				List<District> allRegionDistricts = this
						.findByRegionCode(regionCode);
				for (District district : allRegionDistricts) {
					LOGGER.info("name comparision: " + name + " vs "
							+ district.getName());
					if (district.getName().replaceAll("'", "")
							.equalsIgnoreCase(name)) {
						matchDistrict = district;
						break;
					}
				}
			}

			return matchDistrict;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}
}