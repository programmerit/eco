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
 * This class is a wrapper for {@link Vacancy}.
 * </p>
 *
 * @author tvt
 * @see Vacancy
 * @generated
 */
public class VacancyWrapper implements Vacancy, ModelWrapper<Vacancy> {
	public VacancyWrapper(Vacancy vacancy) {
		_vacancy = vacancy;
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
		attributes.put("name", getName());
		attributes.put("numberOfPosition", getNumberOfPosition());
		attributes.put("titlesId", getTitlesId());
		attributes.put("status", getStatus());
		attributes.put("postedDate", getPostedDate());
		attributes.put("expiredDate", getExpiredDate());
		attributes.put("deleted", getDeleted());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("code", getCode());
		attributes.put("certificateType", getCertificateType());
		attributes.put("experiences", getExperiences());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer numberOfPosition = (Integer)attributes.get("numberOfPosition");

		if (numberOfPosition != null) {
			setNumberOfPosition(numberOfPosition);
		}

		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String certificateType = (String)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		Double experiences = (Double)attributes.get("experiences");

		if (experiences != null) {
			setExperiences(experiences);
		}
	}

	/**
	* Returns the primary key of this vacancy.
	*
	* @return the primary key of this vacancy
	*/
	@Override
	public long getPrimaryKey() {
		return _vacancy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vacancy.
	*
	* @param primaryKey the primary key of this vacancy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vacancy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vacancy ID of this vacancy.
	*
	* @return the vacancy ID of this vacancy
	*/
	@Override
	public long getVacancyId() {
		return _vacancy.getVacancyId();
	}

	/**
	* Sets the vacancy ID of this vacancy.
	*
	* @param vacancyId the vacancy ID of this vacancy
	*/
	@Override
	public void setVacancyId(long vacancyId) {
		_vacancy.setVacancyId(vacancyId);
	}

	/**
	* Returns the name of this vacancy.
	*
	* @return the name of this vacancy
	*/
	@Override
	public java.lang.String getName() {
		return _vacancy.getName();
	}

	/**
	* Sets the name of this vacancy.
	*
	* @param name the name of this vacancy
	*/
	@Override
	public void setName(java.lang.String name) {
		_vacancy.setName(name);
	}

	/**
	* Returns the number of position of this vacancy.
	*
	* @return the number of position of this vacancy
	*/
	@Override
	public int getNumberOfPosition() {
		return _vacancy.getNumberOfPosition();
	}

	/**
	* Sets the number of position of this vacancy.
	*
	* @param numberOfPosition the number of position of this vacancy
	*/
	@Override
	public void setNumberOfPosition(int numberOfPosition) {
		_vacancy.setNumberOfPosition(numberOfPosition);
	}

	/**
	* Returns the titles ID of this vacancy.
	*
	* @return the titles ID of this vacancy
	*/
	@Override
	public long getTitlesId() {
		return _vacancy.getTitlesId();
	}

	/**
	* Sets the titles ID of this vacancy.
	*
	* @param titlesId the titles ID of this vacancy
	*/
	@Override
	public void setTitlesId(long titlesId) {
		_vacancy.setTitlesId(titlesId);
	}

	/**
	* Returns the status of this vacancy.
	*
	* @return the status of this vacancy
	*/
	@Override
	public java.lang.String getStatus() {
		return _vacancy.getStatus();
	}

	/**
	* Sets the status of this vacancy.
	*
	* @param status the status of this vacancy
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_vacancy.setStatus(status);
	}

	/**
	* Returns the posted date of this vacancy.
	*
	* @return the posted date of this vacancy
	*/
	@Override
	public java.util.Date getPostedDate() {
		return _vacancy.getPostedDate();
	}

	/**
	* Sets the posted date of this vacancy.
	*
	* @param postedDate the posted date of this vacancy
	*/
	@Override
	public void setPostedDate(java.util.Date postedDate) {
		_vacancy.setPostedDate(postedDate);
	}

	/**
	* Returns the expired date of this vacancy.
	*
	* @return the expired date of this vacancy
	*/
	@Override
	public java.util.Date getExpiredDate() {
		return _vacancy.getExpiredDate();
	}

	/**
	* Sets the expired date of this vacancy.
	*
	* @param expiredDate the expired date of this vacancy
	*/
	@Override
	public void setExpiredDate(java.util.Date expiredDate) {
		_vacancy.setExpiredDate(expiredDate);
	}

	/**
	* Returns the deleted of this vacancy.
	*
	* @return the deleted of this vacancy
	*/
	@Override
	public boolean getDeleted() {
		return _vacancy.getDeleted();
	}

	/**
	* Returns <code>true</code> if this vacancy is deleted.
	*
	* @return <code>true</code> if this vacancy is deleted; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeleted() {
		return _vacancy.isDeleted();
	}

	/**
	* Sets whether this vacancy is deleted.
	*
	* @param deleted the deleted of this vacancy
	*/
	@Override
	public void setDeleted(boolean deleted) {
		_vacancy.setDeleted(deleted);
	}

	/**
	* Returns the description of this vacancy.
	*
	* @return the description of this vacancy
	*/
	@Override
	public java.lang.String getDescription() {
		return _vacancy.getDescription();
	}

	/**
	* Sets the description of this vacancy.
	*
	* @param description the description of this vacancy
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_vacancy.setDescription(description);
	}

	/**
	* Returns the group ID of this vacancy.
	*
	* @return the group ID of this vacancy
	*/
	@Override
	public long getGroupId() {
		return _vacancy.getGroupId();
	}

	/**
	* Sets the group ID of this vacancy.
	*
	* @param groupId the group ID of this vacancy
	*/
	@Override
	public void setGroupId(long groupId) {
		_vacancy.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vacancy.
	*
	* @return the company ID of this vacancy
	*/
	@Override
	public long getCompanyId() {
		return _vacancy.getCompanyId();
	}

	/**
	* Sets the company ID of this vacancy.
	*
	* @param companyId the company ID of this vacancy
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vacancy.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vacancy.
	*
	* @return the user ID of this vacancy
	*/
	@Override
	public long getUserId() {
		return _vacancy.getUserId();
	}

	/**
	* Sets the user ID of this vacancy.
	*
	* @param userId the user ID of this vacancy
	*/
	@Override
	public void setUserId(long userId) {
		_vacancy.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vacancy.
	*
	* @return the user uuid of this vacancy
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancy.getUserUuid();
	}

	/**
	* Sets the user uuid of this vacancy.
	*
	* @param userUuid the user uuid of this vacancy
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vacancy.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vacancy.
	*
	* @return the user name of this vacancy
	*/
	@Override
	public java.lang.String getUserName() {
		return _vacancy.getUserName();
	}

	/**
	* Sets the user name of this vacancy.
	*
	* @param userName the user name of this vacancy
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vacancy.setUserName(userName);
	}

	/**
	* Returns the create date of this vacancy.
	*
	* @return the create date of this vacancy
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vacancy.getCreateDate();
	}

	/**
	* Sets the create date of this vacancy.
	*
	* @param createDate the create date of this vacancy
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vacancy.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vacancy.
	*
	* @return the modified date of this vacancy
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vacancy.getModifiedDate();
	}

	/**
	* Sets the modified date of this vacancy.
	*
	* @param modifiedDate the modified date of this vacancy
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vacancy.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the code of this vacancy.
	*
	* @return the code of this vacancy
	*/
	@Override
	public java.lang.String getCode() {
		return _vacancy.getCode();
	}

	/**
	* Sets the code of this vacancy.
	*
	* @param code the code of this vacancy
	*/
	@Override
	public void setCode(java.lang.String code) {
		_vacancy.setCode(code);
	}

	/**
	* Returns the certificate type of this vacancy.
	*
	* @return the certificate type of this vacancy
	*/
	@Override
	public java.lang.String getCertificateType() {
		return _vacancy.getCertificateType();
	}

	/**
	* Sets the certificate type of this vacancy.
	*
	* @param certificateType the certificate type of this vacancy
	*/
	@Override
	public void setCertificateType(java.lang.String certificateType) {
		_vacancy.setCertificateType(certificateType);
	}

	/**
	* Returns the experiences of this vacancy.
	*
	* @return the experiences of this vacancy
	*/
	@Override
	public double getExperiences() {
		return _vacancy.getExperiences();
	}

	/**
	* Sets the experiences of this vacancy.
	*
	* @param experiences the experiences of this vacancy
	*/
	@Override
	public void setExperiences(double experiences) {
		_vacancy.setExperiences(experiences);
	}

	@Override
	public boolean isNew() {
		return _vacancy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vacancy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vacancy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vacancy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vacancy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vacancy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vacancy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vacancy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vacancy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vacancy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vacancy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VacancyWrapper((Vacancy)_vacancy.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.hrm.rc.model.Vacancy vacancy) {
		return _vacancy.compareTo(vacancy);
	}

	@Override
	public int hashCode() {
		return _vacancy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.Vacancy> toCacheModel() {
		return _vacancy.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Vacancy toEscapedModel() {
		return new VacancyWrapper(_vacancy.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Vacancy toUnescapedModel() {
		return new VacancyWrapper(_vacancy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vacancy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vacancy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vacancy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacancyWrapper)) {
			return false;
		}

		VacancyWrapper vacancyWrapper = (VacancyWrapper)obj;

		if (Validator.equals(_vacancy, vacancyWrapper._vacancy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Vacancy getWrappedVacancy() {
		return _vacancy;
	}

	@Override
	public Vacancy getWrappedModel() {
		return _vacancy;
	}

	@Override
	public void resetOriginalValues() {
		_vacancy.resetOriginalValues();
	}

	private Vacancy _vacancy;
}