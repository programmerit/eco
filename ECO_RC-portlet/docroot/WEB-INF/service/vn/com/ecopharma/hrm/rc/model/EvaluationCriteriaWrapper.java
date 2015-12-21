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

package vn.com.ecopharma.hrm.rc.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EvaluationCriteria}.
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteria
 * @generated
 */
public class EvaluationCriteriaWrapper implements EvaluationCriteria,
	ModelWrapper<EvaluationCriteria> {
	public EvaluationCriteriaWrapper(EvaluationCriteria evaluationCriteria) {
		_evaluationCriteria = evaluationCriteria;
	}

	@Override
	public Class<?> getModelClass() {
		return EvaluationCriteria.class;
	}

	@Override
	public String getModelClassName() {
		return EvaluationCriteria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("evaluationCriteriaId", getEvaluationCriteriaId());
		attributes.put("type", getType());
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
		Long evaluationCriteriaId = (Long)attributes.get("evaluationCriteriaId");

		if (evaluationCriteriaId != null) {
			setEvaluationCriteriaId(evaluationCriteriaId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
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
	* Returns the primary key of this evaluation criteria.
	*
	* @return the primary key of this evaluation criteria
	*/
	@Override
	public long getPrimaryKey() {
		return _evaluationCriteria.getPrimaryKey();
	}

	/**
	* Sets the primary key of this evaluation criteria.
	*
	* @param primaryKey the primary key of this evaluation criteria
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_evaluationCriteria.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the evaluation criteria ID of this evaluation criteria.
	*
	* @return the evaluation criteria ID of this evaluation criteria
	*/
	@Override
	public long getEvaluationCriteriaId() {
		return _evaluationCriteria.getEvaluationCriteriaId();
	}

	/**
	* Sets the evaluation criteria ID of this evaluation criteria.
	*
	* @param evaluationCriteriaId the evaluation criteria ID of this evaluation criteria
	*/
	@Override
	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_evaluationCriteria.setEvaluationCriteriaId(evaluationCriteriaId);
	}

	/**
	* Returns the type of this evaluation criteria.
	*
	* @return the type of this evaluation criteria
	*/
	@Override
	public java.lang.String getType() {
		return _evaluationCriteria.getType();
	}

	/**
	* Sets the type of this evaluation criteria.
	*
	* @param type the type of this evaluation criteria
	*/
	@Override
	public void setType(java.lang.String type) {
		_evaluationCriteria.setType(type);
	}

	/**
	* Returns the name of this evaluation criteria.
	*
	* @return the name of this evaluation criteria
	*/
	@Override
	public java.lang.String getName() {
		return _evaluationCriteria.getName();
	}

	/**
	* Sets the name of this evaluation criteria.
	*
	* @param name the name of this evaluation criteria
	*/
	@Override
	public void setName(java.lang.String name) {
		_evaluationCriteria.setName(name);
	}

	/**
	* Returns the group ID of this evaluation criteria.
	*
	* @return the group ID of this evaluation criteria
	*/
	@Override
	public long getGroupId() {
		return _evaluationCriteria.getGroupId();
	}

	/**
	* Sets the group ID of this evaluation criteria.
	*
	* @param groupId the group ID of this evaluation criteria
	*/
	@Override
	public void setGroupId(long groupId) {
		_evaluationCriteria.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this evaluation criteria.
	*
	* @return the company ID of this evaluation criteria
	*/
	@Override
	public long getCompanyId() {
		return _evaluationCriteria.getCompanyId();
	}

	/**
	* Sets the company ID of this evaluation criteria.
	*
	* @param companyId the company ID of this evaluation criteria
	*/
	@Override
	public void setCompanyId(long companyId) {
		_evaluationCriteria.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this evaluation criteria.
	*
	* @return the user ID of this evaluation criteria
	*/
	@Override
	public long getUserId() {
		return _evaluationCriteria.getUserId();
	}

	/**
	* Sets the user ID of this evaluation criteria.
	*
	* @param userId the user ID of this evaluation criteria
	*/
	@Override
	public void setUserId(long userId) {
		_evaluationCriteria.setUserId(userId);
	}

	/**
	* Returns the user uuid of this evaluation criteria.
	*
	* @return the user uuid of this evaluation criteria
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteria.getUserUuid();
	}

	/**
	* Sets the user uuid of this evaluation criteria.
	*
	* @param userUuid the user uuid of this evaluation criteria
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_evaluationCriteria.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this evaluation criteria.
	*
	* @return the user name of this evaluation criteria
	*/
	@Override
	public java.lang.String getUserName() {
		return _evaluationCriteria.getUserName();
	}

	/**
	* Sets the user name of this evaluation criteria.
	*
	* @param userName the user name of this evaluation criteria
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_evaluationCriteria.setUserName(userName);
	}

	/**
	* Returns the create date of this evaluation criteria.
	*
	* @return the create date of this evaluation criteria
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _evaluationCriteria.getCreateDate();
	}

	/**
	* Sets the create date of this evaluation criteria.
	*
	* @param createDate the create date of this evaluation criteria
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_evaluationCriteria.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this evaluation criteria.
	*
	* @return the modified date of this evaluation criteria
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _evaluationCriteria.getModifiedDate();
	}

	/**
	* Sets the modified date of this evaluation criteria.
	*
	* @param modifiedDate the modified date of this evaluation criteria
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_evaluationCriteria.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _evaluationCriteria.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_evaluationCriteria.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _evaluationCriteria.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_evaluationCriteria.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _evaluationCriteria.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _evaluationCriteria.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_evaluationCriteria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _evaluationCriteria.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_evaluationCriteria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_evaluationCriteria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_evaluationCriteria.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EvaluationCriteriaWrapper((EvaluationCriteria)_evaluationCriteria.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteria evaluationCriteria) {
		return _evaluationCriteria.compareTo(evaluationCriteria);
	}

	@Override
	public int hashCode() {
		return _evaluationCriteria.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.EvaluationCriteria> toCacheModel() {
		return _evaluationCriteria.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria toEscapedModel() {
		return new EvaluationCriteriaWrapper(_evaluationCriteria.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteria toUnescapedModel() {
		return new EvaluationCriteriaWrapper(_evaluationCriteria.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _evaluationCriteria.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _evaluationCriteria.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_evaluationCriteria.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EvaluationCriteriaWrapper)) {
			return false;
		}

		EvaluationCriteriaWrapper evaluationCriteriaWrapper = (EvaluationCriteriaWrapper)obj;

		if (Validator.equals(_evaluationCriteria,
					evaluationCriteriaWrapper._evaluationCriteria)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EvaluationCriteria getWrappedEvaluationCriteria() {
		return _evaluationCriteria;
	}

	@Override
	public EvaluationCriteria getWrappedModel() {
		return _evaluationCriteria;
	}

	@Override
	public void resetOriginalValues() {
		_evaluationCriteria.resetOriginalValues();
	}

	private EvaluationCriteria _evaluationCriteria;
}