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

import vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class CandidateActionHistoryClp extends BaseModelImpl<CandidateActionHistory>
	implements CandidateActionHistory {
	public CandidateActionHistoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateActionHistory.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateActionHistory.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _candidateActionHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateActionHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateActionHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateActionHistoryId", getCandidateActionHistoryId());
		attributes.put("candidateId", getCandidateId());
		attributes.put("action", getAction());
		attributes.put("actionType", getActionType());
		attributes.put("executedBy", getExecutedBy());
		attributes.put("date", getDate());
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
		Long candidateActionHistoryId = (Long)attributes.get(
				"candidateActionHistoryId");

		if (candidateActionHistoryId != null) {
			setCandidateActionHistoryId(candidateActionHistoryId);
		}

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String actionType = (String)attributes.get("actionType");

		if (actionType != null) {
			setActionType(actionType);
		}

		Long executedBy = (Long)attributes.get("executedBy");

		if (executedBy != null) {
			setExecutedBy(executedBy);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
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
	public long getCandidateActionHistoryId() {
		return _candidateActionHistoryId;
	}

	@Override
	public void setCandidateActionHistoryId(long candidateActionHistoryId) {
		_candidateActionHistoryId = candidateActionHistoryId;

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateActionHistoryId",
						long.class);

				method.invoke(_candidateActionHistoryRemoteModel,
					candidateActionHistoryId);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateId", long.class);

				method.invoke(_candidateActionHistoryRemoteModel, candidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAction() {
		return _action;
	}

	@Override
	public void setAction(String action) {
		_action = action;

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_candidateActionHistoryRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionType() {
		return _actionType;
	}

	@Override
	public void setActionType(String actionType) {
		_actionType = actionType;

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActionType", String.class);

				method.invoke(_candidateActionHistoryRemoteModel, actionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getExecutedBy() {
		return _executedBy;
	}

	@Override
	public void setExecutedBy(long executedBy) {
		_executedBy = executedBy;

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setExecutedBy", long.class);

				method.invoke(_candidateActionHistoryRemoteModel, executedBy);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_candidateActionHistoryRemoteModel, date);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_candidateActionHistoryRemoteModel, description);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_candidateActionHistoryRemoteModel, groupId);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_candidateActionHistoryRemoteModel, companyId);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_candidateActionHistoryRemoteModel, userId);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_candidateActionHistoryRemoteModel, userName);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_candidateActionHistoryRemoteModel, createDate);
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

		if (_candidateActionHistoryRemoteModel != null) {
			try {
				Class<?> clazz = _candidateActionHistoryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_candidateActionHistoryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCandidateActionHistoryRemoteModel() {
		return _candidateActionHistoryRemoteModel;
	}

	public void setCandidateActionHistoryRemoteModel(
		BaseModel<?> candidateActionHistoryRemoteModel) {
		_candidateActionHistoryRemoteModel = candidateActionHistoryRemoteModel;
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

		Class<?> remoteModelClass = _candidateActionHistoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_candidateActionHistoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CandidateActionHistoryLocalServiceUtil.addCandidateActionHistory(this);
		}
		else {
			CandidateActionHistoryLocalServiceUtil.updateCandidateActionHistory(this);
		}
	}

	@Override
	public CandidateActionHistory toEscapedModel() {
		return (CandidateActionHistory)ProxyUtil.newProxyInstance(CandidateActionHistory.class.getClassLoader(),
			new Class[] { CandidateActionHistory.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CandidateActionHistoryClp clone = new CandidateActionHistoryClp();

		clone.setCandidateActionHistoryId(getCandidateActionHistoryId());
		clone.setCandidateId(getCandidateId());
		clone.setAction(getAction());
		clone.setActionType(getActionType());
		clone.setExecutedBy(getExecutedBy());
		clone.setDate(getDate());
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
	public int compareTo(CandidateActionHistory candidateActionHistory) {
		long primaryKey = candidateActionHistory.getPrimaryKey();

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

		if (!(obj instanceof CandidateActionHistoryClp)) {
			return false;
		}

		CandidateActionHistoryClp candidateActionHistory = (CandidateActionHistoryClp)obj;

		long primaryKey = candidateActionHistory.getPrimaryKey();

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

		sb.append("{candidateActionHistoryId=");
		sb.append(getCandidateActionHistoryId());
		sb.append(", candidateId=");
		sb.append(getCandidateId());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", actionType=");
		sb.append(getActionType());
		sb.append(", executedBy=");
		sb.append(getExecutedBy());
		sb.append(", date=");
		sb.append(getDate());
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
		sb.append("vn.com.ecopharma.hrm.rc.model.CandidateActionHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>candidateActionHistoryId</column-name><column-value><![CDATA[");
		sb.append(getCandidateActionHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actionType</column-name><column-value><![CDATA[");
		sb.append(getActionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>executedBy</column-name><column-value><![CDATA[");
		sb.append(getExecutedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
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

	private long _candidateActionHistoryId;
	private long _candidateId;
	private String _action;
	private String _actionType;
	private long _executedBy;
	private Date _date;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _candidateActionHistoryRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}