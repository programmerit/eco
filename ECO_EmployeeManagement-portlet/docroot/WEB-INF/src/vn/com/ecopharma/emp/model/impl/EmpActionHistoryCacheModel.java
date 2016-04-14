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

package vn.com.ecopharma.emp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.ecopharma.emp.model.EmpActionHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpActionHistory in entity cache.
 *
 * @author tvt
 * @see EmpActionHistory
 * @generated
 */
public class EmpActionHistoryCacheModel implements CacheModel<EmpActionHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empActionHistoryId=");
		sb.append(empActionHistoryId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", performedBy=");
		sb.append(performedBy);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", refId=");
		sb.append(refId);
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
	public EmpActionHistory toEntityModel() {
		EmpActionHistoryImpl empActionHistoryImpl = new EmpActionHistoryImpl();

		empActionHistoryImpl.setEmpActionHistoryId(empActionHistoryId);
		empActionHistoryImpl.setEmpId(empId);

		if (action == null) {
			empActionHistoryImpl.setAction(StringPool.BLANK);
		}
		else {
			empActionHistoryImpl.setAction(action);
		}

		empActionHistoryImpl.setPerformedBy(performedBy);

		if (description == null) {
			empActionHistoryImpl.setDescription(StringPool.BLANK);
		}
		else {
			empActionHistoryImpl.setDescription(description);
		}

		if (status == null) {
			empActionHistoryImpl.setStatus(StringPool.BLANK);
		}
		else {
			empActionHistoryImpl.setStatus(status);
		}

		empActionHistoryImpl.setRefId(refId);
		empActionHistoryImpl.setGroupId(groupId);
		empActionHistoryImpl.setCompanyId(companyId);
		empActionHistoryImpl.setUserId(userId);

		if (userName == null) {
			empActionHistoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			empActionHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empActionHistoryImpl.setCreateDate(null);
		}
		else {
			empActionHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empActionHistoryImpl.setModifiedDate(null);
		}
		else {
			empActionHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		empActionHistoryImpl.resetOriginalValues();

		return empActionHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empActionHistoryId = objectInput.readLong();
		empId = objectInput.readLong();
		action = objectInput.readUTF();
		performedBy = objectInput.readLong();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		refId = objectInput.readLong();
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
		objectOutput.writeLong(empActionHistoryId);
		objectOutput.writeLong(empId);

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		objectOutput.writeLong(performedBy);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(refId);
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

	public long empActionHistoryId;
	public long empId;
	public String action;
	public long performedBy;
	public String description;
	public String status;
	public long refId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}