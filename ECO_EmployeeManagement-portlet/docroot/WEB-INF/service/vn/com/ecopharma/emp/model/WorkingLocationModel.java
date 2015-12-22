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
 * The base model interface for the WorkingLocation service. Represents a row in the &quot;eco_em_portlet_WorkingLocation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.emp.model.impl.WorkingLocationImpl}.
 * </p>
 *
 * @author tvt
 * @see WorkingLocation
 * @see vn.com.ecopharma.emp.model.impl.WorkingLocationImpl
 * @see vn.com.ecopharma.emp.model.impl.WorkingLocationModelImpl
 * @generated
 */
public interface WorkingLocationModel extends BaseModel<WorkingLocation>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a working location model instance should use the {@link WorkingLocation} interface instead.
	 */

	/**
	 * Returns the primary key of this working location.
	 *
	 * @return the primary key of this working location
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this working location.
	 *
	 * @param primaryKey the primary key of this working location
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the working location ID of this working location.
	 *
	 * @return the working location ID of this working location
	 */
	public long getWorkingLocationId();

	/**
	 * Sets the working location ID of this working location.
	 *
	 * @param workingLocationId the working location ID of this working location
	 */
	public void setWorkingLocationId(long workingLocationId);

	/**
	 * Returns the name of this working location.
	 *
	 * @return the name of this working location
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this working location.
	 *
	 * @param name the name of this working location
	 */
	public void setName(String name);

	/**
	 * Returns the location ID of this working location.
	 *
	 * @return the location ID of this working location
	 */
	public long getLocationId();

	/**
	 * Sets the location ID of this working location.
	 *
	 * @param locationId the location ID of this working location
	 */
	public void setLocationId(long locationId);

	/**
	 * Returns the group ID of this working location.
	 *
	 * @return the group ID of this working location
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this working location.
	 *
	 * @param groupId the group ID of this working location
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this working location.
	 *
	 * @return the company ID of this working location
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this working location.
	 *
	 * @param companyId the company ID of this working location
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this working location.
	 *
	 * @return the user ID of this working location
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this working location.
	 *
	 * @param userId the user ID of this working location
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this working location.
	 *
	 * @return the user uuid of this working location
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this working location.
	 *
	 * @param userUuid the user uuid of this working location
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this working location.
	 *
	 * @return the user name of this working location
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this working location.
	 *
	 * @param userName the user name of this working location
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this working location.
	 *
	 * @return the create date of this working location
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this working location.
	 *
	 * @param createDate the create date of this working location
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this working location.
	 *
	 * @return the modified date of this working location
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this working location.
	 *
	 * @param modifiedDate the modified date of this working location
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
	public int compareTo(
		vn.com.ecopharma.emp.model.WorkingLocation workingLocation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<vn.com.ecopharma.emp.model.WorkingLocation> toCacheModel();

	@Override
	public vn.com.ecopharma.emp.model.WorkingLocation toEscapedModel();

	@Override
	public vn.com.ecopharma.emp.model.WorkingLocation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}