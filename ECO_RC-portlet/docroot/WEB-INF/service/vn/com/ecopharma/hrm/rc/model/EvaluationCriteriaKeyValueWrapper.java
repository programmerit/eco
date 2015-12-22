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
 * This class is a wrapper for {@link EvaluationCriteriaKeyValue}.
 * </p>
 *
 * @author tvt
 * @see EvaluationCriteriaKeyValue
 * @generated
 */
public class EvaluationCriteriaKeyValueWrapper
	implements EvaluationCriteriaKeyValue,
		ModelWrapper<EvaluationCriteriaKeyValue> {
	public EvaluationCriteriaKeyValueWrapper(
		EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		_evaluationCriteriaKeyValue = evaluationCriteriaKeyValue;
	}

	@Override
	public Class<?> getModelClass() {
		return EvaluationCriteriaKeyValue.class;
	}

	@Override
	public String getModelClassName() {
		return EvaluationCriteriaKeyValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("evaluationCriteriaKeyValueId",
			getEvaluationCriteriaKeyValueId());
		attributes.put("evaluationCriteriaId", getEvaluationCriteriaId());
		attributes.put("key", getKey());
		attributes.put("value", getValue());
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
		Long evaluationCriteriaKeyValueId = (Long)attributes.get(
				"evaluationCriteriaKeyValueId");

		if (evaluationCriteriaKeyValueId != null) {
			setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
		}

		Long evaluationCriteriaId = (Long)attributes.get("evaluationCriteriaId");

		if (evaluationCriteriaId != null) {
			setEvaluationCriteriaId(evaluationCriteriaId);
		}

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
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
	* Returns the primary key of this evaluation criteria key value.
	*
	* @return the primary key of this evaluation criteria key value
	*/
	@Override
	public long getPrimaryKey() {
		return _evaluationCriteriaKeyValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this evaluation criteria key value.
	*
	* @param primaryKey the primary key of this evaluation criteria key value
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_evaluationCriteriaKeyValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the evaluation criteria key value ID of this evaluation criteria key value.
	*
	* @return the evaluation criteria key value ID of this evaluation criteria key value
	*/
	@Override
	public long getEvaluationCriteriaKeyValueId() {
		return _evaluationCriteriaKeyValue.getEvaluationCriteriaKeyValueId();
	}

	/**
	* Sets the evaluation criteria key value ID of this evaluation criteria key value.
	*
	* @param evaluationCriteriaKeyValueId the evaluation criteria key value ID of this evaluation criteria key value
	*/
	@Override
	public void setEvaluationCriteriaKeyValueId(
		long evaluationCriteriaKeyValueId) {
		_evaluationCriteriaKeyValue.setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
	}

	/**
	* Returns the evaluation criteria ID of this evaluation criteria key value.
	*
	* @return the evaluation criteria ID of this evaluation criteria key value
	*/
	@Override
	public long getEvaluationCriteriaId() {
		return _evaluationCriteriaKeyValue.getEvaluationCriteriaId();
	}

	/**
	* Sets the evaluation criteria ID of this evaluation criteria key value.
	*
	* @param evaluationCriteriaId the evaluation criteria ID of this evaluation criteria key value
	*/
	@Override
	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_evaluationCriteriaKeyValue.setEvaluationCriteriaId(evaluationCriteriaId);
	}

	/**
	* Returns the key of this evaluation criteria key value.
	*
	* @return the key of this evaluation criteria key value
	*/
	@Override
	public java.lang.String getKey() {
		return _evaluationCriteriaKeyValue.getKey();
	}

	/**
	* Sets the key of this evaluation criteria key value.
	*
	* @param key the key of this evaluation criteria key value
	*/
	@Override
	public void setKey(java.lang.String key) {
		_evaluationCriteriaKeyValue.setKey(key);
	}

	/**
	* Returns the value of this evaluation criteria key value.
	*
	* @return the value of this evaluation criteria key value
	*/
	@Override
	public int getValue() {
		return _evaluationCriteriaKeyValue.getValue();
	}

	/**
	* Sets the value of this evaluation criteria key value.
	*
	* @param value the value of this evaluation criteria key value
	*/
	@Override
	public void setValue(int value) {
		_evaluationCriteriaKeyValue.setValue(value);
	}

	/**
	* Returns the group ID of this evaluation criteria key value.
	*
	* @return the group ID of this evaluation criteria key value
	*/
	@Override
	public long getGroupId() {
		return _evaluationCriteriaKeyValue.getGroupId();
	}

	/**
	* Sets the group ID of this evaluation criteria key value.
	*
	* @param groupId the group ID of this evaluation criteria key value
	*/
	@Override
	public void setGroupId(long groupId) {
		_evaluationCriteriaKeyValue.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this evaluation criteria key value.
	*
	* @return the company ID of this evaluation criteria key value
	*/
	@Override
	public long getCompanyId() {
		return _evaluationCriteriaKeyValue.getCompanyId();
	}

	/**
	* Sets the company ID of this evaluation criteria key value.
	*
	* @param companyId the company ID of this evaluation criteria key value
	*/
	@Override
	public void setCompanyId(long companyId) {
		_evaluationCriteriaKeyValue.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this evaluation criteria key value.
	*
	* @return the user ID of this evaluation criteria key value
	*/
	@Override
	public long getUserId() {
		return _evaluationCriteriaKeyValue.getUserId();
	}

	/**
	* Sets the user ID of this evaluation criteria key value.
	*
	* @param userId the user ID of this evaluation criteria key value
	*/
	@Override
	public void setUserId(long userId) {
		_evaluationCriteriaKeyValue.setUserId(userId);
	}

	/**
	* Returns the user uuid of this evaluation criteria key value.
	*
	* @return the user uuid of this evaluation criteria key value
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _evaluationCriteriaKeyValue.getUserUuid();
	}

	/**
	* Sets the user uuid of this evaluation criteria key value.
	*
	* @param userUuid the user uuid of this evaluation criteria key value
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_evaluationCriteriaKeyValue.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this evaluation criteria key value.
	*
	* @return the user name of this evaluation criteria key value
	*/
	@Override
	public java.lang.String getUserName() {
		return _evaluationCriteriaKeyValue.getUserName();
	}

	/**
	* Sets the user name of this evaluation criteria key value.
	*
	* @param userName the user name of this evaluation criteria key value
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_evaluationCriteriaKeyValue.setUserName(userName);
	}

	/**
	* Returns the create date of this evaluation criteria key value.
	*
	* @return the create date of this evaluation criteria key value
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _evaluationCriteriaKeyValue.getCreateDate();
	}

	/**
	* Sets the create date of this evaluation criteria key value.
	*
	* @param createDate the create date of this evaluation criteria key value
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_evaluationCriteriaKeyValue.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this evaluation criteria key value.
	*
	* @return the modified date of this evaluation criteria key value
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _evaluationCriteriaKeyValue.getModifiedDate();
	}

	/**
	* Sets the modified date of this evaluation criteria key value.
	*
	* @param modifiedDate the modified date of this evaluation criteria key value
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_evaluationCriteriaKeyValue.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _evaluationCriteriaKeyValue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_evaluationCriteriaKeyValue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _evaluationCriteriaKeyValue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_evaluationCriteriaKeyValue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _evaluationCriteriaKeyValue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _evaluationCriteriaKeyValue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_evaluationCriteriaKeyValue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _evaluationCriteriaKeyValue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_evaluationCriteriaKeyValue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_evaluationCriteriaKeyValue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_evaluationCriteriaKeyValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EvaluationCriteriaKeyValueWrapper((EvaluationCriteriaKeyValue)_evaluationCriteriaKeyValue.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue evaluationCriteriaKeyValue) {
		return _evaluationCriteriaKeyValue.compareTo(evaluationCriteriaKeyValue);
	}

	@Override
	public int hashCode() {
		return _evaluationCriteriaKeyValue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue> toCacheModel() {
		return _evaluationCriteriaKeyValue.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue toEscapedModel() {
		return new EvaluationCriteriaKeyValueWrapper(_evaluationCriteriaKeyValue.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValue toUnescapedModel() {
		return new EvaluationCriteriaKeyValueWrapper(_evaluationCriteriaKeyValue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _evaluationCriteriaKeyValue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _evaluationCriteriaKeyValue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_evaluationCriteriaKeyValue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EvaluationCriteriaKeyValueWrapper)) {
			return false;
		}

		EvaluationCriteriaKeyValueWrapper evaluationCriteriaKeyValueWrapper = (EvaluationCriteriaKeyValueWrapper)obj;

		if (Validator.equals(_evaluationCriteriaKeyValue,
					evaluationCriteriaKeyValueWrapper._evaluationCriteriaKeyValue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EvaluationCriteriaKeyValue getWrappedEvaluationCriteriaKeyValue() {
		return _evaluationCriteriaKeyValue;
	}

	@Override
	public EvaluationCriteriaKeyValue getWrappedModel() {
		return _evaluationCriteriaKeyValue;
	}

	@Override
	public void resetOriginalValues() {
		_evaluationCriteriaKeyValue.resetOriginalValues();
	}

	private EvaluationCriteriaKeyValue _evaluationCriteriaKeyValue;
}