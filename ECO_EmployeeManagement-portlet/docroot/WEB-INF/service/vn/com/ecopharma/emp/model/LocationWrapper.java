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
 * This class is a wrapper for {@link Location}.
 * </p>
 *
 * @author tvt
 * @see Location
 * @generated
 */
public class LocationWrapper implements Location, ModelWrapper<Location> {
	public LocationWrapper(Location location) {
		_location = location;
	}

	@Override
	public Class<?> getModelClass() {
		return Location.class;
	}

	@Override
	public String getModelClassName() {
		return Location.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("locationId", getLocationId());
		attributes.put("name", getName());
		attributes.put("addressId", getAddressId());
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
		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
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
	* Returns the primary key of this location.
	*
	* @return the primary key of this location
	*/
	@Override
	public long getPrimaryKey() {
		return _location.getPrimaryKey();
	}

	/**
	* Sets the primary key of this location.
	*
	* @param primaryKey the primary key of this location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_location.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the location ID of this location.
	*
	* @return the location ID of this location
	*/
	@Override
	public long getLocationId() {
		return _location.getLocationId();
	}

	/**
	* Sets the location ID of this location.
	*
	* @param locationId the location ID of this location
	*/
	@Override
	public void setLocationId(long locationId) {
		_location.setLocationId(locationId);
	}

	/**
	* Returns the name of this location.
	*
	* @return the name of this location
	*/
	@Override
	public java.lang.String getName() {
		return _location.getName();
	}

	/**
	* Sets the name of this location.
	*
	* @param name the name of this location
	*/
	@Override
	public void setName(java.lang.String name) {
		_location.setName(name);
	}

	/**
	* Returns the address ID of this location.
	*
	* @return the address ID of this location
	*/
	@Override
	public long getAddressId() {
		return _location.getAddressId();
	}

	/**
	* Sets the address ID of this location.
	*
	* @param addressId the address ID of this location
	*/
	@Override
	public void setAddressId(long addressId) {
		_location.setAddressId(addressId);
	}

	/**
	* Returns the type of this location.
	*
	* @return the type of this location
	*/
	@Override
	public java.lang.String getType() {
		return _location.getType();
	}

	/**
	* Sets the type of this location.
	*
	* @param type the type of this location
	*/
	@Override
	public void setType(java.lang.String type) {
		_location.setType(type);
	}

	/**
	* Returns the group ID of this location.
	*
	* @return the group ID of this location
	*/
	@Override
	public long getGroupId() {
		return _location.getGroupId();
	}

	/**
	* Sets the group ID of this location.
	*
	* @param groupId the group ID of this location
	*/
	@Override
	public void setGroupId(long groupId) {
		_location.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this location.
	*
	* @return the company ID of this location
	*/
	@Override
	public long getCompanyId() {
		return _location.getCompanyId();
	}

	/**
	* Sets the company ID of this location.
	*
	* @param companyId the company ID of this location
	*/
	@Override
	public void setCompanyId(long companyId) {
		_location.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this location.
	*
	* @return the user ID of this location
	*/
	@Override
	public long getUserId() {
		return _location.getUserId();
	}

	/**
	* Sets the user ID of this location.
	*
	* @param userId the user ID of this location
	*/
	@Override
	public void setUserId(long userId) {
		_location.setUserId(userId);
	}

	/**
	* Returns the user uuid of this location.
	*
	* @return the user uuid of this location
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _location.getUserUuid();
	}

	/**
	* Sets the user uuid of this location.
	*
	* @param userUuid the user uuid of this location
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_location.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this location.
	*
	* @return the user name of this location
	*/
	@Override
	public java.lang.String getUserName() {
		return _location.getUserName();
	}

	/**
	* Sets the user name of this location.
	*
	* @param userName the user name of this location
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_location.setUserName(userName);
	}

	/**
	* Returns the create date of this location.
	*
	* @return the create date of this location
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _location.getCreateDate();
	}

	/**
	* Sets the create date of this location.
	*
	* @param createDate the create date of this location
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_location.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this location.
	*
	* @return the modified date of this location
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _location.getModifiedDate();
	}

	/**
	* Sets the modified date of this location.
	*
	* @param modifiedDate the modified date of this location
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_location.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _location.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_location.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _location.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_location.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _location.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _location.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_location.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _location.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_location.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_location.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_location.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LocationWrapper((Location)_location.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Location location) {
		return _location.compareTo(location);
	}

	@Override
	public int hashCode() {
		return _location.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Location> toCacheModel() {
		return _location.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Location toEscapedModel() {
		return new LocationWrapper(_location.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Location toUnescapedModel() {
		return new LocationWrapper(_location.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _location.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _location.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_location.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LocationWrapper)) {
			return false;
		}

		LocationWrapper locationWrapper = (LocationWrapper)obj;

		if (Validator.equals(_location, locationWrapper._location)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Location getWrappedLocation() {
		return _location;
	}

	@Override
	public Location getWrappedModel() {
		return _location;
	}

	@Override
	public void resetOriginalValues() {
		_location.resetOriginalValues();
	}

	private Location _location;
}