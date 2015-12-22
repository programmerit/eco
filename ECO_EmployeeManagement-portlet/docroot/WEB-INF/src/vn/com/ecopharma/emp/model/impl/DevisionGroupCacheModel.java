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

import vn.com.ecopharma.emp.model.DevisionGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DevisionGroup in entity cache.
 *
 * @author tvt
 * @see DevisionGroup
 * @generated
 */
public class DevisionGroupCacheModel implements CacheModel<DevisionGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{devisionGroupId=");
		sb.append(devisionGroupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", devisionId=");
		sb.append(devisionId);
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
	public DevisionGroup toEntityModel() {
		DevisionGroupImpl devisionGroupImpl = new DevisionGroupImpl();

		devisionGroupImpl.setDevisionGroupId(devisionGroupId);

		if (name == null) {
			devisionGroupImpl.setName(StringPool.BLANK);
		}
		else {
			devisionGroupImpl.setName(name);
		}

		devisionGroupImpl.setDevisionId(devisionId);
		devisionGroupImpl.setGroupId(groupId);
		devisionGroupImpl.setCompanyId(companyId);
		devisionGroupImpl.setUserId(userId);

		if (userName == null) {
			devisionGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			devisionGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			devisionGroupImpl.setCreateDate(null);
		}
		else {
			devisionGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			devisionGroupImpl.setModifiedDate(null);
		}
		else {
			devisionGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		devisionGroupImpl.resetOriginalValues();

		return devisionGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		devisionGroupId = objectInput.readLong();
		name = objectInput.readUTF();
		devisionId = objectInput.readLong();
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
		objectOutput.writeLong(devisionGroupId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(devisionId);
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

	public long devisionGroupId;
	public String name;
	public long devisionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}