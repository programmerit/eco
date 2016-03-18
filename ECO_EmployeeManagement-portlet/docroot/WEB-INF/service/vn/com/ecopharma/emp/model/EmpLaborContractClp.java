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
import vn.com.ecopharma.emp.service.EmpLaborContractLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpLaborContractClp extends BaseModelImpl<EmpLaborContract>
	implements EmpLaborContract {
	public EmpLaborContractClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpLaborContract.class;
	}

	@Override
	public String getModelClassName() {
		return EmpLaborContract.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empLaborContractId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpLaborContractId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empLaborContractId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empLaborContractId", getEmpLaborContractId());
		attributes.put("empId", getEmpId());
		attributes.put("laborContractSignedDate", getLaborContractSignedDate());
		attributes.put("laborContractExpiredDate", getLaborContractExpiredDate());
		attributes.put("laborContractSignedType", getLaborContractSignedType());
		attributes.put("signedTimes", getSignedTimes());
		attributes.put("latest", getLatest());
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
		Long empLaborContractId = (Long)attributes.get("empLaborContractId");

		if (empLaborContractId != null) {
			setEmpLaborContractId(empLaborContractId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Date laborContractSignedDate = (Date)attributes.get(
				"laborContractSignedDate");

		if (laborContractSignedDate != null) {
			setLaborContractSignedDate(laborContractSignedDate);
		}

		Date laborContractExpiredDate = (Date)attributes.get(
				"laborContractExpiredDate");

		if (laborContractExpiredDate != null) {
			setLaborContractExpiredDate(laborContractExpiredDate);
		}

		String laborContractSignedType = (String)attributes.get(
				"laborContractSignedType");

		if (laborContractSignedType != null) {
			setLaborContractSignedType(laborContractSignedType);
		}

		Integer signedTimes = (Integer)attributes.get("signedTimes");

		if (signedTimes != null) {
			setSignedTimes(signedTimes);
		}

		Boolean latest = (Boolean)attributes.get("latest");

		if (latest != null) {
			setLatest(latest);
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
	public long getEmpLaborContractId() {
		return _empLaborContractId;
	}

	@Override
	public void setEmpLaborContractId(long empLaborContractId) {
		_empLaborContractId = empLaborContractId;

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpLaborContractId",
						long.class);

				method.invoke(_empLaborContractRemoteModel, empLaborContractId);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empLaborContractRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLaborContractSignedDate() {
		return _laborContractSignedDate;
	}

	@Override
	public void setLaborContractSignedDate(Date laborContractSignedDate) {
		_laborContractSignedDate = laborContractSignedDate;

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractSignedDate",
						Date.class);

				method.invoke(_empLaborContractRemoteModel,
					laborContractSignedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLaborContractExpiredDate() {
		return _laborContractExpiredDate;
	}

	@Override
	public void setLaborContractExpiredDate(Date laborContractExpiredDate) {
		_laborContractExpiredDate = laborContractExpiredDate;

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractExpiredDate",
						Date.class);

				method.invoke(_empLaborContractRemoteModel,
					laborContractExpiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLaborContractSignedType() {
		return _laborContractSignedType;
	}

	@Override
	public void setLaborContractSignedType(String laborContractSignedType) {
		_laborContractSignedType = laborContractSignedType;

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setLaborContractSignedType",
						String.class);

				method.invoke(_empLaborContractRemoteModel,
					laborContractSignedType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSignedTimes() {
		return _signedTimes;
	}

	@Override
	public void setSignedTimes(int signedTimes) {
		_signedTimes = signedTimes;

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setSignedTimes", int.class);

				method.invoke(_empLaborContractRemoteModel, signedTimes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLatest() {
		return _latest;
	}

	@Override
	public boolean isLatest() {
		return _latest;
	}

	@Override
	public void setLatest(boolean latest) {
		_latest = latest;

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setLatest", boolean.class);

				method.invoke(_empLaborContractRemoteModel, latest);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empLaborContractRemoteModel, groupId);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empLaborContractRemoteModel, companyId);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empLaborContractRemoteModel, userId);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empLaborContractRemoteModel, userName);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empLaborContractRemoteModel, createDate);
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

		if (_empLaborContractRemoteModel != null) {
			try {
				Class<?> clazz = _empLaborContractRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empLaborContractRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpLaborContractRemoteModel() {
		return _empLaborContractRemoteModel;
	}

	public void setEmpLaborContractRemoteModel(
		BaseModel<?> empLaborContractRemoteModel) {
		_empLaborContractRemoteModel = empLaborContractRemoteModel;
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

		Class<?> remoteModelClass = _empLaborContractRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empLaborContractRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpLaborContractLocalServiceUtil.addEmpLaborContract(this);
		}
		else {
			EmpLaborContractLocalServiceUtil.updateEmpLaborContract(this);
		}
	}

	@Override
	public EmpLaborContract toEscapedModel() {
		return (EmpLaborContract)ProxyUtil.newProxyInstance(EmpLaborContract.class.getClassLoader(),
			new Class[] { EmpLaborContract.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpLaborContractClp clone = new EmpLaborContractClp();

		clone.setEmpLaborContractId(getEmpLaborContractId());
		clone.setEmpId(getEmpId());
		clone.setLaborContractSignedDate(getLaborContractSignedDate());
		clone.setLaborContractExpiredDate(getLaborContractExpiredDate());
		clone.setLaborContractSignedType(getLaborContractSignedType());
		clone.setSignedTimes(getSignedTimes());
		clone.setLatest(getLatest());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpLaborContract empLaborContract) {
		long primaryKey = empLaborContract.getPrimaryKey();

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

		if (!(obj instanceof EmpLaborContractClp)) {
			return false;
		}

		EmpLaborContractClp empLaborContract = (EmpLaborContractClp)obj;

		long primaryKey = empLaborContract.getPrimaryKey();

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

		sb.append("{empLaborContractId=");
		sb.append(getEmpLaborContractId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", laborContractSignedDate=");
		sb.append(getLaborContractSignedDate());
		sb.append(", laborContractExpiredDate=");
		sb.append(getLaborContractExpiredDate());
		sb.append(", laborContractSignedType=");
		sb.append(getLaborContractSignedType());
		sb.append(", signedTimes=");
		sb.append(getSignedTimes());
		sb.append(", latest=");
		sb.append(getLatest());
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
		sb.append("vn.com.ecopharma.emp.model.EmpLaborContract");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empLaborContractId</column-name><column-value><![CDATA[");
		sb.append(getEmpLaborContractId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laborContractSignedDate</column-name><column-value><![CDATA[");
		sb.append(getLaborContractSignedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laborContractExpiredDate</column-name><column-value><![CDATA[");
		sb.append(getLaborContractExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>laborContractSignedType</column-name><column-value><![CDATA[");
		sb.append(getLaborContractSignedType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>signedTimes</column-name><column-value><![CDATA[");
		sb.append(getSignedTimes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>latest</column-name><column-value><![CDATA[");
		sb.append(getLatest());
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

	private long _empLaborContractId;
	private long _empId;
	private Date _laborContractSignedDate;
	private Date _laborContractExpiredDate;
	private String _laborContractSignedType;
	private int _signedTimes;
	private boolean _latest;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empLaborContractRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}