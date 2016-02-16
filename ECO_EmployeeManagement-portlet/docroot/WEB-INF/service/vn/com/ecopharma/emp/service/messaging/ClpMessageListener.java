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

package vn.com.ecopharma.emp.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import vn.com.ecopharma.emp.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.emp.service.CertificateServiceUtil;
import vn.com.ecopharma.emp.service.ClpSerializer;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DepartmentServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionServiceUtil;
import vn.com.ecopharma.emp.service.DistrictLocalServiceUtil;
import vn.com.ecopharma.emp.service.DistrictServiceUtil;
import vn.com.ecopharma.emp.service.EmpBankInfoLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpBankInfoServiceUtil;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpDisciplineServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpNotifyEmailServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpOrgRelationshipServiceUtil;
import vn.com.ecopharma.emp.service.EmpServiceUtil;
import vn.com.ecopharma.emp.service.EmployeeTitlesHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmployeeTitlesHistoryServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelServiceUtil;
import vn.com.ecopharma.emp.service.LocationLocalServiceUtil;
import vn.com.ecopharma.emp.service.LocationServiceUtil;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.PromotedHistoryServiceUtil;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResignationHistoryServiceUtil;
import vn.com.ecopharma.emp.service.ResourceConfigLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResourceConfigServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedServiceUtil;
import vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityServiceUtil;
import vn.com.ecopharma.emp.service.WorkingLocationLocalServiceUtil;
import vn.com.ecopharma.emp.service.WorkingLocationServiceUtil;

/**
 * @author tvt
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			CertificateLocalServiceUtil.clearService();

			CertificateServiceUtil.clearService();
			DepartmentLocalServiceUtil.clearService();

			DepartmentServiceUtil.clearService();
			DevisionLocalServiceUtil.clearService();

			DevisionServiceUtil.clearService();
			DistrictLocalServiceUtil.clearService();

			DistrictServiceUtil.clearService();
			EmpLocalServiceUtil.clearService();

			EmpServiceUtil.clearService();
			EmpBankInfoLocalServiceUtil.clearService();

			EmpBankInfoServiceUtil.clearService();
			EmpDisciplineLocalServiceUtil.clearService();

			EmpDisciplineServiceUtil.clearService();
			EmployeeTitlesHistoryLocalServiceUtil.clearService();

			EmployeeTitlesHistoryServiceUtil.clearService();
			EmpNotifyEmailLocalServiceUtil.clearService();

			EmpNotifyEmailServiceUtil.clearService();
			EmpOrgRelationshipLocalServiceUtil.clearService();

			EmpOrgRelationshipServiceUtil.clearService();
			LevelLocalServiceUtil.clearService();

			LevelServiceUtil.clearService();
			LocationLocalServiceUtil.clearService();

			LocationServiceUtil.clearService();
			PromotedHistoryLocalServiceUtil.clearService();

			PromotedHistoryServiceUtil.clearService();
			ResignationHistoryLocalServiceUtil.clearService();

			ResignationHistoryServiceUtil.clearService();
			ResourceConfigLocalServiceUtil.clearService();

			ResourceConfigServiceUtil.clearService();
			SpecializedLocalServiceUtil.clearService();

			SpecializedServiceUtil.clearService();
			TitlesLocalServiceUtil.clearService();

			TitlesServiceUtil.clearService();
			TitlesDepartmentUnitUnitGroupLocalServiceUtil.clearService();

			TitlesDepartmentUnitUnitGroupServiceUtil.clearService();
			UnitLocalServiceUtil.clearService();

			UnitServiceUtil.clearService();
			UnitGroupLocalServiceUtil.clearService();

			UnitGroupServiceUtil.clearService();
			UniversityLocalServiceUtil.clearService();

			UniversityServiceUtil.clearService();
			WorkingLocationLocalServiceUtil.clearService();

			WorkingLocationServiceUtil.clearService();
		}
	}
}