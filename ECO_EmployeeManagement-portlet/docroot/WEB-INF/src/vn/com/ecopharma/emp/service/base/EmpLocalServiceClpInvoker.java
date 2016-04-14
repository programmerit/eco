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

		_methodName198 = "getBeanIdentifier";

		_methodParameterTypes198 = new String[] {  };

		_methodName199 = "setBeanIdentifier";

		_methodParameterTypes199 = new String[] { "java.lang.String" };

		_methodName204 = "findAll";

		_methodParameterTypes204 = new String[] {  };

		_methodName205 = "findAll";

		_methodParameterTypes205 = new String[] { "int", "int" };

		_methodName206 = "findAll";

		_methodParameterTypes206 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName207 = "findByEmpCode";

		_methodParameterTypes207 = new String[] { "java.lang.String" };

		_methodName208 = "findByUser";

		_methodParameterTypes208 = new String[] { "long" };

		_methodName209 = "findByTitles";

		_methodParameterTypes209 = new String[] { "long" };

		_methodName210 = "findResignedEmp";

		_methodParameterTypes210 = new String[] {  };

		_methodName211 = "isOnAddingNewWithSameEmployeeCode";

		_methodParameterTypes211 = new String[] { "long", "java.lang.String" };

		_methodName212 = "countAllUnDeletedIndexedEmpDocuments";

		_methodParameterTypes212 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName213 = "searchAllUnDeletedEmpIndexedDocument";

		_methodParameterTypes213 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName214 = "countFilterEmployeeByFields";

		_methodParameterTypes214 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName215 = "filterEmployeeByFields";

		_methodParameterTypes215 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName216 = "filterEmployeeByAutocompleteQuery";

		_methodParameterTypes216 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext", "int", "int"
			};

		_methodName217 = "filterEmployeeByAutocompleteQuery";

		_methodParameterTypes217 = new String[] {
				"java.lang.String", "java.util.Map",
				"com.liferay.portal.kernel.search.SearchContext", "int", "int"
			};

		_methodName218 = "isOrganizationFilter";

		_methodParameterTypes218 = new String[] { "java.lang.String" };

		_methodName219 = "createDateTermRangeQuery";

		_methodParameterTypes219 = new String[] {
				"java.lang.String", "java.util.List", "java.util.Date",
				"java.util.Date",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName220 = "createDateTermRangeQuery";

		_methodParameterTypes220 = new String[] {
				"java.lang.String", "java.util.Date", "java.util.Date",
				"boolean", "boolean",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName222 = "createStringListQuery";

		_methodParameterTypes222 = new String[] {
				"java.lang.String", "java.util.List",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName223 = "getGlobalSearchFields";

		_methodParameterTypes223 = new String[] {  };

		_methodName224 = "getAutocompleteSearchFields";

		_methodParameterTypes224 = new String[] {  };

		_methodName225 = "removeDashChar";

		_methodParameterTypes225 = new String[] { "java.lang.String" };

		_methodName227 = "getCurrentDateNextYear";

		_methodParameterTypes227 = new String[] {  };

		_methodName228 = "createPrePersistedEntity";

		_methodParameterTypes228 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName229 = "addEmp";

		_methodParameterTypes229 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String", "boolean",
				"boolean", "java.util.Map", "java.util.Map", "java.util.Map",
				"java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName230 = "addEmp";

		_methodParameterTypes230 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "java.util.Map",
				"java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName231 = "addEmp";

		_methodParameterTypes231 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.util.Locale", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "boolean", "int", "int", "int",
				"long[][]", "long[][]", "long[][]", "long[][]", "boolean",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName232 = "update";

		_methodParameterTypes232 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "long", "long",
				"java.util.Map", "java.util.Map", "java.util.Map",
				"java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName233 = "update";

		_methodParameterTypes233 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName234 = "updateExistedEmployee";

		_methodParameterTypes234 = new String[] {
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

		_methodName235 = "addOrUpdateWithExistUser";

		_methodParameterTypes235 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName236 = "addOrUpdateWithExistUser";

		_methodParameterTypes236 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.util.Map",
				"java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName237 = "createEmployee";

		_methodParameterTypes237 = new String[] {
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

		_methodName239 = "getViFullnameFromUser";

		_methodParameterTypes239 = new String[] { "com.liferay.portal.model.User" };

		_methodName240 = "updateEmpAddresses";

		_methodParameterTypes240 = new String[] {
				"java.lang.String", "java.lang.String",
				"vn.com.ecopharma.emp.model.District",
				"com.liferay.portal.model.Region", "long", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName241 = "removeAllExistingEmpAddresses";

		_methodParameterTypes241 = new String[] { "java.lang.String", "long" };

		_methodName242 = "removeAllExistingEmpAddresses";

		_methodParameterTypes242 = new String[] { "long", "long" };

		_methodName243 = "searchAllEmpDocs";

		_methodParameterTypes243 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long"
			};

		_methodName244 = "getIndexedEmp";

		_methodParameterTypes244 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName245 = "getIndexedEmp";

		_methodParameterTypes245 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName246 = "markDeletedEmp";

		_methodParameterTypes246 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName247 = "markDeletedEmp";

		_methodParameterTypes247 = new String[] { "long" };

		_methodName248 = "indexAllEmps";

		_methodParameterTypes248 = new String[] {  };

		_methodName249 = "indexSomeEmps";

		_methodParameterTypes249 = new String[] {  };

		_methodName250 = "removeAllEmpIndexes";

		_methodParameterTypes250 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName251 = "completelyRemoveAllEmp";

		_methodParameterTypes251 = new String[] { "long" };

		_methodName252 = "completelyRemoveAllEmpFromDB";

		_methodParameterTypes252 = new String[] { "long" };

		_methodName253 = "getUserEmployeeCodeValue";

		_methodParameterTypes253 = new String[] { "long", "long" };

		_methodName254 = "addOrUpdateUserEmployeeCodeValue";

		_methodParameterTypes254 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName255 = "isUserExisted";

		_methodParameterTypes255 = new String[] {
				"java.lang.String", "java.lang.String", "java.util.Date", "long"
			};

		_methodName256 = "isSameOrWrongOrderDoB";

		_methodParameterTypes256 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName257 = "regenerateDuplicateEmailAddress";

		_methodParameterTypes257 = new String[] {
				"java.lang.String", "int", "long"
			};

		_methodName258 = "findAllEmpAddress";

		_methodParameterTypes258 = new String[] { "long", "long" };

		_methodName259 = "getPresentAddress";

		_methodParameterTypes259 = new String[] { "long", "long" };

		_methodName260 = "getEmpsFromEmpNotifyEmails";

		_methodParameterTypes260 = new String[] { "java.util.List" };

		_methodName261 = "getUniqueDepartmentsFromEmps";

		_methodParameterTypes261 = new String[] { "java.util.List" };

		_methodName262 = "getAllManagerEmailsFromDepartments";

		_methodParameterTypes262 = new String[] { "java.util.Collection" };

		_methodName263 = "getUsersByEmps";

		_methodParameterTypes263 = new String[] { "java.util.Collection" };

		_methodName264 = "getEmailsFromUsers";

		_methodParameterTypes264 = new String[] { "java.util.Collection" };

		_methodName265 = "getEmailsFromEmps";

		_methodParameterTypes265 = new String[] { "java.util.Collection" };

		_methodName266 = "getEmpsByEmpOrgRelationships";

		_methodParameterTypes266 = new String[] { "java.util.List" };

		_methodName267 = "getManagerEmailsForNewEmpsNotification";

		_methodParameterTypes267 = new String[] { "java.util.List" };

		_methodName268 = "getNewEmployeesHtmlTable";

		_methodParameterTypes268 = new String[] { "java.util.List" };

		_methodName269 = "getEntireNewEmployeesHtmlMailContent";

		_methodParameterTypes269 = new String[] { "java.util.List" };

		_methodName270 = "sendNewEmpsNotificationEmail";

		_methodParameterTypes270 = new String[] { "java.util.List" };

		_methodName271 = "testSendNewEmpsNotificationEmail";

		_methodParameterTypes271 = new String[] { "java.util.List" };

		_methodName272 = "fixLaborContractSignedDate";

		_methodParameterTypes272 = new String[] {  };

		_methodName273 = "generateOriginalUsername";

		_methodParameterTypes273 = new String[] { "java.lang.String" };

		_methodName274 = "regenerateUsername";

		_methodParameterTypes274 = new String[] {
				"java.lang.String", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName275 = "checkAndGenerateUsernameByFullname";

		_methodParameterTypes275 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName276 = "generateEmailByUsername";

		_methodParameterTypes276 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName277 = "getLastName";

		_methodParameterTypes277 = new String[] { "java.lang.String" };

		_methodName278 = "getMiddleName";

		_methodParameterTypes278 = new String[] { "java.lang.String" };

		_methodName279 = "getFirstName";

		_methodParameterTypes279 = new String[] { "java.lang.String" };
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

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return EmpLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			EmpLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return EmpLocalServiceUtil.findAll();
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return EmpLocalServiceUtil.findByEmpCode((java.lang.String)arguments[0]);
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return EmpLocalServiceUtil.findByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return EmpLocalServiceUtil.findByTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return EmpLocalServiceUtil.findResignedEmp();
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return EmpLocalServiceUtil.isOnAddingNewWithSameEmployeeCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return EmpLocalServiceUtil.countAllUnDeletedIndexedEmpDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllUnDeletedEmpIndexedDocument((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return EmpLocalServiceUtil.countFilterEmployeeByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return EmpLocalServiceUtil.filterEmployeeByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return EmpLocalServiceUtil.filterEmployeeByAutocompleteQuery((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1],
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return EmpLocalServiceUtil.filterEmployeeByAutocompleteQuery((java.lang.String)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.SearchContext)arguments[2],
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return EmpLocalServiceUtil.isOrganizationFilter((java.lang.String)arguments[0]);
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			EmpLocalServiceUtil.createDateTermRangeQuery((java.lang.String)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				(java.util.Date)arguments[2], (java.util.Date)arguments[3],
				(com.liferay.portal.kernel.search.SearchContext)arguments[4]);

			return null;
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return EmpLocalServiceUtil.createDateTermRangeQuery((java.lang.String)arguments[0],
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				((Boolean)arguments[3]).booleanValue(),
				((Boolean)arguments[4]).booleanValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[5]);
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			return EmpLocalServiceUtil.createStringListQuery((java.lang.String)arguments[0],
				(java.util.List<java.lang.String>)arguments[1],
				(com.liferay.portal.kernel.search.SearchContext)arguments[2]);
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return EmpLocalServiceUtil.getGlobalSearchFields();
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return EmpLocalServiceUtil.getAutocompleteSearchFields();
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			return EmpLocalServiceUtil.removeDashChar((java.lang.String)arguments[0]);
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			return EmpLocalServiceUtil.getCurrentDateNextYear();
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
			return EmpLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName229.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes229, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Boolean)arguments[5]).booleanValue(),
				(java.lang.String)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				((Boolean)arguments[8]).booleanValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[9],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[10],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[11],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean>)arguments[12],
				((Boolean)arguments[13]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[14]);
		}

		if (_methodName230.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes230, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[2],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[3],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[4],
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName231.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes231, parameterTypes)) {
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

		if (_methodName232.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes232, parameterTypes)) {
			return EmpLocalServiceUtil.update((vn.com.ecopharma.emp.model.Emp)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean>)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName233.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes233, parameterTypes)) {
			return EmpLocalServiceUtil.update((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean>)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName234.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes234, parameterTypes)) {
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

		if (_methodName235.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes235, parameterTypes)) {
			return EmpLocalServiceUtil.addOrUpdateWithExistUser((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean>)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName236.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes236, parameterTypes)) {
			return EmpLocalServiceUtil.addOrUpdateWithExistUser((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpLaborContract, java.lang.Boolean>)arguments[6],
				((Boolean)arguments[7]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[8]);
		}

		if (_methodName237.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes237, parameterTypes)) {
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

		if (_methodName239.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes239, parameterTypes)) {
			return EmpLocalServiceUtil.getViFullnameFromUser((com.liferay.portal.model.User)arguments[0]);
		}

		if (_methodName240.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes240, parameterTypes)) {
			return EmpLocalServiceUtil.updateEmpAddresses((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				(vn.com.ecopharma.emp.model.District)arguments[2],
				(com.liferay.portal.model.Region)arguments[3],
				((Long)arguments[4]).longValue(),
				((Boolean)arguments[5]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName241.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes241, parameterTypes)) {
			EmpLocalServiceUtil.removeAllExistingEmpAddresses((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName242.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes242, parameterTypes)) {
			EmpLocalServiceUtil.removeAllExistingEmpAddresses(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName243.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes243, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllEmpDocs((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName244.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes244, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName245.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes245, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName246.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes246, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName247.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes247, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName248.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes248, parameterTypes)) {
			EmpLocalServiceUtil.indexAllEmps();

			return null;
		}

		if (_methodName249.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes249, parameterTypes)) {
			EmpLocalServiceUtil.indexSomeEmps();

			return null;
		}

		if (_methodName250.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes250, parameterTypes)) {
			EmpLocalServiceUtil.removeAllEmpIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName251.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes251, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmp(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName252.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes252, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmpFromDB(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName253.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes253, parameterTypes)) {
			return EmpLocalServiceUtil.getUserEmployeeCodeValue(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName254.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes254, parameterTypes)) {
			EmpLocalServiceUtil.addOrUpdateUserEmployeeCodeValue((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName255.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes255, parameterTypes)) {
			return EmpLocalServiceUtil.isUserExisted((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName256.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes256, parameterTypes)) {
			return EmpLocalServiceUtil.isSameOrWrongOrderDoB((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName257.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes257, parameterTypes)) {
			return EmpLocalServiceUtil.regenerateDuplicateEmailAddress((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName258.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes258, parameterTypes)) {
			return EmpLocalServiceUtil.findAllEmpAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName259.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes259, parameterTypes)) {
			return EmpLocalServiceUtil.getPresentAddress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName260.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes260, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsFromEmpNotifyEmails((java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail>)arguments[0]);
		}

		if (_methodName261.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes261, parameterTypes)) {
			return EmpLocalServiceUtil.getUniqueDepartmentsFromEmps((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName262.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes262, parameterTypes)) {
			return EmpLocalServiceUtil.getAllManagerEmailsFromDepartments((java.util.Collection<vn.com.ecopharma.emp.model.Department>)arguments[0]);
		}

		if (_methodName263.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes263, parameterTypes)) {
			return EmpLocalServiceUtil.getUsersByEmps((java.util.Collection<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName264.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes264, parameterTypes)) {
			return EmpLocalServiceUtil.getEmailsFromUsers((java.util.Collection<com.liferay.portal.model.User>)arguments[0]);
		}

		if (_methodName265.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes265, parameterTypes)) {
			return EmpLocalServiceUtil.getEmailsFromEmps((java.util.Collection<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName266.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes266, parameterTypes)) {
			return EmpLocalServiceUtil.getEmpsByEmpOrgRelationships((java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship>)arguments[0]);
		}

		if (_methodName267.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes267, parameterTypes)) {
			return EmpLocalServiceUtil.getManagerEmailsForNewEmpsNotification((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName268.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes268, parameterTypes)) {
			return EmpLocalServiceUtil.getNewEmployeesHtmlTable((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName269.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes269, parameterTypes)) {
			return EmpLocalServiceUtil.getEntireNewEmployeesHtmlMailContent((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName270.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes270, parameterTypes)) {
			return EmpLocalServiceUtil.sendNewEmpsNotificationEmail((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName271.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes271, parameterTypes)) {
			return EmpLocalServiceUtil.testSendNewEmpsNotificationEmail((java.util.List<vn.com.ecopharma.emp.model.Emp>)arguments[0]);
		}

		if (_methodName272.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes272, parameterTypes)) {
			EmpLocalServiceUtil.fixLaborContractSignedDate();

			return null;
		}

		if (_methodName273.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes273, parameterTypes)) {
			return EmpLocalServiceUtil.generateOriginalUsername((java.lang.String)arguments[0]);
		}

		if (_methodName274.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes274, parameterTypes)) {
			return EmpLocalServiceUtil.regenerateUsername((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName275.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes275, parameterTypes)) {
			return EmpLocalServiceUtil.checkAndGenerateUsernameByFullname((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName276.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes276, parameterTypes)) {
			return EmpLocalServiceUtil.generateEmailByUsername((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName277.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes277, parameterTypes)) {
			return EmpLocalServiceUtil.getLastName((java.lang.String)arguments[0]);
		}

		if (_methodName278.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes278, parameterTypes)) {
			return EmpLocalServiceUtil.getMiddleName((java.lang.String)arguments[0]);
		}

		if (_methodName279.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes279, parameterTypes)) {
			return EmpLocalServiceUtil.getFirstName((java.lang.String)arguments[0]);
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
	private String _methodName198;
	private String[] _methodParameterTypes198;
	private String _methodName199;
	private String[] _methodParameterTypes199;
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
	private String _methodName222;
	private String[] _methodParameterTypes222;
	private String _methodName223;
	private String[] _methodParameterTypes223;
	private String _methodName224;
	private String[] _methodParameterTypes224;
	private String _methodName225;
	private String[] _methodParameterTypes225;
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
	private String _methodName249;
	private String[] _methodParameterTypes249;
	private String _methodName250;
	private String[] _methodParameterTypes250;
	private String _methodName251;
	private String[] _methodParameterTypes251;
	private String _methodName252;
	private String[] _methodParameterTypes252;
	private String _methodName253;
	private String[] _methodParameterTypes253;
	private String _methodName254;
	private String[] _methodParameterTypes254;
	private String _methodName255;
	private String[] _methodParameterTypes255;
	private String _methodName256;
	private String[] _methodParameterTypes256;
	private String _methodName257;
	private String[] _methodParameterTypes257;
	private String _methodName258;
	private String[] _methodParameterTypes258;
	private String _methodName259;
	private String[] _methodParameterTypes259;
	private String _methodName260;
	private String[] _methodParameterTypes260;
	private String _methodName261;
	private String[] _methodParameterTypes261;
	private String _methodName262;
	private String[] _methodParameterTypes262;
	private String _methodName263;
	private String[] _methodParameterTypes263;
	private String _methodName264;
	private String[] _methodParameterTypes264;
	private String _methodName265;
	private String[] _methodParameterTypes265;
	private String _methodName266;
	private String[] _methodParameterTypes266;
	private String _methodName267;
	private String[] _methodParameterTypes267;
	private String _methodName268;
	private String[] _methodParameterTypes268;
	private String _methodName269;
	private String[] _methodParameterTypes269;
	private String _methodName270;
	private String[] _methodParameterTypes270;
	private String _methodName271;
	private String[] _methodParameterTypes271;
	private String _methodName272;
	private String[] _methodParameterTypes272;
	private String _methodName273;
	private String[] _methodParameterTypes273;
	private String _methodName274;
	private String[] _methodParameterTypes274;
	private String _methodName275;
	private String[] _methodParameterTypes275;
	private String _methodName276;
	private String[] _methodParameterTypes276;
	private String _methodName277;
	private String[] _methodParameterTypes277;
	private String _methodName278;
	private String[] _methodParameterTypes278;
	private String _methodName279;
	private String[] _methodParameterTypes279;
}