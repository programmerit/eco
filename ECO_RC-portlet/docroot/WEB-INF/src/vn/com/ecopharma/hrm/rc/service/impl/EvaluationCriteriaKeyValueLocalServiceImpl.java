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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;
import vn.com.ecopharma.hrm.rc.service.base.EvaluationCriteriaKeyValueLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the evaluation criteria key value local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.base.EvaluationCriteriaKeyValueLocalServiceBaseImpl
 * @see vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil
 */
public class EvaluationCriteriaKeyValueLocalServiceImpl extends
		EvaluationCriteriaKeyValueLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * vn.com.ecopharma
	 * .hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil} to access the
	 * evaluation criteria key value local service.
	 */

	public EvaluationCriteriaKeyValue addEvaluationCriteriaKeyValue(
			long evaluationCriteriaId, String key, int value,
			ServiceContext serviceContext) {

		try {
			final EvaluationCriteriaKeyValue o = evaluationCriteriaKeyValueLocalService
					.createEvaluationCriteriaKeyValue(counterLocalService
							.increment());

			o.setEvaluationCriteriaId(evaluationCriteriaId);
			o.setKey(key);
			o.setValue(value);

			o.setCreateDate(new Date());
			o.setModifiedDate(new Date());
			o.setCompanyId(serviceContext.getCompanyId());
			o.setGroupId(serviceContext.getScopeGroupId());

			return evaluationCriteriaKeyValuePersistence.update(o);
		} catch (SystemException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<EvaluationCriteriaKeyValue> findByEvaluationCriteria(
			long evaluationCriteriaId) {
		try {
			return evaluationCriteriaKeyValuePersistence
					.findByEvaluationCriteria(evaluationCriteriaId);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<EvaluationCriteriaKeyValue> findByEvaluationCriteriaAndKey(
			long evaluationCriteriaId, String key) {
		try {
			return evaluationCriteriaKeyValuePersistence
					.findByEvaluationCriteriaAndKey(evaluationCriteriaId, key);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}
}