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
import vn.com.ecopharma.emp.service.DevisionGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class DevisionGroupClp extends BaseModelImpl<DevisionGroup>
	implements DevisionGroup {
	public DevisionGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DevisionGroup.class;
	}

	@Override
	public String getModelClassName() {
		return DevisionGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _devisionGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDevisionGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _devisionGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("devisionGroupId", getDevisionGroupId());
		attributes.put("name", getName());
		attributes.put("devisionId", getDevisionId());
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
		Long devisionGroupId = (Long)attributes.get("devisionGroupId");

		if (devisionGroupId != null) {
			setDevisionGroupId(devisionGroupId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long devisionId = (Long)attributes.get("devisionId");

		if (devisionId != null) {
			setDevisionId(devisionId);
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

	@Override
	public long getDevisionGroupId() {
		return _devisionGroupId;
	}

	@Override
	public void setDevisionGroupId(long devisionGroupId) {
		_devisionGroupId = devisionGroupId;

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDevisionGroupId", long.class);

				method.invoke(_devisionGroupRemoteModel, devisionGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_devisionGroupRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDevisionId() {
		return _devisionId;
	}

	@Override
	public void setDevisionId(long devisionId) {
		_devisionId = devisionId;

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setDevisionId", long.class);

				method.invoke(_devisionGroupRemoteModel, devisionId);
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

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_devisionGroupRemoteModel, groupId);
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

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_devisionGroupRemoteModel, companyId);
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

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_devisionGroupRemoteModel, userId);
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

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_devisionGroupRemoteModel, userName);
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

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_devisionGroupRemoteModel, createDate);
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

		if (_devisionGroupRemoteModel != null) {
			try {
				Class<?> clazz = _devisionGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_devisionGroupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDevisionGroupRemoteModel() {
		return _devisionGroupRemoteModel;
	}

	public void setDevisionGroupRemoteModel(
		BaseModel<?> devisionGroupRemoteModel) {
		_devisionGroupRemoteModel = devisionGroupRemoteModel;
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

		Class<?> remoteModelClass = _devisionGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_devisionGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DevisionGroupLocalServiceUtil.addDevisionGroup(this);
		}
		else {
			DevisionGroupLocalServiceUtil.updateDevisionGroup(this);
		}
	}

	@Override
	public DevisionGroup toEscapedModel() {
		return (DevisionGroup)ProxyUtil.newProxyInstance(DevisionGroup.class.getClassLoader(),
			new Class[] { DevisionGroup.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DevisionGroupClp clone = new DevisionGroupClp();

		clone.setDevisionGroupId(getDevisionGroupId());
		clone.setName(getName());
		clone.setDevisionId(getDevisionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(DevisionGroup devisionGroup) {
		long primaryKey = devisionGroup.getPrimaryKey();

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

		if (!(obj instanceof DevisionGroupClp)) {
			return false;
		}

		DevisionGroupClp devisionGroup = (DevisionGroupClp)obj;

		long primaryKey = devisionGroup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{devisionGroupId=");
		sb.append(getDevisionGroupId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", devisionId=");
		sb.append(getDevisionId());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.DevisionGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>devisionGroupId</column-name><column-value><![CDATA[");
		sb.append(getDevisionGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>devisionId</column-name><column-value><![CDATA[");
		sb.append(getDevisionId());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _devisionGroupId;
	private String _name;
	private long _devisionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _devisionGroupRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}