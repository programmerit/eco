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

import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.PromotedHistoryModel;
import vn.com.ecopharma.emp.model.PromotedHistorySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the PromotedHistory service. Represents a row in the &quot;eco_em_portlet_PromotedHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.ecopharma.emp.model.PromotedHistoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PromotedHistoryImpl}.
 * </p>
 *
 * @author tvt
 * @see PromotedHistoryImpl
 * @see vn.com.ecopharma.emp.model.PromotedHistory
 * @see vn.com.ecopharma.emp.model.PromotedHistoryModel
 * @generated
 */
@JSON(strict = true)
public class PromotedHistoryModelImpl extends BaseModelImpl<PromotedHistory>
	implements PromotedHistoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a promoted history model instance should use the {@link vn.com.ecopharma.emp.model.PromotedHistory} interface instead.
	 */
	public static final String TABLE_NAME = "eco_em_portlet_PromotedHistory";
	public static final Object[][] TABLE_COLUMNS = {
			{ "promotedHistoryId", Types.BIGINT },
			{ "employeeId", Types.BIGINT },
			{ "oldTitlesId", Types.BIGINT },
			{ "newTitlesId", Types.BIGINT },
			{ "promotedDate", Types.TIMESTAMP },
			{ "comment_", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "deleted", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table eco_em_portlet_PromotedHistory (promotedHistoryId LONG not null primary key,employeeId LONG,oldTitlesId LONG,newTitlesId LONG,promotedDate DATE null,comment_ VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,deleted BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table eco_em_portlet_PromotedHistory";
	public static final String ORDER_BY_JPQL = " ORDER BY promotedHistory.promotedHistoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eco_em_portlet_PromotedHistory.promotedHistoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.ecopharma.emp.model.PromotedHistory"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.ecopharma.emp.model.PromotedHistory"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.ecopharma.emp.model.PromotedHistory"),
			true);
	public static long EMPLOYEEID_COLUMN_BITMASK = 1L;
	public static long NEWTITLESID_COLUMN_BITMASK = 2L;
	public static long OLDTITLESID_COLUMN_BITMASK = 4L;
	public static long PROMOTEDHISTORYID_COLUMN_BITMASK = 8L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static PromotedHistory toModel(PromotedHistorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		PromotedHistory model = new PromotedHistoryImpl();

		model.setPromotedHistoryId(soapModel.getPromotedHistoryId());
		model.setEmployeeId(soapModel.getEmployeeId());
		model.setOldTitlesId(soapModel.getOldTitlesId());
		model.setNewTitlesId(soapModel.getNewTitlesId());
		model.setPromotedDate(soapModel.getPromotedDate());
		model.setComment(soapModel.getComment());
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
	public static List<PromotedHistory> toModels(
		PromotedHistorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<PromotedHistory> models = new ArrayList<PromotedHistory>(soapModels.length);

		for (PromotedHistorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.ecopharma.emp.model.PromotedHistory"));

	public PromotedHistoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _promotedHistoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPromotedHistoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _promotedHistoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return PromotedHistory.class;
	}

	@Override
	public String getModelClassName() {
		return PromotedHistory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("promotedHistoryId", getPromotedHistoryId());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("oldTitlesId", getOldTitlesId());
		attributes.put("newTitlesId", getNewTitlesId());
		attributes.put("promotedDate", getPromotedDate());
		attributes.put("comment", getComment());
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
		Long promotedHistoryId = (Long)attributes.get("promotedHistoryId");

		if (promotedHistoryId != null) {
			setPromotedHistoryId(promotedHistoryId);
		}

		Long employeeId = (Long)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		Long oldTitlesId = (Long)attributes.get("oldTitlesId");

		if (oldTitlesId != null) {
			setOldTitlesId(oldTitlesId);
		}

		Long newTitlesId = (Long)attributes.get("newTitlesId");

		if (newTitlesId != null) {
			setNewTitlesId(newTitlesId);
		}

		Date promotedDate = (Date)attributes.get("promotedDate");

		if (promotedDate != null) {
			setPromotedDate(promotedDate);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
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
	public long getPromotedHistoryId() {
		return _promotedHistoryId;
	}

	@Override
	public void setPromotedHistoryId(long promotedHistoryId) {
		_promotedHistoryId = promotedHistoryId;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_columnBitmask |= EMPLOYEEID_COLUMN_BITMASK;

		if (!_setOriginalEmployeeId) {
			_setOriginalEmployeeId = true;

			_originalEmployeeId = _employeeId;
		}

		_employeeId = employeeId;
	}

	public long getOriginalEmployeeId() {
		return _originalEmployeeId;
	}

	@JSON
	@Override
	public long getOldTitlesId() {
		return _oldTitlesId;
	}

	@Override
	public void setOldTitlesId(long oldTitlesId) {
		_columnBitmask |= OLDTITLESID_COLUMN_BITMASK;

		if (!_setOriginalOldTitlesId) {
			_setOriginalOldTitlesId = true;

			_originalOldTitlesId = _oldTitlesId;
		}

		_oldTitlesId = oldTitlesId;
	}

	public long getOriginalOldTitlesId() {
		return _originalOldTitlesId;
	}

	@JSON
	@Override
	public long getNewTitlesId() {
		return _newTitlesId;
	}

	@Override
	public void setNewTitlesId(long newTitlesId) {
		_columnBitmask |= NEWTITLESID_COLUMN_BITMASK;

		if (!_setOriginalNewTitlesId) {
			_setOriginalNewTitlesId = true;

			_originalNewTitlesId = _newTitlesId;
		}

		_newTitlesId = newTitlesId;
	}

	public long getOriginalNewTitlesId() {
		return _originalNewTitlesId;
	}

	@JSON
	@Override
	public Date getPromotedDate() {
		return _promotedDate;
	}

	@Override
	public void setPromotedDate(Date promotedDate) {
		_promotedDate = promotedDate;
	}

	@JSON
	@Override
	public String getComment() {
		if (_comment == null) {
			return StringPool.BLANK;
		}
		else {
			return _comment;
		}
	}

	@Override
	public void setComment(String comment) {
		_comment = comment;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			PromotedHistory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public PromotedHistory toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (PromotedHistory)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		PromotedHistoryImpl promotedHistoryImpl = new PromotedHistoryImpl();

		promotedHistoryImpl.setPromotedHistoryId(getPromotedHistoryId());
		promotedHistoryImpl.setEmployeeId(getEmployeeId());
		promotedHistoryImpl.setOldTitlesId(getOldTitlesId());
		promotedHistoryImpl.setNewTitlesId(getNewTitlesId());
		promotedHistoryImpl.setPromotedDate(getPromotedDate());
		promotedHistoryImpl.setComment(getComment());
		promotedHistoryImpl.setGroupId(getGroupId());
		promotedHistoryImpl.setCompanyId(getCompanyId());
		promotedHistoryImpl.setUserId(getUserId());
		promotedHistoryImpl.setUserName(getUserName());
		promotedHistoryImpl.setCreateDate(getCreateDate());
		promotedHistoryImpl.setModifiedDate(getModifiedDate());
		promotedHistoryImpl.setDeleted(getDeleted());

		promotedHistoryImpl.resetOriginalValues();

		return promotedHistoryImpl;
	}

	@Override
	public int compareTo(PromotedHistory promotedHistory) {
		long primaryKey = promotedHistory.getPrimaryKey();

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

		if (!(obj instanceof PromotedHistory)) {
			return false;
		}

		PromotedHistory promotedHistory = (PromotedHistory)obj;

		long primaryKey = promotedHistory.getPrimaryKey();

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
		PromotedHistoryModelImpl promotedHistoryModelImpl = this;

		promotedHistoryModelImpl._originalEmployeeId = promotedHistoryModelImpl._employeeId;

		promotedHistoryModelImpl._setOriginalEmployeeId = false;

		promotedHistoryModelImpl._originalOldTitlesId = promotedHistoryModelImpl._oldTitlesId;

		promotedHistoryModelImpl._setOriginalOldTitlesId = false;

		promotedHistoryModelImpl._originalNewTitlesId = promotedHistoryModelImpl._newTitlesId;

		promotedHistoryModelImpl._setOriginalNewTitlesId = false;

		promotedHistoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<PromotedHistory> toCacheModel() {
		PromotedHistoryCacheModel promotedHistoryCacheModel = new PromotedHistoryCacheModel();

		promotedHistoryCacheModel.promotedHistoryId = getPromotedHistoryId();

		promotedHistoryCacheModel.employeeId = getEmployeeId();

		promotedHistoryCacheModel.oldTitlesId = getOldTitlesId();

		promotedHistoryCacheModel.newTitlesId = getNewTitlesId();

		Date promotedDate = getPromotedDate();

		if (promotedDate != null) {
			promotedHistoryCacheModel.promotedDate = promotedDate.getTime();
		}
		else {
			promotedHistoryCacheModel.promotedDate = Long.MIN_VALUE;
		}

		promotedHistoryCacheModel.comment = getComment();

		String comment = promotedHistoryCacheModel.comment;

		if ((comment != null) && (comment.length() == 0)) {
			promotedHistoryCacheModel.comment = null;
		}

		promotedHistoryCacheModel.groupId = getGroupId();

		promotedHistoryCacheModel.companyId = getCompanyId();

		promotedHistoryCacheModel.userId = getUserId();

		promotedHistoryCacheModel.userName = getUserName();

		String userName = promotedHistoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			promotedHistoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			promotedHistoryCacheModel.createDate = createDate.getTime();
		}
		else {
			promotedHistoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			promotedHistoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			promotedHistoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		promotedHistoryCacheModel.deleted = getDeleted();

		return promotedHistoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{promotedHistoryId=");
		sb.append(getPromotedHistoryId());
		sb.append(", employeeId=");
		sb.append(getEmployeeId());
		sb.append(", oldTitlesId=");
		sb.append(getOldTitlesId());
		sb.append(", newTitlesId=");
		sb.append(getNewTitlesId());
		sb.append(", promotedDate=");
		sb.append(getPromotedDate());
		sb.append(", comment=");
		sb.append(getComment());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.PromotedHistory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>promotedHistoryId</column-name><column-value><![CDATA[");
		sb.append(getPromotedHistoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>employeeId</column-name><column-value><![CDATA[");
		sb.append(getEmployeeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>oldTitlesId</column-name><column-value><![CDATA[");
		sb.append(getOldTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>newTitlesId</column-name><column-value><![CDATA[");
		sb.append(getNewTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>promotedDate</column-name><column-value><![CDATA[");
		sb.append(getPromotedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>comment</column-name><column-value><![CDATA[");
		sb.append(getComment());
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

	private static ClassLoader _classLoader = PromotedHistory.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			PromotedHistory.class
		};
	private long _promotedHistoryId;
	private long _employeeId;
	private long _originalEmployeeId;
	private boolean _setOriginalEmployeeId;
	private long _oldTitlesId;
	private long _originalOldTitlesId;
	private boolean _setOriginalOldTitlesId;
	private long _newTitlesId;
	private long _originalNewTitlesId;
	private boolean _setOriginalNewTitlesId;
	private Date _promotedDate;
	private String _comment;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
	private long _columnBitmask;
	private PromotedHistory _escapedModel;
}