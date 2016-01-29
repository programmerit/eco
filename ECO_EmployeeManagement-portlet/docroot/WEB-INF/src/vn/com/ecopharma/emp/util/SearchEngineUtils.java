package vn.com.ecopharma.emp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.constant.EmpField;
import vn.com.ecopharma.emp.dto.EmpIndexedItem;
import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Emp;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.service.UserLocalServiceUtil;

public class SearchEngineUtils {

	public static void indexOrganizationFields(Document document, Emp emp)
			throws SystemException, PortalException {
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

		document.addNumber(EmpField.DEVISION_ID,
				devision != null ? devision.getDevisionId() : 0L);

		document.addNumber(EmpField.DEVISION_ID,
				EmployeeUtils.getBaseModelPrimaryKey(devision));

		document.addNumber(EmpField.DEPARTMENT_ID,
				EmployeeUtils.getBaseModelPrimaryKey(department));

		document.addNumber(EmpField.UNIT_ID,
				EmployeeUtils.getBaseModelPrimaryKey(unit));

		document.addNumber(EmpField.UNITGROUP_ID,
				EmployeeUtils.getBaseModelPrimaryKey(unitGroup));

		document.addNumber(EmpField.TITLES_ID,
				EmployeeUtils.getBaseModelPrimaryKey(titles));

	}

	public static void indexEmpInfo(Document document, Emp emp)
			throws PortalException, SystemException {
		document.addNumber(EmpField.EMP_ID, emp.getEmpId());
		document.addNumber(EmpField.EMPLOYEE_USER_ID, emp.getEmpUserId());
		document.addText(EmpField.FULL_NAME,
				UserLocalServiceUtil.getUser(emp.getEmpUserId()).getFullName());
		document.addText(EmpField.VN_FULL_NAME, EmployeeUtils
				.getViFullnameFromUser(UserLocalServiceUtil.getUser(emp
						.getEmpUserId())));

		document.addText(EmpField.EMP_CODE, emp.getEmpCode());
	}

	public static List<Long> getIdsFromEmpIndexedItems(
			List<EmpIndexedItem> items) {
		final List<Long> result = new ArrayList<>();
		for (EmpIndexedItem item : items)
			result.add(item.getId());
		return result;
	}
}
