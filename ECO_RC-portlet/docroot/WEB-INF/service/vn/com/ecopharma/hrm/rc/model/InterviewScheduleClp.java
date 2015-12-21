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
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class InterviewScheduleClp extends BaseModelImpl<InterviewSchedule>
	implements InterviewSchedule {
	public InterviewScheduleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return InterviewSchedule.class;
	}

	@Override
	public String getModelClassName() {
		return InterviewSchedule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _interviewScheduleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setInterviewScheduleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _interviewScheduleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("interviewScheduleId", getInterviewScheduleId());
		attributes.put("vacancyCandidateId", getVacancyCandidateId());
		attributes.put("interviewId", getInterviewId());
		attributes.put("locationId", getLocationId());
		attributes.put("interviewDate", getInterviewDate());
		attributes.put("interviewTime", getInterviewTime());
		attributes.put("status", getStatus());
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
		Long interviewScheduleId = (Long)attributes.get("interviewScheduleId");

		if (interviewScheduleId != null) {
			setInterviewScheduleId(interviewScheduleId);
		}

		Long vacancyCandidateId = (Long)attributes.get("vacancyCandidateId");

		if (vacancyCandidateId != null) {
			setVacancyCandidateId(vacancyCandidateId);
		}

		Long interviewId = (Long)attributes.get("interviewId");

		if (interviewId != null) {
			setInterviewId(interviewId);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Date interviewDate = (Date)attributes.get("interviewDate");

		if (interviewDate != null) {
			setInterviewDate(interviewDate);
		}

		String interviewTime = (String)attributes.get("interviewTime");

		if (interviewTime != null) {
			setInterviewTime(interviewTime);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public long getInterviewScheduleId() {
		return _interviewScheduleId;
	}

	@Override
	public void setInterviewScheduleId(long interviewScheduleId) {
		_interviewScheduleId = interviewScheduleId;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setInterviewScheduleId",
						long.class);

				method.invoke(_interviewScheduleRemoteModel, interviewScheduleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVacancyCandidateId() {
		return _vacancyCandidateId;
	}

	@Override
	public void setVacancyCandidateId(long vacancyCandidateId) {
		_vacancyCandidateId = vacancyCandidateId;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setVacancyCandidateId",
						long.class);

				method.invoke(_interviewScheduleRemoteModel, vacancyCandidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getInterviewId() {
		return _interviewId;
	}

	@Override
	public void setInterviewId(long interviewId) {
		_interviewId = interviewId;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setInterviewId", long.class);

				method.invoke(_interviewScheduleRemoteModel, interviewId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLocationId() {
		return _locationId;
	}

	@Override
	public void setLocationId(long locationId) {
		_locationId = locationId;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setLocationId", long.class);

				method.invoke(_interviewScheduleRemoteModel, locationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getInterviewDate() {
		return _interviewDate;
	}

	@Override
	public void setInterviewDate(Date interviewDate) {
		_interviewDate = interviewDate;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setInterviewDate", Date.class);

				method.invoke(_interviewScheduleRemoteModel, interviewDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInterviewTime() {
		return _interviewTime;
	}

	@Override
	public void setInterviewTime(String interviewTime) {
		_interviewTime = interviewTime;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setInterviewTime", String.class);

				method.invoke(_interviewScheduleRemoteModel, interviewTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_interviewScheduleRemoteModel, status);
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

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_interviewScheduleRemoteModel, groupId);
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

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_interviewScheduleRemoteModel, companyId);
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

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_interviewScheduleRemoteModel, userId);
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

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_interviewScheduleRemoteModel, userName);
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

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_interviewScheduleRemoteModel, createDate);
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

		if (_interviewScheduleRemoteModel != null) {
			try {
				Class<?> clazz = _interviewScheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_interviewScheduleRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getInterviewScheduleRemoteModel() {
		return _interviewScheduleRemoteModel;
	}

	public void setInterviewScheduleRemoteModel(
		BaseModel<?> interviewScheduleRemoteModel) {
		_interviewScheduleRemoteModel = interviewScheduleRemoteModel;
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

		Class<?> remoteModelClass = _interviewScheduleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_interviewScheduleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			InterviewScheduleLocalServiceUtil.addInterviewSchedule(this);
		}
		else {
			InterviewScheduleLocalServiceUtil.updateInterviewSchedule(this);
		}
	}

	@Override
	public InterviewSchedule toEscapedModel() {
		return (InterviewSchedule)ProxyUtil.newProxyInstance(InterviewSchedule.class.getClassLoader(),
			new Class[] { InterviewSchedule.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		InterviewScheduleClp clone = new InterviewScheduleClp();

		clone.setInterviewScheduleId(getInterviewScheduleId());
		clone.setVacancyCandidateId(getVacancyCandidateId());
		clone.setInterviewId(getInterviewId());
		clone.setLocationId(getLocationId());
		clone.setInterviewDate(getInterviewDate());
		clone.setInterviewTime(getInterviewTime());
		clone.setStatus(getStatus());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(InterviewSchedule interviewSchedule) {
		long primaryKey = interviewSchedule.getPrimaryKey();

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

		if (!(obj instanceof InterviewScheduleClp)) {
			return false;
		}

		InterviewScheduleClp interviewSchedule = (InterviewScheduleClp)obj;

		long primaryKey = interviewSchedule.getPrimaryKey();

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

		sb.append("{interviewScheduleId=");
		sb.append(getInterviewScheduleId());
		sb.append(", vacancyCandidateId=");
		sb.append(getVacancyCandidateId());
		sb.append(", interviewId=");
		sb.append(getInterviewId());
		sb.append(", locationId=");
		sb.append(getLocationId());
		sb.append(", interviewDate=");
		sb.append(getInterviewDate());
		sb.append(", interviewTime=");
		sb.append(getInterviewTime());
		sb.append(", status=");
		sb.append(getStatus());
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
		sb.append("vn.com.ecopharma.hrm.rc.model.InterviewSchedule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>interviewScheduleId</column-name><column-value><![CDATA[");
		sb.append(getInterviewScheduleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vacancyCandidateId</column-name><column-value><![CDATA[");
		sb.append(getVacancyCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewId</column-name><column-value><![CDATA[");
		sb.append(getInterviewId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locationId</column-name><column-value><![CDATA[");
		sb.append(getLocationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewDate</column-name><column-value><![CDATA[");
		sb.append(getInterviewDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interviewTime</column-name><column-value><![CDATA[");
		sb.append(getInterviewTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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

	private long _interviewScheduleId;
	private long _vacancyCandidateId;
	private long _interviewId;
	private long _locationId;
	private Date _interviewDate;
	private String _interviewTime;
	private String _status;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _interviewScheduleRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}