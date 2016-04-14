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
 * This class is a wrapper for {@link EmpActionHistory}.
 * </p>
 *
 * @author tvt
 * @see EmpActionHistory
 * @generated
 */
public class EmpActionHistoryWrapper implements EmpActionHistory,
	ModelWrapper<EmpActionHistory> {
	public EmpActionHistoryWrapper(EmpActionHistory empActionHistory) {
		_empActionHistory = empActionHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpActionHistory.class;
	}

	@Override
	public String getModelClassName() {
		return EmpActionHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empActionHistoryId", getEmpActionHistoryId());
		attributes.put("empId", getEmpId());
		attributes.put("action", getAction());
		attributes.put("performedBy", getPerformedBy());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("refId", getRefId());
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
		Long empActionHistoryId = (Long)attributes.get("empActionHistoryId");

		if (empActionHistoryId != null) {
			setEmpActionHistoryId(empActionHistoryId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Long performedBy = (Long)attributes.get("performedBy");

		if (performedBy != null) {
			setPerformedBy(performedBy);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long refId = (Long)attributes.get("refId");

		if (refId != null) {
			setRefId(refId);
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
	* Returns the primary key of this emp action history.
	*
	* @return the primary key of this emp action history
	*/
	@Override
	public long getPrimaryKey() {
		return _empActionHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp action history.
	*
	* @param primaryKey the primary key of this emp action history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empActionHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp action history ID of this emp action history.
	*
	* @return the emp action history ID of this emp action history
	*/
	@Override
	public long getEmpActionHistoryId() {
		return _empActionHistory.getEmpActionHistoryId();
	}

	/**
	* Sets the emp action history ID of this emp action history.
	*
	* @param empActionHistoryId the emp action history ID of this emp action history
	*/
	@Override
	public void setEmpActionHistoryId(long empActionHistoryId) {
		_empActionHistory.setEmpActionHistoryId(empActionHistoryId);
	}

	/**
	* Returns the emp ID of this emp action history.
	*
	* @return the emp ID of this emp action history
	*/
	@Override
	public long getEmpId() {
		return _empActionHistory.getEmpId();
	}

	/**
	* Sets the emp ID of this emp action history.
	*
	* @param empId the emp ID of this emp action history
	*/
	@Override
	public void setEmpId(long empId) {
		_empActionHistory.setEmpId(empId);
	}

	/**
	* Returns the action of this emp action history.
	*
	* @return the action of this emp action history
	*/
	@Override
	public java.lang.String getAction() {
		return _empActionHistory.getAction();
	}

	/**
	* Sets the action of this emp action history.
	*
	* @param action the action of this emp action history
	*/
	@Override
	public void setAction(java.lang.String action) {
		_empActionHistory.setAction(action);
	}

	/**
	* Returns the performed by of this emp action history.
	*
	* @return the performed by of this emp action history
	*/
	@Override
	public long getPerformedBy() {
		return _empActionHistory.getPerformedBy();
	}

	/**
	* Sets the performed by of this emp action history.
	*
	* @param performedBy the performed by of this emp action history
	*/
	@Override
	public void setPerformedBy(long performedBy) {
		_empActionHistory.setPerformedBy(performedBy);
	}

	/**
	* Returns the description of this emp action history.
	*
	* @return the description of this emp action history
	*/
	@Override
	public java.lang.String getDescription() {
		return _empActionHistory.getDescription();
	}

	/**
	* Sets the description of this emp action history.
	*
	* @param description the description of this emp action history
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_empActionHistory.setDescription(description);
	}

	/**
	* Returns the status of this emp action history.
	*
	* @return the status of this emp action history
	*/
	@Override
	public java.lang.String getStatus() {
		return _empActionHistory.getStatus();
	}

	/**
	* Sets the status of this emp action history.
	*
	* @param status the status of this emp action history
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_empActionHistory.setStatus(status);
	}

	/**
	* Returns the ref ID of this emp action history.
	*
	* @return the ref ID of this emp action history
	*/
	@Override
	public long getRefId() {
		return _empActionHistory.getRefId();
	}

	/**
	* Sets the ref ID of this emp action history.
	*
	* @param refId the ref ID of this emp action history
	*/
	@Override
	public void setRefId(long refId) {
		_empActionHistory.setRefId(refId);
	}

	/**
	* Returns the group ID of this emp action history.
	*
	* @return the group ID of this emp action history
	*/
	@Override
	public long getGroupId() {
		return _empActionHistory.getGroupId();
	}

	/**
	* Sets the group ID of this emp action history.
	*
	* @param groupId the group ID of this emp action history
	*/
	@Override
	public void setGroupId(long groupId) {
		_empActionHistory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp action history.
	*
	* @return the company ID of this emp action history
	*/
	@Override
	public long getCompanyId() {
		return _empActionHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this emp action history.
	*
	* @param companyId the company ID of this emp action history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empActionHistory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp action history.
	*
	* @return the user ID of this emp action history
	*/
	@Override
	public long getUserId() {
		return _empActionHistory.getUserId();
	}

	/**
	* Sets the user ID of this emp action history.
	*
	* @param userId the user ID of this emp action history
	*/
	@Override
	public void setUserId(long userId) {
		_empActionHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp action history.
	*
	* @return the user uuid of this emp action history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empActionHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp action history.
	*
	* @param userUuid the user uuid of this emp action history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empActionHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp action history.
	*
	* @return the user name of this emp action history
	*/
	@Override
	public java.lang.String getUserName() {
		return _empActionHistory.getUserName();
	}

	/**
	* Sets the user name of this emp action history.
	*
	* @param userName the user name of this emp action history
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empActionHistory.setUserName(userName);
	}

	/**
	* Returns the create date of this emp action history.
	*
	* @return the create date of this emp action history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empActionHistory.getCreateDate();
	}

	/**
	* Sets the create date of this emp action history.
	*
	* @param createDate the create date of this emp action history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empActionHistory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp action history.
	*
	* @return the modified date of this emp action history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empActionHistory.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp action history.
	*
	* @param modifiedDate the modified date of this emp action history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empActionHistory.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empActionHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empActionHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empActionHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empActionHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empActionHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empActionHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empActionHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empActionHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empActionHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empActionHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empActionHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpActionHistoryWrapper((EmpActionHistory)_empActionHistory.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmpActionHistory empActionHistory) {
		return _empActionHistory.compareTo(empActionHistory);
	}

	@Override
	public int hashCode() {
		return _empActionHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpActionHistory> toCacheModel() {
		return _empActionHistory.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory toEscapedModel() {
		return new EmpActionHistoryWrapper(_empActionHistory.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpActionHistory toUnescapedModel() {
		return new EmpActionHistoryWrapper(_empActionHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empActionHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empActionHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empActionHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpActionHistoryWrapper)) {
			return false;
		}

		EmpActionHistoryWrapper empActionHistoryWrapper = (EmpActionHistoryWrapper)obj;

		if (Validator.equals(_empActionHistory,
					empActionHistoryWrapper._empActionHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpActionHistory getWrappedEmpActionHistory() {
		return _empActionHistory;
	}

	@Override
	public EmpActionHistory getWrappedModel() {
		return _empActionHistory;
	}

	@Override
	public void resetOriginalValues() {
		_empActionHistory.resetOriginalValues();
	}

	private EmpActionHistory _empActionHistory;
}