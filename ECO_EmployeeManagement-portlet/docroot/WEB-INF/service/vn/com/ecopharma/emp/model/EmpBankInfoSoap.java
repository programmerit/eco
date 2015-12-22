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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpBankInfoServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpBankInfoServiceSoap
 * @generated
 */
public class EmpBankInfoSoap implements Serializable {
	public static EmpBankInfoSoap toSoapModel(EmpBankInfo model) {
		EmpBankInfoSoap soapModel = new EmpBankInfoSoap();

		soapModel.setEmpBankInfoId(model.getEmpBankInfoId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setBankAccountNo(model.getBankAccountNo());
		soapModel.setBankName(model.getBankName());
		soapModel.setBranchName(model.getBranchName());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EmpBankInfoSoap[] toSoapModels(EmpBankInfo[] models) {
		EmpBankInfoSoap[] soapModels = new EmpBankInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpBankInfoSoap[][] toSoapModels(EmpBankInfo[][] models) {
		EmpBankInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpBankInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpBankInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpBankInfoSoap[] toSoapModels(List<EmpBankInfo> models) {
		List<EmpBankInfoSoap> soapModels = new ArrayList<EmpBankInfoSoap>(models.size());

		for (EmpBankInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpBankInfoSoap[soapModels.size()]);
	}

	public EmpBankInfoSoap() {
	}

	public long getPrimaryKey() {
		return _empBankInfoId;
	}

	public void setPrimaryKey(long pk) {
		setEmpBankInfoId(pk);
	}

	public long getEmpBankInfoId() {
		return _empBankInfoId;
	}

	public void setEmpBankInfoId(long empBankInfoId) {
		_empBankInfoId = empBankInfoId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public String getBankAccountNo() {
		return _bankAccountNo;
	}

	public void setBankAccountNo(String bankAccountNo) {
		_bankAccountNo = bankAccountNo;
	}

	public String getBankName() {
		return _bankName;
	}

	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	public String getBranchName() {
		return _branchName;
	}

	public void setBranchName(String branchName) {
		_branchName = branchName;
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

	private long _empBankInfoId;
	private long _empId;
	private String _bankAccountNo;
	private String _bankName;
	private String _branchName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}