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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EmployeeTitlesHistory service. Represents a row in the &quot;eco_em_portlet_EmployeeTitlesHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryImpl}.
 * </p>
 *
 * @author tvt
 * @see EmployeeTitlesHistory
 * @see vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryImpl
 * @see vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryModelImpl
 * @generated
 */
public interface EmployeeTitlesHistoryModel extends BaseModel<EmployeeTitlesHistory> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee titles history model instance should use the {@link EmployeeTitlesHistory} interface instead.
	 */

	/**
	 * Returns the primary key of this employee titles history.
	 *
	 * @return the primary key of this employee titles history
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee titles history.
	 *
	 * @param primaryKey the primary key of this employee titles history
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee titles history ID of this employee titles history.
	 *
	 * @return the employee titles history ID of this employee titles history
	 */
	public long getEmployeeTitlesHistoryId();

	/**
	 * Sets the employee titles history ID of this employee titles history.
	 *
	 * @param employeeTitlesHistoryId the employee titles history ID of this employee titles history
	 */
	public void setEmployeeTitlesHistoryId(long employeeTitlesHistoryId);

	/**
	 * Returns the employee ID of this employee titles history.
	 *
	 * @return the employee ID of this employee titles history
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee titles history.
	 *
	 * @param employeeId the employee ID of this employee titles history
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the titles ID of this employee titles history.
	 *
	 * @return the titles ID of this employee titles history
	 */
	public long getTitlesId();

	/**
	 * Sets the titles ID of this employee titles history.
	 *
	 * @param titlesId the titles ID of this employee titles history
	 */
	public void setTitlesId(long titlesId);

	/**
	 * Returns the set date of this employee titles history.
	 *
	 * @return the set date of this employee titles history
	 */
	public Date getSetDate();

	/**
	 * Sets the set date of this employee titles history.
	 *
	 * @param setDate the set date of this employee titles history
	 */
	public void setSetDate(Date setDate);

	/**
	 * Returns the note of this employee titles history.
	 *
	 * @return the note of this employee titles history
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this employee titles history.
	 *
	 * @param note the note of this employee titles history
	 */
	public void setNote(String note);

	/**
	 * Returns the group ID of this employee titles history.
	 *
	 * @return the group ID of this employee titles history
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this employee titles history.
	 *
	 * @param groupId the group ID of this employee titles history
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee titles history.
	 *
	 * @return the company ID of this employee titles history
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee titles history.
	 *
	 * @param companyId the company ID of this employee titles history
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee titles history.
	 *
	 * @return the user ID of this employee titles history
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this employee titles history.
	 *
	 * @param userId the user ID of this employee titles history
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee titles history.
	 *
	 * @return the user uuid of this employee titles history
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this employee titles history.
	 *
	 * @param userUuid the user uuid of this employee titles history
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this employee titles history.
	 *
	 * @return the create date of this employee titles history
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee titles history.
	 *
	 * @param createDate the create date of this employee titles history
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee titles history.
	 *
	 * @return the modified date of this employee titles history
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee titles history.
	 *
	 * @param modifiedDate the modified date of this employee titles history
	 */
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
	public int compareTo(EmployeeTitlesHistory employeeTitlesHistory);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeTitlesHistory> toCacheModel();

	@Override
	public EmployeeTitlesHistory toEscapedModel();

	@Override
	public EmployeeTitlesHistory toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}