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

import vn.com.ecopharma.emp.model.PromotedHistory;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PromotedHistory in entity cache.
 *
 * @author tvt
 * @see PromotedHistory
 * @generated
 */
public class PromotedHistoryCacheModel implements CacheModel<PromotedHistory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{promotedHistoryId=");
		sb.append(promotedHistoryId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", oldTitlesId=");
		sb.append(oldTitlesId);
		sb.append(", newTitlesId=");
		sb.append(newTitlesId);
		sb.append(", promotedDate=");
		sb.append(promotedDate);
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
	public PromotedHistory toEntityModel() {
		PromotedHistoryImpl promotedHistoryImpl = new PromotedHistoryImpl();

		promotedHistoryImpl.setPromotedHistoryId(promotedHistoryId);
		promotedHistoryImpl.setEmployeeId(employeeId);
		promotedHistoryImpl.setOldTitlesId(oldTitlesId);
		promotedHistoryImpl.setNewTitlesId(newTitlesId);

		if (promotedDate == Long.MIN_VALUE) {
			promotedHistoryImpl.setPromotedDate(null);
		}
		else {
			promotedHistoryImpl.setPromotedDate(new Date(promotedDate));
		}

		if (comment == null) {
			promotedHistoryImpl.setComment(StringPool.BLANK);
		}
		else {
			promotedHistoryImpl.setComment(comment);
		}

		promotedHistoryImpl.setGroupId(groupId);
		promotedHistoryImpl.setCompanyId(companyId);
		promotedHistoryImpl.setUserId(userId);

		if (userName == null) {
			promotedHistoryImpl.setUserName(StringPool.BLANK);
		}
		else {
			promotedHistoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			promotedHistoryImpl.setCreateDate(null);
		}
		else {
			promotedHistoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			promotedHistoryImpl.setModifiedDate(null);
		}
		else {
			promotedHistoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		promotedHistoryImpl.setDeleted(deleted);

		promotedHistoryImpl.resetOriginalValues();

		return promotedHistoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		promotedHistoryId = objectInput.readLong();
		employeeId = objectInput.readLong();
		oldTitlesId = objectInput.readLong();
		newTitlesId = objectInput.readLong();
		promotedDate = objectInput.readLong();
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
		objectOutput.writeLong(promotedHistoryId);
		objectOutput.writeLong(employeeId);
		objectOutput.writeLong(oldTitlesId);
		objectOutput.writeLong(newTitlesId);
		objectOutput.writeLong(promotedDate);

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

	public long promotedHistoryId;
	public long employeeId;
	public long oldTitlesId;
	public long newTitlesId;
	public long promotedDate;
	public String comment;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean deleted;
}