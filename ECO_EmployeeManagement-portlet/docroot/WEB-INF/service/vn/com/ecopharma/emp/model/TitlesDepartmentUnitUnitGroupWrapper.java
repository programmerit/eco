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
 * This class is a wrapper for {@link TitlesDepartmentUnitUnitGroup}.
 * </p>
 *
 * @author tvt
 * @see TitlesDepartmentUnitUnitGroup
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupWrapper
	implements TitlesDepartmentUnitUnitGroup,
		ModelWrapper<TitlesDepartmentUnitUnitGroup> {
	public TitlesDepartmentUnitUnitGroupWrapper(
		TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		_titlesDepartmentUnitUnitGroup = titlesDepartmentUnitUnitGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return TitlesDepartmentUnitUnitGroup.class;
	}

	@Override
	public String getModelClassName() {
		return TitlesDepartmentUnitUnitGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("titlesDepartmentUnitUnitGroupId",
			getTitlesDepartmentUnitUnitGroupId());
		attributes.put("titlesId", getTitlesId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("unitId", getUnitId());
		attributes.put("unitGroupId", getUnitGroupId());
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
		Long titlesDepartmentUnitUnitGroupId = (Long)attributes.get(
				"titlesDepartmentUnitUnitGroupId");

		if (titlesDepartmentUnitUnitGroupId != null) {
			setTitlesDepartmentUnitUnitGroupId(titlesDepartmentUnitUnitGroupId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
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
	* Returns the primary key of this titles department unit unit group.
	*
	* @return the primary key of this titles department unit unit group
	*/
	@Override
	public long getPrimaryKey() {
		return _titlesDepartmentUnitUnitGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this titles department unit unit group.
	*
	* @param primaryKey the primary key of this titles department unit unit group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_titlesDepartmentUnitUnitGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the titles department unit unit group ID of this titles department unit unit group.
	*
	* @return the titles department unit unit group ID of this titles department unit unit group
	*/
	@Override
	public long getTitlesDepartmentUnitUnitGroupId() {
		return _titlesDepartmentUnitUnitGroup.getTitlesDepartmentUnitUnitGroupId();
	}

	/**
	* Sets the titles department unit unit group ID of this titles department unit unit group.
	*
	* @param titlesDepartmentUnitUnitGroupId the titles department unit unit group ID of this titles department unit unit group
	*/
	@Override
	public void setTitlesDepartmentUnitUnitGroupId(
		long titlesDepartmentUnitUnitGroupId) {
		_titlesDepartmentUnitUnitGroup.setTitlesDepartmentUnitUnitGroupId(titlesDepartmentUnitUnitGroupId);
	}

	/**
	* Returns the titles ID of this titles department unit unit group.
	*
	* @return the titles ID of this titles department unit unit group
	*/
	@Override
	public long getTitlesId() {
		return _titlesDepartmentUnitUnitGroup.getTitlesId();
	}

	/**
	* Sets the titles ID of this titles department unit unit group.
	*
	* @param titlesId the titles ID of this titles department unit unit group
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_titlesDepartmentUnitUnitGroup.setTitlesId(titlesId);
	}

	/**
	* Returns the department ID of this titles department unit unit group.
	*
	* @return the department ID of this titles department unit unit group
	*/
	@Override
	public long getDepartmentId() {
		return _titlesDepartmentUnitUnitGroup.getDepartmentId();
	}

	/**
	* Sets the department ID of this titles department unit unit group.
	*
	* @param departmentId the department ID of this titles department unit unit group
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_titlesDepartmentUnitUnitGroup.setDepartmentId(departmentId);
	}

	/**
	* Returns the unit ID of this titles department unit unit group.
	*
	* @return the unit ID of this titles department unit unit group
	*/
	@Override
	public long getUnitId() {
		return _titlesDepartmentUnitUnitGroup.getUnitId();
	}

	/**
	* Sets the unit ID of this titles department unit unit group.
	*
	* @param unitId the unit ID of this titles department unit unit group
	*/
	@Override
	public void setUnitId(long unitId) {
		_titlesDepartmentUnitUnitGroup.setUnitId(unitId);
	}

	/**
	* Returns the unit group ID of this titles department unit unit group.
	*
	* @return the unit group ID of this titles department unit unit group
	*/
	@Override
	public long getUnitGroupId() {
		return _titlesDepartmentUnitUnitGroup.getUnitGroupId();
	}

	/**
	* Sets the unit group ID of this titles department unit unit group.
	*
	* @param unitGroupId the unit group ID of this titles department unit unit group
	*/
	@Override
	public void setUnitGroupId(long unitGroupId) {
		_titlesDepartmentUnitUnitGroup.setUnitGroupId(unitGroupId);
	}

	/**
	* Returns the group ID of this titles department unit unit group.
	*
	* @return the group ID of this titles department unit unit group
	*/
	@Override
	public long getGroupId() {
		return _titlesDepartmentUnitUnitGroup.getGroupId();
	}

	/**
	* Sets the group ID of this titles department unit unit group.
	*
	* @param groupId the group ID of this titles department unit unit group
	*/
	@Override
	public void setGroupId(long groupId) {
		_titlesDepartmentUnitUnitGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this titles department unit unit group.
	*
	* @return the company ID of this titles department unit unit group
	*/
	@Override
	public long getCompanyId() {
		return _titlesDepartmentUnitUnitGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this titles department unit unit group.
	*
	* @param companyId the company ID of this titles department unit unit group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_titlesDepartmentUnitUnitGroup.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this titles department unit unit group.
	*
	* @return the user ID of this titles department unit unit group
	*/
	@Override
	public long getUserId() {
		return _titlesDepartmentUnitUnitGroup.getUserId();
	}

	/**
	* Sets the user ID of this titles department unit unit group.
	*
	* @param userId the user ID of this titles department unit unit group
	*/
	@Override
	public void setUserId(long userId) {
		_titlesDepartmentUnitUnitGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this titles department unit unit group.
	*
	* @return the user uuid of this titles department unit unit group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesDepartmentUnitUnitGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this titles department unit unit group.
	*
	* @param userUuid the user uuid of this titles department unit unit group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_titlesDepartmentUnitUnitGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this titles department unit unit group.
	*
	* @return the user name of this titles department unit unit group
	*/
	@Override
	public java.lang.String getUserName() {
		return _titlesDepartmentUnitUnitGroup.getUserName();
	}

	/**
	* Sets the user name of this titles department unit unit group.
	*
	* @param userName the user name of this titles department unit unit group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_titlesDepartmentUnitUnitGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this titles department unit unit group.
	*
	* @return the create date of this titles department unit unit group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _titlesDepartmentUnitUnitGroup.getCreateDate();
	}

	/**
	* Sets the create date of this titles department unit unit group.
	*
	* @param createDate the create date of this titles department unit unit group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_titlesDepartmentUnitUnitGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this titles department unit unit group.
	*
	* @return the modified date of this titles department unit unit group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _titlesDepartmentUnitUnitGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this titles department unit unit group.
	*
	* @param modifiedDate the modified date of this titles department unit unit group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_titlesDepartmentUnitUnitGroup.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _titlesDepartmentUnitUnitGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_titlesDepartmentUnitUnitGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _titlesDepartmentUnitUnitGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_titlesDepartmentUnitUnitGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _titlesDepartmentUnitUnitGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _titlesDepartmentUnitUnitGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_titlesDepartmentUnitUnitGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _titlesDepartmentUnitUnitGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_titlesDepartmentUnitUnitGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_titlesDepartmentUnitUnitGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_titlesDepartmentUnitUnitGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TitlesDepartmentUnitUnitGroupWrapper((TitlesDepartmentUnitUnitGroup)_titlesDepartmentUnitUnitGroup.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup titlesDepartmentUnitUnitGroup) {
		return _titlesDepartmentUnitUnitGroup.compareTo(titlesDepartmentUnitUnitGroup);
	}

	@Override
	public int hashCode() {
		return _titlesDepartmentUnitUnitGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup> toCacheModel() {
		return _titlesDepartmentUnitUnitGroup.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup toEscapedModel() {
		return new TitlesDepartmentUnitUnitGroupWrapper(_titlesDepartmentUnitUnitGroup.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup toUnescapedModel() {
		return new TitlesDepartmentUnitUnitGroupWrapper(_titlesDepartmentUnitUnitGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _titlesDepartmentUnitUnitGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _titlesDepartmentUnitUnitGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_titlesDepartmentUnitUnitGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TitlesDepartmentUnitUnitGroupWrapper)) {
			return false;
		}

		TitlesDepartmentUnitUnitGroupWrapper titlesDepartmentUnitUnitGroupWrapper =
			(TitlesDepartmentUnitUnitGroupWrapper)obj;

		if (Validator.equals(_titlesDepartmentUnitUnitGroup,
					titlesDepartmentUnitUnitGroupWrapper._titlesDepartmentUnitUnitGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TitlesDepartmentUnitUnitGroup getWrappedTitlesDepartmentUnitUnitGroup() {
		return _titlesDepartmentUnitUnitGroup;
	}

	@Override
	public TitlesDepartmentUnitUnitGroup getWrappedModel() {
		return _titlesDepartmentUnitUnitGroup;
	}

	@Override
	public void resetOriginalValues() {
		_titlesDepartmentUnitUnitGroup.resetOriginalValues();
	}

	private TitlesDepartmentUnitUnitGroup _titlesDepartmentUnitUnitGroup;
}