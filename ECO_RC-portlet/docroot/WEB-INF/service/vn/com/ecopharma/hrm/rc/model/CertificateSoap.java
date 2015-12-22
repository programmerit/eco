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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.CertificateServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.CertificateServiceSoap
 * @generated
 */
public class CertificateSoap implements Serializable {
	public static CertificateSoap toSoapModel(Certificate model) {
		CertificateSoap soapModel = new CertificateSoap();

		soapModel.setCertificateId(model.getCertificateId());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setName(model.getName());
		soapModel.setCertificateType(model.getCertificateType());
		soapModel.setUniversityId(model.getUniversityId());
		soapModel.setGraduationYear(model.getGraduationYear());
		soapModel.setGrade(model.getGrade());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCourseTimeFrom(model.getCourseTimeFrom());
		soapModel.setCourseTimeTo(model.getCourseTimeTo());

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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCertificateType() {
		return _certificateType;
	}

	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;
	}

	public long getUniversityId() {
		return _universityId;
	}

	public void setUniversityId(long universityId) {
		_universityId = universityId;
	}

	public int getGraduationYear() {
		return _graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		_graduationYear = graduationYear;
	}

	public String getGrade() {
		return _grade;
	}

	public void setGrade(String grade) {
		_grade = grade;
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

	public Date getCourseTimeFrom() {
		return _courseTimeFrom;
	}

	public void setCourseTimeFrom(Date courseTimeFrom) {
		_courseTimeFrom = courseTimeFrom;
	}

	public Date getCourseTimeTo() {
		return _courseTimeTo;
	}

	public void setCourseTimeTo(Date courseTimeTo) {
		_courseTimeTo = courseTimeTo;
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
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _courseTimeFrom;
	private Date _courseTimeTo;
}