package vn.com.ecopharma.hrm.rc.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.ECO_RCUtils;
import vn.com.ecopharma.hrm.rc.constant.VacancyField;
import vn.com.ecopharma.hrm.rc.model.Vacancy;
import vn.com.ecopharma.hrm.rc.permission.VacancyPermission;
import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.service.persistence.VacancyActionableDynamicQuery;
import vn.com.ecopharma.hrm.rc.util.SearchEngineUtils;

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

public class VacancyIndexer extends BaseIndexer {
	@Override
	public String[] getClassNames() {
		return new String[] { Vacancy.class.getName() };
	}

	@Override
	public String getPortletId() {
		return ECO_RCUtils.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		final Vacancy vacancy = (Vacancy) obj;
		vacancy.setDeleted(true);
		doReindex(vacancy);
	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final Vacancy vacancy = (Vacancy) obj;
		final Document doc = getBaseModelDocument(ECO_RCUtils.PORTLET_ID,
				vacancy);
		SearchEngineUtils.indexOrganizationFields(doc, vacancy);
		doc.addNumber(VacancyField.VACANCY_ID, vacancy.getVacancyId());
		// doc.addText(VacancyField.NAME, vacancy.getName());
		doc.addNumber(VacancyField.NUMBER_OF_POSITION,
				vacancy.getApprovedNumberOfPosition());
		doc.addText(VacancyField.DESCRIPTION, vacancy.getDescription());

		doc.addNumber(VacancyField.TITLES_ID, vacancy.getTitlesId());
		doc.addText(VacancyField.IS_DELETED, vacancy.isDeleted() ? "true"
				: "false");
		doc.addText(VacancyField.STATUS,
				EmpLocalServiceUtil.removeDashChar(vacancy.getStatus()));
		doc.addText(VacancyField.CERTIFICATE_TYPE, vacancy.getCertificateType());
		doc.addNumber(VacancyField.YEARS_EXPERIENCES, vacancy.getExperiences());
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
		final Vacancy vacancy = (Vacancy) obj;
		final Document document = getDocument(vacancy);
		SearchEngineUtil.updateDocument(getSearchEngineId(),
				vacancy.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		final Vacancy vacancy = VacancyLocalServiceUtil.getVacancy(classPK);
		doReindex(vacancy);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws PortalException,
			SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new VacancyActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				Vacancy obj = (Vacancy) object;

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
		return VacancyPermission.contains(permissionChecker, entryClassPK,
				actionId);
	}

	@Override
	public boolean isPermissionAware() {
		return true;
	}

}
