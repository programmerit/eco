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
 * This class is a wrapper for {@link EmpAnnualLeave}.
 * </p>
 *
 * @author tvt
 * @see EmpAnnualLeave
 * @generated
 */
public class EmpAnnualLeaveWrapper implements EmpAnnualLeave,
	ModelWrapper<EmpAnnualLeave> {
	public EmpAnnualLeaveWrapper(EmpAnnualLeave empAnnualLeave) {
		_empAnnualLeave = empAnnualLeave;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpAnnualLeave.class;
	}

	@Override
	public String getModelClassName() {
		return EmpAnnualLeave.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empAnnualLeaveId", getEmpAnnualLeaveId());
		attributes.put("empId", getEmpId());
		attributes.put("totalAnualLeaveLeft", getTotalAnualLeaveLeft());
		attributes.put("totalAnnualLeave", getTotalAnnualLeave());
		attributes.put("totalPreviousYearLeavesLeft",
			getTotalPreviousYearLeavesLeft());
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
		Long empAnnualLeaveId = (Long)attributes.get("empAnnualLeaveId");

		if (empAnnualLeaveId != null) {
			setEmpAnnualLeaveId(empAnnualLeaveId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Double totalAnualLeaveLeft = (Double)attributes.get(
				"totalAnualLeaveLeft");

		if (totalAnualLeaveLeft != null) {
			setTotalAnualLeaveLeft(totalAnualLeaveLeft);
		}

		Integer totalAnnualLeave = (Integer)attributes.get("totalAnnualLeave");

		if (totalAnnualLeave != null) {
			setTotalAnnualLeave(totalAnnualLeave);
		}

		Double totalPreviousYearLeavesLeft = (Double)attributes.get(
				"totalPreviousYearLeavesLeft");

		if (totalPreviousYearLeavesLeft != null) {
			setTotalPreviousYearLeavesLeft(totalPreviousYearLeavesLeft);
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
	* Returns the primary key of this emp annual leave.
	*
	* @return the primary key of this emp annual leave
	*/
	@Override
	public long getPrimaryKey() {
		return _empAnnualLeave.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp annual leave.
	*
	* @param primaryKey the primary key of this emp annual leave
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empAnnualLeave.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp annual leave ID of this emp annual leave.
	*
	* @return the emp annual leave ID of this emp annual leave
	*/
	@Override
	public long getEmpAnnualLeaveId() {
		return _empAnnualLeave.getEmpAnnualLeaveId();
	}

	/**
	* Sets the emp annual leave ID of this emp annual leave.
	*
	* @param empAnnualLeaveId the emp annual leave ID of this emp annual leave
	*/
	@Override
	public void setEmpAnnualLeaveId(long empAnnualLeaveId) {
		_empAnnualLeave.setEmpAnnualLeaveId(empAnnualLeaveId);
	}

	/**
	* Returns the emp ID of this emp annual leave.
	*
	* @return the emp ID of this emp annual leave
	*/
	@Override
	public long getEmpId() {
		return _empAnnualLeave.getEmpId();
	}

	/**
	* Sets the emp ID of this emp annual leave.
	*
	* @param empId the emp ID of this emp annual leave
	*/
	@Override
	public void setEmpId(long empId) {
		_empAnnualLeave.setEmpId(empId);
	}

	/**
	* Returns the total anual leave left of this emp annual leave.
	*
	* @return the total anual leave left of this emp annual leave
	*/
	@Override
	public double getTotalAnualLeaveLeft() {
		return _empAnnualLeave.getTotalAnualLeaveLeft();
	}

	/**
	* Sets the total anual leave left of this emp annual leave.
	*
	* @param totalAnualLeaveLeft the total anual leave left of this emp annual leave
	*/
	@Override
	public void setTotalAnualLeaveLeft(double totalAnualLeaveLeft) {
		_empAnnualLeave.setTotalAnualLeaveLeft(totalAnualLeaveLeft);
	}

	/**
	* Returns the total annual leave of this emp annual leave.
	*
	* @return the total annual leave of this emp annual leave
	*/
	@Override
	public int getTotalAnnualLeave() {
		return _empAnnualLeave.getTotalAnnualLeave();
	}

	/**
	* Sets the total annual leave of this emp annual leave.
	*
	* @param totalAnnualLeave the total annual leave of this emp annual leave
	*/
	@Override
	public void setTotalAnnualLeave(int totalAnnualLeave) {
		_empAnnualLeave.setTotalAnnualLeave(totalAnnualLeave);
	}

	/**
	* Returns the total previous year leaves left of this emp annual leave.
	*
	* @return the total previous year leaves left of this emp annual leave
	*/
	@Override
	public double getTotalPreviousYearLeavesLeft() {
		return _empAnnualLeave.getTotalPreviousYearLeavesLeft();
	}

	/**
	* Sets the total previous year leaves left of this emp annual leave.
	*
	* @param totalPreviousYearLeavesLeft the total previous year leaves left of this emp annual leave
	*/
	@Override
	public void setTotalPreviousYearLeavesLeft(
		double totalPreviousYearLeavesLeft) {
		_empAnnualLeave.setTotalPreviousYearLeavesLeft(totalPreviousYearLeavesLeft);
	}

	/**
	* Returns the group ID of this emp annual leave.
	*
	* @return the group ID of this emp annual leave
	*/
	@Override
	public long getGroupId() {
		return _empAnnualLeave.getGroupId();
	}

	/**
	* Sets the group ID of this emp annual leave.
	*
	* @param groupId the group ID of this emp annual leave
	*/
	@Override
	public void setGroupId(long groupId) {
		_empAnnualLeave.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp annual leave.
	*
	* @return the company ID of this emp annual leave
	*/
	@Override
	public long getCompanyId() {
		return _empAnnualLeave.getCompanyId();
	}

	/**
	* Sets the company ID of this emp annual leave.
	*
	* @param companyId the company ID of this emp annual leave
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empAnnualLeave.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp annual leave.
	*
	* @return the user ID of this emp annual leave
	*/
	@Override
	public long getUserId() {
		return _empAnnualLeave.getUserId();
	}

	/**
	* Sets the user ID of this emp annual leave.
	*
	* @param userId the user ID of this emp annual leave
	*/
	@Override
	public void setUserId(long userId) {
		_empAnnualLeave.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp annual leave.
	*
	* @return the user uuid of this emp annual leave
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empAnnualLeave.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp annual leave.
	*
	* @param userUuid the user uuid of this emp annual leave
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empAnnualLeave.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp annual leave.
	*
	* @return the user name of this emp annual leave
	*/
	@Override
	public java.lang.String getUserName() {
		return _empAnnualLeave.getUserName();
	}

	/**
	* Sets the user name of this emp annual leave.
	*
	* @param userName the user name of this emp annual leave
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empAnnualLeave.setUserName(userName);
	}

	/**
	* Returns the create date of this emp annual leave.
	*
	* @return the create date of this emp annual leave
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empAnnualLeave.getCreateDate();
	}

	/**
	* Sets the create date of this emp annual leave.
	*
	* @param createDate the create date of this emp annual leave
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empAnnualLeave.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp annual leave.
	*
	* @return the modified date of this emp annual leave
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empAnnualLeave.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp annual leave.
	*
	* @param modifiedDate the modified date of this emp annual leave
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empAnnualLeave.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empAnnualLeave.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empAnnualLeave.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empAnnualLeave.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empAnnualLeave.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empAnnualLeave.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empAnnualLeave.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empAnnualLeave.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empAnnualLeave.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empAnnualLeave.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empAnnualLeave.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empAnnualLeave.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpAnnualLeaveWrapper((EmpAnnualLeave)_empAnnualLeave.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmpAnnualLeave empAnnualLeave) {
		return _empAnnualLeave.compareTo(empAnnualLeave);
	}

	@Override
	public int hashCode() {
		return _empAnnualLeave.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpAnnualLeave> toCacheModel() {
		return _empAnnualLeave.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave toEscapedModel() {
		return new EmpAnnualLeaveWrapper(_empAnnualLeave.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpAnnualLeave toUnescapedModel() {
		return new EmpAnnualLeaveWrapper(_empAnnualLeave.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empAnnualLeave.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empAnnualLeave.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empAnnualLeave.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpAnnualLeaveWrapper)) {
			return false;
		}

		EmpAnnualLeaveWrapper empAnnualLeaveWrapper = (EmpAnnualLeaveWrapper)obj;

		if (Validator.equals(_empAnnualLeave,
					empAnnualLeaveWrapper._empAnnualLeave)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpAnnualLeave getWrappedEmpAnnualLeave() {
		return _empAnnualLeave;
	}

	@Override
	public EmpAnnualLeave getWrappedModel() {
		return _empAnnualLeave;
	}

	@Override
	public void resetOriginalValues() {
		_empAnnualLeave.resetOriginalValues();
	}

	private EmpAnnualLeave _empAnnualLeave;
}