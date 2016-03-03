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

package vn.com.ecopharma.emp.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VacationLeave}.
 * </p>
 *
 * @author tvt
 * @see VacationLeave
 * @generated
 */
public class VacationLeaveWrapper implements VacationLeave,
	ModelWrapper<VacationLeave> {
	public VacationLeaveWrapper(VacationLeave vacationLeave) {
		_vacationLeave = vacationLeave;
	}

	@Override
	public Class<?> getModelClass() {
		return VacationLeave.class;
	}

	@Override
	public String getModelClassName() {
		return VacationLeave.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacationLeaveId", getVacationLeaveId());
		attributes.put("empId", getEmpId());
		attributes.put("leaveType", getLeaveType());
		attributes.put("sign", getSign());
		attributes.put("leaveFrom", getLeaveFrom());
		attributes.put("leaveTo", getLeaveTo());
		attributes.put("actualTo", getActualTo());
		attributes.put("numberOfHours", getNumberOfHours());
		attributes.put("reason", getReason());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacationLeaveId = (Long)attributes.get("vacationLeaveId");

		if (vacationLeaveId != null) {
			setVacationLeaveId(vacationLeaveId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String leaveType = (String)attributes.get("leaveType");

		if (leaveType != null) {
			setLeaveType(leaveType);
		}

		String sign = (String)attributes.get("sign");

		if (sign != null) {
			setSign(sign);
		}

		Date leaveFrom = (Date)attributes.get("leaveFrom");

		if (leaveFrom != null) {
			setLeaveFrom(leaveFrom);
		}

		Date leaveTo = (Date)attributes.get("leaveTo");

		if (leaveTo != null) {
			setLeaveTo(leaveTo);
		}

		Date actualTo = (Date)attributes.get("actualTo");

		if (actualTo != null) {
			setActualTo(actualTo);
		}

		Integer numberOfHours = (Integer)attributes.get("numberOfHours");

		if (numberOfHours != null) {
			setNumberOfHours(numberOfHours);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this vacation leave.
	*
	* @return the primary key of this vacation leave
	*/
	@Override
	public long getPrimaryKey() {
		return _vacationLeave.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vacation leave.
	*
	* @param primaryKey the primary key of this vacation leave
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vacationLeave.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vacation leave ID of this vacation leave.
	*
	* @return the vacation leave ID of this vacation leave
	*/
	@Override
	public long getVacationLeaveId() {
		return _vacationLeave.getVacationLeaveId();
	}

	/**
	* Sets the vacation leave ID of this vacation leave.
	*
	* @param vacationLeaveId the vacation leave ID of this vacation leave
	*/
	@Override
	public void setVacationLeaveId(long vacationLeaveId) {
		_vacationLeave.setVacationLeaveId(vacationLeaveId);
	}

	/**
	* Returns the emp ID of this vacation leave.
	*
	* @return the emp ID of this vacation leave
	*/
	@Override
	public long getEmpId() {
		return _vacationLeave.getEmpId();
	}

	/**
	* Sets the emp ID of this vacation leave.
	*
	* @param empId the emp ID of this vacation leave
	*/
	@Override
	public void setEmpId(long empId) {
		_vacationLeave.setEmpId(empId);
	}

	/**
	* Returns the leave type of this vacation leave.
	*
	* @return the leave type of this vacation leave
	*/
	@Override
	public java.lang.String getLeaveType() {
		return _vacationLeave.getLeaveType();
	}

	/**
	* Sets the leave type of this vacation leave.
	*
	* @param leaveType the leave type of this vacation leave
	*/
	@Override
	public void setLeaveType(java.lang.String leaveType) {
		_vacationLeave.setLeaveType(leaveType);
	}

	/**
	* Returns the sign of this vacation leave.
	*
	* @return the sign of this vacation leave
	*/
	@Override
	public java.lang.String getSign() {
		return _vacationLeave.getSign();
	}

	/**
	* Sets the sign of this vacation leave.
	*
	* @param sign the sign of this vacation leave
	*/
	@Override
	public void setSign(java.lang.String sign) {
		_vacationLeave.setSign(sign);
	}

	/**
	* Returns the leave from of this vacation leave.
	*
	* @return the leave from of this vacation leave
	*/
	@Override
	public java.util.Date getLeaveFrom() {
		return _vacationLeave.getLeaveFrom();
	}

	/**
	* Sets the leave from of this vacation leave.
	*
	* @param leaveFrom the leave from of this vacation leave
	*/
	@Override
	public void setLeaveFrom(java.util.Date leaveFrom) {
		_vacationLeave.setLeaveFrom(leaveFrom);
	}

	/**
	* Returns the leave to of this vacation leave.
	*
	* @return the leave to of this vacation leave
	*/
	@Override
	public java.util.Date getLeaveTo() {
		return _vacationLeave.getLeaveTo();
	}

	/**
	* Sets the leave to of this vacation leave.
	*
	* @param leaveTo the leave to of this vacation leave
	*/
	@Override
	public void setLeaveTo(java.util.Date leaveTo) {
		_vacationLeave.setLeaveTo(leaveTo);
	}

	/**
	* Returns the actual to of this vacation leave.
	*
	* @return the actual to of this vacation leave
	*/
	@Override
	public java.util.Date getActualTo() {
		return _vacationLeave.getActualTo();
	}

	/**
	* Sets the actual to of this vacation leave.
	*
	* @param actualTo the actual to of this vacation leave
	*/
	@Override
	public void setActualTo(java.util.Date actualTo) {
		_vacationLeave.setActualTo(actualTo);
	}

	/**
	* Returns the number of hours of this vacation leave.
	*
	* @return the number of hours of this vacation leave
	*/
	@Override
	public int getNumberOfHours() {
		return _vacationLeave.getNumberOfHours();
	}

	/**
	* Sets the number of hours of this vacation leave.
	*
	* @param numberOfHours the number of hours of this vacation leave
	*/
	@Override
	public void setNumberOfHours(int numberOfHours) {
		_vacationLeave.setNumberOfHours(numberOfHours);
	}

	/**
	* Returns the reason of this vacation leave.
	*
	* @return the reason of this vacation leave
	*/
	@Override
	public java.lang.String getReason() {
		return _vacationLeave.getReason();
	}

	/**
	* Sets the reason of this vacation leave.
	*
	* @param reason the reason of this vacation leave
	*/
	@Override
	public void setReason(java.lang.String reason) {
		_vacationLeave.setReason(reason);
	}

	/**
	* Returns the description of this vacation leave.
	*
	* @return the description of this vacation leave
	*/
	@Override
	public java.lang.String getDescription() {
		return _vacationLeave.getDescription();
	}

	/**
	* Sets the description of this vacation leave.
	*
	* @param description the description of this vacation leave
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_vacationLeave.setDescription(description);
	}

	/**
	* Returns the group ID of this vacation leave.
	*
	* @return the group ID of this vacation leave
	*/
	@Override
	public long getGroupId() {
		return _vacationLeave.getGroupId();
	}

	/**
	* Sets the group ID of this vacation leave.
	*
	* @param groupId the group ID of this vacation leave
	*/
	@Override
	public void setGroupId(long groupId) {
		_vacationLeave.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vacation leave.
	*
	* @return the company ID of this vacation leave
	*/
	@Override
	public long getCompanyId() {
		return _vacationLeave.getCompanyId();
	}

	/**
	* Sets the company ID of this vacation leave.
	*
	* @param companyId the company ID of this vacation leave
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vacationLeave.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vacation leave.
	*
	* @return the user ID of this vacation leave
	*/
	@Override
	public long getUserId() {
		return _vacationLeave.getUserId();
	}

	/**
	* Sets the user ID of this vacation leave.
	*
	* @param userId the user ID of this vacation leave
	*/
	@Override
	public void setUserId(long userId) {
		_vacationLeave.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vacation leave.
	*
	* @return the user uuid of this vacation leave
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacationLeave.getUserUuid();
	}

	/**
	* Sets the user uuid of this vacation leave.
	*
	* @param userUuid the user uuid of this vacation leave
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vacationLeave.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vacation leave.
	*
	* @return the user name of this vacation leave
	*/
	@Override
	public java.lang.String getUserName() {
		return _vacationLeave.getUserName();
	}

	/**
	* Sets the user name of this vacation leave.
	*
	* @param userName the user name of this vacation leave
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vacationLeave.setUserName(userName);
	}

	/**
	* Returns the create date of this vacation leave.
	*
	* @return the create date of this vacation leave
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vacationLeave.getCreateDate();
	}

	/**
	* Sets the create date of this vacation leave.
	*
	* @param createDate the create date of this vacation leave
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vacationLeave.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vacation leave.
	*
	* @return the modified date of this vacation leave
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vacationLeave.getModifiedDate();
	}

	/**
	* Sets the modified date of this vacation leave.
	*
	* @param modifiedDate the modified date of this vacation leave
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vacationLeave.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this vacation leave.
	*
	* @return the deleted of this vacation leave
	*/
	@Override
	public boolean getDeleted() {
		return _vacationLeave.getDeleted();
	}

	/**
	* Returns <code>true</code> if this vacation leave is deleted.
	*
	* @return <code>true</code> if this vacation leave is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _vacationLeave.isDeleted();
	}

	/**
	* Sets whether this vacation leave is deleted.
	*
	* @param deleted the deleted of this vacation leave
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_vacationLeave.setDeleted(deleted);
	}

	/**
	* Returns the status of this vacation leave.
	*
	* @return the status of this vacation leave
	*/
	@Override
	public java.lang.String getStatus() {
		return _vacationLeave.getStatus();
	}

	/**
	* Sets the status of this vacation leave.
	*
	* @param status the status of this vacation leave
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_vacationLeave.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _vacationLeave.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vacationLeave.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vacationLeave.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vacationLeave.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vacationLeave.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vacationLeave.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vacationLeave.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vacationLeave.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vacationLeave.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vacationLeave.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vacationLeave.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VacationLeaveWrapper((VacationLeave)_vacationLeave.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.VacationLeave vacationLeave) {
		return _vacationLeave.compareTo(vacationLeave);
	}

	@Override
	public int hashCode() {
		return _vacationLeave.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.VacationLeave> toCacheModel() {
		return _vacationLeave.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave toEscapedModel() {
		return new VacationLeaveWrapper(_vacationLeave.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.VacationLeave toUnescapedModel() {
		return new VacationLeaveWrapper(_vacationLeave.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vacationLeave.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vacationLeave.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vacationLeave.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacationLeaveWrapper)) {
			return false;
		}

		VacationLeaveWrapper vacationLeaveWrapper = (VacationLeaveWrapper)obj;

		if (Validator.equals(_vacationLeave, vacationLeaveWrapper._vacationLeave)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VacationLeave getWrappedVacationLeave() {
		return _vacationLeave;
	}

	@Override
	public VacationLeave getWrappedModel() {
		return _vacationLeave;
	}

	@Override
	public void resetOriginalValues() {
		_vacationLeave.resetOriginalValues();
	}

	private VacationLeave _vacationLeave;
}