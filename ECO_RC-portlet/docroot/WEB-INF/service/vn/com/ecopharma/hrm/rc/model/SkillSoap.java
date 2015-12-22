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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.SkillServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.SkillServiceSoap
 * @generated
 */
public class SkillSoap implements Serializable {
	public static SkillSoap toSoapModel(Skill model) {
		SkillSoap soapModel = new SkillSoap();

		soapModel.setSkillId(model.getSkillId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setGrade(model.getGrade());
		soapModel.setType(model.getType());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SkillSoap[] toSoapModels(Skill[] models) {
		SkillSoap[] soapModels = new SkillSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SkillSoap[][] toSoapModels(Skill[][] models) {
		SkillSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SkillSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SkillSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SkillSoap[] toSoapModels(List<Skill> models) {
		List<SkillSoap> soapModels = new ArrayList<SkillSoap>(models.size());

		for (Skill model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SkillSoap[soapModels.size()]);
	}

	public SkillSoap() {
	}

	public long getPrimaryKey() {
		return _skillId;
	}

	public void setPrimaryKey(long pk) {
		setSkillId(pk);
	}

	public long getSkillId() {
		return _skillId;
	}

	public void setSkillId(long skillId) {
		_skillId = skillId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
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

	private long _skillId;
	private long _candidateId;
	private String _grade;
	private String _type;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}