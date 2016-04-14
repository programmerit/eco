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

import vn.com.ecopharma.emp.model.EmpActionHistory;
import vn.com.ecopharma.emp.service.base.EmpActionHistoryLocalServiceBaseImpl;

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
 * The implementation of the emp action history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.emp.service.EmpActionHistoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.base.EmpActionHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.emp.service.EmpActionHistoryLocalServiceUtil
 */
public class EmpActionHistoryLocalServiceImpl extends
		EmpActionHistoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.emp.service.EmpActionHistoryLocalServiceUtil} to access
	 * the emp action history local service.
	 */

	private static final Log LOGGER = LogFactoryUtil
			.getLog(EmpActionHistoryLocalServiceImpl.class);

	public List<EmpActionHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EmpActionHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EmpActionHistory> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return empActionHistoryPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return new ArrayList<>();
	}

	public EmpActionHistory createPrePersistedEntity(long empId, String action,
			long performedBy, String description, String status, long refId,
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			final EmpActionHistory empActionHistory = empActionHistoryPersistence
					.create(id);

			empActionHistory.setEmpId(empId);
			empActionHistory.setAction(action);
			empActionHistory.setPerformedBy(serviceContext.getUserId());
			empActionHistory.setDescription(description);
			empActionHistory.setStatus(status);
			empActionHistory.setRefId(refId);

			empActionHistory.setCreateDate(new Date());
			empActionHistory.setGroupId(serviceContext.getScopeGroupId());
			empActionHistory.setCompanyId(serviceContext.getCompanyId());
			empActionHistory.setUserId(serviceContext.getUserId());

			return empActionHistory;
		} catch (SystemException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpActionHistory addEmpActionHistory(EmpActionHistory actionHistory,
			ServiceContext serviceContext) {

		try {
			EmpActionHistory result = super.addEmpActionHistory(actionHistory);

			// add resource
			resourceLocalService.addResources(serviceContext.getCompanyId(),
					serviceContext.getScopeGroupId(),
					serviceContext.getUserId(),
					EmpActionHistory.class.getName(),
					result.getEmpActionHistoryId(), false, true, true);

			// indexing
			Indexer indexer = IndexerRegistryUtil
					.nullSafeGetIndexer(EmpActionHistory.class);
			indexer.reindex(result);

			return result;
		} catch (SystemException e) {
			LOGGER.info(e);
		} catch (PortalException e) {
			LOGGER.info(e);
		}
		return null;
	}

	public EmpActionHistory addEmpActionHistory(long empId, String action,
			long performedBy, String description, String status, long refId,
			ServiceContext serviceContext) {
		return addEmpActionHistory(this.createPrePersistedEntity(empId, action,
				performedBy, description, status, refId, serviceContext),
				serviceContext);
	}

}