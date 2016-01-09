package vn.com.ecopharma.emp.indexer;

import java.util.Locale;

import javax.portlet.PortletURL;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.EMInfo;
import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.permission.EmpPermission;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.LevelLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.emp.service.UniversityLocalServiceUtil;
import vn.com.ecopharma.emp.util.EmployeeUtils;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
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
		Emp nv = (Emp) obj;
		deleteDocument(nv.getCompanyId(), nv.getEmpId());

	}

	@Override
	protected Document doGetDocument(Object obj) throws Exception {
		final Emp emp = (Emp) obj;
		final Document document = getBaseModelDocument(EMInfo.PORTLET_ID, emp);
		final Titles titles = emp.getTitlesId() != 0 ? TitlesLocalServiceUtil
				.getTitles(emp.getTitlesId()) : null;

		final Unit unit = emp.getUnitId() != 0 ? UnitLocalServiceUtil
				.fetchUnit(emp.getUnitId()) : null;

		final UnitGroup unitGroup = emp.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
				.fetchUnitGroup(emp.getUnitGroupId()) : null;

		final Department department = emp.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
				.fetchDepartment(emp.getDepartmentId()) : null;

		final Devision devision = department != null ? DevisionLocalServiceUtil
				.getDevision(department.getDevisionId()) : null;

		document.addNumber(EmpField.EMP_ID, emp.getEmpId());
		document.addText(Field.TITLE, Emp.class.getName());
		document.addDate(Field.CREATE_DATE, emp.getCreateDate());
		document.addDate(Field.MODIFIED_DATE, emp.getModifiedDate());

		document.addNumber(EmpField.EMPLOYEE_USER_ID, emp.getEmpUserId());
		document.addText(EmpField.FULL_NAME,
				UserLocalServiceUtil.getUser(emp.getEmpUserId()).getFullName());
		document.addText(EmpField.VN_FULL_NAME, EmployeeUtils
				.getViFullnameFromUser(UserLocalServiceUtil.getUser(emp
						.getEmpUserId())));

		document.addText(EmpField.EMP_CODE, emp.getEmpCode());

		document.addDate(EmpField.BIRTHDAY, emp.getBirthday());

		document.addText(EmpField.GENDER, emp.getGender());

		document.addText(EmpField.ETHNIC, emp.getEthnic());

		document.addText(EmpField.NATIONALITY, emp.getNationality());

		document.addText(EmpField.RELIGION, emp.getReligion());

		document.addDate(EmpField.JOINED_DATE, emp.getJoinedDate());

		document.addText(EmpField.TITLES,
				titles != null ? EmployeeUtils.removeDashChar(titles.getName())
						: StringUtils.EMPTY);

		document.addText(
				EmpField.UNIT_GROUP,
				unitGroup != null ? EmployeeUtils.removeDashChar(unitGroup
						.getName()) : StringUtils.EMPTY);

		document.addText(EmpField.UNIT,
				unit != null ? EmployeeUtils.removeDashChar(unit.getName())
						: StringUtils.EMPTY);

		document.addText(
				EmpField.DEPARTMENT,
				department != null ? EmployeeUtils.removeDashChar(department
						.getName()) : StringUtils.EMPTY);

		document.addText(
				EmpField.DEVISION,
				devision != null ? EmployeeUtils.removeDashChar(devision
						.getName()) : StringUtils.EMPTY);

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
		document.addText(EmpField.GENDER, emp.getGender());
		document.addText(EmpField.PLACE_OF_BIRTH, emp.getPlaceOfBirth());
		document.addText(EmpField.EDUCATION, emp.getEducation());
		document.addText(EmpField.EDUCATION_SPECIALIZE,
				emp.getEducationSpecialize());
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
		document.addText(EmpField.ADDRESS, "address");
		document.addText(EmpField.EMAIL,
				UserLocalServiceUtil.getUser(emp.getEmpUserId())
						.getEmailAddress());
		document.addText(EmpField.COMPANY_EMAIL_ADDRESS,
				emp.getCompanyEmailAddress());
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

		document.addText(EmpField.STATUS, emp.getStatus());

		document.addText(EmpField.IS_DELETED, emp.isDeleted() ? "true"
				: "false");

		document.addNumber(EmpField.DEVISION_ID,
				devision != null ? devision.getDevisionId() : 0L);

		document.addNumber(EmpField.TITLES_ID,
				titles != null ? titles.getTitlesId() : 0L);

		document.addNumber(EmpField.LEVEL_ID, emp.getLevelId());

		document.addNumber(EmpField.UNIVERSITY_ID, emp.getUniversityId());

		document.addKeyword(Field.GROUP_ID, getSiteGroupId(emp.getGroupId()));
		document.addKeyword(Field.SCOPE_GROUP_ID, emp.getGroupId());
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale,
			String snippet, PortletURL portletURL) throws Exception {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(2000);
		return summary;
	}

	@Override
	protected void doReindex(Object obj) throws Exception {
		Emp emp = (Emp) obj;
		Document document = getDocument(emp);

		SearchEngineUtil.updateDocument(getSearchEngineId(),
				emp.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Emp emp = EmpLocalServiceUtil.fetchEmp(classPK);
		doReindex(emp);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		for (String id : ids) {
			Emp emp = EmpLocalServiceUtil.fetchEmp(Long.valueOf(id));
			doReindex(emp);
		}
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return EMInfo.PORTLET_ID;
	}

}
