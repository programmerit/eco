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
		StringBundler sb = new StringBundler(63);

		sb.append("{vacancyId=");
		sb.append(vacancyId);
		sb.append(", approvedNumberOfPosition=");
		sb.append(approvedNumberOfPosition);
		sb.append(", currentNumberOfEmployee=");
		sb.append(currentNumberOfEmployee);
		sb.append(", titlesId=");
		sb.append(titlesId);
		sb.append(", numberOfNewRecruitment=");
		sb.append(numberOfNewRecruitment);
		sb.append(", numberOfReplacedRecruitment=");
		sb.append(numberOfReplacedRecruitment);
		sb.append(", expectedSalary=");
		sb.append(expectedSalary);
		sb.append(", expectedJoinedDate=");
		sb.append(expectedJoinedDate);
		sb.append(", workPlaceId=");
		sb.append(workPlaceId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", requiredGender=");
		sb.append(requiredGender);
		sb.append(", certificateType=");
		sb.append(certificateType);
		sb.append(", specialized=");
		sb.append(specialized);
		sb.append(", experiences=");
		sb.append(experiences);
		sb.append(", foreignLanguages=");
		sb.append(foreignLanguages);
		sb.append(", skills=");
		sb.append(skills);
		sb.append(", officeSkills=");
		sb.append(officeSkills);
		sb.append(", awayToBusinessType=");
		sb.append(awayToBusinessType);
		sb.append(", workingTimeType=");
		sb.append(workingTimeType);
		sb.append(", jobType=");
		sb.append(jobType);
		sb.append(", code=");
		sb.append(code);
		sb.append(", status=");
		sb.append(status);
		sb.append(", postedDate=");
		sb.append(postedDate);
		sb.append(", expiredDate=");
		sb.append(expiredDate);
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
	public Vacancy toEntityModel() {
		VacancyImpl vacancyImpl = new VacancyImpl();

		vacancyImpl.setVacancyId(vacancyId);
		vacancyImpl.setApprovedNumberOfPosition(approvedNumberOfPosition);
		vacancyImpl.setCurrentNumberOfEmployee(currentNumberOfEmployee);
		vacancyImpl.setTitlesId(titlesId);
		vacancyImpl.setNumberOfNewRecruitment(numberOfNewRecruitment);
		vacancyImpl.setNumberOfReplacedRecruitment(numberOfReplacedRecruitment);
		vacancyImpl.setExpectedSalary(expectedSalary);

		if (expectedJoinedDate == Long.MIN_VALUE) {
			vacancyImpl.setExpectedJoinedDate(null);
		}
		else {
			vacancyImpl.setExpectedJoinedDate(new Date(expectedJoinedDate));
		}

		vacancyImpl.setWorkPlaceId(workPlaceId);

		if (description == null) {
			vacancyImpl.setDescription(StringPool.BLANK);
		}
		else {
			vacancyImpl.setDescription(description);
		}

		if (requiredGender == null) {
			vacancyImpl.setRequiredGender(StringPool.BLANK);
		}
		else {
			vacancyImpl.setRequiredGender(requiredGender);
		}

		if (certificateType == null) {
			vacancyImpl.setCertificateType(StringPool.BLANK);
		}
		else {
			vacancyImpl.setCertificateType(certificateType);
		}

		if (specialized == null) {
			vacancyImpl.setSpecialized(StringPool.BLANK);
		}
		else {
			vacancyImpl.setSpecialized(specialized);
		}

		vacancyImpl.setExperiences(experiences);

		if (foreignLanguages == null) {
			vacancyImpl.setForeignLanguages(StringPool.BLANK);
		}
		else {
			vacancyImpl.setForeignLanguages(foreignLanguages);
		}

		if (skills == null) {
			vacancyImpl.setSkills(StringPool.BLANK);
		}
		else {
			vacancyImpl.setSkills(skills);
		}

		if (officeSkills == null) {
			vacancyImpl.setOfficeSkills(StringPool.BLANK);
		}
		else {
			vacancyImpl.setOfficeSkills(officeSkills);
		}

		if (awayToBusinessType == null) {
			vacancyImpl.setAwayToBusinessType(StringPool.BLANK);
		}
		else {
			vacancyImpl.setAwayToBusinessType(awayToBusinessType);
		}

		if (workingTimeType == null) {
			vacancyImpl.setWorkingTimeType(StringPool.BLANK);
		}
		else {
			vacancyImpl.setWorkingTimeType(workingTimeType);
		}

		if (jobType == null) {
			vacancyImpl.setJobType(StringPool.BLANK);
		}
		else {
			vacancyImpl.setJobType(jobType);
		}

		if (code == null) {
			vacancyImpl.setCode(StringPool.BLANK);
		}
		else {
			vacancyImpl.setCode(code);
		}

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

		vacancyImpl.setDeleted(deleted);

		vacancyImpl.resetOriginalValues();

		return vacancyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		vacancyId = objectInput.readLong();
		approvedNumberOfPosition = objectInput.readInt();
		currentNumberOfEmployee = objectInput.readInt();
		titlesId = objectInput.readLong();
		numberOfNewRecruitment = objectInput.readInt();
		numberOfReplacedRecruitment = objectInput.readInt();
		expectedSalary = objectInput.readDouble();
		expectedJoinedDate = objectInput.readLong();
		workPlaceId = objectInput.readLong();
		description = objectInput.readUTF();
		requiredGender = objectInput.readUTF();
		certificateType = objectInput.readUTF();
		specialized = objectInput.readUTF();
		experiences = objectInput.readDouble();
		foreignLanguages = objectInput.readUTF();
		skills = objectInput.readUTF();
		officeSkills = objectInput.readUTF();
		awayToBusinessType = objectInput.readUTF();
		workingTimeType = objectInput.readUTF();
		jobType = objectInput.readUTF();
		code = objectInput.readUTF();
		status = objectInput.readUTF();
		postedDate = objectInput.readLong();
		expiredDate = objectInput.readLong();
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
		objectOutput.writeLong(vacancyId);
		objectOutput.writeInt(approvedNumberOfPosition);
		objectOutput.writeInt(currentNumberOfEmployee);
		objectOutput.writeLong(titlesId);
		objectOutput.writeInt(numberOfNewRecruitment);
		objectOutput.writeInt(numberOfReplacedRecruitment);
		objectOutput.writeDouble(expectedSalary);
		objectOutput.writeLong(expectedJoinedDate);
		objectOutput.writeLong(workPlaceId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (requiredGender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requiredGender);
		}

		if (certificateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateType);
		}

		if (specialized == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(specialized);
		}

		objectOutput.writeDouble(experiences);

		if (foreignLanguages == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(foreignLanguages);
		}

		if (skills == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skills);
		}

		if (officeSkills == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(officeSkills);
		}

		if (awayToBusinessType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(awayToBusinessType);
		}

		if (workingTimeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workingTimeType);
		}

		if (jobType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobType);
		}

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(postedDate);
		objectOutput.writeLong(expiredDate);
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

	public long vacancyId;
	public int approvedNumberOfPosition;
	public int currentNumberOfEmployee;
	public long titlesId;
	public int numberOfNewRecruitment;
	public int numberOfReplacedRecruitment;
	public double expectedSalary;
	public long expectedJoinedDate;
	public long workPlaceId;
	public String description;
	public String requiredGender;
	public String certificateType;
	public String specialized;
	public double experiences;
	public String foreignLanguages;
	public String skills;
	public String officeSkills;
	public String awayToBusinessType;
	public String workingTimeType;
	public String jobType;
	public String code;
	public String status;
	public long postedDate;
	public long expiredDate;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;
}