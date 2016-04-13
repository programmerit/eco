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

package vn.com.ecopharma.hrm.tt.service.base;

import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;

import java.util.Arrays;

/**
 * @author tvt
 * @generated
 */
public class TimeTrackingLocalServiceClpInvoker {
	public TimeTrackingLocalServiceClpInvoker() {
		_methodName0 = "addTimeTracking";

		_methodParameterTypes0 = new String[] {
				"vn.com.ecopharma.hrm.tt.model.TimeTracking"
			};

		_methodName1 = "createTimeTracking";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteTimeTracking";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteTimeTracking";

		_methodParameterTypes3 = new String[] {
				"vn.com.ecopharma.hrm.tt.model.TimeTracking"
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

		_methodName10 = "fetchTimeTracking";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getTimeTracking";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getTimeTrackings";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getTimeTrackingsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateTimeTracking";

		_methodParameterTypes15 = new String[] {
				"vn.com.ecopharma.hrm.tt.model.TimeTracking"
			};

		_methodName34 = "getBeanIdentifier";

		_methodParameterTypes34 = new String[] {  };

		_methodName35 = "setBeanIdentifier";

		_methodParameterTypes35 = new String[] { "java.lang.String" };

		_methodName40 = "findAll";

		_methodParameterTypes40 = new String[] {  };

		_methodName41 = "findAll";

		_methodParameterTypes41 = new String[] { "int", "int" };

		_methodName42 = "findAll";

		_methodParameterTypes42 = new String[] {
				"int", "int", "com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName43 = "fetchByEmpAndDate";

		_methodParameterTypes43 = new String[] { "long", "java.util.Date" };

		_methodName44 = "findByVacationLeave";

		_methodParameterTypes44 = new String[] { "long" };

		_methodName45 = "countSearch";

		_methodParameterTypes45 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long"
			};

		_methodName46 = "search";

		_methodParameterTypes46 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext",
				"java.util.List", "long",
				"com.liferay.portal.kernel.search.Sort", "int", "int"
			};

		_methodName47 = "getIndexedTimeTracking";

		_methodParameterTypes47 = new String[] {
				"long", "com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName48 = "getIndexedTimeTracking";

		_methodParameterTypes48 = new String[] {
				"java.lang.String",
				"com.liferay.portal.kernel.search.SearchContext"
			};

		_methodName49 = "reindexAllTimeTrackings";

		_methodParameterTypes49 = new String[] {  };

		_methodName50 = "removeAllIndexes";

		_methodParameterTypes50 = new String[] {
				"com.liferay.portal.kernel.search.SearchContext", "long"
			};

		_methodName51 = "addTimeTracking";

		_methodParameterTypes51 = new String[] {
				"long", "java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "long",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName52 = "updateTimeTracking";

		_methodParameterTypes52 = new String[] {
				"long", "java.util.Date", "java.util.Date", "java.util.Date",
				"java.util.Date", "java.util.Date", "java.util.Date"
			};

		_methodName53 = "updateTimeTracking";

		_methodParameterTypes53 = new String[] {
				"vn.com.ecopharma.hrm.tt.model.TimeTracking"
			};

		_methodName54 = "updateTimeTrackingsByUpdatedVacationLeave";

		_methodParameterTypes54 = new String[] {
				"vn.com.ecopharma.emp.model.VacationLeave",
				"vn.com.ecopharma.emp.model.VacationLeave"
			};

		_methodName55 = "setLeaveForTimeTracking";

		_methodParameterTypes55 = new String[] {
				"vn.com.ecopharma.hrm.tt.model.TimeTracking", "long"
			};

		_methodName56 = "addOrUpdateTimeTrackingByLeaveRequest";

		_methodParameterTypes56 = new String[] {
				"vn.com.ecopharma.emp.model.VacationLeave"
			};

		_methodName57 = "addOrUpdateTimeTrackingByInOutRequest";

		_methodParameterTypes57 = new String[] {
				"vn.com.ecopharma.emp.model.VacationLeave"
			};

		_methodName58 = "scanAndAddMissingDataByLeaveRequests";

		_methodParameterTypes58 = new String[] { "java.util.List" };

		_methodName59 = "completelyRemoveAllTimeTrackings";

		_methodParameterTypes59 = new String[] {  };

		_methodName60 = "getDatesBetweenTwoDates";

		_methodParameterTypes60 = new String[] {
				"java.util.Date", "java.util.Date", "boolean", "boolean"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.addTimeTracking((vn.com.ecopharma.hrm.tt.model.TimeTracking)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.createTimeTracking(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.deleteTimeTracking(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.deleteTimeTracking((vn.com.ecopharma.hrm.tt.model.TimeTracking)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.fetchTimeTracking(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getTimeTracking(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getTimeTrackings(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getTimeTrackingsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.updateTimeTracking((vn.com.ecopharma.hrm.tt.model.TimeTracking)arguments[0]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			TimeTrackingLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.findAll();
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.findAll(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[2]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.fetchByEmpAndDate(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1]);
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.findByVacationLeave(((Long)arguments[0]).longValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.countSearch((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.search((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				(java.util.List<com.liferay.portal.kernel.search.Query>)arguments[1],
				((Long)arguments[2]).longValue(),
				(com.liferay.portal.kernel.search.Sort)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getIndexedTimeTracking(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getIndexedTimeTracking((java.lang.String)arguments[0],
				(com.liferay.portal.kernel.search.SearchContext)arguments[1]);
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			TimeTrackingLocalServiceUtil.reindexAllTimeTrackings();

			return null;
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			TimeTrackingLocalServiceUtil.removeAllIndexes((com.liferay.portal.kernel.search.SearchContext)arguments[0],
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.addTimeTracking(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6],
				(java.util.Date)arguments[7], ((Long)arguments[8]).longValue(),
				(com.liferay.portal.service.ServiceContext)arguments[9]);
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.updateTimeTracking(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1], (java.util.Date)arguments[2],
				(java.util.Date)arguments[3], (java.util.Date)arguments[4],
				(java.util.Date)arguments[5], (java.util.Date)arguments[6]);
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.updateTimeTracking((vn.com.ecopharma.hrm.tt.model.TimeTracking)arguments[0]);
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			TimeTrackingLocalServiceUtil.updateTimeTrackingsByUpdatedVacationLeave((vn.com.ecopharma.emp.model.VacationLeave)arguments[0],
				(vn.com.ecopharma.emp.model.VacationLeave)arguments[1]);

			return null;
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.setLeaveForTimeTracking((vn.com.ecopharma.hrm.tt.model.TimeTracking)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			TimeTrackingLocalServiceUtil.addOrUpdateTimeTrackingByLeaveRequest((vn.com.ecopharma.emp.model.VacationLeave)arguments[0]);

			return null;
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			TimeTrackingLocalServiceUtil.addOrUpdateTimeTrackingByInOutRequest((vn.com.ecopharma.emp.model.VacationLeave)arguments[0]);

			return null;
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			TimeTrackingLocalServiceUtil.scanAndAddMissingDataByLeaveRequests((java.util.List<vn.com.ecopharma.emp.model.VacationLeave>)arguments[0]);

			return null;
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			TimeTrackingLocalServiceUtil.completelyRemoveAllTimeTrackings();

			return null;
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return TimeTrackingLocalServiceUtil.getDatesBetweenTwoDates((java.util.Date)arguments[0],
				(java.util.Date)arguments[1],
				((Boolean)arguments[2]).booleanValue(),
				((Boolean)arguments[3]).booleanValue());
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
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
}