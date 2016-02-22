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

import vn.com.ecopharma.emp.service.TitlesDepartmentUnitUnitGroupLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class TitlesDepartmentUnitUnitGroupLocalServiceClpInvoker {
	public TitlesDepartmentUnitUnitGroupLocalServiceClpInvoker() {
		_methodName0 = "addTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup"
			};

		_methodName1 = "createTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup"
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

		_methodName10 = "fetchTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getTitlesDepartmentUnitUnitGroups";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getTitlesDepartmentUnitUnitGroupsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup"
			};

		_methodName174 = "getBeanIdentifier";

		_methodParameterTypes174 = new String[] {  };

		_methodName175 = "setBeanIdentifier";

		_methodParameterTypes175 = new String[] { "java.lang.String" };

		_methodName180 = "findAll";

		_methodParameterTypes180 = new String[] {  };

		_methodName181 = "findAll";

		_methodParameterTypes181 = new String[] { "int", "int" };

		_methodName182 = "findAll";

		_methodParameterTypes182 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName183 = "findByDepartment";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "findByUnit";

		_methodParameterTypes184 = new String[] { "long" };

		_methodName185 = "addTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes185 = new String[] {
				"long", "long", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName186 = "addTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes186 = new String[] {
				"vn.com.ecopharma.emp.model.Titles",
				"vn.com.ecopharma.emp.model.Department",
				"vn.com.ecopharma.emp.model.Unit",
				"vn.com.ecopharma.emp.model.UnitGroup",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName187 = "findByTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes187 = new String[] { "long", "long", "long", "long" };

		_methodName188 = "findByTitlesDepartmentUnitUnitGroup";

		_methodParameterTypes188 = new String[] {
				"vn.com.ecopharma.emp.model.Titles",
				"vn.com.ecopharma.emp.model.Department",
				"vn.com.ecopharma.emp.model.Unit",
				"vn.com.ecopharma.emp.model.UnitGroup"
			};

		_methodName189 = "findByDepartmentUnitUnitGroup";

		_methodParameterTypes189 = new String[] { "long", "long", "long" };

		_methodName190 = "findByUnitUnitGroup";

		_methodParameterTypes190 = new String[] { "long", "long" };

		_methodName191 = "findByUnitGroup";

		_methodParameterTypes191 = new String[] { "long" };

		_methodName192 = "findByTitlesDepartmentUnitNoneUnitGroup";

		_methodParameterTypes192 = new String[] { "long", "long", "long" };

		_methodName193 = "completelyRemoveAll";

		_methodParameterTypes193 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.addTitlesDepartmentUnitUnitGroup((vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.createTitlesDepartmentUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.deleteTitlesDepartmentUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.deleteTitlesDepartmentUnitUnitGroup((vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.fetchTitlesDepartmentUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.getTitlesDepartmentUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.getTitlesDepartmentUnitUnitGroups(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.getTitlesDepartmentUnitUnitGroupsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.updateTitlesDepartmentUnitUnitGroup((vn.com.ecopharma.emp.model.TitlesDepartmentUnitUnitGroup)arguments[0]);
		}

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			TitlesDepartmentUnitUnitGroupLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findAll();
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByDepartment(((Long)arguments[0]).longValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByUnit(((Long)arguments[0]).longValue());
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.addTitlesDepartmentUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.addTitlesDepartmentUnitUnitGroup((vn.com.ecopharma.emp.model.Titles)arguments[0],
				(vn.com.ecopharma.emp.model.Department)arguments[1],
				(vn.com.ecopharma.emp.model.Unit)arguments[2],
				(vn.com.ecopharma.emp.model.UnitGroup)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByTitlesDepartmentUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue());
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByTitlesDepartmentUnitUnitGroup((vn.com.ecopharma.emp.model.Titles)arguments[0],
				(vn.com.ecopharma.emp.model.Department)arguments[1],
				(vn.com.ecopharma.emp.model.Unit)arguments[2],
				(vn.com.ecopharma.emp.model.UnitGroup)arguments[3]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByDepartmentUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return TitlesDepartmentUnitUnitGroupLocalServiceUtil.findByTitlesDepartmentUnitNoneUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			TitlesDepartmentUnitUnitGroupLocalServiceUtil.completelyRemoveAll();

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
	private String _methodName174;
	private String[] _methodParameterTypes174;
	private String _methodName175;
	private String[] _methodParameterTypes175;
	private String _methodName180;
	private String[] _methodParameterTypes180;
	private String _methodName181;
	private String[] _methodParameterTypes181;
	private String _methodName182;
	private String[] _methodParameterTypes182;
	private String _methodName183;
	private String[] _methodParameterTypes183;
	private String _methodName184;
	private String[] _methodParameterTypes184;
	private String _methodName185;
	private String[] _methodParameterTypes185;
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
}