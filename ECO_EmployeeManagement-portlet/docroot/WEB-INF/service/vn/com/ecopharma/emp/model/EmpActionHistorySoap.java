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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpActionHistoryServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpActionHistoryServiceSoap
 * @generated
 */
public class EmpActionHistorySoap implements Serializable {
	public static EmpActionHistorySoap toSoapModel(EmpActionHistory model) {
		EmpActionHistorySoap soapModel = new EmpActionHistorySoap();

		soapModel.setEmpActionHistoryId(model.getEmpActionHistoryId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setAction(model.getAction());
		soapModel.setPerformedBy(model.getPerformedBy());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setRefId(model.getRefId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpActionHistorySoap[] toSoapModels(EmpActionHistory[] models) {
		EmpActionHistorySoap[] soapModels = new EmpActionHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpActionHistorySoap[][] toSoapModels(
		EmpActionHistory[][] models) {
		EmpActionHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpActionHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpActionHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpActionHistorySoap[] toSoapModels(
		List<EmpActionHistory> models) {
		List<EmpActionHistorySoap> soapModels = new ArrayList<EmpActionHistorySoap>(models.size());

		for (EmpActionHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpActionHistorySoap[soapModels.size()]);
	}

	public EmpActionHistorySoap() {
	}

	public long getPrimaryKey() {
		return _empActionHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setEmpActionHistoryId(pk);
	}

	public long getEmpActionHistoryId() {
		return _empActionHistoryId;
	}

	public void setEmpActionHistoryId(long empActionHistoryId) {
		_empActionHistoryId = empActionHistoryId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public long getPerformedBy() {
		return _performedBy;
	}

	public void setPerformedBy(long performedBy) {
		_performedBy = performedBy;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getRefId() {
		return _refId;
	}

	public void setRefId(long refId) {
		_refId = refId;
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

	private long _empActionHistoryId;
	private long _empId;
	private String _action;
	private long _performedBy;
	private String _description;
	private String _status;
	private long _refId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}