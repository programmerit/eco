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

import vn.com.ecopharma.emp.model.WorkingLocation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkingLocation in entity cache.
 *
 * @author tvt
 * @see WorkingLocation
 * @generated
 */
public class WorkingLocationCacheModel implements CacheModel<WorkingLocation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{workingLocationId=");
		sb.append(workingLocationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", locationId=");
		sb.append(locationId);
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
	public WorkingLocation toEntityModel() {
		WorkingLocationImpl workingLocationImpl = new WorkingLocationImpl();

		workingLocationImpl.setWorkingLocationId(workingLocationId);

		if (name == null) {
			workingLocationImpl.setName(StringPool.BLANK);
		}
		else {
			workingLocationImpl.setName(name);
		}

		workingLocationImpl.setLocationId(locationId);
		workingLocationImpl.setGroupId(groupId);
		workingLocationImpl.setCompanyId(companyId);
		workingLocationImpl.setUserId(userId);

		if (userName == null) {
			workingLocationImpl.setUserName(StringPool.BLANK);
		}
		else {
			workingLocationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			workingLocationImpl.setCreateDate(null);
		}
		else {
			workingLocationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			workingLocationImpl.setModifiedDate(null);
		}
		else {
			workingLocationImpl.setModifiedDate(new Date(modifiedDate));
		}

		workingLocationImpl.resetOriginalValues();

		return workingLocationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workingLocationId = objectInput.readLong();
		name = objectInput.readUTF();
		locationId = objectInput.readLong();
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
		objectOutput.writeLong(workingLocationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(locationId);
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

	public long workingLocationId;
	public String name;
	public long locationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}