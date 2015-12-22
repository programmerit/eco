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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.DevisionGroupServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.DevisionGroupServiceSoap
 * @generated
 */
public class DevisionGroupSoap implements Serializable {
	public static DevisionGroupSoap toSoapModel(DevisionGroup model) {
		DevisionGroupSoap soapModel = new DevisionGroupSoap();

		soapModel.setDevisionGroupId(model.getDevisionGroupId());
		soapModel.setName(model.getName());
		soapModel.setDevisionId(model.getDevisionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static DevisionGroupSoap[] toSoapModels(DevisionGroup[] models) {
		DevisionGroupSoap[] soapModels = new DevisionGroupSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DevisionGroupSoap[][] toSoapModels(DevisionGroup[][] models) {
		DevisionGroupSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DevisionGroupSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DevisionGroupSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DevisionGroupSoap[] toSoapModels(List<DevisionGroup> models) {
		List<DevisionGroupSoap> soapModels = new ArrayList<DevisionGroupSoap>(models.size());

		for (DevisionGroup model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DevisionGroupSoap[soapModels.size()]);
	}

	public DevisionGroupSoap() {
	}

	public long getPrimaryKey() {
		return _devisionGroupId;
	}

	public void setPrimaryKey(long pk) {
		setDevisionGroupId(pk);
	}

	public long getDevisionGroupId() {
		return _devisionGroupId;
	}

	public void setDevisionGroupId(long devisionGroupId) {
		_devisionGroupId = devisionGroupId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getDevisionId() {
		return _devisionId;
	}

	public void setDevisionId(long devisionId) {
		_devisionId = devisionId;
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

	private long _devisionGroupId;
	private String _name;
	private long _devisionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}