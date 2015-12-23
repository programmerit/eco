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

import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.service.base.EmpBankInfoLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the emp bank info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpBankInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpBankInfoLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil
 */
public class EmpBankInfoLocalServiceImpl extends
		EmpBankInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil} to access the
	 * emp bank info local service.
	 */

	@Override
	public List<EmpBankInfo> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empBankInfoPersistence
					.findAll(start, end, orderByComparator);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpBankInfoLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public List<EmpBankInfo> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	@Override
	public List<EmpBankInfo> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	
	public List<EmpBankInfo> findByEmp(long empId) {
		try {
			return empBankInfoPersistence.findByEmp(empId);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpBankInfoLocalServiceImpl.class).info(e);
		}
		return new ArrayList<>();
	}

	@Override
	public EmpBankInfo createPrePersistedEntity(long empId,
			String bankAccountNo, String bankName, String branchName) {
		try {
			final EmpBankInfo empBankInfo = empBankInfoPersistence
					.create(counterLocalService.increment());

			empBankInfo.setEmpId(empId);
			empBankInfo.setBankAccountNo(bankAccountNo);
			empBankInfo.setBankName(bankName);
			empBankInfo.setBranchName(branchName);

			return empBankInfo;
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpBankInfoLocalServiceImpl.class).info(e);
		}
		return null;
	}

	@Override
	public EmpBankInfo addEmpBankInfo(EmpBankInfo empBankInfo,
			ServiceContext serviceContext) {
		empBankInfo.setCreateDate(new Date());
		empBankInfo.setUserId(serviceContext.getUserId());
		empBankInfo.setCompanyId(serviceContext.getCompanyId());
		empBankInfo.setGroupId(serviceContext.getScopeGroupId());

		try {
			return super.addEmpBankInfo(empBankInfo);
		} catch (SystemException e) {
			LogFactoryUtil.getLog(EmpBankInfoLocalServiceImpl.class).info(e);
		}
		return null;
	}
	
}