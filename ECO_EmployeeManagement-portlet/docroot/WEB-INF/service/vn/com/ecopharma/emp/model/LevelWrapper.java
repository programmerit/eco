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
 * This class is a wrapper for {@link Level}.
 * </p>
 *
 * @author tvt
 * @see Level
 * @generated
 */
public class LevelWrapper implements Level, ModelWrapper<Level> {
	public LevelWrapper(Level level) {
		_level = level;
	}

	@Override
	public Class<?> getModelClass() {
		return Level.class;
	}

	@Override
	public String getModelClassName() {
		return Level.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("levelId", getLevelId());
		attributes.put("name", getName());
		attributes.put("level", getLevel());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long levelId = (Long)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
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
	* Returns the primary key of this level.
	*
	* @return the primary key of this level
	*/
	@Override
	public long getPrimaryKey() {
		return _level.getPrimaryKey();
	}

	/**
	* Sets the primary key of this level.
	*
	* @param primaryKey the primary key of this level
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_level.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the level ID of this level.
	*
	* @return the level ID of this level
	*/
	@Override
	public long getLevelId() {
		return _level.getLevelId();
	}

	/**
	* Sets the level ID of this level.
	*
	* @param levelId the level ID of this level
	*/
	@Override
	public void setLevelId(long levelId) {
		_level.setLevelId(levelId);
	}

	/**
	* Returns the name of this level.
	*
	* @return the name of this level
	*/
	@Override
	public java.lang.String getName() {
		return _level.getName();
	}

	/**
	* Sets the name of this level.
	*
	* @param name the name of this level
	*/
	@Override
	public void setName(java.lang.String name) {
		_level.setName(name);
	}

	/**
	* Returns the level of this level.
	*
	* @return the level of this level
	*/
	@Override
	public int getLevel() {
		return _level.getLevel();
	}

	/**
	* Sets the level of this level.
	*
	* @param level the level of this level
	*/
	@Override
	public void setLevel(int level) {
		_level.setLevel(level);
	}

	/**
	* Returns the group ID of this level.
	*
	* @return the group ID of this level
	*/
	@Override
	public long getGroupId() {
		return _level.getGroupId();
	}

	/**
	* Sets the group ID of this level.
	*
	* @param groupId the group ID of this level
	*/
	@Override
	public void setGroupId(long groupId) {
		_level.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this level.
	*
	* @return the company ID of this level
	*/
	@Override
	public long getCompanyId() {
		return _level.getCompanyId();
	}

	/**
	* Sets the company ID of this level.
	*
	* @param companyId the company ID of this level
	*/
	@Override
	public void setCompanyId(long companyId) {
		_level.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this level.
	*
	* @return the user ID of this level
	*/
	@Override
	public long getUserId() {
		return _level.getUserId();
	}

	/**
	* Sets the user ID of this level.
	*
	* @param userId the user ID of this level
	*/
	@Override
	public void setUserId(long userId) {
		_level.setUserId(userId);
	}

	/**
	* Returns the user uuid of this level.
	*
	* @return the user uuid of this level
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _level.getUserUuid();
	}

	/**
	* Sets the user uuid of this level.
	*
	* @param userUuid the user uuid of this level
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_level.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this level.
	*
	* @return the create date of this level
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _level.getCreateDate();
	}

	/**
	* Sets the create date of this level.
	*
	* @param createDate the create date of this level
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_level.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this level.
	*
	* @return the modified date of this level
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _level.getModifiedDate();
	}

	/**
	* Sets the modified date of this level.
	*
	* @param modifiedDate the modified date of this level
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_level.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _level.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_level.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _level.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_level.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _level.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _level.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_level.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _level.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_level.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_level.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_level.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LevelWrapper((Level)_level.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Level level) {
		return _level.compareTo(level);
	}

	@Override
	public int hashCode() {
		return _level.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Level> toCacheModel() {
		return _level.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Level toEscapedModel() {
		return new LevelWrapper(_level.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Level toUnescapedModel() {
		return new LevelWrapper(_level.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _level.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _level.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_level.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LevelWrapper)) {
			return false;
		}

		LevelWrapper levelWrapper = (LevelWrapper)obj;

		if (Validator.equals(_level, levelWrapper._level)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Level getWrappedLevel() {
		return _level;
	}

	@Override
	public Level getWrappedModel() {
		return _level;
	}

	@Override
	public void resetOriginalValues() {
		_level.resetOriginalValues();
	}

	private Level _level;
}