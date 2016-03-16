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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.InterviewScheduleServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.InterviewScheduleServiceSoap
 * @generated
 */
public class InterviewScheduleSoap implements Serializable {
	public static InterviewScheduleSoap toSoapModel(InterviewSchedule model) {
		InterviewScheduleSoap soapModel = new InterviewScheduleSoap();

		soapModel.setInterviewScheduleId(model.getInterviewScheduleId());
		soapModel.setVacancyCandidateId(model.getVacancyCandidateId());
		soapModel.setInterviewId(model.getInterviewId());
		soapModel.setInterviewDate(model.getInterviewDate());
		soapModel.setInterviewTime(model.getInterviewTime());
		soapModel.setStatus(model.getStatus());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static InterviewScheduleSoap[] toSoapModels(
		InterviewSchedule[] models) {
		InterviewScheduleSoap[] soapModels = new InterviewScheduleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static InterviewScheduleSoap[][] toSoapModels(
		InterviewSchedule[][] models) {
		InterviewScheduleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new InterviewScheduleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new InterviewScheduleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static InterviewScheduleSoap[] toSoapModels(
		List<InterviewSchedule> models) {
		List<InterviewScheduleSoap> soapModels = new ArrayList<InterviewScheduleSoap>(models.size());

		for (InterviewSchedule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new InterviewScheduleSoap[soapModels.size()]);
	}

	public InterviewScheduleSoap() {
	}

	public long getPrimaryKey() {
		return _interviewScheduleId;
	}

	public void setPrimaryKey(long pk) {
		setInterviewScheduleId(pk);
	}

	public long getInterviewScheduleId() {
		return _interviewScheduleId;
	}

	public void setInterviewScheduleId(long interviewScheduleId) {
		_interviewScheduleId = interviewScheduleId;
	}

	public long getVacancyCandidateId() {
		return _vacancyCandidateId;
	}

	public void setVacancyCandidateId(long vacancyCandidateId) {
		_vacancyCandidateId = vacancyCandidateId;
	}

	public long getInterviewId() {
		return _interviewId;
	}

	public void setInterviewId(long interviewId) {
		_interviewId = interviewId;
	}

	public Date getInterviewDate() {
		return _interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		_interviewDate = interviewDate;
	}

	public String getInterviewTime() {
		return _interviewTime;
	}

	public void setInterviewTime(String interviewTime) {
		_interviewTime = interviewTime;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	private long _interviewScheduleId;
	private long _vacancyCandidateId;
	private long _interviewId;
	private Date _interviewDate;
	private String _interviewTime;
	private String _status;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}