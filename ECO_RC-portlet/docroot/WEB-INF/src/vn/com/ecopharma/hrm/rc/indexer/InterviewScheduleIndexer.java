package vn.com.ecopharma.hrm.rc.indexer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.constant.InterviewScheduleField;
import vn.com.ecopharma.hrm.rc.dto.CandidateIndexItem;
import vn.com.ecopharma.hrm.rc.dto.EmpIndexedItem;
import vn.com.ecopharma.hrm.rc.dto.VacancyIndexItem;
import vn.com.ecopharma.hrm.rc.model.EmployeeInterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.Interview;
import vn.com.ecopharma.hrm.rc.model.InterviewSchedule;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.permission.InterviewSchedulePermission;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.EmployeeInterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.InterviewScheduleLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.persistence.InterviewScheduleActionableDynamicQuery;
import vn.com.ecopharma.hrm.rc.util.RCUtils;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.security.permission.PermissionChecker;

public class InterviewScheduleIndexer extends BaseIndexer {

	private Date timeFrom;
	private Date timeTo;

	@Override
	public String[] getClassNames() {
		return new String[] { InterviewSchedule.class.getName() };
	}

	@Override
	public String getPortletId() {
		return ECO_RCUtils.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		final InterviewSchedule o = (InterviewSchedule) obj;
		// vacancy.setDeleted(true);
		// doReindex(vacancy);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final InterviewSchedule o = (InterviewSchedule) obj;
		final Document doc = getBaseModelDocument(ECO_RCUtils.PORTLET_ID, o);
		final VacancyCandidate vacancyCandidate = VacancyCandidateLocalServiceUtil
				.getVacancyCandidate(o.getVacancyCandidateId());
		final Interview interview = InterviewLocalServiceUtil.getInterview(o
				.getInterviewId());
		final SearchContext searchContext = RCUtils.getCurrentSearchContext();
		doc.addNumber(InterviewScheduleField.ID, o.getInterviewScheduleId());
		doc.addNumber(InterviewScheduleField.VACANCY_CANDIDATE_ID,
				o.getVacancyCandidateId());
		doc.addNumber(InterviewScheduleField.INTERVIEW_ID,
				interview.getInterviewId());
		doc.addNumber(InterviewScheduleField.CANDIDATE_ID,
				vacancyCandidate.getCandidateId());
		doc.addNumber(InterviewScheduleField.VACANCY_ID,
				vacancyCandidate.getVacancyId());

		doc.addNumber(InterviewScheduleField.LOCATION_ID, o.getLocationId());

		doc.addText(
				InterviewScheduleField.VACANCY,
				new VacancyIndexItem(VacancyLocalServiceUtil
						.getIndexVacancyDocument(
								vacancyCandidate.getVacancyId(), searchContext))
						.getName());

		doc.addText(
				InterviewScheduleField.CANDIDATE,
				new CandidateIndexItem(CandidateLocalServiceUtil
						.getIndexCandidateDocument(
								vacancyCandidate.getCandidateId(),
								searchContext)).getFullName());
		doc.addText(InterviewScheduleField.STATUS, o.getStatus());
		doc.addText(InterviewScheduleField.INTERVIEW_NAME, interview.getName());

		doc.addDate(InterviewScheduleField.INTERVIEW_DATE, o.getInterviewDate());

		doc.addText(InterviewScheduleField.INTERVIEW_TIME, o.getInterviewTime());

		setTimeByInterviewSchedule(o);

		doc.addDate(InterviewScheduleField.INTERVIEW_TIME_FROM, this.timeFrom);

		doc.addDate(InterviewScheduleField.INTERVIEW_TIME_FROM, this.timeTo);

		doc.addText(InterviewScheduleField.INTERVIEWERS,
				getInterviewerFullNamesByInterviewSchedule(o));

		doc.addNumber(InterviewScheduleField.INTERVIEWER_IDS,
				getInterviewerIdsByInterviewSchedule(o));

		return doc;
	}

	private void setTimeByInterviewSchedule(InterviewSchedule interviewSchedule) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(interviewSchedule.getInterviewDate());
		final String time = interviewSchedule.getInterviewTime(); // format:
																	// 08:00-09:00
		final String timeFromString = time.split("-")[0];
		final String timeToString = time.split("-")[1];

		int fromHour = Integer.parseInt(timeFromString.split(":")[0]);
		int fromMin = Integer.parseInt(timeFromString.split(":")[1]);

		int toHour = Integer.parseInt(timeToString.split(":")[0]);
		int toMin = Integer.parseInt(timeToString.split(":")[1]);

		calendar.set(Calendar.HOUR, fromHour);
		calendar.set(Calendar.MINUTE, fromMin);
		this.timeFrom = calendar.getTime();

		calendar.set(Calendar.HOUR, toHour);
		calendar.set(Calendar.MINUTE, toMin);
		this.timeTo = calendar.getTime();
	}

	private List<EmpIndexedItem> getInterviewersByInterviewSchedule(
			InterviewSchedule interviewSchedule) {
		final List<EmpIndexedItem> items = new ArrayList<EmpIndexedItem>();
		for (EmployeeInterviewSchedule item : EmployeeInterviewScheduleLocalServiceUtil
				.findByInterviewSchedule(interviewSchedule
						.getInterviewScheduleId())) {
			final EmpIndexedItem e = new EmpIndexedItem(
					EmpLocalServiceUtil.getIndexedEmp(item.getEmployeeId(),
							RCUtils.getCurrentSearchContext()));
			items.add(e);
		}
		return items;
	}

	private String[] getInterviewerFullNamesByInterviewSchedule(
			InterviewSchedule interviewSchedule) {
		final List<EmpIndexedItem> employeeIndexedItems = getInterviewersByInterviewSchedule(interviewSchedule);
		final String[] result = new String[employeeIndexedItems.size()];
		for (int i = 0; i < employeeIndexedItems.size(); i++) {
			result[i] = employeeIndexedItems.get(i).getFullName();
		}
		return result;
	}

	private Long[] getInterviewerIdsByInterviewSchedule(
			InterviewSchedule interviewSchedule) {
		final List<EmpIndexedItem> employeeIndexedItems = getInterviewersByInterviewSchedule(interviewSchedule);
		final Long[] result = new Long[employeeIndexedItems.size()];
		for (int i = 0; i < employeeIndexedItems.size(); i++) {
			result[i] = employeeIndexedItems.get(i).getEmployeeId();
		}
		return result;
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
		final InterviewSchedule o = (InterviewSchedule) obj;
		final Document document = getDocument(o);
		SearchEngineUtil.updateDocument(getSearchEngineId(), o.getCompanyId(),
				document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		final InterviewSchedule o = InterviewScheduleLocalServiceUtil
				.getInterviewSchedule(classPK);
		doReindex(o);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws PortalException,
			SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new InterviewScheduleActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				InterviewSchedule obj = (InterviewSchedule) object;

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
		return ECO_RCUtils.PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {
		return InterviewSchedulePermission.contains(permissionChecker,
				entryClassPK, actionId);
	}

	@Override
	public boolean isPermissionAware() {
		return true;
	}

}