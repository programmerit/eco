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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.VacancyServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.VacancyServiceSoap
 * @generated
 */
public class VacancySoap implements Serializable {
	public static VacancySoap toSoapModel(Vacancy model) {
		VacancySoap soapModel = new VacancySoap();

		soapModel.setVacancyId(model.getVacancyId());
		soapModel.setName(model.getName());
		soapModel.setNumberOfPosition(model.getNumberOfPosition());
		soapModel.setTitlesId(model.getTitlesId());
		soapModel.setStatus(model.getStatus());
		soapModel.setPostedDate(model.getPostedDate());
		soapModel.setExpiredDate(model.getExpiredDate());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setCertificateType(model.getCertificateType());
		soapModel.setExperiences(model.getExperiences());

		return soapModel;
	}

	public static VacancySoap[] toSoapModels(Vacancy[] models) {
		VacancySoap[] soapModels = new VacancySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacancySoap[][] toSoapModels(Vacancy[][] models) {
		VacancySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacancySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacancySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacancySoap[] toSoapModels(List<Vacancy> models) {
		List<VacancySoap> soapModels = new ArrayList<VacancySoap>(models.size());

		for (Vacancy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacancySoap[soapModels.size()]);
	}

	public VacancySoap() {
	}

	public long getPrimaryKey() {
		return _vacancyId;
	}

	public void setPrimaryKey(long pk) {
		setVacancyId(pk);
	}

	public long getVacancyId() {
		return _vacancyId;
	}

	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getNumberOfPosition() {
		return _numberOfPosition;
	}

	public void setNumberOfPosition(int numberOfPosition) {
		_numberOfPosition = numberOfPosition;
	}

	public long getTitlesId() {
		return _titlesId;
	}

	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getPostedDate() {
		return _postedDate;
	}

	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;
	}

	public Date getExpiredDate() {
		return _expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getCertificateType() {
		return _certificateType;
	}

	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;
	}

	public double getExperiences() {
		return _experiences;
	}

	public void setExperiences(double experiences) {
		_experiences = experiences;
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
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _certificateType;
	private double _experiences;
}