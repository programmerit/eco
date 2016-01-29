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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpDisciplineServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpDisciplineServiceSoap
 * @generated
 */
public class EmpDisciplineSoap implements Serializable {
	public static EmpDisciplineSoap toSoapModel(EmpDiscipline model) {
		EmpDisciplineSoap soapModel = new EmpDisciplineSoap();

		soapModel.setEmpDisciplineId(model.getEmpDisciplineId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setContent(model.getContent());
		soapModel.setDisciplineType(model.getDisciplineType());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setAdditionalDisciplineType(model.getAdditionalDisciplineType());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static EmpDisciplineSoap[] toSoapModels(EmpDiscipline[] models) {
		EmpDisciplineSoap[] soapModels = new EmpDisciplineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpDisciplineSoap[][] toSoapModels(EmpDiscipline[][] models) {
		EmpDisciplineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpDisciplineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpDisciplineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpDisciplineSoap[] toSoapModels(List<EmpDiscipline> models) {
		List<EmpDisciplineSoap> soapModels = new ArrayList<EmpDisciplineSoap>(models.size());

		for (EmpDiscipline model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpDisciplineSoap[soapModels.size()]);
	}

	public EmpDisciplineSoap() {
	}

	public long getPrimaryKey() {
		return _empDisciplineId;
	}

	public void setPrimaryKey(long pk) {
		setEmpDisciplineId(pk);
	}

	public long getEmpDisciplineId() {
		return _empDisciplineId;
	}

	public void setEmpDisciplineId(long empDisciplineId) {
		_empDisciplineId = empDisciplineId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getDisciplineType() {
		return _disciplineType;
	}

	public void setDisciplineType(String disciplineType) {
		_disciplineType = disciplineType;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public String getAdditionalDisciplineType() {
		return _additionalDisciplineType;
	}

	public void setAdditionalDisciplineType(String additionalDisciplineType) {
		_additionalDisciplineType = additionalDisciplineType;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private long _empDisciplineId;
	private long _empId;
	private String _content;
	private String _disciplineType;
	private Date _effectiveDate;
	private String _additionalDisciplineType;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
}