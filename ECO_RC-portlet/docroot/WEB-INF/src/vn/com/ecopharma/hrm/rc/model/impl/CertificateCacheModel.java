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

import vn.com.ecopharma.hrm.rc.model.Certificate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Certificate in entity cache.
 *
 * @author tvt
 * @see Certificate
 * @generated
 */
public class CertificateCacheModel implements CacheModel<Certificate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{certificateId=");
		sb.append(certificateId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", name=");
		sb.append(name);
		sb.append(", certificateType=");
		sb.append(certificateType);
		sb.append(", universityId=");
		sb.append(universityId);
		sb.append(", graduationYear=");
		sb.append(graduationYear);
		sb.append(", grade=");
		sb.append(grade);
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
		sb.append(", courseTimeFrom=");
		sb.append(courseTimeFrom);
		sb.append(", courseTimeTo=");
		sb.append(courseTimeTo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Certificate toEntityModel() {
		CertificateImpl certificateImpl = new CertificateImpl();

		certificateImpl.setCertificateId(certificateId);

		if (className == null) {
			certificateImpl.setClassName(StringPool.BLANK);
		}
		else {
			certificateImpl.setClassName(className);
		}

		certificateImpl.setClassPK(classPK);

		if (name == null) {
			certificateImpl.setName(StringPool.BLANK);
		}
		else {
			certificateImpl.setName(name);
		}

		if (certificateType == null) {
			certificateImpl.setCertificateType(StringPool.BLANK);
		}
		else {
			certificateImpl.setCertificateType(certificateType);
		}

		certificateImpl.setUniversityId(universityId);
		certificateImpl.setGraduationYear(graduationYear);

		if (grade == null) {
			certificateImpl.setGrade(StringPool.BLANK);
		}
		else {
			certificateImpl.setGrade(grade);
		}

		certificateImpl.setGroupId(groupId);
		certificateImpl.setCompanyId(companyId);
		certificateImpl.setUserId(userId);

		if (userName == null) {
			certificateImpl.setUserName(StringPool.BLANK);
		}
		else {
			certificateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			certificateImpl.setCreateDate(null);
		}
		else {
			certificateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			certificateImpl.setModifiedDate(null);
		}
		else {
			certificateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (courseTimeFrom == Long.MIN_VALUE) {
			certificateImpl.setCourseTimeFrom(null);
		}
		else {
			certificateImpl.setCourseTimeFrom(new Date(courseTimeFrom));
		}

		if (courseTimeTo == Long.MIN_VALUE) {
			certificateImpl.setCourseTimeTo(null);
		}
		else {
			certificateImpl.setCourseTimeTo(new Date(courseTimeTo));
		}

		certificateImpl.resetOriginalValues();

		return certificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		certificateId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		name = objectInput.readUTF();
		certificateType = objectInput.readUTF();
		universityId = objectInput.readLong();
		graduationYear = objectInput.readInt();
		grade = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		courseTimeFrom = objectInput.readLong();
		courseTimeTo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(certificateId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (certificateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateType);
		}

		objectOutput.writeLong(universityId);
		objectOutput.writeInt(graduationYear);

		if (grade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grade);
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
		objectOutput.writeLong(courseTimeFrom);
		objectOutput.writeLong(courseTimeTo);
	}

	public long certificateId;
	public String className;
	public long classPK;
	public String name;
	public String certificateType;
	public long universityId;
	public int graduationYear;
	public String grade;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long courseTimeFrom;
	public long courseTimeTo;
}