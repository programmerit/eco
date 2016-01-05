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

import vn.com.ecopharma.emp.service.TitlesUnitUnitGroupLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class TitlesUnitUnitGroupLocalServiceClpInvoker {
	public TitlesUnitUnitGroupLocalServiceClpInvoker() {
		_methodName0 = "addTitlesUnitUnitGroup";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.TitlesUnitUnitGroup"
			};

		_methodName1 = "createTitlesUnitUnitGroup";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteTitlesUnitUnitGroup";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteTitlesUnitUnitGroup";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.TitlesUnitUnitGroup"
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

		_methodName10 = "fetchTitlesUnitUnitGroup";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getTitlesUnitUnitGroup";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getTitlesUnitUnitGroups";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getTitlesUnitUnitGroupsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateTitlesUnitUnitGroup";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.TitlesUnitUnitGroup"
			};

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

		_methodName147 = "findByTitlesUnitUnitGroup";

		_methodParameterTypes147 = new String[] { "long", "long", "long" };

		_methodName148 = "findByTitlesUnitUnitGroup";

		_methodParameterTypes148 = new String[] {
				"vn.com.ecopharma.emp.model.Titles",
				"vn.com.ecopharma.emp.model.Unit",
				"vn.com.ecopharma.emp.model.UnitGroup"
			};

		_methodName149 = "findByTitles";

		_methodParameterTypes149 = new String[] { "long" };

		_methodName150 = "findByTitles";

		_methodParameterTypes150 = new String[] {
				"vn.com.ecopharma.emp.model.Titles"
			};

		_methodName151 = "findByUnitAndNoneUnitGroup";

		_methodParameterTypes151 = new String[] { "long" };

		_methodName152 = "findByUnitAndNoneUnitGroup";

		_methodParameterTypes152 = new String[] {
				"vn.com.ecopharma.emp.model.Unit"
			};

		_methodName153 = "findByUnitGroup";

		_methodParameterTypes153 = new String[] {
				"vn.com.ecopharma.emp.model.UnitGroup"
			};

		_methodName154 = "findByUnitGroup";

		_methodParameterTypes154 = new String[] { "long" };

		_methodName155 = "addTitlesUnitUnitGroup";

		_methodParameterTypes155 = new String[] {
				"long", "long", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName156 = "addTitlesUnitUnitGroup";

		_methodParameterTypes156 = new String[] {
				"vn.com.ecopharma.emp.model.Titles",
				"vn.com.ecopharma.emp.model.Unit",
				"vn.com.ecopharma.emp.model.UnitGroup",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName157 = "completelyRemoveAll";

		_methodParameterTypes157 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.addTitlesUnitUnitGroup((vn.com.ecopharma.emp.model.TitlesUnitUnitGroup)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.createTitlesUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.deleteTitlesUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.deleteTitlesUnitUnitGroup((vn.com.ecopharma.emp.model.TitlesUnitUnitGroup)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.fetchTitlesUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.getTitlesUnitUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.getTitlesUnitUnitGroups(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.getTitlesUnitUnitGroupsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.updateTitlesUnitUnitGroup((vn.com.ecopharma.emp.model.TitlesUnitUnitGroup)arguments[0]);
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			TitlesUnitUnitGroupLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findAll();
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName147.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes147, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByTitlesUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName148.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes148, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByTitlesUnitUnitGroup((vn.com.ecopharma.emp.model.Titles)arguments[0],
				(vn.com.ecopharma.emp.model.Unit)arguments[1],
				(vn.com.ecopharma.emp.model.UnitGroup)arguments[2]);
		}

		if (_methodName149.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes149, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName150.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes150, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByTitles((vn.com.ecopharma.emp.model.Titles)arguments[0]);
		}

		if (_methodName151.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes151, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByUnitAndNoneUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName152.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes152, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByUnitAndNoneUnitGroup((vn.com.ecopharma.emp.model.Unit)arguments[0]);
		}

		if (_methodName153.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes153, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByUnitGroup((vn.com.ecopharma.emp.model.UnitGroup)arguments[0]);
		}

		if (_methodName154.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes154, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.findByUnitGroup(((Long)arguments[0]).longValue());
		}

		if (_methodName155.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes155, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.addTitlesUnitUnitGroup(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName156.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes156, parameterTypes)) {
			return TitlesUnitUnitGroupLocalServiceUtil.addTitlesUnitUnitGroup((vn.com.ecopharma.emp.model.Titles)arguments[0],
				(vn.com.ecopharma.emp.model.Unit)arguments[1],
				(vn.com.ecopharma.emp.model.UnitGroup)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName157.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes157, parameterTypes)) {
			TitlesUnitUnitGroupLocalServiceUtil.completelyRemoveAll();

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
}