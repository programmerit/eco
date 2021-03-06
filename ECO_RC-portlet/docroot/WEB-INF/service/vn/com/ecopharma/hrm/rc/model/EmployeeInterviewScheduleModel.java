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
 * The base model interface for the EmployeeInterviewSchedule service. Represents a row in the &quot;eco_rcp_EmployeeInterviewSchedule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleImpl}.
 * </p>
 *
 * @author tvt
 * @see EmployeeInterviewSchedule
 * @see vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleImpl
 * @see vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleModelImpl
 * @generated
 */
public interface EmployeeInterviewScheduleModel extends BaseModel<EmployeeInterviewSchedule>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employee interview schedule model instance should use the {@link EmployeeInterviewSchedule} interface instead.
	 */

	/**
	 * Returns the primary key of this employee interview schedule.
	 *
	 * @return the primary key of this employee interview schedule
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employee interview schedule.
	 *
	 * @param primaryKey the primary key of this employee interview schedule
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employee interview schedule ID of this employee interview schedule.
	 *
	 * @return the employee interview schedule ID of this employee interview schedule
	 */
	public long getEmployeeInterviewScheduleId();

	/**
	 * Sets the employee interview schedule ID of this employee interview schedule.
	 *
	 * @param employeeInterviewScheduleId the employee interview schedule ID of this employee interview schedule
	 */
	public void setEmployeeInterviewScheduleId(long employeeInterviewScheduleId);

	/**
	 * Returns the employee ID of this employee interview schedule.
	 *
	 * @return the employee ID of this employee interview schedule
	 */
	public long getEmployeeId();

	/**
	 * Sets the employee ID of this employee interview schedule.
	 *
	 * @param employeeId the employee ID of this employee interview schedule
	 */
	public void setEmployeeId(long employeeId);

	/**
	 * Returns the interview schedule ID of this employee interview schedule.
	 *
	 * @return the interview schedule ID of this employee interview schedule
	 */
	public long getInterviewScheduleId();

	/**
	 * Sets the interview schedule ID of this employee interview schedule.
	 *
	 * @param interviewScheduleId the interview schedule ID of this employee interview schedule
	 */
	public void setInterviewScheduleId(long interviewScheduleId);

	/**
	 * Returns the note of this employee interview schedule.
	 *
	 * @return the note of this employee interview schedule
	 */
	@AutoEscape
	public String getNote();

	/**
	 * Sets the note of this employee interview schedule.
	 *
	 * @param note the note of this employee interview schedule
	 */
	public void setNote(String note);

	/**
	 * Returns the group ID of this employee interview schedule.
	 *
	 * @return the group ID of this employee interview schedule
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this employee interview schedule.
	 *
	 * @param groupId the group ID of this employee interview schedule
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this employee interview schedule.
	 *
	 * @return the company ID of this employee interview schedule
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this employee interview schedule.
	 *
	 * @param companyId the company ID of this employee interview schedule
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this employee interview schedule.
	 *
	 * @return the user ID of this employee interview schedule
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this employee interview schedule.
	 *
	 * @param userId the user ID of this employee interview schedule
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this employee interview schedule.
	 *
	 * @return the user uuid of this employee interview schedule
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this employee interview schedule.
	 *
	 * @param userUuid the user uuid of this employee interview schedule
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this employee interview schedule.
	 *
	 * @return the user name of this employee interview schedule
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this employee interview schedule.
	 *
	 * @param userName the user name of this employee interview schedule
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this employee interview schedule.
	 *
	 * @return the create date of this employee interview schedule
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this employee interview schedule.
	 *
	 * @param createDate the create date of this employee interview schedule
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this employee interview schedule.
	 *
	 * @return the modified date of this employee interview schedule
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employee interview schedule.
	 *
	 * @param modifiedDate the modified date of this employee interview schedule
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
	public int compareTo(EmployeeInterviewSchedule employeeInterviewSchedule);

	@Override
	public int hashCode();

	@Override
	public CacheModel<EmployeeInterviewSchedule> toCacheModel();

	@Override
	public EmployeeInterviewSchedule toEscapedModel();

	@Override
	public EmployeeInterviewSchedule toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}