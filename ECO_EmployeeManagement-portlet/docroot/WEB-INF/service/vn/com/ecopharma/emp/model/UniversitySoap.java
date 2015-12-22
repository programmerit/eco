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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.UniversityServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.UniversityServiceSoap
 * @generated
 */
public class UniversitySoap implements Serializable {
	public static UniversitySoap toSoapModel(University model) {
		UniversitySoap soapModel = new UniversitySoap();

		soapModel.setUniversityId(model.getUniversityId());
		soapModel.setName(model.getName());
		soapModel.setCode(model.getCode());
		soapModel.setTel_fax(model.getTel_fax());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static UniversitySoap[] toSoapModels(University[] models) {
		UniversitySoap[] soapModels = new UniversitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UniversitySoap[][] toSoapModels(University[][] models) {
		UniversitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UniversitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new UniversitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UniversitySoap[] toSoapModels(List<University> models) {
		List<UniversitySoap> soapModels = new ArrayList<UniversitySoap>(models.size());

		for (University model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UniversitySoap[soapModels.size()]);
	}

	public UniversitySoap() {
	}

	public long getPrimaryKey() {
		return _universityId;
	}

	public void setPrimaryKey(long pk) {
		setUniversityId(pk);
	}

	public long getUniversityId() {
		return _universityId;
	}

	public void setUniversityId(long universityId) {
		_universityId = universityId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getTel_fax() {
		return _tel_fax;
	}

	public void setTel_fax(String tel_fax) {
		_tel_fax = tel_fax;
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

	private long _universityId;
	private String _name;
	private String _code;
	private String _tel_fax;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}