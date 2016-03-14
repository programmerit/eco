package vn.com.ecopharma.hrm.rc.dto;

import vn.com.ecopharma.hrm.rc.constant.VacancyField;

import com.liferay.portal.kernel.search.Document;

public class VacancyIndexItem extends AbstractIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VacancyIndexItem(Document document) {
		super(document);
	}

	public long getTitlesId() {
		return checkNullFieldAndReturnLongValue(VacancyField.TITLES_ID);
	}

	public long getUnitGroupId() {
		return checkNullFieldAndReturnLongValue(VacancyField.UNITGROUP_ID);
	}

	public long getUnitId() {
		return checkNullFieldAndReturnLongValue(VacancyField.UNIT_ID);
	}

	public long getDepartmentId() {
		return checkNullFieldAndReturnLongValue(VacancyField.DEPARTMENT_ID);
	}

	public String getUnit() {
		return checkNullFieldAndReturnEmptyString(VacancyField.UNIT);
	}

	public String getDepartment() {
		return checkNullFieldAndReturnEmptyString(VacancyField.DEPARTMENT);
	}

	public String getUnitGroup() {
		return checkNullFieldAndReturnEmptyString(VacancyField.UNIT_GROUP);
	}

	public String getTitles() {
		return checkNullFieldAndReturnEmptyString(VacancyField.TITLES);
	}

	public int getNumberOfPosition() {
		return checkNullFieldAndReturnIntegerValue(VacancyField.NUMBER_OF_POSITION);
	}

	public String getDescription() {
		return getDocument().getField(VacancyField.DESCRIPTION).getValue();
	}

	public String getStatus() {
		return checkNullFieldAndReturnEmptyString(VacancyField.STATUS);
	}

	@Override
	protected String getIdFieldName() {
		return VacancyField.VACANCY_ID;
	}

}
