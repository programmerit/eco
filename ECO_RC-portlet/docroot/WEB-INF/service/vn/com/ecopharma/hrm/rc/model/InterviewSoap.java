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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.InterviewServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.InterviewServiceSoap
 * @generated
 */
public class InterviewSoap implements Serializable {
	public static InterviewSoap toSoapModel(Interview model) {
		InterviewSoap soapModel = new InterviewSoap();

		soapModel.setInterviewId(model.getInterviewId());
		soapModel.setName(model.getName());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static InterviewSoap[] toSoapModels(Interview[] models) {
		InterviewSoap[] soapModels = new InterviewSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterviewSoap[][] toSoapModels(Interview[][] models) {
		InterviewSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterviewSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterviewSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterviewSoap[] toSoapModels(List<Interview> models) {
		List<InterviewSoap> soapModels = new ArrayList<InterviewSoap>(models.size());

		for (Interview model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterviewSoap[soapModels.size()]);
	}

	public InterviewSoap() {
	}

	public long getPrimaryKey() {
		return _interviewId;
	}

	public void setPrimaryKey(long pk) {
		setInterviewId(pk);
	}

	public long getInterviewId() {
		return _interviewId;
	}

	public void setInterviewId(long interviewId) {
		_interviewId = interviewId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getTitlesId() {
		return _titlesId;
	}

	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
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

	private long _interviewId;
	private String _name;
	private long _titlesId;
	private boolean _deleted;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}