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

import vn.com.ecopharma.emp.model.Titles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Titles in entity cache.
 *
 * @author tvt
 * @see Titles
 * @generated
 */
public class TitlesCacheModel implements CacheModel<Titles>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{titlesId=");
		sb.append(titlesId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", unitGroupId=");
		sb.append(unitGroupId);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", departmentId=");
		sb.append(departmentId);
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
	public Titles toEntityModel() {
		TitlesImpl titlesImpl = new TitlesImpl();

		titlesImpl.setTitlesId(titlesId);

		if (name == null) {
			titlesImpl.setName(StringPool.BLANK);
		}
		else {
			titlesImpl.setName(name);
		}

		titlesImpl.setUnitGroupId(unitGroupId);
		titlesImpl.setUnitId(unitId);
		titlesImpl.setDepartmentId(departmentId);
		titlesImpl.setGroupId(groupId);
		titlesImpl.setCompanyId(companyId);
		titlesImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			titlesImpl.setCreateDate(null);
		}
		else {
			titlesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			titlesImpl.setModifiedDate(null);
		}
		else {
			titlesImpl.setModifiedDate(new Date(modifiedDate));
		}

		titlesImpl.resetOriginalValues();

		return titlesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		titlesId = objectInput.readLong();
		name = objectInput.readUTF();
		unitGroupId = objectInput.readLong();
		unitId = objectInput.readLong();
		departmentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(titlesId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(unitGroupId);
		objectOutput.writeLong(unitId);
		objectOutput.writeLong(departmentId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long titlesId;
	public String name;
	public long unitGroupId;
	public long unitId;
	public long departmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}