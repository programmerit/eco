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

import vn.com.ecopharma.emp.model.Level;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Level in entity cache.
 *
 * @author tvt
 * @see Level
 * @generated
 */
public class LevelCacheModel implements CacheModel<Level>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{levelId=");
		sb.append(levelId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", level=");
		sb.append(level);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Level toEntityModel() {
		LevelImpl levelImpl = new LevelImpl();

		levelImpl.setLevelId(levelId);

		if (name == null) {
			levelImpl.setName(StringPool.BLANK);
		}
		else {
			levelImpl.setName(name);
		}

		levelImpl.setLevel(level);
		levelImpl.setGroupId(groupId);
		levelImpl.setCompanyId(companyId);
		levelImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			levelImpl.setCreateDate(null);
		}
		else {
			levelImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			levelImpl.setModifiedDate(null);
		}
		else {
			levelImpl.setModifiedDate(new Date(modifiedDate));
		}

		levelImpl.resetOriginalValues();

		return levelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		levelId = objectInput.readLong();
		name = objectInput.readUTF();
		level = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(levelId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(level);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long levelId;
	public String name;
	public int level;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}