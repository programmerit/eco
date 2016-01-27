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
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpDisciplineClp extends BaseModelImpl<EmpDiscipline>
	implements EmpDiscipline {
	public EmpDisciplineClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpDiscipline.class;
	}

	@Override
	public String getModelClassName() {
		return EmpDiscipline.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empDisciplineId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpDisciplineId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empDisciplineId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empDisciplineId", getEmpDisciplineId());
		attributes.put("empId", getEmpId());
		attributes.put("content", getContent());
		attributes.put("disciplineType", getDisciplineType());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("additionalDisciplineType", getAdditionalDisciplineType());
		attributes.put("description", getDescription());
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
		Long empDisciplineId = (Long)attributes.get("empDisciplineId");

		if (empDisciplineId != null) {
			setEmpDisciplineId(empDisciplineId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String disciplineType = (String)attributes.get("disciplineType");

		if (disciplineType != null) {
			setDisciplineType(disciplineType);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		String additionalDisciplineType = (String)attributes.get(
				"additionalDisciplineType");

		if (additionalDisciplineType != null) {
			setAdditionalDisciplineType(additionalDisciplineType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	public long getEmpDisciplineId() {
		return _empDisciplineId;
	}

	@Override
	public void setEmpDisciplineId(long empDisciplineId) {
		_empDisciplineId = empDisciplineId;

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpDisciplineId", long.class);

				method.invoke(_empDisciplineRemoteModel, empDisciplineId);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empDisciplineRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_empDisciplineRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDisciplineType() {
		return _disciplineType;
	}

	@Override
	public void setDisciplineType(String disciplineType) {
		_disciplineType = disciplineType;

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setDisciplineType",
						String.class);

				method.invoke(_empDisciplineRemoteModel, disciplineType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_empDisciplineRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAdditionalDisciplineType() {
		return _additionalDisciplineType;
	}

	@Override
	public void setAdditionalDisciplineType(String additionalDisciplineType) {
		_additionalDisciplineType = additionalDisciplineType;

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setAdditionalDisciplineType",
						String.class);

				method.invoke(_empDisciplineRemoteModel,
					additionalDisciplineType);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_empDisciplineRemoteModel, description);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empDisciplineRemoteModel, groupId);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empDisciplineRemoteModel, companyId);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empDisciplineRemoteModel, userId);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empDisciplineRemoteModel, userName);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empDisciplineRemoteModel, createDate);
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

		if (_empDisciplineRemoteModel != null) {
			try {
				Class<?> clazz = _empDisciplineRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empDisciplineRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpDisciplineRemoteModel() {
		return _empDisciplineRemoteModel;
	}

	public void setEmpDisciplineRemoteModel(
		BaseModel<?> empDisciplineRemoteModel) {
		_empDisciplineRemoteModel = empDisciplineRemoteModel;
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

		Class<?> remoteModelClass = _empDisciplineRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empDisciplineRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpDisciplineLocalServiceUtil.addEmpDiscipline(this);
		}
		else {
			EmpDisciplineLocalServiceUtil.updateEmpDiscipline(this);
		}
	}

	@Override
	public EmpDiscipline toEscapedModel() {
		return (EmpDiscipline)ProxyUtil.newProxyInstance(EmpDiscipline.class.getClassLoader(),
			new Class[] { EmpDiscipline.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpDisciplineClp clone = new EmpDisciplineClp();

		clone.setEmpDisciplineId(getEmpDisciplineId());
		clone.setEmpId(getEmpId());
		clone.setContent(getContent());
		clone.setDisciplineType(getDisciplineType());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setAdditionalDisciplineType(getAdditionalDisciplineType());
		clone.setDescription(getDescription());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpDiscipline empDiscipline) {
		long primaryKey = empDiscipline.getPrimaryKey();

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

		if (!(obj instanceof EmpDisciplineClp)) {
			return false;
		}

		EmpDisciplineClp empDiscipline = (EmpDisciplineClp)obj;

		long primaryKey = empDiscipline.getPrimaryKey();

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

		sb.append("{empDisciplineId=");
		sb.append(getEmpDisciplineId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", disciplineType=");
		sb.append(getDisciplineType());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", additionalDisciplineType=");
		sb.append(getAdditionalDisciplineType());
		sb.append(", description=");
		sb.append(getDescription());
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
		sb.append("vn.com.ecopharma.emp.model.EmpDiscipline");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empDisciplineId</column-name><column-value><![CDATA[");
		sb.append(getEmpDisciplineId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>disciplineType</column-name><column-value><![CDATA[");
		sb.append(getDisciplineType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>additionalDisciplineType</column-name><column-value><![CDATA[");
		sb.append(getAdditionalDisciplineType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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

	private long _empDisciplineId;
	private long _empId;
	private String _content;
	private String _disciplineType;
	private Date _effectiveDate;
	private String _additionalDisciplineType;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empDisciplineRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}