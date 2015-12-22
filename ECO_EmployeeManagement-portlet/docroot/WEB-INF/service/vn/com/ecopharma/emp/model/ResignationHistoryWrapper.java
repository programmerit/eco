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
 * This class is a wrapper for {@link ResignationHistory}.
 * </p>
 *
 * @author tvt
 * @see ResignationHistory
 * @generated
 */
public class ResignationHistoryWrapper implements ResignationHistory,
	ModelWrapper<ResignationHistory> {
	public ResignationHistoryWrapper(ResignationHistory resignationHistory) {
		_resignationHistory = resignationHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return ResignationHistory.class;
	}

	@Override
	public String getModelClassName() {
		return ResignationHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("resignationHistoryId", getResignationHistoryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("resignedDate", getResignedDate());
		attributes.put("resignedType", getResignedType());
		attributes.put("comment", getComment());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long resignationHistoryId = (Long)attributes.get("resignationHistoryId");

		if (resignationHistoryId != null) {
			setResignationHistoryId(resignationHistoryId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Date resignedDate = (Date)attributes.get("resignedDate");

		if (resignedDate != null) {
			setResignedDate(resignedDate);
		}

		String resignedType = (String)attributes.get("resignedType");

		if (resignedType != null) {
			setResignedType(resignedType);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	/**
	* Returns the primary key of this resignation history.
	*
	* @return the primary key of this resignation history
	*/
	@Override
	public long getPrimaryKey() {
		return _resignationHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this resignation history.
	*
	* @param primaryKey the primary key of this resignation history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_resignationHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the resignation history ID of this resignation history.
	*
	* @return the resignation history ID of this resignation history
	*/
	@Override
	public long getResignationHistoryId() {
		return _resignationHistory.getResignationHistoryId();
	}

	/**
	* Sets the resignation history ID of this resignation history.
	*
	* @param resignationHistoryId the resignation history ID of this resignation history
	*/
	@Override
	public void setResignationHistoryId(long resignationHistoryId) {
		_resignationHistory.setResignationHistoryId(resignationHistoryId);
	}

	/**
	* Returns the employee ID of this resignation history.
	*
	* @return the employee ID of this resignation history
	*/
	@Override
	public long getEmployeeId() {
		return _resignationHistory.getEmployeeId();
	}

	/**
	* Sets the employee ID of this resignation history.
	*
	* @param employeeId the employee ID of this resignation history
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_resignationHistory.setEmployeeId(employeeId);
	}

	/**
	* Returns the resigned date of this resignation history.
	*
	* @return the resigned date of this resignation history
	*/
	@Override
	public java.util.Date getResignedDate() {
		return _resignationHistory.getResignedDate();
	}

	/**
	* Sets the resigned date of this resignation history.
	*
	* @param resignedDate the resigned date of this resignation history
	*/
	@Override
	public void setResignedDate(java.util.Date resignedDate) {
		_resignationHistory.setResignedDate(resignedDate);
	}

	/**
	* Returns the resigned type of this resignation history.
	*
	* @return the resigned type of this resignation history
	*/
	@Override
	public java.lang.String getResignedType() {
		return _resignationHistory.getResignedType();
	}

	/**
	* Sets the resigned type of this resignation history.
	*
	* @param resignedType the resigned type of this resignation history
	*/
	@Override
	public void setResignedType(java.lang.String resignedType) {
		_resignationHistory.setResignedType(resignedType);
	}

	/**
	* Returns the comment of this resignation history.
	*
	* @return the comment of this resignation history
	*/
	@Override
	public java.lang.String getComment() {
		return _resignationHistory.getComment();
	}

	/**
	* Sets the comment of this resignation history.
	*
	* @param comment the comment of this resignation history
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_resignationHistory.setComment(comment);
	}

	/**
	* Returns the group ID of this resignation history.
	*
	* @return the group ID of this resignation history
	*/
	@Override
	public long getGroupId() {
		return _resignationHistory.getGroupId();
	}

	/**
	* Sets the group ID of this resignation history.
	*
	* @param groupId the group ID of this resignation history
	*/
	@Override
	public void setGroupId(long groupId) {
		_resignationHistory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this resignation history.
	*
	* @return the company ID of this resignation history
	*/
	@Override
	public long getCompanyId() {
		return _resignationHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this resignation history.
	*
	* @param companyId the company ID of this resignation history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_resignationHistory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this resignation history.
	*
	* @return the user ID of this resignation history
	*/
	@Override
	public long getUserId() {
		return _resignationHistory.getUserId();
	}

	/**
	* Sets the user ID of this resignation history.
	*
	* @param userId the user ID of this resignation history
	*/
	@Override
	public void setUserId(long userId) {
		_resignationHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this resignation history.
	*
	* @return the user uuid of this resignation history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _resignationHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this resignation history.
	*
	* @param userUuid the user uuid of this resignation history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_resignationHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this resignation history.
	*
	* @return the user name of this resignation history
	*/
	@Override
	public java.lang.String getUserName() {
		return _resignationHistory.getUserName();
	}

	/**
	* Sets the user name of this resignation history.
	*
	* @param userName the user name of this resignation history
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_resignationHistory.setUserName(userName);
	}

	/**
	* Returns the create date of this resignation history.
	*
	* @return the create date of this resignation history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _resignationHistory.getCreateDate();
	}

	/**
	* Sets the create date of this resignation history.
	*
	* @param createDate the create date of this resignation history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_resignationHistory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this resignation history.
	*
	* @return the modified date of this resignation history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _resignationHistory.getModifiedDate();
	}

	/**
	* Sets the modified date of this resignation history.
	*
	* @param modifiedDate the modified date of this resignation history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_resignationHistory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this resignation history.
	*
	* @return the deleted of this resignation history
	*/
	@Override
	public boolean getDeleted() {
		return _resignationHistory.getDeleted();
	}

	/**
	* Returns <code>true</code> if this resignation history is deleted.
	*
	* @return <code>true</code> if this resignation history is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _resignationHistory.isDeleted();
	}

	/**
	* Sets whether this resignation history is deleted.
	*
	* @param deleted the deleted of this resignation history
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_resignationHistory.setDeleted(deleted);
	}

	@Override
	public boolean isNew() {
		return _resignationHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_resignationHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _resignationHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_resignationHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _resignationHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _resignationHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_resignationHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _resignationHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_resignationHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_resignationHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_resignationHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ResignationHistoryWrapper((ResignationHistory)_resignationHistory.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.ResignationHistory resignationHistory) {
		return _resignationHistory.compareTo(resignationHistory);
	}

	@Override
	public int hashCode() {
		return _resignationHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.ResignationHistory> toCacheModel() {
		return _resignationHistory.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory toEscapedModel() {
		return new ResignationHistoryWrapper(_resignationHistory.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.ResignationHistory toUnescapedModel() {
		return new ResignationHistoryWrapper(_resignationHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _resignationHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _resignationHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_resignationHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ResignationHistoryWrapper)) {
			return false;
		}

		ResignationHistoryWrapper resignationHistoryWrapper = (ResignationHistoryWrapper)obj;

		if (Validator.equals(_resignationHistory,
					resignationHistoryWrapper._resignationHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ResignationHistory getWrappedResignationHistory() {
		return _resignationHistory;
	}

	@Override
	public ResignationHistory getWrappedModel() {
		return _resignationHistory;
	}

	@Override
	public void resetOriginalValues() {
		_resignationHistory.resetOriginalValues();
	}

	private ResignationHistory _resignationHistory;
}