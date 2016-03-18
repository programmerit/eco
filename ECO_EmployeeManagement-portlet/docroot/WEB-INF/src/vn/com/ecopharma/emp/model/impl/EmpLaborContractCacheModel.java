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

import vn.com.ecopharma.emp.model.EmpLaborContract;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpLaborContract in entity cache.
 *
 * @author tvt
 * @see EmpLaborContract
 * @generated
 */
public class EmpLaborContractCacheModel implements CacheModel<EmpLaborContract>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{empLaborContractId=");
		sb.append(empLaborContractId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", laborContractSignedDate=");
		sb.append(laborContractSignedDate);
		sb.append(", laborContractExpiredDate=");
		sb.append(laborContractExpiredDate);
		sb.append(", laborContractSignedType=");
		sb.append(laborContractSignedType);
		sb.append(", signedTimes=");
		sb.append(signedTimes);
		sb.append(", latest=");
		sb.append(latest);
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
	public EmpLaborContract toEntityModel() {
		EmpLaborContractImpl empLaborContractImpl = new EmpLaborContractImpl();

		empLaborContractImpl.setEmpLaborContractId(empLaborContractId);
		empLaborContractImpl.setEmpId(empId);

		if (laborContractSignedDate == Long.MIN_VALUE) {
			empLaborContractImpl.setLaborContractSignedDate(null);
		}
		else {
			empLaborContractImpl.setLaborContractSignedDate(new Date(
					laborContractSignedDate));
		}

		if (laborContractExpiredDate == Long.MIN_VALUE) {
			empLaborContractImpl.setLaborContractExpiredDate(null);
		}
		else {
			empLaborContractImpl.setLaborContractExpiredDate(new Date(
					laborContractExpiredDate));
		}

		if (laborContractSignedType == null) {
			empLaborContractImpl.setLaborContractSignedType(StringPool.BLANK);
		}
		else {
			empLaborContractImpl.setLaborContractSignedType(laborContractSignedType);
		}

		empLaborContractImpl.setSignedTimes(signedTimes);
		empLaborContractImpl.setLatest(latest);
		empLaborContractImpl.setGroupId(groupId);
		empLaborContractImpl.setCompanyId(companyId);
		empLaborContractImpl.setUserId(userId);

		if (userName == null) {
			empLaborContractImpl.setUserName(StringPool.BLANK);
		}
		else {
			empLaborContractImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empLaborContractImpl.setCreateDate(null);
		}
		else {
			empLaborContractImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empLaborContractImpl.setModifiedDate(null);
		}
		else {
			empLaborContractImpl.setModifiedDate(new Date(modifiedDate));
		}

		empLaborContractImpl.resetOriginalValues();

		return empLaborContractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empLaborContractId = objectInput.readLong();
		empId = objectInput.readLong();
		laborContractSignedDate = objectInput.readLong();
		laborContractExpiredDate = objectInput.readLong();
		laborContractSignedType = objectInput.readUTF();
		signedTimes = objectInput.readInt();
		latest = objectInput.readBoolean();
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
		objectOutput.writeLong(empLaborContractId);
		objectOutput.writeLong(empId);
		objectOutput.writeLong(laborContractSignedDate);
		objectOutput.writeLong(laborContractExpiredDate);

		if (laborContractSignedType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(laborContractSignedType);
		}

		objectOutput.writeInt(signedTimes);
		objectOutput.writeBoolean(latest);
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

	public long empLaborContractId;
	public long empId;
	public long laborContractSignedDate;
	public long laborContractExpiredDate;
	public String laborContractSignedType;
	public int signedTimes;
	public boolean latest;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}