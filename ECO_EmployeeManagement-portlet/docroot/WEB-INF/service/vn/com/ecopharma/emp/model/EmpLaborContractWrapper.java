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
 * This class is a wrapper for {@link EmpLaborContract}.
 * </p>
 *
 * @author tvt
 * @see EmpLaborContract
 * @generated
 */
public class EmpLaborContractWrapper implements EmpLaborContract,
	ModelWrapper<EmpLaborContract> {
	public EmpLaborContractWrapper(EmpLaborContract empLaborContract) {
		_empLaborContract = empLaborContract;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpLaborContract.class;
	}

	@Override
	public String getModelClassName() {
		return EmpLaborContract.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empLaborContractId", getEmpLaborContractId());
		attributes.put("empId", getEmpId());
		attributes.put("laborContractSignedDate", getLaborContractSignedDate());
		attributes.put("laborContractExpiredDate", getLaborContractExpiredDate());
		attributes.put("laborContractSignedType", getLaborContractSignedType());
		attributes.put("signedTimes", getSignedTimes());
		attributes.put("latest", getLatest());
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
		Long empLaborContractId = (Long)attributes.get("empLaborContractId");

		if (empLaborContractId != null) {
			setEmpLaborContractId(empLaborContractId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Date laborContractSignedDate = (Date)attributes.get(
				"laborContractSignedDate");

		if (laborContractSignedDate != null) {
			setLaborContractSignedDate(laborContractSignedDate);
		}

		Date laborContractExpiredDate = (Date)attributes.get(
				"laborContractExpiredDate");

		if (laborContractExpiredDate != null) {
			setLaborContractExpiredDate(laborContractExpiredDate);
		}

		String laborContractSignedType = (String)attributes.get(
				"laborContractSignedType");

		if (laborContractSignedType != null) {
			setLaborContractSignedType(laborContractSignedType);
		}

		Integer signedTimes = (Integer)attributes.get("signedTimes");

		if (signedTimes != null) {
			setSignedTimes(signedTimes);
		}

		Boolean latest = (Boolean)attributes.get("latest");

		if (latest != null) {
			setLatest(latest);
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
	* Returns the primary key of this emp labor contract.
	*
	* @return the primary key of this emp labor contract
	*/
	@Override
	public long getPrimaryKey() {
		return _empLaborContract.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp labor contract.
	*
	* @param primaryKey the primary key of this emp labor contract
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empLaborContract.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp labor contract ID of this emp labor contract.
	*
	* @return the emp labor contract ID of this emp labor contract
	*/
	@Override
	public long getEmpLaborContractId() {
		return _empLaborContract.getEmpLaborContractId();
	}

	/**
	* Sets the emp labor contract ID of this emp labor contract.
	*
	* @param empLaborContractId the emp labor contract ID of this emp labor contract
	*/
	@Override
	public void setEmpLaborContractId(long empLaborContractId) {
		_empLaborContract.setEmpLaborContractId(empLaborContractId);
	}

	/**
	* Returns the emp ID of this emp labor contract.
	*
	* @return the emp ID of this emp labor contract
	*/
	@Override
	public long getEmpId() {
		return _empLaborContract.getEmpId();
	}

	/**
	* Sets the emp ID of this emp labor contract.
	*
	* @param empId the emp ID of this emp labor contract
	*/
	@Override
	public void setEmpId(long empId) {
		_empLaborContract.setEmpId(empId);
	}

	/**
	* Returns the labor contract signed date of this emp labor contract.
	*
	* @return the labor contract signed date of this emp labor contract
	*/
	@Override
	public java.util.Date getLaborContractSignedDate() {
		return _empLaborContract.getLaborContractSignedDate();
	}

	/**
	* Sets the labor contract signed date of this emp labor contract.
	*
	* @param laborContractSignedDate the labor contract signed date of this emp labor contract
	*/
	@Override
	public void setLaborContractSignedDate(
		java.util.Date laborContractSignedDate) {
		_empLaborContract.setLaborContractSignedDate(laborContractSignedDate);
	}

	/**
	* Returns the labor contract expired date of this emp labor contract.
	*
	* @return the labor contract expired date of this emp labor contract
	*/
	@Override
	public java.util.Date getLaborContractExpiredDate() {
		return _empLaborContract.getLaborContractExpiredDate();
	}

	/**
	* Sets the labor contract expired date of this emp labor contract.
	*
	* @param laborContractExpiredDate the labor contract expired date of this emp labor contract
	*/
	@Override
	public void setLaborContractExpiredDate(
		java.util.Date laborContractExpiredDate) {
		_empLaborContract.setLaborContractExpiredDate(laborContractExpiredDate);
	}

	/**
	* Returns the labor contract signed type of this emp labor contract.
	*
	* @return the labor contract signed type of this emp labor contract
	*/
	@Override
	public java.lang.String getLaborContractSignedType() {
		return _empLaborContract.getLaborContractSignedType();
	}

	/**
	* Sets the labor contract signed type of this emp labor contract.
	*
	* @param laborContractSignedType the labor contract signed type of this emp labor contract
	*/
	@Override
	public void setLaborContractSignedType(
		java.lang.String laborContractSignedType) {
		_empLaborContract.setLaborContractSignedType(laborContractSignedType);
	}

	/**
	* Returns the signed times of this emp labor contract.
	*
	* @return the signed times of this emp labor contract
	*/
	@Override
	public int getSignedTimes() {
		return _empLaborContract.getSignedTimes();
	}

	/**
	* Sets the signed times of this emp labor contract.
	*
	* @param signedTimes the signed times of this emp labor contract
	*/
	@Override
	public void setSignedTimes(int signedTimes) {
		_empLaborContract.setSignedTimes(signedTimes);
	}

	/**
	* Returns the latest of this emp labor contract.
	*
	* @return the latest of this emp labor contract
	*/
	@Override
	public boolean getLatest() {
		return _empLaborContract.getLatest();
	}

	/**
	* Returns <code>true</code> if this emp labor contract is latest.
	*
	* @return <code>true</code> if this emp labor contract is latest; <code>false</code> otherwise
	*/
	@Override
	public boolean isLatest() {
		return _empLaborContract.isLatest();
	}

	/**
	* Sets whether this emp labor contract is latest.
	*
	* @param latest the latest of this emp labor contract
	*/
	@Override
	public void setLatest(boolean latest) {
		_empLaborContract.setLatest(latest);
	}

	/**
	* Returns the group ID of this emp labor contract.
	*
	* @return the group ID of this emp labor contract
	*/
	@Override
	public long getGroupId() {
		return _empLaborContract.getGroupId();
	}

	/**
	* Sets the group ID of this emp labor contract.
	*
	* @param groupId the group ID of this emp labor contract
	*/
	@Override
	public void setGroupId(long groupId) {
		_empLaborContract.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp labor contract.
	*
	* @return the company ID of this emp labor contract
	*/
	@Override
	public long getCompanyId() {
		return _empLaborContract.getCompanyId();
	}

	/**
	* Sets the company ID of this emp labor contract.
	*
	* @param companyId the company ID of this emp labor contract
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empLaborContract.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp labor contract.
	*
	* @return the user ID of this emp labor contract
	*/
	@Override
	public long getUserId() {
		return _empLaborContract.getUserId();
	}

	/**
	* Sets the user ID of this emp labor contract.
	*
	* @param userId the user ID of this emp labor contract
	*/
	@Override
	public void setUserId(long userId) {
		_empLaborContract.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp labor contract.
	*
	* @return the user uuid of this emp labor contract
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empLaborContract.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp labor contract.
	*
	* @param userUuid the user uuid of this emp labor contract
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empLaborContract.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp labor contract.
	*
	* @return the user name of this emp labor contract
	*/
	@Override
	public java.lang.String getUserName() {
		return _empLaborContract.getUserName();
	}

	/**
	* Sets the user name of this emp labor contract.
	*
	* @param userName the user name of this emp labor contract
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empLaborContract.setUserName(userName);
	}

	/**
	* Returns the create date of this emp labor contract.
	*
	* @return the create date of this emp labor contract
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empLaborContract.getCreateDate();
	}

	/**
	* Sets the create date of this emp labor contract.
	*
	* @param createDate the create date of this emp labor contract
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empLaborContract.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp labor contract.
	*
	* @return the modified date of this emp labor contract
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empLaborContract.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp labor contract.
	*
	* @param modifiedDate the modified date of this emp labor contract
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empLaborContract.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empLaborContract.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empLaborContract.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empLaborContract.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empLaborContract.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empLaborContract.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empLaborContract.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empLaborContract.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empLaborContract.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empLaborContract.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empLaborContract.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empLaborContract.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpLaborContractWrapper((EmpLaborContract)_empLaborContract.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmpLaborContract empLaborContract) {
		return _empLaborContract.compareTo(empLaborContract);
	}

	@Override
	public int hashCode() {
		return _empLaborContract.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpLaborContract> toCacheModel() {
		return _empLaborContract.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract toEscapedModel() {
		return new EmpLaborContractWrapper(_empLaborContract.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpLaborContract toUnescapedModel() {
		return new EmpLaborContractWrapper(_empLaborContract.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empLaborContract.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empLaborContract.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empLaborContract.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpLaborContractWrapper)) {
			return false;
		}

		EmpLaborContractWrapper empLaborContractWrapper = (EmpLaborContractWrapper)obj;

		if (Validator.equals(_empLaborContract,
					empLaborContractWrapper._empLaborContract)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpLaborContract getWrappedEmpLaborContract() {
		return _empLaborContract;
	}

	@Override
	public EmpLaborContract getWrappedModel() {
		return _empLaborContract;
	}

	@Override
	public void resetOriginalValues() {
		_empLaborContract.resetOriginalValues();
	}

	private EmpLaborContract _empLaborContract;
}