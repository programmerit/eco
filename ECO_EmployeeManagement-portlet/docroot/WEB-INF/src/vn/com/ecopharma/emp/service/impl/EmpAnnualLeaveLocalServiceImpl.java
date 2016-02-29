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

import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.service.base.EmpAnnualLeaveLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the emp annual leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpAnnualLeaveLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil
 */
public class EmpAnnualLeaveLocalServiceImpl extends
		EmpAnnualLeaveLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil} to access
	 * the emp annual leave local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpAnnualLeaveLocalServiceImpl.class);

	public List<EmpAnnualLeave> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpAnnualLeave> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpAnnualLeave> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empAnnualLeavePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpAnnualLeave createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			EmpAnnualLeave obj = empAnnualLeavePersistence.create(id);

			obj.setCreateDate(new Date());
			obj.setUserId(serviceContext.getUserId());
			obj.setGroupId(serviceContext.getScopeGroupId());
			obj.setCompanyId(serviceContext.getCompanyId());

			return obj;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpAnnualLeave addEmpAnnualLeave(EmpAnnualLeave prePersistedEntity,
			long empId, double numberOfLeave) {

		prePersistedEntity.setEmpId(empId);
		prePersistedEntity.setNoOfAnualLeave(numberOfLeave);

		try {
			EmpAnnualLeave result = super.addEmpAnnualLeave(prePersistedEntity);
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpAnnualLeave addEmpAnnualLeave(long empId, double numberOfLeave,
			ServiceContext serviceContext) {
		return addEmpAnnualLeave(empId, numberOfLeave, serviceContext);
	}

}