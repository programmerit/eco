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

import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class CertificateClp extends BaseModelImpl<Certificate>
	implements Certificate {
	public CertificateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Certificate.class;
	}

	@Override
	public String getModelClassName() {
		return Certificate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _certificateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCertificateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _certificateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("certificateId", getCertificateId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("name", getName());
		attributes.put("certificateType", getCertificateType());
		attributes.put("universityId", getUniversityId());
		attributes.put("graduationYear", getGraduationYear());
		attributes.put("grade", getGrade());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("courseTimeFrom", getCourseTimeFrom());
		attributes.put("courseTimeTo", getCourseTimeTo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long certificateId = (Long)attributes.get("certificateId");

		if (certificateId != null) {
			setCertificateId(certificateId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String certificateType = (String)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		Long universityId = (Long)attributes.get("universityId");

		if (universityId != null) {
			setUniversityId(universityId);
		}

		Integer graduationYear = (Integer)attributes.get("graduationYear");

		if (graduationYear != null) {
			setGraduationYear(graduationYear);
		}

		String grade = (String)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
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

		Date courseTimeFrom = (Date)attributes.get("courseTimeFrom");

		if (courseTimeFrom != null) {
			setCourseTimeFrom(courseTimeFrom);
		}

		Date courseTimeTo = (Date)attributes.get("courseTimeTo");

		if (courseTimeTo != null) {
			setCourseTimeTo(courseTimeTo);
		}
	}

	@Override
	public long getCertificateId() {
		return _certificateId;
	}

	@Override
	public void setCertificateId(long certificateId) {
		_certificateId = certificateId;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateId", long.class);

				method.invoke(_certificateRemoteModel, certificateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_certificateRemoteModel, className);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_certificateRemoteModel, classPK);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_certificateRemoteModel, name);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateType",
						String.class);

				method.invoke(_certificateRemoteModel, certificateType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUniversityId() {
		return _universityId;
	}

	@Override
	public void setUniversityId(long universityId) {
		_universityId = universityId;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUniversityId", long.class);

				method.invoke(_certificateRemoteModel, universityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getGraduationYear() {
		return _graduationYear;
	}

	@Override
	public void setGraduationYear(int graduationYear) {
		_graduationYear = graduationYear;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setGraduationYear", int.class);

				method.invoke(_certificateRemoteModel, graduationYear);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGrade() {
		return _grade;
	}

	@Override
	public void setGrade(String grade) {
		_grade = grade;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setGrade", String.class);

				method.invoke(_certificateRemoteModel, grade);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_certificateRemoteModel, groupId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_certificateRemoteModel, companyId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_certificateRemoteModel, userId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_certificateRemoteModel, userName);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_certificateRemoteModel, createDate);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_certificateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCourseTimeFrom() {
		return _courseTimeFrom;
	}

	@Override
	public void setCourseTimeFrom(Date courseTimeFrom) {
		_courseTimeFrom = courseTimeFrom;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseTimeFrom", Date.class);

				method.invoke(_certificateRemoteModel, courseTimeFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCourseTimeTo() {
		return _courseTimeTo;
	}

	@Override
	public void setCourseTimeTo(Date courseTimeTo) {
		_courseTimeTo = courseTimeTo;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseTimeTo", Date.class);

				method.invoke(_certificateRemoteModel, courseTimeTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCertificateRemoteModel() {
		return _certificateRemoteModel;
	}

	public void setCertificateRemoteModel(BaseModel<?> certificateRemoteModel) {
		_certificateRemoteModel = certificateRemoteModel;
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

		Class<?> remoteModelClass = _certificateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_certificateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CertificateLocalServiceUtil.addCertificate(this);
		}
		else {
			CertificateLocalServiceUtil.updateCertificate(this);
		}
	}

	@Override
	public Certificate toEscapedModel() {
		return (Certificate)ProxyUtil.newProxyInstance(Certificate.class.getClassLoader(),
			new Class[] { Certificate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CertificateClp clone = new CertificateClp();

		clone.setCertificateId(getCertificateId());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setName(getName());
		clone.setCertificateType(getCertificateType());
		clone.setUniversityId(getUniversityId());
		clone.setGraduationYear(getGraduationYear());
		clone.setGrade(getGrade());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCourseTimeFrom(getCourseTimeFrom());
		clone.setCourseTimeTo(getCourseTimeTo());

		return clone;
	}

	@Override
	public int compareTo(Certificate certificate) {
		long primaryKey = certificate.getPrimaryKey();

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

		if (!(obj instanceof CertificateClp)) {
			return false;
		}

		CertificateClp certificate = (CertificateClp)obj;

		long primaryKey = certificate.getPrimaryKey();

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

		sb.append("{certificateId=");
		sb.append(getCertificateId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", certificateType=");
		sb.append(getCertificateType());
		sb.append(", universityId=");
		sb.append(getUniversityId());
		sb.append(", graduationYear=");
		sb.append(getGraduationYear());
		sb.append(", grade=");
		sb.append(getGrade());
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
		sb.append(", courseTimeFrom=");
		sb.append(getCourseTimeFrom());
		sb.append(", courseTimeTo=");
		sb.append(getCourseTimeTo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.Certificate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>certificateId</column-name><column-value><![CDATA[");
		sb.append(getCertificateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateType</column-name><column-value><![CDATA[");
		sb.append(getCertificateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>universityId</column-name><column-value><![CDATA[");
		sb.append(getUniversityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graduationYear</column-name><column-value><![CDATA[");
		sb.append(getGraduationYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grade</column-name><column-value><![CDATA[");
		sb.append(getGrade());
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
			"<column><column-name>courseTimeFrom</column-name><column-value><![CDATA[");
		sb.append(getCourseTimeFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseTimeTo</column-name><column-value><![CDATA[");
		sb.append(getCourseTimeTo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _certificateId;
	private String _className;
	private long _classPK;
	private String _name;
	private String _certificateType;
	private long _universityId;
	private int _graduationYear;
	private String _grade;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _courseTimeFrom;
	private Date _courseTimeTo;
	private BaseModel<?> _certificateRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}