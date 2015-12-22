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
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class EmpBankInfoClp extends BaseModelImpl<EmpBankInfo>
	implements EmpBankInfo {
	public EmpBankInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EmpBankInfo.class;
	}

	@Override
	public String getModelClassName() {
		return EmpBankInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _empBankInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpBankInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empBankInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empBankInfoId", getEmpBankInfoId());
		attributes.put("empId", getEmpId());
		attributes.put("bankAccountNo", getBankAccountNo());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
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
		Long empBankInfoId = (Long)attributes.get("empBankInfoId");

		if (empBankInfoId != null) {
			setEmpBankInfoId(empBankInfoId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String bankAccountNo = (String)attributes.get("bankAccountNo");

		if (bankAccountNo != null) {
			setBankAccountNo(bankAccountNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
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
	public long getEmpBankInfoId() {
		return _empBankInfoId;
	}

	@Override
	public void setEmpBankInfoId(long empBankInfoId) {
		_empBankInfoId = empBankInfoId;

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpBankInfoId", long.class);

				method.invoke(_empBankInfoRemoteModel, empBankInfoId);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_empBankInfoRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankAccountNo() {
		return _bankAccountNo;
	}

	@Override
	public void setBankAccountNo(String bankAccountNo) {
		_bankAccountNo = bankAccountNo;

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBankAccountNo", String.class);

				method.invoke(_empBankInfoRemoteModel, bankAccountNo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBankName() {
		return _bankName;
	}

	@Override
	public void setBankName(String bankName) {
		_bankName = bankName;

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBankName", String.class);

				method.invoke(_empBankInfoRemoteModel, bankName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBranchName() {
		return _branchName;
	}

	@Override
	public void setBranchName(String branchName) {
		_branchName = branchName;

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setBranchName", String.class);

				method.invoke(_empBankInfoRemoteModel, branchName);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_empBankInfoRemoteModel, groupId);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_empBankInfoRemoteModel, companyId);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_empBankInfoRemoteModel, userId);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_empBankInfoRemoteModel, userName);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_empBankInfoRemoteModel, createDate);
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

		if (_empBankInfoRemoteModel != null) {
			try {
				Class<?> clazz = _empBankInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_empBankInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEmpBankInfoRemoteModel() {
		return _empBankInfoRemoteModel;
	}

	public void setEmpBankInfoRemoteModel(BaseModel<?> empBankInfoRemoteModel) {
		_empBankInfoRemoteModel = empBankInfoRemoteModel;
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

		Class<?> remoteModelClass = _empBankInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_empBankInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpBankInfoLocalServiceUtil.addEmpBankInfo(this);
		}
		else {
			EmpBankInfoLocalServiceUtil.updateEmpBankInfo(this);
		}
	}

	@Override
	public EmpBankInfo toEscapedModel() {
		return (EmpBankInfo)ProxyUtil.newProxyInstance(EmpBankInfo.class.getClassLoader(),
			new Class[] { EmpBankInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpBankInfoClp clone = new EmpBankInfoClp();

		clone.setEmpBankInfoId(getEmpBankInfoId());
		clone.setEmpId(getEmpId());
		clone.setBankAccountNo(getBankAccountNo());
		clone.setBankName(getBankName());
		clone.setBranchName(getBranchName());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EmpBankInfo empBankInfo) {
		long primaryKey = empBankInfo.getPrimaryKey();

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

		if (!(obj instanceof EmpBankInfoClp)) {
			return false;
		}

		EmpBankInfoClp empBankInfo = (EmpBankInfoClp)obj;

		long primaryKey = empBankInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{empBankInfoId=");
		sb.append(getEmpBankInfoId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", bankAccountNo=");
		sb.append(getBankAccountNo());
		sb.append(", bankName=");
		sb.append(getBankName());
		sb.append(", branchName=");
		sb.append(getBranchName());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.EmpBankInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empBankInfoId</column-name><column-value><![CDATA[");
		sb.append(getEmpBankInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankAccountNo</column-name><column-value><![CDATA[");
		sb.append(getBankAccountNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankName</column-name><column-value><![CDATA[");
		sb.append(getBankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>branchName</column-name><column-value><![CDATA[");
		sb.append(getBranchName());
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

	private long _empBankInfoId;
	private long _empId;
	private String _bankAccountNo;
	private String _bankName;
	private String _branchName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _empBankInfoRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}