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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Vacancy}.
 * </p>
 *
 * @author tvt
 * @see Vacancy
 * @generated
 */
public class VacancyWrapper implements Vacancy, ModelWrapper<Vacancy> {
	public VacancyWrapper(Vacancy vacancy) {
		_vacancy = vacancy;
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

	/**
	* Returns the primary key of this vacancy.
	*
	* @return the primary key of this vacancy
	*/
	@Override
	public long getPrimaryKey() {
		return _vacancy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vacancy.
	*
	* @param primaryKey the primary key of this vacancy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vacancy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vacancy ID of this vacancy.
	*
	* @return the vacancy ID of this vacancy
	*/
	@Override
	public long getVacancyId() {
		return _vacancy.getVacancyId();
	}

	/**
	* Sets the vacancy ID of this vacancy.
	*
	* @param vacancyId the vacancy ID of this vacancy
	*/
	@Override
	public void setVacancyId(long vacancyId) {
		_vacancy.setVacancyId(vacancyId);
	}

	/**
	* Returns the approved number of position of this vacancy.
	*
	* @return the approved number of position of this vacancy
	*/
	@Override
	public int getApprovedNumberOfPosition() {
		return _vacancy.getApprovedNumberOfPosition();
	}

	/**
	* Sets the approved number of position of this vacancy.
	*
	* @param approvedNumberOfPosition the approved number of position of this vacancy
	*/
	@Override
	public void setApprovedNumberOfPosition(int approvedNumberOfPosition) {
		_vacancy.setApprovedNumberOfPosition(approvedNumberOfPosition);
	}

	/**
	* Returns the current number of employee of this vacancy.
	*
	* @return the current number of employee of this vacancy
	*/
	@Override
	public int getCurrentNumberOfEmployee() {
		return _vacancy.getCurrentNumberOfEmployee();
	}

	/**
	* Sets the current number of employee of this vacancy.
	*
	* @param currentNumberOfEmployee the current number of employee of this vacancy
	*/
	@Override
	public void setCurrentNumberOfEmployee(int currentNumberOfEmployee) {
		_vacancy.setCurrentNumberOfEmployee(currentNumberOfEmployee);
	}

	/**
	* Returns the titles ID of this vacancy.
	*
	* @return the titles ID of this vacancy
	*/
	@Override
	public long getTitlesId() {
		return _vacancy.getTitlesId();
	}

	/**
	* Sets the titles ID of this vacancy.
	*
	* @param titlesId the titles ID of this vacancy
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_vacancy.setTitlesId(titlesId);
	}

	/**
	* Returns the unit group ID of this vacancy.
	*
	* @return the unit group ID of this vacancy
	*/
	@Override
	public long getUnitGroupId() {
		return _vacancy.getUnitGroupId();
	}

	/**
	* Sets the unit group ID of this vacancy.
	*
	* @param unitGroupId the unit group ID of this vacancy
	*/
	@Override
	public void setUnitGroupId(long unitGroupId) {
		_vacancy.setUnitGroupId(unitGroupId);
	}

	/**
	* Returns the unit ID of this vacancy.
	*
	* @return the unit ID of this vacancy
	*/
	@Override
	public long getUnitId() {
		return _vacancy.getUnitId();
	}

	/**
	* Sets the unit ID of this vacancy.
	*
	* @param unitId the unit ID of this vacancy
	*/
	@Override
	public void setUnitId(long unitId) {
		_vacancy.setUnitId(unitId);
	}

	/**
	* Returns the department ID of this vacancy.
	*
	* @return the department ID of this vacancy
	*/
	@Override
	public long getDepartmentId() {
		return _vacancy.getDepartmentId();
	}

	/**
	* Sets the department ID of this vacancy.
	*
	* @param departmentId the department ID of this vacancy
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_vacancy.setDepartmentId(departmentId);
	}

	/**
	* Returns the number of new recruitment of this vacancy.
	*
	* @return the number of new recruitment of this vacancy
	*/
	@Override
	public int getNumberOfNewRecruitment() {
		return _vacancy.getNumberOfNewRecruitment();
	}

	/**
	* Sets the number of new recruitment of this vacancy.
	*
	* @param numberOfNewRecruitment the number of new recruitment of this vacancy
	*/
	@Override
	public void setNumberOfNewRecruitment(int numberOfNewRecruitment) {
		_vacancy.setNumberOfNewRecruitment(numberOfNewRecruitment);
	}

	/**
	* Returns the number of replaced recruitment of this vacancy.
	*
	* @return the number of replaced recruitment of this vacancy
	*/
	@Override
	public int getNumberOfReplacedRecruitment() {
		return _vacancy.getNumberOfReplacedRecruitment();
	}

	/**
	* Sets the number of replaced recruitment of this vacancy.
	*
	* @param numberOfReplacedRecruitment the number of replaced recruitment of this vacancy
	*/
	@Override
	public void setNumberOfReplacedRecruitment(int numberOfReplacedRecruitment) {
		_vacancy.setNumberOfReplacedRecruitment(numberOfReplacedRecruitment);
	}

	/**
	* Returns the expected salary of this vacancy.
	*
	* @return the expected salary of this vacancy
	*/
	@Override
	public double getExpectedSalary() {
		return _vacancy.getExpectedSalary();
	}

	/**
	* Sets the expected salary of this vacancy.
	*
	* @param expectedSalary the expected salary of this vacancy
	*/
	@Override
	public void setExpectedSalary(double expectedSalary) {
		_vacancy.setExpectedSalary(expectedSalary);
	}

	/**
	* Returns the expected joined date of this vacancy.
	*
	* @return the expected joined date of this vacancy
	*/
	@Override
	public java.util.Date getExpectedJoinedDate() {
		return _vacancy.getExpectedJoinedDate();
	}

	/**
	* Sets the expected joined date of this vacancy.
	*
	* @param expectedJoinedDate the expected joined date of this vacancy
	*/
	@Override
	public void setExpectedJoinedDate(java.util.Date expectedJoinedDate) {
		_vacancy.setExpectedJoinedDate(expectedJoinedDate);
	}

	/**
	* Returns the work place ID of this vacancy.
	*
	* @return the work place ID of this vacancy
	*/
	@Override
	public long getWorkPlaceId() {
		return _vacancy.getWorkPlaceId();
	}

	/**
	* Sets the work place ID of this vacancy.
	*
	* @param workPlaceId the work place ID of this vacancy
	*/
	@Override
	public void setWorkPlaceId(long workPlaceId) {
		_vacancy.setWorkPlaceId(workPlaceId);
	}

	/**
	* Returns the general requirements of this vacancy.
	*
	* @return the general requirements of this vacancy
	*/
	@Override
	public java.lang.String getGeneralRequirements() {
		return _vacancy.getGeneralRequirements();
	}

	/**
	* Sets the general requirements of this vacancy.
	*
	* @param generalRequirements the general requirements of this vacancy
	*/
	@Override
	public void setGeneralRequirements(java.lang.String generalRequirements) {
		_vacancy.setGeneralRequirements(generalRequirements);
	}

	/**
	* Returns the description of this vacancy.
	*
	* @return the description of this vacancy
	*/
	@Override
	public java.lang.String getDescription() {
		return _vacancy.getDescription();
	}

	/**
	* Sets the description of this vacancy.
	*
	* @param description the description of this vacancy
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_vacancy.setDescription(description);
	}

	/**
	* Returns the required gender of this vacancy.
	*
	* @return the required gender of this vacancy
	*/
	@Override
	public java.lang.String getRequiredGender() {
		return _vacancy.getRequiredGender();
	}

	/**
	* Sets the required gender of this vacancy.
	*
	* @param requiredGender the required gender of this vacancy
	*/
	@Override
	public void setRequiredGender(java.lang.String requiredGender) {
		_vacancy.setRequiredGender(requiredGender);
	}

	/**
	* Returns the certificate type of this vacancy.
	*
	* @return the certificate type of this vacancy
	*/
	@Override
	public java.lang.String getCertificateType() {
		return _vacancy.getCertificateType();
	}

	/**
	* Sets the certificate type of this vacancy.
	*
	* @param certificateType the certificate type of this vacancy
	*/
	@Override
	public void setCertificateType(java.lang.String certificateType) {
		_vacancy.setCertificateType(certificateType);
	}

	/**
	* Returns the specialized of this vacancy.
	*
	* @return the specialized of this vacancy
	*/
	@Override
	public java.lang.String getSpecialized() {
		return _vacancy.getSpecialized();
	}

	/**
	* Sets the specialized of this vacancy.
	*
	* @param specialized the specialized of this vacancy
	*/
	@Override
	public void setSpecialized(java.lang.String specialized) {
		_vacancy.setSpecialized(specialized);
	}

	/**
	* Returns the experiences of this vacancy.
	*
	* @return the experiences of this vacancy
	*/
	@Override
	public double getExperiences() {
		return _vacancy.getExperiences();
	}

	/**
	* Sets the experiences of this vacancy.
	*
	* @param experiences the experiences of this vacancy
	*/
	@Override
	public void setExperiences(double experiences) {
		_vacancy.setExperiences(experiences);
	}

	/**
	* Returns the foreign languages of this vacancy.
	*
	* @return the foreign languages of this vacancy
	*/
	@Override
	public java.lang.String getForeignLanguages() {
		return _vacancy.getForeignLanguages();
	}

	/**
	* Sets the foreign languages of this vacancy.
	*
	* @param foreignLanguages the foreign languages of this vacancy
	*/
	@Override
	public void setForeignLanguages(java.lang.String foreignLanguages) {
		_vacancy.setForeignLanguages(foreignLanguages);
	}

	/**
	* Returns the skills of this vacancy.
	*
	* @return the skills of this vacancy
	*/
	@Override
	public java.lang.String getSkills() {
		return _vacancy.getSkills();
	}

	/**
	* Sets the skills of this vacancy.
	*
	* @param skills the skills of this vacancy
	*/
	@Override
	public void setSkills(java.lang.String skills) {
		_vacancy.setSkills(skills);
	}

	/**
	* Returns the office skills of this vacancy.
	*
	* @return the office skills of this vacancy
	*/
	@Override
	public java.lang.String getOfficeSkills() {
		return _vacancy.getOfficeSkills();
	}

	/**
	* Sets the office skills of this vacancy.
	*
	* @param officeSkills the office skills of this vacancy
	*/
	@Override
	public void setOfficeSkills(java.lang.String officeSkills) {
		_vacancy.setOfficeSkills(officeSkills);
	}

	/**
	* Returns the away to business type of this vacancy.
	*
	* @return the away to business type of this vacancy
	*/
	@Override
	public java.lang.String getAwayToBusinessType() {
		return _vacancy.getAwayToBusinessType();
	}

	/**
	* Sets the away to business type of this vacancy.
	*
	* @param awayToBusinessType the away to business type of this vacancy
	*/
	@Override
	public void setAwayToBusinessType(java.lang.String awayToBusinessType) {
		_vacancy.setAwayToBusinessType(awayToBusinessType);
	}

	/**
	* Returns the working time type of this vacancy.
	*
	* @return the working time type of this vacancy
	*/
	@Override
	public java.lang.String getWorkingTimeType() {
		return _vacancy.getWorkingTimeType();
	}

	/**
	* Sets the working time type of this vacancy.
	*
	* @param workingTimeType the working time type of this vacancy
	*/
	@Override
	public void setWorkingTimeType(java.lang.String workingTimeType) {
		_vacancy.setWorkingTimeType(workingTimeType);
	}

	/**
	* Returns the job type of this vacancy.
	*
	* @return the job type of this vacancy
	*/
	@Override
	public java.lang.String getJobType() {
		return _vacancy.getJobType();
	}

	/**
	* Sets the job type of this vacancy.
	*
	* @param jobType the job type of this vacancy
	*/
	@Override
	public void setJobType(java.lang.String jobType) {
		_vacancy.setJobType(jobType);
	}

	/**
	* Returns the code of this vacancy.
	*
	* @return the code of this vacancy
	*/
	@Override
	public java.lang.String getCode() {
		return _vacancy.getCode();
	}

	/**
	* Sets the code of this vacancy.
	*
	* @param code the code of this vacancy
	*/
	@Override
	public void setCode(java.lang.String code) {
		_vacancy.setCode(code);
	}

	/**
	* Returns the status of this vacancy.
	*
	* @return the status of this vacancy
	*/
	@Override
	public java.lang.String getStatus() {
		return _vacancy.getStatus();
	}

	/**
	* Sets the status of this vacancy.
	*
	* @param status the status of this vacancy
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_vacancy.setStatus(status);
	}

	/**
	* Returns the posted date of this vacancy.
	*
	* @return the posted date of this vacancy
	*/
	@Override
	public java.util.Date getPostedDate() {
		return _vacancy.getPostedDate();
	}

	/**
	* Sets the posted date of this vacancy.
	*
	* @param postedDate the posted date of this vacancy
	*/
	@Override
	public void setPostedDate(java.util.Date postedDate) {
		_vacancy.setPostedDate(postedDate);
	}

	/**
	* Returns the expired date of this vacancy.
	*
	* @return the expired date of this vacancy
	*/
	@Override
	public java.util.Date getExpiredDate() {
		return _vacancy.getExpiredDate();
	}

	/**
	* Sets the expired date of this vacancy.
	*
	* @param expiredDate the expired date of this vacancy
	*/
	@Override
	public void setExpiredDate(java.util.Date expiredDate) {
		_vacancy.setExpiredDate(expiredDate);
	}

	/**
	* Returns the group ID of this vacancy.
	*
	* @return the group ID of this vacancy
	*/
	@Override
	public long getGroupId() {
		return _vacancy.getGroupId();
	}

	/**
	* Sets the group ID of this vacancy.
	*
	* @param groupId the group ID of this vacancy
	*/
	@Override
	public void setGroupId(long groupId) {
		_vacancy.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vacancy.
	*
	* @return the company ID of this vacancy
	*/
	@Override
	public long getCompanyId() {
		return _vacancy.getCompanyId();
	}

	/**
	* Sets the company ID of this vacancy.
	*
	* @param companyId the company ID of this vacancy
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vacancy.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vacancy.
	*
	* @return the user ID of this vacancy
	*/
	@Override
	public long getUserId() {
		return _vacancy.getUserId();
	}

	/**
	* Sets the user ID of this vacancy.
	*
	* @param userId the user ID of this vacancy
	*/
	@Override
	public void setUserId(long userId) {
		_vacancy.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vacancy.
	*
	* @return the user uuid of this vacancy
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancy.getUserUuid();
	}

	/**
	* Sets the user uuid of this vacancy.
	*
	* @param userUuid the user uuid of this vacancy
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vacancy.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vacancy.
	*
	* @return the user name of this vacancy
	*/
	@Override
	public java.lang.String getUserName() {
		return _vacancy.getUserName();
	}

	/**
	* Sets the user name of this vacancy.
	*
	* @param userName the user name of this vacancy
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vacancy.setUserName(userName);
	}

	/**
	* Returns the create date of this vacancy.
	*
	* @return the create date of this vacancy
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vacancy.getCreateDate();
	}

	/**
	* Sets the create date of this vacancy.
	*
	* @param createDate the create date of this vacancy
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vacancy.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vacancy.
	*
	* @return the modified date of this vacancy
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vacancy.getModifiedDate();
	}

	/**
	* Sets the modified date of this vacancy.
	*
	* @param modifiedDate the modified date of this vacancy
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vacancy.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this vacancy.
	*
	* @return the deleted of this vacancy
	*/
	@Override
	public boolean getDeleted() {
		return _vacancy.getDeleted();
	}

	/**
	* Returns <code>true</code> if this vacancy is deleted.
	*
	* @return <code>true</code> if this vacancy is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _vacancy.isDeleted();
	}

	/**
	* Sets whether this vacancy is deleted.
	*
	* @param deleted the deleted of this vacancy
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_vacancy.setDeleted(deleted);
	}

	@Override
	public boolean isNew() {
		return _vacancy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vacancy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vacancy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vacancy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vacancy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vacancy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vacancy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vacancy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vacancy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vacancy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vacancy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VacancyWrapper((Vacancy)_vacancy.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.hrm.rc.model.Vacancy vacancy) {
		return _vacancy.compareTo(vacancy);
	}

	@Override
	public int hashCode() {
		return _vacancy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.Vacancy> toCacheModel() {
		return _vacancy.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Vacancy toEscapedModel() {
		return new VacancyWrapper(_vacancy.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Vacancy toUnescapedModel() {
		return new VacancyWrapper(_vacancy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vacancy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vacancy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vacancy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacancyWrapper)) {
			return false;
		}

		VacancyWrapper vacancyWrapper = (VacancyWrapper)obj;

		if (Validator.equals(_vacancy, vacancyWrapper._vacancy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Vacancy getWrappedVacancy() {
		return _vacancy;
	}

	@Override
	public Vacancy getWrappedModel() {
		return _vacancy;
	}

	@Override
	public void resetOriginalValues() {
		_vacancy.resetOriginalValues();
	}

	private Vacancy _vacancy;
}