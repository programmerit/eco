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

import vn.com.ecopharma.emp.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.emp.service.ClpSerializer;

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
		attributes.put("education", getEducation());
		attributes.put("certificateType", getCertificateType());
		attributes.put("name", getName());
		attributes.put("specialize", getSpecialize());
		attributes.put("coursePlace", getCoursePlace());
		attributes.put("graduatedYear", getGraduatedYear());
		attributes.put("grade", getGrade());
		attributes.put("courseType", getCourseType());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("issuedPlace", getIssuedPlace());
		attributes.put("note", getNote());
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

		String education = (String)attributes.get("education");

		if (education != null) {
			setEducation(education);
		}

		String certificateType = (String)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String specialize = (String)attributes.get("specialize");

		if (specialize != null) {
			setSpecialize(specialize);
		}

		Long coursePlace = (Long)attributes.get("coursePlace");

		if (coursePlace != null) {
			setCoursePlace(coursePlace);
		}

		Date graduatedYear = (Date)attributes.get("graduatedYear");

		if (graduatedYear != null) {
			setGraduatedYear(graduatedYear);
		}

		String grade = (String)attributes.get("grade");

		if (grade != null) {
			setGrade(grade);
		}

		String courseType = (String)attributes.get("courseType");

		if (courseType != null) {
			setCourseType(courseType);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
		}

		String issuedPlace = (String)attributes.get("issuedPlace");

		if (issuedPlace != null) {
			setIssuedPlace(issuedPlace);
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
	public String getEducation() {
		return _education;
	}

	@Override
	public void setEducation(String education) {
		_education = education;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setEducation", String.class);

				method.invoke(_certificateRemoteModel, education);
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
	public String getSpecialize() {
		return _specialize;
	}

	@Override
	public void setSpecialize(String specialize) {
		_specialize = specialize;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpecialize", String.class);

				method.invoke(_certificateRemoteModel, specialize);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCoursePlace() {
		return _coursePlace;
	}

	@Override
	public void setCoursePlace(long coursePlace) {
		_coursePlace = coursePlace;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCoursePlace", long.class);

				method.invoke(_certificateRemoteModel, coursePlace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getGraduatedYear() {
		return _graduatedYear;
	}

	@Override
	public void setGraduatedYear(Date graduatedYear) {
		_graduatedYear = graduatedYear;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setGraduatedYear", Date.class);

				method.invoke(_certificateRemoteModel, graduatedYear);
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
	public String getCourseType() {
		return _courseType;
	}

	@Override
	public void setCourseType(String courseType) {
		_courseType = courseType;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseType", String.class);

				method.invoke(_certificateRemoteModel, courseType);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredDate", Date.class);

				method.invoke(_certificateRemoteModel, expiredDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIssuedPlace() {
		return _issuedPlace;
	}

	@Override
	public void setIssuedPlace(String issuedPlace) {
		_issuedPlace = issuedPlace;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setIssuedPlace", String.class);

				method.invoke(_certificateRemoteModel, issuedPlace);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_certificateRemoteModel, note);
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
		clone.setEducation(getEducation());
		clone.setCertificateType(getCertificateType());
		clone.setName(getName());
		clone.setSpecialize(getSpecialize());
		clone.setCoursePlace(getCoursePlace());
		clone.setGraduatedYear(getGraduatedYear());
		clone.setGrade(getGrade());
		clone.setCourseType(getCourseType());
		clone.setExpiredDate(getExpiredDate());
		clone.setIssuedPlace(getIssuedPlace());
		clone.setNote(getNote());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

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
		StringBundler sb = new StringBundler(41);

		sb.append("{certificateId=");
		sb.append(getCertificateId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", education=");
		sb.append(getEducation());
		sb.append(", certificateType=");
		sb.append(getCertificateType());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", specialize=");
		sb.append(getSpecialize());
		sb.append(", coursePlace=");
		sb.append(getCoursePlace());
		sb.append(", graduatedYear=");
		sb.append(getGraduatedYear());
		sb.append(", grade=");
		sb.append(getGrade());
		sb.append(", courseType=");
		sb.append(getCourseType());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
		sb.append(", issuedPlace=");
		sb.append(getIssuedPlace());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(64);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.Certificate");
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
			"<column><column-name>education</column-name><column-value><![CDATA[");
		sb.append(getEducation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateType</column-name><column-value><![CDATA[");
		sb.append(getCertificateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specialize</column-name><column-value><![CDATA[");
		sb.append(getSpecialize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coursePlace</column-name><column-value><![CDATA[");
		sb.append(getCoursePlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graduatedYear</column-name><column-value><![CDATA[");
		sb.append(getGraduatedYear());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>grade</column-name><column-value><![CDATA[");
		sb.append(getGrade());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseType</column-name><column-value><![CDATA[");
		sb.append(getCourseType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedPlace</column-name><column-value><![CDATA[");
		sb.append(getIssuedPlace());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _certificateId;
	private String _className;
	private long _classPK;
	private String _education;
	private String _certificateType;
	private String _name;
	private String _specialize;
	private long _coursePlace;
	private Date _graduatedYear;
	private String _grade;
	private String _courseType;
	private Date _expiredDate;
	private String _issuedPlace;
	private String _note;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _certificateRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.emp.service.ClpSerializer.class;
}