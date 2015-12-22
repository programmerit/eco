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

package vn.com.ecopharma.hrm.rc.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import vn.com.ecopharma.hrm.rc.model.CandidateActionHistory;
import vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalServiceUtil;

/**
 * The extended model base implementation for the CandidateActionHistory service. Represents a row in the &quot;eco_rcp_CandidateActionHistory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CandidateActionHistoryImpl}.
 * </p>
 *
 * @author tvt
 * @see CandidateActionHistoryImpl
 * @see vn.com.ecopharma.hrm.rc.model.CandidateActionHistory
 * @generated
 */
public abstract class CandidateActionHistoryBaseImpl
	extends CandidateActionHistoryModelImpl implements CandidateActionHistory {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a candidate action history model instance should use the {@link CandidateActionHistory} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CandidateActionHistoryLocalServiceUtil.addCandidateActionHistory(this);
		}
		else {
			CandidateActionHistoryLocalServiceUtil.updateCandidateActionHistory(this);
		}
	}
}