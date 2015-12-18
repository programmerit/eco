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

import vn.com.ecopharma.emp.model.ResignationHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResignationHistory in entity cache.
 *
 * @author tvt
 * @see ResignationHistory
 * @generated
 */
public class ResignationHistoryCacheModel implements CacheModel<ResignationHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{resignationHistoryId=");
		sb.append(resignationHistoryId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", resignedDate=");
		sb.append(resignedDate);
		sb.append(", resignedType=");
		sb.append(resignedType);
		sb.append(", comment=");
		sb.append(comment);
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
		sb.append(", deleted=");
		sb.append(deleted);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ResignationHistory toEntityModel() {
		ResignationHistoryImpl resignationHistoryImpl = new ResignationHistoryImpl();

		resignationHistoryImpl.setResignationHistoryId(resignationHistoryId);
		resignationHistoryImpl.setEmployeeId(employeeId);

		if (resignedDate == Long.MIN_VALUE) {
			resignationHistoryImpl.setResignedDate(null);
		}
		else {
			resignationHistoryImpl.setResignedDate(new Date(resignedDate));
		}

		if (resignedType == null) {
			resignationHistoryImpl.setResignedType(StringPool.BLANK);
		}
		else {
			resignationHistoryImpl.setResignedType(resignedType);
		}

		if (comment == null) {
			resignationHistoryImpl.setComment(StringPool.BLANK);
		}
		else {
			resignationHistoryImpl.setComment(comment);
		}

		resignationHistoryImpl.setGroupId(groupId);
		resignationHistoryImpl.setCompanyId(companyId);
		resignationHistoryImpl.setUserId(userId);

		if (userName == null) {
			resignationHistoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			resignationHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			resignationHistoryImpl.setCreateDate(null);
		}
		else {
			resignationHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resignationHistoryImpl.setModifiedDate(null);
		}
		else {
			resignationHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		resignationHistoryImpl.setDeleted(deleted);

		resignationHistoryImpl.resetOriginalValues();

		return resignationHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		resignationHistoryId = objectInput.readLong();
		employeeId = objectInput.readLong();
		resignedDate = objectInput.readLong();
		resignedType = objectInput.readUTF();
		comment = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		deleted = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(resignationHistoryId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(resignedDate);

		if (resignedType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resignedType);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
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
		objectOutput.writeBoolean(deleted);
	}

	public long resignationHistoryId;
	public long employeeId;
	public long resignedDate;
	public String resignedType;
	public String comment;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;
}