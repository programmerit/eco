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

package vn.com.ecopharma.hrm.rc.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.EvaluationCriteriaKeyValueServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.EvaluationCriteriaKeyValueServiceSoap
 * @generated
 */
public class EvaluationCriteriaKeyValueSoap implements Serializable {
	public static EvaluationCriteriaKeyValueSoap toSoapModel(
		EvaluationCriteriaKeyValue model) {
		EvaluationCriteriaKeyValueSoap soapModel = new EvaluationCriteriaKeyValueSoap();

		soapModel.setEvaluationCriteriaKeyValueId(model.getEvaluationCriteriaKeyValueId());
		soapModel.setEvaluationCriteriaId(model.getEvaluationCriteriaId());
		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EvaluationCriteriaKeyValueSoap[] toSoapModels(
		EvaluationCriteriaKeyValue[] models) {
		EvaluationCriteriaKeyValueSoap[] soapModels = new EvaluationCriteriaKeyValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EvaluationCriteriaKeyValueSoap[][] toSoapModels(
		EvaluationCriteriaKeyValue[][] models) {
		EvaluationCriteriaKeyValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EvaluationCriteriaKeyValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EvaluationCriteriaKeyValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EvaluationCriteriaKeyValueSoap[] toSoapModels(
		List<EvaluationCriteriaKeyValue> models) {
		List<EvaluationCriteriaKeyValueSoap> soapModels = new ArrayList<EvaluationCriteriaKeyValueSoap>(models.size());

		for (EvaluationCriteriaKeyValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EvaluationCriteriaKeyValueSoap[soapModels.size()]);
	}

	public EvaluationCriteriaKeyValueSoap() {
	}

	public long getPrimaryKey() {
		return _evaluationCriteriaKeyValueId;
	}

	public void setPrimaryKey(long pk) {
		setEvaluationCriteriaKeyValueId(pk);
	}

	public long getEvaluationCriteriaKeyValueId() {
		return _evaluationCriteriaKeyValueId;
	}

	public void setEvaluationCriteriaKeyValueId(
		long evaluationCriteriaKeyValueId) {
		_evaluationCriteriaKeyValueId = evaluationCriteriaKeyValueId;
	}

	public long getEvaluationCriteriaId() {
		return _evaluationCriteriaId;
	}

	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_evaluationCriteriaId = evaluationCriteriaId;
	}

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
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

	private long _evaluationCriteriaKeyValueId;
	private long _evaluationCriteriaId;
	private String _key;
	private int _value;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}