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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.ecopharma.emp.service.ClpSerializer;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class PromotedHistoryClp extends BaseModelImpl<PromotedHistory>
	implements PromotedHistory {
	public PromotedHistoryClp() {
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
	public long getPrimaryKey() {
		return _promotedHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPromotedHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _promotedHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getPromotedHistoryId() {
		return _promotedHistoryId;
	}

	@Override
	public void setPromotedHistoryId(long promotedHistoryId) {
		_promotedHistoryId = promotedHistoryId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotedHistoryId",
						long.class);

				method.invoke(_promotedHistoryRemoteModel, promotedHistoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_promotedHistoryRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOldTitlesId() {
		return _oldTitlesId;
	}

	@Override
	public void setOldTitlesId(long oldTitlesId) {
		_oldTitlesId = oldTitlesId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setOldTitlesId", long.class);

				method.invoke(_promotedHistoryRemoteModel, oldTitlesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNewTitlesId() {
		return _newTitlesId;
	}

	@Override
	public void setNewTitlesId(long newTitlesId) {
		_newTitlesId = newTitlesId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setNewTitlesId", long.class);

				method.invoke(_promotedHistoryRemoteModel, newTitlesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPromotedDate() {
		return _promotedDate;
	}

	@Override
	public void setPromotedDate(Date promotedDate) {
		_promotedDate = promotedDate;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPromotedDate", Date.class);

				method.invoke(_promotedHistoryRemoteModel, promotedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComment() {
		return _comment;
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_promotedHistoryRemoteModel, comment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_promotedHistoryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_promotedHistoryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_promotedHistoryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_promotedHistoryRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_promotedHistoryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_promotedHistoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_deleted = deleted;

		if (_promotedHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _promotedHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_promotedHistoryRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPromotedHistoryRemoteModel() {
		return _promotedHistoryRemoteModel;
	}

	public void setPromotedHistoryRemoteModel(
		BaseModel<?> promotedHistoryRemoteModel) {
		_promotedHistoryRemoteModel = promotedHistoryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _promotedHistoryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_promotedHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PromotedHistoryLocalServiceUtil.addPromotedHistory(this);
		}
		else {
			PromotedHistoryLocalServiceUtil.updatePromotedHistory(this);
		}
	}

	@Override
	public PromotedHistory toEscapedModel() {
		return (PromotedHistory)ProxyUtil.newProxyInstance(PromotedHistory.class.getClassLoader(),
			new Class[] { PromotedHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PromotedHistoryClp clone = new PromotedHistoryClp();

		clone.setPromotedHistoryId(getPromotedHistoryId());
		clone.setEmployeeId(getEmployeeId());
		clone.setOldTitlesId(getOldTitlesId());
		clone.setNewTitlesId(getNewTitlesId());
		clone.setPromotedDate(getPromotedDate());
		clone.setComment(getComment());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDeleted(getDeleted());

		return clone;
	}

	@Override
	public int compareTo(PromotedHistory promotedHistory) {
		long primaryKey = promotedHistory.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PromotedHistoryClp)) {
			return false;
		}

		PromotedHistoryClp promotedHistory = (PromotedHistoryClp)obj;

		long primaryKey = promotedHistory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{promotedHistoryId=");
		sb.append(getPromotedHistoryId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", oldTitlesId=");
		sb.append(getOldTitlesId());
		sb.append(", newTitlesId=");
		sb.append(getNewTitlesId());
		sb.append(", promotedDate=");
		sb.append(getPromotedDate());
		sb.append(", comment=");
		sb.append(getComment());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.PromotedHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>promotedHistoryId</column-name><column-value><![CDATA[");
		sb.append(getPromotedHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oldTitlesId</column-name><column-value><![CDATA[");
		sb.append(getOldTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newTitlesId</column-name><column-value><![CDATA[");
		sb.append(getNewTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotedDate</column-name><column-value><![CDATA[");
		sb.append(getPromotedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _promotedHistoryId;
	private long _employeeId;
	private long _oldTitlesId;
	private long _newTitlesId;
	private Date _promotedDate;
	private String _comment;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BaseModel<?> _promotedHistoryRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}