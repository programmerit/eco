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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.CertificateServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.CertificateServiceSoap
 * @generated
 */
public class CertificateSoap implements Serializable {
	public static CertificateSoap toSoapModel(Certificate model) {
		CertificateSoap soapModel = new CertificateSoap();

		soapModel.setCertificateId(model.getCertificateId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setEducation(model.getEducation());
		soapModel.setCertificateType(model.getCertificateType());
		soapModel.setName(model.getName());
		soapModel.setSpecialize(model.getSpecialize());
		soapModel.setCoursePlace(model.getCoursePlace());
		soapModel.setGraduatedYear(model.getGraduatedYear());
		soapModel.setGrade(model.getGrade());
		soapModel.setCourseType(model.getCourseType());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setIssuedPlace(model.getIssuedPlace());
		soapModel.setNote(model.getNote());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static CertificateSoap[] toSoapModels(Certificate[] models) {
		CertificateSoap[] soapModels = new CertificateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CertificateSoap[][] toSoapModels(Certificate[][] models) {
		CertificateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CertificateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CertificateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CertificateSoap[] toSoapModels(List<Certificate> models) {
		List<CertificateSoap> soapModels = new ArrayList<CertificateSoap>(models.size());

		for (Certificate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CertificateSoap[soapModels.size()]);
	}

	public CertificateSoap() {
	}

	public long getPrimaryKey() {
		return _certificateId;
	}

	public void setPrimaryKey(long pk) {
		setCertificateId(pk);
	}

	public long getCertificateId() {
		return _certificateId;
	}

	public void setCertificateId(long certificateId) {
		_certificateId = certificateId;
	}

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getEducation() {
		return _education;
	}

	public void setEducation(String education) {
		_education = education;
	}

	public String getCertificateType() {
		return _certificateType;
	}

	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getSpecialize() {
		return _specialize;
	}

	public void setSpecialize(String specialize) {
		_specialize = specialize;
	}

	public long getCoursePlace() {
		return _coursePlace;
	}

	public void setCoursePlace(long coursePlace) {
		_coursePlace = coursePlace;
	}

	public Date getGraduatedYear() {
		return _graduatedYear;
	}

	public void setGraduatedYear(Date graduatedYear) {
		_graduatedYear = graduatedYear;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
	}

	public String getCourseType() {
		return _courseType;
	}

	public void setCourseType(String courseType) {
		_courseType = courseType;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public String getIssuedPlace() {
		return _issuedPlace;
	}

	public void setIssuedPlace(String issuedPlace) {
		_issuedPlace = issuedPlace;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}