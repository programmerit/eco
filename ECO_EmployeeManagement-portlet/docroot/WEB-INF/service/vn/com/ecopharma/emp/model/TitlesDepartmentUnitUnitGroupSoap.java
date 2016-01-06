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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.TitlesDepartmentUnitUnitGroupServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.TitlesDepartmentUnitUnitGroupServiceSoap
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupSoap implements Serializable {
	public static TitlesDepartmentUnitUnitGroupSoap toSoapModel(
		TitlesDepartmentUnitUnitGroup model) {
		TitlesDepartmentUnitUnitGroupSoap soapModel = new TitlesDepartmentUnitUnitGroupSoap();

		soapModel.setTitlesDepartmentUnitUnitGroupId(model.getTitlesDepartmentUnitUnitGroupId());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setUnitId(model.getUnitId());
		soapModel.setUnitGroupId(model.getUnitGroupId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static TitlesDepartmentUnitUnitGroupSoap[] toSoapModels(
		TitlesDepartmentUnitUnitGroup[] models) {
		TitlesDepartmentUnitUnitGroupSoap[] soapModels = new TitlesDepartmentUnitUnitGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TitlesDepartmentUnitUnitGroupSoap[][] toSoapModels(
		TitlesDepartmentUnitUnitGroup[][] models) {
		TitlesDepartmentUnitUnitGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TitlesDepartmentUnitUnitGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TitlesDepartmentUnitUnitGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TitlesDepartmentUnitUnitGroupSoap[] toSoapModels(
		List<TitlesDepartmentUnitUnitGroup> models) {
		List<TitlesDepartmentUnitUnitGroupSoap> soapModels = new ArrayList<TitlesDepartmentUnitUnitGroupSoap>(models.size());

		for (TitlesDepartmentUnitUnitGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TitlesDepartmentUnitUnitGroupSoap[soapModels.size()]);
	}

	public TitlesDepartmentUnitUnitGroupSoap() {
	}

	public long getPrimaryKey() {
		return _titlesDepartmentUnitUnitGroupId;
	}

	public void setPrimaryKey(long pk) {
		setTitlesDepartmentUnitUnitGroupId(pk);
	}

	public long getTitlesDepartmentUnitUnitGroupId() {
		return _titlesDepartmentUnitUnitGroupId;
	}

	public void setTitlesDepartmentUnitUnitGroupId(
		long titlesDepartmentUnitUnitGroupId) {
		_titlesDepartmentUnitUnitGroupId = titlesDepartmentUnitUnitGroupId;
	}

	public long getTitlesId() {
		return _titlesId;
	}

	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getUnitId() {
		return _unitId;
	}

	public void setUnitId(long unitId) {
		_unitId = unitId;
	}

	public long getUnitGroupId() {
		return _unitGroupId;
	}

	public void setUnitGroupId(long unitGroupId) {
		_unitGroupId = unitGroupId;
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

	private long _titlesDepartmentUnitUnitGroupId;
	private long _titlesId;
	private long _departmentId;
	private long _unitId;
	private long _unitGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}