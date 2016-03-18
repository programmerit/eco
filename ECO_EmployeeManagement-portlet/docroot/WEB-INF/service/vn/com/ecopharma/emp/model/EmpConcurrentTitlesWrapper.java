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
 * This class is a wrapper for {@link EmpConcurrentTitles}.
 * </p>
 *
 * @author tvt
 * @see EmpConcurrentTitles
 * @generated
 */
public class EmpConcurrentTitlesWrapper implements EmpConcurrentTitles,
	ModelWrapper<EmpConcurrentTitles> {
	public EmpConcurrentTitlesWrapper(EmpConcurrentTitles empConcurrentTitles) {
		_empConcurrentTitles = empConcurrentTitles;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpConcurrentTitles.class;
	}

	@Override
	public String getModelClassName() {
		return EmpConcurrentTitles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empConcurrentTitlesId", getEmpConcurrentTitlesId());
		attributes.put("empId", getEmpId());
		attributes.put("titlesId", getTitlesId());
		attributes.put("unitGroupId", getUnitGroupId());
		attributes.put("unitId", getUnitId());
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
		Long empConcurrentTitlesId = (Long)attributes.get(
				"empConcurrentTitlesId");

		if (empConcurrentTitlesId != null) {
			setEmpConcurrentTitlesId(empConcurrentTitlesId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
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
	* Returns the primary key of this emp concurrent titles.
	*
	* @return the primary key of this emp concurrent titles
	*/
	@Override
	public long getPrimaryKey() {
		return _empConcurrentTitles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp concurrent titles.
	*
	* @param primaryKey the primary key of this emp concurrent titles
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empConcurrentTitles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp concurrent titles ID of this emp concurrent titles.
	*
	* @return the emp concurrent titles ID of this emp concurrent titles
	*/
	@Override
	public long getEmpConcurrentTitlesId() {
		return _empConcurrentTitles.getEmpConcurrentTitlesId();
	}

	/**
	* Sets the emp concurrent titles ID of this emp concurrent titles.
	*
	* @param empConcurrentTitlesId the emp concurrent titles ID of this emp concurrent titles
	*/
	@Override
	public void setEmpConcurrentTitlesId(long empConcurrentTitlesId) {
		_empConcurrentTitles.setEmpConcurrentTitlesId(empConcurrentTitlesId);
	}

	/**
	* Returns the emp ID of this emp concurrent titles.
	*
	* @return the emp ID of this emp concurrent titles
	*/
	@Override
	public long getEmpId() {
		return _empConcurrentTitles.getEmpId();
	}

	/**
	* Sets the emp ID of this emp concurrent titles.
	*
	* @param empId the emp ID of this emp concurrent titles
	*/
	@Override
	public void setEmpId(long empId) {
		_empConcurrentTitles.setEmpId(empId);
	}

	/**
	* Returns the titles ID of this emp concurrent titles.
	*
	* @return the titles ID of this emp concurrent titles
	*/
	@Override
	public long getTitlesId() {
		return _empConcurrentTitles.getTitlesId();
	}

	/**
	* Sets the titles ID of this emp concurrent titles.
	*
	* @param titlesId the titles ID of this emp concurrent titles
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_empConcurrentTitles.setTitlesId(titlesId);
	}

	/**
	* Returns the unit group ID of this emp concurrent titles.
	*
	* @return the unit group ID of this emp concurrent titles
	*/
	@Override
	public long getUnitGroupId() {
		return _empConcurrentTitles.getUnitGroupId();
	}

	/**
	* Sets the unit group ID of this emp concurrent titles.
	*
	* @param unitGroupId the unit group ID of this emp concurrent titles
	*/
	@Override
	public void setUnitGroupId(long unitGroupId) {
		_empConcurrentTitles.setUnitGroupId(unitGroupId);
	}

	/**
	* Returns the unit ID of this emp concurrent titles.
	*
	* @return the unit ID of this emp concurrent titles
	*/
	@Override
	public long getUnitId() {
		return _empConcurrentTitles.getUnitId();
	}

	/**
	* Sets the unit ID of this emp concurrent titles.
	*
	* @param unitId the unit ID of this emp concurrent titles
	*/
	@Override
	public void setUnitId(long unitId) {
		_empConcurrentTitles.setUnitId(unitId);
	}

	/**
	* Returns the department ID of this emp concurrent titles.
	*
	* @return the department ID of this emp concurrent titles
	*/
	@Override
	public long getDepartmentId() {
		return _empConcurrentTitles.getDepartmentId();
	}

	/**
	* Sets the department ID of this emp concurrent titles.
	*
	* @param departmentId the department ID of this emp concurrent titles
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_empConcurrentTitles.setDepartmentId(departmentId);
	}

	/**
	* Returns the group ID of this emp concurrent titles.
	*
	* @return the group ID of this emp concurrent titles
	*/
	@Override
	public long getGroupId() {
		return _empConcurrentTitles.getGroupId();
	}

	/**
	* Sets the group ID of this emp concurrent titles.
	*
	* @param groupId the group ID of this emp concurrent titles
	*/
	@Override
	public void setGroupId(long groupId) {
		_empConcurrentTitles.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp concurrent titles.
	*
	* @return the company ID of this emp concurrent titles
	*/
	@Override
	public long getCompanyId() {
		return _empConcurrentTitles.getCompanyId();
	}

	/**
	* Sets the company ID of this emp concurrent titles.
	*
	* @param companyId the company ID of this emp concurrent titles
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empConcurrentTitles.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp concurrent titles.
	*
	* @return the user ID of this emp concurrent titles
	*/
	@Override
	public long getUserId() {
		return _empConcurrentTitles.getUserId();
	}

	/**
	* Sets the user ID of this emp concurrent titles.
	*
	* @param userId the user ID of this emp concurrent titles
	*/
	@Override
	public void setUserId(long userId) {
		_empConcurrentTitles.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp concurrent titles.
	*
	* @return the user uuid of this emp concurrent titles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empConcurrentTitles.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp concurrent titles.
	*
	* @param userUuid the user uuid of this emp concurrent titles
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empConcurrentTitles.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp concurrent titles.
	*
	* @return the user name of this emp concurrent titles
	*/
	@Override
	public java.lang.String getUserName() {
		return _empConcurrentTitles.getUserName();
	}

	/**
	* Sets the user name of this emp concurrent titles.
	*
	* @param userName the user name of this emp concurrent titles
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empConcurrentTitles.setUserName(userName);
	}

	/**
	* Returns the create date of this emp concurrent titles.
	*
	* @return the create date of this emp concurrent titles
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empConcurrentTitles.getCreateDate();
	}

	/**
	* Sets the create date of this emp concurrent titles.
	*
	* @param createDate the create date of this emp concurrent titles
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empConcurrentTitles.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp concurrent titles.
	*
	* @return the modified date of this emp concurrent titles
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empConcurrentTitles.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp concurrent titles.
	*
	* @param modifiedDate the modified date of this emp concurrent titles
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empConcurrentTitles.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empConcurrentTitles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empConcurrentTitles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empConcurrentTitles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empConcurrentTitles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empConcurrentTitles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empConcurrentTitles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empConcurrentTitles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empConcurrentTitles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empConcurrentTitles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empConcurrentTitles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empConcurrentTitles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpConcurrentTitlesWrapper((EmpConcurrentTitles)_empConcurrentTitles.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmpConcurrentTitles empConcurrentTitles) {
		return _empConcurrentTitles.compareTo(empConcurrentTitles);
	}

	@Override
	public int hashCode() {
		return _empConcurrentTitles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpConcurrentTitles> toCacheModel() {
		return _empConcurrentTitles.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpConcurrentTitles toEscapedModel() {
		return new EmpConcurrentTitlesWrapper(_empConcurrentTitles.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpConcurrentTitles toUnescapedModel() {
		return new EmpConcurrentTitlesWrapper(_empConcurrentTitles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empConcurrentTitles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empConcurrentTitles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empConcurrentTitles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpConcurrentTitlesWrapper)) {
			return false;
		}

		EmpConcurrentTitlesWrapper empConcurrentTitlesWrapper = (EmpConcurrentTitlesWrapper)obj;

		if (Validator.equals(_empConcurrentTitles,
					empConcurrentTitlesWrapper._empConcurrentTitles)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpConcurrentTitles getWrappedEmpConcurrentTitles() {
		return _empConcurrentTitles;
	}

	@Override
	public EmpConcurrentTitles getWrappedModel() {
		return _empConcurrentTitles;
	}

	@Override
	public void resetOriginalValues() {
		_empConcurrentTitles.resetOriginalValues();
	}

	private EmpConcurrentTitles _empConcurrentTitles;
}