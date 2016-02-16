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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmpNotifyEmail}.
 * </p>
 *
 * @author tvt
 * @see EmpNotifyEmail
 * @generated
 */
public class EmpNotifyEmailWrapper implements EmpNotifyEmail,
	ModelWrapper<EmpNotifyEmail> {
	public EmpNotifyEmailWrapper(EmpNotifyEmail empNotifyEmail) {
		_empNotifyEmail = empNotifyEmail;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpNotifyEmail.class;
	}

	@Override
	public String getModelClassName() {
		return EmpNotifyEmail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empNotifyEmailId", getEmpNotifyEmailId());
		attributes.put("empId", getEmpId());
		attributes.put("notifyType", getNotifyType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empNotifyEmailId = (Long)attributes.get("empNotifyEmailId");

		if (empNotifyEmailId != null) {
			setEmpNotifyEmailId(empNotifyEmailId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String notifyType = (String)attributes.get("notifyType");

		if (notifyType != null) {
			setNotifyType(notifyType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this emp notify email.
	*
	* @return the primary key of this emp notify email
	*/
	@Override
	public long getPrimaryKey() {
		return _empNotifyEmail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp notify email.
	*
	* @param primaryKey the primary key of this emp notify email
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empNotifyEmail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp notify email ID of this emp notify email.
	*
	* @return the emp notify email ID of this emp notify email
	*/
	@Override
	public long getEmpNotifyEmailId() {
		return _empNotifyEmail.getEmpNotifyEmailId();
	}

	/**
	* Sets the emp notify email ID of this emp notify email.
	*
	* @param empNotifyEmailId the emp notify email ID of this emp notify email
	*/
	@Override
	public void setEmpNotifyEmailId(long empNotifyEmailId) {
		_empNotifyEmail.setEmpNotifyEmailId(empNotifyEmailId);
	}

	/**
	* Returns the emp ID of this emp notify email.
	*
	* @return the emp ID of this emp notify email
	*/
	@Override
	public long getEmpId() {
		return _empNotifyEmail.getEmpId();
	}

	/**
	* Sets the emp ID of this emp notify email.
	*
	* @param empId the emp ID of this emp notify email
	*/
	@Override
	public void setEmpId(long empId) {
		_empNotifyEmail.setEmpId(empId);
	}

	/**
	* Returns the notify type of this emp notify email.
	*
	* @return the notify type of this emp notify email
	*/
	@Override
	public java.lang.String getNotifyType() {
		return _empNotifyEmail.getNotifyType();
	}

	/**
	* Sets the notify type of this emp notify email.
	*
	* @param notifyType the notify type of this emp notify email
	*/
	@Override
	public void setNotifyType(java.lang.String notifyType) {
		_empNotifyEmail.setNotifyType(notifyType);
	}

	/**
	* Returns the status of this emp notify email.
	*
	* @return the status of this emp notify email
	*/
	@Override
	public java.lang.String getStatus() {
		return _empNotifyEmail.getStatus();
	}

	/**
	* Sets the status of this emp notify email.
	*
	* @param status the status of this emp notify email
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_empNotifyEmail.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _empNotifyEmail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empNotifyEmail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empNotifyEmail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empNotifyEmail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empNotifyEmail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empNotifyEmail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empNotifyEmail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empNotifyEmail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empNotifyEmail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empNotifyEmail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empNotifyEmail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpNotifyEmailWrapper((EmpNotifyEmail)_empNotifyEmail.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmpNotifyEmail empNotifyEmail) {
		return _empNotifyEmail.compareTo(empNotifyEmail);
	}

	@Override
	public int hashCode() {
		return _empNotifyEmail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpNotifyEmail> toCacheModel() {
		return _empNotifyEmail.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail toEscapedModel() {
		return new EmpNotifyEmailWrapper(_empNotifyEmail.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpNotifyEmail toUnescapedModel() {
		return new EmpNotifyEmailWrapper(_empNotifyEmail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empNotifyEmail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empNotifyEmail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empNotifyEmail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpNotifyEmailWrapper)) {
			return false;
		}

		EmpNotifyEmailWrapper empNotifyEmailWrapper = (EmpNotifyEmailWrapper)obj;

		if (Validator.equals(_empNotifyEmail,
					empNotifyEmailWrapper._empNotifyEmail)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpNotifyEmail getWrappedEmpNotifyEmail() {
		return _empNotifyEmail;
	}

	@Override
	public EmpNotifyEmail getWrappedModel() {
		return _empNotifyEmail;
	}

	@Override
	public void resetOriginalValues() {
		_empNotifyEmail.resetOriginalValues();
	}

	private EmpNotifyEmail _empNotifyEmail;
}