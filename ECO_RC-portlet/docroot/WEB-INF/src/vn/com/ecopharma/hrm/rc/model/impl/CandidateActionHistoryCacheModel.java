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

import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CandidateActionHistory in entity cache.
 *
 * @author tvt
 * @see CandidateActionHistory
 * @generated
 */
public class CandidateActionHistoryCacheModel implements CacheModel<CandidateActionHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{candidateActionHistoryId=");
		sb.append(candidateActionHistoryId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", actionType=");
		sb.append(actionType);
		sb.append(", executedBy=");
		sb.append(executedBy);
		sb.append(", date=");
		sb.append(date);
		sb.append(", description=");
		sb.append(description);
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
	public CandidateActionHistory toEntityModel() {
		CandidateActionHistoryImpl candidateActionHistoryImpl = new CandidateActionHistoryImpl();

		candidateActionHistoryImpl.setCandidateActionHistoryId(candidateActionHistoryId);
		candidateActionHistoryImpl.setCandidateId(candidateId);

		if (action == null) {
			candidateActionHistoryImpl.setAction(StringPool.BLANK);
		}
		else {
			candidateActionHistoryImpl.setAction(action);
		}

		if (actionType == null) {
			candidateActionHistoryImpl.setActionType(StringPool.BLANK);
		}
		else {
			candidateActionHistoryImpl.setActionType(actionType);
		}

		candidateActionHistoryImpl.setExecutedBy(executedBy);

		if (date == Long.MIN_VALUE) {
			candidateActionHistoryImpl.setDate(null);
		}
		else {
			candidateActionHistoryImpl.setDate(new Date(date));
		}

		if (description == null) {
			candidateActionHistoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			candidateActionHistoryImpl.setDescription(description);
		}

		candidateActionHistoryImpl.setGroupId(groupId);
		candidateActionHistoryImpl.setCompanyId(companyId);
		candidateActionHistoryImpl.setUserId(userId);

		if (userName == null) {
			candidateActionHistoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			candidateActionHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			candidateActionHistoryImpl.setCreateDate(null);
		}
		else {
			candidateActionHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			candidateActionHistoryImpl.setModifiedDate(null);
		}
		else {
			candidateActionHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		candidateActionHistoryImpl.resetOriginalValues();

		return candidateActionHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		candidateActionHistoryId = objectInput.readLong();
		candidateId = objectInput.readLong();
		action = objectInput.readUTF();
		actionType = objectInput.readUTF();
		executedBy = objectInput.readLong();
		date = objectInput.readLong();
		description = objectInput.readUTF();
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
		objectOutput.writeLong(candidateActionHistoryId);
		objectOutput.writeLong(candidateId);

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (actionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionType);
		}

		objectOutput.writeLong(executedBy);
		objectOutput.writeLong(date);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
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

	public long candidateActionHistoryId;
	public long candidateId;
	public String action;
	public String actionType;
	public long executedBy;
	public long date;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}