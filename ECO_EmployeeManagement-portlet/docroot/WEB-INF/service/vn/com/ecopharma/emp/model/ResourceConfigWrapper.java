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
 * This class is a wrapper for {@link ResourceConfig}.
 * </p>
 *
 * @author tvt
 * @see ResourceConfig
 * @generated
 */
public class ResourceConfigWrapper implements ResourceConfig,
	ModelWrapper<ResourceConfig> {
	public ResourceConfigWrapper(ResourceConfig resourceConfig) {
		_resourceConfig = resourceConfig;
	}

	@Override
	public Class<?> getModelClass() {
		return ResourceConfig.class;
	}

	@Override
	public String getModelClassName() {
		return ResourceConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("resourceConfigId", getResourceConfigId());
		attributes.put("key", getKey());
		attributes.put("value", getValue());
		attributes.put("type", getType());
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
		Long resourceConfigId = (Long)attributes.get("resourceConfigId");

		if (resourceConfigId != null) {
			setResourceConfigId(resourceConfigId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
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
	* Returns the primary key of this resource config.
	*
	* @return the primary key of this resource config
	*/
	@Override
	public long getPrimaryKey() {
		return _resourceConfig.getPrimaryKey();
	}

	/**
	* Sets the primary key of this resource config.
	*
	* @param primaryKey the primary key of this resource config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_resourceConfig.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the resource config ID of this resource config.
	*
	* @return the resource config ID of this resource config
	*/
	@Override
	public long getResourceConfigId() {
		return _resourceConfig.getResourceConfigId();
	}

	/**
	* Sets the resource config ID of this resource config.
	*
	* @param resourceConfigId the resource config ID of this resource config
	*/
	@Override
	public void setResourceConfigId(long resourceConfigId) {
		_resourceConfig.setResourceConfigId(resourceConfigId);
	}

	/**
	* Returns the key of this resource config.
	*
	* @return the key of this resource config
	*/
	@Override
	public java.lang.String getKey() {
		return _resourceConfig.getKey();
	}

	/**
	* Sets the key of this resource config.
	*
	* @param key the key of this resource config
	*/
	@Override
	public void setKey(java.lang.String key) {
		_resourceConfig.setKey(key);
	}

	/**
	* Returns the value of this resource config.
	*
	* @return the value of this resource config
	*/
	@Override
	public java.lang.String getValue() {
		return _resourceConfig.getValue();
	}

	/**
	* Sets the value of this resource config.
	*
	* @param value the value of this resource config
	*/
	@Override
	public void setValue(java.lang.String value) {
		_resourceConfig.setValue(value);
	}

	/**
	* Returns the type of this resource config.
	*
	* @return the type of this resource config
	*/
	@Override
	public java.lang.String getType() {
		return _resourceConfig.getType();
	}

	/**
	* Sets the type of this resource config.
	*
	* @param type the type of this resource config
	*/
	@Override
	public void setType(java.lang.String type) {
		_resourceConfig.setType(type);
	}

	/**
	* Returns the group ID of this resource config.
	*
	* @return the group ID of this resource config
	*/
	@Override
	public long getGroupId() {
		return _resourceConfig.getGroupId();
	}

	/**
	* Sets the group ID of this resource config.
	*
	* @param groupId the group ID of this resource config
	*/
	@Override
	public void setGroupId(long groupId) {
		_resourceConfig.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this resource config.
	*
	* @return the company ID of this resource config
	*/
	@Override
	public long getCompanyId() {
		return _resourceConfig.getCompanyId();
	}

	/**
	* Sets the company ID of this resource config.
	*
	* @param companyId the company ID of this resource config
	*/
	@Override
	public void setCompanyId(long companyId) {
		_resourceConfig.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this resource config.
	*
	* @return the user ID of this resource config
	*/
	@Override
	public long getUserId() {
		return _resourceConfig.getUserId();
	}

	/**
	* Sets the user ID of this resource config.
	*
	* @param userId the user ID of this resource config
	*/
	@Override
	public void setUserId(long userId) {
		_resourceConfig.setUserId(userId);
	}

	/**
	* Returns the user uuid of this resource config.
	*
	* @return the user uuid of this resource config
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resourceConfig.getUserUuid();
	}

	/**
	* Sets the user uuid of this resource config.
	*
	* @param userUuid the user uuid of this resource config
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_resourceConfig.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this resource config.
	*
	* @return the user name of this resource config
	*/
	@Override
	public java.lang.String getUserName() {
		return _resourceConfig.getUserName();
	}

	/**
	* Sets the user name of this resource config.
	*
	* @param userName the user name of this resource config
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_resourceConfig.setUserName(userName);
	}

	/**
	* Returns the create date of this resource config.
	*
	* @return the create date of this resource config
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _resourceConfig.getCreateDate();
	}

	/**
	* Sets the create date of this resource config.
	*
	* @param createDate the create date of this resource config
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_resourceConfig.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this resource config.
	*
	* @return the modified date of this resource config
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _resourceConfig.getModifiedDate();
	}

	/**
	* Sets the modified date of this resource config.
	*
	* @param modifiedDate the modified date of this resource config
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_resourceConfig.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _resourceConfig.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_resourceConfig.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _resourceConfig.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_resourceConfig.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _resourceConfig.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _resourceConfig.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_resourceConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resourceConfig.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_resourceConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_resourceConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resourceConfig.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResourceConfigWrapper((ResourceConfig)_resourceConfig.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.ResourceConfig resourceConfig) {
		return _resourceConfig.compareTo(resourceConfig);
	}

	@Override
	public int hashCode() {
		return _resourceConfig.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.ResourceConfig> toCacheModel() {
		return _resourceConfig.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig toEscapedModel() {
		return new ResourceConfigWrapper(_resourceConfig.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.ResourceConfig toUnescapedModel() {
		return new ResourceConfigWrapper(_resourceConfig.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _resourceConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _resourceConfig.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_resourceConfig.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResourceConfigWrapper)) {
			return false;
		}

		ResourceConfigWrapper resourceConfigWrapper = (ResourceConfigWrapper)obj;

		if (Validator.equals(_resourceConfig,
					resourceConfigWrapper._resourceConfig)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ResourceConfig getWrappedResourceConfig() {
		return _resourceConfig;
	}

	@Override
	public ResourceConfig getWrappedModel() {
		return _resourceConfig;
	}

	@Override
	public void resetOriginalValues() {
		_resourceConfig.resetOriginalValues();
	}

	private ResourceConfig _resourceConfig;
}