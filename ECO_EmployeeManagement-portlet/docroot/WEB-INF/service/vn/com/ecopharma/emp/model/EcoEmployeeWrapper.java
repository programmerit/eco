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
 * This class is a wrapper for {@link EcoEmployee}.
 * </p>
 *
 * @author tvt
 * @see EcoEmployee
 * @generated
 */
public class EcoEmployeeWrapper implements EcoEmployee,
	ModelWrapper<EcoEmployee> {
	public EcoEmployeeWrapper(EcoEmployee ecoEmployee) {
		_ecoEmployee = ecoEmployee;
	}

	@Override
	public Class<?> getModelClass() {
		return EcoEmployee.class;
	}

	@Override
	public String getModelClassName() {
		return EcoEmployee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ecoEmployeeId", getEcoEmployeeId());
		attributes.put("employeeCode", getEmployeeCode());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("birthday", getBirthday());
		attributes.put("joinedDate", getJoinedDate());
		attributes.put("subUnitId", getSubUnitId());
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
		attributes.put("employeeUserId", getEmployeeUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());
		attributes.put("companyEmailAddress", getCompanyEmailAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ecoEmployeeId = (Long)attributes.get("ecoEmployeeId");

		if (ecoEmployeeId != null) {
			setEcoEmployeeId(ecoEmployeeId);
		}

		String employeeCode = (String)attributes.get("employeeCode");

		if (employeeCode != null) {
			setEmployeeCode(employeeCode);
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

		Long subUnitId = (Long)attributes.get("subUnitId");

		if (subUnitId != null) {
			setSubUnitId(subUnitId);
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

		Long employeeUserId = (Long)attributes.get("employeeUserId");

		if (employeeUserId != null) {
			setEmployeeUserId(employeeUserId);
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
	}

	/**
	* Returns the primary key of this eco employee.
	*
	* @return the primary key of this eco employee
	*/
	@Override
	public long getPrimaryKey() {
		return _ecoEmployee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this eco employee.
	*
	* @param primaryKey the primary key of this eco employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ecoEmployee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the eco employee ID of this eco employee.
	*
	* @return the eco employee ID of this eco employee
	*/
	@Override
	public long getEcoEmployeeId() {
		return _ecoEmployee.getEcoEmployeeId();
	}

	/**
	* Sets the eco employee ID of this eco employee.
	*
	* @param ecoEmployeeId the eco employee ID of this eco employee
	*/
	@Override
	public void setEcoEmployeeId(long ecoEmployeeId) {
		_ecoEmployee.setEcoEmployeeId(ecoEmployeeId);
	}

	/**
	* Returns the employee code of this eco employee.
	*
	* @return the employee code of this eco employee
	*/
	@Override
	public java.lang.String getEmployeeCode() {
		return _ecoEmployee.getEmployeeCode();
	}

	/**
	* Sets the employee code of this eco employee.
	*
	* @param employeeCode the employee code of this eco employee
	*/
	@Override
	public void setEmployeeCode(java.lang.String employeeCode) {
		_ecoEmployee.setEmployeeCode(employeeCode);
	}

	/**
	* Returns the contact number of this eco employee.
	*
	* @return the contact number of this eco employee
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _ecoEmployee.getContactNumber();
	}

	/**
	* Sets the contact number of this eco employee.
	*
	* @param contactNumber the contact number of this eco employee
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_ecoEmployee.setContactNumber(contactNumber);
	}

	/**
	* Returns the birthday of this eco employee.
	*
	* @return the birthday of this eco employee
	*/
	@Override
	public java.util.Date getBirthday() {
		return _ecoEmployee.getBirthday();
	}

	/**
	* Sets the birthday of this eco employee.
	*
	* @param birthday the birthday of this eco employee
	*/
	@Override
	public void setBirthday(java.util.Date birthday) {
		_ecoEmployee.setBirthday(birthday);
	}

	/**
	* Returns the joined date of this eco employee.
	*
	* @return the joined date of this eco employee
	*/
	@Override
	public java.util.Date getJoinedDate() {
		return _ecoEmployee.getJoinedDate();
	}

	/**
	* Sets the joined date of this eco employee.
	*
	* @param joinedDate the joined date of this eco employee
	*/
	@Override
	public void setJoinedDate(java.util.Date joinedDate) {
		_ecoEmployee.setJoinedDate(joinedDate);
	}

	/**
	* Returns the sub unit ID of this eco employee.
	*
	* @return the sub unit ID of this eco employee
	*/
	@Override
	public long getSubUnitId() {
		return _ecoEmployee.getSubUnitId();
	}

	/**
	* Sets the sub unit ID of this eco employee.
	*
	* @param subUnitId the sub unit ID of this eco employee
	*/
	@Override
	public void setSubUnitId(long subUnitId) {
		_ecoEmployee.setSubUnitId(subUnitId);
	}

	/**
	* Returns the titles ID of this eco employee.
	*
	* @return the titles ID of this eco employee
	*/
	@Override
	public long getTitlesId() {
		return _ecoEmployee.getTitlesId();
	}

	/**
	* Sets the titles ID of this eco employee.
	*
	* @param titlesId the titles ID of this eco employee
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_ecoEmployee.setTitlesId(titlesId);
	}

	/**
	* Returns the level ID of this eco employee.
	*
	* @return the level ID of this eco employee
	*/
	@Override
	public long getLevelId() {
		return _ecoEmployee.getLevelId();
	}

	/**
	* Sets the level ID of this eco employee.
	*
	* @param levelId the level ID of this eco employee
	*/
	@Override
	public void setLevelId(long levelId) {
		_ecoEmployee.setLevelId(levelId);
	}

	/**
	* Returns the promoted date of this eco employee.
	*
	* @return the promoted date of this eco employee
	*/
	@Override
	public java.util.Date getPromotedDate() {
		return _ecoEmployee.getPromotedDate();
	}

	/**
	* Sets the promoted date of this eco employee.
	*
	* @param promotedDate the promoted date of this eco employee
	*/
	@Override
	public void setPromotedDate(java.util.Date promotedDate) {
		_ecoEmployee.setPromotedDate(promotedDate);
	}

	/**
	* Returns the labor contract signed date of this eco employee.
	*
	* @return the labor contract signed date of this eco employee
	*/
	@Override
	public java.util.Date getLaborContractSignedDate() {
		return _ecoEmployee.getLaborContractSignedDate();
	}

	/**
	* Sets the labor contract signed date of this eco employee.
	*
	* @param laborContractSignedDate the labor contract signed date of this eco employee
	*/
	@Override
	public void setLaborContractSignedDate(
		java.util.Date laborContractSignedDate) {
		_ecoEmployee.setLaborContractSignedDate(laborContractSignedDate);
	}

	/**
	* Returns the labor contract expired date of this eco employee.
	*
	* @return the labor contract expired date of this eco employee
	*/
	@Override
	public java.util.Date getLaborContractExpiredDate() {
		return _ecoEmployee.getLaborContractExpiredDate();
	}

	/**
	* Sets the labor contract expired date of this eco employee.
	*
	* @param laborContractExpiredDate the labor contract expired date of this eco employee
	*/
	@Override
	public void setLaborContractExpiredDate(
		java.util.Date laborContractExpiredDate) {
		_ecoEmployee.setLaborContractExpiredDate(laborContractExpiredDate);
	}

	/**
	* Returns the labor contract type of this eco employee.
	*
	* @return the labor contract type of this eco employee
	*/
	@Override
	public java.lang.String getLaborContractType() {
		return _ecoEmployee.getLaborContractType();
	}

	/**
	* Sets the labor contract type of this eco employee.
	*
	* @param laborContractType the labor contract type of this eco employee
	*/
	@Override
	public void setLaborContractType(java.lang.String laborContractType) {
		_ecoEmployee.setLaborContractType(laborContractType);
	}

	/**
	* Returns the gender of this eco employee.
	*
	* @return the gender of this eco employee
	*/
	@Override
	public java.lang.String getGender() {
		return _ecoEmployee.getGender();
	}

	/**
	* Sets the gender of this eco employee.
	*
	* @param gender the gender of this eco employee
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_ecoEmployee.setGender(gender);
	}

	/**
	* Returns the place of birth of this eco employee.
	*
	* @return the place of birth of this eco employee
	*/
	@Override
	public java.lang.String getPlaceOfBirth() {
		return _ecoEmployee.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this eco employee.
	*
	* @param placeOfBirth the place of birth of this eco employee
	*/
	@Override
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_ecoEmployee.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the education of this eco employee.
	*
	* @return the education of this eco employee
	*/
	@Override
	public java.lang.String getEducation() {
		return _ecoEmployee.getEducation();
	}

	/**
	* Sets the education of this eco employee.
	*
	* @param education the education of this eco employee
	*/
	@Override
	public void setEducation(java.lang.String education) {
		_ecoEmployee.setEducation(education);
	}

	/**
	* Returns the education specialize of this eco employee.
	*
	* @return the education specialize of this eco employee
	*/
	@Override
	public java.lang.String getEducationSpecialize() {
		return _ecoEmployee.getEducationSpecialize();
	}

	/**
	* Sets the education specialize of this eco employee.
	*
	* @param educationSpecialize the education specialize of this eco employee
	*/
	@Override
	public void setEducationSpecialize(java.lang.String educationSpecialize) {
		_ecoEmployee.setEducationSpecialize(educationSpecialize);
	}

	/**
	* Returns the university ID of this eco employee.
	*
	* @return the university ID of this eco employee
	*/
	@Override
	public long getUniversityId() {
		return _ecoEmployee.getUniversityId();
	}

	/**
	* Sets the university ID of this eco employee.
	*
	* @param universityId the university ID of this eco employee
	*/
	@Override
	public void setUniversityId(long universityId) {
		_ecoEmployee.setUniversityId(universityId);
	}

	/**
	* Returns the marital status of this eco employee.
	*
	* @return the marital status of this eco employee
	*/
	@Override
	public java.lang.String getMaritalStatus() {
		return _ecoEmployee.getMaritalStatus();
	}

	/**
	* Sets the marital status of this eco employee.
	*
	* @param maritalStatus the marital status of this eco employee
	*/
	@Override
	public void setMaritalStatus(java.lang.String maritalStatus) {
		_ecoEmployee.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the identity card no of this eco employee.
	*
	* @return the identity card no of this eco employee
	*/
	@Override
	public java.lang.String getIdentityCardNo() {
		return _ecoEmployee.getIdentityCardNo();
	}

	/**
	* Sets the identity card no of this eco employee.
	*
	* @param identityCardNo the identity card no of this eco employee
	*/
	@Override
	public void setIdentityCardNo(java.lang.String identityCardNo) {
		_ecoEmployee.setIdentityCardNo(identityCardNo);
	}

	/**
	* Returns the issued date of this eco employee.
	*
	* @return the issued date of this eco employee
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _ecoEmployee.getIssuedDate();
	}

	/**
	* Sets the issued date of this eco employee.
	*
	* @param issuedDate the issued date of this eco employee
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_ecoEmployee.setIssuedDate(issuedDate);
	}

	/**
	* Returns the issued place of this eco employee.
	*
	* @return the issued place of this eco employee
	*/
	@Override
	public java.lang.String getIssuedPlace() {
		return _ecoEmployee.getIssuedPlace();
	}

	/**
	* Sets the issued place of this eco employee.
	*
	* @param issuedPlace the issued place of this eco employee
	*/
	@Override
	public void setIssuedPlace(java.lang.String issuedPlace) {
		_ecoEmployee.setIssuedPlace(issuedPlace);
	}

	/**
	* Returns the address ID of this eco employee.
	*
	* @return the address ID of this eco employee
	*/
	@Override
	public long getAddressId() {
		return _ecoEmployee.getAddressId();
	}

	/**
	* Sets the address ID of this eco employee.
	*
	* @param addressId the address ID of this eco employee
	*/
	@Override
	public void setAddressId(long addressId) {
		_ecoEmployee.setAddressId(addressId);
	}

	/**
	* Returns the company email of this eco employee.
	*
	* @return the company email of this eco employee
	*/
	@Override
	public java.lang.String getCompanyEmail() {
		return _ecoEmployee.getCompanyEmail();
	}

	/**
	* Sets the company email of this eco employee.
	*
	* @param companyEmail the company email of this eco employee
	*/
	@Override
	public void setCompanyEmail(java.lang.String companyEmail) {
		_ecoEmployee.setCompanyEmail(companyEmail);
	}

	/**
	* Returns the personal tax code of this eco employee.
	*
	* @return the personal tax code of this eco employee
	*/
	@Override
	public java.lang.String getPersonalTaxCode() {
		return _ecoEmployee.getPersonalTaxCode();
	}

	/**
	* Sets the personal tax code of this eco employee.
	*
	* @param personalTaxCode the personal tax code of this eco employee
	*/
	@Override
	public void setPersonalTaxCode(java.lang.String personalTaxCode) {
		_ecoEmployee.setPersonalTaxCode(personalTaxCode);
	}

	/**
	* Returns the number of dependents of this eco employee.
	*
	* @return the number of dependents of this eco employee
	*/
	@Override
	public int getNumberOfDependents() {
		return _ecoEmployee.getNumberOfDependents();
	}

	/**
	* Sets the number of dependents of this eco employee.
	*
	* @param numberOfDependents the number of dependents of this eco employee
	*/
	@Override
	public void setNumberOfDependents(int numberOfDependents) {
		_ecoEmployee.setNumberOfDependents(numberOfDependents);
	}

	/**
	* Returns the dependent names of this eco employee.
	*
	* @return the dependent names of this eco employee
	*/
	@Override
	public java.lang.String getDependentNames() {
		return _ecoEmployee.getDependentNames();
	}

	/**
	* Sets the dependent names of this eco employee.
	*
	* @param dependentNames the dependent names of this eco employee
	*/
	@Override
	public void setDependentNames(java.lang.String dependentNames) {
		_ecoEmployee.setDependentNames(dependentNames);
	}

	/**
	* Returns the social insurance no of this eco employee.
	*
	* @return the social insurance no of this eco employee
	*/
	@Override
	public java.lang.String getSocialInsuranceNo() {
		return _ecoEmployee.getSocialInsuranceNo();
	}

	/**
	* Sets the social insurance no of this eco employee.
	*
	* @param socialInsuranceNo the social insurance no of this eco employee
	*/
	@Override
	public void setSocialInsuranceNo(java.lang.String socialInsuranceNo) {
		_ecoEmployee.setSocialInsuranceNo(socialInsuranceNo);
	}

	/**
	* Returns the health insurance no of this eco employee.
	*
	* @return the health insurance no of this eco employee
	*/
	@Override
	public java.lang.String getHealthInsuranceNo() {
		return _ecoEmployee.getHealthInsuranceNo();
	}

	/**
	* Sets the health insurance no of this eco employee.
	*
	* @param healthInsuranceNo the health insurance no of this eco employee
	*/
	@Override
	public void setHealthInsuranceNo(java.lang.String healthInsuranceNo) {
		_ecoEmployee.setHealthInsuranceNo(healthInsuranceNo);
	}

	/**
	* Returns the bank account no of this eco employee.
	*
	* @return the bank account no of this eco employee
	*/
	@Override
	public java.lang.String getBankAccountNo() {
		return _ecoEmployee.getBankAccountNo();
	}

	/**
	* Sets the bank account no of this eco employee.
	*
	* @param bankAccountNo the bank account no of this eco employee
	*/
	@Override
	public void setBankAccountNo(java.lang.String bankAccountNo) {
		_ecoEmployee.setBankAccountNo(bankAccountNo);
	}

	/**
	* Returns the bank branch name of this eco employee.
	*
	* @return the bank branch name of this eco employee
	*/
	@Override
	public java.lang.String getBankBranchName() {
		return _ecoEmployee.getBankBranchName();
	}

	/**
	* Sets the bank branch name of this eco employee.
	*
	* @param bankBranchName the bank branch name of this eco employee
	*/
	@Override
	public void setBankBranchName(java.lang.String bankBranchName) {
		_ecoEmployee.setBankBranchName(bankBranchName);
	}

	/**
	* Returns the base wage rates of this eco employee.
	*
	* @return the base wage rates of this eco employee
	*/
	@Override
	public double getBaseWageRates() {
		return _ecoEmployee.getBaseWageRates();
	}

	/**
	* Sets the base wage rates of this eco employee.
	*
	* @param baseWageRates the base wage rates of this eco employee
	*/
	@Override
	public void setBaseWageRates(double baseWageRates) {
		_ecoEmployee.setBaseWageRates(baseWageRates);
	}

	/**
	* Returns the position wage rates of this eco employee.
	*
	* @return the position wage rates of this eco employee
	*/
	@Override
	public double getPositionWageRates() {
		return _ecoEmployee.getPositionWageRates();
	}

	/**
	* Sets the position wage rates of this eco employee.
	*
	* @param positionWageRates the position wage rates of this eco employee
	*/
	@Override
	public void setPositionWageRates(double positionWageRates) {
		_ecoEmployee.setPositionWageRates(positionWageRates);
	}

	/**
	* Returns the capacity salary of this eco employee.
	*
	* @return the capacity salary of this eco employee
	*/
	@Override
	public double getCapacitySalary() {
		return _ecoEmployee.getCapacitySalary();
	}

	/**
	* Sets the capacity salary of this eco employee.
	*
	* @param capacitySalary the capacity salary of this eco employee
	*/
	@Override
	public void setCapacitySalary(double capacitySalary) {
		_ecoEmployee.setCapacitySalary(capacitySalary);
	}

	/**
	* Returns the total salary of this eco employee.
	*
	* @return the total salary of this eco employee
	*/
	@Override
	public double getTotalSalary() {
		return _ecoEmployee.getTotalSalary();
	}

	/**
	* Sets the total salary of this eco employee.
	*
	* @param totalSalary the total salary of this eco employee
	*/
	@Override
	public void setTotalSalary(double totalSalary) {
		_ecoEmployee.setTotalSalary(totalSalary);
	}

	/**
	* Returns the bonus of this eco employee.
	*
	* @return the bonus of this eco employee
	*/
	@Override
	public double getBonus() {
		return _ecoEmployee.getBonus();
	}

	/**
	* Sets the bonus of this eco employee.
	*
	* @param bonus the bonus of this eco employee
	*/
	@Override
	public void setBonus(double bonus) {
		_ecoEmployee.setBonus(bonus);
	}

	/**
	* Returns the resigned date of this eco employee.
	*
	* @return the resigned date of this eco employee
	*/
	@Override
	public java.util.Date getResignedDate() {
		return _ecoEmployee.getResignedDate();
	}

	/**
	* Sets the resigned date of this eco employee.
	*
	* @param resignedDate the resigned date of this eco employee
	*/
	@Override
	public void setResignedDate(java.util.Date resignedDate) {
		_ecoEmployee.setResignedDate(resignedDate);
	}

	/**
	* Returns the employee user ID of this eco employee.
	*
	* @return the employee user ID of this eco employee
	*/
	@Override
	public long getEmployeeUserId() {
		return _ecoEmployee.getEmployeeUserId();
	}

	/**
	* Sets the employee user ID of this eco employee.
	*
	* @param employeeUserId the employee user ID of this eco employee
	*/
	@Override
	public void setEmployeeUserId(long employeeUserId) {
		_ecoEmployee.setEmployeeUserId(employeeUserId);
	}

	/**
	* Returns the employee user uuid of this eco employee.
	*
	* @return the employee user uuid of this eco employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEmployeeUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ecoEmployee.getEmployeeUserUuid();
	}

	/**
	* Sets the employee user uuid of this eco employee.
	*
	* @param employeeUserUuid the employee user uuid of this eco employee
	*/
	@Override
	public void setEmployeeUserUuid(java.lang.String employeeUserUuid) {
		_ecoEmployee.setEmployeeUserUuid(employeeUserUuid);
	}

	/**
	* Returns the group ID of this eco employee.
	*
	* @return the group ID of this eco employee
	*/
	@Override
	public long getGroupId() {
		return _ecoEmployee.getGroupId();
	}

	/**
	* Sets the group ID of this eco employee.
	*
	* @param groupId the group ID of this eco employee
	*/
	@Override
	public void setGroupId(long groupId) {
		_ecoEmployee.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this eco employee.
	*
	* @return the company ID of this eco employee
	*/
	@Override
	public long getCompanyId() {
		return _ecoEmployee.getCompanyId();
	}

	/**
	* Sets the company ID of this eco employee.
	*
	* @param companyId the company ID of this eco employee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ecoEmployee.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this eco employee.
	*
	* @return the user ID of this eco employee
	*/
	@Override
	public long getUserId() {
		return _ecoEmployee.getUserId();
	}

	/**
	* Sets the user ID of this eco employee.
	*
	* @param userId the user ID of this eco employee
	*/
	@Override
	public void setUserId(long userId) {
		_ecoEmployee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this eco employee.
	*
	* @return the user uuid of this eco employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ecoEmployee.getUserUuid();
	}

	/**
	* Sets the user uuid of this eco employee.
	*
	* @param userUuid the user uuid of this eco employee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ecoEmployee.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this eco employee.
	*
	* @return the create date of this eco employee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ecoEmployee.getCreateDate();
	}

	/**
	* Sets the create date of this eco employee.
	*
	* @param createDate the create date of this eco employee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ecoEmployee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this eco employee.
	*
	* @return the modified date of this eco employee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ecoEmployee.getModifiedDate();
	}

	/**
	* Sets the modified date of this eco employee.
	*
	* @param modifiedDate the modified date of this eco employee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ecoEmployee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this eco employee.
	*
	* @return the deleted of this eco employee
	*/
	@Override
	public boolean getDeleted() {
		return _ecoEmployee.getDeleted();
	}

	/**
	* Returns <code>true</code> if this eco employee is deleted.
	*
	* @return <code>true</code> if this eco employee is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _ecoEmployee.isDeleted();
	}

	/**
	* Sets whether this eco employee is deleted.
	*
	* @param deleted the deleted of this eco employee
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_ecoEmployee.setDeleted(deleted);
	}

	/**
	* Returns the company email address of this eco employee.
	*
	* @return the company email address of this eco employee
	*/
	@Override
	public java.lang.String getCompanyEmailAddress() {
		return _ecoEmployee.getCompanyEmailAddress();
	}

	/**
	* Sets the company email address of this eco employee.
	*
	* @param companyEmailAddress the company email address of this eco employee
	*/
	@Override
	public void setCompanyEmailAddress(java.lang.String companyEmailAddress) {
		_ecoEmployee.setCompanyEmailAddress(companyEmailAddress);
	}

	@Override
	public boolean isNew() {
		return _ecoEmployee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ecoEmployee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ecoEmployee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ecoEmployee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ecoEmployee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ecoEmployee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ecoEmployee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ecoEmployee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ecoEmployee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ecoEmployee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ecoEmployee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EcoEmployeeWrapper((EcoEmployee)_ecoEmployee.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee) {
		return _ecoEmployee.compareTo(ecoEmployee);
	}

	@Override
	public int hashCode() {
		return _ecoEmployee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EcoEmployee> toCacheModel() {
		return _ecoEmployee.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee toEscapedModel() {
		return new EcoEmployeeWrapper(_ecoEmployee.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee toUnescapedModel() {
		return new EcoEmployeeWrapper(_ecoEmployee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ecoEmployee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ecoEmployee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ecoEmployee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EcoEmployeeWrapper)) {
			return false;
		}

		EcoEmployeeWrapper ecoEmployeeWrapper = (EcoEmployeeWrapper)obj;

		if (Validator.equals(_ecoEmployee, ecoEmployeeWrapper._ecoEmployee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EcoEmployee getWrappedEcoEmployee() {
		return _ecoEmployee;
	}

	@Override
	public EcoEmployee getWrappedModel() {
		return _ecoEmployee;
	}

	@Override
	public void resetOriginalValues() {
		_ecoEmployee.resetOriginalValues();
	}

	private EcoEmployee _ecoEmployee;
}