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

package vn.com.ecopharma.hrm.tt.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.ecopharma.hrm.tt.service.ClpSerializer;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class TimeTrackingClp extends BaseModelImpl<TimeTracking>
	implements TimeTracking {
	public TimeTrackingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return TimeTracking.class;
	}

	@Override
	public String getModelClassName() {
		return TimeTracking.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _timeTrackingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTimeTrackingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _timeTrackingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("timeTrackingId", getTimeTrackingId());
		attributes.put("empId", getEmpId());
		attributes.put("date", getDate());
		attributes.put("in1", getIn1());
		attributes.put("out1", getOut1());
		attributes.put("in2", getIn2());
		attributes.put("out2", getOut2());
		attributes.put("in3", getIn3());
		attributes.put("out3", getOut3());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("leaveRefId", getLeaveRefId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long timeTrackingId = (Long)attributes.get("timeTrackingId");

		if (timeTrackingId != null) {
			setTimeTrackingId(timeTrackingId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Date in1 = (Date)attributes.get("in1");

		if (in1 != null) {
			setIn1(in1);
		}

		Date out1 = (Date)attributes.get("out1");

		if (out1 != null) {
			setOut1(out1);
		}

		Date in2 = (Date)attributes.get("in2");

		if (in2 != null) {
			setIn2(in2);
		}

		Date out2 = (Date)attributes.get("out2");

		if (out2 != null) {
			setOut2(out2);
		}

		Date in3 = (Date)attributes.get("in3");

		if (in3 != null) {
			setIn3(in3);
		}

		Date out3 = (Date)attributes.get("out3");

		if (out3 != null) {
			setOut3(out3);
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

		Long leaveRefId = (Long)attributes.get("leaveRefId");

		if (leaveRefId != null) {
			setLeaveRefId(leaveRefId);
		}
	}

	@Override
	public long getTimeTrackingId() {
		return _timeTrackingId;
	}

	@Override
	public void setTimeTrackingId(long timeTrackingId) {
		_timeTrackingId = timeTrackingId;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setTimeTrackingId", long.class);

				method.invoke(_timeTrackingRemoteModel, timeTrackingId);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setEmpId", long.class);

				method.invoke(_timeTrackingRemoteModel, empId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_timeTrackingRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIn1() {
		return _in1;
	}

	@Override
	public void setIn1(Date in1) {
		_in1 = in1;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setIn1", Date.class);

				method.invoke(_timeTrackingRemoteModel, in1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOut1() {
		return _out1;
	}

	@Override
	public void setOut1(Date out1) {
		_out1 = out1;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setOut1", Date.class);

				method.invoke(_timeTrackingRemoteModel, out1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIn2() {
		return _in2;
	}

	@Override
	public void setIn2(Date in2) {
		_in2 = in2;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setIn2", Date.class);

				method.invoke(_timeTrackingRemoteModel, in2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOut2() {
		return _out2;
	}

	@Override
	public void setOut2(Date out2) {
		_out2 = out2;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setOut2", Date.class);

				method.invoke(_timeTrackingRemoteModel, out2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getIn3() {
		return _in3;
	}

	@Override
	public void setIn3(Date in3) {
		_in3 = in3;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setIn3", Date.class);

				method.invoke(_timeTrackingRemoteModel, in3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getOut3() {
		return _out3;
	}

	@Override
	public void setOut3(Date out3) {
		_out3 = out3;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setOut3", Date.class);

				method.invoke(_timeTrackingRemoteModel, out3);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_timeTrackingRemoteModel, groupId);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_timeTrackingRemoteModel, companyId);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_timeTrackingRemoteModel, userId);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_timeTrackingRemoteModel, userName);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_timeTrackingRemoteModel, createDate);
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

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_timeTrackingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLeaveRefId() {
		return _leaveRefId;
	}

	@Override
	public void setLeaveRefId(long leaveRefId) {
		_leaveRefId = leaveRefId;

		if (_timeTrackingRemoteModel != null) {
			try {
				Class<?> clazz = _timeTrackingRemoteModel.getClass();

				Method method = clazz.getMethod("setLeaveRefId", long.class);

				method.invoke(_timeTrackingRemoteModel, leaveRefId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getTimeTrackingRemoteModel() {
		return _timeTrackingRemoteModel;
	}

	public void setTimeTrackingRemoteModel(BaseModel<?> timeTrackingRemoteModel) {
		_timeTrackingRemoteModel = timeTrackingRemoteModel;
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

		Class<?> remoteModelClass = _timeTrackingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_timeTrackingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			TimeTrackingLocalServiceUtil.addTimeTracking(this);
		}
		else {
			TimeTrackingLocalServiceUtil.updateTimeTracking(this);
		}
	}

	@Override
	public TimeTracking toEscapedModel() {
		return (TimeTracking)ProxyUtil.newProxyInstance(TimeTracking.class.getClassLoader(),
			new Class[] { TimeTracking.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TimeTrackingClp clone = new TimeTrackingClp();

		clone.setTimeTrackingId(getTimeTrackingId());
		clone.setEmpId(getEmpId());
		clone.setDate(getDate());
		clone.setIn1(getIn1());
		clone.setOut1(getOut1());
		clone.setIn2(getIn2());
		clone.setOut2(getOut2());
		clone.setIn3(getIn3());
		clone.setOut3(getOut3());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLeaveRefId(getLeaveRefId());

		return clone;
	}

	@Override
	public int compareTo(TimeTracking timeTracking) {
		long primaryKey = timeTracking.getPrimaryKey();

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

		if (!(obj instanceof TimeTrackingClp)) {
			return false;
		}

		TimeTrackingClp timeTracking = (TimeTrackingClp)obj;

		long primaryKey = timeTracking.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{timeTrackingId=");
		sb.append(getTimeTrackingId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", in1=");
		sb.append(getIn1());
		sb.append(", out1=");
		sb.append(getOut1());
		sb.append(", in2=");
		sb.append(getIn2());
		sb.append(", out2=");
		sb.append(getOut2());
		sb.append(", in3=");
		sb.append(getIn3());
		sb.append(", out3=");
		sb.append(getOut3());
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
		sb.append(", leaveRefId=");
		sb.append(getLeaveRefId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.tt.model.TimeTracking");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>timeTrackingId</column-name><column-value><![CDATA[");
		sb.append(getTimeTrackingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>in1</column-name><column-value><![CDATA[");
		sb.append(getIn1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>out1</column-name><column-value><![CDATA[");
		sb.append(getOut1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>in2</column-name><column-value><![CDATA[");
		sb.append(getIn2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>out2</column-name><column-value><![CDATA[");
		sb.append(getOut2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>in3</column-name><column-value><![CDATA[");
		sb.append(getIn3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>out3</column-name><column-value><![CDATA[");
		sb.append(getOut3());
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
			"<column><column-name>leaveRefId</column-name><column-value><![CDATA[");
		sb.append(getLeaveRefId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _timeTrackingId;
	private long _empId;
	private Date _date;
	private Date _in1;
	private Date _out1;
	private Date _in2;
	private Date _out2;
	private Date _in3;
	private Date _out3;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _leaveRefId;
	private BaseModel<?> _timeTrackingRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.tt.service.ClpSerializer.class;
}