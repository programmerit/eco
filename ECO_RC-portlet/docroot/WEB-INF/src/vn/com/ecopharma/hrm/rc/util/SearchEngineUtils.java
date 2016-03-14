package vn.com.ecopharma.hrm.rc.util;

import org.apache.commons.lang.StringUtils;

import vn.com.ecopharma.emp.model.Department;
import vn.com.ecopharma.emp.model.Devision;
import vn.com.ecopharma.emp.model.Titles;
import vn.com.ecopharma.emp.model.Unit;
import vn.com.ecopharma.emp.model.UnitGroup;
import vn.com.ecopharma.emp.service.DepartmentLocalServiceUtil;
import vn.com.ecopharma.emp.service.DevisionLocalServiceUtil;
import vn.com.ecopharma.emp.service.EmpLocalServiceUtil;
import vn.com.ecopharma.emp.service.TitlesLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitGroupLocalServiceUtil;
import vn.com.ecopharma.emp.service.UnitLocalServiceUtil;
import vn.com.ecopharma.hrm.rc.constant.EmpField;
import vn.com.ecopharma.hrm.rc.model.Vacancy;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;

/**
 * @author TaoTran
 * @version 1.0
 */
public class SearchEngineUtils {

	public static void indexOrganizationFields(Document document,
			Vacancy vacancy) throws SystemException, PortalException {
		final Titles titles = vacancy.getTitlesId() != 0 ? TitlesLocalServiceUtil
				.getTitles(vacancy.getTitlesId()) : null;

		final Unit unit = vacancy.getUnitId() != 0 ? UnitLocalServiceUtil
				.fetchUnit(vacancy.getUnitId()) : null;

		final UnitGroup unitGroup = vacancy.getUnitGroupId() != 0 ? UnitGroupLocalServiceUtil
				.fetchUnitGroup(vacancy.getUnitGroupId()) : null;

		final Department department = vacancy.getDepartmentId() != 0 ? DepartmentLocalServiceUtil
				.fetchDepartment(vacancy.getDepartmentId()) : null;

		final Devision devision = department != null ? DevisionLocalServiceUtil
				.getDevision(department.getDevisionId()) : null;

		document.addText(
				EmpField.TITLES,
				titles != null ? EmpLocalServiceUtil.removeDashChar(titles
						.getName()) : StringUtils.EMPTY);

		document.addText(
				EmpField.UNIT_GROUP,
				unitGroup != null ? EmpLocalServiceUtil
						.removeDashChar(unitGroup.getName())
						: StringUtils.EMPTY);

		document.addText(
				EmpField.UNIT,
				unit != null ? EmpLocalServiceUtil.removeDashChar(unit
						.getName()) : StringUtils.EMPTY);

		document.addText(
				EmpField.DEPARTMENT,
				department != null ? EmpLocalServiceUtil
						.removeDashChar(department.getName())
						: StringUtils.EMPTY);

		document.addText(
				EmpField.DEVISION,
				devision != null ? EmpLocalServiceUtil.removeDashChar(devision
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

}
