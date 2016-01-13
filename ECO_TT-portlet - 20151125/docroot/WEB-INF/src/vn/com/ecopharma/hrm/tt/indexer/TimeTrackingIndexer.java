package vn.com.ecopharma.hrm.tt.indexer;

import java.util.Locale;

import javax.portlet.PortletURL;

import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.constant.ECO_TT_Info;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class TimeTrackingIndexer extends BaseIndexer {

	@Override
	public String[] getClassNames() {
		return new String[] { TimeTracking.class.getName() };
	}

	@Override
	public String getPortletId() {
		return ECO_TT_Info.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		final TimeTracking o = (TimeTracking) obj;
		deleteDocument(o.getCompanyId(), o.getTimeTrackingId());
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final TimeTracking o = (TimeTracking) obj;
		final Document document = getBaseModelDocument(ECO_TT_Info.PORTLET_ID,
				o);
		final Emp emp = EmpLocalServiceUtil.fetchEmp(o.getEmpId());
		final User user = UserLocalServiceUtil.fetchUser(emp.getEmpUserId());
		final Titles titles = TitlesLocalServiceUtil.fetchTitles(emp
				.getTitlesId());
		final Unit unit = UnitLocalServiceUtil.fetchUnit(titles.getUnitId());

		document.addNumber(TimeTrackingField.ID, o.getTimeTrackingId());

		document.addNumber(TimeTrackingField.EMP_ID, o.getEmpId());
		document.addText(TimeTrackingField.EMP_CODE, emp.getEmpCode());
		document.addText(TimeTrackingField.FULLNAME, user.getFullName());
		document.addText(TimeTrackingField.UNIT, unit.getName());
		document.addText(TimeTrackingField.TITLES, titles.getName());

		document.addDate(TimeTrackingField.DATE, o.getDate());
		document.addDate(TimeTrackingField.IN_1, o.getIn1());
		document.addDate(TimeTrackingField.OUT_1, o.getOut1());

		document.addDate(TimeTrackingField.IN_2, o.getIn2());
		document.addDate(TimeTrackingField.OUT_2, o.getOut2());

		document.addDate(TimeTrackingField.IN_3, o.getIn3());
		document.addDate(TimeTrackingField.OUT_3, o.getOut3());

		document.addKeyword(Field.GROUP_ID, getSiteGroupId(o.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, o.getGroupId());
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		final Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		final TimeTracking o = (TimeTracking) obj;
		final Document document = getDocument(o);
		SearchEngineUtil.updateDocument(getSearchEngineId(), o.getCompanyId(),
				document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		final TimeTracking o = TimeTrackingLocalServiceUtil
				.fetchTimeTracking(classPK);
		doReindex(o);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		for (String id : ids) {
			doReindex(TimeTracking.class.getName(), Long.valueOf(id));
		}
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return ECO_TT_Info.PORTLET_ID;
	}

}
