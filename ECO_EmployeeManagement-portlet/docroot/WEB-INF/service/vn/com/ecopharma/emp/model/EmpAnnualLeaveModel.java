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
 * The base model interface for the EmpAnnualLeave service. Represents a row in the &quot;eco_em_portlet_EmpAnnualLeave&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveImpl}.
 * </p>
 *
 * @author tvt
 * @see EmpAnnualLeave
 * @see vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveImpl
 * @see vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveModelImpl
 * @generated
 */
public interface EmpAnnualLeaveModel extends BaseModel<EmpAnnualLeave>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a emp annual leave model instance should use the {@link EmpAnnualLeave} interface instead.
	 */

	/**
	 * Returns the primary key of this emp annual leave.
	 *
	 * @return the primary key of this emp annual leave
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this emp annual leave.
	 *
	 * @param primaryKey the primary key of this emp annual leave
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the emp annual leave ID of this emp annual leave.
	 *
	 * @return the emp annual leave ID of this emp annual leave
	 */
	public long getEmpAnnualLeaveId();

	/**
	 * Sets the emp annual leave ID of this emp annual leave.
	 *
	 * @param empAnnualLeaveId the emp annual leave ID of this emp annual leave
	 */
	public void setEmpAnnualLeaveId(long empAnnualLeaveId);

	/**
	 * Returns the emp ID of this emp annual leave.
	 *
	 * @return the emp ID of this emp annual leave
	 */
	public long getEmpId();

	/**
	 * Sets the emp ID of this emp annual leave.
	 *
	 * @param empId the emp ID of this emp annual leave
	 */
	public void setEmpId(long empId);

	/**
	 * Returns the total anual leave left of this emp annual leave.
	 *
	 * @return the total anual leave left of this emp annual leave
	 */
	public double getTotalAnualLeaveLeft();

	/**
	 * Sets the total anual leave left of this emp annual leave.
	 *
	 * @param totalAnualLeaveLeft the total anual leave left of this emp annual leave
	 */
	public void setTotalAnualLeaveLeft(double totalAnualLeaveLeft);

	/**
	 * Returns the total annual leave of this emp annual leave.
	 *
	 * @return the total annual leave of this emp annual leave
	 */
	public int getTotalAnnualLeave();

	/**
	 * Sets the total annual leave of this emp annual leave.
	 *
	 * @param totalAnnualLeave the total annual leave of this emp annual leave
	 */
	public void setTotalAnnualLeave(int totalAnnualLeave);

	/**
	 * Returns the total previous year leaves left of this emp annual leave.
	 *
	 * @return the total previous year leaves left of this emp annual leave
	 */
	public double getTotalPreviousYearLeavesLeft();

	/**
	 * Sets the total previous year leaves left of this emp annual leave.
	 *
	 * @param totalPreviousYearLeavesLeft the total previous year leaves left of this emp annual leave
	 */
	public void setTotalPreviousYearLeavesLeft(
		double totalPreviousYearLeavesLeft);

	/**
	 * Returns the group ID of this emp annual leave.
	 *
	 * @return the group ID of this emp annual leave
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this emp annual leave.
	 *
	 * @param groupId the group ID of this emp annual leave
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this emp annual leave.
	 *
	 * @return the company ID of this emp annual leave
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this emp annual leave.
	 *
	 * @param companyId the company ID of this emp annual leave
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this emp annual leave.
	 *
	 * @return the user ID of this emp annual leave
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this emp annual leave.
	 *
	 * @param userId the user ID of this emp annual leave
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this emp annual leave.
	 *
	 * @return the user uuid of this emp annual leave
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this emp annual leave.
	 *
	 * @param userUuid the user uuid of this emp annual leave
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this emp annual leave.
	 *
	 * @return the user name of this emp annual leave
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this emp annual leave.
	 *
	 * @param userName the user name of this emp annual leave
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this emp annual leave.
	 *
	 * @return the create date of this emp annual leave
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this emp annual leave.
	 *
	 * @param createDate the create date of this emp annual leave
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this emp annual leave.
	 *
	 * @return the modified date of this emp annual leave
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this emp annual leave.
	 *
	 * @param modifiedDate the modified date of this emp annual leave
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
	public int compareTo(EmpAnnualLeave empAnnualLeave);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmpAnnualLeave> toCacheModel();

	@Override
	public EmpAnnualLeave toEscapedModel();

	@Override
	public EmpAnnualLeave toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}