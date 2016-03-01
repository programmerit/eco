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

		_methodName180 = "getBeanIdentifier";

		_methodParameterTypes180 = new String[] {  };

		_methodName181 = "setBeanIdentifier";

		_methodParameterTypes181 = new String[] { "java.lang.String" };

		_methodName186 = "findAll";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "findAll";

		_methodParameterTypes187 = new String[] { "int", "int" };

		_methodName188 = "findAll";

		_methodParameterTypes188 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName189 = "findByEmpCode";

		_methodParameterTypes189 = new String[] { "java.lang.String" };

		_methodName190 = "findByUser";

		_methodParameterTypes190 = new String[] { "long" };

		_methodName191 = "findByTitles";

		_methodParameterTypes191 = new String[] { "long" };

		_methodName192 = "findResignedEmp";

		_methodParameterTypes192 = new String[] {  };

		_methodName193 = "isOnAddingNewWithSameEmployeeCode";

		_methodParameterTypes193 = new String[] { "long", "java.lang.String" };

		_methodName194 = "countAllUnDeletedIndexedEmpDocuments";

		_methodParameterTypes194 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName195 = "searchAllUnDeletedEmpIndexedDocument";

		_methodParameterTypes195 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName196 = "countFilterEmployeeByFields";

		_methodParameterTypes196 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName197 = "filterEmployeeByFields";

		_methodParameterTypes197 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName199 = "createDateTermRangeQuery";

		_methodParameterTypes199 = new String[] {
				"java.lang.String", "java.util.List", "java.util.Date",
				"java.util.Date",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName200 = "createDateTermRangeQuery";

		_methodParameterTypes200 = new String[] {
				"java.lang.String", "java.util.Date", "java.util.Date",
				"boolean", "boolean",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName201 = "createStringListQuery";

		_methodParameterTypes201 = new String[] {
				"java.lang.String", "java.util.List",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName202 = "getGlobalSearchFields";

		_methodParameterTypes202 = new String[] {  };

		_methodName203 = "removeDashChar";

		_methodParameterTypes203 = new String[] { "java.lang.String" };

		_methodName205 = "getCurrentDateNextYear";

		_methodParameterTypes205 = new String[] {  };

		_methodName206 = "createPrePersistedEntity";

		_methodParameterTypes206 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName207 = "addEmp";

		_methodParameterTypes207 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.util.Locale", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "boolean", "int", "int", "int",
				"long[][]", "long[][]", "long[][]", "long[][]", "boolean",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName208 = "addEmp";

		_methodParameterTypes208 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "java.util.Map",
				"java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName209 = "update";

		_methodParameterTypes209 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "long", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName210 = "update";

		_methodParameterTypes210 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName211 = "updateExistedEmployee";

		_methodParameterTypes211 = new String[] {
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

		_methodName212 = "addOrUpdateWithExistUser";

		_methodParameterTypes212 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName213 = "addOrUpdateWithExistUser";

		_methodParameterTypes213 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName214 = "createEmployee";

		_methodParameterTypes214 = new String[] {
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

		_methodName216 = "getViFullnameFromUser";

		_methodParameterTypes216 = new String[] { "com.liferay.portal.model.User" };

		_methodName217 = "updateEmpAddresses";

		_methodParameterTypes217 = new String[] {
				"java.lang.String", "java.lang.String",
				"vn.com.ecopharma.emp.model.District",
				"com.liferay.portal.model.Region", "long", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName218 = "removeAllExistingEmpAddresses";

		_methodParameterTypes218 = new String[] { "java.lang.String", "long" };

		_methodName219 = "removeAllExistingEmpAddresses";

		_methodParameterTypes219 = new String[] { "long", "long" };

		_methodName220 = "searchAllEmpDocs";

		_methodParameterTypes220 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long"
			};

		_methodName221 = "getIndexedEmp";

		_methodParameterTypes221 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName222 = "getIndexedEmp";

		_methodParameterTypes222 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName223 = "markDeletedEmp";

		_methodParameterTypes223 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName224 = "markDeletedEmp";

		_methodParameterTypes224 = new String[] { "long" };

		_methodName225 = "indexAllEmps";

		_methodParameterTypes225 = new String[] {  };

		_methodName226 = "indexSomeEmps";

		_methodParameterTypes226 = new String[] {  };

		_methodName227 = "removeAllEmpIndexes";

		_methodParameterTypes227 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName228 = "completelyRemoveAllEmp";

		_methodParameterTypes228 = new String[] { "long" };

		_methodName229 = "completelyRemoveAllEmpFromDB";

		_methodParameterTypes229 = new String[] { "long" };

		_methodName230 = "getUserEmployeeCodeValue";

		_methodParameterTypes230 = new String[] { "long", "long" };

		_methodName231 = "addOrUpdateUserEmployeeCodeValue";

		_methodParameterTypes231 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName232 = "isUserExisted";

		_methodParameterTypes232 = new String[] {
				"java.lang.String", "java.lang.String", "java.util.Date", "long"
			};

		_methodName233 = "isSameOrWrongOrderDoB";

		_methodParameterTypes233 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName234 = "regenerateDuplicateEmailAddress";

		_methodParameterTypes234 = new String[] {
				"java.lang.String", "int", "long"
			};

		_methodName235 = "findAllEmpAddress";

		_methodParameterTypes235 = new String[] { "long", "long" };

		_methodName236 = "getPresentAddress";

		_methodParameterTypes236 = new String[] { "long", "long" };

		_methodName237 = "getEmpsFromEmpNotifyEmails";

		_methodParameterTypes237 = new String[] { "java.util.List" };

		_methodName238 = "getUniqueDepartmentsFromEmps";

		_methodParameterTypes238 = new String[] { "java.util.List" };

		_methodName239 = "getAllManagerEmailsFromDepartments";

		_methodParameterTypes239 = new String[] { "java.util.Collection" };

		_methodName240 = "getUsersByEmps";

		_methodParameterTypes240 = new String[] { "java.util.Collection" };

		_methodName241 = "getEmailsFromUsers";

		_methodParameterTypes241 = new String[] { "java.util.Collection" };

		_methodName242 = "getEmailsFromEmps";

		_methodParameterTypes242 = new String[] { "java.util.Collection" };

		_methodName243 = "getEmpsByEmpOrgRelationships";

		_methodParameterTypes243 = new String[] { "java.util.List" };

		_methodName244 = "getManagerEmailsForNewEmpsNotification";

		_methodParameterTypes244 = new String[] { "java.util.List" };

		_methodName245 = "getNewEmployeesHtmlTable";

		_methodParameterTypes245 = new String[] { "java.util.List" };

		_methodName246 = "getEntireNewEmployeesHtmlMailContent";

		_methodParameterTypes246 = new String[] { "java.util.List" };

		_methodName247 = "sendNewEmpsNotificationEmail";

		_methodParameterTypes247 = new String[] { "java.util.List" };

		_methodName248 = "fixLaborContractSignedDate";

		_methodParameterTypes248 = new String[] {  };
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

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return EmpLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			EmpLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return EmpLocalServiceUtil.findAll();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return EmpLocalServiceUtil.findByEmpCode((java.lang.String)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return EmpLocalServiceUtil.findByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return EmpLocalServiceUtil.findByTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return EmpLocalServiceUtil.findResignedEmp();
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return EmpLocalServiceUtil.isOnAddingNewWithSameEmployeeCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return EmpLocalServiceUtil.countAllUnDeletedIndexedEmpDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllUnDeletedEmpIndexedDocument((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return EmpLocalServiceUtil.countFilterEmployeeByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return EmpLocalServiceUtil.filterEmployeeByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			EmpLocalServiceUtil.createDateTermRangeQuery((java.lang.String)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				(java.util.Date)arguments[2], (java.util.Date)arguments[3],
				(com.liferay.portal.kernel.search.SearchContext)arguments[4]);

			return null;
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return EmpLocalServiceUtil.createDateTermRangeQuery((java.lang.String)arguments[0],
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[5]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return EmpLocalServiceUtil.createStringListQuery((java.lang.String)arguments[0],
				(java.util.List<java.lang.String>)arguments[1],
				(com.liferay.portal.kernel.search.SearchContext)arguments[2]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return EmpLocalServiceUtil.getGlobalSearchFields();
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return EmpLocalServiceUtil.removeDashChar((java.lang.String)arguments[0]);
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return EmpLocalServiceUtil.getCurrentDateNextYear();
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return EmpLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
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

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[2],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[3],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[4],
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
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

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
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

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
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

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
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

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
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

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
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

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return EmpLocalServiceUtil.getViFullnameFromUser((com.liferay.portal.model.User)arguments[0]);
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return EmpLocalServiceUtil.updateEmpAddresses((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(vn.com.ecopharma.emp.model.District)arguments[2],
				(com.liferay.portal.model.Region)arguments[3],
				((Long)arguments[4]).longValue(),
				((Boolean)arguments[5]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			EmpLocalServiceUtil.removeAllExistingEmpAddresses((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			EmpLocalServiceUtil.removeAllExistingEmpAddresses(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllEmpDocs((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			EmpLocalServiceUtil.indexAllEmps();

			return null;
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			EmpLocalServiceUtil.indexSomeEmps();

			return null;
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			EmpLocalServiceUtil.removeAllEmpIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmp(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmpFromDB(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
			return EmpLocalServiceUtil.getUserEmployeeCodeValue(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName231.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes231, parameterTypes)) {
			EmpLocalServiceUtil.addOrUpdateUserEmployeeCodeValue((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName232.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes232, parameterTypes)) {
			return EmpLocalServiceUtil.isUserExisted((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName233.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes233, parameterTypes)) {
			return EmpLocalServiceUtil.isSameOrWrongOrderDoB((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName234.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes234, parameterTypes)) {
			return EmpLocalServiceUtil.regenerateDuplicateEmailAddress((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName235.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes235, parameterTypes)) {
			return EmpLocalServiceUtil.findAllEmpAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName236.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes236, parameterTypes)) {
			return EmpLocalServiceUtil.getPresentAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName237.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes237, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsFromEmpNotifyEmails((java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail>)arguments[0]);
		}

		if (_methodName238.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes238, parameterTypes)) {
			return EmpLocalServiceUtil.getUniqueDepartmentsFromEmps((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName239.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes239, parameterTypes)) {
			return EmpLocalServiceUtil.getAllManagerEmailsFromDepartments((java.util.Collection<vn.com.ecopharma.emp.model.Department>)arguments[0]);
		}

		if (_methodName240.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes240, parameterTypes)) {
			return EmpLocalServiceUtil.getUsersByEmps((java.util.Collection<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName241.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes241, parameterTypes)) {
			return EmpLocalServiceUtil.getEmailsFromUsers((java.util.Collection<com.liferay.portal.model.User>)arguments[0]);
		}

		if (_methodName242.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes242, parameterTypes)) {
			return EmpLocalServiceUtil.getEmailsFromEmps((java.util.Collection<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName243.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes243, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsByEmpOrgRelationships((java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship>)arguments[0]);
		}

		if (_methodName244.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes244, parameterTypes)) {
			return EmpLocalServiceUtil.getManagerEmailsForNewEmpsNotification((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName245.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes245, parameterTypes)) {
			return EmpLocalServiceUtil.getNewEmployeesHtmlTable((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName246.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes246, parameterTypes)) {
			return EmpLocalServiceUtil.getEntireNewEmployeesHtmlMailContent((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName247.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes247, parameterTypes)) {
			return EmpLocalServiceUtil.sendNewEmpsNotificationEmail((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName248.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes248, parameterTypes)) {
			EmpLocalServiceUtil.fixLaborContractSignedDate();

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
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
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
	private String _methodName194;
	private String[] _methodParameterTypes194;
	private String _methodName195;
	private String[] _methodParameterTypes195;
	private String _methodName196;
	private String[] _methodParameterTypes196;
	private String _methodName197;
	private String[] _methodParameterTypes197;
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
	private String _methodName228;
	private String[] _methodParameterTypes228;
	private String _methodName229;
	private String[] _methodParameterTypes229;
	private String _methodName230;
	private String[] _methodParameterTypes230;
	private String _methodName231;
	private String[] _methodParameterTypes231;
	private String _methodName232;
	private String[] _methodParameterTypes232;
	private String _methodName233;
	private String[] _methodParameterTypes233;
	private String _methodName234;
	private String[] _methodParameterTypes234;
	private String _methodName235;
	private String[] _methodParameterTypes235;
	private String _methodName236;
	private String[] _methodParameterTypes236;
	private String _methodName237;
	private String[] _methodParameterTypes237;
	private String _methodName238;
	private String[] _methodParameterTypes238;
	private String _methodName239;
	private String[] _methodParameterTypes239;
	private String _methodName240;
	private String[] _methodParameterTypes240;
	private String _methodName241;
	private String[] _methodParameterTypes241;
	private String _methodName242;
	private String[] _methodParameterTypes242;
	private String _methodName243;
	private String[] _methodParameterTypes243;
	private String _methodName244;
	private String[] _methodParameterTypes244;
	private String _methodName245;
	private String[] _methodParameterTypes245;
	private String _methodName246;
	private String[] _methodParameterTypes246;
	private String _methodName247;
	private String[] _methodParameterTypes247;
	private String _methodName248;
	private String[] _methodParameterTypes248;
}