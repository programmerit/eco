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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.VacancyCandidateServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.VacancyCandidateServiceSoap
 * @generated
 */
public class VacancyCandidateSoap implements Serializable {
	public static VacancyCandidateSoap toSoapModel(VacancyCandidate model) {
		VacancyCandidateSoap soapModel = new VacancyCandidateSoap();

		soapModel.setVacancyCandidateId(model.getVacancyCandidateId());
		soapModel.setVacancyId(model.getVacancyId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setStatus(model.getStatus());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static VacancyCandidateSoap[] toSoapModels(VacancyCandidate[] models) {
		VacancyCandidateSoap[] soapModels = new VacancyCandidateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacancyCandidateSoap[][] toSoapModels(
		VacancyCandidate[][] models) {
		VacancyCandidateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacancyCandidateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacancyCandidateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacancyCandidateSoap[] toSoapModels(
		List<VacancyCandidate> models) {
		List<VacancyCandidateSoap> soapModels = new ArrayList<VacancyCandidateSoap>(models.size());

		for (VacancyCandidate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacancyCandidateSoap[soapModels.size()]);
	}

	public VacancyCandidateSoap() {
	}

	public long getPrimaryKey() {
		return _vacancyCandidateId;
	}

	public void setPrimaryKey(long pk) {
		setVacancyCandidateId(pk);
	}

	public long getVacancyCandidateId() {
		return _vacancyCandidateId;
	}

	public void setVacancyCandidateId(long vacancyCandidateId) {
		_vacancyCandidateId = vacancyCandidateId;
	}

	public long getVacancyId() {
		return _vacancyId;
	}

	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private long _vacancyCandidateId;
	private long _vacancyId;
	private long _candidateId;
	private int _status;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
}