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
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class VacationLeaveClp extends BaseModelImpl<VacationLeave>
	implements VacationLeave {
	public VacationLeaveClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VacationLeave.class;
	}

	@Override
	public String getModelClassName() {
		return VacationLeave.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _vacationLeaveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVacationLeaveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacationLeaveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacationLeaveId", getVacationLeaveId());
		attributes.put("empId", getEmpId());
		attributes.put("leaveType", getLeaveType());
		attributes.put("leaveFrom", getLeaveFrom());
		attributes.put("leaveTo", getLeaveTo());
		attributes.put("actualTo", getActualTo());
		attributes.put("reason", getReason());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacationLeaveId = (Long)attributes.get("vacationLeaveId");

		if (vacationLeaveId != null) {
			setVacationLeaveId(vacationLeaveId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String leaveType = (String)attributes.get("leaveType");

		if (leaveType != null) {
			setLeaveType(leaveType);
		}

		Date leaveFrom = (Date)attributes.get("leaveFrom");

		if (leaveFrom != null) {
			setLeaveFrom(leaveFrom);
		}

		Date leaveTo = (Date)attributes.get("leaveTo");

		if (leaveTo != null) {
			setLeaveTo(leaveTo);
		}

		Date actualTo = (Date)attributes.get("actualTo");

		if (actualTo != null) {
			setActualTo(actualTo);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	@Override
	public long getVacationLeaveId() {
		return _vacationLeaveId;
	}

	@Override
	public void setVacationLeaveId(long vacationLeaveId) {
		_vacationLeaveId = vacationLeaveId;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setVacationLeaveId", long.class);

				method.invoke(_vacationLeaveRemoteModel, vacationLeaveId);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_vacationLeaveRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLeaveType() {
		return _leaveType;
	}

	@Override
	public void setLeaveType(String leaveType) {
		_leaveType = leaveType;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveType", String.class);

				method.invoke(_vacationLeaveRemoteModel, leaveType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLeaveFrom() {
		return _leaveFrom;
	}

	@Override
	public void setLeaveFrom(Date leaveFrom) {
		_leaveFrom = leaveFrom;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveFrom", Date.class);

				method.invoke(_vacationLeaveRemoteModel, leaveFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLeaveTo() {
		return _leaveTo;
	}

	@Override
	public void setLeaveTo(Date leaveTo) {
		_leaveTo = leaveTo;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveTo", Date.class);

				method.invoke(_vacationLeaveRemoteModel, leaveTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getActualTo() {
		return _actualTo;
	}

	@Override
	public void setActualTo(Date actualTo) {
		_actualTo = actualTo;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setActualTo", Date.class);

				method.invoke(_vacationLeaveRemoteModel, actualTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReason() {
		return _reason;
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setReason", String.class);

				method.invoke(_vacationLeaveRemoteModel, reason);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_vacationLeaveRemoteModel, description);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vacationLeaveRemoteModel, groupId);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vacationLeaveRemoteModel, companyId);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vacationLeaveRemoteModel, userId);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vacationLeaveRemoteModel, userName);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vacationLeaveRemoteModel, createDate);
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

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_vacationLeaveRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_deleted = deleted;

		if (_vacationLeaveRemoteModel != null) {
			try {
				Class<?> clazz = _vacationLeaveRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_vacationLeaveRemoteModel, deleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVacationLeaveRemoteModel() {
		return _vacationLeaveRemoteModel;
	}

	public void setVacationLeaveRemoteModel(
		BaseModel<?> vacationLeaveRemoteModel) {
		_vacationLeaveRemoteModel = vacationLeaveRemoteModel;
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

		Class<?> remoteModelClass = _vacationLeaveRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vacationLeaveRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VacationLeaveLocalServiceUtil.addVacationLeave(this);
		}
		else {
			VacationLeaveLocalServiceUtil.updateVacationLeave(this);
		}
	}

	@Override
	public VacationLeave toEscapedModel() {
		return (VacationLeave)ProxyUtil.newProxyInstance(VacationLeave.class.getClassLoader(),
			new Class[] { VacationLeave.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VacationLeaveClp clone = new VacationLeaveClp();

		clone.setVacationLeaveId(getVacationLeaveId());
		clone.setEmpId(getEmpId());
		clone.setLeaveType(getLeaveType());
		clone.setLeaveFrom(getLeaveFrom());
		clone.setLeaveTo(getLeaveTo());
		clone.setActualTo(getActualTo());
		clone.setReason(getReason());
		clone.setDescription(getDescription());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setDeleted(getDeleted());

		return clone;
	}

	@Override
	public int compareTo(VacationLeave vacationLeave) {
		long primaryKey = vacationLeave.getPrimaryKey();

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

		if (!(obj instanceof VacationLeaveClp)) {
			return false;
		}

		VacationLeaveClp vacationLeave = (VacationLeaveClp)obj;

		long primaryKey = vacationLeave.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{vacationLeaveId=");
		sb.append(getVacationLeaveId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", leaveType=");
		sb.append(getLeaveType());
		sb.append(", leaveFrom=");
		sb.append(getLeaveFrom());
		sb.append(", leaveTo=");
		sb.append(getLeaveTo());
		sb.append(", actualTo=");
		sb.append(getActualTo());
		sb.append(", reason=");
		sb.append(getReason());
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
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.VacationLeave");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vacationLeaveId</column-name><column-value><![CDATA[");
		sb.append(getVacationLeaveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveType</column-name><column-value><![CDATA[");
		sb.append(getLeaveType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveFrom</column-name><column-value><![CDATA[");
		sb.append(getLeaveFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveTo</column-name><column-value><![CDATA[");
		sb.append(getLeaveTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualTo</column-name><column-value><![CDATA[");
		sb.append(getActualTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
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
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _vacationLeaveId;
	private long _empId;
	private String _leaveType;
	private Date _leaveFrom;
	private Date _leaveTo;
	private Date _actualTo;
	private String _reason;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private BaseModel<?> _vacationLeaveRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}