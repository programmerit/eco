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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpServiceSoap
 * @generated
 */
public class EmpSoap implements Serializable {
	public static EmpSoap toSoapModel(Emp model) {
		EmpSoap soapModel = new EmpSoap();

		soapModel.setEmpId(model.getEmpId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setEmpCode(model.getEmpCode());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setInternalNumber(model.getInternalNumber());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setEthnic(model.getEthnic());
		soapModel.setNationality(model.getNationality());
		soapModel.setReligion(model.getReligion());
		soapModel.setJoinedDate(model.getJoinedDate());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setUnitGroupId(model.getUnitGroupId());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setLevelId(model.getLevelId());
		soapModel.setPromotedDate(model.getPromotedDate());
		soapModel.setLaborContractSignedDate(model.getLaborContractSignedDate());
		soapModel.setLaborContractExpiredDate(model.getLaborContractExpiredDate());
		soapModel.setLaborContractSignedTime(model.getLaborContractSignedTime());
		soapModel.setLaborContractType(model.getLaborContractType());
		soapModel.setGender(model.getGender());
		soapModel.setPlaceOfBirth(model.getPlaceOfBirth());
		soapModel.setEducation(model.getEducation());
		soapModel.setEducationSpecialize(model.getEducationSpecialize());
		soapModel.setSpecializeId(model.getSpecializeId());
		soapModel.setUniversityId(model.getUniversityId());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setIdentityCardNo(model.getIdentityCardNo());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setIssuedPlace(model.getIssuedPlace());
		soapModel.setPassport(model.getPassport());
		soapModel.setAddressId(model.getAddressId());
		soapModel.setPersonalEmail(model.getPersonalEmail());
		soapModel.setPersonalTaxCode(model.getPersonalTaxCode());
		soapModel.setNumberOfDependents(model.getNumberOfDependents());
		soapModel.setDependentNames(model.getDependentNames());
		soapModel.setSocialInsuranceNo(model.getSocialInsuranceNo());
		soapModel.setHealthInsuranceNo(model.getHealthInsuranceNo());
		soapModel.setHealthInsurancePlace(model.getHealthInsurancePlace());
		soapModel.setBaseWageRates(model.getBaseWageRates());
		soapModel.setPositionWageRates(model.getPositionWageRates());
		soapModel.setCapacitySalary(model.getCapacitySalary());
		soapModel.setTotalSalary(model.getTotalSalary());
		soapModel.setBonus(model.getBonus());
		soapModel.setResignedDate(model.getResignedDate());
		soapModel.setEmpUserId(model.getEmpUserId());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setCompanyEmailAddress(model.getCompanyEmailAddress());
		soapModel.setWorkingPlaceId(model.getWorkingPlaceId());
		soapModel.setStatus(model.getStatus());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpSoap[] toSoapModels(Emp[] models) {
		EmpSoap[] soapModels = new EmpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpSoap[][] toSoapModels(Emp[][] models) {
		EmpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpSoap[] toSoapModels(List<Emp> models) {
		List<EmpSoap> soapModels = new ArrayList<EmpSoap>(models.size());

		for (Emp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpSoap[soapModels.size()]);
	}

	public EmpSoap() {
	}

	public long getPrimaryKey() {
		return _empId;
	}

	public void setPrimaryKey(long pk) {
		setEmpId(pk);
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getEmpCode() {
		return _empCode;
	}

	public void setEmpCode(String empCode) {
		_empCode = empCode;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getInternalNumber() {
		return _internalNumber;
	}

	public void setInternalNumber(String internalNumber) {
		_internalNumber = internalNumber;
	}

	public Date getBirthday() {
		return _birthday;
	}

	public void setBirthday(Date birthday) {
		_birthday = birthday;
	}

	public String getEthnic() {
		return _ethnic;
	}

	public void setEthnic(String ethnic) {
		_ethnic = ethnic;
	}

	public String getNationality() {
		return _nationality;
	}

	public void setNationality(String nationality) {
		_nationality = nationality;
	}

	public String getReligion() {
		return _religion;
	}

	public void setReligion(String religion) {
		_religion = religion;
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

	public long getUnitGroupId() {
		return _unitGroupId;
	}

	public void setUnitGroupId(long unitGroupId) {
		_unitGroupId = unitGroupId;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
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

	public int getLaborContractSignedTime() {
		return _laborContractSignedTime;
	}

	public void setLaborContractSignedTime(int laborContractSignedTime) {
		_laborContractSignedTime = laborContractSignedTime;
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

	public long getSpecializeId() {
		return _specializeId;
	}

	public void setSpecializeId(long specializeId) {
		_specializeId = specializeId;
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

	public String getPassport() {
		return _passport;
	}

	public void setPassport(String passport) {
		_passport = passport;
	}

	public long getAddressId() {
		return _addressId;
	}

	public void setAddressId(long addressId) {
		_addressId = addressId;
	}

	public String getPersonalEmail() {
		return _personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		_personalEmail = personalEmail;
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

	public long getEmpUserId() {
		return _empUserId;
	}

	public void setEmpUserId(long empUserId) {
		_empUserId = empUserId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	private long _empId;
	private long _groupId;
	private String _empCode;
	private String _contactNumber;
	private String _internalNumber;
	private Date _birthday;
	private String _ethnic;
	private String _nationality;
	private String _religion;
	private Date _joinedDate;
	private long _titlesId;
	private long _unitGroupId;
	private long _unitId;
	private long _departmentId;
	private long _levelId;
	private Date _promotedDate;
	private Date _laborContractSignedDate;
	private Date _laborContractExpiredDate;
	private int _laborContractSignedTime;
	private String _laborContractType;
	private String _gender;
	private String _placeOfBirth;
	private String _education;
	private String _educationSpecialize;
	private long _specializeId;
	private long _universityId;
	private String _maritalStatus;
	private String _identityCardNo;
	private Date _issuedDate;
	private String _issuedPlace;
	private String _passport;
	private long _addressId;
	private String _personalEmail;
	private String _personalTaxCode;
	private int _numberOfDependents;
	private String _dependentNames;
	private String _socialInsuranceNo;
	private String _healthInsuranceNo;
	private String _healthInsurancePlace;
	private double _baseWageRates;
	private double _positionWageRates;
	private double _capacitySalary;
	private double _totalSalary;
	private double _bonus;
	private Date _resignedDate;
	private long _empUserId;
	private boolean _deleted;
	private String _companyEmailAddress;
	private long _workingPlaceId;
	private String _status;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}