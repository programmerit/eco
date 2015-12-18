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

package vn.com.ecopharma.emp.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Staff}.
 * </p>
 *
 * @author tvt
 * @see Staff
 * @generated
 */
public class StaffWrapper implements Staff, ModelWrapper<Staff> {
	public StaffWrapper(Staff staff) {
		_staff = staff;
	}

	@Override
	public Class<?> getModelClass() {
		return Staff.class;
	}

	@Override
	public String getModelClassName() {
		return Staff.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("staffId", getStaffId());
		attributes.put("staffCode", getStaffCode());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("birthday", getBirthday());
		attributes.put("joinedDate", getJoinedDate());
		attributes.put("titlesId", getTitlesId());
		attributes.put("levelId", getLevelId());
		attributes.put("promotedDate", getPromotedDate());
		attributes.put("laborContractSignedDate", getLaborContractSignedDate());
		attributes.put("laborContractExpiredDate", getLaborContractExpiredDate());
		attributes.put("laborContractType", getLaborContractType());
		attributes.put("gender", getGender());
		attributes.put("placeOfBirth", getPlaceOfBirth());
		attributes.put("education", getEducation());
		attributes.put("educationSpecialize", getEducationSpecialize());
		attributes.put("universityId", getUniversityId());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("identityCardNo", getIdentityCardNo());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("issuedPlace", getIssuedPlace());
		attributes.put("addressId", getAddressId());
		attributes.put("companyEmail", getCompanyEmail());
		attributes.put("personalTaxCode", getPersonalTaxCode());
		attributes.put("numberOfDependents", getNumberOfDependents());
		attributes.put("dependentNames", getDependentNames());
		attributes.put("socialInsuranceNo", getSocialInsuranceNo());
		attributes.put("healthInsuranceNo", getHealthInsuranceNo());
		attributes.put("bankAccountNo", getBankAccountNo());
		attributes.put("bankBranchName", getBankBranchName());
		attributes.put("baseWageRates", getBaseWageRates());
		attributes.put("positionWageRates", getPositionWageRates());
		attributes.put("capacitySalary", getCapacitySalary());
		attributes.put("totalSalary", getTotalSalary());
		attributes.put("bonus", getBonus());
		attributes.put("resignedDate", getResignedDate());
		attributes.put("staffUserId", getStaffUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());
		attributes.put("companyEmailAddress", getCompanyEmailAddress());
		attributes.put("workingPlaceId", getWorkingPlaceId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long staffId = (Long)attributes.get("staffId");

		if (staffId != null) {
			setStaffId(staffId);
		}

		String staffCode = (String)attributes.get("staffCode");

		if (staffCode != null) {
			setStaffCode(staffCode);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		Date joinedDate = (Date)attributes.get("joinedDate");

		if (joinedDate != null) {
			setJoinedDate(joinedDate);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		Date promotedDate = (Date)attributes.get("promotedDate");

		if (promotedDate != null) {
			setPromotedDate(promotedDate);
		}

		Date laborContractSignedDate = (Date)attributes.get(
				"laborContractSignedDate");

		if (laborContractSignedDate != null) {
			setLaborContractSignedDate(laborContractSignedDate);
		}

		Date laborContractExpiredDate = (Date)attributes.get(
				"laborContractExpiredDate");

		if (laborContractExpiredDate != null) {
			setLaborContractExpiredDate(laborContractExpiredDate);
		}

		String laborContractType = (String)attributes.get("laborContractType");

		if (laborContractType != null) {
			setLaborContractType(laborContractType);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String placeOfBirth = (String)attributes.get("placeOfBirth");

		if (placeOfBirth != null) {
			setPlaceOfBirth(placeOfBirth);
		}

		String education = (String)attributes.get("education");

		if (education != null) {
			setEducation(education);
		}

		String educationSpecialize = (String)attributes.get(
				"educationSpecialize");

		if (educationSpecialize != null) {
			setEducationSpecialize(educationSpecialize);
		}

		Long universityId = (Long)attributes.get("universityId");

		if (universityId != null) {
			setUniversityId(universityId);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		String identityCardNo = (String)attributes.get("identityCardNo");

		if (identityCardNo != null) {
			setIdentityCardNo(identityCardNo);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		String issuedPlace = (String)attributes.get("issuedPlace");

		if (issuedPlace != null) {
			setIssuedPlace(issuedPlace);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		String companyEmail = (String)attributes.get("companyEmail");

		if (companyEmail != null) {
			setCompanyEmail(companyEmail);
		}

		String personalTaxCode = (String)attributes.get("personalTaxCode");

		if (personalTaxCode != null) {
			setPersonalTaxCode(personalTaxCode);
		}

		Integer numberOfDependents = (Integer)attributes.get(
				"numberOfDependents");

		if (numberOfDependents != null) {
			setNumberOfDependents(numberOfDependents);
		}

		String dependentNames = (String)attributes.get("dependentNames");

		if (dependentNames != null) {
			setDependentNames(dependentNames);
		}

		String socialInsuranceNo = (String)attributes.get("socialInsuranceNo");

		if (socialInsuranceNo != null) {
			setSocialInsuranceNo(socialInsuranceNo);
		}

		String healthInsuranceNo = (String)attributes.get("healthInsuranceNo");

		if (healthInsuranceNo != null) {
			setHealthInsuranceNo(healthInsuranceNo);
		}

		String bankAccountNo = (String)attributes.get("bankAccountNo");

		if (bankAccountNo != null) {
			setBankAccountNo(bankAccountNo);
		}

		String bankBranchName = (String)attributes.get("bankBranchName");

		if (bankBranchName != null) {
			setBankBranchName(bankBranchName);
		}

		Double baseWageRates = (Double)attributes.get("baseWageRates");

		if (baseWageRates != null) {
			setBaseWageRates(baseWageRates);
		}

		Double positionWageRates = (Double)attributes.get("positionWageRates");

		if (positionWageRates != null) {
			setPositionWageRates(positionWageRates);
		}

		Double capacitySalary = (Double)attributes.get("capacitySalary");

		if (capacitySalary != null) {
			setCapacitySalary(capacitySalary);
		}

		Double totalSalary = (Double)attributes.get("totalSalary");

		if (totalSalary != null) {
			setTotalSalary(totalSalary);
		}

		Double bonus = (Double)attributes.get("bonus");

		if (bonus != null) {
			setBonus(bonus);
		}

		Date resignedDate = (Date)attributes.get("resignedDate");

		if (resignedDate != null) {
			setResignedDate(resignedDate);
		}

		Long staffUserId = (Long)attributes.get("staffUserId");

		if (staffUserId != null) {
			setStaffUserId(staffUserId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String companyEmailAddress = (String)attributes.get(
				"companyEmailAddress");

		if (companyEmailAddress != null) {
			setCompanyEmailAddress(companyEmailAddress);
		}

		Long workingPlaceId = (Long)attributes.get("workingPlaceId");

		if (workingPlaceId != null) {
			setWorkingPlaceId(workingPlaceId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this staff.
	*
	* @return the primary key of this staff
	*/
	@Override
	public long getPrimaryKey() {
		return _staff.getPrimaryKey();
	}

	/**
	* Sets the primary key of this staff.
	*
	* @param primaryKey the primary key of this staff
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_staff.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the staff ID of this staff.
	*
	* @return the staff ID of this staff
	*/
	@Override
	public long getStaffId() {
		return _staff.getStaffId();
	}

	/**
	* Sets the staff ID of this staff.
	*
	* @param staffId the staff ID of this staff
	*/
	@Override
	public void setStaffId(long staffId) {
		_staff.setStaffId(staffId);
	}

	/**
	* Returns the staff code of this staff.
	*
	* @return the staff code of this staff
	*/
	@Override
	public java.lang.String getStaffCode() {
		return _staff.getStaffCode();
	}

	/**
	* Sets the staff code of this staff.
	*
	* @param staffCode the staff code of this staff
	*/
	@Override
	public void setStaffCode(java.lang.String staffCode) {
		_staff.setStaffCode(staffCode);
	}

	/**
	* Returns the contact number of this staff.
	*
	* @return the contact number of this staff
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _staff.getContactNumber();
	}

	/**
	* Sets the contact number of this staff.
	*
	* @param contactNumber the contact number of this staff
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_staff.setContactNumber(contactNumber);
	}

	/**
	* Returns the birthday of this staff.
	*
	* @return the birthday of this staff
	*/
	@Override
	public java.util.Date getBirthday() {
		return _staff.getBirthday();
	}

	/**
	* Sets the birthday of this staff.
	*
	* @param birthday the birthday of this staff
	*/
	@Override
	public void setBirthday(java.util.Date birthday) {
		_staff.setBirthday(birthday);
	}

	/**
	* Returns the joined date of this staff.
	*
	* @return the joined date of this staff
	*/
	@Override
	public java.util.Date getJoinedDate() {
		return _staff.getJoinedDate();
	}

	/**
	* Sets the joined date of this staff.
	*
	* @param joinedDate the joined date of this staff
	*/
	@Override
	public void setJoinedDate(java.util.Date joinedDate) {
		_staff.setJoinedDate(joinedDate);
	}

	/**
	* Returns the titles ID of this staff.
	*
	* @return the titles ID of this staff
	*/
	@Override
	public long getTitlesId() {
		return _staff.getTitlesId();
	}

	/**
	* Sets the titles ID of this staff.
	*
	* @param titlesId the titles ID of this staff
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_staff.setTitlesId(titlesId);
	}

	/**
	* Returns the level ID of this staff.
	*
	* @return the level ID of this staff
	*/
	@Override
	public long getLevelId() {
		return _staff.getLevelId();
	}

	/**
	* Sets the level ID of this staff.
	*
	* @param levelId the level ID of this staff
	*/
	@Override
	public void setLevelId(long levelId) {
		_staff.setLevelId(levelId);
	}

	/**
	* Returns the promoted date of this staff.
	*
	* @return the promoted date of this staff
	*/
	@Override
	public java.util.Date getPromotedDate() {
		return _staff.getPromotedDate();
	}

	/**
	* Sets the promoted date of this staff.
	*
	* @param promotedDate the promoted date of this staff
	*/
	@Override
	public void setPromotedDate(java.util.Date promotedDate) {
		_staff.setPromotedDate(promotedDate);
	}

	/**
	* Returns the labor contract signed date of this staff.
	*
	* @return the labor contract signed date of this staff
	*/
	@Override
	public java.util.Date getLaborContractSignedDate() {
		return _staff.getLaborContractSignedDate();
	}

	/**
	* Sets the labor contract signed date of this staff.
	*
	* @param laborContractSignedDate the labor contract signed date of this staff
	*/
	@Override
	public void setLaborContractSignedDate(
		java.util.Date laborContractSignedDate) {
		_staff.setLaborContractSignedDate(laborContractSignedDate);
	}

	/**
	* Returns the labor contract expired date of this staff.
	*
	* @return the labor contract expired date of this staff
	*/
	@Override
	public java.util.Date getLaborContractExpiredDate() {
		return _staff.getLaborContractExpiredDate();
	}

	/**
	* Sets the labor contract expired date of this staff.
	*
	* @param laborContractExpiredDate the labor contract expired date of this staff
	*/
	@Override
	public void setLaborContractExpiredDate(
		java.util.Date laborContractExpiredDate) {
		_staff.setLaborContractExpiredDate(laborContractExpiredDate);
	}

	/**
	* Returns the labor contract type of this staff.
	*
	* @return the labor contract type of this staff
	*/
	@Override
	public java.lang.String getLaborContractType() {
		return _staff.getLaborContractType();
	}

	/**
	* Sets the labor contract type of this staff.
	*
	* @param laborContractType the labor contract type of this staff
	*/
	@Override
	public void setLaborContractType(java.lang.String laborContractType) {
		_staff.setLaborContractType(laborContractType);
	}

	/**
	* Returns the gender of this staff.
	*
	* @return the gender of this staff
	*/
	@Override
	public java.lang.String getGender() {
		return _staff.getGender();
	}

	/**
	* Sets the gender of this staff.
	*
	* @param gender the gender of this staff
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_staff.setGender(gender);
	}

	/**
	* Returns the place of birth of this staff.
	*
	* @return the place of birth of this staff
	*/
	@Override
	public java.lang.String getPlaceOfBirth() {
		return _staff.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this staff.
	*
	* @param placeOfBirth the place of birth of this staff
	*/
	@Override
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_staff.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the education of this staff.
	*
	* @return the education of this staff
	*/
	@Override
	public java.lang.String getEducation() {
		return _staff.getEducation();
	}

	/**
	* Sets the education of this staff.
	*
	* @param education the education of this staff
	*/
	@Override
	public void setEducation(java.lang.String education) {
		_staff.setEducation(education);
	}

	/**
	* Returns the education specialize of this staff.
	*
	* @return the education specialize of this staff
	*/
	@Override
	public java.lang.String getEducationSpecialize() {
		return _staff.getEducationSpecialize();
	}

	/**
	* Sets the education specialize of this staff.
	*
	* @param educationSpecialize the education specialize of this staff
	*/
	@Override
	public void setEducationSpecialize(java.lang.String educationSpecialize) {
		_staff.setEducationSpecialize(educationSpecialize);
	}

	/**
	* Returns the university ID of this staff.
	*
	* @return the university ID of this staff
	*/
	@Override
	public long getUniversityId() {
		return _staff.getUniversityId();
	}

	/**
	* Sets the university ID of this staff.
	*
	* @param universityId the university ID of this staff
	*/
	@Override
	public void setUniversityId(long universityId) {
		_staff.setUniversityId(universityId);
	}

	/**
	* Returns the marital status of this staff.
	*
	* @return the marital status of this staff
	*/
	@Override
	public java.lang.String getMaritalStatus() {
		return _staff.getMaritalStatus();
	}

	/**
	* Sets the marital status of this staff.
	*
	* @param maritalStatus the marital status of this staff
	*/
	@Override
	public void setMaritalStatus(java.lang.String maritalStatus) {
		_staff.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the identity card no of this staff.
	*
	* @return the identity card no of this staff
	*/
	@Override
	public java.lang.String getIdentityCardNo() {
		return _staff.getIdentityCardNo();
	}

	/**
	* Sets the identity card no of this staff.
	*
	* @param identityCardNo the identity card no of this staff
	*/
	@Override
	public void setIdentityCardNo(java.lang.String identityCardNo) {
		_staff.setIdentityCardNo(identityCardNo);
	}

	/**
	* Returns the issued date of this staff.
	*
	* @return the issued date of this staff
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _staff.getIssuedDate();
	}

	/**
	* Sets the issued date of this staff.
	*
	* @param issuedDate the issued date of this staff
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_staff.setIssuedDate(issuedDate);
	}

	/**
	* Returns the issued place of this staff.
	*
	* @return the issued place of this staff
	*/
	@Override
	public java.lang.String getIssuedPlace() {
		return _staff.getIssuedPlace();
	}

	/**
	* Sets the issued place of this staff.
	*
	* @param issuedPlace the issued place of this staff
	*/
	@Override
	public void setIssuedPlace(java.lang.String issuedPlace) {
		_staff.setIssuedPlace(issuedPlace);
	}

	/**
	* Returns the address ID of this staff.
	*
	* @return the address ID of this staff
	*/
	@Override
	public long getAddressId() {
		return _staff.getAddressId();
	}

	/**
	* Sets the address ID of this staff.
	*
	* @param addressId the address ID of this staff
	*/
	@Override
	public void setAddressId(long addressId) {
		_staff.setAddressId(addressId);
	}

	/**
	* Returns the company email of this staff.
	*
	* @return the company email of this staff
	*/
	@Override
	public java.lang.String getCompanyEmail() {
		return _staff.getCompanyEmail();
	}

	/**
	* Sets the company email of this staff.
	*
	* @param companyEmail the company email of this staff
	*/
	@Override
	public void setCompanyEmail(java.lang.String companyEmail) {
		_staff.setCompanyEmail(companyEmail);
	}

	/**
	* Returns the personal tax code of this staff.
	*
	* @return the personal tax code of this staff
	*/
	@Override
	public java.lang.String getPersonalTaxCode() {
		return _staff.getPersonalTaxCode();
	}

	/**
	* Sets the personal tax code of this staff.
	*
	* @param personalTaxCode the personal tax code of this staff
	*/
	@Override
	public void setPersonalTaxCode(java.lang.String personalTaxCode) {
		_staff.setPersonalTaxCode(personalTaxCode);
	}

	/**
	* Returns the number of dependents of this staff.
	*
	* @return the number of dependents of this staff
	*/
	@Override
	public int getNumberOfDependents() {
		return _staff.getNumberOfDependents();
	}

	/**
	* Sets the number of dependents of this staff.
	*
	* @param numberOfDependents the number of dependents of this staff
	*/
	@Override
	public void setNumberOfDependents(int numberOfDependents) {
		_staff.setNumberOfDependents(numberOfDependents);
	}

	/**
	* Returns the dependent names of this staff.
	*
	* @return the dependent names of this staff
	*/
	@Override
	public java.lang.String getDependentNames() {
		return _staff.getDependentNames();
	}

	/**
	* Sets the dependent names of this staff.
	*
	* @param dependentNames the dependent names of this staff
	*/
	@Override
	public void setDependentNames(java.lang.String dependentNames) {
		_staff.setDependentNames(dependentNames);
	}

	/**
	* Returns the social insurance no of this staff.
	*
	* @return the social insurance no of this staff
	*/
	@Override
	public java.lang.String getSocialInsuranceNo() {
		return _staff.getSocialInsuranceNo();
	}

	/**
	* Sets the social insurance no of this staff.
	*
	* @param socialInsuranceNo the social insurance no of this staff
	*/
	@Override
	public void setSocialInsuranceNo(java.lang.String socialInsuranceNo) {
		_staff.setSocialInsuranceNo(socialInsuranceNo);
	}

	/**
	* Returns the health insurance no of this staff.
	*
	* @return the health insurance no of this staff
	*/
	@Override
	public java.lang.String getHealthInsuranceNo() {
		return _staff.getHealthInsuranceNo();
	}

	/**
	* Sets the health insurance no of this staff.
	*
	* @param healthInsuranceNo the health insurance no of this staff
	*/
	@Override
	public void setHealthInsuranceNo(java.lang.String healthInsuranceNo) {
		_staff.setHealthInsuranceNo(healthInsuranceNo);
	}

	/**
	* Returns the bank account no of this staff.
	*
	* @return the bank account no of this staff
	*/
	@Override
	public java.lang.String getBankAccountNo() {
		return _staff.getBankAccountNo();
	}

	/**
	* Sets the bank account no of this staff.
	*
	* @param bankAccountNo the bank account no of this staff
	*/
	@Override
	public void setBankAccountNo(java.lang.String bankAccountNo) {
		_staff.setBankAccountNo(bankAccountNo);
	}

	/**
	* Returns the bank branch name of this staff.
	*
	* @return the bank branch name of this staff
	*/
	@Override
	public java.lang.String getBankBranchName() {
		return _staff.getBankBranchName();
	}

	/**
	* Sets the bank branch name of this staff.
	*
	* @param bankBranchName the bank branch name of this staff
	*/
	@Override
	public void setBankBranchName(java.lang.String bankBranchName) {
		_staff.setBankBranchName(bankBranchName);
	}

	/**
	* Returns the base wage rates of this staff.
	*
	* @return the base wage rates of this staff
	*/
	@Override
	public double getBaseWageRates() {
		return _staff.getBaseWageRates();
	}

	/**
	* Sets the base wage rates of this staff.
	*
	* @param baseWageRates the base wage rates of this staff
	*/
	@Override
	public void setBaseWageRates(double baseWageRates) {
		_staff.setBaseWageRates(baseWageRates);
	}

	/**
	* Returns the position wage rates of this staff.
	*
	* @return the position wage rates of this staff
	*/
	@Override
	public double getPositionWageRates() {
		return _staff.getPositionWageRates();
	}

	/**
	* Sets the position wage rates of this staff.
	*
	* @param positionWageRates the position wage rates of this staff
	*/
	@Override
	public void setPositionWageRates(double positionWageRates) {
		_staff.setPositionWageRates(positionWageRates);
	}

	/**
	* Returns the capacity salary of this staff.
	*
	* @return the capacity salary of this staff
	*/
	@Override
	public double getCapacitySalary() {
		return _staff.getCapacitySalary();
	}

	/**
	* Sets the capacity salary of this staff.
	*
	* @param capacitySalary the capacity salary of this staff
	*/
	@Override
	public void setCapacitySalary(double capacitySalary) {
		_staff.setCapacitySalary(capacitySalary);
	}

	/**
	* Returns the total salary of this staff.
	*
	* @return the total salary of this staff
	*/
	@Override
	public double getTotalSalary() {
		return _staff.getTotalSalary();
	}

	/**
	* Sets the total salary of this staff.
	*
	* @param totalSalary the total salary of this staff
	*/
	@Override
	public void setTotalSalary(double totalSalary) {
		_staff.setTotalSalary(totalSalary);
	}

	/**
	* Returns the bonus of this staff.
	*
	* @return the bonus of this staff
	*/
	@Override
	public double getBonus() {
		return _staff.getBonus();
	}

	/**
	* Sets the bonus of this staff.
	*
	* @param bonus the bonus of this staff
	*/
	@Override
	public void setBonus(double bonus) {
		_staff.setBonus(bonus);
	}

	/**
	* Returns the resigned date of this staff.
	*
	* @return the resigned date of this staff
	*/
	@Override
	public java.util.Date getResignedDate() {
		return _staff.getResignedDate();
	}

	/**
	* Sets the resigned date of this staff.
	*
	* @param resignedDate the resigned date of this staff
	*/
	@Override
	public void setResignedDate(java.util.Date resignedDate) {
		_staff.setResignedDate(resignedDate);
	}

	/**
	* Returns the staff user ID of this staff.
	*
	* @return the staff user ID of this staff
	*/
	@Override
	public long getStaffUserId() {
		return _staff.getStaffUserId();
	}

	/**
	* Sets the staff user ID of this staff.
	*
	* @param staffUserId the staff user ID of this staff
	*/
	@Override
	public void setStaffUserId(long staffUserId) {
		_staff.setStaffUserId(staffUserId);
	}

	/**
	* Returns the staff user uuid of this staff.
	*
	* @return the staff user uuid of this staff
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStaffUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staff.getStaffUserUuid();
	}

	/**
	* Sets the staff user uuid of this staff.
	*
	* @param staffUserUuid the staff user uuid of this staff
	*/
	@Override
	public void setStaffUserUuid(java.lang.String staffUserUuid) {
		_staff.setStaffUserUuid(staffUserUuid);
	}

	/**
	* Returns the group ID of this staff.
	*
	* @return the group ID of this staff
	*/
	@Override
	public long getGroupId() {
		return _staff.getGroupId();
	}

	/**
	* Sets the group ID of this staff.
	*
	* @param groupId the group ID of this staff
	*/
	@Override
	public void setGroupId(long groupId) {
		_staff.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this staff.
	*
	* @return the company ID of this staff
	*/
	@Override
	public long getCompanyId() {
		return _staff.getCompanyId();
	}

	/**
	* Sets the company ID of this staff.
	*
	* @param companyId the company ID of this staff
	*/
	@Override
	public void setCompanyId(long companyId) {
		_staff.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this staff.
	*
	* @return the user ID of this staff
	*/
	@Override
	public long getUserId() {
		return _staff.getUserId();
	}

	/**
	* Sets the user ID of this staff.
	*
	* @param userId the user ID of this staff
	*/
	@Override
	public void setUserId(long userId) {
		_staff.setUserId(userId);
	}

	/**
	* Returns the user uuid of this staff.
	*
	* @return the user uuid of this staff
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _staff.getUserUuid();
	}

	/**
	* Sets the user uuid of this staff.
	*
	* @param userUuid the user uuid of this staff
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_staff.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this staff.
	*
	* @return the create date of this staff
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _staff.getCreateDate();
	}

	/**
	* Sets the create date of this staff.
	*
	* @param createDate the create date of this staff
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_staff.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this staff.
	*
	* @return the modified date of this staff
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _staff.getModifiedDate();
	}

	/**
	* Sets the modified date of this staff.
	*
	* @param modifiedDate the modified date of this staff
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_staff.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this staff.
	*
	* @return the deleted of this staff
	*/
	@Override
	public boolean getDeleted() {
		return _staff.getDeleted();
	}

	/**
	* Returns <code>true</code> if this staff is deleted.
	*
	* @return <code>true</code> if this staff is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _staff.isDeleted();
	}

	/**
	* Sets whether this staff is deleted.
	*
	* @param deleted the deleted of this staff
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_staff.setDeleted(deleted);
	}

	/**
	* Returns the company email address of this staff.
	*
	* @return the company email address of this staff
	*/
	@Override
	public java.lang.String getCompanyEmailAddress() {
		return _staff.getCompanyEmailAddress();
	}

	/**
	* Sets the company email address of this staff.
	*
	* @param companyEmailAddress the company email address of this staff
	*/
	@Override
	public void setCompanyEmailAddress(java.lang.String companyEmailAddress) {
		_staff.setCompanyEmailAddress(companyEmailAddress);
	}

	/**
	* Returns the working place ID of this staff.
	*
	* @return the working place ID of this staff
	*/
	@Override
	public long getWorkingPlaceId() {
		return _staff.getWorkingPlaceId();
	}

	/**
	* Sets the working place ID of this staff.
	*
	* @param workingPlaceId the working place ID of this staff
	*/
	@Override
	public void setWorkingPlaceId(long workingPlaceId) {
		_staff.setWorkingPlaceId(workingPlaceId);
	}

	/**
	* Returns the status of this staff.
	*
	* @return the status of this staff
	*/
	@Override
	public java.lang.String getStatus() {
		return _staff.getStatus();
	}

	/**
	* Sets the status of this staff.
	*
	* @param status the status of this staff
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_staff.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _staff.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_staff.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _staff.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_staff.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _staff.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _staff.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_staff.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _staff.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_staff.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_staff.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_staff.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StaffWrapper((Staff)_staff.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Staff staff) {
		return _staff.compareTo(staff);
	}

	@Override
	public int hashCode() {
		return _staff.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Staff> toCacheModel() {
		return _staff.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Staff toEscapedModel() {
		return new StaffWrapper(_staff.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Staff toUnescapedModel() {
		return new StaffWrapper(_staff.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _staff.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _staff.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_staff.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StaffWrapper)) {
			return false;
		}

		StaffWrapper staffWrapper = (StaffWrapper)obj;

		if (Validator.equals(_staff, staffWrapper._staff)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Staff getWrappedStaff() {
		return _staff;
	}

	@Override
	public Staff getWrappedModel() {
		return _staff;
	}

	@Override
	public void resetOriginalValues() {
		_staff.resetOriginalValues();
	}

	private Staff _staff;
}