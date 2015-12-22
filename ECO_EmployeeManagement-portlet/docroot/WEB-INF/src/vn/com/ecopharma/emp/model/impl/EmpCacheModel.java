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

import vn.com.ecopharma.emp.model.Emp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Emp in entity cache.
 *
 * @author tvt
 * @see Emp
 * @generated
 */
public class EmpCacheModel implements CacheModel<Emp>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(101);

		sb.append("{empId=");
		sb.append(empId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", empCode=");
		sb.append(empCode);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", ethnic=");
		sb.append(ethnic);
		sb.append(", nationality=");
		sb.append(nationality);
		sb.append(", religion=");
		sb.append(religion);
		sb.append(", joinedDate=");
		sb.append(joinedDate);
		sb.append(", titlesId=");
		sb.append(titlesId);
		sb.append(", levelId=");
		sb.append(levelId);
		sb.append(", promotedDate=");
		sb.append(promotedDate);
		sb.append(", laborContractSignedDate=");
		sb.append(laborContractSignedDate);
		sb.append(", laborContractExpiredDate=");
		sb.append(laborContractExpiredDate);
		sb.append(", laborContractSignedTime=");
		sb.append(laborContractSignedTime);
		sb.append(", laborContractType=");
		sb.append(laborContractType);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", placeOfBirth=");
		sb.append(placeOfBirth);
		sb.append(", education=");
		sb.append(education);
		sb.append(", educationSpecialize=");
		sb.append(educationSpecialize);
		sb.append(", universityId=");
		sb.append(universityId);
		sb.append(", maritalStatus=");
		sb.append(maritalStatus);
		sb.append(", identityCardNo=");
		sb.append(identityCardNo);
		sb.append(", issuedDate=");
		sb.append(issuedDate);
		sb.append(", issuedPlace=");
		sb.append(issuedPlace);
		sb.append(", passport=");
		sb.append(passport);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", companyEmail=");
		sb.append(companyEmail);
		sb.append(", personalTaxCode=");
		sb.append(personalTaxCode);
		sb.append(", numberOfDependents=");
		sb.append(numberOfDependents);
		sb.append(", dependentNames=");
		sb.append(dependentNames);
		sb.append(", socialInsuranceNo=");
		sb.append(socialInsuranceNo);
		sb.append(", healthInsuranceNo=");
		sb.append(healthInsuranceNo);
		sb.append(", healthInsurancePlace=");
		sb.append(healthInsurancePlace);
		sb.append(", baseWageRates=");
		sb.append(baseWageRates);
		sb.append(", positionWageRates=");
		sb.append(positionWageRates);
		sb.append(", capacitySalary=");
		sb.append(capacitySalary);
		sb.append(", totalSalary=");
		sb.append(totalSalary);
		sb.append(", bonus=");
		sb.append(bonus);
		sb.append(", resignedDate=");
		sb.append(resignedDate);
		sb.append(", empUserId=");
		sb.append(empUserId);
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append(", companyEmailAddress=");
		sb.append(companyEmailAddress);
		sb.append(", workingPlaceId=");
		sb.append(workingPlaceId);
		sb.append(", status=");
		sb.append(status);
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
	public Emp toEntityModel() {
		EmpImpl empImpl = new EmpImpl();

		empImpl.setEmpId(empId);
		empImpl.setGroupId(groupId);

		if (empCode == null) {
			empImpl.setEmpCode(StringPool.BLANK);
		}
		else {
			empImpl.setEmpCode(empCode);
		}

		if (contactNumber == null) {
			empImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			empImpl.setContactNumber(contactNumber);
		}

		if (birthday == Long.MIN_VALUE) {
			empImpl.setBirthday(null);
		}
		else {
			empImpl.setBirthday(new Date(birthday));
		}

		if (ethnic == null) {
			empImpl.setEthnic(StringPool.BLANK);
		}
		else {
			empImpl.setEthnic(ethnic);
		}

		if (nationality == null) {
			empImpl.setNationality(StringPool.BLANK);
		}
		else {
			empImpl.setNationality(nationality);
		}

		if (religion == null) {
			empImpl.setReligion(StringPool.BLANK);
		}
		else {
			empImpl.setReligion(religion);
		}

		if (joinedDate == Long.MIN_VALUE) {
			empImpl.setJoinedDate(null);
		}
		else {
			empImpl.setJoinedDate(new Date(joinedDate));
		}

		empImpl.setTitlesId(titlesId);
		empImpl.setLevelId(levelId);

		if (promotedDate == Long.MIN_VALUE) {
			empImpl.setPromotedDate(null);
		}
		else {
			empImpl.setPromotedDate(new Date(promotedDate));
		}

		if (laborContractSignedDate == Long.MIN_VALUE) {
			empImpl.setLaborContractSignedDate(null);
		}
		else {
			empImpl.setLaborContractSignedDate(new Date(laborContractSignedDate));
		}

		if (laborContractExpiredDate == Long.MIN_VALUE) {
			empImpl.setLaborContractExpiredDate(null);
		}
		else {
			empImpl.setLaborContractExpiredDate(new Date(
					laborContractExpiredDate));
		}

		empImpl.setLaborContractSignedTime(laborContractSignedTime);

		if (laborContractType == null) {
			empImpl.setLaborContractType(StringPool.BLANK);
		}
		else {
			empImpl.setLaborContractType(laborContractType);
		}

		if (gender == null) {
			empImpl.setGender(StringPool.BLANK);
		}
		else {
			empImpl.setGender(gender);
		}

		if (placeOfBirth == null) {
			empImpl.setPlaceOfBirth(StringPool.BLANK);
		}
		else {
			empImpl.setPlaceOfBirth(placeOfBirth);
		}

		if (education == null) {
			empImpl.setEducation(StringPool.BLANK);
		}
		else {
			empImpl.setEducation(education);
		}

		if (educationSpecialize == null) {
			empImpl.setEducationSpecialize(StringPool.BLANK);
		}
		else {
			empImpl.setEducationSpecialize(educationSpecialize);
		}

		empImpl.setUniversityId(universityId);

		if (maritalStatus == null) {
			empImpl.setMaritalStatus(StringPool.BLANK);
		}
		else {
			empImpl.setMaritalStatus(maritalStatus);
		}

		if (identityCardNo == null) {
			empImpl.setIdentityCardNo(StringPool.BLANK);
		}
		else {
			empImpl.setIdentityCardNo(identityCardNo);
		}

		if (issuedDate == Long.MIN_VALUE) {
			empImpl.setIssuedDate(null);
		}
		else {
			empImpl.setIssuedDate(new Date(issuedDate));
		}

		if (issuedPlace == null) {
			empImpl.setIssuedPlace(StringPool.BLANK);
		}
		else {
			empImpl.setIssuedPlace(issuedPlace);
		}

		if (passport == null) {
			empImpl.setPassport(StringPool.BLANK);
		}
		else {
			empImpl.setPassport(passport);
		}

		empImpl.setAddressId(addressId);

		if (companyEmail == null) {
			empImpl.setCompanyEmail(StringPool.BLANK);
		}
		else {
			empImpl.setCompanyEmail(companyEmail);
		}

		if (personalTaxCode == null) {
			empImpl.setPersonalTaxCode(StringPool.BLANK);
		}
		else {
			empImpl.setPersonalTaxCode(personalTaxCode);
		}

		empImpl.setNumberOfDependents(numberOfDependents);

		if (dependentNames == null) {
			empImpl.setDependentNames(StringPool.BLANK);
		}
		else {
			empImpl.setDependentNames(dependentNames);
		}

		if (socialInsuranceNo == null) {
			empImpl.setSocialInsuranceNo(StringPool.BLANK);
		}
		else {
			empImpl.setSocialInsuranceNo(socialInsuranceNo);
		}

		if (healthInsuranceNo == null) {
			empImpl.setHealthInsuranceNo(StringPool.BLANK);
		}
		else {
			empImpl.setHealthInsuranceNo(healthInsuranceNo);
		}

		if (healthInsurancePlace == null) {
			empImpl.setHealthInsurancePlace(StringPool.BLANK);
		}
		else {
			empImpl.setHealthInsurancePlace(healthInsurancePlace);
		}

		empImpl.setBaseWageRates(baseWageRates);
		empImpl.setPositionWageRates(positionWageRates);
		empImpl.setCapacitySalary(capacitySalary);
		empImpl.setTotalSalary(totalSalary);
		empImpl.setBonus(bonus);

		if (resignedDate == Long.MIN_VALUE) {
			empImpl.setResignedDate(null);
		}
		else {
			empImpl.setResignedDate(new Date(resignedDate));
		}

		empImpl.setEmpUserId(empUserId);
		empImpl.setDeleted(deleted);

		if (companyEmailAddress == null) {
			empImpl.setCompanyEmailAddress(StringPool.BLANK);
		}
		else {
			empImpl.setCompanyEmailAddress(companyEmailAddress);
		}

		empImpl.setWorkingPlaceId(workingPlaceId);

		if (status == null) {
			empImpl.setStatus(StringPool.BLANK);
		}
		else {
			empImpl.setStatus(status);
		}

		empImpl.setCompanyId(companyId);
		empImpl.setUserId(userId);

		if (userName == null) {
			empImpl.setUserName(StringPool.BLANK);
		}
		else {
			empImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			empImpl.setCreateDate(null);
		}
		else {
			empImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			empImpl.setModifiedDate(null);
		}
		else {
			empImpl.setModifiedDate(new Date(modifiedDate));
		}

		empImpl.resetOriginalValues();

		return empImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empId = objectInput.readLong();
		groupId = objectInput.readLong();
		empCode = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		birthday = objectInput.readLong();
		ethnic = objectInput.readUTF();
		nationality = objectInput.readUTF();
		religion = objectInput.readUTF();
		joinedDate = objectInput.readLong();
		titlesId = objectInput.readLong();
		levelId = objectInput.readLong();
		promotedDate = objectInput.readLong();
		laborContractSignedDate = objectInput.readLong();
		laborContractExpiredDate = objectInput.readLong();
		laborContractSignedTime = objectInput.readInt();
		laborContractType = objectInput.readUTF();
		gender = objectInput.readUTF();
		placeOfBirth = objectInput.readUTF();
		education = objectInput.readUTF();
		educationSpecialize = objectInput.readUTF();
		universityId = objectInput.readLong();
		maritalStatus = objectInput.readUTF();
		identityCardNo = objectInput.readUTF();
		issuedDate = objectInput.readLong();
		issuedPlace = objectInput.readUTF();
		passport = objectInput.readUTF();
		addressId = objectInput.readLong();
		companyEmail = objectInput.readUTF();
		personalTaxCode = objectInput.readUTF();
		numberOfDependents = objectInput.readInt();
		dependentNames = objectInput.readUTF();
		socialInsuranceNo = objectInput.readUTF();
		healthInsuranceNo = objectInput.readUTF();
		healthInsurancePlace = objectInput.readUTF();
		baseWageRates = objectInput.readDouble();
		positionWageRates = objectInput.readDouble();
		capacitySalary = objectInput.readDouble();
		totalSalary = objectInput.readDouble();
		bonus = objectInput.readDouble();
		resignedDate = objectInput.readLong();
		empUserId = objectInput.readLong();
		deleted = objectInput.readBoolean();
		companyEmailAddress = objectInput.readUTF();
		workingPlaceId = objectInput.readLong();
		status = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empId);
		objectOutput.writeLong(groupId);

		if (empCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(empCode);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		objectOutput.writeLong(birthday);

		if (ethnic == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ethnic);
		}

		if (nationality == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nationality);
		}

		if (religion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(religion);
		}

		objectOutput.writeLong(joinedDate);
		objectOutput.writeLong(titlesId);
		objectOutput.writeLong(levelId);
		objectOutput.writeLong(promotedDate);
		objectOutput.writeLong(laborContractSignedDate);
		objectOutput.writeLong(laborContractExpiredDate);
		objectOutput.writeInt(laborContractSignedTime);

		if (laborContractType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(laborContractType);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (placeOfBirth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(placeOfBirth);
		}

		if (education == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(education);
		}

		if (educationSpecialize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(educationSpecialize);
		}

		objectOutput.writeLong(universityId);

		if (maritalStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maritalStatus);
		}

		if (identityCardNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identityCardNo);
		}

		objectOutput.writeLong(issuedDate);

		if (issuedPlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(issuedPlace);
		}

		if (passport == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passport);
		}

		objectOutput.writeLong(addressId);

		if (companyEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyEmail);
		}

		if (personalTaxCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personalTaxCode);
		}

		objectOutput.writeInt(numberOfDependents);

		if (dependentNames == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dependentNames);
		}

		if (socialInsuranceNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(socialInsuranceNo);
		}

		if (healthInsuranceNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(healthInsuranceNo);
		}

		if (healthInsurancePlace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(healthInsurancePlace);
		}

		objectOutput.writeDouble(baseWageRates);
		objectOutput.writeDouble(positionWageRates);
		objectOutput.writeDouble(capacitySalary);
		objectOutput.writeDouble(totalSalary);
		objectOutput.writeDouble(bonus);
		objectOutput.writeLong(resignedDate);
		objectOutput.writeLong(empUserId);
		objectOutput.writeBoolean(deleted);

		if (companyEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyEmailAddress);
		}

		objectOutput.writeLong(workingPlaceId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

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

	public long empId;
	public long groupId;
	public String empCode;
	public String contactNumber;
	public long birthday;
	public String ethnic;
	public String nationality;
	public String religion;
	public long joinedDate;
	public long titlesId;
	public long levelId;
	public long promotedDate;
	public long laborContractSignedDate;
	public long laborContractExpiredDate;
	public int laborContractSignedTime;
	public String laborContractType;
	public String gender;
	public String placeOfBirth;
	public String education;
	public String educationSpecialize;
	public long universityId;
	public String maritalStatus;
	public String identityCardNo;
	public long issuedDate;
	public String issuedPlace;
	public String passport;
	public long addressId;
	public String companyEmail;
	public String personalTaxCode;
	public int numberOfDependents;
	public String dependentNames;
	public String socialInsuranceNo;
	public String healthInsuranceNo;
	public String healthInsurancePlace;
	public double baseWageRates;
	public double positionWageRates;
	public double capacitySalary;
	public double totalSalary;
	public double bonus;
	public long resignedDate;
	public long empUserId;
	public boolean deleted;
	public String companyEmailAddress;
	public long workingPlaceId;
	public String status;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}