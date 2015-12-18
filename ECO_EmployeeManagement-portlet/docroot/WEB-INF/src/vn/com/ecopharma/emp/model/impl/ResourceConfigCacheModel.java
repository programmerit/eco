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

import vn.com.ecopharma.emp.model.ResourceConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResourceConfig in entity cache.
 *
 * @author tvt
 * @see ResourceConfig
 * @generated
 */
public class ResourceConfigCacheModel implements CacheModel<ResourceConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{resourceConfigId=");
		sb.append(resourceConfigId);
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append(", type=");
		sb.append(type);
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
	public ResourceConfig toEntityModel() {
		ResourceConfigImpl resourceConfigImpl = new ResourceConfigImpl();

		resourceConfigImpl.setResourceConfigId(resourceConfigId);

		if (key == null) {
			resourceConfigImpl.setKey(StringPool.BLANK);
		}
		else {
			resourceConfigImpl.setKey(key);
		}

		if (value == null) {
			resourceConfigImpl.setValue(StringPool.BLANK);
		}
		else {
			resourceConfigImpl.setValue(value);
		}

		if (type == null) {
			resourceConfigImpl.setType(StringPool.BLANK);
		}
		else {
			resourceConfigImpl.setType(type);
		}

		resourceConfigImpl.setGroupId(groupId);
		resourceConfigImpl.setCompanyId(companyId);
		resourceConfigImpl.setUserId(userId);

		if (userName == null) {
			resourceConfigImpl.setUserName(StringPool.BLANK);
		}
		else {
			resourceConfigImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			resourceConfigImpl.setCreateDate(null);
		}
		else {
			resourceConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resourceConfigImpl.setModifiedDate(null);
		}
		else {
			resourceConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		resourceConfigImpl.resetOriginalValues();

		return resourceConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		resourceConfigId = objectInput.readLong();
		key = objectInput.readUTF();
		value = objectInput.readUTF();
		type = objectInput.readUTF();
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
		objectOutput.writeLong(resourceConfigId);

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
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

	public long resourceConfigId;
	public String key;
	public String value;
	public String type;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}