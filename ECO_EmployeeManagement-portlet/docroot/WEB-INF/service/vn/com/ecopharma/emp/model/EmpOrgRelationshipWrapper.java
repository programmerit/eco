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
 * This class is a wrapper for {@link EmpOrgRelationship}.
 * </p>
 *
 * @author tvt
 * @see EmpOrgRelationship
 * @generated
 */
public class EmpOrgRelationshipWrapper implements EmpOrgRelationship,
	ModelWrapper<EmpOrgRelationship> {
	public EmpOrgRelationshipWrapper(EmpOrgRelationship empOrgRelationship) {
		_empOrgRelationship = empOrgRelationship;
	}

	@Override
	public Class<?> getModelClass() {
		return EmpOrgRelationship.class;
	}

	@Override
	public String getModelClassName() {
		return EmpOrgRelationship.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empOrgRelationshipId", getEmpOrgRelationshipId());
		attributes.put("empId", getEmpId());
		attributes.put("orgClassName", getOrgClassName());
		attributes.put("orgClassPK", getOrgClassPK());
		attributes.put("headOfOrg", getHeadOfOrg());
		attributes.put("deputyOfOrg", getDeputyOfOrg());
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
		Long empOrgRelationshipId = (Long)attributes.get("empOrgRelationshipId");

		if (empOrgRelationshipId != null) {
			setEmpOrgRelationshipId(empOrgRelationshipId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String orgClassName = (String)attributes.get("orgClassName");

		if (orgClassName != null) {
			setOrgClassName(orgClassName);
		}

		Long orgClassPK = (Long)attributes.get("orgClassPK");

		if (orgClassPK != null) {
			setOrgClassPK(orgClassPK);
		}

		Boolean headOfOrg = (Boolean)attributes.get("headOfOrg");

		if (headOfOrg != null) {
			setHeadOfOrg(headOfOrg);
		}

		Boolean deputyOfOrg = (Boolean)attributes.get("deputyOfOrg");

		if (deputyOfOrg != null) {
			setDeputyOfOrg(deputyOfOrg);
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
	* Returns the primary key of this emp org relationship.
	*
	* @return the primary key of this emp org relationship
	*/
	@Override
	public long getPrimaryKey() {
		return _empOrgRelationship.getPrimaryKey();
	}

	/**
	* Sets the primary key of this emp org relationship.
	*
	* @param primaryKey the primary key of this emp org relationship
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_empOrgRelationship.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the emp org relationship ID of this emp org relationship.
	*
	* @return the emp org relationship ID of this emp org relationship
	*/
	@Override
	public long getEmpOrgRelationshipId() {
		return _empOrgRelationship.getEmpOrgRelationshipId();
	}

	/**
	* Sets the emp org relationship ID of this emp org relationship.
	*
	* @param empOrgRelationshipId the emp org relationship ID of this emp org relationship
	*/
	@Override
	public void setEmpOrgRelationshipId(long empOrgRelationshipId) {
		_empOrgRelationship.setEmpOrgRelationshipId(empOrgRelationshipId);
	}

	/**
	* Returns the emp ID of this emp org relationship.
	*
	* @return the emp ID of this emp org relationship
	*/
	@Override
	public long getEmpId() {
		return _empOrgRelationship.getEmpId();
	}

	/**
	* Sets the emp ID of this emp org relationship.
	*
	* @param empId the emp ID of this emp org relationship
	*/
	@Override
	public void setEmpId(long empId) {
		_empOrgRelationship.setEmpId(empId);
	}

	/**
	* Returns the org class name of this emp org relationship.
	*
	* @return the org class name of this emp org relationship
	*/
	@Override
	public java.lang.String getOrgClassName() {
		return _empOrgRelationship.getOrgClassName();
	}

	/**
	* Sets the org class name of this emp org relationship.
	*
	* @param orgClassName the org class name of this emp org relationship
	*/
	@Override
	public void setOrgClassName(java.lang.String orgClassName) {
		_empOrgRelationship.setOrgClassName(orgClassName);
	}

	/**
	* Returns the org class p k of this emp org relationship.
	*
	* @return the org class p k of this emp org relationship
	*/
	@Override
	public long getOrgClassPK() {
		return _empOrgRelationship.getOrgClassPK();
	}

	/**
	* Sets the org class p k of this emp org relationship.
	*
	* @param orgClassPK the org class p k of this emp org relationship
	*/
	@Override
	public void setOrgClassPK(long orgClassPK) {
		_empOrgRelationship.setOrgClassPK(orgClassPK);
	}

	/**
	* Returns the head of org of this emp org relationship.
	*
	* @return the head of org of this emp org relationship
	*/
	@Override
	public boolean getHeadOfOrg() {
		return _empOrgRelationship.getHeadOfOrg();
	}

	/**
	* Returns <code>true</code> if this emp org relationship is head of org.
	*
	* @return <code>true</code> if this emp org relationship is head of org; <code>false</code> otherwise
	*/
	@Override
	public boolean isHeadOfOrg() {
		return _empOrgRelationship.isHeadOfOrg();
	}

	/**
	* Sets whether this emp org relationship is head of org.
	*
	* @param headOfOrg the head of org of this emp org relationship
	*/
	@Override
	public void setHeadOfOrg(boolean headOfOrg) {
		_empOrgRelationship.setHeadOfOrg(headOfOrg);
	}

	/**
	* Returns the deputy of org of this emp org relationship.
	*
	* @return the deputy of org of this emp org relationship
	*/
	@Override
	public boolean getDeputyOfOrg() {
		return _empOrgRelationship.getDeputyOfOrg();
	}

	/**
	* Returns <code>true</code> if this emp org relationship is deputy of org.
	*
	* @return <code>true</code> if this emp org relationship is deputy of org; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeputyOfOrg() {
		return _empOrgRelationship.isDeputyOfOrg();
	}

	/**
	* Sets whether this emp org relationship is deputy of org.
	*
	* @param deputyOfOrg the deputy of org of this emp org relationship
	*/
	@Override
	public void setDeputyOfOrg(boolean deputyOfOrg) {
		_empOrgRelationship.setDeputyOfOrg(deputyOfOrg);
	}

	/**
	* Returns the group ID of this emp org relationship.
	*
	* @return the group ID of this emp org relationship
	*/
	@Override
	public long getGroupId() {
		return _empOrgRelationship.getGroupId();
	}

	/**
	* Sets the group ID of this emp org relationship.
	*
	* @param groupId the group ID of this emp org relationship
	*/
	@Override
	public void setGroupId(long groupId) {
		_empOrgRelationship.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this emp org relationship.
	*
	* @return the company ID of this emp org relationship
	*/
	@Override
	public long getCompanyId() {
		return _empOrgRelationship.getCompanyId();
	}

	/**
	* Sets the company ID of this emp org relationship.
	*
	* @param companyId the company ID of this emp org relationship
	*/
	@Override
	public void setCompanyId(long companyId) {
		_empOrgRelationship.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this emp org relationship.
	*
	* @return the user ID of this emp org relationship
	*/
	@Override
	public long getUserId() {
		return _empOrgRelationship.getUserId();
	}

	/**
	* Sets the user ID of this emp org relationship.
	*
	* @param userId the user ID of this emp org relationship
	*/
	@Override
	public void setUserId(long userId) {
		_empOrgRelationship.setUserId(userId);
	}

	/**
	* Returns the user uuid of this emp org relationship.
	*
	* @return the user uuid of this emp org relationship
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _empOrgRelationship.getUserUuid();
	}

	/**
	* Sets the user uuid of this emp org relationship.
	*
	* @param userUuid the user uuid of this emp org relationship
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_empOrgRelationship.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this emp org relationship.
	*
	* @return the user name of this emp org relationship
	*/
	@Override
	public java.lang.String getUserName() {
		return _empOrgRelationship.getUserName();
	}

	/**
	* Sets the user name of this emp org relationship.
	*
	* @param userName the user name of this emp org relationship
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_empOrgRelationship.setUserName(userName);
	}

	/**
	* Returns the create date of this emp org relationship.
	*
	* @return the create date of this emp org relationship
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _empOrgRelationship.getCreateDate();
	}

	/**
	* Sets the create date of this emp org relationship.
	*
	* @param createDate the create date of this emp org relationship
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_empOrgRelationship.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this emp org relationship.
	*
	* @return the modified date of this emp org relationship
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _empOrgRelationship.getModifiedDate();
	}

	/**
	* Sets the modified date of this emp org relationship.
	*
	* @param modifiedDate the modified date of this emp org relationship
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_empOrgRelationship.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _empOrgRelationship.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_empOrgRelationship.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _empOrgRelationship.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_empOrgRelationship.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _empOrgRelationship.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _empOrgRelationship.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_empOrgRelationship.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _empOrgRelationship.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_empOrgRelationship.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_empOrgRelationship.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_empOrgRelationship.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new EmpOrgRelationshipWrapper((EmpOrgRelationship)_empOrgRelationship.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.EmpOrgRelationship empOrgRelationship) {
		return _empOrgRelationship.compareTo(empOrgRelationship);
	}

	@Override
	public int hashCode() {
		return _empOrgRelationship.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.EmpOrgRelationship> toCacheModel() {
		return _empOrgRelationship.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship toEscapedModel() {
		return new EmpOrgRelationshipWrapper(_empOrgRelationship.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.EmpOrgRelationship toUnescapedModel() {
		return new EmpOrgRelationshipWrapper(_empOrgRelationship.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _empOrgRelationship.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _empOrgRelationship.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_empOrgRelationship.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmpOrgRelationshipWrapper)) {
			return false;
		}

		EmpOrgRelationshipWrapper empOrgRelationshipWrapper = (EmpOrgRelationshipWrapper)obj;

		if (Validator.equals(_empOrgRelationship,
					empOrgRelationshipWrapper._empOrgRelationship)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public EmpOrgRelationship getWrappedEmpOrgRelationship() {
		return _empOrgRelationship;
	}

	@Override
	public EmpOrgRelationship getWrappedModel() {
		return _empOrgRelationship;
	}

	@Override
	public void resetOriginalValues() {
		_empOrgRelationship.resetOriginalValues();
	}

	private EmpOrgRelationship _empOrgRelationship;
}