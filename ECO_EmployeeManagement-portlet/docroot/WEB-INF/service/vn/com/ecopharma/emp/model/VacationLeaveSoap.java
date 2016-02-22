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

package vn.com.ecopharma.emp.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.VacationLeaveServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.VacationLeaveServiceSoap
 * @generated
 */
public class VacationLeaveSoap implements Serializable {
	public static VacationLeaveSoap toSoapModel(VacationLeave model) {
		VacationLeaveSoap soapModel = new VacationLeaveSoap();

		soapModel.setVacationLeaveId(model.getVacationLeaveId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setLeaveType(model.getLeaveType());
		soapModel.setLeaveFrom(model.getLeaveFrom());
		soapModel.setLeaveTo(model.getLeaveTo());
		soapModel.setActualTo(model.getActualTo());
		soapModel.setReason(model.getReason());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static VacationLeaveSoap[] toSoapModels(VacationLeave[] models) {
		VacationLeaveSoap[] soapModels = new VacationLeaveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacationLeaveSoap[][] toSoapModels(VacationLeave[][] models) {
		VacationLeaveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacationLeaveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacationLeaveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacationLeaveSoap[] toSoapModels(List<VacationLeave> models) {
		List<VacationLeaveSoap> soapModels = new ArrayList<VacationLeaveSoap>(models.size());

		for (VacationLeave model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacationLeaveSoap[soapModels.size()]);
	}

	public VacationLeaveSoap() {
	}

	public long getPrimaryKey() {
		return _vacationLeaveId;
	}

	public void setPrimaryKey(long pk) {
		setVacationLeaveId(pk);
	}

	public long getVacationLeaveId() {
		return _vacationLeaveId;
	}

	public void setVacationLeaveId(long vacationLeaveId) {
		_vacationLeaveId = vacationLeaveId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public String getLeaveType() {
		return _leaveType;
	}

	public void setLeaveType(String leaveType) {
		_leaveType = leaveType;
	}

	public Date getLeaveFrom() {
		return _leaveFrom;
	}

	public void setLeaveFrom(Date leaveFrom) {
		_leaveFrom = leaveFrom;
	}

	public Date getLeaveTo() {
		return _leaveTo;
	}

	public void setLeaveTo(Date leaveTo) {
		_leaveTo = leaveTo;
	}

	public Date getActualTo() {
		return _actualTo;
	}

	public void setActualTo(Date actualTo) {
		_actualTo = actualTo;
	}

	public String getReason() {
		return _reason;
	}

	public void setReason(String reason) {
		_reason = reason;
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

	private long _vacationLeaveId;
	private long _empId;
	private String _leaveType;
	private Date _leaveFrom;
	private Date _leaveTo;
	private Date _actualTo;
	private String _reason;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}