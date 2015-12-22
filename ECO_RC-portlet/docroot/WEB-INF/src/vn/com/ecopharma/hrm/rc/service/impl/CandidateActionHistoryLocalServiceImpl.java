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

import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;
import vn.com.ecopharma.hrm.rc.service.base.CandidateActionHistoryLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the candidate action history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.CandidateActionHistoryLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalServiceUtil
 */
public class CandidateActionHistoryLocalServiceImpl extends
		CandidateActionHistoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalServiceUtil}
	 * to access the candidate action history local service.
	 */

	public List<CandidateActionHistory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<CandidateActionHistory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<CandidateActionHistory> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return candidateActionHistoryPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CandidateActionHistory> findByCandidate(long candidateId) {
		try {
			return candidateActionHistoryPersistence
					.findByCandidate(candidateId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CandidateActionHistory> findByCandidateAndActionType(
			long candidateId, String actionType) {
		try {
			return candidateActionHistoryPersistence
					.findByCandidateAndActionType(candidateId, actionType);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CandidateActionHistory> findByCandidateAndActionTypeAndAction(
			long candidateId, String actionType, String action) {
		try {
			return candidateActionHistoryPersistence
					.findByCandidateAndActionTypeAndAction(candidateId,
							actionType, action);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CandidateActionHistory createPrePersistedEntity() {
		try {
			long id = counterLocalService.increment();
			return candidateActionHistoryPersistence.create(id);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CandidateActionHistory createPrePersistedEntity(long candidateId,
			String action, String actionType, long executedBy,
			String description, ServiceContext serviceContext) {
		CandidateActionHistory candidateActionHistory = createPrePersistedEntity();
		candidateActionHistory.setCandidateId(candidateId);
		candidateActionHistory.setAction(action);
		candidateActionHistory.setActionType(actionType);
		candidateActionHistory.setExecutedBy(executedBy);
		candidateActionHistory.setDescription(description);
		candidateActionHistory.setDate(new Date(System.currentTimeMillis()));
		candidateActionHistory.setCreateDate(new Date(System
				.currentTimeMillis()));
		candidateActionHistory.setModifiedDate(new Date(System
				.currentTimeMillis()));
		candidateActionHistory.setUserId(serviceContext.getUserId());
		candidateActionHistory.setCompanyId(serviceContext.getCompanyId());
		candidateActionHistory.setGroupId(serviceContext.getScopeGroupId());

		return candidateActionHistory;
	}

	/*
	 * public CandidateActionHistory addCandidateActionHistory(long candidateId,
	 * String action, String actionType, long executedBy, String description,
	 * ServiceContext serviceContext) {
	 * 
	 * }
	 */

}