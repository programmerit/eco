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
public class EcoEmployeeLocalServiceClp implements EcoEmployeeLocalService {
	public EcoEmployeeLocalServiceClp(
		InvokableLocalService invokableLocalService) {
		_invokableLocalService = invokableLocalService;

		_methodName0 = "addEcoEmployee";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.EcoEmployee"
			};

		_methodName1 = "createEcoEmployee";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteEcoEmployee";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteEcoEmployee";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.EcoEmployee"
			};

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

		_methodName10 = "fetchEcoEmployee";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getEcoEmployee";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getEcoEmployees";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getEcoEmployeesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateEcoEmployee";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.EcoEmployee"
			};

		_methodName16 = "getBeanIdentifier";

		_methodParameterTypes16 = new String[] {  };

		_methodName17 = "setBeanIdentifier";

		_methodParameterTypes17 = new String[] { "java.lang.String" };

		_methodName19 = "indexAllEmployees";

		_methodParameterTypes19 = new String[] {  };

		_methodName20 = "removeAllEmployeeIndexes";

		_methodParameterTypes20 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName21 = "countAllIndexedEmployeeDocuments";

		_methodParameterTypes21 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName22 = "countAllUnDeletedIndexedEmployeeDocuments";

		_methodParameterTypes22 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName23 = "searchAllUnDeletedEmployeeIndexedDocument";

		_methodParameterTypes23 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName24 = "searchAllUnDeletedEmployeeIndexedDocumentWithConditionEmployeeList";

		_methodParameterTypes24 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long", "java.util.List", "boolean",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName25 = "countAllUnDeletedIndexedEmployeeDocumentWithConditionEmployeeList";

		_methodParameterTypes25 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long", "java.util.List", "boolean",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName26 = "searchAllUnDeletedEmployeeIndexedDocumentByName";

		_methodParameterTypes26 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName27 = "searchAllEmployeeIndexedDocuments";

		_methodParameterTypes27 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName28 = "searchAllEmployeeIndexedDocuments";

		_methodParameterTypes28 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long", "int", "int"
			};

		_methodName29 = "searchAllEmployeeIndexedDocuments";

		_methodParameterTypes29 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName30 = "findAll";

		_methodParameterTypes30 = new String[] {  };

		_methodName31 = "findAll";

		_methodParameterTypes31 = new String[] { "int", "int" };

		_methodName32 = "findAll";

		_methodParameterTypes32 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName33 = "filterEmployees";

		_methodParameterTypes33 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.List", "java.lang.Long",
				"java.lang.String", "java.lang.String", "int", "int", "boolean",
				"java.lang.String", "java.lang.String"
			};

		_methodName34 = "addEmployee";

		_methodParameterTypes34 = new String[] {
				"vn.com.ecopharma.emp.model.EcoEmployee", "boolean",
				"java.lang.String", "java.lang.String", "boolean",
				"java.lang.String", "java.lang.String", "long",
				"java.lang.String", "java.util.Locale", "java.lang.String",
				"java.lang.String", "java.lang.String", "int", "int", "boolean",
				"int", "int", "int", "long[][]", "long[][]", "long[][]",
				"long[][]", "boolean", "long", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName35 = "update";

		_methodParameterTypes35 = new String[] {
				"vn.com.ecopharma.emp.model.EcoEmployee",
				"com.liferay.portal.model.User",
				"vn.com.ecopharma.emp.model.SubUnit",
				"vn.com.ecopharma.emp.model.Titles",
				"vn.com.ecopharma.emp.model.Level",
				"vn.com.ecopharma.emp.model.University", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName36 = "createEcoEmployee";

		_methodParameterTypes36 = new String[] {
				"java.lang.String", "long", "long", "long", "java.util.Date",
				"long", "java.util.Date", "java.util.Date", "java.util.Date",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName37 = "getIndexedEmployee";

		_methodParameterTypes37 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName38 = "getIndexedEmployee";

		_methodParameterTypes38 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName39 = "markDeletedEmployee";

		_methodParameterTypes39 = new String[] {
				"vn.com.ecopharma.emp.model.EcoEmployee"
			};

		_methodName40 = "markDeletedEmployee";

		_methodParameterTypes40 = new String[] { "long" };

		_methodName41 = "countAll";

		_methodParameterTypes41 = new String[] {  };
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee addEcoEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName0,
					_methodParameterTypes0,
					new Object[] { ClpSerializer.translateInput(ecoEmployee) });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee createEcoEmployee(
		long ecoEmployeeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName1,
					_methodParameterTypes1, new Object[] { ecoEmployeeId });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee deleteEcoEmployee(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName2,
					_methodParameterTypes2, new Object[] { ecoEmployeeId });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee deleteEcoEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName3,
					_methodParameterTypes3,
					new Object[] { ClpSerializer.translateInput(ecoEmployee) });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
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
	public vn.com.ecopharma.emp.model.EcoEmployee fetchEcoEmployee(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName10,
					_methodParameterTypes10, new Object[] { ecoEmployeeId });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee getEcoEmployee(
		long ecoEmployeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName11,
					_methodParameterTypes11, new Object[] { ecoEmployeeId });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
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
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> getEcoEmployees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
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

		return (java.util.List<vn.com.ecopharma.emp.model.EcoEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int getEcoEmployeesCount()
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
	public vn.com.ecopharma.emp.model.EcoEmployee updateEcoEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee ecoEmployee)
		throws com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName15,
					_methodParameterTypes15,
					new Object[] { ClpSerializer.translateInput(ecoEmployee) });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
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
	public void indexAllEmployees() {
		try {
			_invokableLocalService.invokeMethod(_methodName19,
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
	}

	@Override
	public void removeAllEmployeeIndexes(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		try {
			_invokableLocalService.invokeMethod(_methodName20,
				_methodParameterTypes20,
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
	public int countAllIndexedEmployeeDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName21,
					_methodParameterTypes21,
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

		return ((Integer)returnObj).intValue();
	}

	@Override
	public int countAllUnDeletedIndexedEmployeeDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName22,
					_methodParameterTypes22,
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
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocument(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName23,
					_methodParameterTypes23,
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
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocumentWithConditionEmployeeList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> employeeIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort,
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName24,
					_methodParameterTypes24,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filterQueries),
						
					companyId,
						
					ClpSerializer.translateInput(employeeIds),
						
					isExcluded,
						
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
	public int countAllUnDeletedIndexedEmployeeDocumentWithConditionEmployeeList(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, java.util.List<java.lang.Long> employeeIds,
		boolean isExcluded, com.liferay.portal.kernel.search.Sort sort) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName25,
					_methodParameterTypes25,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filterQueries),
						
					companyId,
						
					ClpSerializer.translateInput(employeeIds),
						
					isExcluded,
						
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
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllUnDeletedEmployeeIndexedDocumentByName(
		java.lang.String name,
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName26,
					_methodParameterTypes26,
					new Object[] {
						ClpSerializer.translateInput(name),
						
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

		return (java.util.List<com.liferay.portal.kernel.search.Document>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		long companyId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName27,
					_methodParameterTypes27,
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

		return (java.util.List<com.liferay.portal.kernel.search.Document>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName28,
					_methodParameterTypes28,
					new Object[] {
						ClpSerializer.translateInput(searchContext),
						
					ClpSerializer.translateInput(filterQueries),
						
					companyId,
						
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
	public java.util.List<com.liferay.portal.kernel.search.Document> searchAllEmployeeIndexedDocuments(
		com.liferay.portal.kernel.search.SearchContext searchContext,
		java.util.List<com.liferay.portal.kernel.search.Query> filterQueries,
		long companyId, com.liferay.portal.kernel.search.Sort sort, int start,
		int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName29,
					_methodParameterTypes29,
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
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName30,
					_methodParameterTypes30, new Object[] {  });
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

		return (java.util.List<vn.com.ecopharma.emp.model.EcoEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll(
		int start, int end) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName31,
					_methodParameterTypes31, new Object[] { start, end });
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

		return (java.util.List<vn.com.ecopharma.emp.model.EcoEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName32,
					_methodParameterTypes32,
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

		return (java.util.List<vn.com.ecopharma.emp.model.EcoEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public java.util.List<vn.com.ecopharma.emp.model.EcoEmployee> filterEmployees(
		java.lang.String globStr, java.lang.String fullName,
		java.lang.String emp_code, java.lang.String gender,
		java.lang.String contact_number, java.lang.String joined_date_from,
		java.lang.String joined_date_to,
		java.util.List<java.lang.String> jobTitles, java.lang.Long subUnitId,
		java.lang.String promoted_date_from, java.lang.String promoted_date_to,
		int start, int end, boolean isDeleted, java.lang.String sortField,
		java.lang.String sortOrder) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName33,
					_methodParameterTypes33,
					new Object[] {
						ClpSerializer.translateInput(globStr),
						
					ClpSerializer.translateInput(fullName),
						
					ClpSerializer.translateInput(emp_code),
						
					ClpSerializer.translateInput(gender),
						
					ClpSerializer.translateInput(contact_number),
						
					ClpSerializer.translateInput(joined_date_from),
						
					ClpSerializer.translateInput(joined_date_to),
						
					ClpSerializer.translateInput(jobTitles),
						
					ClpSerializer.translateInput(subUnitId),
						
					ClpSerializer.translateInput(promoted_date_from),
						
					ClpSerializer.translateInput(promoted_date_to),
						
					start,
						
					end,
						
					isDeleted,
						
					ClpSerializer.translateInput(sortField),
						
					ClpSerializer.translateInput(sortOrder)
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

		return (java.util.List<vn.com.ecopharma.emp.model.EcoEmployee>)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee addEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee e, boolean autoPassword,
		java.lang.String password1, java.lang.String password2,
		boolean autoScreenName, java.lang.String screenName,
		java.lang.String emailAddress, long facebookId,
		java.lang.String openId, java.util.Locale locale,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, int prefixId, int suffixId, boolean male,
		int birthdayMonth, int birthdayDay, int birthdayYear, long[] groupIds,
		long[] organizationIds, long[] roleIds, long[] userGroupIds,
		boolean sendEmail, long emp_userId,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addresses,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName34,
					_methodParameterTypes34,
					new Object[] {
						ClpSerializer.translateInput(e),
						
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
						
					emp_userId,
						
					ClpSerializer.translateInput(addresses),
						
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee update(
		vn.com.ecopharma.emp.model.EcoEmployee EcoEmployee,
		com.liferay.portal.model.User user,
		vn.com.ecopharma.emp.model.SubUnit subUnit,
		vn.com.ecopharma.emp.model.Titles titles,
		vn.com.ecopharma.emp.model.Level level,
		vn.com.ecopharma.emp.model.University university,
		java.util.Map<com.liferay.portal.model.Address, java.lang.Boolean> addressesMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName35,
					_methodParameterTypes35,
					new Object[] {
						ClpSerializer.translateInput(EcoEmployee),
						
					ClpSerializer.translateInput(user),
						
					ClpSerializer.translateInput(subUnit),
						
					ClpSerializer.translateInput(titles),
						
					ClpSerializer.translateInput(level),
						
					ClpSerializer.translateInput(university),
						
					ClpSerializer.translateInput(addressesMap),
						
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee createEcoEmployee(
		java.lang.String emp_code, long jTitlesId, long titlesId, long levelId,
		java.util.Date promoted_date, long subUnitId,
		java.util.Date joined_date, java.util.Date laborContractSignedDate,
		java.util.Date laborContractExpiredDate,
		java.lang.String laborContractType, java.util.Date dob,
		java.lang.String gender, java.lang.String placeOfBirth,
		java.lang.String education, java.lang.String education_specialize,
		long universityId, java.lang.String marrital_status,
		java.lang.String identityCard_no, java.util.Date issued_date,
		java.lang.String issued_place, java.lang.String contactNumber,
		java.lang.String companyEmailAddress, java.lang.String taxCode,
		java.lang.String insurranceCode, java.lang.String bankNo,
		java.lang.String bankBranchName) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName36,
					_methodParameterTypes36,
					new Object[] {
						ClpSerializer.translateInput(emp_code),
						
					jTitlesId,
						
					titlesId,
						
					levelId,
						
					ClpSerializer.translateInput(promoted_date),
						
					subUnitId,
						
					ClpSerializer.translateInput(joined_date),
						
					ClpSerializer.translateInput(laborContractSignedDate),
						
					ClpSerializer.translateInput(laborContractExpiredDate),
						
					ClpSerializer.translateInput(laborContractType),
						
					ClpSerializer.translateInput(dob),
						
					ClpSerializer.translateInput(gender),
						
					ClpSerializer.translateInput(placeOfBirth),
						
					ClpSerializer.translateInput(education),
						
					ClpSerializer.translateInput(education_specialize),
						
					universityId,
						
					ClpSerializer.translateInput(marrital_status),
						
					ClpSerializer.translateInput(identityCard_no),
						
					ClpSerializer.translateInput(issued_date),
						
					ClpSerializer.translateInput(issued_place),
						
					ClpSerializer.translateInput(contactNumber),
						
					ClpSerializer.translateInput(companyEmailAddress),
						
					ClpSerializer.translateInput(taxCode),
						
					ClpSerializer.translateInput(insurranceCode),
						
					ClpSerializer.translateInput(bankNo),
						
					ClpSerializer.translateInput(bankBranchName)
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public com.liferay.portal.kernel.search.Document getIndexedEmployee(
		java.lang.String employeeIdString,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName37,
					_methodParameterTypes37,
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
	public com.liferay.portal.kernel.search.Document getIndexedEmployee(
		long ecoEmployeeId,
		com.liferay.portal.kernel.search.SearchContext searchContext) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName38,
					_methodParameterTypes38,
					new Object[] {
						ecoEmployeeId,
						
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
	public vn.com.ecopharma.emp.model.EcoEmployee markDeletedEmployee(
		vn.com.ecopharma.emp.model.EcoEmployee EcoEmployee) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName39,
					_methodParameterTypes39,
					new Object[] { ClpSerializer.translateInput(EcoEmployee) });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public vn.com.ecopharma.emp.model.EcoEmployee markDeletedEmployee(
		long ecoEmployeeId) {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName40,
					_methodParameterTypes40, new Object[] { ecoEmployeeId });
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

		return (vn.com.ecopharma.emp.model.EcoEmployee)ClpSerializer.translateOutput(returnObj);
	}

	@Override
	public int countAll() {
		Object returnObj = null;

		try {
			returnObj = _invokableLocalService.invokeMethod(_methodName41,
					_methodParameterTypes41, new Object[] {  });
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
}