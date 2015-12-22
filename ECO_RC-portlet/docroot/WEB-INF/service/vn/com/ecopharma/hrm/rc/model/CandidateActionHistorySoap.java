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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.CandidateActionHistoryServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.CandidateActionHistoryServiceSoap
 * @generated
 */
public class CandidateActionHistorySoap implements Serializable {
	public static CandidateActionHistorySoap toSoapModel(
		CandidateActionHistory model) {
		CandidateActionHistorySoap soapModel = new CandidateActionHistorySoap();

		soapModel.setCandidateActionHistoryId(model.getCandidateActionHistoryId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setAction(model.getAction());
		soapModel.setActionType(model.getActionType());
		soapModel.setExecutedBy(model.getExecutedBy());
		soapModel.setDate(model.getDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CandidateActionHistorySoap[] toSoapModels(
		CandidateActionHistory[] models) {
		CandidateActionHistorySoap[] soapModels = new CandidateActionHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateActionHistorySoap[][] toSoapModels(
		CandidateActionHistory[][] models) {
		CandidateActionHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateActionHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateActionHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateActionHistorySoap[] toSoapModels(
		List<CandidateActionHistory> models) {
		List<CandidateActionHistorySoap> soapModels = new ArrayList<CandidateActionHistorySoap>(models.size());

		for (CandidateActionHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateActionHistorySoap[soapModels.size()]);
	}

	public CandidateActionHistorySoap() {
	}

	public long getPrimaryKey() {
		return _candidateActionHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateActionHistoryId(pk);
	}

	public long getCandidateActionHistoryId() {
		return _candidateActionHistoryId;
	}

	public void setCandidateActionHistoryId(long candidateActionHistoryId) {
		_candidateActionHistoryId = candidateActionHistoryId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getActionType() {
		return _actionType;
	}

	public void setActionType(String actionType) {
		_actionType = actionType;
	}

	public long getExecutedBy() {
		return _executedBy;
	}

	public void setExecutedBy(long executedBy) {
		_executedBy = executedBy;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
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

	private long _candidateActionHistoryId;
	private long _candidateId;
	private String _action;
	private String _actionType;
	private long _executedBy;
	private Date _date;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}