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

	public int getNumberOfPosition() {
		return checkNullFieldAndReturnIntegerValue(VacancyField.NUMBER_OF_POSITION);
	}

	public String getTitles() {
		return checkNullFieldAndReturnEmptyString(VacancyField.TITLES);
	}

	public String getDescription() {
		return getDocument().getField(VacancyField.DESCRIPTION).getValue();
	}

	public long getTitlesId() {
		return checkNullFieldAndReturnLongValue(VacancyField.TITLES_ID);
	}

	public String getStatus() {
		return checkNullFieldAndReturnEmptyString(VacancyField.STATUS);
	}

	@Override
	protected String getIdFieldName() {
		return VacancyField.VACANCY_ID;
	}

}
