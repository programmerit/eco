package vn.com.ecopharma.hrm.tt.indexer;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;

import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.constant.ECO_TT_Info;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.constant.VacationLeaveField;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.service.persistence.TimeTrackingActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;

public class TimeTrackingIndexer extends
		AbstractBaseEmpInfoModelIndexer<TimeTracking> {

	private static final String DAY_OF_WEEK = "EEEE";

	// private static final String SUNDAY = "Sunday";

	@Override
	public String[] getClassNames() {
		return new String[] { TimeTracking.class.getName() };
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		final TimeTracking o = (TimeTracking) obj;
		deleteDocument(o.getCompanyId(), o.getTimeTrackingId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final TimeTracking o = (TimeTracking) obj;
		final Document document = super.doGetDocument(o);

		final SimpleDateFormat sdf = new SimpleDateFormat(DAY_OF_WEEK,
				Locale.ENGLISH);

		document.addNumber(TimeTrackingField.ID, o.getTimeTrackingId());

		document.addDate(TimeTrackingField.DATE, o.getDate());
		document.addText(TimeTrackingField.DAY, sdf.format(o.getDate()));
		document.addDate(TimeTrackingField.IN_1, o.getIn1());
		document.addDate(TimeTrackingField.OUT_1, o.getOut1());

		document.addDate(TimeTrackingField.IN_2, o.getIn2());
		document.addDate(TimeTrackingField.OUT_2, o.getOut2());

		document.addDate(TimeTrackingField.IN_3, o.getIn3());
		document.addDate(TimeTrackingField.OUT_3, o.getOut3());

		if (o.getLeaveRefId() != 0) {
			VacationLeave leave = VacationLeaveLocalServiceUtil
					.fetchVacationLeave(o.getLeaveRefId());
			document.addNumber(VacationLeaveField.ID,
					leave.getVacationLeaveId());

			document.addText(VacationLeaveField.LEAVE_TYPE,
					leave.getLeaveType());
			document.addDate(VacationLeaveField.LEAVE_FROM,
					leave.getLeaveFrom());
			document.addDate(VacationLeaveField.LEAVE_TO, leave.getLeaveTo());
			document.addDate(VacationLeaveField.ACTUAL_TO, leave.getActualTo());
			document.addNumber(VacationLeaveField.NUMBER_OF_HOURS,
					leave.getNumberOfHours());
			document.addText(VacationLeaveField.STATUS, leave.getStatus());
			document.addText(VacationLeaveField.REASON, leave.getReason());
			document.addText(VacationLeaveField.DESCRIPTION,
					leave.getDescription());
		}
		// document.addText(TimeTrackingField.IS_EMPTY_IN,
		// isAllInEmpty(o) ? "true" : "false");
		// document.addText(TimeTrackingField.IS_EMPTY_OUT,
		// isAllOutEmpty(o) ? "true" : "false");

		document.addKeyword(Field.GROUP_ID, getSiteGroupId(o.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, o.getGroupId());
		return document;
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return ECO_TT_Info.PORTLET_ID;
	}

	// private static boolean isAllInEmpty(TimeTracking o) {
	// if (SUNDAY.equalsIgnoreCase(getDayOfWeek(o.getDate()))) {
	// if (!(o.getOut1() == null && o.getOut2() == null && o.getOut3() == null))
	// {
	// return o.getIn1() == null && o.getIn2() == null
	// && o.getIn3() == null;
	// } else {
	// return false;
	// }
	// }
	// return o.getIn1() == null && o.getIn2() == null && o.getIn3() == null;
	// }
	//
	// private static boolean isAllOutEmpty(TimeTracking o) {
	//
	// if (SUNDAY.equalsIgnoreCase(getDayOfWeek(o.getDate()))) {
	// if (!(o.getIn1() == null && o.getIn2() == null && o.getIn3() == null)) {
	// return o.getOut1() == null && o.getOut2() == null
	// && o.getOut3() == null;
	// } else {
	// return false;
	// }
	// }
	// return o.getOut1() == null && o.getOut2() == null
	// && o.getOut3() == null;
	// }

	// private static String getDayOfWeek(Date date) {
	// final SimpleDateFormat sdf = new SimpleDateFormat(DAY_OF_WEEK,
	// Locale.ENGLISH);
	// return sdf.format(date);
	// }

	@Override
	protected long getEmpId(TimeTracking t) {
		return t.getEmpId();
	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new TimeTrackingActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				TimeTracking obj = (TimeTracking) object;

				Document document = getDocument(obj);

				documents.add(document);
			}

		};
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		final TimeTracking timeTracking = (TimeTracking) obj;
		Document document = getDocument(timeTracking);
		SearchEngineUtil.updateDocument(getSearchEngineId(),
				timeTracking.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		final TimeTracking timeTracking = TimeTrackingLocalServiceUtil
				.fetchTimeTracking(classPK);
		doReindex(timeTracking);
	}

}
