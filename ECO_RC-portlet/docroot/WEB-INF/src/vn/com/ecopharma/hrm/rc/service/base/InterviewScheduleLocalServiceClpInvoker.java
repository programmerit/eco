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

import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class InterviewScheduleLocalServiceClpInvoker {
	public InterviewScheduleLocalServiceClpInvoker() {
		_methodName0 = "addInterviewSchedule";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.InterviewSchedule"
			};

		_methodName1 = "createInterviewSchedule";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteInterviewSchedule";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteInterviewSchedule";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.InterviewSchedule"
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

		_methodName10 = "fetchInterviewSchedule";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getInterviewSchedule";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getInterviewSchedules";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getInterviewSchedulesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateInterviewSchedule";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.InterviewSchedule"
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

		_methodName119 = "findByVacancyCandidateAndInterview";

		_methodParameterTypes119 = new String[] { "long", "long" };

		_methodName120 = "findByVacancyCandidateAndStatus";

		_methodParameterTypes120 = new String[] { "long", "java.lang.String" };

		_methodName121 = "findByVacancyCandidate";

		_methodParameterTypes121 = new String[] { "long" };

		_methodName122 = "findInterviewIdsByVacancyCandidate";

		_methodParameterTypes122 = new String[] { "long" };

		_methodName123 = "addInterviewSchedule";

		_methodParameterTypes123 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.InterviewSchedule",
				"vn.com.ecopharma.hrm.rc.model.VacancyCandidate",
				"java.util.List", "com.liferay.portal.service.ServiceContext"
			};

		_methodName124 = "addInterviewSchedule";

		_methodParameterTypes124 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.InterviewSchedule", "long",
				"java.util.List", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName125 = "updateInterviewSchedule";

		_methodParameterTypes125 = new String[] {
				"vn.com.ecopharma.hrm.rc.model.InterviewSchedule"
			};

		_methodName126 = "createPrePersitedEntity";

		_methodParameterTypes126 = new String[] {  };

		_methodName127 = "countAllIndexedDocuments";

		_methodParameterTypes127 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort"
			};

		_methodName128 = "searchAllIndexedDocuments";

		_methodParameterTypes128 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName129 = "searchByVacancyCandidateId";

		_methodParameterTypes129 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long", "long"
			};

		_methodName130 = "getAllInterviewRoundIdsByVacancyCandidateId";

		_methodParameterTypes130 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long", "long"
			};

		_methodName131 = "indexAll";

		_methodParameterTypes131 = new String[] {  };

		_methodName132 = "removeAllIndexes";

		_methodParameterTypes132 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName133 = "getIndexDocument";

		_methodParameterTypes133 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.addInterviewSchedule((vn.com.ecopharma.hrm.rc.model.InterviewSchedule)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.createInterviewSchedule(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.deleteInterviewSchedule(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.deleteInterviewSchedule((vn.com.ecopharma.hrm.rc.model.InterviewSchedule)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.fetchInterviewSchedule(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getInterviewSchedule(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getInterviewSchedules(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getInterviewSchedulesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.updateInterviewSchedule((vn.com.ecopharma.hrm.rc.model.InterviewSchedule)arguments[0]);
		}

		if (_methodName110.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes110, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName111.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes111, parameterTypes)) {
			InterviewScheduleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName116.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes116, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findAll();
		}

		if (_methodName117.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes117, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName118.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes118, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName119.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes119, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findByVacancyCandidateAndInterview(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName120.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes120, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findByVacancyCandidateAndStatus(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName121.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes121, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findByVacancyCandidate(((Long)arguments[0]).longValue());
		}

		if (_methodName122.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes122, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.findInterviewIdsByVacancyCandidate(((Long)arguments[0]).longValue());
		}

		if (_methodName123.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes123, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.addInterviewSchedule((vn.com.ecopharma.hrm.rc.model.InterviewSchedule)arguments[0],
				(vn.com.ecopharma.hrm.rc.model.VacancyCandidate)arguments[1],
				(java.util.List<vn.com.ecopharma.emp.model.Employee>)arguments[2],
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName124.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes124, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.addInterviewSchedule((vn.com.ecopharma.hrm.rc.model.InterviewSchedule)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.util.List<java.lang.Long>)arguments[2],
				((Long)arguments[3]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[4]);
		}

		if (_methodName125.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes125, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.updateInterviewSchedule((vn.com.ecopharma.hrm.rc.model.InterviewSchedule)arguments[0]);
		}

		if (_methodName126.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes126, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.createPrePersitedEntity();
		}

		if (_methodName127.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes127, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.countAllIndexedDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3]);
		}

		if (_methodName128.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes128, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.searchAllIndexedDocuments((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName129.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes129, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.searchByVacancyCandidateId((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName130.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes130, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getAllInterviewRoundIdsByVacancyCandidateId((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName131.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes131, parameterTypes)) {
			InterviewScheduleLocalServiceUtil.indexAll();

			return null;
		}

		if (_methodName132.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes132, parameterTypes)) {
			InterviewScheduleLocalServiceUtil.removeAllIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName133.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes133, parameterTypes)) {
			return InterviewScheduleLocalServiceUtil.getIndexDocument(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
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
}