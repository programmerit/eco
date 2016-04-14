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

package vn.com.ecopharma.emp.service;

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

import vn.com.ecopharma.emp.model.CertificateClp;
import vn.com.ecopharma.emp.model.DepartmentClp;
import vn.com.ecopharma.emp.model.DevisionClp;
import vn.com.ecopharma.emp.model.DistrictClp;
import vn.com.ecopharma.emp.model.DocumentClp;
import vn.com.ecopharma.emp.model.EmpActionHistoryClp;
import vn.com.ecopharma.emp.model.EmpAnnualLeaveClp;
import vn.com.ecopharma.emp.model.EmpBankInfoClp;
import vn.com.ecopharma.emp.model.EmpClp;
import vn.com.ecopharma.emp.model.EmpConcurrentTitlesClp;
import vn.com.ecopharma.emp.model.EmpDisciplineClp;
import vn.com.ecopharma.emp.model.EmpLaborContractClp;
import vn.com.ecopharma.emp.model.EmpNotifyEmailClp;
import vn.com.ecopharma.emp.model.EmpOrgRelationshipClp;
import vn.com.ecopharma.emp.model.EmployeeTitlesHistoryClp;
import vn.com.ecopharma.emp.model.LevelClp;
import vn.com.ecopharma.emp.model.LocationClp;
import vn.com.ecopharma.emp.model.PromotedHistoryClp;
import vn.com.ecopharma.emp.model.ResignationHistoryClp;
import vn.com.ecopharma.emp.model.ResourceConfigClp;
import vn.com.ecopharma.emp.model.SpecializedClp;
import vn.com.ecopharma.emp.model.TitlesClp;
import vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroupClp;
import vn.com.ecopharma.emp.model.UnitClp;
import vn.com.ecopharma.emp.model.UnitGroupClp;
import vn.com.ecopharma.emp.model.UniversityClp;
import vn.com.ecopharma.emp.model.VacationLeaveClp;
import vn.com.ecopharma.emp.model.WorkingLocationClp;

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
						"ECO_EmployeeManagement-portlet-deployment-context");

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
							"ECO_EmployeeManagement-portlet-deployment-context");

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
				_servletContextName = "ECO_EmployeeManagement-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CertificateClp.class.getName())) {
			return translateInputCertificate(oldModel);
		}

		if (oldModelClassName.equals(DepartmentClp.class.getName())) {
			return translateInputDepartment(oldModel);
		}

		if (oldModelClassName.equals(DevisionClp.class.getName())) {
			return translateInputDevision(oldModel);
		}

		if (oldModelClassName.equals(DistrictClp.class.getName())) {
			return translateInputDistrict(oldModel);
		}

		if (oldModelClassName.equals(DocumentClp.class.getName())) {
			return translateInputDocument(oldModel);
		}

		if (oldModelClassName.equals(EmpClp.class.getName())) {
			return translateInputEmp(oldModel);
		}

		if (oldModelClassName.equals(EmpActionHistoryClp.class.getName())) {
			return translateInputEmpActionHistory(oldModel);
		}

		if (oldModelClassName.equals(EmpAnnualLeaveClp.class.getName())) {
			return translateInputEmpAnnualLeave(oldModel);
		}

		if (oldModelClassName.equals(EmpBankInfoClp.class.getName())) {
			return translateInputEmpBankInfo(oldModel);
		}

		if (oldModelClassName.equals(EmpConcurrentTitlesClp.class.getName())) {
			return translateInputEmpConcurrentTitles(oldModel);
		}

		if (oldModelClassName.equals(EmpDisciplineClp.class.getName())) {
			return translateInputEmpDiscipline(oldModel);
		}

		if (oldModelClassName.equals(EmpLaborContractClp.class.getName())) {
			return translateInputEmpLaborContract(oldModel);
		}

		if (oldModelClassName.equals(EmployeeTitlesHistoryClp.class.getName())) {
			return translateInputEmployeeTitlesHistory(oldModel);
		}

		if (oldModelClassName.equals(EmpNotifyEmailClp.class.getName())) {
			return translateInputEmpNotifyEmail(oldModel);
		}

		if (oldModelClassName.equals(EmpOrgRelationshipClp.class.getName())) {
			return translateInputEmpOrgRelationship(oldModel);
		}

		if (oldModelClassName.equals(LevelClp.class.getName())) {
			return translateInputLevel(oldModel);
		}

		if (oldModelClassName.equals(LocationClp.class.getName())) {
			return translateInputLocation(oldModel);
		}

		if (oldModelClassName.equals(PromotedHistoryClp.class.getName())) {
			return translateInputPromotedHistory(oldModel);
		}

		if (oldModelClassName.equals(ResignationHistoryClp.class.getName())) {
			return translateInputResignationHistory(oldModel);
		}

		if (oldModelClassName.equals(ResourceConfigClp.class.getName())) {
			return translateInputResourceConfig(oldModel);
		}

		if (oldModelClassName.equals(SpecializedClp.class.getName())) {
			return translateInputSpecialized(oldModel);
		}

		if (oldModelClassName.equals(TitlesClp.class.getName())) {
			return translateInputTitles(oldModel);
		}

		if (oldModelClassName.equals(
					TitlesDepartmentUnitUnitGroupClp.class.getName())) {
			return translateInputTitlesDepartmentUnitUnitGroup(oldModel);
		}

		if (oldModelClassName.equals(UnitClp.class.getName())) {
			return translateInputUnit(oldModel);
		}

		if (oldModelClassName.equals(UnitGroupClp.class.getName())) {
			return translateInputUnitGroup(oldModel);
		}

		if (oldModelClassName.equals(UniversityClp.class.getName())) {
			return translateInputUniversity(oldModel);
		}

		if (oldModelClassName.equals(VacationLeaveClp.class.getName())) {
			return translateInputVacationLeave(oldModel);
		}

		if (oldModelClassName.equals(WorkingLocationClp.class.getName())) {
			return translateInputWorkingLocation(oldModel);
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

	public static Object translateInputCertificate(BaseModel<?> oldModel) {
		CertificateClp oldClpModel = (CertificateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCertificateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDepartment(BaseModel<?> oldModel) {
		DepartmentClp oldClpModel = (DepartmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDepartmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDevision(BaseModel<?> oldModel) {
		DevisionClp oldClpModel = (DevisionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDevisionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDistrict(BaseModel<?> oldModel) {
		DistrictClp oldClpModel = (DistrictClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDistrictRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDocument(BaseModel<?> oldModel) {
		DocumentClp oldClpModel = (DocumentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDocumentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmp(BaseModel<?> oldModel) {
		EmpClp oldClpModel = (EmpClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpActionHistory(BaseModel<?> oldModel) {
		EmpActionHistoryClp oldClpModel = (EmpActionHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpActionHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpAnnualLeave(BaseModel<?> oldModel) {
		EmpAnnualLeaveClp oldClpModel = (EmpAnnualLeaveClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpAnnualLeaveRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpBankInfo(BaseModel<?> oldModel) {
		EmpBankInfoClp oldClpModel = (EmpBankInfoClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpBankInfoRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpConcurrentTitles(
		BaseModel<?> oldModel) {
		EmpConcurrentTitlesClp oldClpModel = (EmpConcurrentTitlesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpConcurrentTitlesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpDiscipline(BaseModel<?> oldModel) {
		EmpDisciplineClp oldClpModel = (EmpDisciplineClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpDisciplineRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpLaborContract(BaseModel<?> oldModel) {
		EmpLaborContractClp oldClpModel = (EmpLaborContractClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpLaborContractRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmployeeTitlesHistory(
		BaseModel<?> oldModel) {
		EmployeeTitlesHistoryClp oldClpModel = (EmployeeTitlesHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmployeeTitlesHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpNotifyEmail(BaseModel<?> oldModel) {
		EmpNotifyEmailClp oldClpModel = (EmpNotifyEmailClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpNotifyEmailRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputEmpOrgRelationship(BaseModel<?> oldModel) {
		EmpOrgRelationshipClp oldClpModel = (EmpOrgRelationshipClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getEmpOrgRelationshipRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLevel(BaseModel<?> oldModel) {
		LevelClp oldClpModel = (LevelClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLevelRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputLocation(BaseModel<?> oldModel) {
		LocationClp oldClpModel = (LocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getLocationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPromotedHistory(BaseModel<?> oldModel) {
		PromotedHistoryClp oldClpModel = (PromotedHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPromotedHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResignationHistory(BaseModel<?> oldModel) {
		ResignationHistoryClp oldClpModel = (ResignationHistoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getResignationHistoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputResourceConfig(BaseModel<?> oldModel) {
		ResourceConfigClp oldClpModel = (ResourceConfigClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getResourceConfigRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSpecialized(BaseModel<?> oldModel) {
		SpecializedClp oldClpModel = (SpecializedClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSpecializedRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTitles(BaseModel<?> oldModel) {
		TitlesClp oldClpModel = (TitlesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTitlesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTitlesDepartmentUnitUnitGroup(
		BaseModel<?> oldModel) {
		TitlesDepartmentUnitUnitGroupClp oldClpModel = (TitlesDepartmentUnitUnitGroupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTitlesDepartmentUnitUnitGroupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUnit(BaseModel<?> oldModel) {
		UnitClp oldClpModel = (UnitClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUnitRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUnitGroup(BaseModel<?> oldModel) {
		UnitGroupClp oldClpModel = (UnitGroupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUnitGroupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUniversity(BaseModel<?> oldModel) {
		UniversityClp oldClpModel = (UniversityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUniversityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputVacationLeave(BaseModel<?> oldModel) {
		VacationLeaveClp oldClpModel = (VacationLeaveClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getVacationLeaveRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkingLocation(BaseModel<?> oldModel) {
		WorkingLocationClp oldClpModel = (WorkingLocationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkingLocationRemoteModel();

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
					"vn.com.ecopharma.emp.model.impl.CertificateImpl")) {
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
					"vn.com.ecopharma.emp.model.impl.DepartmentImpl")) {
			return translateOutputDepartment(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.DevisionImpl")) {
			return translateOutputDevision(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.DistrictImpl")) {
			return translateOutputDistrict(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.DocumentImpl")) {
			return translateOutputDocument(oldModel);
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

		if (oldModelClassName.equals("vn.com.ecopharma.emp.model.impl.EmpImpl")) {
			return translateOutputEmp(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpActionHistoryImpl")) {
			return translateOutputEmpActionHistory(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpAnnualLeaveImpl")) {
			return translateOutputEmpAnnualLeave(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpBankInfoImpl")) {
			return translateOutputEmpBankInfo(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpConcurrentTitlesImpl")) {
			return translateOutputEmpConcurrentTitles(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpDisciplineImpl")) {
			return translateOutputEmpDiscipline(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpLaborContractImpl")) {
			return translateOutputEmpLaborContract(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmployeeTitlesHistoryImpl")) {
			return translateOutputEmployeeTitlesHistory(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpNotifyEmailImpl")) {
			return translateOutputEmpNotifyEmail(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.EmpOrgRelationshipImpl")) {
			return translateOutputEmpOrgRelationship(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.LevelImpl")) {
			return translateOutputLevel(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.LocationImpl")) {
			return translateOutputLocation(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.PromotedHistoryImpl")) {
			return translateOutputPromotedHistory(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.ResignationHistoryImpl")) {
			return translateOutputResignationHistory(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.ResourceConfigImpl")) {
			return translateOutputResourceConfig(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.SpecializedImpl")) {
			return translateOutputSpecialized(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.TitlesImpl")) {
			return translateOutputTitles(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.TitlesDepartmentUnitUnitGroupImpl")) {
			return translateOutputTitlesDepartmentUnitUnitGroup(oldModel);
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

		if (oldModelClassName.equals("vn.com.ecopharma.emp.model.impl.UnitImpl")) {
			return translateOutputUnit(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.UnitGroupImpl")) {
			return translateOutputUnitGroup(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.UniversityImpl")) {
			return translateOutputUniversity(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.VacationLeaveImpl")) {
			return translateOutputVacationLeave(oldModel);
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
					"vn.com.ecopharma.emp.model.impl.WorkingLocationImpl")) {
			return translateOutputWorkingLocation(oldModel);
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

		if (className.equals("vn.com.ecopharma.emp.NoSuchCertificateException")) {
			return new vn.com.ecopharma.emp.NoSuchCertificateException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchDepartmentException")) {
			return new vn.com.ecopharma.emp.NoSuchDepartmentException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchDevisionException")) {
			return new vn.com.ecopharma.emp.NoSuchDevisionException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchDistrictException")) {
			return new vn.com.ecopharma.emp.NoSuchDistrictException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchDocumentException")) {
			return new vn.com.ecopharma.emp.NoSuchDocumentException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchEmpException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpActionHistoryException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpActionHistoryException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpAnnualLeaveException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchEmpBankInfoException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpBankInfoException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpConcurrentTitlesException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpDisciplineException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpDisciplineException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpLaborContractException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpLaborContractException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException")) {
			return new vn.com.ecopharma.emp.NoSuchEmployeeTitlesHistoryException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpNotifyEmailException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException")) {
			return new vn.com.ecopharma.emp.NoSuchEmpOrgRelationshipException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchLevelException")) {
			return new vn.com.ecopharma.emp.NoSuchLevelException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchLocationException")) {
			return new vn.com.ecopharma.emp.NoSuchLocationException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchPromotedHistoryException")) {
			return new vn.com.ecopharma.emp.NoSuchPromotedHistoryException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchResignationHistoryException")) {
			return new vn.com.ecopharma.emp.NoSuchResignationHistoryException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchResourceConfigException")) {
			return new vn.com.ecopharma.emp.NoSuchResourceConfigException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchSpecializedException")) {
			return new vn.com.ecopharma.emp.NoSuchSpecializedException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchTitlesException")) {
			return new vn.com.ecopharma.emp.NoSuchTitlesException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException")) {
			return new vn.com.ecopharma.emp.NoSuchTitlesDepartmentUnitUnitGroupException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchUnitException")) {
			return new vn.com.ecopharma.emp.NoSuchUnitException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchUnitGroupException")) {
			return new vn.com.ecopharma.emp.NoSuchUnitGroupException();
		}

		if (className.equals("vn.com.ecopharma.emp.NoSuchUniversityException")) {
			return new vn.com.ecopharma.emp.NoSuchUniversityException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchVacationLeaveException")) {
			return new vn.com.ecopharma.emp.NoSuchVacationLeaveException();
		}

		if (className.equals(
					"vn.com.ecopharma.emp.NoSuchWorkingLocationException")) {
			return new vn.com.ecopharma.emp.NoSuchWorkingLocationException();
		}

		return throwable;
	}

	public static Object translateOutputCertificate(BaseModel<?> oldModel) {
		CertificateClp newModel = new CertificateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCertificateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDepartment(BaseModel<?> oldModel) {
		DepartmentClp newModel = new DepartmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDepartmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDevision(BaseModel<?> oldModel) {
		DevisionClp newModel = new DevisionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDevisionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDistrict(BaseModel<?> oldModel) {
		DistrictClp newModel = new DistrictClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDistrictRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDocument(BaseModel<?> oldModel) {
		DocumentClp newModel = new DocumentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDocumentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmp(BaseModel<?> oldModel) {
		EmpClp newModel = new EmpClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpActionHistory(BaseModel<?> oldModel) {
		EmpActionHistoryClp newModel = new EmpActionHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpActionHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpAnnualLeave(BaseModel<?> oldModel) {
		EmpAnnualLeaveClp newModel = new EmpAnnualLeaveClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpAnnualLeaveRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpBankInfo(BaseModel<?> oldModel) {
		EmpBankInfoClp newModel = new EmpBankInfoClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpBankInfoRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpConcurrentTitles(
		BaseModel<?> oldModel) {
		EmpConcurrentTitlesClp newModel = new EmpConcurrentTitlesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpConcurrentTitlesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpDiscipline(BaseModel<?> oldModel) {
		EmpDisciplineClp newModel = new EmpDisciplineClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpDisciplineRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpLaborContract(BaseModel<?> oldModel) {
		EmpLaborContractClp newModel = new EmpLaborContractClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpLaborContractRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmployeeTitlesHistory(
		BaseModel<?> oldModel) {
		EmployeeTitlesHistoryClp newModel = new EmployeeTitlesHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmployeeTitlesHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpNotifyEmail(BaseModel<?> oldModel) {
		EmpNotifyEmailClp newModel = new EmpNotifyEmailClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpNotifyEmailRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputEmpOrgRelationship(
		BaseModel<?> oldModel) {
		EmpOrgRelationshipClp newModel = new EmpOrgRelationshipClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setEmpOrgRelationshipRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLevel(BaseModel<?> oldModel) {
		LevelClp newModel = new LevelClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLevelRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputLocation(BaseModel<?> oldModel) {
		LocationClp newModel = new LocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setLocationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPromotedHistory(BaseModel<?> oldModel) {
		PromotedHistoryClp newModel = new PromotedHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPromotedHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResignationHistory(
		BaseModel<?> oldModel) {
		ResignationHistoryClp newModel = new ResignationHistoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setResignationHistoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputResourceConfig(BaseModel<?> oldModel) {
		ResourceConfigClp newModel = new ResourceConfigClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setResourceConfigRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSpecialized(BaseModel<?> oldModel) {
		SpecializedClp newModel = new SpecializedClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSpecializedRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTitles(BaseModel<?> oldModel) {
		TitlesClp newModel = new TitlesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTitlesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTitlesDepartmentUnitUnitGroup(
		BaseModel<?> oldModel) {
		TitlesDepartmentUnitUnitGroupClp newModel = new TitlesDepartmentUnitUnitGroupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTitlesDepartmentUnitUnitGroupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUnit(BaseModel<?> oldModel) {
		UnitClp newModel = new UnitClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUnitRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUnitGroup(BaseModel<?> oldModel) {
		UnitGroupClp newModel = new UnitGroupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUnitGroupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUniversity(BaseModel<?> oldModel) {
		UniversityClp newModel = new UniversityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUniversityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputVacationLeave(BaseModel<?> oldModel) {
		VacationLeaveClp newModel = new VacationLeaveClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setVacationLeaveRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkingLocation(BaseModel<?> oldModel) {
		WorkingLocationClp newModel = new WorkingLocationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkingLocationRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}