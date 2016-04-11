package vn.com.ecopharma.rc.client.dto;

import vn.com.ecopharma.hrm.rc.service.VacancyLocalServiceUtil;
import vn.com.ecopharma.rc.client.constant.VacancyField;
import vn.com.ecopharma.rc.client.util.RCClientUtils;

import com.liferay.portal.kernel.search.Document;

public class VacancyIndexItem extends AbstractIndexedItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VacancyIndexItem(Document document) {
		super(document);
	}

	public VacancyIndexItem(long vacancyId) {
		super(VacancyLocalServiceUtil.getIndexVacancyDocument(vacancyId,
				RCClientUtils.getCurrentSearchContext()));
	}

	public VacancyIndexItem(String vacancyId) {
		this(Long.valueOf(vacancyId));
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
		return checkNullFieldAndReturnEmptyString(VacancyField.DESCRIPTION);
	}

	public String getRequirements() {
		return checkNullFieldAndReturnEmptyString(VacancyField.GENERAL_REQUIREMENTS);
	}

	public String getWorkingPlace() {
		return checkNullFieldAndReturnEmptyString(VacancyField.WORKING_PLACE);
	}

	public String getStatus() {
		String status = checkNullFieldAndReturnEmptyString(VacancyField.STATUS);
		return status.replaceAll(" ", "_");
	}

	@Override
	protected String getIdFieldName() {
		return VacancyField.VACANCY_ID;
	}

}
