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
import java.util.List;

import vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException;
import vn.com.ecopharma.emp.enumeration.EmployeeNotifyType;
import vn.com.ecopharma.emp.model.EmpNotifyEmail;
import vn.com.ecopharma.emp.service.base.EmpNotifyEmailLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the emp notify email local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpNotifyEmailLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpNotifyEmailLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil
 */
public class EmpNotifyEmailLocalServiceImpl extends
		EmpNotifyEmailLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil} to access
	 * the emp notify email local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpNotifyEmailLocalServiceImpl.class);

	public List<EmpNotifyEmail> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpNotifyEmail> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpNotifyEmail> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empNotifyEmailPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public List<EmpNotifyEmail> findByStatus(String status) {
		try {
			return empNotifyEmailPersistence.findByStatus(status);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpNotifyEmail createPreperistedEntity() throws SystemException {
		return empNotifyEmailPersistence
				.create(counterLocalService.increment());
	}

	public EmpNotifyEmail createEmpNotifyEmail(long empId, String type,
			String status) {
		try {
			EmpNotifyEmail obj = createPreperistedEntity();
			obj.setEmpId(empId);
			obj.setNotifyType(type);
			obj.setStatus(status);
			return super.addEmpNotifyEmail(obj);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpNotifyEmail updateEmpNotifyEmail(long empNotifyEmailId,
			String status) {
		try {
			EmpNotifyEmail obj = fetchEmpNotifyEmail(empNotifyEmailId);
			obj.setStatus(status);
			return super.updateEmpNotifyEmail(obj);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpNotifyEmail updateSentMailNotify(long empNotifyEmailId) {
		return updateEmpNotifyEmail(empNotifyEmailId,
				EmployeeNotifyType.SENT.toString());
	}

	public void updateSentMailNotifications(List<EmpNotifyEmail> items) {
		for (EmpNotifyEmail item : items) {
			item.setStatus(EmployeeNotifyType.SENT.toString());
		}
	}

	public EmpNotifyEmail removeEmpNotifyEmail(long id) {
		try {
			return empNotifyEmailPersistence.remove(id);
		} catch (NoSuchEmpNotifyEmailException e) {
			LOGGER.info(e);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}
}