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
 * This class is a wrapper for {@link Candidate}.
 * </p>
 *
 * @author tvt
 * @see Candidate
 * @generated
 */
public class CandidateWrapper implements Candidate, ModelWrapper<Candidate> {
	public CandidateWrapper(Candidate candidate) {
		_candidate = candidate;
	}

	@Override
	public Class<?> getModelClass() {
		return Candidate.class;
	}

	@Override
	public String getModelClassName() {
		return Candidate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("candidateId", getCandidateId());
		attributes.put("candidateCode", getCandidateCode());
		attributes.put("fullName", getFullName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("placeOfBirth", getPlaceOfBirth());
		attributes.put("gender", getGender());
		attributes.put("identityCardNo", getIdentityCardNo());
		attributes.put("issuedDate", getIssuedDate());
		attributes.put("issuedPlace", getIssuedPlace());
		attributes.put("maritalStatus", getMaritalStatus());
		attributes.put("numberOfChild", getNumberOfChild());
		attributes.put("nationalityId", getNationalityId());
		attributes.put("ethnic", getEthnic());
		attributes.put("religion", getReligion());
		attributes.put("applicationDate", getApplicationDate());
		attributes.put("status", getStatus());
		attributes.put("locationId", getLocationId());
		attributes.put("deleted", getDeleted());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long candidateId = (Long)attributes.get("candidateId");

		if (candidateId != null) {
			setCandidateId(candidateId);
		}

		String candidateCode = (String)attributes.get("candidateCode");

		if (candidateCode != null) {
			setCandidateCode(candidateCode);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String placeOfBirth = (String)attributes.get("placeOfBirth");

		if (placeOfBirth != null) {
			setPlaceOfBirth(placeOfBirth);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String identityCardNo = (String)attributes.get("identityCardNo");

		if (identityCardNo != null) {
			setIdentityCardNo(identityCardNo);
		}

		Date issuedDate = (Date)attributes.get("issuedDate");

		if (issuedDate != null) {
			setIssuedDate(issuedDate);
		}

		String issuedPlace = (String)attributes.get("issuedPlace");

		if (issuedPlace != null) {
			setIssuedPlace(issuedPlace);
		}

		String maritalStatus = (String)attributes.get("maritalStatus");

		if (maritalStatus != null) {
			setMaritalStatus(maritalStatus);
		}

		Integer numberOfChild = (Integer)attributes.get("numberOfChild");

		if (numberOfChild != null) {
			setNumberOfChild(numberOfChild);
		}

		Long nationalityId = (Long)attributes.get("nationalityId");

		if (nationalityId != null) {
			setNationalityId(nationalityId);
		}

		String ethnic = (String)attributes.get("ethnic");

		if (ethnic != null) {
			setEthnic(ethnic);
		}

		String religion = (String)attributes.get("religion");

		if (religion != null) {
			setReligion(religion);
		}

		Date applicationDate = (Date)attributes.get("applicationDate");

		if (applicationDate != null) {
			setApplicationDate(applicationDate);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long locationId = (Long)attributes.get("locationId");

		if (locationId != null) {
			setLocationId(locationId);
		}

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this candidate.
	*
	* @return the primary key of this candidate
	*/
	@Override
	public long getPrimaryKey() {
		return _candidate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this candidate.
	*
	* @param primaryKey the primary key of this candidate
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_candidate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the candidate ID of this candidate.
	*
	* @return the candidate ID of this candidate
	*/
	@Override
	public long getCandidateId() {
		return _candidate.getCandidateId();
	}

	/**
	* Sets the candidate ID of this candidate.
	*
	* @param candidateId the candidate ID of this candidate
	*/
	@Override
	public void setCandidateId(long candidateId) {
		_candidate.setCandidateId(candidateId);
	}

	/**
	* Returns the candidate code of this candidate.
	*
	* @return the candidate code of this candidate
	*/
	@Override
	public java.lang.String getCandidateCode() {
		return _candidate.getCandidateCode();
	}

	/**
	* Sets the candidate code of this candidate.
	*
	* @param candidateCode the candidate code of this candidate
	*/
	@Override
	public void setCandidateCode(java.lang.String candidateCode) {
		_candidate.setCandidateCode(candidateCode);
	}

	/**
	* Returns the full name of this candidate.
	*
	* @return the full name of this candidate
	*/
	@Override
	public java.lang.String getFullName() {
		return _candidate.getFullName();
	}

	/**
	* Sets the full name of this candidate.
	*
	* @param fullName the full name of this candidate
	*/
	@Override
	public void setFullName(java.lang.String fullName) {
		_candidate.setFullName(fullName);
	}

	/**
	* Returns the email address of this candidate.
	*
	* @return the email address of this candidate
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _candidate.getEmailAddress();
	}

	/**
	* Sets the email address of this candidate.
	*
	* @param emailAddress the email address of this candidate
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_candidate.setEmailAddress(emailAddress);
	}

	/**
	* Returns the contact number of this candidate.
	*
	* @return the contact number of this candidate
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _candidate.getContactNumber();
	}

	/**
	* Sets the contact number of this candidate.
	*
	* @param contactNumber the contact number of this candidate
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_candidate.setContactNumber(contactNumber);
	}

	/**
	* Returns the date of birth of this candidate.
	*
	* @return the date of birth of this candidate
	*/
	@Override
	public java.util.Date getDateOfBirth() {
		return _candidate.getDateOfBirth();
	}

	/**
	* Sets the date of birth of this candidate.
	*
	* @param dateOfBirth the date of birth of this candidate
	*/
	@Override
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		_candidate.setDateOfBirth(dateOfBirth);
	}

	/**
	* Returns the place of birth of this candidate.
	*
	* @return the place of birth of this candidate
	*/
	@Override
	public java.lang.String getPlaceOfBirth() {
		return _candidate.getPlaceOfBirth();
	}

	/**
	* Sets the place of birth of this candidate.
	*
	* @param placeOfBirth the place of birth of this candidate
	*/
	@Override
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		_candidate.setPlaceOfBirth(placeOfBirth);
	}

	/**
	* Returns the gender of this candidate.
	*
	* @return the gender of this candidate
	*/
	@Override
	public java.lang.String getGender() {
		return _candidate.getGender();
	}

	/**
	* Sets the gender of this candidate.
	*
	* @param gender the gender of this candidate
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_candidate.setGender(gender);
	}

	/**
	* Returns the identity card no of this candidate.
	*
	* @return the identity card no of this candidate
	*/
	@Override
	public java.lang.String getIdentityCardNo() {
		return _candidate.getIdentityCardNo();
	}

	/**
	* Sets the identity card no of this candidate.
	*
	* @param identityCardNo the identity card no of this candidate
	*/
	@Override
	public void setIdentityCardNo(java.lang.String identityCardNo) {
		_candidate.setIdentityCardNo(identityCardNo);
	}

	/**
	* Returns the issued date of this candidate.
	*
	* @return the issued date of this candidate
	*/
	@Override
	public java.util.Date getIssuedDate() {
		return _candidate.getIssuedDate();
	}

	/**
	* Sets the issued date of this candidate.
	*
	* @param issuedDate the issued date of this candidate
	*/
	@Override
	public void setIssuedDate(java.util.Date issuedDate) {
		_candidate.setIssuedDate(issuedDate);
	}

	/**
	* Returns the issued place of this candidate.
	*
	* @return the issued place of this candidate
	*/
	@Override
	public java.lang.String getIssuedPlace() {
		return _candidate.getIssuedPlace();
	}

	/**
	* Sets the issued place of this candidate.
	*
	* @param issuedPlace the issued place of this candidate
	*/
	@Override
	public void setIssuedPlace(java.lang.String issuedPlace) {
		_candidate.setIssuedPlace(issuedPlace);
	}

	/**
	* Returns the marital status of this candidate.
	*
	* @return the marital status of this candidate
	*/
	@Override
	public java.lang.String getMaritalStatus() {
		return _candidate.getMaritalStatus();
	}

	/**
	* Sets the marital status of this candidate.
	*
	* @param maritalStatus the marital status of this candidate
	*/
	@Override
	public void setMaritalStatus(java.lang.String maritalStatus) {
		_candidate.setMaritalStatus(maritalStatus);
	}

	/**
	* Returns the number of child of this candidate.
	*
	* @return the number of child of this candidate
	*/
	@Override
	public int getNumberOfChild() {
		return _candidate.getNumberOfChild();
	}

	/**
	* Sets the number of child of this candidate.
	*
	* @param numberOfChild the number of child of this candidate
	*/
	@Override
	public void setNumberOfChild(int numberOfChild) {
		_candidate.setNumberOfChild(numberOfChild);
	}

	/**
	* Returns the nationality ID of this candidate.
	*
	* @return the nationality ID of this candidate
	*/
	@Override
	public long getNationalityId() {
		return _candidate.getNationalityId();
	}

	/**
	* Sets the nationality ID of this candidate.
	*
	* @param nationalityId the nationality ID of this candidate
	*/
	@Override
	public void setNationalityId(long nationalityId) {
		_candidate.setNationalityId(nationalityId);
	}

	/**
	* Returns the ethnic of this candidate.
	*
	* @return the ethnic of this candidate
	*/
	@Override
	public java.lang.String getEthnic() {
		return _candidate.getEthnic();
	}

	/**
	* Sets the ethnic of this candidate.
	*
	* @param ethnic the ethnic of this candidate
	*/
	@Override
	public void setEthnic(java.lang.String ethnic) {
		_candidate.setEthnic(ethnic);
	}

	/**
	* Returns the religion of this candidate.
	*
	* @return the religion of this candidate
	*/
	@Override
	public java.lang.String getReligion() {
		return _candidate.getReligion();
	}

	/**
	* Sets the religion of this candidate.
	*
	* @param religion the religion of this candidate
	*/
	@Override
	public void setReligion(java.lang.String religion) {
		_candidate.setReligion(religion);
	}

	/**
	* Returns the application date of this candidate.
	*
	* @return the application date of this candidate
	*/
	@Override
	public java.util.Date getApplicationDate() {
		return _candidate.getApplicationDate();
	}

	/**
	* Sets the application date of this candidate.
	*
	* @param applicationDate the application date of this candidate
	*/
	@Override
	public void setApplicationDate(java.util.Date applicationDate) {
		_candidate.setApplicationDate(applicationDate);
	}

	/**
	* Returns the status of this candidate.
	*
	* @return the status of this candidate
	*/
	@Override
	public java.lang.String getStatus() {
		return _candidate.getStatus();
	}

	/**
	* Sets the status of this candidate.
	*
	* @param status the status of this candidate
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_candidate.setStatus(status);
	}

	/**
	* Returns the location ID of this candidate.
	*
	* @return the location ID of this candidate
	*/
	@Override
	public long getLocationId() {
		return _candidate.getLocationId();
	}

	/**
	* Sets the location ID of this candidate.
	*
	* @param locationId the location ID of this candidate
	*/
	@Override
	public void setLocationId(long locationId) {
		_candidate.setLocationId(locationId);
	}

	/**
	* Returns the deleted of this candidate.
	*
	* @return the deleted of this candidate
	*/
	@Override
	public boolean getDeleted() {
		return _candidate.getDeleted();
	}

	/**
	* Returns <code>true</code> if this candidate is deleted.
	*
	* @return <code>true</code> if this candidate is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _candidate.isDeleted();
	}

	/**
	* Sets whether this candidate is deleted.
	*
	* @param deleted the deleted of this candidate
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_candidate.setDeleted(deleted);
	}

	/**
	* Returns the group ID of this candidate.
	*
	* @return the group ID of this candidate
	*/
	@Override
	public long getGroupId() {
		return _candidate.getGroupId();
	}

	/**
	* Sets the group ID of this candidate.
	*
	* @param groupId the group ID of this candidate
	*/
	@Override
	public void setGroupId(long groupId) {
		_candidate.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this candidate.
	*
	* @return the company ID of this candidate
	*/
	@Override
	public long getCompanyId() {
		return _candidate.getCompanyId();
	}

	/**
	* Sets the company ID of this candidate.
	*
	* @param companyId the company ID of this candidate
	*/
	@Override
	public void setCompanyId(long companyId) {
		_candidate.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this candidate.
	*
	* @return the user ID of this candidate
	*/
	@Override
	public long getUserId() {
		return _candidate.getUserId();
	}

	/**
	* Sets the user ID of this candidate.
	*
	* @param userId the user ID of this candidate
	*/
	@Override
	public void setUserId(long userId) {
		_candidate.setUserId(userId);
	}

	/**
	* Returns the user uuid of this candidate.
	*
	* @return the user uuid of this candidate
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _candidate.getUserUuid();
	}

	/**
	* Sets the user uuid of this candidate.
	*
	* @param userUuid the user uuid of this candidate
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_candidate.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this candidate.
	*
	* @return the user name of this candidate
	*/
	@Override
	public java.lang.String getUserName() {
		return _candidate.getUserName();
	}

	/**
	* Sets the user name of this candidate.
	*
	* @param userName the user name of this candidate
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_candidate.setUserName(userName);
	}

	/**
	* Returns the create date of this candidate.
	*
	* @return the create date of this candidate
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _candidate.getCreateDate();
	}

	/**
	* Sets the create date of this candidate.
	*
	* @param createDate the create date of this candidate
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_candidate.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this candidate.
	*
	* @return the modified date of this candidate
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _candidate.getModifiedDate();
	}

	/**
	* Sets the modified date of this candidate.
	*
	* @param modifiedDate the modified date of this candidate
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_candidate.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this candidate.
	*
	* @return the description of this candidate
	*/
	@Override
	public java.lang.String getDescription() {
		return _candidate.getDescription();
	}

	/**
	* Sets the description of this candidate.
	*
	* @param description the description of this candidate
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_candidate.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _candidate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_candidate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _candidate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_candidate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _candidate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _candidate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_candidate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _candidate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_candidate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_candidate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_candidate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CandidateWrapper((Candidate)_candidate.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.hrm.rc.model.Candidate candidate) {
		return _candidate.compareTo(candidate);
	}

	@Override
	public int hashCode() {
		return _candidate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.Candidate> toCacheModel() {
		return _candidate.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate toEscapedModel() {
		return new CandidateWrapper(_candidate.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Candidate toUnescapedModel() {
		return new CandidateWrapper(_candidate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _candidate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _candidate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_candidate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CandidateWrapper)) {
			return false;
		}

		CandidateWrapper candidateWrapper = (CandidateWrapper)obj;

		if (Validator.equals(_candidate, candidateWrapper._candidate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Candidate getWrappedCandidate() {
		return _candidate;
	}

	@Override
	public Candidate getWrappedModel() {
		return _candidate;
	}

	@Override
	public void resetOriginalValues() {
		_candidate.resetOriginalValues();
	}

	private Candidate _candidate;
}