package vn.com.ecopharma.emp.indexer;

import java.util.Collection;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.PromotedHistoryField;
import vn.com.ecopharma.emp.model.PromotedHistory;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.permission.PromotedHistoryPermission;
import vn.com.ecopharma.emp.service.PromotedHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.PromotedHistoryActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.security.permission.PermissionChecker;

public class PromotedHistoryIndexer extends
		AbstractBaseEmpInfoModelIndexer<PromotedHistory> {

	@Override
	public String[] getClassNames() {
		return new String[] { PromotedHistory.class.getName() };
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		PromotedHistory p = (PromotedHistory) obj;
		final Document document = super.doGetDocument(p);

		Titles oldTitles = TitlesLocalServiceUtil.fetchTitles(p
				.getOldTitlesId());
		Titles newTitles = TitlesLocalServiceUtil.fetchTitles(p
				.getNewTitlesId());

		document.addNumber(PromotedHistoryField.ID, p.getPromotedHistoryId());
		document.addDate(PromotedHistoryField.PROMOTED_DATE,
				p.getPromotedDate());
		document.addText(PromotedHistoryField.OLD_TITLES,
				oldTitles != null ? oldTitles.getName() : StringUtils.EMPTY);

		document.addText(PromotedHistoryField.NEW_TITLES, newTitles.getName());

		document.addText(PromotedHistoryField.COMMENT, p.getComment());
		document.addText(PromotedHistoryField.IS_DELETED,
				p.isDeleted() ? "true" : "false");
		return document;
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
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return PromotedHistoryPermission.contains(permissionChecker,
				entryClassPK, actionId);

	}

	@Override
	protected long getEmpId(PromotedHistory t) {
		return t.getEmployeeId();
	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new PromotedHistoryActionableDynamicQuery() {

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
	}

}
