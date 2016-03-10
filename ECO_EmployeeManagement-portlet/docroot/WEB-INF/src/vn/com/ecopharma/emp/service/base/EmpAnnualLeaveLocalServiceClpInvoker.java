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

import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class EmpAnnualLeaveLocalServiceClpInvoker {
	public EmpAnnualLeaveLocalServiceClpInvoker() {
		_methodName0 = "addEmpAnnualLeave";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave"
			};

		_methodName1 = "createEmpAnnualLeave";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteEmpAnnualLeave";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteEmpAnnualLeave";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave"
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

		_methodName10 = "fetchEmpAnnualLeave";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getEmpAnnualLeave";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getEmpAnnualLeaves";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getEmpAnnualLeavesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateEmpAnnualLeave";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave"
			};

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

		_methodName189 = "createPrePersistedEntity";

		_methodParameterTypes189 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName190 = "addEmpAnnualLeave";

		_methodParameterTypes190 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave", "long", "int",
				"double", "double"
			};

		_methodName191 = "addEmpAnnualLeave";

		_methodParameterTypes191 = new String[] {
				"long", "int", "double", "double",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName192 = "updateEmpAnnualLeave";

		_methodParameterTypes192 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave"
			};

		_methodName193 = "fetchByEmp";

		_methodParameterTypes193 = new String[] { "long" };

		_methodName194 = "getDatesBetweenTwoDates";

		_methodParameterTypes194 = new String[] {
				"java.util.Date", "java.util.Date", "boolean", "boolean"
			};

		_methodName195 = "countAllDocuments";

		_methodParameterTypes195 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName196 = "searchAllDocuments";

		_methodParameterTypes196 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName197 = "filterByFields";

		_methodParameterTypes197 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName198 = "countFilterByFields";

		_methodParameterTypes198 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName199 = "getIndexedDocument";

		_methodParameterTypes199 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName200 = "getIndexedDocument";

		_methodParameterTypes200 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName201 = "indexAll";

		_methodParameterTypes201 = new String[] {  };

		_methodName202 = "removeAllIndexes";

		_methodParameterTypes202 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName203 = "applyLeaveForEmp";

		_methodParameterTypes203 = new String[] {
				"long", "double", "com.liferay.portal.service.ServiceContext"
			};

		_methodName204 = "scanAndAutoAddVacationLeave";

		_methodParameterTypes204 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName205 = "calculateTotalAnnualLeaveByJoinedDate";

		_methodParameterTypes205 = new String[] { "java.util.Date" };

		_methodName206 = "getMonthsBetweenTwoDate";

		_methodParameterTypes206 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName207 = "addOneDayForEachEmp";

		_methodParameterTypes207 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.addEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.createEmpAnnualLeave(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.deleteEmpAnnualLeave(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.deleteEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.fetchEmpAnnualLeave(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getEmpAnnualLeave(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getEmpAnnualLeaves(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getEmpAnnualLeavesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.updateEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.findAll();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.addEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0],
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Double)arguments[3]).doubleValue(),
				((Double)arguments[4]).doubleValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.addEmpAnnualLeave(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Double)arguments[2]).doubleValue(),
				((Double)arguments[3]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.updateEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.fetchByEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getDatesBetweenTwoDates((java.util.Date)arguments[0],
				(java.util.Date)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.countAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.searchAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.filterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.countFilterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getIndexedDocument((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getIndexedDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.indexAll();

			return null;
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.removeAllIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.applyLeaveForEmp(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.scanAndAutoAddVacationLeave((com.liferay.portal.service.ServiceContext)arguments[0]);

			return null;
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.calculateTotalAnnualLeaveByJoinedDate((java.util.Date)arguments[0]);
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getMonthsBetweenTwoDate((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.addOneDayForEachEmp();

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
}