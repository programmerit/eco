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

import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class EmpDisciplineLocalServiceClpInvoker {
	public EmpDisciplineLocalServiceClpInvoker() {
		_methodName0 = "addEmpDiscipline";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.EmpDiscipline"
			};

		_methodName1 = "createEmpDiscipline";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteEmpDiscipline";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteEmpDiscipline";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.EmpDiscipline"
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

		_methodName10 = "fetchEmpDiscipline";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getEmpDiscipline";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getEmpDisciplines";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getEmpDisciplinesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateEmpDiscipline";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.EmpDiscipline"
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

		_methodName189 = "countAllDocuments";

		_methodParameterTypes189 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName190 = "searchAllDocuments";

		_methodParameterTypes190 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName191 = "getIndexedDocument";

		_methodParameterTypes191 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName192 = "getIndexedDocument";

		_methodParameterTypes192 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName193 = "createPrePersistedEntity";

		_methodParameterTypes193 = new String[] {
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName194 = "addEmpDiscipline";

		_methodParameterTypes194 = new String[] {
				"vn.com.ecopharma.emp.model.EmpDiscipline",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName195 = "addEmpsDiscipline";

		_methodParameterTypes195 = new String[] {
				"java.util.List", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName196 = "updateEmpDiscipline";

		_methodParameterTypes196 = new String[] {
				"vn.com.ecopharma.emp.model.EmpDiscipline"
			};

		_methodName197 = "updateEmpDiscipline";

		_methodParameterTypes197 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.util.Date", "java.lang.String",
				"java.lang.String"
			};

		_methodName198 = "indexAll";

		_methodParameterTypes198 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.addEmpDiscipline((vn.com.ecopharma.emp.model.EmpDiscipline)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.createEmpDiscipline(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.deleteEmpDiscipline(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.deleteEmpDiscipline((vn.com.ecopharma.emp.model.EmpDiscipline)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.fetchEmpDiscipline(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getEmpDiscipline(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getEmpDisciplines(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getEmpDisciplinesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.updateEmpDiscipline((vn.com.ecopharma.emp.model.EmpDiscipline)arguments[0]);
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			EmpDisciplineLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.findAll();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.countAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.searchAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getIndexedDocument((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.getIndexedDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.createPrePersistedEntity((com.liferay.portal.service.ServiceContext)arguments[0]);
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.addEmpDiscipline((vn.com.ecopharma.emp.model.EmpDiscipline)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName195.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes195, parameterTypes)) {
			EmpDisciplineLocalServiceUtil.addEmpsDiscipline((java.util.List<java.lang.Long>)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(com.liferay.portal.service.ServiceContext)arguments[7]);

			return null;
		}

		if (_methodName196.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes196, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.updateEmpDiscipline((vn.com.ecopharma.emp.model.EmpDiscipline)arguments[0]);
		}

		if (_methodName197.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes197, parameterTypes)) {
			return EmpDisciplineLocalServiceUtil.updateEmpDiscipline(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.util.Date)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			EmpDisciplineLocalServiceUtil.indexAll();

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
}