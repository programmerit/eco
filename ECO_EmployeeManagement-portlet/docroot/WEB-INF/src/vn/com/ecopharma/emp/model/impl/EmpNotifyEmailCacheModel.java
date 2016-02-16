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

import vn.com.ecopharma.emp.model.EmpNotifyEmail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing EmpNotifyEmail in entity cache.
 *
 * @author tvt
 * @see EmpNotifyEmail
 * @generated
 */
public class EmpNotifyEmailCacheModel implements CacheModel<EmpNotifyEmail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{empNotifyEmailId=");
		sb.append(empNotifyEmailId);
		sb.append(", empId=");
		sb.append(empId);
		sb.append(", notifyType=");
		sb.append(notifyType);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EmpNotifyEmail toEntityModel() {
		EmpNotifyEmailImpl empNotifyEmailImpl = new EmpNotifyEmailImpl();

		empNotifyEmailImpl.setEmpNotifyEmailId(empNotifyEmailId);
		empNotifyEmailImpl.setEmpId(empId);

		if (notifyType == null) {
			empNotifyEmailImpl.setNotifyType(StringPool.BLANK);
		}
		else {
			empNotifyEmailImpl.setNotifyType(notifyType);
		}

		if (status == null) {
			empNotifyEmailImpl.setStatus(StringPool.BLANK);
		}
		else {
			empNotifyEmailImpl.setStatus(status);
		}

		empNotifyEmailImpl.resetOriginalValues();

		return empNotifyEmailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		empNotifyEmailId = objectInput.readLong();
		empId = objectInput.readLong();
		notifyType = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(empNotifyEmailId);
		objectOutput.writeLong(empId);

		if (notifyType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notifyType);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long empNotifyEmailId;
	public long empId;
	public String notifyType;
	public String status;
}