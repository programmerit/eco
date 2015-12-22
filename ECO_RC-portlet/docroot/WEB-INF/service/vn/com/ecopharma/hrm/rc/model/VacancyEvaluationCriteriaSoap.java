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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.VacancyEvaluationCriteriaServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.VacancyEvaluationCriteriaServiceSoap
 * @generated
 */
public class VacancyEvaluationCriteriaSoap implements Serializable {
	public static VacancyEvaluationCriteriaSoap toSoapModel(
		VacancyEvaluationCriteria model) {
		VacancyEvaluationCriteriaSoap soapModel = new VacancyEvaluationCriteriaSoap();

		soapModel.setVacancyEvaluationCriteriaId(model.getVacancyEvaluationCriteriaId());
		soapModel.setVacancyId(model.getVacancyId());
		soapModel.setEvaluationCriteriaId(model.getEvaluationCriteriaId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static VacancyEvaluationCriteriaSoap[] toSoapModels(
		VacancyEvaluationCriteria[] models) {
		VacancyEvaluationCriteriaSoap[] soapModels = new VacancyEvaluationCriteriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacancyEvaluationCriteriaSoap[][] toSoapModels(
		VacancyEvaluationCriteria[][] models) {
		VacancyEvaluationCriteriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacancyEvaluationCriteriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacancyEvaluationCriteriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacancyEvaluationCriteriaSoap[] toSoapModels(
		List<VacancyEvaluationCriteria> models) {
		List<VacancyEvaluationCriteriaSoap> soapModels = new ArrayList<VacancyEvaluationCriteriaSoap>(models.size());

		for (VacancyEvaluationCriteria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacancyEvaluationCriteriaSoap[soapModels.size()]);
	}

	public VacancyEvaluationCriteriaSoap() {
	}

	public long getPrimaryKey() {
		return _vacancyEvaluationCriteriaId;
	}

	public void setPrimaryKey(long pk) {
		setVacancyEvaluationCriteriaId(pk);
	}

	public long getVacancyEvaluationCriteriaId() {
		return _vacancyEvaluationCriteriaId;
	}

	public void setVacancyEvaluationCriteriaId(long vacancyEvaluationCriteriaId) {
		_vacancyEvaluationCriteriaId = vacancyEvaluationCriteriaId;
	}

	public long getVacancyId() {
		return _vacancyId;
	}

	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;
	}

	public long getEvaluationCriteriaId() {
		return _evaluationCriteriaId;
	}

	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_evaluationCriteriaId = evaluationCriteriaId;
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

	private long _vacancyEvaluationCriteriaId;
	private long _vacancyId;
	private long _evaluationCriteriaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}