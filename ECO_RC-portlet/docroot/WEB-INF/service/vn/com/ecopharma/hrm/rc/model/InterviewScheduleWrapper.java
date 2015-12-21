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
 * This class is a wrapper for {@link InterviewSchedule}.
 * </p>
 *
 * @author tvt
 * @see InterviewSchedule
 * @generated
 */
public class InterviewScheduleWrapper implements InterviewSchedule,
	ModelWrapper<InterviewSchedule> {
	public InterviewScheduleWrapper(InterviewSchedule interviewSchedule) {
		_interviewSchedule = interviewSchedule;
	}

	@Override
	public Class<?> getModelClass() {
		return InterviewSchedule.class;
	}

	@Override
	public String getModelClassName() {
		return InterviewSchedule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("interviewScheduleId", getInterviewScheduleId());
		attributes.put("vacancyCandidateId", getVacancyCandidateId());
		attributes.put("interviewId", getInterviewId());
		attributes.put("locationId", getLocationId());
		attributes.put("interviewDate", getInterviewDate());
		attributes.put("interviewTime", getInterviewTime());
		attributes.put("status", getStatus());
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
		Long interviewScheduleId = (Long)attributes.get("interviewScheduleId");

		if (interviewScheduleId != null) {
			setInterviewScheduleId(interviewScheduleId);
		}

		Long vacancyCandidateId = (Long)attributes.get("vacancyCandidateId");

		if (vacancyCandidateId != null) {
			setVacancyCandidateId(vacancyCandidateId);
		}

		Long interviewId = (Long)attributes.get("interviewId");

		if (interviewId != null) {
			setInterviewId(interviewId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Date interviewDate = (Date)attributes.get("interviewDate");

		if (interviewDate != null) {
			setInterviewDate(interviewDate);
		}

		String interviewTime = (String)attributes.get("interviewTime");

		if (interviewTime != null) {
			setInterviewTime(interviewTime);
		}

		String status = (String)attributes.get("status");

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
	}

	/**
	* Returns the primary key of this interview schedule.
	*
	* @return the primary key of this interview schedule
	*/
	@Override
	public long getPrimaryKey() {
		return _interviewSchedule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this interview schedule.
	*
	* @param primaryKey the primary key of this interview schedule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_interviewSchedule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the interview schedule ID of this interview schedule.
	*
	* @return the interview schedule ID of this interview schedule
	*/
	@Override
	public long getInterviewScheduleId() {
		return _interviewSchedule.getInterviewScheduleId();
	}

	/**
	* Sets the interview schedule ID of this interview schedule.
	*
	* @param interviewScheduleId the interview schedule ID of this interview schedule
	*/
	@Override
	public void setInterviewScheduleId(long interviewScheduleId) {
		_interviewSchedule.setInterviewScheduleId(interviewScheduleId);
	}

	/**
	* Returns the vacancy candidate ID of this interview schedule.
	*
	* @return the vacancy candidate ID of this interview schedule
	*/
	@Override
	public long getVacancyCandidateId() {
		return _interviewSchedule.getVacancyCandidateId();
	}

	/**
	* Sets the vacancy candidate ID of this interview schedule.
	*
	* @param vacancyCandidateId the vacancy candidate ID of this interview schedule
	*/
	@Override
	public void setVacancyCandidateId(long vacancyCandidateId) {
		_interviewSchedule.setVacancyCandidateId(vacancyCandidateId);
	}

	/**
	* Returns the interview ID of this interview schedule.
	*
	* @return the interview ID of this interview schedule
	*/
	@Override
	public long getInterviewId() {
		return _interviewSchedule.getInterviewId();
	}

	/**
	* Sets the interview ID of this interview schedule.
	*
	* @param interviewId the interview ID of this interview schedule
	*/
	@Override
	public void setInterviewId(long interviewId) {
		_interviewSchedule.setInterviewId(interviewId);
	}

	/**
	* Returns the location ID of this interview schedule.
	*
	* @return the location ID of this interview schedule
	*/
	@Override
	public long getLocationId() {
		return _interviewSchedule.getLocationId();
	}

	/**
	* Sets the location ID of this interview schedule.
	*
	* @param locationId the location ID of this interview schedule
	*/
	@Override
	public void setLocationId(long locationId) {
		_interviewSchedule.setLocationId(locationId);
	}

	/**
	* Returns the interview date of this interview schedule.
	*
	* @return the interview date of this interview schedule
	*/
	@Override
	public java.util.Date getInterviewDate() {
		return _interviewSchedule.getInterviewDate();
	}

	/**
	* Sets the interview date of this interview schedule.
	*
	* @param interviewDate the interview date of this interview schedule
	*/
	@Override
	public void setInterviewDate(java.util.Date interviewDate) {
		_interviewSchedule.setInterviewDate(interviewDate);
	}

	/**
	* Returns the interview time of this interview schedule.
	*
	* @return the interview time of this interview schedule
	*/
	@Override
	public java.lang.String getInterviewTime() {
		return _interviewSchedule.getInterviewTime();
	}

	/**
	* Sets the interview time of this interview schedule.
	*
	* @param interviewTime the interview time of this interview schedule
	*/
	@Override
	public void setInterviewTime(java.lang.String interviewTime) {
		_interviewSchedule.setInterviewTime(interviewTime);
	}

	/**
	* Returns the status of this interview schedule.
	*
	* @return the status of this interview schedule
	*/
	@Override
	public java.lang.String getStatus() {
		return _interviewSchedule.getStatus();
	}

	/**
	* Sets the status of this interview schedule.
	*
	* @param status the status of this interview schedule
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_interviewSchedule.setStatus(status);
	}

	/**
	* Returns the group ID of this interview schedule.
	*
	* @return the group ID of this interview schedule
	*/
	@Override
	public long getGroupId() {
		return _interviewSchedule.getGroupId();
	}

	/**
	* Sets the group ID of this interview schedule.
	*
	* @param groupId the group ID of this interview schedule
	*/
	@Override
	public void setGroupId(long groupId) {
		_interviewSchedule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this interview schedule.
	*
	* @return the company ID of this interview schedule
	*/
	@Override
	public long getCompanyId() {
		return _interviewSchedule.getCompanyId();
	}

	/**
	* Sets the company ID of this interview schedule.
	*
	* @param companyId the company ID of this interview schedule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_interviewSchedule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this interview schedule.
	*
	* @return the user ID of this interview schedule
	*/
	@Override
	public long getUserId() {
		return _interviewSchedule.getUserId();
	}

	/**
	* Sets the user ID of this interview schedule.
	*
	* @param userId the user ID of this interview schedule
	*/
	@Override
	public void setUserId(long userId) {
		_interviewSchedule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this interview schedule.
	*
	* @return the user uuid of this interview schedule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _interviewSchedule.getUserUuid();
	}

	/**
	* Sets the user uuid of this interview schedule.
	*
	* @param userUuid the user uuid of this interview schedule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_interviewSchedule.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this interview schedule.
	*
	* @return the user name of this interview schedule
	*/
	@Override
	public java.lang.String getUserName() {
		return _interviewSchedule.getUserName();
	}

	/**
	* Sets the user name of this interview schedule.
	*
	* @param userName the user name of this interview schedule
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_interviewSchedule.setUserName(userName);
	}

	/**
	* Returns the create date of this interview schedule.
	*
	* @return the create date of this interview schedule
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _interviewSchedule.getCreateDate();
	}

	/**
	* Sets the create date of this interview schedule.
	*
	* @param createDate the create date of this interview schedule
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_interviewSchedule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this interview schedule.
	*
	* @return the modified date of this interview schedule
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _interviewSchedule.getModifiedDate();
	}

	/**
	* Sets the modified date of this interview schedule.
	*
	* @param modifiedDate the modified date of this interview schedule
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_interviewSchedule.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _interviewSchedule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_interviewSchedule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _interviewSchedule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_interviewSchedule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _interviewSchedule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _interviewSchedule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_interviewSchedule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _interviewSchedule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_interviewSchedule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_interviewSchedule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_interviewSchedule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new InterviewScheduleWrapper((InterviewSchedule)_interviewSchedule.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.InterviewSchedule interviewSchedule) {
		return _interviewSchedule.compareTo(interviewSchedule);
	}

	@Override
	public int hashCode() {
		return _interviewSchedule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.InterviewSchedule> toCacheModel() {
		return _interviewSchedule.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule toEscapedModel() {
		return new InterviewScheduleWrapper(_interviewSchedule.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.InterviewSchedule toUnescapedModel() {
		return new InterviewScheduleWrapper(_interviewSchedule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _interviewSchedule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _interviewSchedule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_interviewSchedule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof InterviewScheduleWrapper)) {
			return false;
		}

		InterviewScheduleWrapper interviewScheduleWrapper = (InterviewScheduleWrapper)obj;

		if (Validator.equals(_interviewSchedule,
					interviewScheduleWrapper._interviewSchedule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public InterviewSchedule getWrappedInterviewSchedule() {
		return _interviewSchedule;
	}

	@Override
	public InterviewSchedule getWrappedModel() {
		return _interviewSchedule;
	}

	@Override
	public void resetOriginalValues() {
		_interviewSchedule.resetOriginalValues();
	}

	private InterviewSchedule _interviewSchedule;
}