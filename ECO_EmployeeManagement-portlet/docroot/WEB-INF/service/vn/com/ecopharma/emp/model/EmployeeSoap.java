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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmployeeServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmployeeServiceSoap
 * @generated
 */
public class EmployeeSoap implements Serializable {
	public static EmployeeSoap toSoapModel(Employee model) {
		EmployeeSoap soapModel = new EmployeeSoap();

		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setEmployeeCode(model.getEmployeeCode());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setJoinedDate(model.getJoinedDate());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setPromotedDate(model.getPromotedDate());
		soapModel.setLaborContractSignedDate(model.getLaborContractSignedDate());
		soapModel.setLaborContractExpiredDate(model.getLaborContractExpiredDate());
		soapModel.setLaborContractType(model.getLaborContractType());
		soapModel.setGender(model.getGender());
		soapModel.setPlaceOfBirth(model.getPlaceOfBirth());
		soapModel.setEducation(model.getEducation());
		soapModel.setEducationSpecialize(model.getEducationSpecialize());
		soapModel.setUniversityId(model.getUniversityId());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setIdentityCardNo(model.getIdentityCardNo());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setIssuedPlace(model.getIssuedPlace());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setCompanyEmail(model.getCompanyEmail());
		soapModel.setPersonalTaxCode(model.getPersonalTaxCode());
		soapModel.setNumberOfDependents(model.getNumberOfDependents());
		soapModel.setDependentNames(model.getDependentNames());
		soapModel.setSocialInsuranceNo(model.getSocialInsuranceNo());
		soapModel.setHealthInsuranceNo(model.getHealthInsuranceNo());
		soapModel.setHealthInsurancePlace(model.getHealthInsurancePlace());
		soapModel.setBankAccountNo(model.getBankAccountNo());
		soapModel.setBankName(model.getBankName());
		soapModel.setBankBranchName(model.getBankBranchName());
		soapModel.setBaseWageRates(model.getBaseWageRates());
		soapModel.setPositionWageRates(model.getPositionWageRates());
		soapModel.setCapacitySalary(model.getCapacitySalary());
		soapModel.setTotalSalary(model.getTotalSalary());
		soapModel.setBonus(model.getBonus());
		soapModel.setResignedDate(model.getResignedDate());
		soapModel.setEmployeeUserId(model.getEmployeeUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setCompanyEmailAddress(model.getCompanyEmailAddress());
		soapModel.setWorkingPlaceId(model.getWorkingPlaceId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmployeeSoap[] toSoapModels(Employee[] models) {
		EmployeeSoap[] soapModels = new EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[][] toSoapModels(Employee[][] models) {
		EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeSoap[] toSoapModels(List<Employee> models) {
		List<EmployeeSoap> soapModels = new ArrayList<EmployeeSoap>(models.size());

		for (Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeSoap[soapModels.size()]);
	}

	public EmployeeSoap() {
	}

	public long getPrimaryKey() {
		return _employeeId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeId(pk);
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public String getEmployeeCode() {
		return _employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		_employeeCode = employeeCode;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public Date getJoinedDate() {
		return _joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		_joinedDate = joinedDate;
	}

	public long getTitlesId() {
		return _titlesId;
	}

	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
	}

	public long getLevelId() {
		return _levelId;
	}

	public void setLevelId(long levelId) {
		_levelId = levelId;
	}

	public Date getPromotedDate() {
		return _promotedDate;
	}

	public void setPromotedDate(Date promotedDate) {
		_promotedDate = promotedDate;
	}

	public Date getLaborContractSignedDate() {
		return _laborContractSignedDate;
	}

	public void setLaborContractSignedDate(Date laborContractSignedDate) {
		_laborContractSignedDate = laborContractSignedDate;
	}

	public Date getLaborContractExpiredDate() {
		return _laborContractExpiredDate;
	}

	public void setLaborContractExpiredDate(Date laborContractExpiredDate) {
		_laborContractExpiredDate = laborContractExpiredDate;
	}

	public String getLaborContractType() {
		return _laborContractType;
	}

	public void setLaborContractType(String laborContractType) {
		_laborContractType = laborContractType;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;
	}

	public String getEducation() {
		return _education;
	}

	public void setEducation(String education) {
		_education = education;
	}

	public String getEducationSpecialize() {
		return _educationSpecialize;
	}

	public void setEducationSpecialize(String educationSpecialize) {
		_educationSpecialize = educationSpecialize;
	}

	public long getUniversityId() {
		return _universityId;
	}

	public void setUniversityId(long universityId) {
		_universityId = universityId;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public String getIdentityCardNo() {
		return _identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		_identityCardNo = identityCardNo;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public String getIssuedPlace() {
		return _issuedPlace;
	}

	public void setIssuedPlace(String issuedPlace) {
		_issuedPlace = issuedPlace;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public String getCompanyEmail() {
		return _companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		_companyEmail = companyEmail;
	}

	public String getPersonalTaxCode() {
		return _personalTaxCode;
	}

	public void setPersonalTaxCode(String personalTaxCode) {
		_personalTaxCode = personalTaxCode;
	}

	public int getNumberOfDependents() {
		return _numberOfDependents;
	}

	public void setNumberOfDependents(int numberOfDependents) {
		_numberOfDependents = numberOfDependents;
	}

	public String getDependentNames() {
		return _dependentNames;
	}

	public void setDependentNames(String dependentNames) {
		_dependentNames = dependentNames;
	}

	public String getSocialInsuranceNo() {
		return _socialInsuranceNo;
	}

	public void setSocialInsuranceNo(String socialInsuranceNo) {
		_socialInsuranceNo = socialInsuranceNo;
	}

	public String getHealthInsuranceNo() {
		return _healthInsuranceNo;
	}

	public void setHealthInsuranceNo(String healthInsuranceNo) {
		_healthInsuranceNo = healthInsuranceNo;
	}

	public String getHealthInsurancePlace() {
		return _healthInsurancePlace;
	}

	public void setHealthInsurancePlace(String healthInsurancePlace) {
		_healthInsurancePlace = healthInsurancePlace;
	}

	public String getBankAccountNo() {
		return _bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		_bankAccountNo = bankAccountNo;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getBankBranchName() {
		return _bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		_bankBranchName = bankBranchName;
	}

	public double getBaseWageRates() {
		return _baseWageRates;
	}

	public void setBaseWageRates(double baseWageRates) {
		_baseWageRates = baseWageRates;
	}

	public double getPositionWageRates() {
		return _positionWageRates;
	}

	public void setPositionWageRates(double positionWageRates) {
		_positionWageRates = positionWageRates;
	}

	public double getCapacitySalary() {
		return _capacitySalary;
	}

	public void setCapacitySalary(double capacitySalary) {
		_capacitySalary = capacitySalary;
	}

	public double getTotalSalary() {
		return _totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		_totalSalary = totalSalary;
	}

	public double getBonus() {
		return _bonus;
	}

	public void setBonus(double bonus) {
		_bonus = bonus;
	}

	public Date getResignedDate() {
		return _resignedDate;
	}

	public void setResignedDate(Date resignedDate) {
		_resignedDate = resignedDate;
	}

	public long getEmployeeUserId() {
		return _employeeUserId;
	}

	public void setEmployeeUserId(long employeeUserId) {
		_employeeUserId = employeeUserId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public String getCompanyEmailAddress() {
		return _companyEmailAddress;
	}

	public void setCompanyEmailAddress(String companyEmailAddress) {
		_companyEmailAddress = companyEmailAddress;
	}

	public long getWorkingPlaceId() {
		return _workingPlaceId;
	}

	public void setWorkingPlaceId(long workingPlaceId) {
		_workingPlaceId = workingPlaceId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _employeeId;
	private String _employeeCode;
	private String _contactNumber;
	private Date _birthday;
	private Date _joinedDate;
	private long _titlesId;
	private long _levelId;
	private Date _promotedDate;
	private Date _laborContractSignedDate;
	private Date _laborContractExpiredDate;
	private String _laborContractType;
	private String _gender;
	private String _placeOfBirth;
	private String _education;
	private String _educationSpecialize;
	private long _universityId;
	private String _maritalStatus;
	private String _identityCardNo;
	private Date _issuedDate;
	private String _issuedPlace;
	private long _addressId;
	private String _companyEmail;
	private String _personalTaxCode;
	private int _numberOfDependents;
	private String _dependentNames;
	private String _socialInsuranceNo;
	private String _healthInsuranceNo;
	private String _healthInsurancePlace;
	private String _bankAccountNo;
	private String _bankName;
	private String _bankBranchName;
	private double _baseWageRates;
	private double _positionWageRates;
	private double _capacitySalary;
	private double _totalSalary;
	private double _bonus;
	private Date _resignedDate;
	private long _employeeUserId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private String _companyEmailAddress;
	private long _workingPlaceId;
	private String _status;
}