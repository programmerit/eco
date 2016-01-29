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
 * This class is a wrapper for {@link EmpDiscipline}.
 * </p>
 *
 * @author tvt
 * @see EmpDiscipline
 * @generated
 */
public class EmpDisciplineWrapper implements EmpDiscipline,
	ModelWrapper<EmpDiscipline> {
	public EmpDisciplineWrapper(EmpDiscipline empDiscipline) {
		_empDiscipline = empDiscipline;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDiscipline.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDiscipline.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empDisciplineId", getEmpDisciplineId());
		attributes.put("empId", getEmpId());
		attributes.put("content", getContent());
		attributes.put("disciplineType", getDisciplineType());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("additionalDisciplineType", getAdditionalDisciplineType());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empDisciplineId = (Long)attributes.get("empDisciplineId");

		if (empDisciplineId != null) {
			setEmpDisciplineId(empDisciplineId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String disciplineType = (String)attributes.get("disciplineType");

		if (disciplineType != null) {
			setDisciplineType(disciplineType);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		String additionalDisciplineType = (String)attributes.get(
				"additionalDisciplineType");

		if (additionalDisciplineType != null) {
			setAdditionalDisciplineType(additionalDisciplineType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this emp discipline.
	*
	* @return the primary key of this emp discipline
	*/
	@Override
	public long getPrimaryKey() {
		return _empDiscipline.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp discipline.
	*
	* @param primaryKey the primary key of this emp discipline
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empDiscipline.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp discipline ID of this emp discipline.
	*
	* @return the emp discipline ID of this emp discipline
	*/
	@Override
	public long getEmpDisciplineId() {
		return _empDiscipline.getEmpDisciplineId();
	}

	/**
	* Sets the emp discipline ID of this emp discipline.
	*
	* @param empDisciplineId the emp discipline ID of this emp discipline
	*/
	@Override
	public void setEmpDisciplineId(long empDisciplineId) {
		_empDiscipline.setEmpDisciplineId(empDisciplineId);
	}

	/**
	* Returns the emp ID of this emp discipline.
	*
	* @return the emp ID of this emp discipline
	*/
	@Override
	public long getEmpId() {
		return _empDiscipline.getEmpId();
	}

	/**
	* Sets the emp ID of this emp discipline.
	*
	* @param empId the emp ID of this emp discipline
	*/
	@Override
	public void setEmpId(long empId) {
		_empDiscipline.setEmpId(empId);
	}

	/**
	* Returns the content of this emp discipline.
	*
	* @return the content of this emp discipline
	*/
	@Override
	public java.lang.String getContent() {
		return _empDiscipline.getContent();
	}

	/**
	* Sets the content of this emp discipline.
	*
	* @param content the content of this emp discipline
	*/
	@Override
	public void setContent(java.lang.String content) {
		_empDiscipline.setContent(content);
	}

	/**
	* Returns the discipline type of this emp discipline.
	*
	* @return the discipline type of this emp discipline
	*/
	@Override
	public java.lang.String getDisciplineType() {
		return _empDiscipline.getDisciplineType();
	}

	/**
	* Sets the discipline type of this emp discipline.
	*
	* @param disciplineType the discipline type of this emp discipline
	*/
	@Override
	public void setDisciplineType(java.lang.String disciplineType) {
		_empDiscipline.setDisciplineType(disciplineType);
	}

	/**
	* Returns the effective date of this emp discipline.
	*
	* @return the effective date of this emp discipline
	*/
	@Override
	public java.util.Date getEffectiveDate() {
		return _empDiscipline.getEffectiveDate();
	}

	/**
	* Sets the effective date of this emp discipline.
	*
	* @param effectiveDate the effective date of this emp discipline
	*/
	@Override
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_empDiscipline.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the additional discipline type of this emp discipline.
	*
	* @return the additional discipline type of this emp discipline
	*/
	@Override
	public java.lang.String getAdditionalDisciplineType() {
		return _empDiscipline.getAdditionalDisciplineType();
	}

	/**
	* Sets the additional discipline type of this emp discipline.
	*
	* @param additionalDisciplineType the additional discipline type of this emp discipline
	*/
	@Override
	public void setAdditionalDisciplineType(
		java.lang.String additionalDisciplineType) {
		_empDiscipline.setAdditionalDisciplineType(additionalDisciplineType);
	}

	/**
	* Returns the description of this emp discipline.
	*
	* @return the description of this emp discipline
	*/
	@Override
	public java.lang.String getDescription() {
		return _empDiscipline.getDescription();
	}

	/**
	* Sets the description of this emp discipline.
	*
	* @param description the description of this emp discipline
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_empDiscipline.setDescription(description);
	}

	/**
	* Returns the group ID of this emp discipline.
	*
	* @return the group ID of this emp discipline
	*/
	@Override
	public long getGroupId() {
		return _empDiscipline.getGroupId();
	}

	/**
	* Sets the group ID of this emp discipline.
	*
	* @param groupId the group ID of this emp discipline
	*/
	@Override
	public void setGroupId(long groupId) {
		_empDiscipline.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp discipline.
	*
	* @return the company ID of this emp discipline
	*/
	@Override
	public long getCompanyId() {
		return _empDiscipline.getCompanyId();
	}

	/**
	* Sets the company ID of this emp discipline.
	*
	* @param companyId the company ID of this emp discipline
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empDiscipline.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp discipline.
	*
	* @return the user ID of this emp discipline
	*/
	@Override
	public long getUserId() {
		return _empDiscipline.getUserId();
	}

	/**
	* Sets the user ID of this emp discipline.
	*
	* @param userId the user ID of this emp discipline
	*/
	@Override
	public void setUserId(long userId) {
		_empDiscipline.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp discipline.
	*
	* @return the user uuid of this emp discipline
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empDiscipline.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp discipline.
	*
	* @param userUuid the user uuid of this emp discipline
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empDiscipline.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp discipline.
	*
	* @return the user name of this emp discipline
	*/
	@Override
	public java.lang.String getUserName() {
		return _empDiscipline.getUserName();
	}

	/**
	* Sets the user name of this emp discipline.
	*
	* @param userName the user name of this emp discipline
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empDiscipline.setUserName(userName);
	}

	/**
	* Returns the create date of this emp discipline.
	*
	* @return the create date of this emp discipline
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empDiscipline.getCreateDate();
	}

	/**
	* Sets the create date of this emp discipline.
	*
	* @param createDate the create date of this emp discipline
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empDiscipline.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp discipline.
	*
	* @return the modified date of this emp discipline
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empDiscipline.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp discipline.
	*
	* @param modifiedDate the modified date of this emp discipline
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empDiscipline.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this emp discipline.
	*
	* @return the deleted of this emp discipline
	*/
	@Override
	public boolean getDeleted() {
		return _empDiscipline.getDeleted();
	}

	/**
	* Returns <code>true</code> if this emp discipline is deleted.
	*
	* @return <code>true</code> if this emp discipline is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _empDiscipline.isDeleted();
	}

	/**
	* Sets whether this emp discipline is deleted.
	*
	* @param deleted the deleted of this emp discipline
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_empDiscipline.setDeleted(deleted);
	}

	@Override
	public boolean isNew() {
		return _empDiscipline.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empDiscipline.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empDiscipline.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empDiscipline.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empDiscipline.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empDiscipline.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empDiscipline.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empDiscipline.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empDiscipline.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empDiscipline.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empDiscipline.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpDisciplineWrapper((EmpDiscipline)_empDiscipline.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.EmpDiscipline empDiscipline) {
		return _empDiscipline.compareTo(empDiscipline);
	}

	@Override
	public int hashCode() {
		return _empDiscipline.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpDiscipline> toCacheModel() {
		return _empDiscipline.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline toEscapedModel() {
		return new EmpDisciplineWrapper(_empDiscipline.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpDiscipline toUnescapedModel() {
		return new EmpDisciplineWrapper(_empDiscipline.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empDiscipline.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empDiscipline.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empDiscipline.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpDisciplineWrapper)) {
			return false;
		}

		EmpDisciplineWrapper empDisciplineWrapper = (EmpDisciplineWrapper)obj;

		if (Validator.equals(_empDiscipline, empDisciplineWrapper._empDiscipline)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpDiscipline getWrappedEmpDiscipline() {
		return _empDiscipline;
	}

	@Override
	public EmpDiscipline getWrappedModel() {
		return _empDiscipline;
	}

	@Override
	public void resetOriginalValues() {
		_empDiscipline.resetOriginalValues();
	}

	private EmpDiscipline _empDiscipline;
}