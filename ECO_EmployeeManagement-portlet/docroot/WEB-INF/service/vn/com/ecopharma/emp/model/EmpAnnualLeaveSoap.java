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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpAnnualLeaveServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpAnnualLeaveServiceSoap
 * @generated
 */
public class EmpAnnualLeaveSoap implements Serializable {
	public static EmpAnnualLeaveSoap toSoapModel(EmpAnnualLeave model) {
		EmpAnnualLeaveSoap soapModel = new EmpAnnualLeaveSoap();

		soapModel.setEmpAnnualLeaveId(model.getEmpAnnualLeaveId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setTotalAnualLeaveLeft(model.getTotalAnualLeaveLeft());
		soapModel.setTotalAnnualLeave(model.getTotalAnnualLeave());
		soapModel.setTotalPreviousYearLeavesLeft(model.getTotalPreviousYearLeavesLeft());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpAnnualLeaveSoap[] toSoapModels(EmpAnnualLeave[] models) {
		EmpAnnualLeaveSoap[] soapModels = new EmpAnnualLeaveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpAnnualLeaveSoap[][] toSoapModels(EmpAnnualLeave[][] models) {
		EmpAnnualLeaveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpAnnualLeaveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpAnnualLeaveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpAnnualLeaveSoap[] toSoapModels(List<EmpAnnualLeave> models) {
		List<EmpAnnualLeaveSoap> soapModels = new ArrayList<EmpAnnualLeaveSoap>(models.size());

		for (EmpAnnualLeave model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpAnnualLeaveSoap[soapModels.size()]);
	}

	public EmpAnnualLeaveSoap() {
	}

	public long getPrimaryKey() {
		return _empAnnualLeaveId;
	}

	public void setPrimaryKey(long pk) {
		setEmpAnnualLeaveId(pk);
	}

	public long getEmpAnnualLeaveId() {
		return _empAnnualLeaveId;
	}

	public void setEmpAnnualLeaveId(long empAnnualLeaveId) {
		_empAnnualLeaveId = empAnnualLeaveId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public double getTotalAnualLeaveLeft() {
		return _totalAnualLeaveLeft;
	}

	public void setTotalAnualLeaveLeft(double totalAnualLeaveLeft) {
		_totalAnualLeaveLeft = totalAnualLeaveLeft;
	}

	public double getTotalAnnualLeave() {
		return _totalAnnualLeave;
	}

	public void setTotalAnnualLeave(double totalAnnualLeave) {
		_totalAnnualLeave = totalAnnualLeave;
	}

	public double getTotalPreviousYearLeavesLeft() {
		return _totalPreviousYearLeavesLeft;
	}

	public void setTotalPreviousYearLeavesLeft(
		double totalPreviousYearLeavesLeft) {
		_totalPreviousYearLeavesLeft = totalPreviousYearLeavesLeft;
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

	private long _empAnnualLeaveId;
	private long _empId;
	private double _totalAnualLeaveLeft;
	private double _totalAnnualLeave;
	private double _totalPreviousYearLeavesLeft;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}