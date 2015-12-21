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

package vn.com.ecopharma.hrm.tt.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TimeTracking}.
 * </p>
 *
 * @author tvt
 * @see TimeTracking
 * @generated
 */
public class TimeTrackingWrapper implements TimeTracking,
	ModelWrapper<TimeTracking> {
	public TimeTrackingWrapper(TimeTracking timeTracking) {
		_timeTracking = timeTracking;
	}

	@Override
	public Class<?> getModelClass() {
		return TimeTracking.class;
	}

	@Override
	public String getModelClassName() {
		return TimeTracking.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timeTrackingId", getTimeTrackingId());
		attributes.put("empId", getEmpId());
		attributes.put("date", getDate());
		attributes.put("in1", getIn1());
		attributes.put("out1", getOut1());
		attributes.put("in2", getIn2());
		attributes.put("out2", getOut2());
		attributes.put("in3", getIn3());
		attributes.put("out3", getOut3());
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
		Long timeTrackingId = (Long)attributes.get("timeTrackingId");

		if (timeTrackingId != null) {
			setTimeTrackingId(timeTrackingId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Date in1 = (Date)attributes.get("in1");

		if (in1 != null) {
			setIn1(in1);
		}

		Date out1 = (Date)attributes.get("out1");

		if (out1 != null) {
			setOut1(out1);
		}

		Date in2 = (Date)attributes.get("in2");

		if (in2 != null) {
			setIn2(in2);
		}

		Date out2 = (Date)attributes.get("out2");

		if (out2 != null) {
			setOut2(out2);
		}

		Date in3 = (Date)attributes.get("in3");

		if (in3 != null) {
			setIn3(in3);
		}

		Date out3 = (Date)attributes.get("out3");

		if (out3 != null) {
			setOut3(out3);
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
	* Returns the primary key of this time tracking.
	*
	* @return the primary key of this time tracking
	*/
	@Override
	public long getPrimaryKey() {
		return _timeTracking.getPrimaryKey();
	}

	/**
	* Sets the primary key of this time tracking.
	*
	* @param primaryKey the primary key of this time tracking
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_timeTracking.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the time tracking ID of this time tracking.
	*
	* @return the time tracking ID of this time tracking
	*/
	@Override
	public long getTimeTrackingId() {
		return _timeTracking.getTimeTrackingId();
	}

	/**
	* Sets the time tracking ID of this time tracking.
	*
	* @param timeTrackingId the time tracking ID of this time tracking
	*/
	@Override
	public void setTimeTrackingId(long timeTrackingId) {
		_timeTracking.setTimeTrackingId(timeTrackingId);
	}

	/**
	* Returns the emp ID of this time tracking.
	*
	* @return the emp ID of this time tracking
	*/
	@Override
	public long getEmpId() {
		return _timeTracking.getEmpId();
	}

	/**
	* Sets the emp ID of this time tracking.
	*
	* @param empId the emp ID of this time tracking
	*/
	@Override
	public void setEmpId(long empId) {
		_timeTracking.setEmpId(empId);
	}

	/**
	* Returns the date of this time tracking.
	*
	* @return the date of this time tracking
	*/
	@Override
	public java.util.Date getDate() {
		return _timeTracking.getDate();
	}

	/**
	* Sets the date of this time tracking.
	*
	* @param date the date of this time tracking
	*/
	@Override
	public void setDate(java.util.Date date) {
		_timeTracking.setDate(date);
	}

	/**
	* Returns the in1 of this time tracking.
	*
	* @return the in1 of this time tracking
	*/
	@Override
	public java.util.Date getIn1() {
		return _timeTracking.getIn1();
	}

	/**
	* Sets the in1 of this time tracking.
	*
	* @param in1 the in1 of this time tracking
	*/
	@Override
	public void setIn1(java.util.Date in1) {
		_timeTracking.setIn1(in1);
	}

	/**
	* Returns the out1 of this time tracking.
	*
	* @return the out1 of this time tracking
	*/
	@Override
	public java.util.Date getOut1() {
		return _timeTracking.getOut1();
	}

	/**
	* Sets the out1 of this time tracking.
	*
	* @param out1 the out1 of this time tracking
	*/
	@Override
	public void setOut1(java.util.Date out1) {
		_timeTracking.setOut1(out1);
	}

	/**
	* Returns the in2 of this time tracking.
	*
	* @return the in2 of this time tracking
	*/
	@Override
	public java.util.Date getIn2() {
		return _timeTracking.getIn2();
	}

	/**
	* Sets the in2 of this time tracking.
	*
	* @param in2 the in2 of this time tracking
	*/
	@Override
	public void setIn2(java.util.Date in2) {
		_timeTracking.setIn2(in2);
	}

	/**
	* Returns the out2 of this time tracking.
	*
	* @return the out2 of this time tracking
	*/
	@Override
	public java.util.Date getOut2() {
		return _timeTracking.getOut2();
	}

	/**
	* Sets the out2 of this time tracking.
	*
	* @param out2 the out2 of this time tracking
	*/
	@Override
	public void setOut2(java.util.Date out2) {
		_timeTracking.setOut2(out2);
	}

	/**
	* Returns the in3 of this time tracking.
	*
	* @return the in3 of this time tracking
	*/
	@Override
	public java.util.Date getIn3() {
		return _timeTracking.getIn3();
	}

	/**
	* Sets the in3 of this time tracking.
	*
	* @param in3 the in3 of this time tracking
	*/
	@Override
	public void setIn3(java.util.Date in3) {
		_timeTracking.setIn3(in3);
	}

	/**
	* Returns the out3 of this time tracking.
	*
	* @return the out3 of this time tracking
	*/
	@Override
	public java.util.Date getOut3() {
		return _timeTracking.getOut3();
	}

	/**
	* Sets the out3 of this time tracking.
	*
	* @param out3 the out3 of this time tracking
	*/
	@Override
	public void setOut3(java.util.Date out3) {
		_timeTracking.setOut3(out3);
	}

	/**
	* Returns the group ID of this time tracking.
	*
	* @return the group ID of this time tracking
	*/
	@Override
	public long getGroupId() {
		return _timeTracking.getGroupId();
	}

	/**
	* Sets the group ID of this time tracking.
	*
	* @param groupId the group ID of this time tracking
	*/
	@Override
	public void setGroupId(long groupId) {
		_timeTracking.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this time tracking.
	*
	* @return the company ID of this time tracking
	*/
	@Override
	public long getCompanyId() {
		return _timeTracking.getCompanyId();
	}

	/**
	* Sets the company ID of this time tracking.
	*
	* @param companyId the company ID of this time tracking
	*/
	@Override
	public void setCompanyId(long companyId) {
		_timeTracking.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this time tracking.
	*
	* @return the user ID of this time tracking
	*/
	@Override
	public long getUserId() {
		return _timeTracking.getUserId();
	}

	/**
	* Sets the user ID of this time tracking.
	*
	* @param userId the user ID of this time tracking
	*/
	@Override
	public void setUserId(long userId) {
		_timeTracking.setUserId(userId);
	}

	/**
	* Returns the user uuid of this time tracking.
	*
	* @return the user uuid of this time tracking
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _timeTracking.getUserUuid();
	}

	/**
	* Sets the user uuid of this time tracking.
	*
	* @param userUuid the user uuid of this time tracking
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_timeTracking.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this time tracking.
	*
	* @return the user name of this time tracking
	*/
	@Override
	public java.lang.String getUserName() {
		return _timeTracking.getUserName();
	}

	/**
	* Sets the user name of this time tracking.
	*
	* @param userName the user name of this time tracking
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_timeTracking.setUserName(userName);
	}

	/**
	* Returns the create date of this time tracking.
	*
	* @return the create date of this time tracking
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _timeTracking.getCreateDate();
	}

	/**
	* Sets the create date of this time tracking.
	*
	* @param createDate the create date of this time tracking
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_timeTracking.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this time tracking.
	*
	* @return the modified date of this time tracking
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _timeTracking.getModifiedDate();
	}

	/**
	* Sets the modified date of this time tracking.
	*
	* @param modifiedDate the modified date of this time tracking
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_timeTracking.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _timeTracking.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_timeTracking.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _timeTracking.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_timeTracking.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _timeTracking.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _timeTracking.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_timeTracking.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _timeTracking.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_timeTracking.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_timeTracking.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_timeTracking.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TimeTrackingWrapper((TimeTracking)_timeTracking.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.tt.model.TimeTracking timeTracking) {
		return _timeTracking.compareTo(timeTracking);
	}

	@Override
	public int hashCode() {
		return _timeTracking.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.tt.model.TimeTracking> toCacheModel() {
		return _timeTracking.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking toEscapedModel() {
		return new TimeTrackingWrapper(_timeTracking.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.tt.model.TimeTracking toUnescapedModel() {
		return new TimeTrackingWrapper(_timeTracking.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _timeTracking.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _timeTracking.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_timeTracking.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TimeTrackingWrapper)) {
			return false;
		}

		TimeTrackingWrapper timeTrackingWrapper = (TimeTrackingWrapper)obj;

		if (Validator.equals(_timeTracking, timeTrackingWrapper._timeTracking)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TimeTracking getWrappedTimeTracking() {
		return _timeTracking;
	}

	@Override
	public TimeTracking getWrappedModel() {
		return _timeTracking;
	}

	@Override
	public void resetOriginalValues() {
		_timeTracking.resetOriginalValues();
	}

	private TimeTracking _timeTracking;
}