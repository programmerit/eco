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
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class ResignationHistoryClp extends BaseModelImpl<ResignationHistory>
	implements ResignationHistory {
	public ResignationHistoryClp() {
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
	public long getPrimaryKey() {
		return _resignationHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResignationHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _resignationHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getResignationHistoryId() {
		return _resignationHistoryId;
	}

	@Override
	public void setResignationHistoryId(long resignationHistoryId) {
		_resignationHistoryId = resignationHistoryId;

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setResignationHistoryId",
						long.class);

				method.invoke(_resignationHistoryRemoteModel,
					resignationHistoryId);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_resignationHistoryRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getResignedDate() {
		return _resignedDate;
	}

	@Override
	public void setResignedDate(Date resignedDate) {
		_resignedDate = resignedDate;

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setResignedDate", Date.class);

				method.invoke(_resignationHistoryRemoteModel, resignedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResignedType() {
		return _resignedType;
	}

	@Override
	public void setResignedType(String resignedType) {
		_resignedType = resignedType;

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setResignedType", String.class);

				method.invoke(_resignationHistoryRemoteModel, resignedType);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setComment", String.class);

				method.invoke(_resignationHistoryRemoteModel, comment);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_resignationHistoryRemoteModel, groupId);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_resignationHistoryRemoteModel, companyId);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_resignationHistoryRemoteModel, userId);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_resignationHistoryRemoteModel, userName);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_resignationHistoryRemoteModel, createDate);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_resignationHistoryRemoteModel, modifiedDate);
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

		if (_resignationHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _resignationHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_resignationHistoryRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getResignationHistoryRemoteModel() {
		return _resignationHistoryRemoteModel;
	}

	public void setResignationHistoryRemoteModel(
		BaseModel<?> resignationHistoryRemoteModel) {
		_resignationHistoryRemoteModel = resignationHistoryRemoteModel;
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

		Class<?> remoteModelClass = _resignationHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_resignationHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ResignationHistoryLocalServiceUtil.addResignationHistory(this);
		}
		else {
			ResignationHistoryLocalServiceUtil.updateResignationHistory(this);
		}
	}

	@Override
	public ResignationHistory toEscapedModel() {
		return (ResignationHistory)ProxyUtil.newProxyInstance(ResignationHistory.class.getClassLoader(),
			new Class[] { ResignationHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ResignationHistoryClp clone = new ResignationHistoryClp();

		clone.setResignationHistoryId(getResignationHistoryId());
		clone.setEmployeeId(getEmployeeId());
		clone.setResignedDate(getResignedDate());
		clone.setResignedType(getResignedType());
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
	public int compareTo(ResignationHistory resignationHistory) {
		long primaryKey = resignationHistory.getPrimaryKey();

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

		if (!(obj instanceof ResignationHistoryClp)) {
			return false;
		}

		ResignationHistoryClp resignationHistory = (ResignationHistoryClp)obj;

		long primaryKey = resignationHistory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{resignationHistoryId=");
		sb.append(getResignationHistoryId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", resignedDate=");
		sb.append(getResignedDate());
		sb.append(", resignedType=");
		sb.append(getResignedType());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.ResignationHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>resignationHistoryId</column-name><column-value><![CDATA[");
		sb.append(getResignationHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resignedDate</column-name><column-value><![CDATA[");
		sb.append(getResignedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resignedType</column-name><column-value><![CDATA[");
		sb.append(getResignedType());
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

	private long _resignationHistoryId;
	private long _employeeId;
	private Date _resignedDate;
	private String _resignedType;
	private String _comment;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BaseModel<?> _resignationHistoryRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}