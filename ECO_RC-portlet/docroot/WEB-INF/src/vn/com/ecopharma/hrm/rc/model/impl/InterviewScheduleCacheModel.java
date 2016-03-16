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

import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing InterviewSchedule in entity cache.
 *
 * @author tvt
 * @see InterviewSchedule
 * @generated
 */
public class InterviewScheduleCacheModel implements CacheModel<InterviewSchedule>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{interviewScheduleId=");
		sb.append(interviewScheduleId);
		sb.append(", vacancyCandidateId=");
		sb.append(vacancyCandidateId);
		sb.append(", interviewId=");
		sb.append(interviewId);
		sb.append(", interviewDate=");
		sb.append(interviewDate);
		sb.append(", interviewTime=");
		sb.append(interviewTime);
		sb.append(", status=");
		sb.append(status);
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
	public InterviewSchedule toEntityModel() {
		InterviewScheduleImpl interviewScheduleImpl = new InterviewScheduleImpl();

		interviewScheduleImpl.setInterviewScheduleId(interviewScheduleId);
		interviewScheduleImpl.setVacancyCandidateId(vacancyCandidateId);
		interviewScheduleImpl.setInterviewId(interviewId);

		if (interviewDate == Long.MIN_VALUE) {
			interviewScheduleImpl.setInterviewDate(null);
		}
		else {
			interviewScheduleImpl.setInterviewDate(new Date(interviewDate));
		}

		if (interviewTime == null) {
			interviewScheduleImpl.setInterviewTime(StringPool.BLANK);
		}
		else {
			interviewScheduleImpl.setInterviewTime(interviewTime);
		}

		if (status == null) {
			interviewScheduleImpl.setStatus(StringPool.BLANK);
		}
		else {
			interviewScheduleImpl.setStatus(status);
		}

		interviewScheduleImpl.setGroupId(groupId);
		interviewScheduleImpl.setCompanyId(companyId);
		interviewScheduleImpl.setUserId(userId);

		if (userName == null) {
			interviewScheduleImpl.setUserName(StringPool.BLANK);
		}
		else {
			interviewScheduleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			interviewScheduleImpl.setCreateDate(null);
		}
		else {
			interviewScheduleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			interviewScheduleImpl.setModifiedDate(null);
		}
		else {
			interviewScheduleImpl.setModifiedDate(new Date(modifiedDate));
		}

		interviewScheduleImpl.resetOriginalValues();

		return interviewScheduleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		interviewScheduleId = objectInput.readLong();
		vacancyCandidateId = objectInput.readLong();
		interviewId = objectInput.readLong();
		interviewDate = objectInput.readLong();
		interviewTime = objectInput.readUTF();
		status = objectInput.readUTF();
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
		objectOutput.writeLong(interviewScheduleId);
		objectOutput.writeLong(vacancyCandidateId);
		objectOutput.writeLong(interviewId);
		objectOutput.writeLong(interviewDate);

		if (interviewTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(interviewTime);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
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

	public long interviewScheduleId;
	public long vacancyCandidateId;
	public long interviewId;
	public long interviewDate;
	public String interviewTime;
	public String status;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}