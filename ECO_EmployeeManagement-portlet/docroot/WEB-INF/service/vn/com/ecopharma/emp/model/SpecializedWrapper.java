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
 * This class is a wrapper for {@link Specialized}.
 * </p>
 *
 * @author tvt
 * @see Specialized
 * @generated
 */
public class SpecializedWrapper implements Specialized,
	ModelWrapper<Specialized> {
	public SpecializedWrapper(Specialized specialized) {
		_specialized = specialized;
	}

	@Override
	public Class<?> getModelClass() {
		return Specialized.class;
	}

	@Override
	public String getModelClassName() {
		return Specialized.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("specializedId", getSpecializedId());
		attributes.put("specializedCode", getSpecializedCode());
		attributes.put("name", getName());
		attributes.put("level", getLevel());
		attributes.put("parentId", getParentId());
		attributes.put("university", getUniversity());
		attributes.put("college", getCollege());
		attributes.put("vocationalCollege", getVocationalCollege());
		attributes.put("vocational", getVocational());
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
		Long specializedId = (Long)attributes.get("specializedId");

		if (specializedId != null) {
			setSpecializedId(specializedId);
		}

		String specializedCode = (String)attributes.get("specializedCode");

		if (specializedCode != null) {
			setSpecializedCode(specializedCode);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Boolean university = (Boolean)attributes.get("university");

		if (university != null) {
			setUniversity(university);
		}

		Boolean college = (Boolean)attributes.get("college");

		if (college != null) {
			setCollege(college);
		}

		Boolean vocationalCollege = (Boolean)attributes.get("vocationalCollege");

		if (vocationalCollege != null) {
			setVocationalCollege(vocationalCollege);
		}

		Boolean vocational = (Boolean)attributes.get("vocational");

		if (vocational != null) {
			setVocational(vocational);
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
	* Returns the primary key of this specialized.
	*
	* @return the primary key of this specialized
	*/
	@Override
	public long getPrimaryKey() {
		return _specialized.getPrimaryKey();
	}

	/**
	* Sets the primary key of this specialized.
	*
	* @param primaryKey the primary key of this specialized
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_specialized.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the specialized ID of this specialized.
	*
	* @return the specialized ID of this specialized
	*/
	@Override
	public long getSpecializedId() {
		return _specialized.getSpecializedId();
	}

	/**
	* Sets the specialized ID of this specialized.
	*
	* @param specializedId the specialized ID of this specialized
	*/
	@Override
	public void setSpecializedId(long specializedId) {
		_specialized.setSpecializedId(specializedId);
	}

	/**
	* Returns the specialized code of this specialized.
	*
	* @return the specialized code of this specialized
	*/
	@Override
	public java.lang.String getSpecializedCode() {
		return _specialized.getSpecializedCode();
	}

	/**
	* Sets the specialized code of this specialized.
	*
	* @param specializedCode the specialized code of this specialized
	*/
	@Override
	public void setSpecializedCode(java.lang.String specializedCode) {
		_specialized.setSpecializedCode(specializedCode);
	}

	/**
	* Returns the name of this specialized.
	*
	* @return the name of this specialized
	*/
	@Override
	public java.lang.String getName() {
		return _specialized.getName();
	}

	/**
	* Sets the name of this specialized.
	*
	* @param name the name of this specialized
	*/
	@Override
	public void setName(java.lang.String name) {
		_specialized.setName(name);
	}

	/**
	* Returns the level of this specialized.
	*
	* @return the level of this specialized
	*/
	@Override
	public int getLevel() {
		return _specialized.getLevel();
	}

	/**
	* Sets the level of this specialized.
	*
	* @param level the level of this specialized
	*/
	@Override
	public void setLevel(int level) {
		_specialized.setLevel(level);
	}

	/**
	* Returns the parent ID of this specialized.
	*
	* @return the parent ID of this specialized
	*/
	@Override
	public long getParentId() {
		return _specialized.getParentId();
	}

	/**
	* Sets the parent ID of this specialized.
	*
	* @param parentId the parent ID of this specialized
	*/
	@Override
	public void setParentId(long parentId) {
		_specialized.setParentId(parentId);
	}

	/**
	* Returns the university of this specialized.
	*
	* @return the university of this specialized
	*/
	@Override
	public boolean getUniversity() {
		return _specialized.getUniversity();
	}

	/**
	* Returns <code>true</code> if this specialized is university.
	*
	* @return <code>true</code> if this specialized is university; <code>false</code> otherwise
	*/
	@Override
	public boolean isUniversity() {
		return _specialized.isUniversity();
	}

	/**
	* Sets whether this specialized is university.
	*
	* @param university the university of this specialized
	*/
	@Override
	public void setUniversity(boolean university) {
		_specialized.setUniversity(university);
	}

	/**
	* Returns the college of this specialized.
	*
	* @return the college of this specialized
	*/
	@Override
	public boolean getCollege() {
		return _specialized.getCollege();
	}

	/**
	* Returns <code>true</code> if this specialized is college.
	*
	* @return <code>true</code> if this specialized is college; <code>false</code> otherwise
	*/
	@Override
	public boolean isCollege() {
		return _specialized.isCollege();
	}

	/**
	* Sets whether this specialized is college.
	*
	* @param college the college of this specialized
	*/
	@Override
	public void setCollege(boolean college) {
		_specialized.setCollege(college);
	}

	/**
	* Returns the vocational college of this specialized.
	*
	* @return the vocational college of this specialized
	*/
	@Override
	public boolean getVocationalCollege() {
		return _specialized.getVocationalCollege();
	}

	/**
	* Returns <code>true</code> if this specialized is vocational college.
	*
	* @return <code>true</code> if this specialized is vocational college; <code>false</code> otherwise
	*/
	@Override
	public boolean isVocationalCollege() {
		return _specialized.isVocationalCollege();
	}

	/**
	* Sets whether this specialized is vocational college.
	*
	* @param vocationalCollege the vocational college of this specialized
	*/
	@Override
	public void setVocationalCollege(boolean vocationalCollege) {
		_specialized.setVocationalCollege(vocationalCollege);
	}

	/**
	* Returns the vocational of this specialized.
	*
	* @return the vocational of this specialized
	*/
	@Override
	public boolean getVocational() {
		return _specialized.getVocational();
	}

	/**
	* Returns <code>true</code> if this specialized is vocational.
	*
	* @return <code>true</code> if this specialized is vocational; <code>false</code> otherwise
	*/
	@Override
	public boolean isVocational() {
		return _specialized.isVocational();
	}

	/**
	* Sets whether this specialized is vocational.
	*
	* @param vocational the vocational of this specialized
	*/
	@Override
	public void setVocational(boolean vocational) {
		_specialized.setVocational(vocational);
	}

	/**
	* Returns the group ID of this specialized.
	*
	* @return the group ID of this specialized
	*/
	@Override
	public long getGroupId() {
		return _specialized.getGroupId();
	}

	/**
	* Sets the group ID of this specialized.
	*
	* @param groupId the group ID of this specialized
	*/
	@Override
	public void setGroupId(long groupId) {
		_specialized.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this specialized.
	*
	* @return the company ID of this specialized
	*/
	@Override
	public long getCompanyId() {
		return _specialized.getCompanyId();
	}

	/**
	* Sets the company ID of this specialized.
	*
	* @param companyId the company ID of this specialized
	*/
	@Override
	public void setCompanyId(long companyId) {
		_specialized.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this specialized.
	*
	* @return the user ID of this specialized
	*/
	@Override
	public long getUserId() {
		return _specialized.getUserId();
	}

	/**
	* Sets the user ID of this specialized.
	*
	* @param userId the user ID of this specialized
	*/
	@Override
	public void setUserId(long userId) {
		_specialized.setUserId(userId);
	}

	/**
	* Returns the user uuid of this specialized.
	*
	* @return the user uuid of this specialized
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _specialized.getUserUuid();
	}

	/**
	* Sets the user uuid of this specialized.
	*
	* @param userUuid the user uuid of this specialized
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_specialized.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this specialized.
	*
	* @return the user name of this specialized
	*/
	@Override
	public java.lang.String getUserName() {
		return _specialized.getUserName();
	}

	/**
	* Sets the user name of this specialized.
	*
	* @param userName the user name of this specialized
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_specialized.setUserName(userName);
	}

	/**
	* Returns the create date of this specialized.
	*
	* @return the create date of this specialized
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _specialized.getCreateDate();
	}

	/**
	* Sets the create date of this specialized.
	*
	* @param createDate the create date of this specialized
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_specialized.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this specialized.
	*
	* @return the modified date of this specialized
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _specialized.getModifiedDate();
	}

	/**
	* Sets the modified date of this specialized.
	*
	* @param modifiedDate the modified date of this specialized
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_specialized.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _specialized.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_specialized.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _specialized.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_specialized.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _specialized.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _specialized.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_specialized.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _specialized.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_specialized.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_specialized.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_specialized.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SpecializedWrapper((Specialized)_specialized.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.Specialized specialized) {
		return _specialized.compareTo(specialized);
	}

	@Override
	public int hashCode() {
		return _specialized.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Specialized> toCacheModel() {
		return _specialized.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized toEscapedModel() {
		return new SpecializedWrapper(_specialized.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Specialized toUnescapedModel() {
		return new SpecializedWrapper(_specialized.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _specialized.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _specialized.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_specialized.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpecializedWrapper)) {
			return false;
		}

		SpecializedWrapper specializedWrapper = (SpecializedWrapper)obj;

		if (Validator.equals(_specialized, specializedWrapper._specialized)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Specialized getWrappedSpecialized() {
		return _specialized;
	}

	@Override
	public Specialized getWrappedModel() {
		return _specialized;
	}

	@Override
	public void resetOriginalValues() {
		_specialized.resetOriginalValues();
	}

	private Specialized _specialized;
}