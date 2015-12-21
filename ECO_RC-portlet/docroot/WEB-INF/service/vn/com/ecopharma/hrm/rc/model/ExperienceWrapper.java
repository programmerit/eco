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
 * This class is a wrapper for {@link Experience}.
 * </p>
 *
 * @author tvt
 * @see Experience
 * @generated
 */
public class ExperienceWrapper implements Experience, ModelWrapper<Experience> {
	public ExperienceWrapper(Experience experience) {
		_experience = experience;
	}

	@Override
	public Class<?> getModelClass() {
		return Experience.class;
	}

	@Override
	public String getModelClassName() {
		return Experience.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("experienceId", getExperienceId());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("companyName", getCompanyName());
		attributes.put("workingPlace", getWorkingPlace());
		attributes.put("yearsExperience", getYearsExperience());
		attributes.put("tel", getTel());
		attributes.put("workingFrom", getWorkingFrom());
		attributes.put("workingTo", getWorkingTo());
		attributes.put("initialTitles", getInitialTitles());
		attributes.put("finalTitles", getFinalTitles());
		attributes.put("initialSalary", getInitialSalary());
		attributes.put("finalSalary", getFinalSalary());
		attributes.put("field", getField());
		attributes.put("manager", getManager());
		attributes.put("responsibility", getResponsibility());
		attributes.put("resignedReason", getResignedReason());
		attributes.put("description", getDescription());
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
		Long experienceId = (Long)attributes.get("experienceId");

		if (experienceId != null) {
			setExperienceId(experienceId);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String workingPlace = (String)attributes.get("workingPlace");

		if (workingPlace != null) {
			setWorkingPlace(workingPlace);
		}

		Double yearsExperience = (Double)attributes.get("yearsExperience");

		if (yearsExperience != null) {
			setYearsExperience(yearsExperience);
		}

		String tel = (String)attributes.get("tel");

		if (tel != null) {
			setTel(tel);
		}

		Date workingFrom = (Date)attributes.get("workingFrom");

		if (workingFrom != null) {
			setWorkingFrom(workingFrom);
		}

		Date workingTo = (Date)attributes.get("workingTo");

		if (workingTo != null) {
			setWorkingTo(workingTo);
		}

		String initialTitles = (String)attributes.get("initialTitles");

		if (initialTitles != null) {
			setInitialTitles(initialTitles);
		}

		String finalTitles = (String)attributes.get("finalTitles");

		if (finalTitles != null) {
			setFinalTitles(finalTitles);
		}

		Double initialSalary = (Double)attributes.get("initialSalary");

		if (initialSalary != null) {
			setInitialSalary(initialSalary);
		}

		Double finalSalary = (Double)attributes.get("finalSalary");

		if (finalSalary != null) {
			setFinalSalary(finalSalary);
		}

		String field = (String)attributes.get("field");

		if (field != null) {
			setField(field);
		}

		String manager = (String)attributes.get("manager");

		if (manager != null) {
			setManager(manager);
		}

		String responsibility = (String)attributes.get("responsibility");

		if (responsibility != null) {
			setResponsibility(responsibility);
		}

		String resignedReason = (String)attributes.get("resignedReason");

		if (resignedReason != null) {
			setResignedReason(resignedReason);
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
	}

	/**
	* Returns the primary key of this experience.
	*
	* @return the primary key of this experience
	*/
	@Override
	public long getPrimaryKey() {
		return _experience.getPrimaryKey();
	}

	/**
	* Sets the primary key of this experience.
	*
	* @param primaryKey the primary key of this experience
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_experience.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the experience ID of this experience.
	*
	* @return the experience ID of this experience
	*/
	@Override
	public long getExperienceId() {
		return _experience.getExperienceId();
	}

	/**
	* Sets the experience ID of this experience.
	*
	* @param experienceId the experience ID of this experience
	*/
	@Override
	public void setExperienceId(long experienceId) {
		_experience.setExperienceId(experienceId);
	}

	/**
	* Returns the class name of this experience.
	*
	* @return the class name of this experience
	*/
	@Override
	public java.lang.String getClassName() {
		return _experience.getClassName();
	}

	/**
	* Sets the class name of this experience.
	*
	* @param className the class name of this experience
	*/
	@Override
	public void setClassName(java.lang.String className) {
		_experience.setClassName(className);
	}

	/**
	* Returns the class p k of this experience.
	*
	* @return the class p k of this experience
	*/
	@Override
	public long getClassPK() {
		return _experience.getClassPK();
	}

	/**
	* Sets the class p k of this experience.
	*
	* @param classPK the class p k of this experience
	*/
	@Override
	public void setClassPK(long classPK) {
		_experience.setClassPK(classPK);
	}

	/**
	* Returns the company name of this experience.
	*
	* @return the company name of this experience
	*/
	@Override
	public java.lang.String getCompanyName() {
		return _experience.getCompanyName();
	}

	/**
	* Sets the company name of this experience.
	*
	* @param companyName the company name of this experience
	*/
	@Override
	public void setCompanyName(java.lang.String companyName) {
		_experience.setCompanyName(companyName);
	}

	/**
	* Returns the working place of this experience.
	*
	* @return the working place of this experience
	*/
	@Override
	public java.lang.String getWorkingPlace() {
		return _experience.getWorkingPlace();
	}

	/**
	* Sets the working place of this experience.
	*
	* @param workingPlace the working place of this experience
	*/
	@Override
	public void setWorkingPlace(java.lang.String workingPlace) {
		_experience.setWorkingPlace(workingPlace);
	}

	/**
	* Returns the years experience of this experience.
	*
	* @return the years experience of this experience
	*/
	@Override
	public double getYearsExperience() {
		return _experience.getYearsExperience();
	}

	/**
	* Sets the years experience of this experience.
	*
	* @param yearsExperience the years experience of this experience
	*/
	@Override
	public void setYearsExperience(double yearsExperience) {
		_experience.setYearsExperience(yearsExperience);
	}

	/**
	* Returns the tel of this experience.
	*
	* @return the tel of this experience
	*/
	@Override
	public java.lang.String getTel() {
		return _experience.getTel();
	}

	/**
	* Sets the tel of this experience.
	*
	* @param tel the tel of this experience
	*/
	@Override
	public void setTel(java.lang.String tel) {
		_experience.setTel(tel);
	}

	/**
	* Returns the working from of this experience.
	*
	* @return the working from of this experience
	*/
	@Override
	public java.util.Date getWorkingFrom() {
		return _experience.getWorkingFrom();
	}

	/**
	* Sets the working from of this experience.
	*
	* @param workingFrom the working from of this experience
	*/
	@Override
	public void setWorkingFrom(java.util.Date workingFrom) {
		_experience.setWorkingFrom(workingFrom);
	}

	/**
	* Returns the working to of this experience.
	*
	* @return the working to of this experience
	*/
	@Override
	public java.util.Date getWorkingTo() {
		return _experience.getWorkingTo();
	}

	/**
	* Sets the working to of this experience.
	*
	* @param workingTo the working to of this experience
	*/
	@Override
	public void setWorkingTo(java.util.Date workingTo) {
		_experience.setWorkingTo(workingTo);
	}

	/**
	* Returns the initial titles of this experience.
	*
	* @return the initial titles of this experience
	*/
	@Override
	public java.lang.String getInitialTitles() {
		return _experience.getInitialTitles();
	}

	/**
	* Sets the initial titles of this experience.
	*
	* @param initialTitles the initial titles of this experience
	*/
	@Override
	public void setInitialTitles(java.lang.String initialTitles) {
		_experience.setInitialTitles(initialTitles);
	}

	/**
	* Returns the final titles of this experience.
	*
	* @return the final titles of this experience
	*/
	@Override
	public java.lang.String getFinalTitles() {
		return _experience.getFinalTitles();
	}

	/**
	* Sets the final titles of this experience.
	*
	* @param finalTitles the final titles of this experience
	*/
	@Override
	public void setFinalTitles(java.lang.String finalTitles) {
		_experience.setFinalTitles(finalTitles);
	}

	/**
	* Returns the initial salary of this experience.
	*
	* @return the initial salary of this experience
	*/
	@Override
	public double getInitialSalary() {
		return _experience.getInitialSalary();
	}

	/**
	* Sets the initial salary of this experience.
	*
	* @param initialSalary the initial salary of this experience
	*/
	@Override
	public void setInitialSalary(double initialSalary) {
		_experience.setInitialSalary(initialSalary);
	}

	/**
	* Returns the final salary of this experience.
	*
	* @return the final salary of this experience
	*/
	@Override
	public double getFinalSalary() {
		return _experience.getFinalSalary();
	}

	/**
	* Sets the final salary of this experience.
	*
	* @param finalSalary the final salary of this experience
	*/
	@Override
	public void setFinalSalary(double finalSalary) {
		_experience.setFinalSalary(finalSalary);
	}

	/**
	* Returns the field of this experience.
	*
	* @return the field of this experience
	*/
	@Override
	public java.lang.String getField() {
		return _experience.getField();
	}

	/**
	* Sets the field of this experience.
	*
	* @param field the field of this experience
	*/
	@Override
	public void setField(java.lang.String field) {
		_experience.setField(field);
	}

	/**
	* Returns the manager of this experience.
	*
	* @return the manager of this experience
	*/
	@Override
	public java.lang.String getManager() {
		return _experience.getManager();
	}

	/**
	* Sets the manager of this experience.
	*
	* @param manager the manager of this experience
	*/
	@Override
	public void setManager(java.lang.String manager) {
		_experience.setManager(manager);
	}

	/**
	* Returns the responsibility of this experience.
	*
	* @return the responsibility of this experience
	*/
	@Override
	public java.lang.String getResponsibility() {
		return _experience.getResponsibility();
	}

	/**
	* Sets the responsibility of this experience.
	*
	* @param responsibility the responsibility of this experience
	*/
	@Override
	public void setResponsibility(java.lang.String responsibility) {
		_experience.setResponsibility(responsibility);
	}

	/**
	* Returns the resigned reason of this experience.
	*
	* @return the resigned reason of this experience
	*/
	@Override
	public java.lang.String getResignedReason() {
		return _experience.getResignedReason();
	}

	/**
	* Sets the resigned reason of this experience.
	*
	* @param resignedReason the resigned reason of this experience
	*/
	@Override
	public void setResignedReason(java.lang.String resignedReason) {
		_experience.setResignedReason(resignedReason);
	}

	/**
	* Returns the description of this experience.
	*
	* @return the description of this experience
	*/
	@Override
	public java.lang.String getDescription() {
		return _experience.getDescription();
	}

	/**
	* Sets the description of this experience.
	*
	* @param description the description of this experience
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_experience.setDescription(description);
	}

	/**
	* Returns the group ID of this experience.
	*
	* @return the group ID of this experience
	*/
	@Override
	public long getGroupId() {
		return _experience.getGroupId();
	}

	/**
	* Sets the group ID of this experience.
	*
	* @param groupId the group ID of this experience
	*/
	@Override
	public void setGroupId(long groupId) {
		_experience.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this experience.
	*
	* @return the company ID of this experience
	*/
	@Override
	public long getCompanyId() {
		return _experience.getCompanyId();
	}

	/**
	* Sets the company ID of this experience.
	*
	* @param companyId the company ID of this experience
	*/
	@Override
	public void setCompanyId(long companyId) {
		_experience.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this experience.
	*
	* @return the user ID of this experience
	*/
	@Override
	public long getUserId() {
		return _experience.getUserId();
	}

	/**
	* Sets the user ID of this experience.
	*
	* @param userId the user ID of this experience
	*/
	@Override
	public void setUserId(long userId) {
		_experience.setUserId(userId);
	}

	/**
	* Returns the user uuid of this experience.
	*
	* @return the user uuid of this experience
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _experience.getUserUuid();
	}

	/**
	* Sets the user uuid of this experience.
	*
	* @param userUuid the user uuid of this experience
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_experience.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this experience.
	*
	* @return the user name of this experience
	*/
	@Override
	public java.lang.String getUserName() {
		return _experience.getUserName();
	}

	/**
	* Sets the user name of this experience.
	*
	* @param userName the user name of this experience
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_experience.setUserName(userName);
	}

	/**
	* Returns the create date of this experience.
	*
	* @return the create date of this experience
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _experience.getCreateDate();
	}

	/**
	* Sets the create date of this experience.
	*
	* @param createDate the create date of this experience
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_experience.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this experience.
	*
	* @return the modified date of this experience
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _experience.getModifiedDate();
	}

	/**
	* Sets the modified date of this experience.
	*
	* @param modifiedDate the modified date of this experience
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_experience.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _experience.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_experience.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _experience.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_experience.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _experience.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _experience.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_experience.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _experience.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_experience.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_experience.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_experience.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExperienceWrapper((Experience)_experience.clone());
	}

	@Override
	public int compareTo(vn.com.ecopharma.hrm.rc.model.Experience experience) {
		return _experience.compareTo(experience);
	}

	@Override
	public int hashCode() {
		return _experience.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<vn.com.ecopharma.hrm.rc.model.Experience> toCacheModel() {
		return _experience.toCacheModel();
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience toEscapedModel() {
		return new ExperienceWrapper(_experience.toEscapedModel());
	}

	@Override
	public vn.com.ecopharma.hrm.rc.model.Experience toUnescapedModel() {
		return new ExperienceWrapper(_experience.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _experience.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _experience.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_experience.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExperienceWrapper)) {
			return false;
		}

		ExperienceWrapper experienceWrapper = (ExperienceWrapper)obj;

		if (Validator.equals(_experience, experienceWrapper._experience)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Experience getWrappedExperience() {
		return _experience;
	}

	@Override
	public Experience getWrappedModel() {
		return _experience;
	}

	@Override
	public void resetOriginalValues() {
		_experience.resetOriginalValues();
	}

	private Experience _experience;
}