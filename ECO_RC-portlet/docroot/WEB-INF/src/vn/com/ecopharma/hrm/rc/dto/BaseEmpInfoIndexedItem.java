package vn.com.ecopharma.hrm.rc.dto;

import vn.com.ecopharma.hrm.rc.constant.EmpField;

import com.liferay.portal.kernel.search.Document;

public abstract class BaseEmpInfoIndexedItem extends AbstractIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BaseEmpInfoIndexedItem(Document document) {
		super(document);
	}

	public long getEmpId() {
		return checkNullFieldAndReturnLongValue(EmpField.EMP_ID);
	}

	public String getEmployeeCode() {
		return checkNullFieldAndReturnEmptyString(EmpField.EMP_CODE);
	}

	public String getFullName() {
		return checkNullFieldAndReturnEmptyString(EmpField.FULL_NAME);
	}

	public String getFullNameVi() {
		return checkNullFieldAndReturnEmptyString(EmpField.VN_FULL_NAME);
	}

	public String getEmail() {
		return checkNullFieldAndReturnEmptyString(EmpField.EMAIL);
	}

	public long getDevisionId() {
		return checkNullFieldAndReturnLongValue(EmpField.DEVISION_ID);
	}

	public long getTitlesId() {
		return checkNullFieldAndReturnLongValue(EmpField.TITLES_ID);
	}

	public long getUnitGroupId() {
		return checkNullFieldAndReturnLongValue(EmpField.UNITGROUP_ID);
	}

	public long getUnitId() {
		return checkNullFieldAndReturnLongValue(EmpField.UNIT_ID);
	}

	public long getDepartmentId() {
		return checkNullFieldAndReturnLongValue(EmpField.DEPARTMENT_ID);
	}

	public long getLevelId() {
		return checkNullFieldAndReturnLongValue(EmpField.LEVEL_ID);
	}

	public String getUnit() {
		return checkNullFieldAndReturnEmptyString(EmpField.UNIT);
	}

	public String getDepartment() {
		return checkNullFieldAndReturnEmptyString(EmpField.DEPARTMENT);
	}

	public String getDevision() {
		return checkNullFieldAndReturnEmptyString(EmpField.DEVISION);
	}

	public String getUnitGroup() {
		return checkNullFieldAndReturnEmptyString(EmpField.UNIT_GROUP);
	}

	public String getTitles() {
		return checkNullFieldAndReturnEmptyString(EmpField.TITLES);
	}

	public String getLevel() {
		return checkNullFieldAndReturnEmptyString(EmpField.LEVEL);
	}

}
