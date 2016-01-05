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
 * This class is a wrapper for {@link TitlesUnitUnitGroup}.
 * </p>
 *
 * @author tvt
 * @see TitlesUnitUnitGroup
 * @generated
 */
public class TitlesUnitUnitGroupWrapper implements TitlesUnitUnitGroup,
	ModelWrapper<TitlesUnitUnitGroup> {
	public TitlesUnitUnitGroupWrapper(TitlesUnitUnitGroup titlesUnitUnitGroup) {
		_titlesUnitUnitGroup = titlesUnitUnitGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return TitlesUnitUnitGroup.class;
	}

	@Override
	public String getModelClassName() {
		return TitlesUnitUnitGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("titlesUnitUnitGroupId", getTitlesUnitUnitGroupId());
		attributes.put("titlesId", getTitlesId());
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
		Long titlesUnitUnitGroupId = (Long)attributes.get(
				"titlesUnitUnitGroupId");

		if (titlesUnitUnitGroupId != null) {
			setTitlesUnitUnitGroupId(titlesUnitUnitGroupId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
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
	* Returns the primary key of this titles unit unit group.
	*
	* @return the primary key of this titles unit unit group
	*/
	@Override
	public long getPrimaryKey() {
		return _titlesUnitUnitGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this titles unit unit group.
	*
	* @param primaryKey the primary key of this titles unit unit group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_titlesUnitUnitGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the titles unit unit group ID of this titles unit unit group.
	*
	* @return the titles unit unit group ID of this titles unit unit group
	*/
	@Override
	public long getTitlesUnitUnitGroupId() {
		return _titlesUnitUnitGroup.getTitlesUnitUnitGroupId();
	}

	/**
	* Sets the titles unit unit group ID of this titles unit unit group.
	*
	* @param titlesUnitUnitGroupId the titles unit unit group ID of this titles unit unit group
	*/
	@Override
	public void setTitlesUnitUnitGroupId(long titlesUnitUnitGroupId) {
		_titlesUnitUnitGroup.setTitlesUnitUnitGroupId(titlesUnitUnitGroupId);
	}

	/**
	* Returns the titles ID of this titles unit unit group.
	*
	* @return the titles ID of this titles unit unit group
	*/
	@Override
	public long getTitlesId() {
		return _titlesUnitUnitGroup.getTitlesId();
	}

	/**
	* Sets the titles ID of this titles unit unit group.
	*
	* @param titlesId the titles ID of this titles unit unit group
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_titlesUnitUnitGroup.setTitlesId(titlesId);
	}

	/**
	* Returns the unit ID of this titles unit unit group.
	*
	* @return the unit ID of this titles unit unit group
	*/
	@Override
	public long getUnitId() {
		return _titlesUnitUnitGroup.getUnitId();
	}

	/**
	* Sets the unit ID of this titles unit unit group.
	*
	* @param unitId the unit ID of this titles unit unit group
	*/
	@Override
	public void setUnitId(long unitId) {
		_titlesUnitUnitGroup.setUnitId(unitId);
	}

	/**
	* Returns the unit group ID of this titles unit unit group.
	*
	* @return the unit group ID of this titles unit unit group
	*/
	@Override
	public long getUnitGroupId() {
		return _titlesUnitUnitGroup.getUnitGroupId();
	}

	/**
	* Sets the unit group ID of this titles unit unit group.
	*
	* @param unitGroupId the unit group ID of this titles unit unit group
	*/
	@Override
	public void setUnitGroupId(long unitGroupId) {
		_titlesUnitUnitGroup.setUnitGroupId(unitGroupId);
	}

	/**
	* Returns the group ID of this titles unit unit group.
	*
	* @return the group ID of this titles unit unit group
	*/
	@Override
	public long getGroupId() {
		return _titlesUnitUnitGroup.getGroupId();
	}

	/**
	* Sets the group ID of this titles unit unit group.
	*
	* @param groupId the group ID of this titles unit unit group
	*/
	@Override
	public void setGroupId(long groupId) {
		_titlesUnitUnitGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this titles unit unit group.
	*
	* @return the company ID of this titles unit unit group
	*/
	@Override
	public long getCompanyId() {
		return _titlesUnitUnitGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this titles unit unit group.
	*
	* @param companyId the company ID of this titles unit unit group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_titlesUnitUnitGroup.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this titles unit unit group.
	*
	* @return the user ID of this titles unit unit group
	*/
	@Override
	public long getUserId() {
		return _titlesUnitUnitGroup.getUserId();
	}

	/**
	* Sets the user ID of this titles unit unit group.
	*
	* @param userId the user ID of this titles unit unit group
	*/
	@Override
	public void setUserId(long userId) {
		_titlesUnitUnitGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this titles unit unit group.
	*
	* @return the user uuid of this titles unit unit group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titlesUnitUnitGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this titles unit unit group.
	*
	* @param userUuid the user uuid of this titles unit unit group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_titlesUnitUnitGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this titles unit unit group.
	*
	* @return the user name of this titles unit unit group
	*/
	@Override
	public java.lang.String getUserName() {
		return _titlesUnitUnitGroup.getUserName();
	}

	/**
	* Sets the user name of this titles unit unit group.
	*
	* @param userName the user name of this titles unit unit group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_titlesUnitUnitGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this titles unit unit group.
	*
	* @return the create date of this titles unit unit group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _titlesUnitUnitGroup.getCreateDate();
	}

	/**
	* Sets the create date of this titles unit unit group.
	*
	* @param createDate the create date of this titles unit unit group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_titlesUnitUnitGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this titles unit unit group.
	*
	* @return the modified date of this titles unit unit group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _titlesUnitUnitGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this titles unit unit group.
	*
	* @param modifiedDate the modified date of this titles unit unit group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_titlesUnitUnitGroup.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _titlesUnitUnitGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_titlesUnitUnitGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _titlesUnitUnitGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_titlesUnitUnitGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _titlesUnitUnitGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _titlesUnitUnitGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_titlesUnitUnitGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _titlesUnitUnitGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_titlesUnitUnitGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_titlesUnitUnitGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_titlesUnitUnitGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TitlesUnitUnitGroupWrapper((TitlesUnitUnitGroup)_titlesUnitUnitGroup.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.TitlesUnitUnitGroup titlesUnitUnitGroup) {
		return _titlesUnitUnitGroup.compareTo(titlesUnitUnitGroup);
	}

	@Override
	public int hashCode() {
		return _titlesUnitUnitGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.TitlesUnitUnitGroup> toCacheModel() {
		return _titlesUnitUnitGroup.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup toEscapedModel() {
		return new TitlesUnitUnitGroupWrapper(_titlesUnitUnitGroup.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.TitlesUnitUnitGroup toUnescapedModel() {
		return new TitlesUnitUnitGroupWrapper(_titlesUnitUnitGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _titlesUnitUnitGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _titlesUnitUnitGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_titlesUnitUnitGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TitlesUnitUnitGroupWrapper)) {
			return false;
		}

		TitlesUnitUnitGroupWrapper titlesUnitUnitGroupWrapper = (TitlesUnitUnitGroupWrapper)obj;

		if (Validator.equals(_titlesUnitUnitGroup,
					titlesUnitUnitGroupWrapper._titlesUnitUnitGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TitlesUnitUnitGroup getWrappedTitlesUnitUnitGroup() {
		return _titlesUnitUnitGroup;
	}

	@Override
	public TitlesUnitUnitGroup getWrappedModel() {
		return _titlesUnitUnitGroup;
	}

	@Override
	public void resetOriginalValues() {
		_titlesUnitUnitGroup.resetOriginalValues();
	}

	private TitlesUnitUnitGroup _titlesUnitUnitGroup;
}