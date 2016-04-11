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

package vn.com.ecopharma.hrm.rc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.ecopharma.hrm.rc.service.ClpSerializer;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class VacancyClp extends BaseModelImpl<Vacancy> implements Vacancy {
	public VacancyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Vacancy.class;
	}

	@Override
	public String getModelClassName() {
		return Vacancy.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _vacancyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVacancyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacancyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacancyId", getVacancyId());
		attributes.put("approvedNumberOfPosition", getApprovedNumberOfPosition());
		attributes.put("currentNumberOfEmployee", getCurrentNumberOfEmployee());
		attributes.put("titlesId", getTitlesId());
		attributes.put("unitGroupId", getUnitGroupId());
		attributes.put("unitId", getUnitId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("numberOfNewRecruitment", getNumberOfNewRecruitment());
		attributes.put("numberOfReplacedRecruitment",
			getNumberOfReplacedRecruitment());
		attributes.put("expectedSalary", getExpectedSalary());
		attributes.put("expectedJoinedDate", getExpectedJoinedDate());
		attributes.put("workPlaceId", getWorkPlaceId());
		attributes.put("generalRequirements", getGeneralRequirements());
		attributes.put("description", getDescription());
		attributes.put("requiredGender", getRequiredGender());
		attributes.put("certificateType", getCertificateType());
		attributes.put("specialized", getSpecialized());
		attributes.put("experiences", getExperiences());
		attributes.put("foreignLanguages", getForeignLanguages());
		attributes.put("skills", getSkills());
		attributes.put("officeSkills", getOfficeSkills());
		attributes.put("awayToBusinessType", getAwayToBusinessType());
		attributes.put("workingTimeType", getWorkingTimeType());
		attributes.put("jobType", getJobType());
		attributes.put("code", getCode());
		attributes.put("status", getStatus());
		attributes.put("postedDate", getPostedDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		Integer approvedNumberOfPosition = (Integer)attributes.get(
				"approvedNumberOfPosition");

		if (approvedNumberOfPosition != null) {
			setApprovedNumberOfPosition(approvedNumberOfPosition);
		}

		Integer currentNumberOfEmployee = (Integer)attributes.get(
				"currentNumberOfEmployee");

		if (currentNumberOfEmployee != null) {
			setCurrentNumberOfEmployee(currentNumberOfEmployee);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Integer numberOfNewRecruitment = (Integer)attributes.get(
				"numberOfNewRecruitment");

		if (numberOfNewRecruitment != null) {
			setNumberOfNewRecruitment(numberOfNewRecruitment);
		}

		Integer numberOfReplacedRecruitment = (Integer)attributes.get(
				"numberOfReplacedRecruitment");

		if (numberOfReplacedRecruitment != null) {
			setNumberOfReplacedRecruitment(numberOfReplacedRecruitment);
		}

		Double expectedSalary = (Double)attributes.get("expectedSalary");

		if (expectedSalary != null) {
			setExpectedSalary(expectedSalary);
		}

		Date expectedJoinedDate = (Date)attributes.get("expectedJoinedDate");

		if (expectedJoinedDate != null) {
			setExpectedJoinedDate(expectedJoinedDate);
		}

		Long workPlaceId = (Long)attributes.get("workPlaceId");

		if (workPlaceId != null) {
			setWorkPlaceId(workPlaceId);
		}

		String generalRequirements = (String)attributes.get(
				"generalRequirements");

		if (generalRequirements != null) {
			setGeneralRequirements(generalRequirements);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String requiredGender = (String)attributes.get("requiredGender");

		if (requiredGender != null) {
			setRequiredGender(requiredGender);
		}

		String certificateType = (String)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		String specialized = (String)attributes.get("specialized");

		if (specialized != null) {
			setSpecialized(specialized);
		}

		Double experiences = (Double)attributes.get("experiences");

		if (experiences != null) {
			setExperiences(experiences);
		}

		String foreignLanguages = (String)attributes.get("foreignLanguages");

		if (foreignLanguages != null) {
			setForeignLanguages(foreignLanguages);
		}

		String skills = (String)attributes.get("skills");

		if (skills != null) {
			setSkills(skills);
		}

		String officeSkills = (String)attributes.get("officeSkills");

		if (officeSkills != null) {
			setOfficeSkills(officeSkills);
		}

		String awayToBusinessType = (String)attributes.get("awayToBusinessType");

		if (awayToBusinessType != null) {
			setAwayToBusinessType(awayToBusinessType);
		}

		String workingTimeType = (String)attributes.get("workingTimeType");

		if (workingTimeType != null) {
			setWorkingTimeType(workingTimeType);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date postedDate = (Date)attributes.get("postedDate");

		if (postedDate != null) {
			setPostedDate(postedDate);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	@Override
	public long getVacancyId() {
		return _vacancyId;
	}

	@Override
	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setVacancyId", long.class);

				method.invoke(_vacancyRemoteModel, vacancyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getApprovedNumberOfPosition() {
		return _approvedNumberOfPosition;
	}

	@Override
	public void setApprovedNumberOfPosition(int approvedNumberOfPosition) {
		_approvedNumberOfPosition = approvedNumberOfPosition;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovedNumberOfPosition",
						int.class);

				method.invoke(_vacancyRemoteModel, approvedNumberOfPosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getCurrentNumberOfEmployee() {
		return _currentNumberOfEmployee;
	}

	@Override
	public void setCurrentNumberOfEmployee(int currentNumberOfEmployee) {
		_currentNumberOfEmployee = currentNumberOfEmployee;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentNumberOfEmployee",
						int.class);

				method.invoke(_vacancyRemoteModel, currentNumberOfEmployee);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_vacancyRemoteModel, titlesId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitGroupId", long.class);

				method.invoke(_vacancyRemoteModel, unitGroupId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitId", long.class);

				method.invoke(_vacancyRemoteModel, unitId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_vacancyRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfNewRecruitment() {
		return _numberOfNewRecruitment;
	}

	@Override
	public void setNumberOfNewRecruitment(int numberOfNewRecruitment) {
		_numberOfNewRecruitment = numberOfNewRecruitment;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfNewRecruitment",
						int.class);

				method.invoke(_vacancyRemoteModel, numberOfNewRecruitment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfReplacedRecruitment() {
		return _numberOfReplacedRecruitment;
	}

	@Override
	public void setNumberOfReplacedRecruitment(int numberOfReplacedRecruitment) {
		_numberOfReplacedRecruitment = numberOfReplacedRecruitment;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfReplacedRecruitment",
						int.class);

				method.invoke(_vacancyRemoteModel, numberOfReplacedRecruitment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getExpectedSalary() {
		return _expectedSalary;
	}

	@Override
	public void setExpectedSalary(double expectedSalary) {
		_expectedSalary = expectedSalary;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedSalary",
						double.class);

				method.invoke(_vacancyRemoteModel, expectedSalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpectedJoinedDate() {
		return _expectedJoinedDate;
	}

	@Override
	public void setExpectedJoinedDate(Date expectedJoinedDate) {
		_expectedJoinedDate = expectedJoinedDate;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setExpectedJoinedDate",
						Date.class);

				method.invoke(_vacancyRemoteModel, expectedJoinedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getWorkPlaceId() {
		return _workPlaceId;
	}

	@Override
	public void setWorkPlaceId(long workPlaceId) {
		_workPlaceId = workPlaceId;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkPlaceId", long.class);

				method.invoke(_vacancyRemoteModel, workPlaceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeneralRequirements() {
		return _generalRequirements;
	}

	@Override
	public void setGeneralRequirements(String generalRequirements) {
		_generalRequirements = generalRequirements;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneralRequirements",
						String.class);

				method.invoke(_vacancyRemoteModel, generalRequirements);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_vacancyRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRequiredGender() {
		return _requiredGender;
	}

	@Override
	public void setRequiredGender(String requiredGender) {
		_requiredGender = requiredGender;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setRequiredGender",
						String.class);

				method.invoke(_vacancyRemoteModel, requiredGender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertificateType() {
		return _certificateType;
	}

	@Override
	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateType",
						String.class);

				method.invoke(_vacancyRemoteModel, certificateType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpecialized() {
		return _specialized;
	}

	@Override
	public void setSpecialized(String specialized) {
		_specialized = specialized;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecialized", String.class);

				method.invoke(_vacancyRemoteModel, specialized);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getExperiences() {
		return _experiences;
	}

	@Override
	public void setExperiences(double experiences) {
		_experiences = experiences;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setExperiences", double.class);

				method.invoke(_vacancyRemoteModel, experiences);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getForeignLanguages() {
		return _foreignLanguages;
	}

	@Override
	public void setForeignLanguages(String foreignLanguages) {
		_foreignLanguages = foreignLanguages;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setForeignLanguages",
						String.class);

				method.invoke(_vacancyRemoteModel, foreignLanguages);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSkills() {
		return _skills;
	}

	@Override
	public void setSkills(String skills) {
		_skills = skills;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setSkills", String.class);

				method.invoke(_vacancyRemoteModel, skills);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOfficeSkills() {
		return _officeSkills;
	}

	@Override
	public void setOfficeSkills(String officeSkills) {
		_officeSkills = officeSkills;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setOfficeSkills", String.class);

				method.invoke(_vacancyRemoteModel, officeSkills);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAwayToBusinessType() {
		return _awayToBusinessType;
	}

	@Override
	public void setAwayToBusinessType(String awayToBusinessType) {
		_awayToBusinessType = awayToBusinessType;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setAwayToBusinessType",
						String.class);

				method.invoke(_vacancyRemoteModel, awayToBusinessType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkingTimeType() {
		return _workingTimeType;
	}

	@Override
	public void setWorkingTimeType(String workingTimeType) {
		_workingTimeType = workingTimeType;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingTimeType",
						String.class);

				method.invoke(_vacancyRemoteModel, workingTimeType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobType() {
		return _jobType;
	}

	@Override
	public void setJobType(String jobType) {
		_jobType = jobType;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setJobType", String.class);

				method.invoke(_vacancyRemoteModel, jobType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_vacancyRemoteModel, code);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_vacancyRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPostedDate() {
		return _postedDate;
	}

	@Override
	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setPostedDate", Date.class);

				method.invoke(_vacancyRemoteModel, postedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiredDate() {
		return _expiredDate;
	}

	@Override
	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredDate", Date.class);

				method.invoke(_vacancyRemoteModel, expiredDate);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vacancyRemoteModel, groupId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vacancyRemoteModel, companyId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vacancyRemoteModel, userId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vacancyRemoteModel, userName);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vacancyRemoteModel, createDate);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_vacancyRemoteModel, modifiedDate);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_vacancyRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVacancyRemoteModel() {
		return _vacancyRemoteModel;
	}

	public void setVacancyRemoteModel(BaseModel<?> vacancyRemoteModel) {
		_vacancyRemoteModel = vacancyRemoteModel;
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

		Class<?> remoteModelClass = _vacancyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vacancyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VacancyLocalServiceUtil.addVacancy(this);
		}
		else {
			VacancyLocalServiceUtil.updateVacancy(this);
		}
	}

	@Override
	public Vacancy toEscapedModel() {
		return (Vacancy)ProxyUtil.newProxyInstance(Vacancy.class.getClassLoader(),
			new Class[] { Vacancy.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VacancyClp clone = new VacancyClp();

		clone.setVacancyId(getVacancyId());
		clone.setApprovedNumberOfPosition(getApprovedNumberOfPosition());
		clone.setCurrentNumberOfEmployee(getCurrentNumberOfEmployee());
		clone.setTitlesId(getTitlesId());
		clone.setUnitGroupId(getUnitGroupId());
		clone.setUnitId(getUnitId());
		clone.setDepartmentId(getDepartmentId());
		clone.setNumberOfNewRecruitment(getNumberOfNewRecruitment());
		clone.setNumberOfReplacedRecruitment(getNumberOfReplacedRecruitment());
		clone.setExpectedSalary(getExpectedSalary());
		clone.setExpectedJoinedDate(getExpectedJoinedDate());
		clone.setWorkPlaceId(getWorkPlaceId());
		clone.setGeneralRequirements(getGeneralRequirements());
		clone.setDescription(getDescription());
		clone.setRequiredGender(getRequiredGender());
		clone.setCertificateType(getCertificateType());
		clone.setSpecialized(getSpecialized());
		clone.setExperiences(getExperiences());
		clone.setForeignLanguages(getForeignLanguages());
		clone.setSkills(getSkills());
		clone.setOfficeSkills(getOfficeSkills());
		clone.setAwayToBusinessType(getAwayToBusinessType());
		clone.setWorkingTimeType(getWorkingTimeType());
		clone.setJobType(getJobType());
		clone.setCode(getCode());
		clone.setStatus(getStatus());
		clone.setPostedDate(getPostedDate());
		clone.setExpiredDate(getExpiredDate());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDeleted(getDeleted());

		return clone;
	}

	@Override
	public int compareTo(Vacancy vacancy) {
		long primaryKey = vacancy.getPrimaryKey();

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

		if (!(obj instanceof VacancyClp)) {
			return false;
		}

		VacancyClp vacancy = (VacancyClp)obj;

		long primaryKey = vacancy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(71);

		sb.append("{vacancyId=");
		sb.append(getVacancyId());
		sb.append(", approvedNumberOfPosition=");
		sb.append(getApprovedNumberOfPosition());
		sb.append(", currentNumberOfEmployee=");
		sb.append(getCurrentNumberOfEmployee());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", unitGroupId=");
		sb.append(getUnitGroupId());
		sb.append(", unitId=");
		sb.append(getUnitId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", numberOfNewRecruitment=");
		sb.append(getNumberOfNewRecruitment());
		sb.append(", numberOfReplacedRecruitment=");
		sb.append(getNumberOfReplacedRecruitment());
		sb.append(", expectedSalary=");
		sb.append(getExpectedSalary());
		sb.append(", expectedJoinedDate=");
		sb.append(getExpectedJoinedDate());
		sb.append(", workPlaceId=");
		sb.append(getWorkPlaceId());
		sb.append(", generalRequirements=");
		sb.append(getGeneralRequirements());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", requiredGender=");
		sb.append(getRequiredGender());
		sb.append(", certificateType=");
		sb.append(getCertificateType());
		sb.append(", specialized=");
		sb.append(getSpecialized());
		sb.append(", experiences=");
		sb.append(getExperiences());
		sb.append(", foreignLanguages=");
		sb.append(getForeignLanguages());
		sb.append(", skills=");
		sb.append(getSkills());
		sb.append(", officeSkills=");
		sb.append(getOfficeSkills());
		sb.append(", awayToBusinessType=");
		sb.append(getAwayToBusinessType());
		sb.append(", workingTimeType=");
		sb.append(getWorkingTimeType());
		sb.append(", jobType=");
		sb.append(getJobType());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", postedDate=");
		sb.append(getPostedDate());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
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
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(109);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.Vacancy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vacancyId</column-name><column-value><![CDATA[");
		sb.append(getVacancyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedNumberOfPosition</column-name><column-value><![CDATA[");
		sb.append(getApprovedNumberOfPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentNumberOfEmployee</column-name><column-value><![CDATA[");
		sb.append(getCurrentNumberOfEmployee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitGroupId</column-name><column-value><![CDATA[");
		sb.append(getUnitGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfNewRecruitment</column-name><column-value><![CDATA[");
		sb.append(getNumberOfNewRecruitment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfReplacedRecruitment</column-name><column-value><![CDATA[");
		sb.append(getNumberOfReplacedRecruitment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedSalary</column-name><column-value><![CDATA[");
		sb.append(getExpectedSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedJoinedDate</column-name><column-value><![CDATA[");
		sb.append(getExpectedJoinedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workPlaceId</column-name><column-value><![CDATA[");
		sb.append(getWorkPlaceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generalRequirements</column-name><column-value><![CDATA[");
		sb.append(getGeneralRequirements());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredGender</column-name><column-value><![CDATA[");
		sb.append(getRequiredGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateType</column-name><column-value><![CDATA[");
		sb.append(getCertificateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specialized</column-name><column-value><![CDATA[");
		sb.append(getSpecialized());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>experiences</column-name><column-value><![CDATA[");
		sb.append(getExperiences());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foreignLanguages</column-name><column-value><![CDATA[");
		sb.append(getForeignLanguages());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skills</column-name><column-value><![CDATA[");
		sb.append(getSkills());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSkills</column-name><column-value><![CDATA[");
		sb.append(getOfficeSkills());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>awayToBusinessType</column-name><column-value><![CDATA[");
		sb.append(getAwayToBusinessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingTimeType</column-name><column-value><![CDATA[");
		sb.append(getWorkingTimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobType</column-name><column-value><![CDATA[");
		sb.append(getJobType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postedDate</column-name><column-value><![CDATA[");
		sb.append(getPostedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
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
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _vacancyId;
	private int _approvedNumberOfPosition;
	private int _currentNumberOfEmployee;
	private long _titlesId;
	private long _unitGroupId;
	private long _unitId;
	private long _departmentId;
	private int _numberOfNewRecruitment;
	private int _numberOfReplacedRecruitment;
	private double _expectedSalary;
	private Date _expectedJoinedDate;
	private long _workPlaceId;
	private String _generalRequirements;
	private String _description;
	private String _requiredGender;
	private String _certificateType;
	private String _specialized;
	private double _experiences;
	private String _foreignLanguages;
	private String _skills;
	private String _officeSkills;
	private String _awayToBusinessType;
	private String _workingTimeType;
	private String _jobType;
	private String _code;
	private String _status;
	private Date _postedDate;
	private Date _expiredDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BaseModel<?> _vacancyRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}