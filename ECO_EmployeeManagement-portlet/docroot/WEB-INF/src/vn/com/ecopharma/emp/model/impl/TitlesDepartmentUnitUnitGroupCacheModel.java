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

import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TitlesDepartmentUnitUnitGroup in entity cache.
 *
 * @author tvt
 * @see TitlesDepartmentUnitUnitGroup
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupCacheModel implements CacheModel<TitlesDepartmentUnitUnitGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{titlesDepartmentUnitUnitGroupId=");
		sb.append(titlesDepartmentUnitUnitGroupId);
		sb.append(", titlesId=");
		sb.append(titlesId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", unitId=");
		sb.append(unitId);
		sb.append(", unitGroupId=");
		sb.append(unitGroupId);
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
	public TitlesDepartmentUnitUnitGroup toEntityModel() {
		TitlesDepartmentUnitUnitGroupImpl titlesDepartmentUnitUnitGroupImpl = new TitlesDepartmentUnitUnitGroupImpl();

		titlesDepartmentUnitUnitGroupImpl.setTitlesDepartmentUnitUnitGroupId(titlesDepartmentUnitUnitGroupId);
		titlesDepartmentUnitUnitGroupImpl.setTitlesId(titlesId);
		titlesDepartmentUnitUnitGroupImpl.setDepartmentId(departmentId);
		titlesDepartmentUnitUnitGroupImpl.setUnitId(unitId);
		titlesDepartmentUnitUnitGroupImpl.setUnitGroupId(unitGroupId);
		titlesDepartmentUnitUnitGroupImpl.setGroupId(groupId);
		titlesDepartmentUnitUnitGroupImpl.setCompanyId(companyId);
		titlesDepartmentUnitUnitGroupImpl.setUserId(userId);

		if (userName == null) {
			titlesDepartmentUnitUnitGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			titlesDepartmentUnitUnitGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			titlesDepartmentUnitUnitGroupImpl.setCreateDate(null);
		}
		else {
			titlesDepartmentUnitUnitGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			titlesDepartmentUnitUnitGroupImpl.setModifiedDate(null);
		}
		else {
			titlesDepartmentUnitUnitGroupImpl.setModifiedDate(new Date(
					modifiedDate));
		}

		titlesDepartmentUnitUnitGroupImpl.resetOriginalValues();

		return titlesDepartmentUnitUnitGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		titlesDepartmentUnitUnitGroupId = objectInput.readLong();
		titlesId = objectInput.readLong();
		departmentId = objectInput.readLong();
		unitId = objectInput.readLong();
		unitGroupId = objectInput.readLong();
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
		objectOutput.writeLong(titlesDepartmentUnitUnitGroupId);
		objectOutput.writeLong(titlesId);
		objectOutput.writeLong(departmentId);
		objectOutput.writeLong(unitId);
		objectOutput.writeLong(unitGroupId);
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

	public long titlesDepartmentUnitUnitGroupId;
	public long titlesId;
	public long departmentId;
	public long unitId;
	public long unitGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}