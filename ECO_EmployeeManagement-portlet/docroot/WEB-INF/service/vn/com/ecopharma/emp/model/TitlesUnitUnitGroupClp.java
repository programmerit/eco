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
import vn.com.ecopharma.emp.service.TitlesUnitUnitGroupLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class TitlesUnitUnitGroupClp extends BaseModelImpl<TitlesUnitUnitGroup>
	implements TitlesUnitUnitGroup {
	public TitlesUnitUnitGroupClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TitlesUnitUnitGroup.class;
	}

	@Override
	public String getModelClassName() {
		return TitlesUnitUnitGroup.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _titlesUnitUnitGroupId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTitlesUnitUnitGroupId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _titlesUnitUnitGroupId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("titlesUnitUnitGroupId", getTitlesUnitUnitGroupId());
		attributes.put("titlesId", getTitlesId());
		attributes.put("unitId", getUnitId());
		attributes.put("unitGroupId", getUnitGroupId());
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
		Long titlesUnitUnitGroupId = (Long)attributes.get(
				"titlesUnitUnitGroupId");

		if (titlesUnitUnitGroupId != null) {
			setTitlesUnitUnitGroupId(titlesUnitUnitGroupId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
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
	public long getTitlesUnitUnitGroupId() {
		return _titlesUnitUnitGroupId;
	}

	@Override
	public void setTitlesUnitUnitGroupId(long titlesUnitUnitGroupId) {
		_titlesUnitUnitGroupId = titlesUnitUnitGroupId;

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesUnitUnitGroupId",
						long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel,
					titlesUnitUnitGroupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTitlesId() {
		return _titlesId;
	}

	@Override
	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, titlesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUnitId() {
		return _unitId;
	}

	@Override
	public void setUnitId(long unitId) {
		_unitId = unitId;

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitId", long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, unitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUnitGroupId() {
		return _unitGroupId;
	}

	@Override
	public void setUnitGroupId(long unitGroupId) {
		_unitGroupId = unitGroupId;

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitGroupId", long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, unitGroupId);
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

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, groupId);
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

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, companyId);
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

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, userId);
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

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, userName);
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

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, createDate);
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

		if (_titlesUnitUnitGroupRemoteModel != null) {
			try {
				Class<?> clazz = _titlesUnitUnitGroupRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_titlesUnitUnitGroupRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTitlesUnitUnitGroupRemoteModel() {
		return _titlesUnitUnitGroupRemoteModel;
	}

	public void setTitlesUnitUnitGroupRemoteModel(
		BaseModel<?> titlesUnitUnitGroupRemoteModel) {
		_titlesUnitUnitGroupRemoteModel = titlesUnitUnitGroupRemoteModel;
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

		Class<?> remoteModelClass = _titlesUnitUnitGroupRemoteModel.getClass();

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

		Object returnValue = method.invoke(_titlesUnitUnitGroupRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TitlesUnitUnitGroupLocalServiceUtil.addTitlesUnitUnitGroup(this);
		}
		else {
			TitlesUnitUnitGroupLocalServiceUtil.updateTitlesUnitUnitGroup(this);
		}
	}

	@Override
	public TitlesUnitUnitGroup toEscapedModel() {
		return (TitlesUnitUnitGroup)ProxyUtil.newProxyInstance(TitlesUnitUnitGroup.class.getClassLoader(),
			new Class[] { TitlesUnitUnitGroup.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TitlesUnitUnitGroupClp clone = new TitlesUnitUnitGroupClp();

		clone.setTitlesUnitUnitGroupId(getTitlesUnitUnitGroupId());
		clone.setTitlesId(getTitlesId());
		clone.setUnitId(getUnitId());
		clone.setUnitGroupId(getUnitGroupId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(TitlesUnitUnitGroup titlesUnitUnitGroup) {
		long primaryKey = titlesUnitUnitGroup.getPrimaryKey();

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

		if (!(obj instanceof TitlesUnitUnitGroupClp)) {
			return false;
		}

		TitlesUnitUnitGroupClp titlesUnitUnitGroup = (TitlesUnitUnitGroupClp)obj;

		long primaryKey = titlesUnitUnitGroup.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{titlesUnitUnitGroupId=");
		sb.append(getTitlesUnitUnitGroupId());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", unitId=");
		sb.append(getUnitId());
		sb.append(", unitGroupId=");
		sb.append(getUnitGroupId());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.TitlesUnitUnitGroup");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>titlesUnitUnitGroupId</column-name><column-value><![CDATA[");
		sb.append(getTitlesUnitUnitGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitGroupId</column-name><column-value><![CDATA[");
		sb.append(getUnitGroupId());
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

	private long _titlesUnitUnitGroupId;
	private long _titlesId;
	private long _unitId;
	private long _unitGroupId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _titlesUnitUnitGroupRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}