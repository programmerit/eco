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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Document}.
 * </p>
 *
 * @author tvt
 * @see Document
 * @generated
 */
public class DocumentWrapper implements Document, ModelWrapper<Document> {
	public DocumentWrapper(Document document) {
		_document = document;
	}

	@Override
	public Class<?> getModelClass() {
		return Document.class;
	}

	@Override
	public String getModelClassName() {
		return Document.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("documentId", getDocumentId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("type", getType());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("deleted", getDeleted());
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
		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
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
	* Returns the primary key of this document.
	*
	* @return the primary key of this document
	*/
	@Override
	public long getPrimaryKey() {
		return _document.getPrimaryKey();
	}

	/**
	* Sets the primary key of this document.
	*
	* @param primaryKey the primary key of this document
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_document.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the document ID of this document.
	*
	* @return the document ID of this document
	*/
	@Override
	public long getDocumentId() {
		return _document.getDocumentId();
	}

	/**
	* Sets the document ID of this document.
	*
	* @param documentId the document ID of this document
	*/
	@Override
	public void setDocumentId(long documentId) {
		_document.setDocumentId(documentId);
	}

	/**
	* Returns the class name of this document.
	*
	* @return the class name of this document
	*/
	@Override
	public java.lang.String getClassName() {
		return _document.getClassName();
	}

	/**
	* Sets the class name of this document.
	*
	* @param className the class name of this document
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_document.setClassName(className);
	}

	/**
	* Returns the class p k of this document.
	*
	* @return the class p k of this document
	*/
	@Override
	public long getClassPK() {
		return _document.getClassPK();
	}

	/**
	* Sets the class p k of this document.
	*
	* @param classPK the class p k of this document
	*/
	@Override
	public void setClassPK(long classPK) {
		_document.setClassPK(classPK);
	}

	/**
	* Returns the type of this document.
	*
	* @return the type of this document
	*/
	@Override
	public java.lang.String getType() {
		return _document.getType();
	}

	/**
	* Sets the type of this document.
	*
	* @param type the type of this document
	*/
	@Override
	public void setType(java.lang.String type) {
		_document.setType(type);
	}

	/**
	* Returns the file entry ID of this document.
	*
	* @return the file entry ID of this document
	*/
	@Override
	public long getFileEntryId() {
		return _document.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this document.
	*
	* @param fileEntryId the file entry ID of this document
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_document.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the deleted of this document.
	*
	* @return the deleted of this document
	*/
	@Override
	public boolean getDeleted() {
		return _document.getDeleted();
	}

	/**
	* Returns <code>true</code> if this document is deleted.
	*
	* @return <code>true</code> if this document is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _document.isDeleted();
	}

	/**
	* Sets whether this document is deleted.
	*
	* @param deleted the deleted of this document
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_document.setDeleted(deleted);
	}

	/**
	* Returns the group ID of this document.
	*
	* @return the group ID of this document
	*/
	@Override
	public long getGroupId() {
		return _document.getGroupId();
	}

	/**
	* Sets the group ID of this document.
	*
	* @param groupId the group ID of this document
	*/
	@Override
	public void setGroupId(long groupId) {
		_document.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this document.
	*
	* @return the company ID of this document
	*/
	@Override
	public long getCompanyId() {
		return _document.getCompanyId();
	}

	/**
	* Sets the company ID of this document.
	*
	* @param companyId the company ID of this document
	*/
	@Override
	public void setCompanyId(long companyId) {
		_document.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this document.
	*
	* @return the user ID of this document
	*/
	@Override
	public long getUserId() {
		return _document.getUserId();
	}

	/**
	* Sets the user ID of this document.
	*
	* @param userId the user ID of this document
	*/
	@Override
	public void setUserId(long userId) {
		_document.setUserId(userId);
	}

	/**
	* Returns the user uuid of this document.
	*
	* @return the user uuid of this document
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _document.getUserUuid();
	}

	/**
	* Sets the user uuid of this document.
	*
	* @param userUuid the user uuid of this document
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_document.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this document.
	*
	* @return the user name of this document
	*/
	@Override
	public java.lang.String getUserName() {
		return _document.getUserName();
	}

	/**
	* Sets the user name of this document.
	*
	* @param userName the user name of this document
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_document.setUserName(userName);
	}

	/**
	* Returns the create date of this document.
	*
	* @return the create date of this document
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _document.getCreateDate();
	}

	/**
	* Sets the create date of this document.
	*
	* @param createDate the create date of this document
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_document.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this document.
	*
	* @return the modified date of this document
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _document.getModifiedDate();
	}

	/**
	* Sets the modified date of this document.
	*
	* @param modifiedDate the modified date of this document
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_document.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _document.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_document.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _document.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_document.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _document.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _document.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_document.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _document.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_document.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_document.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_document.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DocumentWrapper((Document)_document.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.hrm.rc.model.Document document) {
		return _document.compareTo(document);
	}

	@Override
	public int hashCode() {
		return _document.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.Document> toCacheModel() {
		return _document.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Document toEscapedModel() {
		return new DocumentWrapper(_document.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Document toUnescapedModel() {
		return new DocumentWrapper(_document.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _document.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _document.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_document.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DocumentWrapper)) {
			return false;
		}

		DocumentWrapper documentWrapper = (DocumentWrapper)obj;

		if (Validator.equals(_document, documentWrapper._document)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Document getWrappedDocument() {
		return _document;
	}

	@Override
	public Document getWrappedModel() {
		return _document;
	}

	@Override
	public void resetOriginalValues() {
		_document.resetOriginalValues();
	}

	private Document _document;
}