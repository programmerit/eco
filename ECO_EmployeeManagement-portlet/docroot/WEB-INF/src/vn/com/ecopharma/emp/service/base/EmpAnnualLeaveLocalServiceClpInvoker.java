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

		_methodName207 = "createPrePersistedEntity";

		_methodParameterTypes207 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName208 = "addEmpAnnualLeave";

		_methodParameterTypes208 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave", "long", "double",
				"double", "double"
			};

		_methodName209 = "addEmpAnnualLeave";

		_methodParameterTypes209 = new String[] {
				"long", "double", "double", "double",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName210 = "updateEmpAnnualLeave";

		_methodParameterTypes210 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave"
			};

		_methodName211 = "updateEmpAnnualLeave";

		_methodParameterTypes211 = new String[] {
				"vn.com.ecopharma.emp.model.EmpAnnualLeave", "double", "double",
				"double"
			};

		_methodName212 = "executeFirstAprilQuartzTask";

		_methodParameterTypes212 = new String[] {  };

		_methodName213 = "fetchByEmp";

		_methodParameterTypes213 = new String[] { "long" };

		_methodName214 = "getDatesBetweenTwoDates";

		_methodParameterTypes214 = new String[] {
				"java.util.Date", "java.util.Date", "boolean", "boolean"
			};

		_methodName215 = "countAllDocuments";

		_methodParameterTypes215 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName216 = "searchAllDocuments";

		_methodParameterTypes216 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName217 = "filterByFields";

		_methodParameterTypes217 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName218 = "countFilterByFields";

		_methodParameterTypes218 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName219 = "getIndexedDocument";

		_methodParameterTypes219 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName220 = "getIndexedDocument";

		_methodParameterTypes220 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName221 = "indexAll";

		_methodParameterTypes221 = new String[] {  };

		_methodName222 = "removeAllIndexes";

		_methodParameterTypes222 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName223 = "applyLeaveForEmp";

		_methodParameterTypes223 = new String[] {
				"long", "double", "com.liferay.portal.service.ServiceContext"
			};

		_methodName224 = "applyLeaveForEmp1";

		_methodParameterTypes224 = new String[] {
				"long", "double", "com.liferay.portal.service.ServiceContext"
			};

		_methodName225 = "scanAndAutoAddVacationLeave";

		_methodParameterTypes225 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName226 = "calculateTotalAnnualLeaveByJoinedDate";

		_methodParameterTypes226 = new String[] { "java.util.Date" };

		_methodName227 = "getMonthsBetweenTwoDate";

		_methodParameterTypes227 = new String[] {
				"java.util.Date", "java.util.Date"
			};

		_methodName228 = "addOneDayForEachEmp";

		_methodParameterTypes228 = new String[] {  };
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

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.findAll();
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.addEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0],
				((Long)arguments[1]).longValue(),
				((Double)arguments[2]).doubleValue(),
				((Double)arguments[3]).doubleValue(),
				((Double)arguments[4]).doubleValue());
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.addEmpAnnualLeave(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				((Double)arguments[2]).doubleValue(),
				((Double)arguments[3]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.updateEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0]);
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.updateEmpAnnualLeave((vn.com.ecopharma.emp.model.EmpAnnualLeave)arguments[0],
				((Double)arguments[1]).doubleValue(),
				((Double)arguments[2]).doubleValue(),
				((Double)arguments[3]).doubleValue());
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.executeFirstAprilQuartzTask();

			return null;
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.fetchByEmp(((Long)arguments[0]).longValue());
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getDatesBetweenTwoDates((java.util.Date)arguments[0],
				(java.util.Date)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.countAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.searchAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.filterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.countFilterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getIndexedDocument((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getIndexedDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.indexAll();

			return null;
		}

		if (_methodName222.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes222, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.removeAllIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName223.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes223, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.applyLeaveForEmp(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName224.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes224, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.applyLeaveForEmp1(((Long)arguments[0]).longValue(),
				((Double)arguments[1]).doubleValue(),
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName225.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes225, parameterTypes)) {
			EmpAnnualLeaveLocalServiceUtil.scanAndAutoAddVacationLeave((com.liferay.portal.service.ServiceContext)arguments[0]);

			return null;
		}

		if (_methodName226.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes226, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.calculateTotalAnnualLeaveByJoinedDate((java.util.Date)arguments[0]);
		}

		if (_methodName227.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes227, parameterTypes)) {
			return EmpAnnualLeaveLocalServiceUtil.getMonthsBetweenTwoDate((java.util.Date)arguments[0],
				(java.util.Date)arguments[1]);
		}

		if (_methodName228.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes228, parameterTypes)) {
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
}