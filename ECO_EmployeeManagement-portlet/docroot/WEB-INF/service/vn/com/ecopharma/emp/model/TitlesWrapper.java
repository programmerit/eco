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
 * This class is a wrapper for {@link Titles}.
 * </p>
 *
 * @author tvt
 * @see Titles
 * @generated
 */
public class TitlesWrapper implements Titles, ModelWrapper<Titles> {
	public TitlesWrapper(Titles titles) {
		_titles = titles;
	}

	@Override
	public Class<?> getModelClass() {
		return Titles.class;
	}

	@Override
	public String getModelClassName() {
		return Titles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("titlesId", getTitlesId());
		attributes.put("name", getName());
		attributes.put("name_en", getName_en());
		attributes.put("code", getCode());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String name_en = (String)attributes.get("name_en");

		if (name_en != null) {
			setName_en(name_en);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
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
	* Returns the primary key of this titles.
	*
	* @return the primary key of this titles
	*/
	@Override
	public long getPrimaryKey() {
		return _titles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this titles.
	*
	* @param primaryKey the primary key of this titles
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_titles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the titles ID of this titles.
	*
	* @return the titles ID of this titles
	*/
	@Override
	public long getTitlesId() {
		return _titles.getTitlesId();
	}

	/**
	* Sets the titles ID of this titles.
	*
	* @param titlesId the titles ID of this titles
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_titles.setTitlesId(titlesId);
	}

	/**
	* Returns the name of this titles.
	*
	* @return the name of this titles
	*/
	@Override
	public java.lang.String getName() {
		return _titles.getName();
	}

	/**
	* Sets the name of this titles.
	*
	* @param name the name of this titles
	*/
	@Override
	public void setName(java.lang.String name) {
		_titles.setName(name);
	}

	/**
	* Returns the name_en of this titles.
	*
	* @return the name_en of this titles
	*/
	@Override
	public java.lang.String getName_en() {
		return _titles.getName_en();
	}

	/**
	* Sets the name_en of this titles.
	*
	* @param name_en the name_en of this titles
	*/
	@Override
	public void setName_en(java.lang.String name_en) {
		_titles.setName_en(name_en);
	}

	/**
	* Returns the code of this titles.
	*
	* @return the code of this titles
	*/
	@Override
	public java.lang.String getCode() {
		return _titles.getCode();
	}

	/**
	* Sets the code of this titles.
	*
	* @param code the code of this titles
	*/
	@Override
	public void setCode(java.lang.String code) {
		_titles.setCode(code);
	}

	/**
	* Returns the group ID of this titles.
	*
	* @return the group ID of this titles
	*/
	@Override
	public long getGroupId() {
		return _titles.getGroupId();
	}

	/**
	* Sets the group ID of this titles.
	*
	* @param groupId the group ID of this titles
	*/
	@Override
	public void setGroupId(long groupId) {
		_titles.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this titles.
	*
	* @return the company ID of this titles
	*/
	@Override
	public long getCompanyId() {
		return _titles.getCompanyId();
	}

	/**
	* Sets the company ID of this titles.
	*
	* @param companyId the company ID of this titles
	*/
	@Override
	public void setCompanyId(long companyId) {
		_titles.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this titles.
	*
	* @return the user ID of this titles
	*/
	@Override
	public long getUserId() {
		return _titles.getUserId();
	}

	/**
	* Sets the user ID of this titles.
	*
	* @param userId the user ID of this titles
	*/
	@Override
	public void setUserId(long userId) {
		_titles.setUserId(userId);
	}

	/**
	* Returns the user uuid of this titles.
	*
	* @return the user uuid of this titles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _titles.getUserUuid();
	}

	/**
	* Sets the user uuid of this titles.
	*
	* @param userUuid the user uuid of this titles
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_titles.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this titles.
	*
	* @return the create date of this titles
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _titles.getCreateDate();
	}

	/**
	* Sets the create date of this titles.
	*
	* @param createDate the create date of this titles
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_titles.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this titles.
	*
	* @return the modified date of this titles
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _titles.getModifiedDate();
	}

	/**
	* Sets the modified date of this titles.
	*
	* @param modifiedDate the modified date of this titles
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_titles.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _titles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_titles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _titles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_titles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _titles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _titles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_titles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _titles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_titles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_titles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_titles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TitlesWrapper((Titles)_titles.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Titles titles) {
		return _titles.compareTo(titles);
	}

	@Override
	public int hashCode() {
		return _titles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Titles> toCacheModel() {
		return _titles.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles toEscapedModel() {
		return new TitlesWrapper(_titles.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Titles toUnescapedModel() {
		return new TitlesWrapper(_titles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _titles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _titles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_titles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TitlesWrapper)) {
			return false;
		}

		TitlesWrapper titlesWrapper = (TitlesWrapper)obj;

		if (Validator.equals(_titles, titlesWrapper._titles)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Titles getWrappedTitles() {
		return _titles;
	}

	@Override
	public Titles getWrappedModel() {
		return _titles;
	}

	@Override
	public void resetOriginalValues() {
		_titles.resetOriginalValues();
	}

	private Titles _titles;
}