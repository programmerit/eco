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
 * This class is a wrapper for {@link VacancyEvaluationCriteria}.
 * </p>
 *
 * @author tvt
 * @see VacancyEvaluationCriteria
 * @generated
 */
public class VacancyEvaluationCriteriaWrapper
	implements VacancyEvaluationCriteria,
		ModelWrapper<VacancyEvaluationCriteria> {
	public VacancyEvaluationCriteriaWrapper(
		VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		_vacancyEvaluationCriteria = vacancyEvaluationCriteria;
	}

	@Override
	public Class<?> getModelClass() {
		return VacancyEvaluationCriteria.class;
	}

	@Override
	public String getModelClassName() {
		return VacancyEvaluationCriteria.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacancyEvaluationCriteriaId",
			getVacancyEvaluationCriteriaId());
		attributes.put("vacancyId", getVacancyId());
		attributes.put("evaluationCriteriaId", getEvaluationCriteriaId());
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
		Long vacancyEvaluationCriteriaId = (Long)attributes.get(
				"vacancyEvaluationCriteriaId");

		if (vacancyEvaluationCriteriaId != null) {
			setVacancyEvaluationCriteriaId(vacancyEvaluationCriteriaId);
		}

		Long vacancyId = (Long)attributes.get("vacancyId");

		if (vacancyId != null) {
			setVacancyId(vacancyId);
		}

		Long evaluationCriteriaId = (Long)attributes.get("evaluationCriteriaId");

		if (evaluationCriteriaId != null) {
			setEvaluationCriteriaId(evaluationCriteriaId);
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
	* Returns the primary key of this vacancy evaluation criteria.
	*
	* @return the primary key of this vacancy evaluation criteria
	*/
	@Override
	public long getPrimaryKey() {
		return _vacancyEvaluationCriteria.getPrimaryKey();
	}

	/**
	* Sets the primary key of this vacancy evaluation criteria.
	*
	* @param primaryKey the primary key of this vacancy evaluation criteria
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_vacancyEvaluationCriteria.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the vacancy evaluation criteria ID of this vacancy evaluation criteria.
	*
	* @return the vacancy evaluation criteria ID of this vacancy evaluation criteria
	*/
	@Override
	public long getVacancyEvaluationCriteriaId() {
		return _vacancyEvaluationCriteria.getVacancyEvaluationCriteriaId();
	}

	/**
	* Sets the vacancy evaluation criteria ID of this vacancy evaluation criteria.
	*
	* @param vacancyEvaluationCriteriaId the vacancy evaluation criteria ID of this vacancy evaluation criteria
	*/
	@Override
	public void setVacancyEvaluationCriteriaId(long vacancyEvaluationCriteriaId) {
		_vacancyEvaluationCriteria.setVacancyEvaluationCriteriaId(vacancyEvaluationCriteriaId);
	}

	/**
	* Returns the vacancy ID of this vacancy evaluation criteria.
	*
	* @return the vacancy ID of this vacancy evaluation criteria
	*/
	@Override
	public long getVacancyId() {
		return _vacancyEvaluationCriteria.getVacancyId();
	}

	/**
	* Sets the vacancy ID of this vacancy evaluation criteria.
	*
	* @param vacancyId the vacancy ID of this vacancy evaluation criteria
	*/
	@Override
	public void setVacancyId(long vacancyId) {
		_vacancyEvaluationCriteria.setVacancyId(vacancyId);
	}

	/**
	* Returns the evaluation criteria ID of this vacancy evaluation criteria.
	*
	* @return the evaluation criteria ID of this vacancy evaluation criteria
	*/
	@Override
	public long getEvaluationCriteriaId() {
		return _vacancyEvaluationCriteria.getEvaluationCriteriaId();
	}

	/**
	* Sets the evaluation criteria ID of this vacancy evaluation criteria.
	*
	* @param evaluationCriteriaId the evaluation criteria ID of this vacancy evaluation criteria
	*/
	@Override
	public void setEvaluationCriteriaId(long evaluationCriteriaId) {
		_vacancyEvaluationCriteria.setEvaluationCriteriaId(evaluationCriteriaId);
	}

	/**
	* Returns the group ID of this vacancy evaluation criteria.
	*
	* @return the group ID of this vacancy evaluation criteria
	*/
	@Override
	public long getGroupId() {
		return _vacancyEvaluationCriteria.getGroupId();
	}

	/**
	* Sets the group ID of this vacancy evaluation criteria.
	*
	* @param groupId the group ID of this vacancy evaluation criteria
	*/
	@Override
	public void setGroupId(long groupId) {
		_vacancyEvaluationCriteria.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this vacancy evaluation criteria.
	*
	* @return the company ID of this vacancy evaluation criteria
	*/
	@Override
	public long getCompanyId() {
		return _vacancyEvaluationCriteria.getCompanyId();
	}

	/**
	* Sets the company ID of this vacancy evaluation criteria.
	*
	* @param companyId the company ID of this vacancy evaluation criteria
	*/
	@Override
	public void setCompanyId(long companyId) {
		_vacancyEvaluationCriteria.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this vacancy evaluation criteria.
	*
	* @return the user ID of this vacancy evaluation criteria
	*/
	@Override
	public long getUserId() {
		return _vacancyEvaluationCriteria.getUserId();
	}

	/**
	* Sets the user ID of this vacancy evaluation criteria.
	*
	* @param userId the user ID of this vacancy evaluation criteria
	*/
	@Override
	public void setUserId(long userId) {
		_vacancyEvaluationCriteria.setUserId(userId);
	}

	/**
	* Returns the user uuid of this vacancy evaluation criteria.
	*
	* @return the user uuid of this vacancy evaluation criteria
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _vacancyEvaluationCriteria.getUserUuid();
	}

	/**
	* Sets the user uuid of this vacancy evaluation criteria.
	*
	* @param userUuid the user uuid of this vacancy evaluation criteria
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_vacancyEvaluationCriteria.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this vacancy evaluation criteria.
	*
	* @return the user name of this vacancy evaluation criteria
	*/
	@Override
	public java.lang.String getUserName() {
		return _vacancyEvaluationCriteria.getUserName();
	}

	/**
	* Sets the user name of this vacancy evaluation criteria.
	*
	* @param userName the user name of this vacancy evaluation criteria
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_vacancyEvaluationCriteria.setUserName(userName);
	}

	/**
	* Returns the create date of this vacancy evaluation criteria.
	*
	* @return the create date of this vacancy evaluation criteria
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _vacancyEvaluationCriteria.getCreateDate();
	}

	/**
	* Sets the create date of this vacancy evaluation criteria.
	*
	* @param createDate the create date of this vacancy evaluation criteria
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_vacancyEvaluationCriteria.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this vacancy evaluation criteria.
	*
	* @return the modified date of this vacancy evaluation criteria
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _vacancyEvaluationCriteria.getModifiedDate();
	}

	/**
	* Sets the modified date of this vacancy evaluation criteria.
	*
	* @param modifiedDate the modified date of this vacancy evaluation criteria
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_vacancyEvaluationCriteria.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _vacancyEvaluationCriteria.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_vacancyEvaluationCriteria.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _vacancyEvaluationCriteria.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_vacancyEvaluationCriteria.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _vacancyEvaluationCriteria.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _vacancyEvaluationCriteria.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_vacancyEvaluationCriteria.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _vacancyEvaluationCriteria.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_vacancyEvaluationCriteria.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_vacancyEvaluationCriteria.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_vacancyEvaluationCriteria.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VacancyEvaluationCriteriaWrapper((VacancyEvaluationCriteria)_vacancyEvaluationCriteria.clone());
	}

	@Override
	public int compareTo(
		vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria vacancyEvaluationCriteria) {
		return _vacancyEvaluationCriteria.compareTo(vacancyEvaluationCriteria);
	}

	@Override
	public int hashCode() {
		return _vacancyEvaluationCriteria.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria> toCacheModel() {
		return _vacancyEvaluationCriteria.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria toEscapedModel() {
		return new VacancyEvaluationCriteriaWrapper(_vacancyEvaluationCriteria.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteria toUnescapedModel() {
		return new VacancyEvaluationCriteriaWrapper(_vacancyEvaluationCriteria.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _vacancyEvaluationCriteria.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _vacancyEvaluationCriteria.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_vacancyEvaluationCriteria.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacancyEvaluationCriteriaWrapper)) {
			return false;
		}

		VacancyEvaluationCriteriaWrapper vacancyEvaluationCriteriaWrapper = (VacancyEvaluationCriteriaWrapper)obj;

		if (Validator.equals(_vacancyEvaluationCriteria,
					vacancyEvaluationCriteriaWrapper._vacancyEvaluationCriteria)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VacancyEvaluationCriteria getWrappedVacancyEvaluationCriteria() {
		return _vacancyEvaluationCriteria;
	}

	@Override
	public VacancyEvaluationCriteria getWrappedModel() {
		return _vacancyEvaluationCriteria;
	}

	@Override
	public void resetOriginalValues() {
		_vacancyEvaluationCriteria.resetOriginalValues();
	}

	private VacancyEvaluationCriteria _vacancyEvaluationCriteria;
}