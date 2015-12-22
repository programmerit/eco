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

import vn.com.ecopharma.hrm.rc.model.Experience;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Experience in entity cache.
 *
 * @author tvt
 * @see Experience
 * @generated
 */
public class ExperienceCacheModel implements CacheModel<Experience>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{experienceId=");
		sb.append(experienceId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", workingPlace=");
		sb.append(workingPlace);
		sb.append(", yearsExperience=");
		sb.append(yearsExperience);
		sb.append(", tel=");
		sb.append(tel);
		sb.append(", workingFrom=");
		sb.append(workingFrom);
		sb.append(", workingTo=");
		sb.append(workingTo);
		sb.append(", initialTitles=");
		sb.append(initialTitles);
		sb.append(", finalTitles=");
		sb.append(finalTitles);
		sb.append(", initialSalary=");
		sb.append(initialSalary);
		sb.append(", finalSalary=");
		sb.append(finalSalary);
		sb.append(", field=");
		sb.append(field);
		sb.append(", manager=");
		sb.append(manager);
		sb.append(", responsibility=");
		sb.append(responsibility);
		sb.append(", resignedReason=");
		sb.append(resignedReason);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Experience toEntityModel() {
		ExperienceImpl experienceImpl = new ExperienceImpl();

		experienceImpl.setExperienceId(experienceId);

		if (className == null) {
			experienceImpl.setClassName(StringPool.BLANK);
		}
		else {
			experienceImpl.setClassName(className);
		}

		experienceImpl.setClassPK(classPK);

		if (companyName == null) {
			experienceImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			experienceImpl.setCompanyName(companyName);
		}

		if (workingPlace == null) {
			experienceImpl.setWorkingPlace(StringPool.BLANK);
		}
		else {
			experienceImpl.setWorkingPlace(workingPlace);
		}

		experienceImpl.setYearsExperience(yearsExperience);

		if (tel == null) {
			experienceImpl.setTel(StringPool.BLANK);
		}
		else {
			experienceImpl.setTel(tel);
		}

		if (workingFrom == Long.MIN_VALUE) {
			experienceImpl.setWorkingFrom(null);
		}
		else {
			experienceImpl.setWorkingFrom(new Date(workingFrom));
		}

		if (workingTo == Long.MIN_VALUE) {
			experienceImpl.setWorkingTo(null);
		}
		else {
			experienceImpl.setWorkingTo(new Date(workingTo));
		}

		if (initialTitles == null) {
			experienceImpl.setInitialTitles(StringPool.BLANK);
		}
		else {
			experienceImpl.setInitialTitles(initialTitles);
		}

		if (finalTitles == null) {
			experienceImpl.setFinalTitles(StringPool.BLANK);
		}
		else {
			experienceImpl.setFinalTitles(finalTitles);
		}

		experienceImpl.setInitialSalary(initialSalary);
		experienceImpl.setFinalSalary(finalSalary);

		if (field == null) {
			experienceImpl.setField(StringPool.BLANK);
		}
		else {
			experienceImpl.setField(field);
		}

		if (manager == null) {
			experienceImpl.setManager(StringPool.BLANK);
		}
		else {
			experienceImpl.setManager(manager);
		}

		if (responsibility == null) {
			experienceImpl.setResponsibility(StringPool.BLANK);
		}
		else {
			experienceImpl.setResponsibility(responsibility);
		}

		if (resignedReason == null) {
			experienceImpl.setResignedReason(StringPool.BLANK);
		}
		else {
			experienceImpl.setResignedReason(resignedReason);
		}

		if (description == null) {
			experienceImpl.setDescription(StringPool.BLANK);
		}
		else {
			experienceImpl.setDescription(description);
		}

		experienceImpl.setGroupId(groupId);
		experienceImpl.setCompanyId(companyId);
		experienceImpl.setUserId(userId);

		if (userName == null) {
			experienceImpl.setUserName(StringPool.BLANK);
		}
		else {
			experienceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			experienceImpl.setCreateDate(null);
		}
		else {
			experienceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			experienceImpl.setModifiedDate(null);
		}
		else {
			experienceImpl.setModifiedDate(new Date(modifiedDate));
		}

		experienceImpl.resetOriginalValues();

		return experienceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		experienceId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		companyName = objectInput.readUTF();
		workingPlace = objectInput.readUTF();
		yearsExperience = objectInput.readDouble();
		tel = objectInput.readUTF();
		workingFrom = objectInput.readLong();
		workingTo = objectInput.readLong();
		initialTitles = objectInput.readUTF();
		finalTitles = objectInput.readUTF();
		initialSalary = objectInput.readDouble();
		finalSalary = objectInput.readDouble();
		field = objectInput.readUTF();
		manager = objectInput.readUTF();
		responsibility = objectInput.readUTF();
		resignedReason = objectInput.readUTF();
		description = objectInput.readUTF();
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
		objectOutput.writeLong(experienceId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (workingPlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(workingPlace);
		}

		objectOutput.writeDouble(yearsExperience);

		if (tel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tel);
		}

		objectOutput.writeLong(workingFrom);
		objectOutput.writeLong(workingTo);

		if (initialTitles == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(initialTitles);
		}

		if (finalTitles == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(finalTitles);
		}

		objectOutput.writeDouble(initialSalary);
		objectOutput.writeDouble(finalSalary);

		if (field == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field);
		}

		if (manager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(manager);
		}

		if (responsibility == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(responsibility);
		}

		if (resignedReason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resignedReason);
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
	}

	public long experienceId;
	public String className;
	public long classPK;
	public String companyName;
	public String workingPlace;
	public double yearsExperience;
	public String tel;
	public long workingFrom;
	public long workingTo;
	public String initialTitles;
	public String finalTitles;
	public double initialSalary;
	public double finalSalary;
	public String field;
	public String manager;
	public String responsibility;
	public String resignedReason;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}