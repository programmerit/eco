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

import com.liferay.portal.service.InvokableLocalService;

/**
 * @author tvt
 * @generated
 */
public class EmpLocalServiceClp implements EmpLocalService {
	public EmpLocalServiceClp(InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

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

		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName19 = "findAll";

		_methodParameterTypes19 = new String[] {  };

		_methodName20 = "findAll";

		_methodParameterTypes20 = new String[] { "int", "int" };

		_methodName21 = "findAll";

		_methodParameterTypes21 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName22 = "findByEmpCode";

		_methodParameterTypes22 = new String[] { "java.lang.String" };

		_methodName23 = "findByUser";

		_methodParameterTypes23 = new String[] { "long" };

		_methodName24 = "findByTitles";

		_methodParameterTypes24 = new String[] { "long" };

		_methodName25 = "findResignedEmp";

		_methodParameterTypes25 = new String[] {  };

		_methodName26 = "isOnAddingNewWithSameEmployeeCode";

		_methodParameterTypes26 = new String[] { "long", "java.lang.String" };

		_methodName27 = "countAllUnDeletedIndexedEmpDocuments";

		_methodParameterTypes27 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName28 = "searchAllUnDeletedEmpIndexedDocument";

		_methodParameterTypes28 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName29 = "countFilterEmployeeByFields";

		_methodParameterTypes29 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName30 = "filterEmployeeByFields";

		_methodParameterTypes30 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName31 = "filterEmployeeByAutocompleteQuery";

		_methodParameterTypes31 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext", "int", "int"
			};

		_methodName32 = "isOrganizationFilter";

		_methodParameterTypes32 = new String[] { "java.lang.String" };

		_methodName33 = "createDateTermRangeQuery";

