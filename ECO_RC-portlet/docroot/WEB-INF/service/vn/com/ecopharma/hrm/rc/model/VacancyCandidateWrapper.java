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
 * This class is a wrapper for {@link VacancyCandidate}.
 * </p>
 *
 * @author tvt
 * @see VacancyCandidate
 * @generated
 */
public class VacancyCandidateWrapper implements VacancyCandidate,
	ModelWrapper<VacancyCandidate> {
	public VacancyCandidateWrapper(VacancyCandidate vacancyCandidate) {
		_vacancyCandidate = vacancyCandidate;
	}

	@Override
	public Class<?> getModelClass() {
		return VacancyCandidate.class;
	}

	@Override
	public String getModelClassName() {
		return VacancyCandidate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacancyCandidateId", getVacancyCandidateId());
		attributes.put("vacancyId", getVacancyId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("status", getStatus());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacancyCandidateId = (Long)attributes.get("vacancyCandidateId");

		if (vacancyCandidateId != null) {
			setVacancyCandidateId(vacancyCandidateId);
		}

		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	/**
	* Returns the primary key of this vacancy candidate.
	*
	* @return the primary key of this vacancy candidate
	*/
	@Override
	public long getPrimaryKey() {
		return _vacancyCandidate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vacancy candidate.
	*
	* @param primaryKey the primary key of this vacancy candidate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vacancyCandidate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vacancy candidate ID of this vacancy candidate.
	*
	* @return the vacancy candidate ID of this vacancy candidate
	*/
	@Override
	public long getVacancyCandidateId() {
		return _vacancyCandidate.getVacancyCandidateId();
	}

	/**
	* Sets the vacancy candidate ID of this vacancy candidate.
	*
	* @param vacancyCandidateId the vacancy candidate ID of this vacancy candidate
	*/
	@Override
	public void setVacancyCandidateId(long vacancyCandidateId) {
		_vacancyCandidate.setVacancyCandidateId(vacancyCandidateId);
	}

	/**
	* Returns the vacancy ID of this vacancy candidate.
	*
	* @return the vacancy ID of this vacancy candidate
	*/
	@Override
	public long getVacancyId() {
		return _vacancyCandidate.getVacancyId();
	}

	/**
	* Sets the vacancy ID of this vacancy candidate.
	*
	* @param vacancyId the vacancy ID of this vacancy candidate
	*/
	@Override
	public void setVacancyId(long vacancyId) {
		_vacancyCandidate.setVacancyId(vacancyId);
	}

	/**
	* Returns the candidate ID of this vacancy candidate.
	*
	* @return the candidate ID of this vacancy candidate
	*/
	@Override
	public long getCandidateId() {
		return _vacancyCandidate.getCandidateId();
	}

	/**
	* Sets the candidate ID of this vacancy candidate.
	*
	* @param candidateId the candidate ID of this vacancy candidate
	*/
	@Override
	public void setCandidateId(long candidateId) {
		_vacancyCandidate.setCandidateId(candidateId);
	}

	/**
	* Returns the status of this vacancy candidate.
	*
	* @return the status of this vacancy candidate
	*/
	@Override
	public int getStatus() {
		return _vacancyCandidate.getStatus();
	}

	/**
	* Sets the status of this vacancy candidate.
	*
	* @param status the status of this vacancy candidate
	*/
	@Override
	public void setStatus(int status) {
		_vacancyCandidate.setStatus(status);
	}

	/**
	* Returns the group ID of this vacancy candidate.
	*
	* @return the group ID of this vacancy candidate
	*/
	@Override
	public long getGroupId() {
		return _vacancyCandidate.getGroupId();
	}

	/**
	* Sets the group ID of this vacancy candidate.
	*
	* @param groupId the group ID of this vacancy candidate
	*/
	@Override
	public void setGroupId(long groupId) {
		_vacancyCandidate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vacancy candidate.
	*
	* @return the company ID of this vacancy candidate
	*/
	@Override
	public long getCompanyId() {
		return _vacancyCandidate.getCompanyId();
	}

	/**
	* Sets the company ID of this vacancy candidate.
	*
	* @param companyId the company ID of this vacancy candidate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vacancyCandidate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vacancy candidate.
	*
	* @return the user ID of this vacancy candidate
	*/
	@Override
	public long getUserId() {
		return _vacancyCandidate.getUserId();
	}

	/**
	* Sets the user ID of this vacancy candidate.
	*
	* @param userId the user ID of this vacancy candidate
	*/
	@Override
	public void setUserId(long userId) {
		_vacancyCandidate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vacancy candidate.
	*
	* @return the user uuid of this vacancy candidate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyCandidate.getUserUuid();
	}

	/**
	* Sets the user uuid of this vacancy candidate.
	*
	* @param userUuid the user uuid of this vacancy candidate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vacancyCandidate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vacancy candidate.
	*
	* @return the user name of this vacancy candidate
	*/
	@Override
	public java.lang.String getUserName() {
		return _vacancyCandidate.getUserName();
	}

	/**
	* Sets the user name of this vacancy candidate.
	*
	* @param userName the user name of this vacancy candidate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vacancyCandidate.setUserName(userName);
	}

	/**
	* Returns the create date of this vacancy candidate.
	*
	* @return the create date of this vacancy candidate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vacancyCandidate.getCreateDate();
	}

	/**
	* Sets the create date of this vacancy candidate.
	*
	* @param createDate the create date of this vacancy candidate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vacancyCandidate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vacancy candidate.
	*
	* @return the modified date of this vacancy candidate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vacancyCandidate.getModifiedDate();
	}

	/**
	* Sets the modified date of this vacancy candidate.
	*
	* @param modifiedDate the modified date of this vacancy candidate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vacancyCandidate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type of this vacancy candidate.
	*
	* @return the type of this vacancy candidate
	*/
	@Override
	public java.lang.String getType() {
		return _vacancyCandidate.getType();
	}

	/**
	* Sets the type of this vacancy candidate.
	*
	* @param type the type of this vacancy candidate
	*/
	@Override
	public void setType(java.lang.String type) {
		_vacancyCandidate.setType(type);
	}

	@Override
	public boolean isNew() {
		return _vacancyCandidate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vacancyCandidate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vacancyCandidate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vacancyCandidate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vacancyCandidate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vacancyCandidate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vacancyCandidate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vacancyCandidate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vacancyCandidate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vacancyCandidate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vacancyCandidate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VacancyCandidateWrapper((VacancyCandidate)_vacancyCandidate.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.VacancyCandidate vacancyCandidate) {
		return _vacancyCandidate.compareTo(vacancyCandidate);
	}

	@Override
	public int hashCode() {
		return _vacancyCandidate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.VacancyCandidate> toCacheModel() {
		return _vacancyCandidate.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate toEscapedModel() {
		return new VacancyCandidateWrapper(_vacancyCandidate.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyCandidate toUnescapedModel() {
		return new VacancyCandidateWrapper(_vacancyCandidate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vacancyCandidate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vacancyCandidate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vacancyCandidate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacancyCandidateWrapper)) {
			return false;
		}

		VacancyCandidateWrapper vacancyCandidateWrapper = (VacancyCandidateWrapper)obj;

		if (Validator.equals(_vacancyCandidate,
					vacancyCandidateWrapper._vacancyCandidate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VacancyCandidate getWrappedVacancyCandidate() {
		return _vacancyCandidate;
	}

	@Override
	public VacancyCandidate getWrappedModel() {
		return _vacancyCandidate;
	}

	@Override
	public void resetOriginalValues() {
		_vacancyCandidate.resetOriginalValues();
	}

	private VacancyCandidate _vacancyCandidate;
}