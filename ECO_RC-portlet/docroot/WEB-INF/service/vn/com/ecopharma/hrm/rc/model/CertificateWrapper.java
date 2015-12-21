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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Certificate}.
 * </p>
 *
 * @author tvt
 * @see Certificate
 * @generated
 */
public class CertificateWrapper implements Certificate,
	ModelWrapper<Certificate> {
	public CertificateWrapper(Certificate certificate) {
		_certificate = certificate;
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

	/**
	* Returns the primary key of this certificate.
	*
	* @return the primary key of this certificate
	*/
	@Override
	public long getPrimaryKey() {
		return _certificate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this certificate.
	*
	* @param primaryKey the primary key of this certificate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_certificate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the certificate ID of this certificate.
	*
	* @return the certificate ID of this certificate
	*/
	@Override
	public long getCertificateId() {
		return _certificate.getCertificateId();
	}

	/**
	* Sets the certificate ID of this certificate.
	*
	* @param certificateId the certificate ID of this certificate
	*/
	@Override
	public void setCertificateId(long certificateId) {
		_certificate.setCertificateId(certificateId);
	}

	/**
	* Returns the class name of this certificate.
	*
	* @return the class name of this certificate
	*/
	@Override
	public java.lang.String getClassName() {
		return _certificate.getClassName();
	}

	/**
	* Sets the class name of this certificate.
	*
	* @param className the class name of this certificate
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_certificate.setClassName(className);
	}

	/**
	* Returns the class p k of this certificate.
	*
	* @return the class p k of this certificate
	*/
	@Override
	public long getClassPK() {
		return _certificate.getClassPK();
	}

	/**
	* Sets the class p k of this certificate.
	*
	* @param classPK the class p k of this certificate
	*/
	@Override
	public void setClassPK(long classPK) {
		_certificate.setClassPK(classPK);
	}

	/**
	* Returns the name of this certificate.
	*
	* @return the name of this certificate
	*/
	@Override
	public java.lang.String getName() {
		return _certificate.getName();
	}

	/**
	* Sets the name of this certificate.
	*
	* @param name the name of this certificate
	*/
	@Override
	public void setName(java.lang.String name) {
		_certificate.setName(name);
	}

	/**
	* Returns the certificate type of this certificate.
	*
	* @return the certificate type of this certificate
	*/
	@Override
	public java.lang.String getCertificateType() {
		return _certificate.getCertificateType();
	}

	/**
	* Sets the certificate type of this certificate.
	*
	* @param certificateType the certificate type of this certificate
	*/
	@Override
	public void setCertificateType(java.lang.String certificateType) {
		_certificate.setCertificateType(certificateType);
	}

	/**
	* Returns the university ID of this certificate.
	*
	* @return the university ID of this certificate
	*/
	@Override
	public long getUniversityId() {
		return _certificate.getUniversityId();
	}

	/**
	* Sets the university ID of this certificate.
	*
	* @param universityId the university ID of this certificate
	*/
	@Override
	public void setUniversityId(long universityId) {
		_certificate.setUniversityId(universityId);
	}

	/**
	* Returns the graduation year of this certificate.
	*
	* @return the graduation year of this certificate
	*/
	@Override
	public int getGraduationYear() {
		return _certificate.getGraduationYear();
	}

	/**
	* Sets the graduation year of this certificate.
	*
	* @param graduationYear the graduation year of this certificate
	*/
	@Override
	public void setGraduationYear(int graduationYear) {
		_certificate.setGraduationYear(graduationYear);
	}

	/**
	* Returns the grade of this certificate.
	*
	* @return the grade of this certificate
	*/
	@Override
	public java.lang.String getGrade() {
		return _certificate.getGrade();
	}

	/**
	* Sets the grade of this certificate.
	*
	* @param grade the grade of this certificate
	*/
	@Override
	public void setGrade(java.lang.String grade) {
		_certificate.setGrade(grade);
	}

	/**
	* Returns the group ID of this certificate.
	*
	* @return the group ID of this certificate
	*/
	@Override
	public long getGroupId() {
		return _certificate.getGroupId();
	}

	/**
	* Sets the group ID of this certificate.
	*
	* @param groupId the group ID of this certificate
	*/
	@Override
	public void setGroupId(long groupId) {
		_certificate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this certificate.
	*
	* @return the company ID of this certificate
	*/
	@Override
	public long getCompanyId() {
		return _certificate.getCompanyId();
	}

	/**
	* Sets the company ID of this certificate.
	*
	* @param companyId the company ID of this certificate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_certificate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this certificate.
	*
	* @return the user ID of this certificate
	*/
	@Override
	public long getUserId() {
		return _certificate.getUserId();
	}

	/**
	* Sets the user ID of this certificate.
	*
	* @param userId the user ID of this certificate
	*/
	@Override
	public void setUserId(long userId) {
		_certificate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this certificate.
	*
	* @return the user uuid of this certificate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _certificate.getUserUuid();
	}

	/**
	* Sets the user uuid of this certificate.
	*
	* @param userUuid the user uuid of this certificate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_certificate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this certificate.
	*
	* @return the user name of this certificate
	*/
	@Override
	public java.lang.String getUserName() {
		return _certificate.getUserName();
	}

	/**
	* Sets the user name of this certificate.
	*
	* @param userName the user name of this certificate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_certificate.setUserName(userName);
	}

	/**
	* Returns the create date of this certificate.
	*
	* @return the create date of this certificate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _certificate.getCreateDate();
	}

	/**
	* Sets the create date of this certificate.
	*
	* @param createDate the create date of this certificate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_certificate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this certificate.
	*
	* @return the modified date of this certificate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _certificate.getModifiedDate();
	}

	/**
	* Sets the modified date of this certificate.
	*
	* @param modifiedDate the modified date of this certificate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_certificate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the course time from of this certificate.
	*
	* @return the course time from of this certificate
	*/
	@Override
	public java.util.Date getCourseTimeFrom() {
		return _certificate.getCourseTimeFrom();
	}

	/**
	* Sets the course time from of this certificate.
	*
	* @param courseTimeFrom the course time from of this certificate
	*/
	@Override
	public void setCourseTimeFrom(java.util.Date courseTimeFrom) {
		_certificate.setCourseTimeFrom(courseTimeFrom);
	}

	/**
	* Returns the course time to of this certificate.
	*
	* @return the course time to of this certificate
	*/
	@Override
	public java.util.Date getCourseTimeTo() {
		return _certificate.getCourseTimeTo();
	}

	/**
	* Sets the course time to of this certificate.
	*
	* @param courseTimeTo the course time to of this certificate
	*/
	@Override
	public void setCourseTimeTo(java.util.Date courseTimeTo) {
		_certificate.setCourseTimeTo(courseTimeTo);
	}

	@Override
	public boolean isNew() {
		return _certificate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_certificate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _certificate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_certificate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _certificate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _certificate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_certificate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _certificate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_certificate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_certificate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_certificate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CertificateWrapper((Certificate)_certificate.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.hrm.rc.model.Certificate certificate) {
		return _certificate.compareTo(certificate);
	}

	@Override
	public int hashCode() {
		return _certificate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.Certificate> toCacheModel() {
		return _certificate.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate toEscapedModel() {
		return new CertificateWrapper(_certificate.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Certificate toUnescapedModel() {
		return new CertificateWrapper(_certificate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _certificate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _certificate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_certificate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CertificateWrapper)) {
			return false;
		}

		CertificateWrapper certificateWrapper = (CertificateWrapper)obj;

		if (Validator.equals(_certificate, certificateWrapper._certificate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Certificate getWrappedCertificate() {
		return _certificate;
	}

	@Override
	public Certificate getWrappedModel() {
		return _certificate;
	}

	@Override
	public void resetOriginalValues() {
		_certificate.resetOriginalValues();
	}

	private Certificate _certificate;
}