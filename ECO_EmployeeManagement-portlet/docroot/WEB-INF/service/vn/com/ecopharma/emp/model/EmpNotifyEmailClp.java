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

import vn.com.ecopharma.emp.service.ClpSerializer;
import vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpNotifyEmailClp extends BaseModelImpl<EmpNotifyEmail>
	implements EmpNotifyEmail {
	public EmpNotifyEmailClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpNotifyEmail.class;
	}

	@Override
	public String getModelClassName() {
		return EmpNotifyEmail.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empNotifyEmailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpNotifyEmailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empNotifyEmailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empNotifyEmailId", getEmpNotifyEmailId());
		attributes.put("empId", getEmpId());
		attributes.put("notifyType", getNotifyType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long empNotifyEmailId = (Long)attributes.get("empNotifyEmailId");

		if (empNotifyEmailId != null) {
			setEmpNotifyEmailId(empNotifyEmailId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String notifyType = (String)attributes.get("notifyType");

		if (notifyType != null) {
			setNotifyType(notifyType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getEmpNotifyEmailId() {
		return _empNotifyEmailId;
	}

	@Override
	public void setEmpNotifyEmailId(long empNotifyEmailId) {
		_empNotifyEmailId = empNotifyEmailId;

		if (_empNotifyEmailRemoteModel != null) {
			try {
				Class<?> clazz = _empNotifyEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpNotifyEmailId",
						long.class);

				method.invoke(_empNotifyEmailRemoteModel, empNotifyEmailId);
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

		if (_empNotifyEmailRemoteModel != null) {
			try {
				Class<?> clazz = _empNotifyEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empNotifyEmailRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotifyType() {
		return _notifyType;
	}

	@Override
	public void setNotifyType(String notifyType) {
		_notifyType = notifyType;

		if (_empNotifyEmailRemoteModel != null) {
			try {
				Class<?> clazz = _empNotifyEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setNotifyType", String.class);

				method.invoke(_empNotifyEmailRemoteModel, notifyType);
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

		if (_empNotifyEmailRemoteModel != null) {
			try {
				Class<?> clazz = _empNotifyEmailRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_empNotifyEmailRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpNotifyEmailRemoteModel() {
		return _empNotifyEmailRemoteModel;
	}

	public void setEmpNotifyEmailRemoteModel(
		BaseModel<?> empNotifyEmailRemoteModel) {
		_empNotifyEmailRemoteModel = empNotifyEmailRemoteModel;
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

		Class<?> remoteModelClass = _empNotifyEmailRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empNotifyEmailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpNotifyEmailLocalServiceUtil.addEmpNotifyEmail(this);
		}
		else {
			EmpNotifyEmailLocalServiceUtil.updateEmpNotifyEmail(this);
		}
	}

	@Override
	public EmpNotifyEmail toEscapedModel() {
		return (EmpNotifyEmail)ProxyUtil.newProxyInstance(EmpNotifyEmail.class.getClassLoader(),
			new Class[] { EmpNotifyEmail.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpNotifyEmailClp clone = new EmpNotifyEmailClp();

		clone.setEmpNotifyEmailId(getEmpNotifyEmailId());
		clone.setEmpId(getEmpId());
		clone.setNotifyType(getNotifyType());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(EmpNotifyEmail empNotifyEmail) {
		long primaryKey = empNotifyEmail.getPrimaryKey();

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

		if (!(obj instanceof EmpNotifyEmailClp)) {
			return false;
		}

		EmpNotifyEmailClp empNotifyEmail = (EmpNotifyEmailClp)obj;

		long primaryKey = empNotifyEmail.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{empNotifyEmailId=");
		sb.append(getEmpNotifyEmailId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", notifyType=");
		sb.append(getNotifyType());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.EmpNotifyEmail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empNotifyEmailId</column-name><column-value><![CDATA[");
		sb.append(getEmpNotifyEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notifyType</column-name><column-value><![CDATA[");
		sb.append(getNotifyType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _empNotifyEmailId;
	private long _empId;
	private String _notifyType;
	private String _status;
	private BaseModel<?> _empNotifyEmailRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}