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

package vn.com.ecopharma.hrm.rc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VacancyEvaluationCriteria in entity cache.
 *
 * @author tvt
 * @see VacancyEvaluationCriteria
 * @generated
 */
public class VacancyEvaluationCriteriaCacheModel implements CacheModel<VacancyEvaluationCriteria>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{vacancyEvaluationCriteriaId=");
		sb.append(vacancyEvaluationCriteriaId);
		sb.append(", vacancyId=");
		sb.append(vacancyId);
		sb.append(", evaluationCriteriaId=");
		sb.append(evaluationCriteriaId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VacancyEvaluationCriteria toEntityModel() {
		VacancyEvaluationCriteriaImpl vacancyEvaluationCriteriaImpl = new VacancyEvaluationCriteriaImpl();

		vacancyEvaluationCriteriaImpl.setVacancyEvaluationCriteriaId(vacancyEvaluationCriteriaId);
		vacancyEvaluationCriteriaImpl.setVacancyId(vacancyId);
		vacancyEvaluationCriteriaImpl.setEvaluationCriteriaId(evaluationCriteriaId);
		vacancyEvaluationCriteriaImpl.setGroupId(groupId);
		vacancyEvaluationCriteriaImpl.setCompanyId(companyId);
		vacancyEvaluationCriteriaImpl.setUserId(userId);

		if (userName == null) {
			vacancyEvaluationCriteriaImpl.setUserName(StringPool.BLANK);
		}
		else {
			vacancyEvaluationCriteriaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vacancyEvaluationCriteriaImpl.setCreateDate(null);
		}
		else {
			vacancyEvaluationCriteriaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vacancyEvaluationCriteriaImpl.setModifiedDate(null);
		}
		else {
			vacancyEvaluationCriteriaImpl.setModifiedDate(new Date(modifiedDate));
		}

		vacancyEvaluationCriteriaImpl.resetOriginalValues();

		return vacancyEvaluationCriteriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vacancyEvaluationCriteriaId = objectInput.readLong();
		vacancyId = objectInput.readLong();
		evaluationCriteriaId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vacancyEvaluationCriteriaId);
		objectOutput.writeLong(vacancyId);
		objectOutput.writeLong(evaluationCriteriaId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long vacancyEvaluationCriteriaId;
	public long vacancyId;
	public long evaluationCriteriaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}