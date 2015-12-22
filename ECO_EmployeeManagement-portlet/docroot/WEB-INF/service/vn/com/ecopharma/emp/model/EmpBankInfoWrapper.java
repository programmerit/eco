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
 * This class is a wrapper for {@link EmpBankInfo}.
 * </p>
 *
 * @author tvt
 * @see EmpBankInfo
 * @generated
 */
public class EmpBankInfoWrapper implements EmpBankInfo,
	ModelWrapper<EmpBankInfo> {
	public EmpBankInfoWrapper(EmpBankInfo empBankInfo) {
		_empBankInfo = empBankInfo;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpBankInfo.class;
	}

	@Override
	public String getModelClassName() {
		return EmpBankInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empBankInfoId", getEmpBankInfoId());
		attributes.put("empId", getEmpId());
		attributes.put("bankAccountNo", getBankAccountNo());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
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
		Long empBankInfoId = (Long)attributes.get("empBankInfoId");

		if (empBankInfoId != null) {
			setEmpBankInfoId(empBankInfoId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String bankAccountNo = (String)attributes.get("bankAccountNo");

		if (bankAccountNo != null) {
			setBankAccountNo(bankAccountNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
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
	* Returns the primary key of this emp bank info.
	*
	* @return the primary key of this emp bank info
	*/
	@Override
	public long getPrimaryKey() {
		return _empBankInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp bank info.
	*
	* @param primaryKey the primary key of this emp bank info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empBankInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp bank info ID of this emp bank info.
	*
	* @return the emp bank info ID of this emp bank info
	*/
	@Override
	public long getEmpBankInfoId() {
		return _empBankInfo.getEmpBankInfoId();
	}

	/**
	* Sets the emp bank info ID of this emp bank info.
	*
	* @param empBankInfoId the emp bank info ID of this emp bank info
	*/
	@Override
	public void setEmpBankInfoId(long empBankInfoId) {
		_empBankInfo.setEmpBankInfoId(empBankInfoId);
	}

	/**
	* Returns the emp ID of this emp bank info.
	*
	* @return the emp ID of this emp bank info
	*/
	@Override
	public long getEmpId() {
		return _empBankInfo.getEmpId();
	}

	/**
	* Sets the emp ID of this emp bank info.
	*
	* @param empId the emp ID of this emp bank info
	*/
	@Override
	public void setEmpId(long empId) {
		_empBankInfo.setEmpId(empId);
	}

	/**
	* Returns the bank account no of this emp bank info.
	*
	* @return the bank account no of this emp bank info
	*/
	@Override
	public java.lang.String getBankAccountNo() {
		return _empBankInfo.getBankAccountNo();
	}

	/**
	* Sets the bank account no of this emp bank info.
	*
	* @param bankAccountNo the bank account no of this emp bank info
	*/
	@Override
	public void setBankAccountNo(java.lang.String bankAccountNo) {
		_empBankInfo.setBankAccountNo(bankAccountNo);
	}

	/**
	* Returns the bank name of this emp bank info.
	*
	* @return the bank name of this emp bank info
	*/
	@Override
	public java.lang.String getBankName() {
		return _empBankInfo.getBankName();
	}

	/**
	* Sets the bank name of this emp bank info.
	*
	* @param bankName the bank name of this emp bank info
	*/
	@Override
	public void setBankName(java.lang.String bankName) {
		_empBankInfo.setBankName(bankName);
	}

	/**
	* Returns the branch name of this emp bank info.
	*
	* @return the branch name of this emp bank info
	*/
	@Override
	public java.lang.String getBranchName() {
		return _empBankInfo.getBranchName();
	}

	/**
	* Sets the branch name of this emp bank info.
	*
	* @param branchName the branch name of this emp bank info
	*/
	@Override
	public void setBranchName(java.lang.String branchName) {
		_empBankInfo.setBranchName(branchName);
	}

	/**
	* Returns the group ID of this emp bank info.
	*
	* @return the group ID of this emp bank info
	*/
	@Override
	public long getGroupId() {
		return _empBankInfo.getGroupId();
	}

	/**
	* Sets the group ID of this emp bank info.
	*
	* @param groupId the group ID of this emp bank info
	*/
	@Override
	public void setGroupId(long groupId) {
		_empBankInfo.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp bank info.
	*
	* @return the company ID of this emp bank info
	*/
	@Override
	public long getCompanyId() {
		return _empBankInfo.getCompanyId();
	}

	/**
	* Sets the company ID of this emp bank info.
	*
	* @param companyId the company ID of this emp bank info
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empBankInfo.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp bank info.
	*
	* @return the user ID of this emp bank info
	*/
	@Override
	public long getUserId() {
		return _empBankInfo.getUserId();
	}

	/**
	* Sets the user ID of this emp bank info.
	*
	* @param userId the user ID of this emp bank info
	*/
	@Override
	public void setUserId(long userId) {
		_empBankInfo.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp bank info.
	*
	* @return the user uuid of this emp bank info
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empBankInfo.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp bank info.
	*
	* @param userUuid the user uuid of this emp bank info
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empBankInfo.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp bank info.
	*
	* @return the user name of this emp bank info
	*/
	@Override
	public java.lang.String getUserName() {
		return _empBankInfo.getUserName();
	}

	/**
	* Sets the user name of this emp bank info.
	*
	* @param userName the user name of this emp bank info
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empBankInfo.setUserName(userName);
	}

	/**
	* Returns the create date of this emp bank info.
	*
	* @return the create date of this emp bank info
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empBankInfo.getCreateDate();
	}

	/**
	* Sets the create date of this emp bank info.
	*
	* @param createDate the create date of this emp bank info
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empBankInfo.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp bank info.
	*
	* @return the modified date of this emp bank info
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empBankInfo.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp bank info.
	*
	* @param modifiedDate the modified date of this emp bank info
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empBankInfo.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empBankInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empBankInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empBankInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empBankInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empBankInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empBankInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empBankInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empBankInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empBankInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empBankInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empBankInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpBankInfoWrapper((EmpBankInfo)_empBankInfo.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.emp.model.EmpBankInfo empBankInfo) {
		return _empBankInfo.compareTo(empBankInfo);
	}

	@Override
	public int hashCode() {
		return _empBankInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpBankInfo> toCacheModel() {
		return _empBankInfo.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpBankInfo toEscapedModel() {
		return new EmpBankInfoWrapper(_empBankInfo.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpBankInfo toUnescapedModel() {
		return new EmpBankInfoWrapper(_empBankInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empBankInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empBankInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empBankInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpBankInfoWrapper)) {
			return false;
		}

		EmpBankInfoWrapper empBankInfoWrapper = (EmpBankInfoWrapper)obj;

		if (Validator.equals(_empBankInfo, empBankInfoWrapper._empBankInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpBankInfo getWrappedEmpBankInfo() {
		return _empBankInfo;
	}

	@Override
	public EmpBankInfo getWrappedModel() {
		return _empBankInfo;
	}

	@Override
	public void resetOriginalValues() {
		_empBankInfo.resetOriginalValues();
	}

	private EmpBankInfo _empBankInfo;
}