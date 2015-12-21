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

import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class CandidateEvaluationClp extends BaseModelImpl<CandidateEvaluation>
	implements CandidateEvaluation {
	public CandidateEvaluationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CandidateEvaluation.class;
	}

	@Override
	public String getModelClassName() {
		return CandidateEvaluation.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _candidateEvaluationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateEvaluationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateEvaluationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateEvaluationId", getCandidateEvaluationId());
		attributes.put("evaluationCriteriaId", getEvaluationCriteriaId());
		attributes.put("evaluationCriteriaKeyValueId",
			getEvaluationCriteriaKeyValueId());
		attributes.put("ratingPoint", getRatingPoint());
		attributes.put("note", getNote());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("candidateId", getCandidateId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateEvaluationId = (Long)attributes.get(
				"candidateEvaluationId");

		if (candidateEvaluationId != null) {
			setCandidateEvaluationId(candidateEvaluationId);
		}

		Long evaluationCriteriaId = (Long)attributes.get("evaluationCriteriaId");

		if (evaluationCriteriaId != null) {
			setEvaluationCriteriaId(evaluationCriteriaId);
		}

		Long evaluationCriteriaKeyValueId = (Long)attributes.get(
				"evaluationCriteriaKeyValueId");

		if (evaluationCriteriaKeyValueId != null) {
			setEvaluationCriteriaKeyValueId(evaluationCriteriaKeyValueId);
		}

		Integer ratingPoint = (Integer)attributes.get("ratingPoint");

		if (ratingPoint != null) {
			setRatingPoint(ratingPoint);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
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

		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}
	}

	@Override
	public long getCandidateEvaluationId() {
		return _candidateEvaluationId;
	}

	@Override
	public void setCandidateEvaluationId(long candidateEvaluationId) {
		_candidateEvaluationId = candidateEvaluationId;

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateEvaluationId",
						long.class);

				method.invoke(_candidateEvaluationRemoteModel,
					candidateEvaluationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEvaluationCriteriaId() {
		return _evaluationCriteriaId;
	}

	@Override
	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_evaluationCriteriaId = evaluationCriteriaId;

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setEvaluationCriteriaId",
						long.class);

				method.invoke(_candidateEvaluationRemoteModel,
					evaluationCriteriaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEvaluationCriteriaKeyValueId() {
		return _evaluationCriteriaKeyValueId;
	}

	@Override
	public void setEvaluationCriteriaKeyValueId(
		long evaluationCriteriaKeyValueId) {
		_evaluationCriteriaKeyValueId = evaluationCriteriaKeyValueId;

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setEvaluationCriteriaKeyValueId",
						long.class);

				method.invoke(_candidateEvaluationRemoteModel,
					evaluationCriteriaKeyValueId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRatingPoint() {
		return _ratingPoint;
	}

	@Override
	public void setRatingPoint(int ratingPoint) {
		_ratingPoint = ratingPoint;

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setRatingPoint", int.class);

				method.invoke(_candidateEvaluationRemoteModel, ratingPoint);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_candidateEvaluationRemoteModel, note);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_candidateEvaluationRemoteModel, groupId);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_candidateEvaluationRemoteModel, companyId);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_candidateEvaluationRemoteModel, userId);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_candidateEvaluationRemoteModel, userName);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_candidateEvaluationRemoteModel, createDate);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_candidateEvaluationRemoteModel, modifiedDate);
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

		if (_candidateEvaluationRemoteModel != null) {
			try {
				Class<?> clazz = _candidateEvaluationRemoteModel.getClass();

				Method method = clazz.getMethod("setCandidateId", long.class);

				method.invoke(_candidateEvaluationRemoteModel, candidateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCandidateEvaluationRemoteModel() {
		return _candidateEvaluationRemoteModel;
	}

	public void setCandidateEvaluationRemoteModel(
		BaseModel<?> candidateEvaluationRemoteModel) {
		_candidateEvaluationRemoteModel = candidateEvaluationRemoteModel;
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

		Class<?> remoteModelClass = _candidateEvaluationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_candidateEvaluationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CandidateEvaluationLocalServiceUtil.addCandidateEvaluation(this);
		}
		else {
			CandidateEvaluationLocalServiceUtil.updateCandidateEvaluation(this);
		}
	}

	@Override
	public CandidateEvaluation toEscapedModel() {
		return (CandidateEvaluation)ProxyUtil.newProxyInstance(CandidateEvaluation.class.getClassLoader(),
			new Class[] { CandidateEvaluation.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CandidateEvaluationClp clone = new CandidateEvaluationClp();

		clone.setCandidateEvaluationId(getCandidateEvaluationId());
		clone.setEvaluationCriteriaId(getEvaluationCriteriaId());
		clone.setEvaluationCriteriaKeyValueId(getEvaluationCriteriaKeyValueId());
		clone.setRatingPoint(getRatingPoint());
		clone.setNote(getNote());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCandidateId(getCandidateId());

		return clone;
	}

	@Override
	public int compareTo(CandidateEvaluation candidateEvaluation) {
		long primaryKey = candidateEvaluation.getPrimaryKey();

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

		if (!(obj instanceof CandidateEvaluationClp)) {
			return false;
		}

		CandidateEvaluationClp candidateEvaluation = (CandidateEvaluationClp)obj;

		long primaryKey = candidateEvaluation.getPrimaryKey();

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

		sb.append("{candidateEvaluationId=");
		sb.append(getCandidateEvaluationId());
		sb.append(", evaluationCriteriaId=");
		sb.append(getEvaluationCriteriaId());
		sb.append(", evaluationCriteriaKeyValueId=");
		sb.append(getEvaluationCriteriaKeyValueId());
		sb.append(", ratingPoint=");
		sb.append(getRatingPoint());
		sb.append(", note=");
		sb.append(getNote());
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
		sb.append(", candidateId=");
		sb.append(getCandidateId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.CandidateEvaluation");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>candidateEvaluationId</column-name><column-value><![CDATA[");
		sb.append(getCandidateEvaluationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evaluationCriteriaId</column-name><column-value><![CDATA[");
		sb.append(getEvaluationCriteriaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>evaluationCriteriaKeyValueId</column-name><column-value><![CDATA[");
		sb.append(getEvaluationCriteriaKeyValueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ratingPoint</column-name><column-value><![CDATA[");
		sb.append(getRatingPoint());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
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
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _candidateEvaluationId;
	private long _evaluationCriteriaId;
	private long _evaluationCriteriaKeyValueId;
	private int _ratingPoint;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _candidateId;
	private BaseModel<?> _candidateEvaluationRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}