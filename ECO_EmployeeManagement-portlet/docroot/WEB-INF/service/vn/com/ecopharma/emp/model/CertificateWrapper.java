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
	* Returns the education of this certificate.
	*
	* @return the education of this certificate
	*/
	@Override
	public java.lang.String getEducation() {
		return _certificate.getEducation();
	}

	/**
	* Sets the education of this certificate.
	*
	* @param education the education of this certificate
	*/
	@Override
	public void setEducation(java.lang.String education) {
		_certificate.setEducation(education);
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
	* Returns the specialize of this certificate.
	*
	* @return the specialize of this certificate
	*/
	@Override
	public java.lang.String getSpecialize() {
		return _certificate.getSpecialize();
	}

	/**
	* Sets the specialize of this certificate.
	*
	* @param specialize the specialize of this certificate
	*/
	@Override
	public void setSpecialize(java.lang.String specialize) {
		_certificate.setSpecialize(specialize);
	}

	/**
	* Returns the course place of this certificate.
	*
	* @return the course place of this certificate
	*/
	@Override
	public long getCoursePlace() {
		return _certificate.getCoursePlace();
	}

	/**
	* Sets the course place of this certificate.
	*
	* @param coursePlace the course place of this certificate
	*/
	@Override
	public void setCoursePlace(long coursePlace) {
		_certificate.setCoursePlace(coursePlace);
	}

	/**
	* Returns the graduated year of this certificate.
	*
	* @return the graduated year of this certificate
	*/
	@Override
	public java.util.Date getGraduatedYear() {
		return _certificate.getGraduatedYear();
	}

	/**
	* Sets the graduated year of this certificate.
	*
	* @param graduatedYear the graduated year of this certificate
	*/
	@Override
	public void setGraduatedYear(java.util.Date graduatedYear) {
		_certificate.setGraduatedYear(graduatedYear);
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
	* Returns the course type of this certificate.
	*
	* @return the course type of this certificate
	*/
	@Override
	public java.lang.String getCourseType() {
		return _certificate.getCourseType();
	}

	/**
	* Sets the course type of this certificate.
	*
	* @param courseType the course type of this certificate
	*/
	@Override
	public void setCourseType(java.lang.String courseType) {
		_certificate.setCourseType(courseType);
	}

	/**
	* Returns the expired date of this certificate.
	*
	* @return the expired date of this certificate
	*/
	@Override
	public java.util.Date getExpiredDate() {
		return _certificate.getExpiredDate();
	}

	/**
	* Sets the expired date of this certificate.
	*
	* @param expiredDate the expired date of this certificate
	*/
	@Override
	public void setExpiredDate(java.util.Date expiredDate) {
		_certificate.setExpiredDate(expiredDate);
	}

	/**
	* Returns the issued place of this certificate.
	*
	* @return the issued place of this certificate
	*/
	@Override
	public java.lang.String getIssuedPlace() {
		return _certificate.getIssuedPlace();
	}

	/**
	* Sets the issued place of this certificate.
	*
	* @param issuedPlace the issued place of this certificate
	*/
	@Override
	public void setIssuedPlace(java.lang.String issuedPlace) {
		_certificate.setIssuedPlace(issuedPlace);
	}

	/**
	* Returns the note of this certificate.
	*
	* @return the note of this certificate
	*/
	@Override
	public java.lang.String getNote() {
		return _certificate.getNote();
	}

	/**
	* Sets the note of this certificate.
	*
	* @param note the note of this certificate
	*/
	@Override
	public void setNote(java.lang.String note) {
		_certificate.setNote(note);
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
	public int compareTo(vn.com.ecopharma.emp.model.Certificate certificate) {
		return _certificate.compareTo(certificate);
	}

	@Override
	public int hashCode() {
		return _certificate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.emp.model.Certificate> toCacheModel() {
		return _certificate.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.emp.model.Certificate toEscapedModel() {
		return new CertificateWrapper(_certificate.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.emp.model.Certificate toUnescapedModel() {
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