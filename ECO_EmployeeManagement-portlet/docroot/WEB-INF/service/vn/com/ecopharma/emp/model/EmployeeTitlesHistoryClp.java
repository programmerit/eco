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
import vn.com.ecopharma.emp.service.EmployeeTitlesHistoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmployeeTitlesHistoryClp extends BaseModelImpl<EmployeeTitlesHistory>
	implements EmployeeTitlesHistory {
	public EmployeeTitlesHistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeTitlesHistory.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeTitlesHistory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _employeeTitlesHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeTitlesHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeTitlesHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeTitlesHistoryId", getEmployeeTitlesHistoryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("titlesId", getTitlesId());
		attributes.put("setDate", getSetDate());
		attributes.put("note", getNote());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employeeTitlesHistoryId = (Long)attributes.get(
				"employeeTitlesHistoryId");

		if (employeeTitlesHistoryId != null) {
			setEmployeeTitlesHistoryId(employeeTitlesHistoryId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Date setDate = (Date)attributes.get("setDate");

		if (setDate != null) {
			setSetDate(setDate);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
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
	public long getEmployeeTitlesHistoryId() {
		return _employeeTitlesHistoryId;
	}

	@Override
	public void setEmployeeTitlesHistoryId(long employeeTitlesHistoryId) {
		_employeeTitlesHistoryId = employeeTitlesHistoryId;

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeTitlesHistoryId",
						long.class);

				method.invoke(_employeeTitlesHistoryRemoteModel,
					employeeTitlesHistoryId);
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

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, employeeId);
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

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, titlesId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getSetDate() {
		return _setDate;
	}

	@Override
	public void setSetDate(Date setDate) {
		_setDate = setDate;

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setSetDate", Date.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, setDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, note);
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

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, groupId);
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

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, companyId);
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

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, createDate);
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

		if (_employeeTitlesHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _employeeTitlesHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_employeeTitlesHistoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmployeeTitlesHistoryRemoteModel() {
		return _employeeTitlesHistoryRemoteModel;
	}

	public void setEmployeeTitlesHistoryRemoteModel(
		BaseModel<?> employeeTitlesHistoryRemoteModel) {
		_employeeTitlesHistoryRemoteModel = employeeTitlesHistoryRemoteModel;
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

		Class<?> remoteModelClass = _employeeTitlesHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_employeeTitlesHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeTitlesHistoryLocalServiceUtil.addEmployeeTitlesHistory(this);
		}
		else {
			EmployeeTitlesHistoryLocalServiceUtil.updateEmployeeTitlesHistory(this);
		}
	}

	@Override
	public EmployeeTitlesHistory toEscapedModel() {
		return (EmployeeTitlesHistory)ProxyUtil.newProxyInstance(EmployeeTitlesHistory.class.getClassLoader(),
			new Class[] { EmployeeTitlesHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeTitlesHistoryClp clone = new EmployeeTitlesHistoryClp();

		clone.setEmployeeTitlesHistoryId(getEmployeeTitlesHistoryId());
		clone.setEmployeeId(getEmployeeId());
		clone.setTitlesId(getTitlesId());
		clone.setSetDate(getSetDate());
		clone.setNote(getNote());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmployeeTitlesHistory employeeTitlesHistory) {
		long primaryKey = employeeTitlesHistory.getPrimaryKey();

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

		if (!(obj instanceof EmployeeTitlesHistoryClp)) {
			return false;
		}

		EmployeeTitlesHistoryClp employeeTitlesHistory = (EmployeeTitlesHistoryClp)obj;

		long primaryKey = employeeTitlesHistory.getPrimaryKey();

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

		sb.append("{employeeTitlesHistoryId=");
		sb.append(getEmployeeTitlesHistoryId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", setDate=");
		sb.append(getSetDate());
		sb.append(", note=");
		sb.append(getNote());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
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
		sb.append("vn.com.ecopharma.emp.model.EmployeeTitlesHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>employeeTitlesHistoryId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeTitlesHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>setDate</column-name><column-value><![CDATA[");
		sb.append(getSetDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
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

	private long _employeeTitlesHistoryId;
	private long _employeeId;
	private long _titlesId;
	private Date _setDate;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _employeeTitlesHistoryRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}