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
 * This class is a wrapper for {@link Emp}.
 * </p>
 *
 * @author tvt
 * @see Emp
 * @generated
 */
public class EmpWrapper implements Emp, ModelWrapper<Emp> {
	public EmpWrapper(Emp emp) {
		_emp = emp;
	}

	@Override
	public Class<?> getModelClass() {
		return Emp.class;
	}

	@Override
	public String getModelClassName() {
		return Emp.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empId", getEmpId());
		attributes.put("groupId", getGroupId());
		attributes.put("empCode", getEmpCode());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("birthday", getBirthday());
		attributes.put("ethnic", getEthnic());
		attributes.put("nationality", getNationality());
		attributes.put("religion", getReligion());
		attributes.put("joinedDate", getJoinedDate());
		attributes.put("titlesId", getTitlesId());
		attributes.put("levelId", getLevelId());
		attributes.put("promotedDate", getPromotedDate());
		attributes.put("laborContractSignedDate", getLaborContractSignedDate());
		attributes.put("laborContractExpiredDate", getLaborContractExpiredDate());
		attributes.put("laborContractSignedTime", getLaborContractSignedTime());
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
		attributes.put("passport", getPassport());
		attributes.put("addressId", getAddressId());
		attributes.put("companyEmail", getCompanyEmail());
		attributes.put("personalTaxCode", getPersonalTaxCode());
		attributes.put("numberOfDependents", getNumberOfDependents());
		attributes.put("dependentNames", getDependentNames());
		attributes.put("socialInsuranceNo", getSocialInsuranceNo());
		attributes.put("healthInsuranceNo", getHealthInsuranceNo());
		attributes.put("healthInsurancePlace", getHealthInsurancePlace());
		attributes.put("baseWageRates", getBaseWageRates());
		attributes.put("positionWageRates", getPositionWageRates());
		attributes.put("capacitySalary", getCapacitySalary());
		attributes.put("totalSalary", getTotalSalary());
		attributes.put("bonus", getBonus());
		attributes.put("resignedDate", getResignedDate());
		attributes.put("empUserId", getEmpUserId());
		attributes.put("deleted", getDeleted());
		attributes.put("companyEmailAddress", getCompanyEmailAddress());
		attributes.put("workingPlaceId", getWorkingPlaceId());
		attributes.put("status", getStatus());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("unitId", getUnitId());
		attributes.put("unitGroupId", getUnitGroupId());
		attributes.put("departmentId", getDepartmentId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String empCode = (String)attributes.get("empCode");

		if (empCode != null) {
			setEmpCode(empCode);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String ethnic = (String)attributes.get("ethnic");

		if (ethnic != null) {
			setEthnic(ethnic);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String religion = (String)attributes.get("religion");

		if (religion != null) {
			setReligion(religion);
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

		Integer laborContractSignedTime = (Integer)attributes.get(
				"laborContractSignedTime");

		if (laborContractSignedTime != null) {
			setLaborContractSignedTime(laborContractSignedTime);
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

		String passport = (String)attributes.get("passport");

		if (passport != null) {
			setPassport(passport);
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

		String healthInsurancePlace = (String)attributes.get(
				"healthInsurancePlace");

		if (healthInsurancePlace != null) {
			setHealthInsurancePlace(healthInsurancePlace);
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

		Long empUserId = (Long)attributes.get("empUserId");

		if (empUserId != null) {
			setEmpUserId(empUserId);
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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}
	}

	/**
	* Returns the primary key of this emp.
	*
	* @return the primary key of this emp
	*/
	@Override
	public long getPrimaryKey() {
		return _emp.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp.
	*
	* @param primaryKey the primary key of this emp
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_emp.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp ID of this emp.
	*
	* @return the emp ID of this emp
	*/
	@Override
	public long getEmpId() {
		return _emp.getEmpId();
	}

	/**
	* Sets the emp ID of this emp.
	*
	* @param empId the emp ID of this emp
	*/
	@Override
	public void setEmpId(long empId) {
		_emp.setEmpId(empId);
	}

	/**
	* Returns the group ID of this emp.
	*
	* @return the group ID of this emp
	*/
	@Override
	public long getGroupId() {
		return _emp.getGroupId();
	}

	/**
	* Sets the group ID of this emp.
	*
	* @param groupId the group ID of this emp
	*/
	@Override
	public void setGroupId(long groupId) {
		_emp.setGroupId(groupId);
	}

	/**
	* Returns the emp code of this emp.
	*
	* @return the emp code of this emp
	*/
	@Override
	public java.lang.String getEmpCode() {
		return _emp.getEmpCode();
	}

	/**
	* Sets the emp code of this emp.
	*
	* @param empCode the emp code of this emp
	*/
	@Override
	public void setEmpCode(java.lang.String empCode) {
		_emp.setEmpCode(empCode);
	}

	/**
	* Returns the contact number of this emp.
	*
	* @return the contact number of this emp
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _emp.getContactNumber();
	}

	/**
	* Sets the contact number of this emp.
	*
	* @param contactNumber the contact number of this emp
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_emp.setContactNumber(contactNumber);
	}

	/**
	* Returns the birthday of this emp.
	*
	* @return the birthday of this emp
	*/
	@Override
	public java.util.Date getBirthday() {
		return _emp.getBirthday();
	}

	/**
	* Sets the birthday of this emp.
	*
	* @param birthday the birthday of this emp
	*/
	@Override
	public void setBirthday(java.util.Date birthday) {
		_emp.setBirthday(birthday);
	}

	/**
	* Returns the ethnic of this emp.
	*
	* @return the ethnic of this emp
	*/
	@Override
	public java.lang.String getEthnic() {
		return _emp.getEthnic();
	}

	/**
	* Sets the ethnic of this emp.
	*
	* @param ethnic the ethnic of this emp
	*/
	@Override
	public void setEthnic(java.lang.String ethnic) {
		_emp.setEthnic(ethnic);
	}

	/**
	* Returns the nationality of this emp.
	*
	* @return the nationality of this emp
	*/
	@Override
	public java.lang.String getNationality() {
		return _emp.getNationality();
	}

	/**
	* Sets the nationality of this emp.
	*
	* @param nationality the nationality of this emp
	*/
	@Override
	public void setNationality(java.lang.String nationality) {
		_emp.setNationality(nationality);
	}

	/**
	* Returns the religion of this emp.
	*
	* @return the religion of this emp
	*/
	@Override
	public java.lang.String getReligion() {
		return _emp.getReligion();
	}

	/**
	* Sets the religion of this emp.
	*
	* @param religion the religion of this emp
	*/
	@Override
	public void setReligion(java.lang.String religion) {
		_emp.setReligion(religion);
	}

	/**
	* Returns the joined date of this emp.
	*
	* @return the joined date of this emp
	*/
	@Override
	public java.util.Date getJoinedDate() {
		return _emp.getJoinedDate();
	}

	/**
	* Sets the joined date of this emp.
	*
	* @param joinedDate the joined date of this emp
	*/
	@Override
	public void setJoinedDate(java.util.Date joinedDate) {
		_emp.setJoinedDate(joinedDate);
	}

	/**
	* Returns the titles ID of this emp.
	*
	* @return the titles ID of this emp
	*/
	@Override
	public long getTitlesId() {
		return _emp.getTitlesId();
	}

	/**
	* Sets the titles ID of this emp.
	*
	* @param titlesId the titles ID of this emp
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_emp.setTitlesId(titlesId);
	}

	/**
	* Returns the level ID of this emp.
	*
	* @return the level ID of this emp
	*/
	@Override
	public long getLevelId() {
		return _emp.getLevelId();
	}

	/**
	* Sets the level ID of this emp.
	*
	* @param levelId the level ID of this emp
	*/
	@Override
	public void setLevelId(long levelId) {
		_emp.setLevelId(levelId);
	}

	/**
	* Returns the promoted date of this emp.
	*
	* @return the promoted date of this emp
	*/
	@Override
	public java.util.Date getPromotedDate() {
		return _emp.getPromotedDate();
	}

	/**
	* Sets the promoted date of this emp.
	*
	* @param promotedDate the promoted date of this emp
	*/
	@Override
	public void setPromotedDate(java.util.Date promotedDate) {
		_emp.setPromotedDate(promotedDate);
	}

	/**
	* Returns the labor contract signed date of this emp.
	*
	* @return the labor contract signed date of this emp
	*/
	@Override
	public java.util.Date getLaborContractSignedDate() {
		return _emp.getLaborContractSignedDate();
	}

	/**
	* Sets the labor contract signed date of this emp.
	*
	* @param laborContractSignedDate the labor contract signed date of this emp
	*/
	@Override
	public void setLaborContractSignedDate(
		java.util.Date laborContractSignedDate) {
		_emp.setLaborContractSignedDate(laborContractSignedDate);
	}

	/**
	* Returns the labor contract expired date of this emp.
	*
	* @return the labor contract expired date of this emp
	*/
	@Override
	public java.util.Date getLaborContractExpiredDate() {
		return _emp.getLaborContractExpiredDate();
	}

	/**
	* Sets the labor contract expired date of this emp.
	*
	* @param laborContractExpiredDate the labor contract expired date of this emp
	*/
	@Override
	public void setLaborContractExpiredDate(
		java.util.Date laborContractExpiredDate) {
		_emp.setLaborContractExpiredDate(laborContractExpiredDate);
	}

	/**
	* Returns the labor contract signed time of this emp.
	*
	* @return the labor contract signed time of this emp
	*/
	@Override
	public int getLaborContractSignedTime() {
		return _emp.getLaborContractSignedTime();
	}

	/**
	* Sets the labor contract signed time of this emp.
	*
	* @param laborContractSignedTime the labor contract signed time of this emp
	*/
	@Override
	public void setLaborContractSignedTime(int laborContractSignedTime) {
		_emp.setLaborContractSignedTime(laborContractSignedTime);
	}

	/**
	* Returns the labor contract type of this emp.
	*
	* @return the labor contract type of this emp
	*/
	@Override
	public java.lang.String getLaborContractType() {
		return _emp.getLaborContractType();
	}

	/**
	* Sets the labor contract type of this emp.
	*
	* @param laborContractType the labor contract type of this emp
	*/
	@Override
	public void setLaborContractType(java.lang.String laborContractType) {
		_emp.setLaborContractType(laborContractType);
	}

	/**
	* Returns the gender of this emp.
	*
	* @return the gender of this emp
	*/
	@Override
	public java.lang.String getGender() {
		return _emp.getGender();
	}

	/**
	* Sets the gender of this emp.
	*
	* @param gender the gender of this emp
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_emp.setGender(gender);
	}

	/**
	* Returns the place of birth of this emp.
	*
	* @return the place of birth of this emp
	*/
	@Override
	public java.lang.String getPlaceOfBirth() {
		return _emp.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this emp.
	*
	* @param placeOfBirth the place of birth of this emp
	*/
	@Override
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_emp.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the education of this emp.
	*
	* @return the education of this emp
	*/
	@Override
	public java.lang.String getEducation() {
		return _emp.getEducation();
	}

	/**
	* Sets the education of this emp.
	*
	* @param education the education of this emp
	*/
	@Override
	public void setEducation(java.lang.String education) {
		_emp.setEducation(education);
	}

	/**
	* Returns the education specialize of this emp.
	*
	* @return the education specialize of this emp
	*/
	@Override
	public java.lang.String getEducationSpecialize() {
		return _emp.getEducationSpecialize();
	}

	/**
	* Sets the education specialize of this emp.
	*
	* @param educationSpecialize the education specialize of this emp
	*/
	@Override
	public void setEducationSpecialize(java.lang.String educationSpecialize) {
		_emp.setEducationSpecialize(educationSpecialize);
	}

	/**
	* Returns the university ID of this emp.
	*
	* @return the university ID of this emp
	*/
	@Override
	public long getUniversityId() {
		return _emp.getUniversityId();
	}

	/**
	* Sets the university ID of this emp.
	*
	* @param universityId the university ID of this emp
	*/
	@Override
	public void setUniversityId(long universityId) {
		_emp.setUniversityId(universityId);
	}

	/**
	* Returns the marital status of this emp.
	*
	* @return the marital status of this emp
	*/
	@Override
	public java.lang.String getMaritalStatus() {
		return _emp.getMaritalStatus();
	}

	/**
	* Sets the marital status of this emp.
	*
	* @param maritalStatus the marital status of this emp
	*/
	@Override
	public void setMaritalStatus(java.lang.String maritalStatus) {
		_emp.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the identity card no of this emp.
	*
	* @return the identity card no of this emp
	*/
	@Override
	public java.lang.String getIdentityCardNo() {
		return _emp.getIdentityCardNo();
	}

	/**
	* Sets the identity card no of this emp.
	*
	* @param identityCardNo the identity card no of this emp
	*/
	@Override
	public void setIdentityCardNo(java.lang.String identityCardNo) {
		_emp.setIdentityCardNo(identityCardNo);
	}

	/**
	* Returns the issued date of this emp.
	*
	* @return the issued date of this emp
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _emp.getIssuedDate();
	}

	/**
	* Sets the issued date of this emp.
	*
	* @param issuedDate the issued date of this emp
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_emp.setIssuedDate(issuedDate);
	}

	/**
	* Returns the issued place of this emp.
	*
	* @return the issued place of this emp
	*/
	@Override
	public java.lang.String getIssuedPlace() {
		return _emp.getIssuedPlace();
	}

	/**
	* Sets the issued place of this emp.
	*
	* @param issuedPlace the issued place of this emp
	*/
	@Override
	public void setIssuedPlace(java.lang.String issuedPlace) {
		_emp.setIssuedPlace(issuedPlace);
	}

	/**
	* Returns the passport of this emp.
	*
	* @return the passport of this emp
	*/
	@Override
	public java.lang.String getPassport() {
		return _emp.getPassport();
	}

	/**
	* Sets the passport of this emp.
	*
	* @param passport the passport of this emp
	*/
	@Override
	public void setPassport(java.lang.String passport) {
		_emp.setPassport(passport);
	}

	/**
	* Returns the address ID of this emp.
	*
	* @return the address ID of this emp
	*/
	@Override
	public long getAddressId() {
		return _emp.getAddressId();
	}

	/**
	* Sets the address ID of this emp.
	*
	* @param addressId the address ID of this emp
	*/
	@Override
	public void setAddressId(long addressId) {
		_emp.setAddressId(addressId);
	}

	/**
	* Returns the company email of this emp.
	*
	* @return the company email of this emp
	*/
	@Override
	public java.lang.String getCompanyEmail() {
		return _emp.getCompanyEmail();
	}

	/**
	* Sets the company email of this emp.
	*
	* @param companyEmail the company email of this emp
	*/
	@Override
	public void setCompanyEmail(java.lang.String companyEmail) {
		_emp.setCompanyEmail(companyEmail);
	}

	/**
	* Returns the personal tax code of this emp.
	*
	* @return the personal tax code of this emp
	*/
	@Override
	public java.lang.String getPersonalTaxCode() {
		return _emp.getPersonalTaxCode();
	}

	/**
	* Sets the personal tax code of this emp.
	*
	* @param personalTaxCode the personal tax code of this emp
	*/
	@Override
	public void setPersonalTaxCode(java.lang.String personalTaxCode) {
		_emp.setPersonalTaxCode(personalTaxCode);
	}

	/**
	* Returns the number of dependents of this emp.
	*
	* @return the number of dependents of this emp
	*/
	@Override
	public int getNumberOfDependents() {
		return _emp.getNumberOfDependents();
	}

	/**
	* Sets the number of dependents of this emp.
	*
	* @param numberOfDependents the number of dependents of this emp
	*/
	@Override
	public void setNumberOfDependents(int numberOfDependents) {
		_emp.setNumberOfDependents(numberOfDependents);
	}

	/**
	* Returns the dependent names of this emp.
	*
	* @return the dependent names of this emp
	*/
	@Override
	public java.lang.String getDependentNames() {
		return _emp.getDependentNames();
	}

	/**
	* Sets the dependent names of this emp.
	*
	* @param dependentNames the dependent names of this emp
	*/
	@Override
	public void setDependentNames(java.lang.String dependentNames) {
		_emp.setDependentNames(dependentNames);
	}

	/**
	* Returns the social insurance no of this emp.
	*
	* @return the social insurance no of this emp
	*/
	@Override
	public java.lang.String getSocialInsuranceNo() {
		return _emp.getSocialInsuranceNo();
	}

	/**
	* Sets the social insurance no of this emp.
	*
	* @param socialInsuranceNo the social insurance no of this emp
	*/
	@Override
	public void setSocialInsuranceNo(java.lang.String socialInsuranceNo) {
		_emp.setSocialInsuranceNo(socialInsuranceNo);
	}

	/**
	* Returns the health insurance no of this emp.
	*
	* @return the health insurance no of this emp
	*/
	@Override
	public java.lang.String getHealthInsuranceNo() {
		return _emp.getHealthInsuranceNo();
	}

	/**
	* Sets the health insurance no of this emp.
	*
	* @param healthInsuranceNo the health insurance no of this emp
	*/
	@Override
	public void setHealthInsuranceNo(java.lang.String healthInsuranceNo) {
		_emp.setHealthInsuranceNo(healthInsuranceNo);
	}

	/**
	* Returns the health insurance place of this emp.
	*
	* @return the health insurance place of this emp
	*/
	@Override
	public java.lang.String getHealthInsurancePlace() {
		return _emp.getHealthInsurancePlace();
	}

	/**
	* Sets the health insurance place of this emp.
	*
	* @param healthInsurancePlace the health insurance place of this emp
	*/
	@Override
	public void setHealthInsurancePlace(java.lang.String healthInsurancePlace) {
		_emp.setHealthInsurancePlace(healthInsurancePlace);
	}

	/**
	* Returns the base wage rates of this emp.
	*
	* @return the base wage rates of this emp
	*/
	@Override
	public double getBaseWageRates() {
		return _emp.getBaseWageRates();
	}

	/**
	* Sets the base wage rates of this emp.
	*
	* @param baseWageRates the base wage rates of this emp
	*/
	@Override
	public void setBaseWageRates(double baseWageRates) {
		_emp.setBaseWageRates(baseWageRates);
	}

	/**
	* Returns the position wage rates of this emp.
	*
	* @return the position wage rates of this emp
	*/
	@Override
	public double getPositionWageRates() {
		return _emp.getPositionWageRates();
	}

	/**
	* Sets the position wage rates of this emp.
	*
	* @param positionWageRates the position wage rates of this emp
	*/
	@Override
	public void setPositionWageRates(double positionWageRates) {
		_emp.setPositionWageRates(positionWageRates);
	}

	/**
	* Returns the capacity salary of this emp.
	*
	* @return the capacity salary of this emp
	*/
	@Override
	public double getCapacitySalary() {
		return _emp.getCapacitySalary();
	}

	/**
	* Sets the capacity salary of this emp.
	*
	* @param capacitySalary the capacity salary of this emp
	*/
	@Override
	public void setCapacitySalary(double capacitySalary) {
		_emp.setCapacitySalary(capacitySalary);
	}

	/**
	* Returns the total salary of this emp.
	*
	* @return the total salary of this emp
	*/
	@Override
	public double getTotalSalary() {
		return _emp.getTotalSalary();
	}

	/**
	* Sets the total salary of this emp.
	*
	* @param totalSalary the total salary of this emp
	*/
	@Override
	public void setTotalSalary(double totalSalary) {
		_emp.setTotalSalary(totalSalary);
	}

	/**
	* Returns the bonus of this emp.
	*
	* @return the bonus of this emp
	*/
	@Override
	public double getBonus() {
		return _emp.getBonus();
	}

	/**
	* Sets the bonus of this emp.
	*
	* @param bonus the bonus of this emp
	*/
	@Override
	public void setBonus(double bonus) {
		_emp.setBonus(bonus);
	}

	/**
	* Returns the resigned date of this emp.
	*
	* @return the resigned date of this emp
	*/
	@Override
	public java.util.Date getResignedDate() {
		return _emp.getResignedDate();
	}

	/**
	* Sets the resigned date of this emp.
	*
	* @param resignedDate the resigned date of this emp
	*/
	@Override
	public void setResignedDate(java.util.Date resignedDate) {
		_emp.setResignedDate(resignedDate);
	}

	/**
	* Returns the emp user ID of this emp.
	*
	* @return the emp user ID of this emp
	*/
	@Override
	public long getEmpUserId() {
		return _emp.getEmpUserId();
	}

	/**
	* Sets the emp user ID of this emp.
	*
	* @param empUserId the emp user ID of this emp
	*/
	@Override
	public void setEmpUserId(long empUserId) {
		_emp.setEmpUserId(empUserId);
	}

	/**
	* Returns the emp user uuid of this emp.
	*
	* @return the emp user uuid of this emp
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEmpUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emp.getEmpUserUuid();
	}

	/**
	* Sets the emp user uuid of this emp.
	*
	* @param empUserUuid the emp user uuid of this emp
	*/
	@Override
	public void setEmpUserUuid(java.lang.String empUserUuid) {
		_emp.setEmpUserUuid(empUserUuid);
	}

	/**
	* Returns the deleted of this emp.
	*
	* @return the deleted of this emp
	*/
	@Override
	public boolean getDeleted() {
		return _emp.getDeleted();
	}

	/**
	* Returns <code>true</code> if this emp is deleted.
	*
	* @return <code>true</code> if this emp is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _emp.isDeleted();
	}

	/**
	* Sets whether this emp is deleted.
	*
	* @param deleted the deleted of this emp
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_emp.setDeleted(deleted);
	}

	/**
	* Returns the company email address of this emp.
	*
	* @return the company email address of this emp
	*/
	@Override
	public java.lang.String getCompanyEmailAddress() {
		return _emp.getCompanyEmailAddress();
	}

	/**
	* Sets the company email address of this emp.
	*
	* @param companyEmailAddress the company email address of this emp
	*/
	@Override
	public void setCompanyEmailAddress(java.lang.String companyEmailAddress) {
		_emp.setCompanyEmailAddress(companyEmailAddress);
	}

	/**
	* Returns the working place ID of this emp.
	*
	* @return the working place ID of this emp
	*/
	@Override
	public long getWorkingPlaceId() {
		return _emp.getWorkingPlaceId();
	}

	/**
	* Sets the working place ID of this emp.
	*
	* @param workingPlaceId the working place ID of this emp
	*/
	@Override
	public void setWorkingPlaceId(long workingPlaceId) {
		_emp.setWorkingPlaceId(workingPlaceId);
	}

	/**
	* Returns the status of this emp.
	*
	* @return the status of this emp
	*/
	@Override
	public java.lang.String getStatus() {
		return _emp.getStatus();
	}

	/**
	* Sets the status of this emp.
	*
	* @param status the status of this emp
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_emp.setStatus(status);
	}

	/**
	* Returns the company ID of this emp.
	*
	* @return the company ID of this emp
	*/
	@Override
	public long getCompanyId() {
		return _emp.getCompanyId();
	}

	/**
	* Sets the company ID of this emp.
	*
	* @param companyId the company ID of this emp
	*/
	@Override
	public void setCompanyId(long companyId) {
		_emp.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp.
	*
	* @return the user ID of this emp
	*/
	@Override
	public long getUserId() {
		return _emp.getUserId();
	}

	/**
	* Sets the user ID of this emp.
	*
	* @param userId the user ID of this emp
	*/
	@Override
	public void setUserId(long userId) {
		_emp.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp.
	*
	* @return the user uuid of this emp
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _emp.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp.
	*
	* @param userUuid the user uuid of this emp
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_emp.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp.
	*
	* @return the user name of this emp
	*/
	@Override
	public java.lang.String getUserName() {
		return _emp.getUserName();
	}

	/**
	* Sets the user name of this emp.
	*
	* @param userName the user name of this emp
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_emp.setUserName(userName);
	}

	/**
	* Returns the create date of this emp.
	*
	* @return the create date of this emp
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _emp.getCreateDate();
	}

	/**
	* Sets the create date of this emp.
	*
	* @param createDate the create date of this emp
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_emp.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp.
	*
	* @return the modified date of this emp
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _emp.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp.
	*
	* @param modifiedDate the modified date of this emp
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_emp.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the unit ID of this emp.
	*
	* @return the unit ID of this emp
	*/
	@Override
	public long getUnitId() {
		return _emp.getUnitId();
	}

	/**
	* Sets the unit ID of this emp.
	*
	* @param unitId the unit ID of this emp
	*/
	@Override
	public void setUnitId(long unitId) {
		_emp.setUnitId(unitId);
	}

	/**
	* Returns the unit group ID of this emp.
	*
	* @return the unit group ID of this emp
	*/
	@Override
	public long getUnitGroupId() {
		return _emp.getUnitGroupId();
	}

	/**
	* Sets the unit group ID of this emp.
	*
	* @param unitGroupId the unit group ID of this emp
	*/
	@Override
	public void setUnitGroupId(long unitGroupId) {
		_emp.setUnitGroupId(unitGroupId);
	}

	/**
	* Returns the department ID of this emp.
	*
	* @return the department ID of this emp
	*/
	@Override
	public long getDepartmentId() {
		return _emp.getDepartmentId();
	}

	/**
	* Sets the department ID of this emp.
	*
	* @param departmentId the department ID of this emp
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_emp.setDepartmentId(departmentId);
	}

	@Override
	public boolean isNew() {
		return _emp.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_emp.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _emp.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_emp.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _emp.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _emp.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_emp.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _emp.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_emp.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_emp.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_emp.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpWrapper((Emp)_emp.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Emp emp) {
		return _emp.compareTo(emp);
	}

	@Override
	public int hashCode() {
		return _emp.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Emp> toCacheModel() {
		return _emp.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp toEscapedModel() {
		return new EmpWrapper(_emp.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp toUnescapedModel() {
		return new EmpWrapper(_emp.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _emp.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _emp.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_emp.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpWrapper)) {
			return false;
		}

		EmpWrapper empWrapper = (EmpWrapper)obj;

		if (Validator.equals(_emp, empWrapper._emp)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Emp getWrappedEmp() {
		return _emp;
	}

	@Override
	public Emp getWrappedModel() {
		return _emp;
	}

	@Override
	public void resetOriginalValues() {
		_emp.resetOriginalValues();
	}

	private Emp _emp;
}