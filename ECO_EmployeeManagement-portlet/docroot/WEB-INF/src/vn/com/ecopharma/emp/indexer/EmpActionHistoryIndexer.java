package vn.com.ecopharma.emp.indexer;

import java.util.Collection;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpActionHistoryField;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.model.EmpActionHistory;
import vn.com.ecopharma.emp.service.EmpActionHistoryLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.EmpActionHistoryActionableDynamicQuery;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.service.UserLocalServiceUtil;

public class EmpActionHistoryIndexer extends
		AbstractBaseModelIndexer<EmpActionHistory> {

	@Override
	public String[] getClassNames() {
		return new String[] { EmpActionHistory.class.getName() };
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		EmpActionHistory history = (EmpActionHistory) obj;
		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID,
				history);
		final long empId = history.getEmpId();
		final long performedById = history.getPerformedBy();

		if (EmpLocalServiceUtil.fetchEmp(empId) != null) {
			SearchEngineUtils.indexEmpInfo(document, empId);
		} else {
			document.addNumber(EmpField.EMP_ID, empId);
		}
		document.addNumber(EmpActionHistoryField.ID,
				history.getEmpActionHistoryId());
		document.addText(EmpActionHistoryField.ACTION, history.getAction());
		document.addText(EmpActionHistoryField.PERFORMED_BY,
				UserLocalServiceUtil.fetchUser(performedById).getFullName());
		document.addNumber(EmpActionHistoryField.PERFORMED_BY_ID, performedById);
		document.addNumber(EmpActionHistoryField.DESCRIPTION,
				history.getDescription());
		document.addText(EmpActionHistoryField.STATUS, history.getStatus());

		document.addText(Field.TITLE, EmpActionHistory.class.getName());
		document.addDate(Field.CREATE_DATE, history.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, history.getModifiedDate());
		document.addKeyword(Field.GROUP_ID,
				getSiteGroupId(history.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, history.getGroupId());

		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		EmpActionHistory e = (EmpActionHistory) obj;
		Document document = getDocument(e);

		SearchEngineUtil.updateDocument(getSearchEngineId(), e.getCompanyId(),
				document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		EmpActionHistory e = EmpActionHistoryLocalServiceUtil
				.fetchEmpActionHistory(classPK);
		doReindex(e);
	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new EmpActionHistoryActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
				super.addCriteria(dynamicQuery);
			}

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				EmpActionHistory e = (EmpActionHistory) object;
				Document document = getDocument(e);
				documents.add(document);
			}
		};
	}

}
