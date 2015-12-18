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
 * This class is a wrapper for {@link PromotedHistory}.
 * </p>
 *
 * @author tvt
 * @see PromotedHistory
 * @generated
 */
public class PromotedHistoryWrapper implements PromotedHistory,
	ModelWrapper<PromotedHistory> {
	public PromotedHistoryWrapper(PromotedHistory promotedHistory) {
		_promotedHistory = promotedHistory;
	}

	@Override
	public Class<?> getModelClass() {
		return PromotedHistory.class;
	}

	@Override
	public String getModelClassName() {
		return PromotedHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("promotedHistoryId", getPromotedHistoryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("oldTitlesId", getOldTitlesId());
		attributes.put("newTitlesId", getNewTitlesId());
		attributes.put("promotedDate", getPromotedDate());
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
		Long promotedHistoryId = (Long)attributes.get("promotedHistoryId");

		if (promotedHistoryId != null) {
			setPromotedHistoryId(promotedHistoryId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long oldTitlesId = (Long)attributes.get("oldTitlesId");

		if (oldTitlesId != null) {
			setOldTitlesId(oldTitlesId);
		}

		Long newTitlesId = (Long)attributes.get("newTitlesId");

		if (newTitlesId != null) {
			setNewTitlesId(newTitlesId);
		}

		Date promotedDate = (Date)attributes.get("promotedDate");

		if (promotedDate != null) {
			setPromotedDate(promotedDate);
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
	* Returns the primary key of this promoted history.
	*
	* @return the primary key of this promoted history
	*/
	@Override
	public long getPrimaryKey() {
		return _promotedHistory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this promoted history.
	*
	* @param primaryKey the primary key of this promoted history
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_promotedHistory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the promoted history ID of this promoted history.
	*
	* @return the promoted history ID of this promoted history
	*/
	@Override
	public long getPromotedHistoryId() {
		return _promotedHistory.getPromotedHistoryId();
	}

	/**
	* Sets the promoted history ID of this promoted history.
	*
	* @param promotedHistoryId the promoted history ID of this promoted history
	*/
	@Override
	public void setPromotedHistoryId(long promotedHistoryId) {
		_promotedHistory.setPromotedHistoryId(promotedHistoryId);
	}

	/**
	* Returns the employee ID of this promoted history.
	*
	* @return the employee ID of this promoted history
	*/
	@Override
	public long getEmployeeId() {
		return _promotedHistory.getEmployeeId();
	}

	/**
	* Sets the employee ID of this promoted history.
	*
	* @param employeeId the employee ID of this promoted history
	*/
	@Override
	public void setEmployeeId(long employeeId) {
		_promotedHistory.setEmployeeId(employeeId);
	}

	/**
	* Returns the old titles ID of this promoted history.
	*
	* @return the old titles ID of this promoted history
	*/
	@Override
	public long getOldTitlesId() {
		return _promotedHistory.getOldTitlesId();
	}

	/**
	* Sets the old titles ID of this promoted history.
	*
	* @param oldTitlesId the old titles ID of this promoted history
	*/
	@Override
	public void setOldTitlesId(long oldTitlesId) {
		_promotedHistory.setOldTitlesId(oldTitlesId);
	}

	/**
	* Returns the new titles ID of this promoted history.
	*
	* @return the new titles ID of this promoted history
	*/
	@Override
	public long getNewTitlesId() {
		return _promotedHistory.getNewTitlesId();
	}

	/**
	* Sets the new titles ID of this promoted history.
	*
	* @param newTitlesId the new titles ID of this promoted history
	*/
	@Override
	public void setNewTitlesId(long newTitlesId) {
		_promotedHistory.setNewTitlesId(newTitlesId);
	}

	/**
	* Returns the promoted date of this promoted history.
	*
	* @return the promoted date of this promoted history
	*/
	@Override
	public java.util.Date getPromotedDate() {
		return _promotedHistory.getPromotedDate();
	}

	/**
	* Sets the promoted date of this promoted history.
	*
	* @param promotedDate the promoted date of this promoted history
	*/
	@Override
	public void setPromotedDate(java.util.Date promotedDate) {
		_promotedHistory.setPromotedDate(promotedDate);
	}

	/**
	* Returns the comment of this promoted history.
	*
	* @return the comment of this promoted history
	*/
	@Override
	public java.lang.String getComment() {
		return _promotedHistory.getComment();
	}

	/**
	* Sets the comment of this promoted history.
	*
	* @param comment the comment of this promoted history
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_promotedHistory.setComment(comment);
	}

	/**
	* Returns the group ID of this promoted history.
	*
	* @return the group ID of this promoted history
	*/
	@Override
	public long getGroupId() {
		return _promotedHistory.getGroupId();
	}

	/**
	* Sets the group ID of this promoted history.
	*
	* @param groupId the group ID of this promoted history
	*/
	@Override
	public void setGroupId(long groupId) {
		_promotedHistory.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this promoted history.
	*
	* @return the company ID of this promoted history
	*/
	@Override
	public long getCompanyId() {
		return _promotedHistory.getCompanyId();
	}

	/**
	* Sets the company ID of this promoted history.
	*
	* @param companyId the company ID of this promoted history
	*/
	@Override
	public void setCompanyId(long companyId) {
		_promotedHistory.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this promoted history.
	*
	* @return the user ID of this promoted history
	*/
	@Override
	public long getUserId() {
		return _promotedHistory.getUserId();
	}

	/**
	* Sets the user ID of this promoted history.
	*
	* @param userId the user ID of this promoted history
	*/
	@Override
	public void setUserId(long userId) {
		_promotedHistory.setUserId(userId);
	}

	/**
	* Returns the user uuid of this promoted history.
	*
	* @return the user uuid of this promoted history
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _promotedHistory.getUserUuid();
	}

	/**
	* Sets the user uuid of this promoted history.
	*
	* @param userUuid the user uuid of this promoted history
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_promotedHistory.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this promoted history.
	*
	* @return the user name of this promoted history
	*/
	@Override
	public java.lang.String getUserName() {
		return _promotedHistory.getUserName();
	}

	/**
	* Sets the user name of this promoted history.
	*
	* @param userName the user name of this promoted history
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_promotedHistory.setUserName(userName);
	}

	/**
	* Returns the create date of this promoted history.
	*
	* @return the create date of this promoted history
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _promotedHistory.getCreateDate();
	}

	/**
	* Sets the create date of this promoted history.
	*
	* @param createDate the create date of this promoted history
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_promotedHistory.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this promoted history.
	*
	* @return the modified date of this promoted history
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _promotedHistory.getModifiedDate();
	}

	/**
	* Sets the modified date of this promoted history.
	*
	* @param modifiedDate the modified date of this promoted history
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_promotedHistory.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the deleted of this promoted history.
	*
	* @return the deleted of this promoted history
	*/
	@Override
	public boolean getDeleted() {
		return _promotedHistory.getDeleted();
	}

	/**
	* Returns <code>true</code> if this promoted history is deleted.
	*
	* @return <code>true</code> if this promoted history is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _promotedHistory.isDeleted();
	}

	/**
	* Sets whether this promoted history is deleted.
	*
	* @param deleted the deleted of this promoted history
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_promotedHistory.setDeleted(deleted);
	}

	@Override
	public boolean isNew() {
		return _promotedHistory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_promotedHistory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _promotedHistory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_promotedHistory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _promotedHistory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _promotedHistory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_promotedHistory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _promotedHistory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_promotedHistory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_promotedHistory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_promotedHistory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PromotedHistoryWrapper((PromotedHistory)_promotedHistory.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.emp.model.PromotedHistory promotedHistory) {
		return _promotedHistory.compareTo(promotedHistory);
	}

	@Override
	public int hashCode() {
		return _promotedHistory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.PromotedHistory> toCacheModel() {
		return _promotedHistory.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory toEscapedModel() {
		return new PromotedHistoryWrapper(_promotedHistory.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.PromotedHistory toUnescapedModel() {
		return new PromotedHistoryWrapper(_promotedHistory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _promotedHistory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _promotedHistory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_promotedHistory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PromotedHistoryWrapper)) {
			return false;
		}

		PromotedHistoryWrapper promotedHistoryWrapper = (PromotedHistoryWrapper)obj;

		if (Validator.equals(_promotedHistory,
					promotedHistoryWrapper._promotedHistory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PromotedHistory getWrappedPromotedHistory() {
		return _promotedHistory;
	}

	@Override
	public PromotedHistory getWrappedModel() {
		return _promotedHistory;
	}

	@Override
	public void resetOriginalValues() {
		_promotedHistory.resetOriginalValues();
	}

	private PromotedHistory _promotedHistory;
}