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

package vn.com.ecopharma.emp.model.impl;

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

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.model.VacationLeaveModel;
import vn.com.ecopharma.emp.model.VacationLeaveSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the VacationLeave service. Represents a row in the &quot;eco_em_portlet_VacationLeave&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.ecopharma.emp.model.VacationLeaveModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VacationLeaveImpl}.
 * </p>
 *
 * @author tvt
 * @see VacationLeaveImpl
 * @see vn.com.ecopharma.emp.model.VacationLeave
 * @see vn.com.ecopharma.emp.model.VacationLeaveModel
 * @generated
 */
@JSON(strict = true)
public class VacationLeaveModelImpl extends BaseModelImpl<VacationLeave>
	implements VacationLeaveModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vacation leave model instance should use the {@link vn.com.ecopharma.emp.model.VacationLeave} interface instead.
	 */
	public static final String TABLE_NAME = "eco_em_portlet_VacationLeave";
	public static final Object[][] TABLE_COLUMNS = {
			{ "vacationLeaveId", Types.BIGINT },
			{ "empId", Types.BIGINT },
			{ "leaveType", Types.VARCHAR },
			{ "leaveFrom", Types.TIMESTAMP },
			{ "leaveTo", Types.TIMESTAMP },
			{ "actualTo", Types.TIMESTAMP },
			{ "numberOfHours", Types.INTEGER },
			{ "reason", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN },
			{ "status", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table eco_em_portlet_VacationLeave (vacationLeaveId LONG not null primary key,empId LONG,leaveType VARCHAR(75) null,leaveFrom DATE null,leaveTo DATE null,actualTo DATE null,numberOfHours INTEGER,reason VARCHAR(75) null,description VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,deleted BOOLEAN,status VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table eco_em_portlet_VacationLeave";
	public static final String ORDER_BY_JPQL = " ORDER BY vacationLeave.vacationLeaveId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eco_em_portlet_VacationLeave.vacationLeaveId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.ecopharma.emp.model.VacationLeave"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.ecopharma.emp.model.VacationLeave"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.ecopharma.emp.model.VacationLeave"),
			true);
	public static long EMPID_COLUMN_BITMASK = 1L;
	public static long LEAVETYPE_COLUMN_BITMASK = 2L;
	public static long VACATIONLEAVEID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static VacationLeave toModel(VacationLeaveSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		VacationLeave model = new VacationLeaveImpl();

		model.setVacationLeaveId(soapModel.getVacationLeaveId());
		model.setEmpId(soapModel.getEmpId());
		model.setLeaveType(soapModel.getLeaveType());
		model.setLeaveFrom(soapModel.getLeaveFrom());
		model.setLeaveTo(soapModel.getLeaveTo());
		model.setActualTo(soapModel.getActualTo());
		model.setNumberOfHours(soapModel.getNumberOfHours());
		model.setReason(soapModel.getReason());
		model.setDescription(soapModel.getDescription());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setDeleted(soapModel.getDeleted());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<VacationLeave> toModels(VacationLeaveSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<VacationLeave> models = new ArrayList<VacationLeave>(soapModels.length);

		for (VacationLeaveSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.ecopharma.emp.model.VacationLeave"));

	public VacationLeaveModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _vacationLeaveId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVacationLeaveId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _vacationLeaveId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return VacationLeave.class;
	}

	@Override
	public String getModelClassName() {
		return VacationLeave.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("vacationLeaveId", getVacationLeaveId());
		attributes.put("empId", getEmpId());
		attributes.put("leaveType", getLeaveType());
		attributes.put("leaveFrom", getLeaveFrom());
		attributes.put("leaveTo", getLeaveTo());
		attributes.put("actualTo", getActualTo());
		attributes.put("numberOfHours", getNumberOfHours());
		attributes.put("reason", getReason());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("deleted", getDeleted());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long vacationLeaveId = (Long)attributes.get("vacationLeaveId");

		if (vacationLeaveId != null) {
			setVacationLeaveId(vacationLeaveId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String leaveType = (String)attributes.get("leaveType");

		if (leaveType != null) {
			setLeaveType(leaveType);
		}

		Date leaveFrom = (Date)attributes.get("leaveFrom");

		if (leaveFrom != null) {
			setLeaveFrom(leaveFrom);
		}

		Date leaveTo = (Date)attributes.get("leaveTo");

		if (leaveTo != null) {
			setLeaveTo(leaveTo);
		}

		Date actualTo = (Date)attributes.get("actualTo");

		if (actualTo != null) {
			setActualTo(actualTo);
		}

		Integer numberOfHours = (Integer)attributes.get("numberOfHours");

		if (numberOfHours != null) {
			setNumberOfHours(numberOfHours);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
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

		Boolean deleted = (Boolean)attributes.get("deleted");

		if (deleted != null) {
			setDeleted(deleted);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@JSON
	@Override
	public long getVacationLeaveId() {
		return _vacationLeaveId;
	}

	@Override
	public void setVacationLeaveId(long vacationLeaveId) {
		_vacationLeaveId = vacationLeaveId;
	}

	@JSON
	@Override
	public long getEmpId() {
		return _empId;
	}

	@Override
	public void setEmpId(long empId) {
		_columnBitmask |= EMPID_COLUMN_BITMASK;

		if (!_setOriginalEmpId) {
			_setOriginalEmpId = true;

			_originalEmpId = _empId;
		}

		_empId = empId;
	}

	public long getOriginalEmpId() {
		return _originalEmpId;
	}

	@JSON
	@Override
	public String getLeaveType() {
		if (_leaveType == null) {
			return StringPool.BLANK;
		}
		else {
			return _leaveType;
		}
	}

	@Override
	public void setLeaveType(String leaveType) {
		_columnBitmask |= LEAVETYPE_COLUMN_BITMASK;

		if (_originalLeaveType == null) {
			_originalLeaveType = _leaveType;
		}

		_leaveType = leaveType;
	}

	public String getOriginalLeaveType() {
		return GetterUtil.getString(_originalLeaveType);
	}

	@JSON
	@Override
	public Date getLeaveFrom() {
		return _leaveFrom;
	}

	@Override
	public void setLeaveFrom(Date leaveFrom) {
		_leaveFrom = leaveFrom;
	}

	@JSON
	@Override
	public Date getLeaveTo() {
		return _leaveTo;
	}

	@Override
	public void setLeaveTo(Date leaveTo) {
		_leaveTo = leaveTo;
	}

	@JSON
	@Override
	public Date getActualTo() {
		return _actualTo;
	}

	@Override
	public void setActualTo(Date actualTo) {
		_actualTo = actualTo;
	}

	@JSON
	@Override
	public int getNumberOfHours() {
		return _numberOfHours;
	}

	@Override
	public void setNumberOfHours(int numberOfHours) {
		_numberOfHours = numberOfHours;
	}

	@JSON
	@Override
	public String getReason() {
		if (_reason == null) {
			return StringPool.BLANK;
		}
		else {
			return _reason;
		}
	}

	@Override
	public void setReason(String reason) {
		_reason = reason;
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
		_deleted = deleted;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			VacationLeave.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VacationLeave toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VacationLeave)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VacationLeaveImpl vacationLeaveImpl = new VacationLeaveImpl();

		vacationLeaveImpl.setVacationLeaveId(getVacationLeaveId());
		vacationLeaveImpl.setEmpId(getEmpId());
		vacationLeaveImpl.setLeaveType(getLeaveType());
		vacationLeaveImpl.setLeaveFrom(getLeaveFrom());
		vacationLeaveImpl.setLeaveTo(getLeaveTo());
		vacationLeaveImpl.setActualTo(getActualTo());
		vacationLeaveImpl.setNumberOfHours(getNumberOfHours());
		vacationLeaveImpl.setReason(getReason());
		vacationLeaveImpl.setDescription(getDescription());
		vacationLeaveImpl.setGroupId(getGroupId());
		vacationLeaveImpl.setCompanyId(getCompanyId());
		vacationLeaveImpl.setUserId(getUserId());
		vacationLeaveImpl.setUserName(getUserName());
		vacationLeaveImpl.setCreateDate(getCreateDate());
		vacationLeaveImpl.setModifiedDate(getModifiedDate());
		vacationLeaveImpl.setDeleted(getDeleted());
		vacationLeaveImpl.setStatus(getStatus());

		vacationLeaveImpl.resetOriginalValues();

		return vacationLeaveImpl;
	}

	@Override
	public int compareTo(VacationLeave vacationLeave) {
		long primaryKey = vacationLeave.getPrimaryKey();

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

		if (!(obj instanceof VacationLeave)) {
			return false;
		}

		VacationLeave vacationLeave = (VacationLeave)obj;

		long primaryKey = vacationLeave.getPrimaryKey();

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
		VacationLeaveModelImpl vacationLeaveModelImpl = this;

		vacationLeaveModelImpl._originalEmpId = vacationLeaveModelImpl._empId;

		vacationLeaveModelImpl._setOriginalEmpId = false;

		vacationLeaveModelImpl._originalLeaveType = vacationLeaveModelImpl._leaveType;

		vacationLeaveModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VacationLeave> toCacheModel() {
		VacationLeaveCacheModel vacationLeaveCacheModel = new VacationLeaveCacheModel();

		vacationLeaveCacheModel.vacationLeaveId = getVacationLeaveId();

		vacationLeaveCacheModel.empId = getEmpId();

		vacationLeaveCacheModel.leaveType = getLeaveType();

		String leaveType = vacationLeaveCacheModel.leaveType;

		if ((leaveType != null) && (leaveType.length() == 0)) {
			vacationLeaveCacheModel.leaveType = null;
		}

		Date leaveFrom = getLeaveFrom();

		if (leaveFrom != null) {
			vacationLeaveCacheModel.leaveFrom = leaveFrom.getTime();
		}
		else {
			vacationLeaveCacheModel.leaveFrom = Long.MIN_VALUE;
		}

		Date leaveTo = getLeaveTo();

		if (leaveTo != null) {
			vacationLeaveCacheModel.leaveTo = leaveTo.getTime();
		}
		else {
			vacationLeaveCacheModel.leaveTo = Long.MIN_VALUE;
		}

		Date actualTo = getActualTo();

		if (actualTo != null) {
			vacationLeaveCacheModel.actualTo = actualTo.getTime();
		}
		else {
			vacationLeaveCacheModel.actualTo = Long.MIN_VALUE;
		}

		vacationLeaveCacheModel.numberOfHours = getNumberOfHours();

		vacationLeaveCacheModel.reason = getReason();

		String reason = vacationLeaveCacheModel.reason;

		if ((reason != null) && (reason.length() == 0)) {
			vacationLeaveCacheModel.reason = null;
		}

		vacationLeaveCacheModel.description = getDescription();

		String description = vacationLeaveCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			vacationLeaveCacheModel.description = null;
		}

		vacationLeaveCacheModel.groupId = getGroupId();

		vacationLeaveCacheModel.companyId = getCompanyId();

		vacationLeaveCacheModel.userId = getUserId();

		vacationLeaveCacheModel.userName = getUserName();

		String userName = vacationLeaveCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			vacationLeaveCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			vacationLeaveCacheModel.createDate = createDate.getTime();
		}
		else {
			vacationLeaveCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			vacationLeaveCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			vacationLeaveCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		vacationLeaveCacheModel.deleted = getDeleted();

		vacationLeaveCacheModel.status = getStatus();

		String status = vacationLeaveCacheModel.status;

		if ((status != null) && (status.length() == 0)) {
			vacationLeaveCacheModel.status = null;
		}

		return vacationLeaveCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{vacationLeaveId=");
		sb.append(getVacationLeaveId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", leaveType=");
		sb.append(getLeaveType());
		sb.append(", leaveFrom=");
		sb.append(getLeaveFrom());
		sb.append(", leaveTo=");
		sb.append(getLeaveTo());
		sb.append(", actualTo=");
		sb.append(getActualTo());
		sb.append(", numberOfHours=");
		sb.append(getNumberOfHours());
		sb.append(", reason=");
		sb.append(getReason());
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
		sb.append(", deleted=");
		sb.append(getDeleted());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.VacationLeave");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>vacationLeaveId</column-name><column-value><![CDATA[");
		sb.append(getVacationLeaveId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveType</column-name><column-value><![CDATA[");
		sb.append(getLeaveType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveFrom</column-name><column-value><![CDATA[");
		sb.append(getLeaveFrom());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>leaveTo</column-name><column-value><![CDATA[");
		sb.append(getLeaveTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>actualTo</column-name><column-value><![CDATA[");
		sb.append(getActualTo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfHours</column-name><column-value><![CDATA[");
		sb.append(getNumberOfHours());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>reason</column-name><column-value><![CDATA[");
		sb.append(getReason());
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
		sb.append(
			"<column><column-name>deleted</column-name><column-value><![CDATA[");
		sb.append(getDeleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VacationLeave.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VacationLeave.class
		};
	private long _vacationLeaveId;
	private long _empId;
	private long _originalEmpId;
	private boolean _setOriginalEmpId;
	private String _leaveType;
	private String _originalLeaveType;
	private Date _leaveFrom;
	private Date _leaveTo;
	private Date _actualTo;
	private int _numberOfHours;
	private String _reason;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private String _status;
	private long _columnBitmask;
	private VacationLeave _escapedModel;
}