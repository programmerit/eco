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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link vn.com.ecopharma.emp.service.http.EmpNotifyEmailServiceSoap}.
 *
 * @author tvt
 * @see vn.com.ecopharma.emp.service.http.EmpNotifyEmailServiceSoap
 * @generated
 */
public class EmpNotifyEmailSoap implements Serializable {
	public static EmpNotifyEmailSoap toSoapModel(EmpNotifyEmail model) {
		EmpNotifyEmailSoap soapModel = new EmpNotifyEmailSoap();

		soapModel.setEmpNotifyEmailId(model.getEmpNotifyEmailId());
		soapModel.setEmpId(model.getEmpId());
		soapModel.setNotifyType(model.getNotifyType());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EmpNotifyEmailSoap[] toSoapModels(EmpNotifyEmail[] models) {
		EmpNotifyEmailSoap[] soapModels = new EmpNotifyEmailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpNotifyEmailSoap[][] toSoapModels(EmpNotifyEmail[][] models) {
		EmpNotifyEmailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpNotifyEmailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpNotifyEmailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpNotifyEmailSoap[] toSoapModels(List<EmpNotifyEmail> models) {
		List<EmpNotifyEmailSoap> soapModels = new ArrayList<EmpNotifyEmailSoap>(models.size());

		for (EmpNotifyEmail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpNotifyEmailSoap[soapModels.size()]);
	}

	public EmpNotifyEmailSoap() {
	}

	public long getPrimaryKey() {
		return _empNotifyEmailId;
	}

	public void setPrimaryKey(long pk) {
		setEmpNotifyEmailId(pk);
	}

	public long getEmpNotifyEmailId() {
		return _empNotifyEmailId;
	}

	public void setEmpNotifyEmailId(long empNotifyEmailId) {
		_empNotifyEmailId = empNotifyEmailId;
	}

	public long getEmpId() {
		return _empId;
	}

	public void setEmpId(long empId) {
		_empId = empId;
	}

	public String getNotifyType() {
		return _notifyType;
	}

	public void setNotifyType(String notifyType) {
		_notifyType = notifyType;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _empNotifyEmailId;
	private long _empId;
	private String _notifyType;
	private String _status;
}