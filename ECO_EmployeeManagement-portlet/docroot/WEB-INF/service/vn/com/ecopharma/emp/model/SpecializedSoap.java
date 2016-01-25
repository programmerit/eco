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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.SpecializedServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.SpecializedServiceSoap
 * @generated
 */
public class SpecializedSoap implements Serializable {
	public static SpecializedSoap toSoapModel(Specialized model) {
		SpecializedSoap soapModel = new SpecializedSoap();

		soapModel.setSpecializedId(model.getSpecializedId());
		soapModel.setSpecializedCode(model.getSpecializedCode());
		soapModel.setName(model.getName());
		soapModel.setLevel(model.getLevel());
		soapModel.setParentId(model.getParentId());
		soapModel.setUniversity(model.getUniversity());
		soapModel.setCollege(model.getCollege());
		soapModel.setVocationalCollege(model.getVocationalCollege());
		soapModel.setVocational(model.getVocational());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SpecializedSoap[] toSoapModels(Specialized[] models) {
		SpecializedSoap[] soapModels = new SpecializedSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpecializedSoap[][] toSoapModels(Specialized[][] models) {
		SpecializedSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpecializedSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpecializedSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpecializedSoap[] toSoapModels(List<Specialized> models) {
		List<SpecializedSoap> soapModels = new ArrayList<SpecializedSoap>(models.size());

		for (Specialized model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpecializedSoap[soapModels.size()]);
	}

	public SpecializedSoap() {
	}

	public long getPrimaryKey() {
		return _specializedId;
	}

	public void setPrimaryKey(long pk) {
		setSpecializedId(pk);
	}

	public long getSpecializedId() {
		return _specializedId;
	}

	public void setSpecializedId(long specializedId) {
		_specializedId = specializedId;
	}

	public String getSpecializedCode() {
		return _specializedCode;
	}

	public void setSpecializedCode(String specializedCode) {
		_specializedCode = specializedCode;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public long getParentId() {
		return _parentId;
	}

	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	public boolean getUniversity() {
		return _university;
	}

	public boolean isUniversity() {
		return _university;
	}

	public void setUniversity(boolean university) {
		_university = university;
	}

	public boolean getCollege() {
		return _college;
	}

	public boolean isCollege() {
		return _college;
	}

	public void setCollege(boolean college) {
		_college = college;
	}

	public boolean getVocationalCollege() {
		return _vocationalCollege;
	}

	public boolean isVocationalCollege() {
		return _vocationalCollege;
	}

	public void setVocationalCollege(boolean vocationalCollege) {
		_vocationalCollege = vocationalCollege;
	}

	public boolean getVocational() {
		return _vocational;
	}

	public boolean isVocational() {
		return _vocational;
	}

	public void setVocational(boolean vocational) {
		_vocational = vocational;
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

	private long _specializedId;
	private String _specializedCode;
	private String _name;
	private int _level;
	private long _parentId;
	private boolean _university;
	private boolean _college;
	private boolean _vocationalCollege;
	private boolean _vocational;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}