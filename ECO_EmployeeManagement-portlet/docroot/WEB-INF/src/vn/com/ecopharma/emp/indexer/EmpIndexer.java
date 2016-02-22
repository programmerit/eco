package vn.com.ecopharma.emp.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletURL;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Specialized;
import vn.com.ecopharma.emp.permission.EmpPermission;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.SpecializedLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.service.persistence.EmpActionableDynamicQuery;
import vn.com.ecopharma.emp.util.EmployeeUtils;
import vn.com.ecopharma.emp.util.ImportExportUtils;
import vn.com.ecopharma.emp.util.SearchEngineUtils;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.Address;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.UserLocalServiceUtil;

public class EmpIndexer extends BaseIndexer {

	@Override
	public String[] getClassNames() {
		return new String[] { Emp.class.getName() };
	}

	@Override
	public String getPortletId() {
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

		return EmpPermission
				.contains(permissionChecker, entryClassPK, actionId);

	}

	@Override
	protected void doDelete(Object obj) throws Exception {
		final Emp nv = (Emp) obj;
		deleteDocument(nv.getCompanyId(), nv.getEmpId());

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception { // NOSONAR
		final Emp emp = (Emp) obj;
		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID, emp);

		document.addNumber(EmpField.EMP_ID, emp.getEmpId());
		document.addNumber(EmpField.EMPLOYEE_USER_ID, emp.getEmpUserId());
		document.addText(EmpField.FULL_NAME,
				UserLocalServiceUtil.getUser(emp.getEmpUserId()).getFullName());
		document.addText(EmpField.VN_FULL_NAME, EmpLocalServiceUtil
				.getViFullnameFromUser(UserLocalServiceUtil.getUser(emp
						.getEmpUserId())));

		document.addText(EmpField.EMP_CODE, emp.getEmpCode());

		document.addDate(EmpField.BIRTHDAY, emp.getBirthday());

		document.addText(EmpField.GENDER, emp.getGender());

		document.addText(EmpField.ETHNIC, emp.getEthnic());

		document.addText(EmpField.NATIONALITY, emp.getNationality());

		document.addText(EmpField.RELIGION, emp.getReligion());

		document.addDate(EmpField.JOINED_DATE, emp.getJoinedDate());

		SearchEngineUtils.indexOrganizationFields(document, emp);

		document.addText(
				EmpField.LEVEL,
				emp.getLevelId() != 0 ? LevelLocalServiceUtil.getLevel(
						emp.getLevelId()).getName() : StringUtils.EMPTY);
		document.addDate(EmpField.PROMOTED_DATE, emp.getPromotedDate());
		document.addDate(EmpField.LABOR_CONTRACT_SIGNED_DATE,
				emp.getLaborContractSignedDate());
		document.addDate(EmpField.LABOR_CONTRACT_EXPIRED_DATE,
				emp.getLaborContractExpiredDate());
		document.addText(EmpField.LABOR_CONTRACT_TYPE,
				emp.getLaborContractType());
		document.addNumber(EmpField.LABOR_CONTRACT_SIGNED_TIME,
				String.valueOf(emp.getLaborContractSignedTime()));
		document.addText(EmpField.GENDER, emp.getGender());
		document.addText(EmpField.PLACE_OF_BIRTH, emp.getPlaceOfBirth());
		document.addText(EmpField.EDUCATION, emp.getEducation());
		long specializedId = emp.getSpecializeId();
		Specialized specialized = SpecializedLocalServiceUtil
				.fetchSpecialized(specializedId);
		document.addText(
				EmpField.EDUCATION_SPECIALIZE,
				emp.getEducationSpecialize() != null ? emp
						.getEducationSpecialize() : StringUtils.EMPTY);

		document.addText(EmpField.SPECIALIZED,
				specialized != null ? specialized.getName() : StringUtils.EMPTY);
		document.addText(EmpField.UNIVERSITY,
				emp.getUniversityId() != 0 ? UniversityLocalServiceUtil
						.getUniversity(emp.getUniversityId()).getName()
						: StringUtils.EMPTY);
		document.addText(EmpField.MARITAL_STATUS, emp.getMaritalStatus());
		document.addText(EmpField.IDENTITY_CARD_NO, emp.getIdentityCardNo());
		document.addDate(EmpField.ISSUED_DATE, emp.getIssuedDate());
		document.addText(EmpField.ISSUED_PLACE, emp.getIssuedPlace());
		document.addText(EmpField.PASSPORT, emp.getPassport());

		document.addText(EmpField.CONTACT_NUMBER, emp.getContactNumber());
		Address address = EmpLocalServiceUtil.getPresentAddress(
				emp.getCompanyId(), emp.getEmpId());
		document.addText(EmpField.ADDRESS,
				EmployeeUtils.removeDashChar(ImportExportUtils
						.getFullAddressString(address)));
		document.addText(
				EmpField.CITY,
				address != null ? EmployeeUtils.removeDashChar(address
						.getRegion().getName()) : StringUtils.EMPTY);
		document.addText(EmpField.EMAIL,
				UserLocalServiceUtil.getUser(emp.getEmpUserId())
						.getEmailAddress());
		document.addText(EmpField.PERSONAL_EMAIL_ADDRESS,
				emp.getPersonalEmail());
		document.addText(EmpField.TAX_CODE, emp.getPersonalTaxCode());
		document.addNumber(EmpField.NUMBER_OF_DEPENDENTS,
				emp.getNumberOfDependents());
		document.addText(EmpField.DEPENDENT_NAMES, emp.getDependentNames());
		document.addText(EmpField.SOCIAL_INSURANCE_NO,
				emp.getSocialInsuranceNo());
		document.addText(EmpField.HEALTH_INSURANCE_NO,
				emp.getHealthInsuranceNo());

		document.addNumber(EmpField.BASE_WAGE_RATES, emp.getBaseWageRates());
		document.addNumber(EmpField.POSITION_WAGE_RATES,
				emp.getPositionWageRates());
		document.addNumber(EmpField.CAPACITY_SALARY, emp.getCapacitySalary());
		document.addNumber(EmpField.TOTAL_SALARY, emp.getTotalSalary());
		document.addNumber(EmpField.BONUS, emp.getBonus());
		document.addDate(EmpField.RESIGNED_DATE, emp.getResignedDate());

		document.addText(EmpField.STATUS,
				EmployeeUtils.removeDashChar(emp.getStatus()));

		document.addText(EmpField.IS_DELETED, emp.isDeleted() ? "true"
				: "false");

		document.addNumber(EmpField.LEVEL_ID, emp.getLevelId());

		document.addNumber(EmpField.UNIVERSITY_ID, emp.getUniversityId());

		document.addText(Field.TITLE, Emp.class.getName());
		document.addDate(Field.CREATE_DATE, emp.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, emp.getModifiedDate());
		document.addKeyword(Field.GROUP_ID, getSiteGroupId(emp.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, emp.getGroupId());
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
		final Emp emp = (Emp) obj;
		Document document = getDocument(emp);

		SearchEngineUtil.updateDocument(getSearchEngineId(),
				emp.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		final Emp emp = EmpLocalServiceUtil.fetchEmp(classPK);
		doReindex(emp);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);
		reindexEntries(companyId);
	}

	protected void reindexEntries(long companyId) throws PortalException,
			SystemException {

		final Collection<Document> documents = new ArrayList<Document>();

		ActionableDynamicQuery actionableDynamicQuery = new EmpActionableDynamicQuery() {

			@Override
			protected void addCriteria(DynamicQuery dynamicQuery) {
			}

			@Override
			protected void performAction(Object object) throws PortalException {
				Emp emp = (Emp) object;

				Document document = getDocument(emp);

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

}
