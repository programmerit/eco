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
 * This class is a wrapper for {@link EmpAnualLeave}.
 * </p>
 *
 * @author tvt
 * @see EmpAnualLeave
 * @generated
 */
public class EmpAnualLeaveWrapper implements EmpAnualLeave,
	ModelWrapper<EmpAnualLeave> {
	public EmpAnualLeaveWrapper(EmpAnualLeave empAnualLeave) {
		_empAnualLeave = empAnualLeave;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpAnualLeave.class;
	}

	@Override
	public String getModelClassName() {
		return EmpAnualLeave.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empAnualLeaveId", getEmpAnualLeaveId());
		attributes.put("empId", getEmpId());
		attributes.put("noOfAnualLeave", getNoOfAnualLeave());
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
		Long empAnualLeaveId = (Long)attributes.get("empAnualLeaveId");

		if (empAnualLeaveId != null) {
			setEmpAnualLeaveId(empAnualLeaveId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Double noOfAnualLeave = (Double)attributes.get("noOfAnualLeave");

		if (noOfAnualLeave != null) {
			setNoOfAnualLeave(noOfAnualLeave);
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
	* Returns the primary key of this emp anual leave.
	*
	* @return the primary key of this emp anual leave
	*/
	@Override
	public long getPrimaryKey() {
		return _empAnualLeave.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp anual leave.
	*
	* @param primaryKey the primary key of this emp anual leave
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empAnualLeave.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp anual leave ID of this emp anual leave.
	*
	* @return the emp anual leave ID of this emp anual leave
	*/
	@Override
	public long getEmpAnualLeaveId() {
		return _empAnualLeave.getEmpAnualLeaveId();
	}

	/**
	* Sets the emp anual leave ID of this emp anual leave.
	*
	* @param empAnualLeaveId the emp anual leave ID of this emp anual leave
	*/
	@Override
	public void setEmpAnualLeaveId(long empAnualLeaveId) {
		_empAnualLeave.setEmpAnualLeaveId(empAnualLeaveId);
	}

	/**
	* Returns the emp ID of this emp anual leave.
	*
	* @return the emp ID of this emp anual leave
	*/
	@Override
	public long getEmpId() {
		return _empAnualLeave.getEmpId();
	}

	/**
	* Sets the emp ID of this emp anual leave.
	*
	* @param empId the emp ID of this emp anual leave
	*/
	@Override
	public void setEmpId(long empId) {
		_empAnualLeave.setEmpId(empId);
	}

	/**
	* Returns the no of anual leave of this emp anual leave.
	*
	* @return the no of anual leave of this emp anual leave
	*/
	@Override
	public double getNoOfAnualLeave() {
		return _empAnualLeave.getNoOfAnualLeave();
	}

	/**
	* Sets the no of anual leave of this emp anual leave.
	*
	* @param noOfAnualLeave the no of anual leave of this emp anual leave
	*/
	@Override
	public void setNoOfAnualLeave(double noOfAnualLeave) {
		_empAnualLeave.setNoOfAnualLeave(noOfAnualLeave);
	}

	/**
	* Returns the group ID of this emp anual leave.
	*
	* @return the group ID of this emp anual leave
	*/
	@Override
	public long getGroupId() {
		return _empAnualLeave.getGroupId();
	}

	/**
	* Sets the group ID of this emp anual leave.
	*
	* @param groupId the group ID of this emp anual leave
	*/
	@Override
	public void setGroupId(long groupId) {
		_empAnualLeave.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp anual leave.
	*
	* @return the company ID of this emp anual leave
	*/
	@Override
	public long getCompanyId() {
		return _empAnualLeave.getCompanyId();
	}

	/**
	* Sets the company ID of this emp anual leave.
	*
	* @param companyId the company ID of this emp anual leave
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empAnualLeave.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp anual leave.
	*
	* @return the user ID of this emp anual leave
	*/
	@Override
	public long getUserId() {
		return _empAnualLeave.getUserId();
	}

	/**
	* Sets the user ID of this emp anual leave.
	*
	* @param userId the user ID of this emp anual leave
	*/
	@Override
	public void setUserId(long userId) {
		_empAnualLeave.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp anual leave.
	*
	* @return the user uuid of this emp anual leave
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnualLeave.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp anual leave.
	*
	* @param userUuid the user uuid of this emp anual leave
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empAnualLeave.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp anual leave.
	*
	* @return the user name of this emp anual leave
	*/
	@Override
	public java.lang.String getUserName() {
		return _empAnualLeave.getUserName();
	}

	/**
	* Sets the user name of this emp anual leave.
	*
	* @param userName the user name of this emp anual leave
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empAnualLeave.setUserName(userName);
	}

	/**
	* Returns the create date of this emp anual leave.
	*
	* @return the create date of this emp anual leave
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empAnualLeave.getCreateDate();
	}

	/**
	* Sets the create date of this emp anual leave.
	*
	* @param createDate the create date of this emp anual leave
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empAnualLeave.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp anual leave.
	*
	* @return the modified date of this emp anual leave
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empAnualLeave.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp anual leave.
	*
	* @param modifiedDate the modified date of this emp anual leave
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empAnualLeave.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empAnualLeave.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empAnualLeave.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empAnualLeave.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empAnualLeave.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empAnualLeave.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empAnualLeave.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empAnualLeave.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empAnualLeave.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empAnualLeave.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empAnualLeave.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empAnualLeave.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpAnualLeaveWrapper((EmpAnualLeave)_empAnualLeave.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.EmpAnualLeave empAnualLeave) {
		return _empAnualLeave.compareTo(empAnualLeave);
	}

	@Override
	public int hashCode() {
		return _empAnualLeave.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpAnualLeave> toCacheModel() {
		return _empAnualLeave.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnualLeave toEscapedModel() {
		return new EmpAnualLeaveWrapper(_empAnualLeave.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnualLeave toUnescapedModel() {
		return new EmpAnualLeaveWrapper(_empAnualLeave.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empAnualLeave.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empAnualLeave.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empAnualLeave.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpAnualLeaveWrapper)) {
			return false;
		}

		EmpAnualLeaveWrapper empAnualLeaveWrapper = (EmpAnualLeaveWrapper)obj;

		if (Validator.equals(_empAnualLeave, empAnualLeaveWrapper._empAnualLeave)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpAnualLeave getWrappedEmpAnualLeave() {
		return _empAnualLeave;
	}

	@Override
	public EmpAnualLeave getWrappedModel() {
		return _empAnualLeave;
	}

	@Override
	public void resetOriginalValues() {
		_empAnualLeave.resetOriginalValues();
	}

	private EmpAnualLeave _empAnualLeave;
}