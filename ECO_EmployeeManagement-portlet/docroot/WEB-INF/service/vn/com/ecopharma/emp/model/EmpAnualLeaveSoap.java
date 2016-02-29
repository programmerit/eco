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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpAnualLeaveServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpAnualLeaveServiceSoap
 * @generated
 */
public class EmpAnualLeaveSoap implements Serializable {
	public static EmpAnualLeaveSoap toSoapModel(EmpAnualLeave model) {
		EmpAnualLeaveSoap soapModel = new EmpAnualLeaveSoap();

		soapModel.setEmpAnualLeaveId(model.getEmpAnualLeaveId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setNoOfAnualLeave(model.getNoOfAnualLeave());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpAnualLeaveSoap[] toSoapModels(EmpAnualLeave[] models) {
		EmpAnualLeaveSoap[] soapModels = new EmpAnualLeaveSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpAnualLeaveSoap[][] toSoapModels(EmpAnualLeave[][] models) {
		EmpAnualLeaveSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpAnualLeaveSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpAnualLeaveSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpAnualLeaveSoap[] toSoapModels(List<EmpAnualLeave> models) {
		List<EmpAnualLeaveSoap> soapModels = new ArrayList<EmpAnualLeaveSoap>(models.size());

		for (EmpAnualLeave model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpAnualLeaveSoap[soapModels.size()]);
	}

	public EmpAnualLeaveSoap() {
	}

	public long getPrimaryKey() {
		return _empAnualLeaveId;
	}

	public void setPrimaryKey(long pk) {
		setEmpAnualLeaveId(pk);
	}

	public long getEmpAnualLeaveId() {
		return _empAnualLeaveId;
	}

	public void setEmpAnualLeaveId(long empAnualLeaveId) {
		_empAnualLeaveId = empAnualLeaveId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public double getNoOfAnualLeave() {
		return _noOfAnualLeave;
	}

	public void setNoOfAnualLeave(double noOfAnualLeave) {
		_noOfAnualLeave = noOfAnualLeave;
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

	private long _empAnualLeaveId;
	private long _empId;
	private double _noOfAnualLeave;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}