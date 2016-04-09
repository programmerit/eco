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

package vn.com.ecopharma.hrm.rc.service.base;

import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class CandidateLocalServiceClpInvoker {
	public CandidateLocalServiceClpInvoker() {
		_methodName0 = "addCandidate";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate"
			};

		_methodName1 = "createCandidate";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteCandidate";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteCandidate";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate"
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

		_methodName10 = "fetchCandidate";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getCandidate";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getCandidates";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getCandidatesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateCandidate";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate"
			};

		_methodName110 = "getBeanIdentifier";

		_methodParameterTypes110 = new String[] {  };

		_methodName111 = "setBeanIdentifier";

		_methodParameterTypes111 = new String[] { "java.lang.String" };

		_methodName116 = "findAll";

		_methodParameterTypes116 = new String[] {  };

		_methodName117 = "findAll";

		_methodParameterTypes117 = new String[] { "int", "int" };

		_methodName118 = "findAll";

		_methodParameterTypes118 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName119 = "isEmailExisted";

		_methodParameterTypes119 = new String[] { "java.lang.String" };

		_methodName120 = "findByIdentityCardNo";

		_methodParameterTypes120 = new String[] { "java.lang.String" };

		_methodName121 = "findByContactNumber";

		_methodParameterTypes121 = new String[] { "java.lang.String" };

		_methodName122 = "createPrePersistCandidate";

		_methodParameterTypes122 = new String[] {  };

		_methodName123 = "createPrePersistCandidate";

		_methodParameterTypes123 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "long", "long",
				"java.util.Date", "java.lang.String"
			};

		_methodName124 = "addCandidate";

		_methodParameterTypes124 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate", "long",
				"java.util.List", "java.util.List",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName125 = "addCandidate";

		_methodParameterTypes125 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate", "long",
				"java.util.List", "java.util.List", "java.util.Map",
				"java.util.Map", "com.liferay.portal.service.ServiceContext"
			};

		_methodName126 = "updateCandidate";

		_methodParameterTypes126 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate", "long",
				"java.util.List", "java.util.List", "java.util.Map",
				"java.util.Map", "com.liferay.portal.service.ServiceContext"
			};

		_methodName127 = "changeCandidateStatus";

		_methodParameterTypes127 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName128 = "changeCandidateStatus";

		_methodParameterTypes128 = new String[] {
				"long", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName129 = "changeMultipleCandidateStatus";

		_methodParameterTypes129 = new String[] {
				"java.util.List", "java.lang.String",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName130 = "setShortListCandidate";

		_methodParameterTypes130 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName131 = "setShortListCandidates";

		_methodParameterTypes131 = new String[] {
				"java.util.List", "com.liferay.portal.service.ServiceContext"
			};

		_methodName132 = "markDeleted";

		_methodParameterTypes132 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.Candidate",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName133 = "markDeleted";

		_methodParameterTypes133 = new String[] {
				"long", "com.liferay.portal.service.ServiceContext"
			};

		_methodName134 = "countAllUnDeletedIndexedCandidateDocuments";

		_methodParameterTypes134 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName135 = "searchAllUnDeletedCandidatesIndexedDocument";

		_methodParameterTypes135 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName136 = "filterByFields";

		_methodParameterTypes136 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long",
				"int", "int"
			};

		_methodName137 = "countFilterByFields";

		_methodParameterTypes137 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.Map", "com.liferay.portal.kernel.search.Sort", "long"
			};

		_methodName138 = "createDateTermRangeQuery";

		_methodParameterTypes138 = new String[] {
				"java.lang.String", "java.util.Date", "java.util.Date",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName139 = "getCurrentDateNextYear";

		_methodParameterTypes139 = new String[] {  };

		_methodName141 = "getIndexCandidateDocument";

		_methodParameterTypes141 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName142 = "getIndexCandidateDocument";

		_methodParameterTypes142 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName143 = "indexAllCandidates";

		_methodParameterTypes143 = new String[] {  };

		_methodName144 = "removeAllCandidateIndexes";

		_methodParameterTypes144 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName145 = "hasAlreadyScheduleForInterview";

		_methodParameterTypes145 = new String[] { "long", "long", "long" };

		_methodName146 = "hasAlreadyScheduleForInterview";

		_methodParameterTypes146 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return CandidateLocalServiceUtil.addCandidate((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return CandidateLocalServiceUtil.createCandidate(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return CandidateLocalServiceUtil.deleteCandidate(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return CandidateLocalServiceUtil.deleteCandidate((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return CandidateLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return CandidateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return CandidateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return CandidateLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return CandidateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return CandidateLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return CandidateLocalServiceUtil.fetchCandidate(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return CandidateLocalServiceUtil.getCandidate(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return CandidateLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return CandidateLocalServiceUtil.getCandidates(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return CandidateLocalServiceUtil.getCandidatesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return CandidateLocalServiceUtil.updateCandidate((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return CandidateLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			CandidateLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return CandidateLocalServiceUtil.findAll();
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return CandidateLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return CandidateLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			return CandidateLocalServiceUtil.isEmailExisted((java.lang.String)arguments[0]);
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return CandidateLocalServiceUtil.findByIdentityCardNo((java.lang.String)arguments[0]);
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			return CandidateLocalServiceUtil.findByContactNumber((java.lang.String)arguments[0]);
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return CandidateLocalServiceUtil.createPrePersistCandidate();
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return CandidateLocalServiceUtil.createPrePersistCandidate((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				((Long)arguments[5]).longValue(),
				((Long)arguments[6]).longValue(), (java.util.Date)arguments[7],
				(java.lang.String)arguments[8]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return CandidateLocalServiceUtil.addCandidate((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.util.List<java.lang.Long>)arguments[2],
				(java.util.List<java.lang.Long>)arguments[3],
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return CandidateLocalServiceUtil.addCandidate((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.util.List<java.lang.Long>)arguments[2],
				(java.util.List<java.lang.Long>)arguments[3],
				(java.util.Map<vn.com.ecopharma.hrm.rc.model.Experience, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.hrm.rc.model.Certificate, java.lang.Boolean>)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return CandidateLocalServiceUtil.updateCandidate((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.util.List<java.lang.Long>)arguments[2],
				(java.util.List<java.lang.Long>)arguments[3],
				(java.util.Map<vn.com.ecopharma.hrm.rc.model.Experience, java.lang.Boolean>)arguments[4],
				(java.util.Map<vn.com.ecopharma.hrm.rc.model.Certificate, java.lang.Boolean>)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return CandidateLocalServiceUtil.changeCandidateStatus((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0],
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return CandidateLocalServiceUtil.changeCandidateStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			CandidateLocalServiceUtil.changeMultipleCandidateStatus((java.util.List<java.lang.Long>)arguments[0],
				(java.lang.String)arguments[1],
				(com.liferay.portal.service.ServiceContext)arguments[2]);

			return null;
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return CandidateLocalServiceUtil.setShortListCandidate(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			CandidateLocalServiceUtil.setShortListCandidates((java.util.List<java.lang.Long>)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);

			return null;
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			return CandidateLocalServiceUtil.markDeleted((vn.com.ecopharma.hrm.rc.model.Candidate)arguments[0],
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return CandidateLocalServiceUtil.markDeleted(((Long)arguments[0]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[1]);
		}

		if (_methodName134.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes134, parameterTypes)) {
			return CandidateLocalServiceUtil.countAllUnDeletedIndexedCandidateDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName135.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes135, parameterTypes)) {
			return CandidateLocalServiceUtil.searchAllUnDeletedCandidatesIndexedDocument((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName136.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes136, parameterTypes)) {
			return CandidateLocalServiceUtil.filterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue(),
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName137.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes137, parameterTypes)) {
			return CandidateLocalServiceUtil.countFilterByFields((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.Map<java.lang.String, java.lang.Object>)arguments[1],
				(com.liferay.portal.kernel.search.Sort)arguments[2],
				((Long)arguments[3]).longValue());
		}

		if (_methodName138.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes138, parameterTypes)) {
			return CandidateLocalServiceUtil.createDateTermRangeQuery((java.lang.String)arguments[0],
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				(com.liferay.portal.kernel.search.SearchContext)arguments[3]);
		}

		if (_methodName139.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes139, parameterTypes)) {
			return CandidateLocalServiceUtil.getCurrentDateNextYear();
		}

		if (_methodName141.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes141, parameterTypes)) {
			return CandidateLocalServiceUtil.getIndexCandidateDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName142.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes142, parameterTypes)) {
			return CandidateLocalServiceUtil.getIndexCandidateDocument((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName143.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes143, parameterTypes)) {
			CandidateLocalServiceUtil.indexAllCandidates();

			return null;
		}

		if (_methodName144.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes144, parameterTypes)) {
			CandidateLocalServiceUtil.removeAllCandidateIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName145.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes145, parameterTypes)) {
			return CandidateLocalServiceUtil.hasAlreadyScheduleForInterview(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName146.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes146, parameterTypes)) {
			return CandidateLocalServiceUtil.hasAlreadyScheduleForInterview(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
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
	private String _methodName110;
	private String[] _methodParameterTypes110;
	private String _methodName111;
	private String[] _methodParameterTypes111;
	private String _methodName116;
	private String[] _methodParameterTypes116;
	private String _methodName117;
	private String[] _methodParameterTypes117;
	private String _methodName118;
	private String[] _methodParameterTypes118;
	private String _methodName119;
	private String[] _methodParameterTypes119;
	private String _methodName120;
	private String[] _methodParameterTypes120;
	private String _methodName121;
	private String[] _methodParameterTypes121;
	private String _methodName122;
	private String[] _methodParameterTypes122;
	private String _methodName123;
	private String[] _methodParameterTypes123;
	private String _methodName124;
	private String[] _methodParameterTypes124;
	private String _methodName125;
	private String[] _methodParameterTypes125;
	private String _methodName126;
	private String[] _methodParameterTypes126;
	private String _methodName127;
	private String[] _methodParameterTypes127;
	private String _methodName128;
	private String[] _methodParameterTypes128;
	private String _methodName129;
	private String[] _methodParameterTypes129;
	private String _methodName130;
	private String[] _methodParameterTypes130;
	private String _methodName131;
	private String[] _methodParameterTypes131;
	private String _methodName132;
	private String[] _methodParameterTypes132;
	private String _methodName133;
	private String[] _methodParameterTypes133;
	private String _methodName134;
	private String[] _methodParameterTypes134;
	private String _methodName135;
	private String[] _methodParameterTypes135;
	private String _methodName136;
	private String[] _methodParameterTypes136;
	private String _methodName137;
	private String[] _methodParameterTypes137;
	private String _methodName138;
	private String[] _methodParameterTypes138;
	private String _methodName139;
	private String[] _methodParameterTypes139;
	private String _methodName141;
	private String[] _methodParameterTypes141;
	private String _methodName142;
	private String[] _methodParameterTypes142;
	private String _methodName143;
	private String[] _methodParameterTypes143;
	private String _methodName144;
	private String[] _methodParameterTypes144;
	private String _methodName145;
	private String[] _methodParameterTypes145;
	private String _methodName146;
	private String[] _methodParameterTypes146;
}