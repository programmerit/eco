package vn.com.ecopharma.hrm.rc.dto;

import java.io.Serializable;

import vn.com.ecopharma.hrm.rc.constant.VacancyField;

import com.liferay.portal.kernel.search.Document;

public class VacancyIndexItem extends AbstractIndexEntityItem implements
		Serializable {

	private static final long serialVersionUID = 1L;

	public VacancyIndexItem(Document document) {
		super(document);
	}

	public String getName() {
		return getDocument().getField(VacancyField.NAME).getValue();
	}

	public int getNumberOfPosition() {
		return Integer.valueOf(getDocument().getField(
				VacancyField.NUMBER_OF_POSITION).getValue());
	}

	public String getTitles() {
		return getDocument().getField(VacancyField.TITLES).getValue();
	}

	public String getDescription() {
		return getDocument().getField(VacancyField.DESCRIPTION).getValue();
	}

	public long getTitlesId() {
		return Long.valueOf(getDocument().getField(VacancyField.TITLES_ID)
				.getValue());
	}

	public String getStatus() {
		return getDocument().getField(VacancyField.STATUS).getValue();
	}

	@Override
	protected String idFieldName() {
		return VacancyField.VACANCY_ID;
	}

}
