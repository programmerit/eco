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

import vn.com.ecopharma.emp.model.Specialized;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Specialized in entity cache.
 *
 * @author tvt
 * @see Specialized
 * @generated
 */
public class SpecializedCacheModel implements CacheModel<Specialized>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{specializedId=");
		sb.append(specializedId);
		sb.append(", specializedCode=");
		sb.append(specializedCode);
		sb.append(", name=");
		sb.append(name);
		sb.append(", level=");
		sb.append(level);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", university=");
		sb.append(university);
		sb.append(", college=");
		sb.append(college);
		sb.append(", vocationalCollege=");
		sb.append(vocationalCollege);
		sb.append(", vocational=");
		sb.append(vocational);
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
	public Specialized toEntityModel() {
		SpecializedImpl specializedImpl = new SpecializedImpl();

		specializedImpl.setSpecializedId(specializedId);

		if (specializedCode == null) {
			specializedImpl.setSpecializedCode(StringPool.BLANK);
		}
		else {
			specializedImpl.setSpecializedCode(specializedCode);
		}

		if (name == null) {
			specializedImpl.setName(StringPool.BLANK);
		}
		else {
			specializedImpl.setName(name);
		}

		specializedImpl.setLevel(level);
		specializedImpl.setParentId(parentId);
		specializedImpl.setUniversity(university);
		specializedImpl.setCollege(college);
		specializedImpl.setVocationalCollege(vocationalCollege);
		specializedImpl.setVocational(vocational);
		specializedImpl.setGroupId(groupId);
		specializedImpl.setCompanyId(companyId);
		specializedImpl.setUserId(userId);

		if (userName == null) {
			specializedImpl.setUserName(StringPool.BLANK);
		}
		else {
			specializedImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			specializedImpl.setCreateDate(null);
		}
		else {
			specializedImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			specializedImpl.setModifiedDate(null);
		}
		else {
			specializedImpl.setModifiedDate(new Date(modifiedDate));
		}

		specializedImpl.resetOriginalValues();

		return specializedImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		specializedId = objectInput.readLong();
		specializedCode = objectInput.readUTF();
		name = objectInput.readUTF();
		level = objectInput.readInt();
		parentId = objectInput.readLong();
		university = objectInput.readBoolean();
		college = objectInput.readBoolean();
		vocationalCollege = objectInput.readBoolean();
		vocational = objectInput.readBoolean();
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
		objectOutput.writeLong(specializedId);

		if (specializedCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(specializedCode);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(level);
		objectOutput.writeLong(parentId);
		objectOutput.writeBoolean(university);
		objectOutput.writeBoolean(college);
		objectOutput.writeBoolean(vocationalCollege);
		objectOutput.writeBoolean(vocational);
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

	public long specializedId;
	public String specializedCode;
	public String name;
	public int level;
	public long parentId;
	public boolean university;
	public boolean college;
	public boolean vocationalCollege;
	public boolean vocational;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}