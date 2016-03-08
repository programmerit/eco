package vn.com.ecopharma.emp.indexer;

import java.util.Collection;

import vn.com.ecopharma.emp.constant.EmpAnnualLeaveField;
import vn.com.ecopharma.emp.model.EmpAnnualLeave;
import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.service.EmpAnnualLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.EmpAnnualLeaveActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchEngineUtil;

public class EmpAnnualLeaveIndexer extends
		AbstractBaseEmpInfoModelIndexer<EmpAnnualLeave> {

	@Override
	protected long getEmpId(EmpAnnualLeave t) {
		return t.getEmpId();
	}

	@Override
	public String[] getClassNames() {
		return new String[] { EmpAnnualLeave.class.getName() };
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final EmpAnnualLeave o = (EmpAnnualLeave) obj;
		final Document document = super.doGetDocument(o);

		document.addNumber(EmpAnnualLeaveField.ID, o.getEmpAnnualLeaveId());
		document.addNumber(EmpAnnualLeaveField.TOTAL_LEAVE,
				o.getTotalAnnualLeave());
		document.addNumber(EmpAnnualLeaveField.TOTAL_LEAVE_LEFT,
				o.getTotalAnualLeaveLeft());
		document.addNumber(EmpAnnualLeaveField.TOTAL_PREVIOUS_YEAR_LEAVE,
				o.getTotalPreviousYearLeavesLeft());

		document.addText(Field.TITLE, EmpDiscipline.class.getName());
		document.addDate(Field.CREATE_DATE, o.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, o.getModifiedDate());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(o.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, o.getGroupId());
		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		EmpAnnualLeave e = (EmpAnnualLeave) obj;
		Document document = getDocument(e);

		SearchEngineUtil.updateDocument(getSearchEngineId(), e.getCompanyId(),
				document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		EmpAnnualLeave e = EmpAnnualLeaveLocalServiceUtil
				.fetchEmpAnnualLeave(classPK);
		doReindex(e);
	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new EmpAnnualLeaveActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
				super.addCriteria(dynamicQuery);
			}

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				EmpAnnualLeave e = (EmpAnnualLeave) object;
				Document document = getDocument(e);
				documents.add(document);
			}
		};
	}

}
