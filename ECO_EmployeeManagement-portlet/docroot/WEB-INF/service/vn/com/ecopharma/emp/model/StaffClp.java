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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.ecopharma.emp.service.ClpSerializer;
import vn.com.ecopharma.emp.service.StaffLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class StaffClp extends BaseModelImpl<Staff> implements Staff {
	public StaffClp() {
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
	public long getPrimaryKey() {
		return _staffId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStaffId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _staffId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getStaffId() {
		return _staffId;
	}

	@Override
	public void setStaffId(long staffId) {
		_staffId = staffId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffId", long.class);

				method.invoke(_staffRemoteModel, staffId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStaffCode() {
		return _staffCode;
	}

	@Override
	public void setStaffCode(String staffCode) {
		_staffCode = staffCode;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffCode", String.class);

				method.invoke(_staffRemoteModel, staffCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactNumber() {
		return _contactNumber;
	}

	@Override
	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNumber", String.class);

				method.invoke(_staffRemoteModel, contactNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getBirthday() {
		return _birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		_birthday = birthday;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthday", Date.class);

				method.invoke(_staffRemoteModel, birthday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getJoinedDate() {
		return _joinedDate;
	}

	@Override
	public void setJoinedDate(Date joinedDate) {
		_joinedDate = joinedDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setJoinedDate", Date.class);

				method.invoke(_staffRemoteModel, joinedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTitlesId() {
		return _titlesId;
	}

	@Override
	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_staffRemoteModel, titlesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevelId() {
		return _levelId;
	}

	@Override
	public void setLevelId(long levelId) {
		_levelId = levelId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelId", long.class);

				method.invoke(_staffRemoteModel, levelId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPromotedDate() {
		return _promotedDate;
	}

	@Override
	public void setPromotedDate(Date promotedDate) {
		_promotedDate = promotedDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotedDate", Date.class);

				method.invoke(_staffRemoteModel, promotedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLaborContractSignedDate() {
		return _laborContractSignedDate;
	}

	@Override
	public void setLaborContractSignedDate(Date laborContractSignedDate) {
		_laborContractSignedDate = laborContractSignedDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractSignedDate",
						Date.class);

				method.invoke(_staffRemoteModel, laborContractSignedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLaborContractExpiredDate() {
		return _laborContractExpiredDate;
	}

	@Override
	public void setLaborContractExpiredDate(Date laborContractExpiredDate) {
		_laborContractExpiredDate = laborContractExpiredDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractExpiredDate",
						Date.class);

				method.invoke(_staffRemoteModel, laborContractExpiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLaborContractType() {
		return _laborContractType;
	}

	@Override
	public void setLaborContractType(String laborContractType) {
		_laborContractType = laborContractType;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractType",
						String.class);

				method.invoke(_staffRemoteModel, laborContractType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_staffRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	@Override
	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setPlaceOfBirth", String.class);

				method.invoke(_staffRemoteModel, placeOfBirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEducation() {
		return _education;
	}

	@Override
	public void setEducation(String education) {
		_education = education;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setEducation", String.class);

				method.invoke(_staffRemoteModel, education);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEducationSpecialize() {
		return _educationSpecialize;
	}

	@Override
	public void setEducationSpecialize(String educationSpecialize) {
		_educationSpecialize = educationSpecialize;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setEducationSpecialize",
						String.class);

				method.invoke(_staffRemoteModel, educationSpecialize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUniversityId() {
		return _universityId;
	}

	@Override
	public void setUniversityId(long universityId) {
		_universityId = universityId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setUniversityId", long.class);

				method.invoke(_staffRemoteModel, universityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMaritalStatus() {
		return _maritalStatus;
	}

	@Override
	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setMaritalStatus", String.class);

				method.invoke(_staffRemoteModel, maritalStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdentityCardNo() {
		return _identityCardNo;
	}

	@Override
	public void setIdentityCardNo(String identityCardNo) {
		_identityCardNo = identityCardNo;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentityCardNo",
						String.class);

				method.invoke(_staffRemoteModel, identityCardNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIssuedDate() {
		return _issuedDate;
	}

	@Override
	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedDate", Date.class);

				method.invoke(_staffRemoteModel, issuedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIssuedPlace() {
		return _issuedPlace;
	}

	@Override
	public void setIssuedPlace(String issuedPlace) {
		_issuedPlace = issuedPlace;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedPlace", String.class);

				method.invoke(_staffRemoteModel, issuedPlace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAddressId() {
		return _addressId;
	}

	@Override
	public void setAddressId(long addressId) {
		_addressId = addressId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", long.class);

				method.invoke(_staffRemoteModel, addressId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyEmail() {
		return _companyEmail;
	}

	@Override
	public void setCompanyEmail(String companyEmail) {
		_companyEmail = companyEmail;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyEmail", String.class);

				method.invoke(_staffRemoteModel, companyEmail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonalTaxCode() {
		return _personalTaxCode;
	}

	@Override
	public void setPersonalTaxCode(String personalTaxCode) {
		_personalTaxCode = personalTaxCode;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonalTaxCode",
						String.class);

				method.invoke(_staffRemoteModel, personalTaxCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfDependents() {
		return _numberOfDependents;
	}

	@Override
	public void setNumberOfDependents(int numberOfDependents) {
		_numberOfDependents = numberOfDependents;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfDependents",
						int.class);

				method.invoke(_staffRemoteModel, numberOfDependents);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDependentNames() {
		return _dependentNames;
	}

	@Override
	public void setDependentNames(String dependentNames) {
		_dependentNames = dependentNames;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setDependentNames",
						String.class);

				method.invoke(_staffRemoteModel, dependentNames);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSocialInsuranceNo() {
		return _socialInsuranceNo;
	}

	@Override
	public void setSocialInsuranceNo(String socialInsuranceNo) {
		_socialInsuranceNo = socialInsuranceNo;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialInsuranceNo",
						String.class);

				method.invoke(_staffRemoteModel, socialInsuranceNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHealthInsuranceNo() {
		return _healthInsuranceNo;
	}

	@Override
	public void setHealthInsuranceNo(String healthInsuranceNo) {
		_healthInsuranceNo = healthInsuranceNo;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setHealthInsuranceNo",
						String.class);

				method.invoke(_staffRemoteModel, healthInsuranceNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankAccountNo() {
		return _bankAccountNo;
	}

	@Override
	public void setBankAccountNo(String bankAccountNo) {
		_bankAccountNo = bankAccountNo;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setBankAccountNo", String.class);

				method.invoke(_staffRemoteModel, bankAccountNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankBranchName() {
		return _bankBranchName;
	}

	@Override
	public void setBankBranchName(String bankBranchName) {
		_bankBranchName = bankBranchName;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setBankBranchName",
						String.class);

				method.invoke(_staffRemoteModel, bankBranchName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getBaseWageRates() {
		return _baseWageRates;
	}

	@Override
	public void setBaseWageRates(double baseWageRates) {
		_baseWageRates = baseWageRates;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setBaseWageRates", double.class);

				method.invoke(_staffRemoteModel, baseWageRates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getPositionWageRates() {
		return _positionWageRates;
	}

	@Override
	public void setPositionWageRates(double positionWageRates) {
		_positionWageRates = positionWageRates;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionWageRates",
						double.class);

				method.invoke(_staffRemoteModel, positionWageRates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getCapacitySalary() {
		return _capacitySalary;
	}

	@Override
	public void setCapacitySalary(double capacitySalary) {
		_capacitySalary = capacitySalary;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setCapacitySalary",
						double.class);

				method.invoke(_staffRemoteModel, capacitySalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getTotalSalary() {
		return _totalSalary;
	}

	@Override
	public void setTotalSalary(double totalSalary) {
		_totalSalary = totalSalary;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalSalary", double.class);

				method.invoke(_staffRemoteModel, totalSalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getBonus() {
		return _bonus;
	}

	@Override
	public void setBonus(double bonus) {
		_bonus = bonus;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setBonus", double.class);

				method.invoke(_staffRemoteModel, bonus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getResignedDate() {
		return _resignedDate;
	}

	@Override
	public void setResignedDate(Date resignedDate) {
		_resignedDate = resignedDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setResignedDate", Date.class);

				method.invoke(_staffRemoteModel, resignedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStaffUserId() {
		return _staffUserId;
	}

	@Override
	public void setStaffUserId(long staffUserId) {
		_staffUserId = staffUserId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setStaffUserId", long.class);

				method.invoke(_staffRemoteModel, staffUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStaffUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStaffUserId(), "uuid", _staffUserUuid);
	}

	@Override
	public void setStaffUserUuid(String staffUserUuid) {
		_staffUserUuid = staffUserUuid;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_staffRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_staffRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_staffRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_staffRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_staffRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_deleted = deleted;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_staffRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyEmailAddress() {
		return _companyEmailAddress;
	}

	@Override
	public void setCompanyEmailAddress(String companyEmailAddress) {
		_companyEmailAddress = companyEmailAddress;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyEmailAddress",
						String.class);

				method.invoke(_staffRemoteModel, companyEmailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkingPlaceId() {
		return _workingPlaceId;
	}

	@Override
	public void setWorkingPlaceId(long workingPlaceId) {
		_workingPlaceId = workingPlaceId;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingPlaceId", long.class);

				method.invoke(_staffRemoteModel, workingPlaceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_staffRemoteModel != null) {
			try {
				Class<?> clazz = _staffRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_staffRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStaffRemoteModel() {
		return _staffRemoteModel;
	}

	public void setStaffRemoteModel(BaseModel<?> staffRemoteModel) {
		_staffRemoteModel = staffRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _staffRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_staffRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StaffLocalServiceUtil.addStaff(this);
		}
		else {
			StaffLocalServiceUtil.updateStaff(this);
		}
	}

	@Override
	public Staff toEscapedModel() {
		return (Staff)ProxyUtil.newProxyInstance(Staff.class.getClassLoader(),
			new Class[] { Staff.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StaffClp clone = new StaffClp();

		clone.setStaffId(getStaffId());
		clone.setStaffCode(getStaffCode());
		clone.setContactNumber(getContactNumber());
		clone.setBirthday(getBirthday());
		clone.setJoinedDate(getJoinedDate());
		clone.setTitlesId(getTitlesId());
		clone.setLevelId(getLevelId());
		clone.setPromotedDate(getPromotedDate());
		clone.setLaborContractSignedDate(getLaborContractSignedDate());
		clone.setLaborContractExpiredDate(getLaborContractExpiredDate());
		clone.setLaborContractType(getLaborContractType());
		clone.setGender(getGender());
		clone.setPlaceOfBirth(getPlaceOfBirth());
		clone.setEducation(getEducation());
		clone.setEducationSpecialize(getEducationSpecialize());
		clone.setUniversityId(getUniversityId());
		clone.setMaritalStatus(getMaritalStatus());
		clone.setIdentityCardNo(getIdentityCardNo());
		clone.setIssuedDate(getIssuedDate());
		clone.setIssuedPlace(getIssuedPlace());
		clone.setAddressId(getAddressId());
		clone.setCompanyEmail(getCompanyEmail());
		clone.setPersonalTaxCode(getPersonalTaxCode());
		clone.setNumberOfDependents(getNumberOfDependents());
		clone.setDependentNames(getDependentNames());
		clone.setSocialInsuranceNo(getSocialInsuranceNo());
		clone.setHealthInsuranceNo(getHealthInsuranceNo());
		clone.setBankAccountNo(getBankAccountNo());
		clone.setBankBranchName(getBankBranchName());
		clone.setBaseWageRates(getBaseWageRates());
		clone.setPositionWageRates(getPositionWageRates());
		clone.setCapacitySalary(getCapacitySalary());
		clone.setTotalSalary(getTotalSalary());
		clone.setBonus(getBonus());
		clone.setResignedDate(getResignedDate());
		clone.setStaffUserId(getStaffUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDeleted(getDeleted());
		clone.setCompanyEmailAddress(getCompanyEmailAddress());
		clone.setWorkingPlaceId(getWorkingPlaceId());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(Staff staff) {
		long primaryKey = staff.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StaffClp)) {
			return false;
		}

		StaffClp staff = (StaffClp)obj;

		long primaryKey = staff.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(91);

		sb.append("{staffId=");
		sb.append(getStaffId());
		sb.append(", staffCode=");
		sb.append(getStaffCode());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", joinedDate=");
		sb.append(getJoinedDate());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", levelId=");
		sb.append(getLevelId());
		sb.append(", promotedDate=");
		sb.append(getPromotedDate());
		sb.append(", laborContractSignedDate=");
		sb.append(getLaborContractSignedDate());
		sb.append(", laborContractExpiredDate=");
		sb.append(getLaborContractExpiredDate());
		sb.append(", laborContractType=");
		sb.append(getLaborContractType());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", placeOfBirth=");
		sb.append(getPlaceOfBirth());
		sb.append(", education=");
		sb.append(getEducation());
		sb.append(", educationSpecialize=");
		sb.append(getEducationSpecialize());
		sb.append(", universityId=");
		sb.append(getUniversityId());
		sb.append(", maritalStatus=");
		sb.append(getMaritalStatus());
		sb.append(", identityCardNo=");
		sb.append(getIdentityCardNo());
		sb.append(", issuedDate=");
		sb.append(getIssuedDate());
		sb.append(", issuedPlace=");
		sb.append(getIssuedPlace());
		sb.append(", addressId=");
		sb.append(getAddressId());
		sb.append(", companyEmail=");
		sb.append(getCompanyEmail());
		sb.append(", personalTaxCode=");
		sb.append(getPersonalTaxCode());
		sb.append(", numberOfDependents=");
		sb.append(getNumberOfDependents());
		sb.append(", dependentNames=");
		sb.append(getDependentNames());
		sb.append(", socialInsuranceNo=");
		sb.append(getSocialInsuranceNo());
		sb.append(", healthInsuranceNo=");
		sb.append(getHealthInsuranceNo());
		sb.append(", bankAccountNo=");
		sb.append(getBankAccountNo());
		sb.append(", bankBranchName=");
		sb.append(getBankBranchName());
		sb.append(", baseWageRates=");
		sb.append(getBaseWageRates());
		sb.append(", positionWageRates=");
		sb.append(getPositionWageRates());
		sb.append(", capacitySalary=");
		sb.append(getCapacitySalary());
		sb.append(", totalSalary=");
		sb.append(getTotalSalary());
		sb.append(", bonus=");
		sb.append(getBonus());
		sb.append(", resignedDate=");
		sb.append(getResignedDate());
		sb.append(", staffUserId=");
		sb.append(getStaffUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append(", companyEmailAddress=");
		sb.append(getCompanyEmailAddress());
		sb.append(", workingPlaceId=");
		sb.append(getWorkingPlaceId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(139);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.Staff");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>staffId</column-name><column-value><![CDATA[");
		sb.append(getStaffId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffCode</column-name><column-value><![CDATA[");
		sb.append(getStaffCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>birthday</column-name><column-value><![CDATA[");
		sb.append(getBirthday());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>joinedDate</column-name><column-value><![CDATA[");
		sb.append(getJoinedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelId</column-name><column-value><![CDATA[");
		sb.append(getLevelId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotedDate</column-name><column-value><![CDATA[");
		sb.append(getPromotedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laborContractSignedDate</column-name><column-value><![CDATA[");
		sb.append(getLaborContractSignedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laborContractExpiredDate</column-name><column-value><![CDATA[");
		sb.append(getLaborContractExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laborContractType</column-name><column-value><![CDATA[");
		sb.append(getLaborContractType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getPlaceOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>education</column-name><column-value><![CDATA[");
		sb.append(getEducation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>educationSpecialize</column-name><column-value><![CDATA[");
		sb.append(getEducationSpecialize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>universityId</column-name><column-value><![CDATA[");
		sb.append(getUniversityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maritalStatus</column-name><column-value><![CDATA[");
		sb.append(getMaritalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identityCardNo</column-name><column-value><![CDATA[");
		sb.append(getIdentityCardNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedDate</column-name><column-value><![CDATA[");
		sb.append(getIssuedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedPlace</column-name><column-value><![CDATA[");
		sb.append(getIssuedPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>addressId</column-name><column-value><![CDATA[");
		sb.append(getAddressId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyEmail</column-name><column-value><![CDATA[");
		sb.append(getCompanyEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personalTaxCode</column-name><column-value><![CDATA[");
		sb.append(getPersonalTaxCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfDependents</column-name><column-value><![CDATA[");
		sb.append(getNumberOfDependents());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dependentNames</column-name><column-value><![CDATA[");
		sb.append(getDependentNames());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>socialInsuranceNo</column-name><column-value><![CDATA[");
		sb.append(getSocialInsuranceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>healthInsuranceNo</column-name><column-value><![CDATA[");
		sb.append(getHealthInsuranceNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankAccountNo</column-name><column-value><![CDATA[");
		sb.append(getBankAccountNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankBranchName</column-name><column-value><![CDATA[");
		sb.append(getBankBranchName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>baseWageRates</column-name><column-value><![CDATA[");
		sb.append(getBaseWageRates());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>positionWageRates</column-name><column-value><![CDATA[");
		sb.append(getPositionWageRates());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capacitySalary</column-name><column-value><![CDATA[");
		sb.append(getCapacitySalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalSalary</column-name><column-value><![CDATA[");
		sb.append(getTotalSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bonus</column-name><column-value><![CDATA[");
		sb.append(getBonus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resignedDate</column-name><column-value><![CDATA[");
		sb.append(getResignedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>staffUserId</column-name><column-value><![CDATA[");
		sb.append(getStaffUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyEmailAddress</column-name><column-value><![CDATA[");
		sb.append(getCompanyEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingPlaceId</column-name><column-value><![CDATA[");
		sb.append(getWorkingPlaceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _staffId;
	private String _staffCode;
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
	private String _bankAccountNo;
	private String _bankBranchName;
	private double _baseWageRates;
	private double _positionWageRates;
	private double _capacitySalary;
	private double _totalSalary;
	private double _bonus;
	private Date _resignedDate;
	private long _staffUserId;
	private String _staffUserUuid;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private String _companyEmailAddress;
	private long _workingPlaceId;
	private String _status;
	private BaseModel<?> _staffRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}