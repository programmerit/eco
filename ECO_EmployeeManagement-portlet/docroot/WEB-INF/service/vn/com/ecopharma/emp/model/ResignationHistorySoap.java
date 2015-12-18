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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.ResignationHistoryServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.ResignationHistoryServiceSoap
 * @generated
 */
public class ResignationHistorySoap implements Serializable {
	public static ResignationHistorySoap toSoapModel(ResignationHistory model) {
		ResignationHistorySoap soapModel = new ResignationHistorySoap();

		soapModel.setResignationHistoryId(model.getResignationHistoryId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setResignedDate(model.getResignedDate());
		soapModel.setResignedType(model.getResignedType());
		soapModel.setComment(model.getComment());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static ResignationHistorySoap[] toSoapModels(
		ResignationHistory[] models) {
		ResignationHistorySoap[] soapModels = new ResignationHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResignationHistorySoap[][] toSoapModels(
		ResignationHistory[][] models) {
		ResignationHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResignationHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResignationHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResignationHistorySoap[] toSoapModels(
		List<ResignationHistory> models) {
		List<ResignationHistorySoap> soapModels = new ArrayList<ResignationHistorySoap>(models.size());

		for (ResignationHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResignationHistorySoap[soapModels.size()]);
	}

	public ResignationHistorySoap() {
	}

	public long getPrimaryKey() {
		return _resignationHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setResignationHistoryId(pk);
	}

	public long getResignationHistoryId() {
		return _resignationHistoryId;
	}

	public void setResignationHistoryId(long resignationHistoryId) {
		_resignationHistoryId = resignationHistoryId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public Date getResignedDate() {
		return _resignedDate;
	}

	public void setResignedDate(Date resignedDate) {
		_resignedDate = resignedDate;
	}

	public String getResignedType() {
		return _resignedType;
	}

	public void setResignedType(String resignedType) {
		_resignedType = resignedType;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
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

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private long _resignationHistoryId;
	private long _employeeId;
	private Date _resignedDate;
	private String _resignedType;
	private String _comment;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
}