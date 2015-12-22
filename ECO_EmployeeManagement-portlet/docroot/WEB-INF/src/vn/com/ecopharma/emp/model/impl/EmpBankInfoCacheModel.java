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

import vn.com.ecopharma.emp.model.EmpBankInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpBankInfo in entity cache.
 *
 * @author tvt
 * @see EmpBankInfo
 * @generated
 */
public class EmpBankInfoCacheModel implements CacheModel<EmpBankInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{empBankInfoId=");
		sb.append(empBankInfoId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", bankAccountNo=");
		sb.append(bankAccountNo);
		sb.append(", bankName=");
		sb.append(bankName);
		sb.append(", branchName=");
		sb.append(branchName);
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
	public EmpBankInfo toEntityModel() {
		EmpBankInfoImpl empBankInfoImpl = new EmpBankInfoImpl();

		empBankInfoImpl.setEmpBankInfoId(empBankInfoId);
		empBankInfoImpl.setEmpId(empId);

		if (bankAccountNo == null) {
			empBankInfoImpl.setBankAccountNo(StringPool.BLANK);
		}
		else {
			empBankInfoImpl.setBankAccountNo(bankAccountNo);
		}

		if (bankName == null) {
			empBankInfoImpl.setBankName(StringPool.BLANK);
		}
		else {
			empBankInfoImpl.setBankName(bankName);
		}

		if (branchName == null) {
			empBankInfoImpl.setBranchName(StringPool.BLANK);
		}
		else {
			empBankInfoImpl.setBranchName(branchName);
		}

		empBankInfoImpl.setGroupId(groupId);
		empBankInfoImpl.setCompanyId(companyId);
		empBankInfoImpl.setUserId(userId);

		if (userName == null) {
			empBankInfoImpl.setUserName(StringPool.BLANK);
		}
		else {
			empBankInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empBankInfoImpl.setCreateDate(null);
		}
		else {
			empBankInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empBankInfoImpl.setModifiedDate(null);
		}
		else {
			empBankInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		empBankInfoImpl.resetOriginalValues();

		return empBankInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empBankInfoId = objectInput.readLong();
		empId = objectInput.readLong();
		bankAccountNo = objectInput.readUTF();
		bankName = objectInput.readUTF();
		branchName = objectInput.readUTF();
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
		objectOutput.writeLong(empBankInfoId);
		objectOutput.writeLong(empId);

		if (bankAccountNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankAccountNo);
		}

		if (bankName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bankName);
		}

		if (branchName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(branchName);
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

	public long empBankInfoId;
	public long empId;
	public String bankAccountNo;
	public String bankName;
	public String branchName;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}