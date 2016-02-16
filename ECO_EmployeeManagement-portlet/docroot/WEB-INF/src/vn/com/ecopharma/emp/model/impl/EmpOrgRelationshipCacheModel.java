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

import vn.com.ecopharma.emp.model.EmpOrgRelationship;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpOrgRelationship in entity cache.
 *
 * @author tvt
 * @see EmpOrgRelationship
 * @generated
 */
public class EmpOrgRelationshipCacheModel implements CacheModel<EmpOrgRelationship>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{empOrgRelationshipId=");
		sb.append(empOrgRelationshipId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", orgClassName=");
		sb.append(orgClassName);
		sb.append(", orgClassPK=");
		sb.append(orgClassPK);
		sb.append(", headOfOrg=");
		sb.append(headOfOrg);
		sb.append(", deputyOfOrg=");
		sb.append(deputyOfOrg);
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
	public EmpOrgRelationship toEntityModel() {
		EmpOrgRelationshipImpl empOrgRelationshipImpl = new EmpOrgRelationshipImpl();

		empOrgRelationshipImpl.setEmpOrgRelationshipId(empOrgRelationshipId);
		empOrgRelationshipImpl.setEmpId(empId);

		if (orgClassName == null) {
			empOrgRelationshipImpl.setOrgClassName(StringPool.BLANK);
		}
		else {
			empOrgRelationshipImpl.setOrgClassName(orgClassName);
		}

		empOrgRelationshipImpl.setOrgClassPK(orgClassPK);
		empOrgRelationshipImpl.setHeadOfOrg(headOfOrg);
		empOrgRelationshipImpl.setDeputyOfOrg(deputyOfOrg);
		empOrgRelationshipImpl.setGroupId(groupId);
		empOrgRelationshipImpl.setCompanyId(companyId);
		empOrgRelationshipImpl.setUserId(userId);

		if (userName == null) {
			empOrgRelationshipImpl.setUserName(StringPool.BLANK);
		}
		else {
			empOrgRelationshipImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empOrgRelationshipImpl.setCreateDate(null);
		}
		else {
			empOrgRelationshipImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empOrgRelationshipImpl.setModifiedDate(null);
		}
		else {
			empOrgRelationshipImpl.setModifiedDate(new Date(modifiedDate));
		}

		empOrgRelationshipImpl.resetOriginalValues();

		return empOrgRelationshipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empOrgRelationshipId = objectInput.readLong();
		empId = objectInput.readLong();
		orgClassName = objectInput.readUTF();
		orgClassPK = objectInput.readLong();
		headOfOrg = objectInput.readBoolean();
		deputyOfOrg = objectInput.readBoolean();
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
		objectOutput.writeLong(empOrgRelationshipId);
		objectOutput.writeLong(empId);

		if (orgClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orgClassName);
		}

		objectOutput.writeLong(orgClassPK);
		objectOutput.writeBoolean(headOfOrg);
		objectOutput.writeBoolean(deputyOfOrg);
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

	public long empOrgRelationshipId;
	public long empId;
	public String orgClassName;
	public long orgClassPK;
	public boolean headOfOrg;
	public boolean deputyOfOrg;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}