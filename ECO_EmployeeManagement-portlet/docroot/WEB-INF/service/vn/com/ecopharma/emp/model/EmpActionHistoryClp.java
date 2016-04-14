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
import vn.com.ecopharma.emp.service.EmpActionHistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpActionHistoryClp extends BaseModelImpl<EmpActionHistory>
	implements EmpActionHistory {
	public EmpActionHistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpActionHistory.class;
	}

	@Override
	public String getModelClassName() {
		return EmpActionHistory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empActionHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpActionHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empActionHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empActionHistoryId", getEmpActionHistoryId());
		attributes.put("empId", getEmpId());
		attributes.put("action", getAction());
		attributes.put("performedBy", getPerformedBy());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("refId", getRefId());
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
		Long empActionHistoryId = (Long)attributes.get("empActionHistoryId");

		if (empActionHistoryId != null) {
			setEmpActionHistoryId(empActionHistoryId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		Long performedBy = (Long)attributes.get("performedBy");

		if (performedBy != null) {
			setPerformedBy(performedBy);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long refId = (Long)attributes.get("refId");

		if (refId != null) {
			setRefId(refId);
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
	public long getEmpActionHistoryId() {
		return _empActionHistoryId;
	}

	@Override
	public void setEmpActionHistoryId(long empActionHistoryId) {
		_empActionHistoryId = empActionHistoryId;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpActionHistoryId",
						long.class);

				method.invoke(_empActionHistoryRemoteModel, empActionHistoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEmpId() {
		return _empId;
	}

	@Override
	public void setEmpId(long empId) {
		_empId = empId;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empActionHistoryRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAction() {
		return _action;
	}

	@Override
	public void setAction(String action) {
		_action = action;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_empActionHistoryRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPerformedBy() {
		return _performedBy;
	}

	@Override
	public void setPerformedBy(long performedBy) {
		_performedBy = performedBy;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setPerformedBy", long.class);

				method.invoke(_empActionHistoryRemoteModel, performedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_empActionHistoryRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_empActionHistoryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRefId() {
		return _refId;
	}

	@Override
	public void setRefId(long refId) {
		_refId = refId;

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setRefId", long.class);

				method.invoke(_empActionHistoryRemoteModel, refId);
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

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empActionHistoryRemoteModel, groupId);
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

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empActionHistoryRemoteModel, companyId);
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

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empActionHistoryRemoteModel, userId);
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

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empActionHistoryRemoteModel, userName);
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

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empActionHistoryRemoteModel, createDate);
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

		if (_empActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _empActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empActionHistoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpActionHistoryRemoteModel() {
		return _empActionHistoryRemoteModel;
	}

	public void setEmpActionHistoryRemoteModel(
		BaseModel<?> empActionHistoryRemoteModel) {
		_empActionHistoryRemoteModel = empActionHistoryRemoteModel;
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

		Class<?> remoteModelClass = _empActionHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empActionHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpActionHistoryLocalServiceUtil.addEmpActionHistory(this);
		}
		else {
			EmpActionHistoryLocalServiceUtil.updateEmpActionHistory(this);
		}
	}

	@Override
	public EmpActionHistory toEscapedModel() {
		return (EmpActionHistory)ProxyUtil.newProxyInstance(EmpActionHistory.class.getClassLoader(),
			new Class[] { EmpActionHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpActionHistoryClp clone = new EmpActionHistoryClp();

		clone.setEmpActionHistoryId(getEmpActionHistoryId());
		clone.setEmpId(getEmpId());
		clone.setAction(getAction());
		clone.setPerformedBy(getPerformedBy());
		clone.setDescription(getDescription());
		clone.setStatus(getStatus());
		clone.setRefId(getRefId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpActionHistory empActionHistory) {
		long primaryKey = empActionHistory.getPrimaryKey();

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

		if (!(obj instanceof EmpActionHistoryClp)) {
			return false;
		}

		EmpActionHistoryClp empActionHistory = (EmpActionHistoryClp)obj;

		long primaryKey = empActionHistory.getPrimaryKey();

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

		sb.append("{empActionHistoryId=");
		sb.append(getEmpActionHistoryId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", performedBy=");
		sb.append(getPerformedBy());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", refId=");
		sb.append(getRefId());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.EmpActionHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empActionHistoryId</column-name><column-value><![CDATA[");
		sb.append(getEmpActionHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>performedBy</column-name><column-value><![CDATA[");
		sb.append(getPerformedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>refId</column-name><column-value><![CDATA[");
		sb.append(getRefId());
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

	private long _empActionHistoryId;
	private long _empId;
	private String _action;
	private long _performedBy;
	private String _description;
	private String _status;
	private long _refId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empActionHistoryRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}