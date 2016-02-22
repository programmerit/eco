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

		_methodName183 = "findByEmployee";

		_methodParameterTypes183 = new String[] { "long" };

		_methodName184 = "findByOldTitles";

		_methodParameterTypes184 = new String[] { "long" };

		_methodName185 = "findByNewTitles";

		_methodParameterTypes185 = new String[] { "long" };

		_methodName186 = "createPrePersisted";

		_methodParameterTypes186 = new String[] {  };

		_methodName187 = "addPromotedHistory";

		_methodParameterTypes187 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory", "long", "long",
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName188 = "markDeleted";

		_methodParameterTypes188 = new String[] {
				"vn.com.ecopharma.emp.model.PromotedHistory"
			};

		_methodName189 = "countAllUnDeletedDocuments";

		_methodParameterTypes189 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName190 = "searchAllUnDeletedDocuments";

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

		_methodName193 = "indexAll";

		_methodParameterTypes193 = new String[] {  };

		_methodName194 = "removeAllIndexes";

		_methodParameterTypes194 = new String[] {
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

		if (_methodName174.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes174, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName175.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes175, parameterTypes)) {
			PromotedHistoryLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName180.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes180, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findAll();
		}

		if (_methodName181.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes181, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName182.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes182, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName183.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes183, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findByEmployee(((Long)arguments[0]).longValue());
		}

		if (_methodName184.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes184, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findByOldTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName185.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes185, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.findByNewTitles(((Long)arguments[0]).longValue());
		}

		if (_methodName186.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes186, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.createPrePersisted();
		}

		if (_methodName187.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes187, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.addPromotedHistory((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName188.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes188, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.markDeleted((vn.com.ecopharma.emp.model.PromotedHistory)arguments[0]);
		}

		if (_methodName189.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes189, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.countAllUnDeletedDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName190.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes190, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.searchAllUnDeletedDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName191.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes191, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getIndexedDocument((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName192.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes192, parameterTypes)) {
			return PromotedHistoryLocalServiceUtil.getIndexedDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName193.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes193, parameterTypes)) {
			PromotedHistoryLocalServiceUtil.indexAll();

			return null;
		}

		if (_methodName194.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes194, parameterTypes)) {
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
	private String _methodName194;
	private String[] _methodParameterTypes194;
}