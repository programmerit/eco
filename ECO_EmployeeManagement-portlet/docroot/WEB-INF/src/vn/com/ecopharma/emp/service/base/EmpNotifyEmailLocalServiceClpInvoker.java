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

import vn.com.ecopharma.emp.service.EmpNotifyEmailLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class EmpNotifyEmailLocalServiceClpInvoker {
	public EmpNotifyEmailLocalServiceClpInvoker() {
		_methodName0 = "addEmpNotifyEmail";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.EmpNotifyEmail"
			};

		_methodName1 = "createEmpNotifyEmail";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteEmpNotifyEmail";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteEmpNotifyEmail";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.EmpNotifyEmail"
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

		_methodName10 = "fetchEmpNotifyEmail";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getEmpNotifyEmail";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getEmpNotifyEmails";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getEmpNotifyEmailsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateEmpNotifyEmail";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.EmpNotifyEmail"
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

		_methodName207 = "findByStatus";

		_methodParameterTypes207 = new String[] { "java.lang.String" };

		_methodName208 = "createPreperistedEntity";

		_methodParameterTypes208 = new String[] {  };

		_methodName209 = "createEmpNotifyEmail";

		_methodParameterTypes209 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName210 = "updateEmpNotifyEmail";

		_methodParameterTypes210 = new String[] {
				"vn.com.ecopharma.emp.model.EmpNotifyEmail", "java.lang.String"
			};

		_methodName211 = "updateEmpNotifyEmail";

		_methodParameterTypes211 = new String[] { "long", "java.lang.String" };

		_methodName212 = "updateSentMailNotify";

		_methodParameterTypes212 = new String[] { "long" };

		_methodName213 = "updateSentMailNotify";

		_methodParameterTypes213 = new String[] {
				"vn.com.ecopharma.emp.model.EmpNotifyEmail"
			};

		_methodName214 = "updateSentMailNotifications";

		_methodParameterTypes214 = new String[] { "java.util.List" };

		_methodName215 = "removeEmpNotifyEmail";

		_methodParameterTypes215 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.addEmpNotifyEmail((vn.com.ecopharma.emp.model.EmpNotifyEmail)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.createEmpNotifyEmail(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.deleteEmpNotifyEmail(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.deleteEmpNotifyEmail((vn.com.ecopharma.emp.model.EmpNotifyEmail)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.fetchEmpNotifyEmail(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.getEmpNotifyEmail(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.getEmpNotifyEmails(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.getEmpNotifyEmailsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.updateEmpNotifyEmail((vn.com.ecopharma.emp.model.EmpNotifyEmail)arguments[0]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			EmpNotifyEmailLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.findAll();
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.findByStatus((java.lang.String)arguments[0]);
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.createPreperistedEntity();
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.createEmpNotifyEmail(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.updateEmpNotifyEmail((vn.com.ecopharma.emp.model.EmpNotifyEmail)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.updateEmpNotifyEmail(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.updateSentMailNotify(((Long)arguments[0]).longValue());
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.updateSentMailNotify((vn.com.ecopharma.emp.model.EmpNotifyEmail)arguments[0]);
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			EmpNotifyEmailLocalServiceUtil.updateSentMailNotifications((java.util.List<vn.com.ecopharma.emp.model.EmpNotifyEmail>)arguments[0]);

			return null;
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return EmpNotifyEmailLocalServiceUtil.removeEmpNotifyEmail(((Long)arguments[0]).longValue());
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
}