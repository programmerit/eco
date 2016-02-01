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

import vn.com.ecopharma.emp.model.EmpDiscipline;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EmpDiscipline in entity cache.
 *
 * @author tvt
 * @see EmpDiscipline
 * @generated
 */
public class EmpDisciplineCacheModel implements CacheModel<EmpDiscipline>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{empDisciplineId=");
		sb.append(empDisciplineId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", decisionNo=");
		sb.append(decisionNo);
		sb.append(", content=");
		sb.append(content);
		sb.append(", disciplineType=");
		sb.append(disciplineType);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", additionalDisciplineType=");
		sb.append(additionalDisciplineType);
		sb.append(", description=");
		sb.append(description);
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
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpDiscipline toEntityModel() {
		EmpDisciplineImpl empDisciplineImpl = new EmpDisciplineImpl();

		empDisciplineImpl.setEmpDisciplineId(empDisciplineId);
		empDisciplineImpl.setEmpId(empId);

		if (decisionNo == null) {
			empDisciplineImpl.setDecisionNo(StringPool.BLANK);
		}
		else {
			empDisciplineImpl.setDecisionNo(decisionNo);
		}

		if (content == null) {
			empDisciplineImpl.setContent(StringPool.BLANK);
		}
		else {
			empDisciplineImpl.setContent(content);
		}

		if (disciplineType == null) {
			empDisciplineImpl.setDisciplineType(StringPool.BLANK);
		}
		else {
			empDisciplineImpl.setDisciplineType(disciplineType);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			empDisciplineImpl.setEffectiveDate(null);
		}
		else {
			empDisciplineImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (additionalDisciplineType == null) {
			empDisciplineImpl.setAdditionalDisciplineType(StringPool.BLANK);
		}
		else {
			empDisciplineImpl.setAdditionalDisciplineType(additionalDisciplineType);
		}

		if (description == null) {
			empDisciplineImpl.setDescription(StringPool.BLANK);
		}
		else {
			empDisciplineImpl.setDescription(description);
		}

		empDisciplineImpl.setGroupId(groupId);
		empDisciplineImpl.setCompanyId(companyId);
		empDisciplineImpl.setUserId(userId);

		if (userName == null) {
			empDisciplineImpl.setUserName(StringPool.BLANK);
		}
		else {
			empDisciplineImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empDisciplineImpl.setCreateDate(null);
		}
		else {
			empDisciplineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empDisciplineImpl.setModifiedDate(null);
		}
		else {
			empDisciplineImpl.setModifiedDate(new Date(modifiedDate));
		}

		empDisciplineImpl.setDeleted(deleted);

		empDisciplineImpl.resetOriginalValues();

		return empDisciplineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empDisciplineId = objectInput.readLong();
		empId = objectInput.readLong();
		decisionNo = objectInput.readUTF();
		content = objectInput.readUTF();
		disciplineType = objectInput.readUTF();
		effectiveDate = objectInput.readLong();
		additionalDisciplineType = objectInput.readUTF();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		deleted = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empDisciplineId);
		objectOutput.writeLong(empId);

		if (decisionNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(decisionNo);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (disciplineType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(disciplineType);
		}

		objectOutput.writeLong(effectiveDate);

		if (additionalDisciplineType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalDisciplineType);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
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
		objectOutput.writeBoolean(deleted);
	}

	public long empDisciplineId;
	public long empId;
	public String decisionNo;
	public String content;
	public String disciplineType;
	public long effectiveDate;
	public String additionalDisciplineType;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;
}