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

import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.TitlesModel;
import vn.com.ecopharma.emp.model.TitlesSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Titles service. Represents a row in the &quot;eco_em_portlet_Titles&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.ecopharma.emp.model.TitlesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TitlesImpl}.
 * </p>
 *
 * @author tvt
 * @see TitlesImpl
 * @see vn.com.ecopharma.emp.model.Titles
 * @see vn.com.ecopharma.emp.model.TitlesModel
 * @generated
 */
@JSON(strict = true)
public class TitlesModelImpl extends BaseModelImpl<Titles>
	implements TitlesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a titles model instance should use the {@link vn.com.ecopharma.emp.model.Titles} interface instead.
	 */
	public static final String TABLE_NAME = "eco_em_portlet_Titles";
	public static final Object[][] TABLE_COLUMNS = {
			{ "titlesId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "unitGroupId", Types.BIGINT },
			{ "unitId", Types.BIGINT },
			{ "departmentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eco_em_portlet_Titles (titlesId LONG not null primary key,name VARCHAR(75) null,unitGroupId LONG,unitId LONG,departmentId LONG,groupId LONG,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eco_em_portlet_Titles";
	public static final String ORDER_BY_JPQL = " ORDER BY titles.titlesId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eco_em_portlet_Titles.titlesId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.ecopharma.emp.model.Titles"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.ecopharma.emp.model.Titles"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.vn.com.ecopharma.emp.model.Titles"),
			true);
	public static long DEPARTMENTID_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static long UNITGROUPID_COLUMN_BITMASK = 4L;
	public static long UNITID_COLUMN_BITMASK = 8L;
	public static long TITLESID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Titles toModel(TitlesSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Titles model = new TitlesImpl();

		model.setTitlesId(soapModel.getTitlesId());
		model.setName(soapModel.getName());
		model.setUnitGroupId(soapModel.getUnitGroupId());
		model.setUnitId(soapModel.getUnitId());
		model.setDepartmentId(soapModel.getDepartmentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Titles> toModels(TitlesSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Titles> models = new ArrayList<Titles>(soapModels.length);

		for (TitlesSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.ecopharma.emp.model.Titles"));

	public TitlesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _titlesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTitlesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _titlesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Titles.class;
	}

	@Override
	public String getModelClassName() {
		return Titles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("titlesId", getTitlesId());
		attributes.put("name", getName());
		attributes.put("unitGroupId", getUnitGroupId());
		attributes.put("unitId", getUnitId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long titlesId = (Long)attributes.get("titlesId");

		if (titlesId != null) {
			setTitlesId(titlesId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long unitGroupId = (Long)attributes.get("unitGroupId");

		if (unitGroupId != null) {
			setUnitGroupId(unitGroupId);
		}

		Long unitId = (Long)attributes.get("unitId");

		if (unitId != null) {
			setUnitId(unitId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
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
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public long getUnitGroupId() {
		return _unitGroupId;
	}

	@Override
	public void setUnitGroupId(long unitGroupId) {
		_columnBitmask |= UNITGROUPID_COLUMN_BITMASK;

		if (!_setOriginalUnitGroupId) {
			_setOriginalUnitGroupId = true;

			_originalUnitGroupId = _unitGroupId;
		}

		_unitGroupId = unitGroupId;
	}

	public long getOriginalUnitGroupId() {
		return _originalUnitGroupId;
	}

	@JSON
	@Override
	public long getUnitId() {
		return _unitId;
	}

	@Override
	public void setUnitId(long unitId) {
		_columnBitmask |= UNITID_COLUMN_BITMASK;

		if (!_setOriginalUnitId) {
			_setOriginalUnitId = true;

			_originalUnitId = _unitId;
		}

		_unitId = unitId;
	}

	public long getOriginalUnitId() {
		return _originalUnitId;
	}

	@JSON
	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_columnBitmask |= DEPARTMENTID_COLUMN_BITMASK;

		if (!_setOriginalDepartmentId) {
			_setOriginalDepartmentId = true;

			_originalDepartmentId = _departmentId;
		}

		_departmentId = departmentId;
	}

	public long getOriginalDepartmentId() {
		return _originalDepartmentId;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Titles.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Titles toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Titles)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TitlesImpl titlesImpl = new TitlesImpl();

		titlesImpl.setTitlesId(getTitlesId());
		titlesImpl.setName(getName());
		titlesImpl.setUnitGroupId(getUnitGroupId());
		titlesImpl.setUnitId(getUnitId());
		titlesImpl.setDepartmentId(getDepartmentId());
		titlesImpl.setGroupId(getGroupId());
		titlesImpl.setCompanyId(getCompanyId());
		titlesImpl.setUserId(getUserId());
		titlesImpl.setCreateDate(getCreateDate());
		titlesImpl.setModifiedDate(getModifiedDate());

		titlesImpl.resetOriginalValues();

		return titlesImpl;
	}

	@Override
	public int compareTo(Titles titles) {
		long primaryKey = titles.getPrimaryKey();

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

		if (!(obj instanceof Titles)) {
			return false;
		}

		Titles titles = (Titles)obj;

		long primaryKey = titles.getPrimaryKey();

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
		TitlesModelImpl titlesModelImpl = this;

		titlesModelImpl._originalName = titlesModelImpl._name;

		titlesModelImpl._originalUnitGroupId = titlesModelImpl._unitGroupId;

		titlesModelImpl._setOriginalUnitGroupId = false;

		titlesModelImpl._originalUnitId = titlesModelImpl._unitId;

		titlesModelImpl._setOriginalUnitId = false;

		titlesModelImpl._originalDepartmentId = titlesModelImpl._departmentId;

		titlesModelImpl._setOriginalDepartmentId = false;

		titlesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Titles> toCacheModel() {
		TitlesCacheModel titlesCacheModel = new TitlesCacheModel();

		titlesCacheModel.titlesId = getTitlesId();

		titlesCacheModel.name = getName();

		String name = titlesCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			titlesCacheModel.name = null;
		}

		titlesCacheModel.unitGroupId = getUnitGroupId();

		titlesCacheModel.unitId = getUnitId();

		titlesCacheModel.departmentId = getDepartmentId();

		titlesCacheModel.groupId = getGroupId();

		titlesCacheModel.companyId = getCompanyId();

		titlesCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			titlesCacheModel.createDate = createDate.getTime();
		}
		else {
			titlesCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			titlesCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			titlesCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return titlesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{titlesId=");
		sb.append(getTitlesId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", unitGroupId=");
		sb.append(getUnitGroupId());
		sb.append(", unitId=");
		sb.append(getUnitId());
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.Titles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>titlesId</column-name><column-value><![CDATA[");
		sb.append(getTitlesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitGroupId</column-name><column-value><![CDATA[");
		sb.append(getUnitGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>unitId</column-name><column-value><![CDATA[");
		sb.append(getUnitId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
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

	private static ClassLoader _classLoader = Titles.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Titles.class };
	private long _titlesId;
	private String _name;
	private String _originalName;
	private long _unitGroupId;
	private long _originalUnitGroupId;
	private boolean _setOriginalUnitGroupId;
	private long _unitId;
	private long _originalUnitId;
	private boolean _setOriginalUnitId;
	private long _departmentId;
	private long _originalDepartmentId;
	private boolean _setOriginalDepartmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private Titles _escapedModel;
}