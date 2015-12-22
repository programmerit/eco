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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.ResourceConfigServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.ResourceConfigServiceSoap
 * @generated
 */
public class ResourceConfigSoap implements Serializable {
	public static ResourceConfigSoap toSoapModel(ResourceConfig model) {
		ResourceConfigSoap soapModel = new ResourceConfigSoap();

		soapModel.setResourceConfigId(model.getResourceConfigId());
		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());
		soapModel.setType(model.getType());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ResourceConfigSoap[] toSoapModels(ResourceConfig[] models) {
		ResourceConfigSoap[] soapModels = new ResourceConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResourceConfigSoap[][] toSoapModels(ResourceConfig[][] models) {
		ResourceConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ResourceConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResourceConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResourceConfigSoap[] toSoapModels(List<ResourceConfig> models) {
		List<ResourceConfigSoap> soapModels = new ArrayList<ResourceConfigSoap>(models.size());

		for (ResourceConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResourceConfigSoap[soapModels.size()]);
	}

	public ResourceConfigSoap() {
	}

	public long getPrimaryKey() {
		return _resourceConfigId;
	}

	public void setPrimaryKey(long pk) {
		setResourceConfigId(pk);
	}

	public long getResourceConfigId() {
		return _resourceConfigId;
	}

	public void setResourceConfigId(long resourceConfigId) {
		_resourceConfigId = resourceConfigId;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
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

	private long _resourceConfigId;
	private String _key;
	private String _value;
	private String _type;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}