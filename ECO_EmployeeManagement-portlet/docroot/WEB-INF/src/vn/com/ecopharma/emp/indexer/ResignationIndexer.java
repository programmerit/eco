package vn.com.ecopharma.emp.indexer;

import java.util.Collection;

import vn.com.ecopharma.emp.constant.ResignationHistoryField;
import vn.com.ecopharma.emp.model.ResignationHistory;
import vn.com.ecopharma.emp.permission.ResignationHistoryPermission;
import vn.com.ecopharma.emp.service.ResignationHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.ResignationHistoryActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.security.permission.PermissionChecker;

public class ResignationIndexer extends
		AbstractBaseEmpInfoModelIndexer<ResignationHistory> {

	private String[] CLASS_NAMES = new String[] { ResignationHistory.class
			.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		ResignationHistory r = (ResignationHistory) obj;
		final Document document = super.doGetDocument(r);
		document.addNumber(ResignationHistoryField.ID,
				r.getResignationHistoryId());
		document.addDate(ResignationHistoryField.RESIGNED_DATE,
				r.getResignedDate());
		document.addText(ResignationHistoryField.RESIGNED_TYPE,
				r.getResignedType());
		document.addText(ResignationHistoryField.COMMENT, r.getComment());
		document.addText(ResignationHistoryField.IS_DELETED,
				r.isDeleted() ? "true" : "false");
		return document;
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

	@Override
	protected long getEmpId(ResignationHistory obj) {
		return obj.getEmployeeId();
	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new ResignationHistoryActionableDynamicQuery() {

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
	}

}
