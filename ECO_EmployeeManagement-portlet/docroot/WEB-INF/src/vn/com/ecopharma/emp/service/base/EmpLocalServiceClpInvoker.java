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

		_methodName138 = "getBeanIdentifier";

		_methodParameterTypes138 = new String[] {  };

		_methodName139 = "setBeanIdentifier";

		_methodParameterTypes139 = new String[] { "java.lang.String" };

		_methodName144 = "findAll";

		_methodParameterTypes144 = new String[] {  };

		_methodName145 = "findAll";

		_methodParameterTypes145 = new String[] { "int", "int" };

		_methodName146 = "findAll";

		_methodParameterTypes146 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName147 = "findByEmpCode";

		_methodParameterTypes147 = new String[] { "java.lang.String" };

		_methodName148 = "findByUser";

		_methodParameterTypes148 = new String[] { "long" };

		_methodName149 = "findByTitles";

		_methodParameterTypes149 = new String[] { "long" };

		_methodName150 = "findResignedEmp";

		_methodParameterTypes150 = new String[] {  };

		_methodName151 = "isOnAddingNewWithSameEmployeeCode";

		_methodParameterTypes151 = new String[] { "long", "java.lang.String" };

		_methodName152 = "countAllUnDeletedIndexedEmpDocuments";

		_methodParameterTypes152 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName153 = "searchAllUnDeletedEmpIndexedDocument";

		_methodParameterTypes153 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName154 = "addEmp";

		_methodParameterTypes154 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.util.Locale", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "boolean", "int", "int", "int",
				"long[][]", "long[][]", "long[][]", "long[][]", "boolean",
				"java.util.Map", "java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName155 = "addEmp";

		_methodParameterTypes155 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "java.util.Map",
				"java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName156 = "update";

		_methodParameterTypes156 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "long", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName157 = "update";

		_methodParameterTypes157 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName158 = "addOrUpdateWithExistUser";

		_methodParameterTypes158 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName159 = "addOrUpdateWithExistUser";

		_methodParameterTypes159 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName160 = "createEmployee";

		_methodParameterTypes160 = new String[] {
				"java.lang.String", "long", "long", "long", "long", "long",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.lang.String", "int", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"int", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName161 = "updateExistedEmployee";

		_methodParameterTypes161 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"long", "long", "long", "long", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.lang.String", "int", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "java.lang.String",
				"java.lang.String", "java.lang.String"
			};

		_methodName163 = "searchAllEmpDocs";

		_methodParameterTypes163 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long"
			};

		_methodName164 = "getIndexedEmp";

		_methodParameterTypes164 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName165 = "getIndexedEmp";

		_methodParameterTypes165 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName166 = "markDeletedEmp";

		_methodParameterTypes166 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName167 = "markDeletedEmp";

		_methodParameterTypes167 = new String[] { "long" };

		_methodName168 = "indexAllEmps";

		_methodParameterTypes168 = new String[] {  };

		_methodName169 = "indexSomeEmps";

		_methodParameterTypes169 = new String[] {  };

		_methodName170 = "removeAllEmpIndexes";

		_methodParameterTypes170 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName171 = "completelyRemoveAllEmp";

		_methodParameterTypes171 = new String[] { "long" };

		_methodName172 = "completelyRemoveAllEmpFromDB";

		_methodParameterTypes172 = new String[] { "long" };

		_methodName173 = "getUserEmployeeCodeValue";

		_methodParameterTypes173 = new String[] { "long", "long" };

		_methodName174 = "addOrUpdateUserEmployeeCodeValue";

		_methodParameterTypes174 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName175 = "isUserExisted";

		_methodParameterTypes175 = new String[] {
				"java.lang.String", "java.lang.String", "java.util.Date", "long"
			};

		_methodName176 = "isSameOrWrongOrderDoB";

		_methodParameterTypes176 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName177 = "regenerateDuplicateEmailAddress";

		_methodParameterTypes177 = new String[] {
				"java.lang.String", "int", "long"
			};

		_methodName178 = "findAllEmpAddress";

		_methodParameterTypes178 = new String[] { "long" };

		_methodName179 = "getPresentAddress";

		_methodParameterTypes179 = new String[] { "long" };
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

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return EmpLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			EmpLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return EmpLocalServiceUtil.findAll();
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return EmpLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return EmpLocalServiceUtil.findByEmpCode((java.lang.String)arguments[0]);
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return EmpLocalServiceUtil.findByUser(((Long)arguments[0]).longValue());
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return EmpLocalServiceUtil.findByTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return EmpLocalServiceUtil.findResignedEmp();
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return EmpLocalServiceUtil.isOnAddingNewWithSameEmployeeCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return EmpLocalServiceUtil.countAllUnDeletedIndexedEmpDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllUnDeletedEmpIndexedDocument((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
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
				(com.liferay.portal.service.ServiceContext)arguments[27]);
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return EmpLocalServiceUtil.addEmp((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[2],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[3],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[4],
				(com.liferay.portal.service.ServiceContext)arguments[5]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return EmpLocalServiceUtil.update((vn.com.ecopharma.emp.model.Emp)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			return EmpLocalServiceUtil.update((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName158.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes158, parameterTypes)) {
			return EmpLocalServiceUtil.addOrUpdateWithExistUser((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(com.liferay.portal.model.User)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName159.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes159, parameterTypes)) {
			return EmpLocalServiceUtil.addOrUpdateWithExistUser((vn.com.ecopharma.emp.model.Emp)arguments[0],
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean>)arguments[3],
				(java.util.Map<java.lang.String, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean>)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				(com.liferay.portal.service.ServiceContext)arguments[7]);
		}

		if (_methodName160.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes160, parameterTypes)) {
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
				(java.lang.String)arguments[18],
				(java.lang.String)arguments[19], (java.util.Date)arguments[20],
				(java.lang.String)arguments[21],
				(java.lang.String)arguments[22],
				(java.lang.String)arguments[23],
				(java.lang.String)arguments[24],
				((Integer)arguments[25]).intValue(),
				(java.lang.String)arguments[26],
				(java.lang.String)arguments[27], (java.lang.String)arguments[28]);
		}

		if (_methodName161.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes161, parameterTypes)) {
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

		if (_methodName163.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes163, parameterTypes)) {
			return EmpLocalServiceUtil.searchAllEmpDocs((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName164.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes164, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName165.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes165, parameterTypes)) {
			return EmpLocalServiceUtil.getIndexedEmp(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName166.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes166, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp((vn.com.ecopharma.emp.model.Emp)arguments[0]);
		}

		if (_methodName167.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes167, parameterTypes)) {
			return EmpLocalServiceUtil.markDeletedEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName168.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes168, parameterTypes)) {
			EmpLocalServiceUtil.indexAllEmps();

			return null;
		}

		if (_methodName169.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes169, parameterTypes)) {
			EmpLocalServiceUtil.indexSomeEmps();

			return null;
		}

		if (_methodName170.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes170, parameterTypes)) {
			EmpLocalServiceUtil.removeAllEmpIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName171.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes171, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmp(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName172.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes172, parameterTypes)) {
			EmpLocalServiceUtil.completelyRemoveAllEmpFromDB(((Long)arguments[0]).longValue());

			return null;
		}

		if (_methodName173.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes173, parameterTypes)) {
			return EmpLocalServiceUtil.getUserEmployeeCodeValue(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			EmpLocalServiceUtil.addOrUpdateUserEmployeeCodeValue((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());

			return null;
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			return EmpLocalServiceUtil.isUserExisted((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName176.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes176, parameterTypes)) {
			return EmpLocalServiceUtil.isSameOrWrongOrderDoB((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName177.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes177, parameterTypes)) {
			return EmpLocalServiceUtil.regenerateDuplicateEmailAddress((java.lang.String)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName178.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes178, parameterTypes)) {
			return EmpLocalServiceUtil.findAllEmpAddress(((Long)arguments[0]).longValue());
		}

		if (_methodName179.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes179, parameterTypes)) {
			return EmpLocalServiceUtil.getPresentAddress(((Long)arguments[0]).longValue());
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
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName146;
	private String[] _methodParameterTypes146;
	private String _methodName147;
	private String[] _methodParameterTypes147;
	private String _methodName148;
	private String[] _methodParameterTypes148;
	private String _methodName149;
	private String[] _methodParameterTypes149;
	private String _methodName150;
	private String[] _methodParameterTypes150;
	private String _methodName151;
	private String[] _methodParameterTypes151;
	private String _methodName152;
	private String[] _methodParameterTypes152;
	private String _methodName153;
	private String[] _methodParameterTypes153;
	private String _methodName154;
	private String[] _methodParameterTypes154;
	private String _methodName155;
	private String[] _methodParameterTypes155;
	private String _methodName156;
	private String[] _methodParameterTypes156;
	private String _methodName157;
	private String[] _methodParameterTypes157;
	private String _methodName158;
	private String[] _methodParameterTypes158;
	private String _methodName159;
	private String[] _methodParameterTypes159;
	private String _methodName160;
	private String[] _methodParameterTypes160;
	private String _methodName161;
	private String[] _methodParameterTypes161;
	private String _methodName163;
	private String[] _methodParameterTypes163;
	private String _methodName164;
	private String[] _methodParameterTypes164;
	private String _methodName165;
	private String[] _methodParameterTypes165;
	private String _methodName166;
	private String[] _methodParameterTypes166;
	private String _methodName167;
	private String[] _methodParameterTypes167;
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
}