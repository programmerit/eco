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

import vn.com.ecopharma.emp.model.EmployeeTitlesHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmployeeTitlesHistory in entity cache.
 *
 * @author tvt
 * @see EmployeeTitlesHistory
 * @generated
 */
public class EmployeeTitlesHistoryCacheModel implements CacheModel<EmployeeTitlesHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{employeeTitlesHistoryId=");
		sb.append(employeeTitlesHistoryId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", titlesId=");
		sb.append(titlesId);
		sb.append(", setDate=");
		sb.append(setDate);
		sb.append(", note=");
		sb.append(note);
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
	public EmployeeTitlesHistory toEntityModel() {
		EmployeeTitlesHistoryImpl employeeTitlesHistoryImpl = new EmployeeTitlesHistoryImpl();

		employeeTitlesHistoryImpl.setEmployeeTitlesHistoryId(employeeTitlesHistoryId);
		employeeTitlesHistoryImpl.setEmployeeId(employeeId);
		employeeTitlesHistoryImpl.setTitlesId(titlesId);

		if (setDate == Long.MIN_VALUE) {
			employeeTitlesHistoryImpl.setSetDate(null);
		}
		else {
			employeeTitlesHistoryImpl.setSetDate(new Date(setDate));
		}

		if (note == null) {
			employeeTitlesHistoryImpl.setNote(StringPool.BLANK);
		}
		else {
			employeeTitlesHistoryImpl.setNote(note);
		}

		employeeTitlesHistoryImpl.setGroupId(groupId);
		employeeTitlesHistoryImpl.setCompanyId(companyId);
		employeeTitlesHistoryImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			employeeTitlesHistoryImpl.setCreateDate(null);
		}
		else {
			employeeTitlesHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeTitlesHistoryImpl.setModifiedDate(null);
		}
		else {
			employeeTitlesHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		employeeTitlesHistoryImpl.resetOriginalValues();

		return employeeTitlesHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employeeTitlesHistoryId = objectInput.readLong();
		employeeId = objectInput.readLong();
		titlesId = objectInput.readLong();
		setDate = objectInput.readLong();
		note = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employeeTitlesHistoryId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(titlesId);
		objectOutput.writeLong(setDate);

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long employeeTitlesHistoryId;
	public long employeeId;
	public long titlesId;
	public long setDate;
	public String note;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}