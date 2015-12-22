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

package vn.com.ecopharma.hrm.rc.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.hrm.rc.model.Certificate;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;

/**
 * @author tvt
 * @generated
 */
public abstract class CertificateActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CertificateActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CertificateLocalServiceUtil.getService());
		setClass(Certificate.class);

		setClassLoader(vn.com.ecopharma.hrm.rc.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("certificateId");
	}
}