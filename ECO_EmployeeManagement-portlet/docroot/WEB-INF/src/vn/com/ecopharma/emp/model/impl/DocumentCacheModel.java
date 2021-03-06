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

package vn.com.ecopharma.emp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import vn.com.ecopharma.emp.model.Document;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Document in entity cache.
 *
 * @author tvt
 * @see Document
 * @generated
 */
public class DocumentCacheModel implements CacheModel<Document>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{documentId=");
		sb.append(documentId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", documentType=");
		sb.append(documentType);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Document toEntityModel() {
		DocumentImpl documentImpl = new DocumentImpl();

		documentImpl.setDocumentId(documentId);

		if (className == null) {
			documentImpl.setClassName(StringPool.BLANK);
		}
		else {
			documentImpl.setClassName(className);
		}

		documentImpl.setClassPK(classPK);
		documentImpl.setFileEntryId(fileEntryId);

		if (documentType == null) {
			documentImpl.setDocumentType(StringPool.BLANK);
		}
		else {
			documentImpl.setDocumentType(documentType);
		}

		documentImpl.setGroupId(groupId);
		documentImpl.setCompanyId(companyId);
		documentImpl.setUserId(userId);

		if (userName == null) {
			documentImpl.setUserName(StringPool.BLANK);
		}
		else {
			documentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			documentImpl.setCreateDate(null);
		}
		else {
			documentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			documentImpl.setModifiedDate(null);
		}
		else {
			documentImpl.setModifiedDate(new Date(modifiedDate));
		}

		documentImpl.resetOriginalValues();

		return documentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		documentId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		fileEntryId = objectInput.readLong();
		documentType = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(documentId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);
		objectOutput.writeLong(fileEntryId);

		if (documentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentType);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long documentId;
	public String className;
	public long classPK;
	public long fileEntryId;
	public String documentType;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}