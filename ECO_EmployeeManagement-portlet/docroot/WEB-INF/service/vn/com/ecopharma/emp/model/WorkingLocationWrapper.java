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
 * This class is a wrapper for {@link WorkingLocation}.
 * </p>
 *
 * @author tvt
 * @see WorkingLocation
 * @generated
 */
public class WorkingLocationWrapper implements WorkingLocation,
	ModelWrapper<WorkingLocation> {
	public WorkingLocationWrapper(WorkingLocation workingLocation) {
		_workingLocation = workingLocation;
	}

	@Override
	public Class<?> getModelClass() {
		return WorkingLocation.class;
	}

	@Override
	public String getModelClassName() {
		return WorkingLocation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("workingLocationId", getWorkingLocationId());
		attributes.put("name", getName());
		attributes.put("locationId", getLocationId());
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
		Long workingLocationId = (Long)attributes.get("workingLocationId");

		if (workingLocationId != null) {
			setWorkingLocationId(workingLocationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
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
	* Returns the primary key of this working location.
	*
	* @return the primary key of this working location
	*/
	@Override
	public long getPrimaryKey() {
		return _workingLocation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this working location.
	*
	* @param primaryKey the primary key of this working location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_workingLocation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the working location ID of this working location.
	*
	* @return the working location ID of this working location
	*/
	@Override
	public long getWorkingLocationId() {
		return _workingLocation.getWorkingLocationId();
	}

	/**
	* Sets the working location ID of this working location.
	*
	* @param workingLocationId the working location ID of this working location
	*/
	@Override
	public void setWorkingLocationId(long workingLocationId) {
		_workingLocation.setWorkingLocationId(workingLocationId);
	}

	/**
	* Returns the name of this working location.
	*
	* @return the name of this working location
	*/
	@Override
	public java.lang.String getName() {
		return _workingLocation.getName();
	}

	/**
	* Sets the name of this working location.
	*
	* @param name the name of this working location
	*/
	@Override
	public void setName(java.lang.String name) {
		_workingLocation.setName(name);
	}

	/**
	* Returns the location ID of this working location.
	*
	* @return the location ID of this working location
	*/
	@Override
	public long getLocationId() {
		return _workingLocation.getLocationId();
	}

	/**
	* Sets the location ID of this working location.
	*
	* @param locationId the location ID of this working location
	*/
	@Override
	public void setLocationId(long locationId) {
		_workingLocation.setLocationId(locationId);
	}

	/**
	* Returns the group ID of this working location.
	*
	* @return the group ID of this working location
	*/
	@Override
	public long getGroupId() {
		return _workingLocation.getGroupId();
	}

	/**
	* Sets the group ID of this working location.
	*
	* @param groupId the group ID of this working location
	*/
	@Override
	public void setGroupId(long groupId) {
		_workingLocation.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this working location.
	*
	* @return the company ID of this working location
	*/
	@Override
	public long getCompanyId() {
		return _workingLocation.getCompanyId();
	}

	/**
	* Sets the company ID of this working location.
	*
	* @param companyId the company ID of this working location
	*/
	@Override
	public void setCompanyId(long companyId) {
		_workingLocation.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this working location.
	*
	* @return the user ID of this working location
	*/
	@Override
	public long getUserId() {
		return _workingLocation.getUserId();
	}

	/**
	* Sets the user ID of this working location.
	*
	* @param userId the user ID of this working location
	*/
	@Override
	public void setUserId(long userId) {
		_workingLocation.setUserId(userId);
	}

	/**
	* Returns the user uuid of this working location.
	*
	* @return the user uuid of this working location
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workingLocation.getUserUuid();
	}

	/**
	* Sets the user uuid of this working location.
	*
	* @param userUuid the user uuid of this working location
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_workingLocation.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this working location.
	*
	* @return the user name of this working location
	*/
	@Override
	public java.lang.String getUserName() {
		return _workingLocation.getUserName();
	}

	/**
	* Sets the user name of this working location.
	*
	* @param userName the user name of this working location
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_workingLocation.setUserName(userName);
	}

	/**
	* Returns the create date of this working location.
	*
	* @return the create date of this working location
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _workingLocation.getCreateDate();
	}

	/**
	* Sets the create date of this working location.
	*
	* @param createDate the create date of this working location
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_workingLocation.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this working location.
	*
	* @return the modified date of this working location
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _workingLocation.getModifiedDate();
	}

	/**
	* Sets the modified date of this working location.
	*
	* @param modifiedDate the modified date of this working location
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_workingLocation.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _workingLocation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_workingLocation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _workingLocation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_workingLocation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _workingLocation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _workingLocation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_workingLocation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _workingLocation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_workingLocation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_workingLocation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_workingLocation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new WorkingLocationWrapper((WorkingLocation)_workingLocation.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation) {
		return _workingLocation.compareTo(workingLocation);
	}

	@Override
	public int hashCode() {
		return _workingLocation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.WorkingLocation> toCacheModel() {
		return _workingLocation.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.WorkingLocation toEscapedModel() {
		return new WorkingLocationWrapper(_workingLocation.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.WorkingLocation toUnescapedModel() {
		return new WorkingLocationWrapper(_workingLocation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _workingLocation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _workingLocation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_workingLocation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof WorkingLocationWrapper)) {
			return false;
		}

		WorkingLocationWrapper workingLocationWrapper = (WorkingLocationWrapper)obj;

		if (Validator.equals(_workingLocation,
					workingLocationWrapper._workingLocation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public WorkingLocation getWrappedWorkingLocation() {
		return _workingLocation;
	}

	@Override
	public WorkingLocation getWrappedModel() {
		return _workingLocation;
	}

	@Override
	public void resetOriginalValues() {
		_workingLocation.resetOriginalValues();
	}

	private WorkingLocation _workingLocation;
}