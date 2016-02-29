package vn.com.ecopharma.emp.indexer;

import java.util.Collection;

import vn.com.ecopharma.emp.constant.VacationLeaveField;
import vn.com.ecopharma.emp.model.VacationLeave;
import vn.com.ecopharma.emp.service.VacationLeaveLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.VacationLeaveActionableDynamicQuery;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchEngineUtil;

public class VacationLeaveIndexer extends
		AbstractBaseEmpInfoModelIndexer<VacationLeave> {

	@Override
	protected long getEmpId(VacationLeave t) {
		return t.getEmpId();
	}

	@Override
	public String[] getClassNames() {
		return new String[] { VacationLeave.class.getName() };
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		VacationLeave vacationLeave = (VacationLeave) obj;
		Document document = super.doGetDocument(vacationLeave);

		document.addNumber(VacationLeaveField.ID,
				vacationLeave.getVacationLeaveId());

		document.addText(VacationLeaveField.LEAVE_TYPE,
				vacationLeave.getLeaveType());
		document.addDate(VacationLeaveField.LEAVE_FROM,
				vacationLeave.getLeaveFrom());
		document.addDate(VacationLeaveField.LEAVE_TO,
				vacationLeave.getLeaveTo());
		document.addDate(VacationLeaveField.ACTUAL_TO,
				vacationLeave.getActualTo());
		document.addNumber(VacationLeaveField.NUMBER_OF_HOURS,
				vacationLeave.getNumberOfHours());

		document.addText(VacationLeaveField.REASON, vacationLeave.getReason());
		document.addText(VacationLeaveField.DESCRIPTION,
				vacationLeave.getDescription());
		document.addText(VacationLeaveField.STATUS, vacationLeave.getStatus());

		document.addText(VacationLeaveField.IS_DELETED,
				vacationLeave.isDeleted() ? "true" : "false");

		document.addText(Field.TITLE, VacationLeave.class.getName());
		document.addDate(Field.CREATE_DATE, vacationLeave.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, vacationLeave.getModifiedDate());
		document.addKeyword(Field.GROUP_ID,
				getSiteGroupId(vacationLeave.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, vacationLeave.getGroupId());
		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		VacationLeave v = (VacationLeave) obj;
		Document document = getDocument(v);
		SearchEngineUtil.updateDocument(getSearchEngineId(), v.getCompanyId(),
				document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		VacationLeave v = VacationLeaveLocalServiceUtil
				.fetchVacationLeave(classPK);
		doReindex(v);
	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new VacationLeaveActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
				super.addCriteria(dynamicQuery);
			}

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				VacationLeave o = (VacationLeave) object;
				Document document = getDocument(o);
				documents.add(document);
			}
		};
	}

}
