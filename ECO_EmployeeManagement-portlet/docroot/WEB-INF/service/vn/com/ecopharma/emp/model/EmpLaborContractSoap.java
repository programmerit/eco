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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpLaborContractServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpLaborContractServiceSoap
 * @generated
 */
public class EmpLaborContractSoap implements Serializable {
	public static EmpLaborContractSoap toSoapModel(EmpLaborContract model) {
		EmpLaborContractSoap soapModel = new EmpLaborContractSoap();

		soapModel.setEmpLaborContractId(model.getEmpLaborContractId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setLaborContractSignedDate(model.getLaborContractSignedDate());
		soapModel.setLaborContractExpiredDate(model.getLaborContractExpiredDate());
		soapModel.setLaborContractSignedType(model.getLaborContractSignedType());
		soapModel.setSignedTimes(model.getSignedTimes());
		soapModel.setLatest(model.getLatest());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpLaborContractSoap[] toSoapModels(EmpLaborContract[] models) {
		EmpLaborContractSoap[] soapModels = new EmpLaborContractSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpLaborContractSoap[][] toSoapModels(
		EmpLaborContract[][] models) {
		EmpLaborContractSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpLaborContractSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpLaborContractSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpLaborContractSoap[] toSoapModels(
		List<EmpLaborContract> models) {
		List<EmpLaborContractSoap> soapModels = new ArrayList<EmpLaborContractSoap>(models.size());

		for (EmpLaborContract model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpLaborContractSoap[soapModels.size()]);
	}

	public EmpLaborContractSoap() {
	}

	public long getPrimaryKey() {
		return _empLaborContractId;
	}

	public void setPrimaryKey(long pk) {
		setEmpLaborContractId(pk);
	}

	public long getEmpLaborContractId() {
		return _empLaborContractId;
	}

	public void setEmpLaborContractId(long empLaborContractId) {
		_empLaborContractId = empLaborContractId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public Date getLaborContractSignedDate() {
		return _laborContractSignedDate;
	}

	public void setLaborContractSignedDate(Date laborContractSignedDate) {
		_laborContractSignedDate = laborContractSignedDate;
	}

	public Date getLaborContractExpiredDate() {
		return _laborContractExpiredDate;
	}

	public void setLaborContractExpiredDate(Date laborContractExpiredDate) {
		_laborContractExpiredDate = laborContractExpiredDate;
	}

	public String getLaborContractSignedType() {
		return _laborContractSignedType;
	}

	public void setLaborContractSignedType(String laborContractSignedType) {
		_laborContractSignedType = laborContractSignedType;
	}

	public int getSignedTimes() {
		return _signedTimes;
	}

	public void setSignedTimes(int signedTimes) {
		_signedTimes = signedTimes;
	}

	public boolean getLatest() {
		return _latest;
	}

	public boolean isLatest() {
		return _latest;
	}

	public void setLatest(boolean latest) {
		_latest = latest;
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

	private long _empLaborContractId;
	private long _empId;
	private Date _laborContractSignedDate;
	private Date _laborContractExpiredDate;
	private String _laborContractSignedType;
	private int _signedTimes;
	private boolean _latest;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}