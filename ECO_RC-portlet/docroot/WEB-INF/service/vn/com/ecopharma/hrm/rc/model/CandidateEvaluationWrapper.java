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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CandidateEvaluation}.
 * </p>
 *
 * @author tvt
 * @see CandidateEvaluation
 * @generated
 */
public class CandidateEvaluationWrapper implements CandidateEvaluation,
	ModelWrapper<CandidateEvaluation> {
	public CandidateEvaluationWrapper(CandidateEvaluation candidateEvaluation) {
		_candidateEvaluation = candidateEvaluation;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateEvaluation.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateEvaluation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateEvaluationId", getCandidateEvaluationId());
		attributes.put("evaluationCriteriaId", getEvaluationCriteriaId());
		attributes.put("evaluationCriteriaKeyValueId",
			getEvaluationCriteriaKeyValueId());
		attributes.put("ratingPoint", getRatingPoint());
		attributes.put("note", getNote());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("candidateId", getCandidateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateEvaluationId = (Long)attributes.get(
				"candidateEvaluationId");

		if (candidateEvaluationId != null) {
			setCandidateEvaluationId(candidateEvaluationId);
		}

		Long evaluationCriteriaId = (Long)attributes.get("evaluationCriteriaId");

		if (evaluationCriteriaId != null) {
			setEvaluationCriteriaId(evaluationCriteriaId);
		}

		Long evaluationCriteriaKeyValueId = (Long)attributes.get(
				"evaluationCriteriaKeyValueId");

		if (evaluationCriteriaKeyValueId != null) {
			setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
		}

		Integer ratingPoint = (Integer)attributes.get("ratingPoint");

		if (ratingPoint != null) {
			setRatingPoint(ratingPoint);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}
	}

	/**
	* Returns the primary key of this candidate evaluation.
	*
	* @return the primary key of this candidate evaluation
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateEvaluation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this candidate evaluation.
	*
	* @param primaryKey the primary key of this candidate evaluation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateEvaluation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the candidate evaluation ID of this candidate evaluation.
	*
	* @return the candidate evaluation ID of this candidate evaluation
	*/
	@Override
	public long getCandidateEvaluationId() {
		return _candidateEvaluation.getCandidateEvaluationId();
	}

	/**
	* Sets the candidate evaluation ID of this candidate evaluation.
	*
	* @param candidateEvaluationId the candidate evaluation ID of this candidate evaluation
	*/
	@Override
	public void setCandidateEvaluationId(long candidateEvaluationId) {
		_candidateEvaluation.setCandidateEvaluationId(candidateEvaluationId);
	}

	/**
	* Returns the evaluation criteria ID of this candidate evaluation.
	*
	* @return the evaluation criteria ID of this candidate evaluation
	*/
	@Override
	public long getEvaluationCriteriaId() {
		return _candidateEvaluation.getEvaluationCriteriaId();
	}

	/**
	* Sets the evaluation criteria ID of this candidate evaluation.
	*
	* @param evaluationCriteriaId the evaluation criteria ID of this candidate evaluation
	*/
	@Override
	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_candidateEvaluation.setEvaluationCriteriaId(evaluationCriteriaId);
	}

	/**
	* Returns the evaluation criteria key value ID of this candidate evaluation.
	*
	* @return the evaluation criteria key value ID of this candidate evaluation
	*/
	@Override
	public long getEvaluationCriteriaKeyValueId() {
		return _candidateEvaluation.getEvaluationCriteriaKeyValueId();
	}

	/**
	* Sets the evaluation criteria key value ID of this candidate evaluation.
	*
	* @param evaluationCriteriaKeyValueId the evaluation criteria key value ID of this candidate evaluation
	*/
	@Override
	public void setEvaluationCriteriaKeyValueId(
		long evaluationCriteriaKeyValueId) {
		_candidateEvaluation.setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
	}

	/**
	* Returns the rating point of this candidate evaluation.
	*
	* @return the rating point of this candidate evaluation
	*/
	@Override
	public int getRatingPoint() {
		return _candidateEvaluation.getRatingPoint();
	}

	/**
	* Sets the rating point of this candidate evaluation.
	*
	* @param ratingPoint the rating point of this candidate evaluation
	*/
	@Override
	public void setRatingPoint(int ratingPoint) {
		_candidateEvaluation.setRatingPoint(ratingPoint);
	}

	/**
	* Returns the note of this candidate evaluation.
	*
	* @return the note of this candidate evaluation
	*/
	@Override
	public java.lang.String getNote() {
		return _candidateEvaluation.getNote();
	}

	/**
	* Sets the note of this candidate evaluation.
	*
	* @param note the note of this candidate evaluation
	*/
	@Override
	public void setNote(java.lang.String note) {
		_candidateEvaluation.setNote(note);
	}

	/**
	* Returns the group ID of this candidate evaluation.
	*
	* @return the group ID of this candidate evaluation
	*/
	@Override
	public long getGroupId() {
		return _candidateEvaluation.getGroupId();
	}

	/**
	* Sets the group ID of this candidate evaluation.
	*
	* @param groupId the group ID of this candidate evaluation
	*/
	@Override
	public void setGroupId(long groupId) {
		_candidateEvaluation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this candidate evaluation.
	*
	* @return the company ID of this candidate evaluation
	*/
	@Override
	public long getCompanyId() {
		return _candidateEvaluation.getCompanyId();
	}

	/**
	* Sets the company ID of this candidate evaluation.
	*
	* @param companyId the company ID of this candidate evaluation
	*/
	@Override
	public void setCompanyId(long companyId) {
		_candidateEvaluation.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this candidate evaluation.
	*
	* @return the user ID of this candidate evaluation
	*/
	@Override
	public long getUserId() {
		return _candidateEvaluation.getUserId();
	}

	/**
	* Sets the user ID of this candidate evaluation.
	*
	* @param userId the user ID of this candidate evaluation
	*/
	@Override
	public void setUserId(long userId) {
		_candidateEvaluation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this candidate evaluation.
	*
	* @return the user uuid of this candidate evaluation
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateEvaluation.getUserUuid();
	}

	/**
	* Sets the user uuid of this candidate evaluation.
	*
	* @param userUuid the user uuid of this candidate evaluation
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_candidateEvaluation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this candidate evaluation.
	*
	* @return the user name of this candidate evaluation
	*/
	@Override
	public java.lang.String getUserName() {
		return _candidateEvaluation.getUserName();
	}

	/**
	* Sets the user name of this candidate evaluation.
	*
	* @param userName the user name of this candidate evaluation
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_candidateEvaluation.setUserName(userName);
	}

	/**
	* Returns the create date of this candidate evaluation.
	*
	* @return the create date of this candidate evaluation
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _candidateEvaluation.getCreateDate();
	}

	/**
	* Sets the create date of this candidate evaluation.
	*
	* @param createDate the create date of this candidate evaluation
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_candidateEvaluation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this candidate evaluation.
	*
	* @return the modified date of this candidate evaluation
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _candidateEvaluation.getModifiedDate();
	}

	/**
	* Sets the modified date of this candidate evaluation.
	*
	* @param modifiedDate the modified date of this candidate evaluation
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_candidateEvaluation.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the candidate ID of this candidate evaluation.
	*
	* @return the candidate ID of this candidate evaluation
	*/
	@Override
	public long getCandidateId() {
		return _candidateEvaluation.getCandidateId();
	}

	/**
	* Sets the candidate ID of this candidate evaluation.
	*
	* @param candidateId the candidate ID of this candidate evaluation
	*/
	@Override
	public void setCandidateId(long candidateId) {
		_candidateEvaluation.setCandidateId(candidateId);
	}

	@Override
	public boolean isNew() {
		return _candidateEvaluation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_candidateEvaluation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _candidateEvaluation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateEvaluation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateEvaluation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _candidateEvaluation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_candidateEvaluation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _candidateEvaluation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_candidateEvaluation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_candidateEvaluation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_candidateEvaluation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CandidateEvaluationWrapper((CandidateEvaluation)_candidateEvaluation.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.CandidateEvaluation candidateEvaluation) {
		return _candidateEvaluation.compareTo(candidateEvaluation);
	}

	@Override
	public int hashCode() {
		return _candidateEvaluation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.CandidateEvaluation> toCacheModel() {
		return _candidateEvaluation.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation toEscapedModel() {
		return new CandidateEvaluationWrapper(_candidateEvaluation.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateEvaluation toUnescapedModel() {
		return new CandidateEvaluationWrapper(_candidateEvaluation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _candidateEvaluation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _candidateEvaluation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_candidateEvaluation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateEvaluationWrapper)) {
			return false;
		}

		CandidateEvaluationWrapper candidateEvaluationWrapper = (CandidateEvaluationWrapper)obj;

		if (Validator.equals(_candidateEvaluation,
					candidateEvaluationWrapper._candidateEvaluation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CandidateEvaluation getWrappedCandidateEvaluation() {
		return _candidateEvaluation;
	}

	@Override
	public CandidateEvaluation getWrappedModel() {
		return _candidateEvaluation;
	}

	@Override
	public void resetOriginalValues() {
		_candidateEvaluation.resetOriginalValues();
	}

	private CandidateEvaluation _candidateEvaluation;
}