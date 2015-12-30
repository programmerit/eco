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

import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.model.VacancyModel;
import vn.com.ecopharma.hrm.rc.model.VacancySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Vacancy service. Represents a row in the &quot;eco_rcp_Vacancy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.ecopharma.hrm.rc.model.VacancyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VacancyImpl}.
 * </p>
 *
 * @author tvt
 * @see VacancyImpl
 * @see vn.com.ecopharma.hrm.rc.model.Vacancy
 * @see vn.com.ecopharma.hrm.rc.model.VacancyModel
 * @generated
 */
@JSON(strict = true)
public class VacancyModelImpl extends BaseModelImpl<Vacancy>
	implements VacancyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vacancy model instance should use the {@link vn.com.ecopharma.hrm.rc.model.Vacancy} interface instead.
	 */
	public static final String TABLE_NAME = "eco_rcp_Vacancy";
	public static final Object[][] TABLE_COLUMNS = {
			{ "vacancyId", Types.BIGINT },
			{ "approvedNumberOfPosition", Types.INTEGER },
			{ "currentNumberOfEmployee", Types.INTEGER },
			{ "titlesId", Types.BIGINT },
			{ "numberOfNewRecruitment", Types.INTEGER },
			{ "numberOfReplacedRecruitment", Types.INTEGER },
			{ "expectedSalary", Types.DOUBLE },
			{ "expectedJoinedDate", Types.TIMESTAMP },
			{ "workingPlace", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "requiredGender", Types.VARCHAR },
			{ "certificateType", Types.VARCHAR },
			{ "specialized", Types.VARCHAR },
			{ "experiences", Types.DOUBLE },
			{ "foreignLanguages", Types.VARCHAR },
			{ "skills", Types.VARCHAR },
			{ "officeSkills", Types.VARCHAR },
			{ "awayToBusinessType", Types.VARCHAR },
			{ "workingTimeType", Types.VARCHAR },
			{ "jobType", Types.VARCHAR },
			{ "code_", Types.VARCHAR },
			{ "status", Types.VARCHAR },
			{ "postedDate", Types.TIMESTAMP },
			{ "expiredDate", Types.TIMESTAMP },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table eco_rcp_Vacancy (vacancyId LONG not null primary key,approvedNumberOfPosition INTEGER,currentNumberOfEmployee INTEGER,titlesId LONG,numberOfNewRecruitment INTEGER,numberOfReplacedRecruitment INTEGER,expectedSalary DOUBLE,expectedJoinedDate DATE null,workingPlace VARCHAR(75) null,description VARCHAR(75) null,requiredGender VARCHAR(75) null,certificateType VARCHAR(75) null,specialized VARCHAR(75) null,experiences DOUBLE,foreignLanguages VARCHAR(75) null,skills VARCHAR(75) null,officeSkills VARCHAR(75) null,awayToBusinessType VARCHAR(75) null,workingTimeType VARCHAR(75) null,jobType VARCHAR(75) null,code_ VARCHAR(75) null,status VARCHAR(75) null,postedDate DATE null,expiredDate DATE null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table eco_rcp_Vacancy";
	public static final String ORDER_BY_JPQL = " ORDER BY vacancy.vacancyId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eco_rcp_Vacancy.vacancyId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.ecopharma.hrm.rc.model.Vacancy"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.ecopharma.hrm.rc.model.Vacancy"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.ecopharma.hrm.rc.model.Vacancy"),
			true);
	public static long DELETED_COLUMN_BITMASK = 1L;
	public static long VACANCYID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Vacancy toModel(VacancySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Vacancy model = new VacancyImpl();

		model.setVacancyId(soapModel.getVacancyId());
		model.setApprovedNumberOfPosition(soapModel.getApprovedNumberOfPosition());
		model.setCurrentNumberOfEmployee(soapModel.getCurrentNumberOfEmployee());
		model.setTitlesId(soapModel.getTitlesId());
		model.setNumberOfNewRecruitment(soapModel.getNumberOfNewRecruitment());
		model.setNumberOfReplacedRecruitment(soapModel.getNumberOfReplacedRecruitment());
		model.setExpectedSalary(soapModel.getExpectedSalary());
		model.setExpectedJoinedDate(soapModel.getExpectedJoinedDate());
		model.setWorkingPlace(soapModel.getWorkingPlace());
		model.setDescription(soapModel.getDescription());
		model.setRequiredGender(soapModel.getRequiredGender());
		model.setCertificateType(soapModel.getCertificateType());
		model.setSpecialized(soapModel.getSpecialized());
		model.setExperiences(soapModel.getExperiences());
		model.setForeignLanguages(soapModel.getForeignLanguages());
		model.setSkills(soapModel.getSkills());
		model.setOfficeSkills(soapModel.getOfficeSkills());
		model.setAwayToBusinessType(soapModel.getAwayToBusinessType());
		model.setWorkingTimeType(soapModel.getWorkingTimeType());
		model.setJobType(soapModel.getJobType());
		model.setCode(soapModel.getCode());
		model.setStatus(soapModel.getStatus());
		model.setPostedDate(soapModel.getPostedDate());
		model.setExpiredDate(soapModel.getExpiredDate());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDeleted(soapModel.getDeleted());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Vacancy> toModels(VacancySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Vacancy> models = new ArrayList<Vacancy>(soapModels.length);

		for (VacancySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.ecopharma.hrm.rc.model.Vacancy"));

	public VacancyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _vacancyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVacancyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacancyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Vacancy.class;
	}

	@Override
	public String getModelClassName() {
		return Vacancy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacancyId", getVacancyId());
		attributes.put("approvedNumberOfPosition", getApprovedNumberOfPosition());
		attributes.put("currentNumberOfEmployee", getCurrentNumberOfEmployee());
		attributes.put("titlesId", getTitlesId());
		attributes.put("numberOfNewRecruitment", getNumberOfNewRecruitment());
		attributes.put("numberOfReplacedRecruitment",
			getNumberOfReplacedRecruitment());
		attributes.put("expectedSalary", getExpectedSalary());
		attributes.put("expectedJoinedDate", getExpectedJoinedDate());
		attributes.put("workingPlace", getWorkingPlace());
		attributes.put("description", getDescription());
		attributes.put("requiredGender", getRequiredGender());
		attributes.put("certificateType", getCertificateType());
		attributes.put("specialized", getSpecialized());
		attributes.put("experiences", getExperiences());
		attributes.put("foreignLanguages", getForeignLanguages());
		attributes.put("skills", getSkills());
		attributes.put("officeSkills", getOfficeSkills());
		attributes.put("awayToBusinessType", getAwayToBusinessType());
		attributes.put("workingTimeType", getWorkingTimeType());
		attributes.put("jobType", getJobType());
		attributes.put("code", getCode());
		attributes.put("status", getStatus());
		attributes.put("postedDate", getPostedDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		Integer approvedNumberOfPosition = (Integer)attributes.get(
				"approvedNumberOfPosition");

		if (approvedNumberOfPosition != null) {
			setApprovedNumberOfPosition(approvedNumberOfPosition);
		}

		Integer currentNumberOfEmployee = (Integer)attributes.get(
				"currentNumberOfEmployee");

		if (currentNumberOfEmployee != null) {
			setCurrentNumberOfEmployee(currentNumberOfEmployee);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		Integer numberOfNewRecruitment = (Integer)attributes.get(
				"numberOfNewRecruitment");

		if (numberOfNewRecruitment != null) {
			setNumberOfNewRecruitment(numberOfNewRecruitment);
		}

		Integer numberOfReplacedRecruitment = (Integer)attributes.get(
				"numberOfReplacedRecruitment");

		if (numberOfReplacedRecruitment != null) {
			setNumberOfReplacedRecruitment(numberOfReplacedRecruitment);
		}

		Double expectedSalary = (Double)attributes.get("expectedSalary");

		if (expectedSalary != null) {
			setExpectedSalary(expectedSalary);
		}

		Date expectedJoinedDate = (Date)attributes.get("expectedJoinedDate");

		if (expectedJoinedDate != null) {
			setExpectedJoinedDate(expectedJoinedDate);
		}

		String workingPlace = (String)attributes.get("workingPlace");

		if (workingPlace != null) {
			setWorkingPlace(workingPlace);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String requiredGender = (String)attributes.get("requiredGender");

		if (requiredGender != null) {
			setRequiredGender(requiredGender);
		}

		String certificateType = (String)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		String specialized = (String)attributes.get("specialized");

		if (specialized != null) {
			setSpecialized(specialized);
		}

		Double experiences = (Double)attributes.get("experiences");

		if (experiences != null) {
			setExperiences(experiences);
		}

		String foreignLanguages = (String)attributes.get("foreignLanguages");

		if (foreignLanguages != null) {
			setForeignLanguages(foreignLanguages);
		}

		String skills = (String)attributes.get("skills");

		if (skills != null) {
			setSkills(skills);
		}

		String officeSkills = (String)attributes.get("officeSkills");

		if (officeSkills != null) {
			setOfficeSkills(officeSkills);
		}

		String awayToBusinessType = (String)attributes.get("awayToBusinessType");

		if (awayToBusinessType != null) {
			setAwayToBusinessType(awayToBusinessType);
		}

		String workingTimeType = (String)attributes.get("workingTimeType");

		if (workingTimeType != null) {
			setWorkingTimeType(workingTimeType);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date postedDate = (Date)attributes.get("postedDate");

		if (postedDate != null) {
			setPostedDate(postedDate);
		}

		Date expiredDate = (Date)attributes.get("expiredDate");

		if (expiredDate != null) {
			setExpiredDate(expiredDate);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}
	}

	@JSON
	@Override
	public long getVacancyId() {
		return _vacancyId;
	}

	@Override
	public void setVacancyId(long vacancyId) {
		_vacancyId = vacancyId;
	}

	@JSON
	@Override
	public int getApprovedNumberOfPosition() {
		return _approvedNumberOfPosition;
	}

	@Override
	public void setApprovedNumberOfPosition(int approvedNumberOfPosition) {
		_approvedNumberOfPosition = approvedNumberOfPosition;
	}

	@JSON
	@Override
	public int getCurrentNumberOfEmployee() {
		return _currentNumberOfEmployee;
	}

	@Override
	public void setCurrentNumberOfEmployee(int currentNumberOfEmployee) {
		_currentNumberOfEmployee = currentNumberOfEmployee;
	}

	@JSON
	@Override
	public long getTitlesId() {
		return _titlesId;
	}

	@Override
	public void setTitlesId(long titlesId) {
		_titlesId = titlesId;
	}

	@JSON
	@Override
	public int getNumberOfNewRecruitment() {
		return _numberOfNewRecruitment;
	}

	@Override
	public void setNumberOfNewRecruitment(int numberOfNewRecruitment) {
		_numberOfNewRecruitment = numberOfNewRecruitment;
	}

	@JSON
	@Override
	public int getNumberOfReplacedRecruitment() {
		return _numberOfReplacedRecruitment;
	}

	@Override
	public void setNumberOfReplacedRecruitment(int numberOfReplacedRecruitment) {
		_numberOfReplacedRecruitment = numberOfReplacedRecruitment;
	}

	@JSON
	@Override
	public double getExpectedSalary() {
		return _expectedSalary;
	}

	@Override
	public void setExpectedSalary(double expectedSalary) {
		_expectedSalary = expectedSalary;
	}

	@JSON
	@Override
	public Date getExpectedJoinedDate() {
		return _expectedJoinedDate;
	}

	@Override
	public void setExpectedJoinedDate(Date expectedJoinedDate) {
		_expectedJoinedDate = expectedJoinedDate;
	}

	@JSON
	@Override
	public String getWorkingPlace() {
		if (_workingPlace == null) {
			return StringPool.BLANK;
		}
		else {
			return _workingPlace;
		}
	}

	@Override
	public void setWorkingPlace(String workingPlace) {
		_workingPlace = workingPlace;
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

	@JSON
	@Override
	public String getRequiredGender() {
		if (_requiredGender == null) {
			return StringPool.BLANK;
		}
		else {
			return _requiredGender;
		}
	}

	@Override
	public void setRequiredGender(String requiredGender) {
		_requiredGender = requiredGender;
	}

	@JSON
	@Override
	public String getCertificateType() {
		if (_certificateType == null) {
			return StringPool.BLANK;
		}
		else {
			return _certificateType;
		}
	}

	@Override
	public void setCertificateType(String certificateType) {
		_certificateType = certificateType;
	}

	@JSON
	@Override
	public String getSpecialized() {
		if (_specialized == null) {
			return StringPool.BLANK;
		}
		else {
			return _specialized;
		}
	}

	@Override
	public void setSpecialized(String specialized) {
		_specialized = specialized;
	}

	@JSON
	@Override
	public double getExperiences() {
		return _experiences;
	}

	@Override
	public void setExperiences(double experiences) {
		_experiences = experiences;
	}

	@JSON
	@Override
	public String getForeignLanguages() {
		if (_foreignLanguages == null) {
			return StringPool.BLANK;
		}
		else {
			return _foreignLanguages;
		}
	}

	@Override
	public void setForeignLanguages(String foreignLanguages) {
		_foreignLanguages = foreignLanguages;
	}

	@JSON
	@Override
	public String getSkills() {
		if (_skills == null) {
			return StringPool.BLANK;
		}
		else {
			return _skills;
		}
	}

	@Override
	public void setSkills(String skills) {
		_skills = skills;
	}

	@JSON
	@Override
	public String getOfficeSkills() {
		if (_officeSkills == null) {
			return StringPool.BLANK;
		}
		else {
			return _officeSkills;
		}
	}

	@Override
	public void setOfficeSkills(String officeSkills) {
		_officeSkills = officeSkills;
	}

	@JSON
	@Override
	public String getAwayToBusinessType() {
		if (_awayToBusinessType == null) {
			return StringPool.BLANK;
		}
		else {
			return _awayToBusinessType;
		}
	}

	@Override
	public void setAwayToBusinessType(String awayToBusinessType) {
		_awayToBusinessType = awayToBusinessType;
	}

	@JSON
	@Override
	public String getWorkingTimeType() {
		if (_workingTimeType == null) {
			return StringPool.BLANK;
		}
		else {
			return _workingTimeType;
		}
	}

	@Override
	public void setWorkingTimeType(String workingTimeType) {
		_workingTimeType = workingTimeType;
	}

	@JSON
	@Override
	public String getJobType() {
		if (_jobType == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobType;
		}
	}

	@Override
	public void setJobType(String jobType) {
		_jobType = jobType;
	}

	@JSON
	@Override
	public String getCode() {
		if (_code == null) {
			return StringPool.BLANK;
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_code = code;
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
	public Date getPostedDate() {
		return _postedDate;
	}

	@Override
	public void setPostedDate(Date postedDate) {
		_postedDate = postedDate;
	}

	@JSON
	@Override
	public Date getExpiredDate() {
		return _expiredDate;
	}

	@Override
	public void setExpiredDate(Date expiredDate) {
		_expiredDate = expiredDate;
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
	public boolean getDeleted() {
		return _deleted;
	}

	@Override
	public boolean isDeleted() {
		return _deleted;
	}

	@Override
	public void setDeleted(boolean deleted) {
		_columnBitmask |= DELETED_COLUMN_BITMASK;

		if (!_setOriginalDeleted) {
			_setOriginalDeleted = true;

			_originalDeleted = _deleted;
		}

		_deleted = deleted;
	}

	public boolean getOriginalDeleted() {
		return _originalDeleted;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Vacancy.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Vacancy toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Vacancy)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VacancyImpl vacancyImpl = new VacancyImpl();

		vacancyImpl.setVacancyId(getVacancyId());
		vacancyImpl.setApprovedNumberOfPosition(getApprovedNumberOfPosition());
		vacancyImpl.setCurrentNumberOfEmployee(getCurrentNumberOfEmployee());
		vacancyImpl.setTitlesId(getTitlesId());
		vacancyImpl.setNumberOfNewRecruitment(getNumberOfNewRecruitment());
		vacancyImpl.setNumberOfReplacedRecruitment(getNumberOfReplacedRecruitment());
		vacancyImpl.setExpectedSalary(getExpectedSalary());
		vacancyImpl.setExpectedJoinedDate(getExpectedJoinedDate());
		vacancyImpl.setWorkingPlace(getWorkingPlace());
		vacancyImpl.setDescription(getDescription());
		vacancyImpl.setRequiredGender(getRequiredGender());
		vacancyImpl.setCertificateType(getCertificateType());
		vacancyImpl.setSpecialized(getSpecialized());
		vacancyImpl.setExperiences(getExperiences());
		vacancyImpl.setForeignLanguages(getForeignLanguages());
		vacancyImpl.setSkills(getSkills());
		vacancyImpl.setOfficeSkills(getOfficeSkills());
		vacancyImpl.setAwayToBusinessType(getAwayToBusinessType());
		vacancyImpl.setWorkingTimeType(getWorkingTimeType());
		vacancyImpl.setJobType(getJobType());
		vacancyImpl.setCode(getCode());
		vacancyImpl.setStatus(getStatus());
		vacancyImpl.setPostedDate(getPostedDate());
		vacancyImpl.setExpiredDate(getExpiredDate());
		vacancyImpl.setGroupId(getGroupId());
		vacancyImpl.setCompanyId(getCompanyId());
		vacancyImpl.setUserId(getUserId());
		vacancyImpl.setUserName(getUserName());
		vacancyImpl.setCreateDate(getCreateDate());
		vacancyImpl.setModifiedDate(getModifiedDate());
		vacancyImpl.setDeleted(getDeleted());

		vacancyImpl.resetOriginalValues();

		return vacancyImpl;
	}

	@Override
	public int compareTo(Vacancy vacancy) {
		long primaryKey = vacancy.getPrimaryKey();

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

		if (!(obj instanceof Vacancy)) {
			return false;
		}

		Vacancy vacancy = (Vacancy)obj;

		long primaryKey = vacancy.getPrimaryKey();

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
		VacancyModelImpl vacancyModelImpl = this;

		vacancyModelImpl._originalDeleted = vacancyModelImpl._deleted;

		vacancyModelImpl._setOriginalDeleted = false;

		vacancyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Vacancy> toCacheModel() {
		VacancyCacheModel vacancyCacheModel = new VacancyCacheModel();

		vacancyCacheModel.vacancyId = getVacancyId();

		vacancyCacheModel.approvedNumberOfPosition = getApprovedNumberOfPosition();

		vacancyCacheModel.currentNumberOfEmployee = getCurrentNumberOfEmployee();

		vacancyCacheModel.titlesId = getTitlesId();

		vacancyCacheModel.numberOfNewRecruitment = getNumberOfNewRecruitment();

		vacancyCacheModel.numberOfReplacedRecruitment = getNumberOfReplacedRecruitment();

		vacancyCacheModel.expectedSalary = getExpectedSalary();

		Date expectedJoinedDate = getExpectedJoinedDate();

		if (expectedJoinedDate != null) {
			vacancyCacheModel.expectedJoinedDate = expectedJoinedDate.getTime();
		}
		else {
			vacancyCacheModel.expectedJoinedDate = Long.MIN_VALUE;
		}

		vacancyCacheModel.workingPlace = getWorkingPlace();

		String workingPlace = vacancyCacheModel.workingPlace;

		if ((workingPlace != null) && (workingPlace.length() == 0)) {
			vacancyCacheModel.workingPlace = null;
		}

		vacancyCacheModel.description = getDescription();

		String description = vacancyCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			vacancyCacheModel.description = null;
		}

		vacancyCacheModel.requiredGender = getRequiredGender();

		String requiredGender = vacancyCacheModel.requiredGender;

		if ((requiredGender != null) && (requiredGender.length() == 0)) {
			vacancyCacheModel.requiredGender = null;
		}

		vacancyCacheModel.certificateType = getCertificateType();

		String certificateType = vacancyCacheModel.certificateType;

		if ((certificateType != null) && (certificateType.length() == 0)) {
			vacancyCacheModel.certificateType = null;
		}

		vacancyCacheModel.specialized = getSpecialized();

		String specialized = vacancyCacheModel.specialized;

		if ((specialized != null) && (specialized.length() == 0)) {
			vacancyCacheModel.specialized = null;
		}

		vacancyCacheModel.experiences = getExperiences();

		vacancyCacheModel.foreignLanguages = getForeignLanguages();

		String foreignLanguages = vacancyCacheModel.foreignLanguages;

		if ((foreignLanguages != null) && (foreignLanguages.length() == 0)) {
			vacancyCacheModel.foreignLanguages = null;
		}

		vacancyCacheModel.skills = getSkills();

		String skills = vacancyCacheModel.skills;

		if ((skills != null) && (skills.length() == 0)) {
			vacancyCacheModel.skills = null;
		}

		vacancyCacheModel.officeSkills = getOfficeSkills();

		String officeSkills = vacancyCacheModel.officeSkills;

		if ((officeSkills != null) && (officeSkills.length() == 0)) {
			vacancyCacheModel.officeSkills = null;
		}

		vacancyCacheModel.awayToBusinessType = getAwayToBusinessType();

		String awayToBusinessType = vacancyCacheModel.awayToBusinessType;

		if ((awayToBusinessType != null) && (awayToBusinessType.length() == 0)) {
			vacancyCacheModel.awayToBusinessType = null;
		}

		vacancyCacheModel.workingTimeType = getWorkingTimeType();

		String workingTimeType = vacancyCacheModel.workingTimeType;

		if ((workingTimeType != null) && (workingTimeType.length() == 0)) {
			vacancyCacheModel.workingTimeType = null;
		}

		vacancyCacheModel.jobType = getJobType();

		String jobType = vacancyCacheModel.jobType;

		if ((jobType != null) && (jobType.length() == 0)) {
			vacancyCacheModel.jobType = null;
		}

		vacancyCacheModel.code = getCode();

		String code = vacancyCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			vacancyCacheModel.code = null;
		}

		vacancyCacheModel.status = getStatus();

		String status = vacancyCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			vacancyCacheModel.status = null;
		}

		Date postedDate = getPostedDate();

		if (postedDate != null) {
			vacancyCacheModel.postedDate = postedDate.getTime();
		}
		else {
			vacancyCacheModel.postedDate = Long.MIN_VALUE;
		}

		Date expiredDate = getExpiredDate();

		if (expiredDate != null) {
			vacancyCacheModel.expiredDate = expiredDate.getTime();
		}
		else {
			vacancyCacheModel.expiredDate = Long.MIN_VALUE;
		}

		vacancyCacheModel.groupId = getGroupId();

		vacancyCacheModel.companyId = getCompanyId();

		vacancyCacheModel.userId = getUserId();

		vacancyCacheModel.userName = getUserName();

		String userName = vacancyCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			vacancyCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vacancyCacheModel.createDate = createDate.getTime();
		}
		else {
			vacancyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vacancyCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vacancyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vacancyCacheModel.deleted = getDeleted();

		return vacancyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{vacancyId=");
		sb.append(getVacancyId());
		sb.append(", approvedNumberOfPosition=");
		sb.append(getApprovedNumberOfPosition());
		sb.append(", currentNumberOfEmployee=");
		sb.append(getCurrentNumberOfEmployee());
		sb.append(", titlesId=");
		sb.append(getTitlesId());
		sb.append(", numberOfNewRecruitment=");
		sb.append(getNumberOfNewRecruitment());
		sb.append(", numberOfReplacedRecruitment=");
		sb.append(getNumberOfReplacedRecruitment());
		sb.append(", expectedSalary=");
		sb.append(getExpectedSalary());
		sb.append(", expectedJoinedDate=");
		sb.append(getExpectedJoinedDate());
		sb.append(", workingPlace=");
		sb.append(getWorkingPlace());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", requiredGender=");
		sb.append(getRequiredGender());
		sb.append(", certificateType=");
		sb.append(getCertificateType());
		sb.append(", specialized=");
		sb.append(getSpecialized());
		sb.append(", experiences=");
		sb.append(getExperiences());
		sb.append(", foreignLanguages=");
		sb.append(getForeignLanguages());
		sb.append(", skills=");
		sb.append(getSkills());
		sb.append(", officeSkills=");
		sb.append(getOfficeSkills());
		sb.append(", awayToBusinessType=");
		sb.append(getAwayToBusinessType());
		sb.append(", workingTimeType=");
		sb.append(getWorkingTimeType());
		sb.append(", jobType=");
		sb.append(getJobType());
		sb.append(", code=");
		sb.append(getCode());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", postedDate=");
		sb.append(getPostedDate());
		sb.append(", expiredDate=");
		sb.append(getExpiredDate());
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
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(97);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.Vacancy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vacancyId</column-name><column-value><![CDATA[");
		sb.append(getVacancyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvedNumberOfPosition</column-name><column-value><![CDATA[");
		sb.append(getApprovedNumberOfPosition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentNumberOfEmployee</column-name><column-value><![CDATA[");
		sb.append(getCurrentNumberOfEmployee());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfNewRecruitment</column-name><column-value><![CDATA[");
		sb.append(getNumberOfNewRecruitment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfReplacedRecruitment</column-name><column-value><![CDATA[");
		sb.append(getNumberOfReplacedRecruitment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedSalary</column-name><column-value><![CDATA[");
		sb.append(getExpectedSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expectedJoinedDate</column-name><column-value><![CDATA[");
		sb.append(getExpectedJoinedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingPlace</column-name><column-value><![CDATA[");
		sb.append(getWorkingPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>requiredGender</column-name><column-value><![CDATA[");
		sb.append(getRequiredGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateType</column-name><column-value><![CDATA[");
		sb.append(getCertificateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>specialized</column-name><column-value><![CDATA[");
		sb.append(getSpecialized());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>experiences</column-name><column-value><![CDATA[");
		sb.append(getExperiences());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foreignLanguages</column-name><column-value><![CDATA[");
		sb.append(getForeignLanguages());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skills</column-name><column-value><![CDATA[");
		sb.append(getSkills());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officeSkills</column-name><column-value><![CDATA[");
		sb.append(getOfficeSkills());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>awayToBusinessType</column-name><column-value><![CDATA[");
		sb.append(getAwayToBusinessType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingTimeType</column-name><column-value><![CDATA[");
		sb.append(getWorkingTimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobType</column-name><column-value><![CDATA[");
		sb.append(getJobType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>code</column-name><column-value><![CDATA[");
		sb.append(getCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postedDate</column-name><column-value><![CDATA[");
		sb.append(getPostedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredDate</column-name><column-value><![CDATA[");
		sb.append(getExpiredDate());
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
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Vacancy.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Vacancy.class
		};
	private long _vacancyId;
	private int _approvedNumberOfPosition;
	private int _currentNumberOfEmployee;
	private long _titlesId;
	private int _numberOfNewRecruitment;
	private int _numberOfReplacedRecruitment;
	private double _expectedSalary;
	private Date _expectedJoinedDate;
	private String _workingPlace;
	private String _description;
	private String _requiredGender;
	private String _certificateType;
	private String _specialized;
	private double _experiences;
	private String _foreignLanguages;
	private String _skills;
	private String _officeSkills;
	private String _awayToBusinessType;
	private String _workingTimeType;
	private String _jobType;
	private String _code;
	private String _status;
	private Date _postedDate;
	private Date _expiredDate;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private boolean _originalDeleted;
	private boolean _setOriginalDeleted;
	private long _columnBitmask;
	private Vacancy _escapedModel;
}