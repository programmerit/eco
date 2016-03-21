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

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpLaborContract;
import vn.com.ecopharma.emp.service.base.EmpLaborContractLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the emp labor contract local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpLaborContractLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpLaborContractLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpLaborContractLocalServiceUtil
 */
public class EmpLaborContractLocalServiceImpl extends
		EmpLaborContractLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpLaborContractLocalServiceUtil} to access
	 * the emp labor contract local service.
	 */
	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpLaborContractLocalServiceImpl.class);

	public List<EmpLaborContract> findByEmp(long empId) {
		try {
			return empLaborContractPersistence.findByEmp(empId);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpLaborContract createPrePersistedEntity(
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			EmpLaborContract result = super.createEmpLaborContract(id);
			result.setCreateDate(new Date());
			result.setUserId(serviceContext.getUserId());
			result.setGroupId(serviceContext.getScopeGroupId());
			result.setCompanyId(serviceContext.getCompanyId());
			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpLaborContract addEmpLaborContract(
			EmpLaborContract empLaborContract, ServiceContext serviceContext) {
		try {
			if (empLaborContract.getLaborContractSignedDate() == null
					|| empLaborContract.getLaborContractSignedType() == null
					|| empLaborContract.getLaborContractSignedType().isEmpty())
				return null;
			return super.addEmpLaborContract(empLaborContract);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	/************** transfer info from emp **************/
	public void transferContractFromEmps(ServiceContext serviceContext) {
		for (Emp emp : empLocalService.findAll()) {
			if (emp.getLaborContractSignedDate() != null) {
				EmpLaborContract contract = createPrePersistedEntity(serviceContext);
				contract.setEmpId(emp.getEmpId());
				contract.setLaborContractSignedDate(emp
						.getLaborContractSignedDate());
				contract.setLaborContractExpiredDate(emp
						.getLaborContractExpiredDate());
				contract.setLaborContractSignedType(emp.getLaborContractType());
				contract.setSignedTimes(emp.getLaborContractSignedTime());
				contract.setLatest(true);
				this.addEmpLaborContract(contract, serviceContext);
			}
		}
	}

}