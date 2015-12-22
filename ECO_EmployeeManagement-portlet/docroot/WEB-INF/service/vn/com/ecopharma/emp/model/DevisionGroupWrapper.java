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
 * This class is a wrapper for {@link DevisionGroup}.
 * </p>
 *
 * @author tvt
 * @see DevisionGroup
 * @generated
 */
public class DevisionGroupWrapper implements DevisionGroup,
	ModelWrapper<DevisionGroup> {
	public DevisionGroupWrapper(DevisionGroup devisionGroup) {
		_devisionGroup = devisionGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return DevisionGroup.class;
	}

	@Override
	public String getModelClassName() {
		return DevisionGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("devisionGroupId", getDevisionGroupId());
		attributes.put("name", getName());
		attributes.put("devisionId", getDevisionId());
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
		Long devisionGroupId = (Long)attributes.get("devisionGroupId");

		if (devisionGroupId != null) {
			setDevisionGroupId(devisionGroupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long devisionId = (Long)attributes.get("devisionId");

		if (devisionId != null) {
			setDevisionId(devisionId);
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
	* Returns the primary key of this devision group.
	*
	* @return the primary key of this devision group
	*/
	@Override
	public long getPrimaryKey() {
		return _devisionGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this devision group.
	*
	* @param primaryKey the primary key of this devision group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_devisionGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the devision group ID of this devision group.
	*
	* @return the devision group ID of this devision group
	*/
	@Override
	public long getDevisionGroupId() {
		return _devisionGroup.getDevisionGroupId();
	}

	/**
	* Sets the devision group ID of this devision group.
	*
	* @param devisionGroupId the devision group ID of this devision group
	*/
	@Override
	public void setDevisionGroupId(long devisionGroupId) {
		_devisionGroup.setDevisionGroupId(devisionGroupId);
	}

	/**
	* Returns the name of this devision group.
	*
	* @return the name of this devision group
	*/
	@Override
	public java.lang.String getName() {
		return _devisionGroup.getName();
	}

	/**
	* Sets the name of this devision group.
	*
	* @param name the name of this devision group
	*/
	@Override
	public void setName(java.lang.String name) {
		_devisionGroup.setName(name);
	}

	/**
	* Returns the devision ID of this devision group.
	*
	* @return the devision ID of this devision group
	*/
	@Override
	public long getDevisionId() {
		return _devisionGroup.getDevisionId();
	}

	/**
	* Sets the devision ID of this devision group.
	*
	* @param devisionId the devision ID of this devision group
	*/
	@Override
	public void setDevisionId(long devisionId) {
		_devisionGroup.setDevisionId(devisionId);
	}

	/**
	* Returns the group ID of this devision group.
	*
	* @return the group ID of this devision group
	*/
	@Override
	public long getGroupId() {
		return _devisionGroup.getGroupId();
	}

	/**
	* Sets the group ID of this devision group.
	*
	* @param groupId the group ID of this devision group
	*/
	@Override
	public void setGroupId(long groupId) {
		_devisionGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this devision group.
	*
	* @return the company ID of this devision group
	*/
	@Override
	public long getCompanyId() {
		return _devisionGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this devision group.
	*
	* @param companyId the company ID of this devision group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_devisionGroup.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this devision group.
	*
	* @return the user ID of this devision group
	*/
	@Override
	public long getUserId() {
		return _devisionGroup.getUserId();
	}

	/**
	* Sets the user ID of this devision group.
	*
	* @param userId the user ID of this devision group
	*/
	@Override
	public void setUserId(long userId) {
		_devisionGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this devision group.
	*
	* @return the user uuid of this devision group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devisionGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this devision group.
	*
	* @param userUuid the user uuid of this devision group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_devisionGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this devision group.
	*
	* @return the user name of this devision group
	*/
	@Override
	public java.lang.String getUserName() {
		return _devisionGroup.getUserName();
	}

	/**
	* Sets the user name of this devision group.
	*
	* @param userName the user name of this devision group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_devisionGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this devision group.
	*
	* @return the create date of this devision group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _devisionGroup.getCreateDate();
	}

	/**
	* Sets the create date of this devision group.
	*
	* @param createDate the create date of this devision group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_devisionGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this devision group.
	*
	* @return the modified date of this devision group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _devisionGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this devision group.
	*
	* @param modifiedDate the modified date of this devision group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_devisionGroup.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _devisionGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_devisionGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _devisionGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_devisionGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _devisionGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _devisionGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_devisionGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _devisionGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_devisionGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_devisionGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_devisionGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DevisionGroupWrapper((DevisionGroup)_devisionGroup.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.DevisionGroup devisionGroup) {
		return _devisionGroup.compareTo(devisionGroup);
	}

	@Override
	public int hashCode() {
		return _devisionGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.DevisionGroup> toCacheModel() {
		return _devisionGroup.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup toEscapedModel() {
		return new DevisionGroupWrapper(_devisionGroup.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.DevisionGroup toUnescapedModel() {
		return new DevisionGroupWrapper(_devisionGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _devisionGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _devisionGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_devisionGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DevisionGroupWrapper)) {
			return false;
		}

		DevisionGroupWrapper devisionGroupWrapper = (DevisionGroupWrapper)obj;

		if (Validator.equals(_devisionGroup, devisionGroupWrapper._devisionGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DevisionGroup getWrappedDevisionGroup() {
		return _devisionGroup;
	}

	@Override
	public DevisionGroup getWrappedModel() {
		return _devisionGroup;
	}

	@Override
	public void resetOriginalValues() {
		_devisionGroup.resetOriginalValues();
	}

	private DevisionGroup _devisionGroup;
}