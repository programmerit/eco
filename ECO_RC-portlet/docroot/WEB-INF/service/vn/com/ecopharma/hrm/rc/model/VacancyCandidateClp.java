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
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class VacancyCandidateClp extends BaseModelImpl<VacancyCandidate>
	implements VacancyCandidate {
	public VacancyCandidateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return VacancyCandidate.class;
	}

	@Override
	public String getModelClassName() {
		return VacancyCandidate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _vacancyCandidateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVacancyCandidateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacancyCandidateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacancyCandidateId", getVacancyCandidateId());
		attributes.put("vacancyId", getVacancyId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("status", getStatus());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacancyCandidateId = (Long)attributes.get("vacancyCandidateId");

		if (vacancyCandidateId != null) {
			setVacancyCandidateId(vacancyCandidateId);
		}

		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		Integer status = (Integer)attributes.get("status");

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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public long getVacancyCandidateId() {
		return _vacancyCandidateId;
	}

	@Override
	public void setVacancyCandidateId(long vacancyCandidateId) {
		_vacancyCandidateId = vacancyCandidateId;

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setVacancyCandidateId",
						long.class);

				method.invoke(_vacancyCandidateRemoteModel, vacancyCandidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVacancyId() {
		return _vacancyId;
	}

	@Override
	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setVacancyId", long.class);

				method.invoke(_vacancyCandidateRemoteModel, vacancyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateId", long.class);

				method.invoke(_vacancyCandidateRemoteModel, candidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_vacancyCandidateRemoteModel, status);
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

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vacancyCandidateRemoteModel, groupId);
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

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vacancyCandidateRemoteModel, companyId);
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

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vacancyCandidateRemoteModel, userId);
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

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vacancyCandidateRemoteModel, userName);
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

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vacancyCandidateRemoteModel, createDate);
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

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_vacancyCandidateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_vacancyCandidateRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyCandidateRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_vacancyCandidateRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVacancyCandidateRemoteModel() {
		return _vacancyCandidateRemoteModel;
	}

	public void setVacancyCandidateRemoteModel(
		BaseModel<?> vacancyCandidateRemoteModel) {
		_vacancyCandidateRemoteModel = vacancyCandidateRemoteModel;
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

		Class<?> remoteModelClass = _vacancyCandidateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vacancyCandidateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VacancyCandidateLocalServiceUtil.addVacancyCandidate(this);
		}
		else {
			VacancyCandidateLocalServiceUtil.updateVacancyCandidate(this);
		}
	}

	@Override
	public VacancyCandidate toEscapedModel() {
		return (VacancyCandidate)ProxyUtil.newProxyInstance(VacancyCandidate.class.getClassLoader(),
			new Class[] { VacancyCandidate.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VacancyCandidateClp clone = new VacancyCandidateClp();

		clone.setVacancyCandidateId(getVacancyCandidateId());
		clone.setVacancyId(getVacancyId());
		clone.setCandidateId(getCandidateId());
		clone.setStatus(getStatus());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setType(getType());

		return clone;
	}

	@Override
	public int compareTo(VacancyCandidate vacancyCandidate) {
		long primaryKey = vacancyCandidate.getPrimaryKey();

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

		if (!(obj instanceof VacancyCandidateClp)) {
			return false;
		}

		VacancyCandidateClp vacancyCandidate = (VacancyCandidateClp)obj;

		long primaryKey = vacancyCandidate.getPrimaryKey();

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

		sb.append("{vacancyCandidateId=");
		sb.append(getVacancyCandidateId());
		sb.append(", vacancyId=");
		sb.append(getVacancyId());
		sb.append(", candidateId=");
		sb.append(getCandidateId());
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
		sb.append(", type=");
		sb.append(getType());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.VacancyCandidate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vacancyCandidateId</column-name><column-value><![CDATA[");
		sb.append(getVacancyCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vacancyId</column-name><column-value><![CDATA[");
		sb.append(getVacancyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
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
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _vacancyCandidateId;
	private long _vacancyId;
	private long _candidateId;
	private int _status;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
	private BaseModel<?> _vacancyCandidateRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}