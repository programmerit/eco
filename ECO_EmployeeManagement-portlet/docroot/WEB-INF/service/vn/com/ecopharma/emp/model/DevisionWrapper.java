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
 * This class is a wrapper for {@link Devision}.
 * </p>
 *
 * @author tvt
 * @see Devision
 * @generated
 */
public class DevisionWrapper implements Devision, ModelWrapper<Devision> {
	public DevisionWrapper(Devision devision) {
		_devision = devision;
	}

	@Override
	public Class<?> getModelClass() {
		return Devision.class;
	}

	@Override
	public String getModelClassName() {
		return Devision.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("devisionId", getDevisionId());
		attributes.put("name", getName());
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
		Long devisionId = (Long)attributes.get("devisionId");

		if (devisionId != null) {
			setDevisionId(devisionId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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
	* Returns the primary key of this devision.
	*
	* @return the primary key of this devision
	*/
	@Override
	public long getPrimaryKey() {
		return _devision.getPrimaryKey();
	}

	/**
	* Sets the primary key of this devision.
	*
	* @param primaryKey the primary key of this devision
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_devision.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the devision ID of this devision.
	*
	* @return the devision ID of this devision
	*/
	@Override
	public long getDevisionId() {
		return _devision.getDevisionId();
	}

	/**
	* Sets the devision ID of this devision.
	*
	* @param devisionId the devision ID of this devision
	*/
	@Override
	public void setDevisionId(long devisionId) {
		_devision.setDevisionId(devisionId);
	}

	/**
	* Returns the name of this devision.
	*
	* @return the name of this devision
	*/
	@Override
	public java.lang.String getName() {
		return _devision.getName();
	}

	/**
	* Sets the name of this devision.
	*
	* @param name the name of this devision
	*/
	@Override
	public void setName(java.lang.String name) {
		_devision.setName(name);
	}

	/**
	* Returns the group ID of this devision.
	*
	* @return the group ID of this devision
	*/
	@Override
	public long getGroupId() {
		return _devision.getGroupId();
	}

	/**
	* Sets the group ID of this devision.
	*
	* @param groupId the group ID of this devision
	*/
	@Override
	public void setGroupId(long groupId) {
		_devision.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this devision.
	*
	* @return the company ID of this devision
	*/
	@Override
	public long getCompanyId() {
		return _devision.getCompanyId();
	}

	/**
	* Sets the company ID of this devision.
	*
	* @param companyId the company ID of this devision
	*/
	@Override
	public void setCompanyId(long companyId) {
		_devision.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this devision.
	*
	* @return the user ID of this devision
	*/
	@Override
	public long getUserId() {
		return _devision.getUserId();
	}

	/**
	* Sets the user ID of this devision.
	*
	* @param userId the user ID of this devision
	*/
	@Override
	public void setUserId(long userId) {
		_devision.setUserId(userId);
	}

	/**
	* Returns the user uuid of this devision.
	*
	* @return the user uuid of this devision
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _devision.getUserUuid();
	}

	/**
	* Sets the user uuid of this devision.
	*
	* @param userUuid the user uuid of this devision
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_devision.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this devision.
	*
	* @return the user name of this devision
	*/
	@Override
	public java.lang.String getUserName() {
		return _devision.getUserName();
	}

	/**
	* Sets the user name of this devision.
	*
	* @param userName the user name of this devision
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_devision.setUserName(userName);
	}

	/**
	* Returns the create date of this devision.
	*
	* @return the create date of this devision
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _devision.getCreateDate();
	}

	/**
	* Sets the create date of this devision.
	*
	* @param createDate the create date of this devision
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_devision.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this devision.
	*
	* @return the modified date of this devision
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _devision.getModifiedDate();
	}

	/**
	* Sets the modified date of this devision.
	*
	* @param modifiedDate the modified date of this devision
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_devision.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _devision.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_devision.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _devision.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_devision.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _devision.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _devision.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_devision.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _devision.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_devision.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_devision.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_devision.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DevisionWrapper((Devision)_devision.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Devision devision) {
		return _devision.compareTo(devision);
	}

	@Override
	public int hashCode() {
		return _devision.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Devision> toCacheModel() {
		return _devision.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Devision toEscapedModel() {
		return new DevisionWrapper(_devision.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Devision toUnescapedModel() {
		return new DevisionWrapper(_devision.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _devision.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _devision.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_devision.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DevisionWrapper)) {
			return false;
		}

		DevisionWrapper devisionWrapper = (DevisionWrapper)obj;

		if (Validator.equals(_devision, devisionWrapper._devision)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Devision getWrappedDevision() {
		return _devision;
	}

	@Override
	public Devision getWrappedModel() {
		return _devision;
	}

	@Override
	public void resetOriginalValues() {
		_devision.resetOriginalValues();
	}

	private Devision _devision;
}