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

import vn.com.ecopharma.emp.model.UnitGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UnitGroup in entity cache.
 *
 * @author tvt
 * @see UnitGroup
 * @generated
 */
public class UnitGroupCacheModel implements CacheModel<UnitGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{unitGroupId=");
		sb.append(unitGroupId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", unitId=");
		sb.append(unitId);
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
	public UnitGroup toEntityModel() {
		UnitGroupImpl unitGroupImpl = new UnitGroupImpl();

		unitGroupImpl.setUnitGroupId(unitGroupId);

		if (name == null) {
			unitGroupImpl.setName(StringPool.BLANK);
		}
		else {
			unitGroupImpl.setName(name);
		}

		unitGroupImpl.setUnitId(unitId);
		unitGroupImpl.setGroupId(groupId);
		unitGroupImpl.setCompanyId(companyId);
		unitGroupImpl.setUserId(userId);

		if (userName == null) {
			unitGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			unitGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			unitGroupImpl.setCreateDate(null);
		}
		else {
			unitGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			unitGroupImpl.setModifiedDate(null);
		}
		else {
			unitGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		unitGroupImpl.resetOriginalValues();

		return unitGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		unitGroupId = objectInput.readLong();
		name = objectInput.readUTF();
		unitId = objectInput.readLong();
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
		objectOutput.writeLong(unitGroupId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(unitId);
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

	public long unitGroupId;
	public String name;
	public long unitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}