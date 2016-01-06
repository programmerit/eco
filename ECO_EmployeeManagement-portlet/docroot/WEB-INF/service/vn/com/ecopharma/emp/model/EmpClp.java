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
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpClp extends BaseModelImpl<Emp> implements Emp {
	public EmpClp() {
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
	public long getPrimaryKey() {
		return _empId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getEmpId() {
		return _empId;
	}

	@Override
	public void setEmpId(long empId) {
		_empId = empId;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmpCode() {
		return _empCode;
	}

	@Override
	public void setEmpCode(String empCode) {
		_empCode = empCode;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpCode", String.class);

				method.invoke(_empRemoteModel, empCode);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setContactNumber", String.class);

				method.invoke(_empRemoteModel, contactNumber);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setBirthday", Date.class);

				method.invoke(_empRemoteModel, birthday);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEthnic() {
		return _ethnic;
	}

	@Override
	public void setEthnic(String ethnic) {
		_ethnic = ethnic;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setEthnic", String.class);

				method.invoke(_empRemoteModel, ethnic);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNationality() {
		return _nationality;
	}

	@Override
	public void setNationality(String nationality) {
		_nationality = nationality;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setNationality", String.class);

				method.invoke(_empRemoteModel, nationality);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReligion() {
		return _religion;
	}

	@Override
	public void setReligion(String religion) {
		_religion = religion;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setReligion", String.class);

				method.invoke(_empRemoteModel, religion);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setJoinedDate", Date.class);

				method.invoke(_empRemoteModel, joinedDate);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_empRemoteModel, titlesId);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelId", long.class);

				method.invoke(_empRemoteModel, levelId);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotedDate", Date.class);

				method.invoke(_empRemoteModel, promotedDate);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractSignedDate",
						Date.class);

				method.invoke(_empRemoteModel, laborContractSignedDate);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractExpiredDate",
						Date.class);

				method.invoke(_empRemoteModel, laborContractExpiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLaborContractSignedTime() {
		return _laborContractSignedTime;
	}

	@Override
	public void setLaborContractSignedTime(int laborContractSignedTime) {
		_laborContractSignedTime = laborContractSignedTime;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractSignedTime",
						int.class);

				method.invoke(_empRemoteModel, laborContractSignedTime);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractType",
						String.class);

				method.invoke(_empRemoteModel, laborContractType);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_empRemoteModel, gender);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setPlaceOfBirth", String.class);

				method.invoke(_empRemoteModel, placeOfBirth);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setEducation", String.class);

				method.invoke(_empRemoteModel, education);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setEducationSpecialize",
						String.class);

				method.invoke(_empRemoteModel, educationSpecialize);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setUniversityId", long.class);

				method.invoke(_empRemoteModel, universityId);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setMaritalStatus", String.class);

				method.invoke(_empRemoteModel, maritalStatus);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentityCardNo",
						String.class);

				method.invoke(_empRemoteModel, identityCardNo);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedDate", Date.class);

				method.invoke(_empRemoteModel, issuedDate);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedPlace", String.class);

				method.invoke(_empRemoteModel, issuedPlace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPassport() {
		return _passport;
	}

	@Override
	public void setPassport(String passport) {
		_passport = passport;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setPassport", String.class);

				method.invoke(_empRemoteModel, passport);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setAddressId", long.class);

				method.invoke(_empRemoteModel, addressId);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyEmail", String.class);

				method.invoke(_empRemoteModel, companyEmail);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonalTaxCode",
						String.class);

				method.invoke(_empRemoteModel, personalTaxCode);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfDependents",
						int.class);

				method.invoke(_empRemoteModel, numberOfDependents);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setDependentNames",
						String.class);

				method.invoke(_empRemoteModel, dependentNames);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setSocialInsuranceNo",
						String.class);

				method.invoke(_empRemoteModel, socialInsuranceNo);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setHealthInsuranceNo",
						String.class);

				method.invoke(_empRemoteModel, healthInsuranceNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHealthInsurancePlace() {
		return _healthInsurancePlace;
	}

	@Override
	public void setHealthInsurancePlace(String healthInsurancePlace) {
		_healthInsurancePlace = healthInsurancePlace;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setHealthInsurancePlace",
						String.class);

				method.invoke(_empRemoteModel, healthInsurancePlace);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setBaseWageRates", double.class);

				method.invoke(_empRemoteModel, baseWageRates);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setPositionWageRates",
						double.class);

				method.invoke(_empRemoteModel, positionWageRates);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setCapacitySalary",
						double.class);

				method.invoke(_empRemoteModel, capacitySalary);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalSalary", double.class);

				method.invoke(_empRemoteModel, totalSalary);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setBonus", double.class);

				method.invoke(_empRemoteModel, bonus);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setResignedDate", Date.class);

				method.invoke(_empRemoteModel, resignedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmpUserId() {
		return _empUserId;
	}

	@Override
	public void setEmpUserId(long empUserId) {
		_empUserId = empUserId;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpUserId", long.class);

				method.invoke(_empRemoteModel, empUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmpUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getEmpUserId(), "uuid", _empUserUuid);
	}

	@Override
	public void setEmpUserUuid(String empUserUuid) {
		_empUserUuid = empUserUuid;
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_empRemoteModel, deleted);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyEmailAddress",
						String.class);

				method.invoke(_empRemoteModel, companyEmailAddress);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingPlaceId", long.class);

				method.invoke(_empRemoteModel, workingPlaceId);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_empRemoteModel, status);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empRemoteModel, companyId);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empRemoteModel, userId);
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
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empRemoteModel, createDate);
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

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUnitId() {
		return _unitId;
	}

	@Override
	public void setUnitId(long unitId) {
		_unitId = unitId;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitId", long.class);

				method.invoke(_empRemoteModel, unitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUnitGroupId() {
		return _unitGroupId;
	}

	@Override
	public void setUnitGroupId(long unitGroupId) {
		_unitGroupId = unitGroupId;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitGroupId", long.class);

				method.invoke(_empRemoteModel, unitGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_empRemoteModel != null) {
			try {
				Class<?> clazz = _empRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_empRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpRemoteModel() {
		return _empRemoteModel;
	}

	public void setEmpRemoteModel(BaseModel<?> empRemoteModel) {
		_empRemoteModel = empRemoteModel;
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

		Class<?> remoteModelClass = _empRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpLocalServiceUtil.addEmp(this);
		}
		else {
			EmpLocalServiceUtil.updateEmp(this);
		}
	}

	@Override
	public Emp toEscapedModel() {
		return (Emp)ProxyUtil.newProxyInstance(Emp.class.getClassLoader(),
			new Class[] { Emp.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpClp clone = new EmpClp();

		clone.setEmpId(getEmpId());
		clone.setGroupId(getGroupId());
		clone.setEmpCode(getEmpCode());
		clone.setContactNumber(getContactNumber());
		clone.setBirthday(getBirthday());
		clone.setEthnic(getEthnic());
		clone.setNationality(getNationality());
		clone.setReligion(getReligion());
		clone.setJoinedDate(getJoinedDate());
		clone.setTitlesId(getTitlesId());
		clone.setLevelId(getLevelId());
		clone.setPromotedDate(getPromotedDate());
		clone.setLaborContractSignedDate(getLaborContractSignedDate());
		clone.setLaborContractExpiredDate(getLaborContractExpiredDate());
		clone.setLaborContractSignedTime(getLaborContractSignedTime());
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
		clone.setPassport(getPassport());
		clone.setAddressId(getAddressId());
		clone.setCompanyEmail(getCompanyEmail());
		clone.setPersonalTaxCode(getPersonalTaxCode());
		clone.setNumberOfDependents(getNumberOfDependents());
		clone.setDependentNames(getDependentNames());
		clone.setSocialInsuranceNo(getSocialInsuranceNo());
		clone.setHealthInsuranceNo(getHealthInsuranceNo());
		clone.setHealthInsurancePlace(getHealthInsurancePlace());
		clone.setBaseWageRates(getBaseWageRates());
		clone.setPositionWageRates(getPositionWageRates());
		clone.setCapacitySalary(getCapacitySalary());
		clone.setTotalSalary(getTotalSalary());
		clone.setBonus(getBonus());
		clone.setResignedDate(getResignedDate());
		clone.setEmpUserId(getEmpUserId());
		clone.setDeleted(getDeleted());
		clone.setCompanyEmailAddress(getCompanyEmailAddress());
		clone.setWorkingPlaceId(getWorkingPlaceId());
		clone.setStatus(getStatus());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUnitId(getUnitId());
		clone.setUnitGroupId(getUnitGroupId());
		clone.setDepartmentId(getDepartmentId());

		return clone;
	}

	@Override
	public int compareTo(Emp emp) {
		long primaryKey = emp.getPrimaryKey();

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

		if (!(obj instanceof EmpClp)) {
			return false;
		}

		EmpClp emp = (EmpClp)obj;

		long primaryKey = emp.getPrimaryKey();

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
		StringBundler sb = new StringBundler(107);

		sb.append("{empId=");
		sb.append(getEmpId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", empCode=");
		sb.append(getEmpCode());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", birthday=");
		sb.append(getBirthday());
		sb.append(", ethnic=");
		sb.append(getEthnic());
		sb.append(", nationality=");
		sb.append(getNationality());
		sb.append(", religion=");
		sb.append(getReligion());
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
		sb.append(", laborContractSignedTime=");
		sb.append(getLaborContractSignedTime());
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
		sb.append(", passport=");
		sb.append(getPassport());
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
		sb.append(", healthInsurancePlace=");
		sb.append(getHealthInsurancePlace());
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
		sb.append(", empUserId=");
		sb.append(getEmpUserId());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append(", companyEmailAddress=");
		sb.append(getCompanyEmailAddress());
		sb.append(", workingPlaceId=");
		sb.append(getWorkingPlaceId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", unitId=");
		sb.append(getUnitId());
		sb.append(", unitGroupId=");
		sb.append(getUnitGroupId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(163);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.Emp");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empCode</column-name><column-value><![CDATA[");
		sb.append(getEmpCode());
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
			"<column><column-name>ethnic</column-name><column-value><![CDATA[");
		sb.append(getEthnic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationality</column-name><column-value><![CDATA[");
		sb.append(getNationality());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>religion</column-name><column-value><![CDATA[");
		sb.append(getReligion());
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
			"<column><column-name>laborContractSignedTime</column-name><column-value><![CDATA[");
		sb.append(getLaborContractSignedTime());
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
			"<column><column-name>passport</column-name><column-value><![CDATA[");
		sb.append(getPassport());
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
			"<column><column-name>healthInsurancePlace</column-name><column-value><![CDATA[");
		sb.append(getHealthInsurancePlace());
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
			"<column><column-name>empUserId</column-name><column-value><![CDATA[");
		sb.append(getEmpUserId());
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
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
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
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitGroupId</column-name><column-value><![CDATA[");
		sb.append(getUnitGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empId;
	private long _groupId;
	private String _empCode;
	private String _contactNumber;
	private Date _birthday;
	private String _ethnic;
	private String _nationality;
	private String _religion;
	private Date _joinedDate;
	private long _titlesId;
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
	private long _universityId;
	private String _maritalStatus;
	private String _identityCardNo;
	private Date _issuedDate;
	private String _issuedPlace;
	private String _passport;
	private long _addressId;
	private String _companyEmail;
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
	private String _empUserUuid;
	private boolean _deleted;
	private String _companyEmailAddress;
	private long _workingPlaceId;
	private String _status;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _unitId;
	private long _unitGroupId;
	private long _departmentId;
	private BaseModel<?> _empRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}