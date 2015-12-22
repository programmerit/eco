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
 * This class is a wrapper for {@link University}.
 * </p>
 *
 * @author tvt
 * @see University
 * @generated
 */
public class UniversityWrapper implements University, ModelWrapper<University> {
	public UniversityWrapper(University university) {
		_university = university;
	}

	@Override
	public Class<?> getModelClass() {
		return University.class;
	}

	@Override
	public String getModelClassName() {
		return University.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("universityId", getUniversityId());
		attributes.put("name", getName());
		attributes.put("code", getCode());
		attributes.put("tel_fax", getTel_fax());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long universityId = (Long)attributes.get("universityId");

		if (universityId != null) {
			setUniversityId(universityId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String tel_fax = (String)attributes.get("tel_fax");

		if (tel_fax != null) {
			setTel_fax(tel_fax);
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
	* Returns the primary key of this university.
	*
	* @return the primary key of this university
	*/
	@Override
	public long getPrimaryKey() {
		return _university.getPrimaryKey();
	}

	/**
	* Sets the primary key of this university.
	*
	* @param primaryKey the primary key of this university
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_university.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the university ID of this university.
	*
	* @return the university ID of this university
	*/
	@Override
	public long getUniversityId() {
		return _university.getUniversityId();
	}

	/**
	* Sets the university ID of this university.
	*
	* @param universityId the university ID of this university
	*/
	@Override
	public void setUniversityId(long universityId) {
		_university.setUniversityId(universityId);
	}

	/**
	* Returns the name of this university.
	*
	* @return the name of this university
	*/
	@Override
	public java.lang.String getName() {
		return _university.getName();
	}

	/**
	* Sets the name of this university.
	*
	* @param name the name of this university
	*/
	@Override
	public void setName(java.lang.String name) {
		_university.setName(name);
	}

	/**
	* Returns the code of this university.
	*
	* @return the code of this university
	*/
	@Override
	public java.lang.String getCode() {
		return _university.getCode();
	}

	/**
	* Sets the code of this university.
	*
	* @param code the code of this university
	*/
	@Override
	public void setCode(java.lang.String code) {
		_university.setCode(code);
	}

	/**
	* Returns the tel_fax of this university.
	*
	* @return the tel_fax of this university
	*/
	@Override
	public java.lang.String getTel_fax() {
		return _university.getTel_fax();
	}

	/**
	* Sets the tel_fax of this university.
	*
	* @param tel_fax the tel_fax of this university
	*/
	@Override
	public void setTel_fax(java.lang.String tel_fax) {
		_university.setTel_fax(tel_fax);
	}

	/**
	* Returns the group ID of this university.
	*
	* @return the group ID of this university
	*/
	@Override
	public long getGroupId() {
		return _university.getGroupId();
	}

	/**
	* Sets the group ID of this university.
	*
	* @param groupId the group ID of this university
	*/
	@Override
	public void setGroupId(long groupId) {
		_university.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this university.
	*
	* @return the company ID of this university
	*/
	@Override
	public long getCompanyId() {
		return _university.getCompanyId();
	}

	/**
	* Sets the company ID of this university.
	*
	* @param companyId the company ID of this university
	*/
	@Override
	public void setCompanyId(long companyId) {
		_university.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this university.
	*
	* @return the user ID of this university
	*/
	@Override
	public long getUserId() {
		return _university.getUserId();
	}

	/**
	* Sets the user ID of this university.
	*
	* @param userId the user ID of this university
	*/
	@Override
	public void setUserId(long userId) {
		_university.setUserId(userId);
	}

	/**
	* Returns the user uuid of this university.
	*
	* @return the user uuid of this university
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _university.getUserUuid();
	}

	/**
	* Sets the user uuid of this university.
	*
	* @param userUuid the user uuid of this university
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_university.setUserUuid(userUuid);
	}

	/**
	* Returns the create date of this university.
	*
	* @return the create date of this university
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _university.getCreateDate();
	}

	/**
	* Sets the create date of this university.
	*
	* @param createDate the create date of this university
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_university.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this university.
	*
	* @return the modified date of this university
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _university.getModifiedDate();
	}

	/**
	* Sets the modified date of this university.
	*
	* @param modifiedDate the modified date of this university
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_university.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _university.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_university.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _university.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_university.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _university.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _university.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_university.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _university.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_university.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_university.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_university.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UniversityWrapper((University)_university.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.University university) {
		return _university.compareTo(university);
	}

	@Override
	public int hashCode() {
		return _university.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.University> toCacheModel() {
		return _university.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.University toEscapedModel() {
		return new UniversityWrapper(_university.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.University toUnescapedModel() {
		return new UniversityWrapper(_university.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _university.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _university.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_university.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UniversityWrapper)) {
			return false;
		}

		UniversityWrapper universityWrapper = (UniversityWrapper)obj;

		if (Validator.equals(_university, universityWrapper._university)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public University getWrappedUniversity() {
		return _university;
	}

	@Override
	public University getWrappedModel() {
		return _university;
	}

	@Override
	public void resetOriginalValues() {
		_university.resetOriginalValues();
	}

	private University _university;
}