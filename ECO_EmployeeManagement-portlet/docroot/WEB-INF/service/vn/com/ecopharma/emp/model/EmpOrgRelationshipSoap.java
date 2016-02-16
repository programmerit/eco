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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpOrgRelationshipServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpOrgRelationshipServiceSoap
 * @generated
 */
public class EmpOrgRelationshipSoap implements Serializable {
	public static EmpOrgRelationshipSoap toSoapModel(EmpOrgRelationship model) {
		EmpOrgRelationshipSoap soapModel = new EmpOrgRelationshipSoap();

		soapModel.setEmpOrgRelationshipId(model.getEmpOrgRelationshipId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setOrgClassName(model.getOrgClassName());
		soapModel.setOrgClassPK(model.getOrgClassPK());
		soapModel.setHeadOfOrg(model.getHeadOfOrg());
		soapModel.setDeputyOfOrg(model.getDeputyOfOrg());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpOrgRelationshipSoap[] toSoapModels(
		EmpOrgRelationship[] models) {
		EmpOrgRelationshipSoap[] soapModels = new EmpOrgRelationshipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpOrgRelationshipSoap[][] toSoapModels(
		EmpOrgRelationship[][] models) {
		EmpOrgRelationshipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpOrgRelationshipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpOrgRelationshipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpOrgRelationshipSoap[] toSoapModels(
		List<EmpOrgRelationship> models) {
		List<EmpOrgRelationshipSoap> soapModels = new ArrayList<EmpOrgRelationshipSoap>(models.size());

		for (EmpOrgRelationship model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpOrgRelationshipSoap[soapModels.size()]);
	}

	public EmpOrgRelationshipSoap() {
	}

	public long getPrimaryKey() {
		return _empOrgRelationshipId;
	}

	public void setPrimaryKey(long pk) {
		setEmpOrgRelationshipId(pk);
	}

	public long getEmpOrgRelationshipId() {
		return _empOrgRelationshipId;
	}

	public void setEmpOrgRelationshipId(long empOrgRelationshipId) {
		_empOrgRelationshipId = empOrgRelationshipId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public String getOrgClassName() {
		return _orgClassName;
	}

	public void setOrgClassName(String orgClassName) {
		_orgClassName = orgClassName;
	}

	public long getOrgClassPK() {
		return _orgClassPK;
	}

	public void setOrgClassPK(long orgClassPK) {
		_orgClassPK = orgClassPK;
	}

	public boolean getHeadOfOrg() {
		return _headOfOrg;
	}

	public boolean isHeadOfOrg() {
		return _headOfOrg;
	}

	public void setHeadOfOrg(boolean headOfOrg) {
		_headOfOrg = headOfOrg;
	}

	public boolean getDeputyOfOrg() {
		return _deputyOfOrg;
	}

	public boolean isDeputyOfOrg() {
		return _deputyOfOrg;
	}

	public void setDeputyOfOrg(boolean deputyOfOrg) {
		_deputyOfOrg = deputyOfOrg;
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

	private long _empOrgRelationshipId;
	private long _empId;
	private String _orgClassName;
	private long _orgClassPK;
	private boolean _headOfOrg;
	private boolean _deputyOfOrg;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}