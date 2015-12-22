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
 * This class is a wrapper for {@link Unit}.
 * </p>
 *
 * @author tvt
 * @see Unit
 * @generated
 */
public class UnitWrapper implements Unit, ModelWrapper<Unit> {
	public UnitWrapper(Unit unit) {
		_unit = unit;
	}

	@Override
	public Class<?> getModelClass() {
		return Unit.class;
	}

	@Override
	public String getModelClassName() {
		return Unit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("unitId", getUnitId());
		attributes.put("name", getName());
		attributes.put("departmentId", getDepartmentId());
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
		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
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
	* Returns the primary key of this unit.
	*
	* @return the primary key of this unit
	*/
	@Override
	public long getPrimaryKey() {
		return _unit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this unit.
	*
	* @param primaryKey the primary key of this unit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_unit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the unit ID of this unit.
	*
	* @return the unit ID of this unit
	*/
	@Override
	public long getUnitId() {
		return _unit.getUnitId();
	}

	/**
	* Sets the unit ID of this unit.
	*
	* @param unitId the unit ID of this unit
	*/
	@Override
	public void setUnitId(long unitId) {
		_unit.setUnitId(unitId);
	}

	/**
	* Returns the name of this unit.
	*
	* @return the name of this unit
	*/
	@Override
	public java.lang.String getName() {
		return _unit.getName();
	}

	/**
	* Sets the name of this unit.
	*
	* @param name the name of this unit
	*/
	@Override
	public void setName(java.lang.String name) {
		_unit.setName(name);
	}

	/**
	* Returns the department ID of this unit.
	*
	* @return the department ID of this unit
	*/
	@Override
	public long getDepartmentId() {
		return _unit.getDepartmentId();
	}

	/**
	* Sets the department ID of this unit.
	*
	* @param departmentId the department ID of this unit
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_unit.setDepartmentId(departmentId);
	}

	/**
	* Returns the group ID of this unit.
	*
	* @return the group ID of this unit
	*/
	@Override
	public long getGroupId() {
		return _unit.getGroupId();
	}

	/**
	* Sets the group ID of this unit.
	*
	* @param groupId the group ID of this unit
	*/
	@Override
	public void setGroupId(long groupId) {
		_unit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this unit.
	*
	* @return the company ID of this unit
	*/
	@Override
	public long getCompanyId() {
		return _unit.getCompanyId();
	}

	/**
	* Sets the company ID of this unit.
	*
	* @param companyId the company ID of this unit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_unit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this unit.
	*
	* @return the user ID of this unit
	*/
	@Override
	public long getUserId() {
		return _unit.getUserId();
	}

	/**
	* Sets the user ID of this unit.
	*
	* @param userId the user ID of this unit
	*/
	@Override
	public void setUserId(long userId) {
		_unit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this unit.
	*
	* @return the user uuid of this unit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _unit.getUserUuid();
	}

	/**
	* Sets the user uuid of this unit.
	*
	* @param userUuid the user uuid of this unit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_unit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this unit.
	*
	* @return the user name of this unit
	*/
	@Override
	public java.lang.String getUserName() {
		return _unit.getUserName();
	}

	/**
	* Sets the user name of this unit.
	*
	* @param userName the user name of this unit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_unit.setUserName(userName);
	}

	/**
	* Returns the create date of this unit.
	*
	* @return the create date of this unit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _unit.getCreateDate();
	}

	/**
	* Sets the create date of this unit.
	*
	* @param createDate the create date of this unit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_unit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this unit.
	*
	* @return the modified date of this unit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _unit.getModifiedDate();
	}

	/**
	* Sets the modified date of this unit.
	*
	* @param modifiedDate the modified date of this unit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_unit.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _unit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_unit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _unit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_unit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _unit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _unit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_unit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _unit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_unit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_unit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_unit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UnitWrapper((Unit)_unit.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Unit unit) {
		return _unit.compareTo(unit);
	}

	@Override
	public int hashCode() {
		return _unit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Unit> toCacheModel() {
		return _unit.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit toEscapedModel() {
		return new UnitWrapper(_unit.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Unit toUnescapedModel() {
		return new UnitWrapper(_unit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _unit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _unit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_unit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UnitWrapper)) {
			return false;
		}

		UnitWrapper unitWrapper = (UnitWrapper)obj;

		if (Validator.equals(_unit, unitWrapper._unit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Unit getWrappedUnit() {
		return _unit;
	}

	@Override
	public Unit getWrappedModel() {
		return _unit;
	}

	@Override
	public void resetOriginalValues() {
		_unit.resetOriginalValues();
	}

	private Unit _unit;
}