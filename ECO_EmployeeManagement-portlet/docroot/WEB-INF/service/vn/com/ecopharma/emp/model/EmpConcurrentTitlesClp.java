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
import vn.com.ecopharma.emp.service.EmpConcurrentTitlesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpConcurrentTitlesClp extends BaseModelImpl<EmpConcurrentTitles>
	implements EmpConcurrentTitles {
	public EmpConcurrentTitlesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpConcurrentTitles.class;
	}

	@Override
	public String getModelClassName() {
		return EmpConcurrentTitles.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empConcurrentTitlesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpConcurrentTitlesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empConcurrentTitlesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empConcurrentTitlesId", getEmpConcurrentTitlesId());
		attributes.put("empId", getEmpId());
		attributes.put("titlesId", getTitlesId());
		attributes.put("unitGroupId", getUnitGroupId());
		attributes.put("unitId", getUnitId());
		attributes.put("departmentId", getDepartmentId());
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
		Long empConcurrentTitlesId = (Long)attributes.get(
				"empConcurrentTitlesId");

		if (empConcurrentTitlesId != null) {
			setEmpConcurrentTitlesId(empConcurrentTitlesId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
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
	public long getEmpConcurrentTitlesId() {
		return _empConcurrentTitlesId;
	}

	@Override
	public void setEmpConcurrentTitlesId(long empConcurrentTitlesId) {
		_empConcurrentTitlesId = empConcurrentTitlesId;

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpConcurrentTitlesId",
						long.class);

				method.invoke(_empConcurrentTitlesRemoteModel,
					empConcurrentTitlesId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, empId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, titlesId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitGroupId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, unitGroupId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setUnitId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, unitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, departmentId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, groupId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, companyId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empConcurrentTitlesRemoteModel, userId);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empConcurrentTitlesRemoteModel, userName);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empConcurrentTitlesRemoteModel, createDate);
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

		if (_empConcurrentTitlesRemoteModel != null) {
			try {
				Class<?> clazz = _empConcurrentTitlesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empConcurrentTitlesRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpConcurrentTitlesRemoteModel() {
		return _empConcurrentTitlesRemoteModel;
	}

	public void setEmpConcurrentTitlesRemoteModel(
		BaseModel<?> empConcurrentTitlesRemoteModel) {
		_empConcurrentTitlesRemoteModel = empConcurrentTitlesRemoteModel;
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

		Class<?> remoteModelClass = _empConcurrentTitlesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empConcurrentTitlesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpConcurrentTitlesLocalServiceUtil.addEmpConcurrentTitles(this);
		}
		else {
			EmpConcurrentTitlesLocalServiceUtil.updateEmpConcurrentTitles(this);
		}
	}

	@Override
	public EmpConcurrentTitles toEscapedModel() {
		return (EmpConcurrentTitles)ProxyUtil.newProxyInstance(EmpConcurrentTitles.class.getClassLoader(),
			new Class[] { EmpConcurrentTitles.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpConcurrentTitlesClp clone = new EmpConcurrentTitlesClp();

		clone.setEmpConcurrentTitlesId(getEmpConcurrentTitlesId());
		clone.setEmpId(getEmpId());
		clone.setTitlesId(getTitlesId());
		clone.setUnitGroupId(getUnitGroupId());
		clone.setUnitId(getUnitId());
		clone.setDepartmentId(getDepartmentId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpConcurrentTitles empConcurrentTitles) {
		long primaryKey = empConcurrentTitles.getPrimaryKey();

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

		if (!(obj instanceof EmpConcurrentTitlesClp)) {
			return false;
		}

		EmpConcurrentTitlesClp empConcurrentTitles = (EmpConcurrentTitlesClp)obj;

		long primaryKey = empConcurrentTitles.getPrimaryKey();

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

		sb.append("{empConcurrentTitlesId=");
		sb.append(getEmpConcurrentTitlesId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", unitGroupId=");
		sb.append(getUnitGroupId());
		sb.append(", unitId=");
		sb.append(getUnitId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.EmpConcurrentTitles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empConcurrentTitlesId</column-name><column-value><![CDATA[");
		sb.append(getEmpConcurrentTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitGroupId</column-name><column-value><![CDATA[");
		sb.append(getUnitGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
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

	private long _empConcurrentTitlesId;
	private long _empId;
	private long _titlesId;
	private long _unitGroupId;
	private long _unitId;
	private long _departmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empConcurrentTitlesRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}