package vn.com.ecopharma.emp.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.ResignationHistoryField;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.permission.ResignationHistoryPermission;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.ResignationHistoryActionableDynamicQuery;

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

public class ResignationIndexer extends BaseIndexer {

	private String[] CLASS_NAMES = new String[] { ResignationHistory.class
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
		ResignationHistory r = ResignationHistoryLocalServiceUtil
				.fetchResignationHistory(((ResignationHistory) obj)
						.getResignationHistoryId());
		Emp employee = EmpLocalServiceUtil.fetchEmp(r.getEmployeeId());
		Titles titles = TitlesLocalServiceUtil.fetchTitles(employee
				.getTitlesId());
		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID, r);

		document.addNumber(ResignationHistoryField.ID,
				r.getResignationHistoryId());
		document.addNumber(ResignationHistoryField.EMPLOYEE_ID,
				r.getEmployeeId());
		document.addDate(ResignationHistoryField.RESIGNED_DATE,
				r.getResignedDate());
		document.addText(ResignationHistoryField.RESIGNED_TYPE,
				r.getResignedType());
		document.addText(ResignationHistoryField.FULLNAME, UserLocalServiceUtil
				.fetchUser(employee.getEmpUserId()).getFullName());
		document.addText(ResignationHistoryField.TITLES, titles.getName());
		document.addText(ResignationHistoryField.COMMENT, r.getComment());
		document.addText(ResignationHistoryField.IS_DELETED,
				r.isDeleted() ? "true" : "false");
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
		ResignationHistory r = (ResignationHistory) obj;
		Document document = getDocument(r);

		SearchEngineUtil.updateDocument(getSearchEngineId(), r.getCompanyId(),
				document);

	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		ResignationHistory r = ResignationHistoryLocalServiceUtil
				.fetchResignationHistory(classPK);
		doReindex(r);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexResignationHistory(companyId);
	}

	protected void reindexResignationHistory(long companyId)
			throws SystemException, PortalException {
		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new ResignationHistoryActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
				super.addCriteria(dynamicQuery);
			}

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				ResignationHistory r = (ResignationHistory) object;
				Document document = getDocument(r);
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
	public boolean isPermissionAware() {
		return true;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return ResignationHistoryPermission.contains(permissionChecker,
				entryClassPK, actionId);

	}

}
