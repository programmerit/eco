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

import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule;
import vn.com.ecopharma.hrm.rc.service.base.EmployeeInterviewScheduleLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the employee interview schedule local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.EmployeeInterviewScheduleLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalServiceUtil
 */
public class EmployeeInterviewScheduleLocalServiceImpl extends
		EmployeeInterviewScheduleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma
	 * .hrm.rc.service.EmployeeInterviewScheduleLocalServiceUtil} to access the
	 * employee interview schedule local service.
	 */

	public List<EmployeeInterviewSchedule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmployeeInterviewSchedule> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmployeeInterviewSchedule> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return employeeInterviewSchedulePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EmployeeInterviewSchedule addEmployeeInterviewSchedule(
			EmployeeInterviewSchedule employeeInterviewSchedule,
			ServiceContext serviceContext) {
		employeeInterviewSchedule.setCompanyId(serviceContext.getCompanyId());
		employeeInterviewSchedule.setGroupId(serviceContext.getScopeGroupId());
		employeeInterviewSchedule.setUserId(serviceContext.getUserId());
		employeeInterviewSchedule.setCreateDate(new Date(System
				.currentTimeMillis()));
		employeeInterviewSchedule.setModifiedDate(new Date(System
				.currentTimeMillis()));
		try {
			return employeeInterviewScheduleLocalService
					.updateEmployeeInterviewSchedule(employeeInterviewSchedule);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EmployeeInterviewSchedule createPrePersitedEntity() {
		try {
			final long id = counterLocalService.increment();
			final EmployeeInterviewSchedule employeeInterviewSchedule = employeeInterviewSchedulePersistence
					.create(id);
			return employeeInterviewSchedule;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<EmployeeInterviewSchedule> findByInterviewSchedule(
			long interviewScheduleId) {
		try {
			return employeeInterviewSchedulePersistence
					.findByInterviewSchedule(interviewScheduleId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

}