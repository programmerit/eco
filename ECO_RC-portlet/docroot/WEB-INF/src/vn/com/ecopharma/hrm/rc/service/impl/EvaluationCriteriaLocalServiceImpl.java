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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;
import vn.com.ecopharma.hrm.rc.service.base.EvaluationCriteriaLocalServiceBaseImpl;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the evaluation criteria local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.EvaluationCriteriaLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil
 */
public class EvaluationCriteriaLocalServiceImpl extends
		EvaluationCriteriaLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil} to
	 * access the evaluation criteria local service.
	 */

	public List<EvaluationCriteria> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public List<EvaluationCriteria> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	public List<EvaluationCriteria> findAll(int start, int end,
			OrderByComparator orderByComparator) {
		try {
			return evaluationCriteriaPersistence.findAll(start, end,
					orderByComparator);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EvaluationCriteria findByType(String type) {
		try {
			return evaluationCriteriaPersistence.fetchByType(type);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EvaluationCriteria createPrePersistedEntity() {
		try {
			long id = counterLocalService.increment();
			final EvaluationCriteria o = evaluationCriteriaPersistence
					.create(id);
			return o;
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public EvaluationCriteria addEvaluationCriteria(String type, String name,
			ServiceContext serviceContext) {
		try {
			long id = counterLocalService.increment();
			final EvaluationCriteria o = evaluationCriteriaPersistence
					.create(id);

			o.setType(type);
			o.setName(name);

			o.setCreateDate(new Date());
			o.setModifiedDate(new Date());
			o.setCompanyId(serviceContext.getCompanyId());
			o.setGroupId(serviceContext.getScopeGroupId());

			return evaluationCriteriaPersistence.update(o);

		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}