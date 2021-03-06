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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Vacancy service. Represents a row in the &quot;eco_rcp_Vacancy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.hrm.rc.model.impl.VacancyImpl}.
 * </p>
 *
 * @author tvt
 * @see Vacancy
 * @see vn.com.ecopharma.hrm.rc.model.impl.VacancyImpl
 * @see vn.com.ecopharma.hrm.rc.model.impl.VacancyModelImpl
 * @generated
 */
public interface VacancyModel extends BaseModel<Vacancy>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vacancy model instance should use the {@link Vacancy} interface instead.
	 */

	/**
	 * Returns the primary key of this vacancy.
	 *
	 * @return the primary key of this vacancy
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this vacancy.
	 *
	 * @param primaryKey the primary key of this vacancy
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the vacancy ID of this vacancy.
	 *
	 * @return the vacancy ID of this vacancy
	 */
	public long getVacancyId();

	/**
	 * Sets the vacancy ID of this vacancy.
	 *
	 * @param vacancyId the vacancy ID of this vacancy
	 */
	public void setVacancyId(long vacancyId);

	/**
	 * Returns the approved number of position of this vacancy.
	 *
	 * @return the approved number of position of this vacancy
	 */
	public int getApprovedNumberOfPosition();

	/**
	 * Sets the approved number of position of this vacancy.
	 *
	 * @param approvedNumberOfPosition the approved number of position of this vacancy
	 */
	public void setApprovedNumberOfPosition(int approvedNumberOfPosition);

	/**
	 * Returns the current number of employee of this vacancy.
	 *
	 * @return the current number of employee of this vacancy
	 */
	public int getCurrentNumberOfEmployee();

	/**
	 * Sets the current number of employee of this vacancy.
	 *
	 * @param currentNumberOfEmployee the current number of employee of this vacancy
	 */
	public void setCurrentNumberOfEmployee(int currentNumberOfEmployee);

	/**
	 * Returns the titles ID of this vacancy.
	 *
	 * @return the titles ID of this vacancy
	 */
	public long getTitlesId();

	/**
	 * Sets the titles ID of this vacancy.
	 *
	 * @param titlesId the titles ID of this vacancy
	 */
	public void setTitlesId(long titlesId);

	/**
	 * Returns the unit group ID of this vacancy.
	 *
	 * @return the unit group ID of this vacancy
	 */
	public long getUnitGroupId();

	/**
	 * Sets the unit group ID of this vacancy.
	 *
	 * @param unitGroupId the unit group ID of this vacancy
	 */
	public void setUnitGroupId(long unitGroupId);

	/**
	 * Returns the unit ID of this vacancy.
	 *
	 * @return the unit ID of this vacancy
	 */
	public long getUnitId();

	/**
	 * Sets the unit ID of this vacancy.
	 *
	 * @param unitId the unit ID of this vacancy
	 */
	public void setUnitId(long unitId);

	/**
	 * Returns the department ID of this vacancy.
	 *
	 * @return the department ID of this vacancy
	 */
	public long getDepartmentId();

	/**
	 * Sets the department ID of this vacancy.
	 *
	 * @param departmentId the department ID of this vacancy
	 */
	public void setDepartmentId(long departmentId);

	/**
	 * Returns the number of new recruitment of this vacancy.
	 *
	 * @return the number of new recruitment of this vacancy
	 */
	public int getNumberOfNewRecruitment();

	/**
	 * Sets the number of new recruitment of this vacancy.
	 *
	 * @param numberOfNewRecruitment the number of new recruitment of this vacancy
	 */
	public void setNumberOfNewRecruitment(int numberOfNewRecruitment);

	/**
	 * Returns the number of replaced recruitment of this vacancy.
	 *
	 * @return the number of replaced recruitment of this vacancy
	 */
	public int getNumberOfReplacedRecruitment();

	/**
	 * Sets the number of replaced recruitment of this vacancy.
	 *
	 * @param numberOfReplacedRecruitment the number of replaced recruitment of this vacancy
	 */
	public void setNumberOfReplacedRecruitment(int numberOfReplacedRecruitment);

	/**
	 * Returns the expected salary of this vacancy.
	 *
	 * @return the expected salary of this vacancy
	 */
	public double getExpectedSalary();

	/**
	 * Sets the expected salary of this vacancy.
	 *
	 * @param expectedSalary the expected salary of this vacancy
	 */
	public void setExpectedSalary(double expectedSalary);

	/**
	 * Returns the expected joined date of this vacancy.
	 *
	 * @return the expected joined date of this vacancy
	 */
	public Date getExpectedJoinedDate();

	/**
	 * Sets the expected joined date of this vacancy.
	 *
	 * @param expectedJoinedDate the expected joined date of this vacancy
	 */
	public void setExpectedJoinedDate(Date expectedJoinedDate);

	/**
	 * Returns the work place ID of this vacancy.
	 *
	 * @return the work place ID of this vacancy
	 */
	public long getWorkPlaceId();

	/**
	 * Sets the work place ID of this vacancy.
	 *
	 * @param workPlaceId the work place ID of this vacancy
	 */
	public void setWorkPlaceId(long workPlaceId);

	/**
	 * Returns the general requirements of this vacancy.
	 *
	 * @return the general requirements of this vacancy
	 */
	@AutoEscape
	public String getGeneralRequirements();

	/**
	 * Sets the general requirements of this vacancy.
	 *
	 * @param generalRequirements the general requirements of this vacancy
	 */
	public void setGeneralRequirements(String generalRequirements);

	/**
	 * Returns the description of this vacancy.
	 *
	 * @return the description of this vacancy
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this vacancy.
	 *
	 * @param description the description of this vacancy
	 */
	public void setDescription(String description);

	/**
	 * Returns the required gender of this vacancy.
	 *
	 * @return the required gender of this vacancy
	 */
	@AutoEscape
	public String getRequiredGender();

	/**
	 * Sets the required gender of this vacancy.
	 *
	 * @param requiredGender the required gender of this vacancy
	 */
	public void setRequiredGender(String requiredGender);

	/**
	 * Returns the certificate type of this vacancy.
	 *
	 * @return the certificate type of this vacancy
	 */
	@AutoEscape
	public String getCertificateType();

	/**
	 * Sets the certificate type of this vacancy.
	 *
	 * @param certificateType the certificate type of this vacancy
	 */
	public void setCertificateType(String certificateType);

	/**
	 * Returns the specialized of this vacancy.
	 *
	 * @return the specialized of this vacancy
	 */
	@AutoEscape
	public String getSpecialized();

	/**
	 * Sets the specialized of this vacancy.
	 *
	 * @param specialized the specialized of this vacancy
	 */
	public void setSpecialized(String specialized);

	/**
	 * Returns the experiences of this vacancy.
	 *
	 * @return the experiences of this vacancy
	 */
	public double getExperiences();

	/**
	 * Sets the experiences of this vacancy.
	 *
	 * @param experiences the experiences of this vacancy
	 */
	public void setExperiences(double experiences);

	/**
	 * Returns the foreign languages of this vacancy.
	 *
	 * @return the foreign languages of this vacancy
	 */
	@AutoEscape
	public String getForeignLanguages();

	/**
	 * Sets the foreign languages of this vacancy.
	 *
	 * @param foreignLanguages the foreign languages of this vacancy
	 */
	public void setForeignLanguages(String foreignLanguages);

	/**
	 * Returns the skills of this vacancy.
	 *
	 * @return the skills of this vacancy
	 */
	@AutoEscape
	public String getSkills();

	/**
	 * Sets the skills of this vacancy.
	 *
	 * @param skills the skills of this vacancy
	 */
	public void setSkills(String skills);

	/**
	 * Returns the office skills of this vacancy.
	 *
	 * @return the office skills of this vacancy
	 */
	@AutoEscape
	public String getOfficeSkills();

	/**
	 * Sets the office skills of this vacancy.
	 *
	 * @param officeSkills the office skills of this vacancy
	 */
	public void setOfficeSkills(String officeSkills);

	/**
	 * Returns the away to business type of this vacancy.
	 *
	 * @return the away to business type of this vacancy
	 */
	@AutoEscape
	public String getAwayToBusinessType();

	/**
	 * Sets the away to business type of this vacancy.
	 *
	 * @param awayToBusinessType the away to business type of this vacancy
	 */
	public void setAwayToBusinessType(String awayToBusinessType);

	/**
	 * Returns the working time type of this vacancy.
	 *
	 * @return the working time type of this vacancy
	 */
	@AutoEscape
	public String getWorkingTimeType();

	/**
	 * Sets the working time type of this vacancy.
	 *
	 * @param workingTimeType the working time type of this vacancy
	 */
	public void setWorkingTimeType(String workingTimeType);

	/**
	 * Returns the job type of this vacancy.
	 *
	 * @return the job type of this vacancy
	 */
	@AutoEscape
	public String getJobType();

	/**
	 * Sets the job type of this vacancy.
	 *
	 * @param jobType the job type of this vacancy
	 */
	public void setJobType(String jobType);

	/**
	 * Returns the code of this vacancy.
	 *
	 * @return the code of this vacancy
	 */
	@AutoEscape
	public String getCode();

	/**
	 * Sets the code of this vacancy.
	 *
	 * @param code the code of this vacancy
	 */
	public void setCode(String code);

	/**
	 * Returns the status of this vacancy.
	 *
	 * @return the status of this vacancy
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this vacancy.
	 *
	 * @param status the status of this vacancy
	 */
	public void setStatus(String status);

	/**
	 * Returns the posted date of this vacancy.
	 *
	 * @return the posted date of this vacancy
	 */
	public Date getPostedDate();

	/**
	 * Sets the posted date of this vacancy.
	 *
	 * @param postedDate the posted date of this vacancy
	 */
	public void setPostedDate(Date postedDate);

	/**
	 * Returns the expired date of this vacancy.
	 *
	 * @return the expired date of this vacancy
	 */
	public Date getExpiredDate();

	/**
	 * Sets the expired date of this vacancy.
	 *
	 * @param expiredDate the expired date of this vacancy
	 */
	public void setExpiredDate(Date expiredDate);

	/**
	 * Returns the group ID of this vacancy.
	 *
	 * @return the group ID of this vacancy
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this vacancy.
	 *
	 * @param groupId the group ID of this vacancy
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this vacancy.
	 *
	 * @return the company ID of this vacancy
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this vacancy.
	 *
	 * @param companyId the company ID of this vacancy
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this vacancy.
	 *
	 * @return the user ID of this vacancy
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this vacancy.
	 *
	 * @param userId the user ID of this vacancy
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this vacancy.
	 *
	 * @return the user uuid of this vacancy
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this vacancy.
	 *
	 * @param userUuid the user uuid of this vacancy
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this vacancy.
	 *
	 * @return the user name of this vacancy
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this vacancy.
	 *
	 * @param userName the user name of this vacancy
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this vacancy.
	 *
	 * @return the create date of this vacancy
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this vacancy.
	 *
	 * @param createDate the create date of this vacancy
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this vacancy.
	 *
	 * @return the modified date of this vacancy
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this vacancy.
	 *
	 * @param modifiedDate the modified date of this vacancy
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the deleted of this vacancy.
	 *
	 * @return the deleted of this vacancy
	 */
	public boolean getDeleted();

	/**
	 * Returns <code>true</code> if this vacancy is deleted.
	 *
	 * @return <code>true</code> if this vacancy is deleted; <code>false</code> otherwise
	 */
	public boolean isDeleted();

	/**
	 * Sets whether this vacancy is deleted.
	 *
	 * @param deleted the deleted of this vacancy
	 */
	public void setDeleted(boolean deleted);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Vacancy vacancy);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Vacancy> toCacheModel();

	@Override
	public Vacancy toEscapedModel();

	@Override
	public Vacancy toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}