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
 * This class is a wrapper for {@link CandidateActionHistory}.
 * </p>
 *
 * @author tvt
 * @see CandidateActionHistory
 * @generated
 */
public class CandidateActionHistoryWrapper implements CandidateActionHistory,
	ModelWrapper<CandidateActionHistory> {
	public CandidateActionHistoryWrapper(
		CandidateActionHistory candidateActionHistory) {
		_candidateActionHistory = candidateActionHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateActionHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateActionHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateActionHistoryId", getCandidateActionHistoryId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("action", getAction());
		attributes.put("actionType", getActionType());
		attributes.put("executedBy", getExecutedBy());
		attributes.put("date", getDate());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateActionHistoryId = (Long)attributes.get(
				"candidateActionHistoryId");

		if (candidateActionHistoryId != null) {
			setCandidateActionHistoryId(candidateActionHistoryId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		Long executedBy = (Long)attributes.get("executedBy");

		if (executedBy != null) {
			setExecutedBy(executedBy);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	}

	/**
	* Returns the primary key of this candidate action history.
	*
	* @return the primary key of this candidate action history
	*/
	@Override
	public long getPrimaryKey() {
		return _candidateActionHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this candidate action history.
	*
	* @param primaryKey the primary key of this candidate action history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidateActionHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the candidate action history ID of this candidate action history.
	*
	* @return the candidate action history ID of this candidate action history
	*/
	@Override
	public long getCandidateActionHistoryId() {
		return _candidateActionHistory.getCandidateActionHistoryId();
	}

	/**
	* Sets the candidate action history ID of this candidate action history.
	*
	* @param candidateActionHistoryId the candidate action history ID of this candidate action history
	*/
	@Override
	public void setCandidateActionHistoryId(long candidateActionHistoryId) {
		_candidateActionHistory.setCandidateActionHistoryId(candidateActionHistoryId);
	}

	/**
	* Returns the candidate ID of this candidate action history.
	*
	* @return the candidate ID of this candidate action history
	*/
	@Override
	public long getCandidateId() {
		return _candidateActionHistory.getCandidateId();
	}

	/**
	* Sets the candidate ID of this candidate action history.
	*
	* @param candidateId the candidate ID of this candidate action history
	*/
	@Override
	public void setCandidateId(long candidateId) {
		_candidateActionHistory.setCandidateId(candidateId);
	}

	/**
	* Returns the action of this candidate action history.
	*
	* @return the action of this candidate action history
	*/
	@Override
	public java.lang.String getAction() {
		return _candidateActionHistory.getAction();
	}

	/**
	* Sets the action of this candidate action history.
	*
	* @param action the action of this candidate action history
	*/
	@Override
	public void setAction(java.lang.String action) {
		_candidateActionHistory.setAction(action);
	}

	/**
	* Returns the action type of this candidate action history.
	*
	* @return the action type of this candidate action history
	*/
	@Override
	public java.lang.String getActionType() {
		return _candidateActionHistory.getActionType();
	}

	/**
	* Sets the action type of this candidate action history.
	*
	* @param actionType the action type of this candidate action history
	*/
	@Override
	public void setActionType(java.lang.String actionType) {
		_candidateActionHistory.setActionType(actionType);
	}

	/**
	* Returns the executed by of this candidate action history.
	*
	* @return the executed by of this candidate action history
	*/
	@Override
	public long getExecutedBy() {
		return _candidateActionHistory.getExecutedBy();
	}

	/**
	* Sets the executed by of this candidate action history.
	*
	* @param executedBy the executed by of this candidate action history
	*/
	@Override
	public void setExecutedBy(long executedBy) {
		_candidateActionHistory.setExecutedBy(executedBy);
	}

	/**
	* Returns the date of this candidate action history.
	*
	* @return the date of this candidate action history
	*/
	@Override
	public java.util.Date getDate() {
		return _candidateActionHistory.getDate();
	}

	/**
	* Sets the date of this candidate action history.
	*
	* @param date the date of this candidate action history
	*/
	@Override
	public void setDate(java.util.Date date) {
		_candidateActionHistory.setDate(date);
	}

	/**
	* Returns the description of this candidate action history.
	*
	* @return the description of this candidate action history
	*/
	@Override
	public java.lang.String getDescription() {
		return _candidateActionHistory.getDescription();
	}

	/**
	* Sets the description of this candidate action history.
	*
	* @param description the description of this candidate action history
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_candidateActionHistory.setDescription(description);
	}

	/**
	* Returns the group ID of this candidate action history.
	*
	* @return the group ID of this candidate action history
	*/
	@Override
	public long getGroupId() {
		return _candidateActionHistory.getGroupId();
	}

	/**
	* Sets the group ID of this candidate action history.
	*
	* @param groupId the group ID of this candidate action history
	*/
	@Override
	public void setGroupId(long groupId) {
		_candidateActionHistory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this candidate action history.
	*
	* @return the company ID of this candidate action history
	*/
	@Override
	public long getCompanyId() {
		return _candidateActionHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this candidate action history.
	*
	* @param companyId the company ID of this candidate action history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_candidateActionHistory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this candidate action history.
	*
	* @return the user ID of this candidate action history
	*/
	@Override
	public long getUserId() {
		return _candidateActionHistory.getUserId();
	}

	/**
	* Sets the user ID of this candidate action history.
	*
	* @param userId the user ID of this candidate action history
	*/
	@Override
	public void setUserId(long userId) {
		_candidateActionHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this candidate action history.
	*
	* @return the user uuid of this candidate action history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidateActionHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this candidate action history.
	*
	* @param userUuid the user uuid of this candidate action history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_candidateActionHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this candidate action history.
	*
	* @return the user name of this candidate action history
	*/
	@Override
	public java.lang.String getUserName() {
		return _candidateActionHistory.getUserName();
	}

	/**
	* Sets the user name of this candidate action history.
	*
	* @param userName the user name of this candidate action history
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_candidateActionHistory.setUserName(userName);
	}

	/**
	* Returns the create date of this candidate action history.
	*
	* @return the create date of this candidate action history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _candidateActionHistory.getCreateDate();
	}

	/**
	* Sets the create date of this candidate action history.
	*
	* @param createDate the create date of this candidate action history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_candidateActionHistory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this candidate action history.
	*
	* @return the modified date of this candidate action history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _candidateActionHistory.getModifiedDate();
	}

	/**
	* Sets the modified date of this candidate action history.
	*
	* @param modifiedDate the modified date of this candidate action history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_candidateActionHistory.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _candidateActionHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_candidateActionHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _candidateActionHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidateActionHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _candidateActionHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _candidateActionHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_candidateActionHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _candidateActionHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_candidateActionHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_candidateActionHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_candidateActionHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CandidateActionHistoryWrapper((CandidateActionHistory)_candidateActionHistory.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.CandidateActionHistory candidateActionHistory) {
		return _candidateActionHistory.compareTo(candidateActionHistory);
	}

	@Override
	public int hashCode() {
		return _candidateActionHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.CandidateActionHistory> toCacheModel() {
		return _candidateActionHistory.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory toEscapedModel() {
		return new CandidateActionHistoryWrapper(_candidateActionHistory.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.CandidateActionHistory toUnescapedModel() {
		return new CandidateActionHistoryWrapper(_candidateActionHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _candidateActionHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _candidateActionHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_candidateActionHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateActionHistoryWrapper)) {
			return false;
		}

		CandidateActionHistoryWrapper candidateActionHistoryWrapper = (CandidateActionHistoryWrapper)obj;

		if (Validator.equals(_candidateActionHistory,
					candidateActionHistoryWrapper._candidateActionHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CandidateActionHistory getWrappedCandidateActionHistory() {
		return _candidateActionHistory;
	}

	@Override
	public CandidateActionHistory getWrappedModel() {
		return _candidateActionHistory;
	}

	@Override
	public void resetOriginalValues() {
		_candidateActionHistory.resetOriginalValues();
	}

	private CandidateActionHistory _candidateActionHistory;
}