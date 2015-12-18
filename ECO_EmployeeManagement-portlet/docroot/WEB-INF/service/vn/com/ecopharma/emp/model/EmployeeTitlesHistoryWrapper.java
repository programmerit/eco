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
 * This class is a wrapper for {@link EmployeeTitlesHistory}.
 * </p>
 *
 * @author tvt
 * @see EmployeeTitlesHistory
 * @generated
 */
public class EmployeeTitlesHistoryWrapper implements EmployeeTitlesHistory,
	ModelWrapper<EmployeeTitlesHistory> {
	public EmployeeTitlesHistoryWrapper(
		EmployeeTitlesHistory employeeTitlesHistory) {
		_employeeTitlesHistory = employeeTitlesHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeTitlesHistory.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeTitlesHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeTitlesHistoryId", getEmployeeTitlesHistoryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("titlesId", getTitlesId());
		attributes.put("setDate", getSetDate());
		attributes.put("note", getNote());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeTitlesHistoryId = (Long)attributes.get(
				"employeeTitlesHistoryId");

		if (employeeTitlesHistoryId != null) {
			setEmployeeTitlesHistoryId(employeeTitlesHistoryId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Date setDate = (Date)attributes.get("setDate");

		if (setDate != null) {
			setSetDate(setDate);
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
	* Returns the primary key of this employee titles history.
	*
	* @return the primary key of this employee titles history
	*/
	@Override
	public long getPrimaryKey() {
		return _employeeTitlesHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this employee titles history.
	*
	* @param primaryKey the primary key of this employee titles history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employeeTitlesHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the employee titles history ID of this employee titles history.
	*
	* @return the employee titles history ID of this employee titles history
	*/
	@Override
	public long getEmployeeTitlesHistoryId() {
		return _employeeTitlesHistory.getEmployeeTitlesHistoryId();
	}

	/**
	* Sets the employee titles history ID of this employee titles history.
	*
	* @param employeeTitlesHistoryId the employee titles history ID of this employee titles history
	*/
	@Override
	public void setEmployeeTitlesHistoryId(long employeeTitlesHistoryId) {
		_employeeTitlesHistory.setEmployeeTitlesHistoryId(employeeTitlesHistoryId);
	}

	/**
	* Returns the employee ID of this employee titles history.
	*
	* @return the employee ID of this employee titles history
	*/
	@Override
	public long getEmployeeId() {
		return _employeeTitlesHistory.getEmployeeId();
	}

	/**
	* Sets the employee ID of this employee titles history.
	*
	* @param employeeId the employee ID of this employee titles history
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_employeeTitlesHistory.setEmployeeId(employeeId);
	}

	/**
	* Returns the titles ID of this employee titles history.
	*
	* @return the titles ID of this employee titles history
	*/
	@Override
	public long getTitlesId() {
		return _employeeTitlesHistory.getTitlesId();
	}

	/**
	* Sets the titles ID of this employee titles history.
	*
	* @param titlesId the titles ID of this employee titles history
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_employeeTitlesHistory.setTitlesId(titlesId);
	}

	/**
	* Returns the set date of this employee titles history.
	*
	* @return the set date of this employee titles history
	*/
	@Override
	public java.util.Date getSetDate() {
		return _employeeTitlesHistory.getSetDate();
	}

	/**
	* Sets the set date of this employee titles history.
	*
	* @param setDate the set date of this employee titles history
	*/
	@Override
	public void setSetDate(java.util.Date setDate) {
		_employeeTitlesHistory.setSetDate(setDate);
	}

	/**
	* Returns the note of this employee titles history.
	*
	* @return the note of this employee titles history
	*/
	@Override
	public java.lang.String getNote() {
		return _employeeTitlesHistory.getNote();
	}

	/**
	* Sets the note of this employee titles history.
	*
	* @param note the note of this employee titles history
	*/
	@Override
	public void setNote(java.lang.String note) {
		_employeeTitlesHistory.setNote(note);
	}

	/**
	* Returns the group ID of this employee titles history.
	*
	* @return the group ID of this employee titles history
	*/
	@Override
	public long getGroupId() {
		return _employeeTitlesHistory.getGroupId();
	}

	/**
	* Sets the group ID of this employee titles history.
	*
	* @param groupId the group ID of this employee titles history
	*/
	@Override
	public void setGroupId(long groupId) {
		_employeeTitlesHistory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this employee titles history.
	*
	* @return the company ID of this employee titles history
	*/
	@Override
	public long getCompanyId() {
		return _employeeTitlesHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this employee titles history.
	*
	* @param companyId the company ID of this employee titles history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_employeeTitlesHistory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this employee titles history.
	*
	* @return the user ID of this employee titles history
	*/
	@Override
	public long getUserId() {
		return _employeeTitlesHistory.getUserId();
	}

	/**
	* Sets the user ID of this employee titles history.
	*
	* @param userId the user ID of this employee titles history
	*/
	@Override
	public void setUserId(long userId) {
		_employeeTitlesHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this employee titles history.
	*
	* @return the user uuid of this employee titles history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _employeeTitlesHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this employee titles history.
	*
	* @param userUuid the user uuid of this employee titles history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_employeeTitlesHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this employee titles history.
	*
	* @return the create date of this employee titles history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _employeeTitlesHistory.getCreateDate();
	}

	/**
	* Sets the create date of this employee titles history.
	*
	* @param createDate the create date of this employee titles history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_employeeTitlesHistory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this employee titles history.
	*
	* @return the modified date of this employee titles history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _employeeTitlesHistory.getModifiedDate();
	}

	/**
	* Sets the modified date of this employee titles history.
	*
	* @param modifiedDate the modified date of this employee titles history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_employeeTitlesHistory.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _employeeTitlesHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_employeeTitlesHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _employeeTitlesHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employeeTitlesHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _employeeTitlesHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _employeeTitlesHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_employeeTitlesHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _employeeTitlesHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_employeeTitlesHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_employeeTitlesHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_employeeTitlesHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmployeeTitlesHistoryWrapper((EmployeeTitlesHistory)_employeeTitlesHistory.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmployeeTitlesHistory employeeTitlesHistory) {
		return _employeeTitlesHistory.compareTo(employeeTitlesHistory);
	}

	@Override
	public int hashCode() {
		return _employeeTitlesHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmployeeTitlesHistory> toCacheModel() {
		return _employeeTitlesHistory.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory toEscapedModel() {
		return new EmployeeTitlesHistoryWrapper(_employeeTitlesHistory.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmployeeTitlesHistory toUnescapedModel() {
		return new EmployeeTitlesHistoryWrapper(_employeeTitlesHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _employeeTitlesHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employeeTitlesHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_employeeTitlesHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployeeTitlesHistoryWrapper)) {
			return false;
		}

		EmployeeTitlesHistoryWrapper employeeTitlesHistoryWrapper = (EmployeeTitlesHistoryWrapper)obj;

		if (Validator.equals(_employeeTitlesHistory,
					employeeTitlesHistoryWrapper._employeeTitlesHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmployeeTitlesHistory getWrappedEmployeeTitlesHistory() {
		return _employeeTitlesHistory;
	}

	@Override
	public EmployeeTitlesHistory getWrappedModel() {
		return _employeeTitlesHistory;
	}

	@Override
	public void resetOriginalValues() {
		_employeeTitlesHistory.resetOriginalValues();
	}

	private EmployeeTitlesHistory _employeeTitlesHistory;
}