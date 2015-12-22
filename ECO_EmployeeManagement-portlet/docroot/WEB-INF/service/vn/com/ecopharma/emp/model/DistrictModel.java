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
 * The base model interface for the District service. Represents a row in the &quot;eco_em_portlet_District&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link vn.com.ecopharma.emp.model.impl.DistrictModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link vn.com.ecopharma.emp.model.impl.DistrictImpl}.
 * </p>
 *
 * @author tvt
 * @see District
 * @see vn.com.ecopharma.emp.model.impl.DistrictImpl
 * @see vn.com.ecopharma.emp.model.impl.DistrictModelImpl
 * @generated
 */
public interface DistrictModel extends BaseModel<District>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a district model instance should use the {@link District} interface instead.
	 */

	/**
	 * Returns the primary key of this district.
	 *
	 * @return the primary key of this district
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this district.
	 *
	 * @param primaryKey the primary key of this district
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the district ID of this district.
	 *
	 * @return the district ID of this district
	 */
	public long getDistrictId();

	/**
	 * Sets the district ID of this district.
	 *
	 * @param districtId the district ID of this district
	 */
	public void setDistrictId(long districtId);

	/**
	 * Returns the group ID of this district.
	 *
	 * @return the group ID of this district
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this district.
	 *
	 * @param groupId the group ID of this district
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this district.
	 *
	 * @return the company ID of this district
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this district.
	 *
	 * @param companyId the company ID of this district
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this district.
	 *
	 * @return the user ID of this district
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this district.
	 *
	 * @param userId the user ID of this district
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this district.
	 *
	 * @return the user uuid of this district
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this district.
	 *
	 * @param userUuid the user uuid of this district
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this district.
	 *
	 * @return the user name of this district
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this district.
	 *
	 * @param userName the user name of this district
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this district.
	 *
	 * @return the create date of this district
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this district.
	 *
	 * @param createDate the create date of this district
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this district.
	 *
	 * @return the modified date of this district
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this district.
	 *
	 * @param modifiedDate the modified date of this district
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the region code of this district.
	 *
	 * @return the region code of this district
	 */
	@AutoEscape
	public String getRegionCode();

	/**
	 * Sets the region code of this district.
	 *
	 * @param regionCode the region code of this district
	 */
	public void setRegionCode(String regionCode);

	/**
	 * Returns the name of this district.
	 *
	 * @return the name of this district
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this district.
	 *
	 * @param name the name of this district
	 */
	public void setName(String name);

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
	public int compareTo(vn.com.ecopharma.emp.model.District district);

	@Override
	public int hashCode();

	@Override
	public CacheModel<vn.com.ecopharma.emp.model.District> toCacheModel();

	@Override
	public vn.com.ecopharma.emp.model.District toEscapedModel();

	@Override
	public vn.com.ecopharma.emp.model.District toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}