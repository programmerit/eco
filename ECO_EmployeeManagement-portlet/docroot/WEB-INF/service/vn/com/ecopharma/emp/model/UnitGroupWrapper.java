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
 * This class is a wrapper for {@link UnitGroup}.
 * </p>
 *
 * @author tvt
 * @see UnitGroup
 * @generated
 */
public class UnitGroupWrapper implements UnitGroup, ModelWrapper<UnitGroup> {
	public UnitGroupWrapper(UnitGroup unitGroup) {
		_unitGroup = unitGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return UnitGroup.class;
	}

	@Override
	public String getModelClassName() {
		return UnitGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("unitGroupId", getUnitGroupId());
		attributes.put("name", getName());
		attributes.put("unitId", getUnitId());
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
		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
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
	* Returns the primary key of this unit group.
	*
	* @return the primary key of this unit group
	*/
	@Override
	public long getPrimaryKey() {
		return _unitGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this unit group.
	*
	* @param primaryKey the primary key of this unit group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_unitGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the unit group ID of this unit group.
	*
	* @return the unit group ID of this unit group
	*/
	@Override
	public long getUnitGroupId() {
		return _unitGroup.getUnitGroupId();
	}

	/**
	* Sets the unit group ID of this unit group.
	*
	* @param unitGroupId the unit group ID of this unit group
	*/
	@Override
	public void setUnitGroupId(long unitGroupId) {
		_unitGroup.setUnitGroupId(unitGroupId);
	}

	/**
	* Returns the name of this unit group.
	*
	* @return the name of this unit group
	*/
	@Override
	public java.lang.String getName() {
		return _unitGroup.getName();
	}

	/**
	* Sets the name of this unit group.
	*
	* @param name the name of this unit group
	*/
	@Override
	public void setName(java.lang.String name) {
		_unitGroup.setName(name);
	}

	/**
	* Returns the unit ID of this unit group.
	*
	* @return the unit ID of this unit group
	*/
	@Override
	public long getUnitId() {
		return _unitGroup.getUnitId();
	}

	/**
	* Sets the unit ID of this unit group.
	*
	* @param unitId the unit ID of this unit group
	*/
	@Override
	public void setUnitId(long unitId) {
		_unitGroup.setUnitId(unitId);
	}

	/**
	* Returns the group ID of this unit group.
	*
	* @return the group ID of this unit group
	*/
	@Override
	public long getGroupId() {
		return _unitGroup.getGroupId();
	}

	/**
	* Sets the group ID of this unit group.
	*
	* @param groupId the group ID of this unit group
	*/
	@Override
	public void setGroupId(long groupId) {
		_unitGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this unit group.
	*
	* @return the company ID of this unit group
	*/
	@Override
	public long getCompanyId() {
		return _unitGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this unit group.
	*
	* @param companyId the company ID of this unit group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_unitGroup.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this unit group.
	*
	* @return the user ID of this unit group
	*/
	@Override
	public long getUserId() {
		return _unitGroup.getUserId();
	}

	/**
	* Sets the user ID of this unit group.
	*
	* @param userId the user ID of this unit group
	*/
	@Override
	public void setUserId(long userId) {
		_unitGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this unit group.
	*
	* @return the user uuid of this unit group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unitGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this unit group.
	*
	* @param userUuid the user uuid of this unit group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_unitGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this unit group.
	*
	* @return the user name of this unit group
	*/
	@Override
	public java.lang.String getUserName() {
		return _unitGroup.getUserName();
	}

	/**
	* Sets the user name of this unit group.
	*
	* @param userName the user name of this unit group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_unitGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this unit group.
	*
	* @return the create date of this unit group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _unitGroup.getCreateDate();
	}

	/**
	* Sets the create date of this unit group.
	*
	* @param createDate the create date of this unit group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_unitGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this unit group.
	*
	* @return the modified date of this unit group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _unitGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this unit group.
	*
	* @param modifiedDate the modified date of this unit group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_unitGroup.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _unitGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_unitGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _unitGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_unitGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _unitGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _unitGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_unitGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _unitGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_unitGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_unitGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_unitGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UnitGroupWrapper((UnitGroup)_unitGroup.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.UnitGroup unitGroup) {
		return _unitGroup.compareTo(unitGroup);
	}

	@Override
	public int hashCode() {
		return _unitGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.UnitGroup> toCacheModel() {
		return _unitGroup.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup toEscapedModel() {
		return new UnitGroupWrapper(_unitGroup.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.UnitGroup toUnescapedModel() {
		return new UnitGroupWrapper(_unitGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _unitGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _unitGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_unitGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UnitGroupWrapper)) {
			return false;
		}

		UnitGroupWrapper unitGroupWrapper = (UnitGroupWrapper)obj;

		if (Validator.equals(_unitGroup, unitGroupWrapper._unitGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UnitGroup getWrappedUnitGroup() {
		return _unitGroup;
	}

	@Override
	public UnitGroup getWrappedModel() {
		return _unitGroup;
	}

	@Override
	public void resetOriginalValues() {
		_unitGroup.resetOriginalValues();
	}

	private UnitGroup _unitGroup;
}