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
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpOrgRelationshipClp extends BaseModelImpl<EmpOrgRelationship>
	implements EmpOrgRelationship {
	public EmpOrgRelationshipClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpOrgRelationship.class;
	}

	@Override
	public String getModelClassName() {
		return EmpOrgRelationship.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empOrgRelationshipId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpOrgRelationshipId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empOrgRelationshipId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empOrgRelationshipId", getEmpOrgRelationshipId());
		attributes.put("empId", getEmpId());
		attributes.put("orgClassName", getOrgClassName());
		attributes.put("orgClassPK", getOrgClassPK());
		attributes.put("headOfOrg", getHeadOfOrg());
		attributes.put("deputyOfOrg", getDeputyOfOrg());
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
		Long empOrgRelationshipId = (Long)attributes.get("empOrgRelationshipId");

		if (empOrgRelationshipId != null) {
			setEmpOrgRelationshipId(empOrgRelationshipId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String orgClassName = (String)attributes.get("orgClassName");

		if (orgClassName != null) {
			setOrgClassName(orgClassName);
		}

		Long orgClassPK = (Long)attributes.get("orgClassPK");

		if (orgClassPK != null) {
			setOrgClassPK(orgClassPK);
		}

		Boolean headOfOrg = (Boolean)attributes.get("headOfOrg");

		if (headOfOrg != null) {
			setHeadOfOrg(headOfOrg);
		}

		Boolean deputyOfOrg = (Boolean)attributes.get("deputyOfOrg");

		if (deputyOfOrg != null) {
			setDeputyOfOrg(deputyOfOrg);
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
	public long getEmpOrgRelationshipId() {
		return _empOrgRelationshipId;
	}

	@Override
	public void setEmpOrgRelationshipId(long empOrgRelationshipId) {
		_empOrgRelationshipId = empOrgRelationshipId;

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpOrgRelationshipId",
						long.class);

				method.invoke(_empOrgRelationshipRemoteModel,
					empOrgRelationshipId);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empOrgRelationshipRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrgClassName() {
		return _orgClassName;
	}

	@Override
	public void setOrgClassName(String orgClassName) {
		_orgClassName = orgClassName;

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgClassName", String.class);

				method.invoke(_empOrgRelationshipRemoteModel, orgClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrgClassPK() {
		return _orgClassPK;
	}

	@Override
	public void setOrgClassPK(long orgClassPK) {
		_orgClassPK = orgClassPK;

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgClassPK", long.class);

				method.invoke(_empOrgRelationshipRemoteModel, orgClassPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHeadOfOrg() {
		return _headOfOrg;
	}

	@Override
	public boolean isHeadOfOrg() {
		return _headOfOrg;
	}

	@Override
	public void setHeadOfOrg(boolean headOfOrg) {
		_headOfOrg = headOfOrg;

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setHeadOfOrg", boolean.class);

				method.invoke(_empOrgRelationshipRemoteModel, headOfOrg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeputyOfOrg() {
		return _deputyOfOrg;
	}

	@Override
	public boolean isDeputyOfOrg() {
		return _deputyOfOrg;
	}

	@Override
	public void setDeputyOfOrg(boolean deputyOfOrg) {
		_deputyOfOrg = deputyOfOrg;

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setDeputyOfOrg", boolean.class);

				method.invoke(_empOrgRelationshipRemoteModel, deputyOfOrg);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empOrgRelationshipRemoteModel, groupId);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empOrgRelationshipRemoteModel, companyId);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empOrgRelationshipRemoteModel, userId);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empOrgRelationshipRemoteModel, userName);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empOrgRelationshipRemoteModel, createDate);
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

		if (_empOrgRelationshipRemoteModel != null) {
			try {
				Class<?> clazz = _empOrgRelationshipRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empOrgRelationshipRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpOrgRelationshipRemoteModel() {
		return _empOrgRelationshipRemoteModel;
	}

	public void setEmpOrgRelationshipRemoteModel(
		BaseModel<?> empOrgRelationshipRemoteModel) {
		_empOrgRelationshipRemoteModel = empOrgRelationshipRemoteModel;
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

		Class<?> remoteModelClass = _empOrgRelationshipRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empOrgRelationshipRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpOrgRelationshipLocalServiceUtil.addEmpOrgRelationship(this);
		}
		else {
			EmpOrgRelationshipLocalServiceUtil.updateEmpOrgRelationship(this);
		}
	}

	@Override
	public EmpOrgRelationship toEscapedModel() {
		return (EmpOrgRelationship)ProxyUtil.newProxyInstance(EmpOrgRelationship.class.getClassLoader(),
			new Class[] { EmpOrgRelationship.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpOrgRelationshipClp clone = new EmpOrgRelationshipClp();

		clone.setEmpOrgRelationshipId(getEmpOrgRelationshipId());
		clone.setEmpId(getEmpId());
		clone.setOrgClassName(getOrgClassName());
		clone.setOrgClassPK(getOrgClassPK());
		clone.setHeadOfOrg(getHeadOfOrg());
		clone.setDeputyOfOrg(getDeputyOfOrg());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpOrgRelationship empOrgRelationship) {
		long primaryKey = empOrgRelationship.getPrimaryKey();

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

		if (!(obj instanceof EmpOrgRelationshipClp)) {
			return false;
		}

		EmpOrgRelationshipClp empOrgRelationship = (EmpOrgRelationshipClp)obj;

		long primaryKey = empOrgRelationship.getPrimaryKey();

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

		sb.append("{empOrgRelationshipId=");
		sb.append(getEmpOrgRelationshipId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", orgClassName=");
		sb.append(getOrgClassName());
		sb.append(", orgClassPK=");
		sb.append(getOrgClassPK());
		sb.append(", headOfOrg=");
		sb.append(getHeadOfOrg());
		sb.append(", deputyOfOrg=");
		sb.append(getDeputyOfOrg());
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
		sb.append("vn.com.ecopharma.emp.model.EmpOrgRelationship");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empOrgRelationshipId</column-name><column-value><![CDATA[");
		sb.append(getEmpOrgRelationshipId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgClassName</column-name><column-value><![CDATA[");
		sb.append(getOrgClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgClassPK</column-name><column-value><![CDATA[");
		sb.append(getOrgClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>headOfOrg</column-name><column-value><![CDATA[");
		sb.append(getHeadOfOrg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deputyOfOrg</column-name><column-value><![CDATA[");
		sb.append(getDeputyOfOrg());
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

	private long _empOrgRelationshipId;
	private long _empId;
	private String _orgClassName;
	private long _orgClassPK;
	private boolean _headOfOrg;
	private boolean _deputyOfOrg;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empOrgRelationshipRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}