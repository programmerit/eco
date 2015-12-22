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

import java.util.List;

import vn.com.ecopharma.hrm.rc.model.CandidateEvaluation;
import vn.com.ecopharma.hrm.rc.service.base.CandidateEvaluationLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the candidate evaluation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.CandidateEvaluationLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil
 */
public class CandidateEvaluationLocalServiceImpl extends
		CandidateEvaluationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil} to
	 * access the candidate evaluation local service.
	 */
	public List<CandidateEvaluation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<CandidateEvaluation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<CandidateEvaluation> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return candidateEvaluationPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CandidateEvaluation> findByCandidate(long candidateId) {
		try {
			return candidateEvaluationPersistence.findByCandidate(candidateId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CandidateEvaluation createPrePersistedEntity() {
		try {
			long id = counterLocalService.increment();
			final CandidateEvaluation o = candidateEvaluationPersistence
					.create(id);
			return o;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CandidateEvaluation addCandidateEvaluation(long candidateId,
			long evaluationCriteriaId, long evaluationCriteriaKeyValueId,
			int ratingPoint, ServiceContext serviceContext) {
		CandidateEvaluation candidateEvaluation = createPrePersistedEntity();
		candidateEvaluation.setCandidateId(candidateId);
		candidateEvaluation.setEvaluationCriteriaId(evaluationCriteriaId);
		candidateEvaluation
				.setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
		candidateEvaluation.setRatingPoint(ratingPoint);

		candidateEvaluation.setCompanyId(serviceContext.getCompanyId());
		candidateEvaluation.setGroupId(serviceContext.getScopeGroupId());
		candidateEvaluation.setUserId(serviceContext.getUserId());

		try {
			return candidateEvaluationPersistence.update(candidateEvaluation);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}