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

package vn.com.ecopharma.hrm.tt.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.tt.service.http.TimeTrackingServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.tt.service.http.TimeTrackingServiceSoap
 * @generated
 */
public class TimeTrackingSoap implements Serializable {
	public static TimeTrackingSoap toSoapModel(TimeTracking model) {
		TimeTrackingSoap soapModel = new TimeTrackingSoap();

		soapModel.setTimeTrackingId(model.getTimeTrackingId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setDate(model.getDate());
		soapModel.setIn1(model.getIn1());
		soapModel.setOut1(model.getOut1());
		soapModel.setIn2(model.getIn2());
		soapModel.setOut2(model.getOut2());
		soapModel.setIn3(model.getIn3());
		soapModel.setOut3(model.getOut3());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLeaveRefId(model.getLeaveRefId());

		return soapModel;
	}

	public static TimeTrackingSoap[] toSoapModels(TimeTracking[] models) {
		TimeTrackingSoap[] soapModels = new TimeTrackingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TimeTrackingSoap[][] toSoapModels(TimeTracking[][] models) {
		TimeTrackingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TimeTrackingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TimeTrackingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TimeTrackingSoap[] toSoapModels(List<TimeTracking> models) {
		List<TimeTrackingSoap> soapModels = new ArrayList<TimeTrackingSoap>(models.size());

		for (TimeTracking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TimeTrackingSoap[soapModels.size()]);
	}

	public TimeTrackingSoap() {
	}

	public long getPrimaryKey() {
		return _timeTrackingId;
	}

	public void setPrimaryKey(long pk) {
		setTimeTrackingId(pk);
	}

	public long getTimeTrackingId() {
		return _timeTrackingId;
	}

	public void setTimeTrackingId(long timeTrackingId) {
		_timeTrackingId = timeTrackingId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public Date getIn1() {
		return _in1;
	}

	public void setIn1(Date in1) {
		_in1 = in1;
	}

	public Date getOut1() {
		return _out1;
	}

	public void setOut1(Date out1) {
		_out1 = out1;
	}

	public Date getIn2() {
		return _in2;
	}

	public void setIn2(Date in2) {
		_in2 = in2;
	}

	public Date getOut2() {
		return _out2;
	}

	public void setOut2(Date out2) {
		_out2 = out2;
	}

	public Date getIn3() {
		return _in3;
	}

	public void setIn3(Date in3) {
		_in3 = in3;
	}

	public Date getOut3() {
		return _out3;
	}

	public void setOut3(Date out3) {
		_out3 = out3;
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

	public long getLeaveRefId() {
		return _leaveRefId;
	}

	public void setLeaveRefId(long leaveRefId) {
		_leaveRefId = leaveRefId;
	}

	private long _timeTrackingId;
	private long _empId;
	private Date _date;
	private Date _in1;
	private Date _out1;
	private Date _in2;
	private Date _out2;
	private Date _in3;
	private Date _out3;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _leaveRefId;
}