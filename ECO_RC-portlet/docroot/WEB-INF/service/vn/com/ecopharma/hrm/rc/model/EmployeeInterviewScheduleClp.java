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

package vn.com.ecopharma.hrm.rc.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.ecopharma.hrm.rc.service.ClpSerializer;
import vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmployeeInterviewScheduleClp extends BaseModelImpl<EmployeeInterviewSchedule>
	implements EmployeeInterviewSchedule {
	public EmployeeInterviewScheduleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmployeeInterviewSchedule.class;
	}

	@Override
	public String getModelClassName() {
		return EmployeeInterviewSchedule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _employeeInterviewScheduleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmployeeInterviewScheduleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employeeInterviewScheduleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employeeInterviewScheduleId",
			getEmployeeInterviewScheduleId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("interviewScheduleId", getInterviewScheduleId());
		attributes.put("note", getNote());
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
		Long employeeInterviewScheduleId = (Long)attributes.get(
				"employeeInterviewScheduleId");

		if (employeeInterviewScheduleId != null) {
			setEmployeeInterviewScheduleId(employeeInterviewScheduleId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long interviewScheduleId = (Long)attributes.get("interviewScheduleId");

		if (interviewScheduleId != null) {
			setInterviewScheduleId(interviewScheduleId);
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
	public long getEmployeeInterviewScheduleId() {
		return _employeeInterviewScheduleId;
	}

	@Override
	public void setEmployeeInterviewScheduleId(long employeeInterviewScheduleId) {
		_employeeInterviewScheduleId = employeeInterviewScheduleId;

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeInterviewScheduleId",
						long.class);

				method.invoke(_employeeInterviewScheduleRemoteModel,
					employeeInterviewScheduleId);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setEmployeeId", long.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, employeeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInterviewScheduleId() {
		return _interviewScheduleId;
	}

	@Override
	public void setInterviewScheduleId(long interviewScheduleId) {
		_interviewScheduleId = interviewScheduleId;

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setInterviewScheduleId",
						long.class);

				method.invoke(_employeeInterviewScheduleRemoteModel,
					interviewScheduleId);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, note);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, groupId);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, companyId);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, userId);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, userName);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_employeeInterviewScheduleRemoteModel, createDate);
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

		if (_employeeInterviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _employeeInterviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_employeeInterviewScheduleRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmployeeInterviewScheduleRemoteModel() {
		return _employeeInterviewScheduleRemoteModel;
	}

	public void setEmployeeInterviewScheduleRemoteModel(
		BaseModel<?> employeeInterviewScheduleRemoteModel) {
		_employeeInterviewScheduleRemoteModel = employeeInterviewScheduleRemoteModel;
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

		Class<?> remoteModelClass = _employeeInterviewScheduleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_employeeInterviewScheduleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmployeeInterviewScheduleLocalServiceUtil.addEmployeeInterviewSchedule(this);
		}
		else {
			EmployeeInterviewScheduleLocalServiceUtil.updateEmployeeInterviewSchedule(this);
		}
	}

	@Override
	public EmployeeInterviewSchedule toEscapedModel() {
		return (EmployeeInterviewSchedule)ProxyUtil.newProxyInstance(EmployeeInterviewSchedule.class.getClassLoader(),
			new Class[] { EmployeeInterviewSchedule.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmployeeInterviewScheduleClp clone = new EmployeeInterviewScheduleClp();

		clone.setEmployeeInterviewScheduleId(getEmployeeInterviewScheduleId());
		clone.setEmployeeId(getEmployeeId());
		clone.setInterviewScheduleId(getInterviewScheduleId());
		clone.setNote(getNote());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmployeeInterviewSchedule employeeInterviewSchedule) {
		long primaryKey = employeeInterviewSchedule.getPrimaryKey();

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

		if (!(obj instanceof EmployeeInterviewScheduleClp)) {
			return false;
		}

		EmployeeInterviewScheduleClp employeeInterviewSchedule = (EmployeeInterviewScheduleClp)obj;

		long primaryKey = employeeInterviewSchedule.getPrimaryKey();

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

		sb.append("{employeeInterviewScheduleId=");
		sb.append(getEmployeeInterviewScheduleId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", interviewScheduleId=");
		sb.append(getInterviewScheduleId());
		sb.append(", note=");
		sb.append(getNote());
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
		sb.append("vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>employeeInterviewScheduleId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeInterviewScheduleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewScheduleId</column-name><column-value><![CDATA[");
		sb.append(getInterviewScheduleId());
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

	private long _employeeInterviewScheduleId;
	private long _employeeId;
	private long _interviewScheduleId;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _employeeInterviewScheduleRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}