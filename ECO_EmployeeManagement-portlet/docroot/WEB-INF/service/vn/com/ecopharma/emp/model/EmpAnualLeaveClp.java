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
import vn.com.ecopharma.emp.service.EmpAnualLeaveLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpAnualLeaveClp extends BaseModelImpl<EmpAnualLeave>
	implements EmpAnualLeave {
	public EmpAnualLeaveClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpAnualLeave.class;
	}

	@Override
	public String getModelClassName() {
		return EmpAnualLeave.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empAnualLeaveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpAnualLeaveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empAnualLeaveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empAnualLeaveId", getEmpAnualLeaveId());
		attributes.put("empId", getEmpId());
		attributes.put("noOfAnualLeave", getNoOfAnualLeave());
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
		Long empAnualLeaveId = (Long)attributes.get("empAnualLeaveId");

		if (empAnualLeaveId != null) {
			setEmpAnualLeaveId(empAnualLeaveId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Double noOfAnualLeave = (Double)attributes.get("noOfAnualLeave");

		if (noOfAnualLeave != null) {
			setNoOfAnualLeave(noOfAnualLeave);
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
	public long getEmpAnualLeaveId() {
		return _empAnualLeaveId;
	}

	@Override
	public void setEmpAnualLeaveId(long empAnualLeaveId) {
		_empAnualLeaveId = empAnualLeaveId;

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpAnualLeaveId", long.class);

				method.invoke(_empAnualLeaveRemoteModel, empAnualLeaveId);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empAnualLeaveRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getNoOfAnualLeave() {
		return _noOfAnualLeave;
	}

	@Override
	public void setNoOfAnualLeave(double noOfAnualLeave) {
		_noOfAnualLeave = noOfAnualLeave;

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setNoOfAnualLeave",
						double.class);

				method.invoke(_empAnualLeaveRemoteModel, noOfAnualLeave);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empAnualLeaveRemoteModel, groupId);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empAnualLeaveRemoteModel, companyId);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empAnualLeaveRemoteModel, userId);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empAnualLeaveRemoteModel, userName);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empAnualLeaveRemoteModel, createDate);
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

		if (_empAnualLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _empAnualLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empAnualLeaveRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpAnualLeaveRemoteModel() {
		return _empAnualLeaveRemoteModel;
	}

	public void setEmpAnualLeaveRemoteModel(
		BaseModel<?> empAnualLeaveRemoteModel) {
		_empAnualLeaveRemoteModel = empAnualLeaveRemoteModel;
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

		Class<?> remoteModelClass = _empAnualLeaveRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empAnualLeaveRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpAnualLeaveLocalServiceUtil.addEmpAnualLeave(this);
		}
		else {
			EmpAnualLeaveLocalServiceUtil.updateEmpAnualLeave(this);
		}
	}

	@Override
	public EmpAnualLeave toEscapedModel() {
		return (EmpAnualLeave)ProxyUtil.newProxyInstance(EmpAnualLeave.class.getClassLoader(),
			new Class[] { EmpAnualLeave.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpAnualLeaveClp clone = new EmpAnualLeaveClp();

		clone.setEmpAnualLeaveId(getEmpAnualLeaveId());
		clone.setEmpId(getEmpId());
		clone.setNoOfAnualLeave(getNoOfAnualLeave());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpAnualLeave empAnualLeave) {
		long primaryKey = empAnualLeave.getPrimaryKey();

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

		if (!(obj instanceof EmpAnualLeaveClp)) {
			return false;
		}

		EmpAnualLeaveClp empAnualLeave = (EmpAnualLeaveClp)obj;

		long primaryKey = empAnualLeave.getPrimaryKey();

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

		sb.append("{empAnualLeaveId=");
		sb.append(getEmpAnualLeaveId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", noOfAnualLeave=");
		sb.append(getNoOfAnualLeave());
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
		sb.append("vn.com.ecopharma.emp.model.EmpAnualLeave");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empAnualLeaveId</column-name><column-value><![CDATA[");
		sb.append(getEmpAnualLeaveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfAnualLeave</column-name><column-value><![CDATA[");
		sb.append(getNoOfAnualLeave());
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

	private long _empAnualLeaveId;
	private long _empId;
	private double _noOfAnualLeave;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empAnualLeaveRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}