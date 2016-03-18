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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpConcurrentTitlesServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpConcurrentTitlesServiceSoap
 * @generated
 */
public class EmpConcurrentTitlesSoap implements Serializable {
	public static EmpConcurrentTitlesSoap toSoapModel(EmpConcurrentTitles model) {
		EmpConcurrentTitlesSoap soapModel = new EmpConcurrentTitlesSoap();

		soapModel.setEmpConcurrentTitlesId(model.getEmpConcurrentTitlesId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setUnitGroupId(model.getUnitGroupId());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpConcurrentTitlesSoap[] toSoapModels(
		EmpConcurrentTitles[] models) {
		EmpConcurrentTitlesSoap[] soapModels = new EmpConcurrentTitlesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpConcurrentTitlesSoap[][] toSoapModels(
		EmpConcurrentTitles[][] models) {
		EmpConcurrentTitlesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpConcurrentTitlesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpConcurrentTitlesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpConcurrentTitlesSoap[] toSoapModels(
		List<EmpConcurrentTitles> models) {
		List<EmpConcurrentTitlesSoap> soapModels = new ArrayList<EmpConcurrentTitlesSoap>(models.size());

		for (EmpConcurrentTitles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpConcurrentTitlesSoap[soapModels.size()]);
	}

	public EmpConcurrentTitlesSoap() {
	}

	public long getPrimaryKey() {
		return _empConcurrentTitlesId;
	}

	public void setPrimaryKey(long pk) {
		setEmpConcurrentTitlesId(pk);
	}

	public long getEmpConcurrentTitlesId() {
		return _empConcurrentTitlesId;
	}

	public void setEmpConcurrentTitlesId(long empConcurrentTitlesId) {
		_empConcurrentTitlesId = empConcurrentTitlesId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public long getTitlesId() {
		return _titlesId;
	}

	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
	}

	public long getUnitGroupId() {
		return _unitGroupId;
	}

	public void setUnitGroupId(long unitGroupId) {
		_unitGroupId = unitGroupId;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
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

	private long _empConcurrentTitlesId;
	private long _empId;
	private long _titlesId;
	private long _unitGroupId;
	private long _unitId;
	private long _departmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}