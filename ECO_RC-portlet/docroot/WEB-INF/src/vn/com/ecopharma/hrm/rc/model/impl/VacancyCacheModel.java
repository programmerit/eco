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

import vn.com.ecopharma.hrm.rc.model.Vacancy;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Vacancy in entity cache.
 *
 * @author tvt
 * @see Vacancy
 * @generated
 */
public class VacancyCacheModel implements CacheModel<Vacancy>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{vacancyId=");
		sb.append(vacancyId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", numberOfPosition=");
		sb.append(numberOfPosition);
		sb.append(", titlesId=");
		sb.append(titlesId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", postedDate=");
		sb.append(postedDate);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", deleted=");
		sb.append(deleted);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", certificateType=");
		sb.append(certificateType);
		sb.append(", experiences=");
		sb.append(experiences);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vacancy toEntityModel() {
		VacancyImpl vacancyImpl = new VacancyImpl();

		vacancyImpl.setVacancyId(vacancyId);

		if (name == null) {
			vacancyImpl.setName(StringPool.BLANK);
		}
		else {
			vacancyImpl.setName(name);
		}

		vacancyImpl.setNumberOfPosition(numberOfPosition);
		vacancyImpl.setTitlesId(titlesId);

		if (status == null) {
			vacancyImpl.setStatus(StringPool.BLANK);
		}
		else {
			vacancyImpl.setStatus(status);
		}

		if (postedDate == Long.MIN_VALUE) {
			vacancyImpl.setPostedDate(null);
		}
		else {
			vacancyImpl.setPostedDate(new Date(postedDate));
		}

		if (expiredDate == Long.MIN_VALUE) {
			vacancyImpl.setExpiredDate(null);
		}
		else {
			vacancyImpl.setExpiredDate(new Date(expiredDate));
		}

		vacancyImpl.setDeleted(deleted);

		if (description == null) {
			vacancyImpl.setDescription(StringPool.BLANK);
		}
		else {
			vacancyImpl.setDescription(description);
		}

		vacancyImpl.setGroupId(groupId);
		vacancyImpl.setCompanyId(companyId);
		vacancyImpl.setUserId(userId);

		if (userName == null) {
			vacancyImpl.setUserName(StringPool.BLANK);
		}
		else {
			vacancyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			vacancyImpl.setCreateDate(null);
		}
		else {
			vacancyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			vacancyImpl.setModifiedDate(null);
		}
		else {
			vacancyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			vacancyImpl.setCode(StringPool.BLANK);
		}
		else {
			vacancyImpl.setCode(code);
		}

		if (certificateType == null) {
			vacancyImpl.setCertificateType(StringPool.BLANK);
		}
		else {
			vacancyImpl.setCertificateType(certificateType);
		}

		vacancyImpl.setExperiences(experiences);

		vacancyImpl.resetOriginalValues();

		return vacancyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vacancyId = objectInput.readLong();
		name = objectInput.readUTF();
		numberOfPosition = objectInput.readInt();
		titlesId = objectInput.readLong();
		status = objectInput.readUTF();
		postedDate = objectInput.readLong();
		expiredDate = objectInput.readLong();
		deleted = objectInput.readBoolean();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		certificateType = objectInput.readUTF();
		experiences = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(vacancyId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(numberOfPosition);
		objectOutput.writeLong(titlesId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(postedDate);
		objectOutput.writeLong(expiredDate);
		objectOutput.writeBoolean(deleted);

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

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (certificateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateType);
		}

		objectOutput.writeDouble(experiences);
	}

	public long vacancyId;
	public String name;
	public int numberOfPosition;
	public long titlesId;
	public String status;
	public long postedDate;
	public long expiredDate;
	public boolean deleted;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String certificateType;
	public double experiences;
}