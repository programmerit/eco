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

import vn.com.ecopharma.emp.model.EmpBankInfo;
import vn.com.ecopharma.emp.model.EmpBankInfoModel;
import vn.com.ecopharma.emp.model.EmpBankInfoSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the EmpBankInfo service. Represents a row in the &quot;eco_em_portlet_EmpBankInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link vn.com.ecopharma.emp.model.EmpBankInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EmpBankInfoImpl}.
 * </p>
 *
 * @author tvt
 * @see EmpBankInfoImpl
 * @see vn.com.ecopharma.emp.model.EmpBankInfo
 * @see vn.com.ecopharma.emp.model.EmpBankInfoModel
 * @generated
 */
@JSON(strict = true)
public class EmpBankInfoModelImpl extends BaseModelImpl<EmpBankInfo>
	implements EmpBankInfoModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a emp bank info model instance should use the {@link vn.com.ecopharma.emp.model.EmpBankInfo} interface instead.
	 */
	public static final String TABLE_NAME = "eco_em_portlet_EmpBankInfo";
	public static final Object[][] TABLE_COLUMNS = {
			{ "empBankInfoId", Types.BIGINT },
			{ "empId", Types.BIGINT },
			{ "bankAccountNo", Types.VARCHAR },
			{ "bankName", Types.VARCHAR },
			{ "branchName", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table eco_em_portlet_EmpBankInfo (empBankInfoId LONG not null primary key,empId LONG,bankAccountNo VARCHAR(75) null,bankName VARCHAR(75) null,branchName VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table eco_em_portlet_EmpBankInfo";
	public static final String ORDER_BY_JPQL = " ORDER BY empBankInfo.empBankInfoId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY eco_em_portlet_EmpBankInfo.empBankInfoId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.vn.com.ecopharma.emp.model.EmpBankInfo"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.vn.com.ecopharma.emp.model.EmpBankInfo"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static EmpBankInfo toModel(EmpBankInfoSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		EmpBankInfo model = new EmpBankInfoImpl();

		model.setEmpBankInfoId(soapModel.getEmpBankInfoId());
		model.setEmpId(soapModel.getEmpId());
		model.setBankAccountNo(soapModel.getBankAccountNo());
		model.setBankName(soapModel.getBankName());
		model.setBranchName(soapModel.getBranchName());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
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
	public static List<EmpBankInfo> toModels(EmpBankInfoSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<EmpBankInfo> models = new ArrayList<EmpBankInfo>(soapModels.length);

		for (EmpBankInfoSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.vn.com.ecopharma.emp.model.EmpBankInfo"));

	public EmpBankInfoModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _empBankInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setEmpBankInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _empBankInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return EmpBankInfo.class;
	}

	@Override
	public String getModelClassName() {
		return EmpBankInfo.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("empBankInfoId", getEmpBankInfoId());
		attributes.put("empId", getEmpId());
		attributes.put("bankAccountNo", getBankAccountNo());
		attributes.put("bankName", getBankName());
		attributes.put("branchName", getBranchName());
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
		Long empBankInfoId = (Long)attributes.get("empBankInfoId");

		if (empBankInfoId != null) {
			setEmpBankInfoId(empBankInfoId);
		}

		Long empId = (Long)attributes.get("empId");

		if (empId != null) {
			setEmpId(empId);
		}

		String bankAccountNo = (String)attributes.get("bankAccountNo");

		if (bankAccountNo != null) {
			setBankAccountNo(bankAccountNo);
		}

		String bankName = (String)attributes.get("bankName");

		if (bankName != null) {
			setBankName(bankName);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
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

	@JSON
	@Override
	public long getEmpBankInfoId() {
		return _empBankInfoId;
	}

	@Override
	public void setEmpBankInfoId(long empBankInfoId) {
		_empBankInfoId = empBankInfoId;
	}

	@JSON
	@Override
	public long getEmpId() {
		return _empId;
	}

	@Override
	public void setEmpId(long empId) {
		_empId = empId;
	}

	@JSON
	@Override
	public String getBankAccountNo() {
		if (_bankAccountNo == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankAccountNo;
		}
	}

	@Override
	public void setBankAccountNo(String bankAccountNo) {
		_bankAccountNo = bankAccountNo;
	}

	@JSON
	@Override
	public String getBankName() {
		if (_bankName == null) {
			return StringPool.BLANK;
		}
		else {
			return _bankName;
		}
	}

	@Override
	public void setBankName(String bankName) {
		_bankName = bankName;
	}

	@JSON
	@Override
	public String getBranchName() {
		if (_branchName == null) {
			return StringPool.BLANK;
		}
		else {
			return _branchName;
		}
	}

	@Override
	public void setBranchName(String branchName) {
		_branchName = branchName;
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			EmpBankInfo.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public EmpBankInfo toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (EmpBankInfo)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		EmpBankInfoImpl empBankInfoImpl = new EmpBankInfoImpl();

		empBankInfoImpl.setEmpBankInfoId(getEmpBankInfoId());
		empBankInfoImpl.setEmpId(getEmpId());
		empBankInfoImpl.setBankAccountNo(getBankAccountNo());
		empBankInfoImpl.setBankName(getBankName());
		empBankInfoImpl.setBranchName(getBranchName());
		empBankInfoImpl.setGroupId(getGroupId());
		empBankInfoImpl.setCompanyId(getCompanyId());
		empBankInfoImpl.setUserId(getUserId());
		empBankInfoImpl.setUserName(getUserName());
		empBankInfoImpl.setCreateDate(getCreateDate());
		empBankInfoImpl.setModifiedDate(getModifiedDate());

		empBankInfoImpl.resetOriginalValues();

		return empBankInfoImpl;
	}

	@Override
	public int compareTo(EmpBankInfo empBankInfo) {
		long primaryKey = empBankInfo.getPrimaryKey();

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

		if (!(obj instanceof EmpBankInfo)) {
			return false;
		}

		EmpBankInfo empBankInfo = (EmpBankInfo)obj;

		long primaryKey = empBankInfo.getPrimaryKey();

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
	}

	@Override
	public CacheModel<EmpBankInfo> toCacheModel() {
		EmpBankInfoCacheModel empBankInfoCacheModel = new EmpBankInfoCacheModel();

		empBankInfoCacheModel.empBankInfoId = getEmpBankInfoId();

		empBankInfoCacheModel.empId = getEmpId();

		empBankInfoCacheModel.bankAccountNo = getBankAccountNo();

		String bankAccountNo = empBankInfoCacheModel.bankAccountNo;

		if ((bankAccountNo != null) && (bankAccountNo.length() == 0)) {
			empBankInfoCacheModel.bankAccountNo = null;
		}

		empBankInfoCacheModel.bankName = getBankName();

		String bankName = empBankInfoCacheModel.bankName;

		if ((bankName != null) && (bankName.length() == 0)) {
			empBankInfoCacheModel.bankName = null;
		}

		empBankInfoCacheModel.branchName = getBranchName();

		String branchName = empBankInfoCacheModel.branchName;

		if ((branchName != null) && (branchName.length() == 0)) {
			empBankInfoCacheModel.branchName = null;
		}

		empBankInfoCacheModel.groupId = getGroupId();

		empBankInfoCacheModel.companyId = getCompanyId();

		empBankInfoCacheModel.userId = getUserId();

		empBankInfoCacheModel.userName = getUserName();

		String userName = empBankInfoCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			empBankInfoCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			empBankInfoCacheModel.createDate = createDate.getTime();
		}
		else {
			empBankInfoCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			empBankInfoCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			empBankInfoCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return empBankInfoCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{empBankInfoId=");
		sb.append(getEmpBankInfoId());
		sb.append(", empId=");
		sb.append(getEmpId());
		sb.append(", bankAccountNo=");
		sb.append(getBankAccountNo());
		sb.append(", bankName=");
		sb.append(getBankName());
		sb.append(", branchName=");
		sb.append(getBranchName());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("vn.com.ecopharma.emp.model.EmpBankInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>empBankInfoId</column-name><column-value><![CDATA[");
		sb.append(getEmpBankInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>empId</column-name><column-value><![CDATA[");
		sb.append(getEmpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankAccountNo</column-name><column-value><![CDATA[");
		sb.append(getBankAccountNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bankName</column-name><column-value><![CDATA[");
		sb.append(getBankName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>branchName</column-name><column-value><![CDATA[");
		sb.append(getBranchName());
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

	private static ClassLoader _classLoader = EmpBankInfo.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			EmpBankInfo.class
		};
	private long _empBankInfoId;
	private long _empId;
	private String _bankAccountNo;
	private String _bankName;
	private String _branchName;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private EmpBankInfo _escapedModel;
}