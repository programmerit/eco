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

import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class DevisionLocalServiceClpInvoker {
	public DevisionLocalServiceClpInvoker() {
		_methodName0 = "addDevision";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.Devision"
			};

		_methodName1 = "createDevision";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteDevision";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteDevision";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.Devision"
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

		_methodName10 = "fetchDevision";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getDevision";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getDevisions";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getDevisionsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateDevision";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.Devision"
			};

		_methodName130 = "getBeanIdentifier";

		_methodParameterTypes130 = new String[] {  };

		_methodName131 = "setBeanIdentifier";

		_methodParameterTypes131 = new String[] { "java.lang.String" };

		_methodName136 = "findAll";

		_methodParameterTypes136 = new String[] {  };

		_methodName137 = "findAll";

		_methodParameterTypes137 = new String[] { "int", "int" };

		_methodName138 = "findAll";

		_methodParameterTypes138 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName139 = "addDevision";

		_methodParameterTypes139 = new String[] {
				"java.lang.String", "com.liferay.portal.service.ServiceContext"
			};

		_methodName140 = "addDevision";

		_methodParameterTypes140 = new String[] {
				"vn.com.ecopharma.emp.model.Devision",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName141 = "findByName";

		_methodParameterTypes141 = new String[] { "java.lang.String" };

		_methodName142 = "completelyDeleteAll";

		_methodParameterTypes142 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return DevisionLocalServiceUtil.addDevision((vn.com.ecopharma.emp.model.Devision)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return DevisionLocalServiceUtil.createDevision(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return DevisionLocalServiceUtil.deleteDevision(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return DevisionLocalServiceUtil.deleteDevision((vn.com.ecopharma.emp.model.Devision)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return DevisionLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return DevisionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return DevisionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return DevisionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return DevisionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return DevisionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return DevisionLocalServiceUtil.fetchDevision(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return DevisionLocalServiceUtil.getDevision(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return DevisionLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return DevisionLocalServiceUtil.getDevisions(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return DevisionLocalServiceUtil.getDevisionsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return DevisionLocalServiceUtil.updateDevision((vn.com.ecopharma.emp.model.Devision)arguments[0]);
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return DevisionLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			DevisionLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return DevisionLocalServiceUtil.findAll();
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return DevisionLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return DevisionLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return DevisionLocalServiceUtil.addDevision((java.lang.String)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName140.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes140, parameterTypes)) {
			return DevisionLocalServiceUtil.addDevision((vn.com.ecopharma.emp.model.Devision)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return DevisionLocalServiceUtil.findByName((java.lang.String)arguments[0]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			DevisionLocalServiceUtil.completelyDeleteAll();

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
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName140;
	private String[] _methodParameterTypes140;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
}