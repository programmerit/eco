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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmpBankInfo service. Represents a row in the &quot;eco_em_portlet_EmpBankInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.emp.model.impl.EmpBankInfoImpl}.
 * </p>
 *
 * @author tvt
 * @see EmpBankInfo
 * @see vn.com.ecopharma.emp.model.impl.EmpBankInfoImpl
 * @see vn.com.ecopharma.emp.model.impl.EmpBankInfoModelImpl
 * @generated
 */
public interface EmpBankInfoModel extends BaseModel<EmpBankInfo>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a emp bank info model instance should use the {@link EmpBankInfo} interface instead.
	 */

	/**
	 * Returns the primary key of this emp bank info.
	 *
	 * @return the primary key of this emp bank info
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this emp bank info.
	 *
	 * @param primaryKey the primary key of this emp bank info
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the emp bank info ID of this emp bank info.
	 *
	 * @return the emp bank info ID of this emp bank info
	 */
	public long getEmpBankInfoId();

	/**
	 * Sets the emp bank info ID of this emp bank info.
	 *
	 * @param empBankInfoId the emp bank info ID of this emp bank info
	 */
	public void setEmpBankInfoId(long empBankInfoId);

	/**
	 * Returns the emp ID of this emp bank info.
	 *
	 * @return the emp ID of this emp bank info
	 */
	public long getEmpId();

	/**
	 * Sets the emp ID of this emp bank info.
	 *
	 * @param empId the emp ID of this emp bank info
	 */
	public void setEmpId(long empId);

	/**
	 * Returns the bank account no of this emp bank info.
	 *
	 * @return the bank account no of this emp bank info
	 */
	@AutoEscape
	public String getBankAccountNo();

	/**
	 * Sets the bank account no of this emp bank info.
	 *
	 * @param bankAccountNo the bank account no of this emp bank info
	 */
	public void setBankAccountNo(String bankAccountNo);

	/**
	 * Returns the bank name of this emp bank info.
	 *
	 * @return the bank name of this emp bank info
	 */
	@AutoEscape
	public String getBankName();

	/**
	 * Sets the bank name of this emp bank info.
	 *
	 * @param bankName the bank name of this emp bank info
	 */
	public void setBankName(String bankName);

	/**
	 * Returns the branch name of this emp bank info.
	 *
	 * @return the branch name of this emp bank info
	 */
	@AutoEscape
	public String getBranchName();

	/**
	 * Sets the branch name of this emp bank info.
	 *
	 * @param branchName the branch name of this emp bank info
	 */
	public void setBranchName(String branchName);

	/**
	 * Returns the group ID of this emp bank info.
	 *
	 * @return the group ID of this emp bank info
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this emp bank info.
	 *
	 * @param groupId the group ID of this emp bank info
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this emp bank info.
	 *
	 * @return the company ID of this emp bank info
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this emp bank info.
	 *
	 * @param companyId the company ID of this emp bank info
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this emp bank info.
	 *
	 * @return the user ID of this emp bank info
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this emp bank info.
	 *
	 * @param userId the user ID of this emp bank info
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this emp bank info.
	 *
	 * @return the user uuid of this emp bank info
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this emp bank info.
	 *
	 * @param userUuid the user uuid of this emp bank info
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this emp bank info.
	 *
	 * @return the user name of this emp bank info
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this emp bank info.
	 *
	 * @param userName the user name of this emp bank info
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this emp bank info.
	 *
	 * @return the create date of this emp bank info
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this emp bank info.
	 *
	 * @param createDate the create date of this emp bank info
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this emp bank info.
	 *
	 * @return the modified date of this emp bank info
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this emp bank info.
	 *
	 * @param modifiedDate the modified date of this emp bank info
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(EmpBankInfo empBankInfo);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmpBankInfo> toCacheModel();

	@Override
	public EmpBankInfo toEscapedModel();

	@Override
	public EmpBankInfo toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}