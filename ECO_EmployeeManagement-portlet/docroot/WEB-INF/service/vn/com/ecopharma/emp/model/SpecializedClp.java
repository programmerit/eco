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
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class SpecializedClp extends BaseModelImpl<Specialized>
	implements Specialized {
	public SpecializedClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Specialized.class;
	}

	@Override
	public String getModelClassName() {
		return Specialized.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _specializedId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpecializedId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _specializedId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("specializedId", getSpecializedId());
		attributes.put("specializedCode", getSpecializedCode());
		attributes.put("name", getName());
		attributes.put("level", getLevel());
		attributes.put("parentId", getParentId());
		attributes.put("university", getUniversity());
		attributes.put("college", getCollege());
		attributes.put("vocationalCollege", getVocationalCollege());
		attributes.put("vocational", getVocational());
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
		Long specializedId = (Long)attributes.get("specializedId");

		if (specializedId != null) {
			setSpecializedId(specializedId);
		}

		String specializedCode = (String)attributes.get("specializedCode");

		if (specializedCode != null) {
			setSpecializedCode(specializedCode);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Boolean university = (Boolean)attributes.get("university");

		if (university != null) {
			setUniversity(university);
		}

		Boolean college = (Boolean)attributes.get("college");

		if (college != null) {
			setCollege(college);
		}

		Boolean vocationalCollege = (Boolean)attributes.get("vocationalCollege");

		if (vocationalCollege != null) {
			setVocationalCollege(vocationalCollege);
		}

		Boolean vocational = (Boolean)attributes.get("vocational");

		if (vocational != null) {
			setVocational(vocational);
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
	public long getSpecializedId() {
		return _specializedId;
	}

	@Override
	public void setSpecializedId(long specializedId) {
		_specializedId = specializedId;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecializedId", long.class);

				method.invoke(_specializedRemoteModel, specializedId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSpecializedCode() {
		return _specializedCode;
	}

	@Override
	public void setSpecializedCode(String specializedCode) {
		_specializedCode = specializedCode;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecializedCode",
						String.class);

				method.invoke(_specializedRemoteModel, specializedCode);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_specializedRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLevel() {
		return _level;
	}

	@Override
	public void setLevel(int level) {
		_level = level;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", int.class);

				method.invoke(_specializedRemoteModel, level);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_specializedRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getUniversity() {
		return _university;
	}

	@Override
	public boolean isUniversity() {
		return _university;
	}

	@Override
	public void setUniversity(boolean university) {
		_university = university;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setUniversity", boolean.class);

				method.invoke(_specializedRemoteModel, university);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCollege() {
		return _college;
	}

	@Override
	public boolean isCollege() {
		return _college;
	}

	@Override
	public void setCollege(boolean college) {
		_college = college;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setCollege", boolean.class);

				method.invoke(_specializedRemoteModel, college);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVocationalCollege() {
		return _vocationalCollege;
	}

	@Override
	public boolean isVocationalCollege() {
		return _vocationalCollege;
	}

	@Override
	public void setVocationalCollege(boolean vocationalCollege) {
		_vocationalCollege = vocationalCollege;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setVocationalCollege",
						boolean.class);

				method.invoke(_specializedRemoteModel, vocationalCollege);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getVocational() {
		return _vocational;
	}

	@Override
	public boolean isVocational() {
		return _vocational;
	}

	@Override
	public void setVocational(boolean vocational) {
		_vocational = vocational;

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setVocational", boolean.class);

				method.invoke(_specializedRemoteModel, vocational);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_specializedRemoteModel, groupId);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_specializedRemoteModel, companyId);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_specializedRemoteModel, userId);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_specializedRemoteModel, userName);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_specializedRemoteModel, createDate);
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

		if (_specializedRemoteModel != null) {
			try {
				Class<?> clazz = _specializedRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_specializedRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSpecializedRemoteModel() {
		return _specializedRemoteModel;
	}

	public void setSpecializedRemoteModel(BaseModel<?> specializedRemoteModel) {
		_specializedRemoteModel = specializedRemoteModel;
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

		Class<?> remoteModelClass = _specializedRemoteModel.getClass();

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

		Object returnValue = method.invoke(_specializedRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SpecializedLocalServiceUtil.addSpecialized(this);
		}
		else {
			SpecializedLocalServiceUtil.updateSpecialized(this);
		}
	}

	@Override
	public Specialized toEscapedModel() {
		return (Specialized)ProxyUtil.newProxyInstance(Specialized.class.getClassLoader(),
			new Class[] { Specialized.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SpecializedClp clone = new SpecializedClp();

		clone.setSpecializedId(getSpecializedId());
		clone.setSpecializedCode(getSpecializedCode());
		clone.setName(getName());
		clone.setLevel(getLevel());
		clone.setParentId(getParentId());
		clone.setUniversity(getUniversity());
		clone.setCollege(getCollege());
		clone.setVocationalCollege(getVocationalCollege());
		clone.setVocational(getVocational());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Specialized specialized) {
		long primaryKey = specialized.getPrimaryKey();

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

		if (!(obj instanceof SpecializedClp)) {
			return false;
		}

		SpecializedClp specialized = (SpecializedClp)obj;

		long primaryKey = specialized.getPrimaryKey();

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

		sb.append("{specializedId=");
		sb.append(getSpecializedId());
		sb.append(", specializedCode=");
		sb.append(getSpecializedCode());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", university=");
		sb.append(getUniversity());
		sb.append(", college=");
		sb.append(getCollege());
		sb.append(", vocationalCollege=");
		sb.append(getVocationalCollege());
		sb.append(", vocational=");
		sb.append(getVocational());
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
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.Specialized");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>specializedId</column-name><column-value><![CDATA[");
		sb.append(getSpecializedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specializedCode</column-name><column-value><![CDATA[");
		sb.append(getSpecializedCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>university</column-name><column-value><![CDATA[");
		sb.append(getUniversity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>college</column-name><column-value><![CDATA[");
		sb.append(getCollege());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vocationalCollege</column-name><column-value><![CDATA[");
		sb.append(getVocationalCollege());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>vocational</column-name><column-value><![CDATA[");
		sb.append(getVocational());
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

	private long _specializedId;
	private String _specializedCode;
	private String _name;
	private int _level;
	private long _parentId;
	private boolean _university;
	private boolean _college;
	private boolean _vocationalCollege;
	private boolean _vocational;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _specializedRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}