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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.CandidateEvaluationServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.CandidateEvaluationServiceSoap
 * @generated
 */
public class CandidateEvaluationSoap implements Serializable {
	public static CandidateEvaluationSoap toSoapModel(CandidateEvaluation model) {
		CandidateEvaluationSoap soapModel = new CandidateEvaluationSoap();

		soapModel.setCandidateEvaluationId(model.getCandidateEvaluationId());
		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setInterviewId(model.getInterviewId());
		soapModel.setEvaluationCriteriaKeyValueId(model.getEvaluationCriteriaKeyValueId());
		soapModel.setRatingPoint(model.getRatingPoint());
		soapModel.setNote(model.getNote());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CandidateEvaluationSoap[] toSoapModels(
		CandidateEvaluation[] models) {
		CandidateEvaluationSoap[] soapModels = new CandidateEvaluationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateEvaluationSoap[][] toSoapModels(
		CandidateEvaluation[][] models) {
		CandidateEvaluationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateEvaluationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateEvaluationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateEvaluationSoap[] toSoapModels(
		List<CandidateEvaluation> models) {
		List<CandidateEvaluationSoap> soapModels = new ArrayList<CandidateEvaluationSoap>(models.size());

		for (CandidateEvaluation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateEvaluationSoap[soapModels.size()]);
	}

	public CandidateEvaluationSoap() {
	}

	public long getPrimaryKey() {
		return _candidateEvaluationId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateEvaluationId(pk);
	}

	public long getCandidateEvaluationId() {
		return _candidateEvaluationId;
	}

	public void setCandidateEvaluationId(long candidateEvaluationId) {
		_candidateEvaluationId = candidateEvaluationId;
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public long getInterviewId() {
		return _interviewId;
	}

	public void setInterviewId(long interviewId) {
		_interviewId = interviewId;
	}

	public long getEvaluationCriteriaKeyValueId() {
		return _evaluationCriteriaKeyValueId;
	}

	public void setEvaluationCriteriaKeyValueId(
		long evaluationCriteriaKeyValueId) {
		_evaluationCriteriaKeyValueId = evaluationCriteriaKeyValueId;
	}

	public int getRatingPoint() {
		return _ratingPoint;
	}

	public void setRatingPoint(int ratingPoint) {
		_ratingPoint = ratingPoint;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
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

	private long _candidateEvaluationId;
	private long _candidateId;
	private long _interviewId;
	private long _evaluationCriteriaKeyValueId;
	private int _ratingPoint;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}