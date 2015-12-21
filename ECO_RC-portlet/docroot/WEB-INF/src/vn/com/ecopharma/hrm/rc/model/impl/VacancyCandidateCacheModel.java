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

import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VacancyCandidate in entity cache.
 *
 * @author tvt
 * @see VacancyCandidate
 * @generated
 */
public class VacancyCandidateCacheModel implements CacheModel<VacancyCandidate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{vacancyCandidateId=");
		sb.append(vacancyCandidateId);
		sb.append(", vacancyId=");
		sb.append(vacancyId);
		sb.append(", candidateId=");
		sb.append(candidateId);
		sb.append(", status=");
		sb.append(status);
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
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VacancyCandidate toEntityModel() {
		VacancyCandidateImpl vacancyCandidateImpl = new VacancyCandidateImpl();

		vacancyCandidateImpl.setVacancyCandidateId(vacancyCandidateId);
		vacancyCandidateImpl.setVacancyId(vacancyId);
		vacancyCandidateImpl.setCandidateId(candidateId);
		vacancyCandidateImpl.setStatus(status);
		vacancyCandidateImpl.setGroupId(groupId);
		vacancyCandidateImpl.setCompanyId(companyId);
		vacancyCandidateImpl.setUserId(userId);

		if (userName == null) {
			vacancyCandidateImpl.setUserName(StringPool.BLANK);
		}
		else {
			vacancyCandidateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vacancyCandidateImpl.setCreateDate(null);
		}
		else {
			vacancyCandidateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vacancyCandidateImpl.setModifiedDate(null);
		}
		else {
			vacancyCandidateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			vacancyCandidateImpl.setType(StringPool.BLANK);
		}
		else {
			vacancyCandidateImpl.setType(type);
		}

		vacancyCandidateImpl.resetOriginalValues();

		return vacancyCandidateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vacancyCandidateId = objectInput.readLong();
		vacancyId = objectInput.readLong();
		candidateId = objectInput.readLong();
		status = objectInput.readInt();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vacancyCandidateId);
		objectOutput.writeLong(vacancyId);
		objectOutput.writeLong(candidateId);
		objectOutput.writeInt(status);
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

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public long vacancyCandidateId;
	public long vacancyId;
	public long candidateId;
	public int status;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;
}