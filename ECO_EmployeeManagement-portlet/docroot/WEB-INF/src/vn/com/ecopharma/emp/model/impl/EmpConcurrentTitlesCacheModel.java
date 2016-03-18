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

import vn.com.ecopharma.emp.model.EmpConcurrentTitles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpConcurrentTitles in entity cache.
 *
 * @author tvt
 * @see EmpConcurrentTitles
 * @generated
 */
public class EmpConcurrentTitlesCacheModel implements CacheModel<EmpConcurrentTitles>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empConcurrentTitlesId=");
		sb.append(empConcurrentTitlesId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", titlesId=");
		sb.append(titlesId);
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
	public EmpConcurrentTitles toEntityModel() {
		EmpConcurrentTitlesImpl empConcurrentTitlesImpl = new EmpConcurrentTitlesImpl();

		empConcurrentTitlesImpl.setEmpConcurrentTitlesId(empConcurrentTitlesId);
		empConcurrentTitlesImpl.setEmpId(empId);
		empConcurrentTitlesImpl.setTitlesId(titlesId);
		empConcurrentTitlesImpl.setUnitGroupId(unitGroupId);
		empConcurrentTitlesImpl.setUnitId(unitId);
		empConcurrentTitlesImpl.setDepartmentId(departmentId);
		empConcurrentTitlesImpl.setGroupId(groupId);
		empConcurrentTitlesImpl.setCompanyId(companyId);
		empConcurrentTitlesImpl.setUserId(userId);

		if (userName == null) {
			empConcurrentTitlesImpl.setUserName(StringPool.BLANK);
		}
		else {
			empConcurrentTitlesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empConcurrentTitlesImpl.setCreateDate(null);
		}
		else {
			empConcurrentTitlesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empConcurrentTitlesImpl.setModifiedDate(null);
		}
		else {
			empConcurrentTitlesImpl.setModifiedDate(new Date(modifiedDate));
		}

		empConcurrentTitlesImpl.resetOriginalValues();

		return empConcurrentTitlesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empConcurrentTitlesId = objectInput.readLong();
		empId = objectInput.readLong();
		titlesId = objectInput.readLong();
		unitGroupId = objectInput.readLong();
		unitId = objectInput.readLong();
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
		objectOutput.writeLong(empConcurrentTitlesId);
		objectOutput.writeLong(empId);
		objectOutput.writeLong(titlesId);
		objectOutput.writeLong(unitGroupId);
		objectOutput.writeLong(unitId);
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

	public long empConcurrentTitlesId;
	public long empId;
	public long titlesId;
	public long unitGroupId;
	public long unitId;
	public long departmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}