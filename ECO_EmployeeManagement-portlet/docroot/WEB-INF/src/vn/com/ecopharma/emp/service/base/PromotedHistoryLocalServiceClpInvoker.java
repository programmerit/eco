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

import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class PromotedHistoryLocalServiceClpInvoker {
	public PromotedHistoryLocalServiceClpInvoker() {
		_methodName0 = "addPromotedHistory";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory"
			};

		_methodName1 = "createPromotedHistory";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deletePromotedHistory";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deletePromotedHistory";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory"
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

		_methodName10 = "fetchPromotedHistory";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPromotedHistory";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getPromotedHistories";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getPromotedHistoriesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updatePromotedHistory";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory"
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

		_methodName207 = "findByEmployee";

		_methodParameterTypes207 = new String[] { "long" };

		_methodName208 = "findByOldTitles";

		_methodParameterTypes208 = new String[] { "long" };

		_methodName209 = "findByNewTitles";

		_methodParameterTypes209 = new String[] { "long" };

		_methodName210 = "createPrePersisted";

		_methodParameterTypes210 = new String[] {  };

		_methodName211 = "addPromotedHistory";

		_methodParameterTypes211 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory", "long", "long",
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName212 = "updatePromotedHistory";

		_methodParameterTypes212 = new String[] {
				"long", "java.util.Date", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName213 = "markDeleted";

		_methodParameterTypes213 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory"
			};

		_methodName214 = "countAllDocuments";

		_methodParameterTypes214 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName215 = "searchAllDocuments";

		_methodParameterTypes215 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName216 = "filterByFields";

		_methodParameterTypes216 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName217 = "countFilterByFields";

		_methodParameterTypes217 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName218 = "getIndexedDocument";

		_methodParameterTypes218 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName219 = "getIndexedDocument";

		_methodParameterTypes219 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName220 = "indexAll";

		_methodParameterTypes220 = new String[] {  };

		_methodName221 = "removeAllIndexes";

		_methodParameterTypes221 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.addPromotedHistory((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.createPromotedHistory(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.deletePromotedHistory(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.deletePromotedHistory((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.fetchPromotedHistory(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getPromotedHistory(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getPromotedHistories(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getPromotedHistoriesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.updatePromotedHistory((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0]);
		}

		if (_methodName198.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes198, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName199.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes199, parameterTypes)) {
			PromotedHistoryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName204.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes204, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findAll();
		}

		if (_methodName205.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes205, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName206.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes206, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName207.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes207, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findByEmployee(((Long)arguments[0]).longValue());
		}

		if (_methodName208.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes208, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findByOldTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName209.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes209, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findByNewTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName210.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes210, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.createPrePersisted();
		}

		if (_methodName211.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes211, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.addPromotedHistory((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName212.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes212, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.updatePromotedHistory(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1], (java.lang.String)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName213.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes213, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.markDeleted((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0]);
		}

		if (_methodName214.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes214, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.countAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName215.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes215, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.searchAllDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName216.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes216, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.filterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName217.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes217, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.countFilterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName218.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes218, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getIndexedDocument((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName219.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes219, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getIndexedDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName220.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes220, parameterTypes)) {
			PromotedHistoryLocalServiceUtil.indexAll();

			return null;
		}

		if (_methodName221.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes221, parameterTypes)) {
			PromotedHistoryLocalServiceUtil.removeAllIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

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
}