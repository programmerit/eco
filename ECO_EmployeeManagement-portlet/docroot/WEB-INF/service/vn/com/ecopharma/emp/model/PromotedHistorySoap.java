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

package vn.com.ecopharma.emp.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.PromotedHistoryServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.PromotedHistoryServiceSoap
 * @generated
 */
public class PromotedHistorySoap implements Serializable {
	public static PromotedHistorySoap toSoapModel(PromotedHistory model) {
		PromotedHistorySoap soapModel = new PromotedHistorySoap();

		soapModel.setPromotedHistoryId(model.getPromotedHistoryId());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setOldTitlesId(model.getOldTitlesId());
		soapModel.setNewTitlesId(model.getNewTitlesId());
		soapModel.setPromotedDate(model.getPromotedDate());
		soapModel.setComment(model.getComment());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDeleted(model.getDeleted());

		return soapModel;
	}

	public static PromotedHistorySoap[] toSoapModels(PromotedHistory[] models) {
		PromotedHistorySoap[] soapModels = new PromotedHistorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PromotedHistorySoap[][] toSoapModels(
		PromotedHistory[][] models) {
		PromotedHistorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PromotedHistorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new PromotedHistorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PromotedHistorySoap[] toSoapModels(
		List<PromotedHistory> models) {
		List<PromotedHistorySoap> soapModels = new ArrayList<PromotedHistorySoap>(models.size());

		for (PromotedHistory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PromotedHistorySoap[soapModels.size()]);
	}

	public PromotedHistorySoap() {
	}

	public long getPrimaryKey() {
		return _promotedHistoryId;
	}

	public void setPrimaryKey(long pk) {
		setPromotedHistoryId(pk);
	}

	public long getPromotedHistoryId() {
		return _promotedHistoryId;
	}

	public void setPromotedHistoryId(long promotedHistoryId) {
		_promotedHistoryId = promotedHistoryId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	public long getOldTitlesId() {
		return _oldTitlesId;
	}

	public void setOldTitlesId(long oldTitlesId) {
		_oldTitlesId = oldTitlesId;
	}

	public long getNewTitlesId() {
		return _newTitlesId;
	}

	public void setNewTitlesId(long newTitlesId) {
		_newTitlesId = newTitlesId;
	}

	public Date getPromotedDate() {
		return _promotedDate;
	}

	public void setPromotedDate(Date promotedDate) {
		_promotedDate = promotedDate;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public boolean getDeleted() {
		return _deleted;
	}

	public boolean isDeleted() {
		return _deleted;
	}

	public void setDeleted(boolean deleted) {
		_deleted = deleted;
	}

	private long _promotedHistoryId;
	private long _employeeId;
	private long _oldTitlesId;
	private long _newTitlesId;
	private Date _promotedDate;
	private String _comment;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _deleted;
}