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

import vn.com.ecopharma.emp.model.EmpAnualLeave;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpAnualLeave in entity cache.
 *
 * @author tvt
 * @see EmpAnualLeave
 * @generated
 */
public class EmpAnualLeaveCacheModel implements CacheModel<EmpAnualLeave>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{empAnualLeaveId=");
		sb.append(empAnualLeaveId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", noOfAnualLeave=");
		sb.append(noOfAnualLeave);
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
	public EmpAnualLeave toEntityModel() {
		EmpAnualLeaveImpl empAnualLeaveImpl = new EmpAnualLeaveImpl();

		empAnualLeaveImpl.setEmpAnualLeaveId(empAnualLeaveId);
		empAnualLeaveImpl.setEmpId(empId);
		empAnualLeaveImpl.setNoOfAnualLeave(noOfAnualLeave);
		empAnualLeaveImpl.setGroupId(groupId);
		empAnualLeaveImpl.setCompanyId(companyId);
		empAnualLeaveImpl.setUserId(userId);

		if (userName == null) {
			empAnualLeaveImpl.setUserName(StringPool.BLANK);
		}
		else {
			empAnualLeaveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empAnualLeaveImpl.setCreateDate(null);
		}
		else {
			empAnualLeaveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empAnualLeaveImpl.setModifiedDate(null);
		}
		else {
			empAnualLeaveImpl.setModifiedDate(new Date(modifiedDate));
		}

		empAnualLeaveImpl.resetOriginalValues();

		return empAnualLeaveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empAnualLeaveId = objectInput.readLong();
		empId = objectInput.readLong();
		noOfAnualLeave = objectInput.readDouble();
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
		objectOutput.writeLong(empAnualLeaveId);
		objectOutput.writeLong(empId);
		objectOutput.writeDouble(noOfAnualLeave);
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

	public long empAnualLeaveId;
	public long empId;
	public double noOfAnualLeave;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}