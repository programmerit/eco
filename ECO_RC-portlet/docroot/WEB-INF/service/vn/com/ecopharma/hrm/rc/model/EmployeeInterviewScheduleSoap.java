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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.EmployeeInterviewScheduleServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.EmployeeInterviewScheduleServiceSoap
 * @generated
 */
public class EmployeeInterviewScheduleSoap implements Serializable {
	public static EmployeeInterviewScheduleSoap toSoapModel(
		EmployeeInterviewSchedule model) {
		EmployeeInterviewScheduleSoap soapModel = new EmployeeInterviewScheduleSoap();

		soapModel.setEmployeeInterviewScheduleId(model.getEmployeeInterviewScheduleId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setInterviewScheduleId(model.getInterviewScheduleId());
		soapModel.setNote(model.getNote());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmployeeInterviewScheduleSoap[] toSoapModels(
		EmployeeInterviewSchedule[] models) {
		EmployeeInterviewScheduleSoap[] soapModels = new EmployeeInterviewScheduleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeInterviewScheduleSoap[][] toSoapModels(
		EmployeeInterviewSchedule[][] models) {
		EmployeeInterviewScheduleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeInterviewScheduleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeInterviewScheduleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeInterviewScheduleSoap[] toSoapModels(
		List<EmployeeInterviewSchedule> models) {
		List<EmployeeInterviewScheduleSoap> soapModels = new ArrayList<EmployeeInterviewScheduleSoap>(models.size());

		for (EmployeeInterviewSchedule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeInterviewScheduleSoap[soapModels.size()]);
	}

	public EmployeeInterviewScheduleSoap() {
	}

	public long getPrimaryKey() {
		return _employeeInterviewScheduleId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeInterviewScheduleId(pk);
	}

	public long getEmployeeInterviewScheduleId() {
		return _employeeInterviewScheduleId;
	}

	public void setEmployeeInterviewScheduleId(long employeeInterviewScheduleId) {
		_employeeInterviewScheduleId = employeeInterviewScheduleId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getInterviewScheduleId() {
		return _interviewScheduleId;
	}

	public void setInterviewScheduleId(long interviewScheduleId) {
		_interviewScheduleId = interviewScheduleId;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
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

	private long _employeeInterviewScheduleId;
	private long _employeeId;
	private long _interviewScheduleId;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}