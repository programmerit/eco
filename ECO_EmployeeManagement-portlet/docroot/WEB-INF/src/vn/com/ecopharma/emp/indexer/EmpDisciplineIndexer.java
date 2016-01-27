package vn.com.ecopharma.emp.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.PromotedHistoryField;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.permission.PromotedHistoryPermission;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.PromotedHistoryActionableDynamicQuery;
import vn.com.ecopharma.emp.util.EmployeeUtils;

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
import com.liferay.portal.service.UserLocalServiceUtil;

public class EmpDisciplineIndexer extends BaseIndexer {

	private String[] CLASS_NAMES = new String[] { EmpDiscipline.class
			.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return EMInfo.PORTLET_ID;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		EmpDiscipline e = (EmpDiscipline)obj;
		Emp employee = EmpLocalServiceUtil.fetchEmp(p.getEmployeeId());
		Titles oldTitles = TitlesLocalServiceUtil.fetchTitles(p
				.getOldTitlesId());
		Titles newTitles = TitlesLocalServiceUtil.fetchTitles(p
				.getNewTitlesId());
		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID, p);

		document.addNumber(PromotedHistoryField.ID, p.getPromotedHistoryId());
		document.addNumber(PromotedHistoryField.EMPLOYEE_ID, p.getEmployeeId());
		document.addDate(PromotedHistoryField.PROMOTED_DATE,
				p.getPromotedDate());
		document.addText(PromotedHistoryField.OLD_TITLES,
				oldTitles != null ? oldTitles.getName() : StringUtils.EMPTY);

		document.addText(PromotedHistoryField.NEW_TITLES, newTitles.getName());

		document.addText(PromotedHistoryField.FULLNAME, EmployeeUtils
				.getViFullnameFromUser(UserLocalServiceUtil.fetchUser(employee
						.getEmpUserId())));
		document.addText(PromotedHistoryField.COMMENT, p.getComment());
		document.addText(PromotedHistoryField.IS_DELETED,
				p.isDeleted() ? "true" : "false");
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		PromotedHistory p = (PromotedHistory) obj;
		Document document = getDocument(p);

		SearchEngineUtil.updateDocument(getSearchEngineId(), p.getCompanyId(),
				document);

	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		PromotedHistory r = PromotedHistoryLocalServiceUtil
				.fetchPromotedHistory(classPK);
		doReindex(r);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexPromotedHistory(companyId);
	}

	protected void reindexPromotedHistory(long companyId)
			throws SystemException, PortalException {
		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new PromotedHistoryActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
				super.addCriteria(dynamicQuery);
			}

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				PromotedHistory o = (PromotedHistory) object;
				Document document = getDocument(o);
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
		return EMInfo.PORTLET_ID;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return PromotedHistoryPermission.contains(permissionChecker,
				entryClassPK, actionId);

	}
	
}
