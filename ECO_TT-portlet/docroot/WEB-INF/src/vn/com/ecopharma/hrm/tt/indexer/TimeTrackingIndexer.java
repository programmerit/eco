package vn.com.ecopharma.hrm.tt.indexer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javax.portlet.PortletURL;

import org.apache.commons.lang3.StringUtils;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.constant.ECO_TT_Info;
import vn.com.ecopharma.hrm.tt.constant.TimeTrackingField;
import vn.com.ecopharma.hrm.tt.model.TimeTracking;
import vn.com.ecopharma.hrm.tt.service.TimeTrackingLocalServiceUtil;
import vn.com.ecopharma.hrm.tt.service.persistence.TimeTrackingActionableDynamicQuery;
import vn.com.ecopharma.hrm.tt.utils.TTUtils;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class TimeTrackingIndexer extends BaseIndexer {

	private static final String DAY_OF_WEEK = "EEEE";

	private static final String SUNDAY = "Sunday";

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
		final Titles titles = emp.getTitlesId() != 0 ? TitlesLocalServiceUtil
				.getTitles(emp.getTitlesId()) : null;

		final Unit unit = emp.getUnitId() != 0 ? UnitLocalServiceUtil
				.fetchUnit(emp.getUnitId()) : null;

		final UnitGroup unitGroup = emp.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
				.fetchUnitGroup(emp.getUnitGroupId()) : null;

		final Department department = emp.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
				.fetchDepartment(emp.getDepartmentId()) : null;

		final Devision devision = department != null ? DevisionLocalServiceUtil
				.getDevision(department.getDevisionId()) : null;

		final SimpleDateFormat sdf = new SimpleDateFormat(DAY_OF_WEEK,
				Locale.ENGLISH);

		document.addNumber(TimeTrackingField.ID, o.getTimeTrackingId());

		document.addNumber(TimeTrackingField.EMP_ID, o.getEmpId());
		document.addText(TimeTrackingField.EMP_CODE, emp.getEmpCode());
		document.addText(TimeTrackingField.FULLNAME, user.getFullName());

		document.addText(TimeTrackingField.VN_FULLNAME,
				TTUtils.getViFullnameFromUser(user));
		document.addText(TimeTrackingField.DEVISION, devision.getName());
		document.addText(TimeTrackingField.DEPARTMENT, department.getName());
		document.addText(TimeTrackingField.UNIT, unit != null ? unit.getName()
				: StringUtils.EMPTY);
		document.addText(TimeTrackingField.UNIT_GROUP,
				unitGroup != null ? unitGroup.getName() : StringUtils.EMPTY);
		document.addText(TimeTrackingField.TITLES, titles.getName());

		document.addDate(TimeTrackingField.DATE, o.getDate());
		document.addText(TimeTrackingField.DAY, sdf.format(o.getDate()));
		document.addDate(TimeTrackingField.IN_1, o.getIn1());
		document.addDate(TimeTrackingField.OUT_1, o.getOut1());

		document.addDate(TimeTrackingField.IN_2, o.getIn2());
		document.addDate(TimeTrackingField.OUT_2, o.getOut2());

		document.addDate(TimeTrackingField.IN_3, o.getIn3());
		document.addDate(TimeTrackingField.OUT_3, o.getOut3());
		document.addText(TimeTrackingField.IS_EMPTY_IN,
				isAllInEmpty(o) ? "true" : "false");
		document.addText(TimeTrackingField.IS_EMPTY_OUT,
				isAllOutEmpty(o) ? "true" : "false");

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
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws PortalException,
			SystemException {

		final Collection<Document> documents = new ArrayList<>();

		ActionableDynamicQuery actionableDynamicQuery = new TimeTrackingActionableDynamicQuery() {

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

		actionableDynamicQuery.setCompanyId(companyId);

		actionableDynamicQuery.performActions();

		SearchEngineUtil.updateDocuments(getSearchEngineId(), companyId,
				documents);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return ECO_TT_Info.PORTLET_ID;
	}

	private static boolean isAllInEmpty(TimeTracking o) {
		if (SUNDAY.equalsIgnoreCase(getDayOfWeek(o.getDate()))) {
			if (!(o.getOut1() == null && o.getOut2() == null && o.getOut3() == null)) {
				return o.getIn1() == null && o.getIn2() == null
						&& o.getIn3() == null;
			} else {
				return false;
			}
		}
		return o.getIn1() == null && o.getIn2() == null && o.getIn3() == null;
	}

	private static boolean isAllOutEmpty(TimeTracking o) {

		if (SUNDAY.equalsIgnoreCase(getDayOfWeek(o.getDate()))) {
			if (!(o.getIn1() == null && o.getIn2() == null && o.getIn3() == null)) {
				return o.getOut1() == null && o.getOut2() == null
						&& o.getOut3() == null;
			} else {
				return false;
			}
		}
		return o.getOut1() == null && o.getOut2() == null
				&& o.getOut3() == null;
	}

	private static String getDayOfWeek(Date date) {
		final SimpleDateFormat sdf = new SimpleDateFormat(DAY_OF_WEEK,
				Locale.ENGLISH);
		return sdf.format(date);
	}

}
