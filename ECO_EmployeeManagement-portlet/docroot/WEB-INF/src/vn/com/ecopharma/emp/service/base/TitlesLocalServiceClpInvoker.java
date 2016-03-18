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

import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class TitlesLocalServiceClpInvoker {
	public TitlesLocalServiceClpInvoker() {
		_methodName0 = "addTitles";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.Titles"
			};

		_methodName1 = "createTitles";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteTitles";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteTitles";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.Titles"
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

		_methodName10 = "fetchTitles";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getTitles";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getTitleses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getTitlesesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateTitles";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.Titles"
			};

		_methodName192 = "getBeanIdentifier";

		_methodParameterTypes192 = new String[] {  };

		_methodName193 = "setBeanIdentifier";

		_methodParameterTypes193 = new String[] { "java.lang.String" };

		_methodName198 = "findAll";

		_methodParameterTypes198 = new String[] {  };

		_methodName199 = "findAll";

		_methodParameterTypes199 = new String[] { "int", "int" };

		_methodName200 = "findAll";

		_methodParameterTypes200 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName201 = "findFilterListByRelatedFields";

		_methodParameterTypes201 = new String[] {
				"java.util.List", "java.util.List", "java.util.List"
			};

		_methodName202 = "addTitles";

		_methodParameterTypes202 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName203 = "addTitles";

		_methodParameterTypes203 = new String[] {
				"vn.com.ecopharma.emp.model.Titles",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName204 = "addTitles";

		_methodParameterTypes204 = new String[] {
				"vn.com.ecopharma.emp.model.Titles",
				"vn.com.ecopharma.emp.model.UnitGroup",
				"vn.com.ecopharma.emp.model.Unit",
				"vn.com.ecopharma.emp.model.Department",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName205 = "findByDepartmentUnitUnitGroup";

		_methodParameterTypes205 = new String[] { "long", "long", "long" };

		_methodName206 = "findByUnitUnitGroup";

		_methodParameterTypes206 = new String[] { "long", "long" };

		_methodName207 = "findAllByDepartment";

		_methodParameterTypes207 = new String[] { "long" };

		_methodName208 = "findAllByUnit";

		_methodParameterTypes208 = new String[] { "long" };

		_methodName209 = "findByDepartmentOnly";

		_methodParameterTypes209 = new String[] { "long" };

		_methodName210 = "findByUnitOnly";

		_methodParameterTypes210 = new String[] { "long" };

		_methodName211 = "findByUnitGroupOnly";

		_methodParameterTypes211 = new String[] { "long" };

		_methodName212 = "findByName";

		_methodParameterTypes212 = new String[] { "java.lang.String" };

		_methodName213 = "createPrePersistedTitles";

		_methodParameterTypes213 = new String[] {  };

		_methodName214 = "updateTitles";

		_methodParameterTypes214 = new String[] {
				"vn.com.ecopharma.emp.model.Titles"
			};

		_methodName215 = "deleteTitles";

		_methodParameterTypes215 = new String[] {
				"vn.com.ecopharma.emp.model.Titles"
			};

		_methodName216 = "deleteTitles";

		_methodParameterTypes216 = new String[] { "long" };

		_methodName217 = "completelyRemoveAll";

		_methodParameterTypes217 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TitlesLocalServiceUtil.addTitles((vn.com.ecopharma.emp.model.Titles)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TitlesLocalServiceUtil.createTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TitlesLocalServiceUtil.deleteTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TitlesLocalServiceUtil.deleteTitles((vn.com.ecopharma.emp.model.Titles)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TitlesLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TitlesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TitlesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TitlesLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TitlesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TitlesLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TitlesLocalServiceUtil.fetchTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TitlesLocalServiceUtil.getTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TitlesLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TitlesLocalServiceUtil.getTitleses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TitlesLocalServiceUtil.getTitlesesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TitlesLocalServiceUtil.updateTitles((vn.com.ecopharma.emp.model.Titles)arguments[0]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return TitlesLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			TitlesLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return TitlesLocalServiceUtil.findAll();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			return TitlesLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName200.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes200, parameterTypes)) {
			return TitlesLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName201.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes201, parameterTypes)) {
			return TitlesLocalServiceUtil.findFilterListByRelatedFields((java.util.List<vn.com.ecopharma.emp.model.Department>)arguments[0],
				(java.util.List<vn.com.ecopharma.emp.model.Unit>)arguments[1],
				(java.util.List<vn.com.ecopharma.emp.model.UnitGroup>)arguments[2]);
		}

		if (_methodName202.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes202, parameterTypes)) {
			return TitlesLocalServiceUtil.addTitles((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName203.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes203, parameterTypes)) {
			return TitlesLocalServiceUtil.addTitles((vn.com.ecopharma.emp.model.Titles)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return TitlesLocalServiceUtil.addTitles((vn.com.ecopharma.emp.model.Titles)arguments[0],
				(vn.com.ecopharma.emp.model.UnitGroup)arguments[1],
				(vn.com.ecopharma.emp.model.Unit)arguments[2],
				(vn.com.ecopharma.emp.model.Department)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return TitlesLocalServiceUtil.findByDepartmentUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return TitlesLocalServiceUtil.findByUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return TitlesLocalServiceUtil.findAllByDepartment(((Long)arguments[0]).longValue());
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return TitlesLocalServiceUtil.findAllByUnit(((Long)arguments[0]).longValue());
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return TitlesLocalServiceUtil.findByDepartmentOnly(((Long)arguments[0]).longValue());
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return TitlesLocalServiceUtil.findByUnitOnly(((Long)arguments[0]).longValue());
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return TitlesLocalServiceUtil.findByUnitGroupOnly(((Long)arguments[0]).longValue());
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return TitlesLocalServiceUtil.findByName((java.lang.String)arguments[0]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return TitlesLocalServiceUtil.createPrePersistedTitles();
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return TitlesLocalServiceUtil.updateTitles((vn.com.ecopharma.emp.model.Titles)arguments[0]);
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return TitlesLocalServiceUtil.deleteTitles((vn.com.ecopharma.emp.model.Titles)arguments[0]);
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return TitlesLocalServiceUtil.deleteTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			TitlesLocalServiceUtil.completelyRemoveAll();

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
	private String _methodName192;
	private String[] _methodParameterTypes192;
	private String _methodName193;
	private String[] _methodParameterTypes193;
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
}