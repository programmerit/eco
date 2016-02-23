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

package vn.com.ecopharma.hrm.rc.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import vn.com.ecopharma.hrm.rc.model.CandidateActionHistoryClp;
import vn.com.ecopharma.hrm.rc.model.CandidateClp;
import vn.com.ecopharma.hrm.rc.model.CandidateEvaluationClp;
import vn.com.ecopharma.hrm.rc.model.CertificateClp;
import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewScheduleClp;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaClp;
import vn.com.ecopharma.hrm.rc.model.EvaluationCriteriaKeyValueClp;
import vn.com.ecopharma.hrm.rc.model.ExperienceClp;
import vn.com.ecopharma.hrm.rc.model.InterviewClp;
import vn.com.ecopharma.hrm.rc.model.InterviewScheduleClp;
import vn.com.ecopharma.hrm.rc.model.SkillClp;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidateClp;
import vn.com.ecopharma.hrm.rc.model.VacancyClp;
import vn.com.ecopharma.hrm.rc.model.VacancyEvaluationCriteriaClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tvt
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"ECO_RC-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"ECO_RC-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "ECO_RC-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CandidateClp.class.getName())) {
			return translateInputCandidate(oldModel);
		}

		if (oldModelClassName.equals(CandidateActionHistoryClp.class.getName())) {
			return translateInputCandidateActionHistory(oldModel);
		}

		if (oldModelClassName.equals(CandidateEvaluationClp.class.getName())) {
			return translateInputCandidateEvaluation(oldModel);
		}

		if (oldModelClassName.equals(CertificateClp.class.getName())) {
			return translateInputCertificate(oldModel);
		}

		if (oldModelClassName.equals(
					EmployeeInterviewScheduleClp.class.getName())) {
			return translateInputEmployeeInterviewSchedule(oldModel);
		}

		if (oldModelClassName.equals(EvaluationCriteriaClp.class.getName())) {
			return translateInputEvaluationCriteria(oldModel);
		}

		if (oldModelClassName.equals(
					EvaluationCriteriaKeyValueClp.class.getName())) {
			return translateInputEvaluationCriteriaKeyValue(oldModel);
		}

		if (oldModelClassName.equals(ExperienceClp.class.getName())) {
			return translateInputExperience(oldModel);
		}

		if (oldModelClassName.equals(InterviewClp.class.getName())) {
			return translateInputInterview(oldModel);
		}

		if (oldModelClassName.equals(InterviewScheduleClp.class.getName())) {
			return translateInputInterviewSchedule(oldModel);
		}

		if (oldModelClassName.equals(SkillClp.class.getName())) {
			return translateInputSkill(oldModel);
		}

		if (oldModelClassName.equals(VacancyClp.class.getName())) {
			return translateInputVacancy(oldModel);
		}

		if (oldModelClassName.equals(VacancyCandidateClp.class.getName())) {
			return translateInputVacancyCandidate(oldModel);
		}

		if (oldModelClassName.equals(
					VacancyEvaluationCriteriaClp.class.getName())) {
			return translateInputVacancyEvaluationCriteria(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCandidate(BaseModel<?> oldModel) {
		CandidateClp oldClpModel = (CandidateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCandidateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCandidateActionHistory(
		BaseModel<?> oldModel) {
		CandidateActionHistoryClp oldClpModel = (CandidateActionHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCandidateActionHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCandidateEvaluation(
		BaseModel<?> oldModel) {
		CandidateEvaluationClp oldClpModel = (CandidateEvaluationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCandidateEvaluationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCertificate(BaseModel<?> oldModel) {
		CertificateClp oldClpModel = (CertificateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCertificateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmployeeInterviewSchedule(
		BaseModel<?> oldModel) {
		EmployeeInterviewScheduleClp oldClpModel = (EmployeeInterviewScheduleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmployeeInterviewScheduleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEvaluationCriteria(BaseModel<?> oldModel) {
		EvaluationCriteriaClp oldClpModel = (EvaluationCriteriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEvaluationCriteriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEvaluationCriteriaKeyValue(
		BaseModel<?> oldModel) {
		EvaluationCriteriaKeyValueClp oldClpModel = (EvaluationCriteriaKeyValueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEvaluationCriteriaKeyValueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputExperience(BaseModel<?> oldModel) {
		ExperienceClp oldClpModel = (ExperienceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getExperienceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInterview(BaseModel<?> oldModel) {
		InterviewClp oldClpModel = (InterviewClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInterviewRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputInterviewSchedule(BaseModel<?> oldModel) {
		InterviewScheduleClp oldClpModel = (InterviewScheduleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getInterviewScheduleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSkill(BaseModel<?> oldModel) {
		SkillClp oldClpModel = (SkillClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSkillRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVacancy(BaseModel<?> oldModel) {
		VacancyClp oldClpModel = (VacancyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVacancyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVacancyCandidate(BaseModel<?> oldModel) {
		VacancyCandidateClp oldClpModel = (VacancyCandidateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVacancyCandidateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVacancyEvaluationCriteria(
		BaseModel<?> oldModel) {
		VacancyEvaluationCriteriaClp oldClpModel = (VacancyEvaluationCriteriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVacancyEvaluationCriteriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.CandidateImpl")) {
			return translateOutputCandidate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.CandidateActionHistoryImpl")) {
			return translateOutputCandidateActionHistory(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.CandidateEvaluationImpl")) {
			return translateOutputCandidateEvaluation(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.CertificateImpl")) {
			return translateOutputCertificate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.EmployeeInterviewScheduleImpl")) {
			return translateOutputEmployeeInterviewSchedule(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaImpl")) {
			return translateOutputEvaluationCriteria(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.EvaluationCriteriaKeyValueImpl")) {
			return translateOutputEvaluationCriteriaKeyValue(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.ExperienceImpl")) {
			return translateOutputExperience(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.InterviewImpl")) {
			return translateOutputInterview(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.InterviewScheduleImpl")) {
			return translateOutputInterviewSchedule(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.SkillImpl")) {
			return translateOutputSkill(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.VacancyImpl")) {
			return translateOutputVacancy(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.VacancyCandidateImpl")) {
			return translateOutputVacancyCandidate(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		if (oldModelClassName.equals(
					"vn.com.ecopharma.hrm.rc.model.impl.VacancyEvaluationCriteriaImpl")) {
			return translateOutputVacancyEvaluationCriteria(oldModel);
		}
		else if (oldModelClassName.endsWith("Clp")) {
			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Method getClpSerializerClassMethod = oldModelClass.getMethod(
						"getClpSerializerClass");

				Class<?> oldClpSerializerClass = (Class<?>)getClpSerializerClassMethod.invoke(oldModel);

				Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

				Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
						BaseModel.class);

				Class<?> oldModelModelClass = oldModel.getModelClass();

				Method getRemoteModelMethod = oldModelClass.getMethod("get" +
						oldModelModelClass.getSimpleName() + "RemoteModel");

				Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

				BaseModel<?> newModel = (BaseModel<?>)translateOutputMethod.invoke(null,
						oldRemoteModel);

				return newModel;
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info("Unable to translate " + oldModelClassName, t);
				}
			}
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("vn.com.ecopharma.hrm.rc.NoSuchCandidateException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchCandidateException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchCandidateActionHistoryException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchCandidateEvaluationException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchCertificateException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchCertificateException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchEmployeeInterviewScheduleException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchEvaluationCriteriaKeyValueException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchExperienceException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchExperienceException();
		}

		if (className.equals("vn.com.ecopharma.hrm.rc.NoSuchInterviewException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchInterviewException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchInterviewScheduleException();
		}

		if (className.equals("vn.com.ecopharma.hrm.rc.NoSuchSkillException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchSkillException();
		}

		if (className.equals("vn.com.ecopharma.hrm.rc.NoSuchVacancyException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchVacancyException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchVacancyCandidateException();
		}

		if (className.equals(
					"vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException")) {
			return new vn.com.ecopharma.hrm.rc.NoSuchVacancyEvaluationCriteriaException();
		}

		return throwable;
	}

	public static Object translateOutputCandidate(BaseModel<?> oldModel) {
		CandidateClp newModel = new CandidateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCandidateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCandidateActionHistory(
		BaseModel<?> oldModel) {
		CandidateActionHistoryClp newModel = new CandidateActionHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCandidateActionHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCandidateEvaluation(
		BaseModel<?> oldModel) {
		CandidateEvaluationClp newModel = new CandidateEvaluationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCandidateEvaluationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCertificate(BaseModel<?> oldModel) {
		CertificateClp newModel = new CertificateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCertificateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmployeeInterviewSchedule(
		BaseModel<?> oldModel) {
		EmployeeInterviewScheduleClp newModel = new EmployeeInterviewScheduleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmployeeInterviewScheduleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEvaluationCriteria(
		BaseModel<?> oldModel) {
		EvaluationCriteriaClp newModel = new EvaluationCriteriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEvaluationCriteriaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEvaluationCriteriaKeyValue(
		BaseModel<?> oldModel) {
		EvaluationCriteriaKeyValueClp newModel = new EvaluationCriteriaKeyValueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEvaluationCriteriaKeyValueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputExperience(BaseModel<?> oldModel) {
		ExperienceClp newModel = new ExperienceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExperienceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInterview(BaseModel<?> oldModel) {
		InterviewClp newModel = new InterviewClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInterviewRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputInterviewSchedule(BaseModel<?> oldModel) {
		InterviewScheduleClp newModel = new InterviewScheduleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setInterviewScheduleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSkill(BaseModel<?> oldModel) {
		SkillClp newModel = new SkillClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSkillRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVacancy(BaseModel<?> oldModel) {
		VacancyClp newModel = new VacancyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVacancyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVacancyCandidate(BaseModel<?> oldModel) {
		VacancyCandidateClp newModel = new VacancyCandidateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVacancyCandidateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVacancyEvaluationCriteria(
		BaseModel<?> oldModel) {
		VacancyEvaluationCriteriaClp newModel = new VacancyEvaluationCriteriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVacancyEvaluationCriteriaRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}