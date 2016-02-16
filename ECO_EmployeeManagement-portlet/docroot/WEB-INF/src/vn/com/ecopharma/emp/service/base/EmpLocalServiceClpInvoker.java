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

package vn.com.ecopharma.emp.service.base;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class EmpLocalServiceClpInvoker {
	public EmpLocalServiceClpInvoker() {
		_methodName0 = "addEmp";

		_methodParameterTypes0 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName1 = "createEmp";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteEmp";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteEmp";

		_methodParameterTypes3 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchEmp";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getEmp";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getEmps";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getEmpsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateEmp";

		_methodParameterTypes15 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName162 = "getBeanIdentifier";

		_methodParameterTypes162 = new String[] {  };

		_methodName163 = "setBeanIdentifier";

		_methodParameterTypes163 = new String[] { "java.lang.String" };

		_methodName168 = "findAll";

		_methodParameterTypes168 = new String[] {  };

		_methodName169 = "findAll";

		_methodParameterTypes169 = new String[] { "int", "int" };

		_methodName170 = "findAll";

		_methodParameterTypes170 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName171 = "findByEmpCode";

		_methodParameterTypes171 = new String[] { "java.lang.String" };

		_methodName172 = "findByUser";

		_methodParameterTypes172 = new String[] { "long" };

		_methodName173 = "findByTitles";

		_methodParameterTypes173 = new String[] { "long" };

		_methodName174 = "findResignedEmp";

		_methodParameterTypes174 = new String[] {  };

		_methodName175 = "isOnAddingNewWithSameEmployeeCode";

		_methodParameterTypes175 = new String[] { "long", "java.lang.String" };

		_methodName176 = "countAllUnDeletedIndexedEmpDocuments";

		_methodParameterTypes176 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName177 = "searchAllUnDeletedEmpIndexedDocument";

		_methodParameterTypes177 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName178 = "countFilterEmployeeByFields";

		_methodParameterTypes178 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "java.lang.String",
				"org.primefaces.model.SortOrder", "long"
			};

		_methodName179 = "filterEmployeeByFields";

		_methodParameterTypes179 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "java.lang.String",
				"org.primefaces.model.SortOrder", "long", "int", "int"
			};

		_methodName186 = "addEmp";

		_methodParameterTypes186 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.util.Locale", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "boolean", "int", "int", "int",
				"long[][]", "long[][]", "long[][]", "long[][]", "boolean",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName187 = "addEmp";

		_methodParameterTypes187 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "java.util.Map",
				"java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName188 = "update";

		_methodParameterTypes188 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "long", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName189 = "update";

		_methodParameterTypes189 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName190 = "updateExistedEmployee";

		_methodParameterTypes190 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"long", "long", "long", "long", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.lang.String", "int", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "long", "java.lang.String", "java.lang.String",
				"java.util.Date", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "int",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName191 = "addOrUpdateWithExistUser";

		_methodParameterTypes191 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName192 = "addOrUpdateWithExistUser";

		_methodParameterTypes192 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName193 = "createEmployee";

		_methodParameterTypes193 = new String[] {
				"java.lang.String", "long", "long", "long", "long", "long",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "int", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "long", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName195 = "getViFullnameFromUser";

		_methodParameterTypes195 = new String[] { "com.liferay.portal.model.User" };

		_methodName196 = "updateEmpAddresses";

		_methodParameterTypes196 = new String[] {
				"java.lang.String", "java.lang.String",
				"vn.com.ecopharma.emp.model.District",
				"com.liferay.portal.model.Region", "long", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName197 = "removeAllExistingEmpAddresses";

		_methodParameterTypes197 = new String[] { "java.lang.String", "long" };

		_methodName198 = "removeAllExistingEmpAddresses";

		_methodParameterTypes198 = new String[] { "long", "long" };

		_methodName199 = "searchAllEmpDocs";

		_methodParameterTypes199 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long"
			};

		_methodName200 = "getIndexedEmp";

		_methodParameterTypes200 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName201 = "getIndexedEmp";

		_methodParameterTypes201 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName202 = "markDeletedEmp";

		_methodParameterTypes202 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName203 = "markDeletedEmp";

		_methodParameterTypes203 = new String[] { "long" };

		_methodName204 = "indexAllEmps";

		_methodParameterTypes204 = new String[] {  };

		_methodName205 = "indexSomeEmps";

		_methodParameterTypes205 = new String[] {  };

		_methodName206 = "removeAllEmpIndexes";

		_methodParameterTypes206 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName207 = "completelyRemoveAllEmp";

		_methodParameterTypes207 = new String[] { "long" };

		_methodName208 = "completelyRemoveAllEmpFromDB";

		_methodParameterTypes208 = new String[] { "long" };

		_methodName209 = "getUserEmployeeCodeValue";

		_methodParameterTypes209 = new String[] { "long", "long" };

		_methodName210 = "addOrUpdateUserEmployeeCodeValue";

		_methodParameterTypes210 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName211 = "isUserExisted";

		_methodParameterTypes211 = new String[] {
				"java.lang.String", "java.lang.String", "java.util.Date", "long"
			};

		_methodName212 = "isSameOrWrongOrderDoB";

		_methodParameterTypes212 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName213 = "regenerateDuplicateEmailAddress";

		_methodParameterTypes213 = new String[] {
				"java.lang.String", "int", "long"
			};

		_methodName214 = "findAllEmpAddress";

		_methodParameterTypes214 = new String[] { "long", "long" };

		_methodName215 = "getPresentAddress";

		_methodParameterTypes215 = new String[] { "long", "long" };

		_methodName216 = "getEmpsFromEmpNotifyEmails";

		_methodParameterTypes216 = new String[] { "java.util.List" };

		_methodName217 = "getUniqueDepartmentsFromEmps";

		_methodParameterTypes217 = new String[] { "java.util.List" };

		_methodName218 = "getAllManagerEmailsFromDepartments";

		_methodParameterTypes218 = new String[] { "java.util.Collection" };

		_methodName219 = "getUsersByEmps";

		_methodParameterTypes219 = new String[] { "java.util.Collection" };

		_methodName220 = "getEmailsFromUsers";

		_methodParameterTypes220 = new String[] { "java.util.Collection" };

		_methodName221 = "getEmailsFromEmps";

		_methodParameterTypes221 = new String[] { "java.util.Collection" };

		_methodName222 = "getEmpsByEmpOrgRelationships";

		_methodParameterTypes222 = new String[] { "java.util.List" };

		_methodName223 = "getManagerEmailsForNewEmpsNotification";

		_methodParameterTypes223 = new String[] { "java.util.List" };

		_methodName224 = "getNewEmployeesHtmlTable";

		_methodParameterTypes224 = new String[] { "java.util.List" };

		_methodName225 = "getEntireNewEmployeesHtmlMailContent";

		_methodParameterTypes225 = new String[] { "java.util.List" };

		_methodName226 = "sendNewEmpsNotificationEmail";

		_methodParameterTypes226 = new String[] { "java.util.List" };

		_methodName227 = "getNewEmpsAndSendNotifyEmail";

		_methodParameterTypes227 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return EmpLocalServiceUtil.createEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return EmpLocalServiceUtil.deleteEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return EmpLocalServiceUtil.deleteEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return EmpLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return EmpLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return EmpLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return EmpLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return EmpLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return EmpLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return EmpLocalServiceUtil.fetchEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return EmpLocalServiceUtil.getEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return EmpLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return EmpLocalServiceUtil.getEmps(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return EmpLocalServiceUtil.updateEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName162.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes162, parameterTypes)) {
			return EmpLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			EmpLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			return EmpLocalServiceUtil.findAll();
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			return EmpLocalServiceUtil.findByEmpCode((java.lang.String)arguments[0]);
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			return EmpLocalServiceUtil.findByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return EmpLocalServiceUtil.findByTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return EmpLocalServiceUtil.findResignedEmp();
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return EmpLocalServiceUtil.isOnAddingNewWithSameEmployeeCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return EmpLocalServiceUtil.countAllUnDeletedIndexedEmpDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllUnDeletedEmpIndexedDocument((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return EmpLocalServiceUtil.countFilterEmployeeByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(java.lang.String)arguments[2],
				(org.primefaces.model.SortOrder)arguments[3],
				((Long)arguments[4]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return EmpLocalServiceUtil.filterEmployeeByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(java.lang.String)arguments[2],
				(org.primefaces.model.SortOrder)arguments[3],
				((Long)arguments[4]).longValue(),
				((Integer)arguments[5]).intValue(),
				((Integer)arguments[6]).intValue());
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0],
				((Boolean)arguments[1]).booleanValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				((Boolean)arguments[4]).booleanValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				((Long)arguments[7]).longValue(),
				(java.lang.String)arguments[8], (java.util.Locale)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				(java.lang.String)arguments[12],
				((Integer)arguments[13]).intValue(),
				((Integer)arguments[14]).intValue(),
				((Boolean)arguments[15]).booleanValue(),
				((Integer)arguments[16]).intValue(),
				((Integer)arguments[17]).intValue(),
				((Integer)arguments[18]).intValue(), (long[])arguments[19],
				(long[])arguments[20], (long[])arguments[21],
				(long[])arguments[22], ((Boolean)arguments[23]).booleanValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[24],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[25],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[26],
				((Boolean)arguments[27]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[28]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[2],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[3],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[4],
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return EmpLocalServiceUtil.update((vn.com.ecopharma.emp.model.Emp)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return EmpLocalServiceUtil.update((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return EmpLocalServiceUtil.updateExistedEmployee((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(), (java.util.Date)arguments[7],
				(java.util.Date)arguments[8], (java.util.Date)arguments[9],
				(java.util.Date)arguments[10], (java.lang.String)arguments[11],
				((Integer)arguments[12]).intValue(),
				(java.util.Date)arguments[13], (java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				(java.lang.String)arguments[17],
				((Long)arguments[18]).longValue(),
				((Long)arguments[19]).longValue(),
				(java.lang.String)arguments[20],
				(java.lang.String)arguments[21], (java.util.Date)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				(java.lang.String)arguments[25],
				(java.lang.String)arguments[26],
				((Integer)arguments[27]).intValue(),
				(java.lang.String)arguments[28],
				(java.lang.String)arguments[29], (java.lang.String)arguments[30]);
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return EmpLocalServiceUtil.addOrUpdateWithExistUser((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return EmpLocalServiceUtil.addOrUpdateWithExistUser((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return EmpLocalServiceUtil.createEmployee((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				((Long)arguments[5]).longValue(), (java.util.Date)arguments[6],
				(java.util.Date)arguments[7], (java.util.Date)arguments[8],
				(java.util.Date)arguments[9], (java.lang.String)arguments[10],
				((Integer)arguments[11]).intValue(),
				(java.util.Date)arguments[12], (java.lang.String)arguments[13],
				(java.lang.String)arguments[14],
				(java.lang.String)arguments[15],
				(java.lang.String)arguments[16],
				((Long)arguments[17]).longValue(),
				((Long)arguments[18]).longValue(),
				(java.lang.String)arguments[19],
				(java.lang.String)arguments[20], (java.util.Date)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				(java.lang.String)arguments[25],
				((Integer)arguments[26]).intValue(),
				(java.lang.String)arguments[27],
				(java.lang.String)arguments[28], (java.lang.String)arguments[29]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return EmpLocalServiceUtil.getViFullnameFromUser((com.liferay.portal.model.User)arguments[0]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return EmpLocalServiceUtil.updateEmpAddresses((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(vn.com.ecopharma.emp.model.District)arguments[2],
				(com.liferay.portal.model.Region)arguments[3],
				((Long)arguments[4]).longValue(),
				((Boolean)arguments[5]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			EmpLocalServiceUtil.removeAllExistingEmpAddresses((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			EmpLocalServiceUtil.removeAllExistingEmpAddresses(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllEmpDocs((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			EmpLocalServiceUtil.indexAllEmps();

			return null;
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			EmpLocalServiceUtil.indexSomeEmps();

			return null;
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			EmpLocalServiceUtil.removeAllEmpIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmp(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmpFromDB(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return EmpLocalServiceUtil.getUserEmployeeCodeValue(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			EmpLocalServiceUtil.addOrUpdateUserEmployeeCodeValue((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return EmpLocalServiceUtil.isUserExisted((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return EmpLocalServiceUtil.isSameOrWrongOrderDoB((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return EmpLocalServiceUtil.regenerateDuplicateEmailAddress((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return EmpLocalServiceUtil.findAllEmpAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return EmpLocalServiceUtil.getPresentAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsFromEmpNotifyEmails((java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail>)arguments[0]);
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return EmpLocalServiceUtil.getUniqueDepartmentsFromEmps((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return EmpLocalServiceUtil.getAllManagerEmailsFromDepartments((java.util.Collection<vn.com.ecopharma.emp.model.Department>)arguments[0]);
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return EmpLocalServiceUtil.getUsersByEmps((java.util.Collection<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return EmpLocalServiceUtil.getEmailsFromUsers((java.util.Collection<com.liferay.portal.model.User>)arguments[0]);
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return EmpLocalServiceUtil.getEmailsFromEmps((java.util.Collection<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsByEmpOrgRelationships((java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship>)arguments[0]);
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return EmpLocalServiceUtil.getManagerEmailsForNewEmpsNotification((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return EmpLocalServiceUtil.getNewEmployeesHtmlTable((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return EmpLocalServiceUtil.getEntireNewEmployeesHtmlMailContent((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			EmpLocalServiceUtil.sendNewEmpsNotificationEmail((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);

			return null;
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			EmpLocalServiceUtil.getNewEmpsAndSendNotifyEmail();

			return null;
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName162;
	private String[] _methodParameterTypes162;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName168;
	private String[] _methodParameterTypes168;
	private String _methodName169;
	private String[] _methodParameterTypes169;
	private String _methodName170;
	private String[] _methodParameterTypes170;
	private String _methodName171;
	private String[] _methodParameterTypes171;
	private String _methodName172;
	private String[] _methodParameterTypes172;
	private String _methodName173;
	private String[] _methodParameterTypes173;
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName176;
	private String[] _methodParameterTypes176;
	private String _methodName177;
	private String[] _methodParameterTypes177;
	private String _methodName178;
	private String[] _methodParameterTypes178;
	private String _methodName179;
	private String[] _methodParameterTypes179;
	private String _methodName186;
	private String[] _methodParameterTypes186;
	private String _methodName187;
	private String[] _methodParameterTypes187;
	private String _methodName188;
	private String[] _methodParameterTypes188;
	private String _methodName189;
	private String[] _methodParameterTypes189;
	private String _methodName190;
	private String[] _methodParameterTypes190;
	private String _methodName191;
	private String[] _methodParameterTypes191;
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
	private String _methodName200;
	private String[] _methodParameterTypes200;
	private String _methodName201;
	private String[] _methodParameterTypes201;
	private String _methodName202;
	private String[] _methodParameterTypes202;
	private String _methodName203;
	private String[] _methodParameterTypes203;
	private String _methodName204;
	private String[] _methodParameterTypes204;
	private String _methodName205;
	private String[] _methodParameterTypes205;
	private String _methodName206;
	private String[] _methodParameterTypes206;
	private String _methodName207;
	private String[] _methodParameterTypes207;
	private String _methodName208;
	private String[] _methodParameterTypes208;
	private String _methodName209;
	private String[] _methodParameterTypes209;
	private String _methodName210;
	private String[] _methodParameterTypes210;
	private String _methodName211;
	private String[] _methodParameterTypes211;
	private String _methodName212;
	private String[] _methodParameterTypes212;
	private String _methodName213;
	private String[] _methodParameterTypes213;
	private String _methodName214;
	private String[] _methodParameterTypes214;
	private String _methodName215;
	private String[] _methodParameterTypes215;
	private String _methodName216;
	private String[] _methodParameterTypes216;
	private String _methodName217;
	private String[] _methodParameterTypes217;
	private String _methodName218;
	private String[] _methodParameterTypes218;
	private String _methodName219;
	private String[] _methodParameterTypes219;
	private String _methodName220;
	private String[] _methodParameterTypes220;
	private String _methodName221;
	private String[] _methodParameterTypes221;
	private String _methodName222;
	private String[] _methodParameterTypes222;
	private String _methodName223;
	private String[] _methodParameterTypes223;
	private String _methodName224;
	private String[] _methodParameterTypes224;
	private String _methodName225;
	private String[] _methodParameterTypes225;
	private String _methodName226;
	private String[] _methodParameterTypes226;
	private String _methodName227;
	private String[] _methodParameterTypes227;
}