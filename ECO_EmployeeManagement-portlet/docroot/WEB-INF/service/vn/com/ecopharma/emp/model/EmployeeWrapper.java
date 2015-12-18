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
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author tvt
 * @see Employee
 * @generated
 */
public class EmployeeWrapper implements Employee, ModelWrapper<Employee> {
	public EmployeeWrapper(Employee employee) {
		_employee = employee;
	}

	@Override
	public Class<?> getModelClass() {
		return Employee.class;
	}

	@Override
	public String getModelClassName() {
		return Employee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeId", getEmployeeId());
		attributes.put("employeeCode", getEmployeeCode());
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
		attributes.put("healthInsurancePlace", getHealthInsurancePlace());
		attributes.put("bankAccountNo", getBankAccountNo());
		attributes.put("bankName", getBankName());
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
		attributes.put("workingPlaceId", getWorkingPlaceId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
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

		String healthInsurancePlace = (String)attributes.get(
				"healthInsurancePlace");

		if (healthInsurancePlace != null) {
			setHealthInsurancePlace(healthInsurancePlace);
		}

		String bankAccountNo = (String)attributes.get("bankAccountNo");

		if (bankAccountNo != null) {
			setBankAccountNo(bankAccountNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
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
	* Returns the primary key of this employee.
	*
	* @return the primary key of this employee
	*/
	@Override
	public long getPrimaryKey() {
		return _employee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee.
	*
	* @param primaryKey the primary key of this employee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee ID of this employee.
	*
	* @return the employee ID of this employee
	*/
	@Override
	public long getEmployeeId() {
		return _employee.getEmployeeId();
	}

	/**
	* Sets the employee ID of this employee.
	*
	* @param employeeId the employee ID of this employee
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employee.setEmployeeId(employeeId);
	}

	/**
	* Returns the employee code of this employee.
	*
	* @return the employee code of this employee
	*/
	@Override
	public java.lang.String getEmployeeCode() {
		return _employee.getEmployeeCode();
	}

	/**
	* Sets the employee code of this employee.
	*
	* @param employeeCode the employee code of this employee
	*/
	@Override
	public void setEmployeeCode(java.lang.String employeeCode) {
		_employee.setEmployeeCode(employeeCode);
	}

	/**
	* Returns the contact number of this employee.
	*
	* @return the contact number of this employee
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _employee.getContactNumber();
	}

	/**
	* Sets the contact number of this employee.
	*
	* @param contactNumber the contact number of this employee
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_employee.setContactNumber(contactNumber);
	}

	/**
	* Returns the birthday of this employee.
	*
	* @return the birthday of this employee
	*/
	@Override
	public java.util.Date getBirthday() {
		return _employee.getBirthday();
	}

	/**
	* Sets the birthday of this employee.
	*
	* @param birthday the birthday of this employee
	*/
	@Override
	public void setBirthday(java.util.Date birthday) {
		_employee.setBirthday(birthday);
	}

	/**
	* Returns the joined date of this employee.
	*
	* @return the joined date of this employee
	*/
	@Override
	public java.util.Date getJoinedDate() {
		return _employee.getJoinedDate();
	}

	/**
	* Sets the joined date of this employee.
	*
	* @param joinedDate the joined date of this employee
	*/
	@Override
	public void setJoinedDate(java.util.Date joinedDate) {
		_employee.setJoinedDate(joinedDate);
	}

	/**
	* Returns the titles ID of this employee.
	*
	* @return the titles ID of this employee
	*/
	@Override
	public long getTitlesId() {
		return _employee.getTitlesId();
	}

	/**
	* Sets the titles ID of this employee.
	*
	* @param titlesId the titles ID of this employee
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_employee.setTitlesId(titlesId);
	}

	/**
	* Returns the level ID of this employee.
	*
	* @return the level ID of this employee
	*/
	@Override
	public long getLevelId() {
		return _employee.getLevelId();
	}

	/**
	* Sets the level ID of this employee.
	*
	* @param levelId the level ID of this employee
	*/
	@Override
	public void setLevelId(long levelId) {
		_employee.setLevelId(levelId);
	}

	/**
	* Returns the promoted date of this employee.
	*
	* @return the promoted date of this employee
	*/
	@Override
	public java.util.Date getPromotedDate() {
		return _employee.getPromotedDate();
	}

	/**
	* Sets the promoted date of this employee.
	*
	* @param promotedDate the promoted date of this employee
	*/
	@Override
	public void setPromotedDate(java.util.Date promotedDate) {
		_employee.setPromotedDate(promotedDate);
	}

	/**
	* Returns the labor contract signed date of this employee.
	*
	* @return the labor contract signed date of this employee
	*/
	@Override
	public java.util.Date getLaborContractSignedDate() {
		return _employee.getLaborContractSignedDate();
	}

	/**
	* Sets the labor contract signed date of this employee.
	*
	* @param laborContractSignedDate the labor contract signed date of this employee
	*/
	@Override
	public void setLaborContractSignedDate(
		java.util.Date laborContractSignedDate) {
		_employee.setLaborContractSignedDate(laborContractSignedDate);
	}

	/**
	* Returns the labor contract expired date of this employee.
	*
	* @return the labor contract expired date of this employee
	*/
	@Override
	public java.util.Date getLaborContractExpiredDate() {
		return _employee.getLaborContractExpiredDate();
	}

	/**
	* Sets the labor contract expired date of this employee.
	*
	* @param laborContractExpiredDate the labor contract expired date of this employee
	*/
	@Override
	public void setLaborContractExpiredDate(
		java.util.Date laborContractExpiredDate) {
		_employee.setLaborContractExpiredDate(laborContractExpiredDate);
	}

	/**
	* Returns the labor contract type of this employee.
	*
	* @return the labor contract type of this employee
	*/
	@Override
	public java.lang.String getLaborContractType() {
		return _employee.getLaborContractType();
	}

	/**
	* Sets the labor contract type of this employee.
	*
	* @param laborContractType the labor contract type of this employee
	*/
	@Override
	public void setLaborContractType(java.lang.String laborContractType) {
		_employee.setLaborContractType(laborContractType);
	}

	/**
	* Returns the gender of this employee.
	*
	* @return the gender of this employee
	*/
	@Override
	public java.lang.String getGender() {
		return _employee.getGender();
	}

	/**
	* Sets the gender of this employee.
	*
	* @param gender the gender of this employee
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_employee.setGender(gender);
	}

	/**
	* Returns the place of birth of this employee.
	*
	* @return the place of birth of this employee
	*/
	@Override
	public java.lang.String getPlaceOfBirth() {
		return _employee.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this employee.
	*
	* @param placeOfBirth the place of birth of this employee
	*/
	@Override
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_employee.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the education of this employee.
	*
	* @return the education of this employee
	*/
	@Override
	public java.lang.String getEducation() {
		return _employee.getEducation();
	}

	/**
	* Sets the education of this employee.
	*
	* @param education the education of this employee
	*/
	@Override
	public void setEducation(java.lang.String education) {
		_employee.setEducation(education);
	}

	/**
	* Returns the education specialize of this employee.
	*
	* @return the education specialize of this employee
	*/
	@Override
	public java.lang.String getEducationSpecialize() {
		return _employee.getEducationSpecialize();
	}

	/**
	* Sets the education specialize of this employee.
	*
	* @param educationSpecialize the education specialize of this employee
	*/
	@Override
	public void setEducationSpecialize(java.lang.String educationSpecialize) {
		_employee.setEducationSpecialize(educationSpecialize);
	}

	/**
	* Returns the university ID of this employee.
	*
	* @return the university ID of this employee
	*/
	@Override
	public long getUniversityId() {
		return _employee.getUniversityId();
	}

	/**
	* Sets the university ID of this employee.
	*
	* @param universityId the university ID of this employee
	*/
	@Override
	public void setUniversityId(long universityId) {
		_employee.setUniversityId(universityId);
	}

	/**
	* Returns the marital status of this employee.
	*
	* @return the marital status of this employee
	*/
	@Override
	public java.lang.String getMaritalStatus() {
		return _employee.getMaritalStatus();
	}

	/**
	* Sets the marital status of this employee.
	*
	* @param maritalStatus the marital status of this employee
	*/
	@Override
	public void setMaritalStatus(java.lang.String maritalStatus) {
		_employee.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the identity card no of this employee.
	*
	* @return the identity card no of this employee
	*/
	@Override
	public java.lang.String getIdentityCardNo() {
		return _employee.getIdentityCardNo();
	}

	/**
	* Sets the identity card no of this employee.
	*
	* @param identityCardNo the identity card no of this employee
	*/
	@Override
	public void setIdentityCardNo(java.lang.String identityCardNo) {
		_employee.setIdentityCardNo(identityCardNo);
	}

	/**
	* Returns the issued date of this employee.
	*
	* @return the issued date of this employee
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _employee.getIssuedDate();
	}

	/**
	* Sets the issued date of this employee.
	*
	* @param issuedDate the issued date of this employee
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_employee.setIssuedDate(issuedDate);
	}

	/**
	* Returns the issued place of this employee.
	*
	* @return the issued place of this employee
	*/
	@Override
	public java.lang.String getIssuedPlace() {
		return _employee.getIssuedPlace();
	}

	/**
	* Sets the issued place of this employee.
	*
	* @param issuedPlace the issued place of this employee
	*/
	@Override
	public void setIssuedPlace(java.lang.String issuedPlace) {
		_employee.setIssuedPlace(issuedPlace);
	}

	/**
	* Returns the address ID of this employee.
	*
	* @return the address ID of this employee
	*/
	@Override
	public long getAddressId() {
		return _employee.getAddressId();
	}

	/**
	* Sets the address ID of this employee.
	*
	* @param addressId the address ID of this employee
	*/
	@Override
	public void setAddressId(long addressId) {
		_employee.setAddressId(addressId);
	}

	/**
	* Returns the company email of this employee.
	*
	* @return the company email of this employee
	*/
	@Override
	public java.lang.String getCompanyEmail() {
		return _employee.getCompanyEmail();
	}

	/**
	* Sets the company email of this employee.
	*
	* @param companyEmail the company email of this employee
	*/
	@Override
	public void setCompanyEmail(java.lang.String companyEmail) {
		_employee.setCompanyEmail(companyEmail);
	}

	/**
	* Returns the personal tax code of this employee.
	*
	* @return the personal tax code of this employee
	*/
	@Override
	public java.lang.String getPersonalTaxCode() {
		return _employee.getPersonalTaxCode();
	}

	/**
	* Sets the personal tax code of this employee.
	*
	* @param personalTaxCode the personal tax code of this employee
	*/
	@Override
	public void setPersonalTaxCode(java.lang.String personalTaxCode) {
		_employee.setPersonalTaxCode(personalTaxCode);
	}

	/**
	* Returns the number of dependents of this employee.
	*
	* @return the number of dependents of this employee
	*/
	@Override
	public int getNumberOfDependents() {
		return _employee.getNumberOfDependents();
	}

	/**
	* Sets the number of dependents of this employee.
	*
	* @param numberOfDependents the number of dependents of this employee
	*/
	@Override
	public void setNumberOfDependents(int numberOfDependents) {
		_employee.setNumberOfDependents(numberOfDependents);
	}

	/**
	* Returns the dependent names of this employee.
	*
	* @return the dependent names of this employee
	*/
	@Override
	public java.lang.String getDependentNames() {
		return _employee.getDependentNames();
	}

	/**
	* Sets the dependent names of this employee.
	*
	* @param dependentNames the dependent names of this employee
	*/
	@Override
	public void setDependentNames(java.lang.String dependentNames) {
		_employee.setDependentNames(dependentNames);
	}

	/**
	* Returns the social insurance no of this employee.
	*
	* @return the social insurance no of this employee
	*/
	@Override
	public java.lang.String getSocialInsuranceNo() {
		return _employee.getSocialInsuranceNo();
	}

	/**
	* Sets the social insurance no of this employee.
	*
	* @param socialInsuranceNo the social insurance no of this employee
	*/
	@Override
	public void setSocialInsuranceNo(java.lang.String socialInsuranceNo) {
		_employee.setSocialInsuranceNo(socialInsuranceNo);
	}

	/**
	* Returns the health insurance no of this employee.
	*
	* @return the health insurance no of this employee
	*/
	@Override
	public java.lang.String getHealthInsuranceNo() {
		return _employee.getHealthInsuranceNo();
	}

	/**
	* Sets the health insurance no of this employee.
	*
	* @param healthInsuranceNo the health insurance no of this employee
	*/
	@Override
	public void setHealthInsuranceNo(java.lang.String healthInsuranceNo) {
		_employee.setHealthInsuranceNo(healthInsuranceNo);
	}

	/**
	* Returns the health insurance place of this employee.
	*
	* @return the health insurance place of this employee
	*/
	@Override
	public java.lang.String getHealthInsurancePlace() {
		return _employee.getHealthInsurancePlace();
	}

	/**
	* Sets the health insurance place of this employee.
	*
	* @param healthInsurancePlace the health insurance place of this employee
	*/
	@Override
	public void setHealthInsurancePlace(java.lang.String healthInsurancePlace) {
		_employee.setHealthInsurancePlace(healthInsurancePlace);
	}

	/**
	* Returns the bank account no of this employee.
	*
	* @return the bank account no of this employee
	*/
	@Override
	public java.lang.String getBankAccountNo() {
		return _employee.getBankAccountNo();
	}

	/**
	* Sets the bank account no of this employee.
	*
	* @param bankAccountNo the bank account no of this employee
	*/
	@Override
	public void setBankAccountNo(java.lang.String bankAccountNo) {
		_employee.setBankAccountNo(bankAccountNo);
	}

	/**
	* Returns the bank name of this employee.
	*
	* @return the bank name of this employee
	*/
	@Override
	public java.lang.String getBankName() {
		return _employee.getBankName();
	}

	/**
	* Sets the bank name of this employee.
	*
	* @param bankName the bank name of this employee
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_employee.setBankName(bankName);
	}

	/**
	* Returns the bank branch name of this employee.
	*
	* @return the bank branch name of this employee
	*/
	@Override
	public java.lang.String getBankBranchName() {
		return _employee.getBankBranchName();
	}

	/**
	* Sets the bank branch name of this employee.
	*
	* @param bankBranchName the bank branch name of this employee
	*/
	@Override
	public void setBankBranchName(java.lang.String bankBranchName) {
		_employee.setBankBranchName(bankBranchName);
	}

	/**
	* Returns the base wage rates of this employee.
	*
	* @return the base wage rates of this employee
	*/
	@Override
	public double getBaseWageRates() {
		return _employee.getBaseWageRates();
	}

	/**
	* Sets the base wage rates of this employee.
	*
	* @param baseWageRates the base wage rates of this employee
	*/
	@Override
	public void setBaseWageRates(double baseWageRates) {
		_employee.setBaseWageRates(baseWageRates);
	}

	/**
	* Returns the position wage rates of this employee.
	*
	* @return the position wage rates of this employee
	*/
	@Override
	public double getPositionWageRates() {
		return _employee.getPositionWageRates();
	}

	/**
	* Sets the position wage rates of this employee.
	*
	* @param positionWageRates the position wage rates of this employee
	*/
	@Override
	public void setPositionWageRates(double positionWageRates) {
		_employee.setPositionWageRates(positionWageRates);
	}

	/**
	* Returns the capacity salary of this employee.
	*
	* @return the capacity salary of this employee
	*/
	@Override
	public double getCapacitySalary() {
		return _employee.getCapacitySalary();
	}

	/**
	* Sets the capacity salary of this employee.
	*
	* @param capacitySalary the capacity salary of this employee
	*/
	@Override
	public void setCapacitySalary(double capacitySalary) {
		_employee.setCapacitySalary(capacitySalary);
	}

	/**
	* Returns the total salary of this employee.
	*
	* @return the total salary of this employee
	*/
	@Override
	public double getTotalSalary() {
		return _employee.getTotalSalary();
	}

	/**
	* Sets the total salary of this employee.
	*
	* @param totalSalary the total salary of this employee
	*/
	@Override
	public void setTotalSalary(double totalSalary) {
		_employee.setTotalSalary(totalSalary);
	}

	/**
	* Returns the bonus of this employee.
	*
	* @return the bonus of this employee
	*/
	@Override
	public double getBonus() {
		return _employee.getBonus();
	}

	/**
	* Sets the bonus of this employee.
	*
	* @param bonus the bonus of this employee
	*/
	@Override
	public void setBonus(double bonus) {
		_employee.setBonus(bonus);
	}

	/**
	* Returns the resigned date of this employee.
	*
	* @return the resigned date of this employee
	*/
	@Override
	public java.util.Date getResignedDate() {
		return _employee.getResignedDate();
	}

	/**
	* Sets the resigned date of this employee.
	*
	* @param resignedDate the resigned date of this employee
	*/
	@Override
	public void setResignedDate(java.util.Date resignedDate) {
		_employee.setResignedDate(resignedDate);
	}

	/**
	* Returns the employee user ID of this employee.
	*
	* @return the employee user ID of this employee
	*/
	@Override
	public long getEmployeeUserId() {
		return _employee.getEmployeeUserId();
	}

	/**
	* Sets the employee user ID of this employee.
	*
	* @param employeeUserId the employee user ID of this employee
	*/
	@Override
	public void setEmployeeUserId(long employeeUserId) {
		_employee.setEmployeeUserId(employeeUserId);
	}

	/**
	* Returns the employee user uuid of this employee.
	*
	* @return the employee user uuid of this employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getEmployeeUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employee.getEmployeeUserUuid();
	}

	/**
	* Sets the employee user uuid of this employee.
	*
	* @param employeeUserUuid the employee user uuid of this employee
	*/
	@Override
	public void setEmployeeUserUuid(java.lang.String employeeUserUuid) {
		_employee.setEmployeeUserUuid(employeeUserUuid);
	}

	/**
	* Returns the group ID of this employee.
	*
	* @return the group ID of this employee
	*/
	@Override
	public long getGroupId() {
		return _employee.getGroupId();
	}

	/**
	* Sets the group ID of this employee.
	*
	* @param groupId the group ID of this employee
	*/
	@Override
	public void setGroupId(long groupId) {
		_employee.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this employee.
	*
	* @return the company ID of this employee
	*/
	@Override
	public long getCompanyId() {
		return _employee.getCompanyId();
	}

	/**
	* Sets the company ID of this employee.
	*
	* @param companyId the company ID of this employee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employee.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this employee.
	*
	* @return the user ID of this employee
	*/
	@Override
	public long getUserId() {
		return _employee.getUserId();
	}

	/**
	* Sets the user ID of this employee.
	*
	* @param userId the user ID of this employee
	*/
	@Override
	public void setUserId(long userId) {
		_employee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this employee.
	*
	* @return the user uuid of this employee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employee.getUserUuid();
	}

	/**
	* Sets the user uuid of this employee.
	*
	* @param userUuid the user uuid of this employee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_employee.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this employee.
	*
	* @return the create date of this employee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _employee.getCreateDate();
	}

	/**
	* Sets the create date of this employee.
	*
	* @param createDate the create date of this employee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_employee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this employee.
	*
	* @return the modified date of this employee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _employee.getModifiedDate();
	}

	/**
	* Sets the modified date of this employee.
	*
	* @param modifiedDate the modified date of this employee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_employee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this employee.
	*
	* @return the deleted of this employee
	*/
	@Override
	public boolean getDeleted() {
		return _employee.getDeleted();
	}

	/**
	* Returns <code>true</code> if this employee is deleted.
	*
	* @return <code>true</code> if this employee is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _employee.isDeleted();
	}

	/**
	* Sets whether this employee is deleted.
	*
	* @param deleted the deleted of this employee
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_employee.setDeleted(deleted);
	}

	/**
	* Returns the company email address of this employee.
	*
	* @return the company email address of this employee
	*/
	@Override
	public java.lang.String getCompanyEmailAddress() {
		return _employee.getCompanyEmailAddress();
	}

	/**
	* Sets the company email address of this employee.
	*
	* @param companyEmailAddress the company email address of this employee
	*/
	@Override
	public void setCompanyEmailAddress(java.lang.String companyEmailAddress) {
		_employee.setCompanyEmailAddress(companyEmailAddress);
	}

	/**
	* Returns the working place ID of this employee.
	*
	* @return the working place ID of this employee
	*/
	@Override
	public long getWorkingPlaceId() {
		return _employee.getWorkingPlaceId();
	}

	/**
	* Sets the working place ID of this employee.
	*
	* @param workingPlaceId the working place ID of this employee
	*/
	@Override
	public void setWorkingPlaceId(long workingPlaceId) {
		_employee.setWorkingPlaceId(workingPlaceId);
	}

	/**
	* Returns the status of this employee.
	*
	* @return the status of this employee
	*/
	@Override
	public java.lang.String getStatus() {
		return _employee.getStatus();
	}

	/**
	* Sets the status of this employee.
	*
	* @param status the status of this employee
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_employee.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _employee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeWrapper((Employee)_employee.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Employee employee) {
		return _employee.compareTo(employee);
	}

	@Override
	public int hashCode() {
		return _employee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Employee> toCacheModel() {
		return _employee.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee toEscapedModel() {
		return new EmployeeWrapper(_employee.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Employee toUnescapedModel() {
		return new EmployeeWrapper(_employee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeWrapper)) {
			return false;
		}

		EmployeeWrapper employeeWrapper = (EmployeeWrapper)obj;

		if (Validator.equals(_employee, employeeWrapper._employee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Employee getWrappedEmployee() {
		return _employee;
	}

	@Override
	public Employee getWrappedModel() {
		return _employee;
	}

	@Override
	public void resetOriginalValues() {
		_employee.resetOriginalValues();
	}

	private Employee _employee;
}