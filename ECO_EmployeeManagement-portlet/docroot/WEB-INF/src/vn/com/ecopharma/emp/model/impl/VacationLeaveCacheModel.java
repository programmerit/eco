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

import vn.com.ecopharma.emp.model.VacationLeave;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VacationLeave in entity cache.
 *
 * @author tvt
 * @see VacationLeave
 * @generated
 */
public class VacationLeaveCacheModel implements CacheModel<VacationLeave>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{vacationLeaveId=");
		sb.append(vacationLeaveId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", leaveType=");
		sb.append(leaveType);
		sb.append(", leaveFrom=");
		sb.append(leaveFrom);
		sb.append(", leaveTo=");
		sb.append(leaveTo);
		sb.append(", actualTo=");
		sb.append(actualTo);
		sb.append(", numberOfHours=");
		sb.append(numberOfHours);
		sb.append(", reason=");
		sb.append(reason);
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
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VacationLeave toEntityModel() {
		VacationLeaveImpl vacationLeaveImpl = new VacationLeaveImpl();

		vacationLeaveImpl.setVacationLeaveId(vacationLeaveId);
		vacationLeaveImpl.setEmpId(empId);

		if (leaveType == null) {
			vacationLeaveImpl.setLeaveType(StringPool.BLANK);
		}
		else {
			vacationLeaveImpl.setLeaveType(leaveType);
		}

		if (leaveFrom == Long.MIN_VALUE) {
			vacationLeaveImpl.setLeaveFrom(null);
		}
		else {
			vacationLeaveImpl.setLeaveFrom(new Date(leaveFrom));
		}

		if (leaveTo == Long.MIN_VALUE) {
			vacationLeaveImpl.setLeaveTo(null);
		}
		else {
			vacationLeaveImpl.setLeaveTo(new Date(leaveTo));
		}

		if (actualTo == Long.MIN_VALUE) {
			vacationLeaveImpl.setActualTo(null);
		}
		else {
			vacationLeaveImpl.setActualTo(new Date(actualTo));
		}

		vacationLeaveImpl.setNumberOfHours(numberOfHours);

		if (reason == null) {
			vacationLeaveImpl.setReason(StringPool.BLANK);
		}
		else {
			vacationLeaveImpl.setReason(reason);
		}

		if (description == null) {
			vacationLeaveImpl.setDescription(StringPool.BLANK);
		}
		else {
			vacationLeaveImpl.setDescription(description);
		}

		vacationLeaveImpl.setGroupId(groupId);
		vacationLeaveImpl.setCompanyId(companyId);
		vacationLeaveImpl.setUserId(userId);

		if (userName == null) {
			vacationLeaveImpl.setUserName(StringPool.BLANK);
		}
		else {
			vacationLeaveImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vacationLeaveImpl.setCreateDate(null);
		}
		else {
			vacationLeaveImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vacationLeaveImpl.setModifiedDate(null);
		}
		else {
			vacationLeaveImpl.setModifiedDate(new Date(modifiedDate));
		}

		vacationLeaveImpl.setDeleted(deleted);

		if (status == null) {
			vacationLeaveImpl.setStatus(StringPool.BLANK);
		}
		else {
			vacationLeaveImpl.setStatus(status);
		}

		vacationLeaveImpl.resetOriginalValues();

		return vacationLeaveImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vacationLeaveId = objectInput.readLong();
		empId = objectInput.readLong();
		leaveType = objectInput.readUTF();
		leaveFrom = objectInput.readLong();
		leaveTo = objectInput.readLong();
		actualTo = objectInput.readLong();
		numberOfHours = objectInput.readInt();
		reason = objectInput.readUTF();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		deleted = objectInput.readBoolean();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vacationLeaveId);
		objectOutput.writeLong(empId);

		if (leaveType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(leaveType);
		}

		objectOutput.writeLong(leaveFrom);
		objectOutput.writeLong(leaveTo);
		objectOutput.writeLong(actualTo);
		objectOutput.writeInt(numberOfHours);

		if (reason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reason);
		}

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
		objectOutput.writeBoolean(deleted);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long vacationLeaveId;
	public long empId;
	public String leaveType;
	public long leaveFrom;
	public long leaveTo;
	public long actualTo;
	public int numberOfHours;
	public String reason;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;
	public String status;
}