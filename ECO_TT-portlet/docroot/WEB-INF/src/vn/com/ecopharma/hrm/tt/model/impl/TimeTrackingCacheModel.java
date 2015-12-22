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

package vn.com.ecopharma.hrm.tt.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.ecopharma.hrm.tt.model.TimeTracking;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TimeTracking in entity cache.
 *
 * @author tvt
 * @see TimeTracking
 * @generated
 */
public class TimeTrackingCacheModel implements CacheModel<TimeTracking>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{timeTrackingId=");
		sb.append(timeTrackingId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", date=");
		sb.append(date);
		sb.append(", in1=");
		sb.append(in1);
		sb.append(", out1=");
		sb.append(out1);
		sb.append(", in2=");
		sb.append(in2);
		sb.append(", out2=");
		sb.append(out2);
		sb.append(", in3=");
		sb.append(in3);
		sb.append(", out3=");
		sb.append(out3);
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
	public TimeTracking toEntityModel() {
		TimeTrackingImpl timeTrackingImpl = new TimeTrackingImpl();

		timeTrackingImpl.setTimeTrackingId(timeTrackingId);
		timeTrackingImpl.setEmpId(empId);

		if (date == Long.MIN_VALUE) {
			timeTrackingImpl.setDate(null);
		}
		else {
			timeTrackingImpl.setDate(new Date(date));
		}

		if (in1 == Long.MIN_VALUE) {
			timeTrackingImpl.setIn1(null);
		}
		else {
			timeTrackingImpl.setIn1(new Date(in1));
		}

		if (out1 == Long.MIN_VALUE) {
			timeTrackingImpl.setOut1(null);
		}
		else {
			timeTrackingImpl.setOut1(new Date(out1));
		}

		if (in2 == Long.MIN_VALUE) {
			timeTrackingImpl.setIn2(null);
		}
		else {
			timeTrackingImpl.setIn2(new Date(in2));
		}

		if (out2 == Long.MIN_VALUE) {
			timeTrackingImpl.setOut2(null);
		}
		else {
			timeTrackingImpl.setOut2(new Date(out2));
		}

		if (in3 == Long.MIN_VALUE) {
			timeTrackingImpl.setIn3(null);
		}
		else {
			timeTrackingImpl.setIn3(new Date(in3));
		}

		if (out3 == Long.MIN_VALUE) {
			timeTrackingImpl.setOut3(null);
		}
		else {
			timeTrackingImpl.setOut3(new Date(out3));
		}

		timeTrackingImpl.setGroupId(groupId);
		timeTrackingImpl.setCompanyId(companyId);
		timeTrackingImpl.setUserId(userId);

		if (userName == null) {
			timeTrackingImpl.setUserName(StringPool.BLANK);
		}
		else {
			timeTrackingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			timeTrackingImpl.setCreateDate(null);
		}
		else {
			timeTrackingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			timeTrackingImpl.setModifiedDate(null);
		}
		else {
			timeTrackingImpl.setModifiedDate(new Date(modifiedDate));
		}

		timeTrackingImpl.resetOriginalValues();

		return timeTrackingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		timeTrackingId = objectInput.readLong();
		empId = objectInput.readLong();
		date = objectInput.readLong();
		in1 = objectInput.readLong();
		out1 = objectInput.readLong();
		in2 = objectInput.readLong();
		out2 = objectInput.readLong();
		in3 = objectInput.readLong();
		out3 = objectInput.readLong();
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
		objectOutput.writeLong(timeTrackingId);
		objectOutput.writeLong(empId);
		objectOutput.writeLong(date);
		objectOutput.writeLong(in1);
		objectOutput.writeLong(out1);
		objectOutput.writeLong(in2);
		objectOutput.writeLong(out2);
		objectOutput.writeLong(in3);
		objectOutput.writeLong(out3);
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

	public long timeTrackingId;
	public long empId;
	public long date;
	public long in1;
	public long out1;
	public long in2;
	public long out2;
	public long in3;
	public long out3;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}