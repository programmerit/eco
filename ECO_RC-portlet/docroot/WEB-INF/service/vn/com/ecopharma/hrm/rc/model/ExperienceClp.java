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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import vn.com.ecopharma.hrm.rc.service.ClpSerializer;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tvt
 */
public class ExperienceClp extends BaseModelImpl<Experience>
	implements Experience {
	public ExperienceClp() {
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
	public long getPrimaryKey() {
		return _experienceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setExperienceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _experienceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getExperienceId() {
		return _experienceId;
	}

	@Override
	public void setExperienceId(long experienceId) {
		_experienceId = experienceId;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setExperienceId", long.class);

				method.invoke(_experienceRemoteModel, experienceId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClassName() {
		return _className;
	}

	@Override
	public void setClassName(String className) {
		_className = className;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setClassName", String.class);

				method.invoke(_experienceRemoteModel, className);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_experienceRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCompanyName() {
		return _companyName;
	}

	@Override
	public void setCompanyName(String companyName) {
		_companyName = companyName;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyName", String.class);

				method.invoke(_experienceRemoteModel, companyName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWorkingPlace() {
		return _workingPlace;
	}

	@Override
	public void setWorkingPlace(String workingPlace) {
		_workingPlace = workingPlace;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingPlace", String.class);

				method.invoke(_experienceRemoteModel, workingPlace);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getYearsExperience() {
		return _yearsExperience;
	}

	@Override
	public void setYearsExperience(double yearsExperience) {
		_yearsExperience = yearsExperience;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setYearsExperience",
						double.class);

				method.invoke(_experienceRemoteModel, yearsExperience);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTel() {
		return _tel;
	}

	@Override
	public void setTel(String tel) {
		_tel = tel;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setTel", String.class);

				method.invoke(_experienceRemoteModel, tel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWorkingFrom() {
		return _workingFrom;
	}

	@Override
	public void setWorkingFrom(Date workingFrom) {
		_workingFrom = workingFrom;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingFrom", Date.class);

				method.invoke(_experienceRemoteModel, workingFrom);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getWorkingTo() {
		return _workingTo;
	}

	@Override
	public void setWorkingTo(Date workingTo) {
		_workingTo = workingTo;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setWorkingTo", Date.class);

				method.invoke(_experienceRemoteModel, workingTo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInitialTitles() {
		return _initialTitles;
	}

	@Override
	public void setInitialTitles(String initialTitles) {
		_initialTitles = initialTitles;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setInitialTitles", String.class);

				method.invoke(_experienceRemoteModel, initialTitles);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFinalTitles() {
		return _finalTitles;
	}

	@Override
	public void setFinalTitles(String finalTitles) {
		_finalTitles = finalTitles;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalTitles", String.class);

				method.invoke(_experienceRemoteModel, finalTitles);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getInitialSalary() {
		return _initialSalary;
	}

	@Override
	public void setInitialSalary(double initialSalary) {
		_initialSalary = initialSalary;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setInitialSalary", double.class);

				method.invoke(_experienceRemoteModel, initialSalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getFinalSalary() {
		return _finalSalary;
	}

	@Override
	public void setFinalSalary(double finalSalary) {
		_finalSalary = finalSalary;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setFinalSalary", double.class);

				method.invoke(_experienceRemoteModel, finalSalary);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField() {
		return _field;
	}

	@Override
	public void setField(String field) {
		_field = field;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setField", String.class);

				method.invoke(_experienceRemoteModel, field);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getManager() {
		return _manager;
	}

	@Override
	public void setManager(String manager) {
		_manager = manager;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setManager", String.class);

				method.invoke(_experienceRemoteModel, manager);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResponsibility() {
		return _responsibility;
	}

	@Override
	public void setResponsibility(String responsibility) {
		_responsibility = responsibility;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setResponsibility",
						String.class);

				method.invoke(_experienceRemoteModel, responsibility);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResignedReason() {
		return _resignedReason;
	}

	@Override
	public void setResignedReason(String resignedReason) {
		_resignedReason = resignedReason;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setResignedReason",
						String.class);

				method.invoke(_experienceRemoteModel, resignedReason);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_experienceRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_experienceRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_experienceRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_experienceRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_experienceRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_experienceRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_experienceRemoteModel != null) {
			try {
				Class<?> clazz = _experienceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_experienceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getExperienceRemoteModel() {
		return _experienceRemoteModel;
	}

	public void setExperienceRemoteModel(BaseModel<?> experienceRemoteModel) {
		_experienceRemoteModel = experienceRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _experienceRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_experienceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ExperienceLocalServiceUtil.addExperience(this);
		}
		else {
			ExperienceLocalServiceUtil.updateExperience(this);
		}
	}

	@Override
	public Experience toEscapedModel() {
		return (Experience)ProxyUtil.newProxyInstance(Experience.class.getClassLoader(),
			new Class[] { Experience.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ExperienceClp clone = new ExperienceClp();

		clone.setExperienceId(getExperienceId());
		clone.setClassName(getClassName());
		clone.setClassPK(getClassPK());
		clone.setCompanyName(getCompanyName());
		clone.setWorkingPlace(getWorkingPlace());
		clone.setYearsExperience(getYearsExperience());
		clone.setTel(getTel());
		clone.setWorkingFrom(getWorkingFrom());
		clone.setWorkingTo(getWorkingTo());
		clone.setInitialTitles(getInitialTitles());
		clone.setFinalTitles(getFinalTitles());
		clone.setInitialSalary(getInitialSalary());
		clone.setFinalSalary(getFinalSalary());
		clone.setField(getField());
		clone.setManager(getManager());
		clone.setResponsibility(getResponsibility());
		clone.setResignedReason(getResignedReason());
		clone.setDescription(getDescription());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(Experience experience) {
		long primaryKey = experience.getPrimaryKey();

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

		if (!(obj instanceof ExperienceClp)) {
			return false;
		}

		ExperienceClp experience = (ExperienceClp)obj;

		long primaryKey = experience.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{experienceId=");
		sb.append(getExperienceId());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", companyName=");
		sb.append(getCompanyName());
		sb.append(", workingPlace=");
		sb.append(getWorkingPlace());
		sb.append(", yearsExperience=");
		sb.append(getYearsExperience());
		sb.append(", tel=");
		sb.append(getTel());
		sb.append(", workingFrom=");
		sb.append(getWorkingFrom());
		sb.append(", workingTo=");
		sb.append(getWorkingTo());
		sb.append(", initialTitles=");
		sb.append(getInitialTitles());
		sb.append(", finalTitles=");
		sb.append(getFinalTitles());
		sb.append(", initialSalary=");
		sb.append(getInitialSalary());
		sb.append(", finalSalary=");
		sb.append(getFinalSalary());
		sb.append(", field=");
		sb.append(getField());
		sb.append(", manager=");
		sb.append(getManager());
		sb.append(", responsibility=");
		sb.append(getResponsibility());
		sb.append(", resignedReason=");
		sb.append(getResignedReason());
		sb.append(", description=");
		sb.append(getDescription());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.hrm.rc.model.Experience");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>experienceId</column-name><column-value><![CDATA[");
		sb.append(getExperienceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyName</column-name><column-value><![CDATA[");
		sb.append(getCompanyName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingPlace</column-name><column-value><![CDATA[");
		sb.append(getWorkingPlace());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yearsExperience</column-name><column-value><![CDATA[");
		sb.append(getYearsExperience());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tel</column-name><column-value><![CDATA[");
		sb.append(getTel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingFrom</column-name><column-value><![CDATA[");
		sb.append(getWorkingFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>workingTo</column-name><column-value><![CDATA[");
		sb.append(getWorkingTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initialTitles</column-name><column-value><![CDATA[");
		sb.append(getInitialTitles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalTitles</column-name><column-value><![CDATA[");
		sb.append(getFinalTitles());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initialSalary</column-name><column-value><![CDATA[");
		sb.append(getInitialSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>finalSalary</column-name><column-value><![CDATA[");
		sb.append(getFinalSalary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field</column-name><column-value><![CDATA[");
		sb.append(getField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>manager</column-name><column-value><![CDATA[");
		sb.append(getManager());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>responsibility</column-name><column-value><![CDATA[");
		sb.append(getResponsibility());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resignedReason</column-name><column-value><![CDATA[");
		sb.append(getResignedReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
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

		sb.append("</model>");

		return sb.toString();
	}

	private long _experienceId;
	private String _className;
	private long _classPK;
	private String _companyName;
	private String _workingPlace;
	private double _yearsExperience;
	private String _tel;
	private Date _workingFrom;
	private Date _workingTo;
	private String _initialTitles;
	private String _finalTitles;
	private double _initialSalary;
	private double _finalSalary;
	private String _field;
	private String _manager;
	private String _responsibility;
	private String _resignedReason;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _experienceRemoteModel;
	private Class<?> _clpSerializerClass = vn.com.ecopharma.hrm.rc.service.ClpSerializer.class;
}