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
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class VacancyClp extends BaseModelImpl<Vacancy> implements Vacancy {
	public VacancyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Vacancy.class;
	}

	@Override
	public String getModelClassName() {
		return Vacancy.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _vacancyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVacancyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacancyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacancyId", getVacancyId());
		attributes.put("name", getName());
		attributes.put("numberOfPosition", getNumberOfPosition());
		attributes.put("titlesId", getTitlesId());
		attributes.put("status", getStatus());
		attributes.put("postedDate", getPostedDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("deleted", getDeleted());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("certificateType", getCertificateType());
		attributes.put("experiences", getExperiences());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer numberOfPosition = (Integer)attributes.get("numberOfPosition");

		if (numberOfPosition != null) {
			setNumberOfPosition(numberOfPosition);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date postedDate = (Date)attributes.get("postedDate");

		if (postedDate != null) {
			setPostedDate(postedDate);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String certificateType = (String)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		Double experiences = (Double)attributes.get("experiences");

		if (experiences != null) {
			setExperiences(experiences);
		}
	}

	@Override
	public long getVacancyId() {
		return _vacancyId;
	}

	@Override
	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setVacancyId", long.class);

				method.invoke(_vacancyRemoteModel, vacancyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_vacancyRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfPosition() {
		return _numberOfPosition;
	}

	@Override
	public void setNumberOfPosition(int numberOfPosition) {
		_numberOfPosition = numberOfPosition;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfPosition", int.class);

				method.invoke(_vacancyRemoteModel, numberOfPosition);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTitlesId() {
		return _titlesId;
	}

	@Override
	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setTitlesId", long.class);

				method.invoke(_vacancyRemoteModel, titlesId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_vacancyRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPostedDate() {
		return _postedDate;
	}

	@Override
	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setPostedDate", Date.class);

				method.invoke(_vacancyRemoteModel, postedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiredDate() {
		return _expiredDate;
	}

	@Override
	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredDate", Date.class);

				method.invoke(_vacancyRemoteModel, expiredDate);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setDeleted", boolean.class);

				method.invoke(_vacancyRemoteModel, deleted);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_vacancyRemoteModel, description);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_vacancyRemoteModel, groupId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_vacancyRemoteModel, companyId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_vacancyRemoteModel, userId);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_vacancyRemoteModel, userName);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_vacancyRemoteModel, createDate);
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

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_vacancyRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCode() {
		return _code;
	}

	@Override
	public void setCode(String code) {
		_code = code;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCode", String.class);

				method.invoke(_vacancyRemoteModel, code);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertificateType() {
		return _certificateType;
	}

	@Override
	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateType",
						String.class);

				method.invoke(_vacancyRemoteModel, certificateType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getExperiences() {
		return _experiences;
	}

	@Override
	public void setExperiences(double experiences) {
		_experiences = experiences;

		if (_vacancyRemoteModel != null) {
			try {
				Class<?> clazz = _vacancyRemoteModel.getClass();

				Method method = clazz.getMethod("setExperiences", double.class);

				method.invoke(_vacancyRemoteModel, experiences);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVacancyRemoteModel() {
		return _vacancyRemoteModel;
	}

	public void setVacancyRemoteModel(BaseModel<?> vacancyRemoteModel) {
		_vacancyRemoteModel = vacancyRemoteModel;
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

		Class<?> remoteModelClass = _vacancyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_vacancyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VacancyLocalServiceUtil.addVacancy(this);
		}
		else {
			VacancyLocalServiceUtil.updateVacancy(this);
		}
	}

	@Override
	public Vacancy toEscapedModel() {
		return (Vacancy)ProxyUtil.newProxyInstance(Vacancy.class.getClassLoader(),
			new Class[] { Vacancy.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VacancyClp clone = new VacancyClp();

		clone.setVacancyId(getVacancyId());
		clone.setName(getName());
		clone.setNumberOfPosition(getNumberOfPosition());
		clone.setTitlesId(getTitlesId());
		clone.setStatus(getStatus());
		clone.setPostedDate(getPostedDate());
		clone.setExpiredDate(getExpiredDate());
		clone.setDeleted(getDeleted());
		clone.setDescription(getDescription());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCode(getCode());
		clone.setCertificateType(getCertificateType());
		clone.setExperiences(getExperiences());

		return clone;
	}

	@Override
	public int compareTo(Vacancy vacancy) {
		long primaryKey = vacancy.getPrimaryKey();

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

		if (!(obj instanceof VacancyClp)) {
			return false;
		}

		VacancyClp vacancy = (VacancyClp)obj;

		long primaryKey = vacancy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(37);

		sb.append("{vacancyId=");
		sb.append(getVacancyId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", numberOfPosition=");
		sb.append(getNumberOfPosition());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", postedDate=");
		sb.append(getPostedDate());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", deleted=");
		sb.append(getDeleted());
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
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", certificateType=");
		sb.append(getCertificateType());
		sb.append(", experiences=");
		sb.append(getExperiences());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(58);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.Vacancy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vacancyId</column-name><column-value><![CDATA[");
		sb.append(getVacancyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfPosition</column-name><column-value><![CDATA[");
		sb.append(getNumberOfPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postedDate</column-name><column-value><![CDATA[");
		sb.append(getPostedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
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
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateType</column-name><column-value><![CDATA[");
		sb.append(getCertificateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>experiences</column-name><column-value><![CDATA[");
		sb.append(getExperiences());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _vacancyId;
	private String _name;
	private int _numberOfPosition;
	private long _titlesId;
	private String _status;
	private Date _postedDate;
	private Date _expiredDate;
	private boolean _deleted;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _certificateType;
	private double _experiences;
	private BaseModel<?> _vacancyRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}