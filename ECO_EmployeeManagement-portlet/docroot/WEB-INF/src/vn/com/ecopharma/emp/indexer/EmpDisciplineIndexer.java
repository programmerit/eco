package vn.com.ecopharma.emp.indexer;

import java.util.Collection;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpDisciplineField;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.EmpDiscipline;
import vn.com.ecopharma.emp.permission.EmpDisciplinePermission;
import vn.com.ecopharma.emp.service.EmpDisciplineLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.EmpDisciplineActionableDynamicQuery;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.security.permission.PermissionChecker;

public class EmpDisciplineIndexer extends
		AbstractBaseModelIndexer<EmpDiscipline> {

	private String[] CLASS_NAMES = new String[] { EmpDiscipline.class.getName() };

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	protected void doDelete(Object obj) throws Exception {

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final EmpDiscipline o = (EmpDiscipline) obj;
		final Emp emp = EmpLocalServiceUtil.fetchEmp(o.getEmpId());

		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID, o);
		SearchEngineUtils.indexOrganizationFields(document, emp);
		SearchEngineUtils.indexEmpInfo(document, emp);
		document.addNumber(EmpDisciplineField.ID, o.getEmpDisciplineId());
		document.addText(EmpDisciplineField.DECISION_NO, o.getDecisionNo());
		document.addText(EmpDisciplineField.CONTENT, o.getContent());
		document.addText(EmpDisciplineField.TYPE, o.getDisciplineType());
		document.addDate(EmpDisciplineField.EFFECTIVE_DATE,
				o.getEffectiveDate());
		document.addText(EmpDisciplineField.ADDITIONAL_DISCIPLINE,
				o.getAdditionalDisciplineType());
		document.addText(EmpDisciplineField.DESC, o.getDescription());

		document.addText(Field.TITLE, EmpDiscipline.class.getName());
		document.addDate(Field.CREATE_DATE, o.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, o.getModifiedDate());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(o.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, o.getGroupId());
		return document;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		EmpDiscipline e = (EmpDiscipline) obj;
		Document document = getDocument(e);

		SearchEngineUtil.updateDocument(getSearchEngineId(), e.getCompanyId(),
				document);

	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		EmpDiscipline e = EmpDisciplineLocalServiceUtil
				.fetchEmpDiscipline(classPK);
		doReindex(e);
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker,
			String entryClassName, long entryClassPK, String actionId)
			throws Exception {

		return EmpDisciplinePermission.contains(permissionChecker,
				entryClassPK, actionId);

	}

	@Override
	protected BaseActionableDynamicQuery getActionableDynamicQuery(
			final Collection<Document> documents) throws SystemException {
		return new EmpDisciplineActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
				super.addCriteria(dynamicQuery);
			}

			@Override
			protected void performAction(Object object) throws PortalException,
					SystemException {
				EmpDiscipline e = (EmpDiscipline) object;
				Document document = getDocument(e);
				documents.add(document);
			}
		};
	}

}
