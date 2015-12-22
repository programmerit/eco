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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.ExperienceServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.ExperienceServiceSoap
 * @generated
 */
public class ExperienceSoap implements Serializable {
	public static ExperienceSoap toSoapModel(Experience model) {
		ExperienceSoap soapModel = new ExperienceSoap();

		soapModel.setExperienceId(model.getExperienceId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setWorkingPlace(model.getWorkingPlace());
		soapModel.setYearsExperience(model.getYearsExperience());
		soapModel.setTel(model.getTel());
		soapModel.setWorkingFrom(model.getWorkingFrom());
		soapModel.setWorkingTo(model.getWorkingTo());
		soapModel.setInitialTitles(model.getInitialTitles());
		soapModel.setFinalTitles(model.getFinalTitles());
		soapModel.setInitialSalary(model.getInitialSalary());
		soapModel.setFinalSalary(model.getFinalSalary());
		soapModel.setField(model.getField());
		soapModel.setManager(model.getManager());
		soapModel.setResponsibility(model.getResponsibility());
		soapModel.setResignedReason(model.getResignedReason());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ExperienceSoap[] toSoapModels(Experience[] models) {
		ExperienceSoap[] soapModels = new ExperienceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExperienceSoap[][] toSoapModels(Experience[][] models) {
		ExperienceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExperienceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExperienceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExperienceSoap[] toSoapModels(List<Experience> models) {
		List<ExperienceSoap> soapModels = new ArrayList<ExperienceSoap>(models.size());

		for (Experience model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExperienceSoap[soapModels.size()]);
	}

	public ExperienceSoap() {
	}

	public long getPrimaryKey() {
		return _experienceId;
	}

	public void setPrimaryKey(long pk) {
		setExperienceId(pk);
	}

	public long getExperienceId() {
		return _experienceId;
	}

	public void setExperienceId(long experienceId) {
		_experienceId = experienceId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getWorkingPlace() {
		return _workingPlace;
	}

	public void setWorkingPlace(String workingPlace) {
		_workingPlace = workingPlace;
	}

	public double getYearsExperience() {
		return _yearsExperience;
	}

	public void setYearsExperience(double yearsExperience) {
		_yearsExperience = yearsExperience;
	}

	public String getTel() {
		return _tel;
	}

	public void setTel(String tel) {
		_tel = tel;
	}

	public Date getWorkingFrom() {
		return _workingFrom;
	}

	public void setWorkingFrom(Date workingFrom) {
		_workingFrom = workingFrom;
	}

	public Date getWorkingTo() {
		return _workingTo;
	}

	public void setWorkingTo(Date workingTo) {
		_workingTo = workingTo;
	}

	public String getInitialTitles() {
		return _initialTitles;
	}

	public void setInitialTitles(String initialTitles) {
		_initialTitles = initialTitles;
	}

	public String getFinalTitles() {
		return _finalTitles;
	}

	public void setFinalTitles(String finalTitles) {
		_finalTitles = finalTitles;
	}

	public double getInitialSalary() {
		return _initialSalary;
	}

	public void setInitialSalary(double initialSalary) {
		_initialSalary = initialSalary;
	}

	public double getFinalSalary() {
		return _finalSalary;
	}

	public void setFinalSalary(double finalSalary) {
		_finalSalary = finalSalary;
	}

	public String getField() {
		return _field;
	}

	public void setField(String field) {
		_field = field;
	}

	public String getManager() {
		return _manager;
	}

	public void setManager(String manager) {
		_manager = manager;
	}

	public String getResponsibility() {
		return _responsibility;
	}

	public void setResponsibility(String responsibility) {
		_responsibility = responsibility;
	}

	public String getResignedReason() {
		return _resignedReason;
	}

	public void setResignedReason(String resignedReason) {
		_resignedReason = resignedReason;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	private long _experienceId;
	private String _className;
	private long _classPK;
	private String _companyName;
	private String _workingPlace;
	private double _yearsExperience;
	private String _tel;
	private Date _workingFrom;
	private Date _workingTo;
	private String _initialTitles;
	private String _finalTitles;
	private double _initialSalary;
	private double _finalSalary;
	private String _field;
	private String _manager;
	private String _responsibility;
	private String _resignedReason;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}