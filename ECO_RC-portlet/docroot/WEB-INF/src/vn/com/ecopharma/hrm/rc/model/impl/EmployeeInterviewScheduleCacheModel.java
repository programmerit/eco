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

import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeInterviewSchedule in entity cache.
 *
 * @author tvt
 * @see EmployeeInterviewSchedule
 * @generated
 */
public class EmployeeInterviewScheduleCacheModel implements CacheModel<EmployeeInterviewSchedule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeInterviewScheduleId=");
		sb.append(employeeInterviewScheduleId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", interviewScheduleId=");
		sb.append(interviewScheduleId);
		sb.append(", note=");
		sb.append(note);
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
	public EmployeeInterviewSchedule toEntityModel() {
		EmployeeInterviewScheduleImpl employeeInterviewScheduleImpl = new EmployeeInterviewScheduleImpl();

		employeeInterviewScheduleImpl.setEmployeeInterviewScheduleId(employeeInterviewScheduleId);
		employeeInterviewScheduleImpl.setEmployeeId(employeeId);
		employeeInterviewScheduleImpl.setInterviewScheduleId(interviewScheduleId);

		if (note == null) {
			employeeInterviewScheduleImpl.setNote(StringPool.BLANK);
		}
		else {
			employeeInterviewScheduleImpl.setNote(note);
		}

		employeeInterviewScheduleImpl.setGroupId(groupId);
		employeeInterviewScheduleImpl.setCompanyId(companyId);
		employeeInterviewScheduleImpl.setUserId(userId);

		if (userName == null) {
			employeeInterviewScheduleImpl.setUserName(StringPool.BLANK);
		}
		else {
			employeeInterviewScheduleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeInterviewScheduleImpl.setCreateDate(null);
		}
		else {
			employeeInterviewScheduleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeInterviewScheduleImpl.setModifiedDate(null);
		}
		else {
			employeeInterviewScheduleImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeInterviewScheduleImpl.resetOriginalValues();

		return employeeInterviewScheduleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeInterviewScheduleId = objectInput.readLong();
		employeeId = objectInput.readLong();
		interviewScheduleId = objectInput.readLong();
		note = objectInput.readUTF();
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
		objectOutput.writeLong(employeeInterviewScheduleId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(interviewScheduleId);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
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

	public long employeeInterviewScheduleId;
	public long employeeId;
	public long interviewScheduleId;
	public String note;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}