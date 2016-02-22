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

import vn.com.ecopharma.emp.enumeration.EmployeeStatus;
import vn.com.ecopharma.emp.enumeration.VacationLeaveType;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.base.VacationLeaveLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the vacation leave local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.VacationLeaveLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.VacationLeaveLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil
 */
public class VacationLeaveLocalServiceImpl extends
		VacationLeaveLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil} to access the
	 * vacation leave local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(VacationLeaveLocalServiceImpl.class);

	public List<VacationLeave> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<VacationLeave> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<VacationLeave> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return vacationLeavePersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public VacationLeave createPrePersistedEntity(ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			VacationLeave obj = vacationLeavePersistence.create(id);

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

	public VacationLeave addVacationLeave(VacationLeave prePersistedEntity,
			long empId, String leaveType, Date leaveFrom, Date leaveTo,
			Date actualTo, String reason, String description) {
		prePersistedEntity.setEmpId(empId);
		prePersistedEntity.setLeaveType(leaveType);
		prePersistedEntity.setLeaveFrom(leaveFrom);
		prePersistedEntity.setLeaveTo(leaveTo);
		prePersistedEntity.setActualTo(actualTo);
		prePersistedEntity.setReason(reason);
		prePersistedEntity.setDescription(description);
		try {
			VacationLeave result = super.addVacationLeave(prePersistedEntity);
			resourceLocalService.addResources(result.getCompanyId(),
					result.getGroupId(), result.getUserId(),
					VacationLeave.class.getName(), result.getVacationLeaveId(),
					false, true, true);

			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(VacationLeave.class.getName());

			indexer.reindex(VacationLeave.class.getName(),
					result.getVacationLeaveId());

			// set status to employee
			if (leaveType.equals(VacationLeaveType.MATERNITY.toString())) {
				Emp emp = empLocalService.fetchEmp(empId);
				emp.setStatus(EmployeeStatus.MATERNITY_LEAVE.toString());
				empLocalService.updateEmp(emp);
			}

			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public VacationLeave addVacationLeave(long empId, String leaveType,
			Date leaveFrom, Date leaveTo, Date actualTo, String reason,
			String description, ServiceContext serviceContext) {
		return addVacationLeave(createPrePersistedEntity(serviceContext),
				empId, leaveType, leaveFrom, leaveTo, actualTo, reason,
				description);
	}

}