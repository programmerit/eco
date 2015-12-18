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

import vn.com.ecopharma.emp.model.Unit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Unit in entity cache.
 *
 * @author tvt
 * @see Unit
 * @generated
 */
public class UnitCacheModel implements CacheModel<Unit>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{unitId=");
		sb.append(unitId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", departmentId=");
		sb.append(departmentId);
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
	public Unit toEntityModel() {
		UnitImpl unitImpl = new UnitImpl();

		unitImpl.setUnitId(unitId);

		if (name == null) {
			unitImpl.setName(StringPool.BLANK);
		}
		else {
			unitImpl.setName(name);
		}

		unitImpl.setDepartmentId(departmentId);
		unitImpl.setGroupId(groupId);
		unitImpl.setCompanyId(companyId);
		unitImpl.setUserId(userId);

		if (userName == null) {
			unitImpl.setUserName(StringPool.BLANK);
		}
		else {
			unitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			unitImpl.setCreateDate(null);
		}
		else {
			unitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			unitImpl.setModifiedDate(null);
		}
		else {
			unitImpl.setModifiedDate(new Date(modifiedDate));
		}

		unitImpl.resetOriginalValues();

		return unitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		unitId = objectInput.readLong();
		name = objectInput.readUTF();
		departmentId = objectInput.readLong();
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
		objectOutput.writeLong(unitId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(departmentId);
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

	public long unitId;
	public String name;
	public long departmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}