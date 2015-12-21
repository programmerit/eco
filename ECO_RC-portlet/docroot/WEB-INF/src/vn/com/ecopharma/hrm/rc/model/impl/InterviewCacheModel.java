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

import vn.com.ecopharma.hrm.rc.model.Interview;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Interview in entity cache.
 *
 * @author tvt
 * @see Interview
 * @generated
 */
public class InterviewCacheModel implements CacheModel<Interview>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{interviewId=");
		sb.append(interviewId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", titlesId=");
		sb.append(titlesId);
		sb.append(", deleted=");
		sb.append(deleted);
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
	public Interview toEntityModel() {
		InterviewImpl interviewImpl = new InterviewImpl();

		interviewImpl.setInterviewId(interviewId);

		if (name == null) {
			interviewImpl.setName(StringPool.BLANK);
		}
		else {
			interviewImpl.setName(name);
		}

		interviewImpl.setTitlesId(titlesId);
		interviewImpl.setDeleted(deleted);
		interviewImpl.setGroupId(groupId);
		interviewImpl.setCompanyId(companyId);
		interviewImpl.setUserId(userId);

		if (userName == null) {
			interviewImpl.setUserName(StringPool.BLANK);
		}
		else {
			interviewImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			interviewImpl.setCreateDate(null);
		}
		else {
			interviewImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			interviewImpl.setModifiedDate(null);
		}
		else {
			interviewImpl.setModifiedDate(new Date(modifiedDate));
		}

		interviewImpl.resetOriginalValues();

		return interviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		interviewId = objectInput.readLong();
		name = objectInput.readUTF();
		titlesId = objectInput.readLong();
		deleted = objectInput.readBoolean();
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
		objectOutput.writeLong(interviewId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(titlesId);
		objectOutput.writeBoolean(deleted);
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

	public long interviewId;
	public String name;
	public long titlesId;
	public boolean deleted;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}