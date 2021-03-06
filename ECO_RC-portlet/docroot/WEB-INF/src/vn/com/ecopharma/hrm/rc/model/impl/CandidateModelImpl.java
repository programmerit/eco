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

package vn.com.ecopharma.hrm.rc.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.CandidateModel;
import vn.com.ecopharma.hrm.rc.model.CandidateSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Candidate service. Represents a row in the &quot;eco_rcp_Candidate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.ecopharma.hrm.rc.model.CandidateModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateImpl}.
 * </p>
 *
 * @author tvt
 * @see CandidateImpl
 * @see vn.com.ecopharma.hrm.rc.model.Candidate
 * @see vn.com.ecopharma.hrm.rc.model.CandidateModel
 * @generated
 */
@JSON(strict = true)
public class CandidateModelImpl extends BaseModelImpl<Candidate>
	implements CandidateModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate model instance should use the {@link vn.com.ecopharma.hrm.rc.model.Candidate} interface instead.
	 */
	public static final String TABLE_NAME = "eco_rcp_Candidate";
	public static final Object[][] TABLE_COLUMNS = {
			{ "candidateId", Types.BIGINT },
			{ "candidateCode", Types.VARCHAR },
			{ "fullName", Types.VARCHAR },
			{ "emailAddress", Types.VARCHAR },
			{ "contactNumber", Types.VARCHAR },
			{ "dateOfBirth", Types.TIMESTAMP },
			{ "placeOfBirth", Types.VARCHAR },
			{ "gender", Types.VARCHAR },
			{ "identityCardNo", Types.VARCHAR },
			{ "issuedDate", Types.TIMESTAMP },
			{ "issuedPlace", Types.VARCHAR },
			{ "maritalStatus", Types.VARCHAR },
			{ "numberOfChild", Types.INTEGER },
			{ "nationalityId", Types.BIGINT },
			{ "ethnic", Types.VARCHAR },
			{ "religion", Types.VARCHAR },
			{ "applicationDate", Types.TIMESTAMP },
			{ "status", Types.VARCHAR },
			{ "deleted", Types.BOOLEAN },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "description", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eco_rcp_Candidate (candidateId LONG not null primary key,candidateCode VARCHAR(75) null,fullName VARCHAR(75) null,emailAddress VARCHAR(75) null,contactNumber VARCHAR(75) null,dateOfBirth DATE null,placeOfBirth VARCHAR(75) null,gender VARCHAR(75) null,identityCardNo VARCHAR(75) null,issuedDate DATE null,issuedPlace VARCHAR(75) null,maritalStatus VARCHAR(75) null,numberOfChild INTEGER,nationalityId LONG,ethnic VARCHAR(75) null,religion VARCHAR(75) null,applicationDate DATE null,status VARCHAR(75) null,deleted BOOLEAN,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,description VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eco_rcp_Candidate";
	public static final String ORDER_BY_JPQL = " ORDER BY candidate.candidateId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eco_rcp_Candidate.candidateId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.ecopharma.hrm.rc.model.Candidate"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.ecopharma.hrm.rc.model.Candidate"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.ecopharma.hrm.rc.model.Candidate"),
			true);
	public static long CONTACTNUMBER_COLUMN_BITMASK = 1L;
	public static long EMAILADDRESS_COLUMN_BITMASK = 2L;
	public static long IDENTITYCARDNO_COLUMN_BITMASK = 4L;
	public static long CANDIDATEID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Candidate toModel(CandidateSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Candidate model = new CandidateImpl();

		model.setCandidateId(soapModel.getCandidateId());
		model.setCandidateCode(soapModel.getCandidateCode());
		model.setFullName(soapModel.getFullName());
		model.setEmailAddress(soapModel.getEmailAddress());
		model.setContactNumber(soapModel.getContactNumber());
		model.setDateOfBirth(soapModel.getDateOfBirth());
		model.setPlaceOfBirth(soapModel.getPlaceOfBirth());
		model.setGender(soapModel.getGender());
		model.setIdentityCardNo(soapModel.getIdentityCardNo());
		model.setIssuedDate(soapModel.getIssuedDate());
		model.setIssuedPlace(soapModel.getIssuedPlace());
		model.setMaritalStatus(soapModel.getMaritalStatus());
		model.setNumberOfChild(soapModel.getNumberOfChild());
		model.setNationalityId(soapModel.getNationalityId());
		model.setEthnic(soapModel.getEthnic());
		model.setReligion(soapModel.getReligion());
		model.setApplicationDate(soapModel.getApplicationDate());
		model.setStatus(soapModel.getStatus());
		model.setDeleted(soapModel.getDeleted());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDescription(soapModel.getDescription());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Candidate> toModels(CandidateSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Candidate> models = new ArrayList<Candidate>(soapModels.length);

		for (CandidateSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.ecopharma.hrm.rc.model.Candidate"));

	public CandidateModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _candidateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCandidateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _candidateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@JSON
	@Override
	public long getCandidateId() {
		return _candidateId;
	}

	@Override
	public void setCandidateId(long candidateId) {
		_candidateId = candidateId;
	}

	@JSON
	@Override
	public String getCandidateCode() {
		if (_candidateCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _candidateCode;
		}
	}

	@Override
	public void setCandidateCode(String candidateCode) {
		_candidateCode = candidateCode;
	}

	@JSON
	@Override
	public String getFullName() {
		if (_fullName == null) {
			return StringPool.BLANK;
		}
		else {
			return _fullName;
		}
	}

	@Override
	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	@JSON
	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_columnBitmask |= EMAILADDRESS_COLUMN_BITMASK;

		if (_originalEmailAddress == null) {
			_originalEmailAddress = _emailAddress;
		}

		_emailAddress = emailAddress;
	}

	public String getOriginalEmailAddress() {
		return GetterUtil.getString(_originalEmailAddress);
	}

	@JSON
	@Override
	public String getContactNumber() {
		if (_contactNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _contactNumber;
		}
	}

	@Override
	public void setContactNumber(String contactNumber) {
		_columnBitmask |= CONTACTNUMBER_COLUMN_BITMASK;

		if (_originalContactNumber == null) {
			_originalContactNumber = _contactNumber;
		}

		_contactNumber = contactNumber;
	}

	public String getOriginalContactNumber() {
		return GetterUtil.getString(_originalContactNumber);
	}

	@JSON
	@Override
	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	@JSON
	@Override
	public String getPlaceOfBirth() {
		if (_placeOfBirth == null) {
			return StringPool.BLANK;
		}
		else {
			return _placeOfBirth;
		}
	}

	@Override
	public void setPlaceOfBirth(String placeOfBirth) {
		_placeOfBirth = placeOfBirth;
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return StringPool.BLANK;
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;
	}

	@JSON
	@Override
	public String getIdentityCardNo() {
		if (_identityCardNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _identityCardNo;
		}
	}

	@Override
	public void setIdentityCardNo(String identityCardNo) {
		_columnBitmask |= IDENTITYCARDNO_COLUMN_BITMASK;

		if (_originalIdentityCardNo == null) {
			_originalIdentityCardNo = _identityCardNo;
		}

		_identityCardNo = identityCardNo;
	}

	public String getOriginalIdentityCardNo() {
		return GetterUtil.getString(_originalIdentityCardNo);
	}

	@JSON
	@Override
	public Date getIssuedDate() {
		return _issuedDate;
	}

	@Override
	public void setIssuedDate(Date issuedDate) {
		_issuedDate = issuedDate;
	}

	@JSON
	@Override
	public String getIssuedPlace() {
		if (_issuedPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _issuedPlace;
		}
	}

	@Override
	public void setIssuedPlace(String issuedPlace) {
		_issuedPlace = issuedPlace;
	}

	@JSON
	@Override
	public String getMaritalStatus() {
		if (_maritalStatus == null) {
			return StringPool.BLANK;
		}
		else {
			return _maritalStatus;
		}
	}

	@Override
	public void setMaritalStatus(String maritalStatus) {
		_maritalStatus = maritalStatus;
	}

	@JSON
	@Override
	public int getNumberOfChild() {
		return _numberOfChild;
	}

	@Override
	public void setNumberOfChild(int numberOfChild) {
		_numberOfChild = numberOfChild;
	}

	@JSON
	@Override
	public long getNationalityId() {
		return _nationalityId;
	}

	@Override
	public void setNationalityId(long nationalityId) {
		_nationalityId = nationalityId;
	}

	@JSON
	@Override
	public String getEthnic() {
		if (_ethnic == null) {
			return StringPool.BLANK;
		}
		else {
			return _ethnic;
		}
	}

	@Override
	public void setEthnic(String ethnic) {
		_ethnic = ethnic;
	}

	@JSON
	@Override
	public String getReligion() {
		if (_religion == null) {
			return StringPool.BLANK;
		}
		else {
			return _religion;
		}
	}

	@Override
	public void setReligion(String religion) {
		_religion = religion;
	}

	@JSON
	@Override
	public Date getApplicationDate() {
		return _applicationDate;
	}

	@Override
	public void setApplicationDate(Date applicationDate) {
		_applicationDate = applicationDate;
	}

	@JSON
	@Override
	public String getStatus() {
		if (_status == null) {
			return StringPool.BLANK;
		}
		else {
			return _status;
		}
	}

	@Override
	public void setStatus(String status) {
		_status = status;
	}

	@JSON
	@Override
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Candidate.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Candidate toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Candidate)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CandidateImpl candidateImpl = new CandidateImpl();

		candidateImpl.setCandidateId(getCandidateId());
		candidateImpl.setCandidateCode(getCandidateCode());
		candidateImpl.setFullName(getFullName());
		candidateImpl.setEmailAddress(getEmailAddress());
		candidateImpl.setContactNumber(getContactNumber());
		candidateImpl.setDateOfBirth(getDateOfBirth());
		candidateImpl.setPlaceOfBirth(getPlaceOfBirth());
		candidateImpl.setGender(getGender());
		candidateImpl.setIdentityCardNo(getIdentityCardNo());
		candidateImpl.setIssuedDate(getIssuedDate());
		candidateImpl.setIssuedPlace(getIssuedPlace());
		candidateImpl.setMaritalStatus(getMaritalStatus());
		candidateImpl.setNumberOfChild(getNumberOfChild());
		candidateImpl.setNationalityId(getNationalityId());
		candidateImpl.setEthnic(getEthnic());
		candidateImpl.setReligion(getReligion());
		candidateImpl.setApplicationDate(getApplicationDate());
		candidateImpl.setStatus(getStatus());
		candidateImpl.setDeleted(getDeleted());
		candidateImpl.setGroupId(getGroupId());
		candidateImpl.setCompanyId(getCompanyId());
		candidateImpl.setUserId(getUserId());
		candidateImpl.setUserName(getUserName());
		candidateImpl.setCreateDate(getCreateDate());
		candidateImpl.setModifiedDate(getModifiedDate());
		candidateImpl.setDescription(getDescription());

		candidateImpl.resetOriginalValues();

		return candidateImpl;
	}

	@Override
	public int compareTo(Candidate candidate) {
		long primaryKey = candidate.getPrimaryKey();

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

		if (!(obj instanceof Candidate)) {
			return false;
		}

		Candidate candidate = (Candidate)obj;

		long primaryKey = candidate.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CandidateModelImpl candidateModelImpl = this;

		candidateModelImpl._originalEmailAddress = candidateModelImpl._emailAddress;

		candidateModelImpl._originalContactNumber = candidateModelImpl._contactNumber;

		candidateModelImpl._originalIdentityCardNo = candidateModelImpl._identityCardNo;

		candidateModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Candidate> toCacheModel() {
		CandidateCacheModel candidateCacheModel = new CandidateCacheModel();

		candidateCacheModel.candidateId = getCandidateId();

		candidateCacheModel.candidateCode = getCandidateCode();

		String candidateCode = candidateCacheModel.candidateCode;

		if ((candidateCode != null) && (candidateCode.length() == 0)) {
			candidateCacheModel.candidateCode = null;
		}

		candidateCacheModel.fullName = getFullName();

		String fullName = candidateCacheModel.fullName;

		if ((fullName != null) && (fullName.length() == 0)) {
			candidateCacheModel.fullName = null;
		}

		candidateCacheModel.emailAddress = getEmailAddress();

		String emailAddress = candidateCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			candidateCacheModel.emailAddress = null;
		}

		candidateCacheModel.contactNumber = getContactNumber();

		String contactNumber = candidateCacheModel.contactNumber;

		if ((contactNumber != null) && (contactNumber.length() == 0)) {
			candidateCacheModel.contactNumber = null;
		}

		Date dateOfBirth = getDateOfBirth();

		if (dateOfBirth != null) {
			candidateCacheModel.dateOfBirth = dateOfBirth.getTime();
		}
		else {
			candidateCacheModel.dateOfBirth = Long.MIN_VALUE;
		}

		candidateCacheModel.placeOfBirth = getPlaceOfBirth();

		String placeOfBirth = candidateCacheModel.placeOfBirth;

		if ((placeOfBirth != null) && (placeOfBirth.length() == 0)) {
			candidateCacheModel.placeOfBirth = null;
		}

		candidateCacheModel.gender = getGender();

		String gender = candidateCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			candidateCacheModel.gender = null;
		}

		candidateCacheModel.identityCardNo = getIdentityCardNo();

		String identityCardNo = candidateCacheModel.identityCardNo;

		if ((identityCardNo != null) && (identityCardNo.length() == 0)) {
			candidateCacheModel.identityCardNo = null;
		}

		Date issuedDate = getIssuedDate();

		if (issuedDate != null) {
			candidateCacheModel.issuedDate = issuedDate.getTime();
		}
		else {
			candidateCacheModel.issuedDate = Long.MIN_VALUE;
		}

		candidateCacheModel.issuedPlace = getIssuedPlace();

		String issuedPlace = candidateCacheModel.issuedPlace;

		if ((issuedPlace != null) && (issuedPlace.length() == 0)) {
			candidateCacheModel.issuedPlace = null;
		}

		candidateCacheModel.maritalStatus = getMaritalStatus();

		String maritalStatus = candidateCacheModel.maritalStatus;

		if ((maritalStatus != null) && (maritalStatus.length() == 0)) {
			candidateCacheModel.maritalStatus = null;
		}

		candidateCacheModel.numberOfChild = getNumberOfChild();

		candidateCacheModel.nationalityId = getNationalityId();

		candidateCacheModel.ethnic = getEthnic();

		String ethnic = candidateCacheModel.ethnic;

		if ((ethnic != null) && (ethnic.length() == 0)) {
			candidateCacheModel.ethnic = null;
		}

		candidateCacheModel.religion = getReligion();

		String religion = candidateCacheModel.religion;

		if ((religion != null) && (religion.length() == 0)) {
			candidateCacheModel.religion = null;
		}

		Date applicationDate = getApplicationDate();

		if (applicationDate != null) {
			candidateCacheModel.applicationDate = applicationDate.getTime();
		}
		else {
			candidateCacheModel.applicationDate = Long.MIN_VALUE;
		}

		candidateCacheModel.status = getStatus();

		String status = candidateCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			candidateCacheModel.status = null;
		}

		candidateCacheModel.deleted = getDeleted();

		candidateCacheModel.groupId = getGroupId();

		candidateCacheModel.companyId = getCompanyId();

		candidateCacheModel.userId = getUserId();

		candidateCacheModel.userName = getUserName();

		String userName = candidateCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			candidateCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			candidateCacheModel.createDate = createDate.getTime();
		}
		else {
			candidateCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			candidateCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			candidateCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		candidateCacheModel.description = getDescription();

		String description = candidateCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			candidateCacheModel.description = null;
		}

		return candidateCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{candidateId=");
		sb.append(getCandidateId());
		sb.append(", candidateCode=");
		sb.append(getCandidateCode());
		sb.append(", fullName=");
		sb.append(getFullName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", contactNumber=");
		sb.append(getContactNumber());
		sb.append(", dateOfBirth=");
		sb.append(getDateOfBirth());
		sb.append(", placeOfBirth=");
		sb.append(getPlaceOfBirth());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", identityCardNo=");
		sb.append(getIdentityCardNo());
		sb.append(", issuedDate=");
		sb.append(getIssuedDate());
		sb.append(", issuedPlace=");
		sb.append(getIssuedPlace());
		sb.append(", maritalStatus=");
		sb.append(getMaritalStatus());
		sb.append(", numberOfChild=");
		sb.append(getNumberOfChild());
		sb.append(", nationalityId=");
		sb.append(getNationalityId());
		sb.append(", ethnic=");
		sb.append(getEthnic());
		sb.append(", religion=");
		sb.append(getReligion());
		sb.append(", applicationDate=");
		sb.append(getApplicationDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", deleted=");
		sb.append(getDeleted());
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
		sb.append(", description=");
		sb.append(getDescription());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.Candidate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>candidateId</column-name><column-value><![CDATA[");
		sb.append(getCandidateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>candidateCode</column-name><column-value><![CDATA[");
		sb.append(getCandidateCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullName</column-name><column-value><![CDATA[");
		sb.append(getFullName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactNumber</column-name><column-value><![CDATA[");
		sb.append(getContactNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateOfBirth</column-name><column-value><![CDATA[");
		sb.append(getDateOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>placeOfBirth</column-name><column-value><![CDATA[");
		sb.append(getPlaceOfBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identityCardNo</column-name><column-value><![CDATA[");
		sb.append(getIdentityCardNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedDate</column-name><column-value><![CDATA[");
		sb.append(getIssuedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issuedPlace</column-name><column-value><![CDATA[");
		sb.append(getIssuedPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>maritalStatus</column-name><column-value><![CDATA[");
		sb.append(getMaritalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfChild</column-name><column-value><![CDATA[");
		sb.append(getNumberOfChild());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nationalityId</column-name><column-value><![CDATA[");
		sb.append(getNationalityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ethnic</column-name><column-value><![CDATA[");
		sb.append(getEthnic());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>religion</column-name><column-value><![CDATA[");
		sb.append(getReligion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>applicationDate</column-name><column-value><![CDATA[");
		sb.append(getApplicationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
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
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Candidate.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Candidate.class
		};
	private long _candidateId;
	private String _candidateCode;
	private String _fullName;
	private String _emailAddress;
	private String _originalEmailAddress;
	private String _contactNumber;
	private String _originalContactNumber;
	private Date _dateOfBirth;
	private String _placeOfBirth;
	private String _gender;
	private String _identityCardNo;
	private String _originalIdentityCardNo;
	private Date _issuedDate;
	private String _issuedPlace;
	private String _maritalStatus;
	private int _numberOfChild;
	private long _nationalityId;
	private String _ethnic;
	private String _religion;
	private Date _applicationDate;
	private String _status;
	private boolean _deleted;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private long _columnBitmask;
	private Candidate _escapedModel;
}