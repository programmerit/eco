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

import vn.com.ecopharma.emp.model.Certificate;

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
		StringBundler sb = new StringBundler(41);

		sb.append("{certificateId=");
		sb.append(certificateId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", education=");
		sb.append(education);
		sb.append(", certificateType=");
		sb.append(certificateType);
		sb.append(", name=");
		sb.append(name);
		sb.append(", specialize=");
		sb.append(specialize);
		sb.append(", coursePlace=");
		sb.append(coursePlace);
		sb.append(", graduatedYear=");
		sb.append(graduatedYear);
		sb.append(", grade=");
		sb.append(grade);
		sb.append(", courseType=");
		sb.append(courseType);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
		sb.append(", issuedPlace=");
		sb.append(issuedPlace);
		sb.append(", note=");
		sb.append(note);
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

		if (education == null) {
			certificateImpl.setEducation(StringPool.BLANK);
		}
		else {
			certificateImpl.setEducation(education);
		}

		if (certificateType == null) {
			certificateImpl.setCertificateType(StringPool.BLANK);
		}
		else {
			certificateImpl.setCertificateType(certificateType);
		}

		if (name == null) {
			certificateImpl.setName(StringPool.BLANK);
		}
		else {
			certificateImpl.setName(name);
		}

		if (specialize == null) {
			certificateImpl.setSpecialize(StringPool.BLANK);
		}
		else {
			certificateImpl.setSpecialize(specialize);
		}

		certificateImpl.setCoursePlace(coursePlace);

		if (graduatedYear == Long.MIN_VALUE) {
			certificateImpl.setGraduatedYear(null);
		}
		else {
			certificateImpl.setGraduatedYear(new Date(graduatedYear));
		}

		if (grade == null) {
			certificateImpl.setGrade(StringPool.BLANK);
		}
		else {
			certificateImpl.setGrade(grade);
		}

		if (courseType == null) {
			certificateImpl.setCourseType(StringPool.BLANK);
		}
		else {
			certificateImpl.setCourseType(courseType);
		}

		if (expiredDate == Long.MIN_VALUE) {
			certificateImpl.setExpiredDate(null);
		}
		else {
			certificateImpl.setExpiredDate(new Date(expiredDate));
		}

		if (issuedPlace == null) {
			certificateImpl.setIssuedPlace(StringPool.BLANK);
		}
		else {
			certificateImpl.setIssuedPlace(issuedPlace);
		}

		if (note == null) {
			certificateImpl.setNote(StringPool.BLANK);
		}
		else {
			certificateImpl.setNote(note);
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

		certificateImpl.resetOriginalValues();

		return certificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		certificateId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		education = objectInput.readUTF();
		certificateType = objectInput.readUTF();
		name = objectInput.readUTF();
		specialize = objectInput.readUTF();
		coursePlace = objectInput.readLong();
		graduatedYear = objectInput.readLong();
		grade = objectInput.readUTF();
		courseType = objectInput.readUTF();
		expiredDate = objectInput.readLong();
		issuedPlace = objectInput.readUTF();
		note = objectInput.readUTF();
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
		objectOutput.writeLong(certificateId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (education == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(education);
		}

		if (certificateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateType);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (specialize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(specialize);
		}

		objectOutput.writeLong(coursePlace);
		objectOutput.writeLong(graduatedYear);

		if (grade == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(grade);
		}

		if (courseType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseType);
		}

		objectOutput.writeLong(expiredDate);

		if (issuedPlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issuedPlace);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
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

	public long certificateId;
	public String className;
	public long classPK;
	public String education;
	public String certificateType;
	public String name;
	public String specialize;
	public long coursePlace;
	public long graduatedYear;
	public String grade;
	public String courseType;
	public long expiredDate;
	public String issuedPlace;
	public String note;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}