		_methodParameterTypes33 = new String[] {
				"java.lang.String", "java.util.List", "java.util.Date",
				"java.util.Date",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName34 = "createDateTermRangeQuery";

		_methodParameterTypes34 = new String[] {
				"java.lang.String", "java.util.Date", "java.util.Date",
				"boolean", "boolean",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName35 = "createStringListQuery";

		_methodParameterTypes35 = new String[] {
				"java.lang.String", "java.util.List",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName36 = "getGlobalSearchFields";

		_methodParameterTypes36 = new String[] {  };

		_methodName37 = "removeDashChar";

		_methodParameterTypes37 = new String[] { "java.lang.String" };

		_methodName38 = "getCurrentDateNextYear";

		_methodParameterTypes38 = new String[] {  };

		_methodName39 = "createPrePersistedEntity";

		_methodParameterTypes39 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName40 = "addEmp";

		_methodParameterTypes40 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String", "boolean",
				"boolean", "java.util.Map", "java.util.Map", "java.util.Map",
				"boolean", "com.liferay.portal.service.ServiceContext"
			};

		_methodName41 = "addEmp";

		_methodParameterTypes41 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "java.util.Map",
				"java.util.Map", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName42 = "addEmp";

		_methodParameterTypes42 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "boolean", "java.lang.String",
				"java.lang.String", "boolean", "java.lang.String",
				"java.lang.String", "long", "java.lang.String",
				"java.util.Locale", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int", "boolean", "int", "int", "int",
				"long[][]", "long[][]", "long[][]", "long[][]", "boolean",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName43 = "update";

		_methodParameterTypes43 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "long", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName44 = "update";

		_methodParameterTypes44 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName45 = "updateExistedEmployee";

		_methodParameterTypes45 = new String[] {
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

		_methodName46 = "addOrUpdateWithExistUser";

		_methodParameterTypes46 = new String[] {
				"vn.com.ecopharma.emp.model.Emp",
				"com.liferay.portal.model.User", "long", "java.util.Map",
				"java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName47 = "addOrUpdateWithExistUser";

		_methodParameterTypes47 = new String[] {
				"vn.com.ecopharma.emp.model.Emp", "java.lang.String", "long",
				"java.util.Map", "java.util.Map", "java.util.Map", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName48 = "createEmployee";

		_methodParameterTypes48 = new String[] {
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

		_methodName49 = "getViFullnameFromUser";

		_methodParameterTypes49 = new String[] { "com.liferay.portal.model.User" };

		_methodName50 = "updateEmpAddresses";

		_methodParameterTypes50 = new String[] {
				"java.lang.String", "java.lang.String",
				"vn.com.ecopharma.emp.model.District",
				"com.liferay.portal.model.Region", "long", "boolean",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName51 = "removeAllExistingEmpAddresses";

		_methodParameterTypes51 = new String[] { "java.lang.String", "long" };

		_methodName52 = "removeAllExistingEmpAddresses";

		_methodParameterTypes52 = new String[] { "long", "long" };

		_methodName53 = "searchAllEmpDocs";

		_methodParameterTypes53 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long"
			};

		_methodName54 = "getIndexedEmp";

		_methodParameterTypes54 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName55 = "getIndexedEmp";

		_methodParameterTypes55 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName56 = "markDeletedEmp";

		_methodParameterTypes56 = new String[] { "vn.com.ecopharma.emp.model.Emp" };

		_methodName57 = "markDeletedEmp";

		_methodParameterTypes57 = new String[] { "long" };

		_methodName58 = "indexAllEmps";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "indexSomeEmps";

		_methodParameterTypes59 = new String[] {  };

		_methodName60 = "removeAllEmpIndexes";

		_methodParameterTypes60 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName61 = "completelyRemoveAllEmp";

		_methodParameterTypes61 = new String[] { "long" };

		_methodName62 = "completelyRemoveAllEmpFromDB";

		_methodParameterTypes62 = new String[] { "long" };

		_methodName63 = "getUserEmployeeCodeValue";

		_methodParameterTypes63 = new String[] { "long", "long" };

		_methodName64 = "addOrUpdateUserEmployeeCodeValue";

		_methodParameterTypes64 = new String[] {
				"java.lang.String", "long", "long"
			};

		_methodName65 = "isUserExisted";

		_methodParameterTypes65 = new String[] {
				"java.lang.String", "java.lang.String", "java.util.Date", "long"
			};

		_methodName66 = "isSameOrWrongOrderDoB";

		_methodParameterTypes66 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName67 = "regenerateDuplicateEmailAddress";

		_methodParameterTypes67 = new String[] { "java.lang.String", "int", "long" };

		_methodName68 = "findAllEmpAddress";

		_methodParameterTypes68 = new String[] { "long", "long" };

		_methodName69 = "getPresentAddress";

		_methodParameterTypes69 = new String[] { "long", "long" };

		_methodName70 = "getEmpsFromEmpNotifyEmails";

		_methodParameterTypes70 = new String[] { "java.util.List" };

		_methodName71 = "getUniqueDepartmentsFromEmps";

		_methodParameterTypes71 = new String[] { "java.util.List" };

		_methodName72 = "getAllManagerEmailsFromDepartments";

		_methodParameterTypes72 = new String[] { "java.util.Collection" };

		_methodName73 = "getUsersByEmps";

		_methodParameterTypes73 = new String[] { "java.util.Collection" };

		_methodName74 = "getEmailsFromUsers";

		_methodParameterTypes74 = new String[] { "java.util.Collection" };

		_methodName75 = "getEmailsFromEmps";

		_methodParameterTypes75 = new String[] { "java.util.Collection" };

		_methodName76 = "getEmpsByEmpOrgRelationships";

		_methodParameterTypes76 = new String[] { "java.util.List" };

		_methodName77 = "getManagerEmailsForNewEmpsNotification";

		_methodParameterTypes77 = new String[] { "java.util.List" };

		_methodName78 = "getNewEmployeesHtmlTable";

		_methodParameterTypes78 = new String[] { "java.util.List" };

		_methodName79 = "getEntireNewEmployeesHtmlMailContent";

		_methodParameterTypes79 = new String[] { "java.util.List" };

		_methodName80 = "sendNewEmpsNotificationEmail";

		_methodParameterTypes80 = new String[] { "java.util.List" };

		_methodName81 = "testSendNewEmpsNotificationEmail";

		_methodParameterTypes81 = new String[] { "java.util.List" };

		_methodName82 = "fixLaborContractSignedDate";

		_methodParameterTypes82 = new String[] {  };
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(emp) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp createEmp(long empId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { empId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp deleteEmp(long empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { empId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp deleteEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(emp) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName4,
					_methodParameterTypes4, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.dao.orm.DynamicQuery)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName5,
					_methodParameterTypes5,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName6,
					_methodParameterTypes6,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName7,
					_methodParameterTypes7,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName8,
					_methodParameterTypes8,
					new Object[] { ClpSerializer.translateInput(dynamicQuery) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName9,
					_methodParameterTypes9,
					new Object[] {
						ClpSerializer.translateInput(dynamicQuery),
						
					ClpSerializer.translateInput(projection)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Long)returnObj).longValue();
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp fetchEmp(long empId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { empId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp getEmp(long empId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { empId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName12,
					_methodParameterTypes12,
					new Object[] { ClpSerializer.translateInput(primaryKeyObj) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.PersistedModel)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> getEmps(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName13,
					_methodParameterTypes13, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getEmpsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName14,
					_methodParameterTypes14, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp updateEmp(
		vn.com.ecopharma.emp.model.Emp emp)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(emp) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getBeanIdentifier() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName16,
					_methodParameterTypes16, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		try {
			_invokableLocalService.invokeMethod(_methodName17,
				_methodParameterTypes17,
				new Object[] { ClpSerializer.translateInput(beanIdentifier) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		throw new UnsupportedOperationException();
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findAll() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName19,
					_methodParameterTypes19, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName20,
					_methodParameterTypes20, new Object[] { start, end });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
					new Object[] {
						start,
						
					end,
						
					ClpSerializer.translateInput(orderByComparator)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp findByEmpCode(
		java.lang.String empCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
					new Object[] { ClpSerializer.translateInput(empCode) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp findByUser(long empUserId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23, new Object[] { empUserId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findByTitles(
		long titlesId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24, new Object[] { titlesId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> findResignedEmp() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isOnAddingNewWithSameEmployeeCode(long prePersistedEmpId,
		java.lang.String empCode) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] {
						prePersistedEmpId,
						
					ClpSerializer.translateInput(empCode)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public int countAllUnDeletedIndexedEmpDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filterQueries),
						
					companyId,
						
					ClpSerializer.translateInput(sort)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmpIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filterQueries),
						
					companyId,
						
					ClpSerializer.translateInput(sort),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.kernel.search.Document>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countFilterEmployeeByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId)
		throws com.liferay.portal.kernel.search.ParseException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filters),
						
					ClpSerializer.translateInput(sort),
						
					companyId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.search.ParseException) {
				throw (com.liferay.portal.kernel.search.ParseException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Integer)returnObj).intValue();
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterEmployeeByFields(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.Map<java.lang.String, java.lang.Object> filters,
		com.liferay.portal.kernel.search.Sort sort, long companyId, int start,
		int end) throws com.liferay.portal.kernel.search.ParseException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filters),
						
					ClpSerializer.translateInput(sort),
						
					companyId,
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.search.ParseException) {
				throw (com.liferay.portal.kernel.search.ParseException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.kernel.search.Document>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> filterEmployeeByAutocompleteQuery(
		java.lang.String query,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		int start, int end)
		throws com.liferay.portal.kernel.search.ParseException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31,
					new Object[] {
						ClpSerializer.translateInput(query),
						
					ClpSerializer.translateInput(searchContext),
						
					start,
						
					end
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.search.ParseException) {
				throw (com.liferay.portal.kernel.search.ParseException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.kernel.search.Document>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean isOrganizationFilter(java.lang.String filterProperty) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
					new Object[] { ClpSerializer.translateInput(filterProperty) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void createDateTermRangeQuery(java.lang.String field,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		java.util.Date dateFrom, java.util.Date dateTo,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		try {
			_invokableLocalService.invokeMethod(_methodName33,
				_methodParameterTypes33,
				new Object[] {
					ClpSerializer.translateInput(field),
					
				ClpSerializer.translateInput(queries),
					
				ClpSerializer.translateInput(dateFrom),
					
				ClpSerializer.translateInput(dateTo),
					
				ClpSerializer.translateInput(searchContext)
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public com.liferay.portal.kernel.search.Query createDateTermRangeQuery(
		java.lang.String field, java.util.Date dateFrom, java.util.Date dateTo,
		boolean includesLower, boolean includesUpper,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						ClpSerializer.translateInput(field),
						
					ClpSerializer.translateInput(dateFrom),
						
					ClpSerializer.translateInput(dateTo),
						
					includesLower,
						
					includesUpper,
						
					ClpSerializer.translateInput(searchContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.search.Query)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.search.Query createStringListQuery(
		java.lang.String property, java.util.List<java.lang.String> values,
		com.liferay.portal.kernel.search.SearchContext searchContext)
		throws com.liferay.portal.kernel.search.ParseException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						ClpSerializer.translateInput(property),
						
					ClpSerializer.translateInput(values),
						
					ClpSerializer.translateInput(searchContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.search.ParseException) {
				throw (com.liferay.portal.kernel.search.ParseException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.search.Query)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String[] getGlobalSearchFields() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String[])ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String removeDashChar(java.lang.String s) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
					new Object[] { ClpSerializer.translateInput(s) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Date getCurrentDateNextYear() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Date)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp createPrePersistedEntity(
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] { ClpSerializer.translateInput(serviceContext) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User generatedUser, boolean autoPassword,
		java.lang.String password1, java.lang.String password2,
		boolean autoScreenName, java.lang.String screenName, boolean male,
		boolean sendEmail,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					ClpSerializer.translateInput(generatedUser),
						
					autoPassword,
						
					ClpSerializer.translateInput(password1),
						
					ClpSerializer.translateInput(password2),
						
					autoScreenName,
						
					ClpSerializer.translateInput(screenName),
						
					male,
						
					sendEmail,
						
					ClpSerializer.translateInput(addresses),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					isImportAction,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					ClpSerializer.translateInput(user),
						
					ClpSerializer.translateInput(addressesMap),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addEmp(
		vn.com.ecopharma.emp.model.Emp employee, boolean autoPassword,
		java.lang.String password1, java.lang.String password2,
		boolean autoScreenName, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.lang.String openId, java.util.Locale locale,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName42,
					_methodParameterTypes42,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					autoPassword,
						
					ClpSerializer.translateInput(password1),
						
					ClpSerializer.translateInput(password2),
						
					autoScreenName,
						
					ClpSerializer.translateInput(screenName),
						
					ClpSerializer.translateInput(emailAddress),
						
					facebookId,
						
					ClpSerializer.translateInput(openId),
						
					ClpSerializer.translateInput(locale),
						
					ClpSerializer.translateInput(firstName),
						
					ClpSerializer.translateInput(middleName),
						
					ClpSerializer.translateInput(lastName),
						
					prefixId,
						
					suffixId,
						
					male,
						
					birthdayMonth,
						
					birthdayDay,
						
					birthdayYear,
						
					ClpSerializer.translateInput(groupIds),
						
					ClpSerializer.translateInput(organizationIds),
						
					ClpSerializer.translateInput(roleIds),
						
					ClpSerializer.translateInput(userGroupIds),
						
					sendEmail,
						
					ClpSerializer.translateInput(addresses),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					isImportAction,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp update(
		vn.com.ecopharma.emp.model.Emp employee, long userId, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName43,
					_methodParameterTypes43,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					userId,
						
					oldTitlesId,
						
					ClpSerializer.translateInput(addressesMap),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					isImportAction,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp update(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName44,
					_methodParameterTypes44,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					ClpSerializer.translateInput(user),
						
					oldTitlesId,
						
					ClpSerializer.translateInput(addressesMap),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					isImportAction,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp updateExistedEmployee(
		vn.com.ecopharma.emp.model.Emp employee, java.lang.String employeeCode,
		long titlesId, long unitGroupId, long unitId, long departmentId,
		long levelId, java.util.Date promotedDate, java.util.Date joinedDate,
		java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, int laborContractSignedTime,
		java.util.Date dob, java.lang.String gender,
		java.lang.String placeOfBirth, java.lang.String education,
		java.lang.String educationSpecialize, long specializedId,
		long universityId, java.lang.String maritalStatus,
		java.lang.String identityCardNo, java.util.Date issuedDate,
		java.lang.String issuedPlace, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		int numberOfDependents, java.lang.String dependentNames,
		java.lang.String insurranceCode, java.lang.String healthInsuranceNo) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName45,
					_methodParameterTypes45,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					ClpSerializer.translateInput(employeeCode),
						
					titlesId,
						
					unitGroupId,
						
					unitId,
						
					departmentId,
						
					levelId,
						
					ClpSerializer.translateInput(promotedDate),
						
					ClpSerializer.translateInput(joinedDate),
						
					ClpSerializer.translateInput(laborContractSignedDate),
						
					ClpSerializer.translateInput(laborContractExpiredDate),
						
					ClpSerializer.translateInput(laborContractType),
						
					laborContractSignedTime,
						
					ClpSerializer.translateInput(dob),
						
					ClpSerializer.translateInput(gender),
						
					ClpSerializer.translateInput(placeOfBirth),
						
					ClpSerializer.translateInput(education),
						
					ClpSerializer.translateInput(educationSpecialize),
						
					specializedId,
						
					universityId,
						
					ClpSerializer.translateInput(maritalStatus),
						
					ClpSerializer.translateInput(identityCardNo),
						
					ClpSerializer.translateInput(issuedDate),
						
					ClpSerializer.translateInput(issuedPlace),
						
					ClpSerializer.translateInput(contactNumber),
						
					ClpSerializer.translateInput(companyEmailAddress),
						
					ClpSerializer.translateInput(taxCode),
						
					numberOfDependents,
						
					ClpSerializer.translateInput(dependentNames),
						
					ClpSerializer.translateInput(insurranceCode),
						
					ClpSerializer.translateInput(healthInsuranceNo)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addOrUpdateWithExistUser(
		vn.com.ecopharma.emp.model.Emp employee,
		com.liferay.portal.model.User user, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName46,
					_methodParameterTypes46,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					ClpSerializer.translateInput(user),
						
					oldTitlesId,
						
					ClpSerializer.translateInput(addressesMap),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					isImportAction,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp addOrUpdateWithExistUser(
		vn.com.ecopharma.emp.model.Emp employee,
		java.lang.String userScreenName, long oldTitlesId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		java.util.Map<java.lang.String, java.lang.Boolean> dependentNameMap,
		java.util.Map<vn.com.ecopharma.emp.model.EmpBankInfo, java.lang.Boolean> bankInfoMap,
		boolean isImportAction,
		com.liferay.portal.service.ServiceContext serviceContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName47,
					_methodParameterTypes47,
					new Object[] {
						ClpSerializer.translateInput(employee),
						
					ClpSerializer.translateInput(userScreenName),
						
					oldTitlesId,
						
					ClpSerializer.translateInput(addressesMap),
						
					ClpSerializer.translateInput(dependentNameMap),
						
					ClpSerializer.translateInput(bankInfoMap),
						
					isImportAction,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp createEmployee(
		java.lang.String employeeCode, long titlesId, long unitGroupId,
		long unitId, long departmentId, long levelId,
		java.util.Date promotedDate, java.util.Date joinedDate,
		java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, int laborContractSignedTime,
		java.util.Date dob, java.lang.String gender,
		java.lang.String placeOfBirth, java.lang.String education,
		java.lang.String educationSpecialize, long specializedId,
		long universityId, java.lang.String maritalStatus,
		java.lang.String identityCardNo, java.util.Date issuedDate,
		java.lang.String issuedPlace, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		int numberOfDependents, java.lang.String dependentNames,
		java.lang.String insurranceCode, java.lang.String healthInsuranceNo) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName48,
					_methodParameterTypes48,
					new Object[] {
						ClpSerializer.translateInput(employeeCode),
						
					titlesId,
						
					unitGroupId,
						
					unitId,
						
					departmentId,
						
					levelId,
						
					ClpSerializer.translateInput(promotedDate),
						
					ClpSerializer.translateInput(joinedDate),
						
					ClpSerializer.translateInput(laborContractSignedDate),
						
					ClpSerializer.translateInput(laborContractExpiredDate),
						
					ClpSerializer.translateInput(laborContractType),
						
					laborContractSignedTime,
						
					ClpSerializer.translateInput(dob),
						
					ClpSerializer.translateInput(gender),
						
					ClpSerializer.translateInput(placeOfBirth),
						
					ClpSerializer.translateInput(education),
						
					ClpSerializer.translateInput(educationSpecialize),
						
					specializedId,
						
					universityId,
						
					ClpSerializer.translateInput(maritalStatus),
						
					ClpSerializer.translateInput(identityCardNo),
						
					ClpSerializer.translateInput(issuedDate),
						
					ClpSerializer.translateInput(issuedPlace),
						
					ClpSerializer.translateInput(contactNumber),
						
					ClpSerializer.translateInput(companyEmailAddress),
						
					ClpSerializer.translateInput(taxCode),
						
					numberOfDependents,
						
					ClpSerializer.translateInput(dependentNames),
						
					ClpSerializer.translateInput(insurranceCode),
						
					ClpSerializer.translateInput(healthInsuranceNo)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getViFullnameFromUser(
		com.liferay.portal.model.User user) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName49,
					_methodParameterTypes49,
					new Object[] { ClpSerializer.translateInput(user) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp updateEmpAddresses(
		java.lang.String empCode, java.lang.String address,
		vn.com.ecopharma.emp.model.District district,
		com.liferay.portal.model.Region region, long countryId,
		boolean isPrimary,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName50,
					_methodParameterTypes50,
					new Object[] {
						ClpSerializer.translateInput(empCode),
						
					ClpSerializer.translateInput(address),
						
					ClpSerializer.translateInput(district),
						
					ClpSerializer.translateInput(region),
						
					countryId,
						
					isPrimary,
						
					ClpSerializer.translateInput(serviceContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.PortalException) {
				throw (com.liferay.portal.kernel.exception.PortalException)t;
			}

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void removeAllExistingEmpAddresses(java.lang.String empCode,
		long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName51,
				_methodParameterTypes51,
				new Object[] { ClpSerializer.translateInput(empCode), companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void removeAllExistingEmpAddresses(long empId, long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName52,
				_methodParameterTypes52, new Object[] { empId, companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmpDocs(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> queries,
		long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName53,
					_methodParameterTypes53,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(queries),
						
					companyId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.kernel.search.Document>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmp(
		java.lang.String employeeIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName54,
					_methodParameterTypes54,
					new Object[] {
						ClpSerializer.translateInput(employeeIdString),
						
					ClpSerializer.translateInput(searchContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.search.Document)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmp(
		long employeeId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName55,
					_methodParameterTypes55,
					new Object[] {
						employeeId,
						
					ClpSerializer.translateInput(searchContext)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.kernel.search.Document)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp markDeletedEmp(
		vn.com.ecopharma.emp.model.Emp employee) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName56,
					_methodParameterTypes56,
					new Object[] { ClpSerializer.translateInput(employee) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.Emp markDeletedEmp(long employeeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName57,
					_methodParameterTypes57, new Object[] { employeeId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (vn.com.ecopharma.emp.model.Emp)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void indexAllEmps() {
		try {
			_invokableLocalService.invokeMethod(_methodName58,
				_methodParameterTypes58, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void indexSomeEmps() {
		try {
			_invokableLocalService.invokeMethod(_methodName59,
				_methodParameterTypes59, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void removeAllEmpIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName60,
				_methodParameterTypes60,
				new Object[] {
					ClpSerializer.translateInput(searchContext),
					
				companyId
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void completelyRemoveAllEmp(long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName61,
				_methodParameterTypes61, new Object[] { companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public void completelyRemoveAllEmpFromDB(long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName62,
				_methodParameterTypes62, new Object[] { companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public java.lang.String getUserEmployeeCodeValue(long userId, long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName63,
					_methodParameterTypes63, new Object[] { userId, companyId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public void addOrUpdateUserEmployeeCodeValue(
		java.lang.String employeeCode, long userId, long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName64,
				_methodParameterTypes64,
				new Object[] {
					ClpSerializer.translateInput(employeeCode),
					
				userId,
					
				companyId
				});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	@Override
	public boolean isUserExisted(java.lang.String generatedScreenName,
		java.lang.String employeeCode, java.util.Date empDoB, long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName65,
					_methodParameterTypes65,
					new Object[] {
						ClpSerializer.translateInput(generatedScreenName),
						
					ClpSerializer.translateInput(employeeCode),
						
					ClpSerializer.translateInput(empDoB),
						
					companyId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean isSameOrWrongOrderDoB(java.util.Date empDob,
		java.util.Date userEmpDob) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName66,
					_methodParameterTypes66,
					new Object[] {
						ClpSerializer.translateInput(empDob),
						
					ClpSerializer.translateInput(userEmpDob)
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public java.lang.String regenerateDuplicateEmailAddress(
		java.lang.String emailAddress, int number, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName67,
					_methodParameterTypes67,
					new Object[] {
						ClpSerializer.translateInput(emailAddress),
						
					number,
						
					companyId
					});
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.model.Address> findAllEmpAddress(
		long companyId, long employeeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName68,
					_methodParameterTypes68,
					new Object[] { companyId, employeeId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<com.liferay.portal.model.Address>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.model.Address getPresentAddress(long companyId,
		long employeeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName69,
					_methodParameterTypes69,
					new Object[] { companyId, employeeId });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (com.liferay.portal.model.Address)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.Emp> getEmpsFromEmpNotifyEmails(
		java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail> empNotifyEmails)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName70,
					_methodParameterTypes70,
					new Object[] { ClpSerializer.translateInput(empNotifyEmails) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.List<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<vn.com.ecopharma.emp.model.Department> getUniqueDepartmentsFromEmps(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName71,
					_methodParameterTypes71,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<vn.com.ecopharma.emp.model.Department>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<java.lang.String> getAllManagerEmailsFromDepartments(
		java.util.Collection<vn.com.ecopharma.emp.model.Department> departments)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName72,
					_methodParameterTypes72,
					new Object[] { ClpSerializer.translateInput(departments) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<com.liferay.portal.model.User> getUsersByEmps(
		java.util.Collection<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName73,
					_methodParameterTypes73,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<com.liferay.portal.model.User>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<java.lang.String> getEmailsFromUsers(
		java.util.Collection<com.liferay.portal.model.User> users) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName74,
					_methodParameterTypes74,
					new Object[] { ClpSerializer.translateInput(users) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<java.lang.String> getEmailsFromEmps(
		java.util.Collection<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName75,
					_methodParameterTypes75,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<vn.com.ecopharma.emp.model.Emp> getEmpsByEmpOrgRelationships(
		java.util.List<vn.com.ecopharma.emp.model.EmpOrgRelationship> empManagers)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName76,
					_methodParameterTypes76,
					new Object[] { ClpSerializer.translateInput(empManagers) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<vn.com.ecopharma.emp.model.Emp>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.Set<java.lang.String> getManagerEmailsForNewEmpsNotification(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName77,
					_methodParameterTypes77,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.util.Set<java.lang.String>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getNewEmployeesHtmlTable(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName78,
					_methodParameterTypes78,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.lang.String getEntireNewEmployeesHtmlMailContent(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName79,
					_methodParameterTypes79,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return (java.lang.String)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public boolean sendNewEmpsNotificationEmail(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName80,
					_methodParameterTypes80,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public boolean testSendNewEmpsNotificationEmail(
		java.util.List<vn.com.ecopharma.emp.model.Emp> emps) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName81,
					_methodParameterTypes81,
					new Object[] { ClpSerializer.translateInput(emps) });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}

		return ((Boolean)returnObj).booleanValue();
	}

	@Override
	public void fixLaborContractSignedDate()
		throws com.liferay.portal.kernel.exception.SystemException,
			java.text.ParseException {
		try {
			_invokableLocalService.invokeMethod(_methodName82,
				_methodParameterTypes82, new Object[] {  });
		}
		catch (Throwable t) {
			t = ClpSerializer.translateThrowable(t);

			if (t instanceof com.liferay.portal.kernel.exception.SystemException) {
				throw (com.liferay.portal.kernel.exception.SystemException)t;
			}

			if (t instanceof java.text.ParseException) {
				throw (java.text.ParseException)t;
			}

			if (t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			else {
				throw new RuntimeException(t.getClass().getName() +
					" is not a valid exception");
			}
		}
	}

	private InvokableLocalService _invokableLocalService;
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
	private String _methodName16;
	private String[] _methodParameterTypes16;
	private String _methodName17;
	private String[] _methodParameterTypes17;
	private String _methodName19;
	private String[] _methodParameterTypes19;
	private String _methodName20;
	private String[] _methodParameterTypes20;
	private String _methodName21;
	private String[] _methodParameterTypes21;
	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName24;
	private String[] _methodParameterTypes24;
	private String _methodName25;
	private String[] _methodParameterTypes25;
	private String _methodName26;
	private String[] _methodParameterTypes26;
	private String _methodName27;
	private String[] _methodParameterTypes27;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName38;
	private String[] _methodParameterTypes38;
	private String _methodName39;
	private String[] _methodParameterTypes39;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
	private String _methodName61;
	private String[] _methodParameterTypes61;
	private String _methodName62;
	private String[] _methodParameterTypes62;
	private String _methodName63;
	private String[] _methodParameterTypes63;
	private String _methodName64;
	private String[] _methodParameterTypes64;
	private String _methodName65;
	private String[] _methodParameterTypes65;
	private String _methodName66;
	private String[] _methodParameterTypes66;
	private String _methodName67;
	private String[] _methodParameterTypes67;
	private String _methodName68;
	private String[] _methodParameterTypes68;
	private String _methodName69;
	private String[] _methodParameterTypes69;
	private String _methodName70;
	private String[] _methodParameterTypes70;
	private String _methodName71;
	private String[] _methodParameterTypes71;
	private String _methodName72;
	private String[] _methodParameterTypes72;
	private String _methodName73;
	private String[] _methodParameterTypes73;
	private String _methodName74;
	private String[] _methodParameterTypes74;
	private String _methodName75;
	private String[] _methodParameterTypes75;
	private String _methodName76;
	private String[] _methodParameterTypes76;
	private String _methodName77;
	private String[] _methodParameterTypes77;
	private String _methodName78;
	private String[] _methodParameterTypes78;
	private String _methodName79;
	private String[] _methodParameterTypes79;
	private String _methodName80;
	private String[] _methodParameterTypes80;
	private String _methodName81;
	private String[] _methodParameterTypes81;
	private String _methodName82;
	private String[] _methodParameterTypes82;
}