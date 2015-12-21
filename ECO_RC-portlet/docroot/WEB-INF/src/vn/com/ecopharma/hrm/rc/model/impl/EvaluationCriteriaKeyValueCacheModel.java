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

import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EvaluationCriteriaKeyValue in entity cache.
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValue
 * @generated
 */
public class EvaluationCriteriaKeyValueCacheModel implements CacheModel<EvaluationCriteriaKeyValue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{evaluationCriteriaKeyValueId=");
		sb.append(evaluationCriteriaKeyValueId);
		sb.append(", evaluationCriteriaId=");
		sb.append(evaluationCriteriaId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
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
	public EvaluationCriteriaKeyValue toEntityModel() {
		EvaluationCriteriaKeyValueImpl evaluationCriteriaKeyValueImpl = new EvaluationCriteriaKeyValueImpl();

		evaluationCriteriaKeyValueImpl.setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
		evaluationCriteriaKeyValueImpl.setEvaluationCriteriaId(evaluationCriteriaId);

		if (key == null) {
			evaluationCriteriaKeyValueImpl.setKey(StringPool.BLANK);
		}
		else {
			evaluationCriteriaKeyValueImpl.setKey(key);
		}

		evaluationCriteriaKeyValueImpl.setValue(value);
		evaluationCriteriaKeyValueImpl.setGroupId(groupId);
		evaluationCriteriaKeyValueImpl.setCompanyId(companyId);
		evaluationCriteriaKeyValueImpl.setUserId(userId);

		if (userName == null) {
			evaluationCriteriaKeyValueImpl.setUserName(StringPool.BLANK);
		}
		else {
			evaluationCriteriaKeyValueImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			evaluationCriteriaKeyValueImpl.setCreateDate(null);
		}
		else {
			evaluationCriteriaKeyValueImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			evaluationCriteriaKeyValueImpl.setModifiedDate(null);
		}
		else {
			evaluationCriteriaKeyValueImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		evaluationCriteriaKeyValueImpl.resetOriginalValues();

		return evaluationCriteriaKeyValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		evaluationCriteriaKeyValueId = objectInput.readLong();
		evaluationCriteriaId = objectInput.readLong();
		key = objectInput.readUTF();
		value = objectInput.readInt();
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
		objectOutput.writeLong(evaluationCriteriaKeyValueId);
		objectOutput.writeLong(evaluationCriteriaId);

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		objectOutput.writeInt(value);
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

	public long evaluationCriteriaKeyValueId;
	public long evaluationCriteriaId;
	public String key;
	public int value;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}