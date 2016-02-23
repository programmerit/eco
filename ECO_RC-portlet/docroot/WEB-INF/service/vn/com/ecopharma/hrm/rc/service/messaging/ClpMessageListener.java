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

package vn.com.ecopharma.hrm.rc.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateActionHistoryServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateEvaluationServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CandidateServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CertificateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.CertificateServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ClpSerializer;
import vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaKeyValueServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EvaluationCriteriaServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ExperienceLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.ExperienceServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewServiceUtil;
import vn.com.ecopharma.hrm.rc.service.SkillServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyEvaluationCriteriaServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyServiceUtil;

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
			CandidateLocalServiceUtil.clearService();

			CandidateServiceUtil.clearService();
			CandidateActionHistoryLocalServiceUtil.clearService();

			CandidateActionHistoryServiceUtil.clearService();
			CandidateEvaluationLocalServiceUtil.clearService();

			CandidateEvaluationServiceUtil.clearService();
			CertificateLocalServiceUtil.clearService();

			CertificateServiceUtil.clearService();
			EmployeeInterviewScheduleLocalServiceUtil.clearService();

			EmployeeInterviewScheduleServiceUtil.clearService();
			EvaluationCriteriaLocalServiceUtil.clearService();

			EvaluationCriteriaServiceUtil.clearService();
			EvaluationCriteriaKeyValueLocalServiceUtil.clearService();

			EvaluationCriteriaKeyValueServiceUtil.clearService();
			ExperienceLocalServiceUtil.clearService();

			ExperienceServiceUtil.clearService();
			InterviewLocalServiceUtil.clearService();

			InterviewServiceUtil.clearService();
			InterviewScheduleLocalServiceUtil.clearService();

			InterviewScheduleServiceUtil.clearService();

			SkillServiceUtil.clearService();
			VacancyLocalServiceUtil.clearService();

			VacancyServiceUtil.clearService();
			VacancyCandidateLocalServiceUtil.clearService();

			VacancyCandidateServiceUtil.clearService();
			VacancyEvaluationCriteriaLocalServiceUtil.clearService();

			VacancyEvaluationCriteriaServiceUtil.clearService();
		}
	}
}