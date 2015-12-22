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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmployeeTitlesHistoryServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmployeeTitlesHistoryServiceSoap
 * @generated
 */
public class EmployeeTitlesHistorySoap implements Serializable {
	public static EmployeeTitlesHistorySoap toSoapModel(
		EmployeeTitlesHistory model) {
		EmployeeTitlesHistorySoap soapModel = new EmployeeTitlesHistorySoap();

		soapModel.setEmployeeTitlesHistoryId(model.getEmployeeTitlesHistoryId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setSetDate(model.getSetDate());
		soapModel.setNote(model.getNote());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmployeeTitlesHistorySoap[] toSoapModels(
		EmployeeTitlesHistory[] models) {
		EmployeeTitlesHistorySoap[] soapModels = new EmployeeTitlesHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTitlesHistorySoap[][] toSoapModels(
		EmployeeTitlesHistory[][] models) {
		EmployeeTitlesHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployeeTitlesHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployeeTitlesHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployeeTitlesHistorySoap[] toSoapModels(
		List<EmployeeTitlesHistory> models) {
		List<EmployeeTitlesHistorySoap> soapModels = new ArrayList<EmployeeTitlesHistorySoap>(models.size());

		for (EmployeeTitlesHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployeeTitlesHistorySoap[soapModels.size()]);
	}

	public EmployeeTitlesHistorySoap() {
	}

	public long getPrimaryKey() {
		return _employeeTitlesHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setEmployeeTitlesHistoryId(pk);
	}

	public long getEmployeeTitlesHistoryId() {
		return _employeeTitlesHistoryId;
	}

	public void setEmployeeTitlesHistoryId(long employeeTitlesHistoryId) {
		_employeeTitlesHistoryId = employeeTitlesHistoryId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getTitlesId() {
		return _titlesId;
	}

	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
	}

	public Date getSetDate() {
		return _setDate;
	}

	public void setSetDate(Date setDate) {
		_setDate = setDate;
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

	private long _employeeTitlesHistoryId;
	private long _employeeId;
	private long _titlesId;
	private Date _setDate;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}