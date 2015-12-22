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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteria;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EvaluationCriteria in entity cache.
 *
 * @author tvt
 * @see EvaluationCriteria
 * @generated
 */
public class EvaluationCriteriaCacheModel implements CacheModel<EvaluationCriteria>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{evaluationCriteriaId=");
		sb.append(evaluationCriteriaId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", name=");
		sb.append(name);
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
	public EvaluationCriteria toEntityModel() {
		EvaluationCriteriaImpl evaluationCriteriaImpl = new EvaluationCriteriaImpl();

		evaluationCriteriaImpl.setEvaluationCriteriaId(evaluationCriteriaId);

		if (type == null) {
			evaluationCriteriaImpl.setType(StringPool.BLANK);
		}
		else {
			evaluationCriteriaImpl.setType(type);
		}

		if (name == null) {
			evaluationCriteriaImpl.setName(StringPool.BLANK);
		}
		else {
			evaluationCriteriaImpl.setName(name);
		}

		evaluationCriteriaImpl.setGroupId(groupId);
		evaluationCriteriaImpl.setCompanyId(companyId);
		evaluationCriteriaImpl.setUserId(userId);

		if (userName == null) {
			evaluationCriteriaImpl.setUserName(StringPool.BLANK);
		}
		else {
			evaluationCriteriaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			evaluationCriteriaImpl.setCreateDate(null);
		}
		else {
			evaluationCriteriaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			evaluationCriteriaImpl.setModifiedDate(null);
		}
		else {
			evaluationCriteriaImpl.setModifiedDate(new Date(modifiedDate));
		}

		evaluationCriteriaImpl.resetOriginalValues();

		return evaluationCriteriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		evaluationCriteriaId = objectInput.readLong();
		type = objectInput.readUTF();
		name = objectInput.readUTF();
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
		objectOutput.writeLong(evaluationCriteriaId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

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

	public long evaluationCriteriaId;
	public String type;
	public String name;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}