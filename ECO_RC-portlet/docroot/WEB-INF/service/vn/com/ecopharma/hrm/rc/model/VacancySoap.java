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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.VacancyServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.VacancyServiceSoap
 * @generated
 */
public class VacancySoap implements Serializable {
	public static VacancySoap toSoapModel(Vacancy model) {
		VacancySoap soapModel = new VacancySoap();

		soapModel.setVacancyId(model.getVacancyId());
		soapModel.setApprovedNumberOfPosition(model.getApprovedNumberOfPosition());
		soapModel.setCurrentNumberOfEmployee(model.getCurrentNumberOfEmployee());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setUnitGroupId(model.getUnitGroupId());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setNumberOfNewRecruitment(model.getNumberOfNewRecruitment());
		soapModel.setNumberOfReplacedRecruitment(model.getNumberOfReplacedRecruitment());
		soapModel.setExpectedSalary(model.getExpectedSalary());
		soapModel.setExpectedJoinedDate(model.getExpectedJoinedDate());
		soapModel.setWorkPlaceId(model.getWorkPlaceId());
		soapModel.setGeneralRequirements(model.getGeneralRequirements());
		soapModel.setDescription(model.getDescription());
		soapModel.setRequiredGender(model.getRequiredGender());
		soapModel.setCertificateType(model.getCertificateType());
		soapModel.setSpecialized(model.getSpecialized());
		soapModel.setExperiences(model.getExperiences());
		soapModel.setForeignLanguages(model.getForeignLanguages());
		soapModel.setSkills(model.getSkills());
		soapModel.setOfficeSkills(model.getOfficeSkills());
		soapModel.setAwayToBusinessType(model.getAwayToBusinessType());
		soapModel.setWorkingTimeType(model.getWorkingTimeType());
		soapModel.setJobType(model.getJobType());
		soapModel.setCode(model.getCode());
		soapModel.setStatus(model.getStatus());
		soapModel.setPostedDate(model.getPostedDate());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static VacancySoap[] toSoapModels(Vacancy[] models) {
		VacancySoap[] soapModels = new VacancySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacancySoap[][] toSoapModels(Vacancy[][] models) {
		VacancySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacancySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacancySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacancySoap[] toSoapModels(List<Vacancy> models) {
		List<VacancySoap> soapModels = new ArrayList<VacancySoap>(models.size());

		for (Vacancy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacancySoap[soapModels.size()]);
	}

	public VacancySoap() {
	}

	public long getPrimaryKey() {
		return _vacancyId;
	}

	public void setPrimaryKey(long pk) {
		setVacancyId(pk);
	}

	public long getVacancyId() {
		return _vacancyId;
	}

	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;
	}

	public int getApprovedNumberOfPosition() {
		return _approvedNumberOfPosition;
	}

	public void setApprovedNumberOfPosition(int approvedNumberOfPosition) {
		_approvedNumberOfPosition = approvedNumberOfPosition;
	}

	public int getCurrentNumberOfEmployee() {
		return _currentNumberOfEmployee;
	}

	public void setCurrentNumberOfEmployee(int currentNumberOfEmployee) {
		_currentNumberOfEmployee = currentNumberOfEmployee;
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

	public int getNumberOfNewRecruitment() {
		return _numberOfNewRecruitment;
	}

	public void setNumberOfNewRecruitment(int numberOfNewRecruitment) {
		_numberOfNewRecruitment = numberOfNewRecruitment;
	}

	public int getNumberOfReplacedRecruitment() {
		return _numberOfReplacedRecruitment;
	}

	public void setNumberOfReplacedRecruitment(int numberOfReplacedRecruitment) {
		_numberOfReplacedRecruitment = numberOfReplacedRecruitment;
	}

	public double getExpectedSalary() {
		return _expectedSalary;
	}

	public void setExpectedSalary(double expectedSalary) {
		_expectedSalary = expectedSalary;
	}

	public Date getExpectedJoinedDate() {
		return _expectedJoinedDate;
	}

	public void setExpectedJoinedDate(Date expectedJoinedDate) {
		_expectedJoinedDate = expectedJoinedDate;
	}

	public long getWorkPlaceId() {
		return _workPlaceId;
	}

	public void setWorkPlaceId(long workPlaceId) {
		_workPlaceId = workPlaceId;
	}

	public String getGeneralRequirements() {
		return _generalRequirements;
	}

	public void setGeneralRequirements(String generalRequirements) {
		_generalRequirements = generalRequirements;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getRequiredGender() {
		return _requiredGender;
	}

	public void setRequiredGender(String requiredGender) {
		_requiredGender = requiredGender;
	}

	public String getCertificateType() {
		return _certificateType;
	}

	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;
	}

	public String getSpecialized() {
		return _specialized;
	}

	public void setSpecialized(String specialized) {
		_specialized = specialized;
	}

	public double getExperiences() {
		return _experiences;
	}

	public void setExperiences(double experiences) {
		_experiences = experiences;
	}

	public String getForeignLanguages() {
		return _foreignLanguages;
	}

	public void setForeignLanguages(String foreignLanguages) {
		_foreignLanguages = foreignLanguages;
	}

	public String getSkills() {
		return _skills;
	}

	public void setSkills(String skills) {
		_skills = skills;
	}

	public String getOfficeSkills() {
		return _officeSkills;
	}

	public void setOfficeSkills(String officeSkills) {
		_officeSkills = officeSkills;
	}

	public String getAwayToBusinessType() {
		return _awayToBusinessType;
	}

	public void setAwayToBusinessType(String awayToBusinessType) {
		_awayToBusinessType = awayToBusinessType;
	}

	public String getWorkingTimeType() {
		return _workingTimeType;
	}

	public void setWorkingTimeType(String workingTimeType) {
		_workingTimeType = workingTimeType;
	}

	public String getJobType() {
		return _jobType;
	}

	public void setJobType(String jobType) {
		_jobType = jobType;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getPostedDate() {
		return _postedDate;
	}

	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
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

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
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
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
}