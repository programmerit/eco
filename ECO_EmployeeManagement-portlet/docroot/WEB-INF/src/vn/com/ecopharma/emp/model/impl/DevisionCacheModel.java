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

import vn.com.ecopharma.emp.model.Devision;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Devision in entity cache.
 *
 * @author tvt
 * @see Devision
 * @generated
 */
public class DevisionCacheModel implements CacheModel<Devision>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{devisionId=");
		sb.append(devisionId);
		sb.append(", name=");
		sb.append(name);
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
	public Devision toEntityModel() {
		DevisionImpl devisionImpl = new DevisionImpl();

		devisionImpl.setDevisionId(devisionId);

		if (name == null) {
			devisionImpl.setName(StringPool.BLANK);
		}
		else {
			devisionImpl.setName(name);
		}

		devisionImpl.setGroupId(groupId);
		devisionImpl.setCompanyId(companyId);
		devisionImpl.setUserId(userId);

		if (userName == null) {
			devisionImpl.setUserName(StringPool.BLANK);
		}
		else {
			devisionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			devisionImpl.setCreateDate(null);
		}
		else {
			devisionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			devisionImpl.setModifiedDate(null);
		}
		else {
			devisionImpl.setModifiedDate(new Date(modifiedDate));
		}

		devisionImpl.resetOriginalValues();

		return devisionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		devisionId = objectInput.readLong();
		name = objectInput.readUTF();
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
		objectOutput.writeLong(devisionId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
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

	public long devisionId;
	public String name;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}