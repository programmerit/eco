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

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

import vn.com.ecopharma.emp.model.EmployeeTitlesHistory;
import vn.com.ecopharma.emp.service.base.EmployeeTitlesHistoryLocalServiceBaseImpl;

/**
 * The implementation of the employee titles history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmployeeTitlesHistoryLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmployeeTitlesHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmployeeTitlesHistoryLocalServiceUtil
 */
public class EmployeeTitlesHistoryLocalServiceImpl extends
		EmployeeTitlesHistoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmployeeTitlesHistoryLocalServiceUtil} to
	 * access the employee titles history local service.
	 */

	public List<EmployeeTitlesHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmployeeTitlesHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmployeeTitlesHistory> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return employeeTitlesHistoryPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EmployeeTitlesHistory addEmployeeTitlesHistory(long employeeId,
			long titlesId, String note, java.util.Date set_date,
			ServiceContext serviceContext) throws SystemException {
		EmployeeTitlesHistory model = employeeTitlesHistoryPersistence
				.create(counterLocalService.increment());

		model.setEmployeeId(employeeId);
		model.setTitlesId(titlesId);
		model.setNote(note);
		model.setSetDate(set_date);

		model = employeeTitlesHistoryPersistence.update(model);

		return model;
	}
}