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

package vn.com.ecopharma.hrm.rc.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.ecopharma.hrm.rc.model.Skill;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Skill in entity cache.
 *
 * @author tvt
 * @see Skill
 * @generated
 */
public class SkillCacheModel implements CacheModel<Skill>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{skillId=");
		sb.append(skillId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", grade=");
		sb.append(grade);
		sb.append(", type=");
		sb.append(type);
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
	public Skill toEntityModel() {
		SkillImpl skillImpl = new SkillImpl();

		skillImpl.setSkillId(skillId);
		skillImpl.setCandidateId(candidateId);

		if (grade == null) {
			skillImpl.setGrade(StringPool.BLANK);
		}
		else {
			skillImpl.setGrade(grade);
		}

		if (type == null) {
			skillImpl.setType(StringPool.BLANK);
		}
		else {
			skillImpl.setType(type);
		}

		skillImpl.setGroupId(groupId);
		skillImpl.setCompanyId(companyId);
		skillImpl.setUserId(userId);

		if (userName == null) {
			skillImpl.setUserName(StringPool.BLANK);
		}
		else {
			skillImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			skillImpl.setCreateDate(null);
		}
		else {
			skillImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			skillImpl.setModifiedDate(null);
		}
		else {
			skillImpl.setModifiedDate(new Date(modifiedDate));
		}

		skillImpl.resetOriginalValues();

		return skillImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		skillId = objectInput.readLong();
		candidateId = objectInput.readLong();
		grade = objectInput.readUTF();
		type = objectInput.readUTF();
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
		objectOutput.writeLong(skillId);
		objectOutput.writeLong(candidateId);

		if (grade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grade);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
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

	public long skillId;
	public long candidateId;
	public String grade;
	public String type;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}