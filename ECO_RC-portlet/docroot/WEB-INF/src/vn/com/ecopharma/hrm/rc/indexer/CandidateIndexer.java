package vn.com.ecopharma.hrm.rc.indexer;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletURL;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.hrm.rc.constant.CandidateField;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.enumeration.VacancyCandidateType;
import vn.com.ecopharma.hrm.rc.model.Candidate;
import vn.com.ecopharma.hrm.rc.model.VacancyCandidate;
import vn.com.ecopharma.hrm.rc.permission.CandidatePermission;
import vn.com.ecopharma.hrm.rc.service.CandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyCandidateLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.security.permission.PermissionChecker;

public class CandidateIndexer extends BaseIndexer {

	@Override
	public String[] getClassNames() {
		return new String[] { Candidate.class.getName() };
	}

	@Override
	public String getPortletId() {
		return ECO_RCUtils.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		final Candidate candidate = (Candidate) obj;
		candidate.setDeleted(true);
		// CandidateLocalServiceUtil.markDeleted(candidate);
		doReindex(candidate);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final Candidate candidate = (Candidate) obj;
		final long candidateId = candidate.getCandidateId();
		final Document doc = getBaseModelDocument(ECO_RCUtils.PORTLET_ID,
				candidate);
		// final VacancyCandidate vacancyCandidate =
		// VacancyCandidateLocalServiceUtil
		// .findByCandidateAndActiveStatus(candidateId);
		// TODO .... each candidate has only one MAIN vacancy at the same time
		final List<VacancyCandidate> vacancyCandidates = VacancyCandidateLocalServiceUtil
				.findByCandidateAndType(candidateId,
						VacancyCandidateType.MAIN.toString());
		final VacancyCandidate vacancyCandidate = vacancyCandidates != null
				&& !vacancyCandidates.isEmpty() ? vacancyCandidates.get(0)
				: null;

		doc.addNumber(CandidateField.CANDIDATE_ID, candidate.getCandidateId());
		doc.addText(CandidateField.FULLNAME, candidate.getFullName());
		doc.addText(CandidateField.EMAIL, candidate.getEmailAddress());
		doc.addText(CandidateField.CONTACT_NUMBER, candidate.getContactNumber());
		doc.addNumber(
				CandidateField.VACANCY_CANDIDATE_ID,
				vacancyCandidate != null ? vacancyCandidate
						.getVacancyCandidateId() : 0L);
		doc.addNumber(CandidateField.VACANCY_ID,
				vacancyCandidate != null ? vacancyCandidate.getVacancyId() : 0L);
		doc.addText(
				CandidateField.VACANCY,
				vacancyCandidate != null ? VacancyLocalServiceUtil.getVacancy(
						vacancyCandidate.getVacancyId()).getName()
						: StringUtils.EMPTY);
		doc.addNumber(CandidateField.LOCATION_ID, candidate.getLocationId());
		doc.addDate(CandidateField.APPLICATION_DATE,
				candidate.getApplicationDate());
		doc.addText(CandidateField.STATUS, candidate.getStatus());
		doc.addText(CandidateField.IS_DELETED, candidate.isDeleted() ? "true"
				: "false");
		doc.addKeyword(Field.GROUP_ID, getSiteGroupId(candidate.getGroupId()));
		doc.addKeyword(Field.SCOPE_GROUP_ID, candidate.getGroupId());

		return doc;
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
		final Candidate candidate = (Candidate) obj;
		final Document document = getDocument(candidate);
		SearchEngineUtil.updateDocument(getSearchEngineId(),
				candidate.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		final Candidate candidate = CandidateLocalServiceUtil
				.getCandidate(classPK);
		doReindex(candidate);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		for (String id : ids) {
			final Candidate candidate = CandidateLocalServiceUtil
					.getCandidate(Long.valueOf(id));
			doReindex(candidate);
		}
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return ECO_RCUtils.PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {
		return CandidatePermission.contains(permissionChecker, entryClassPK,
				actionId);
	}

	@Override
	public boolean isPermissionAware() {
		return true;
	}

}
