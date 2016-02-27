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
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.hrm.rc.service.http.CandidateServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.hrm.rc.service.http.CandidateServiceSoap
 * @generated
 */
public class CandidateSoap implements Serializable {
	public static CandidateSoap toSoapModel(Candidate model) {
		CandidateSoap soapModel = new CandidateSoap();

		soapModel.setCandidateId(model.getCandidateId());
		soapModel.setCandidateCode(model.getCandidateCode());
		soapModel.setFullName(model.getFullName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setPlaceOfBirth(model.getPlaceOfBirth());
		soapModel.setGender(model.getGender());
		soapModel.setIdentityCardNo(model.getIdentityCardNo());
		soapModel.setIssuedDate(model.getIssuedDate());
		soapModel.setIssuedPlace(model.getIssuedPlace());
		soapModel.setMaritalStatus(model.getMaritalStatus());
		soapModel.setNumberOfChild(model.getNumberOfChild());
		soapModel.setNationalityId(model.getNationalityId());
		soapModel.setEthnic(model.getEthnic());
		soapModel.setReligion(model.getReligion());
		soapModel.setApplicationDate(model.getApplicationDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setLocationId(model.getLocationId());
		soapModel.setDeleted(model.getDeleted());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static CandidateSoap[] toSoapModels(Candidate[] models) {
		CandidateSoap[] soapModels = new CandidateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CandidateSoap[][] toSoapModels(Candidate[][] models) {
		CandidateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CandidateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CandidateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CandidateSoap[] toSoapModels(List<Candidate> models) {
		List<CandidateSoap> soapModels = new ArrayList<CandidateSoap>(models.size());

		for (Candidate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CandidateSoap[soapModels.size()]);
	}

	public CandidateSoap() {
	}

	public long getPrimaryKey() {
		return _candidateId;
	}

	public void setPrimaryKey(long pk) {
		setCandidateId(pk);
	}

	public long getCandidateId() {
		return _candidateId;
	}

	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	public String getCandidateCode() {
		return _candidateCode;
	}

	public void setCandidateCode(String candidateCode) {
		_candidateCode = candidateCode;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return _placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getIdentityCardNo() {
		return _identityCardNo;
	}

	public void setIdentityCardNo(String identityCardNo) {
		_identityCardNo = identityCardNo;
	}

	public Date getIssuedDate() {
		return _issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	public String getIssuedPlace() {
		return _issuedPlace;
	}

	public void setIssuedPlace(String issuedPlace) {
		_issuedPlace = issuedPlace;
	}

	public String getMaritalStatus() {
		return _maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	public int getNumberOfChild() {
		return _numberOfChild;
	}

	public void setNumberOfChild(int numberOfChild) {
		_numberOfChild = numberOfChild;
	}

	public long getNationalityId() {
		return _nationalityId;
	}

	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;
	}

	public String getEthnic() {
		return _ethnic;
	}

	public void setEthnic(String ethnic) {
		_ethnic = ethnic;
	}

	public String getReligion() {
		return _religion;
	}

	public void setReligion(String religion) {
		_religion = religion;
	}

	public Date getApplicationDate() {
		return _applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		_applicationDate = applicationDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getLocationId() {
		return _locationId;
	}

	public void setLocationId(long locationId) {
		_locationId = locationId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _candidateId;
	private String _candidateCode;
	private String _fullName;
	private String _emailAddress;
	private String _contactNumber;
	private Date _dateOfBirth;
	private String _placeOfBirth;
	private String _gender;
	private String _identityCardNo;
	private Date _issuedDate;
	private String _issuedPlace;
	private String _maritalStatus;
	private int _numberOfChild;
	private long _nationalityId;
	private String _ethnic;
	private String _religion;
	private Date _applicationDate;
	private String _status;
	private long _locationId;
	private boolean _deleted;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
}